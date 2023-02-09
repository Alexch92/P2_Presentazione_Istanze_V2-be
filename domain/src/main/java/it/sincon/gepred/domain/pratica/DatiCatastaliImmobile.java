package it.sincon.gepred.domain.pratica;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.data.jpa.domain.AbstractPersistable;

import it.osapulie.domain.Comune;

/**
 * The persistent class for the tb_immobile database table.
 * @author Maria Michela Birtolo
 * 
 */
@Entity
@Table(name = "tb_immobile_web")
public class DatiCatastaliImmobile extends AbstractPersistable<Long> implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "num",length=5 ,nullable=false)
	private String num;
	
	@Column(name = "immobile_comune",length=50 ,nullable=true)
	private String immobile_comune;
	
	@Column(name = "immobile_provincia",length=50 ,nullable=true)
	private String immobile_provincia;
	
	@Column(name = "immobile_cod_comune_catastale",length=4 ,nullable=true)
	private String immobile_codComuneCatastale;
	
	@Column(name = "immobile_indirizzo",length=255 ,nullable=true)
	private String immobile_indirizzo;
	
	@Column(name = "immobile_foglio_nceu",length=5 ,nullable=false)
	private String immobile_foglioNCEU;
	
	@Column(name = "immobile_part_nceu",length=50 ,nullable=false)
	private String immobile_partNCEU;
	
	@Column(name = "immobile_sub_nceu",length=5 ,nullable=false)
	private String immobile_subNCEU;
	
	@Column(name = "immobile_cat_nceu",length=5 ,nullable=false)
	private String immobile_catNCEU;
	
	@Column(name = "immobile_foglio_nct",length=5 ,nullable=false)
	private String immobile_foglioNCT;
	
	@Column(name = "immobile_part_nct",length=50 ,nullable=false)
	private String immobile_partNCT;
	
	@Column(name = "immobile_sub_nct",length=5 ,nullable=false)
	private String immobile_subNCT;

	@JoinColumn(name = "fk_pratica_web", insertable = false, nullable = false)
	private PraticaWeb praticaWeb;
	
	@JoinColumn(name = "fk_pratica", insertable = false, nullable = true)
	private Pratica pratica;
	
	@Transient
	private String immobile_denomComune;
	
	@Override
	public void setId(Long id) {
		super.setId(id);
	}
	
	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getImmobile_foglioNCEU() {
		return immobile_foglioNCEU;
	}

	public void setImmobile_foglioNCEU(String immobile_foglioNCEU) {
		this.immobile_foglioNCEU = immobile_foglioNCEU;
	}

	public String getImmobile_partNCEU() {
		return immobile_partNCEU;
	}

	public void setImmobile_partNCEU(String immobile_partNCEU) {
		this.immobile_partNCEU = immobile_partNCEU;
	}

	public String getImmobile_subNCEU() {
		return immobile_subNCEU;
	}

	public void setImmobile_subNCEU(String immobile_subNCEU) {
		this.immobile_subNCEU = immobile_subNCEU;
	}

	public String getImmobile_catNCEU() {
		return immobile_catNCEU;
	}

	public void setImmobile_catNCEU(String immobile_catNCEU) {
		this.immobile_catNCEU = immobile_catNCEU;
	}

	public String getImmobile_foglioNCT() {
		return immobile_foglioNCT;
	}

	public void setImmobile_foglioNCT(String immobile_foglioNCT) {
		this.immobile_foglioNCT = immobile_foglioNCT;
	}

	public String getImmobile_partNCT() {
		return immobile_partNCT;
	}

	public void setImmobile_partNCT(String immobile_partNCT) {
		this.immobile_partNCT = immobile_partNCT;
	}

	public String getImmobile_subNCT() {
		return immobile_subNCT;
	}

	public void setImmobile_subNCT(String immobile_subNCT) {
		this.immobile_subNCT = immobile_subNCT;
	}

	public PraticaWeb getPraticaWeb() {
		return praticaWeb;
	}

	public void setPraticaWeb(PraticaWeb praticaWeb) {
		this.praticaWeb = praticaWeb;
	}

	public Pratica getPratica() {
		return pratica;
	}

	public void setPratica(Pratica pratica) {
		this.pratica = pratica;
	}

	public String getImmobile_comune() {
		return immobile_comune;
	}
	public void setImmobile_comune(String immobile_comune) {
		this.immobile_comune = immobile_comune;
	}
	public String getImmobile_provincia() {
		return immobile_provincia;
	}
	public void setImmobile_provincia(String immobile_provincia) {
		this.immobile_provincia = immobile_provincia;
	}
	public String getImmobile_codComuneCatastale() {
		return immobile_codComuneCatastale;
	}
	public void setImmobile_codComuneCatastale(String immobile_codComuneCatastale) {
		this.immobile_codComuneCatastale = immobile_codComuneCatastale;
	}
	public String getImmobile_indirizzo() {
		return immobile_indirizzo;
	}
	public void setImmobile_indirizzo(String immobile_indirizzo) {
		this.immobile_indirizzo = immobile_indirizzo;
	}

	public String getImmobile_denomComune() {
		if (immobile_comune != null){
			return String.format("%s (%s) [cod. %s]", immobile_comune, immobile_provincia, immobile_codComuneCatastale);		
		}
		else {
			return null;
		}
	}

	public void setImmobile_denomComune(String immobile_denomComune) {
		this.immobile_denomComune = immobile_denomComune;
	}
	
}

