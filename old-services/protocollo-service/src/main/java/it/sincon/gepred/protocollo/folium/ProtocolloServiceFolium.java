package it.sincon.gepred.protocollo.folium;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import it.sincon.gepred.protocollo.adoc.ProtocolloServiceAdoc;
import it.sincon.gepred.protocollo.bean.AllegatoProtocollo;
import it.sincon.gepred.protocollo.bean.DatiAutenticazione;
import it.sincon.gepred.protocollo.bean.DatiEsito;
import it.sincon.gepred.protocollo.bean.DatiMittenteDestinatario;
import it.sincon.gepred.protocollo.bean.DatiOutputProtocollo;
import it.sincon.gepred.protocollo.bean.DatiRichiestaProtocollo;
import it.sincon.gepred.protocollo.bean.MezzoSpedizioneEnum;
import it.sincon.gepred.protocollo.folium.bean.DocumentoProtocollato;
import it.sincon.gepred.protocollo.folium.bean.MittenteDestinatario;
import it.sincon.gepred.protocollo.folium.bean.Ricerca;
import it.sincon.gepred.protocollo.folium.bean.WSAuthentication;
import it.sincon.gepred.protocollo.folium.impl.ProtocolloWebService;
import it.sincon.gepred.protocollo.folium.impl.ProtocolloWebServiceService;
import it.sincon.gepred.protocollo.folium.impl.ProtocolloWebServiceServiceLocator;
import it.sincon.gepred.protocollo.folium.log.LogMessageFolium;
import it.sincon.gepred.protocollo.service.ProtocolloService;

