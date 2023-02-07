package it.sincon.gepred.service;

import java.io.File;
import java.io.Serializable;
import java.util.List;
import java.util.SortedMap;


import it.osapulie.service.ServiceLayerException;
import it.sincon.gepred.domain.pratica.FascicoloTemporaneo;

/**
 * 
 * @author Maria Michela Birtolo
 * 
 */
public interface GestioneFascicoliTemporaneiService {
	
	/**
	 * Salva una pratica nel sistema.
	 * 
	 * @param pratica
	 * @throws ServiceLayerException
	 */
	public FascicoloTemporaneo saveFascicolo(FascicoloTemporaneo fascicolo) throws ServiceLayerException;
	
	/**
	 * Ritorna la pratica a partire dal suo ID.
	 * 
	 * @param pk
	 * @return Pratica
	 * @throws ServiceLayerException
	 */
	public FascicoloTemporaneo getFascicoloByPk(long pk) throws ServiceLayerException;
	
	/**
	 * Cancella la pratica a partire dal suo ID.
	 * 
	 * @param pk
	 * @throws ServiceLayerException
	 */
	public void deleteFascicolo(FascicoloTemporaneo fascicolo) throws ServiceLayerException;
	
	
}
