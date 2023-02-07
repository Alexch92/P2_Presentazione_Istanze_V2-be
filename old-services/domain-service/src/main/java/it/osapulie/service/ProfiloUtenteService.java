package it.osapulie.service;

import it.osapulie.domain.ProfiloUtente;
import it.osapulie.domain.Ruolo;


import it.sincon.gepred.domain.pratica.CategoriePratiche;
import it.sincon.gepred.web.portlet.varie.DatiRicercaProfiloUtente;

import java.util.List;

public interface ProfiloUtenteService {

	/**
	 * Ritorna la lista di tutti i profili utenti presenti nel sistema.
	 * 
	 * @return
	 * @throws ServiceLayerException
	 */
	public List<ProfiloUtente> getAllProfiloUtenteCittadino() throws ServiceLayerException;
	
	/**
	 * Metodo che restituisce l'elenco dei profili abilitati alle categorie
	 * @param categorie
	 * @return
	 * @throws ServiceLayerException
	 */
	public List<ProfiloUtente> searchProfiliByCategorie(List<CategoriePratiche> categorie) throws ServiceLayerException;

	/**
	 * 
	 * @param filtriRicerca
	 * @return
	 * @throws ServiceLayerException
	 */
	public List<ProfiloUtente> searchProfili(DatiRicercaProfiloUtente filtriRicerca) throws ServiceLayerException;
	
	/**
	 * Ritorna il {@link ProfiloUtente} a partire dalla sua PK.
	 * 
	 * @param pk la pk
	 * @return
	 * @throws ServiceLayerException
	 */
	public ProfiloUtente getProfiloUtenteCittadinoById(long pk) throws ServiceLayerException;
	/**
	 * Ritorna il {@link ProfiloUtente} a partire dalla sua mail.
	 * @param mail
	 * @return ProfiloUtente
	 * @throws ServiceLayerException
	 */
	public ProfiloUtente getProfiloUtenteCittadinoByEmail(String mail) throws ServiceLayerException ;

	/**
	 * Ritorna il {@link ProfiloUtente} a partire dal Codice Fiscale.
	 * 
	 * @param cf
	 * @return
	 * @throws ServiceLayerException
	 */
	public ProfiloUtente getProfiloUtenteCittadinoByCf(String cf) throws ServiceLayerException;
	
	public List<ProfiloUtente> getProfiloUtenteNomeRuolo(String[] nomiRuoli);
	
	public List<ProfiloUtente> getProfiloUtenteRuolo(Ruolo ruolo);
	
	/**
	 * Ritorna la lista di {@link ProfiloUtente} il cui ruolo è uno di quelli passati come parametro
	 * @param ruoli
	 * @return
	 * @throws ServiceLayerException
	 */
	public List<ProfiloUtente> getAllProfiloUtenteByRuolo(List<Ruolo> ruoli) throws ServiceLayerException;
	

	/**
	 * Ritorna un {@link ProfiloUtente} il cui ruolo è uno di quelli passati come parametro
	 * per cui sono attive le credenziali di accesso per il protocollo
	 * @param ruoli
	 * @return
	 * @throws ServiceLayerException
	 */
	public ProfiloUtente getProfiloUtenteProtocolloByRuolo(List<Ruolo> ruoli) throws ServiceLayerException;
	
	/**
	 * Restituisce true se il profiloUtente passato in input ha fra i suoi ruoli, il ruolo di ADMINISTRATOR
	 * @param profiloUtente
	 * @return
	 */
	public boolean isAdmin(ProfiloUtente profiloUtente);
}
