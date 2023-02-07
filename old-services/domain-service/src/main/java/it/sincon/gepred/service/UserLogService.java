package it.sincon.gepred.service;

/**
 * @author Eligio Cavallo  
 * */

import java.util.List;

import it.osapulie.domain.ProfiloUtente;
import it.osapulie.service.ServiceLayerException;
import it.sincon.gepred.domain.UserLog;
import it.sincon.gepred.web.portlet.varie.DatiRicercaUserLog;

public interface UserLogService {

	/**
	 * Ricerca le informazioni (eventi) dell'utente loggato 
	 * @param filtriRicerca
	 * @return List<UserLog>
	 * @throws ServiceLayerException
	 */
	List<UserLog> searchUserLog(DatiRicercaUserLog filtriRicerca) throws ServiceLayerException;
	
	/**
	 * Aggiunge le informazioni relative all'utente loggato nel sistema
	 * @param profiloutente
	 * @param operazione
	 * @param oggetto
	 * @throws ServiceLayerException
	 */
	public void saveOperazione(ProfiloUtente profiloutente, String operazione, String oggetto, Long idoggetto, String note) throws ServiceLayerException;

}

