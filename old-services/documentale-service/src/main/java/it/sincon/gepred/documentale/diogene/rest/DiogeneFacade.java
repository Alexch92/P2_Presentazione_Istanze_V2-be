package it.sincon.gepred.documentale.diogene.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.jersey.core.util.Base64;

import it.innovapuglia.diogene.common.result.Result;
import it.innovapuglia.diogene.common.util.security.SharedCrypto;
import it.innovapuglia.diogene.models.Aggregato;
import it.innovapuglia.diogene.models.Cartella;
import it.innovapuglia.diogene.models.Documento;
import it.innovapuglia.diogene.models.FascicoloReale;
import it.innovapuglia.diogene.models.Titolario;
import it.innovapuglia.diogene.models.ricerca.RicercaType;
import it.innovapuglia.diogene.restclient.rest.DiogeneRestClientFactory;
import it.innovapuglia.diogene.restclient.rest.DiogeneRestClientFactory.DIOGENE_ENV;
import it.innovapuglia.diogene.restclient.rest.dao.AggregatoRestDAO;
import it.innovapuglia.diogene.restclient.rest.dao.CartellaRestDAO;
import it.innovapuglia.diogene.restclient.rest.dao.DocumentoRestDAO;
import it.innovapuglia.diogene.restclient.rest.dao.FascicoloRestDAO;
import it.innovapuglia.diogene.restclient.rest.dao.GatewayRestWSRestDAO;
import it.innovapuglia.diogene.restclient.rest.dao.RealeRestDAO;
import it.innovapuglia.diogene.restclient.rest.dao.exception.RestException;
import it.innovapuglia.diogene.restclient.rest.exception.DiogeneAuthException;
import it.innovapuglia.diogene.restclient.rest.gateway.DiogeneRestClientGateway;
import it.innovapuglia.diogene.restclient.rest.gateway.GatewayAuth;
import it.sincon.gepred.documentale.bean.DocumentaleException;

public class DiogeneFacade {

	private static Logger log = LoggerFactory.getLogger(DiogeneFacade.class);
	private DiogeneRestClientGateway gateway;
	private boolean gatewayTokenScaduto = false;
	
	private static String LOG_CALL_SERVICE_PREFIX = "DiogeneRestClient - Chiamata al servizio ";
	private static String LOG_RESPONSE_SERVICE_PREFIX = "DiogeneRestClient - Risposta del servizio ";
	
    public DiogeneFacade(){}
    
    public boolean isGatewayTokenScaduto() {
		return gatewayTokenScaduto;
	}

	public void setGatewayTokenScaduto(boolean gatewayTokenScaduto) {
		this.gatewayTokenScaduto = gatewayTokenScaduto;
	}

	/**
     * Metodo per inizializzare e impostare il client per l'integrazione con Diogene.
     * @param gw_user 				username dell'utenza del gateway.
     * @param gw_pwd password 		password dell'utenza del gateway.
     * @param gw_consumer_key 		consumer key del gateway.
     * @param gw_consumer_secret 	consumer secret del gateway.
     * @param dgn_user 				username dell'utenza di Diogene.
     * @param dgn_pwd 				password dell'utenza di Diogene.
     * @param dgn_consumer_key 		consumer key del gateway.
     * @param dgn_consumer_secret	consumer secret del gateway.
     * @param client_ip				IP del Server da cui vengono effettuate le chiamate ai servizi DIOGENE;
     */
    public void initGateway(String diogene_env, String gw_user, String gw_pwd, String gw_consumer_key,
    		String gw_consumer_secret, String dgn_user, String dgn_pwd, String dgn_consumer_key,
    		String dgn_consumer_secret, String client_ip) {
    	setup(diogene_env);
    	login(gw_user, gw_pwd, gw_consumer_key, gw_consumer_secret, dgn_user, dgn_pwd, 
    			dgn_consumer_key, dgn_consumer_secret, client_ip);
    	
    }
    
