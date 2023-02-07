package it.sincon.gepred.service;
/**
 * @author Eligio Cavallo - Sincon srl 
 * */
import java.util.List;
import it.osapulie.service.ServiceLayerException;
import it.sincon.gepred.domain.Immobile;
import it.sincon.gepred.web.portlet.varie.DatiRicercaImmobile;


public interface GestioneImmobileService {


/**
	 * Ritorna l'immobile/i a partire dai dati inseriti.
	 * 
	 * @param filtriRicerca
	 * @return List<Immobile>
	 * @throws ServiceLayerException
	 */
	
	List<Immobile> getImmobili(DatiRicercaImmobile filtriRicerca) throws ServiceLayerException;
	
	/**
	 * Aggiunge l'Immobile al sistema
	 * 
	 * @param Immobile
	 * @throws ServiceLayerException
	 */
	public void saveImmobile(Immobile immobile) throws ServiceLayerException;
	/**
	 * Elimina  l'Immobile dal sistema.
	 * 
	 * @param pk
	 * @throws ServiceLayerException
	 */	
	public void deleteImmobile(long pk) throws ServiceLayerException;
	/**
	 * Ritorna l'Immobile a partire dal suo id.
	 * 
	 * @param pk
	 * @return Immobile
	 * @throws ServiceLayerException
	 */
	public Immobile getImmobileByPk(long pk)throws ServiceLayerException;

}

