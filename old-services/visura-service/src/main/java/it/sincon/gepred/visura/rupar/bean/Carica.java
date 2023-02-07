package it.sincon.gepred.visura.rupar.bean;

import com.google.gson.annotations.SerializedName;

public class Carica {

	
	private String value;
	
	@SerializedName("c-carica")
	private String codiceCarica;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getCodiceCarica() {
		return codiceCarica;
	}

	public void setCodiceCarica(String codiceCarica) {
		this.codiceCarica = codiceCarica;
	}
	
	public String toString()
	{
		String retValue = "->Carica:";
		
		if (codiceCarica == null)
			retValue += "codiceCarica IS NULL";
		else {
			retValue += "codiceCarica="+codiceCarica;
		}
		
		if (value == null)
			retValue += "value IS NULL";
		else {
			retValue += "value="+value;
		}
		
		return retValue;
	}
}
