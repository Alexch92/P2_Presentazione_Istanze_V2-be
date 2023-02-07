package it.sincon.gepred.visura.bean;

import java.util.List;

public class VisuraImpresa {
	
	private String codice;
	private String messaggio;
	private String denominazione;
	private String codiceFiscale;
	private String partitaIva;
	private String formaGiuridica;
	private String pec;
	private SedeImpresa sede;
	private List<String> codiciAteco;
	private List<RappresentanteLegale> rappresentanti;
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
	public String getFormaGiuridica() {
		return formaGiuridica;
	}
	public void setFormaGiuridica(String formaGiuridica) {
		this.formaGiuridica = formaGiuridica;
	}
	public String getPec() {
		return pec;
	}
	public void setPec(String pec) {
		this.pec = pec;
	}
	public SedeImpresa getSede() {
		return sede;
	}
	public void setSede(SedeImpresa sede) {
		this.sede = sede;
	}
	public List<String> getCodiciAteco() {
		return codiciAteco;
	}
	public void setCodiciAteco(List<String> codiciAteco) {
		this.codiciAteco = codiciAteco;
	}
	public List<RappresentanteLegale> getRappresentanti() {
		return rappresentanti;
	}
	public void setRappresentanti(List<RappresentanteLegale> rappresentanti) {
		this.rappresentanti = rappresentanti;
	}
	public String getCodice() {
		return codice;
	}
	public void setCodice(String codice) {
		this.codice = codice;
	}
	public String getMessaggio() {
		return messaggio;
	}
	public void setMessaggio(String messaggio) {
		this.messaggio = messaggio;
	}
	
}
