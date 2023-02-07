package it.sincon.gepred.visura.rupar.bean;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class ClassificazioniAteco {

    @SerializedName("classificazione-ateco")
    private List<ClassificazioneAteco> classificazioneAteco;
    
    @SerializedName("c-codifica")
    private int codiceCodifica;
    
    private String codifica;

	public List<ClassificazioneAteco> getClassificazioneAteco() {
		return classificazioneAteco;
	}

	public void setClassificazioneAteco(List<ClassificazioneAteco> classificazioneAteco) {
		this.classificazioneAteco = classificazioneAteco;
	}

	public int getCodiceCodifica() {
		return codiceCodifica;
	}

	public void setCodiceCodifica(int codiceCodifica) {
		this.codiceCodifica = codiceCodifica;
	}

	public String getCodifica() {
		return codifica;
	}

	public void setCodifica(String codifica) {
		this.codifica = codifica;
	}

    
}
