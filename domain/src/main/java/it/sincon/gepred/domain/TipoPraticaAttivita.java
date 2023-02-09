package it.sincon.gepred.domain;

import it.sincon.gepred.domain.pratica.TipoPratica;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 * Entity per le attivit&agrave; associate al Tipo Pratica
 * 
 * @author Angelo Pascadopoli
 *
 */
@Entity
@Table(name = "tb_tipopratica_attivita")
public class TipoPraticaAttivita extends AbstractPersistable<Long> implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "scadenza")
	private Integer scadenza;
	
	@Column(name = "automatica",length=1, nullable = true)
	private Integer automatica;
	
	@JoinColumn(name = "tipopratica_id", nullable = false, insertable = false)
	TipoPratica tipoPratica;
	
	@JoinColumn(name = "attivita_id", nullable = false, insertable = false)
	Attivita attivita;
	
	@Column(name = "da_calendario", nullable = false, length=1)
	private boolean daCalendario=false;
	
	@Column(name = "send_alert_mail", nullable = false, length=1)
	private boolean sendAlertMail;
	
	public boolean isDaCalendario() {
		return daCalendario;
	}

	public void setDaCalendario(boolean daCalendario) {
		this.daCalendario = daCalendario;
	}

	public Integer getScadenza() {
		return scadenza;
	}

	public void setScadenza(Integer scadenza) {
		this.scadenza = scadenza;
	}

	public TipoPratica getTipoPratica() {
		return tipoPratica;
	}

	public void setTipoPratica(TipoPratica tipoPratica) {
		this.tipoPratica = tipoPratica;
	}

	public Attivita getAttivita() {
		return attivita;
	}

	public void setAttivita(Attivita attivita) {
		this.attivita = attivita;
	}

	public Integer getAutomatica() {
		return automatica;
	}

	public void setAutomatica(Integer automatica) {
		this.automatica = automatica;
	}

	public boolean isSendAlertMail() {
		return sendAlertMail;
	}

	public void setSendAlertMail(boolean sendAlertMail) {
		this.sendAlertMail = sendAlertMail;
	}
	
}
