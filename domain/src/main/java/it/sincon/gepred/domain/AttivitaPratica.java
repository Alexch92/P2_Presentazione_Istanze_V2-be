package it.sincon.gepred.domain;

import it.osapulie.domain.ProfiloUtente;
import it.sincon.gepred.domain.pratica.Pratica;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.data.jpa.domain.AbstractPersistable;
/**
 * @author Maria Michela Birtolo
 *
 */
@Entity
@Table(name = "tb_attivitapratica")
public class AttivitaPratica extends AbstractPersistable<Long> implements Serializable{

	private static final long serialVersionUID = 1L;

	@JoinColumn(name = "fk_attivita", insertable = false, nullable = true)
	Attivita attivita;

	@JoinColumn(name = "fk_pratica", insertable = false, nullable = false)
	Pratica pratica;
	
	@Column(name = "descrizione",length=255, nullable = false)
	private String descrizione;
	
	@JoinColumn(name = "fk_profiloutente", nullable = true)
	private ProfiloUtente profiloutente;

	@JoinColumn(name = "fk_ente", nullable = true)
	private Referente ente;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_assegnazione", nullable = true)
	private Date dataAssegnazione;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_scadenza", nullable = true)
	private Date dataScadenza;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_completamento", nullable = true)
	private Date dataCompletamento;
	
	@Column(name = "id_evento_calendario", nullable = true)
	private Long idEventoCalendario;
	
	@Column(name="send_alert_mail",length=1, nullable = false)
	private boolean sendAlertMail;
	
	@Column(name = "tipologia",length=1, nullable = true)
	private Integer tipologia;
	
	@Override
	public void setId(Long id) {
		super.setId(id);
	}

	public Attivita getAttivita() {
		return attivita;
	}

	public void setAttivita(Attivita attivita) {
		this.attivita = attivita;
	}

	public Pratica getPratica() {
		return pratica;
	}

	public void setPratica(Pratica pratica) {
		this.pratica = pratica;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public ProfiloUtente getProfiloutente() {
		return profiloutente;
	}

	public void setProfiloutente(ProfiloUtente profiloutente) {
		this.profiloutente = profiloutente;
	}

	public Referente getEnte() {
		return ente;
	}

	public void setEnte(Referente ente) {
		this.ente = ente;
	}

	public Date getDataAssegnazione() {
		return dataAssegnazione;
	}

	public void setDataAssegnazione(Date dataAssegnazione) {
		this.dataAssegnazione = dataAssegnazione;
	}

	public Date getDataScadenza() {
		return dataScadenza;
	}

	public void setDataScadenza(Date dataScadenza) {
		this.dataScadenza = dataScadenza;
	}

	public Date getDataCompletamento() {
		return dataCompletamento;
	}

	public void setDataCompletamento(Date dataCompletamento) {
		this.dataCompletamento = dataCompletamento;
	}

	public Long getIdEventoCalendario() {
		return idEventoCalendario;
	}

	public void setIdEventoCalendario(Long idEventoCalendario) {
		this.idEventoCalendario = idEventoCalendario;
	}

	public boolean isSendAlertMail() {
		return sendAlertMail;
	}

	public void setSendAlertMail(boolean sendAlertMail) {
		this.sendAlertMail = sendAlertMail;
	}

	public Integer getTipologia() {
		return tipologia;
	}

	public void setTipologia(Integer tipologia) {
		this.tipologia = tipologia;
	}
	
}
