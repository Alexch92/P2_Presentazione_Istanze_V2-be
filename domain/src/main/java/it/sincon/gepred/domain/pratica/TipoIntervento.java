package it.sincon.gepred.domain.pratica;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Locale;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 * Classe che contiene i dati sulla tipologia di intervento
 * @author Antonio Santomauro
 */
@Entity
@Table(name = "tb_tipointervento")
public class TipoIntervento extends AbstractPersistable<Long> implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1672642453678627404L;
	@Column(name="descrizione", length=255)
	private String descrizione;
	
	@Column(name="classe")
	private int classe;
	
	
	@Column(name="unita_misura", length=255)
	private String unitaMisura;
	
	@Column(name="contributo_max")
	private double contributoMax;
	
	@Transient
	private String contributoMaxString;
	
	public String getDescrizione() {		
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public int getClasse() {
		return classe;
	}

	public void setClasse(int classe) {
		this.classe = classe;
	}

	public String getUnitaMisura() {
		return unitaMisura;
	}

	public void setUnitaMisura(String unitaMisura) {
		this.unitaMisura = unitaMisura;
	}

	public double getContributoMax() {
		return contributoMax;
	}

	public void setContributoMax(double controbutoMax) {
		this.contributoMax = controbutoMax;
	}
	
	public String getContributoMaxString() {
		return DecimalFormat.getCurrencyInstance(Locale.ITALY).format(contributoMax);
	}
}
