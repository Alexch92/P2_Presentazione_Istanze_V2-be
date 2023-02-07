package it.sincon.sanita.services.service.impl;

import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;

import it.sincon.sanita.services.model.StrutturaSanitaria;
import it.sincon.sanita.services.service.StrutturaSanitariaLocalServiceUtil;
import it.sincon.sanita.services.service.base.StrutturaSanitariaLocalServiceBaseImpl;
import it.sincon.sanita.services.service.persistence.StrutturaSanitariaFinderUtil;

/**
 * The implementation of the struttura sanitaria local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link it.sincon.sanita.services.service.StrutturaSanitariaLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Sincon
 * @see it.sincon.sanita.services.service.base.StrutturaSanitariaLocalServiceBaseImpl
 * @see it.sincon.sanita.services.service.StrutturaSanitariaLocalServiceUtil
 */
public class StrutturaSanitariaLocalServiceImpl
    extends StrutturaSanitariaLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link it.sincon.sanita.services.service.StrutturaSanitariaLocalServiceUtil} to access the struttura sanitaria local service.
     */
	
	protected void deleteAll() throws SystemException{
		runSQL("TRUNCATE TABLE SANITAREST_StrutturaSanitaria;");
	}
	
	public long replaceAll(List<StrutturaSanitaria> newItemsList) throws SystemException{
		int added = 0;

		deleteAll();

		for (StrutturaSanitaria ss : newItemsList){
			ss = StrutturaSanitariaLocalServiceUtil.addStrutturaSanitaria(ss);
			added++;
		}

		return added;
	}

	public StrutturaSanitaria findByIdStrutturaAndLocale(long idStruttura, String locale) throws SystemException{
		return strutturaSanitariaPersistence.fetchByIdStrutturaAndLocale(idStruttura, locale);
	}
	
	public long searchCount(List<String> listaIdTipoStrutture, List<String> listaIdStrutture, String fullText, String locale) throws SystemException{
		return StrutturaSanitariaFinderUtil.getSearchCount(listaIdTipoStrutture, listaIdStrutture, fullText, locale);
	}
	
	public List<StrutturaSanitaria> search(
			int start, int numRes,
	        List<String> listaIdTipoStrutture,
	        List<String> listaIdStrutture,
	        String fullText, 
	        Double mobile_latitude,
	        Double mobile_longitude,
	        String locale) throws SystemException{
		
		return StrutturaSanitariaFinderUtil.search(
				start, numRes, 
				listaIdTipoStrutture, 
				listaIdStrutture, 
				fullText, 
				mobile_latitude, 
				mobile_longitude,
				locale);
	}
	
}
