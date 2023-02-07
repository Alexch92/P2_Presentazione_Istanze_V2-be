package it.sincon.gepred.visura.rupar.bean;

import java.util.Date;

import com.google.gson.annotations.SerializedName;

public class DatiIdentificativi {
	
    @SerializedName("forma-giuridica")
    private FormaGiuridica formaGiuridica;
    @SerializedName("indirizzo-localizzazione")
    private IndirizzoLocalizzazione indirizzoLocalizzazione;
    @SerializedName("indirizzo-posta-certificata")
    private String indirizzoPostaCertificata;
    @SerializedName("c-fonte")
    private String codiceFonte;
    private String fonte;
    @SerializedName("tipo-soggetto")
    private String tipoSoggetto;
    @SerializedName("descrizione-tipo-soggetto")
    private String descrizioneTipoSoggetto;
    @SerializedName("tipo-impresa")
    private String tipoImpresa;
    @SerializedName("descrizione-tipo-impresa")
    private String descrizioneTipoImpresa;
    @SerializedName("dt-iscrizione-rea")
    private Date dataIscrizioneRea;
    @SerializedName("dt-atto-costituzione")
    private Date dataAttoCostituzione;
    private String denominazione;
    @SerializedName("c-fiscale")
    private String codiceFiscale;
    @SerializedName("partita-iva")
    private String partitaIva;
    private String cciaa;
    @SerializedName("n-rea")
    private int numeroRea;
	public FormaGiuridica getFormaGiuridica() {
		return formaGiuridica;
	}
	public void setFormaGiuridica(FormaGiuridica formaGiuridica) {
		this.formaGiuridica = formaGiuridica;
	}
	public IndirizzoLocalizzazione getIndirizzoLocalizzazione() {
		return indirizzoLocalizzazione;
	}
	public void setIndirizzoLocalizzazione(IndirizzoLocalizzazione indirizzoLocalizzazione) {
		this.indirizzoLocalizzazione = indirizzoLocalizzazione;
	}
	public String getIndirizzoPostaCertificata() {
		return indirizzoPostaCertificata;
	}
	public void setIndirizzoPostaCertificata(String indirizzoPostaCertificata) {
		this.indirizzoPostaCertificata = indirizzoPostaCertificata;
	}
	public String getCodiceFonte() {
		return codiceFonte;
	}
	public void setCodiceFonte(String codiceFonte) {
		this.codiceFonte = codiceFonte;
	}
	public String getFonte() {
		return fonte;
	}
	public void setFonte(String fonte) {
		this.fonte = fonte;
	}
	public String getTipoSoggetto() {
		return tipoSoggetto;
	}
	public void setTipoSoggetto(String tipoSoggetto) {
		this.tipoSoggetto = tipoSoggetto;
	}
	public String getDescrizioneTipoSoggetto() {
		return descrizioneTipoSoggetto;
	}
	public void setDescrizioneTipoSoggetto(String descrizioneTipoSoggetto) {
		this.descrizioneTipoSoggetto = descrizioneTipoSoggetto;
	}
	public String getTipoImpresa() {
		return tipoImpresa;
	}
	public void setTipoImpresa(String tipoImpresa) {
		this.tipoImpresa = tipoImpresa;
	}
	public String getDescrizioneTipoImpresa() {
		return descrizioneTipoImpresa;
	}
	public void setDescrizioneTipoImpresa(String descrizioneTipoImpresa) {
		this.descrizioneTipoImpresa = descrizioneTipoImpresa;
	}
	public Date getDataIscrizioneRea() {
		return dataIscrizioneRea;
	}
	public void setDataIscrizioneRea(Date dataIscrizioneRea) {
		this.dataIscrizioneRea = dataIscrizioneRea;
	}
	public Date getDataAttoCostituzione() {
		return dataAttoCostituzione;
	}
	public void setDataAttoCostituzione(Date dataAttoCostituzione) {
		this.dataAttoCostituzione = dataAttoCostituzione;
	}
	public String getDenominazione() {
		return denominazione;
	}
	public void setDenominazione(String denominazione) {
		this.denominazione = denominazione;
	}
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}
	public String getPartitaIva() {
		return partitaIva;
	}
	public void setPartitaIva(String partitaIva) {
		this.partitaIva = partitaIva;
	}
	public String getCciaa() {
		return cciaa;
	}
	public void setCciaa(String cciaa) {
		this.cciaa = cciaa;
	}
	public int getNumeroRea() {
		return numeroRea;
	}
	public void setNumeroRea(int numeroRea) {
		this.numeroRea = numeroRea;
	}

    
}
