package it.sincon.sanita.scheduler;

import it.sincon.sanita.services.service.SanitaRESTfullService;
import it.sincon.sanita.services.service.impl.SanitaRESTfullServiceImpl;
import it.sincon.sanita.services.model.News;
import it.sincon.sanita.services.model.StrutturaSanitaria;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.Lock;
import com.liferay.portal.service.LockLocalServiceUtil;

@Service
public class AggiornaRestDataTask  {
	
	private static Logger log = LoggerFactory.getLogger( AggiornaRestDataTask.class );
	private final ResourceBundle resourceBundle = ResourceBundle.getBundle("portlet");

	protected SanitaRESTfullService sanitaRESTfullService;
	
	public AggiornaRestDataTask(){}
	
	public void updateStrutturaSanitaria(){
		String className = StrutturaSanitaria.class.getName();
		String taskKey = resourceBundle.getString("sched.update_ss.task_key");
		long savedItems = 0;
		
		// sleep di un numero casuale di millisec per la sincronizzazione con l'altro nodo...
		long sleepForMs = new Random().nextInt(1000);
		try {
			log.info(String.format("waiting for %s millisec...", sleepForMs));
			Thread.sleep(sleepForMs);
		} catch (InterruptedException e1) {
			log.error(e1.getMessage(), e1);
		}
		
		try {
		    if (LockLocalServiceUtil.isLocked(className, taskKey)) {
		    	log.info("----- Update StrutturaSanitaria Task in esecuzione su altro nodo!! -----");
		        return;
		    }
		    Lock lock = LockLocalServiceUtil.lock(className,  taskKey, taskKey);
		    log.info(String.format("lock acquisito: id:%s - key:%s - className:%s", lock.getLockId(), lock.getKey(), lock.getClassName()));

		    // do your job
		    try{
		    	List<StrutturaSanitaria> listaStrutture = new ArrayList<StrutturaSanitaria>();
		    	log.info("---------------- Retrieve StrutturaSanitaria (it_IT) - START !!! -----------");
		    	savedItems = getSanitaRESTfullService().aggiornaStruttureSanitarie(listaStrutture, new Locale("it_IT"));
		    	log.info(String.format("----- Retrieve StrutturaSanitaria (it_IT) - E N D !!! Saved %s ITEMS -----", savedItems));
		    	
		    	log.info("---------------- Retrieve StrutturaSanitaria (en_EN) - START !!! -----------");
		    	savedItems = getSanitaRESTfullService().aggiornaStruttureSanitarie(listaStrutture, new Locale("en_EN"));
		    	log.info(String.format("----- Retrieve StrutturaSanitaria (en_EN) - E N D !!! Saved %s ITEMS -----", savedItems));
		    	
		    	getSanitaRESTfullService().storeStruttureSanitarie(listaStrutture);
		    }catch (SystemException e) {
		    	log.error(e.getMessage(), e);
		    }
		    
		}catch (SystemException e) {
	    	log.error(e.getMessage(), e);
		}finally {
		    try {
				LockLocalServiceUtil.unlock(className, taskKey);
				log.info(String.format("lock rilasciato: key:%s - className:%s", taskKey, className));
			} catch (SystemException e) {
				log.error(e.getMessage(), e);
			}
		}
	}
	
	public void updateNews(){
		String className = News.class.getName();
		String taskKey = resourceBundle.getString("sched.update_news.task_key");
		long savedItems = 0;
		
		// sleep di un numero casuale di millisec per la sincronizzazione con l'altro nodo...
		long sleepForMs = new Random().nextInt(10000);
		try {
			log.info(String.format("waiting for %s millisec...", sleepForMs));
			Thread.sleep(sleepForMs);
		} catch (InterruptedException e1) {
			log.error(e1.getMessage(), e1);
		}
		
		try {
		    if (LockLocalServiceUtil.isLocked(className, taskKey)) {
		    	log.info("----- Update News Task in esecuzione su altro nodo!! -----");
		        return;
		    }
		    Lock lock = LockLocalServiceUtil.lock(className,  taskKey, taskKey);
		    log.info(String.format("lock acquisito: id:%s - key:%s - className:%s", lock.getLockId(), lock.getKey(), lock.getClassName()));

		    // do your job
		    try{
		    	List<News> listaNews = new ArrayList<News>();
		    	log.info("---------------- Retrieve News (it_IT) - START !!! -----------");
		    	savedItems = getSanitaRESTfullService().aggiornaNews(listaNews, new Locale("it_IT"));
		    	log.info(String.format("----- Retrieve News (it_IT) - E N D !!! Saved %s ITEMS -----", savedItems));
		    	
		    	log.info("---------------- Retrieve News (en_EN) - START !!! -----------");
		    	savedItems = getSanitaRESTfullService().aggiornaNews(listaNews, new Locale("en_EN"));
		    	log.info(String.format("----- Retrieve News (en_EN) - E N D !!! Saved %s ITEMS -----", savedItems));
		    	
		    	getSanitaRESTfullService().storeNews(listaNews);
		    }catch (SystemException e) {
		    	log.error(e.getMessage(), e);
		    }
		    
		}catch (SystemException e) {
	    	log.error(e.getMessage(), e);
		}finally {
		    try {
				LockLocalServiceUtil.unlock(className, taskKey);
			} catch (SystemException e) {
				log.error(e.getMessage(), e);
			}
		}
	}
	
	private SanitaRESTfullService getSanitaRESTfullService(){
		if (sanitaRESTfullService==null){
			sanitaRESTfullService = new SanitaRESTfullServiceImpl();
		}

		return sanitaRESTfullService;
	}

}
