package it.sincon.gepred.protocollo.adoc;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.MessageContext;


import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import it.sincon.gepred.protocollo.adoc.bean.Allegato;
import it.sincon.gepred.protocollo.adoc.bean.Destinatario;
import it.sincon.gepred.protocollo.adoc.bean.Documento;
import it.sincon.gepred.protocollo.adoc.bean.Mittente;
import it.sincon.gepred.protocollo.adoc.bean.PersonaFisica;
import it.sincon.gepred.protocollo.adoc.bean.PersonaGiuridica;
import it.sincon.gepred.protocollo.adoc.impl.AddAllegatura;
import it.sincon.gepred.protocollo.adoc.impl.AddAllegaturaResponse;
import it.sincon.gepred.protocollo.adoc.impl.CompletamentoProtocolloProvvisorio;
import it.sincon.gepred.protocollo.adoc.impl.CompletamentoProtocolloProvvisorioResponse;
import it.sincon.gepred.protocollo.adoc.impl.GetProtocollo;
import it.sincon.gepred.protocollo.adoc.impl.GetProtocolloResponse;
import it.sincon.gepred.protocollo.adoc.impl.ProtocolloServer;
import it.sincon.gepred.protocollo.adoc.impl.RichiestaProtocollo;
import it.sincon.gepred.protocollo.adoc.impl.RichiestaProtocolloProvvisorio;
import it.sincon.gepred.protocollo.adoc.impl.RichiestaProtocolloProvvisorioResponse;
import it.sincon.gepred.protocollo.adoc.impl.RichiestaProtocolloResponse;
import it.sincon.gepred.protocollo.bean.AllegatoProtocollo;
import it.sincon.gepred.protocollo.bean.DatiAutenticazione;
import it.sincon.gepred.protocollo.bean.DatiEsito;
import it.sincon.gepred.protocollo.bean.DatiMittenteDestinatario;
import it.sincon.gepred.protocollo.bean.DatiOutputProtocollo;
import it.sincon.gepred.protocollo.bean.DatiRichiestaProtocollo;
import it.sincon.gepred.protocollo.bean.MezzoSpedizioneEnum;
import it.sincon.gepred.protocollo.service.ProtocolloService;

@SuppressWarnings("restriction")
public class ProtocolloServiceAdoc implements ProtocolloService {
	
	private static Logger log = LoggerFactory.getLogger(ProtocolloServiceAdoc.class);

	
	@Autowired(required=false)
	private ProtocolloServer port;
	
	private String amministrazione;
	
	private String aoo;
	

	public void setAmministrazione(String amministrazione) {
		this.amministrazione = amministrazione;
	}

	public void setAoo(String aoo) {
		this.aoo = aoo;
	}

