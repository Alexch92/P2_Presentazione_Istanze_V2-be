package it.sincon.gepred.protocollo.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * Classe contenente i dati relativi il risultato di protocollazione di una pratica
 * 
 * @author Giuseppe Cellamare
 *
 */
public class DatiOutputProtocollo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String numeroProtocollo;
	private Date dataProtocollo;
	private Serializable idProtocollo;
	private DatiEsito esito;
	
	public String getNumeroProtocollo() {
		return numeroProtocollo;
	}
	public void setNumeroProtocollo(String numeroProtocollo) {
		this.numeroProtocollo = numeroProtocollo;
	}
	public Date getDataProtocollo() {
		return dataProtocollo;
	}
	public void setDataProtocollo(Date dataProtocollo) {
		this.dataProtocollo = dataProtocollo;
	}
	public Serializable getIdProtocollo() {
		return idProtocollo;
	}
	public void setIdProtocollo(Serializable idProtocollo) {
		this.idProtocollo = idProtocollo;
	}
	public DatiEsito getEsito() {
		return esito;
	}
	public void setEsito(DatiEsito esito) {
		this.esito = esito;
	}

}