import javax.annotation.PostConstruct;
import javax.xml.namespace.QName;
import javax.xml.rpc.ServiceException;
import javax.xml.rpc.handler.HandlerInfo;
import javax.xml.rpc.handler.HandlerRegistry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ProtocolloServiceFolium implements ProtocolloService {
	
	
	private static Logger log = LoggerFactory.getLogger(ProtocolloServiceFolium.class);

	private ProtocolloWebService portType;
	private String codiceAmministrazione;
	private String codiceAoo;
	private String applicazione;
	private String urlEndpoint;
	private String registro;
	
	@PostConstruct
	public void initialize() {
		ProtocolloWebServiceService service = new ProtocolloWebServiceServiceLocator();
		HandlerRegistry reg = service.getHandlerRegistry();
		List chain = reg.getHandlerChain(new QName(service.getServiceName().getNamespaceURI(), "ProtocolloWebService"));
		HandlerInfo info = new HandlerInfo();
		info.setHandlerClass(LogMessageFolium.class);
		chain.add(info);
		try {
			portType = service.getProtocolloWebService(new URL(urlEndpoint));
		} 		catch(ServiceException se) {
			log.error("Error in initialize ProtocolloServiceFolium :: "+se.getMessage(),se);
		} catch (MalformedURLException e) {
			log.error("Error in initialize ProtocolloServiceFolium :: "+e.getMessage(),e);
		}

		
	}

	public void setCodiceAmministrazione(String codiceAmministrazione) {
		this.codiceAmministrazione = codiceAmministrazione;
	}

	public void setCodiceAoo(String codiceAoo) {
		this.codiceAoo = codiceAoo;
	}

	public void setApplicazione(String applicazione) {
		this.applicazione = applicazione;
	}

	public void setUrlEndpoint(String urlEndpoint) {
		this.urlEndpoint = urlEndpoint;
	}
	
	public void setRegistro(String registro) {
		this.registro = registro;
	}

	@Override
	public DatiOutputProtocollo protocollaPratica(
			DatiRichiestaProtocollo datiProtocollazione,
			DatiAutenticazione datiAutenticazione) {
		WSAuthentication authentication = createAuthentication(datiAutenticazione);
		DocumentoProtocollato documento = new DocumentoProtocollato();
		DocumentoProtocollato risultato = null;
		DatiOutputProtocollo result = new DatiOutputProtocollo();
		result.setEsito(new DatiEsito());
		documento.setOggetto(datiProtocollazione.getOggetto());
		documento.setTipoProtocollo(datiProtocollazione.getTipoProtocollo());
		documento.setRegistro(registro);
		documento.setUfficioCompetente(datiAutenticazione.getCodiceUfficio());
		documento.setIsContenuto(datiProtocollazione.getDocumentoPrincipale()!=null);
		if (documento.isIsContenuto()) {
			documento.setContenuto(datiProtocollazione.getDocumentoPrincipale().getContenutoAllegato());
			documento.setNomeFileContenuto(datiProtocollazione.getDocumentoPrincipale().getUrlAllegato());
			documento.setTimbro(true);
		}
		List<MittenteDestinatario> listaMittentiDestinatari=new ArrayList<MittenteDestinatario>();
		for(DatiMittenteDestinatario mittenteDestinatario:datiProtocollazione.getMittenteDestinatario())
		{
			MittenteDestinatario mittenteDestinatarioFolium = new MittenteDestinatario();
			mittenteDestinatarioFolium.setCodiceMezzoSpedizione((String)traduciMezziSpedizione().get(mittenteDestinatario.getMezzoSpedizione()));
			mittenteDestinatarioFolium.setInvioPC(mittenteDestinatario.isInvioPc());
			if (mittenteDestinatario.isAzienda()) {
				mittenteDestinatarioFolium.setTipo("G");
				mittenteDestinatarioFolium.setDenominazione(mittenteDestinatario.getNominativo());
				mittenteDestinatarioFolium.setCodiceMittenteDestinatario(mittenteDestinatario.getPartitaIva());
			}
			else {
				mittenteDestinatarioFolium.setTipo("F");
				mittenteDestinatarioFolium.setDenominazione(mittenteDestinatario.getCognome()+" "+mittenteDestinatario.getNome());
				mittenteDestinatarioFolium.setNome(mittenteDestinatario.getNome());
				mittenteDestinatarioFolium.setCognome(mittenteDestinatario.getCognome());
				mittenteDestinatarioFolium.setCodiceMittenteDestinatario(mittenteDestinatario.getCodiceFiscale());
			}
			mittenteDestinatarioFolium.setEmail(mittenteDestinatario.getEmail());
			mittenteDestinatarioFolium.setCitta(mittenteDestinatario.getCitta());
			mittenteDestinatarioFolium.setIndirizzo(mittenteDestinatario.getIndirizzo());
			listaMittentiDestinatari.add(mittenteDestinatarioFolium);
		}
		documento.setMittentiDestinatari(listaMittentiDestinatari.toArray(new MittenteDestinatario[0]));
		try {
			risultato = portType.protocolla(authentication, documento);
			if (risultato.getEsito().getCodiceEsito().equals("000")) {
				result.getEsito().setCodice("000");
				result.setNumeroProtocollo(risultato.getNumeroProtocollo());
				result.setDataProtocollo(risultato.getDataProtocollo().getTime());
			} else {
				result.getEsito().setCodice(risultato.getEsito().getCodiceEsito());
				result.getEsito().setDescrizione(risultato.getEsito().getDescrizioneEsito());
			}
		} catch (RemoteException e) {
			result.getEsito().setCodice("2");
			result.getEsito().setDescrizione("Errore in colloquio con protocollo :: "+e.getMessage());
			log.error("Errore in colloquio con protocollo :: "+e.getMessage(),e);
		}
		return result;
	}

	@Override
	public DatiRichiestaProtocollo consultaProtocollo(
			DatiOutputProtocollo datiIdentificativiProtocollo,
			DatiAutenticazione datiAutenticazione) {
		WSAuthentication authentication = createAuthentication(datiAutenticazione);
		Ricerca ricerca = new Ricerca();
		ricerca.setRegistro(registro);
		ricerca.setNumeroDa(datiIdentificativiProtocollo.getNumeroProtocollo());
		ricerca.setNumeroA(datiIdentificativiProtocollo.getNumeroProtocollo());
		Calendar dataProtocollo = Calendar.getInstance();
		dataProtocollo.setTime(datiIdentificativiProtocollo.getDataProtocollo());
		ricerca.setDataProtocolloDa(dataProtocollo);
		ricerca.setDataProtocolloA(dataProtocollo);
		DatiRichiestaProtocollo result = new DatiRichiestaProtocollo();
		result.setDatiProtocollazione(datiIdentificativiProtocollo);
		result.setEsito(new DatiEsito());
		DocumentoProtocollato[] elenco = null;
		try {
			elenco = portType.ricercaProtocolli(authentication, ricerca);
			if (elenco!=null && elenco.length==1) {
				if (elenco[0].getEsito().getCodiceEsito().equals("000")) {
					result.getEsito().setCodice("000");
					result.setOggetto(elenco[0].getOggetto());
					result.setTipoProtocollo(elenco[0].getTipoProtocollo());
					List<DatiMittenteDestinatario> mittentiDestinatari = new ArrayList<DatiMittenteDestinatario>();
					for(MittenteDestinatario mittenteDestinatarioFolium:elenco[0].getMittentiDestinatari()) {
						DatiMittenteDestinatario mittenteDestinatario = new DatiMittenteDestinatario();
						mittenteDestinatario.setAzienda(mittenteDestinatarioFolium.getTipo().equals("G"));
						SortedMap<MezzoSpedizioneEnum, Serializable> codificaMezzi = traduciMezziSpedizione();
						for(Map.Entry<MezzoSpedizioneEnum, Serializable> row:codificaMezzi.entrySet()) {
							if (row.getValue().equals(mittenteDestinatarioFolium.getCodiceMezzoSpedizione()))
								mittenteDestinatario.setMezzoSpedizione(row.getKey());
						}
						if (mittenteDestinatario.isAzienda())
							mittenteDestinatario.setNominativo(mittenteDestinatarioFolium.getDenominazione());
						else {
							mittenteDestinatario.setNome(mittenteDestinatarioFolium.getNome());
							mittenteDestinatario.setCognome(mittenteDestinatarioFolium.getCognome());
						}
						mittenteDestinatario.setCitta(mittenteDestinatarioFolium.getCitta());
						mittenteDestinatario.setIndirizzo(mittenteDestinatarioFolium.getIndirizzo());
						mittenteDestinatario.setEmail(mittenteDestinatarioFolium.getEmail());
						mittenteDestinatario.setInvioPc(mittenteDestinatarioFolium.isInvioPC());
						mittentiDestinatari.add(mittenteDestinatario);
					}
					result.setMittenteDestinatario(mittentiDestinatari);
				} else {
					result.getEsito().setCodice(elenco[0].getEsito().getCodiceEsito());
					result.getEsito().setDescrizione(elenco[0].getEsito().getDescrizioneEsito());
				}
			} else {
				result.getEsito().setCodice("2");
				result.getEsito().setDescrizione("Errore in recupero protocollo");
			}
		} catch (RemoteException e) {
			result.getEsito().setCodice("2");
			result.getEsito().setDescrizione("Errore in recupero protocollo :: "+e.getMessage());
			log.error("Errore in colloquio con protocollo :: "+e.getMessage(),e);
		}
		return result;
	}

	@Override
	public DatiOutputProtocollo completaProtocollazioneProvvisoria(
			AllegatoProtocollo documentoPrincipale,
			DatiOutputProtocollo datiIdentificativiProtocollo,
			DatiAutenticazione datiAutenticazione) {
		return null;
	}

	@Override
	public DatiOutputProtocollo allegaDocumentoAProtocollo(
			AllegatoProtocollo allegato,
			DatiOutputProtocollo datiIdentificativiProtocollo,
			DatiAutenticazione datiAutenticazione) {
		return null;
	}

	@Override
	public SortedMap<MezzoSpedizioneEnum, Serializable> traduciMezziSpedizione() {
		SortedMap<MezzoSpedizioneEnum,Serializable> result = new TreeMap<MezzoSpedizioneEnum, Serializable>();
		result.put(MezzoSpedizioneEnum.EMAIL_ORDINARIA, "MAILST");
		result.put(MezzoSpedizioneEnum.POSTA_ORDINARIA, "PTORDI");
		result.put(MezzoSpedizioneEnum.POSTA_PRIORITARIA, "PTPRIO");
		result.put(MezzoSpedizioneEnum.RACCOMANDATA_A_MANO, "RACCAM");
		result.put(MezzoSpedizioneEnum.RACCOMANDATA_AR, "RACCAR");
		result.put(MezzoSpedizioneEnum.RACCOMANDATA_ORDINARIA, "RACCST");
		result.put(MezzoSpedizioneEnum.EMAIL_AO, "MAILAO");
		result.put(MezzoSpedizioneEnum.EMAIL_AM, "MAILAM");
		return result;
	}

	@Override
	public boolean isSettatoInviaPc() {
		return true;
	}

	@Override
	public boolean isImplementedCompletamento() {
		return false;
	}

	@Override
	public boolean isImplementedProtocolloUscita() {
		return true;
	}
	
	private WSAuthentication createAuthentication(DatiAutenticazione autenticazione) {
		return new WSAuthentication(codiceAoo, applicazione, codiceAmministrazione, autenticazione.getPassword(), autenticazione.getUsername());
	}

}
