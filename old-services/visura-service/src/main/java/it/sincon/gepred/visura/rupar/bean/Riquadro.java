package it.sincon.gepred.visura.rupar.bean;

import com.google.gson.annotations.SerializedName;

public class Riquadro {

	@SerializedName("composizione-quote")
	private ComposizioneQuote composizioneQuote;
	
	private Titolari titolari;

	public ComposizioneQuote getComposizioneQuote() {
		return composizioneQuote;
	}

	public void setComposizioneQuote(ComposizioneQuote composizioneQuote) {
		this.composizioneQuote = composizioneQuote;
	}

	public Titolari getTitolari() {
		return titolari;
	}

	public void setTitolari(Titolari titolari) {
		this.titolari = titolari;
	}
	
	
}
