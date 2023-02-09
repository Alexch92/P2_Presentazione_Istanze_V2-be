package it.sincon.gepred.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 * @author Giuseppe Cellamare
 *
 */
@Entity
@Table(name = "tb_campiaggiuntivi_listavalori")
public class CampiAggiuntiviListaValori extends AbstractPersistable<Long> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1017326830054528119L;

	@Column(name = "valore", nullable = false)
	private String valore;
	
	@JoinColumn(name = "fk_campoaggiuntivo", nullable = false)
	private CampiAggiuntivi campiAggiuntivi;
	
	@ManyToOne
	@JoinColumn(name = "fk_parent")
	private CampiAggiuntiviListaValori parent;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "parent")
	private List<CampiAggiuntiviListaValori> children;

	public String getValore() {
		return valore;
	}

	public void setValore(String valore) {
		this.valore = valore;
	}

	public CampiAggiuntivi getCampiAggiuntivi() {
		return campiAggiuntivi;
	}

	public void setCampiAggiuntivi(CampiAggiuntivi campiAggiuntivi) {
		this.campiAggiuntivi = campiAggiuntivi;
	}

	public CampiAggiuntiviListaValori getParent() {
		return parent;
	}

	public void setParent(CampiAggiuntiviListaValori parent) {
		this.parent = parent;
	}

	public List<CampiAggiuntiviListaValori> getChildren() {
		return children;
	}

	public void setChildren(List<CampiAggiuntiviListaValori> children) {
		this.children = children;
	}
	
}
