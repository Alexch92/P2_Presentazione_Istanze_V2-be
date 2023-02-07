package it.sincon.gepred.visura.rupar.bean;

import com.google.gson.annotations.SerializedName;

public class IndirizzoLocalizzazioneWrapper {

	@SerializedName("indirizzo-localizzazione")
	private IndirizzoLocalizzazione indirizzoLocalizzazione;

	public IndirizzoLocalizzazione getIndirizzoLocalizzazione() {
		return indirizzoLocalizzazione;
	}

	public void setIndirizzoLocalizzazione(IndirizzoLocalizzazione indirizzoLocalizzazione) {
		this.indirizzoLocalizzazione = indirizzoLocalizzazione;
	}
	
	
}
