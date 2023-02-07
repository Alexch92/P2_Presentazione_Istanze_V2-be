package it.sincon.gepred.documentale.bean;

/**
 * Classe che rappresenta le informazioni di un file gestito dal Documentale
 * @author Santomauro
 *
 */
public class DocFile {
	private String uuid;
	private String nome;
	private String mimeType;
	private String encoding;
	private String dimensione;
	private byte[] content;
	
	public DocFile() {}
	
	public DocFile(DocFile _input){
		this.uuid = _input.getUuid();
		this.nome = _input.getNome();
		this.mimeType = _input.getMimeType();
		this.encoding = _input.getEncoding();
		this.dimensione = _input.getDimensione();
		this.content = _input.getContent();
	}
	
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String _nome) {
		this.nome = _nome;
	}
	public String getMimeType() {
		return mimeType;
	}
	public void setMimeType(String _mimeType) {
		this.mimeType = _mimeType;
	}
	public String getEncoding() {
		return encoding;
	}
	public void setEncoding(String _encoding) {
		this.encoding = _encoding;
	}
	public String getDimensione() {
		return dimensione;
	}
	public void setDimensione(String _dimensione) {
		this.dimensione = _dimensione;
	}
	public byte[] getContent() {
		return content;
	}
	public void setContent(byte[] _content) {
		this.content = _content;
	}
}
