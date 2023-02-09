package it.sincon.gepred.domain;

import java.io.File;
import java.io.Serializable;

import it.sincon.gepred.domain.CampiAggiuntivi;
import it.sincon.gepred.domain.pratica.PraticaWeb;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.data.jpa.domain.AbstractPersistable;
/**
 * @author Maria Michela Birtolo
 *
 */
@Entity
@Table(name = "tb_ca_praticaweb")
public class CampiAggiuntiviPraticaWeb extends AbstractPersistable<Long> implements Serializable{

	private static final long serialVersionUID = -9074347978258085256L;

	@JoinColumn(name = "fk_campiaggiuntivi", insertable = false, nullable = false)
	CampiAggiuntivi campiAggiuntivi;

	@Column(name = "valore",length=500)
	private String valore;
	
	@Column(name = "doc_file_uuid",length=45)
	private String uuidFile;
	
	@Column(name = "doc_file_nome",length=100)
	private String nomeFile;

	@JoinColumn(name = "fk_pratica", insertable = false, nullable = false)
	PraticaWeb pratica;
	
	@Transient
	private File allegato;
	
	public void setId(Long id) {
		super.setId(id);
	}
	
	public File getAllegato() {
		return allegato;
	}

	public void setAllegato(File allegato) {
		this.allegato = allegato;
	}

	public CampiAggiuntivi getCampiAggiuntivi() {
		return campiAggiuntivi;
	}

	public String getValore() {
		return valore;
	}
	
	public String getUuidFile() {
		return uuidFile;
	}

	public void setUuidFile(String uuidFile) {
		this.uuidFile = uuidFile;
	}

	public String getNomeFile() {
		return nomeFile;
	}

	public void setNomeFile(String nomeFile) {
		this.nomeFile = nomeFile;
	}

	public PraticaWeb getPratica() {
		return pratica;
	}

	public void setCampiAggiuntivi(CampiAggiuntivi campiAggiuntivi) {
		this.campiAggiuntivi = campiAggiuntivi;
	}

	public void setValore(String valore) {
		this.valore = valore;
	}

	public void setPratica(PraticaWeb pratica) {
		this.pratica = pratica;
	}


}

