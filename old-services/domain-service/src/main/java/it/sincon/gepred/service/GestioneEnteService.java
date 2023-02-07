package it.sincon.gepred.service;
/**
 * @author Eligio Cavallo - Sincon srl 
 * */
import java.util.List;
import it.osapulie.service.ServiceLayerException;
import it.sincon.gepred.domain.Ente;
import it.sincon.gepred.web.portlet.varie.DatiRicercaEnte;


public interface GestioneEnteService 
{
	/**
	 * Ritorna l'ente/i a partire dalla sua denominazione.
	 * 
	 * @param denominazione
	 * @return List<Ente>
	 * @throws ServiceLayerException
	 */
	List<Ente> getEnteByDenominazione(DatiRicercaEnte filtriRicerca) throws ServiceLayerException;
	/**
	 * Aggiunge l'ente al sistema
	 * 
	 * @param ente
	 * @return Ente
	 * @throws ServiceLayerException
	 */
	public void saveEnte(Ente ente) throws ServiceLayerException;
	/**
	 * Elimina  l'ente dal sistema.
	 * 
	 * @param ente
	 * @throws ServiceLayerException
	 */	
	public void deleteEnte(long pk) throws ServiceLayerException;
	/**
	 * Ritorna l'ente a partire dal suo id.
	 * 
	 * @param id
	 * @return Ente
	 * @throws ServiceLayerException
	 */
	public Ente getEnteByPk(long pk)throws ServiceLayerException;

}

