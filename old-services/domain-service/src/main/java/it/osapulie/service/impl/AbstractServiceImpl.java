/*******************************************************************************
 * Copyright (c) 2011, 2012 Link Management & Technology S.p.A. via R. Scotellaro, 55 - 73100 -
 * Lecce - http://www.linksmt.it All rights reserved.
 *
 * Contributors: Links Management & Technology S.p.A. - initial API and implementation
 *******************************************************************************/
package it.osapulie.service.impl;

import it.osapulie.infrastructure.XMLHelper;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Implementazione base per eventuali service classes che usano il {@link PddsIntegration} per
 * richiedere i servizi.
 *
 * @author Maria Michela Birtolo
 */
public class AbstractServiceImpl {

	protected Logger log = LoggerFactory.getLogger(getClass());

	@Inject
	protected XMLHelper xmlHelper;

	/**
	 * Protected c-tor to enforce usage only for derived classes.
	 */
	protected AbstractServiceImpl() {
		// Nothing
	}

	/**
	 * Template method per l'esecuzione di una chiamata RPC al servizio web che funge da adapter per
	 * il PDDS della porta applicativa di un comune.
	 *
	 * @param xmlContent
	 * @param tipoRisposta
	 * @return un oggetto contenente la risposta dal servizio remoto.
	 */
	protected <TR> TR eseguiUnmarshal(byte[] xmlContent , Class<TR> tipoRisposta) {

		String xml = new String(xmlContent);
		log.debug("xml="+xml);
		//String risposta = pddsIntegration.getRichiestaPdd(xmlRichiesta, nomeServizio, uriServizio);

		TR dati = null;
		if (xml != null && !xml.equals("")) {
			dati = xmlHelper.unmarshal(xml, tipoRisposta);
		}

		return dati;
	}

	/**
	 * Template method per l'esecuzione di una chiamata RPC al servizio web che funge da adapter per
	 * il PDDS della porta applicativa di un comune.
	 *
	 * @param xmlContent
	 * @param tipoRisposta
	 * @return un oggetto contenente la risposta dal servizio remoto.
	 */
	protected <T> String eseguiMarshal(T oggetto) {

		log.debug("eseguiMarshal=");
		//String risposta = pddsIntegration.getRichiestaPdd(xmlRichiesta, nomeServizio, uriServizio);

		String dati = null;
		if (oggetto != null ) {
			dati = xmlHelper.marshal(oggetto);
		}

		return dati;
	}
}