    /**
     * Metodo per impostare l'ambiente a cui far puntare il modulo (sviluppo o produzione).
     */
    private void setup(String diogene_env){
    	try{
    		log.debug(String.format("Try get Diogene Client Instance [diogene_env:%s]...", diogene_env));
    		this.gateway = (DiogeneRestClientGateway) DiogeneRestClientFactory
    				.getDiogeneClientInstance(DIOGENE_ENV.valueOf(diogene_env));
    		log.debug(String.format("Diogene Client Instance retrived!! [Gateway uri:%s]...", this.gateway.getGatewayUri()));

    	} catch (Exception e) {
    		log.error(e.getMessage(), e);
    	}
    }
    
    /**
     * Login sul sistema Diogene e sul gateway dei servizi REST.
     * @param gw_user 				username dell'utenza del gateway.
     * @param gw_pwd password 		password dell'utenza del gateway.
     * @param gw_consumer_key 		consumer key del gateway.
     * @param gw_consumer_secret 	consumer secret del gateway.
     * @param dgn_user 				username dell'utenza di Diogene.
     * @param dgn_pwd 				password dell'utenza di Diogene.
     * @param dgn_consumer_key 		consumer key del gateway.
     * @param dgn_consumer_secret	consumer secret del gateway.
     * @param client_ip				IP del Server da cui vengono effettuate le chiamate ai servizi DIOGENE;
     */
    private void login(String gw_user, String gw_pwd, String gw_consumer_key,
    		String gw_consumer_secret, String dgn_user, String dgn_pwd, String dgn_consumer_key,
    		String dgn_consumer_secret, String client_ip) {
    	try{
	    	// Login Gateway
	    	String auth = new String(Base64.encode(gw_consumer_key + ":" + gw_consumer_secret));
	    	log.debug(String.format("Try login gateway [gw_user:%s - gw_consumer_key:%s - gw_consumer_secret:%s auth:%s]...", 
	    			gw_user, gw_consumer_key, gw_consumer_secret, auth));
	        this.gateway.loginGateway(gw_user, gw_pwd, auth);
	        log.debug("Login gateway done !!");
	        
	        // Renew token Gateway
	        renewGatewayToken(gw_consumer_key, gw_consumer_secret);
	        
	        // Login Diogene
	        String diogeneAuth = new String(Base64.encode(dgn_consumer_key + ":" + dgn_consumer_secret));
	        log.debug(String.format("Try diogene login [dgn_user:%s  - diogeneAuth:%s - client_ip:%s]...", 
	        		dgn_user, diogeneAuth, client_ip));
	        this.gateway.login(
	        		dgn_user,
	                SharedCrypto.encrypt(dgn_pwd),
	                client_ip,
	                diogeneAuth, false);
	        log.debug("Diogene login done !!");
		} catch (Exception e) {
			this.gateway = null;
        	log.error(e.getMessage(), e);
        	e.printStackTrace();
        }
	}
    
    /**
     * Generazione di un nuovo token per il gateway dei servizi REST.
     * @param gw_consumer_key 		consumer key del gateway.
     * @param gw_consumer_secret 	consumer secret del gateway.
     */
    public void renewGatewayToken(String gw_consumer_key, String gw_consumer_secret)
    		throws DiogeneAuthException{
    	// Renew token Gateway
        String renewAuth = new String(Base64.encode(gw_consumer_key + ":" + gw_consumer_secret));
        log.debug(String.format("Try renew access token gateway [renewAuth:%s]...", renewAuth));
        this.gateway.renewAccessTokenGateway(renewAuth);
        
        if (this.gateway!= null && gateway.getRestError()!=null)
        	log.debug(String.format("gateway.getRestError().toString()=%s...", gateway.getRestError().toString()));
        
        this.gatewayTokenScaduto = false;
        log.debug("Renew access token gateway done !!");
    }
    
    /**
     * In caso di RestException porto a null il gateway, in modo da forzare un successivo re-init...
     * @param e
     * @throws DocumentaleException
     */
    private String manageException(Exception e) {
    	String errMessage = "";
    	
    	if(e instanceof RestException) {
    		RestException re = (RestException) e;
    		errMessage = (re.getMessaggio());
    		if (re.getCodice().equals("401"))
    			this.gateway = null;
		}else{
			errMessage = e.getMessage();
		}
		
    	log.error(errMessage, e);
		return errMessage;
    }
    
