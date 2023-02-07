package it.sincon.gepred.service;

import java.util.List;
import it.osapulie.service.ServiceLayerException;
import it.sincon.gepred.domain.Referente;
import it.sincon.gepred.web.portlet.varie.DatiRicercaReferente;

/**
 * 
 * @author Davide Ciannamea
 * 
 */
public interface GestioneReferenteService {

	/**
	 * Metodo che recupera l'elenco dei referenti relativi ai parametri di ricerca inseriti
	 * @param oggetto
	 * @param richiedente
	 * @param numero
	 * @return List<Pratica>
	 */
	List<Referente> searchReferente(DatiRicercaReferente filtriRicerca);
	
	/**
	 * Salva un referente nel sistema.
	 * 
	 * @param pratica
	 * @return 
	 * @throws ServiceLayerException
	 */
	public Referente saveReferente(Referente referente) throws ServiceLayerException, ReferenteDuplicatoException;
	
	/**
	 * Ritorna un referente a partire dal suo ID.
	 * 
	 * @param pk
	 * @return Pratica
	 * @throws ServiceLayerException
	 */
	public Referente getReferenteByPk(long pk) throws ServiceLayerException;
	
	/**
	 * Cancella un referente a partire dal suo ID.
	 * 
	 * @param pk
	 * @throws ServiceLayerException
	 */
	public void deleteReferente(long pk) throws ServiceLayerException;
	
	
}
