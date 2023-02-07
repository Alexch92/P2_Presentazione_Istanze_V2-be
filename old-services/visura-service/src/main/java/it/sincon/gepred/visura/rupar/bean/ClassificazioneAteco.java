package it.sincon.gepred.visura.rupar.bean;

import com.google.gson.annotations.SerializedName;

public class ClassificazioneAteco {
	
    private String value;
    
    @SerializedName("c-attivita")
    private String codiceAttivita;
    
    private String attivita;
    
    @SerializedName("c-importanza")
    private String codiceImportanza;
    
    private String importanza;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getCodiceAttivita() {
		return codiceAttivita;
	}

	public void setCodiceAttivita(String codiceAttivita) {
		this.codiceAttivita = codiceAttivita;
	}

	public String getAttivita() {
		return attivita;
	}

	public void setAttivita(String attivita) {
		this.attivita = attivita;
	}

	public String getCodiceImportanza() {
		return codiceImportanza;
	}

	public void setCodiceImportanza(String codiceImportanza) {
		this.codiceImportanza = codiceImportanza;
	}

	public String getImportanza() {
		return importanza;
	}

	public void setImportanza(String importanza) {
		this.importanza = importanza;
	}


}
