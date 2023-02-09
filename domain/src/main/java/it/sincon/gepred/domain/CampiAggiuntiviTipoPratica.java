package it.sincon.gepred.domain;

import it.sincon.gepred.domain.pratica.TipoPratica;
import it.sincon.gepred.domain.pratica.Tab;

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
import javax.persistence.Transient;

//import org.eclipse.persistence.annotations.CascadeOnDelete;
import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 * Entity per i campi aggiuntivi associati al Tipo Pratica
 * 
 * @author Angelo Pascadopoli
 *
 */
@Entity
@Table(name = "tb_tipopratica_cagg")
public class CampiAggiuntiviTipoPratica extends AbstractPersistable<Long> implements Serializable {
	
	private static final long serialVersionUID = 8749629984265310558L;
	
	@Column(name = "posizione", nullable = false)
	private int posizione;
	
	@Column(name = "config_cagg", nullable = false)
	private byte config_cagg;
	
	@JoinColumn(name = "tipopratica_id", insertable = false, nullable = false)
	TipoPratica tipoPratica;

	@JoinColumn(name = "campiaggiuntivi_id", insertable = false, nullable = false)
	CampiAggiuntivi campiAggiuntivi;
	
	@JoinColumn(name = "tab_id", insertable = false, nullable = false)
	Tab tab;
	
	@Transient
	private int backFrontEnd;
	
	public int getPosizione() {
		return posizione;
	}

	public void setPosizione(int posizione) {
		this.posizione = posizione;
	}

	public byte getConfig_cagg() {
		return config_cagg;
	}

	public void setConfig_cagg(byte config_cagg) {
		this.config_cagg = config_cagg;
	}

	public TipoPratica getTipoPratica() {
		return tipoPratica;
	}

	public void setTipoPratica(TipoPratica tipoPratica) {
		this.tipoPratica = tipoPratica;
	}

	public CampiAggiuntivi getCampiAggiuntivi() {
		return campiAggiuntivi;
	}

	public void setCampiAggiuntivi(CampiAggiuntivi campiAggiuntivi) {
		this.campiAggiuntivi = campiAggiuntivi;
	}

	public int getBackFrontEnd() {
		return backFrontEnd;
	}

	public void setBackFrontEnd(int backFrontEnd) {
		this.backFrontEnd = backFrontEnd;
	}

	public Tab getTab() {
		return tab;
	}

	public void setTab(Tab tab) {
		this.tab = tab;
	}
	
}
