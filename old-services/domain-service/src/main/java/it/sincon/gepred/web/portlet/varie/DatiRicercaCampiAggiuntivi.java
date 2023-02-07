package it.sincon.gepred.web.portlet.varie;

/**
 * Classe contenente i filtri per la ricerca dei campi aggiuntivi
 * 
 * @author Eligio Cavallo
 * 
 */

import it.sincon.gepred.domain.pratica.TipoPratica;

import java.io.Serializable;

public class DatiRicercaCampiAggiuntivi implements Serializable {

	private static final long serialVersionUID = 7440646430159589242L;

	private String filtroLabel;
	private String filtroTipoPratica;
	
	public String getFiltroLabel() {
		return filtroLabel;
	}

	public void setFiltroLabel(String filtroLabel) {
		this.filtroLabel = filtroLabel;
	}

	public String getFiltroTipoPratica() {
		return filtroTipoPratica;
	}

	public void setFiltroTipoPratica(String filtroTipoPratica) {
		this.filtroTipoPratica = filtroTipoPratica;
	}


}
