/*******************************************************************************
 * Copyright (c) 2011, 2012 Link Management & Technology S.p.A. via R. Scotellaro, 55 - 73100 -
 * Lecce - http://www.linksmt.it All rights reserved.
 * 
 * Contributors: Links Management & Technology S.p.A. - initial API and implementation
 *******************************************************************************/
package it.sincon.gepred.service;

import it.osapulie.service.ServiceLayerException;
import it.sincon.gepred.domain.Attivita;
import it.sincon.gepred.web.portlet.varie.DatiRicercaAttivita;

import java.util.List;

/**
 * @author Maria Michela Birtolo
 * 
 */
public interface GestioneAttivitaService {

	/**
	 * Ritorna la lista di tutte le attività presenti nel sistema.
	 * 
	 * @return
	 * @throws ServiceLayerException
	 */
	List<Attivita> searchAttivita(DatiRicercaAttivita filtriRicerca);
	
	/**
	 * Salva un' attività nel sistema.
	 * 
	 * @param pratica
	 * @throws ServiceLayerException
	 */
	public void saveAttivita(Attivita attivita) throws ServiceLayerException;
	
	/**
	 * Ritorna un' Attività a partire dal suo ID.
	 * 
	 * @param pk
	 * @return Attivita
	 * @throws ServiceLayerException
	 */
	public Attivita getAttivitaByPk(long pk) throws ServiceLayerException;
	
	/**
	 * Cancella un' Attività a partire dal suo ID.
	 * 
	 * @param pk
	 * @throws ServiceLayerException
	 */
	public void deleteAttivita(long pk) throws ServiceLayerException;

}
