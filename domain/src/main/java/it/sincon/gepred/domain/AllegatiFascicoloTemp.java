package it.sincon.gepred.domain;

import it.sincon.gepred.domain.pratica.FascicoloTemporaneo;

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
import org.springframework.web.multipart.MultipartFile;
/**
 * @author Eligio Cavallo
 *
 */
@Entity
@Table(name = "tb_allegatifascicolo_temp")
public class AllegatiFascicoloTemp extends AbstractPersistable<Long> implements Serializable{

	private static final long serialVersionUID = 1L;

	@JoinColumn(name = "fk_allegati", insertable = false, nullable = false)
	Allegati allegati;

	@JoinColumn(name = "fk_fascicolo", insertable = false, nullable = false)
	FascicoloTemporaneo fascicolo;
	
	@Column(name = "caricato",length=1, nullable = false)
	private boolean caricato;
	
	@Column(name = "completato",length=1, nullable = false)
	private boolean completato;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_protocollo", nullable = true)
	private Date dataProtocollo;
	
	@Column(name = "num_protocollo", nullable = true)
	private String numProtocollo;
	
	@Column(name = "tipo_protocollo", nullable = true,length=1)
	private String tipoProtocollo;
	
	@Column(name="url_allegato", nullable = true, length = 255)
	private String urlAllegato;
	
	@Column(name="doc_file_uuid", nullable = true, length = 45)
	private String uuidFile;
	
	@Column(name="doc_file_nome", nullable = true, length = 100)
	private String nomeFile;
	
	@Column(name = "cancellato",length=1, nullable = false)
	private boolean cancellato;
	
	@Column(name = "spostato",length=1, nullable = false)
	private boolean spostato;
	
	public void setUuidFile(String uuidFile) {
		this.uuidFile = uuidFile;
	}

	public String getUuidFile() {
		return uuidFile;
	}

	public boolean isCancellato() {
		return cancellato;
	}

	public void setCancellato(boolean cancellato) {
		this.cancellato = cancellato;
	}

	public boolean isSpostato() {
		return spostato;
	}

	public void setSpostato(boolean spostato) {
		this.spostato = spostato;
	}

	public String getNomeFile() {
		return nomeFile;
	}

	public void setNomeFile(String nomeFile) {
		this.nomeFile = nomeFile;
	}

	public String getUrlAllegato() {
		return urlAllegato;
	}

	public void setUrlAllegato(String urlAllegato) {
		this.urlAllegato = urlAllegato;
	}
	
	@Transient
	private MultipartFile allegato;
	
	public MultipartFile getAllegato() {
		return allegato;
	}

	public void setAllegato(MultipartFile allegato) {
		this.allegato = allegato;
	}

	public Date getDataProtocollo() {
		return dataProtocollo;
	}
	public void setDataProtocollo(Date dataProtocollo) {
		this.dataProtocollo = dataProtocollo;
	}
	public String getNumProtocollo() {
		return numProtocollo;
	}
	public void setNumProtocollo(String numProtocollo) {
		this.numProtocollo = numProtocollo;
	}
	public String getTipoProtocollo() {
		return tipoProtocollo;
	}
	public void setTipoProtocollo(String tipoProtocollo) {
		this.tipoProtocollo = tipoProtocollo;
	}
	public boolean isCaricato() {
		return caricato;
	}
	public void setCaricato(boolean caricato) {
		this.caricato = caricato;
	}
	public boolean isCompletato() {
		return completato;
	}

	public void setCompletato(boolean completato) {
		this.completato = completato;
	}

	public Allegati getAllegati() {
		return allegati;
	}
	public void setAllegati(Allegati allegati) {
		this.allegati = allegati;
	}

	public FascicoloTemporaneo getFascicolo() {
		return fascicolo;
	}

	public void setFascicolo(FascicoloTemporaneo fascicolo) {
		this.fascicolo = fascicolo;
	}
	
}
