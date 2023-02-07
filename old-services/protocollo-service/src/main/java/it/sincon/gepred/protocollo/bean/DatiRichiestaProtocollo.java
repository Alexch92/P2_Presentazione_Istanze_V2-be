package it.sincon.gepred.protocollo.bean;

import java.io.Serializable;
import java.util.List;


/**
 * Classe contenente i dati relativi alla richiesta protocollo di una pratica
 * 
 * @author Giuseppe Cellamare
 * 
 */

public class DatiRichiestaProtocollo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String oggetto;
	private DatiOutputProtocollo datiProtocollazione;
	private List<DatiMittenteDestinatario> mittenteDestinatario;
	private List<AllegatoProtocollo> allegati;
	private String tipoProtocollo;
	private String registro;
	private boolean timbro;
	private AllegatoProtocollo documentoPrincipale;
	private DatiEsito esito;
	
	public String getOggetto() {
		return oggetto;
	}
	public void setOggetto(String oggetto) {
		this.oggetto = oggetto;
	}
	public DatiOutputProtocollo getDatiProtocollazione() {
		return datiProtocollazione;
	}
	public void setDatiProtocollazione(DatiOutputProtocollo datiProtocollazione) {
		this.datiProtocollazione = datiProtocollazione;
	}
	public List<DatiMittenteDestinatario> getMittenteDestinatario() {
		return mittenteDestinatario;
	}
	public void setMittenteDestinatario(
			List<DatiMittenteDestinatario> mittenteDestinatario) {
		this.mittenteDestinatario = mittenteDestinatario;
	}
	public List<AllegatoProtocollo> getAllegati() {
		return allegati;
	}
	public void setAllegati(List<AllegatoProtocollo> allegati) {
		this.allegati = allegati;
	}
	public String getTipoProtocollo() {
		return tipoProtocollo;
	}
	public void setTipoProtocollo(String tipoProtocollo) {
		this.tipoProtocollo = tipoProtocollo;
	}
	public String getRegistro() {
		return registro;
	}
	public void setRegistro(String registro) {
		this.registro = registro;
	}
	public boolean isTimbro() {
		return timbro;
	}
	public void setTimbro(boolean timbro) {
		this.timbro = timbro;
	}
	public AllegatoProtocollo getDocumentoPrincipale() {
		return documentoPrincipale;
	}
	public void setDocumentoPrincipale(AllegatoProtocollo documentoPrincipale) {
		this.documentoPrincipale = documentoPrincipale;
	}
	public DatiEsito getEsito() {
		return esito;
	}
	public void setEsito(DatiEsito esito) {
		this.esito = esito;
	}
}
