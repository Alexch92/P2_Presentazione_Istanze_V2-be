package it.sincon.gepred.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 * Classe che definisce l'esito del parere
 * @author Maria Michela Birtolo
 */
@Entity
@Table(name = "tb_quartiere")
public class Quartiere extends AbstractPersistable<Long> implements Serializable {

	private static final long serialVersionUID = -247798258529795889L;
	
	@Column(name="descrizione", length=255)
	private String descrizione;

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
}
