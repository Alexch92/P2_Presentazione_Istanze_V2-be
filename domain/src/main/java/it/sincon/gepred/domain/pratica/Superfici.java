package it.sincon.gepred.domain.pratica;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 * The persistent class for the tb_superfice_web database table.
 * @author Maria Michela Birtolo
 * 
 */
@Entity
@Table(name = "tb_superfice_web")
public class Superfici extends AbstractPersistable<Long> implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "coperta",length=8 ,nullable=false)
	private String coperta;
	
	@Column(name = "scoperta",length=8 ,nullable=false)
	private String scoperta;
	
	@Column(name = "altezza",length=8 ,nullable=false)
	private String altezza;
	
	@Column(name = "sup_lorda",length=8 ,nullable=false)
	private String sup_lorda;
	
	@Column(name = "sup_utile",length=8 ,nullable=false)
	private String sup_utile;
	
	@Column(name = "volume",length=8 ,nullable=false)
	private String volume;

	@JoinColumn(name = "fk_pratica", insertable = false, nullable = false)
	private PraticaWeb praticaWeb;

	public PraticaWeb getPraticaWeb() {
		return praticaWeb;
	}

	public void setPraticaWeb(PraticaWeb praticaWeb) {
		this.praticaWeb = praticaWeb;
	}

	public String getCoperta() {
		return coperta;
	}

	public void setCoperta(String coperta) {
		this.coperta = coperta;
	}

	public String getScoperta() {
		return scoperta;
	}

	public void setScoperta(String scoperta) {
		this.scoperta = scoperta;
	}

	public String getAltezza() {
		return altezza;
	}

	public void setAltezza(String altezza) {
		this.altezza = altezza;
	}

	public String getSup_lorda() {
		return sup_lorda;
	}

	public void setSup_lorda(String sup_lorda) {
		this.sup_lorda = sup_lorda;
	}

	public String getSup_utile() {
		return sup_utile;
	}

	public void setSup_utile(String sup_utile) {
		this.sup_utile = sup_utile;
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

}

