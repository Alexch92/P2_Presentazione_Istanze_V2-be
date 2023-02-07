package it.sincon.gepred.documentale.diogene.rest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.sincon.gepred.documentale.bean.DateUtils;
import it.sincon.gepred.documentale.bean.DocFile;
import it.sincon.gepred.documentale.bean.DocInfo;
import it.sincon.gepred.documentale.bean.DocumentaleException;
import it.sincon.gepred.documentale.diogene.domain.SottoAggregati;
import it.sincon.gepred.documentale.diogene.enums.TipoDocumento;
import it.sincon.gepred.documentale.diogene.persistence.SottoAggregatiRepository;
import it.sincon.gepred.documentale.diogene.rest.thread.AsyncSpostaDocumento;
import it.sincon.gepred.documentale.service.DocumentaleService;
import it.sincon.gepred.documentale.service.DocumentaleUtils;
import it.innovapuglia.diogene.models.Aggregato;
import it.innovapuglia.diogene.models.Cartella;
import it.innovapuglia.diogene.models.Documento;
import it.innovapuglia.diogene.models.FascicoloReale;
import it.innovapuglia.diogene.models.NumerazioneFascicolo;
import it.innovapuglia.diogene.restclient.rest.dao.exception.RestException;
import it.innovapuglia.diogene.restclient.rest.exception.DiogeneAuthException;

public class DocumentaleServiceDiogeneImpl implements DocumentaleService {
	private static Logger log = LoggerFactory.getLogger(DocumentaleServiceDiogeneImpl.class);

	private static String TIPOOGGETTO_DOCUMENTO = "D";

	//#SA# Il tipo conenitore dovrebbe essere Fascicolo_Reale (R). in test usiamo Cartella (C).
	private static String AGGREGATO_CARTELLA = "C";
	private static String AGGREGATO_FASCICOLO_REALE = "R";
	
	private DiogeneFacade diogene;
	
	private String enviroment;

	private String gatewayUsername;
	private String gatewayPassword;
	private String gatewayConsumerKey;
	private String gatewayConsumerSecret;
	
	private String diogUsername;
	private String diogPassword;
	private String diogConsumerKey;
	private String diogConsumerSecret;
	private String diogIDAggregatoRoot;
	private String diogIdTitolario;
	private String diogIdVoceTitolario;
	private int diogLimiteSottoAggregati;
	
	private String fasciculusServerIp;
	
	private String titoloDocumentoInvalidsPattern;

	@Inject
	private SottoAggregatiRepository sottoAggregatiRepository;

	public void setEnviroment(String enviroment) {
		this.enviroment = enviroment;
	}
	public void setGatewayUsername(String gatewayUsername) {
		this.gatewayUsername = gatewayUsername;
	}
	public void setGatewayPassword(String gatewayPassword) {
		this.gatewayPassword = gatewayPassword;
	}
	public void setGatewayConsumerKey(String gatewayConsumerKey) {
		this.gatewayConsumerKey = gatewayConsumerKey;
	}
	public void setGatewayConsumerSecret(String gatewayConsumerSecret) {
		this.gatewayConsumerSecret = gatewayConsumerSecret;
	}
	public void setDiogUsername(String diogUsername) {
		this.diogUsername = diogUsername;
	}
	public void setDiogPassword(String diogPassword) {
		this.diogPassword = diogPassword;
	}
	public void setDiogConsumerKey(String diogConsumerKey) {
		this.diogConsumerKey = diogConsumerKey;
	}
	public void setDiogConsumerSecret(String diogConsumerSecret) {
		this.diogConsumerSecret = diogConsumerSecret;
	}
	public String getDiogIdTitolario() {
		return diogIdTitolario;
	}
	public void setDiogIdTitolario(String diogIdTitolario) {
		this.diogIdTitolario = diogIdTitolario;
	}
	public String getDiogIdVoceTitolario() {
		return diogIdVoceTitolario;
	}
	public void setDiogIdVoceTitolario(String diogIdVoceTitolario) {
		this.diogIdVoceTitolario = diogIdVoceTitolario;
	}
	public void setDiogIDAggregatoRoot(String _diogIDAggregatoRoot) {
		this.diogIDAggregatoRoot = _diogIDAggregatoRoot;
	}
	public int getDiogLimiteSottoAggregati() {
		return diogLimiteSottoAggregati;
	}
	public void setDiogLimiteSottoAggregati(int diogLimiteSottoAggregati) {
		this.diogLimiteSottoAggregati = diogLimiteSottoAggregati;
	}
	public String getFasciculusServerIp() {
		return fasciculusServerIp;
	}
	public void setFasciculusServerIp(String fasciculusServerIp) {
		this.fasciculusServerIp = fasciculusServerIp;
	}
	public String getTitoloDocumentoInvalidsPattern() {
		return titoloDocumentoInvalidsPattern;
	}
	public void setTitoloDocumentoInvalidsPattern(
			String titoloDocumentoInvalidsPattern) {
		this.titoloDocumentoInvalidsPattern = titoloDocumentoInvalidsPattern;
	}
	
