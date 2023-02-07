package it.sincon.gepred.visura.rupar.bean;

import com.google.gson.annotations.SerializedName;

public class AnagraficaTitolare {

	private String value;
	
	@SerializedName("c-fiscale")
	private String codiceFiscale;
	
	private String denominazione;
	
	private String cognome;
	
	private String nome;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public String getDenominazione() {
		return denominazione;
	}

	public void setDenominazione(String denominazione) {
		this.denominazione = denominazione;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
