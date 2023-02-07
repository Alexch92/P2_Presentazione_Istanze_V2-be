package it.sincon.sanita.services.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.ResourceBundle;

import org.jsoup.Jsoup;
import org.jsoup.examples.HtmlToPlainText;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import flexjson.JSONDeserializer;

import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.Group;
import com.liferay.portal.service.ClassNameLocalServiceUtil;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.liferay.portlet.dynamicdatamapping.model.DDMStructure;
import com.liferay.portlet.dynamicdatamapping.service.DDMStructureLocalServiceUtil;
import com.liferay.portlet.dynamicdatamapping.storage.Field;
import com.liferay.portlet.dynamicdatamapping.storage.Fields;
import com.liferay.portlet.journal.NoSuchArticleException;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.portlet.journal.util.JournalConverterUtil;

import it.sincon.sanita.services.beans.ENG_Geo;
import it.sincon.sanita.services.beans.ENG_Image;
import it.sincon.sanita.services.model.CFG_CategorieAbilitate;
import it.sincon.sanita.services.model.CategoriaStruttura;
import it.sincon.sanita.services.model.News;
import it.sincon.sanita.services.model.StrutturaSanitaria;
import it.sincon.sanita.services.model.StrutturaSanitariaFiglia;
import it.sincon.sanita.services.model.impl.CategoriaStrutturaImpl;
import it.sincon.sanita.services.model.impl.NewsImpl;
import it.sincon.sanita.services.model.impl.StrutturaSanitariaFigliaImpl;
import it.sincon.sanita.services.model.impl.StrutturaSanitariaImpl;
import it.sincon.sanita.services.service.CFG_CategorieAbilitateLocalServiceUtil;
import it.sincon.sanita.services.service.NewsLocalServiceUtil;
import it.sincon.sanita.services.service.SanitaRESTfullService;
import it.sincon.sanita.services.service.StrutturaSanitariaLocalServiceUtil;
import it.sincon.sanita.utils.CommonUtils;

public class SanitaRESTfullServiceImpl implements SanitaRESTfullService {

	private static Logger log = LoggerFactory.getLogger( SanitaRESTfullServiceImpl.class );
	private final ResourceBundle resourceBundle = ResourceBundle.getBundle("portlet");
	
	private static int JOURNAL_ARTICLE_STATUS_APPROVED = 0;
	private static String LIFERAY_DOWNLOAD_FILE_ACTION = "/c/document_library/get_file";
	
	/**
	 * Array con i nomi dei campi della DDM_Structure in cui eseguire la ricerca.
	 */
	private String portalBaseURL;
	private long groupIdRegionalePubblico;
	private long groupIdRegionalePrivato;
	private long companyId;
	
	private int nrNewsToBeRetrieved;
	
	// Configurazioni per il mapping dei web contents con la StrutturaSanitaria
	private String s_sanitaria_denominazione; 	
	private String s_sanitaria_tipologia;     	
	private String s_sanitaria_descrizione;
	private String s_sanitaria_descrizione_breve;	
	private String s_sanitaria_telefono;		
	private String s_sanitaria_fax;				
	private String s_sanitaria_email;			
	private String s_sanitaria_geo;				
	private String s_sanitaria_immagine;
	private String s_sanitaria_direttore;
	private String s_sanitaria_responsabile;
	private String s_sanitaria_ce_ospedaleCollegato;			
	private String s_sanitaria_ce_ambulatorio;				
	private String s_sanitaria_ce_unitaOperativa;
	private String s_sanitaria_ce_unitaps;
	private String s_sanitaria_re_ambulatorio;
	// Configurazioni per il mapping dei web contents con la News
	private String news_autore;
	
	private String ddm_structure_news_name;
	// Configurazione mappa delle assetcategories per al ricerca delle News. 
	// Per ogni category si riporta il groupId associato. Se groupId=* allora
	// il groupId coincide con quello riportato in db in cfg_CategorieAbilitate
	// associato all'azienda sanitaria di cui si vogliono le News...
	private LinkedHashMap<String, String> mapNewsCategories;
	
	// Configurazione mappa delle assetcategories per al ricerca delle News Regionali. 
	// Per ogni category si riporta il groupId associato. Se groupId=* allora
	// il groupId coincide con quello riportato in db in cfg_CategorieAbilitate
	// associato all'azienda sanitaria di cui si vogliono le News...
	private LinkedHashMap<String, String> mapNewsRegCategories;
	
	// Configurazione mappa di corrispondenze tra i fields childrenEdotto delle 
	// custom DDMStructure di ENG e le CategoriaStruttura...
	Map<String, String> mapDdmEngCategorie;
    
