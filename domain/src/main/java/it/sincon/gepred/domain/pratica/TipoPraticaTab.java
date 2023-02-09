package it.sincon.gepred.domain.pratica;

import it.osapulie.domain.Ruolo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;
import javax.persistence.JoinTable;



import org.springframework.data.jpa.domain.AbstractPersistable;


@Entity
@Table(name="tb_tipopratica_tab")
public class TipoPraticaTab extends AbstractPersistable<Long> implements Serializable{

	private static final long serialVersionUID = 1L;

	@Column(name="modifica_referente",nullable=false,length=1)
	private boolean modificaReferente;
	
	@Column(name="modifica_assegnatario",nullable=false,length=1)
	private boolean modificaAssegnatario;
	
	@JoinColumn(name="tipopratica_id",insertable=false,nullable=false)
	TipoPratica tipoPratica;
	
	@JoinColumn(name="tab_id",insertable=false, nullable=false)
	Tab tab;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "tb_tipopratica_tab_ruolo", inverseJoinColumns = { @JoinColumn(name="ruolo_id", referencedColumnName = "ID") },  joinColumns = @JoinColumn(name = "tipopratica_tab_id", referencedColumnName = "ID"))
	List<Ruolo> ruoliScrittura;

	@Override
	public void setId(Long id) {
		super.setId(id);
	}
	
	public boolean isModificaReferente() {
		return modificaReferente;
	}

	public void setModificaReferente(boolean modificaReferente) {
		this.modificaReferente = modificaReferente;
	}

	public boolean isModificaAssegnatario() {
		return modificaAssegnatario;
	}

	public void setModificaAssegnatario(boolean modificaAssegnatario) {
		this.modificaAssegnatario = modificaAssegnatario;
	}

	public TipoPratica getTipoPratica() {
		return tipoPratica;
	}

	public void setTipoPratica(TipoPratica tipoPratica) {
		this.tipoPratica = tipoPratica;
	}

	public Tab getTab() {
		return tab;
	}

	public void setTab(Tab tab) {
		this.tab = tab;
	}

	public List<Ruolo> getRuoliScrittura() {
		return ruoliScrittura;
	}

	public void setRuoliScrittura(List<Ruolo> ruoliScrittura) {
		this.ruoliScrittura = ruoliScrittura;
	}
	
}
