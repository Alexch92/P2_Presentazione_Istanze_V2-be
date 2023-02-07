package it.sincon.gepred.visura.rupar.bean;

public class Cariche {

	private Carica carica;

	public Carica getCarica() {
		return carica;
	}
	public void setCarica(Carica carica) {
		this.carica = carica;
	}


	public String toString()
	{
		String retValue = "->Cariche...";
		
		if (carica == null)
			retValue += "carica IS NULL";
		else {
			retValue += carica.toString();
		}
		
		return retValue;
	}
}
