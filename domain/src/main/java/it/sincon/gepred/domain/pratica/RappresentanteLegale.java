package it.sincon.gepred.domain.pratica;

import java.io.File;
import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Transient;

import org.springframework.data.jpa.domain.AbstractPersistable;

import it.sincon.gepred.domain.pratica.PraticaWeb;

/**
 * 
 * @author Antonio Santomauro
 *
 */
@Entity
@Table(name="tb_rappresentanti_legali")
public class RappresentanteLegale  extends AbstractPersistable<Long> implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Column(name="nominativo",nullable=false,length=255)
	private String nominativo;

	@Column(name="codice_fiscale",nullable=false,length=50)
	private String codiceFiscale;
	
	@Column(name="carica_ricoperta",nullable=false,length=50)
	private String caricaRicoperta;
	
	@Column(name="doc_allegatob_uuid", nullable = true, length = 45)
	private String uuidAllegatoB;
	
	@Column(name="doc_allegatob_nomefile", nullable = true, length = 100)
	private String nomeFileAllegatoB;
	
	@Column(name ="impronta_allegatob", length = 255, nullable = true)
	private String improntaAllegatoB; 
	
	@OneToMany(mappedBy = "rappresentante", cascade = CascadeType.ALL, orphanRemoval = true)
	@OrderBy("id asc")
	private List<AziendaRappresentanti> aziende;
	
	@Transient
	private File fileAllegatoB;
	
	@Transient
	private Boolean verificaAllegatoB;
	
	@Transient
	private String nominativoAndCF;
	
	@Override
	public void setId(Long id) {
		super.setId(id);
	}

	public String getNominativo() {
		return nominativo;
	}

	public void setNominativo(String nominativo) {
		this.nominativo = nominativo;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}	
	
	public String getCaricaRicoperta() {
		return caricaRicoperta;
	}

	public void setCaricaRicoperta(String caricaRicoperta) {
		this.caricaRicoperta = caricaRicoperta;
	}
	
	public String getUuidAllegatoB() {
		return uuidAllegatoB;
	}

	public void setUuidAllegatoB(String uuidAllegatoB) {
		this.uuidAllegatoB = uuidAllegatoB;
	}

	public String getNomeFileAllegatoB() {
		return nomeFileAllegatoB;
	}

	public void setNomeFileAllegatoB(String nomeFileAllegatoB) {
		this.nomeFileAllegatoB = nomeFileAllegatoB;
	}

	public File getFileAllegatoB() {
		return fileAllegatoB;
	}

	public void setFileAllegatoB(File fileAllegatoB) {
		this.fileAllegatoB = fileAllegatoB;
	}

	public Boolean getVerificaAllegatoB() {
		return verificaAllegatoB;
	}

	public void setVerificaAllegatoB(Boolean verificaAllegatoB) {
		this.verificaAllegatoB = verificaAllegatoB;
	}

	public String getImprontaAllegatoB() {
		return improntaAllegatoB;
	}

	public void setImprontaAllegatoB(String improntaAllegatoB) {
		this.improntaAllegatoB = improntaAllegatoB;
	}

	public List<AziendaRappresentanti> getAziende() {
		return aziende;
	}

	public void setAziende(List<AziendaRappresentanti> aziende) {
		this.aziende = aziende;
	}

	public String getNominativoAndCF() {
		return String.format("%s - %s", nominativo, codiceFiscale);
	}
	
}
