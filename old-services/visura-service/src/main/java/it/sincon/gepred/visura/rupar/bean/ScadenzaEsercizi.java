package it.sincon.gepred.visura.rupar.bean;

import java.util.Date;

import com.google.gson.annotations.SerializedName;

public class ScadenzaEsercizi {

	private String value;
	
	@SerializedName("dt-primo-esercizio")
	private Date dataPrimoEsercizio;
	
	@SerializedName("esercizi-successivi")
	private String eserciziSuccessi;
	
	private int giorniProrogaBilancio;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Date getDataPrimoEsercizio() {
		return dataPrimoEsercizio;
	}

	public void setDataPrimoEsercizio(Date dataPrimoEsercizio) {
		this.dataPrimoEsercizio = dataPrimoEsercizio;
	}

	public String getEserciziSuccessi() {
		return eserciziSuccessi;
	}

	public void setEserciziSuccessi(String eserciziSuccessi) {
		this.eserciziSuccessi = eserciziSuccessi;
	}

	public int getGiorniProrogaBilancio() {
		return giorniProrogaBilancio;
	}

	public void setGiorniProrogaBilancio(int giorniProrogaBilancio) {
		this.giorniProrogaBilancio = giorniProrogaBilancio;
	}
	
	
}
