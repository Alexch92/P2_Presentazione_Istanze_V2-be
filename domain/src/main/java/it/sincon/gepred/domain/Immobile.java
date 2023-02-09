package it.sincon.gepred.domain;


import java.io.Serializable;

import it.osapulie.domain.Comune;
import it.sincon.gepred.domain.TipoImmobile;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 * The persistent class for the tb_immobile database table.
 * @author Maria Michela Birtolo
 * @auhor Eligio Cavallo
 *
 */
@Entity
@Table(name = "tb_immobile")
public class Immobile extends AbstractPersistable<Long> implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@JoinColumn(name = "fk_comune", nullable = false)
	Comune comune;
	
	@Column(name = "denominazione",length=255, nullable=false)
	private String denominazione;
	
	@Column(name = "indirizzo",length=255,nullable=false)
	private String indirizzo;
	
	@Column(name = "cap",length=5 ,nullable=false)
	private String cap;
	
	@Column(name = "area_sin",length=1 ,nullable=false)
	private String areaSin;
	
	@Column(name = "lat_g",length=5,nullable=true)
	private Integer latG;
	@Column(name = "lat_p",length=5,nullable=true)
	private Integer latP;
	@Column(name = "lat_s",length=5,nullable=true)
	private Double latS;
	
	@Column(name = "long_g",length=5,nullable=true)
	private Integer longG;
	@Column(name = "long_p",length=5,nullable=true)
	private Integer longP;
	@Column(name = "long_s",length=5,nullable=true)
	private Double longS;
	
	@JoinColumn(name = "fk_quartiere", nullable = true)
	private Quartiere  quartiere;
	
	@JoinColumn(name = "fk_tipologia", nullable = false)
	private TipoImmobile  tipologia;
	
	@Column(name = "foglio",length=5,nullable=true)
	private Integer foglio;
	
	@Column(name = "particella",length=255,nullable=true)
	private String particella;
	
	@Column(name = "subalterno",length=15,nullable=true)
	private String subalterno;

	public String getAreaSin() {
		return areaSin;
	}

	public void setAreaSin(String areaSin) {
		this.areaSin = areaSin;
	}

	public Integer getLatG() {
		return latG;
	}

	public void setLatG(Integer latG) {
		this.latG = latG;
	}

	public Integer getLatP() {
		return latP;
	}

	public void setLatP(Integer latP) {
		this.latP = latP;
	}

	public Double getLatS() {
		return latS;
	}

	public void setLatS(Double latS) {
		this.latS = latS;
	}

	public Integer getLongG() {
		return longG;
	}

	public void setLongG(Integer longG) {
		this.longG = longG;
	}

	public Integer getLongP() {
		return longP;
	}

	public void setLongP(Integer longP) {
		this.longP = longP;
	}

	public Double getLongS() {
		return longS;
	}

	public void setLongS(Double longS) {
		this.longS = longS;
	}

	public Quartiere getQuartiere() {
		return quartiere;
	}

	public void setQuartiere(Quartiere quartiere) {
		this.quartiere = quartiere;
	}

	public Comune getComune() {
		return comune;
	}

	public String getDenominazione() {
		return denominazione;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public String getCap() {
		return cap;
	}

	public TipoImmobile getTipologia() {
		return tipologia;
	}

	public Integer getFoglio() {
		return foglio;
	}

	public String getParticella() {
		return particella;
	}

	public String getSubalterno() {
		return subalterno;
	}

	public void setComune(Comune comune) {
		this.comune = comune;
	}

	public void setDenominazione(String denominazione) {
		this.denominazione = denominazione;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}

	public void setTipologia(TipoImmobile tipologia) {
		this.tipologia = tipologia;
	}

	public void setFoglio(Integer foglio) {
		this.foglio = foglio;
	}

	public void setParticella(String particella) {
		this.particella = particella;
	}

	public void setSubalterno(String subalterno) {
		this.subalterno = subalterno;
	}


	
}

