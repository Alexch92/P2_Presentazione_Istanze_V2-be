package it.sincon.gepred.visura.rupar.bean;

import com.google.gson.annotations.SerializedName;

public class DirittoPartecipazione {
	
	private String value;
	
	@SerializedName("c-tipo")
	private int codiceTipo;
	
	private String tipo;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int getCodiceTipo() {
		return codiceTipo;
	}

	public void setCodiceTipo(int codiceTipo) {
		this.codiceTipo = codiceTipo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	

}
