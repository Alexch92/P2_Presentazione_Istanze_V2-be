package it.sincon.gepred.visura.rupar.bean;

import com.google.gson.annotations.SerializedName;

public class InfoStatuto {

	@SerializedName("durata-societa")
	private DurataSocieta durataSocieta;

	public DurataSocieta getDurataSocieta() {
		return durataSocieta;
	}

	public void setDurataSocieta(DurataSocieta durataSocieta) {
		this.durataSocieta = durataSocieta;
	}
	
}
