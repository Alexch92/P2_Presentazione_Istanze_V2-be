package it.sincon.gepred.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class DatiMailInviate implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3589138160623199523L;
	
	@Column(name="datainvio")
	private Date datainvio;
	@Column(name="mittente")
	private String mittente;
	@Column(name="destinatario")
	private String destinatario;
	@Column(name="oggetto")
	private String oggetto;
	@Column(name="corpo")
	private String corpo;
	@Column(name="nrallegati")
	private long nrallegati;
	
	public DatiMailInviate(Date datainvio,
			String mittente,
			String destinatario,
			String oggetto,
			String corpo,
			long nrallegati){
		
		this.datainvio = datainvio;
		this.mittente = mittente;
		this.destinatario = destinatario;
		this.oggetto = oggetto;
		this.corpo = corpo;
		this.nrallegati = nrallegati;
	}
	
	public Date getDatainvio() {
		return datainvio;
	}
	public void setDatainvio(Date datainvio) {
		this.datainvio = datainvio;
	}
	public String getMittente() {
		return mittente;
	}
	public void setMittente(String mittente) {
		this.mittente = mittente;
	}
	public String getDestinatario() {
		return destinatario;
	}
	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}
	public String getOggetto() {
		return oggetto;
	}
	public void setOggetto(String oggetto) {
		this.oggetto = oggetto;
	}
	public String getCorpo() {
		return corpo;
	}
	public void setCorpo(String corpo) {
		this.corpo = corpo;
	}
	public long getNrallegati() {
		return nrallegati;
	}
	public void setNrallegati(long nrallegati) {
		this.nrallegati = nrallegati;
	}
	
}
