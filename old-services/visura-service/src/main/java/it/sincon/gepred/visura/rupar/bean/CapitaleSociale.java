package it.sincon.gepred.visura.rupar.bean;

import com.google.gson.annotations.SerializedName;

public class CapitaleSociale {

	private Deliberato deliberato;
	
	private Sottoscritto sottoscritto;
	
	private Versato versato;
	
	@SerializedName("c-valuta")
	private String codiceValuta;
	
	private String valuta;

	public Deliberato getDeliberato() {
		return deliberato;
	}

	public void setDeliberato(Deliberato deliberato) {
		this.deliberato = deliberato;
	}

	public Sottoscritto getSottoscritto() {
		return sottoscritto;
	}

	public void setSottoscritto(Sottoscritto sottoscritto) {
		this.sottoscritto = sottoscritto;
	}

	public Versato getVersato() {
		return versato;
	}

	public void setVersato(Versato versato) {
		this.versato = versato;
	}

	public String getCodiceValuta() {
		return codiceValuta;
	}

	public void setCodiceValuta(String codiceValuta) {
		this.codiceValuta = codiceValuta;
	}

	public String getValuta() {
		return valuta;
	}

	public void setValuta(String valuta) {
		this.valuta = valuta;
	}
	
	
}