	@Override
	public DatiOutputProtocollo protocollaPratica(
			DatiRichiestaProtocollo datiProtocollazione, DatiAutenticazione datiAutenticazione) {
		DatiOutputProtocollo datiOutputProtocollo=new DatiOutputProtocollo();
		datiOutputProtocollo.setEsito(new DatiEsito());
		insertAuthenticationHeader(datiAutenticazione);
		if (datiProtocollazione.getTipoProtocollo().equals("I"))
		{
			if (datiProtocollazione.getDocumentoPrincipale()!=null&&datiProtocollazione.getDocumentoPrincipale().getContenutoAllegato()!=null)
			{
				//protocollazione completa
				RichiestaProtocollo.ProtocolloRequest protocolloRequest = new RichiestaProtocollo.ProtocolloRequest();
				protocolloRequest.setOggetto(datiProtocollazione.getOggetto());
				protocolloRequest.setAmministrazione(amministrazione);
				protocolloRequest.setAreaOrganizzativaOmogenea(aoo);
				protocolloRequest.setIdUtente(datiAutenticazione.getIdUtente());
				Mittente mittente = new Mittente();
				mittente.setComune(datiProtocollazione.getMittenteDestinatario().get(0).getCitta());
				mittente.setIndirizzo(datiProtocollazione.getMittenteDestinatario().get(0).getIndirizzo());
				if (datiProtocollazione.getMittenteDestinatario().get(0).isAzienda())
				{
					//Azienda
					PersonaGiuridica personaGiuridica=new PersonaGiuridica();
					personaGiuridica.setPartitaIVA(datiProtocollazione.getMittenteDestinatario().get(0).getPartitaIva());
					personaGiuridica.setRagioneSociale(datiProtocollazione.getMittenteDestinatario().get(0).getNominativo());
					mittente.setPersonaGiuridica(personaGiuridica);
				}
				else
				{
					//Persona fisica
					PersonaFisica personaFisica = new PersonaFisica();
					personaFisica.setCodiceFiscale(datiProtocollazione.getMittenteDestinatario().get(0).getCodiceFiscale());
					personaFisica.setCognome(datiProtocollazione.getMittenteDestinatario().get(0).getCognome());
					personaFisica.setNome(datiProtocollazione.getMittenteDestinatario().get(0).getNome());
					mittente.setPersonaFisica(personaFisica);
				}
				protocolloRequest.setMittente(mittente);
				Documento documento=new Documento();
				String nomeFile = datiProtocollazione.getDocumentoPrincipale().getUrlAllegato();
//				String nomeFile = urlAllegato.substring(urlAllegato.lastIndexOf("/")+1,urlAllegato.indexOf("?"));
				documento.setNomeFile(nomeFile);
				documento.setContenuto(datiProtocollazione.getDocumentoPrincipale().getContenutoAllegato());
				documento.setTitolo(datiProtocollazione.getDocumentoPrincipale().getNomeDocumento());
				protocolloRequest.setDocumento(documento);
				for(AllegatoProtocollo allegato:datiProtocollazione.getAllegati()){
					if (allegato.isDaAllegareProtocollazione() && !allegato.getIdAllegato().equals(datiProtocollazione.getDocumentoPrincipale().getIdAllegato()))
					{
						Allegato allegato2=new Allegato();
						Documento documentoAllegato = new Documento();
						String nomeFile2 =allegato.getUrlAllegato();
//						String nomeFile2 = urlAllegato2.substring(urlAllegato2.lastIndexOf("/")+1,urlAllegato2.indexOf("?"));
						documentoAllegato.setNomeFile(nomeFile2);
						documentoAllegato.setContenuto(allegato.getContenutoAllegato());
						documentoAllegato.setTitolo(allegato.getNomeDocumento());
						allegato2.setDocumento(documentoAllegato);
						protocolloRequest.getAllegati().add(allegato2);
					}
				}
				RichiestaProtocolloResponse.Return response = port.richiestaProtocollo(protocolloRequest);
				datiOutputProtocollo.setEsito(new DatiEsito());
				if (response.getErrore()==null)
				{
					datiOutputProtocollo.setNumeroProtocollo(response.getNumeroProtocollo().toString());
					datiOutputProtocollo.setDataProtocollo(response.getDataProtocollo().toGregorianCalendar().getTime());
					datiOutputProtocollo.getEsito().setCodice("000");
				}
				else
				{
					datiOutputProtocollo.getEsito().setCodice(response.getErrore().getCodice());
					datiOutputProtocollo.getEsito().setDescrizione(response.getErrore().getDescrizione());
				}
			}
			else
			{
				//protocollazione provvisoria
				RichiestaProtocolloProvvisorio.ProtocolloProvvisorioRequest protocolloRequest = new RichiestaProtocolloProvvisorio.ProtocolloProvvisorioRequest();
				protocolloRequest.setOggetto(datiProtocollazione.getOggetto());
				protocolloRequest.setAmministrazione(amministrazione);
				protocolloRequest.setAreaOrganizzativaOmogenea(aoo);
				protocolloRequest.setIdUtente(datiAutenticazione.getIdUtente());
				Mittente mittente = new Mittente();
				mittente.setComune(datiProtocollazione.getMittenteDestinatario().get(0).getCitta());
				mittente.setIndirizzo(datiProtocollazione.getMittenteDestinatario().get(0).getIndirizzo());
				if (datiProtocollazione.getMittenteDestinatario().get(0).isAzienda())
				{
					//Azienda
					PersonaGiuridica personaGiuridica=new PersonaGiuridica();
					personaGiuridica.setPartitaIVA(datiProtocollazione.getMittenteDestinatario().get(0).getPartitaIva());
					personaGiuridica.setRagioneSociale(datiProtocollazione.getMittenteDestinatario().get(0).getNominativo());
					mittente.setPersonaGiuridica(personaGiuridica);
				}
				else
				{
					//Persona fisica
					PersonaFisica personaFisica = new PersonaFisica();
					personaFisica.setCodiceFiscale(datiProtocollazione.getMittenteDestinatario().get(0).getCodiceFiscale());
					personaFisica.setCognome(datiProtocollazione.getMittenteDestinatario().get(0).getCognome());
					personaFisica.setNome(datiProtocollazione.getMittenteDestinatario().get(0).getNome());
					mittente.setPersonaFisica(personaFisica);
				}
				protocolloRequest.setMittente(mittente);
				RichiestaProtocolloProvvisorioResponse.Return response = port.richiestaProtocolloProvvisorio(protocolloRequest);
				if (response.getErrore()==null)
				{
					datiOutputProtocollo.setNumeroProtocollo(response.getNumeroProtocollo().toString());
					datiOutputProtocollo.setDataProtocollo(response.getDataProtocollo().toGregorianCalendar().getTime());
					datiOutputProtocollo.getEsito().setCodice("000");
				}
				else
				{
					datiOutputProtocollo.getEsito().setCodice(response.getErrore().getCodice());
					datiOutputProtocollo.getEsito().setDescrizione(response.getErrore().getDescrizione());
				}
			}
		}
		else
		{
			datiOutputProtocollo.getEsito().setCodice("1");
			datiOutputProtocollo.getEsito().setDescrizione("Tipo di protocollazione non supportata");
		}
		return datiOutputProtocollo;
	}

