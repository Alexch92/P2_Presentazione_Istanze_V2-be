package it.sincon.gepred.protocollo.bean;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

public class AllegatoProtocollo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long idAllegato;
	private String urlAllegato;
	private String nomeDocumento;
	private MultipartFile allegato;
	private boolean daAllegareProtocollazione;
	private String collocazione;
	private byte[] contenutoAllegato;
	
	public Long getIdAllegato() {
		return idAllegato;
	}
	public void setIdAllegato(Long idAllegato) {
		this.idAllegato = idAllegato;
	}
	public String getUrlAllegato() {
		return urlAllegato;
	}
	public void setUrlAllegato(String urlAllegato) {
		this.urlAllegato = urlAllegato;
	}
	public String getNomeDocumento() {
		return nomeDocumento;
	}
	public void setNomeDocumento(String nomeDocumento) {
		this.nomeDocumento = nomeDocumento;
	}
	public MultipartFile getAllegato() {
		return allegato;
	}
	public void setAllegato(MultipartFile allegato) {
		this.allegato = allegato;
	}
	public boolean isDaAllegareProtocollazione() {
		return daAllegareProtocollazione;
	}
	public void setDaAllegareProtocollazione(boolean daAllegareProtocollazione) {
		this.daAllegareProtocollazione = daAllegareProtocollazione;
	}
	public String getCollocazione() {
		return collocazione;
	}
	public void setCollocazione(String collocazione) {
		this.collocazione = collocazione;
	}
	public byte[] getContenutoAllegato() {
		return contenutoAllegato;
	}
	public void setContenutoAllegato(byte[] contenutoAllegato) {
		this.contenutoAllegato = contenutoAllegato;
	}
	
}
