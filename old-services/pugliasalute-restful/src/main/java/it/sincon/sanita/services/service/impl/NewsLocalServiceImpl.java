package it.sincon.sanita.services.service.impl;

import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;

import it.sincon.sanita.services.model.News;
import it.sincon.sanita.services.model.StrutturaSanitaria;
import it.sincon.sanita.services.service.NewsLocalServiceUtil;
import it.sincon.sanita.services.service.base.NewsLocalServiceBaseImpl;
import it.sincon.sanita.services.service.persistence.NewsFinderUtil;
import it.sincon.sanita.services.service.persistence.StrutturaSanitariaFinderUtil;

/**
 * The implementation of the news local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link it.sincon.sanita.services.service.NewsLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Sincon
 * @see it.sincon.sanita.services.service.base.NewsLocalServiceBaseImpl
 * @see it.sincon.sanita.services.service.NewsLocalServiceUtil
 */
public class NewsLocalServiceImpl extends NewsLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link it.sincon.sanita.services.service.NewsLocalServiceUtil} to access the news local service.
     */
	
	protected void deleteAll() throws SystemException{
		runSQL("TRUNCATE TABLE SANITAREST_News;");
	}
	
	public long replaceAll(List<News> newItemsList) throws SystemException{
		int added = 0;

		deleteAll();

		for (News ss : newItemsList){
			ss = NewsLocalServiceUtil.addNews(ss);
			added++;
		}

		return added;
	}
	
	public long searchCount(List<String> listaIdTipoStrutture, String fullText, String locale) throws SystemException{
		return NewsFinderUtil.getSearchCount(listaIdTipoStrutture, fullText, locale);
	}
	
	public List<News> search(
			int start, int numRes,
	        List<String> listaIdTipoStrutture,
	        String fullText, 
	        String locale) throws SystemException{
		
		return NewsFinderUtil.search(
				start, numRes, 
				listaIdTipoStrutture, fullText, 
				locale);
	}
}