	public SanitaRESTfullServiceImpl(){
		this.mapDdmEngCategorie = new HashMap<String, String>();
		int cfgMapSize = Integer.parseInt(resourceBundle.getString("map_ddm_eng_categorie.count"));
		for (int idx=0; idx < cfgMapSize; idx++){
			this.mapDdmEngCategorie.put(
					resourceBundle.getString(String.format("map_ddm_eng_categorie[%s].key", idx)), 
					resourceBundle.getString(String.format("map_ddm_eng_categorie[%s].value", idx))
					);
		}
		
		this.mapNewsCategories = new LinkedHashMap<String, String>();
		cfgMapSize = Integer.parseInt(resourceBundle.getString("map_news_categorie.count"));
		for (int idx=0; idx < cfgMapSize; idx++){
			this.mapNewsCategories.put(
					resourceBundle.getString(String.format("map_news_categorie[%s].key", idx)), 
					resourceBundle.getString(String.format("map_news_categorie[%s].value", idx))
					);
		}
		
		this.mapNewsRegCategories = new LinkedHashMap<String, String>();
		cfgMapSize = Integer.parseInt(resourceBundle.getString("map_news_reg_categorie.count"));
		for (int idx=0; idx < cfgMapSize; idx++){
			this.mapNewsRegCategories.put(
					resourceBundle.getString(String.format("map_news_reg_categorie[%s].key", idx)), 
					resourceBundle.getString(String.format("map_news_reg_categorie[%s].value", idx))
					);
		}
		
		this.portalBaseURL = resourceBundle.getString("portal.baseURL");
		
		this.companyId = Long.parseLong(resourceBundle.getString("portaleRegionale.companyId"));
		this.groupIdRegionalePrivato = Long.parseLong(resourceBundle.getString("portaleRegionale.groupId.private"));
		this.groupIdRegionalePubblico = Long.parseLong(resourceBundle.getString("portaleRegionale.groupId.public"));
		this.nrNewsToBeRetrieved = Integer.parseInt(resourceBundle.getString("task.updateNews.maxNewsToBeRetrieved"));
		
		this.s_sanitaria_denominazione = resourceBundle.getString("eng.structure.field.denominazione");
		this.s_sanitaria_tipologia = resourceBundle.getString("eng.structure.field.tipologia");
		this.s_sanitaria_descrizione = resourceBundle.getString("eng.structure.field.descrizione");
		this.s_sanitaria_descrizione_breve = resourceBundle.getString("eng.structure.field.descrizioneBreve");
		this.s_sanitaria_telefono = resourceBundle.getString("eng.structure.field.telefono");
		this.s_sanitaria_fax = resourceBundle.getString("eng.structure.field.fax");
		this.s_sanitaria_email = resourceBundle.getString("eng.structure.field.email");
		this.s_sanitaria_geo = resourceBundle.getString("eng.structure.field.geo");
		this.s_sanitaria_immagine = resourceBundle.getString("eng.structure.field.immagine");
		this.s_sanitaria_direttore = resourceBundle.getString("eng.structure.field.direttore");
		this.s_sanitaria_responsabile = resourceBundle.getString("eng.structure.field.responsabileSanitario");
		this.s_sanitaria_ce_ospedaleCollegato = resourceBundle.getString("eng.structure.field.childrenEdottoOspedaleCollegato");
		this.s_sanitaria_ce_ambulatorio = resourceBundle.getString("eng.structure.field.childrenEdottoAmbulatorio");
		this.s_sanitaria_ce_unitaOperativa = resourceBundle.getString("eng.structure.field.childrenEdottoUnitaOperativa");
		this.s_sanitaria_ce_unitaps = resourceBundle.getString("eng.structure.field.childrenEdottoUnitaps");
		this.s_sanitaria_re_ambulatorio = resourceBundle.getString("eng.structure.field.relazioneAmbulatorio");
		
		this.news_autore = resourceBundle.getString("eng.structure.field.autore");
		
		this.ddm_structure_news_name = resourceBundle.getString("ddmStructure.news.name");
	}
	
	@Override
	/**
	 * Restituisce la lista di CategoriaStruttura con le info delle sole categorie abilitate all'app
	 */
	public List<CategoriaStruttura> getCategorieAbilitate(Locale locale) throws SystemException {

		LinkedList<CategoriaStruttura> response = new LinkedList<CategoriaStruttura>();

		List<CFG_CategorieAbilitate> cfg_catAbilitate = 
				CFG_CategorieAbilitateLocalServiceUtil.getCFG_CategorieAbilitateByClassName(
						StrutturaSanitaria.class.getName());
		
		log.debug(String.format("cfg_catAbilitate.size()=(%s)...", cfg_catAbilitate.size()));

		for (CFG_CategorieAbilitate cfg_cat : cfg_catAbilitate){
			CategoriaStruttura cat = new CategoriaStrutturaImpl();
			cat.setIdTipoStruttura(cfg_cat.getTitoloStruttura());
			cat.setDenominazione(cfg_cat.getDenominazione());
			response.addLast(cat);
		}

		return response;
	}
	
	@Override
	/**
	 * Restituisce la lista di CategoriaStruttura con le info delle sole categorie abilitate all'app
	 */
	public List<CategoriaStruttura> getCategorieNewsAbilitate(Locale locale) throws SystemException {

		LinkedList<CategoriaStruttura> response = new LinkedList<CategoriaStruttura>();

		List<CFG_CategorieAbilitate> cfg_catAbilitate = 
				CFG_CategorieAbilitateLocalServiceUtil.getCFG_CategorieAbilitateByClassName(
						News.class.getName());
		
		log.debug(String.format("cfg_catAbilitate.size()=(%s)...", cfg_catAbilitate.size()));

		for (CFG_CategorieAbilitate cfg_cat : cfg_catAbilitate){
			CategoriaStruttura cat = new CategoriaStrutturaImpl();
			cat.setIdTipoStruttura(cfg_cat.getTitoloStruttura());
			cat.setDenominazione(cfg_cat.getDenominazione());
			response.addLast(cat);
		}

		return response;
	}	

	
	private String getChildenEdottoStrValue(String _nomeRelazione, StrutturaSanitaria ss){
		String response = null;
		
		// Recupero i campi childenEdotto per le relazioni....
		if( _nomeRelazione.equalsIgnoreCase(s_sanitaria_ce_ospedaleCollegato) ){
			response = ss.getChildrenEdottoOspedaleCollegato();
		}
		else if( _nomeRelazione.equalsIgnoreCase(s_sanitaria_ce_ambulatorio) ){
			response = ss.getChildrenEdottoAmbulatorio();
		}
		else if( _nomeRelazione.equalsIgnoreCase(s_sanitaria_ce_unitaOperativa) ){
			response = ss.getChildrenEdottoUnitaOperativa();
		}
		else if(_nomeRelazione.equalsIgnoreCase(s_sanitaria_ce_unitaps) ){
			response = ss.getChildrenEdottoUnitaps();
		}
		else if( _nomeRelazione.equalsIgnoreCase(s_sanitaria_re_ambulatorio) ){
			response = ss.getRelazioneAmbulatorio();
		}
		
		return response;
	}
	
