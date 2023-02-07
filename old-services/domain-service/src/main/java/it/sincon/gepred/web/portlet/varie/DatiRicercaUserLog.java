package it.sincon.gepred.web.portlet.varie;

/**
 * Classe contenente il filtro per la ricerca UserLog
 * 
 * @author Eligio Cavallo
 * 
 */

import it.osapulie.domain.ProfiloUtente;
import java.io.Serializable;

public class DatiRicercaUserLog implements Serializable{

	private static final long serialVersionUID 	= 1L;
	
	private String filtroData_da;
	private String filtroData_a;
	private String filtroProfiloUtente;
	private String filtrotipooperazione;
	
	public String getFiltroData_da() {
		return filtroData_da;
	}
	public String getFiltroData_a() {
		return filtroData_a;
	}
	public String getFiltroProfiloUtente() {
		return filtroProfiloUtente;
	}
	public String getFiltrotipooperazione() {
		return filtrotipooperazione;
	}
	public void setFiltroData_da(String filtroData_da) {
		this.filtroData_da = filtroData_da;
	}
	public void setFiltroData_a(String filtroData_a) {
		this.filtroData_a = filtroData_a;
	}
	public void setFiltroProfiloUtente(String filtroProfiloUtente) {
		this.filtroProfiloUtente = filtroProfiloUtente;
	}
	public void setFiltrotipooperazione(String filtrotipooperazione) {
		this.filtrotipooperazione = filtrotipooperazione;
	}
}