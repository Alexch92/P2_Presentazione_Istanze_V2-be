package it.sincon.gepred.documentale.diogene;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.xml.rpc.ServiceException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.sincon.gepred.documentale.bean.DateUtils;
import it.sincon.gepred.documentale.bean.DocFile;
import it.sincon.gepred.documentale.bean.DocInfo;
import it.sincon.gepred.documentale.bean.DocumentaleContainerNotFoundException;
import it.sincon.gepred.documentale.bean.DocumentaleException;
import it.sincon.gepred.documentale.diogene.domain.SottoAggregati;
import it.sincon.gepred.documentale.diogene.enums.TipoDocumento;
import it.sincon.gepred.documentale.diogene.bean.WS_Aggregato;
import it.sincon.gepred.documentale.diogene.bean.WS_Dettaglio;
import it.sincon.gepred.documentale.diogene.bean.WS_Documento;
import it.sincon.gepred.documentale.diogene.bean.WS_Download;
import it.sincon.gepred.documentale.diogene.bean.WS_FileType;
import it.sincon.gepred.documentale.diogene.bean.WS_InfoDocumento;
import it.sincon.gepred.documentale.diogene.bean.WS_MostraContenuto;
import it.sincon.gepred.documentale.diogene.bean.WS_NumerazioneFascicolo;
import it.sincon.gepred.documentale.diogene.bean.WS_NuovaCartella;
import it.sincon.gepred.documentale.diogene.bean.WS_NuovoDocumento;
import it.sincon.gepred.documentale.diogene.bean.WS_NuovoFascicolo;
import it.sincon.gepred.documentale.diogene.bean.WS_Protocollo;
import it.sincon.gepred.documentale.diogene.bean.WS_RicercaResult;
import it.sincon.gepred.documentale.diogene.bean.WS_RicercaType;
import it.sincon.gepred.documentale.diogene.impl.Diogene;
import it.sincon.gepred.documentale.diogene.impl.DiogeneServiceLocator;
import it.sincon.gepred.documentale.diogene.persistence.SottoAggregatiRepository;
import it.sincon.gepred.documentale.service.DocumentaleService;

public class DocumentaleServiceDiogeneImpl implements DocumentaleService {
	private static Logger log = LoggerFactory.getLogger(DocumentaleServiceDiogeneImpl.class);

	private static String TIPOOGGETTO_DOCUMENTO = "D";

	//#SA# Il tipo conenitore dovrebbe essere Fascicolo_Reale (R). in test usiamo Cartella (C).
	private static String AGGREGATO_CARTELLA = "C";
	private static String AGGREGATO_FASCICOLO_REALE = "R";

	private Diogene port;

	private String username;
	private String password;

	private String diogIDAggregatoRoot;
	private String diogWebServiceUri;
	private String diogIdTitolario;
	private String diogIdVoceTitolario;
	private int diogLimiteSottoAggregati;

