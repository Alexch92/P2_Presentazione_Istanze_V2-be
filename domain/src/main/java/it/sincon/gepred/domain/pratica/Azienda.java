package it.sincon.gepred.domain.pratica;

import java.io.File;
import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.data.jpa.domain.AbstractPersistable;

import it.sincon.gepred.domain.CampiAggiuntiviPraticaWeb;

/**
 * 
 * @author Antonio Santomauro
 *
 */
@Entity
@Table(name="tb_azienda")
public class Azienda  extends AbstractPersistable<Long> implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Column(name="denominazione",nullable=false,length=2000)
	private String denominazione;

	@Column(name="partita_iva",nullable=false,length=50)
	private String partitaIva;
	
	@Column(name="sede",nullable=true,length=255)
	private String sede;
	
	@Column(name="pec",nullable=true,length=50)
	private String pec;
	
	@Column(name="e_mail",nullable=true,length=50)
	private String eMail;
	
	@OneToMany(mappedBy = "azienda", cascade = CascadeType.ALL, orphanRemoval = true)
	@OrderBy("id asc")
	private List<AziendaRappresentanti> rappresentanti;
	
	@Transient
	private String denominazioneCompleta;
		
	@Override
	public void setId(Long id) {
		super.setId(id);
	}

	public String getDenominazione() {
		return denominazione;
	}

	public void setDenominazione(String denominazione) {
		this.denominazione = denominazione;
	}

	public String getPartitaIva() {
		return partitaIva;
	}

	public void setPartitaIva(String partitaIva) {
		this.partitaIva = partitaIva;
	}

	public String getSede() {
		return sede;
	}

	public void setSede(String sede) {
		this.sede = sede;
	}

	public List<AziendaRappresentanti> getRappresentanti() {
		return rappresentanti;
	}

	public void setRappresentanti(List<AziendaRappresentanti> rappresentanti) {
		this.rappresentanti = rappresentanti;
	}
	
	public String getPec() {
		return pec;
	}

	public void setPec(String pec) {
		this.pec = pec;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getDenominazioneCompleta() {
		denominazioneCompleta = String.format("%s (P.IVA: %s)", denominazione, partitaIva); 
		return denominazioneCompleta;
	}
}
