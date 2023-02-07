package it.sincon.gepred.visura.rupar.bean;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class AttiConferimentoCariche {

	@SerializedName("atto-conferimento-cariche")
	private List<AttoConferimentoCariche> attoConferimentoCariche;

	public List<AttoConferimentoCariche> getAttoConferimentoCariche() {
		return attoConferimentoCariche;
	}

	public void setAttoConferimentoCariche(List<AttoConferimentoCariche> attoConferimentoCariche) {
		this.attoConferimentoCariche = attoConferimentoCariche;
	}
	
	public String toString()
	{
		String retValue = "->AttiConferimentoCariche...";
		
		if (attoConferimentoCariche == null)
			retValue += "attoConferimentoCariche IS NULL";
		else {
			for (AttoConferimentoCariche acc : attoConferimentoCariche) {
				retValue += acc.toString();
			}
		}
		
		return retValue;
	}
}
