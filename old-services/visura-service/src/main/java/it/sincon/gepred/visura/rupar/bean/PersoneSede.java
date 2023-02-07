package it.sincon.gepred.visura.rupar.bean;

import java.util.List;

public class PersoneSede {

	private List<Persona> persona;

	public List<Persona> getPersona() {
		return persona;
	}

	public void setPersona(List<Persona> persona) {
		this.persona = persona;
	}
	
	
	public String toString()
	{
		if (persona == null)
			return "->PersonaSede:persona IS NULL";
		else {
			String retValue = String.format("personaSede:persona (count=%s)...", persona.size());
			
			for (Persona persona2 : persona) {
				retValue += persona2.toString();
			}
			
			return retValue;
		}
	}
}
