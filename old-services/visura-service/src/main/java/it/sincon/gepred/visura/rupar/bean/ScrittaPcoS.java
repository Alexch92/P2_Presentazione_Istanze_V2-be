package it.sincon.gepred.visura.rupar.bean;

import com.google.gson.annotations.SerializedName;

public class ScrittaPcoS {

	private String value;
	
	@SerializedName("f-presenza-pco-s")
	private String flagPresenzaPcoS;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getFlagPresenzaPcoS() {
		return flagPresenzaPcoS;
	}

	public void setFlagPresenzaPcoS(String flagPresenzaPcoS) {
		this.flagPresenzaPcoS = flagPresenzaPcoS;
	}
	
	
}
