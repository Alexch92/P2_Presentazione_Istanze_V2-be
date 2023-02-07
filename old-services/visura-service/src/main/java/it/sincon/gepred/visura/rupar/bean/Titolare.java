package it.sincon.gepred.visura.rupar.bean;

import com.google.gson.annotations.SerializedName;

public class Titolare {

	@SerializedName("anagrafica-titolare")
	private AnagraficaTitolare anagraficaTitolare;
	
	@SerializedName("diritto-partecipazione")
	private DirittoPartecipazione dirittoPartecipazione;

	public AnagraficaTitolare getAnagraficaTitolare() {
		return anagraficaTitolare;
	}

	public void setAnagraficaTitolare(AnagraficaTitolare anagraficaTitolare) {
		this.anagraficaTitolare = anagraficaTitolare;
	}

	public DirittoPartecipazione getDirittoPartecipazione() {
		return dirittoPartecipazione;
	}

	public void setDirittoPartecipazione(DirittoPartecipazione dirittoPartecipazione) {
		this.dirittoPartecipazione = dirittoPartecipazione;
	}
	
	
}
