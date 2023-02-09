package it.sincon.gepred.domain;

import it.sincon.gepred.domain.pratica.TipoPratica;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import org.springframework.data.jpa.domain.AbstractPersistable;
/**
 * @author Maria Michela Birtolo
 *
 */
@Entity
@Table(name = "tb_allegati")
public class Allegati extends AbstractPersistable<Long> implements Serializable{

	private static final long serialVersionUID = 1L;

	@Column(name = "nomeDocumento",length=255 ,nullable = false)
	private String nomeDocumento;
	
	@Column(name = "posizione",length=3, nullable = false)
	private Integer posizione;
	
	@Column(name = "obbligatorio",length=1,nullable = true)
	private boolean obbligatorio;
	
	@Column(name = "controllo",length=512,nullable = true)
	private String controllo;
	
	@Column(name = "urlModelloDaCompilare",length=512,nullable = true)
	private String urlModelloDaCompilare;
	
	@Column(name = "is_modello_jasper",length=1,nullable = true)
	private boolean modDaCompilareJasper;
	
	@JoinColumn(name = "fk_tipopratica", nullable = true)
	private TipoPratica tipoPratica;
	
	@Column(name = "visibile_online",length=1,nullable = true)
	private boolean visibileOnLine;
	
	public boolean isObbligatorio() {
		return obbligatorio;
	}

	public void setObbligatorio(boolean obbligatorio) {
		this.obbligatorio = obbligatorio;
	}

	public Integer getPosizione() {
		return posizione;
	}

	public void setPosizione(Integer posizione) {
		this.posizione = posizione;
	}

	public TipoPratica getTipoPratica() {
		return tipoPratica;
	}

	public void setTipoPratica(TipoPratica tipoPratica) {
		this.tipoPratica = tipoPratica;
	}

	public String getNomeDocumento() {
		return nomeDocumento;
	}

	public void setNomeDocumento(String nomeDocumento) {
		this.nomeDocumento = nomeDocumento;
	}

	public String getControllo() {
		return controllo;
	}

	public void setControllo(String controllo) {
		this.controllo = controllo;
	}

	public String getUrlModelloDaCompilare() {
		return urlModelloDaCompilare;
	}

	public void setUrlModelloDaCompilare(String urlModelloDaCompilare) {
		this.urlModelloDaCompilare = urlModelloDaCompilare;
	}

	public boolean isModDaCompilareJasper() {
		return modDaCompilareJasper;
	}

	public void setModDaCompilareJasper(boolean modDaCompilareJasper) {
		this.modDaCompilareJasper = modDaCompilareJasper;
	}

	public boolean isVisibileOnLine() {
		return visibileOnLine;
	}

	public void setVisibileOnLine(boolean visibileOnLine) {
		this.visibileOnLine = visibileOnLine;
	}
	
}