	@Inject
	private SottoAggregatiRepository sottoAggregatiRepository;

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
	public void setUsername(String _username) {
		this.username = _username;
	}
	public void setPassword(String _password) {
		this.password = _password;
	}
	public void setDiogWebServiceUri(String _diogWebServiceUri) {
		this.diogWebServiceUri = _diogWebServiceUri;
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

	@PostConstruct
	public void initializeProperties()
	{
		try {
			port = new DiogeneServiceLocator().getDiogene(new URL(diogWebServiceUri));

		} catch (ServiceException exp) {
			log.error(exp.getMessage(), exp);
		} catch (MalformedURLException exp) {
			log.error(exp.getMessage(), exp);
		}
	}

	private String creaCartella(String idAggregatoPadre, String nomeCartella) throws RemoteException{
		WS_NuovaCartella nuovaCartella = new WS_NuovaCartella();
		nuovaCartella.setIdPadre(idAggregatoPadre);
		nuovaCartella.setNomeAggregato(nomeCartella);

		log.info("Chiamata al servizio Diogene 'nuovaCartella'...");
		WS_Dettaglio ws_response = port.nuovaCartella(username, nuovaCartella);
		String  uuidContenitoreCreato = ws_response.getCartella().getIdAggregato();
		log.info(String.format("Nuova cartella creato con uuid = %s", uuidContenitoreCreato));

		return uuidContenitoreCreato;
	}

	private String creaFascicolo(String uuidContenitorePadre, String nomeFascicolo, String oggettoPratica, boolean gestisciLimiteSottoAggregati) throws RemoteException{
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

		WS_NuovoFascicolo nuovoFascicolo = new WS_NuovoFascicolo();
		nuovoFascicolo.setIdPadre(uuidFascicolo);
		nuovoFascicolo.setNomeAggregato(nomeFascicolo);
		nuovoFascicolo.setIdTitolario(diogIdTitolario);
		nuovoFascicolo.setIdVoceTitolario(diogIdVoceTitolario);
		nuovoFascicolo.setOggetto(oggettoPratica);

		WS_NumerazioneFascicolo numeroFascicolo  = new WS_NumerazioneFascicolo();
		numeroFascicolo.setTipologiaNumerazione(1);
		nuovoFascicolo.setNumerazione(numeroFascicolo);

		log.info("Chiamata al servizio Diogene 'nuovoFascicolo'...");
		WS_Dettaglio ws_response = port.nuovoFascicolo(username, nuovoFascicolo);
		String uuidContenitoreCreato = ws_response.getFascicolo().getIdAggregato();
		log.info(String.format("Nuovo fascicolo creato con uuid = %s", uuidContenitoreCreato));

		return uuidContenitoreCreato;
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
		log.info(String.format("diogIDAggregatoRoot = %s; destPath = %s; regex=%s", diogIDAggregatoRoot, destPath,regex));

		try{
			String[] elements = destPath.split(regex); 
			if (elements.length == 0)
				throw new DocumentaleException("Invalid format of destination folder path!");

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
//					result = creaCartella(diogIDAggregatoRoot, nomeNuovoFascicolo);
			}

			return result;
		}
		catch (Exception exp){
			log.error(exp.getMessage(), exp);
			throw new DocumentaleException(exp);
		}
	}
	private String creaContenitoreFascicolo(String uuidContenitoreRoot, String[] elements) throws RemoteException {
		String uuidContenitoreResult = uuidContenitoreRoot;
		// Elaboro tutte le categorie del path...
		boolean found = false;
		for (int idx=0; idx<elements.length-1; idx++){
			// verifico se è stato già creato un aggregato per questa categoria...
			log.info("Chiamata al servizio Diogene 'mostraContenuto'...");
			WS_MostraContenuto ws_search_response = port.mostraContenuto(username, uuidContenitoreResult);
			log.info(String.format("Risposta dal servizio Diogene 'mostraContenuto': rilevati %s Aggregati figli", ws_search_response.getElencoAggregati().length));
			if (ws_search_response.getElencoAggregati().length>0){
				int k=0;
				found=false;
				for (;k<ws_search_response.getElencoAggregati().length;k++){
					found = ws_search_response.getElencoAggregati()[k].getNomeAggregato().equals(elements[idx]);
					if (found)
						break;
				}

				if (found)
				{
					uuidContenitoreResult = ws_search_response.getElencoAggregati()[k].getIdAggregato();
					log.debug(String.format("Contenitore trovato: nome = %s; uuid = %s", elements[idx], uuidContenitoreResult));
				}
			}
			if (!found)					
				uuidContenitoreResult = creaCartella(uuidContenitoreResult, elements[idx]);
		}
		return uuidContenitoreResult;
	}

