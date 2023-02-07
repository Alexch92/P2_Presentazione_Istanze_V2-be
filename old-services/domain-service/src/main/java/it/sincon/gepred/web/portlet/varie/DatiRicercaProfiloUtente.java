package it.sincon.gepred.web.portlet.varie;

import java.io.Serializable;

public class DatiRicercaProfiloUtente  implements Serializable{
	
	private static final long serialVersionUID = -881234567890L;
	private String filtroCognome;
	private String filtroNome;
	private String filtroCodiceFiscale;
	private String filtroMail;
	private String filtroMailPec;
	private String filtroUsername;
	
	public String getFiltroMail() {
		return filtroMail;
	}
	public void setFiltroMail(String filtroMail) {
		this.filtroMail = filtroMail;
	}
	public String getFiltroMailPec() {
		return filtroMailPec;
	}
	public void setFiltroMailPec(String filtroMailPec) {
		this.filtroMailPec = filtroMailPec;
	}
	public String getFiltroUsername() {
		return filtroUsername;
	}
	public void setFiltroUsername(String filtroUsername) {
		this.filtroUsername = filtroUsername;
	}
	public String getFiltroCognome() {
		return filtroCognome;
	}
	public void setFiltroCognome(String filtroCognome) {
		this.filtroCognome = filtroCognome;
	}
	public String getFiltroNome() {
		return filtroNome;
	}
	public void setFiltroNome(String filtroNome) {
		this.filtroNome = filtroNome;
	}
	public String getFiltroCodiceFiscale() {
		return filtroCodiceFiscale;
	}
	public void setFiltroCodiceFiscale(String filtroCodiceFiscale) {
		this.filtroCodiceFiscale = filtroCodiceFiscale;
	}
	
	
}

