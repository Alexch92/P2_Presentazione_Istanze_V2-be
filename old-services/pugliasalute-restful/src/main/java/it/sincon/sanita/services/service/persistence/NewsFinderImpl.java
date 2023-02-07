package it.sincon.sanita.services.service.persistence;

import it.sincon.sanita.services.model.News;
import it.sincon.sanita.services.model.impl.NewsImpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;


public class NewsFinderImpl extends BasePersistenceImpl<News> implements  NewsFinder{
	
	private static Logger log = LoggerFactory.getLogger( NewsFinderImpl.class );
	
	private static final String _SQL_SEARCH_NEWS = ""
			+ "SELECT	pk, idNews, idAzienda, "
			         + "titolo, immagine, descrizione, "
			         + "dataPubblicazione, autore, locale "
            + "FROM SANITAREST_News "
            + "WHERE 1 = 1 ";
	private static final String _SQL_SEARCH_NEWS_SELECT_COUNT = ""
			+ "SELECT COUNT ( pk ) as search_count "
			+ "FROM SANITAREST_News "
			+ "WHERE 1 = 1 ";
	
	private static final String _WHERE_CLAUSE_LOCALE = " AND locale ILIKE '%s' ";
	private static final String _WHERE_CLAUSE_IDAZIENDA = " AND idAzienda IN ";
	private static final String _WHERE_CLAUSE_FULLTEXTSEARCH_FORMAT = " AND titolo ILIKE '%?%' ";
	private static final String _ORDER_BY_DATA_PUBBLICAZIONE = " ORDER BY dataPubblicazione DESC ";
	
	public long getSearchCount(
			List<String> listaAziende,
			String fullText,
			String locale)
			throws SystemException{
		long count = 0;
		
		StringBundler queryBuilder = new StringBundler();
        String sql = null;
        Session session = null;
        
        try {
        	// Preparo la query sql...
        	queryBuilder.append(_SQL_SEARCH_NEWS_SELECT_COUNT);
        	queryBuilder.append(String.format(_WHERE_CLAUSE_LOCALE, locale));

        	if (fullText!= null && !fullText.isEmpty())
        		queryBuilder.append(_WHERE_CLAUSE_FULLTEXTSEARCH_FORMAT.replace("?", fullText));

        	if (listaAziende != null && !(listaAziende.size()==0))
        		queryBuilder.append(getCategorieWhereClause(listaAziende));

        	sql = queryBuilder.toString();

        	session = openSession();
        	SQLQuery q = session.createSQLQuery(sql);
        	q.setCacheable(false);
        	q.addScalar("search_count", Type.LONG);
        	
        	// Eseguo la query..
        	log.info(String.format("Try to execute query:%s...",sql));
        	List sqlResult = (List)q.list();
        	count = (Long) sqlResult.get(0);
        	log.info(String.format("Query eseguita. Count = %s.",count));
        } catch (Exception e) {
        	throw processException(e);
        } finally {
        	closeSession(session);
        }

        return count;
	}
	
	/**
     * Esegue una ricerca nella tabella SANITA_News sulla base dei parametri
     * passati in input.
     * @param start					: ordinale del primo risultato da restituire
     * @param numRes					: numero di risultati da restituire
     * @param listaIdAziende	: lista delle tipologie di Strutture su cui fare la ricerca
     * @param fullText				: testo da ricercare nella Denominazione delle Strutture
     * @return
     * @throws com.liferay.portal.kernel.exception.SystemException
     */
     public List<News> search(
             int start, int numRes,
             List<String> listaIdAziende,
             String fullText, 
             String locale)
             throws SystemException{
    	 
    	 List<News> list = null;
    	 
    	 StringBundler queryBuilder = new StringBundler();
         String sql = null;
         Session session = null;
    	 
         try {
        	 // Preparo la query sql...
	         queryBuilder.append(_SQL_SEARCH_NEWS);
	         
	         queryBuilder.append(String.format(_WHERE_CLAUSE_LOCALE, locale));
	         
	         if (fullText!= null && !fullText.isEmpty())
	        	 queryBuilder.append(_WHERE_CLAUSE_FULLTEXTSEARCH_FORMAT.replace("?", fullText));
	         
	         if (listaIdAziende != null && !(listaIdAziende.size()==0))
	        	 queryBuilder.append(getCategorieWhereClause(listaIdAziende));
	         
	         queryBuilder.append(_ORDER_BY_DATA_PUBBLICAZIONE);
	         
	         sql = queryBuilder.toString();
	         
             session = openSession();
             SQLQuery q = session.createSQLQuery(sql);
             q.setCacheable(false);
             q.addEntity("News", NewsImpl.class);
             
             // Eseguo la query..
             log.info(String.format("Try to execute query:%s...",sql));
             list = (List<News>) QueryUtil.list(q,getDialect(), start, start + numRes);
             log.info(String.format("Query eseguita. Recuperati %s items.",list.size()));
         } catch (Exception e) {
             throw processException(e);
         } finally {
             closeSession(session);
         }
    	 
         return list;
     }			
     
     private String getCategorieWhereClause(List<String> listaIdAziende){
    	 String response = _WHERE_CLAUSE_IDAZIENDA + "(";
    	 
    	 int idx=0;
    	 for (idx=0; idx < listaIdAziende.size() - 1; idx++){
    		 response += String.format("'%s',", listaIdAziende.get(idx));
    	 }
    	 response += String.format("'%s')", listaIdAziende.get(listaIdAziende.size() - 1));
    	 
    	 return response;
     }

}