	private DiogeneFacade init(String user, String password){
		try {
			DiogeneFacade diogene =  new DiogeneFacade();
			diogene.initGateway(enviroment, 
								gatewayUsername, 
								gatewayPassword, 
								gatewayConsumerKey, 
								gatewayConsumerSecret, 
								user, password, 
								diogConsumerKey, 
								diogConsumerSecret,
								fasciculusServerIp);
			log.info("init diogene connection with "+user+" user credentials DONE!");
			
			return diogene;			
		} catch(Exception e) {
			return null;
		}
	}
	
	private void clearDiogeneFacade(){
		log.debug("clearDiogeneFacade...");
//		diogene.setGatewayTokenScaduto(true);
		diogene = null;
	}
	
	private DiogeneFacade getDiogeneFacade()  throws DocumentaleException{
		if(diogene == null || (diogene!=null && diogene.getGateway() == null)) {
			diogene = init(diogUsername, diogPassword);
		}
		
		if(diogene!=null && diogene.getGateway()!= null && diogene.isGatewayTokenScaduto()){
			try {
				diogene.renewGatewayToken(gatewayConsumerKey, gatewayConsumerSecret);
			} catch (DiogeneAuthException e) {
				diogene = null;
				throw new DocumentaleException("Connessione con Diogene fallita: " + e.getMessage());
			}
		}
		
		if(diogene!=null && diogene.getGateway()!= null && diogene.getGateway().getUsername()==null){
			diogene = null;
			throw new DocumentaleException("Connessione con Diogene fallita.");
		}
		
		return diogene;
	}

	private String creaCartella(String idAggregatoPadre, String nomeCartella) throws Exception{
		Cartella nuovaCartella = new Cartella();
		nuovaCartella.setIdPadre(idAggregatoPadre);
		nuovaCartella.setNomeAggregato(nomeCartella);

		
		Cartella rest_response = getDiogeneFacade().creaCartella(nuovaCartella, true);
		String  uuidContenitoreCreato = rest_response.getIdAggregato();
		log.info(String.format("Nuova cartella creata con uuid = %s", uuidContenitoreCreato));

		return uuidContenitoreCreato;
	}

