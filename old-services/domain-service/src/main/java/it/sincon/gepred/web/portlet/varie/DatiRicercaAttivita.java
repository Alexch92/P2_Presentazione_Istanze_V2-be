package it.sincon.gepred.web.portlet.varie;

/**

 * Classe contenente i filtri per la ricerca delle attività
 * 
 * @author Maria Michela Birtolo
 * 
 */

import java.io.Serializable;

public class DatiRicercaAttivita implements Serializable {

	private static final long serialVersionUID = 7440646430159589242L;

	private String filtroDescrizione;

	public String getFiltroDescrizione() {
		return filtroDescrizione;
	}

	public void setFiltroDescrizione(String filtroDescrizione) {
		this.filtroDescrizione = filtroDescrizione;
	}
	
	
}
