package it.sincon.gepred.visura.rupar.bean;

import com.google.gson.annotations.SerializedName;

public class FormaGiuridica {
	
	@SerializedName(value="value")
	private String value;
	
	@SerializedName(value="c")
	private String codice;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}
	
	

}
