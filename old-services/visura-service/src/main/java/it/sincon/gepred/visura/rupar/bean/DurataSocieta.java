package it.sincon.gepred.visura.rupar.bean;

import java.util.Date;

import com.google.gson.annotations.SerializedName;

public class DurataSocieta {

	@SerializedName("scadenza-esercizi")
	private ScadenzaEsercizi esercizi;
	
	@SerializedName("dt-termine")
	private Date dateTermine;

	public ScadenzaEsercizi getEsercizi() {
		return esercizi;
	}

	public void setEsercizi(ScadenzaEsercizi esercizi) {
		this.esercizi = esercizi;
	}

	public Date getDateTermine() {
		return dateTermine;
	}

	public void setDateTermine(Date dateTermine) {
		this.dateTermine = dateTermine;
	}
	
	
	
	
}
