package it.sincon.gepred.web.portlet.varie;

import java.io.Serializable;

/**
 * Classe contenente i filtri per la ricerca delle pratiche
 * 
 * @author Eligio Cavallo
 * 
 */
public class DatiRicercaTipoPratica implements Serializable {

	private static final long serialVersionUID = -5591876945721994618L;
	private String filtroDescrizione;
	private String filtroAllegati;
	private String filtroModelli;
	
	public String getFiltroDescrizione() {
		return filtroDescrizione;
	}
	public String getFiltroAllegati() {
		return filtroAllegati;
	}
	public String getFiltroModelli() {
		return filtroModelli;
	}
	public void setFiltroDescrizione(String filtroDescrizione) {
		this.filtroDescrizione = filtroDescrizione;
	}
	public void setFiltroAllegati(String filtroAllegati) {
		this.filtroAllegati = filtroAllegati;
	}
	public void setFiltroModelli(String filtroModelli) {
		this.filtroModelli = filtroModelli;
	}
	
	
}
