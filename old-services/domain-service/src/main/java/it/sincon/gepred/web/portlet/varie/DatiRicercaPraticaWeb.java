package it.sincon.gepred.web.portlet.varie;

import java.io.Serializable;
import java.util.List;

/**
 * Classe contenente i filtri per la ricerca front-end delle pratiche
 * 
 * @author Maria Michela Birtolo
 * 
 */
public class DatiRicercaPraticaWeb implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String oggetto;
	private String numero;
	private String statopratica;
	private String utente;
	private String tipologia;
	private List<Long> statiAmmessi;
	
	public String getTipologia() {
		return tipologia;
	}
	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}
	public String getUtente() {
		return utente;
	}
	public void setUtente(String utente) {
		this.utente = utente;
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
	public String getStatopratica() {
		return statopratica;
	}
	public void setStatopratica(String statopratica) {
		this.statopratica = statopratica;
	}
	public List<Long> getStatiAmmessi() {
		return statiAmmessi;
	}
	public void setStatiAmmessi(List<Long> statiAmmessi) {
		this.statiAmmessi = statiAmmessi;
	}	
	
}
