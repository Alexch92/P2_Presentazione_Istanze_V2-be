package it.sincon.sanita.servlet;

import com.liferay.portal.kernel.dao.orm.ORMException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import it.sincon.sanita.services.model.CategoriaStruttura;
import it.sincon.sanita.services.model.News;
import it.sincon.sanita.services.model.RispostaPaginata;
import it.sincon.sanita.services.model.StrutturaSanitaria;
import it.sincon.sanita.services.model.StrutturaSanitariaFiglia;
import it.sincon.sanita.services.model.impl.RispostaPaginataImpl;
import it.sincon.sanita.services.service.SanitaRESTfullService;
import it.sincon.sanita.services.service.impl.SanitaRESTfullServiceImpl;
import it.sincon.sanita.utils.CommonUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class SanitaRESTFullController {

	private static Logger log = LoggerFactory.getLogger( SanitaRESTFullController.class );
	private final ResourceBundle resourceBundle = ResourceBundle.getBundle("portlet");

	protected SanitaRESTfullService sanitaRESTfullService;

	/**
	 * Restituisce la lista di tutte le tipologie di Strutture sanitarie (DDMStructure) ricercabili
	 * dall'app.
	 * Es.:
	 * http://138.66.174.183:8080/pugliasalute-restful/services/strutture/categorie?language=it_IT
	 * http://www.sanita.puglia.it/pugliasalute-restful/services/strutture/categorie?language=it_IT
	 * @param language
	 * @param idStruttura
	 * @return
	 * @throws SystemException
	 */
	@RequestMapping(value = "/strutture/categorie", method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody RispostaPaginata<CategoriaStruttura> listaCategorie(
			@RequestParam("language") String language,
			@RequestParam(required=false,value="idStruttura") Integer idStruttura
			) throws SystemException {

		log.debug(String.format("invocato service listaCategorie()... "
				+ "language=(%s) - idStruttura=(%s)...", 
				language, idStruttura));
		
		// Controllo sulla lingua aggiunto per gestire le varie tipologie...
		language = verificaLocale(language);

		try {

			List<CategoriaStruttura> listaCategorie = getSanitaRESTfullService().getCategorieAbilitate(new Locale(language));
			RispostaPaginata<CategoriaStruttura> response = new RispostaPaginataImpl<CategoriaStruttura>(
					0,
					listaCategorie.size(),
					listaCategorie,
					true);

			return response;
		} catch (SystemException e) {
			throw e;
			
		}
	}

	/**
	 * Esegue la ricerca sulle Strutture Sanitarie, filtrandole sulla base delle categorie passate in input.
	 * Se si passa categorie a null non verrà fatto filtraggio sulle categorie.
	 * Se si valorizza il parametro fullText verranno restituiti solo le strutture  contenenti  la  parola  
	 * ${fullText}  all'interno dei campi configurati nell'array fullTextSearchItems[], del serviceImpl. 
	 * Se si valorizzano i campi gps_lat e gps_lng verrà  calcolata  la  distanza  di ciascuna struttura dal 
	 * dispositivo mobile che ha eseguito la richiesta e la lista verrà ordinata in ordine crescente.
	 * Es.:
	 * http://138.66.174.183:8080/pugliasalute-restful/services/strutture?language=it_IT&start=0&numRes=10&lat=40.4646&long=17.2704&categorie=["Ospedale"]&idStrutture=["59517","1109701","89312","54359","00000"]
	 * http://www.sanita.puglia.it/pugliasalute-restful/services/strutture?language=it_IT&start=0&numRes=10&lat=40.4646&long=17.2704&categorie=["Ospedale"]&idStrutture=["870985","847011","759307","756641","00000"]
	 * @param language
	 * @param start
	 * @param numRes
	 * @param fulltext
	 * @param jsonCategorie
	 * @param mobile_gps_lat
	 * @param mobile_gps_lng
	 * @return
	 * @throws SystemException
	 */
	@RequestMapping(value = "/strutture", method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody RispostaPaginata<StrutturaSanitaria> ricercaStrutture(
			@RequestParam("language") String language,
			@RequestParam("start") int start,
			@RequestParam("numRes") int numRes,
			@RequestParam(required=false, value="fulltext") String fulltext,
			@RequestParam(required=false, value="categorie") String jsonCategorie,
			@RequestParam(required=false, value="lat") Double mobile_gps_lat,
			@RequestParam(required=false, value="long") Double mobile_gps_lng,
			@RequestParam(required=false, value="idStrutture") String jsonIdStrutture
			) throws SystemException {

		log.info(String.format("invocato service ricercaStrutture()... "
				+ "language=(%s) - "
				+ "start=(%s) - "
				+ "numRes=(%s) - "
				+ "fulltext=(%s) - "
				+ "categorie=(%s) - "
				+ "mobile gps lat=(%s) - "
				+ "mobile gps=(%s) - "
				+ "idStrutture=(%s)...",
				language, start, numRes, fulltext, jsonCategorie, mobile_gps_lat, mobile_gps_lng, jsonIdStrutture));
		
		// Controllo sulla lingua aggiunto per gestire le varie tipologie...
		language = verificaLocale(language);

		try {
			List<StrutturaSanitaria> listaStrutture = new ArrayList<StrutturaSanitaria>();
			RispostaPaginata<StrutturaSanitaria> response = null;
			long numTot = 0;
			
			numTot = getSanitaRESTfullService().ricercaStruttureSanitarie(
					listaStrutture,
					new Locale(language), 
					start, numRes, 
					jsonCategorie,
					jsonIdStrutture,
					fulltext, 
					mobile_gps_lat, mobile_gps_lng);

			response = new RispostaPaginataImpl<StrutturaSanitaria>(
					start, 
					(int)numTot, 
					listaStrutture,
					false);
			
			return response;
		} catch (SystemException e) {
			throw e;
		}
	}

	/**
	 * Restituisce la lista di tutte le categorie cui appartengono le Strutture sanitarie (DDMStructure) 
	 * figlie di una data Struttura padre.
	 * Es.:
	 * http://138.66.174.183:8080/pugliasalute-restful/services/strutture/categorieFigli?language=it_IT&idStruttura=1162275
	 * http://www.sanita.puglia.it/pugliasalute-restful/services/strutture/categorieFigli?language=it_IT&idStruttura=870419
	 * @param language
	 * @param idStruttura
	 * @return
	 * @throws SystemException
	 */
	@RequestMapping(value = "/strutture/categorieFigli", method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody RispostaPaginata<CategoriaStruttura> listaCategorieStruttureFiglie(
			@RequestParam("language") String language,
			@RequestParam("idStruttura") long idStrutturaPadre
			) throws SystemException {

		log.info(String.format("invocato service listaCategorieStruttureFiglie()... "
				+ "language=(%s) - "
				+ "idStruttura=(%s)...", 
				language, idStrutturaPadre));
		
		// Controllo sulla lingua aggiunto per gestire le varie tipologie...
		language = verificaLocale(language);

		try {
			
			List<CategoriaStruttura> listaCategorie = getSanitaRESTfullService().findCategorieFigliByStrutturaPadre(
					new Locale(language), 
					Long.valueOf(idStrutturaPadre));
			RispostaPaginata<CategoriaStruttura> response = new RispostaPaginataImpl<CategoriaStruttura>(
					0, 10, listaCategorie, true);

			return response;
		} catch (SystemException e) {
			throw e;
		}
	}

	/**
	 * Restituisce la lista di tutte le Strutture sanitarie (DDMStructure) figlie di una data Struttura padre
	 * e di categoria pari alla categoria identificata da idCategoria 
	 * Es.:
	 * http://138.66.174.183:8080/pugliasalute-restful/services/strutture/findByPadreAndCategoria?language=it_IT&start=0&numRes=10&idStruttura=1162275&idTipoStruttura=relazioneAmbulatorio
	 * http://www.sanita.puglia.it/pugliasalute-restful/services/strutture/findByPadreAndCategoria?language=it_IT&start=0&numRes=10&idStruttura=871015&idTipoStruttura=childrenEdottoUnitaOperativa
	 * 
	 * @param language
	 * @param start
	 * @param numRes
	 * @param idStrutturaPadre
	 * @param idTipoStruttura
	 * @return
	 * @throws SystemException
	 */
	@RequestMapping(value = "/strutture/findByPadreAndCategoria", method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody RispostaPaginata<StrutturaSanitariaFiglia> findStruttureByPadreAndCategoria(
			@RequestParam("language") String language,
			@RequestParam("start") int start,
			@RequestParam("numRes") int numRes,
			@RequestParam("idStruttura") long idStrutturaPadre,
			@RequestParam("idTipoStruttura") String idTipoStruttura
			) throws SystemException {

		log.info(String.format("invocato service findStruttureByPadreAndCategoria()... "
				+ "language=(%s) - "
				+ "start=(%s) - "
				+ "numRes=(%s) - "
				+ "idStruttura=(%s) - "
				+ "idTipoStruttura=(%s)...", 
				language, start, numRes, idStrutturaPadre, idTipoStruttura));
		
		// Controllo sulla lingua aggiunto per gestire le varie tipologie...
		language = verificaLocale(language);

		try {

			LinkedList<StrutturaSanitariaFiglia> listaStrutture = new LinkedList<StrutturaSanitariaFiglia>();
			int numFound = getSanitaRESTfullService().ricercaStruttureSanitarieFiglie(
					listaStrutture,
					new Locale(language), 
					start, numRes, 
					idTipoStruttura,
					Long.valueOf(idStrutturaPadre));

			RispostaPaginata<StrutturaSanitariaFiglia> response = new RispostaPaginataImpl<StrutturaSanitariaFiglia>(
					start,
					numFound, 
					listaStrutture,
					false);

			return response;
		} catch (SystemException e) {
			throw e;
		}
	}
	
	/**
	 * Servizio identico alla ricercaStrutture ma configurato per restituire solo
	 * le strutture sanitarie di categoria configurata nel file di properties 
	 * alla voce PrimoSoccorso.jsonCategorie ovvero Punti di Primo Soccorso
	 * Es.:
	 * http://138.66.174.183:8080/pugliasalute-restful/services/strutture/primoSoccorso?language=it_IT&start=0&numRes=10&lat=40.4646&long=17.2704
	 * http://www.sanita.puglia.it/pugliasalute-restful/services/strutture/primoSoccorso?language=it_IT&start=0&numRes=10&lat=40.4646&long=17.2704
	 *  
	 * @param language
	 * @param start
	 * @param numRes
	 * @param fulltext
	 * @param mobile_gps_lat
	 * @param mobile_gps_lng
	 * @param jsonIdStrutture
	 * @return
	 * @throws SystemException
	 */
	@RequestMapping(value = "/strutture/primoSoccorso", method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody RispostaPaginata<StrutturaSanitaria> ricercaStrutturePrimoSoccorso(
			@RequestParam("language") String language,
			@RequestParam("start") int start,
			@RequestParam("numRes") int numRes,
			@RequestParam(required=false, value="fulltext") String fulltext,
			@RequestParam(required=false, value="lat") Double mobile_gps_lat,
			@RequestParam(required=false, value="long") Double mobile_gps_lng,
			@RequestParam(required=false, value="idStrutture") String jsonIdStrutture
			) throws SystemException {

		log.info(String.format("invocato service ricercaStrutturePrimoSoccorso()... "
				+ "language=(%s) - "
				+ "start=(%s) - "
				+ "numRes=(%s) - "
				+ "fulltext=(%s) - "
				+ "mobile gps lat=(%s) - "
				+ "mobile gps=(%s) - "
				+ "idStrutture=(%s)...",
				language, start, numRes, fulltext, mobile_gps_lat, mobile_gps_lng, jsonIdStrutture));
		
		// Controllo sulla lingua aggiunto per gestire le varie tipologie...
		language = verificaLocale(language);
		
		// Recupero la lista di categorie da mostrare per questo servizio...
		String jsonCategorie = resourceBundle.getString("PrimoSoccorso.jsonCategorie");
		
		return ricercaStrutture(
				language, 
				start, 
				numRes, 
				fulltext, 
				jsonCategorie,
				mobile_gps_lat, 
				mobile_gps_lng, 
				jsonIdStrutture);
			
	}
	
	/**
	 * Servizio identico alla ricercaStrutture ma configurato per restituire solo
	 * le strutture sanitarie di categoria configurata nel file di properties 
	 * alla voce ContinuitaAssistenziale.jsonCategorie ovvero Continuita Assistenziale
	 * Es.:
	 * http://138.66.174.183:8080/pugliasalute-restful/services/strutture/contAss?language=it_IT&start=0&numRes=10&lat=40.4646&long=17.2704
	 * http://www.sanita.puglia.it/pugliasalute-restful/services/strutture/contAss?language=it_IT&start=0&numRes=10&lat=40.4646&long=17.2704
	 *  
	 * @param language
	 * @param start
	 * @param numRes
	 * @param fulltext
	 * @param mobile_gps_lat
	 * @param mobile_gps_lng
	 * @param jsonIdStrutture
	 * @return
	 * @throws SystemException
	 */
	@RequestMapping(value = "/strutture/contAss", method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody RispostaPaginata<StrutturaSanitaria> ricercaStruttureCA(
			@RequestParam("language") String language,
			@RequestParam("start") int start,
			@RequestParam("numRes") int numRes,
			@RequestParam(required=false, value="fulltext") String fulltext,
			@RequestParam(required=false, value="lat") Double mobile_gps_lat,
			@RequestParam(required=false, value="long") Double mobile_gps_lng,
			@RequestParam(required=false, value="idStrutture") String jsonIdStrutture
			) throws SystemException {

		log.info(String.format("invocato service ricercaStruttureCA()... "
				+ "language=(%s) - "
				+ "start=(%s) - "
				+ "numRes=(%s) - "
				+ "fulltext=(%s) - "
				+ "mobile gps lat=(%s) - "
				+ "mobile gps=(%s) - "
				+ "idStrutture=(%s)...",
				language, start, numRes, fulltext, mobile_gps_lat, mobile_gps_lng, jsonIdStrutture));
		
		// Controllo sulla lingua aggiunto per gestire le varie tipologie...
		language = verificaLocale(language);
		
		// Recupero la lista di categorie da mostrare per questo servizio...
		String jsonCategorie = resourceBundle.getString("ContinuitaAssistenziale.jsonCategorie");
		
		return ricercaStrutture(
				language, 
				start, 
				numRes, 
				fulltext, 
				jsonCategorie,
				mobile_gps_lat, 
				mobile_gps_lng, 
				jsonIdStrutture);
		
	}
	
	/**
	 * Restituisce la lista di tutte le tipologie di Strutture sanitarie (DDMStructure) ricercabili
	 * dall'app.
	 * Es.:
	 * http://138.66.174.183:8080/pugliasalute-restful/services/news/categorie?language=it_IT
	 * http://www.sanita.puglia.it/pugliasalute-restful/services/news/categorie?language=it_IT
	 * @param language
	 * @param idStruttura
	 * @return
	 * @throws SystemException
	 */
	@RequestMapping(value = "/news/categorie", method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody RispostaPaginata<CategoriaStruttura> listaCategorieNews(
			@RequestParam("language") String language) throws SystemException {

		log.info(String.format("invocato service listaCategorieNews()... language=(%s)...", language));
		
		// Controllo sulla lingua aggiunto per gestire le varie tipologie...
		language = verificaLocale(language);

		try {

			List<CategoriaStruttura> listaCategorie = getSanitaRESTfullService().getCategorieNewsAbilitate(new Locale(language));
			RispostaPaginata<CategoriaStruttura> response = new RispostaPaginataImpl<CategoriaStruttura>(
					0,
					listaCategorie.size(),
					listaCategorie,
					true);

			return response;
		} catch (SystemException e) {
			throw e;
		}
	}

	/**
	 * Restituisce la lista delle ultime numRes News (valore configurabile) pubblicate sull’HomePage del Portale PugliaSalute
	 * * Es.:
	 * http://138.66.174.183:8080/pugliasalute-restful/services/news/lista?language=it_IT&numRes=10&categorie=["20182"]
	 * http://www.sanita.puglia.it/pugliasalute-restful/services/news/lista?language=it_IT&numRes=5&categorie=["36031"]
	 * 
	 * @param language
	 * @param numRes
	 * @return
	 */
	@RequestMapping(value = "/news/lista", method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody RispostaPaginata<News> listaNews(
			@RequestParam("language") String language,
			@RequestParam("numRes") int numRes,
			@RequestParam(required=false, value="start") Integer start,
			@RequestParam(required=false, value="categorie") String jsonCategorie,
			@RequestParam(required=false, value="fulltext") String fulltext
			) throws SystemException, PortalException {

		log.info(String.format("invocato service listaNews()... "
				+ "language=(%s) - "
				+ "numRes=(%s) - "
				+ "start=(%s) - "
				+ "categorie=(%s) - "
				+ "fulltext=(%s)...", 
				language, numRes, start, jsonCategorie, fulltext));
		
		// Controllo sulla lingua aggiunto per gestire le varie tipologie...
		language = verificaLocale(language);

// Implementazione da utilizzare se si abiliota il task di update delle News...
//		try {
//			if (start == null)
//				start = new Integer(0);
//
//			List<News> listaNews = new ArrayList<News>();
//			long numFound = getSanitaRESTfullService().ricercaNews(
//					listaNews, new Locale(language), 
//					start, numRes, jsonCategorie, fulltext);
//			
//			RispostaPaginata<News> response = new RispostaPaginataImpl<News>(
//					start,	
//					(int)numFound,	
//					listaNews, 
//					false);
//
//			return response;
//		} catch (SystemException e) {
//			throw e;
//		}
		try {
			if (start == null)
				start = new Integer(0);

			List<News> listaNews = new ArrayList<News>();
			getSanitaRESTfullService().ricercaNewsLiferay(
					listaNews, new Locale(language), 
					start, numRes, jsonCategorie, fulltext);
			
			RispostaPaginata<News> response = new RispostaPaginataImpl<News>(
					start,	
					numRes,	
					listaNews, 
					true);

			return response;
		} catch (SystemException se) {
			throw se;
		} catch (PortalException e) {
			throw e;
		}
	}
	
	// Se il locale passato in input inizia con "it", restituisce il locale it_IT, 
	// altrimenti restituisce il locale en_EN
	private String verificaLocale(String inputLocale){
		String outputLocale = "it_IT";
		
		if (!inputLocale.startsWith("it"))
			outputLocale = "en_EN";
		
		return outputLocale;
	}

	//exception handling

	@ResponseStatus(HttpStatus.CONFLICT)  
	@ExceptionHandler(SystemException.class)
	public void handleConflict(SystemException se) {
		if(se.getCause() instanceof ORMException){
			throw (ORMException) se.getCause();
		}
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST) 
	@ExceptionHandler(ORMException.class)
	public void handleBadRequest(SystemException se) {

	}

	private SanitaRESTfullService getSanitaRESTfullService(){
		if (sanitaRESTfullService==null){
			sanitaRESTfullService = new SanitaRESTfullServiceImpl();
		}

		return sanitaRESTfullService;
	}

}