	private String creaFascicolo(String uuidContenitorePadre, String nomeFascicolo, String oggettoPratica, boolean gestisciLimiteSottoAggregati) throws Exception{
		String uuidFascicolo = uuidContenitorePadre;
		
		if (gestisciLimiteSottoAggregati){
			// Se il parametro appProperties.diogLimiteSottoAggregati = 0 non si esegue la gestione dei sottoAggregati...
			if (diogLimiteSottoAggregati>0){
				// Verifico se devo creare una nuova sottocartella
				SottoAggregati entity = null;
				List<SottoAggregati> listSottoAggregati = sottoAggregatiRepository.findByUuidContenitorePadre(uuidContenitorePadre);
				if (listSottoAggregati.size()==0){
					String uuid = creaCartella(uuidContenitorePadre,String.format("DAL %s", nomeFascicolo));
					// Salvo in db la nuova entry
					entity = sottoAggregatiRepository.save(new SottoAggregati(uuidContenitorePadre,uuid,1,0));
				}
				else
					entity = listSottoAggregati.get(0);

				uuidFascicolo=entity.getUuidContenitoreFiglio();
				if (entity.getNrFigli()>=diogLimiteSottoAggregati){
					log.debug(String.format("Raggiunto il limite max(=%s) di elementi per il contenitore Diogene uuid=%s", diogLimiteSottoAggregati, uuidFascicolo));

					log.debug(String.format("Generazione della nuova sottocartella %s...", String.format("DAL %s", nomeFascicolo)));
					uuidFascicolo = creaCartella(uuidContenitorePadre,String.format("DAL %s", nomeFascicolo));

					entity.setUuidContenitoreFiglio(uuidFascicolo);
					entity.setOrdinaleFiglio(entity.getOrdinaleFiglio()+1);
					entity.setNrFigli(0);
					entity = sottoAggregatiRepository.save(entity);
				}

				// salvo lo stato dei sotto aggregati...
				entity.setNrFigli(entity.getNrFigli()+1);
				sottoAggregatiRepository.save(entity);
			}
		}

		FascicoloReale nuovoFascicolo = new FascicoloReale();
		nuovoFascicolo.setNomeAggregato(nomeFascicolo);
		nuovoFascicolo.setDescrizione(nomeFascicolo);
		nuovoFascicolo.setOggetto(oggettoPratica);
		nuovoFascicolo.setIdPadre(uuidFascicolo);
		nuovoFascicolo.setIdTitolario(diogIdTitolario);
		nuovoFascicolo.setIdVoceTitolario(diogIdVoceTitolario);

		NumerazioneFascicolo numeroFascicolo  = new NumerazioneFascicolo();
		numeroFascicolo.setTipologiaNumerazione(1);
		nuovoFascicolo.setNumerazione(numeroFascicolo);

		FascicoloReale fascicoloCreato = getDiogeneFacade().creaFascicolo(nuovoFascicolo, false, true);
		String uuidContenitoreCreato = fascicoloCreato.getIdAggregato();
		log.info(String.format("Nuovo fascicolo creato con uuid = %s", uuidContenitoreCreato));

		return uuidContenitoreCreato;
	}
	private String creaContenitoreFascicolo(String uuidContenitoreRoot, String[] elements) throws Exception {
		String uuidContenitoreResult = uuidContenitoreRoot;
		// Elaboro tutte le categorie del path...
		boolean found = false;
		for (int idx=0; idx<elements.length-1; idx++){
			// verifico se è stato già creato un aggregato per questa categoria...
			Aggregato retAggregato = getDiogeneFacade().mostraContenuto(uuidContenitoreResult, true, false);

			if (retAggregato.getAggregati().size() > 0){
				int k=0;
				found=false;
				
				for (;k<retAggregato.getAggregati().size(); k++){
					found = retAggregato.getAggregati().get(k).getNomeAggregato().equals(elements[idx]);
					if (found)
						break;
				}
				
				if (found)
				{
					uuidContenitoreResult = retAggregato.getAggregati().get(k).getIdAggregato();
					log.debug(String.format("Contenitore trovato: nome = %s; uuid = %s", elements[idx], uuidContenitoreResult));
				}
			}
			if (!found)					
				uuidContenitoreResult = creaCartella(uuidContenitoreResult, elements[idx]);
		}
		return uuidContenitoreResult;
	}
	
