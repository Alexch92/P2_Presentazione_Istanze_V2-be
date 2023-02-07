package it.sincon.gepred.service.impl;

import java.util.List;
import it.osapulie.domain.ProfiloUtente;
import it.osapulie.infrastructure.impl.DateUtils;
import it.osapulie.service.ServiceLayerException;
import it.sincon.gepred.domain.UserLog;
import it.sincon.gepred.persistence.UserLogRepository;
import it.sincon.gepred.service.UserLogService;
import it.sincon.gepred.web.portlet.varie.DatiRicercaUserLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * @author Eligio Cavallo 
* */

@Service("gestioneUserLogService")
public class UserLogServiceImpl implements UserLogService{

	@PersistenceContext(unitName="gepred")
	private EntityManager entity;
	
	private static Logger log = LoggerFactory.getLogger(UserLogServiceImpl.class);

	@Inject
	private UserLogRepository userLogRepository;
	
	/**
	 * Ritorna la lista di utenti che hanno utilizzato il sistema a partire dai dati di ricerca.
	 * 
	 * @param filtriRicerca
	 * @return List<UserLog>
	 * @throws ServiceLayerException
	 * @throws ParseException 
	 */
	
	public List<UserLog> searchUserLog(DatiRicercaUserLog filtriRicerca)throws ServiceLayerException{
		log.debug("searchUserLog :: entering method");
		String query_String = "select ul from UserLog ul where 1=1";
		
		if(filtriRicerca.getFiltroProfiloUtente()!=null && !filtriRicerca.getFiltroProfiloUtente().equals("")){
			query_String += " AND ul.profiloutente.id =?1";
		}
		if (filtriRicerca.getFiltrotipooperazione()!= null && !filtriRicerca.getFiltrotipooperazione().equals("")) {
			query_String += " AND lower(ul.tipooperazione) LIKE lower(?2)";
		}
		if(filtriRicerca.getFiltroData_da()!= null  && !filtriRicerca.getFiltroData_da().equals("")){
				query_String += " AND (ul.data)>=(?3) ";
		}
		if(filtriRicerca.getFiltroData_a()!= null  && !filtriRicerca.getFiltroData_a().equals("")){
				query_String += " AND (ul.data)<=(?4) ";
		}
		Query query = entity.createQuery(query_String , UserLog.class);
		
		if (filtriRicerca.getFiltroProfiloUtente()!= null && !filtriRicerca.getFiltroProfiloUtente().equals("")){
			query.setParameter(1,filtriRicerca.getFiltroProfiloUtente());
		}
		if (filtriRicerca.getFiltrotipooperazione()!= null && !filtriRicerca.getFiltrotipooperazione().equals("")) {
			query.setParameter(2, "%" + filtriRicerca.getFiltrotipooperazione().toLowerCase() + "%");
		}
		if(filtriRicerca.getFiltroData_da()!= null  && !filtriRicerca.getFiltroData_da().equals("")){
			query.setParameter(3,DateUtils.getData(filtriRicerca.getFiltroData_da()));
		}
		if(filtriRicerca.getFiltroData_a()!= null  && !filtriRicerca.getFiltroData_a().equals("")){
			query.setParameter(4,DateUtils.getData(filtriRicerca.getFiltroData_a()));
		}		
		return  (List<UserLog>)query.getResultList();
	}
	
	@Override
	public void saveOperazione(ProfiloUtente profiloutente, String operazione, String oggetto, Long idoggetto, String note) throws ServiceLayerException{
		log.debug("saveUserLog :: entering method ");
		try {
			UserLog userLog=new UserLog();
			userLog.setProfiloutente(profiloutente);
			userLog.setTipooperazione(operazione);
			userLog.setOggettooperazione(oggetto);
			userLog.setIdoggettooperazione(idoggetto);
			userLog.setNote(note);
			userLog.setData(DateUtils.getOggi());
			userLogRepository.save(userLog);
			}
		catch (Exception e) {
			throw new ServiceLayerException("There was an error when saving an object of type userlog :: " + e.getMessage(), e);
			}
		}
}
