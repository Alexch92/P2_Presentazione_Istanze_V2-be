package it.sincon.gepred.visura.rupar.bean;

import java.util.Date;

import com.google.gson.annotations.SerializedName;

public class InfoAttivita {

    @SerializedName("attivita-esercitata")
    private String attivitaEsercitata;
    
    @SerializedName("classificazioni-ateco")
    private ClassificazioniAteco classificazioniAteco;
    
    @SerializedName("attivita-prevalente")
    private String attivitaPrevalente;
    
    @SerializedName("dt-inizio-attivita-impresa")
    private Date dataInizioAttivitaImpresa;

	public String getAttivitaEsercitata() {
		return attivitaEsercitata;
	}

	public void setAttivitaEsercitata(String attivitaEsercitata) {
		this.attivitaEsercitata = attivitaEsercitata;
	}

	public ClassificazioniAteco getClassificazioniAteco() {
		return classificazioniAteco;
	}

	public void setClassificazioniAteco(ClassificazioniAteco classificazioniAteco) {
		this.classificazioniAteco = classificazioniAteco;
	}

	public String getAttivitaPrevalente() {
		return attivitaPrevalente;
	}

	public void setAttivitaPrevalente(String attivitaPrevalente) {
		this.attivitaPrevalente = attivitaPrevalente;
	}

	public Date getDataInizioAttivitaImpresa() {
		return dataInizioAttivitaImpresa;
	}

	public void setDataInizioAttivitaImpresa(Date dataInizioAttivitaImpresa) {
		this.dataInizioAttivitaImpresa = dataInizioAttivitaImpresa;
	}
    
    

}
