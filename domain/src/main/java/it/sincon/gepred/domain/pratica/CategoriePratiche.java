package it.sincon.gepred.domain.pratica;

import it.osapulie.domain.Ruolo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "tb_categorie_pratiche")
public class CategoriePratiche extends AbstractPersistable<Long> implements
		Serializable {

	private static final long serialVersionUID = 93475320971287639L;
	public static final String SEPARATORE = " - ";

	@Column(name = "descrizione", length = 255, nullable = false)
	private String descr;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "parent")
	private List<CategoriePratiche> children;

	@ManyToOne
	@JoinColumn(name = "parent_id")
	private CategoriePratiche parent;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "categoria")
	private List<TipoPratica> tipoPratica;
	
	@ManyToMany(mappedBy = "categorieAbilitate", fetch = FetchType.EAGER)
	private List<Ruolo> ruolo;

	public void setId(Long id) {
		super.setId(id);
	}
	
	public List<Ruolo> getRuolo() {
		return ruolo;
	}

	public void setRuolo(List<Ruolo> ruolo) {
		this.ruolo = ruolo;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public List<CategoriePratiche> getChildren() {
		return children;
	}

	public void setChildren(List<CategoriePratiche> children) {
		this.children = children;
	}

	public CategoriePratiche getParent() {
		return parent;
	}

	public void setParent(CategoriePratiche parent) {
		this.parent = parent;
	}

	public List<TipoPratica> getTipoPratica() {
		return tipoPratica;
	}

	public void setTipoPratica(List<TipoPratica> tipoPratica) {
		this.tipoPratica = tipoPratica;
	}

	public String getNomeCompletoCategoria() {
		String result = "";
		if (parent != null)
			result = parent.getNomeCompletoCategoria() + SEPARATORE;
		result += descr;
		return result;
	}

}
