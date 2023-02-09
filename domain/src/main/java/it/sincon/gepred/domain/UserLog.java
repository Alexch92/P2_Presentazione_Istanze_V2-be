package it.sincon.gepred.domain;


import it.osapulie.domain.ProfiloUtente;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 * @author Eligio Cavallo
 *
 */

@Entity
@Table(name = "tb_userlog")
public class UserLog extends AbstractPersistable<Long> implements Serializable{

	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data", length = 128)
	private Date data;
	
	@Column(name = "tipooperazione",length=255 ,nullable = false)
	private String tipooperazione;

	
	@JoinColumn(name = "fk_profiloutente", nullable = true)
	private ProfiloUtente profiloutente;
	
	@Column(name = "oggettooperazione",length=255 ,nullable = false)
	private String oggettooperazione;

	@Column(name = "idoggettooperazione",length=5 ,nullable = true)
	private Long idoggettooperazione;

	@Column(name = "note",length=255 ,nullable = true)
	private String note;

	public Date getData() {
		return data;
	}

	public String getTipooperazione() {
		return tipooperazione;
	}

	public ProfiloUtente getProfiloutente() {
		return profiloutente;
	}

	public String getOggettooperazione() {
		return oggettooperazione;
	}

	public Long getIdoggettooperazione() {
		return idoggettooperazione;
	}

	public String getNote() {
		return note;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public void setTipooperazione(String tipooperazione) {
		this.tipooperazione = tipooperazione;
	}

	public void setProfiloutente(ProfiloUtente profiloutente) {
		this.profiloutente = profiloutente;
	}

	public void setOggettooperazione(String oggettooperazione) {
		this.oggettooperazione = oggettooperazione;
	}

	public void setIdoggettooperazione(Long idoggettooperazione) {
		this.idoggettooperazione = idoggettooperazione;
	}

	public void setNote(String note) {
		this.note = note;
	}

}		