package it.sincon.gepred.visura.rupar.bean;

import com.google.gson.annotations.SerializedName;

public class IndirizzoLocalizzazione {
	
    private String value;
    
    @SerializedName("c-comune")
    private String codiceComune;
    
    private String comune;
    
    private String provincia;
    
    @SerializedName("c-toponimo")
    private String codiceToponimo;
    
    private String toponimo;
    
    private String via;
    
    @SerializedName("n-civico")
    private String numeroCivico;
    
    private String cap;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getCodiceComune() {
		return codiceComune;
	}

	public void setCodiceComune(String codiceComune) {
		this.codiceComune = codiceComune;
	}

	public String getComune() {
		return comune;
	}

	public void setComune(String comune) {
		this.comune = comune;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getCodiceToponimo() {
		return codiceToponimo;
	}

	public void setCodiceToponimo(String codiceToponimo) {
		this.codiceToponimo = codiceToponimo;
	}

	public String getToponimo() {
		return toponimo;
	}

	public void setToponimo(String toponimo) {
		this.toponimo = toponimo;
	}

	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	public String getNumeroCivico() {
		return numeroCivico;
	}

	public void setNumeroCivico(String numeroCivico) {
		this.numeroCivico = numeroCivico;
	}

	public String getCap() {
		return cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}
    
    

}
