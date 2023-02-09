package it.sincon.gepred.domain;


import java.io.Serializable;

import it.osapulie.domain.Comune;
import it.osapulie.domain.Provincia;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
//import org.hibernate.validator.constraints.Email;
import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 * @author Eligio Cavallo
 */
@Entity
@Table(name = "tb_ente")
public class Ente extends AbstractPersistable<Long> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@JoinColumn(name = "fk_comune", insertable = false, nullable = false)
	Comune comune;
	
	@Column(name = "denominazione",length=255)
	private String denominazione;
	
	@Column(name = "indirizzo",length=255)
	private String indirizzo;
	
	@Column(name = "cap",length=5)
	private String cap;
	
	@JoinColumn(name = "fk_provincia", insertable = false, nullable = false)
	Provincia provincia;
		
	@Column(name = "riferimentitelefonici",length=50)
	private String riferimentitelefonici;
	
//	@Email
	@Column(name = "email", length= 150)
	private String email;
	
//	@Email
	@Column(name = "pec", length= 150)
	private String pec;

	public String getPec() {
		return pec;
	}

	public void setPec(String pec) {
		this.pec = pec;
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

	public String getRiferimentitelefonici() {
		return riferimentitelefonici;
	}

	public String getEmail() {
		return email;
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

	public void setRiferimentitelefonici(String riferimentitelefonici) {
		this.riferimentitelefonici = riferimentitelefonici;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}


	
}

