package it.sincon.gepred.domain;

import java.io.Serializable;
import java.util.Date;

import it.osapulie.domain.Comune;
import it.osapulie.domain.Provincia;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "tb_referente")
/**
 * @author Davide
 * @author Maria Michela Birtolo
 */
public class Referente extends AbstractPersistable<Long> implements
		Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JoinColumn(name = "fk_comune", insertable = false, nullable = false)
	Comune comune;
	
	@JoinColumn(name = "fk_provincia", insertable = false, nullable = true)
	Provincia provincia;
	
	@Column(name = "tipologia", nullable = false, length = 1)
	private String tipologia;

	@Column(name = "chkref", nullable = true, length = 1)
	private Boolean chkref = true;

	@Column(name = "nominativo", length = 255)
	private String nominativo;

	@Column(name = "nome", length = 255)
	private String nome;

	@Column(name = "cognome", length = 255)
	private String cognome;

	@Column(name = "cf", length = 16, nullable = true)
	private String cf;

	@Column(name = "piva", length = 25, nullable = true)
	private String piva;

	@Column(name = "indirizzo", length = 255)
	private String indirizzo;

	@Column(name = "cap", length = 5, nullable = false)
	private String cap;

	@Column(name = "fax", length = 50)
	private String fax;

	@Column(name = "riferimentitelefonici", length = 50, nullable = false)
	private String riferimentitelefonici;

	@Column(name = "cell", length = 50)
	private String cell;

	@Column(name = "email", length = 155)
	private String email;

	@Column(name = "pec", length = 155)
	private String pec;
	
	@Column(name = "nregistro", length = 255)
	private String nregistro;
	
	@Column(name = "numalbo", length = 50)
	private String numalbo;
	
	@Column(name = "alboapp", length = 255)
	private String alboapp;
	
	@Column(name = "coord_banca", length = 45)
	private String coordinateBancarie;
	
	@Column(name = "ass_compagnia", length = 45)
	private String compagniaAssicurativa;
	
	@Column(name = "ass_num_polizza", length = 45)
	private String nrPolizza;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ass_data_stipula")
	private Date dataStipulaAssicurazione;
	
	@Column(name = "ass_importo", length = 45)
	private String importoPolizza;
	
	@Column(name = "ass_massimale", length = 45)
	private String massimalePolizza;
	
	@Override
	public void setId(Long id) {
		super.setId(id);
	}
		
	public String getCompagniaAssicurativa() {
		return compagniaAssicurativa;
	}

	public void setCompagniaAssicurativa(String compagniaAssicurativa) {
		this.compagniaAssicurativa = compagniaAssicurativa;
	}

	public String getNrPolizza() {
		return nrPolizza;
	}

	public void setNrPolizza(String nrPolizza) {
		this.nrPolizza = nrPolizza;
	}

	public Date getDataStipulaAssicurazione() {
		return dataStipulaAssicurazione;
	}

	public void setDataStipulaAssicurazione(Date dataStipulaAssicurazione) {
		this.dataStipulaAssicurazione = dataStipulaAssicurazione;
	}

	public String getImportoPolizza() {
		return importoPolizza;
	}

	public void setImportoPolizza(String importoPolizza) {
		this.importoPolizza = importoPolizza;
	}

	public String getCoordinateBancarie() {
		return coordinateBancarie;
	}

	public void setCoordinateBancarie(String coordinateBancarie) {
		this.coordinateBancarie = coordinateBancarie;
	}

	public String getCf() {
		return cf;
	}

	public void setCf(String cf) {
		this.cf = cf;
	}

	public String getPiva() {
		return piva;
	}

	public void setPiva(String piva) {
		this.piva = piva;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getCell() {
		return cell;
	}

	public void setCell(String cell) {
		this.cell = cell;
	}

	public String getPec() {
		return pec;
	}

	public void setPec(String pec) {
		this.pec = pec;
	}

	public Comune getComune() {
		return comune;
	}

	public void setComune(Comune comune) {
		this.comune = comune;
	}

	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	public String getTipologia() {
		return tipologia;
	}

	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}

	public String getNominativo() {
		return nominativo;
	}

	public void setNominativo(String nominativo) {
		this.nominativo = nominativo;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getCap() {
		return cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRiferimentitelefonici() {
		return riferimentitelefonici;
	}

	public void setRiferimentitelefonici(String riferimentitelefonici) {
		this.riferimentitelefonici = riferimentitelefonici;
	}

	public Boolean getChkref() {
		return chkref;
	}

	public void setChkref(Boolean chkref) {
		this.chkref = chkref;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNregistro() {
		return nregistro;
	}

	public void setNregistro(String nregistro) {
		this.nregistro = nregistro;
	}

	public String getNumalbo() {
		return numalbo;
	}

	public void setNumalbo(String numalbo) {
		this.numalbo = numalbo;
	}

	public String getAlboapp() {
		return alboapp;
	}

	public void setAlboapp(String alboapp) {
		this.alboapp = alboapp;
	}
	
	public String getMassimalePolizza() {
		return massimalePolizza;
	}

	public void setMassimalePolizza(String massimalePolizza) {
		this.massimalePolizza = massimalePolizza;
	}
	
}