	@Override
	public DatiRichiestaProtocollo consultaProtocollo(
			DatiOutputProtocollo datiIdentificativiProtocollo, DatiAutenticazione datiAutenticazione) {
		insertAuthenticationHeader(datiAutenticazione);
		DatiRichiestaProtocollo datiRichiestaProtocollo=new DatiRichiestaProtocollo();
		datiRichiestaProtocollo.setEsito(new DatiEsito());
		DateFormat df = new SimpleDateFormat("yyyy");
		GetProtocollo.ProtocolloInformazioniRequest informazioniRequest=new GetProtocollo.ProtocolloInformazioniRequest();
		informazioniRequest.setNumeroProtocollo(new Long(datiIdentificativiProtocollo.getNumeroProtocollo()).longValue());
		informazioniRequest.setAnno(df.format(datiIdentificativiProtocollo.getDataProtocollo()));
		GetProtocolloResponse.Return response = port.getProtocollo(informazioniRequest);
		if (response.getErrore()!=null)
		{
			datiRichiestaProtocollo.getEsito().setCodice(response.getErrore().getCodice());
			datiRichiestaProtocollo.getEsito().setDescrizione(response.getErrore().getDescrizione());
		}
		else
		{
			datiRichiestaProtocollo.getEsito().setCodice("000");
			datiRichiestaProtocollo.setDatiProtocollazione(new DatiOutputProtocollo());
			datiRichiestaProtocollo.getDatiProtocollazione().setDataProtocollo(response.getDataProtocollo().toGregorianCalendar().getTime());
			datiRichiestaProtocollo.getDatiProtocollazione().setNumeroProtocollo(response.getNumeroProtocollo().toString());
			datiRichiestaProtocollo.setOggetto(response.getOggetto());
			datiRichiestaProtocollo.setMittenteDestinatario(new ArrayList<DatiMittenteDestinatario>());
			log.info("Condizione verifica protocollo uscita: "+(response.getMittente()==null || ((response.getMittente().getPersonaFisica()==null|| response.getMittente().getPersonaFisica().getCodiceFiscale()==null || response.getMittente().getPersonaFisica().getCodiceFiscale().trim().equals(""))&&(response.getMittente().getPersonaGiuridica()==null|| response.getMittente().getPersonaGiuridica().getPartitaIVA()==null||response.getMittente().getPersonaGiuridica().getPartitaIVA().trim().equals("")))));
			if (response.getMittente()==null || ((response.getMittente().getPersonaFisica()==null|| response.getMittente().getPersonaFisica().getCodiceFiscale()==null || response.getMittente().getPersonaFisica().getCodiceFiscale().trim().equals(""))&&(response.getMittente().getPersonaGiuridica()==null|| response.getMittente().getPersonaGiuridica().getPartitaIVA()==null||response.getMittente().getPersonaGiuridica().getPartitaIVA().trim().equals(""))))
			{
				datiRichiestaProtocollo.setTipoProtocollo("U");
				for(Destinatario destinatario:response.getDestinatari())
				{
					DatiMittenteDestinatario datiMittenteDestinatario=new DatiMittenteDestinatario();
					datiMittenteDestinatario.setAzienda(false);
					datiMittenteDestinatario.setCodiceFiscale(destinatario.getPersonaFisica().getCodiceFiscale());
					datiMittenteDestinatario.setCognome(destinatario.getPersonaFisica().getCognome());
					datiMittenteDestinatario.setNome(destinatario.getPersonaFisica().getNome());
					datiRichiestaProtocollo.getMittenteDestinatario().add(datiMittenteDestinatario);
				}
			}
			else
			{
				datiRichiestaProtocollo.setTipoProtocollo("I");
				DatiMittenteDestinatario ref = new DatiMittenteDestinatario();
				ref.setAzienda(response.getMittente().getPersonaGiuridica()!=null && response.getMittente().getPersonaGiuridica().getPartitaIVA()!=null &&!response.getMittente().getPersonaGiuridica().getPartitaIVA().equals(""));
				if (ref.isAzienda())
				{
					ref.setNominativo(response.getMittente().getPersonaGiuridica().getRagioneSociale());
					ref.setPartitaIva(response.getMittente().getPersonaGiuridica().getPartitaIVA());
				}
				else
				{
					ref.setCodiceFiscale(response.getMittente().getPersonaFisica().getCodiceFiscale());
					ref.setNome(response.getMittente().getPersonaFisica().getNome());
					ref.setCognome(response.getMittente().getPersonaFisica().getCognome());
				}
				ref.setCitta(response.getMittente().getComune());
				ref.setIndirizzo(response.getMittente().getIndirizzo());
				datiRichiestaProtocollo.getMittenteDestinatario().add(ref);
			}
			
		}
		if (response.getDocumento()!=null)
		{
			AllegatoProtocollo documentoPrincipale = new AllegatoProtocollo();
			documentoPrincipale.setContenutoAllegato(response.getDocumento().getContenuto());
			documentoPrincipale.setNomeDocumento(response.getDocumento().getTitolo());
			documentoPrincipale.setIdAllegato(0L);
			datiRichiestaProtocollo.setAllegati(new ArrayList<AllegatoProtocollo>());
			datiRichiestaProtocollo.getAllegati().add(documentoPrincipale);
			datiRichiestaProtocollo.setDocumentoPrincipale(documentoPrincipale);
			for(Allegato allegato:response.getAllegati()){
				AllegatoProtocollo allegatoProtocollo=new AllegatoProtocollo();
				allegatoProtocollo.setIdAllegato(new Integer(datiRichiestaProtocollo.getAllegati().size()).longValue());
				allegatoProtocollo.setContenutoAllegato(allegato.getDocumento().getContenuto());
				allegatoProtocollo.setNomeDocumento(allegato.getDocumento().getTitolo());
				datiRichiestaProtocollo.getAllegati().add(allegatoProtocollo);
			}
		}
		return datiRichiestaProtocollo;
	}