	@Override
	public List<CategoriaStruttura> findCategorieFigliByStrutturaPadre(
			Locale locale, long idStruttura) throws SystemException {
		
		LinkedList<CategoriaStruttura> response = new LinkedList<CategoriaStruttura>();
		
		try {
			// Recupero la Struttura Sanitaria...
			StrutturaSanitaria ss = StrutturaSanitariaLocalServiceUtil.findByIdStrutturaAndLocale(idStruttura, locale.toString());
			log.info(String.format("----- StrutturaSanitaria[id=%s] - Trovato!! ----------------------", ss.getIdStruttura()));
			
			String strValue=null;
			for (Entry<String, String> mapEntry : mapDdmEngCategorie.entrySet()){

				strValue = getChildenEdottoStrValue(mapEntry.getKey(), ss);
				
				if (strValue != null && !strValue.isEmpty()){
					CategoriaStruttura cat = new CategoriaStrutturaImpl();
					cat.setIdTipoStruttura(mapEntry.getKey());
					cat.setDenominazione(mapEntry.getValue());
					response.addLast(cat);
				}
			}
					
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		
		return response;
	}
	
	/**
	 * Aggiorna la tabella delle Strutture Sanitarie, recuperando i dati di interesse dalla tabella
	 * dei Journal Articles di Liferay
	 *  
	 * @param locale
	 * @return
	 */
	@Override
	public long aggiornaStruttureSanitarie(List<StrutturaSanitaria> listaStrutture, Locale locale) throws SystemException {
		// Recupero le Categorie per le quali andare a recuperare i web contents...
		List<CFG_CategorieAbilitate> cfg_catAbilitate = 
				CFG_CategorieAbilitateLocalServiceUtil.getCFG_CategorieAbilitateByClassName(
						StrutturaSanitaria.class.getName());
		log.info(String.format("cfg_catAbilitate.size()=(%s)...", cfg_catAbilitate.size())); 
		
		// Recupero le DDMStructure... 
		List<DDMStructure> ddmStructures = DDMStructureLocalServiceUtil.getDDMStructures(-1, -1);
		log.debug(String.format("recuperate %s ddm_structure", ddmStructures.size()));
		DDMStructure ddmStructure = null;

		// Recupero i webContents categoria per categoria....
		for(CFG_CategorieAbilitate cfgCategoria : cfg_catAbilitate) {
			// Recupero la DDMStructure corrispondente alla categoria...
			ddmStructure = findDDMStructureByName(ddmStructures, locale, cfgCategoria.getTitoloStruttura().split("\\.")[0]);

			if (ddmStructure!=null){
				log.info(String.format("---------------- Categoria:(%s) DDMStructure:(%s) - START... ---------------------- ", 
						cfgCategoria.getDenominazione(), ddmStructure.getName(locale)));

				// Recupero l'ultima versione in stato approvato dei webContents di questa categoria,
				// li trasformo in StrutturaSanitaria e li salvo in DB....
				listaStrutture.addAll(findLatestApprovedItemsByDDMStructure(cfgCategoria, ddmStructure, locale));

				log.info(String.format("---------------- Categoria:(%s) DDMStructure:(%s) - E N D... ---------------------- ", 
						cfgCategoria.getDenominazione(), ddmStructure.getName(locale)));
			}
			else
				log.error(String.format("Nessuna DDMStructure trovata in corrispondenza della categoria : %s",cfgCategoria.getTitoloStruttura()));
		}
		
		return listaStrutture.size();
	}
	
	/**
	 * 
	 */
	public long storeStruttureSanitarie(List<StrutturaSanitaria> listaStrutture) throws SystemException{
		// Aggiorno le Strutture sanitarie in DB...
		log.info(String.format("----- UpDate DB : %s StruttureSanitarie estratte da inserire... ---------", listaStrutture.size()));
		long addedItems = StrutturaSanitariaLocalServiceUtil.replaceAll(listaStrutture);
		log.info(String.format("----- UpDate DB : %s StruttureSanitarie salvate in DB... ---------", addedItems));

		return addedItems;
	}
	
	private void printAllGroups(){
		try {
			List<Group> groups = GroupLocalServiceUtil.getGroups(-1, -1);
			log.info("-------------- LISTA Groups Liferay --------------------------------");
			for (Group g : groups){
				log.info(String.format("Group: companyId=%s - groupId=%s - name=%s", 
						g.getCompanyId(), g.getGroupId(), g.getName()));
			}
			log.info("-------------- LISTA Groups Liferay --------------------------------");
		} catch (SystemException e) {
			log.error(e.getMessage(), e);
		}
	}
	
	@Override
	public long aggiornaNews(List<News> listaNews, Locale locale)
			throws SystemException {
		
		// Recupero le Categorie per le quali andare a recuperare i web contents...
		List<CFG_CategorieAbilitate> cfg_catAbilitate = 
				CFG_CategorieAbilitateLocalServiceUtil.getCFG_CategorieAbilitateByClassName(
						News.class.getName());
		log.info(String.format("cfg_catAbilitate.size()=(%s)...", cfg_catAbilitate.size())); 
		
		// Recupero i webContents categoria per categoria....
		for(CFG_CategorieAbilitate cfgCategoria : cfg_catAbilitate) {
			// Recupero il groupId...
			Group group = null;
			
			try {
				group = GroupLocalServiceUtil.getGroup(companyId, cfgCategoria.getTitoloStruttura());
			} catch (PortalException e) {
				log.error(e.getMessage(), e);
				group = null;
			}
			
			if (group!=null){
				listaNews.addAll(getListaNews(cfgCategoria.getTitoloStruttura(), 
											  cfgCategoria.getDenominazione(),
											  locale,
											  ""));
			}
			else
				log.warn(String.format("Group con companyId:%s, name:%s non trovato!!", companyId, cfgCategoria.getTitoloStruttura()));
		}
		
		return listaNews.size();
	}

	@Override
	public long storeNews(List<News> listaNews) throws SystemException {
		// Aggiorno le Strutture sanitarie in DB...
		log.info(String.format("----- UpDate DB : %s News estratte da inserire... ---------", listaNews.size()));
		long addedItems = NewsLocalServiceUtil.replaceAll(listaNews);
		log.info(String.format("----- UpDate DB : %s News salvate in DB... ---------", addedItems));

		return addedItems;
	}
	
	/**
	 * Esegue la ricerca delle News nella tabella SANITAREST_News, filtrandole sulla base delle aziende passate 
	 * in input. Se si passa aziende a null verranno restituite solo le News del Portale regionale.
	 * Se si valorizza il parametro fullText verranno restituiti solo le strutture  contenenti  la  parola  
	 * ${fullText}  all'interno dei campi configurati nell'array fullTextSearchItems[], del serviceImpl. 
	 * 
	 * @param output
	 * @param locale
	 * @param start
	 * @param numRes
	 * @param aziende
	 * @param fullText
	 * @return
	 * @throws SystemException
	 */
	@Override
	public long ricercaNews(
			List<News> output, Locale locale, 
			int start,	int numRes, 
			String jsonAziende, String fullText
			) throws SystemException {
		log.info("------------- Ricerca News  - START... ---------------------- ");
		
		List<String> idAziende = null;
		// Se mi viene valorizzato jsonCategorie estraggo le DDMStructure corrispondenti,
		// altrimenti prelevo quelle da configurazione.
		List<CFG_CategorieAbilitate> cfgCatAbilitate = CFG_CategorieAbilitateLocalServiceUtil.getSelectedByClassName(News.class.getName(), jsonAziende);
		if (cfgCatAbilitate!= null && !cfgCatAbilitate.isEmpty()){
			idAziende = new ArrayList<String>();
			for (CFG_CategorieAbilitate cat : cfgCatAbilitate){
				idAziende.add(cat.getTitoloStruttura());
			}
		}
		
		long response = NewsLocalServiceUtil.searchCount(idAziende, fullText, locale.toString());
		
		output.addAll(NewsLocalServiceUtil.search(
				start, numRes, idAziende, 
				fullText, locale.toString()));
		
		log.info(String.format("Ricerca News eseguita!! (Recuperate %s news su un totale di %s spresenti ", 
				output.size(), response));
		
		return response;
	}
	
	/**
	 * Esegue la ricerca delle News direttamente nelle tabelle di Liferay, filtrandole sulla base delle 
	 * aziende passate in input. 
	 * Se si passa aziende a null verranno restituite solo le News del Portale regionale.
	 * Se si valorizza il parametro fullText verranno restituiti solo le strutture  contenenti  la  parola  
	 * ${fullText}  all'interno dei campi configurati nell'array fullTextSearchItems[], del serviceImpl. 
	 * 
	 * @param output
	 * @param locale
	 * @param start
	 * @param numRes
	 * @param aziende
	 * @param fullText
	 * @return
	 * @throws SystemException
	 * @throws PortalException 
	 */
	public long ricercaNewsLiferay(
			List<News> output,
			Locale locale, 
			int start, int numRes,
			String jsonAziende,
			String fullText
			)throws SystemException, PortalException{
		
		List<CFG_CategorieAbilitate> listaAziende = CFG_CategorieAbilitateLocalServiceUtil.getSelectedByClassName(News.class.getName(), jsonAziende);

		if (listaAziende != null){
			// Recupero i webContents categoria per categoria....
			for(CFG_CategorieAbilitate azienda : listaAziende) {
				output.addAll(getListaNews(
						azienda.getTitoloStruttura(), 
						azienda.getDenominazione(), 
						locale,
						fullText));
			}
		}
		
		return output.size();
	}

	/**
	 * Esegue la ricerca sulle Strutture Sanitarie, filtrandole sulla base delle categorie passate in input.
	 * Se si passa categorie a null non verrà fatto filtraggio sulle categorie.
	 * Se si valorizza il parametro fullText ed il parametro fullTextSearchItems verranno restituiti solo le 
	 * strutture  contenenti  la  parola  $ {fullText}  all'interno dei campi il cui nome compare nell'array 
	 * fullTextSearchItems 
	 * Se si valorizzano i campi gps_lat e gps_lng verrà  calcolata  la  distanza  di ciascuna struttura dal 
	 * dispositivo mobile che ha eseguito la richiesta e la lista verrà ordinata in ordine crescente.
	 *  
	 * @param locale
	 * @param start
	 * @param numRes
	 * @param jsonCategorie : elenco delle categorie di cui restituire i webcontents.
	 * @param jsonStrutture : elenco degli id delle sole strutture da restituire.
	 * @param fulltext : parola da ricercare
	 * @param fullTextSearchItems : array con i nomi dei campi della DDM_Structure in cui eseguire la ricerca,
	 * @param mobile_lat : latitudine del dispositivo mobile che esegue la ricerca 
	 * @param mobile_lng : longitudine del dispositivo mobile che esegue la ricerca
	 * @return
	 */
	@Override
	public long ricercaStruttureSanitarie(
			List<StrutturaSanitaria> output,
			Locale locale,
			int start, int numRes, 
			String jsonCategorie,
			String jsonStrutture,
			String fullText,
			Double mobile_lat, Double mobile_lng) throws SystemException {
		
		log.info("------------- Ricerca StruttureSanitarie  - START... ---------------------- ");
		
		List<String> idCategorie = null;
		// Se mi viene valorizzato jsonCategorie estraggo le DDMStructure corrispondenti,
		// altrimenti prelevo quelle da configurazione.
		List<CFG_CategorieAbilitate> cfgCatAbilitate = CFG_CategorieAbilitateLocalServiceUtil.getSelectedByClassName(
				StrutturaSanitaria.class.getName(), jsonCategorie);
		if (cfgCatAbilitate!= null && !cfgCatAbilitate.isEmpty()){
			idCategorie = new ArrayList<String>();
			for (CFG_CategorieAbilitate cat : cfgCatAbilitate){
				idCategorie.add(cat.getTitoloStruttura());
			}
		}
		
		// Se mi viene valorizzato jsonStrutture estraggo le DDMStructure con tali id...
		List<String> idStrutture = CommonUtils.parseJson(jsonStrutture);
		
		long response = StrutturaSanitariaLocalServiceUtil.searchCount(idCategorie, idStrutture, fullText, locale.toString());
		
		output.addAll(StrutturaSanitariaLocalServiceUtil.search(
				start, numRes, 
				idCategorie, 
				idStrutture,
				fullText, 
				mobile_lat, mobile_lng,
				locale.toString()));
		
		for (StrutturaSanitaria ss : output) {
			if (mobile_lat != null && mobile_lng != null){
				if (ss.getLat() == 0 && ss.getLng() == 0)
					ss.setDistanza(Double.MAX_VALUE);
			}
			else
				ss.setDistanza(Double.MAX_VALUE);
		}
		
		log.info(String.format("Ricerca StruttureSanitarie eseguita!! (Recuperate %s strutture su un totale di %s strutture presenti ", 
				output.size(), response));
		
		return response;
	}
	
	/**
	 * Restituisce la lista di StruttureSanitarie recuperate sulla base dell'id passato
	 * nel parametro idAziende
	 * @param output
	 * @param locale
	 * @param idAziende
	 * @return
	 * @throws SystemException
	 */
	@Override
	public long getStruttureSanitarieByIds(List<StrutturaSanitaria> output,
			Locale locale, List<String> idAziende) throws SystemException {
		
		long retCount = 0;
		
		long idStruttura = 0;
		for (String str : idAziende){
			try{
				idStruttura = Long.parseLong(str);
				StrutturaSanitaria ss = StrutturaSanitariaLocalServiceUtil.findByIdStrutturaAndLocale(idStruttura, locale.toString());
				if (ss!=null){
					output.add(ss);
					retCount++;
				}
			}catch (Exception exp){
				log.error(exp.getMessage(), exp);
			}
		}
		
		return retCount;
	}

	/**
	 * Restituisce la lista di StruttureSanitarie figlie di una data Struttura padre e di categoria pari
	 * alla categoria identificata da idCategoria.
	 *  
	 * @param locale
	 * @param start
	 * @param numRes : nr delle news da restituire
	 * @param idCategoria : identificativo della categoria di cui restituire i webcontents.
	 * @param idStrutturaPadre : sidentificativo della struttura padre di cui si vogliono i figli.
	 * @return
	 */
	@Override
	public int ricercaStruttureSanitarieFiglie(
			List<StrutturaSanitariaFiglia> output,
			Locale locale,
			int start, int numRes, 
			String idCategoria, 
			long idStrutturaPadre) throws SystemException {
		
		int response = 0;
		
		try {
			// Recupero la Struttura Sanitaria...
			StrutturaSanitaria ss = StrutturaSanitariaLocalServiceUtil.findByIdStrutturaAndLocale(idStrutturaPadre, locale.toString());
			log.info(String.format("----- StrutturaSanitaria[id=%s] - Trovato!! ----------------------", ss.getIdStruttura()));
						
			// Recupero il value del field di relazione di interesse...
			String fieldValue = getChildenEdottoStrValue(idCategoria, ss); 
			
			// Estraggo i webContents di interesse...
			if (fieldValue!=null && !fieldValue.isEmpty()){
				String[] articleIds = fieldValue.split(";");
				response = articleIds.length - 1;
				
				log.debug(String.format("articles.length = %s", articleIds.length));

				if (start > articleIds.length)
					start = articleIds.length;
				int foundWebContentCount = 0;
				int idx = start;
				LinkedList<JournalArticle> webContents = new LinkedList<JournalArticle>();
				// Recupero il webContent da trasformare in StrutturaSanitaria....
				while ((foundWebContentCount < numRes) && (idx < articleIds.length)){
					if ( articleIds[idx]!=null && !articleIds[idx].isEmpty()){
						try{
							webContents.addLast(JournalArticleLocalServiceUtil.getLatestArticle(
									ss.getGroupId(), articleIds[idx], JOURNAL_ARTICLE_STATUS_APPROVED));
							foundWebContentCount++;
						}catch (Exception exp){
							log.error(exp.getMessage(), exp);
						}
					}
					idx++;
				}
				
				// Converto i webContents in StrutturaSanitaria....
				convertJournalArticleListToStrutturaSanitariaFigliaList(
						output, webContents, 
						(String) mapDdmEngCategorie.get(idCategoria), 
						locale);
				
			}
					
		} catch (PortalException e) {
			log.error(e.getMessage(), e);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		
		return response;
	}
	
	/**
	 * Restituisce la lista delle ultime numRes News (valore configurabile) pubblicate sull’HomePage 
	 * del Portale PugliaSalute
	 * @param locale
	 * @return
	 * @throws SystemException
	 */
	public List<News> getListaNews(String idAzienda, String nomeAzienda, Locale locale, String fulltext)throws SystemException{
		
		LinkedList<News> response = new LinkedList<News>();
		
		// Recupero i webContents categoria per categoria....
		DDMStructure ddmStructure = findDDMStructureByName(DDMStructureLocalServiceUtil.getDDMStructures(-1, -1), locale, ddm_structure_news_name);
		log.info(String.format("---------------- Azienda:(%s) Categoria:(%s) DDMStructure:(%s) - START... ---------------------- ", 
				nomeAzienda, ddm_structure_news_name, ddmStructure.getName(locale)));
		
	    Map<String, String> mapCategorie = null;
		if (idAzienda.equals(String.valueOf(groupIdRegionalePrivato))){
			mapCategorie = mapNewsRegCategories;
			log.debug(String.format("groupIdRegionalePrivato = %s... mapCategorie = mapNewsRegCategories", groupIdRegionalePrivato));
		}else{
			mapCategorie = mapNewsCategories;
			log.debug(String.format("groupIdRegionalePrivato = %s... mapCategorie = mapNewsCategories", groupIdRegionalePrivato));
		}

		LinkedList<JournalArticle> webContents = null;
		int newsCount = 0;
		// Recupero l'ultima versione in stato approvato dei webContents di struttura News, che 
		// abbiano come categoria una di quelle configurate, in ordine di config delle categorie.
		for (Entry<String, String> AC_Entry : mapCategorie.entrySet()){
			webContents = new LinkedList<JournalArticle>();
			String assetCategoryName = AC_Entry.getKey();
			
			long groupId = Long.parseLong(idAzienda);
			if (!AC_Entry.getValue().equals("*"))
				groupId = Long.parseLong(AC_Entry.getValue());
			
			webContents.addAll(
					findLatestApprovedNewsOrderByDataPubblicazione(
							nrNewsToBeRetrieved, 
							ddmStructure, 
							groupId,
							assetCategoryName, 
							locale,
							fulltext));
			
			// Trasformo i webContents in News...
			if (groupId == groupIdRegionalePubblico)
				idAzienda = String.valueOf(groupIdRegionalePrivato);
			newsCount += convertJournalArticleListToNewsList(response, webContents, idAzienda, ddmStructure, locale);
			
			// Se ho raggiunto il numero di risultati da restituire interrompo in ciclo...
			if (webContents.size() >= nrNewsToBeRetrieved)
				break;
		}
		
		log.info(String.format("---------------- Azienda:(%s) Categoria:(%s) DDMStructure:(%s) - E N D recuperate %s news... ----- ", 
				nomeAzienda, ddm_structure_news_name, ddmStructure.getName(locale), newsCount));
		
		return response;
	}
	
	
	/**
	 * PRIVATE METHODS
	 */
	
	/**
	 * Cerca la DDMStructure il cui titolo coincide con searchName e se lo trova ne restituisce la structureKey.
	 * In caso contrario restituisce stringa vuota. 
	 * @param locale
	 * @param searchName
	 * @return
	 * @throws SystemException
	 */
	private DDMStructure getDDMStructureByStructureName(Locale locale, String searchName) throws SystemException{
		List<DDMStructure> ddmStructures = DDMStructureLocalServiceUtil.getDDMStructures(-1, -1);
		log.debug(String.format("recuperate %s ddm_structure", ddmStructures.size()));
		
		return findDDMStructureByName(ddmStructures, locale, searchName);
	}
	
	private DDMStructure findDDMStructureByName(List<DDMStructure> inputList, Locale locale, String searchName){
		DDMStructure ddmStructure = null;
		log.debug(String.format("Ricerca DDMStructure con nome = (%s)...", searchName));
		for (DDMStructure ddm_str : inputList){
			if (ddm_str.getName(locale).equalsIgnoreCase(searchName)){
				log.debug(String.format("trovata DDMStructure con nome = (%s)... structureKey=%s", searchName, ddm_str.getStructureKey()));
				ddmStructure = ddm_str;
				break;
			}
		}
		
		return ddmStructure;
	}
	
	private long findLiferayGroupIdByName(String name) throws SystemException{
		long response = -1;
		for (Group g : GroupLocalServiceUtil.getLiveGroups()){
			if (g.getName().equals(name)){
				response = g.getGroupId();
				break;
			}
		}
		
		return response;
	}
	
	private LinkedList<JournalArticle> findLatestApprovedNewsOrderByDataPubblicazione(
			int numRes,
			DDMStructure ddmStructure,
			long groupId,
			String categoria,
			Locale locale,
			String fulltext) throws SystemException{

		LinkedList <JournalArticle> response = new LinkedList<JournalArticle>();
		LinkedList <JournalArticle> tmpJournals = new LinkedList<JournalArticle>();

		try{
			long jaClassNameId = ClassNameLocalServiceUtil.getClassNameId(JournalArticle.class);
			DynamicQuery queryCategory = DynamicQueryFactoryUtil.forClass(AssetCategory.class)
					.add(PropertyFactoryUtil.forName( "groupId" ).eq( groupId ));

			Criterion criterion = RestrictionsFactoryUtil.eq("name", categoria);
			queryCategory.add(criterion);

			// recupero gli AssetEntries per queste categorie...
			List<AssetEntry> assetEntries = new ArrayList<AssetEntry>();
			List<AssetCategory> categorie =	AssetCategoryLocalServiceUtil.dynamicQuery(queryCategory);
			if (categorie.size() != 0){
				for (AssetCategory cat : categorie){
					List<AssetEntry> tmpAssetEntries = AssetEntryLocalServiceUtil.getAssetCategoryAssetEntries( cat.getCategoryId()); 
					for (AssetEntry ae : tmpAssetEntries){
						if (ae.getClassNameId() == jaClassNameId && !assetEntries.contains(ae)){
							assetEntries.add(ae);
						}
					}
				}
			}

			// Recupero i JournalArticles...
			// #SA# : In data 30/03/2016 rimuovo da dbMaster (PROD) l'assetentries_assetcategories con 
			//        categoryid = 96772, entryid = 2187877 perche manda in errore la chiamata
			//        getLatestArticle in quanto pur essendoci il recordi in assetentries_assetcategories
			//        non esiste un journalArticle con resourcePrimKey = 2187877...
			//        Per il futuro aggiungo la cattura dell'eccezione NoSuchArticleException...
			boolean ricercaFullText = (fulltext != null && !fulltext.isEmpty());
			for (AssetEntry ae : assetEntries){
				try{
					JournalArticle j = JournalArticleLocalServiceUtil.getLatestArticle(ae.getClassPK(), WorkflowConstants.STATUS_APPROVED);
					if (j.getStructureId().equals(ddmStructure.getStructureKey()))
						// Se la ricerca fulltext è da fare veruifico anche se il titolo contiene il testo desiderato,
						if (ricercaFullText){
							if (j.getTitle(locale).toLowerCase(locale).contains(fulltext.toLowerCase(locale)))
								tmpJournals.add(j);
						} // altrimenti prendo cmq in considerazione la news.
						else
							tmpJournals.add(j);
				} catch (NoSuchArticleException nsae){
					log.error(nsae.getMessage(), nsae);
				}
			}

			// Ordino per data...
			Collections.sort(tmpJournals, new Comparator<JournalArticle>() {
				@Override
				public int compare(JournalArticle o1, JournalArticle o2) {
					// Write your logic here.
					try{
						if (o1.getDisplayDate().getTime() == o2.getDisplayDate().getTime())
							return 0;
						else if (o1.getDisplayDate().getTime() > o2.getDisplayDate().getTime())
							return -1;
						else
							return 1;
					}
					catch (Exception exp){
						log.error(exp.getMessage(), exp);
						return 0;
					}
				}
			});
			
			// quindi taglio...
			int end = numRes;
			if (end > tmpJournals.size())
				end = tmpJournals.size();

			for (int idx = 0; idx < end; idx++){
				response.addLast(tmpJournals.get(idx));
			}
			
			tmpJournals = null;
			log.info(String.format("AssetCategory :%s - groupId :%s - recuperate %s News...",
					categoria, groupId, end));
		} catch (PortalException pe){
			log.error(pe.getMessage(), pe);
		}

		log.info(String.format("DDMStructure:(%s) estratti %s webContents di categoria:%s...",ddmStructure.getName(locale), response.size(), categoria));
		
		return response;
	}
	
	private List<StrutturaSanitaria> findLatestApprovedItemsByDDMStructure(
			CFG_CategorieAbilitate cfgCategoria,
			DDMStructure ddmStructure,
			Locale locale) throws SystemException{
		List <JournalArticle> tempJournals = new ArrayList<JournalArticle>();
		List<StrutturaSanitaria> listaStrutture = new ArrayList<StrutturaSanitaria>();

		// Query per recuperare l'ultima versione dei JournalArticle in stato APPROVED 
		// di una data DDMStructure...
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(JournalArticle.class);
		dynamicQuery.add(RestrictionsFactoryUtil.eq("status", JOURNAL_ARTICLE_STATUS_APPROVED))
				.add(PropertyFactoryUtil.forName("structureId").eq(ddmStructure.getStructureKey()))
		        .addOrder(OrderFactoryUtil.desc("version"));
//		        .setLimit(cur, cur + resultsByPage);
		
		tempJournals.addAll(JournalArticleLocalServiceUtil.dynamicQuery(dynamicQuery));
		log.info(String.format("DDMStructure:(%s) estratti %s webContents...",ddmStructure.getName(locale), tempJournals.size()));
		
		// Mantengo solo l'ultima versione di ciascun JournalArticle....
		List<String> processedArticleId = new ArrayList<String>();
		String searchTipologia = null;
		String[] tmp = cfgCategoria.getTitoloStruttura().split("\\.");
		if (tmp.length > 1)
			searchTipologia = tmp[1];
		
		for (JournalArticle ja : tempJournals){
			if (!processedArticleId.contains(ja.getArticleId())){
				
				try{
					// Converto il JournalArticle in StrutturaSanitaria
					StrutturaSanitaria ss = convertJournalArticleToStrutturaSanitaria(
							ja, cfgCategoria, 
							searchTipologia,
							ddmStructure, 
							locale);
					
					if (ss != null){
						try{
							listaStrutture.add(ss);
							processedArticleId.add(ja.getArticleId());
							log.debug(String.format("articolo id=%s di versione %s aggiuto...", ja.getArticleId(), ja.getVersion()));
						} catch (Exception exp){
							log.error(exp.getMessage(), exp);
						}
					}
					
				} catch (Exception exp){
					log.error(exp.getMessage(), exp);
				}
			}
		}
		
		log.info(String.format("DDMStructure:(%s) estratti %s webContents latest version...",ddmStructure.getName(locale), listaStrutture.size()));

		tempJournals = null;
		
		return listaStrutture;
	}
	
	private int convertJournalArticleListToStrutturaSanitariaFigliaList(
			List<StrutturaSanitariaFiglia> output, 
			List<JournalArticle> input,
			String idCategoria,	Locale locale) throws PortalException, SystemException{
		int count=0;
		
		// genero la lista di StrutturaSanitaria...
		if (input!=null && input.size() > 0){
			
			// Recupero la DDMStructure di questo webContent....
			DDMStructure ddmStructure = DDMStructureLocalServiceUtil.getStructure(
					groupIdRegionalePubblico, 
					ClassNameLocalServiceUtil.getClassNameId(JournalArticle.class), 
					input.get(0).getStructureId());
			
			ListIterator<JournalArticle> inputIterator = input.listIterator();
			
			while (inputIterator.hasNext()) {
				JournalArticle journal = inputIterator.next();
				try{
					StrutturaSanitariaFiglia ss = convertJournalArticleToStrutturaSanitariaFiglia(
							journal, 
							idCategoria, 
							ddmStructure, 
							locale);
					
					if (ss!=null){
						output.add(ss);
						count++;
					}
				}
				catch (Exception exp){
					log.error(exp.getMessage(), exp);
				}
			}
			
			log.info(String.format("DDMStructure:(%s) - Aggiunti %s items di tipo StrutturaSanitariaFiglia...", 
					ddmStructure.getName(locale), output.size()));
		}
		else
			log.error("input list is null");
		
		return count;
	}
	
	private int convertJournalArticleListToNewsList(
			List<News> output, List<JournalArticle> input,
			String idAzienda, DDMStructure ddmStructure, 
			Locale locale){
		int count=0;
		
		// genero la lista di News...
		if (input!=null){
			
			ListIterator<JournalArticle> inputIterator = input.listIterator();
			
			while (inputIterator.hasNext()) {
				JournalArticle journal = inputIterator.next();
				try{
					News news = convertJournalArticleToNews(journal, idAzienda, ddmStructure, locale);
					
					if (news!=null){
						output.add(news);
						count++;
					}
				}
				catch (Exception exp){
					log.error(exp.getMessage(), exp);
				}
			}
		}
		else
			log.error("input list is null");
		
		log.info(String.format("DDMStructure:(%s) - Recuperate %s News...", 
				ddmStructure.getName(locale), output.size()));
		return count;
	}
	
	private StrutturaSanitaria convertJournalArticleToStrutturaSanitaria(
			JournalArticle webContent, 
			CFG_CategorieAbilitate cfgCategoria, 
			String searchTipologia,
			DDMStructure ddmStructure, 
			Locale locale) throws Exception{
		log.debug(String.format("Analisi WebContent con title :  %s...", webContent.getTitle(new Locale("it","IT"))));
		
		StrutturaSanitaria ss = new StrutturaSanitariaImpl();
		ss.setIdStruttura(webContent.getResourcePrimKey());
		ss.setGroupId(webContent.getGroupId());
		ss.setIdTipoStruttura(cfgCategoria.getTitoloStruttura());
		ss.setTipoStruttura(cfgCategoria.getDenominazione());
		ss.setLocale(locale.toString());
	
		String strGeo = null;
		Fields fs = JournalConverterUtil.getDDMFields( ddmStructure , webContent.getContent());
	
		for (String s : ddmStructure.getFieldNames()) { 
			Field f = fs.get(s);
	
			if (f != null){
				if( s.equalsIgnoreCase(s_sanitaria_denominazione) ){
					ss.setDenominazione((String) f.getValue(locale));
				}
				else if( s.equalsIgnoreCase(s_sanitaria_tipologia) ){
					ss.setTipologia((String) f.getValue(locale));
				}
				else if( s.equalsIgnoreCase(s_sanitaria_descrizione) ){
					String strValue = new HtmlToPlainText().getPlainText(Jsoup.parse((String) f.getValue(locale)));
					ss.setDescrizione(strValue);
				}
				else if( s.equalsIgnoreCase(s_sanitaria_telefono) ){
					ss.setTelefono((String) f.getValue(locale));
				}
				else if( s.equalsIgnoreCase(s_sanitaria_fax) ){
					ss.setFax((String) f.getValue(locale));
				}
				else if( s.equalsIgnoreCase(s_sanitaria_email) ){
					ss.setEmail((String) f.getValue(locale));
				}
				else if( s.equalsIgnoreCase(s_sanitaria_geo) ){
					strGeo = (String) f.getValue();
				}
				else if( s.equalsIgnoreCase(s_sanitaria_immagine) ){
					ss.setImmagine(getImageURL((String) f.getValue()));
				}
				// Recupero i campi childenEdotto per le relazioni....
				else if( s.equalsIgnoreCase(s_sanitaria_ce_ospedaleCollegato) ){
					ss.setChildrenEdottoOspedaleCollegato(f.getValue().toString());
				}
				else if( s.equalsIgnoreCase(s_sanitaria_ce_ambulatorio) ){
					ss.setChildrenEdottoAmbulatorio(f.getValue().toString());
				}
				else if( s.equalsIgnoreCase(s_sanitaria_ce_unitaOperativa) ){
					ss.setChildrenEdottoUnitaOperativa(f.getValue().toString());
				}
				else if( s.equalsIgnoreCase(s_sanitaria_ce_unitaps) ){
					ss.setChildrenEdottoUnitaps(f.getValue().toString());
				}
				else if( s.equalsIgnoreCase(s_sanitaria_re_ambulatorio) ){
					ss.setRelazioneAmbulatorio(f.getValue().toString());
				}
			}
			else
				log.debug(String.format("Field with name %s is null !!Skipped...", s));
		}
		
		// Se idCategoria riporta con se anche l'informazione sulla tipologia, 
		// filtro solo i journal Articles di tale tipologia
		if (searchTipologia!=null && !searchTipologia.isEmpty()){
			if (ss.getTipologia()!= null){
				if (ss.getTipologia().contains(searchTipologia))
					log.debug(String.format("WebContent[id=%s] risulta essere di tipologia = %s",
							webContent.getResourcePrimKey(), searchTipologia));
				else
					ss = null;
			}
		}
		
		// Se è stata valorizzata la stringa con le coordinate geografiche della struttura 
		// ne faccio il parsing....
		if (ss != null && strGeo!= null && !strGeo.isEmpty()){
			try{
				log.debug(String.format("geo value = %s", strGeo));
				
				JSONDeserializer<ENG_Geo> deserializer = new JSONDeserializer<ENG_Geo>();
				ENG_Geo engGeo = deserializer.deserialize(strGeo, ENG_Geo.class);
	
				log.debug(String.format("ENG_geo.coordinate value = %s", engGeo.getCoordinates()));
	
				if (engGeo!=null){
					ss.setIndirizzo(engGeo.getIndirizzo());
					ss.setLat(engGeo.getGeoLatitude());
					ss.setLng(engGeo.getGeoLongitude());
				}
			}
			catch(Exception exp){
				log.error(String.format("WebContent[id=%s] - Errore nel recupero delle coordinate geografiche!!", webContent.getResourcePrimKey()));
			}
		}
		
		return ss;
	}
	
	private StrutturaSanitariaFiglia convertJournalArticleToStrutturaSanitariaFiglia(
			JournalArticle webContent, 
			String idCategoria, 
			DDMStructure ddmStructure, 
			Locale locale) throws Exception{
		log.debug(String.format("Analisi WebContent con title :  %s...", webContent.getTitle(new Locale("it","IT"))));
		
		StrutturaSanitariaFiglia ss = new StrutturaSanitariaFigliaImpl();
		ss.setIdStrutturaFiglia(webContent.getResourcePrimKey());
		ss.setTipoStruttura(idCategoria);
	
		Fields fs;
		fs = JournalConverterUtil.getDDMFields( ddmStructure , webContent.getContent() );
	
		for (String s : ddmStructure.getFieldNames()) { 
			Field f = fs.get(s);
	
			if (f != null){
				if( s.equalsIgnoreCase(s_sanitaria_denominazione) ){
					ss.setDenominazione((String) f.getValue(locale));
				}
				else if( s.equalsIgnoreCase(s_sanitaria_telefono) ){
					ss.setTelefono((String) f.getValue(locale));
				}
				else if( s.equalsIgnoreCase(s_sanitaria_email) ){
					ss.setEmail((String) f.getValue(locale));
				}
				else if( s.equalsIgnoreCase(s_sanitaria_responsabile) ){
					ss.setResponsabileSanitario((String) f.getValue(locale));
				}
				else if( s.equalsIgnoreCase(s_sanitaria_direttore) ){
					ss.setDirettore((String) f.getValue(locale));
				}
			}
			else
				log.debug(String.format("Field with name %s is null !!Skipped...", s));
		}
		
			
		return ss;
	}
	
	/**
	 * Costruisce la URL per poter fare il download di un DLFileEntry partendo da groupId e uuid. 
	 * Es.: http://138.66.174.183:8080/c/document_library/get_file?uuid=5673ffef-0c83-4620-89a2-a09cd3cdf19a&groupId=25176
	 * @param strImageData
	 * @return
	 */
	private String getImageURL(String strImageData){
		log.debug(String.format("strImageData = %s", strImageData));
		String url = "";
		
		if (strImageData != null && !strImageData.isEmpty()){
			try{
				JSONDeserializer<ENG_Image> deserializer = new JSONDeserializer<ENG_Image>();
				ENG_Image imageData = deserializer.deserialize(strImageData, ENG_Image.class);

				if (imageData != null){
					url = portalBaseURL + LIFERAY_DOWNLOAD_FILE_ACTION + 
							"?uuid=" + imageData.getUuid() + 
							"&groupId=" + imageData.getGroupId();
				}
			}catch (Exception exp){
				log.error(exp.getMessage(), exp);
			}
		}

		log.debug(String.format("La URL generata e' la seguente: %s...", url));
		return url;
	}
	
	private News convertJournalArticleToNews(
			JournalArticle webContent, 
			String idAzienda,
			DDMStructure ddmStructure, 
			Locale locale) throws Exception{
		log.debug(String.format("Analisi WebContent con title :  %s...", webContent.getTitle(new Locale("it","IT"))));
		
		News news = new NewsImpl();
		news.setIdNews(Long.parseLong(webContent.getArticleId()));
		news.setIdAzienda(idAzienda);
//		news.setIdAzienda(String.valueOf(webContent.getGroupId()));
		news.setDataPubblicazione(webContent.getDisplayDate().getTime());
		news.setLocale(locale.toString());

		Fields fs;
		fs = JournalConverterUtil.getDDMFields( ddmStructure , webContent.getContent() );
		String descrBreve = "";
		String descrizione = "";

		for (String s : ddmStructure.getFieldNames()) { 
			Field f = fs.get(s);

			if (f != null){
				if( s.equalsIgnoreCase(s_sanitaria_denominazione) ){
					news.setTitolo((String) f.getValue(locale));
				}
				else if( s.equalsIgnoreCase(s_sanitaria_immagine) ){
					news.setImmagine(getImageURL((String) f.getValue()));
				}
				else if( s.equalsIgnoreCase(s_sanitaria_descrizione) ){
					descrizione = new HtmlToPlainText().getPlainText(Jsoup.parse((String) f.getValue(locale)));
				}
				else if( s.equalsIgnoreCase(s_sanitaria_descrizione_breve) ){
					descrBreve = new HtmlToPlainText().getPlainText(Jsoup.parse((String) f.getValue(locale)));
				}
				else if( s.equalsIgnoreCase(news_autore) ){
					news.setAutore((String) f.getValue(locale));
				}
			}
			else
				log.debug(String.format("Field with name %s is null !!Skipped...", s));
		}
		
		if (!descrizione.isEmpty())
			news.setDescrizione(descrizione);
		else if (!descrBreve.isEmpty())
			news.setDescrizione(descrBreve);
		
		return news;
	}

}