	/**
	 * Analizza il destPath passato in input e crea in Diogene l'alberatura necessaria.
	 * destPath deve contenere il percorso a partire dalla root, fino al nome del nuovo fascicolo da creare,
	 * contenuto nell'ultimo elemento del path.
	 * 	es: DOC. FASCICOLATI - RICORSI - CONT 000001 2014.
	 * In Diogene verranno creati gli aggregati fino al fascicolo. 
	 * In fase di creazione del fascicolo viene gestito il numero massimo di sottoaggregati possibili in Diogene.
	 * Se il destPath contiene un solo elemento si segue la gestione per la creazione del fascicolo RICHESTE PARERI
	 * che viene creato direttamente sotto l'aggregato root di Diogene.  
	 */
	public String creaContenitore(String destPath, String regex, String oggettoPratica) throws DocumentaleException {
		String result = "";
		log.info(String.format("CreaContenitore - diogIDAggregatoRoot = %s; destPath = %s; regex=%s", diogIDAggregatoRoot, destPath,regex));

		try{
			String[] elements = destPath.split(regex); 
			if (elements.length == 0){
				clearDiogeneFacade();
				throw new DocumentaleException("Invalid format of destination folder path!");
			}

			// Il nome del nuovo fascicolo Diogene da creare e'....
			String nomeNuovoFascicolo = elements[elements.length-1];
			if (elements.length > 1){
				String uuidContenitorePadre = creaContenitoreFascicolo(diogIDAggregatoRoot, elements);
				// Creazione del nuovo Fascicolo...
				result = creaFascicolo(uuidContenitorePadre, nomeNuovoFascicolo, oggettoPratica, true);
			}else{
				// Verifico se già esiste tale fascicolo.... se non esiste lo creo.
				result = ricercaInContenitore(nomeNuovoFascicolo, true, diogIDAggregatoRoot);
				if (result == null)
					// Creazione del nuovo Fascicolo...
					result = creaFascicolo(diogIDAggregatoRoot, nomeNuovoFascicolo, oggettoPratica, false);
				//	result = creaCartella(diogIDAggregatoRoot, nomeNuovoFascicolo);
			}

			if (result == null){
				clearDiogeneFacade();
				throw new DocumentaleException("DiogeneRestClient -  service creaFascicolo return null pointer!!");
			}

			clearDiogeneFacade();
			return result;
		}
		catch (Exception e) {
			if(e instanceof RestException) {
				log.error(((RestException) e).getMessaggio(), e);
			}
			else{
				log.error(e.getMessage(), e);
			}

			clearDiogeneFacade();
			throw new DocumentaleException(e);
		} 
	}

	public String ricercaContenitore(String destPath, String regex) throws DocumentaleException {
		boolean found = false;
		String uuidContenitorePadre = diogIDAggregatoRoot;

		log.info(String.format("ricercaContenitore : [destPath=%s|regex=%s]", destPath, regex));
		String[] elements = destPath.split(regex); 
		if (elements.length == 0){
			clearDiogeneFacade();
			throw new DocumentaleException("Invalid format of destination folder path!");
		}

		try{
			// Elaboro tutte le categorie del path...
			for (int idx=0; idx<elements.length-1; idx++){
				// verifico se è stato già creato un aggregato per questa categoria...
				Aggregato retAggregato = getDiogeneFacade().mostraContenuto(uuidContenitorePadre, true, false);
				if (retAggregato.getAggregati().size()>0){
					int k=0;
					found=false;
					for (;k<retAggregato.getAggregati().size();k++){
						found = retAggregato.getAggregati().get(k).getNomeAggregato().equals(elements[idx]);
						if (found)
							break;
					}

					if (found)
					{
						uuidContenitorePadre = retAggregato.getAggregati().get(k).getIdAggregato();
						log.debug(String.format("Contenitore trovato: nome = %s; uuid = %s", elements[idx], uuidContenitorePadre));
					}
				}
				if (!found)
					break;
			}

			if (!found){
				log.error(String.format("Impossibile trovare il contenitore con uuidPadre = %s e nome = %s", uuidContenitorePadre,destPath));
				uuidContenitorePadre = null;
			}

			clearDiogeneFacade();
			return uuidContenitorePadre;
		}catch (DocumentaleException de) {
			clearDiogeneFacade();
			throw new DocumentaleException(de);
		}catch (Exception e){
			clearDiogeneFacade();
			throw new DocumentaleException(e.getMessage());
		}
		
	}

