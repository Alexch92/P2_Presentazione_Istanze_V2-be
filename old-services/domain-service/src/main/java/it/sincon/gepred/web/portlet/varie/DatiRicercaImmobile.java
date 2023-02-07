package it.sincon.gepred.web.portlet.varie;

/**
 * Classe contenente il filtro per la ricerca dell'immobile
 * 
 * @author Eligio Cavallo
 * 
 */

import it.osapulie.domain.Comune;

import java.io.Serializable;

public class DatiRicercaImmobile implements Serializable{

	private static final long serialVersionUID 	= 1L;
	
	private String filtroDenominazione;
	private Comune filtroComune ;
	private String filtroIndirizzo;
	private String filtroCap;
	private String filtroTipologia;
	private Integer filtroFoglio;
	private Integer filtroParticella;
	private Integer filtroSubalterno;
	
	public String getFiltroDenominazione() {
		return filtroDenominazione;
	}
	public Comune getFiltroComune() {
		return filtroComune;
	}
	public String getFiltroIndirizzo() {
		return filtroIndirizzo;
	}
	public String getFiltroCap() {
		return filtroCap;
	}
	public String getFiltroTipologia() {
		return filtroTipologia;
	}
	public Integer getFiltroFoglio() {
		return filtroFoglio;
	}
	public Integer getFiltroParticella() {
		return filtroParticella;
	}
	public Integer getFiltroSubalterno() {
		return filtroSubalterno;
	}
	public void setFiltroDenominazione(String filtroDenominazione) {
		this.filtroDenominazione = filtroDenominazione;
	}
	public void setFiltroComune(Comune filtroComune) {
		this.filtroComune = filtroComune;
	}
	public void setFiltroIndirizzo(String filtroIndirizzo) {
		this.filtroIndirizzo = filtroIndirizzo;
	}
	public void setFiltroCap(String filtroCap) {
		this.filtroCap = filtroCap;
	}
	public void setFiltroTipologia(String filtroTipologia) {
		this.filtroTipologia = filtroTipologia;
	}
	public void setFiltroFoglio(Integer filtroFoglio) {
		this.filtroFoglio = filtroFoglio;
	}
	public void setFiltroParticella(Integer filtroParticella) {
		this.filtroParticella = filtroParticella;
	}
	public void setFiltroSubalterno(Integer filtroSubalterno) {
		this.filtroSubalterno = filtroSubalterno;
	}
}