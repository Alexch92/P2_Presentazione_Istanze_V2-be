package it.sincon.gepred.web.portlet.varie;

import java.io.Serializable;

public class DatiConsuntivoPratica implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3589138160623199523L;
	
	private String nomeReferente;
	private String cognomeReferente;
	private Long numeroPratiche;
	
	
	public DatiConsuntivoPratica(String nomeReferente, String cognomeReferente,
			Long numeroPratiche) {
		super();
		this.nomeReferente = nomeReferente;
		this.cognomeReferente = cognomeReferente;
		this.numeroPratiche = numeroPratiche;
	}
	
	public String getNomeReferente() {
		return nomeReferente;
	}
	public void setNomeReferente(String nomeReferente) {
		this.nomeReferente = nomeReferente;
	}
	public String getCognomeReferente() {
		return cognomeReferente;
	}
	public void setCognomeReferente(String cognomeReferente) {
		this.cognomeReferente = cognomeReferente;
	}
	public Long getNumeroPratiche() {
		return numeroPratiche;
	}
	public void setNumeroPratiche(Long numeroPratiche) {
		this.numeroPratiche = numeroPratiche;
	}
	
	
}
