package it.sincon.gepred.protocollo.bean;


import java.io.Serializable;

/**
 * Classe contenente i dati dei mittenti/destinatari di un protocollo
 * 
 * @author Giuseppe Cellamare
 *
 */
public class DatiMittenteDestinatario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long idMittenteDestinatario;
	private String nominativo;
	private String indirizzo;
	private String email;
	private MezzoSpedizioneEnum mezzoSpedizione;
	private boolean selezionatoPerCancellazione;
	private boolean invioPc;
	private boolean azienda;
	private String citta;
	private String nome;
	private String cognome;
	private String partitaIva;
	private String codiceFiscale;
	
	public Long getIdMittenteDestinatario() {
		return idMittenteDestinatario;
	}
	public void setIdMittenteDestinatario(Long idMittenteDestinatario) {
		this.idMittenteDestinatario = idMittenteDestinatario;
	}
	public String getNominativo() {
		return nominativo;
	}
	public void setNominativo(String nominativo) {
		this.nominativo = nominativo;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public MezzoSpedizioneEnum getMezzoSpedizione() {
		return mezzoSpedizione;
	}
	public void setMezzoSpedizione(MezzoSpedizioneEnum mezzoSpedizione) {
		this.mezzoSpedizione = mezzoSpedizione;
	}
	public boolean isSelezionatoPerCancellazione() {
		return selezionatoPerCancellazione;
	}
	public void setSelezionatoPerCancellazione(boolean selezionatoPerCancellazione) {
		this.selezionatoPerCancellazione = selezionatoPerCancellazione;
	}
	public boolean isInvioPc() {
		return invioPc;
	}
	public void setInvioPc(boolean invioPc) {
		this.invioPc = invioPc;
	}
	public boolean isAzienda() {
		return azienda;
	}
	public void setAzienda(boolean azienda) {
		this.azienda = azienda;
	}
	public String getCitta() {
		return citta;
	}
	public void setCitta(String citta) {
		this.citta = citta;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getPartitaIva() {
		return partitaIva;
	}
	public void setPartitaIva(String partitaIva) {
		this.partitaIva = partitaIva;
	}
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}
}
