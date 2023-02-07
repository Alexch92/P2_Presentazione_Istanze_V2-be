package it.sincon.gepred.visura.rupar.bean;

import com.google.gson.annotations.SerializedName;

public class ClassificazioneAtecoWrapper {

	@SerializedName("classificazioni-ateco")
	private ClassificazioniAteco classificazioniAteco;

	public ClassificazioniAteco getClassificazioniAteco() {
		return classificazioniAteco;
	}

	public void setClassificazioniAteco(ClassificazioniAteco classificazioniAteco) {
		this.classificazioniAteco = classificazioniAteco;
	}
}
