package it.sincon.sanita.services.service;

import it.sincon.sanita.services.model.CFG_CategorieAbilitate;
import it.sincon.sanita.services.model.CategoriaStruttura;
import it.sincon.sanita.services.model.News;
import it.sincon.sanita.services.model.StrutturaSanitaria;
import it.sincon.sanita.services.model.StrutturaSanitariaFiglia;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.BaseService;
import com.liferay.portal.service.InvokableService;
import com.liferay.portlet.dynamicdatamapping.model.DDMStructure;

/**
 * Interfaccia per i service utilizzati nella 
 * @author Santomauro
 *
 */
public interface SanitaRESTfullService {
	
	/**
	 * Restituisce la lista di CategoriaStruttura con le info delle sole categorie abilitate all'app per la
	 * ricerca delle StruttureSanitarie.
	 * In CategoriaStruttura verrà valorizzato il campo idTipoStruttura con il nomelogico della DDMStructure
	 * che è formato come <NomeDDMStructure>.<Tipologia> es. UfficioSemplice.ps per il pronto soccorso 
	 * @param locale
	 * @return
	 * @throws SystemException
	 */
	public List<CategoriaStruttura> getCategorieAbilitate(Locale locale)throws SystemException;
	
	/**
	 * Recupera la lista delle categorie cui appartengono le strutture figlie di una data struttura sanitaria.
	 * In CategoriaStruttura verrà valorizzato il campo idTipoStruttura con il nomelogico della DDMStructure
	 * che è formato come <NomeDDMStructure>.<Tipologia> es. UfficioSemplice.ps per il pronto soccorso 
	 * @param idStruttura
	 * @return
	 * @throws SystemException
	 */
	public List<CategoriaStruttura> findCategorieFigliByStrutturaPadre(Locale locale, long idStruttura)throws SystemException;
	
	/**
	 * Aggiorna la tabella delle Strutture Sanitarie, recuperando i dati di interesse dalla tabella
	 * dei Journal Articles di Liferay
	 * 
	 * @param listaStrutture
	 * @param locale
	 * @return
	 * @throws SystemException
	 */
	public long aggiornaStruttureSanitarie(List<StrutturaSanitaria> listaStrutture, Locale locale)throws SystemException;
	
	/**
	 * Storicizza in db la lista di strutture passata in input
	 * @param listaStrutture
	 * @return
	 * @throws SystemException
	 */
	public long storeStruttureSanitarie(List<StrutturaSanitaria> listaStrutture) throws SystemException;
	
	/**
	 * Aggiorna la tabella delle News, recuperando i dati di interesse dalla tabella
	 * dei Journal Articles di Liferay
	 * 
	 * @param listaNews
	 * @param locale
	 * @return
	 * @throws SystemException
	 */
	public long aggiornaNews(List<News> listaNews, Locale locale)throws SystemException;
	
	/**
	 * Storicizza in db la lista di news passata in input
	 * @param listaNews
	 * @return
	 * @throws SystemException
	 */
	public long storeNews(List<News> listaNews) throws SystemException;
	
	/**
	 * Esegue la ricerca sulle Strutture Sanitarie, filtrandole sulla base delle categorie passate in input.
	 * Se si passa categorie a null non verrà fatto filtraggio sulle categorie.
	 * Se si valorizza il parametro fullText verranno restituiti solo le strutture  contenenti  la  parola  
	 * ${fullText}  all'interno dei campi configurati nell'array fullTextSearchItems[], del serviceImpl. 
	 * Se si valorizzano i campi gps_lat e gps_lng verrà  calcolata  la  distanza  di ciascuna struttura dal 
	 * dispositivo mobile che ha eseguito la richiesta e la lista verrà ordinata in ordine crescente.
	 *  
	 * @param locale
	 * @param start
	 * @param numRes
	 * @param jsonCategorie : elenco delle categorie di cui restituire i webcontents.
	 * @param jsonStrutture : elenco degli id delle sole strutture da restituire.
	 * @param fulltext : parola da ricercare
	 * @param gps_lat : latitudine del dispositivo mobile che esegue la ricerca 
	 * @param gps_lng : longitudine del dispositivo mobile che esegue la ricerca
	 * @return
	 */
	public long ricercaStruttureSanitarie(
			List<StrutturaSanitaria> output,
			Locale locale, 
			int start, int numRes,
			String jsonCategorie,
			String jsonStrutture,
			String fullText,
			Double gps_lat, Double gps_lng
			)throws SystemException;
	
	/**
	 * Restituisce la lista di StruttureSanitarie recuperate sulla base dell'id passato
	 * nel parametro idAziende
	 * @param output
	 * @param locale
	 * @param idAziende
	 * @return
	 * @throws SystemException
	 */
	public long getStruttureSanitarieByIds(
			List<StrutturaSanitaria> output,
			Locale locale, 
			List<String> idAziende
			)throws SystemException;
	
	/**
	 * Restituisce la lista di StruttureSanitarie figlie di una data Struttura padre e di categoria pari
	 * alla categoria identificata da idCategoria.
	 *  
	 * @param locale
	 * @param start
	 * @param numRes : nr delle news da restituire
	 * @param idCategoria : nome logico della categoria di cui restituire i webcontents.
	 * @param idStrutturaPadre : sidentificativo della struttura padre di cui si vogliono i figli.
	 * @return
	 */
	public int ricercaStruttureSanitarieFiglie(
			List<StrutturaSanitariaFiglia> output,
			Locale locale, 
			int start, int numRes,
			String idCategoria,
			long idStrutturaPadre)
			throws SystemException;
	
	/**
	 * Restituisce la lista di CategoriaStruttura con le info delle sole categorie abilitate all'app per la
	 * ricerca delle News.
	 * In CategoriaStruttura verrà valorizzato il campo idTipoStruttura con il nomelogico della DDMStructure
	 * che è formato come <NomeDDMStructure>.<Tipologia> es. UfficioSemplice.ps per il pronto soccorso 
	 * @param locale
	 * @return
	 * @throws SystemException
	 */
	public List<CategoriaStruttura> getCategorieNewsAbilitate(Locale locale)throws SystemException;
	
	/**
	 * Restituisce la lista delle ultime numRes News (valore configurabile) pubblicate sull’HomePage 
	 * del Portale PugliaSalute
	 * 
	 * @param idAzienda
	 * @param nomeAzienda
	 * @param locale
	 * @return
	 * @throws SystemException
	 */
	public List<News> getListaNews(String idAzienda, String nomeAzienda, Locale locale, String fulltext)throws SystemException;
	
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
	public long ricercaNews(
			List<News> output,
			Locale locale, 
			int start, int numRes,
			String aziende,
			String fullText
			)throws SystemException;
	
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
	 */
	public long ricercaNewsLiferay(
			List<News> output,
			Locale locale, 
			int start, int numRes,
			String aziende,
			String fullText
			)throws SystemException, PortalException;
	
}
