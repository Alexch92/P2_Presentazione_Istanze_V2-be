package it.sincon.gepred.protocollo.scatel;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.rmi.RemoteException;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;

import org.apache.axis.EngineConfiguration;
import org.apache.axis.Handler;
import org.apache.axis.SimpleChain;
import org.apache.axis.SimpleTargetedChain;
import org.apache.axis.configuration.SimpleProvider;
import org.apache.axis.transport.http.HTTPSender;
import org.apache.axis.transport.http.HTTPTransport;
import org.apache.ws.axis.security.WSDoAllSender;
import org.apache.ws.security.WSConstants;
import org.apache.ws.security.handler.WSHandlerConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;

import it.sincon.gepred.protocollo.bean.AllegatoProtocollo;
import it.sincon.gepred.protocollo.bean.DatiAutenticazione;
import it.sincon.gepred.protocollo.bean.DatiEsito;
import it.sincon.gepred.protocollo.bean.DatiMittenteDestinatario;
import it.sincon.gepred.protocollo.bean.DatiOutputProtocollo;
import it.sincon.gepred.protocollo.bean.DatiRichiestaProtocollo;
import it.sincon.gepred.protocollo.bean.MezzoSpedizioneEnum;
import it.sincon.gepred.protocollo.scatel.bean.CredenzialiUtente;
import it.sincon.gepred.protocollo.scatel.bean.Descrizione;
import it.sincon.gepred.protocollo.scatel.bean.Destinatario;
import it.sincon.gepred.protocollo.scatel.bean.Destinazione;
import it.sincon.gepred.protocollo.scatel.bean.Documento;
import it.sincon.gepred.protocollo.scatel.bean.DocumentoTipoRiferimento;
import it.sincon.gepred.protocollo.scatel.bean.Identificatore;
import it.sincon.gepred.protocollo.scatel.bean.IndirizzoTelematico;
import it.sincon.gepred.protocollo.scatel.bean.IndirizzoTelematicoTipo;
import it.sincon.gepred.protocollo.scatel.bean.Intestazione;
import it.sincon.gepred.protocollo.scatel.bean.Mittente;
import it.sincon.gepred.protocollo.scatel.bean.Origine;
import it.sincon.gepred.protocollo.scatel.bean.ParametriEseguiProtocollo;
import it.sincon.gepred.protocollo.scatel.bean.ParametriRichiestaProtocollo;
import it.sincon.gepred.protocollo.scatel.bean.Persona;
import it.sincon.gepred.protocollo.scatel.bean.RispostaDettaglioProtocollo;
import it.sincon.gepred.protocollo.scatel.bean.RispostaProtocollo;
import it.sincon.gepred.protocollo.scatel.bean.Segnatura;
import it.sincon.gepred.protocollo.scatel.impl.ProtocolloPortType;
import it.sincon.gepred.protocollo.scatel.impl.ProtocolloWS;
import it.sincon.gepred.protocollo.scatel.impl.ProtocolloWSLocator;
import it.sincon.gepred.protocollo.service.ProtocolloService;
import javax.annotation.PostConstruct;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;
import javax.xml.namespace.QName;
import javax.xml.rpc.ServiceException;
import javax.xml.rpc.handler.HandlerInfo;
import javax.xml.rpc.handler.HandlerRegistry;

public class ProtocolloServiceScatel implements ProtocolloService {

	private static Logger log = LoggerFactory.getLogger(ProtocolloServiceScatel.class);

	private ProtocolloPortType portType;
	
	private String endpointAddress;
	
	private String codiceAmministrazione;
	
	private String wso2TokenUserName;
	
	private String wso2TokenPassword;
	
	private String codiceAoo;
	
	private DateFormat dfResult;
	
	private DateFormat dfRequest;
	
	private String authorization;
	private Date expirationDate;
	private String pathKeystoreServer;
	private String passwordKeystore;
	private String pathKeystoreClient;
	private String tokenGenerateURL;
	private String tokenAuthorization;
	
