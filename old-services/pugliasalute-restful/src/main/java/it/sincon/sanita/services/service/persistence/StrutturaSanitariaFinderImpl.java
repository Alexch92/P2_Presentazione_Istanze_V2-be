package it.sincon.sanita.services.service.persistence;

import it.sincon.sanita.services.model.StrutturaSanitaria;
import it.sincon.sanita.services.model.impl.StrutturaSanitariaImpl;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;


public class StrutturaSanitariaFinderImpl extends BasePersistenceImpl<StrutturaSanitaria> implements  StrutturaSanitariaFinder{
	
	private static Logger log = LoggerFactory.getLogger( StrutturaSanitariaFinderImpl.class );
	private final ResourceBundle resourceBundle = ResourceBundle.getBundle("portlet");
	
	private static final String _SQL_SEARCH_SS_WITH_DISTANCE_COMPUTE = ""
			+ "SELECT	pk, idstruttura, groupid, idtipostruttura, "
			         + "tipostruttura, tipologia, denominazione, "
			         + "descrizione, immagine, indirizzo, "
			         + "telefono, fax, email, orari, "
			         + "locale, stato, lat, lng, "
			         + "st_distance_sphere(st_geomfromtext('POINT(' || lng || ' ' || lat || ')'), st_geomfromtext('POINT(' || ? || ' ' || ? || ')')) / 1000 as distanza, "
			         + "childrenedottoospedalecollegato, childrenedottoambulatorio, "
			         + "childrenedottounitaoperativa, childrenedottounitaps, relazioneambulatorio "
            + "FROM SANITAREST_StrutturaSanitaria "
            + "WHERE 1 = 1 ";
	private static final String _SQL_SEARCH_SS_WITHOUT_DISTANCE_COMPUTE = ""
			+ "SELECT	pk, idstruttura, groupid, idtipostruttura, "
			         + "tipostruttura, tipologia, denominazione, "
			         + "descrizione, immagine, indirizzo, "
			         + "telefono, fax, email, orari, "
			         + "locale, stato, lat, lng, distanza, "
			         + "childrenedottoospedalecollegato, childrenedottoambulatorio, "
			         + "childrenedottounitaoperativa, childrenedottounitaps, relazioneambulatorio "
            + "FROM SANITAREST_StrutturaSanitaria "
            + "WHERE 1 = 1 ";
	private static final String _SQL_SEARCH_SS_SELECT_COUNT = ""
			+ "SELECT COUNT ( pk ) as search_SScount "
			+ "FROM SANITAREST_StrutturaSanitaria "
			+ "WHERE 1 = 1 ";
	
	private static final String _WHERE_CLAUSE_LOCALE = " AND locale ILIKE '%s' ";
	private static final String _WHERE_CLAUSE_IDTIPOSTRUTTURE = " AND idTipoStruttura IN ";
	private static final String _WHERE_CLAUSE_IDSTRUTTURE = " AND idStruttura IN ";
	private static final String _ORDER_BY_DISTANCE = " ORDER BY distanza ";
	