    /**
     * Legge le informazioni dei titolari.
     * @return Elenco dei titolari disponibili.
     * @throws Exception
     */
    public List<Titolario> leggiTitolari() throws Exception {
			FascicoloRestDAO<FascicoloReale> fascicoloDao = 
						new FascicoloRestDAO<FascicoloReale>(FascicoloReale.class, "", getGateway()) {};
			Result<List<Titolario>> result = fascicoloDao.getTitolari();
			return result.getResult();
	}
    
    /**
     * Recupera documenti e fascicoli afferenti al titolario e alla voce del titolario specificati.
     * @param idTitolario identificativo del titolario.
     * @param idVoceTitolario identificativo della voce del titolario.
     * @return Aggregato che contiene documenti e fascicoli richiesti.
     * @throws Exception
     */
    public Aggregato esploraTitolario(String idTitolario, String idVoceTitolario) throws Exception {
				AggregatoRestDAO<Aggregato> fascicoloDao = 
					new AggregatoRestDAO<Aggregato>(Aggregato.class, getGateway());
				Result<Aggregato> result = fascicoloDao.esploraTitolario(idTitolario, 
					idVoceTitolario, null);
				return result.getResult(); 
	}
    
    
    /**
     * Crea un fascicolo in Diogene. 
     * @param fascicolo 
     * @param isSubfascicolo true se � un sottofascicolo, false altrimenti.
     * @param ereditaPermessi true se si vogliono ereditare i permessi del contenitore, false altrimenti.
     * @return fascicolo creato.
     * @throws Exception
     */
    public FascicoloReale creaFascicolo(FascicoloReale fascicolo, boolean isSubfascicolo, 
    		boolean ereditaPermessi) throws DocumentaleException {
    	try{
    		GatewayRestWSRestDAO dao = new GatewayRestWSRestDAO(getGateway());
    		
    		log.info(LOG_CALL_SERVICE_PREFIX + "'creaFascicolo'...");
    		Result<FascicoloReale> rest_response = dao.creaReale(fascicolo, isSubfascicolo, ereditaPermessi);
    		if (rest_response.getCodice()!=0){
    			log.error(String.format("%s'creaFascicolo' : Error code:%s Error Msg:%s", LOG_RESPONSE_SERVICE_PREFIX, 
    					rest_response.getCodice(), rest_response.getMessaggio()));

    			throw new DocumentaleException(rest_response.getMessaggio());
    		}else{
    			log.info(String.format("%s'creaFascicolo' : cod=%s | Msg=%s", LOG_RESPONSE_SERVICE_PREFIX, 
    					rest_response.getCodice(), rest_response.getMessaggio()));
    			
    			return rest_response.getResult();
    		}
    	}catch (Exception e) {
    		throw new DocumentaleException(manageException(e), e);
    	}
    }
    
