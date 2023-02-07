package it.sincon.gepred.web.portlet.varie;

import java.io.Serializable;

public class DatiRicercaCategoria implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private boolean equal = false;
	private String filtroID;
	private String filtroDescrizione;
	
	public String getFiltroID() {
		return filtroID;
	}
	
	public void setFiltroID(String filtroID) {
		this.filtroID = filtroID;
	}
	
	public String getFiltroDescrizione() {
		return filtroDescrizione;
	}
	
	public void setFiltroDescrizione(String filtroDescrizione) {
		this.filtroDescrizione = filtroDescrizione;
	}

	public boolean isEqual() {
		return equal;
	}

	public void setEqual(boolean equal) {
		this.equal = equal;
	}
	
	
}