	public long getSearchCount(
			List<String> listaIdTipoStrutture,
			List<String> listaIdStrutture,
			String fullText,
			String locale)
			throws SystemException{
		long count = 0;
		
		StringBundler queryBuilder = new StringBundler();
        String sql = null;
        Session session = null;
        
        try {
        	// Preparo la query sql...
        	queryBuilder.append(_SQL_SEARCH_SS_SELECT_COUNT);
        	queryBuilder.append(String.format(_WHERE_CLAUSE_LOCALE, locale));

        	if (fullText!= null && !fullText.isEmpty())
        		queryBuilder.append(getFullTextWhereClause(fullText));

        	if (listaIdTipoStrutture != null && !(listaIdTipoStrutture.size()==0))
        		queryBuilder.append(getCategorieWhereClause(listaIdTipoStrutture));
        	
        	if (listaIdStrutture != null && !(listaIdStrutture.size()==0))
        		queryBuilder.append(getStruttureWhereClause(listaIdStrutture));

        	sql = queryBuilder.toString();

        	session = openSession();
        	SQLQuery q = session.createSQLQuery(sql);
        	q.setCacheable(false);
        	q.addScalar("search_SScount", Type.LONG);
        	
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
     * Esegue una ricerca nella tabella SANITA_StrutturaSanitaria sulla base dei parametri
     * passati in input.
     * @param start					: ordinale del primo risultato da restituire
     * @param numRes					: numero di risultati da restituire
     * @param listaIdTipoStrutture	: lista delle tipologie di Strutture su cui fare la ricerca
     * @param fullText				: testo da ricercare nella Denominazione delle Strutture
     * @param mobile_latitude		: Latitudine del dispositivo mobile
     * @param mobile_longitude		: Longitudine del dispositivo mobile
     * @return
     * @throws com.liferay.portal.kernel.exception.SystemException
     */
     public List<StrutturaSanitaria> search(
             int start, int numRes,
             List<String> listaIdTipoStrutture,
             List<String> listaIdStrutture,
             String fullText, 
             Double mobile_latitude, Double mobile_longitude,
             String locale)
             throws SystemException{
    	 
    	 List<StrutturaSanitaria> list = null;
    	 
    	 StringBundler queryBuilder = new StringBundler();
         String sql = null;
         Session session = null;
    	 
         try {
        	 // Preparo la query sql...
	         boolean computeDistance = false;
	         if (mobile_latitude != null && mobile_longitude != null){
	        	 queryBuilder.append(_SQL_SEARCH_SS_WITH_DISTANCE_COMPUTE);
	        	 computeDistance = true;
	         }
	         else
	        	 queryBuilder.append(_SQL_SEARCH_SS_WITHOUT_DISTANCE_COMPUTE);
	         
	         queryBuilder.append(String.format(_WHERE_CLAUSE_LOCALE, locale));
	         
	         if (fullText!= null && !fullText.isEmpty())
	        		queryBuilder.append(getFullTextWhereClause(fullText));
	         
	         if (listaIdTipoStrutture != null && !(listaIdTipoStrutture.size()==0))
	        	 queryBuilder.append(getCategorieWhereClause(listaIdTipoStrutture));
	         
	         if (listaIdStrutture != null && !(listaIdStrutture.size()==0))
	        	 queryBuilder.append(getStruttureWhereClause(listaIdStrutture));
	         
	         if (computeDistance)
	        	 queryBuilder.append(_ORDER_BY_DISTANCE);
	         
	         sql = queryBuilder.toString();
	         
             session = openSession();
             SQLQuery q = session.createSQLQuery(sql);
             q.setCacheable(false);
             q.addEntity("StrutturaSanitaria", StrutturaSanitariaImpl.class);
             
             QueryPos qPos = null;
             if (computeDistance){
            	 qPos = QueryPos.getInstance(q);
            	 qPos.add(mobile_longitude);
            	 qPos.add(mobile_latitude);
             }
             
             // Eseguo la query..
             log.info(String.format("Try to execute query:%s...",sql));
             list = (List<StrutturaSanitaria>) QueryUtil.list(q,getDialect(), start, start + numRes);
             log.info(String.format("Query eseguita. Recuperati %s items.",list.size()));
         } catch (Exception e) {
             throw processException(e);
         } finally {
             closeSession(session);
         }
    	 
         return list;
     }			
     
     private String getCategorieWhereClause(List<String> listaIdTipoStrutture){
    	 String response = _WHERE_CLAUSE_IDTIPOSTRUTTURE + "(";
    	 
    	 int idx=0;
    	 for (idx=0; idx < listaIdTipoStrutture.size() - 1; idx++){
    		 response += String.format("'%s',", listaIdTipoStrutture.get(idx));
    	 }
    	 response += String.format("'%s')", listaIdTipoStrutture.get(listaIdTipoStrutture.size() - 1));
    	 
    	 return response;
     }
     
     private String getStruttureWhereClause(List<String> listaIdStrutture){
    	 String response = _WHERE_CLAUSE_IDSTRUTTURE + "(";
    	 
    	 int idx=0;
    	 for (idx=0; idx < listaIdStrutture.size() - 1; idx++){
    		 response += String.format("'%s',", listaIdStrutture.get(idx));
    	 }
    	 response += String.format("'%s')", listaIdStrutture.get(listaIdStrutture.size() - 1));
    	 
    	 return response;
     }
     
     private String getFullTextWhereClause(String fulltext){
    	 String response  = " AND (";

    	 String cfgSearchColumns = resourceBundle.getString("ss_fulltext_search_columns");
    	 String[] arraySearchColumns = cfgSearchColumns.split(",");
    	 
    	 int lastItemIdx = arraySearchColumns.length - 1;
    	 for (int idx = 0; idx < lastItemIdx; idx++){
    		 response += arraySearchColumns[idx] + " ILIKE '%" + fulltext + "%' OR ";
    	 }
    	 response += arraySearchColumns[lastItemIdx] + " ILIKE '%" + fulltext + "%')";

    	 return response;
     }

}
