package it.sincon.gepred.visura.rupar.bean;

import com.google.gson.annotations.SerializedName;

public class SedeFuoriProvinciaWrapper {
	
	@SerializedName("sede-fuori-provincia")
	private SedeFuoriProvincia sedeFuoriProvincia;

	public SedeFuoriProvincia getSedeFuoriProvincia() {
		return sedeFuoriProvincia;
	}

	public void setSedeFuoriProvincia(SedeFuoriProvincia sedeFuoriProvincia) {
		this.sedeFuoriProvincia = sedeFuoriProvincia;
	}
	
	

}