	@Override
	public DatiOutputProtocollo completaProtocollazioneProvvisoria(
			AllegatoProtocollo documentoPrincipale,
			DatiOutputProtocollo datiIdentificativiProtocollo, DatiAutenticazione datiAutenticazione) {
		insertAuthenticationHeader(datiAutenticazione);
		DatiOutputProtocollo datiOutputProtocollo=new DatiOutputProtocollo();
		datiOutputProtocollo.setEsito(new DatiEsito());
		CompletamentoProtocolloProvvisorio.ProtocolloDaCompletareRequest completareRequest=new CompletamentoProtocolloProvvisorio.ProtocolloDaCompletareRequest();
		completareRequest.setAmministrazione(amministrazione);
		completareRequest.setAreaOrganizzativaOmogenea(aoo);
		completareRequest.setIdUtente(datiAutenticazione.getIdUtente());
		Documento documento=new Documento();
		documento.setTitolo(documentoPrincipale.getNomeDocumento());
		String nomeFile = documentoPrincipale.getUrlAllegato();
//		String nomeFile = urlAllegato.substring(urlAllegato.lastIndexOf("/")+1,urlAllegato.indexOf("?"));
		documento.setNomeFile(nomeFile);
		documento.setContenuto(documentoPrincipale.getContenutoAllegato());
		completareRequest.setDocumento(documento);
		DateFormat df = new SimpleDateFormat("yyyy");
		completareRequest.setNumeroProtocollo(new Long(datiIdentificativiProtocollo.getNumeroProtocollo()).longValue());
		completareRequest.setAnno(df.format(datiIdentificativiProtocollo.getDataProtocollo()));
		CompletamentoProtocolloProvvisorioResponse.Return response = port.completamentoProtocolloProvvisorio(completareRequest);
		if (response.getErrore()==null)
		{
			datiOutputProtocollo.getEsito().setCodice("000");
			datiOutputProtocollo.setNumeroProtocollo(response.getNumeroProtocollo().toString());
			datiOutputProtocollo.setDataProtocollo(response.getDataProtocollo().toGregorianCalendar().getTime());
		}
		else
		{
			datiOutputProtocollo.getEsito().setCodice(response.getErrore().getCodice());
			datiOutputProtocollo.getEsito().setDescrizione(response.getErrore().getDescrizione());
		}
		return datiOutputProtocollo;
	}