    /**
     * Crea una cartella in Diogene.
     * @param cartella
     * @param ereditaPermessi true se si vogliono ereditare i permessi del contenitore, false altrimenti.
     * @return cartella creata.
     * @throws Exception
     */
    public Cartella creaCartella(Cartella cartella, boolean ereditaPermessi) throws DocumentaleException {
    	try{
    		GatewayRestWSRestDAO dao = new GatewayRestWSRestDAO(getGateway());
    		log.info(LOG_CALL_SERVICE_PREFIX + "'creaCartella'...");
    		Result<Cartella> rest_response = dao.creaCartella(cartella, ereditaPermessi);
    		if (rest_response.getCodice()!=0){
    			log.error(String.format("%s'creaCartella' : Error code:%s Error Msg:%s", LOG_RESPONSE_SERVICE_PREFIX, 
    					rest_response.getCodice(), rest_response.getMessaggio()));

    			throw new DocumentaleException(rest_response.getMessaggio());
    		}else{
    			log.info(String.format("%s'creaCartella' : cod=%s | Msg=%s", LOG_RESPONSE_SERVICE_PREFIX, 
    					rest_response.getCodice(), rest_response.getMessaggio()));
    			
    			return rest_response.getResult();
    		}
    	}catch (Exception e) {
    		throw new DocumentaleException(manageException(e), e);
    	}
    }
    
   
    /**
     * Crea un documento in Diogene.
     * @param documento
     * @param ereditaPermessi true se si vogliono ereditare i permessi del contenitore, false altrimenti.
     * @return documento creato.
     * @throws DocumentaleException
     */
    public Documento creaDocumento(Documento documento, boolean ereditaPermessi) throws DocumentaleException {
    	try{
    		GatewayRestWSRestDAO dao = new GatewayRestWSRestDAO(getGateway());
    		log.info(LOG_CALL_SERVICE_PREFIX + "'creaDocumento'...");
    		Result<Documento> rest_response = dao.creaDocumento(documento, ereditaPermessi);
    		
    		if (rest_response.getCodice()!=0){
    			log.error(String.format("%s'creaDocumento' : Error code:%s Error Msg:%s", LOG_RESPONSE_SERVICE_PREFIX, 
    					rest_response.getCodice(), rest_response.getMessaggio()));

    			throw new DocumentaleException(rest_response.getMessaggio());
    		}else{
    			log.info(String.format("%s'creaDocumento' : cod=%s | Msg=%s", LOG_RESPONSE_SERVICE_PREFIX, 
    					rest_response.getCodice(), rest_response.getMessaggio()));
    			
    			return rest_response.getResult();
    		}
    	}catch (Exception e) {
    		throw new DocumentaleException(manageException(e), e);
    	}
    }
    
    /**
     * Recupera i documenti e i fascicoli/cartelle che si trovano all'interno del contenitore specificato.
     * @param idContenitore identificativo del contenitore.
     * @return Aggregato che contiene le liste di documenti e fascicoli.
     * @throws Exception
     */
    public Aggregato mostraContenuto(String idContenitore) throws Exception {
    	GatewayRestWSRestDAO dao = new GatewayRestWSRestDAO(getGateway());
    	Result<Aggregato> result = dao.mostraContenuto(idContenitore);
    	return result.getResult();
    }
    
    /**
     * Recupera i documenti e/o i fascicoli/cartelle che si trovano all'interno del contenitore specificato.
     * @param idContenitore identificativo del contenitore.
     * @param aggregati true se leggere cartelle/fascicoli contenuti, false altrimenti.
     * @param documenti true se leggere i documenti contenuti, false altrimenti.
     * @return Aggregato che contiene le liste di documenti e/o fascicoli.
     * @throws Exception 
     */
    public Aggregato mostraContenuto(String idContenitore, boolean aggregati, boolean documenti) 
    		throws DocumentaleException {
    	try{
    		GatewayRestWSRestDAO dao = new GatewayRestWSRestDAO(getGateway());
    		log.info(String.format("%s'mostraContenuto'...uuidContenitore:%s", LOG_CALL_SERVICE_PREFIX, idContenitore));
    		Result<Aggregato> rest_response = dao.mostraContenuto(idContenitore, aggregati, documenti, false);

    		if (rest_response.getCodice()!=0){
    			log.error(String.format("%s'downloadDocumento' : Error code:%s Error Msg:%s", LOG_RESPONSE_SERVICE_PREFIX, 
    					rest_response.getCodice(), rest_response.getMessaggio()));

    			throw new DocumentaleException(rest_response.getMessaggio());
    		}else{
    			if (aggregati){
    				log.info(String.format("%s'mostraContenuto' : cod=%s | Msg=%s | aggregati figli recuperati=%s", LOG_RESPONSE_SERVICE_PREFIX,
    						rest_response.getCodice(), rest_response.getMessaggio(), rest_response.getResult().getAggregati().size()));
    			}
    			if (documenti){
    				log.info(String.format("%s'mostraContenuto' : cod=%s | Msg=%s | doc recuperati=%s", LOG_RESPONSE_SERVICE_PREFIX,
    						rest_response.getCodice(), rest_response.getMessaggio(), rest_response.getResult().getDocumenti().size()));
    			}

    			return rest_response.getResult();
    		}
    	}catch (Exception e) {
    		throw new DocumentaleException(manageException(e), e);
    	}
    }
    
