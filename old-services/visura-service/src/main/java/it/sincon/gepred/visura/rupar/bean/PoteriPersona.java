package it.sincon.gepred.visura.rupar.bean;

import com.google.gson.annotations.SerializedName;

public class PoteriPersona {

	private String value;
	
	@SerializedName("p-poteri")
	private int prioritaPoteri;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int getPrioritaPoteri() {
		return prioritaPoteri;
	}

	public void setPrioritaPoteri(int prioritaPoteri) {
		this.prioritaPoteri = prioritaPoteri;
	}
	
	public String toString()
	{
		String retValue = "->PoteriPersona:";
		
		retValue += " prioritaPoteri="+prioritaPoteri;
		
		if (value == null)
			retValue += " value IS NULL";
		else {
			retValue += " value="+value;
		}
		
		return retValue;
	}
}
