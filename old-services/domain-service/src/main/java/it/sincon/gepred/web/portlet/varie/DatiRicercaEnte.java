package it.sincon.gepred.web.portlet.varie;

/**
 * Classe contenente il filtro per la ricerca dell'ente
 * 
 * @author Eligio Cavallo
 * 
 */

import it.osapulie.domain.Comune;

import java.io.Serializable;

public class DatiRicercaEnte implements Serializable {

	private static final long serialVersionUID = 1L;

	private String filtroDenominazione;
	private Comune filtroComune ;
	public String getFiltroDenominazione() {
		return filtroDenominazione;
	}
	public Comune getFiltroComune() {
		return filtroComune;
	}
	public void setFiltroDenominazione(String filtroDenominazione) {
		this.filtroDenominazione = filtroDenominazione;
	}
	public void setFiltroComune(Comune filtroComune) {
		this.filtroComune = filtroComune;
	}
	
}
