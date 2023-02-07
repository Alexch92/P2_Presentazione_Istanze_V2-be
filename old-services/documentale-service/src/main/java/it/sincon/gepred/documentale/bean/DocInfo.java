package it.sincon.gepred.documentale.bean;

import java.util.Date;

/**
 * Classe che rappresenta le informazioni di un Documento presente nel Documentale. 
 * @author Santomauro
 *
 */
public class DocInfo {
	
	private String titolo;
	private String tipologia;
	private String creator;
	private Date dataCreazione;
	private Boolean protocollato;
	private Date dataProtocollo;
	private String numeroProtocollo;
	private String tipoProtocollo;
	private String note;
	private String uuid;
	private DocFile file;
	
	public DocInfo() {}

	public DocInfo(DocInfo _input){
		this.titolo = _input.getTitolo();
		this.tipologia = _input.getTipologia();
		this.creator = _input.getCreator();
		this.dataCreazione = _input.getDataCreazione();
		this.protocollato = _input.getProtocollato();
		this.dataProtocollo = _input.getDataProtocollo();
		this.numeroProtocollo = _input.getNumeroProtocollo();
		this.tipoProtocollo = _input.getTipoProtocollo();
		this.note = _input.getNote();
		this.uuid = _input.getUuid();
		
		this.file = new DocFile(_input.getFile());
	}
	
	/**
	 * 
	 * @return
	 */
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String _titolo) {
		this.titolo = _titolo;
	}
	public String getTipologia() {
		return tipologia;
	}
	public void setTipologia(String _tipologia) {
		this.tipologia = _tipologia;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String _creator) {
		this.creator = _creator;
	}
	public Date getDataCreazione() {
		return dataCreazione;
	}
	public void setDataCreazione(Date _dataCreazione) {
		this.dataCreazione = _dataCreazione;
	}
	public Boolean getProtocollato() {
		return protocollato;
	}
	public void setProtocollato(Boolean _protocollato) {
		this.protocollato = _protocollato;
	}
	public Date getDataProtocollo() {
		return dataProtocollo;
	}
	public void setDataProtocollo(Date _dataProtocollo) {
		this.dataProtocollo = _dataProtocollo;
	}
	public String getNumeroProtocollo() {
		return numeroProtocollo;
	}
	public void setNumeroProtocollo(String _numeroProtocollo) {
		this.numeroProtocollo = _numeroProtocollo;
	}
	public String getTipoProtocollo() {
		return tipoProtocollo;
	}
	public void setTipoProtocollo(String _tipoProtocollo) {
		this.tipoProtocollo = _tipoProtocollo;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public DocFile getFile() {
		return file;
	}
	public void setFile(DocFile file) {
		this.file = file;
	}

}
