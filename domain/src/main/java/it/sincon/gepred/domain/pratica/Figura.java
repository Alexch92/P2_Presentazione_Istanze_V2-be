package it.sincon.gepred.domain.pratica;


import java.io.Serializable;

import it.sincon.gepred.domain.Referente;
import it.sincon.gepred.domain.pratica.Qualifica;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name="tb_figura_pratica")
/**
 * The persistent class for the tb_figura_pratica database table.
 * @author Maria Michela Birtolo
 */
public class Figura extends AbstractPersistable<Long> implements Serializable{
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@JoinColumn(name="fk_qualifica", insertable = false, nullable = false)
	Qualifica qualifica;
	
	@JoinColumn(name="fk_referente", insertable = false, nullable = false)
	Referente referente;
	
	@JoinColumn(name="fk_pratica", insertable = false, nullable = false)
	Pratica pratica;
	
	public Qualifica getQualifica() {
		return qualifica;
	}

	public void setQualifica(Qualifica qualifica) {
		this.qualifica = qualifica;
	}

	public Referente getReferente() {
		return referente;
	}

	public void setReferente(Referente referente) {
		this.referente = referente;
	}

	public Pratica getPratica() {
		return pratica;
	}

	public void setPratica(Pratica pratica) {
		this.pratica = pratica;
	}	
}
