package it.sincon.gepred.domain.pratica;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import javax.persistence.JoinColumn;


import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 * Classe che definisce il modello di pratica
 * @author Eligio Cavallo 
 */
@Entity
@Table(name = "tb_modelli")
public class Modelli extends AbstractPersistable<Long> implements Serializable {

	private static final long serialVersionUID = -247798258529795889L;
	
	@Column(name="nome", length=255)
	private String nome;

	@Column(name="contenuto")
	private byte[] contenuto;
	
	@Column(name="estensione",length = 10)
	private String estensione;
	
	@Column(name = "tipo_contenuto" ,length = 255)
	private String tipoContenuto;
	
	@JoinColumn(name="fk_tipologia", insertable = false, nullable = false)
	TipoPratica tipoPratica;
	
	@Column(name = "nome_file_report_jasper" ,length = 255)
	private String nomeFileReportJasper;
	
	@Column(name = "for_pratica_web",length = 1)
	private boolean web;


	public TipoPratica getTipoPratica() {
		return tipoPratica;
	}

	public void setTipoPratica(TipoPratica tipoPratica) {
		this.tipoPratica = tipoPratica;
	}

	public String getNome() {
		return nome;
	}

	public byte[] getContenuto() {
		return contenuto;
	}

	public void setContenuto(byte[] contenuto) {
		this.contenuto = contenuto;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEstensione() {
		return estensione;
	}

	public void setEstensione(String estensione) {
		this.estensione = estensione;
	}

	public String getTipoContenuto() {
		return tipoContenuto;
	}

	public void setTipoContenuto(String tipoContenuto) {
		this.tipoContenuto = tipoContenuto;
	}
	
	public String getNomeFileReportJasper() {
		return nomeFileReportJasper;
	}

	public void setNomeFileReportJasper(String nomeFileReportJasper) {
		this.nomeFileReportJasper = nomeFileReportJasper;
	}

	public boolean isWeb() {
		return web;
	}

	public void setWeb(boolean web) {
		this.web = web;
	}
}
