/*******************************************************************************
 * Copyright (c) 2011, 2012 Link Management & Technology S.p.A. via R. Scotellaro, 55 - 73100 -
 * Lecce - http://www.linksmt.it All rights reserved.
 * 
 * Contributors: Links Management & Technology S.p.A. - initial API and implementation
 *******************************************************************************/
package it.sincon.gepred.service;

import it.osapulie.domain.Comune;
import it.osapulie.service.ServiceLayerException;
import it.sincon.gepred.web.portlet.varie.DatiRicercaComune;

import java.util.List;

/**
 * @author Davide Ciannamea
 * 
 */
public interface GestioneComuneService {

	/**
	 * Ritorna la lista di tutti i comuni presenti nel sistema.
	 * 
	 * @return
	 * @throws ServiceLayerException
	 */
	List<Comune> searchComune(DatiRicercaComune filtriRicerca);
	
	/**
	 * Salva un comune nel sistema.
	 * 
	 * @param pratica
	 * @throws ServiceLayerException
	 */
	public void saveComune(Comune comune) throws ServiceLayerException;
	
	/**
	 * Ritorna un comune a partire dal suo ID.
	 * 
	 * @param pk
	 * @return Pratica
	 * @throws ServiceLayerException
	 */
	public Comune getComuneByPk(long pk) throws ServiceLayerException;
	
	/**
	 * Cancella un comune a partire dal suo ID.
	 * 
	 * @param pk
	 * @throws ServiceLayerException
	 */
	public void deleteComune(long pk) throws ServiceLayerException;

}