	@Override
	public DatiOutputProtocollo allegaDocumentoAProtocollo(
			AllegatoProtocollo allegato,
			DatiOutputProtocollo datiIdentificativiProtocollo, DatiAutenticazione datiAutenticazione) {
		insertAuthenticationHeader(datiAutenticazione);
		DatiOutputProtocollo datiOutputProtocollo=new DatiOutputProtocollo();
		datiOutputProtocollo.setEsito(new DatiEsito());
		AddAllegatura.AllegaturaRequest allegaturaRequest = new AddAllegatura.AllegaturaRequest();
		allegaturaRequest.setAmministrazione(amministrazione);
		allegaturaRequest.setAreaOrganizzativaOmogenea(aoo);
		allegaturaRequest.setIdUtente(datiAutenticazione.getIdUtente());
		DateFormat df = new SimpleDateFormat("yyyy");
		allegaturaRequest.setAnno(df.format(datiIdentificativiProtocollo.getDataProtocollo()));
		allegaturaRequest.setNumeroProtocollo(new Long(datiIdentificativiProtocollo.getNumeroProtocollo()));
		Allegato allegato2=new Allegato();
		String nomeFile = allegato.getUrlAllegato();
//		String nomeFile = urlAllegato.substring(urlAllegato.lastIndexOf("/")+1,urlAllegato.indexOf("?"));
		allegato2.setDocumento(new Documento());
		allegato2.getDocumento().setContenuto(allegato.getContenutoAllegato());
		allegato2.getDocumento().setTitolo(allegato.getNomeDocumento());
		allegato2.getDocumento().setNomeFile(nomeFile);
		allegaturaRequest.getAllegati().add(allegato2);
		AddAllegaturaResponse.Return response = port.addAllegatura(allegaturaRequest);
		if (response.getErrore()!=null)
		{
			datiOutputProtocollo.getEsito().setCodice(response.getErrore().getCodice());
			datiOutputProtocollo.getEsito().setDescrizione(response.getErrore().getDescrizione());
		}
		else
		{
			datiOutputProtocollo.getEsito().setCodice("000");
			datiOutputProtocollo.setDataProtocollo(datiIdentificativiProtocollo.getDataProtocollo());
			datiOutputProtocollo.setNumeroProtocollo(datiIdentificativiProtocollo.getNumeroProtocollo());
		}
		return datiOutputProtocollo;
	}

	@Override
	public SortedMap<MezzoSpedizioneEnum, Serializable> traduciMezziSpedizione() {
		return null;
	}

	@Override
	public boolean isSettatoInviaPc() {
		return false;
	}

	@Override
	public boolean isImplementedCompletamento() {
		return true;
	}

	@Override
	public boolean isImplementedProtocolloUscita() {
		return false;
	}
	
	private void insertAuthenticationHeader(DatiAutenticazione datiAutenticazione){
		Client client = ClientProxy.getClient(port);
		Map<String, Object> req_ctx = ((BindingProvider) port).getRequestContext();
		Map<String, List<String>> headers = new HashMap<String, List<String>>();
		headers.put("Username", Collections.singletonList(datiAutenticazione.getUsername()));
		headers.put("Password", Collections.singletonList(datiAutenticazione.getPassword()));
		req_ctx.put(MessageContext.HTTP_REQUEST_HEADERS, headers);
		log.info("Username: "+datiAutenticazione.getUsername());
		log.info("Password: "+datiAutenticazione.getPassword());
		log.info("Adoc client: "+client.getEndpoint().getEndpointInfo().getAddress());
		log.info("Id utente: "+datiAutenticazione.getIdUtente());
		req_ctx.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, client.getEndpoint().getEndpointInfo().getAddress()+"?wsdl");
	}

}