	public String ricercaContenitore(String destPath, String regex) throws DocumentaleException {
		boolean found = false;
		String uuidContenitorePadre = diogIDAggregatoRoot;
		
		try{
			log.info(String.format("ricercaContenitore : [destPath=%s|regex=%s]", destPath, regex));
			String[] elements = destPath.split(regex); 
			if (elements.length == 0)
				throw new DocumentaleException("Invalid format of destination folder path!");

			// Elaboro tutte le categorie del path...
			for (int idx=0; idx<elements.length-1; idx++){
				// verifico se è stato già creato un aggregato per questa categoria...
				log.info("Chiamata al servizio Diogene 'mostraContenuto'...");
				WS_MostraContenuto ws_search_response = port.mostraContenuto(username, uuidContenitorePadre);
				log.info(String.format("Risposta dal servizio Diogene 'mostraContenuto': rilevati %s Aggregati figli", ws_search_response.getElencoAggregati().length));
				if (ws_search_response.getElencoAggregati().length>0){
					int k=0;
					found=false;
					for (;k<ws_search_response.getElencoAggregati().length;k++){
						found = ws_search_response.getElencoAggregati()[k].getNomeAggregato().equals(elements[idx]);
						if (found)
							break;
					}

					if (found)
					{
						uuidContenitorePadre = ws_search_response.getElencoAggregati()[k].getIdAggregato();
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

			return uuidContenitorePadre;
		}
		catch (Exception exp){
			log.error(exp.getMessage(), exp);
			throw new DocumentaleException(exp);
		}
	}

	public DocInfo uploadFile(DocInfo _fileInfo, String uuidContenitore)
			throws DocumentaleException {
		try{
			WS_FileType wsFile = new WS_FileType();
			wsFile.setFileName(_fileInfo.getFile().getNome());
			wsFile.setFileContent(_fileInfo.getFile().getContent().clone());
			wsFile.setAutore(_fileInfo.getCreator());
			wsFile.setIdAggregatoContenitore(uuidContenitore);
			wsFile.setTitolo(_fileInfo.getTitolo());

			WS_NuovoDocumento wsDocumento = new WS_NuovoDocumento();
			wsDocumento.setFile(wsFile);
			wsDocumento.setTitolo(_fileInfo.getTitolo());
			wsDocumento.setIdAggregatoContenitore(uuidContenitore);
			wsDocumento.setDescrizione(_fileInfo.getNote());

			//Gestione del Tipo di Documento
			// Init al tipo documento generico...
			wsDocumento.setTipoDocumento(TipoDocumento.DOCUMENTO.toString());
			if (_fileInfo.getTipologia()!=null){
				if (_fileInfo.getTipologia().equals(TipoDocumento.DOCUMENTO_FIRMATO_DIGITALMENTE.toString()) ||
						_fileInfo.getTipologia().equals(TipoDocumento.DOCUMENTO_WEB.toString()) ||
						_fileInfo.getTipologia().equals(TipoDocumento.EMAIL.toString()) ||
						_fileInfo.getTipologia().equals(TipoDocumento.NOTA.toString()) ||
						_fileInfo.getTipologia().equals(TipoDocumento.POSTA_ELETTRONICA_CERTIFICATA.toString()) ||
						_fileInfo.getTipologia().equals(TipoDocumento.RICEVUTA_PEC.toString()))
					wsDocumento.setTipoDocumento(_fileInfo.getTipologia());
			}

			log.info("WS Diogene - chiamata al servizio nuovoDocumento...");
			WS_Dettaglio ws_response = port.nuovoDocumento(username, AGGREGATO_FASCICOLO_REALE, wsDocumento);

			if (ws_response.getCodice()!=0){
				log.error(String.format("WS Diogene - risposta del servizio nuovoDocumento : Error code:%s Error Msg:%s", 
						ws_response.getCodice(), ws_response.getMessaggio()));

				throw new DocumentaleException(ws_response.getMessaggio());
			}
			else{
				log.info(String.format("WS Diogene - risposta del servizio nuovoDocumento : cod=%s | Msg=%s", ws_response.getCodice(), ws_response.getMessaggio()));
				_fileInfo.setUuid(ws_response.getDocumento().getIdDocumento());
				_fileInfo.getFile().setUuid(ws_response.getDocumento().getIdDocumento());

				if (ws_response.getDocumento().getProtocollo()!=null){
					_fileInfo.setProtocollato(true);
					_fileInfo.setDataProtocollo(DateUtils.getData(ws_response.getDocumento().getProtocollo().getData()));
					_fileInfo.setNumeroProtocollo(ws_response.getDocumento().getProtocollo().getNumero());
					_fileInfo.setTipoProtocollo(ws_response.getDocumento().getProtocollo().getTipoProtocollo());
				}
				else
					_fileInfo.setProtocollato(false);

				return new DocInfo(_fileInfo);
			}
		}
		catch (Exception exp){
			log.error(exp.getMessage(), exp);
			throw new DocumentaleException(exp);
		}
	}

	public Boolean consenteEliminaFile() {
		return false;
	}

	public void eliminaFile(String uuid) throws DocumentaleException {
		throw new DocumentaleException("Diogene WS non consente di eliminare un documento via web service!");
	}
	
	public void eliminaDirectory(String uuid) throws DocumentaleException {
		throw new DocumentaleException("Diogene WS non consente di eliminare un contenitore via web service!");
	}

	public DocInfo getMetadatiDocumento(String uuid) throws DocumentaleException {
		try{
			log.info("WS Diogene - chiamata al servizio leggiDettaglio...");
			WS_Dettaglio ws_response = port.leggiDettaglio(username, uuid, TIPOOGGETTO_DOCUMENTO, AGGREGATO_FASCICOLO_REALE);

			if (ws_response.getCodice()!=0){
				log.error(String.format("WS Diogene - risposta del servizio leggiDettaglio : Error code:%s Error Msg:%s", 
						ws_response.getCodice(), ws_response.getMessaggio()));
				throw new DocumentaleException(ws_response.getMessaggio());
			}
			else{
				log.debug(String.format("WS Diogene - risposta del servizio leggiDettaglio : cod=%s | Msg=%s", 
						ws_response.getCodice(), ws_response.getMessaggio()));

				WS_Documento ws_doc = ws_response.getDocumento();

				log.debug(String.format("WS Diogene - leggiDettaglio : uuid=%s", ws_doc.getIdDocumento()));

				DocInfo docInfo = new DocInfo();
				docInfo.setCreator(ws_doc.getAutore());
				docInfo.setDataCreazione(DateUtils.getData(ws_doc.getDataCreazione()));
				docInfo.setUuid(ws_doc.getIdDocumento());
				docInfo.setTitolo(ws_doc.getTitolo());
				docInfo.setTipologia(ws_doc.getTipoDocumento());

				if (ws_doc.getProtocollo()!=null){
					log.debug(String.format("WS Diogene - leggiDettaglio : numProtocollo=%s | tipoProtocollo=%s | Data Protocollo=%s", 
							ws_doc.getProtocollo().getNumero(),
							ws_doc.getProtocollo().getTipoProtocollo(), 
							ws_doc.getProtocollo().getData()));
					docInfo.setProtocollato(true);
					docInfo.setTipoProtocollo(ws_doc.getProtocollo().getTipoProtocollo());
					docInfo.setNumeroProtocollo(ws_doc.getProtocollo().getNumero());
					docInfo.setDataProtocollo(new SimpleDateFormat("dd/MM/yyyy hh:mm").parse(ws_doc.getProtocollo().getData()));
				}
				else{
					log.error("Dati di Procollazione = NULL !!");
					docInfo.setProtocollato(false);
				}


				DocFile docFile = new DocFile();
				docFile.setUuid(ws_doc.getIdDocumento());
				docFile.setNome(ws_doc.getFileName());
				docFile.setMimeType(ws_doc.getMimeType());
				docFile.setDimensione(ws_doc.getFileSize());

				docInfo.setFile(docFile);

				return docInfo;
			}
		}
		catch (Exception exp){
			log.error(exp.getMessage(), exp);
			throw new DocumentaleException(exp);
		}
	}

	public ArrayList<DocInfo> documentiContenuti(String uuidContenitore)
			throws DocumentaleException {

		try{
			log.info(String.format("WS Diogene - chiamata al servizio mostraContenuto...uuidContenitore:%s", uuidContenitore));
			WS_MostraContenuto ws_response = port.mostraContenuto(username, uuidContenitore);

			if (ws_response.getCodice()!=0){
				log.error(String.format("WS Diogene - risposta del servizio mostraContenuto : Error code:%s Error Msg:%s", 
						ws_response.getCodice(), ws_response.getMessaggio()));
				throw new DocumentaleException(ws_response.getMessaggio());
			}
			else{
				log.info(String.format("WS Diogene - risposta del servizio mostraContenuto : cod=%s | Msg=%s | doc recuperati=%s", 
						ws_response.getCodice(), ws_response.getMessaggio(), ws_response.getElencoDocumenti().length));

				ArrayList<DocInfo> result = new ArrayList<DocInfo>();


				for (int idx=0; idx < ws_response.getElencoDocumenti().length; idx++){
					WS_InfoDocumento ws_docInfo = ws_response.getElencoDocumenti()[idx];
					DocInfo docInfo = null;
					try{
						docInfo = getMetadatiDocumento(ws_docInfo.getIdDocumento());
					}
					catch (Exception exp){
						log.error(String.format("WS Diogene - Impossibile recuperare i dati di protocollo per il documento id=%s", ws_docInfo.getIdDocumento()));

						// Si riportano solo i dati recuperati nella lista di WSInfoDocumento...
						docInfo = new DocInfo();
						docInfo.setCreator(ws_docInfo.getAutore());
						docInfo.setDataCreazione(DateUtils.getData(ws_docInfo.getDataCreazione()));
						docInfo.setUuid(ws_docInfo.getIdDocumento());
						docInfo.setTitolo(ws_docInfo.getTitolo());
						
						DocFile docFile = new DocFile();
						docFile.setUuid(ws_docInfo.getIdDocumento());
						docFile.setNome(ws_docInfo.getFileName());
						
						docInfo.setFile(docFile);
					}

					result.add(docInfo);	
				}

				return result;
			}
		}
		catch (Exception exp){
			log.error(exp.getMessage(), exp);
			throw new DocumentaleException(exp);
		}
	}

	public DocFile download(String uuidContenitore, String uuidFile) throws DocumentaleException {
		try{
			log.info(String.format("WS Diogene -  download file con id=%s, id aggregato contenitore = %s",uuidFile, uuidContenitore));
			WS_Download ws_response = port.download(username, uuidFile, null);
			if (ws_response.getCodice()!=0){
				log.error(String.format("WS Diogene - risposta del servizio download : Error code:%s Error Msg:%s", 
						ws_response.getCodice(), ws_response.getMessaggio()));
				throw new DocumentaleException(ws_response.getMessaggio());
			}
			else{
				log.info(String.format("WS Diogene - risposta del servizio download : cod=%s | Msg=%s", 
						ws_response.getCodice(), ws_response.getMessaggio()));

				DocFile result = new DocFile();
				result.setNome(ws_response.getFile().getFileName());
				result.setUuid(ws_response.getFile().getIdDocumento());
				result.setDimensione(ws_response.getFile().getFileSize());
				result.setMimeType(ws_response.getFile().getMimeType());

				result.setContent(ws_response.getFile().getFileContent());

				return result;
			}
		}
		catch (Exception exp){
			log.error(exp.getMessage(), exp);
			throw new DocumentaleException(exp);
		}
	}

	public void spostaDocumento(String uuidDocumento, String uuidDestContenitore)
			throws DocumentaleException {
		try{
			log.info(String.format("WS Diogene - servizio spostaDocumento... uuidDocumento=%s, uuidDestContenitore=%s, TIPO_CONTENITORE=%s",uuidDocumento, uuidDestContenitore, AGGREGATO_FASCICOLO_REALE));
			WS_Dettaglio ws_response = port.spostaDocumento(username, uuidDocumento, AGGREGATO_FASCICOLO_REALE, uuidDestContenitore);

			if (ws_response.getCodice()!=0){
				log.error(String.format("WS Diogene - risposta del servizio spostaDocumento : Error code:%s Error Msg:%s", 
						ws_response.getCodice(), ws_response.getMessaggio()));
				throw new DocumentaleException(ws_response.getMessaggio());
			}
			else{
				log.info(String.format("WS Diogene - risposta del servizio spostaDocumento : cod=%s | Msg=%s", 
						ws_response.getCodice(), ws_response.getMessaggio()));
			}
		}
		catch (Exception exp){
			log.error(exp.getMessage(), exp);
			throw new DocumentaleException(exp);
		}
	}

	public String ricercaInContenitore(String searchText, boolean searchForFolder, String uuidPadre) 
			throws DocumentaleException {
		try{
			String result = "";

			log.info("Chiamata al servizio Diogene 'mostraContenuto'...");
			WS_MostraContenuto ws_search_response = port.mostraContenuto(username, uuidPadre);
			log.info(String.format("Risposta dal servizio Diogene 'mostraContenuto': rilevati %s Aggregati figli", ws_search_response.getElencoAggregati().length));
			boolean found=false;

			if (searchForFolder){
				if (ws_search_response.getElencoAggregati().length>0){
					int k=0;
					for (;k<ws_search_response.getElencoAggregati().length;k++){
						found = ws_search_response.getElencoAggregati()[k].getNomeAggregato().equalsIgnoreCase(searchText);
						if (found)
							break;
					}

					if (found)
					{
						result = ws_search_response.getElencoAggregati()[k].getIdAggregato();
						log.debug(String.format("Aggregato trovato: nome = %s; uuid = %s", 
								ws_search_response.getElencoAggregati()[k].getNomeAggregato(), result));
					}
				}
			}
			else{
				if (ws_search_response.getElencoDocumenti().length>0){
					int k=0;
					for (;k<ws_search_response.getElencoDocumenti().length;k++){
						found = ws_search_response.getElencoDocumenti()[k].getFileName().equalsIgnoreCase(searchText);
						if (found)
							break;
					}

					if (found)
					{
						result = ws_search_response.getElencoDocumenti()[k].getIdDocumento();
						log.debug(String.format("Documento trovato: nome = %s; uuid = %s", 
								ws_search_response.getElencoDocumenti()[k].getFileName(), result));
					}
				}
			}
			if (!found){
				log.debug(String.format("Nessun Elemento trovato in aggregato con uuid=%s utilizzando %s come testo di ricerca!!", 
						uuidPadre, searchText));
				result = null;
			}

			return result;
		}
		catch (Exception exp){
			log.error(exp.getMessage(), exp);
			throw new DocumentaleException(exp);
		}
	}
}
