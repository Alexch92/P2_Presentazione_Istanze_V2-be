package it.sincon.gepred.protocollo.bean;

import java.io.Serializable;

/**
 * Classe contenente i dati relativi all'esito di una qualsiasi operazione relativa
 * alla protocollazione
 * 
 * @author Giuseppe Cellamare
 *
 */
public class DatiEsito implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String codice;
	private String descrizione;

	public String getCodice() {
		return codice;
	}
	public void setCodice(String codice) {
		this.codice = codice;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	
}