	public DocInfo uploadFile(DocInfo _fileInfo, String uuidContenitore)
			throws DocumentaleException {

		log.info(String.format("uploadFile : [uuidContenitore=%s] start...", uuidContenitore));

		Documento documento = new Documento();
		documento.setFileName(_fileInfo.getFile().getNome());
		documento.setFileContent(_fileInfo.getFile().getContent().clone());
		documento.setAutore(_fileInfo.getCreator());
		documento.setIdAggregatoContenitore(uuidContenitore);
		documento.setTipoAggregatoContenitore(AGGREGATO_FASCICOLO_REALE);

		if (!DocumentaleUtils.containsIllegals(_fileInfo.getTitolo(), titoloDocumentoInvalidsPattern)){
			documento.setTitolo(_fileInfo.getTitolo());
		} else {
			clearDiogeneFacade();
			throw new DocumentaleException(String.format("Non e' consentito eseguire l'upload di un Documento avente come titolo: %s! Rimuovere i caratteri invalidi.", 
					_fileInfo.getTitolo()));
		}

		documento.setDescrizione(_fileInfo.getNote());
		//Gestione del Tipo di Documento
		// Init al tipo documento generico...
		documento.setTipoDocumento(TipoDocumento.DOCUMENTO.toString());
		if (_fileInfo.getTipologia()!=null){
			if (_fileInfo.getTipologia().equals(TipoDocumento.DOCUMENTO_FIRMATO_DIGITALMENTE.toString()) ||
					_fileInfo.getTipologia().equals(TipoDocumento.DOCUMENTO_WEB.toString()) ||
					_fileInfo.getTipologia().equals(TipoDocumento.EMAIL.toString()) ||
					_fileInfo.getTipologia().equals(TipoDocumento.NOTA.toString()) ||
					_fileInfo.getTipologia().equals(TipoDocumento.POSTA_ELETTRONICA_CERTIFICATA.toString()) ||
					_fileInfo.getTipologia().equals(TipoDocumento.RICEVUTA_PEC.toString()))
				documento.setTipoDocumento(_fileInfo.getTipologia());
		}
		documento.setIdTitolario(diogIdTitolario);
		documento.setIdVoceTitolario(diogIdVoceTitolario);

		try{
			Documento retDocumento = getDiogeneFacade().creaDocumento(documento, true);

			_fileInfo.setUuid(retDocumento.getIdDocumento());
			_fileInfo.getFile().setUuid(retDocumento.getIdDocumento());

			if (retDocumento.getProtocollo()!=null){
				_fileInfo.setProtocollato(true);
				_fileInfo.setDataProtocollo(DateUtils.getData(retDocumento.getProtocollo().getData()));
				_fileInfo.setNumeroProtocollo(retDocumento.getProtocollo().getNumero());
				_fileInfo.setTipoProtocollo(retDocumento.getProtocollo().getTipoProtocollo());
			}
			else
				_fileInfo.setProtocollato(false);

			clearDiogeneFacade();
			return new DocInfo(_fileInfo);
		}catch (DocumentaleException de) {
			clearDiogeneFacade();
			throw new DocumentaleException(de);
		}catch (Exception e){
			clearDiogeneFacade();
			throw new DocumentaleException(e.getMessage());
		}

	}

	// TODO: Rivedere con Beppe... lo devo abilitare???
	public Boolean consenteEliminaFile() {
		return true;
	}
	
	public Boolean consenteEliminaContenitore() {
		return true;
	}

	public void eliminaFile(String uuid) throws DocumentaleException {
		try{
			log.info(String.format("EliminaFile - uuid Documento da eliminare = %s;", uuid));
			getDiogeneFacade().cancellaDocumento(uuid, AGGREGATO_FASCICOLO_REALE);
			clearDiogeneFacade();
		}catch (DocumentaleException de) {
			clearDiogeneFacade();
			throw new DocumentaleException(de);
		}catch (Exception e){
			clearDiogeneFacade();
			throw new DocumentaleException(e.getMessage());
		}
	}
	public void eliminaDirectory(String uuid) throws DocumentaleException {
		try {
			log.info(String.format("EliminaDirectory - uuid Fascicolo da eliminare = %s;", uuid));
			getDiogeneFacade().cancellaFascicolo(uuid);
			clearDiogeneFacade();
		}catch (DocumentaleException de) {
			clearDiogeneFacade();
			throw new DocumentaleException(de);
		}catch (Exception e){
			clearDiogeneFacade();
			throw new DocumentaleException(e.getMessage());
		}
	}

	/**
	 * Versione che esegue la chiamata a Diogene per il LeggiDocumento
	 */
	public DocInfo getMetadatiDocumento(String uuid) throws DocumentaleException {
		try{
			Documento documento = getDiogeneFacade().leggiDocumento(uuid, AGGREGATO_FASCICOLO_REALE);
			return getMetadatiDocumento(documento);
		}catch (DocumentaleException de) {
			clearDiogeneFacade();
			throw new DocumentaleException(de);
		}catch (Exception e){
			clearDiogeneFacade();
			throw new DocumentaleException(e.getMessage());
		}
	}
	
