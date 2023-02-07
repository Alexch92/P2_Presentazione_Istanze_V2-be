package it.sincon.gepred.web.portlet.varie;


import java.io.Serializable;

public class DatiRicercaComune implements Serializable {
	
	private static final long serialVersionUID = 1L;

	String filtroProvincia;
	String filtroDenominazione;
	String filtroCodiceCatastale;
	

	public String getFiltroDenominazione() {
		return filtroDenominazione;
	}
	public void setFiltroDenominazione(String filtroDenominazione) {
		this.filtroDenominazione = filtroDenominazione;
	}
	public String getFiltroProvincia() {
		return filtroProvincia;
	}
	public void setFiltroProvincia(String filtroProvincia) {
		this.filtroProvincia = filtroProvincia;
	}
	public String getFiltroCodiceCatastale() {
		return filtroCodiceCatastale;
	}
	public void setFiltroCodiceCatastale(String filtroCodiceCatastale) {
		this.filtroCodiceCatastale = filtroCodiceCatastale;
	}
	
}