    /**
     * Effettua il download del file content di un documento, oltre a leggerne gli attributi.
     * @param idDocumento identificativo del documento.
     * @param idVersione identificativo della versione del documento, se null scarica l'ultima versione
     * @param tipoContenitore tipo del contenitore del documento.
     * @return documento scaricato.
     * @throws Exception
     */
    public Documento downloadDocumento(String idDocumento, String idVersione, String tipoContenitore) 
    		throws DocumentaleException {
    	try{
    		GatewayRestWSRestDAO dao = new GatewayRestWSRestDAO(getGateway());
    		log.info(LOG_CALL_SERVICE_PREFIX + "'downloadDocumento'...");
    		Result<Documento> rest_response = dao.download(idDocumento, idVersione, tipoContenitore);
    		if (rest_response.getCodice()!=0){
    			log.error(String.format("%s'downloadDocumento' : Error code:%s Error Msg:%s", LOG_RESPONSE_SERVICE_PREFIX, 
    					rest_response.getCodice(), rest_response.getMessaggio()));

    			throw new DocumentaleException(rest_response.getMessaggio());
    		}else{
    			log.info(String.format("%s'downloadDocumento' : cod=%s | Msg=%s", LOG_RESPONSE_SERVICE_PREFIX, 
    					rest_response.getCodice(), rest_response.getMessaggio()));

    			return rest_response.getResult();
    		}
    	}catch (Exception e) {
    		throw new DocumentaleException(manageException(e), e);
    	}
    }
    
    
    /**
     * Legge gli attributi di un documento di Diogene.
     * @param idDocumento identificativo del documento.
     * @param tipoContenitore tipo del contenitore del documento.
     * @return documento
     * @throws Exception
     */
    public Documento leggiDocumento(String idDocumento, String tipoContenitore) throws DocumentaleException {
    	try{
    		GatewayRestWSRestDAO dao = new GatewayRestWSRestDAO(getGateway());
    		log.info(LOG_CALL_SERVICE_PREFIX + "'leggiDocumento'...");
    		Result<Documento> rest_response = dao.leggiDocumento(idDocumento, tipoContenitore);
    		if (rest_response.getCodice()!=0){
    			log.error(String.format("%s'leggiDocumento' : Error code:%s Error Msg:%s", LOG_RESPONSE_SERVICE_PREFIX, 
    					rest_response.getCodice(), rest_response.getMessaggio()));

    			throw new DocumentaleException(rest_response.getMessaggio());
    		}else{
    			log.info(String.format("%s'leggiDocumento' : cod=%s | Msg=%s", LOG_RESPONSE_SERVICE_PREFIX, 
    					rest_response.getCodice(), rest_response.getMessaggio()));

    			return rest_response.getResult();
    		}
    	}catch (Exception e) {
    		throw new DocumentaleException(manageException(e), e);
    	}
    }
    
    /**
     * Legge gli attributi di una cartella di Diogene.
     * @param idCartella identificativo della cartella.
     * @return cartella.
     * @throws Exception
     */
    public Cartella leggiCartella(String idCartella) throws DocumentaleException {
    	try{
    		GatewayRestWSRestDAO dao = new GatewayRestWSRestDAO(getGateway());
    		log.info(LOG_CALL_SERVICE_PREFIX + "'leggiCartella'...");
    		Result<Cartella> rest_response = dao.leggiCartella(idCartella);
    		if (rest_response.getCodice()!=0){
    			log.error(String.format("%s'leggiCartella' : Error code:%s Error Msg:%s", LOG_RESPONSE_SERVICE_PREFIX, 
    					rest_response.getCodice(), rest_response.getMessaggio()));

    			throw new DocumentaleException(rest_response.getMessaggio());
    		}else{
    			log.info(String.format("%s'leggiCartella' : cod=%s | Msg=%s", LOG_RESPONSE_SERVICE_PREFIX, 
    					rest_response.getCodice(), rest_response.getMessaggio()));

    			return rest_response.getResult();
    		}
    	}catch (Exception e) {
    		throw new DocumentaleException(manageException(e), e);
    	}
    }
    
