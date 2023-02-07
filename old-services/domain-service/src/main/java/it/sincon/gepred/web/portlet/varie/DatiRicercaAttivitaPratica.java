package it.sincon.gepred.web.portlet.varie;

/**

 * Classe contenente i filtri per la ricerca delle attività
 * nella portlet Visualizzazione attività
 * 
 * @author Angelo Pascadopoli
 * 
 */

import java.io.Serializable;

public class DatiRicercaAttivitaPratica implements Serializable {

	private static final long serialVersionUID = 1L;

	private String filtroDescrizione;
	private String filtroCompletamento;
	private Long filtroUtente;

	
	public String getFiltroDescrizione() {
		return filtroDescrizione;
	}

	public void setFiltroDescrizione(String filtroDescrizione) {
		this.filtroDescrizione = filtroDescrizione;
	}

	public String getFiltroCompletamento() {
		return filtroCompletamento;
	}

	public void setFiltroCompletamento(String filtroCompletamento) {
		this.filtroCompletamento = filtroCompletamento;
	}

	public Long getFiltroUtente() {
		return filtroUtente;
	}

	public void setFiltroUtente(Long filtroUtente) {
		this.filtroUtente = filtroUtente;
	}
}