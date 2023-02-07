package it.sincon.gepred.visura.rupar.bean;

import com.google.gson.annotations.SerializedName;

public class ComposizioneQuote {

	private String value;
	
	@SerializedName("c-tipo")
	private String codiceTipo;
	
	private String tipo;
	
	@SerializedName("n")
	private String numero;
	
	@SerializedName("c-valuta")
	private String codiceValuta;
	
	private String valuta;
	
	@SerializedName("valore-nominale")
	private String valoreNominale;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getCodiceTipo() {
		return codiceTipo;
	}

	public void setCodiceTipo(String codiceTipo) {
		this.codiceTipo = codiceTipo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
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

	public String getValoreNominale() {
		return valoreNominale;
	}

	public void setValoreNominale(String valoreNominale) {
		this.valoreNominale = valoreNominale;
	}
	
	
	
}
