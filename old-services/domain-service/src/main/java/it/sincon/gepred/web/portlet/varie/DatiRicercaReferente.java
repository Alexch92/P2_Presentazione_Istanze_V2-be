package it.sincon.gepred.web.portlet.varie;

import it.osapulie.domain.Comune;

import java.io.Serializable;

public class DatiRicercaReferente implements Serializable {

	private static final long serialVersionUID = 1L;

	private String filtroNominativo;
	private String filtroTipologia;
	private Comune filtroComune;

	public String getFiltroNominativo() {
		return filtroNominativo;
	}

	public void setFiltroNominativo(String filtroNominativo) {
		this.filtroNominativo = filtroNominativo;
	}

	public String getFiltroTipologia() {
		return filtroTipologia;
	}

	public void setFiltroTipologia(String filtroTipologia) {
		this.filtroTipologia = filtroTipologia;
	}

	public Comune getFiltroComune() {
		return this.filtroComune;
	}
	public void setFiltroComune(Comune filtroComune) {
		this.filtroComune = filtroComune;
	}


}
