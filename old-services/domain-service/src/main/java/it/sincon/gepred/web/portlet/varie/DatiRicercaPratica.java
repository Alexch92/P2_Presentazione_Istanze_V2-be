package it.sincon.gepred.web.portlet.varie;

import it.sincon.gepred.domain.CampiAggiuntivi;
import it.sincon.gepred.domain.Immobile;
import it.sincon.gepred.domain.Referente;
import it.osapulie.domain.ProfiloUtente;
import it.osapulie.domain.Ruolo;

import java.io.Serializable;
import java.util.List;

/**
 * Classe contenente i filtri per la ricerca delle pratiche
 * 
 * @author Maria Michela Birtolo
 * 
 */
public class DatiRicercaPratica implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String oggetto;
	private String numero;
	private Referente richiedente;
	private Immobile immobile;
	private String statopratica;
	private String responsabile;
	private String utenteWorkflow;
//	private Ruolo ruoloUtenteLoggato;
	private ProfiloUtente utenteLoggato;
	private String tipointervento;
	private String areaSIN;
	private String tipologia;
	private String anno;
	private String periodo_da;
	private String periodo_a;
	private List<CampiAggiuntivi> campiAggiuntivi;
	private String idCorrelati;
	private List<Long> statiAmmessi;
	private String dataProtocollo_da;
	private String dataProtocollo_a;
	
	
	private String numProtocollo;
	
	public String getIdCorrelati() {
		return idCorrelati;
	}
	public void setIdCorrelati(String idCorrelati) {
		this.idCorrelati = idCorrelati;
	}
	public List<CampiAggiuntivi> getCampiAggiuntivi() {
		return campiAggiuntivi;
	}
	public void setCampiAggiuntivi(List<CampiAggiuntivi> campiAggiuntivi) {
		this.campiAggiuntivi = campiAggiuntivi;
	}
	public String getPeriodo_da() {
		return periodo_da;
	}
	public void setPeriodo_da(String periodo_da) {
		this.periodo_da = periodo_da;
	}
	public String getPeriodo_a() {
		return periodo_a;
	}
	public void setPeriodo_a(String periodo_a) {
		this.periodo_a = periodo_a;
	}
	public String getAnno() {
		return anno;
	}
	public void setAnno(String anno) {
		this.anno = anno;
	}
	public String getTipologia() {
		return tipologia;
	}
	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}
	public String getTipointervento() {
		return tipointervento;
	}
	public void setTipointervento(String tipointervento) {
		this.tipointervento = tipointervento;
	}
	public String getAreaSIN() {
		return areaSIN;
	}
	public void setAreaSIN(String areaSIN) {
		this.areaSIN = areaSIN;
	}
	public Immobile getImmobile() {
		return immobile;
	}
	public void setImmobile(Immobile immobile) {
		this.immobile = immobile;
	}
	public String getUtenteWorkflow() {
		return utenteWorkflow;
	}
	public void setUtenteWorkflow(String utenteWorkflow) {
		this.utenteWorkflow = utenteWorkflow;
	}
//	public Ruolo getRuoloUtenteLoggato() {
//		return ruoloUtenteLoggato;
//	}
//	public void setRuoloUtenteLoggato(Ruolo ruoloUtenteLoggato) {
//		this.ruoloUtenteLoggato = ruoloUtenteLoggato;
//	}
	public ProfiloUtente getUtenteLoggato() {
		return utenteLoggato;
	}
	public void setUtenteLoggato(ProfiloUtente utenteLoggato) {
		this.utenteLoggato = utenteLoggato;
	}
	public String getOggetto() {
		return oggetto;
	}
	public void setOggetto(String oggetto) {
		this.oggetto = oggetto;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public Referente getRichiedente() {
		return richiedente;
	}
	public void setRichiedente(Referente richiedente) {
		this.richiedente = richiedente;
	}
	public String getStatopratica() {
		return statopratica;
	}
	public void setStatopratica(String statopratica) {
		this.statopratica = statopratica;
	}
	public String getResponsabile() {
		return responsabile;
	}
	public void setResponsabile(String responsabile) {
		this.responsabile = responsabile;
	}
	public String getNumProtocollo() {
		return numProtocollo;
	}
	public void setNumProtocollo(String numProtocollo) {
		this.numProtocollo = numProtocollo;
	}
	public List<Long> getStatiAmmessi() {
		return statiAmmessi;
	}
	public void setStatiAmmessi(List<Long> statiAmmessi) {
		this.statiAmmessi = statiAmmessi;
	}
	public String getDataProtocollo_da() {
		return dataProtocollo_da;
	}
	public void setDataProtocollo_da(String dataProtocollo_da) {
		this.dataProtocollo_da = dataProtocollo_da;
	}
	public String getDataProtocollo_a() {
		return dataProtocollo_a;
	}
	public void setDataProtocollo_a(String dataProtocollo_a) {
		this.dataProtocollo_a = dataProtocollo_a;
	}
	
}
