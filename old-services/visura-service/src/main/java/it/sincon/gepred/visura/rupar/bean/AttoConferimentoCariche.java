package it.sincon.gepred.visura.rupar.bean;

import com.google.gson.annotations.SerializedName;

public class AttoConferimentoCariche {

	private Cariche cariche;
	
	@SerializedName("poteri-persona")
	private PoteriPersona poteriPersona;

	public Cariche getCariche() {
		return cariche;
	}

	public void setCariche(Cariche cariche) {
		this.cariche = cariche;
	}

	public PoteriPersona getPoteriPersona() {
		return poteriPersona;
	}

	public void setPoteriPersona(PoteriPersona poteriPersona) {
		this.poteriPersona = poteriPersona;
	}
	
	public String toString()
	{
		String retValue = "->AttoConferimentoCariche...";
		
		if (cariche == null)
			retValue += "cariche IS NULL";
		else {
			retValue += cariche.toString();
		}
		
		if (poteriPersona == null)
			retValue += "poteriPersona IS NULL";
		else {
			retValue += poteriPersona.toString();
		}
		
		return retValue;
	}
}
