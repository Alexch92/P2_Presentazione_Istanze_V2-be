package it.sincon.gepred.domain;

import it.osapulie.domain.ProfiloUtente;
import it.sincon.gepred.domain.pratica.Pratica;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
@Table(name = "tb_inviomail")
public class DatiInvioMail extends AbstractPersistable<Long> implements Serializable{

	private static final long serialVersionUID = 1L;

	@Column(name = "fk_pratica", nullable = true)
	long idPratica;
	
	@JoinColumn(name = "fk_allegatipratica", insertable = false, nullable = true)
	AllegatiPratica allegato;

	@Column(name = "inviato",length=1, nullable = false)
	private boolean inviato;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_invio", nullable = false)
	private Date dataInvio;
	
	@Column(name = "destinatario", nullable = false)
	private String destinatario;
	
	@Column(name = "mittente", nullable = true)
	private String mittente;
	
	@Column(name = "oggetto", nullable = false,length=255)
	private String oggetto;
	
	@Column(name="corpo", nullable = false)
	private String corpo;
	
	@JoinColumn( name = "fk_profiloutente",nullable=false)
	private ProfiloUtente utente;
	
	
	@Transient
	private List<AllegatiPraticaExtended> allegatiSelezionati;

	public AllegatiPratica getAllegato() {
		return allegato;
	}

	public void setAllegato(AllegatiPratica allegato) {
		this.allegato = allegato;
	}
	
	
	public long getIdPratica() {
		return idPratica;
	}

	public void setIdPratica(long idPratica) {
		this.idPratica = idPratica;
	}

	public boolean isInviato() {
		return inviato;
	}

	public void setInviato(boolean inviato) {
		this.inviato = inviato;
	}

	public Date getDataInvio() {
		return dataInvio;
	}

	public void setDataInvio(Date dataInvio) {
		this.dataInvio = dataInvio;
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

	public ProfiloUtente getUtente() {
		return utente;
	}

	public void setUtente(ProfiloUtente utente) {
		this.utente = utente;
	}

	public List<AllegatiPraticaExtended> getAllegatiSelezionati() {
		return allegatiSelezionati;
	}

	public void setAllegatiSelezionati(
			List<AllegatiPraticaExtended> allegatiSelezionati) {
		this.allegatiSelezionati = allegatiSelezionati;
	}
	
	public String getMittente() {
		return mittente;
	}

	public void setMittente(String mittente) {
		this.mittente = mittente;
	}

	public void resetId(){
		this.setId(null);
	}
}
