package it.sincon.gepred.visura.rupar.bean;

import com.google.gson.annotations.SerializedName;

public class AlbiRuoliLicenzeRidotti {

	@SerializedName("ruoli-ridotti")
	private RuoloRidotto ruoliRidotti;

	public RuoloRidotto getRuoliRidotti() {
		return ruoliRidotti;
	}

	public void setRuoliRidotti(RuoloRidotto ruoliRidotti) {
		this.ruoliRidotti = ruoliRidotti;
	}
	
	
}