    /**
     * Legge gli ttributi di un fascicolo di Diogene.
     * @param idFascicolo identificativo del fascicolo.
     * @return fascicolo.
     * @throws Exception
     */
    public FascicoloReale leggiFascicolo(String idFascicolo) throws DocumentaleException {
    	try{
    		GatewayRestWSRestDAO dao = new GatewayRestWSRestDAO(getGateway());
    		log.info(LOG_CALL_SERVICE_PREFIX + "'leggiReale'...");
    		Result<FascicoloReale> rest_response = dao.leggiReale(idFascicolo);
    		if (rest_response.getCodice()!=0){
    			log.error(String.format("%s'leggiReale' : Error code:%s Error Msg:%s", LOG_RESPONSE_SERVICE_PREFIX, 
    					rest_response.getCodice(), rest_response.getMessaggio()));

    			throw new DocumentaleException(rest_response.getMessaggio());
    		}else{
    			log.info(String.format("%s'leggiReale' : cod=%s | Msg=%s", LOG_RESPONSE_SERVICE_PREFIX, 
    					rest_response.getCodice(), rest_response.getMessaggio()));

    			return rest_response.getResult();
    		}
    	}catch (Exception e) {
    		throw new DocumentaleException(manageException(e), e);
    	}
    }
    
    /**
     * Elimina un documento da Diogene.
     * @param idDocumento identificativo del documento.
     * @param tipoContenitore tipo contenitore del documento.
     * @throws Exception
     */
    public void cancellaDocumento(String idDocumento, String tipoContenitore) throws DocumentaleException {
    	try{
    		DocumentoRestDAO dao = new DocumentoRestDAO(getGateway());
    		log.info(LOG_CALL_SERVICE_PREFIX + "'DocumentoRestDAO.delete'...");
    		dao.delete(idDocumento, tipoContenitore);
    	}catch (Exception e) {
    		throw new DocumentaleException(manageException(e), e);
    	}
    }

    /**
     * Elimina una cartella da Diogene.
     * @param idCartella identificativo della cartella.
     * @throws Exception 
     */
    public void cancellaCartella(String idCartella) throws DocumentaleException {
    	try{
    		log.info(LOG_CALL_SERVICE_PREFIX + "'CartellaRestDAO.delete'...");
    		CartellaRestDAO dao = new CartellaRestDAO(getGateway());
        	dao.delete(idCartella);
    	}catch (Exception e) {
    		throw new DocumentaleException(manageException(e), e);
    	}
    }
    
    /**
     * Elimina un fascicolo da Diogene.
     * @param idFascicolo
     * @throws Exception
     */
    public void cancellaFascicolo(String idFascicolo) throws DocumentaleException {
    	try{
    		log.info(LOG_CALL_SERVICE_PREFIX + "'RealeRestDAO.delete'...");
    		RealeRestDAO dao = new RealeRestDAO(getGateway());
    		dao.delete(idFascicolo);
    	}catch (Exception e) {
    		throw new DocumentaleException(manageException(e), e);
    	}
    }
    
    /**
     * Sposta un cartella di Diogene in un nuovo contenitore.
     * @param idCartella identificativo della cartella da spostare.
     * @param idDestinazione identificativo del contenitore di destinazione.
     * @param params 
     * @return cartella spostata.
     * @throws Exception
     */
    public Cartella spostaCartella(String idCartella, String idDestinazione, String... params) 
    		throws DocumentaleException {
    	try{
    		CartellaRestDAO dao = new CartellaRestDAO(getGateway());
    		log.info(LOG_CALL_SERVICE_PREFIX + "'spostaCartella'...");
    		Result<Cartella> rest_response = dao.sposta(idCartella, idDestinazione, params);
    		if (rest_response.getCodice()!=0){
    			log.error(String.format("%s'spostaCartella' : Error code:%s Error Msg:%s", LOG_RESPONSE_SERVICE_PREFIX, 
    					rest_response.getCodice(), rest_response.getMessaggio()));

    			throw new DocumentaleException(rest_response.getMessaggio());
    		}else{
    			log.info(String.format("%s'spostaCartella' : cod=%s | Msg=%s", LOG_RESPONSE_SERVICE_PREFIX, 
    					rest_response.getCodice(), rest_response.getMessaggio()));

    			return rest_response.getResult();
    		}
    	}catch (Exception e) {
    		throw new DocumentaleException(manageException(e), e);
    	}
    }
    
