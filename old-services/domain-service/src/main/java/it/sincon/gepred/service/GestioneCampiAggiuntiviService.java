package it.sincon.gepred.service;

import java.util.List;

import it.osapulie.service.ServiceLayerException;
import it.sincon.gepred.domain.CampiAggiuntivi;
import it.sincon.gepred.web.portlet.varie.DatiRicercaCampiAggiuntivi;

/**
 * 
 * @author Eligio Cavallo
 * 
 */

public interface GestioneCampiAggiuntiviService {

	/**
	 * Metodo che recupera l'elenco dei CampiAggiuntivi relativi ai parametri di ricerca inseriti
	 * @param filtriRicerca
	 * @return List<CampiAggiuntivi>
	 */
	List<CampiAggiuntivi> searchCampiAggiuntivi(DatiRicercaCampiAggiuntivi filtriRicerca);

	/**
	 * Metodo che recupera l'elenco dei CampiAggiuntivi 
	 * @return List<CampiAggiuntivi>
	 */
	List<CampiAggiuntivi> getAll();

	/**
	 * Salva un Campo Aggiuntivo nel sistema.
	 * 
	 * @param CampiAggiuntivi
	 * @throws ServiceLayerException
	 */
	public void saveCampiAggiuntivi(CampiAggiuntivi campiaggiuntivi) throws ServiceLayerException;
	
	/**
	 * Ritorna la pratica a partire dal suo ID.
	 * 
	 * @param pk
	 * @return Pratica
	 * @throws ServiceLayerException
	 */
	public CampiAggiuntivi getCampiAggiuntiviByPk(long pk) throws ServiceLayerException;
	
	/**
	 * Cancella la pratica a partire dal suo ID.
	 * 
	 * @param pk
	 * @throws ServiceLayerException
	 */
	public void deleteCampiAggiuntivi(long pk) throws ServiceLayerException;
	
	
}
