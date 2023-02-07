package it.osapulie.service;

import java.util.List;

import it.osapulie.domain.Ruolo;
import it.sincon.gepred.domain.pratica.CategoriePratiche;

public interface RuoloService {

	/**
	 * Salva un nuovo ruolo
	 * @param ruolo
	 * 
	 */
	public void saveRuolo(Ruolo ruolo);
	
	/**
	 * Recupera un ruolo a partire dall'id
	 * @param pk
	 * @return Ruolo
	 * @throws ServiceLayerException
	 */
	public Ruolo getRuoloById(long pk) throws ServiceLayerException;
	
	/**
	 * Recupera tutti i ruolo
	 * @return List<Ruolo>
	 * @throws ServiceLayerException
	 */
	public List<Ruolo> getAllRuolo() throws ServiceLayerException ;
	
	public List<Ruolo> getRuoloNome(String[] ruoli);

}