	private String recuperaTipoProtocolloDaNumero(String numProtocollo){
		String retValue = "INGRESSO";
		
		if (numProtocollo != null && numProtocollo.length() > 0 && numProtocollo.charAt(numProtocollo.length()-1)=='I') {
			retValue = "INGRESSO";
		} else if (numProtocollo != null && numProtocollo.length() > 0 && numProtocollo.charAt(numProtocollo.length()-1)=='U') {
			retValue = "USCITA";
		}
		
		return retValue;
	}
	
	public DocInfo getMetadatiDocumento(Documento documento) throws DocumentaleException {
		log.debug(String.format("Documento = {idDocumento:%s, autore:%s, titolo:%s, tipoDocumento:%s, dataCreazione:%s, fileName:%s, mimeType:%s, fileSize:%s}",
				documento.getIdDocumento(), documento.getAutore(), 
				documento.getTitolo(), documento.getTipoDocumento(),
				documento.getDataCreazione(), documento.getFileName(),
				documento.getMimeType(), documento.getFileSize()));

		DocInfo docInfo = new DocInfo();
		docInfo.setCreator(documento.getAutore());
		docInfo.setDataCreazione(DateUtils.getData(documento.getDataCreazione()));
		docInfo.setUuid(documento.getIdDocumento());
		docInfo.setTitolo(documento.getTitolo());
		docInfo.setTipologia(documento.getTipoDocumento());

		if (documento.getProtocollo()!=null){
			log.debug(String.format("getMetadatiDocumento : numProtocollo=%s | tipoProtocollo=%s | Data Protocollo=%s", 
					documento.getProtocollo().getNumero(),
					documento.getProtocollo().getTipoProtocollo(), 
					documento.getProtocollo().getData()));
			docInfo.setProtocollato(true);
			docInfo.setNumeroProtocollo(documento.getProtocollo().getNumero());
			if (documento.getProtocollo().getTipoProtocollo() != null)
				docInfo.setTipoProtocollo(documento.getProtocollo().getTipoProtocollo());
			else
				docInfo.setTipoProtocollo(recuperaTipoProtocolloDaNumero(documento.getProtocollo().getNumero()));
			
			try{
				docInfo.setDataProtocollo(new SimpleDateFormat("dd/MM/yyyy hh:mm").parse(documento.getProtocollo().getData()));
			}catch (Exception exp){
				throw new DocumentaleException(exp);
			}
		}
		else{
			log.error("Dati di Procollazione = NULL !!");
			docInfo.setProtocollato(false);
		}

		DocFile docFile = new DocFile();
		docFile.setUuid(documento.getIdDocumento());
		docFile.setNome(documento.getFileName());
		docFile.setMimeType(documento.getMimeType());
		docFile.setDimensione(String.valueOf(documento.getFileSize()));

		docInfo.setFile(docFile);

		return docInfo;
	}
	
	public ArrayList<DocInfo> documentiContenuti(String uuidContenitore)
			throws DocumentaleException {

		try{
			Aggregato retAggregato = getDiogeneFacade().mostraContenuto(uuidContenitore, false, true);

			ArrayList<DocInfo> result = new ArrayList<DocInfo>();

			for (int idx=0; idx < retAggregato.getDocumenti().size(); idx++){
				Documento retDocumento = retAggregato.getDocumenti().get(idx);
				DocInfo docInfo = null;
				try{
					//				docInfo = getMetadatiDocumento(retDocumento.getIdDocumento());
					docInfo = getMetadatiDocumento(retDocumento);
				}
				catch (Exception exp){
					log.error(String.format("Impossibile recuperare i dati di protocollo per il documento id=%s", retDocumento.getIdDocumento()));

					// Si riportano solo i dati recuperati nella lista di WSInfoDocumento...
					docInfo = new DocInfo();
					docInfo.setCreator(retDocumento.getAutore());
					docInfo.setDataCreazione(DateUtils.getData(retDocumento.getDataCreazione()));
					docInfo.setUuid(retDocumento.getIdDocumento());
					docInfo.setTitolo(retDocumento.getTitolo());

					DocFile docFile = new DocFile();
					docFile.setUuid(retDocumento.getIdDocumento());
					docFile.setNome(retDocumento.getFileName());

					docInfo.setFile(docFile);
				}

				result.add(docInfo);	
			}

			clearDiogeneFacade();
			return result;
		}catch (DocumentaleException de) {
			clearDiogeneFacade();
			throw new DocumentaleException(de);
		}catch (Exception e){
			clearDiogeneFacade();
			throw new DocumentaleException(e.getMessage());
		}
	}

