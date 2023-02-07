/*******************************************************************************
 * Copyright (c) 2011, 2012 Link Management & Technology S.p.A. via R. Scotellaro, 55 - 73100 -
 * Lecce - http://www.linksmt.it All rights reserved.
 * 
 * Contributors: Links Management & Technology S.p.A. - initial API and implementation
 *******************************************************************************/
package it.sincon.gepred.service;

import it.osapulie.service.ServiceLayerException;
import it.sincon.gepred.domain.pratica.Qualifica;
import it.sincon.gepred.web.portlet.varie.DatiRicercaQualifica;

import java.util.List;

/**
 * @author Maria Michela Birtolo
 * 
 */
public interface GestioneQualificaService {

	/**
	 * Ritorna la lista di tutte le Qualifiche presenti nel sistema.
	 * 
	 * @return
	 * @throws ServiceLayerException
	 */
	List<Qualifica> searchQualifica(DatiRicercaQualifica filtriRicerca);
	
	/**
	 * Salva un' Qualifica nel sistema.
	 * 
	 * @param pratica
	 * @throws ServiceLayerException
	 */
	public void saveQualifica(Qualifica qualifica) throws ServiceLayerException;
	
	/**
	 * Ritorna un' Qualifica a partire dal suo ID.
	 * 
	 * @param pk
	 * @return Qualifica
	 * @throws ServiceLayerException
	 */
	public Qualifica getQualificaByPk(long pk) throws ServiceLayerException;
	
	/**
	 * Cancella un' Qualifica a partire dal suo ID.
	 * 
	 * @param pk
	 * @throws ServiceLayerException
	 */
	public void deleteQualifica(long pk) throws ServiceLayerException;

}