	public String getPathKeystoreServer() {
		return pathKeystoreServer;
	}
	public void setPathKeystoreServer(String pathKeystoreServer) {
		this.pathKeystoreServer = pathKeystoreServer;
	}
	public String getPasswordKeystore() {
		return passwordKeystore;
	}
	public void setPasswordKeystore(String passwordKeystore) {
		this.passwordKeystore = passwordKeystore;
	}
	public String getPathKeystoreClient() {
		return pathKeystoreClient;
	}
	public void setPathKeystoreClient(String pathKeystoreClient) {
		this.pathKeystoreClient = pathKeystoreClient;
	}
	public String getTokenGenerateURL() {
		return tokenGenerateURL;
	}
	public void setTokenGenerateURL(String tokenGenerateURL) {
		this.tokenGenerateURL = tokenGenerateURL;
	}
	public String getTokenAuthorization() {
		return tokenAuthorization;
	}
	public void setTokenAuthorization(String tokenAuthorization) {
		this.tokenAuthorization = tokenAuthorization;
	}

	public EngineConfiguration createConfigurationWithSecurityHeaders(String username, String password) throws Exception {
        SimpleProvider result;
        Handler securityHandler;
        SimpleChain requestHandler;

        Handler pivot;
        Handler transport;

        try {
            result = new SimpleProvider();
            securityHandler = new WSDoAllSender();
            securityHandler.setOption(WSHandlerConstants.ACTION, WSHandlerConstants.USERNAME_TOKEN);
            securityHandler.setOption(WSHandlerConstants.PASSWORD_TYPE, WSConstants.PW_TEXT);
            PWCallback.pwd=password;
            System.out.println("password callback settata!");
            securityHandler.setOption(WSHandlerConstants.PW_CALLBACK_CLASS, PWCallback.class.getName());
            securityHandler.setOption(WSHandlerConstants.USER, username);
            securityHandler.setOption(WSHandlerConstants.MUST_UNDERSTAND, "false");

            requestHandler = new SimpleChain();
            requestHandler.addHandler(securityHandler);

            pivot = new HTTPSender();
            transport = new SimpleTargetedChain(requestHandler, pivot, null);

            result.deployTransport(HTTPTransport.DEFAULT_TRANSPORT_NAME, transport);

        }
        catch (Exception e) {
            throw e;
        }

        return result;
    }
	
	private void refreshToken() {
		try {
			System.setProperty("javax.net.ssl.trustStore",pathKeystoreServer);
	        System.setProperty("javax.net.ssl.trustStorePassword", passwordKeystore);     
	
	        //System.setProperty("javax.net.ssl.keyStore", pathKeystoreClient);
	        //System.setProperty("javax.net.ssl.keyStorePassword", passwordKeystore);
	
	        System.setProperty("sun.security.ssl.allowUnsafeRenegotiation", "true"); 
	        
	        // Establish SSL handshake before the first web service method is called
	        final KeyStore keyStore = KeyStore.getInstance("JKS");
	        keyStore.load(new FileInputStream(pathKeystoreClient), passwordKeystore.toCharArray());
	        final KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
	        keyManagerFactory.init(keyStore, passwordKeystore.toCharArray());
	
	        final KeyStore trustStore = KeyStore.getInstance("JKS");
	        trustStore.load(new FileInputStream(pathKeystoreServer), passwordKeystore.toCharArray());
	        final TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
	        trustManagerFactory.init(trustStore);
	
	        final SSLContext sslContext = SSLContext.getInstance("TLSv1.2");
	        sslContext.init(keyManagerFactory.getKeyManagers(), trustManagerFactory.getTrustManagers(), new SecureRandom());
	
	        final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();
	        final SSLSocket sslSocket = (SSLSocket) sslSocketFactory.createSocket("api-gw.regione.puglia.it", 443);
	        //sslSocket.startHandshake();
	
	        
			URL urlForToken = new URL(tokenGenerateURL);
			HttpsURLConnection httpURLConnectionForToken = (HttpsURLConnection)urlForToken.openConnection();
			httpURLConnectionForToken.setRequestMethod("POST");
			httpURLConnectionForToken.setDoOutput(true);
			httpURLConnectionForToken.setUseCaches(false);
			httpURLConnectionForToken.setConnectTimeout(60000);
			httpURLConnectionForToken.setReadTimeout(60000);
																					 		
			httpURLConnectionForToken.addRequestProperty("Authorization", tokenAuthorization);
			httpURLConnectionForToken.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			
			// Create all-trusting host name verifier
			HostnameVerifier allHostsValid = new HostnameVerifier() {
				
				@Override
				public boolean verify(String hostname, SSLSession session) {
					return true;
				}
			};
	
			// Install the all-trusting host verifier
			httpURLConnectionForToken.setDefaultHostnameVerifier(allHostsValid);
			
			InputStream is=httpURLConnectionForToken.getInputStream();
			ByteArrayOutputStream baos=new ByteArrayOutputStream();
			byte[] buffer = new byte[256];
			int len;
			while((len=is.read(buffer))!=-1)
				baos.write(buffer, 0, len);
			String json = new String(baos.toByteArray());
			log.debug(String.format("Token Json:%s", json));
			
			Gson gson=new Gson();
			Map<String,Object> token=(Map<String,Object>)gson.fromJson(new String(baos.toByteArray()),Map.class);
			authorization=token.get("token_type")+" "+token.get("access_token");
			log.debug(String.format("authorization:%s", authorization));
			
			Calendar cal=Calendar.getInstance();
			cal.add(Calendar.SECOND, ((Double)token.get("expires_in")).intValue());
			expirationDate=cal.getTime();
		} catch (MalformedURLException e) {
			log.error(e.getMessage(), e);
		} catch (ProtocolException e) {
			log.error(e.getMessage(), e);
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		}
		catch (Exception ee) {
			log.error(ee.getMessage(), ee);
		}
	}
	@PostConstruct
	public void initialize() {
		//ProtocolloWS service = new ProtocolloWSLocator();
		
		try	{
			ProtocolloWS service = new ProtocolloWSLocator(createConfigurationWithSecurityHeaders(wso2TokenUserName, wso2TokenPassword));
			portType = service.getProtocolloPort(new URL(endpointAddress));
			dfResult = new SimpleDateFormat("ddMMyyyy");
			dfRequest = new SimpleDateFormat("yyyy/MM/dd");
		}
		catch(ServiceException se) {
			log.error("Error in initialize ProtocolloServiceScatel :: "+se.getMessage(),se);
		} catch (Exception e) {
			log.error("Error in initialize ProtocolloServiceScatel :: "+e.getMessage(),e);
		}
	}
	
