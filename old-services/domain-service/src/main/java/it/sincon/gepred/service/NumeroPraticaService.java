/*******************************************************************************
 * Copyright (c) 2011, 2012 Link Management & Technology S.p.A. via R. Scotellaro, 55 - 73100 -
 * Lecce - http://www.linksmt.it All rights reserved.
 * 
 * Contributors: Links Management & Technology S.p.A. - initial API and implementation
 *******************************************************************************/
package it.sincon.gepred.service;

import it.osapulie.service.ServiceLayerException;
import it.sincon.gepred.domain.pratica.NumeroPratica;

/**
 * @author Antonio Santomauro
 * 
 */
public interface NumeroPraticaService {

	/**
	 * Ritorna la lista di tutte le attività presenti nel sistema.
	 * 
	 * @return
	 * @throws ServiceLayerException
	 */
	NumeroPratica getNext(String prefisso, Integer anno);
	
	/**
	 * Salva un' attività nel sistema.
	 * 
	 * @param pratica
	 * @throws ServiceLayerException
	 */
	public NumeroPratica save(NumeroPratica entity);
	
}
