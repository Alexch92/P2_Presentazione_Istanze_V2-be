package it.sincon.sanita.services.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.liferay.portal.kernel.exception.SystemException;

import flexjson.JSONDeserializer;
import it.sincon.sanita.services.model.CFG_CategorieAbilitate;
import it.sincon.sanita.services.service.CFG_CategorieAbilitateLocalServiceUtil;
import it.sincon.sanita.services.service.base.CFG_CategorieAbilitateLocalServiceBaseImpl;
import it.sincon.sanita.utils.CommonUtils;

/**
 * The implementation of the c f g_ categorie abilitate local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link it.sincon.sanita.services.service.CFG_CategorieAbilitateLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Sincon
 * @see it.sincon.sanita.services.service.base.CFG_CategorieAbilitateLocalServiceBaseImpl
 * @see it.sincon.sanita.services.service.CFG_CategorieAbilitateLocalServiceUtil
 */
public class CFG_CategorieAbilitateLocalServiceImpl
    extends CFG_CategorieAbilitateLocalServiceBaseImpl {
	
	private static Logger log = LoggerFactory.getLogger( CFG_CategorieAbilitateLocalServiceImpl.class );
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link it.sincon.sanita.services.service.CFG_CategorieAbilitateLocalServiceUtil} to access the c f g_ categorie abilitate local service.
     */
	public List<CFG_CategorieAbilitate> getAllCFG_CategorieAbilitate() throws SystemException{
		return this.cfg_CategorieAbilitateLocalService.getCFG_CategorieAbilitates(-1, -1);
	}
	
	public List<CFG_CategorieAbilitate> getCFG_CategorieAbilitateByClassName(String className) throws SystemException{
		return this.cfg_CategorieAbilitatePersistence.findByClassName(className);
	}
	
	public List<CFG_CategorieAbilitate> getCFG_CategorieAbilitateByClassNameAndDefaultRicerca(String className, boolean defaultRicerca) throws SystemException{
		return this.cfg_CategorieAbilitatePersistence.findByClassNameAndDefaultRicerca(className, defaultRicerca);
	}
	
	/**
	 * Analizza il jsonAziende (parametro di request inviato dall'app mobile) e se non è null restituisce
	 * la lista di CFG_CategorieAbilitate corrispondenti, in caso contrario restituisce quelle impostate di default.
	 * 
	 * @param className
	 * @param jsonCategorie
	 * @return
	 * @throws SystemException
	 */
	public List<CFG_CategorieAbilitate> getSelectedByClassName(String className, String jsonCategorie) 
			throws SystemException{
		
		List<CFG_CategorieAbilitate> response = new ArrayList<CFG_CategorieAbilitate>();
		
		// Se mi viene valorizzato jsonCategorie estraggo le DDMStructure corrispondenti,
    	// altrimenti prelevo quelle da configurazione impostate come default....
		List<String> idCategorie = CommonUtils.parseJson(jsonCategorie);
		
		if (idCategorie == null || (idCategorie != null && idCategorie.size() == 0)){
			// Recupero le Categorie configurate come defaults...
			List<CFG_CategorieAbilitate> cfg_catAbilitateDefault = 
					CFG_CategorieAbilitateLocalServiceUtil.getCFG_CategorieAbilitateByClassNameAndDefaultRicerca(
							className, true);
			log.info(String.format("cfg_catAbilitateDefault.size()=(%s)...", cfg_catAbilitateDefault.size()));
			
			response.addAll(cfg_catAbilitateDefault);
		} else {
			// Recupero le Categorie per le quali andare a recuperare i web contents...
			List<CFG_CategorieAbilitate> cfg_catAbilitate = 
					CFG_CategorieAbilitateLocalServiceUtil.getCFG_CategorieAbilitateByClassName(className);
			log.info(String.format("cfg_catAbilitate.size()=(%s)...", cfg_catAbilitate.size()));
			
			for (CFG_CategorieAbilitate cat : cfg_catAbilitate){
				for (String idAzienda : idCategorie){
					if (cat.getTitoloStruttura().equalsIgnoreCase(idAzienda))
						response.add(cat);
				}
			}
		}
		
		log.info(String.format("response.size()=(%s)...", response.size()));
		return response;
	}
}
