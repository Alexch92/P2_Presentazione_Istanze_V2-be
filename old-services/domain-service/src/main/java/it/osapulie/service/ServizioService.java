package it.osapulie.service;

import it.osapulie.domain.servizi.Servizio;

import java.util.List;

public interface ServizioService {

	/**
	 * Carica un servizio a partire dalla sua PK.
	 * 
	 * @param id
	 * @return
	 * @throws ServiceLayerException
	 */
	public Servizio getServizioById(long id) throws ServiceLayerException;

	/**
	 * Calica la lista di tutti i servizi presenti nel sistema.
	 * 
	 * @return
	 * @throws ServiceLayerException
	 */
	public List<Servizio> getAllServizio() throws ServiceLayerException;

	/**
	 * Carica un servizio a partire dal suo codice servizio.
	 * 
	 * @param codiceServizio
	 * @return
	 * @throws ServiceLayerException
	 */
	public Servizio getServizioByCodiceServizio(String codiceServizio) throws ServiceLayerException;

}