	@Override
	public DatiOutputProtocollo protocollaPratica(
			DatiRichiestaProtocollo datiProtocollazione, DatiAutenticazione datiAutenticazione) {
		
		DatiOutputProtocollo result = new DatiOutputProtocollo();
		result.setEsito(new DatiEsito());
		
		if (authorization==null || expirationDate.getTime()<System.currentTimeMillis()) {
			refreshToken();
		}
		
		ParametriEseguiProtocollo eseguiProtocollo = new ParametriEseguiProtocollo();
		eseguiProtocollo.setCredenzialiUtente(new CredenzialiUtente(codiceAmministrazione, codiceAoo, datiAutenticazione.getUsername()));
		eseguiProtocollo.setSegnatura(new Segnatura());
		eseguiProtocollo.getSegnatura().setInOut(datiProtocollazione.getTipoProtocollo());
		eseguiProtocollo.getSegnatura().setIntestazione(new Intestazione());
		if (datiProtocollazione.getTipoProtocollo().equals("I")) {
			eseguiProtocollo.getSegnatura().getIntestazione().setIdentificatore(new Identificatore(codiceAmministrazione, codiceAoo, "0000000", "0000-00-00"));
			eseguiProtocollo.getSegnatura().getIntestazione().setOrigine(new Origine());
			eseguiProtocollo.getSegnatura().getIntestazione().getOrigine().setIndirizzoTelematico(new IndirizzoTelematico());
			if (datiProtocollazione.getMittenteDestinatario().get(0).getEmail()!=null &&!datiProtocollazione.getMittenteDestinatario().get(0).getEmail().equals("")) {
				eseguiProtocollo.getSegnatura().getIntestazione().getOrigine().getIndirizzoTelematico().setTipo(IndirizzoTelematicoTipo.smtp);
				eseguiProtocollo.getSegnatura().getIntestazione().getOrigine().getIndirizzoTelematico().set_value(datiProtocollazione.getMittenteDestinatario().get(0).getEmail());
			}
			else
				eseguiProtocollo.getSegnatura().getIntestazione().getOrigine().getIndirizzoTelematico().setTipo(IndirizzoTelematicoTipo.NMTOKEN);
			eseguiProtocollo.getSegnatura().getIntestazione().getOrigine().setMittente(new Mittente());
			if (datiProtocollazione.getMittenteDestinatario().get(0).isAzienda())
				eseguiProtocollo.getSegnatura().getIntestazione().getOrigine().getMittente().setPersona(new Persona(datiProtocollazione.getMittenteDestinatario().get(0).getNominativo(), null, null, null, datiProtocollazione.getMittenteDestinatario().get(0).getPartitaIva(), null, null, null));
			else
				eseguiProtocollo.getSegnatura().getIntestazione().getOrigine().getMittente().setPersona(new Persona(null,datiProtocollazione.getMittenteDestinatario().get(0).getNome(),datiProtocollazione.getMittenteDestinatario().get(0).getCognome(),null,datiProtocollazione.getMittenteDestinatario().get(0).getCodiceFiscale(),null,null,null));
			eseguiProtocollo.getSegnatura().getIntestazione().setDestinazione(new Destinazione[1]);
			eseguiProtocollo.getSegnatura().getIntestazione().getDestinazione()[0]=new Destinazione();
			eseguiProtocollo.getSegnatura().getIntestazione().getDestinazione()[0].setIndirizzoTelematico(new IndirizzoTelematico());
			eseguiProtocollo.getSegnatura().getIntestazione().getDestinazione()[0].getIndirizzoTelematico().setTipo(IndirizzoTelematicoTipo.NMTOKEN);
			eseguiProtocollo.getSegnatura().getIntestazione().getDestinazione()[0].setDestinatario(new Destinatario[1]);
			eseguiProtocollo.getSegnatura().getIntestazione().getDestinazione()[0].getDestinatario()[0]=new Destinatario();
			eseguiProtocollo.getSegnatura().getIntestazione().getDestinazione()[0].getDestinatario()[0].setDenominazione(codiceAmministrazione);
			eseguiProtocollo.getSegnatura().getIntestazione().setOggetto(datiProtocollazione.getOggetto());
			eseguiProtocollo.getSegnatura().setDescrizione(new Descrizione());
			eseguiProtocollo.getSegnatura().getDescrizione().setDocumento(new Documento());
			eseguiProtocollo.getSegnatura().getDescrizione().getDocumento().setNome("none");
			eseguiProtocollo.getSegnatura().getDescrizione().getDocumento().setTipoMIME("none");
			eseguiProtocollo.getSegnatura().getDescrizione().getDocumento().setTipoRiferimento(DocumentoTipoRiferimento.telematico);
			eseguiProtocollo.getSegnatura().getDescrizione().getDocumento().setTitoloDocumento("Nessun file");
			eseguiProtocollo.getSegnatura().getDescrizione().getDocumento().setOggetto("Nessun oggetto");
			RispostaProtocollo risposta = null;
			try {
				risposta = portType.eseguiProtocollazione(eseguiProtocollo, authorization);
				if (risposta.getEsito().getCodice().equals("0")){
					result.getEsito().setCodice("000");
					result.setNumeroProtocollo(String.format("%s/%s/%s", 
							risposta.getSegnaturaProtocollo().getCodiceAmministrazione().toUpperCase(),
							risposta.getSegnaturaProtocollo().getCodiceAOO(),
							risposta.getSegnaturaProtocollo().getNumeroProtocollo()));
					try {
						result.setDataProtocollo(dfResult.parse(risposta.getSegnaturaProtocollo().getDataRegistrazione()));
					} catch (ParseException e) {
						result.getEsito().setCodice("3");
						result.getEsito().setDescrizione("Errore nel formato della data");
					}
				}else{
					result.getEsito().setCodice(risposta.getEsito().getCodice());
					result.getEsito().setDescrizione(risposta.getEsito().getDescrizione());
				}
			} catch (RemoteException e) {
				result.getEsito().setCodice("2");
				result.getEsito().setDescrizione("Errore in colloquio con protocollo :: "+e.getMessage());
				log.error("Errore in colloquio con protocollo :: "+e.getMessage(),e);
			}
		}
		else if (datiProtocollazione.getTipoProtocollo().equals("U")) {
			eseguiProtocollo.getSegnatura().getIntestazione().setIdentificatore(new Identificatore(codiceAmministrazione, codiceAoo, "0000000", "0000-00-00"));
			
			eseguiProtocollo.getSegnatura().getIntestazione().setOrigine(new Origine());
			eseguiProtocollo.getSegnatura().getIntestazione().getOrigine().setIndirizzoTelematico(new IndirizzoTelematico());
			if (datiProtocollazione.getMittenteDestinatario().get(0).getEmail()!=null &&!datiProtocollazione.getMittenteDestinatario().get(0).getEmail().equals("")) {
				eseguiProtocollo.getSegnatura().getIntestazione().getOrigine().getIndirizzoTelematico().setTipo(IndirizzoTelematicoTipo.smtp);
				eseguiProtocollo.getSegnatura().getIntestazione().getOrigine().getIndirizzoTelematico().set_value(datiProtocollazione.getMittenteDestinatario().get(0).getEmail());
			}
			else
				eseguiProtocollo.getSegnatura().getIntestazione().getOrigine().getIndirizzoTelematico().setTipo(IndirizzoTelematicoTipo.NMTOKEN);
			eseguiProtocollo.getSegnatura().getIntestazione().getOrigine().setMittente(new Mittente());
			eseguiProtocollo.getSegnatura().getIntestazione().getOrigine().getMittente().setDenominazione(codiceAmministrazione);
			
			eseguiProtocollo.getSegnatura().getIntestazione().setDestinazione(new Destinazione[1]);
			eseguiProtocollo.getSegnatura().getIntestazione().getDestinazione()[0]=new Destinazione();
			eseguiProtocollo.getSegnatura().getIntestazione().getDestinazione()[0].setIndirizzoTelematico(new IndirizzoTelematico());
			eseguiProtocollo.getSegnatura().getIntestazione().getDestinazione()[0].getIndirizzoTelematico().setTipo(IndirizzoTelematicoTipo.NMTOKEN);
			eseguiProtocollo.getSegnatura().getIntestazione().getDestinazione()[0].setDestinatario(new Destinatario[1]);
			eseguiProtocollo.getSegnatura().getIntestazione().getDestinazione()[0].getDestinatario()[0]=new Destinatario();
			Persona persona = null;
			if (datiProtocollazione.getMittenteDestinatario().get(0).isAzienda()) 
				persona = new Persona(datiProtocollazione.getMittenteDestinatario().get(0).getNominativo(), null, null, null, datiProtocollazione.getMittenteDestinatario().get(0).getPartitaIva(), null, null, null);
			else
				persona = new Persona(null,datiProtocollazione.getMittenteDestinatario().get(0).getNome(),datiProtocollazione.getMittenteDestinatario().get(0).getCognome(),null,datiProtocollazione.getMittenteDestinatario().get(0).getCodiceFiscale(),null,null,null);
			eseguiProtocollo.getSegnatura().getIntestazione().getDestinazione()[0].getDestinatario()[0].setPersona(new Persona[] {persona});

			eseguiProtocollo.getSegnatura().getIntestazione().setOggetto(datiProtocollazione.getOggetto());
			eseguiProtocollo.getSegnatura().setDescrizione(new Descrizione());
			eseguiProtocollo.getSegnatura().getDescrizione().setDocumento(new Documento());
			eseguiProtocollo.getSegnatura().getDescrizione().getDocumento().setNome("none");
			eseguiProtocollo.getSegnatura().getDescrizione().getDocumento().setTipoMIME("none");
			eseguiProtocollo.getSegnatura().getDescrizione().getDocumento().setTipoRiferimento(DocumentoTipoRiferimento.telematico);
			eseguiProtocollo.getSegnatura().getDescrizione().getDocumento().setTitoloDocumento("Nessun file");
			eseguiProtocollo.getSegnatura().getDescrizione().getDocumento().setOggetto("Nessun oggetto");
			RispostaProtocollo risposta = null;
			try {
				risposta = portType.eseguiProtocollazione(eseguiProtocollo, authorization);
				if (risposta.getEsito().getCodice().equals("0")){
					result.getEsito().setCodice("000");
					result.setNumeroProtocollo(String.format("%s/%s/%s", 
							risposta.getSegnaturaProtocollo().getCodiceAmministrazione().toUpperCase(),
							risposta.getSegnaturaProtocollo().getCodiceAOO(),
							risposta.getSegnaturaProtocollo().getNumeroProtocollo()));
					try {
						result.setDataProtocollo(dfResult.parse(risposta.getSegnaturaProtocollo().getDataRegistrazione()));
					} catch (ParseException e) {
						result.getEsito().setCodice("3");
						result.getEsito().setDescrizione("Errore nel formato della data");
					}
				}else{
					result.getEsito().setCodice(risposta.getEsito().getCodice());
					result.getEsito().setDescrizione(risposta.getEsito().getDescrizione());
				}
			} catch (RemoteException e) {
				result.getEsito().setCodice("2");
				result.getEsito().setDescrizione("Errore in colloquio con protocollo :: "+e.getMessage());
				log.error("Errore in colloquio con protocollo :: "+e.getMessage(),e);
			}
		}
		else {
			result.getEsito().setCodice("1");
			result.getEsito().setDescrizione("Tipo di protocollazione non supportata");
		}
		return result;
	}

