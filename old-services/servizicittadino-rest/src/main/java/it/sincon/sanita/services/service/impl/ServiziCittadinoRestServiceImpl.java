package it.sincon.sanita.services.service.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;

import org.apache.axis.encoding.Base64;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;

import it.puglia.sanita.cup.Appuntamento;
import it.puglia.sanita.cup.Ente;
import it.puglia.sanita.cup.Errore;
import it.puglia.sanita.cup.Operatore;
import it.puglia.sanita.cup.Paziente;
import it.puglia.sanita.cup.Prescrizione;
import it.puglia.sanita.cup.Prestazione;
import it.puglia.sanita.cup.RichiestaCancella;
import it.puglia.sanita.cup.RichiestaPrescrizioni;
import it.puglia.sanita.cup.RichiestaPromemoria;
import it.puglia.sanita.cup.RispostaCancella;
import it.puglia.sanita.cup.RispostaPrescrizioni;
import it.puglia.sanita.cup.RispostaPromemoria;
import it.puglia.sanita.cup.Servizi;
import it.puglia.sanita.cup.WssgpLocator;
import it.sincon.sanita.services.ServiziCittadinoRestServiceException;
import it.sincon.sanita.services.beans.CfgEnte;
import it.sincon.sanita.services.beans.CfgTipoPrestazione;
import it.sincon.sanita.services.beans.DisdettaResponseJAXB;
import it.sincon.sanita.services.beans.ListaEntiPagamentoTicketResponseJAXB;
import it.sincon.sanita.services.beans.PagamentoTicketEnteJAXB;
import it.sincon.sanita.services.beans.WsCupErrorEnum;
import it.sincon.sanita.services.beans.WsCupStatoAppuntamentoEnum;
import it.sincon.sanita.services.service.ServiziCittadinoRestService;
import it.sincon.sanita.utils.ConverterToPdf;
import it.sincon.sanita.utils.DateUtils;
import it.sincon.sanita.utils.StreamUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Service("serviziCittadinoRestService")
public class ServiziCittadinoRestServiceImpl implements
		ServiziCittadinoRestService {
	
	private final static String MSG_SERVIZIO_NON_DISPONIBILE = "Servizio momentaneamente non disponibile.";
	private final static String MSG_PARAM_INVALID_IDENTE = "Valore del parametro IdEnte non valido.";
	private final static String TMPLT_ERRORE_DISDETTA = "errore.rtf";
	private final static String TMPLT_PROMEMORIA_DISDETTA = "promemoria.rtf";
	private final static String MSG_DISDETTA_NON_ESEGUIBILE = "Attenzione! La prenotazione nr."
			+ " %s del cittadino CF=%s risulta essere CANCELLATA. Non è possibile eseguire la Disdetta.";
	
	private final ResourceBundle resourceBundle = ResourceBundle.getBundle("servlet");
	private static Logger log = LoggerFactory.getLogger( ServiziCittadinoRestServiceImpl.class );
	
	private Map<Integer, CfgTipoPrestazione> mapTipiPrestazione;
	private Map<String, CfgEnte> mapEnti;
	
	private String wsdlLocationPath;
	private String wsdlFileName;
	
	private String openOfficeHost;
	private int openOfficePort;
	
	private String promemoriaTempFolder;
	
	public ServiziCittadinoRestServiceImpl(){
		promemoriaTempFolder = resourceBundle.getString("pdf_temp_folder");
		wsdlLocationPath = resourceBundle.getString("wsdl.location");
		wsdlFileName = resourceBundle.getString("wsdl.fileName");
		
		// Carico da config file la mappa dei Tipi di Prestazione...
		this.mapTipiPrestazione = new HashMap<Integer, CfgTipoPrestazione>();
		int cfgMapTipoPrestazioneSize = Integer.parseInt(resourceBundle.getString("map_tipo_prestazione.count"));
		for (int idx=0; idx < cfgMapTipoPrestazioneSize; idx++){
			this.mapTipiPrestazione.put(
					Integer.parseInt(resourceBundle.getString(String.format("map_tipo_prestazione[%s].key", idx))), 
					new CfgTipoPrestazione(
							resourceBundle.getString(String.format("map_tipo_prestazione[%s].value.titolo", idx)),
							resourceBundle.getString(String.format("map_tipo_prestazione[%s].value.tipoErogazione", idx)),
							resourceBundle.getString(String.format("map_tipo_prestazione[%s].value.tipoPrescrizione", idx)))
					);
		}
		
		// Carico da config file la mappa dei Tipi di Prestazione...
		this.mapEnti = new HashMap<String, CfgEnte>();
		int cfgMapEntiSize = Integer.parseInt(resourceBundle.getString("map_enti.count"));
		
		openOfficeHost = resourceBundle.getString("openOffice.host");
		openOfficePort = Integer.parseInt(resourceBundle.getString("openOffice.port"));
		
		for (int idx=0; idx < cfgMapEntiSize; idx++){
			String idEnte = resourceBundle.getString(String.format("map_enti[%s].value.idEnte", idx));
			CfgEnte ente = null;
			// Solo per ASL Lecce il codice Unico di Prenotazione si calcola cosi...
			if (idEnte.equals("LECCE1")){
				ente = new CfgEnte(){
					@Override
					public String getCodiceUnicoPrenotazione(String anno, String numPrenotazione){
						int zeriToBeAdded = 12 - anno.length() - numPrenotazione.length();
						String zeri = "";
						if (zeriToBeAdded > 0){
							for (int idx = 0; idx < zeriToBeAdded; idx++){
								zeri += "0";
							}
						}
						
						return anno + zeri + numPrenotazione;
					}
				};
			}else
				ente = new CfgEnte();
			
			ente.setIdEnte(idEnte);
			ente.setNome(resourceBundle.getString(String.format("map_enti[%s].value.nome", idx)));
			ente.setOperatoreUsername(resourceBundle.getString(String.format("map_enti[%s].value.ope.username", idx)));
			ente.setOperatorePassword(resourceBundle.getString(String.format("map_enti[%s].value.ope.password", idx)));
			ente.setWsEndpointURL(resourceBundle.getString(String.format("map_enti[%s].value.endpoint", idx)));
			ente.setCodice(resourceBundle.getString(String.format("map_enti[%s].value.codice", idx)));
			ente.setPagamentoTicketURL(resourceBundle.getString(String.format("map_enti[%s].value.pagamentoTicketURL", idx)));
			ente.setFormatoDataAppuntamento(resourceBundle.getString(String.format("map_enti[%s].value.formatoDataAppuntamento", idx)));
			ente.setFormatoDataDisdetta(resourceBundle.getString(String.format("map_enti[%s].value.formatoDataDisdetta", idx)));
			
			this.mapEnti.put(resourceBundle.getString(String.format("map_enti[%s].key", idx)), ente);
		}
	}
	
	@Override
	public ListaEntiPagamentoTicketResponseJAXB getListaEntiPagamentoTicket(
			Locale locale) {
		ListaEntiPagamentoTicketResponseJAXB response = null;
		
		List<PagamentoTicketEnteJAXB> data = new ArrayList<PagamentoTicketEnteJAXB>();
		for (CfgEnte ente : mapEnti.values()){
			PagamentoTicketEnteJAXB ptEnte = new PagamentoTicketEnteJAXB(ente.getIdEnte(),
																		 ente.getNome(), 
																		 ente.getPagamentoTicketURL());
			data.add(ptEnte);
		}
		
		response = new ListaEntiPagamentoTicketResponseJAXB(mapEnti.size(), 0, data);
		
		return response;
	}

	@Override
	public DisdettaResponseJAXB disdiciPrenotazione(
			String idEnte, 
			String codFiscale, 
			String codPrenotazione, 
			int keyTipoPrenotazione,
			Locale locale,
			String baseURL)  {
		
		DisdettaResponseJAXB disdettaResponse = null;
		Servizi wsService = null;
		Prescrizione prescrDaDisdire = new Prescrizione();
		
		// Recupero la classe ws.cup.Servizi sulla base dell'ente in cui eseguire la disdetta...
		CfgEnte ente = mapEnti.get(idEnte);
		
		try{
			if (ente == null){
				throw new ServiziCittadinoRestServiceException(MSG_PARAM_INVALID_IDENTE);
			}
			wsService = findServizioByEnte(ente);
			disdettaResponse = new DisdettaResponseJAXB(WsCupErrorEnum.OK.getValue(), null, "");
		}catch (ServiziCittadinoRestServiceException scrse){
			log.error(scrse.getMessage(), scrse);
			disdettaResponse = new DisdettaResponseJAXB(WsCupErrorEnum.GENERIC_ERROR.getValue(), scrse.getMessage(), "");
		}
		
		// Recupero la Prescrizione da disdire...
		if (disdettaResponse.Stato.equals(WsCupErrorEnum.OK.getValue())){
			disdettaResponse = getPrescrizione(
					wsService, 
					ente, 
					codFiscale, 
					codPrenotazione, 
					mapTipiPrestazione.get(keyTipoPrenotazione).getTipoErogazione(),
					prescrDaDisdire);
		}
		
		// Eseguo la disdetta...
		if (disdettaResponse.Stato.equals(WsCupErrorEnum.OK.getValue())){
			disdettaResponse = eseguiDisdetta(wsService, ente, codPrenotazione, codFiscale, keyTipoPrenotazione, prescrDaDisdire, baseURL);
		}
		
		// Genero la URL per il download del promemoria....
		if (disdettaResponse.Stato.equals(WsCupErrorEnum.OK.getValue())){
//			disdettaResponse = scaricaPromemoria(wsService, ente, codPrenotazione, prescrDaDisdire, baseURL);
			disdettaResponse = getPromemoriaURL(idEnte, codFiscale, codPrenotazione, keyTipoPrenotazione, baseURL);
		}
		
		return disdettaResponse;
	}
	
	@Override
	public byte[] generaPromemoriaDisdetta(
			String idEnte, String codFiscale,
			String codPrenotazione, 
			int keyTipoPrenotazione,
			String baseURL) {
		byte[] response = null;
		
		DisdettaResponseJAXB disdettaResponse = null;
		Servizi wsService = null;
		Prescrizione prescrDisdettata = new Prescrizione();
		
		CfgEnte ente = mapEnti.get(idEnte);
		CfgTipoPrestazione tipoPrestazione = mapTipiPrestazione.get(keyTipoPrenotazione);
		
		try{
			if (ente == null){
				throw new ServiziCittadinoRestServiceException(MSG_PARAM_INVALID_IDENTE);
			}
			wsService = findServizioByEnte(ente);
			disdettaResponse = new DisdettaResponseJAXB(WsCupErrorEnum.OK.getValue(), null, "");
		}catch (ServiziCittadinoRestServiceException scrse){
			log.error(scrse.getMessage(), scrse);
			disdettaResponse = new DisdettaResponseJAXB(WsCupErrorEnum.GENERIC_ERROR.getValue(), scrse.getMessage(), "");
		}
		
		// Recupero la Prescrizione da disdire...
		if (disdettaResponse.Stato.equals(WsCupErrorEnum.OK.getValue())){
			disdettaResponse = getPrescrizione(
					wsService, 
					ente, 
					codFiscale, 
					codPrenotazione, 
					tipoPrestazione.getTipoErogazione(),
					prescrDisdettata);
		}
		
		HashMap<String, Object> mapVelocity = new HashMap<String, Object>();
		String templateFileName = "";
		
		// Genero il promemoria...
		if (disdettaResponse.Stato.equals(WsCupErrorEnum.OK.getValue())){
			
			// Recupero il modello del promemoria
			templateFileName = TMPLT_PROMEMORIA_DISDETTA;
			
			// Dettagli prescrizione
			mapVelocity.put("numPrescrizione", ((prescrDisdettata.getIdPrescrizione() == null) ? "" : prescrDisdettata.getIdPrescrizione()));
			mapVelocity.put("numImpegnativa", ((prescrDisdettata.getNumeroImpegnativa() == null) ? "" : prescrDisdettata.getNumeroImpegnativa()));
			mapVelocity.put("tipoPrescrizione", ((tipoPrestazione.getTitolo() == null) ? "" : tipoPrestazione.getTitolo()));
			mapVelocity.put("classePriorita", ((prescrDisdettata.getClassePriorita() == null) ? "Nessuna Priorita'" : prescrDisdettata.getClassePriorita()));
			mapVelocity.put("costoPrescrizione", ((prescrDisdettata.getCostoPrescrizione() == null) ? "" : prescrDisdettata.getCostoPrescrizione()));
			mapVelocity.put("codiceEsenzione", ((prescrDisdettata.getCodiceEsenzione() == null) ? "" : prescrDisdettata.getCodiceEsenzione()));
			mapVelocity.put("dataImpegnativa", ((prescrDisdettata.getDataImpegnativa() == null) ? "" : DateUtils.changeFormat(prescrDisdettata.getDataImpegnativa(), ente.getFormatoDataDisdetta(), "dd/MM/yyyy")));
			
			
			//TODO:Rimuovere qui
//			log.info(String.format("Data Impegnativa:%s",prescrDisdettata.getDataImpegnativa()));
			//TODO:Rimuovere qui
			
			// Prendo la lista degli appuntamenti
			Appuntamento[] listaAppuntamenti = prescrDisdettata.getListaAppuntamenti();
			
			// Creo la lista in cui inserire la mappa dei dati di ogni appuntamento
			ArrayList<HashMap<String, Object>> listaMapAppuntamenti = new ArrayList<HashMap<String, Object>>();
			
			// Scorro gli appuntamenti	
			String dataDisdetta = "";
			for(int i = 0; i < listaAppuntamenti.length; i++){
				Appuntamento app = listaAppuntamenti[i];
				// Prendo la lista delle prestazioni e l'elemento 0
				Prestazione[] listaPrestazioni = app.getListaPrestazioni();
				Prestazione prestazione = listaPrestazioni[0];
				
				//TODO:Rimuovere qui
//				log.info(String.format("Data Appuntamento:%s",app.getDataAppuntamento()));
//				log.info(String.format("Data getDataModificaStatoPre:%s",prestazione.getDataModificaStatoPre()));
//				log.info(String.format("app.getDataModificaStato():%s",app.getDataModificaStato()));
				//TODO:Rimuovere qui
				
				HashMap<String, Object> curMapAppuntamento = new HashMap<String, Object>(); 
				// Inserisco nella mappa i valori dell'appuntamento utili
				curMapAppuntamento.put("data", ((app.getDataAppuntamento() == null) ? "" : DateUtils.changeFormat(app.getDataAppuntamento(), ente.getFormatoDataAppuntamento(), "dd/MM/yyyy")));
				curMapAppuntamento.put("ora", ((app.getOraAppuntamento() == null) ? "" : app.getOraAppuntamento()));
				curMapAppuntamento.put("sede", ((app.getSede().getDescSede() == null) ? "" : app.getSede().getDescSede()));
				curMapAppuntamento.put("unita", ((app.getUnita().getDescUnita() == null) ? "" : app.getUnita().getDescUnita()));
				
				// Prendo i dati comuni alle prestazioni: data e id
				dataDisdetta = "";
				if (prestazione.getDataModificaStatoPre()!=null)
					 dataDisdetta = DateUtils.changeFormat(prestazione.getDataModificaStatoPre(), ente.getFormatoDataDisdetta(), "dd/MM/yyyy HH:mm");
				else if (app.getDataModificaStato()!=null)
					dataDisdetta = DateUtils.changeFormat(app.getDataModificaStato(), ente.getFormatoDataDisdetta(), "dd/MM/yyyy HH:mm");
				
				curMapAppuntamento.put("dataModifica", dataDisdetta);
				curMapAppuntamento.put("idDisdetta", ((prestazione.getIdDisdettaPre() == null) ? "" : prestazione.getIdDisdettaPre()));
				
				// Creo la lista in cui inserire la mappa dei dati di ogni prestazione
				ArrayList<HashMap<String, Object>> listaMapPrestazioni = new ArrayList<HashMap<String, Object>>();				
				
				// Scorro le prestazioni
				for(int j = 0; j < listaPrestazioni.length; j++){
					Prestazione curPrestazione = listaPrestazioni[j];
					HashMap<String, Object> curMapPrestazione = new HashMap<String, Object>();
					// Inserisco nella mappa i valori della prestazione utili
					curMapPrestazione.put("codice", ((curPrestazione.getCodicePrestazione() == null) ? "" : curPrestazione.getCodicePrestazione()));
					curMapPrestazione.put("descrizione", ((curPrestazione.getDescrizionePrestazione() == null) ? "" : curPrestazione.getDescrizionePrestazione()));
					curMapPrestazione.put("costo", ((curPrestazione.getCostoPrestazione() == null) ? "" : curPrestazione.getCostoPrestazione()));
					
					// Inserisco la mappa della prestazione corrente nella lista
					listaMapPrestazioni.add(curMapPrestazione);
				}
				
				// Inserisco la lista di prestazioni nella mappa dell'appuntamento
				curMapAppuntamento.put("listaPrestazioni", listaMapPrestazioni);

				// Inserisco la mappa dell'appuntamento corrente nella lista
				listaMapAppuntamenti.add(curMapAppuntamento);
			}
			// Passo la lista di appuntamenti all'engine
			mapVelocity.put("listaAppuntamenti", listaMapAppuntamenti);
		
		}else{
			// Se sono entrato in questo ramo è FALLITA la chiamata al Service del CUP per recuperare la Prescrizione
			// disdettata per cui non posso generare il promemoria. 
			// Genero comunque un PDF con il messaggio per l'utente
			// Recupero il modello di errore
			templateFileName = TMPLT_ERRORE_DISDETTA;
			mapVelocity.put("downloadPromemoriaURL", getPromemoriaURL(idEnte, codFiscale, codPrenotazione, keyTipoPrenotazione, baseURL).PdfURL);
		}
		
		// Inizializzo l'engine
		String templateLocation = ServiziCittadinoRestServiceImpl.class.getResource("/vmTemplates/").getPath().replaceAll("%20", " ");
		Properties props = new Properties();
        props.setProperty(VelocityEngine.RESOURCE_LOADER, "file");
        props.setProperty(VelocityEngine.FILE_RESOURCE_LOADER_PATH, templateLocation);
        VelocityEngine velocityEngine = new VelocityEngine();
        velocityEngine.init(props);

		// Generaro l'rtf chiamando velocity....
		String body = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, templateFileName, mapVelocity);
		
		// Convertire il modello in PDF...
		// Generare un outputstream utilizzando OpenOffice...
		InputStream inputStream = new ByteArrayInputStream(body.getBytes());//StandardCharsets.UTF_8));
		ByteArrayOutputStream baos = null;
		try {
			// Generare un outputstream utilizzando OpenOffice...
			baos = ConverterToPdf.converterToPdf(inputStream, "application/msword", openOfficeHost, openOfficePort);
			response = baos.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return response;
	}
	
	private DisdettaResponseJAXB getPromemoriaURL(
			String idEnte, 
			String codFiscale, 
			String codPrenotazione, 
			int tipoPrenotazione,
			String promemoriaBaseURL){
		DisdettaResponseJAXB response = null;
		
		String promemoriaURL = String.format("%s?idEnte=%s&codiceFiscale=%s&cup=%s&tipologia=%s",
												promemoriaBaseURL, 
												idEnte, 
												codFiscale, 
												codPrenotazione, 
												tipoPrenotazione);
		response = new DisdettaResponseJAXB("Ok", null, promemoriaURL);
		
		return response;
	}
	
	private DisdettaResponseJAXB eseguiDisdetta(
			Servizi wsService, 
			CfgEnte ente, 
			String codPrenotazione,
			String codFiscale, 
			int tipologia,
			Prescrizione daDisdire,
			String basePromemoriaURL){
		DisdettaResponseJAXB response = new DisdettaResponseJAXB(WsCupErrorEnum.OK.getValue(), null, "");

		if (daDisdire.getListaAppuntamenti()==null){
			String errMessage = String.format("NumPrescrizione:%s - idPrescrizione:%s - NON HA APPUNTAMENTI!!",
					daDisdire.getNumPrescrizione(), daDisdire.getIdPrescrizione());
			response = new DisdettaResponseJAXB(WsCupErrorEnum.GENERIC_ERROR.getValue(), errMessage, "");
			log.error(errMessage);
		}
		else{
			// Configuro l'Operatore...
			Operatore wsOpe = new Operatore(
					ente.getOperatoreUsername(), 
					ente.getOperatorePassword(), 
					null);

			// Configuro l'ente...
			Ente wsEnte = new Ente(ente.getIdEnte());

			try {
				for(Appuntamento app: daDisdire.getListaAppuntamenti()){
					if (!app.getStatoAppuntamento().equals(WsCupStatoAppuntamentoEnum.CANCELLATO.getValue())){
						Appuntamento appDaDisdire = new Appuntamento();
						appDaDisdire.setIdAppuntamento(app.getIdAppuntamento());
						appDaDisdire.setStatoAppuntamento(app.getStatoAppuntamento());
						RichiestaCancella cancellaRequest = new RichiestaCancella(wsOpe, wsEnte, appDaDisdire);
						
						// Chiamata al WS del CUP...
						log.info(String.format("Chiamata al servizio CUP setCancella (idAppuntamento:%s).....", appDaDisdire.getIdAppuntamento()));
						RispostaCancella cancellaResponse = wsService.setCancella(cancellaRequest);
						log.info(String.format("Chiamata al servizio CUP setCancella (idAppuntamento:%s) ESEGUITA!!", appDaDisdire.getIdAppuntamento()));

						if (cancellaResponse == null){
							log.error("cancellaResponse IS NULL");
							throw new ServiziCittadinoRestServiceException(MSG_SERVIZIO_NON_DISPONIBILE);
						}else{
							// Analizzo il messaggio di errore...
							if (ErroreInResponse(cancellaResponse.getErrore())){
								response = new DisdettaResponseJAXB(
										cancellaResponse.getErrore().getCodiceErrore(), 
										cancellaResponse.getErrore().getMessaggioErrore(), 
										"");
								break;
							}
						}
					}else{
						String warnMsg = String.format("ATTENZIONE!!: [idPrescr:%s - idApp:%s] - Appuntamento in stato %s NON CANCELLABILE!!",
								codPrenotazione, app.getIdAppuntamento(), app.getStatoAppuntamento()); 
						log.warn(warnMsg);
						response = new DisdettaResponseJAXB(
												WsCupErrorEnum.GENERIC_ERROR.getValue(),
												String.format(MSG_DISDETTA_NON_ESEGUIBILE, codPrenotazione, codFiscale), 
												getPromemoriaURL(ente.getIdEnte(), codFiscale, codPrenotazione, tipologia, basePromemoriaURL).PdfURL);
						break;
					}
				}
			} catch (Exception e) {
				log.error(e.getMessage(), e);
				response = new DisdettaResponseJAXB(WsCupErrorEnum.GENERIC_ERROR.getValue(), e.getMessage(), "");
			}
		}
		
		return response;
	}
	
	private boolean ErroreInResponse(Errore wsError){
		boolean retValue=false;

		if (wsError==null){
			log.error("Oggetto Errore in response IS NULL");
		}else{
			log.info(String.format("Response del CUP: codiceErrore:%s - messaggio:%s",
					wsError.getCodiceErrore(), wsError.getMessaggioErrore()));
			
			if (!wsError.getCodiceErrore().equalsIgnoreCase(WsCupErrorEnum.OK.getValue()))
				retValue=true;
		}
				
		return retValue;
	}
	
	private DisdettaResponseJAXB getPrescrizione(
			Servizi wsService, 
			CfgEnte ente, 
			String codFiscale, 
			String codPrenotazione,
			String tipoErogazione,
			Prescrizione daDisdire
			) {
		DisdettaResponseJAXB response = null;
		
		// Configuro l'Operatore...
		Operatore wsOpe = new Operatore(
				ente.getOperatoreUsername(), 
				ente.getOperatorePassword(), 
				null);

		// Configuro l'ente...
		Ente wsEnte = new Ente(ente.getIdEnte());

		// Configuro il Paziente...
		Paziente wsPaziente = new Paziente();
		wsPaziente.setCodiceFiscale(codFiscale);

		// Configuro la Lista Prescrizioni 
		Prescrizione wsPrescrizione = new Prescrizione();
		wsPrescrizione.setTipoErogazione(tipoErogazione);
		Prescrizione[] listaPrescrizioni = new Prescrizione[] { wsPrescrizione };
		
		// Genero la Request...
		RichiestaPrescrizioni prescrRequest = new RichiestaPrescrizioni();
		prescrRequest.setEnte(wsEnte);
		prescrRequest.setPaziente(wsPaziente);
		prescrRequest.setOperatore(wsOpe);
		prescrRequest.setListaPrescrizioni(listaPrescrizioni);
		
		try {
			log.info("Chiamata al servizio CUP getPrescrizioni().....");
			RispostaPrescrizioni prescrResponse = wsService.getPrescrizioni(prescrRequest);
			log.info("Chiamata al servizio CUP getPrescrizioni() ESEGUITA");

			if (prescrResponse == null){
				log.error("prescrResponse IS NULL");
				throw new ServiziCittadinoRestServiceException(MSG_SERVIZIO_NON_DISPONIBILE);
			}else{
				// Analizzo il messaggio di errore...
				if (ErroreInResponse(prescrResponse.getErrore())){
					response = new DisdettaResponseJAXB(
							prescrResponse.getErrore().getCodiceErrore(), 
							prescrResponse.getErrore().getMessaggioErrore(), 
							"");
				}else{
					if (prescrResponse.getListaPrescrizioni() != null){
						int nrPrescrizioni = prescrResponse.getListaPrescrizioni().length;
						log.info(String.format("Servizio getPrescrizioni() invocato: recuperate %s prescrizioni.", nrPrescrizioni));

						String anno = codPrenotazione.substring(0, 4);
						String numPren = codPrenotazione.replaceFirst(anno, "");
						String codUnicoPrenotazione = ente.getCodiceUnicoPrenotazione(anno, numPren);
						boolean trovato = false;
						for (Prescrizione pr : prescrResponse.getListaPrescrizioni()){
							// TODO: mettere in debug...
							log.info(String.format("Id Prescrizione:%s - CF:%s, tipo:%s Stato:%s - CodUnicoPren:%s",
									pr.getIdPrescrizione(),
									prescrResponse.getPaziente().getCodiceFiscale(),
									pr.getTipoErogazione(),
									pr.getListaAppuntamenti()[0].getStatoAppuntamento(),
									codUnicoPrenotazione));

							// Verifico se questa è la prescrizione desiderata....
							if (pr.getIdPrescrizione().equals(codUnicoPrenotazione)){
								log.info(String.format("Trovata Prenotazione : codFiscale:%s - idPrenotazione:%s - tipo:%s - nr. appuntamenti:%s", 
										codFiscale, pr.getIdPrescrizione(), pr.getTipoErogazione(), pr.getListaAppuntamenti().length));
								
								daDisdire.setIdPrescrizione(pr.getIdPrescrizione());
								daDisdire.setTipoErogazione(pr.getTipoErogazione());
								daDisdire.setNumeroImpegnativa(pr.getNumeroImpegnativa());
								daDisdire.setTipoPrescrizione(pr.getTipoPrescrizione());
								daDisdire.setClassePriorita(pr.getClassePriorita());
								daDisdire.setCostoPrescrizione(pr.getCostoPrescrizione());
								daDisdire.setDataImpegnativa(pr.getDataImpegnativa());
								daDisdire.setCodiceEsenzione(pr.getCodiceEsenzione());
								
								Appuntamento[] listaAppuntamenti = new Appuntamento[pr.getListaAppuntamenti().length];
								for (int idx = 0; idx < pr.getListaAppuntamenti().length; idx++){
									log.info(String.format("copia dei dati dell'appuntamento con id:%s...", pr.getListaAppuntamenti()[idx].getIdAppuntamento()));
									listaAppuntamenti[idx] = pr.getListaAppuntamenti()[idx];
								}
								daDisdire.setListaAppuntamenti(listaAppuntamenti);
								
								trovato=true;
								break;
							}
						}
						
						// Verifico se ho trovato una prescrizione con il numero passato...
						if (trovato){
							response = new DisdettaResponseJAXB(WsCupErrorEnum.OK.getValue(), null, "");
						}else{
							String errMessage = String.format("ATTENZIONE! Nessuna Prenotazione trovata con numero: %s per il cittadino con C.F.:%s di tipologia:%s",
									codPrenotazione, codFiscale, tipoErogazione);
							response = new DisdettaResponseJAXB(WsCupErrorEnum.GENERIC_ERROR.getValue(), errMessage, "");
							log.error(errMessage);
						}
					}
					else{
						String errMessage = "prescrResponse.getListaPrescrizioni() IS NULL";
						response = new DisdettaResponseJAXB(WsCupErrorEnum.GENERIC_ERROR.getValue(), errMessage, "");
						log.error(errMessage);
					}
				}

			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			response = new DisdettaResponseJAXB(WsCupErrorEnum.GENERIC_ERROR.getValue(), e.getMessage(), "");
		}
		
		return response;
	}
	
	private Servizi findServizioByEnte(CfgEnte ente) throws ServiziCittadinoRestServiceException{
		
		try {
			log.debug(String.format("Istanzio il client per l'endpoint url:%s", ente.getWsEndpointURL()));
			
			// Istanzio il locator...
			WssgpLocator locator = new WssgpLocator();
			log.debug("locator istanziato...");
						
			//Istanzio il client e ne imposto l'endPoint...
			URL endPointURL = new URL(ente.getWsEndpointURL());
			Servizi client = locator.getwssgp(endPointURL);
			log.debug(String.format("client istanziato. endPointURL:%s", endPointURL.toString()));
			
			return client;
			
		} catch (Exception exp) {
			log.error(exp.getMessage(), exp);
			throw new ServiziCittadinoRestServiceException(MSG_SERVIZIO_NON_DISPONIBILE);
		}
	}
	
	private DisdettaResponseJAXB scaricaPromemoria(
			Servizi wsService,
			CfgEnte ente, 
			String codPrenotazione,
			Prescrizione prescrizione,
			String promemoriaBaseURL) {
		
		if (prescrizione==null)
			log.error("Attenzione prescrizione is null!!");
		
		DisdettaResponseJAXB response = null;

		// Configuro l'Operatore...
		Operatore wsOpe = new Operatore(
				ente.getOperatoreUsername(), 
				ente.getOperatorePassword(), 
				null);

		// Configuro l'ente...
		Ente wsEnte = new Ente(ente.getIdEnte());

		try{
			RichiestaPromemoria promemoriaRequest = new RichiestaPromemoria(wsOpe, wsEnte, prescrizione);
			// Chiamata al WS del CUP...
			RispostaPromemoria promemoriaResponse = wsService.getPromemoria(promemoriaRequest);

			if (promemoriaResponse == null){
				log.error("promemoriaResponse IS NULL");
				throw new ServiziCittadinoRestServiceException(MSG_SERVIZIO_NON_DISPONIBILE);
			}else{
				// Analizzo il messaggio di errore...
				if (ErroreInResponse(promemoriaResponse.getErrore())){
					response = new DisdettaResponseJAXB(
							promemoriaResponse.getErrore().getCodiceErrore(), 
							promemoriaResponse.getErrore().getMessaggioErrore(), 
							"");
				}else{
					log.debug(String.format("Promemoria Base64:%s", promemoriaResponse.getPromemoria()));
					byte[] pdfContentBytes = Base64.decode(promemoriaResponse.getPromemoria());
					String filename = String.format("%s_%s.pdf",codPrenotazione, Calendar.getInstance().getTimeInMillis());
					String tmpPdfPath = promemoriaTempFolder + filename;
					File promemoria = StreamUtils.dumpToFile(pdfContentBytes, tmpPdfPath);
					
					String promemoriaURL = String.format("%s?filename=%s",promemoriaBaseURL, filename);
					response = new DisdettaResponseJAXB("Ok", null, promemoriaURL);
				}
			}

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			response = new DisdettaResponseJAXB(WsCupErrorEnum.GENERIC_ERROR.getValue(), e.getMessage(), "");
		}		
		
		return response;
	}


}
