package it.sincon.gepred.visura.rupar.bean;

import com.google.gson.annotations.SerializedName;

public class SedeFuoriProvincia {

	private String value;
	
	@SerializedName("n-rea")
	private String numeroRea;
	
	private String cciaa;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getNumeroRea() {
		return numeroRea;
	}

	public void setNumeroRea(String numeroRea) {
		this.numeroRea = numeroRea;
	}

	public String getCciaa() {
		return cciaa;
	}

	public void setCciaa(String cciaa) {
		this.cciaa = cciaa;
	}
	
	
}
