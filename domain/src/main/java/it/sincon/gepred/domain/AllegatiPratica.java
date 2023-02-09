package it.sincon.gepred.domain;

import it.sincon.gepred.domain.pratica.Pratica;

import java.io.File;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.data.jpa.domain.AbstractPersistable;
/**
 * @author Eligio Cavallo
 *
 */
@Entity
@Table(name = "tb_allegatipratica")
public class AllegatiPratica extends AbstractPersistable<Long> implements Serializable{

	private static final long serialVersionUID = 1L;

	@JoinColumn(name = "fk_allegati", insertable = false, nullable = false)
	Allegati allegati;

	@JoinColumn(name = "fk_pratica", insertable = false, nullable = false)
	Pratica pratica;
	
	@OneToMany(mappedBy = "allegato", cascade = CascadeType.ALL, orphanRemoval = true, fetch=FetchType.LAZY)
	@OrderBy("dataInvio DESC")
	private List<DatiInvioMail> mail;
	
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
	
	@Column(name ="accesso_a_protocollo", length = 1,nullable=false)
	private boolean accessoProtocollo=true;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_inserimento", nullable = true)
	private Date dataInserimento;
	
	@Column(name ="modello", length = 1,nullable = true)
	private boolean modello=false;
	
	@Column(name ="impronta", length = 256,nullable = true)
	private String impronta; 
	
	@Column(name = "visibile_online",length=1, nullable = false)
	private boolean visibileOnline;
	
	@Column(name = "da_integrare",length=1, nullable = false)
	private boolean daIntegrare;
	
	@Column(name = "non_caricato",length=1, nullable = false)
	private boolean nonCaricato;
	
	@Transient
	private boolean obbligatorio;
	
	public boolean isDaIntegrare() {
		return daIntegrare;
	}

	public void setDaIntegrare(boolean daIntegrare) {
		this.daIntegrare = daIntegrare;
	}

	public boolean isVisibileOnline() {
		return visibileOnline;
	}

	public void setVisibileOnline(boolean visibileOnline) {
		this.visibileOnline = visibileOnline;
	}

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
	private File allegato;
	
	@Transient
	private boolean firmaDaValidare = false;
	
	public File getAllegato() {
		return allegato;
	}

	public void setAllegato(File allegato) {
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
	public Pratica getPratica() {
		return pratica;
	}
	public void setAllegati(Allegati allegati) {
		this.allegati = allegati;
	}
	public void setPratica(Pratica pratica) {
		this.pratica = pratica;
	}

	public boolean isAccessoProtocollo() {
		return accessoProtocollo;
	}

	public void setAccessoProtocollo(boolean accessoProtocollo) {
		this.accessoProtocollo = accessoProtocollo;
	}

	public Date getDataInserimento() {
		return dataInserimento;
	}

	public void setDataInserimento(Date dataInserimento) {
		this.dataInserimento = dataInserimento;
	}

	public boolean isModello() {
		return modello;
	}

	public void setModello(boolean modello) {
		this.modello = modello;
	}

	public List<DatiInvioMail> getMail() {
		return mail;
	}

	public void setMail(List<DatiInvioMail> mail) {
		this.mail = mail;
	}

	public String getImpronta() {
		return impronta;
	}

	public void setImpronta(String impronta) {
		this.impronta = impronta;
	}
	
	public boolean getNonCaricato() {
		return nonCaricato;
	}
	public void setNonCaricato(boolean nonCaricato) {
		this.nonCaricato = nonCaricato;
	}

	public boolean isFirmaDaValidare() {
		return firmaDaValidare;
	}

	public void setFirmaDaValidare(boolean firmaDaValidare) {
		this.firmaDaValidare = firmaDaValidare;
	}

	public boolean isObbligatorio() {
		return obbligatorio;
	}

	public void setObbligatorio(boolean obbligatorio) {
		this.obbligatorio = obbligatorio;
	}
	
}
