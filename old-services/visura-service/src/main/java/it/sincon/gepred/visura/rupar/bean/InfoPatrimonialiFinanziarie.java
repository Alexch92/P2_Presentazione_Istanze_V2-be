package it.sincon.gepred.visura.rupar.bean;

import com.google.gson.annotations.SerializedName;

public class InfoPatrimonialiFinanziarie {

	@SerializedName("capitale-sociale")
	private CapitaleSociale capitaleSociale;

	public CapitaleSociale getCapitaleSociale() {
		return capitaleSociale;
	}

	public void setCapitaleSociale(CapitaleSociale capitaleSociale) {
		this.capitaleSociale = capitaleSociale;
	}
	
	
}
