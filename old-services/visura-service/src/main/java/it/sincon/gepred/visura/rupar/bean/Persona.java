package it.sincon.gepred.visura.rupar.bean;

import com.google.gson.annotations.SerializedName;

public class Persona {

	@SerializedName("persona-fisica")
	private PersonaFisica personaFisica;
	
	@SerializedName("atti-conferimento-cariche")
	private AttiConferimentoCariche attiConferimentoCariche;
	
	private int progressivo;

	public PersonaFisica getPersonaFisica() {
		return personaFisica;
	}

	public void setPersonaFisica(PersonaFisica personaFisica) {
		this.personaFisica = personaFisica;
	}

	public AttiConferimentoCariche getAttiConferimentoCariche() {
		return attiConferimentoCariche;
	}

	public void setAttiConferimentoCariche(AttiConferimentoCariche attiConferimentoCariche) {
		this.attiConferimentoCariche = attiConferimentoCariche;
	}

	public int getProgressivo() {
		return progressivo;
	}

	public void setProgressivo(int progressivo) {
		this.progressivo = progressivo;
	}
	
	public String toString()
	{
		String retValue = String.format("->Persona:progressivo=%s...", progressivo);
		
		if (personaFisica == null)
			retValue += "personaFisica IS NULL";
		else {
			retValue += personaFisica.toString();
		}
		
		if (attiConferimentoCariche == null)
			retValue += "attiConferimentoCariche IS NULL";
		else {
			retValue += attiConferimentoCariche.toString();
		}
		
		return retValue;
	}
}
