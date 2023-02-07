package it.sincon.gepred.calendario.beans;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * Classe che implementa l'oggetto appuntamento a partire da un'attivit&agrave;,
 * che poi diventer&agrave; un evento sul calendario di Liferay
 * 
 * @author Angelo Pascadopoli
 *
 */
public class Appuntamento implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private long idAttivita;
	private String titolo;
	private String descrizione; //Pratica di riferimento + Descrizione dell'attività
	private long idUtente;
	private Date dataInizio;
	private Date dataScadenza;
	private Long idEventoCalendario;
	
	public long getIdAttivita() {
		return idAttivita;
	}
	public void setIdAttivita(long idAttivita) {
		this.idAttivita = idAttivita;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public long getIdUtente() {
		return idUtente;
	}
	public void setIdUtente(long idUtente) {
		this.idUtente = idUtente;
	}
	public Date getDataScadenza() {
		return dataScadenza;
	}
	public void setDataScadenza(Date dataScadenza) {
		this.dataScadenza = dataScadenza;
	}
	public Date getDataInizio() {
		return dataInizio;
	}
	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}
	public Long getIdEventoCalendario() {
		return idEventoCalendario;
	}
	public void setIdEventoCalendario(Long idEventoCalendario) {
		this.idEventoCalendario = idEventoCalendario;
	}
	

}
