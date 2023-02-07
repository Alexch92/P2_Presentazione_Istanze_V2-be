package it.sincon.gepred.visura.rupar.bean;

import java.util.Date;

import com.google.gson.annotations.SerializedName;

public class RuoloRidotto {

    private String value;
    
    @SerializedName("c-tipo")
    private String codiceTipo;
    
    private String tipo;
    
    @SerializedName("n")
    private String numero;
    
    @SerializedName("c-ente-rilascio")
    private String codiceEnteRilascio;
    
    @SerializedName("ente-rilascio")
    private String enteRilascio;
    
    private String provincia;
    
    private Date data;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getCodiceTipo() {
		return codiceTipo;
	}

	public void setCodiceTipo(String codiceTipo) {
		this.codiceTipo = codiceTipo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCodiceEnteRilascio() {
		return codiceEnteRilascio;
	}

	public void setCodiceEnteRilascio(String codiceEnteRilascio) {
		this.codiceEnteRilascio = codiceEnteRilascio;
	}

	public String getEnteRilascio() {
		return enteRilascio;
	}

	public void setEnteRilascio(String enteRilascio) {
		this.enteRilascio = enteRilascio;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
    

}
