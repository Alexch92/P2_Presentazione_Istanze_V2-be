package it.sincon.gepred.web.portlet.varie;

import java.io.Serializable;
import java.util.List;

import it.sincon.gepred.domain.pratica.Azienda;

public class DatiSelezioneAzienda  implements Serializable{
	
	private static final long serialVersionUID = -881234567890L;
	private long selectedAziendaID;
	private List<Azienda> aziende;
	private String filtroDenominazione;
	private String filtroPartitaIva;
	
	
	public long getSelectedAziendaID() {
		return selectedAziendaID;
	}
	public void setSelectedAziendaID(long selectedAziendaID) {
		this.selectedAziendaID = selectedAziendaID;
	}
	public List<Azienda> getAziende() {
		return aziende;
	}
	public void setAziende(List<Azienda> aziende) {
		this.aziende = aziende;
	}
	public String getFiltroDenominazione() {
		return filtroDenominazione;
	}
	public void setFiltroDenominazione(String filtroDenominazione) {
		this.filtroDenominazione = filtroDenominazione;
	}
	public String getFiltroPartitaIva() {
		return filtroPartitaIva;
	}
	public void setFiltroPartitaIva(String filtroPartitaIva) {
		this.filtroPartitaIva = filtroPartitaIva;
	}
}