	@Override
	public DatiRichiestaProtocollo consultaProtocollo(
			DatiOutputProtocollo datiIdentificativiProtocollo, DatiAutenticazione datiAutenticazione) {
		ParametriRichiestaProtocollo richiestaDatiProtocollazione = new ParametriRichiestaProtocollo();
		richiestaDatiProtocollazione.setCredenzialiUtente(new CredenzialiUtente(codiceAmministrazione, codiceAoo, datiAutenticazione.getUsername()));
		richiestaDatiProtocollazione.setIdentificatore(new Identificatore(codiceAmministrazione, codiceAoo, datiIdentificativiProtocollo.getNumeroProtocollo(), dfRequest.format(datiIdentificativiProtocollo.getDataProtocollo())));
		RispostaDettaglioProtocollo datiProtocollo = null;
		DatiRichiestaProtocollo result = new DatiRichiestaProtocollo();
		result.setDatiProtocollazione(datiIdentificativiProtocollo);
		result.setEsito(new DatiEsito());
		try {
			datiProtocollo = portType.prelevaDettaglioProtocollo(richiestaDatiProtocollazione);
			if (datiProtocollo.isTrovato())
			{
				if (datiProtocollo.getSegnatura().getInOut().equals("I")) {
					DatiMittenteDestinatario mittente = new DatiMittenteDestinatario(); 
					if (datiProtocollo.getSegnatura().getIntestazione().getOrigine().getMittente().getPersona().getDenominazione()!=null) {
						mittente.setAzienda(true);
						mittente.setNominativo(datiProtocollo.getSegnatura().getIntestazione().getOrigine().getMittente().getPersona().getDenominazione());
					} else {
						mittente.setAzienda(false);
						mittente.setNome(datiProtocollo.getSegnatura().getIntestazione().getOrigine().getMittente().getPersona().getNome());
						mittente.setCognome(datiProtocollo.getSegnatura().getIntestazione().getOrigine().getMittente().getPersona().getCognome());
					}
					result.setMittenteDestinatario(new ArrayList<DatiMittenteDestinatario>());
					result.getMittenteDestinatario().add(mittente);
					result.setOggetto(datiProtocollo.getSegnatura().getIntestazione().getOggetto());
				} else {
					result.getEsito().setCodice("1");
					result.getEsito().setDescrizione("Errore in recupero protocollo");
				}
			}
			else
			{
				result.getEsito().setCodice("2");
				result.getEsito().setDescrizione("Protocollo non trovato");
			}
		} catch (RemoteException e) {
			result.getEsito().setCodice("2");
			result.getEsito().setDescrizione("Errore in colloquio con protocollo :: "+e.getMessage());
			log.error("Errore in colloquio con protocollo :: "+e.getMessage(),e);
		}
		return result;
	}

	@Override
	public DatiOutputProtocollo completaProtocollazioneProvvisoria(
			AllegatoProtocollo documentoPrincipale,
			DatiOutputProtocollo datiIdentificativiProtocollo, DatiAutenticazione datiAutenticazione) {
		return null;
	}

	@Override
	public DatiOutputProtocollo allegaDocumentoAProtocollo(
			AllegatoProtocollo allegato,
			DatiOutputProtocollo datiIdentificativiProtocollo, DatiAutenticazione datiAutenticazione) {
		return null;
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
		return false;
	}

	@Override
	public boolean isImplementedProtocolloUscita() {
		return false;
	}

	public void setEndpointAddress(String endpointAddress) {
		this.endpointAddress = endpointAddress;
	}

	public void setCodiceAmministrazione(String codiceAmministrazione) {
		this.codiceAmministrazione = codiceAmministrazione;
	}

	public void setCodiceAoo(String codiceAoo) {
		this.codiceAoo = codiceAoo;
	}
	
	public void setWso2TokenUserName(String wso2TokenUserName) {
		this.wso2TokenUserName = wso2TokenUserName;
	}

	public void setWso2TokenPassword(String wso2TokenPassword) {
		this.wso2TokenPassword = wso2TokenPassword;
	}

}