	public DocFile download(String uuidContenitore, String uuidFile) throws DocumentaleException {
		try{
			Documento retDocumento = getDiogeneFacade().downloadDocumento(uuidFile, null, AGGREGATO_FASCICOLO_REALE);

			DocFile result = new DocFile();
			result.setNome(retDocumento.getFileName());
			result.setUuid(retDocumento.getIdDocumento());
			result.setMimeType(retDocumento.getMimeType());
			result.setDimensione(String.valueOf(retDocumento.getFileSize()));
			result.setContent(retDocumento.getFileContent());

			clearDiogeneFacade();
			return result;
		}catch (DocumentaleException de) {
			clearDiogeneFacade();
			throw new DocumentaleException(de);
		}catch (Exception e){
			clearDiogeneFacade();
			throw new DocumentaleException(e.getMessage());
		}
	}

	/**
	 * Versione con la chiamata Sincrona...
	 */
	public void spostaDocumento(String uuidDocumento, String uuidDestContenitore)
			throws DocumentaleException {
		try{
			getDiogeneFacade().spostaDocumento(uuidDocumento, uuidDestContenitore, AGGREGATO_FASCICOLO_REALE, true);
			clearDiogeneFacade();
		}catch (DocumentaleException de) {
			clearDiogeneFacade();
			throw new DocumentaleException(de);
		}catch (Exception e){
			clearDiogeneFacade();
			throw new DocumentaleException(e.getMessage());
		}
	}
	
	/**
	 * Versione con la chiamata Asincrona...
	 */
//	public void spostaDocumento(String uuidDocumento, String uuidDestContenitore)
//			throws DocumentaleException {
//		try{
//			Thread t = new AsyncSpostaDocumento(getDiogeneFacade(), uuidDocumento, uuidDestContenitore, AGGREGATO_FASCICOLO_REALE);
//			t.start();
//		}
//		catch (Exception exp){
//			clearDiogeneFacade();
//			throw new DocumentaleException(e.getMessage());
//		}
//	}
	
	public String ricercaInContenitore(String searchText, boolean searchForFolder, String uuidPadre) 
			throws DocumentaleException {
		try{
			String result = "";

			Aggregato rest_response = getDiogeneFacade().mostraContenuto(uuidPadre, true, true);
			
			boolean found=false;
			if (searchForFolder){
				if (rest_response.getAggregati().size()>0){
					int k=0;
					for (;k<rest_response.getAggregati().size();k++){
						found = rest_response.getAggregati().get(k).getNomeAggregato().equalsIgnoreCase(searchText);
						if (found)
							break;
					}

					if (found)
					{
						result = rest_response.getAggregati().get(k).getIdAggregato();
						log.debug(String.format("Aggregato trovato: nome = %s; uuid = %s", 
								rest_response.getAggregati().get(k).getNomeAggregato(), result));
					}
				}
			}
			else{
				if (rest_response.getDocumenti().size()>0){
					int k=0;
					for (;k<rest_response.getDocumenti().size();k++){
						found = rest_response.getDocumenti().get(k).getFileName().equalsIgnoreCase(searchText);
						if (found)
							break;
					}

					if (found)
					{
						result = rest_response.getDocumenti().get(k).getIdDocumento();
						log.debug(String.format("Documento trovato: nome = %s; uuid = %s", 
								rest_response.getDocumenti().get(k).getFileName(), result));
					}
				}
			}
			if (!found){
				log.debug(String.format("Nessun Elemento trovato in aggregato con uuid=%s utilizzando %s come testo di ricerca!!", 
						uuidPadre, searchText));
				result = null;
			}

			clearDiogeneFacade();
			return result;
		}catch (DocumentaleException de) {
			clearDiogeneFacade();
			throw new DocumentaleException(de);
		}catch (Exception e){
			clearDiogeneFacade();
			throw new DocumentaleException(e.getMessage());
		}
	}
}