    /**
     * Sposta un fascicolo di Diogene in un nuovo contenitore.
     * @param idFascicolo
     * @param idDestinazione
     * @param params
     * @return
     * @throws Exception
     */
    public FascicoloReale spostaFascicolo(String idFascicolo, String idDestinazione, String... params)
    		throws DocumentaleException {
    	try{
    		RealeRestDAO dao = new RealeRestDAO(getGateway());
    		log.info(LOG_CALL_SERVICE_PREFIX + "'spostaFascicolo'...");
    		Result<FascicoloReale> rest_response = dao.sposta(idFascicolo, idDestinazione, params);
    		if (rest_response.getCodice()!=0){
    			log.error(String.format("%s'spostaFascicolo' : Error code:%s Error Msg:%s", LOG_RESPONSE_SERVICE_PREFIX, 
    					rest_response.getCodice(), rest_response.getMessaggio()));

    			throw new DocumentaleException(rest_response.getMessaggio());
    		}else{
    			log.info(String.format("%s'spostaFascicolo' : cod=%s | Msg=%s", LOG_RESPONSE_SERVICE_PREFIX, 
    					rest_response.getCodice(), rest_response.getMessaggio()));

    			return rest_response.getResult();
    		}
    	}catch (Exception e) {
    		throw new DocumentaleException(manageException(e), e);
    	}
    }
    
    /**
     * Sposta un documento di Diogene in un nuovo contenitore.
     * @param idDocumento identificativo del documento da spostare.
     * @param idDestinazione identificativo dell conteniore di destinazione.
     * @param tipoDestinazione tipo del contenitore di destinazione.
     * @param ereditaPermessi true se si vogliono ereditare i permessi del contenitore, false altrimenti.
     * @return documento spostato.
     * @throws Exception
     */
    public Documento spostaDocumento(String idDocumento, String idDestinazione, 
    		String tipoDestinazione, boolean ereditaPermessi) throws DocumentaleException {
    	try{
    		GatewayRestWSRestDAO dao = new GatewayRestWSRestDAO(getGateway());
    		log.info(LOG_CALL_SERVICE_PREFIX + "'spostaDocumento'...");
    		Result<Documento> rest_response = dao.spostaDocumento(idDocumento, idDestinazione, 
    				tipoDestinazione, ereditaPermessi);
    		if (rest_response.getCodice()!=0){
    			log.error(String.format("%s'spostaDocumento' : Error code:%s Error Msg:%s", LOG_RESPONSE_SERVICE_PREFIX, 
    					rest_response.getCodice(), rest_response.getMessaggio()));

    			throw new DocumentaleException(rest_response.getMessaggio());
    		}else{
    			log.info(String.format("%s'spostaDocumento' : cod=%s | Msg=%s", LOG_RESPONSE_SERVICE_PREFIX, 
    					rest_response.getCodice(), rest_response.getMessaggio()));

    			return rest_response.getResult();
    		}
    	}catch (Exception e) {
    		throw new DocumentaleException(manageException(e), e);
    	}
    }

    /**
     * Ricerca un contenitore o un documento in base a determinati parametri di selezioe.
     * @param ricerca Oggetto in cui specificare i parametri per la ricerca, es. nome, titolo, 
     * 			id, tipo oggetto, etc.
     * @param maxResult numero massimo di risultati.
     * @return Aggregato che contiene gli oggetti restituiti dalla ricerca.
     * @throws Exception
     */
    public Aggregato ricercaWS(RicercaType ricerca, int maxResult) throws Exception{
    	GatewayRestWSRestDAO dao = new GatewayRestWSRestDAO(getGateway());
    	Result<Aggregato> result = dao.ricercaWS(ricerca, maxResult);
    	return result.getResult();
    }

	public DiogeneRestClientGateway getGateway() {
		return gateway;
	}

	public void setGateway(DiogeneRestClientGateway gateway) {
		this.gateway = gateway;
	}
    
}
