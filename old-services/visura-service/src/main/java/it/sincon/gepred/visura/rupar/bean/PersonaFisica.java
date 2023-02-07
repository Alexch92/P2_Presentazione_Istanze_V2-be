package it.sincon.gepred.visura.rupar.bean;

import com.google.gson.annotations.SerializedName;

public class PersonaFisica {

	@SerializedName("estremi-nascita")
	private EstremiNascita estremiNascita;
	
	private String cognome;
	
	private String nome;
	
	@SerializedName("c-fiscale")
	private String codiceFiscale;

	public EstremiNascita getEstremiNascita() {
		return estremiNascita;
	}

	public void setEstremiNascita(EstremiNascita estremiNascita) {
		this.estremiNascita = estremiNascita;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}
	
	public String toString()
	{
		String retValue = "PersonaFisica:";
		
		if (cognome == null)
			retValue += "cognome IS NULL";
		else {
			retValue += "cognome="+cognome;
		}
		
		if (nome == null)
			retValue += "nome IS NULL";
		else {
			retValue += "nome="+nome;
		}
		
		if (codiceFiscale == null)
			retValue += "codiceFiscale IS NULL";
		else {
			retValue += "codiceFiscale="+codiceFiscale;
		}
		
		return retValue;
	}
}
