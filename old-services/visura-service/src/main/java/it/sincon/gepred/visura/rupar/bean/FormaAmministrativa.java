package it.sincon.gepred.visura.rupar.bean;

import com.google.gson.annotations.SerializedName;

public class FormaAmministrativa {

	private String value;
	
	@SerializedName("c")
	private String codice;

	@SerializedName("f-in-carica")
	private String flagInCarica;
	
	@SerializedName("f-organo-controllo")
	private String flagOrganoControllo;
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public String getFlagInCarica() {
		return flagInCarica;
	}

	public void setFlagInCarica(String flagInCarica) {
		this.flagInCarica = flagInCarica;
	}

	public String getFlagOrganoControllo() {
		return flagOrganoControllo;
	}

	public void setFlagOrganoControllo(String flagOrganoControllo) {
		this.flagOrganoControllo = flagOrganoControllo;
	}
	
	

}
