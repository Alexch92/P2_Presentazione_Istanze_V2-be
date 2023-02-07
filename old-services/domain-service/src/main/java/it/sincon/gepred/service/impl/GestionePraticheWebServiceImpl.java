package it.sincon.gepred.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import it.osapulie.domain.Comune;
import it.osapulie.domain.ProfiloUtente;
import it.osapulie.domain.Ruolo;
import it.osapulie.infrastructure.impl.DateUtils;
import it.osapulie.infrastructure.impl.StreamUtils;
import it.osapulie.infrastructure.impl.StringUtils;
import it.osapulie.persistence.ComuneRepository;
import it.osapulie.service.ProfiloUtenteService;
import it.osapulie.service.ServiceLayerException;
import it.osapulie.web.portlet.util.CheckSumGenerator;
import it.osapulie.web.portlet.util.MailPecSenderHelper;
import it.osapulie.web.portlet.util.MailSenderHelper;
import it.sincon.gepred.documentale.bean.DocFile;
import it.sincon.gepred.documentale.bean.DocInfo;
import it.sincon.gepred.documentale.bean.DocumentaleException;
import it.sincon.gepred.documentale.service.DocumentaleService;
import it.sincon.gepred.domain.Allegati;
import it.sincon.gepred.domain.AllegatiPratica;
import it.sincon.gepred.domain.CampiAggiuntiviListaValori;
import it.sincon.gepred.domain.CampiAggiuntiviPraticaWeb;
import it.sincon.gepred.domain.Referente;
import it.sincon.gepred.domain.TipoImmobile;
import it.sincon.gepred.domain.pratica.Azienda;
import it.sincon.gepred.domain.pratica.CategoriePratiche;
import it.sincon.gepred.domain.pratica.ElencoPraticheWeb;
import it.sincon.gepred.domain.pratica.Modelli;
import it.sincon.gepred.domain.pratica.NumeroPratica;
import it.sincon.gepred.domain.pratica.Pratica;
import it.sincon.gepred.domain.pratica.PraticaWeb;
import it.sincon.gepred.domain.pratica.PraticaWebExtended;
import it.sincon.gepred.domain.pratica.Preventivo;
import it.sincon.gepred.domain.pratica.RappresentanteLegale;
import it.sincon.gepred.domain.pratica.StatoPratica;
import it.sincon.gepred.domain.pratica.TipoPratica;
import it.sincon.gepred.domain.pratica.TipoPraticaTab;
import it.sincon.gepred.persistence.AllegatiRepository;
import it.sincon.gepred.persistence.CampiAggiuntiviPraticaWebRepository;
import it.sincon.gepred.persistence.PraticaRepository;
import it.sincon.gepred.persistence.PraticaWebRepository;
import it.sincon.gepred.persistence.PreventivoRepository;
import it.sincon.gepred.persistence.RappresentanteLegaleRepository;
import it.sincon.gepred.persistence.StatoPraticaRepository;
import it.sincon.gepred.persistence.TipoImmobileRepository;
import it.sincon.gepred.protocollo.bean.AllegatoProtocollo;
import it.sincon.gepred.protocollo.bean.DatiAutenticazione;
import it.sincon.gepred.protocollo.bean.DatiEsito;
import it.sincon.gepred.protocollo.bean.DatiMittenteDestinatario;
import it.sincon.gepred.protocollo.bean.DatiOutputProtocollo;
import it.sincon.gepred.protocollo.bean.DatiRichiestaProtocollo;
import it.sincon.gepred.protocollo.bean.MezzoSpedizioneEnum;
import it.sincon.gepred.protocollo.service.ProtocolloService;
import it.sincon.gepred.service.GestioneCampiAggiuntiviService;
import it.sincon.gepred.service.GestionePraticheWebService;
import it.sincon.gepred.service.GestioneReferenteService;
import it.sincon.gepred.service.GestioneTipoPraticheService;
import it.sincon.gepred.service.NumeroPraticaService;
import it.sincon.gepred.service.RappresentanteLegaleService;
import it.sincon.gepred.visura.service.VisuraService;
import it.sincon.gepred.web.portlet.utils.ConverterToPdf;
import it.sincon.gepred.web.portlet.utils.ServiceHelper;
import it.sincon.gepred.web.portlet.utils.CalcolaPunteggioUtils;
import it.sincon.gepred.web.portlet.varie.DatiRicercaPraticaWeb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.PrefsPropsUtil;

import org.apache.commons.io.FileUtils;


/**
 * Implementazione di {@link GestionePraticheWebService}
 * 
 * @author Maria Michela Birtolo
 */
@Service("gestionePraticheWebService")
public class GestionePraticheWebServiceImpl implements GestionePraticheWebService {

	private static Logger log = LoggerFactory
			.getLogger(GestionePraticheWebServiceImpl.class);

	@PersistenceContext
	private EntityManager em;
	
	@Inject
	private PraticaWebRepository praticaWebRepository;	
	
	@Inject
	private PraticaRepository praticaRepository;
	
	@Inject
	private GestioneTipoPraticheService gestioneTipoPraticheService;
	
	@Inject
	private GestioneReferenteService gestioneReferenteService;
	
	@Inject
	private ComuneRepository comuneRepository;
	
	@Inject
	private TipoImmobileRepository tipoImmobileRepository;
	
	@Inject
	private AllegatiRepository allegatiRepository;
	
	@Inject
	private ProfiloUtenteService profiloUtenteService;
	
	@Inject
	private NumeroPraticaService numPraticaService;
	
	//@Inject
	//private AllegatiPraticaRepository allegatiRepository;
	
	@Inject
	private CampiAggiuntiviPraticaWebRepository campiAggPraticaRepository;
	
	@Inject
	private GestioneCampiAggiuntiviService gestioneCampiAggiuntiviService;
	
	@Inject
	private StatoPraticaRepository statoPraticaRepository;
	
	@Inject
	private RappresentanteLegaleRepository rappresentanteLegaleRepository;
	@Inject
	private RappresentanteLegaleService rappresentanteLegaleService;
	
	@Inject
	private PreventivoRepository preventivoRepository;
	
	//	@Inject
	//	private DocumentHandler documentHandler;
	//  TO DO : Rimuovere...
	
	@Autowired(required=false)
	private ProtocolloService protocolloService;

	@Autowired(required = false)
	private DocumentaleService documentaleService;
	
	@Autowired(required = false)
	private VisuraService visuraService;

	@Inject
	private MailSenderHelper mailSenderHelper;
	
	@Inject
	private MailPecSenderHelper mailPecSenderHelper;
	
	
	@Value("#{applicationProperties.host_open_office}")
	private String hostOpenOffice;
	
	@Value("#{applicationProperties.port_open_office}")
	private String portOpenOffice;


	@Value("#{applicationProperties.tplEmail}")
	private String templateName;
	@Value("#{applicationProperties.tplEmailProtocolloViaPec}")
	private String tplEmailProtocolloViaPec;
	
	
	@Value("#{applicationProperties.nomeModello}")
	private String nomeModello;
	
	@Value("#{applicationProperties.nomeModelloRitiro}")
	private String nomeModelloRitiro;
	
	@Value("#{applicationProperties.tplEmailRitiro}")
	private String tplEmailRitiroName;
	
	@Value("#{applicationProperties.documentaleFolderRichiestePratiche}")
	private String destContenitoreRichiestePratiche;
	
	@Value("#{applicationProperties.patternNomeAllegatoPraticaWeb}")
	private String patternNomeAllegatoPraticaWeb;
	
	@Value("#{applicationProperties.patternNomeAllegatoPraticaWebToBeSaved}")
	private String patternNomeAllegatoPraticaWebToBeSaved;

	@Value("#{applicationProperties.nomeRicevuta}")
	private String nomeRicevuta;
	
	
	@Value("#{applicationProperties.patternNomeAllegatoB_RapprLegale}")
	private String patternNomeAllegatoB_RapprLegale;
	
	@Value("#{applicationProperties.inviaCopiaPraticaWebViaPec}")
	private String configInviaCopiaPraticaWebViaPec;
	
	@Value("#{applicationProperties.tplEmailNotificaCambioStato}")
	private String tplEmailNotificaCambioStato;
	
	@Value("#{applicationProperties.tplEmailCheckValidazione}")
	private String tplEmailCheckValidazione;
	@Value("#{applicationProperties.tplMittenteMailIstruttorie}")
	private String mittenteMailIstruttorie;
	
	private static final String LABEL_SOTTOSCRITTORE = "Il sottoscritto";
	private static final String LABEL_NOME_AZIENDA = "della Ditta/Impresa";
	private static final String LABEL_E_MAIL = "E-mail";
	private static final String LABEL_DENOM_BENEFICIARIO = "Cognome e Nome";
	
	
	private static final String LABEL_UNITA_ABIBATIVE = "Unità abitative occupate";
	private static final String LABEL_UNITA_ABIBATIVE_TOT = "Unita' abitative totali";
	private static final String LABEL_PERC_UNITA_ABIBATIVE = "Unita' abitative (%)";
	
	private static final String LABEL_SUP_LORDA_PAV = "Sup. lorda pavim. destinata ad unita' abitative (mq)";
	private static final String LABEL_SUP_LORDA_PAV_TOT = "Superficie lorda pavimento (mq)";
	private static final String LABEL_PERC_SUP_LORDA_PAV = "S.L.P. (%)";
	
	/**
	 * Metodo che ricerca le pratiche
	 */
	public List<Pratica> searchPratiche(DatiRicercaPraticaWeb filtriRicerca) {
		log.debug("searchPratiche :: entering method");
		String queryString = "select DISTINCT pr from Pratica pr LEFT OUTER JOIN pr.figure fig " +
				" LEFT OUTER JOIN pr.richiedente rich " +
				" LEFT OUTER JOIN fig.referente ref " +
				" LEFT OUTER JOIN fig.qualifica qua " +
				"where ((upper(rich.cf) = upper(?1) OR upper(rich.piva) = upper(?2))  OR "
				+ "     ((upper(ref.cf) = upper(?3) OR upper(ref.piva) = upper(?4))  and qua.visWeb= 1) OR "
				+ "     ((upper(pr.titolare) = upper(?1) OR upper(pr.impresa) = upper(?1))) OR "
				+ "     (rich.id = (?5))) ";
		if (filtriRicerca.getOggetto() != null
				&& !filtriRicerca.getOggetto().equals("")) {
			queryString += " AND lower(pr.oggettoRichiesta) LIKE lower(?6)";
		}
		if (filtriRicerca.getNumero() != null
				&& !filtriRicerca.getNumero().equals("")) {
			queryString += " AND pr.numeroPratica  = ?7";
		}
		if (filtriRicerca.getStatopratica() != null
				&& !filtriRicerca.getStatopratica().equals("")) {
			queryString += " AND pr.stato.id  = ?8";
		}
		if (filtriRicerca.getTipologia() != null && !filtriRicerca.getTipologia().equals("")) {
			queryString += " AND pr.tipologia.id  = ?9";
		}
		if (filtriRicerca.getStatiAmmessi() != null) {
			queryString += " AND pr.stato.id IN ?10";
		}
		
		queryString += " ORDER BY pr.dataRichiesta DESC, pr.numeroPratica DESC";
		Query query = em.createQuery(queryString, Pratica.class);
		
		query.setParameter(1, filtriRicerca.getUtente());
		query.setParameter(2, filtriRicerca.getUtente());
		query.setParameter(3, filtriRicerca.getUtente());
		query.setParameter(4, filtriRicerca.getUtente());

		if (StringUtils.isNumericString(filtriRicerca.getUtente()))
			query.setParameter(5, Long.parseLong(filtriRicerca.getUtente()));
		else
			query.setParameter(5, 0);
		
		if (filtriRicerca.getOggetto() != null
				&& !filtriRicerca.getOggetto().equals("")) {
			query.setParameter(6, "%"
					+ filtriRicerca.getOggetto().toLowerCase() + "%");
		}
		if (filtriRicerca.getNumero() != null
				&& !filtriRicerca.getNumero().equals("")) {
			query.setParameter(7, filtriRicerca.getNumero());
		}
		if (filtriRicerca.getStatopratica() != null
				&& !filtriRicerca.getStatopratica().equals("")) {
			query.setParameter(8, filtriRicerca.getStatopratica());
		}		
		if (filtriRicerca.getTipologia() != null
				&& !filtriRicerca.getTipologia().equals("")) {
			query.setParameter(9, filtriRicerca.getTipologia());
		}
		if (filtriRicerca.getStatiAmmessi() != null) {
			query.setParameter(10, filtriRicerca.getStatiAmmessi());
		}
		
		return (List<Pratica>) query.getResultList();
	}

//	public String getContenitoreFolderRichiestePratiche() {
//		return destContenitoreRichiestePratiche;
//	}
//
//	public void setContenitoreFolderRichiestePratiche(String _destContenitoreRichiestePratiche) {
//		this.destContenitoreRichiestePratiche = _destContenitoreRichiestePratiche;
//	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.osapulie.service.PraticaService#getPraticaByPk(long)
	 */
	public Pratica getPraticaByPk(long pk) throws ServiceLayerException {
		return praticaRepository.findOne(pk);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see it.osapulie.service.PraticaService#getPraticaByPk(long)
	 */
	public PraticaWeb getPraticaWebByPk(long pk) throws ServiceLayerException {
		PraticaWeb praticaWeb = praticaWebRepository.findOne(pk);
		
		if (praticaWeb != null) {
			if (praticaWeb.getFascicoliCorrelati() != null) {
				if (praticaWeb.getFascicoliCorrelati().size() > 0) {
					praticaWeb.setPrCorrelata(praticaWeb.getFascicoliCorrelati().get(0));
				}	
			}
		}
		
		return praticaWeb;
	}
	
	
	public String CercaAllegatoInDocumentale(String nomeDocumentoModello, String uuidContenitore, long idPraticaWeb) 
			throws ServiceLayerException, DocumentaleException
	{
		log.debug(String.format("nome documento: %s", nomeDocumentoModello));
		String uuidDocumento = null;
		List<DocInfo> documents = documentaleService.documentiContenuti(uuidContenitore);
		log.debug(String.format("Il contenitore con con uuid=%s contiene %s documenti...", uuidContenitore, documents.size()));
		for(int i=0; i<documents.size(); i++){
			log.debug(String.format("allegato alfresco nome: %s - uuid: %s", documents.get(i).getFile().getNome(), documents.get(i).getUuid()));
			if (documents.get(i).getFile().getDimensione()==null || documents.get(i).getFile().getDimensione().equals("0")){
				throw new ServiceLayerException("Sono presenti allegati a zero byte");
			}else if(documents.get(i).getFile().getNome().startsWith(nomeDocumentoModello)){
				uuidDocumento=documents.get(i).getUuid();
			}
		}	
		
		return uuidDocumento;
	}
	private File generaDocumentoPrincipaleContentDaModello(PraticaWeb pr, PraticaWeb praticaWeb, String modalitaUtilizzo) throws Exception {
		File retValue = null;
		Modelli modelloPraticaWeb = null;
		byte[] contentPrincipale=null;
		for(int i=0;i<pr.getTipologia().getModelli().size() && modelloPraticaWeb==null;i++){
			Modelli modello = pr.getTipologia().getModelli().get(i);
			if (modello.isWeb())
				modelloPraticaWeb=modello;
		}
		if (modelloPraticaWeb!=null) {
			String fileName = StringUtils.cleanString(modelloPraticaWeb.getNome());
			//byte[] contenuto = modello.getContenuto();		

			String mainModelloPath = this.getClass().getResource("/tplEmail/").getPath().replaceAll("%20", " ");
			fileName = fileName + DateUtils.getOggi().getTime();
			mainModelloPath+= fileName+".vm";
			StreamUtils.dumpToFile(modelloPraticaWeb.getContenuto(), mainModelloPath);
			pr.setAllegati(praticaWeb.getAllegati());
			for(AllegatiPratica allegato : pr.getAllegati()){
				if (allegato.getUuidFile()!=null && !allegato.getUuidFile().equals("") && allegato.getImpronta() == null){
					byte[] content = documentaleService.download(pr.getUuidContenitore(), allegato.getUuidFile()).getContent();
					String impronta = CheckSumGenerator.generateCheckSum(content);
					allegato.setImpronta(impronta);
				}
			}
			
			HashMap<String, Object> map = pr.getPraticaAsMap();
			map.put("modalitaUtilizzo", modalitaUtilizzo);
			String body = mailSenderHelper.mergeTplModelli(fileName+".vm", map);
			String rtfFileName=String.format(fileName+"."+modelloPraticaWeb.getEstensione());
			
			String pdfFileName = ServiceHelper.createDir();
			try {
				retValue = ConverterToPdf.converterToPdf(body.getBytes(), pdfFileName, rtfFileName, hostOpenOffice, Integer.parseInt(portOpenOffice));
				if (retValue==null || !retValue.exists()){
					retValue = new File(pdfFileName,rtfFileName);
					StreamUtils.dumpToFile(body.getBytes(), retValue.getPath());
				}
			} catch (Exception e) {
				log.error(e.getMessage(), e);
				retValue = new File(pdfFileName,rtfFileName);
				StreamUtils.dumpToFile(body.getBytes(), retValue.getPath());
			}									
		} else
			throw new Exception(String.format("Nessun modelloPraticaWeb trovato per la pratica con id=%s. Controllare la Tipologia di Pratica %s...",
					pr.getId(), pr.getTipologia().getDescrizione()));
		
		return retValue;
	}
	
	private DatiOutputProtocollo executeProtocolla(
			String nomeFileOriginal, String nomeModello, ProfiloUtente profiloUtenteProtocollatore, PraticaWeb pr, byte[] contentPrincipale) 
					throws IOException {
		log.debug("executeProtocolla...START");
		DatiOutputProtocollo datiOutputProtocollo = null;
		
		if (profiloUtenteProtocollatore!=null) {
			DatiAutenticazione datiAutenticazione = new DatiAutenticazione();
			datiAutenticazione.setUsername(profiloUtenteProtocollatore.getUsernameProtocollo());
			datiAutenticazione.setPassword(profiloUtenteProtocollatore.getPasswordProtocollo());
			datiAutenticazione.setCodiceUfficio(profiloUtenteProtocollatore.getCodiceUfficio());
			datiAutenticazione.setIdUtente(profiloUtenteProtocollatore.getIdUtenteProtocollo());
			DatiRichiestaProtocollo datiRichiestaProtocollo = new DatiRichiestaProtocollo();
			datiRichiestaProtocollo.setTipoProtocollo("I");
			datiRichiestaProtocollo.setOggetto(pr.getOggettoRichiesta());
			AllegatoProtocollo documentoPrincipaleProtocollo = new AllegatoProtocollo();
			documentoPrincipaleProtocollo.setContenutoAllegato(contentPrincipale);
			documentoPrincipaleProtocollo.setUrlAllegato(nomeFileOriginal);
			documentoPrincipaleProtocollo.setIdAllegato(1L);
			documentoPrincipaleProtocollo.setNomeDocumento(nomeModello);
			documentoPrincipaleProtocollo.setDaAllegareProtocollazione(true);
			datiRichiestaProtocollo.setAllegati(new ArrayList<AllegatoProtocollo>());
			datiRichiestaProtocollo.getAllegati().add(documentoPrincipaleProtocollo);
			datiRichiestaProtocollo.setDocumentoPrincipale(documentoPrincipaleProtocollo);
			datiRichiestaProtocollo.setMittenteDestinatario(new ArrayList<DatiMittenteDestinatario>());
			DatiMittenteDestinatario mittente = new DatiMittenteDestinatario();
			mittente.setAzienda(false);
			String nome=null;
			String cognome=null;
			String email=null;
			String codiceFiscale="";
			String indirizzo=null;
			String comune=null;
			if (pr.getProfiloutente()!=null) {
				email=pr.getProfiloutente().getMail();
				nome=pr.getProfiloutente().getNome();
				cognome=pr.getProfiloutente().getCognome();
				codiceFiscale=pr.getProfiloutente().getCodiceFiscale();
				if (pr.getReferente()!=null) {
					if (pr.getReferente().getComune()!=null)
						comune=pr.getReferente().getComune().getDenominazione();
					indirizzo=pr.getReferente().getIndirizzo();
				}
			}
				//URP
			for(int i=0;i<pr.getCampiaggiuntivi().size();i++) {
				if (pr.getCampiaggiuntivi().get(i).getCampiAggiuntivi().getLabel().equals("Nome") && pr.getCampiaggiuntivi().get(i).getValore()!=null && nome==null)
					nome=pr.getCampiaggiuntivi().get(i).getValore();
				else if (pr.getCampiaggiuntivi().get(i).getCampiAggiuntivi().getLabel().equals("Cognome") && pr.getCampiaggiuntivi().get(i).getValore()!=null && cognome==null)
					cognome=pr.getCampiaggiuntivi().get(i).getValore();
				else if (pr.getCampiaggiuntivi().get(i).getCampiAggiuntivi().getLabel().equals("Indirizzo") && pr.getCampiaggiuntivi().get(i).getValore()!=null && indirizzo==null)
					indirizzo=pr.getCampiaggiuntivi().get(i).getValore();
				else if (pr.getCampiaggiuntivi().get(i).getCampiAggiuntivi().getLabel().equals("Comune") && pr.getCampiaggiuntivi().get(i).getValore()!=null && comune==null)
					comune=pr.getCampiaggiuntivi().get(i).getValore();
				else if (pr.getCampiaggiuntivi().get(i).getCampiAggiuntivi().getLabel().equals(LABEL_E_MAIL) && pr.getCampiaggiuntivi().get(i).getValore()!=null && email==null)
					email=pr.getCampiaggiuntivi().get(i).getValore();
			}
			mittente.setCognome(cognome);
			mittente.setNome(nome);
			mittente.setEmail(email);
			mittente.setCodiceFiscale(codiceFiscale);
			if (indirizzo != null && (!indirizzo.equals("")))
		          mittente.setIndirizzo(indirizzo);
		        else
		          mittente.setIndirizzo("NON DEFINITO");
	        if (comune!=null && !comune.equals(""))
	            mittente.setCitta(comune);
	          else
	            mittente.setCitta("NON DEFINITO");
			if (protocolloService.traduciMezziSpedizione()!=null && !protocolloService.traduciMezziSpedizione().isEmpty()){
				SortedMap<MezzoSpedizioneEnum, Serializable> mezziSpedizione = protocolloService.traduciMezziSpedizione();
				mittente.setMezzoSpedizione(mezziSpedizione.firstKey());
			}
			datiRichiestaProtocollo.getMittenteDestinatario().add(mittente);
			datiOutputProtocollo = protocolloService.protocollaPratica(datiRichiestaProtocollo, datiAutenticazione);
			log.debug(String.format("esito protocollo: %s - numero protocollo: %s", datiOutputProtocollo.getEsito().getCodice(), datiOutputProtocollo.getNumeroProtocollo()));
		}
		
		log.debug("executeProtocolla...END");
		return datiOutputProtocollo;
	}
	
	private DatiOutputProtocollo executeInviaCopiaPraticaWebViaPec(
			DocFile documentoPrincipale, String nomeFileOriginal, PraticaWeb pr) {
		log.info("executeInviaCopiaPraticaWebViaPec...START");
		
		DatiOutputProtocollo retValue = new DatiOutputProtocollo();
		DatiEsito esito = new DatiEsito();
		esito.setCodice("000");
		
		File[] attachments = null;
		File daAllegare = null;
		if (documentoPrincipale != null) {
			String directory = ServiceHelper.createDir();
			daAllegare = new File(directory, nomeFileOriginal);
			try {
				StreamUtils.dumpToFile(documentoPrincipale.getContent(), daAllegare.getPath());
			} catch (Exception e) {
				log.error(e.getMessage(), e);
				esito.setCodice("001");
				esito.setDescrizione(String.format("Errore nel recupero del documento principale - %s", e.getMessage()));
			}
		} 
		
		if (esito.getCodice().equals("000")) {
			attachments = new File[]{daAllegare};
			
			String emailTo = pr.getTipologia().getMittenteMail();
			if (emailTo!=null) {
				Map model = new HashMap();
				String oggetto = String.format("Nuova istanza Presentata:%s - %s", 
						pr.getNumeroPratica(), pr.getOggettoRichiesta());  
				
				boolean pecEnableBoolean = true;
				try {
					pecEnableBoolean = Boolean.parseBoolean(PrefsPropsUtil.getString("pec.mail.session.mail.smtp.enable"));
				} catch (SystemException e1) {
					log.error(e1.getMessage(), e1);
				}
				String bodyContent = mailSenderHelper.mergeTplModelli(this.tplEmailProtocolloViaPec, model);
				
				if (pecEnableBoolean) {
					try {
						this.mailPecSenderHelper.sendMail(oggetto, bodyContent, attachments, pr.getTipologia().getMittenteMail(), new String[]{emailTo});
					} catch (Exception e) {
						log.error(e.getMessage(), e);
						esito.setCodice("002");
						esito.setDescrizione(String.format("Invio della PEC fallito! - %s", e.getMessage()));
					}
				} else {
					try {
						this.mailSenderHelper.sendMail(oggetto, bodyContent, attachments, pr.getTipologia().getMittenteMail(), new String[]{emailTo});
					} catch (Exception e) {
						log.error(e.getMessage(), e);
						esito.setCodice("003");
						esito.setDescrizione(String.format("Invio della Mail fallito! - %s", e.getMessage()));
					}
				}
			}
		}
		
		log.info("executeInviaCopiaPraticaWebViaPec...END");
		retValue.setEsito(esito);
		return retValue;
	}
	
	private PraticaWeb protocollaPratica(PraticaWeb pr, PraticaWeb praticaWeb, String nomeModello, String tplMailCortesiaName, String stato, String invioPec) throws Exception{
		boolean noAutomaticProtocol = true;
		boolean lanciareEccezione=false;
		String exceptionMessage = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		if (ServiceHelper.checkBitMask(pr.getTipologia().getConfigurazione(), ServiceHelper.AUTOMATIC_PROTOCOL)){
			if (protocolloService!=null){
				List<Ruolo> ruoliAccessoProtocollo = new ArrayList<Ruolo>();
				for(TipoPraticaTab tab:pr.getTipologia().getSchede()){
					if (tab.getTab().getId().equals(9L)){
						ruoliAccessoProtocollo.addAll(tab.getRuoliScrittura());
						log.debug(String.format("aggiunti %s ruoli: ", tab.getRuoliScrittura().size()));
					}
				}
				ProfiloUtente profiloUtenteProtocollatore = profiloUtenteService.getProfiloUtenteProtocolloByRuolo(ruoliAccessoProtocollo);
				
				
				String nomeDocumentoModello = ServiceHelper.getNomeAllegatoPraticaWeb((Long) pr.getId(), null, null,
						nomeModello, this.patternNomeAllegatoPraticaWeb);
				log.info("nome documento: "+nomeDocumentoModello);
				String nomeReplace = ServiceHelper.getNomeAllegatoPraticaWeb((Long) pr.getId(), null, null,
						nomeModello, this.patternNomeAllegatoPraticaWebToBeSaved);
				String uuidDocumentoPrincipale = null;
				
				try {
					uuidDocumentoPrincipale = CercaAllegatoInDocumentale(nomeDocumentoModello, pr.getUuidContenitore(), pr.getId());
				}
				catch (ServiceLayerException sex) {
					log.error(sex.getMessage(), sex);
					noAutomaticProtocol=false;
					lanciareEccezione=true;
					exceptionMessage="Sono presenti allegati a zero byte";
					pr.setStato(stato);
					pr.setInvioPec(invioPec);
					log.info(String.format("stato pratica: %s", pr.getStato().toString()));
					pr=praticaWebRepository.saveAndFlush(pr);
				}
				
				if (!lanciareEccezione){
					log.info(String.format("uuid documento: %s",uuidDocumentoPrincipale));
					if (profiloUtenteProtocollatore!=null)
						log.info(String.format("Utente individuato per protocollazione: %s %s",profiloUtenteProtocollatore.getNome(),profiloUtenteProtocollatore.getCognome()));
					
					byte[] contentPrincipale=null;
					DocFile documentoPrincipale = null;
					File pdfFilePrincipale = null;
					try {
						if (uuidDocumentoPrincipale!=null) {
							documentoPrincipale = this.documentaleService.download(pr.getUuidContenitore(),	uuidDocumentoPrincipale);
							contentPrincipale=documentoPrincipale.getContent();
						}else {
							pdfFilePrincipale = generaDocumentoPrincipaleContentDaModello(pr, praticaWeb, "ingresso");
							contentPrincipale=StreamUtils.getFileContent(pdfFilePrincipale);
						}
					} catch (Exception ex){
						log.error(ex.getMessage(), ex);
					}
					
					if (contentPrincipale != null) {
						noAutomaticProtocol=false;
						DatiOutputProtocollo datiOutputProtocollo = null;
						try {
							boolean inviaCopiaPraticaWebViaPec = Boolean.parseBoolean(configInviaCopiaPraticaWebViaPec);
							String nomeFileOriginal = nomeDocumentoModello.replaceAll(nomeReplace, "") + 
									                  ServiceHelper.detectExtension(contentPrincipale);
							
							datiOutputProtocollo = executeProtocolla(nomeFileOriginal, nomeModello,
	                                     profiloUtenteProtocollatore, pr, contentPrincipale);
	                                     
							if (datiOutputProtocollo.getEsito().getCodice().equals("000")){
								log.info("datiOutputProtocollo esito=000 - OK!!");
								
								if (inviaCopiaPraticaWebViaPec) {
									executeInviaCopiaPraticaWebViaPec(documentoPrincipale, nomeFileOriginal, pr);
								}
								
								// Aggiorno num e data protocollo della pratica solo se sto effettuando la protocollazione della domanda,
								// ma non per la protocollazione del ritiro.
								if ((pr.getStato().equals("P") && pr.getInvioPec().equals("S"))&&(!"P".equals(stato) && !"S".equals(invioPec))) {
									pr.setNumeroProtocollo(datiOutputProtocollo.getNumeroProtocollo());
									pr.setDataProtocollo(datiOutputProtocollo.getDataProtocollo());
									// #SA#: 12/10/2021 : per redditoEnergetico commento l'aggiornamento dello stato
									//                  : per lasciare la praticaweb in PRESENTATA...
									//pr.setStato("D");
									pr=praticaWebRepository.save(pr);
									log.info(String.format("Dati protocollo salvati: IdPratica=%s - numero protocollo: %s",	pr.getId(), datiOutputProtocollo.getNumeroProtocollo()));
								}
								
								// START INVIO DELLA MAIL....
								String emailTo1 = pr.getProfiloutente().getMail();
								String emailTo2 = getValoreCampoAggiuntivo(pr, LABEL_E_MAIL);
								String denominazione = getValoreCampoAggiuntivo(pr, LABEL_NOME_AZIENDA);
								if (emailTo1!=null) {
									Map model = new HashMap();
									String oggettoMail = pr.getOggettoRichiesta();
									model.put("denominazione", denominazione);
									model.put("numeroPratica", pr.getNumeroProtocollo());
									model.put("dataPresentazione", sdf.format(pr.getDataProtocollo()));
									model.put("newline", "</br>");

									boolean pecEnableBoolean = Boolean.parseBoolean(PrefsPropsUtil.getString("pec.mail.session.mail.smtp.enable"));
									String bodyContent = mailSenderHelper.mergeTplModelli(tplMailCortesiaName, model);
									
									if (pecEnableBoolean) {
										this.mailPecSenderHelper.sendMail(oggettoMail, bodyContent, null, pr.getTipologia().getMittenteMail(), new String[]{emailTo1, emailTo2});
									} else {
										this.mailSenderHelper.sendMail(oggettoMail, bodyContent, null, pr.getTipologia().getMittenteMail(), new String[]{emailTo1, emailTo2});
									}
								}
								
							}
							else{
								log.info(String.format("identificativo pratica: %s, errore protocollo: %s", pr.getId().toString(),datiOutputProtocollo.getEsito().getDescrizione()));
								exceptionMessage="errore in colloquio con protocollo: " + datiOutputProtocollo.getEsito().getDescrizione();
								if (!praticaWeb.isNew()) {
									pr.setStato(stato);
									pr.setInvioPec(invioPec);
									log.info(String.format("stato pratica: %s", pr.getStato().toString()));
									pr=praticaWebRepository.saveAndFlush(pr);
								}
								else {
									praticaWebRepository.delete(pr);
								}
								lanciareEccezione=true;
							}
						} catch (Exception e) {
							log.error(e.getMessage(), e);
							log.info(String.format("identificativo pratica: %s", pr.getId().toString()));
							e.printStackTrace();
							pr.setStato("");
							pr.setInvioPec(null);
							log.info(String.format("stato pratica: %s", pr.getStato().toString()));
							pr=praticaWebRepository.saveAndFlush(pr);
							lanciareEccezione=true;
							//exceptionMessage=e.getMessage();
						} finally {
							if (lanciareEccezione && exceptionMessage==null) exceptionMessage="errore in colloquio con protocollo";
						}
					}
					if (exceptionMessage!=null)throw new Exception(exceptionMessage);
				}
			}
		}
		
		return pr;
	}
	
	private PraticaWeb protocollaRitiroPratica(PraticaWeb pr, PraticaWeb praticaWeb, String stato, String invioPec) throws Exception{
		boolean noAutomaticProtocol = true;
		boolean lanciareEccezione=false;
		String exceptionMessage = null;
		if (ServiceHelper.checkBitMask(pr.getTipologia().getConfigurazione(), ServiceHelper.AUTOMATIC_PROTOCOL)){
			if (protocolloService!=null){
				List<Ruolo> ruoliAccessoProtocollo = new ArrayList<Ruolo>();
				for(TipoPraticaTab tab:pr.getTipologia().getSchede()){
					if (tab.getTab().getId().equals(9L)){
						ruoliAccessoProtocollo.addAll(tab.getRuoliScrittura());
					}
				}
				ProfiloUtente profiloUtenteProtocollatore = profiloUtenteService.getProfiloUtenteProtocolloByRuolo(ruoliAccessoProtocollo);
				if (profiloUtenteProtocollatore!=null)
				{
					String nomeDocumentoModello = ServiceHelper.getNomeAllegatoPraticaWeb((Long) pr.getId(), null, null,
							this.nomeModelloRitiro, this.patternNomeAllegatoPraticaWeb);
					log.info("nome documento: "+nomeDocumentoModello);
					String nomeReplace = ServiceHelper.getNomeAllegatoPraticaWeb((Long) pr.getId(), null, null,
							this.nomeModelloRitiro, this.patternNomeAllegatoPraticaWebToBeSaved);
					String uuidDocumento = null;
					List<DocInfo> documents = documentaleService.documentiContenuti(pr.getUuidContenitore());
					for(int i=0;i<documents.size()&&!lanciareEccezione;i++){
						log.info("allegato alfresco nome: "+documents.get(i).getFile().getNome());
						if (documents.get(i).getFile().getDimensione()==null || documents.get(i).getFile().getDimensione().equals("0")){
							noAutomaticProtocol=false;
							lanciareEccezione=true;
							exceptionMessage="Sono presenti allegati a zero byte";
							pr.setStato(stato);
							pr.setInvioPec(invioPec);
							log.info(String.format("stato pratica: %s", pr.getStato().toString()));
							pr=praticaWebRepository.saveAndFlush(pr);
						}else if(documents.get(i).getFile().getNome().startsWith(nomeDocumentoModello)){
							uuidDocumento=documents.get(i).getUuid();
							
						}
					}
					if (!lanciareEccezione){
						log.info(String.format("Utente individuato per protocollazione: %s %s",profiloUtenteProtocollatore.getNome(),profiloUtenteProtocollatore.getCognome()));
						/*uuidDocumento = this.documentaleService.ricercaInContenitore(nomeDocumentoModello, false,
								pr.getUuidContenitore());*/
						log.info(String.format("uuid documento: %s",uuidDocumento));
						byte[] contentPrincipale=null;
						if (uuidDocumento!=null) {
							DocFile documentoPrincipale = this.documentaleService.download(pr.getUuidContenitore(),
									uuidDocumento);
							contentPrincipale=documentoPrincipale.getContent();
						}else {
							Modelli modelloPraticaWeb = null;
							for(int i=0;i<pr.getTipologia().getModelli().size() && modelloPraticaWeb==null;i++){
								Modelli modello = pr.getTipologia().getModelli().get(i);
								if (modello.isWeb())
									modelloPraticaWeb=modello;
							}
							if (modelloPraticaWeb!=null) {
								String fileName = StringUtils.cleanString(modelloPraticaWeb.getNome());
								//byte[] contenuto = modello.getContenuto();		

								String mainModelloPath = this.getClass().getResource("/tplEmail/").getPath().replaceAll("%20", " ");
								fileName = fileName + DateUtils.getOggi().getTime();
								mainModelloPath+= fileName+".vm";
								StreamUtils.dumpToFile(modelloPraticaWeb.getContenuto(), mainModelloPath);
								pr.setAllegati(praticaWeb.getAllegati());
								for(AllegatiPratica allegato : pr.getAllegati()){
									if (allegato.getUuidFile()!=null && !allegato.getUuidFile().equals("")){
										byte[] content = documentaleService.download(pr.getUuidContenitore(), allegato.getUuidFile()).getContent();
										String impronta = CheckSumGenerator.generateCheckSum(content);
										allegato.setImpronta(impronta);
									}
								}
								
								HashMap<String, Object> map = pr.getPraticaAsMap();
								map.put("modalitaUtilizzo", "ingresso");
								String body = mailSenderHelper.mergeTplModelli(fileName+".vm", map);
								String rtfFileName=String.format(fileName+"."+modelloPraticaWeb.getEstensione());
								
								String pdfFileName = ServiceHelper.createDir();
								File[] attachments = null;
								File daAllegare = null;
								try {
									File f = ConverterToPdf.converterToPdf(body.getBytes(), pdfFileName, rtfFileName, hostOpenOffice, Integer.parseInt(portOpenOffice));
									contentPrincipale=StreamUtils.getFileContent(f);
								} catch (Exception e) {
									e.printStackTrace();
								}									
							}
						}
						
						if (contentPrincipale != null) {
							noAutomaticProtocol=false;
							try {
								String nomeFileOriginal = nomeDocumentoModello.replaceAll(nomeReplace, "") + ServiceHelper.detectExtension(contentPrincipale);
								DatiAutenticazione datiAutenticazione = new DatiAutenticazione();
								datiAutenticazione.setUsername(profiloUtenteProtocollatore.getUsernameProtocollo());
								datiAutenticazione.setPassword(profiloUtenteProtocollatore.getPasswordProtocollo());
								datiAutenticazione.setCodiceUfficio(profiloUtenteProtocollatore.getCodiceUfficio());
								datiAutenticazione.setIdUtente(profiloUtenteProtocollatore.getIdUtenteProtocollo());
								DatiRichiestaProtocollo datiRichiestaProtocollo = new DatiRichiestaProtocollo();
								datiRichiestaProtocollo.setTipoProtocollo("I");
								datiRichiestaProtocollo.setOggetto(pr.getOggettoRichiesta());
								AllegatoProtocollo documentoPrincipaleProtocollo = new AllegatoProtocollo();
								documentoPrincipaleProtocollo.setContenutoAllegato(contentPrincipale);
								documentoPrincipaleProtocollo.setUrlAllegato(nomeFileOriginal);
								documentoPrincipaleProtocollo.setIdAllegato(1L);
								documentoPrincipaleProtocollo.setNomeDocumento(nomeModelloRitiro);
								documentoPrincipaleProtocollo.setDaAllegareProtocollazione(true);
								datiRichiestaProtocollo.setAllegati(new ArrayList<AllegatoProtocollo>());
								datiRichiestaProtocollo.getAllegati().add(documentoPrincipaleProtocollo);
								datiRichiestaProtocollo.setDocumentoPrincipale(documentoPrincipaleProtocollo);
								datiRichiestaProtocollo.setMittenteDestinatario(new ArrayList<DatiMittenteDestinatario>());
								DatiMittenteDestinatario mittente = new DatiMittenteDestinatario();
								mittente.setAzienda(false);
								String nome=null;
								String cognome=null;
								String email=null;
								String codiceFiscale="";
								String indirizzo=null;
								String comune=null;
								if (pr.getProfiloutente()!=null) {
									email=pr.getProfiloutente().getMail();
									nome=pr.getProfiloutente().getNome();
									cognome=pr.getProfiloutente().getCognome();
									codiceFiscale=pr.getProfiloutente().getCodiceFiscale();
									if (pr.getReferente()!=null) {
										if (pr.getReferente().getComune()!=null)
											comune=pr.getReferente().getComune().getDenominazione();
										indirizzo=pr.getReferente().getIndirizzo();
									}
								}
									//URP
								for(int i=0;i<pr.getCampiaggiuntivi().size();i++) {
									if (pr.getCampiaggiuntivi().get(i).getCampiAggiuntivi().getLabel().equals("Nome") && pr.getCampiaggiuntivi().get(i).getValore()!=null && nome==null)
										nome=pr.getCampiaggiuntivi().get(i).getValore();
									else if (pr.getCampiaggiuntivi().get(i).getCampiAggiuntivi().getLabel().equals("Cognome") && pr.getCampiaggiuntivi().get(i).getValore()!=null && cognome==null)
										cognome=pr.getCampiaggiuntivi().get(i).getValore();
									else if (pr.getCampiaggiuntivi().get(i).getCampiAggiuntivi().getLabel().equals("Indirizzo") && pr.getCampiaggiuntivi().get(i).getValore()!=null && indirizzo==null)
										indirizzo=pr.getCampiaggiuntivi().get(i).getValore();
									else if (pr.getCampiaggiuntivi().get(i).getCampiAggiuntivi().getLabel().equals("Comune") && pr.getCampiaggiuntivi().get(i).getValore()!=null && comune==null)
										comune=pr.getCampiaggiuntivi().get(i).getValore();
									else if (pr.getCampiaggiuntivi().get(i).getCampiAggiuntivi().getLabel().equals("E-mail") && pr.getCampiaggiuntivi().get(i).getValore()!=null && email==null)
										email=pr.getCampiaggiuntivi().get(i).getValore();
								}
								mittente.setCognome(cognome);
								mittente.setNome(nome);
								mittente.setEmail(email);
								mittente.setCodiceFiscale(codiceFiscale);
								if (indirizzo != null && (!indirizzo.equals("")))
							          mittente.setIndirizzo(indirizzo);
							        else
							          mittente.setIndirizzo("NON DEFINITO");
						        if (comune!=null && !comune.equals(""))
						            mittente.setCitta(comune);
						          else
						            mittente.setCitta("NON DEFINITO");
								if (protocolloService.traduciMezziSpedizione()!=null && !protocolloService.traduciMezziSpedizione().isEmpty()){
									SortedMap<MezzoSpedizioneEnum, Serializable> mezziSpedizione = protocolloService.traduciMezziSpedizione();
									mittente.setMezzoSpedizione(mezziSpedizione.firstKey());
								}
								datiRichiestaProtocollo.getMittenteDestinatario().add(mittente);
								DatiOutputProtocollo datiOutputProtocollo = protocolloService.protocollaPratica(datiRichiestaProtocollo, datiAutenticazione);
								log.info(String.format("esito protocollo: %s", datiOutputProtocollo.getEsito().getCodice()));
								if (datiOutputProtocollo.getEsito().getCodice().equals("000")){
									log.info("entrato nell'if");
									// TODO: NON devo sovrascrivere il num protocollo Ordiginario della pratica...
									//pr.setNumeroProtocollo(datiOutputProtocollo.getNumeroProtocollo());
									//pr.setDataProtocollo(datiOutputProtocollo.getDataProtocollo());
									//pr.setStato("D");
									//pr=praticaWebRepository.save(pr);
									Modelli modelloPraticaWeb = null;
									for(int i=0;i<pr.getTipologia().getModelli().size() && modelloPraticaWeb==null;i++){
										Modelli modello = pr.getTipologia().getModelli().get(i);
										if (modello.isWeb())
											modelloPraticaWeb=modello;
									}
									if (modelloPraticaWeb!=null) {
										String fileName = StringUtils.cleanString(modelloPraticaWeb.getNome());
										//byte[] contenuto = modello.getContenuto();		

										String mainModelloPath = this.getClass().getResource("/tplEmail/").getPath().replaceAll("%20", " ");
										fileName = fileName + DateUtils.getOggi().getTime();
										mainModelloPath+= fileName+".vm";
										StreamUtils.dumpToFile(modelloPraticaWeb.getContenuto(), mainModelloPath);
										pr.setAllegati(praticaWeb.getAllegati());
										for(AllegatiPratica allegato : pr.getAllegati()){
											if (allegato.getUuidFile()!=null && !allegato.getUuidFile().equals("")){
												byte[] content = documentaleService.download(pr.getUuidContenitore(), allegato.getUuidFile()).getContent();
												String impronta = CheckSumGenerator.generateCheckSum(content);
												allegato.setImpronta(impronta);
											}
										}
										
										HashMap<String, Object> map = pr.getPraticaAsMap();
										map.put("modalitaUtilizzo", "uscita");
										log.debug("PraticaMap="+map.toString());

										String body = mailSenderHelper.mergeTplModelli(fileName+".vm", map);
										String rtfFileName=String.format(fileName+"."+modelloPraticaWeb.getEstensione());
										
										String pdfFileName = ServiceHelper.createDir();
										File[] attachments = null;
										File daAllegare = null;
										try {
											File f = ConverterToPdf.converterToPdf(body.getBytes(), pdfFileName, rtfFileName, hostOpenOffice, Integer.parseInt(portOpenOffice));
											attachments = new File[]{f};
											daAllegare = f;
											if (f==null || !f.exists()){
												attachments=null;
												String directory = ServiceHelper.createDir();
												daAllegare = new File(directory,rtfFileName);
												StreamUtils.dumpToFile(body.getBytes(), daAllegare.getPath());
											}
										} catch (Exception e) {
											attachments=null;
											String directory = ServiceHelper.createDir();
											daAllegare = new File(directory,rtfFileName);
											StreamUtils.dumpToFile(body.getBytes(), daAllegare.getPath());
											e.printStackTrace();
										} finally{
											if (email!=null) {
												Map model = new HashMap();
												String tipologia = pr.getTipologia().getDescrizione();
												model.put("tipodomanda", tipologia);
												model.put("nome", nome);
												model.put("cognome", cognome);
												String fileNameToBeUploaded = ServiceHelper.getNomeAllegatoPraticaWeb((Long) praticaWeb.getId(), null,
														daAllegare.getName(), this.nomeRicevuta, this.patternNomeAllegatoPraticaWeb);
												File fileToUploaded = new File(ServiceHelper.createDir(),fileNameToBeUploaded);
												FileUtils.copyFile(daAllegare, fileToUploaded);
												DocInfo docFileInfo = new DocInfo();
	
												docFileInfo.setTitolo(this.nomeModelloRitiro);
	
												docFileInfo.setFile(ServiceHelper.convertFiletoDocFile(fileToUploaded));
												this.documentaleService.uploadFile(docFileInfo, pr.getUuidContenitore());
	
												boolean pecEnableBoolean = Boolean
														.parseBoolean(PrefsPropsUtil.getString("pec.mail.session.mail.smtp.enable"));
												String bodyContent = null;
												if (attachments!=null){
													bodyContent=mailSenderHelper.mergeTplModelli(this.templateName, model);
												}else{
													bodyContent=ServiceHelper.contentToString(body.getBytes());
												}
												if (pecEnableBoolean) {
													this.mailPecSenderHelper.sendMail(tipologia, bodyContent, attachments, pr.getTipologia().getMittenteMail(), new String[]{email});
												} else {
													this.mailSenderHelper.sendMail(tipologia, bodyContent, attachments, pr.getTipologia().getMittenteMail(), new String[]{email});
												}
											}
										}
									}
								}else{
									log.info(String.format("identificativo pratica: %s, errore protocollo: %s", pr.getId().toString(),datiOutputProtocollo.getEsito().getDescrizione()));
									if (!praticaWeb.isNew()) {
										pr.setStato(stato);
										pr.setInvioPec(invioPec);
										log.info(String.format("stato pratica: %s", pr.getStato().toString()));
										pr=praticaWebRepository.saveAndFlush(pr);
									}
									else {
										praticaWebRepository.delete(pr);
									}
									lanciareEccezione=true;
								}
							} catch (Exception e) {
								log.error("eccezione:",e);
								log.info(String.format("identificativo pratica: %s", pr.getId().toString()));
								e.printStackTrace();
								pr.setStato("");
								pr.setInvioPec(null);
								log.info(String.format("stato pratica: %s", pr.getStato().toString()));
								pr=praticaWebRepository.saveAndFlush(pr);
								lanciareEccezione=true;
								exceptionMessage=e.getMessage();
							} finally {
								if (lanciareEccezione && exceptionMessage==null) exceptionMessage="errore in colloquio con protocollo";
							}
						}
					}
					if (exceptionMessage!=null)throw new Exception(exceptionMessage);
				}
			}
		}
		
		return pr;
	}
	
	
	public PraticaWeb savePratica(PraticaWeb praticaWeb)throws ServiceLayerException {
		try {
			PraticaWeb pr = null;
			NumeroPratica numPratica = null;
			if (praticaWeb.isNew()){
				numPratica = numPraticaService.getNext(praticaWeb.getTipologia().getPrefisso(), Integer.parseInt(DateUtils.getDataSenzaSlash(praticaWeb.getDataRichiesta()).substring(4)));
				praticaWeb.setNumeroPratica(numPratica.toString());
			}
			String invioPec=null;
			String stato="";
			String numeroProtocollo=null;
			Date dataProtocollo = null;
			if (!praticaWeb.isNew()){
				PraticaWeb oldPratica = praticaWebRepository.findOne(praticaWeb.getId());
				invioPec=oldPratica.getInvioPec();
				stato=oldPratica.getStato();
				numeroProtocollo=oldPratica.getNumeroProtocollo();
				dataProtocollo=oldPratica.getDataProtocollo();
			}

			if (praticaWeb.getCampiaggiuntivi()!=null){
				for (int i = 0; i < praticaWeb.getCampiaggiuntivi().size(); i++) {
					if (praticaWeb.getCampiaggiuntivi().get(i).getCampiAggiuntivi().getTipologia().equals("l") && praticaWeb.getCampiaggiuntivi().get(i).getValore()!=null && !praticaWeb.getCampiaggiuntivi().get(i).getValore().equals("")) {
						boolean found = false;
						for(int j=0;j<praticaWeb.getCampiaggiuntivi().get(i).getCampiAggiuntivi().getValori().size() && !found;j++){
							found = praticaWeb.getCampiaggiuntivi().get(i).getCampiAggiuntivi().getValori().get(j).getValore().equals(praticaWeb.getCampiaggiuntivi().get(i).getValore());
						}
						if (!found) {
							CampiAggiuntiviListaValori newValue = new CampiAggiuntiviListaValori();
							newValue.setCampiAggiuntivi(praticaWeb.getCampiaggiuntivi().get(i).getCampiAggiuntivi());
							newValue.setValore(praticaWeb.getCampiaggiuntivi().get(i).getValore());
							praticaWeb.getCampiaggiuntivi().get(i).getCampiAggiuntivi().getValori().add(newValue);
							gestioneCampiAggiuntiviService.saveCampiAggiuntivi(praticaWeb.getCampiaggiuntivi().get(i).getCampiAggiuntivi());
							praticaWeb.getCampiaggiuntivi().get(i).setCampiAggiuntivi(gestioneCampiAggiuntiviService.getCampiAggiuntiviByPk(praticaWeb.getCampiaggiuntivi().get(i).getCampiAggiuntivi().getId()));
						}
					}
					praticaWeb.getCampiaggiuntivi().get(i).setPratica(praticaWeb);
				}
			}
			if (praticaWeb.getDatiCatastali()!=null)
				for (int i = 0; i < praticaWeb.getDatiCatastali().size(); i++) {
					praticaWeb.getDatiCatastali().get(i).setPraticaWeb(praticaWeb);
				}
			if (praticaWeb.getSuperfici()!=null)
				for (int i = 0; i < praticaWeb.getSuperfici().size(); i++) {
					praticaWeb.getSuperfici().get(i).setPraticaWeb(praticaWeb);
				}
			
			if (praticaWeb.getPreventivo() != null) {
				Preventivo preventivoSaved = preventivoRepository.save(praticaWeb.getPreventivo());
				praticaWeb.setPreventivo(preventivoSaved);
			}
			
			pr = praticaWebRepository.save(praticaWeb);
			if (numPratica!=null)
				numPraticaService.save(numPratica);
			
			if (pr.isConsuntivo()) {
				if (pr.getFascicoliCorrelati() != null) {
					PraticaWeb prCorrelata = pr.getFascicoliCorrelati().get(0);
					
					if (prCorrelata != null) {
						if (prCorrelata.getFascicoliCorrelati() == null)
							prCorrelata.setFascicoliCorrelati(new ArrayList<PraticaWeb>());
						
						if (prCorrelata.getFascicoliCorrelati().size() == 0) {
							prCorrelata.getFascicoliCorrelati().add(praticaWeb);						
							praticaWebRepository.save(prCorrelata);
						}
					}
				}
			}
			
			if(praticaWeb.getUuidContenitore() == null || praticaWeb.getUuidContenitore().equals("")){
				log.debug("cerco il contenitore");

				String pathToBeCreated = destContenitoreRichiestePratiche.replace("%separatore", CategoriePratiche.SEPARATORE).replace("%idPratica", pr.getId()+"");
				String uuid = documentaleService.creaContenitore(pathToBeCreated, CategoriePratiche.SEPARATORE, pr.getOggettoRichiesta());

				pr.setUuidContenitore(uuid);
				pr = praticaWebRepository.save(pr);
			}
			
			if(praticaWeb.getAllegati() != null && !praticaWeb.getAllegati().isEmpty())
			{
				log.debug(String.format("nr di allegati inviati:%d", praticaWeb.getAllegati().size()));
				for(int j=0; j < praticaWeb.getAllegati().size(); j++){
					AllegatiPratica allegato = praticaWeb.getAllegati().get(j);
					if(allegato.getAllegato() != null){
						if(!praticaWeb.isNew() && allegato.getUuidFile() != null && !allegato.getUuidFile().equals("")){
							log.debug("elimino il nodo con uuid="+allegato.getUuidFile());
							documentaleService.eliminaFile(allegato.getUuidFile());
							log.debug("allegato trovato");
							allegato.setUrlAllegato("");
							allegato.setUuidFile(null);
							allegato.setNomeFile(null);
						}			
						log.debug("allegato != null. nome allegato ="+allegato.getAllegato().getName());
						String fileToBeUploadName = ServiceHelper.getNomeAllegatoPraticaWeb(praticaWeb.getId(), allegato.getAllegati().getId(), allegato.getAllegato().getName(), allegato.getAllegati().getNomeDocumento(), patternNomeAllegatoPraticaWeb);
						File fileToBeUpload = new File(ServiceHelper.createDir()+fileToBeUploadName);
						FileUtils.copyFile(allegato.getAllegato(),fileToBeUpload);
						
						DocInfo docFileInfo = new DocInfo();
						//#SA# : Per alfresco Titolo, Note e Creator non servono.
						//       Per Diogene da verificare se sono necessari e se bastano.
						docFileInfo.setTitolo(allegato.getAllegati().getNomeDocumento());
						//docFileInfo.setNote(allegato.);
						//docFileInfo.setCreator(_creator);
						docFileInfo.setFile(ServiceHelper.convertFiletoDocFile(fileToBeUpload));
						String uuidAllegato = documentaleService.uploadFile(docFileInfo, praticaWeb.getUuidContenitore()).getUuid();
						
						//PER IL MOMENTO CANCELLO IL FILE ORIGINALE E LASCIO QUELLO CON IL NOME LEGATO ALL'ID DELLA PRATICA
						//log.debug("cancello il file ="+fileToBeUpload.getAbsolutePath());
						boolean canc = ServiceHelper.deleteFile(fileToBeUpload);
						log.debug("file cancellato="+canc);						
						//boolean canc1 = allegato.getAllegato().delete();
						boolean canc1 = ServiceHelper.deleteFile(allegato.getAllegato());
						log.debug("file cancellato="+canc1);
					}
				}
			}
			if (praticaWeb.getCampiaggiuntivi()!=null){
				for(int j=0; j < praticaWeb.getCampiaggiuntivi().size(); j++){
					CampiAggiuntiviPraticaWeb ca = praticaWeb.getCampiaggiuntivi().get(j);
					if(ca.getCampiAggiuntivi().getTipologia().equals("i") && ca.getAllegato() != null){
						if(!praticaWeb.isNew() && ca.getUuidFile() != null && !ca.getUuidFile().equals("")){
							log.debug("elimino il nodo con uuid="+ca.getUuidFile());
							documentaleService.eliminaFile(ca.getUuidFile());
							log.debug("allegato trovato");
							ca.setUuidFile(null);
							ca.setNomeFile(null);
						}						
						log.debug("doc ="+ca.getAllegato().getName());
						log.debug("allegato != null");
						String ext=ca.getAllegato().getName().substring(ca.getAllegato().getName().lastIndexOf("."));
						String fileToBeUploadName = praticaWeb.getId()+"_"+ca.getCampiAggiuntivi().getLabel()+ext;
						File fileToBeUpload = new File(ServiceHelper.createDir()+fileToBeUploadName);
						FileUtils.copyFile(ca.getAllegato(),fileToBeUpload);
						//ca.getAllegato().transferTo(fileToBeUpload);
						DocInfo docFileInfo = new DocInfo();
						//#SA# : Per alfresco Titolo, Note e Creator non servono.
						//       Per Diogene da verificare se sono necessari e se bastano.
						docFileInfo.setTitolo(ca.getCampiAggiuntivi().getLabel());
						//docFileInfo.setNote(allegato.);
						//docFileInfo.setCreator(_creator);
						docFileInfo.setFile(ServiceHelper.convertFiletoDocFile(fileToBeUpload));
						String uuidFileCA = documentaleService.uploadFile(docFileInfo, praticaWeb.getUuidContenitore()).getUuid();

						boolean canc = ServiceHelper.deleteFile(fileToBeUpload);
						log.debug("file cancellato="+canc);
						
						// pr.getCampiaggiuntivi().get(j).setValore(doc);
						pr.getCampiaggiuntivi().get(j).setUuidFile(uuidFileCA);
						pr.getCampiaggiuntivi().get(j).setNomeFile(ca.getAllegato().getName());
						campiAggPraticaRepository.save(pr.getCampiaggiuntivi().get(j));
					}
				}
			}
			
			/* 19_05_2022 : In sede di COLLAUDO con la dirigente Angela Cistulli, valentino Silvestris e Francesco Manghisi di decide di:
			 *              non inviare le notifiche al cambio stato della pratica web se non quando questa viene inviata a Regione!!!*/
			if (("B".equals(stato))&&pr.getStato().equals("E")) {
				// Passaggio da BOZZA in CONSOLIDATA
				String denominazione = getValoreCampoAggiuntivo(pr, LABEL_DENOM_BENEFICIARIO);
				String emailTo = getValoreCampoAggiuntivo(pr, "E-mail");
				String[] destinatari = new String[]{emailTo};
				//sendNotificationMailCambioStato(pr, denominazione, destinatari);
				pr.setMotivo_rifiuto("");
				pr = praticaWebRepository.save(pr);
			}
			
			if ((("E".equals(stato))&&pr.getStato().equals("B")) ||
					(("E".equals(stato))&&pr.getStato().equals("V"))){
				// Passaggio da CONSOLIDATA in BOZZA o da CONSOLIDATA in CONVALIDATA
				String denominazione = String.format("%s referente interno per la procedura di Reddito Energetico Regionale per la ditta %s", 
						getValoreCampoAggiuntivo(pr, "Il sottoscritto"), getValoreCampoAggiuntivo(pr, "della Ditta/Impresa"));
				String emailTo = pr.getProfiloutente().getMail();
				String[] destinatari = new String[]{emailTo};
				//sendNotificationMailCambioStato(pr, denominazione, destinatari);
			}
			
			if ((pr.getStato().equals("P") && pr.getInvioPec().equals("S"))&&(!"P".equals(stato) && !"S".equals(invioPec))) {
				pr=protocollaPratica(pr, praticaWeb, nomeModello, templateName, stato, invioPec);
			}
			
			if ((pr.getStato().equals("I") && pr.getInvioPec().equals("S"))&&(!"I".equals(stato))) {
				pr=protocollaPratica(pr, praticaWeb, nomeModelloRitiro, tplEmailRitiroName, stato, invioPec);
			}
			
			return pr;
			
		} catch (Exception e) {
			throw new ServiceLayerException("Errore in fase di salvataggio pratica :: " + e.getMessage(), e);
		}
	}
	
	private void sendNotificationMailCambioStato(PraticaWeb pr, String denominazione, String[] destinatari) throws Exception {
		// START INVIO DELLA MAIL....
		
		if (destinatari!=null) {
			String oggettoMail = pr.getOggettoRichiesta();
			Map model = new HashMap();
			model.put("denominazione", denominazione);
			model.put("numeroPratica", pr.getNumeroPratica());
			model.put("oggettoPratica", oggettoMail);
			
			model.put("newline", "</br>");

			boolean pecEnableBoolean = Boolean.parseBoolean(PrefsPropsUtil.getString("pec.mail.session.mail.smtp.enable"));
			String bodyContent = mailSenderHelper.mergeTplModelli(tplEmailNotificaCambioStato, model);
			
			if (pecEnableBoolean) {
				this.mailPecSenderHelper.sendMail(oggettoMail, bodyContent, null, pr.getTipologia().getMittenteMail(), destinatari);
			} else {
				this.mailSenderHelper.sendMail(oggettoMail, bodyContent, null, pr.getTipologia().getMittenteMail(), destinatari);
			}
		}
	}
	
	public List<PraticaWeb> searchPraticheWeb(ProfiloUtente profiloutente ){
		if (profiloutente!=null){
			return praticaWebRepository.findByProfiloutenteOrderByDataRichiestaDesc(profiloutente);
		}
		else
			return null;
	}
	
	public ElencoPraticheWeb searchPraticheWebBackend(ProfiloUtente profiloUtente,DatiRicercaPraticaWeb filtri){
		ElencoPraticheWeb elencoPraticheWeb = new ElencoPraticheWeb();
		List<PraticaWeb> result = null;
		List<PraticaWebExtended> listPraticheWebExtended = new ArrayList<PraticaWebExtended>();
		// Query JPA..
//		String queryString ="select distinct Pr "
//				+ "from PraticaWeb pr LEFT OUTER JOIN pr.tipologia.categoria.ruolo ru "
//				+ "where ru.id = ?1 and pr.stato = ?2 "
//				+ "order by pr.dataRichiesta DESC,pr.id DESC";
		
//		Query query = em.createQuery(queryString, PraticaWeb.class);
//		query.setParameter(1, profiloUtente.getRuolo().getId());
		
		// Query Nativa...
		String queryString ="select distinct pr.* from tb_praticaweb pr "
				+ "inner join tb_tipopratica tp on pr.fk_tipologia = tp.id "
				+ "inner join tb_categorie_pratiche cat on tp.fk_categoria = cat.id "
				+ "inner join tb_ruoli_categorie rolecat on rolecat.categoria_id = cat.id "
				+ "inner join tb_profilo_ruolo roleprof on roleprof.fk_ruolo = rolecat.ruolo_id "
				+ "where roleprof.fk_profilo = ?1 and pr.stato = ?2 "
				+ "order by pr.data_protocollo ASC, pr.numero_protocollo ASC";
		
		Query query = em.createNativeQuery(queryString, PraticaWeb.class);
		query.setParameter(1, profiloUtente.getId());
		
		
		query.setParameter(2, filtri.getStatopratica());
		result=query.getResultList();
		for (PraticaWeb pW : result) {
			PraticaWebExtended nuovaPW = new PraticaWebExtended();
			BeanUtils.copyProperties(pW, nuovaPW);
			listPraticheWebExtended.add(nuovaPW);
		}
		
		elencoPraticheWeb.setElencoPraticheWeb(listPraticheWebExtended);
		return elencoPraticheWeb;
	}
	
	public ElencoPraticheWeb searchPraticheWebBackendInviate(ProfiloUtente profiloUtente,DatiRicercaPraticaWeb filtri){
		ElencoPraticheWeb elencoPraticheWeb = new ElencoPraticheWeb();
		List<PraticaWeb> result = null;
		List<PraticaWebExtended> listPraticheWebExtended = new ArrayList<PraticaWebExtended>();
		
//		String queryString ="select distinct Pr "
//				+ "from PraticaWeb pr "
//				+ "LEFT OUTER JOIN pr.tipologia.categoria.ruolo ru "
//				+ "LEFT OUTER JOIN ru.utenti ut "
//				+ "where ut.id = ?1 and (pr.invioPec = 'S' or pr.invioPec = 's') and pr.stato = ?2 "
//				+ "order by pr.dataRichiesta DESC,pr.id DESC";
//		Query query = em.createQuery(queryString, PraticaWeb.class);
//		query.setParameter(1, profiloUtente.getId());
//		query.setParameter(2, filtri.getStatopratica());
//		result=query.getResultList();
		
		// Query Nativa
		String queryString ="select distinct pr.* from tb_praticaweb pr "
				+ "inner join tb_tipopratica tp on pr.fk_tipologia = tp.id "
				+ "inner join tb_categorie_pratiche cat on tp.fk_categoria = cat.id "
				+ "inner join tb_ruoli_categorie rolecat on rolecat.categoria_id = cat.id "
				+ "inner join tb_profilo_ruolo roleprof on roleprof.fk_ruolo = rolecat.ruolo_id "
				+ "where roleprof.fk_profilo = ?1 and pr.stato = ?2 and pr.invio_pec=?3 "
				+ "order by pr.data_protocollo ASC, pr.numero_protocollo ASC";
		
		Query query = em.createNativeQuery(queryString, PraticaWeb.class);
		query.setParameter(1, profiloUtente.getId());
		query.setParameter(2, filtri.getStatopratica());
		query.setParameter(3, "S");
		result=query.getResultList();
		for (PraticaWeb pW : result) {
			PraticaWebExtended nuovaPW = new PraticaWebExtended();
			BeanUtils.copyProperties(pW, nuovaPW);
			listPraticheWebExtended.add(nuovaPW);
		}
		elencoPraticheWeb.setElencoPraticheWeb(listPraticheWebExtended);
		return elencoPraticheWeb;
	}
	
	public List<PraticaWeb> searchPraticheWeb() {
		return praticaWebRepository.findAll(new Sort(Direction.DESC, "dataRichiesta"));
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * it.osapulie.service.PraticaService#processaUploadPratica(it.sincon.gepred.domain
	 * .Pratica)
	 */
	
	public List<PraticaWeb> praticheSelezionate(ElencoPraticheWeb elenco) {
		log.debug("documentiSelezionati :: Entering Method");

		List<PraticaWeb> result = new ArrayList<PraticaWeb>();

		for (PraticaWebExtended doc : elenco.getElencoPraticheWeb()) {
			log.info("ID " +doc.getId());
			log.info("CHECKED " +doc.isChecked());
			if (doc.isChecked()) {
				PraticaWeb document = new PraticaWeb();
				String[] ignoreParams = {"checked"};
				BeanUtils.copyProperties(doc, document, ignoreParams);
				/*document.setTitolo(doc.getTitolo());
				document.setTipoProtocollo(doc.getTipoProtocollo());
				document.setDataProtocollo(doc.getDataProtocollo());
				document.setNumeroProtocollo(doc.getNumeroProtocollo());
				document.setUuid(doc.getUuid());*/
				result.add(document);
			}
		}

		return result;
	}
	
	public List<ProfiloUtente> getRemainingProfiliUtente(PraticaWeb pratica) {
		List<ProfiloUtente> result = null;
		if (pratica!=null && pratica.getTipologia()!=null)
		{
			result = profiloUtenteService.getAllProfiloUtenteByRuolo(pratica.getTipologia().getCategoria().getRuolo());
			if (pratica.getAssegnatari()!=null)
			{
				for(int i=0;i<pratica.getAssegnatari().size();i++)
				{
					boolean found = false;
					for(int j=0;j<result.size() && !found;j++)
					{
						if (result.get(j).getId().equals(pratica.getAssegnatari().get(i).getId()))
						{
							found=true;
							result.remove(j);
						}
					}
				}
			}
		}
		return result;
	}
	
	public String processaUploadPratica(String tipologia, String fileName, byte[] content, ProfiloUtente profiloUtente,String idPratica, String uuidContenitorePratica) throws ServiceLayerException,Exception{
		
		PraticaWeb pratica = praticaWebRepository.findOne(Long.parseLong(idPratica));
		Map<String, String> model = new HashMap<String, String>();
		model.put("tipodomanda", tipologia);
		model.put("nome", pratica.getRichNome());
		model.put("cognome", pratica.getRichCognome());
		model.put("codiceFiscale", profiloUtente.getCodiceFiscale());
		String uuidUploadedFile = null;
		try {			
			if(content != null){
//				File file = StreamUtils.dumpToFile(content, ServiceHelper.createDir()+fileName);
//				File file = new File(ServiceHelper.createDir()+fileName);
//				FileOutputStream output = new FileOutputStream(file);
//				output.write(content);
//				output.close();
				
//				//09-12-2014 COMMENTATO PERCHè COSIMO DICE CHE NON HA SENSO INVIARE LA MAIL ALLA PEC DEL COMUNE VISTO CHE IL COMUNE HA GIà LA RICHIESTA DI PRATICA NEL BACK-OFFICE
//				//mailPecSenderHelper.sendConfirmationEmail(tipologia, templateName, file, model);
				Long idAllegato = null;
				try {
					for (Allegati at : pratica.getTipologia().getAllegati()) {
						if (at.getNomeDocumento().equals(nomeModello))
							idAllegato = at.getId();
					}
				} catch (Exception e) {
					log.error(e.getMessage(), e);
				}
				
				String fileToBeUploadName = ServiceHelper.getNomeAllegatoPraticaWeb(pratica.getId(), idAllegato, fileName, nomeModello, patternNomeAllegatoPraticaWeb);
				
				File fileToBeUpload = StreamUtils.dumpToFile(content, ServiceHelper.createDir()+fileToBeUploadName);
//				File fileToBeUpload = new File(ServiceHelper.createDir()+fileToBeUploadName);
//				file.renameTo(fileToBeUpload);		
				
				DocInfo docFileInfo = new DocInfo();
				//#SA# : Per alfresco Titolo, Note e Creator non servono.
				//       Per Diogene da verificare se sono necessari e se bastano.
				docFileInfo.setTitolo(tipologia);
				//docFileInfo.setNote(allegato.);
				//docFileInfo.setCreator(_creator);
				docFileInfo.setFile(ServiceHelper.convertFiletoDocFile(fileToBeUpload));
				uuidUploadedFile = documentaleService.uploadFile(docFileInfo, uuidContenitorePratica).getUuid();
				log.debug("uuid uploadedfile="+uuidUploadedFile);
				
				//boolean canc = file.delete();
				boolean canc1 = ServiceHelper.deleteFile(fileToBeUpload);
				
				log.debug("file cancellato="+canc1);
			}else{
				DocFile doc = documentaleService.download(uuidContenitorePratica, fileName);
				File file = new File(fileName);
				FileOutputStream output = new FileOutputStream(file);
				output.write(doc.getContent());
				output.close();
				//09-12-2014 COMMENTATO PERCHè COSIMO DICE CHE NON HA SENSO INVIARE LA MAIL ALLA PEC DEL COMUNE VISTO CHE IL COMUNE HA GIà LA RICHIESTA DI PRATICA NEL BACK-OFFICE
//				//mailPecSenderHelper.sendConfirmationEmail(tipologia, templateName, file, model);
				
				boolean canc = file.delete();
				log.debug("file cancellato="+canc);
			}
			
			return uuidUploadedFile;
		}
		catch(Exception e){
			log.error("processaUploadDichiarazioni :: " + e.getMessage(), e);
			throw new IOException("processaUploadDichiarazioni :: Errore durante l'invio della PEC mail" , e);
		}
		
	}
	
public String processaUploadRitiroPratica(String tipologia, String fileName, byte[] content, ProfiloUtente profiloUtente,String idPratica, String uuidContenitorePratica) throws ServiceLayerException,Exception{
		
		PraticaWeb pratica = praticaWebRepository.findOne(Long.parseLong(idPratica));
		Map<String, String> model = new HashMap<String, String>();
		model.put("tipodomanda", tipologia);
		model.put("nome", pratica.getRichNome());
		model.put("cognome", pratica.getRichCognome());
		model.put("codiceFiscale", profiloUtente.getCodiceFiscale());
		String uuidUploadedFile = null;
		try {			
			if(content != null){
				Long idAllegato = null;
				try {
					for (Allegati at : pratica.getTipologia().getAllegati()) {
						if (at.getNomeDocumento().equals(nomeModelloRitiro))
							idAllegato = at.getId();
					}
				} catch (Exception e) {
					log.error(e.getMessage(), e);
				}
				
				String fileToBeUploadName = ServiceHelper.getNomeAllegatoPraticaWeb(pratica.getId(), idAllegato, fileName, nomeModelloRitiro, patternNomeAllegatoPraticaWeb);
				
				File fileToBeUpload = StreamUtils.dumpToFile(content, ServiceHelper.createDir()+fileToBeUploadName);
				
				DocInfo docFileInfo = new DocInfo();
				//#SA# : Per alfresco Titolo, Note e Creator non servono.
				//       Per Diogene da verificare se sono necessari e se bastano.
				docFileInfo.setTitolo(tipologia);
				//docFileInfo.setNote(allegato.);
				//docFileInfo.setCreator(_creator);
				docFileInfo.setFile(ServiceHelper.convertFiletoDocFile(fileToBeUpload));
				uuidUploadedFile = documentaleService.uploadFile(docFileInfo, uuidContenitorePratica).getUuid();
				log.debug("uuid uploadedfile="+uuidUploadedFile);
				
				//boolean canc = file.delete();
				boolean canc1 = ServiceHelper.deleteFile(fileToBeUpload);
				
				log.debug("file cancellato="+canc1);
			}else{
				DocFile doc = documentaleService.download(uuidContenitorePratica, fileName);
				File file = new File(fileName);
				FileOutputStream output = new FileOutputStream(file);
				output.write(doc.getContent());
				output.close();
				
				boolean canc = file.delete();
				log.debug("file cancellato="+canc);
			}
			
			return uuidUploadedFile;
		}
		catch(Exception e){
			log.error("processaUploadDichiarazioni :: " + e.getMessage(), e);
			throw new IOException("processaUploadDichiarazioni :: Errore durante l'invio della PEC mail" , e);
		}
		
	}

	public byte[] downloadDocumento(String uuidContenitore,String uuidDocumento) throws ServiceLayerException
	{
		byte[] result = null;

		try{							
			result = documentaleService.download(uuidContenitore, uuidDocumento).getContent();
		}catch (Exception e) {
			throw new ServiceLayerException(
					"There was an error when upload an object of type File :: "
							+ e.getMessage(), e);
		}
		return result;
	}
	
	public List<TipoPratica> searchTipoPraticheFrontEnd() {
		log.debug("searchTipoPraticheFrontEnd:: entering method");
		
		return gestioneTipoPraticheService.getTipoPraticaByFrontend();
	}
	
	public List<TipoPratica> searchTipoPraticheFrontEnd(CategoriePratiche categoria) {
		log.debug(String.format("searchTipoPraticheFrontEnd:: Categoria::%s - entering method", categoria.getDescr()));
		
		return gestioneTipoPraticheService.getTipoPraticaByCategoriaAndFrontend(categoria);
	}

	public List<Comune> searchComuni() {
		log.debug("searchComuni:: entering method");
		
		return (List<Comune>) comuneRepository.findAll();
	}

	public List<TipoImmobile> searchTipoImmobile() {
		log.debug("searchTipoImmobile :: entering method");
		
		return tipoImmobileRepository.findAll();
	}
	
	public List<StatoPratica> searchStatoPratica() {
		log.debug("searchStatoPratica :: entering method");
		
		return statoPraticaRepository.findAll();
	}
	
	public Referente getReferenteByPk(long pk) {
		log.debug("getReferenteByPk :: entering method");
		
		return gestioneReferenteService.getReferenteByPk(pk);
	}
	
	public List<Allegati> searchAllegatiTipoPratica(TipoPratica tipologia) {
		log.debug("searchAllegatiTipoPratica :: entering method");
		
		return allegatiRepository.findByTipoPratica(tipologia);
	}
	
	public TipoPratica getTipoPraticaByPk(long pk) {
		log.debug("getTipoPraticaByPk :: entering method");
		
		return gestioneTipoPraticheService.getTipoPraticaByPk(pk);
	}
	
	public Comune getComuneByPk(long pk) {
		log.debug("getComuneByPk :: entering method");
		
		return comuneRepository.findOne(pk);
	}
	
	public TipoImmobile getTipoImmobileByPk(long pk) {
		log.debug("getTipoImmobileByPk :: entering method");
		
		return tipoImmobileRepository.findOne(pk);
	}
	
	public ArrayList<DocInfo> documentiContenuti(String uuidContenitore) {
		log.debug("documentiContenuti :: entering method");
		
		try {
			return documentaleService.documentiContenuti(uuidContenitore);
		} catch (DocumentaleException e) {
			log.error("ERRORE: " + e.getLocalizedMessage());
			return null;
		}
	}
	
	public Boolean eliminaDocumento(String uuidFile) {
		log.debug("eliminaDocumento :: entering method");
		Boolean res = true;
		try {
			documentaleService.eliminaFile(uuidFile);
			
		} catch (DocumentaleException e) {
			log.error("ERRORE: " + e.getLocalizedMessage());
			res = false;
		}
		return res;
	}
	
	/**
	 * Recupera il valore di uno specifico campo aggiuntivo per la pratica pr. 
	 * 
	 * @param pr
	 * @param labelCampoAggiuntivo
	 * @return Restituisce il valore contenuto nel campo aggiuntivo della pratica pr la cui label 
	 * 		   è pari a labelCampoAggiuntivo, null se il campo aggiuntivo non esiste. 
	 */
	public String getValoreCampoAggiuntivo(PraticaWeb pr, String labelCampoAggiuntivo){
		String retValue = null;
		
		CampiAggiuntiviPraticaWeb ca_pr = getCampoAggiuntivo(pr, labelCampoAggiuntivo);
		if (ca_pr != null)
			retValue = ca_pr.getValore();
		
		return retValue;
	}
	
	/**
	 * Recupera uno specifico campo aggiuntivo per la pratica pr. 
	 * 
	 * @param pr
	 * @param labelCampoAggiuntivo
	 * @return Restituisce il valore contenuto nel campo aggiuntivo della pratica pr la cui label 
	 * 		   è pari a labelCampoAggiuntivo, null se il campo aggiuntivo non esiste. 
	 */
	public CampiAggiuntiviPraticaWeb getCampoAggiuntivo(PraticaWeb pr, String labelCampoAggiuntivo){
		CampiAggiuntiviPraticaWeb retValue = null;
		
		try {
			if (pr.getCampiaggiuntivi() != null) {
				for (CampiAggiuntiviPraticaWeb ca_pr : pr.getCampiaggiuntivi()){
					if (ca_pr.getCampiAggiuntivi().getLabel() != null) {
						if (ca_pr.getCampiAggiuntivi().getLabel().toLowerCase().equalsIgnoreCase(labelCampoAggiuntivo.toLowerCase()))
							retValue = ca_pr;
					}
				}
			}
		} catch (Exception exp) {
			log.error(exp.getMessage(), exp);
		}
		
		return retValue;
	}
	
	/**
	 * Imposta il valore di uno specifico campo aggiuntivo per la pratica pr. 
	 * @param pr
	 * @param labelCampoAggiuntivo
	 * @param newValue
	 */
	public void setValoreCampoAggiuntivo(PraticaWeb pr, String labelCampoAggiuntivo, String newValue){
		
		CampiAggiuntiviPraticaWeb ca_pr = getCampoAggiuntivo(pr, labelCampoAggiuntivo);
		if (ca_pr != null)
			ca_pr.setValore(newValue);
	}

	@Override
	public void deletePraticaWeb(Long idPratica)
			throws ServiceLayerException {
		praticaWebRepository.delete(idPratica);
		
	}

	public RappresentanteLegale rimuoviAllegatoB(RappresentanteLegale entity)throws ServiceLayerException {
		
		try {
			documentaleService.eliminaFile(entity.getUuidAllegatoB());
			
			entity.setUuidAllegatoB(null);
			entity.setNomeFileAllegatoB(null);
			entity.setImprontaAllegatoB(null);
			
			return rappresentanteLegaleRepository.save(entity);
		} catch (Exception e) {
			throw new ServiceLayerException(
					"There was an error when saving an object of type Pratica :: "
							+ e.getMessage(), e);
		}
	}
	
	public List<PraticaWeb> searchPraticheWebByValoreCampAgg(String caLabel, String caValore ){
		log.debug("searchPraticheWebByValoreCampAgg :: entering method");
		
		
		String queryString = "select DISTINCT pr from PraticaWeb pr "
				+ "LEFT OUTER JOIN pr.campiaggiuntivi ca_web "
				+ "LEFT OUTER JOIN ca_web.campiAggiuntivi ca "
				+ "WHERE pr.stato = ?1"
				+ " AND ca.label = ?2 "
				+ " AND ca_web.valore = ?3";
				
		
		/*String queryString = "SELECT * FROM tb_praticaweb pr "
				+ "INNER JOIN tb_ca_praticaweb ca_web ON pr.ID = ca_web.fk_pratica "
				+ "INNER JOIN tb_campiaggiuntivi ca ON ca.ID = ca_web.fk_campiaggiuntivi "
				+ "WHERE pr.stato = ?1 "
				+ "AND ca.label = ?2 "
				+ "AND ca_web.valore = ?3";*/
		
		//Query query = em.createNativeQuery(queryString, PraticaWeb.class);
		Query query = em.createQuery(queryString, PraticaWeb.class);
		
		query.setParameter(1, "P");
		query.setParameter(2, caLabel);
		query.setParameter(3, caValore);
		
		return (List<PraticaWeb>) query.getResultList();
	}

	public List<PraticaWeb> searchPraticheWebPresentateByTitolare(String titolare ){
		log.debug("searchPraticheWebByTitolare :: entering method");
		
		
		String queryString = "select DISTINCT pr from PraticaWeb pr "
				+ "WHERE (pr.stato = ?1 or pr.stato = ?2) "
				+ " AND pr.titolare = ?3";
				
		Query query = em.createQuery(queryString, PraticaWeb.class);
		
		query.setParameter(1, "P");
		query.setParameter(2, "V");
		query.setParameter(3, titolare.toUpperCase());
		
		return (List<PraticaWeb>) query.getResultList();
	}
	
	public List<PraticaWeb> searchPraticheWebByTitolare(String titolare ){
		log.debug("searchPraticheWebByTitolare :: entering method");
		
		
		String queryString = "select DISTINCT pr from PraticaWeb pr "
				+ "LEFT OUTER JOIN pr.fascicoliCorrelati pr_corr "
				+ "WHERE pr.titolare = ?1";
				
		Query query = em.createQuery(queryString, PraticaWeb.class);
		
		query.setParameter(1, titolare.toUpperCase());
		
		return (List<PraticaWeb>) query.getResultList();
	}

	@Override
	public List<PraticaWeb> searchPraticheWebByImpresa(String partitaIva) {
		log.debug("searchPraticheWebByImpresa :: entering method");
		
		String queryString = "select DISTINCT pr from PraticaWeb pr "
				+ "LEFT OUTER JOIN pr.fascicoliCorrelati pr_corr "
				+ "WHERE pr.impresa = ?1";
				
		Query query = em.createQuery(queryString, PraticaWeb.class);
		
		query.setParameter(1, partitaIva.toUpperCase());
		
		return (List<PraticaWeb>) query.getResultList();
	}
	
	@Override
	public List<PraticaWeb> searchPraticheWebByImpresaAndTitolare(String partitaIva, String titolare, String stato) {
		log.debug("searchPraticheWebByImpresa :: entering method");
		
		String queryString = "select DISTINCT pr from PraticaWeb pr "
				+ "WHERE pr.impresa = ?1 and pr.titolare = ?2";
		if (stato != null) {
			if (!stato.trim().isEmpty())
				queryString += " and pr.stato = ?3";
		}
				
		Query query = em.createQuery(queryString, PraticaWeb.class);
		
		query.setParameter(1, partitaIva.toUpperCase());
		query.setParameter(2, titolare.toUpperCase());
		if (stato != null) {
			if (!stato.trim().isEmpty())
				query.setParameter(3, stato.toUpperCase());
		}
		
		return (List<PraticaWeb>) query.getResultList();
	}
	
	private void calcolaPerc(PraticaWeb entity, String labelVal, String labelValTot, String labelValPerc) {
		log.debug(String.format("calcolaPerc: %s - %s - %s", labelVal, labelValTot, labelValPerc));
		
		try {
			CampiAggiuntiviPraticaWeb ca_val = getCampoAggiuntivo(entity, labelVal);
			CampiAggiuntiviPraticaWeb ca_ValTot = getCampoAggiuntivo(entity, labelValTot);
			double val = Double.parseDouble(ca_val.getValore());
			double valTot = Double.parseDouble(ca_ValTot.getValore());
			double valPerc = ( val / valTot ) * 100;
			setValoreCampoAggiuntivo(entity, labelValPerc, String.format("%.2f%%",valPerc));
			
		} catch (Exception ex) {
			log.error("calcolaPerc :: " + ex.getMessage(), ex);
			setValoreCampoAggiuntivo(entity, labelValPerc, "");
		}
	}
	
	private boolean isIstanzaCondominio(PraticaWeb pratica) {
		return pratica.getTipologia().getCategoria().getNomeCompletoCategoria().toLowerCase().contains("categoria c");
	}

	@Override
	public PraticaWeb valorizzaCampiCalcolati(PraticaWeb pratica) throws ServiceLayerException {
		try {
			
			// Salvo il cod fiscale del sottoscrittore nel campo tecnico...
			try {
				String sottoscrittore = getValoreCampoAggiuntivo(pratica, LABEL_SOTTOSCRITTORE);
				String cfSottocrittore =  sottoscrittore.split("-")[1].trim();
				pratica.setTecnico(cfSottocrittore);
			} catch (Exception ex) {
				log.error("calcolaPercentuali :: " + ex.getMessage(), ex);
			}
			
			if (isIstanzaCondominio(pratica)) {
				try {
					calcolaPerc(pratica, LABEL_SUP_LORDA_PAV, LABEL_SUP_LORDA_PAV_TOT, LABEL_PERC_SUP_LORDA_PAV);
				} catch (Exception ex) {
					log.error("calcolaPercentuali :: " + ex.getMessage(), ex);
				}
				
				try {
					calcolaPerc(pratica, LABEL_UNITA_ABIBATIVE, LABEL_UNITA_ABIBATIVE_TOT, LABEL_PERC_UNITA_ABIBATIVE);
				} catch (Exception ex) {
					log.error("calcolaPercentuali :: " + ex.getMessage(), ex);
				}
			}	
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
		}
		
		return pratica;
	}

	@Override
	public int calcolaPunteggio(PraticaWeb pratica) throws ServiceLayerException {
		int punteggioIstanza = 0;
		if(pratica.getCampiaggiuntivi()!= null && pratica.getCampiaggiuntivi().size()>0)
		{
			for (CampiAggiuntiviPraticaWeb ca_web : pratica.getCampiaggiuntivi()) {
				punteggioIstanza += CalcolaPunteggioUtils.getPunteggioCampoAggiuntivo(ca_web.getCampiAggiuntivi(), ca_web.getValore());
			}
		}
		
		if (pratica.getPreventivo() != null) {
			punteggioIstanza += CalcolaPunteggioUtils.getPunteggioPreventivo(pratica.getPreventivo());
		}
		
		return punteggioIstanza;
	}

	@Override
	/**
	 * E' possibile consolidare una domanda solo se non esiste nessuna altra domanda ne in stato PRESENTATA ne in stato VALIDATA
	 * per questo titolare
	 */
	public boolean isConsolidaPossibile(PraticaWeb praticaWeb) {
		boolean retValue = true;
		
		try {
			List<PraticaWeb> prPresentate = searchPraticheWebPresentateByTitolare(praticaWeb.getTitolare());
			
			if (prPresentate != null) {
				if (prPresentate.size() > 0)
					retValue = false;
			}
			
		} catch (Exception exp) {
			log.error(exp.getMessage(), exp);
		}
		
		return retValue;
	}

	/**
	 * E' possibile inviare una domanda solo se non esiste nessuna altra domanda in stato PRESENTATA 
	 * per questo titolare
	 */
	@Override
	public boolean isInviaDomandaPossibile(PraticaWeb praticaWeb) {
		boolean retValue = true;
		
		try {
			List<PraticaWeb> prPresentate = searchPraticheWebPresentateByTitolare(praticaWeb.getTitolare());
			
			if (prPresentate != null) {
				for (PraticaWeb pr : prPresentate) {
					if (pr.getStato().equals("P")) {
						retValue = false;
						break;
					}
				}
			}
		} catch (Exception exp) {
			log.error(exp.getMessage(), exp);
		}
		
		return retValue;
	}
	
	/**
	 * Formato di controllo:
	 * campoObbligatorioAssumeValore#<LABEL C.A.>v<IDX_VAL_1>OR<IDX_VAL_2>...
	 * Esempio di controllo:
	 * campoObbligatorioAssumeValore#Sono stati effettuati interventi di miglioramento della prestazione energetica sull’immobile@0
	 * @param alPra
	 * @return
	 */
	@Override
	public boolean isAllegatoPraticaWebObbligatorio(PraticaWeb prWeb, AllegatiPratica alPra) {
		boolean retValue = false;
		
		try {
			if (alPra.getAllegati().isObbligatorio()) {
				retValue = true;
				if (alPra.getAllegati().getControllo() != null) {
					if (!alPra.getAllegati().getControllo().isEmpty()) {
						String controllo = alPra.getAllegati().getControllo();
						String ctrl[] = controllo.split("#");
						
						if(ctrl[0].equals("campoObbligatorioAssumeValore")){
							String opts[] = ctrl[1].split("@");
							String listaValoriIdx[] = opts[1].split("OR");
							CampiAggiuntiviPraticaWeb caWeb = getCampoAggiuntivo(prWeb, opts[0]);
							if (!campoObbligatorioAssumeValore(caWeb, listaValoriIdx))
								retValue = false;
						}
					}
				}
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		
		return retValue;
	}
	
	private boolean campoObbligatorioAssumeValore(CampiAggiuntiviPraticaWeb campo, String[] listaValoriIdx){
		boolean ret = false;
		
		if (campo.getCampiAggiuntivi().getTipologia().equals("l") || 
				campo.getCampiAggiuntivi().getTipologia().equals("g") || 
				campo.getCampiAggiuntivi().getTipologia().equals("b")){
			if(campo.getValore() != null && !campo.getValore().equals("") && !campo.getValore().replaceAll(",", "").equals("")){
				for (String idx : listaValoriIdx){
					ret = contieneValore(campo, Integer.parseInt(idx));
					if (ret)
						break;
				}
			}
		}

		log.debug(String.format("Validazione del campo : Tipologia = %s; Label = %s; Valore = %s",
				campo.getCampiAggiuntivi().getTipologia(),
				campo.getCampiAggiuntivi().getLabel(),
				campo.getValore()));
		
		return ret;
	}
	private boolean contieneValore(CampiAggiuntiviPraticaWeb campo, int valoreIdx){
		boolean ret = false;
		String listaValori[] = campo.getCampiAggiuntivi().getListaValori().split(",");

		if (listaValori !=null && listaValori.length >= valoreIdx){
			String valore = listaValori[valoreIdx];
		
			if (campo.getValore()!=null){
				if(campo.getValore().contains(valore))
					ret = true;
			}
		}

		return ret;
	}

	@Override
	public List<PraticaWeb> searchPraticheWebValidate(int nrGiorniValidateDa) {

		List<PraticaWeb> retValue = new ArrayList<PraticaWeb>();
		
		log.debug("searchPraticheWebValidate :: entering method");
		List<PraticaWeb> praticheValidate = praticaWebRepository.findByStato("V");
		if (praticheValidate != null) {
			log.debug(String.format("Trovate %s pratiche validate", praticheValidate.size()));
			Date oggi = new Date();
			long diffInMillies = 0;
			for (PraticaWeb praticaWeb : praticheValidate) {
				diffInMillies = Math.abs(oggi.getTime() - praticaWeb.getDataValidazione().getTime());
				praticaWeb.setGgValidazione(TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS));
				
				if (nrGiorniValidateDa > 0) {
					if (praticaWeb.getGgValidazione() > nrGiorniValidateDa)
						retValue.add(praticaWeb);
				} else
					retValue.add(praticaWeb);
			}
		}
		else {
			log.debug("Nessuna pratica validata trovata");
		}
		
		return retValue;
	}

	@Override
	public List<PraticaWeb> rimuoviValidazione(int nrGiorniValidateDa) {
		log.debug(String.format("rimuoviValidazione - %s :: entering method", nrGiorniValidateDa));
		
		List<PraticaWeb> praticheDaElaborare = searchPraticheWebValidate(nrGiorniValidateDa);
		if (praticheDaElaborare != null) {
			log.debug(String.format("Trovate %s pratiche validate da riportare in stato DA VALIDARE!!", praticheDaElaborare.size()));
			String emailTo1 = "";
			String emailTo2 = "";
			String denominazione = "";
			Date dataValidazione = null;
			Azienda azienda = null;
			for (PraticaWeb praticaWeb : praticheDaElaborare) {
				log.debug(String.format("Gestione della istanza ID=$s - numero:%s...", praticaWeb.getId(), praticaWeb.getNumeroPratica()));
				
				dataValidazione = praticaWeb.getDataValidazione();
				praticaWeb.setDataValidazione(null);
				praticaWeb.setStato("E");
				praticaWebRepository.save(praticaWeb);
				
				// Invio mail al BENEFICIARIO...
				sendMailCheckValidazione(
						getValoreCampoAggiuntivo(praticaWeb, LABEL_E_MAIL), 
						getValoreCampoAggiuntivo(praticaWeb, LABEL_DENOM_BENEFICIARIO), 
						praticaWeb.getNumeroPratica(), 
						praticaWeb.getOggettoRichiesta(), 
						nrGiorniValidateDa, 
						dataValidazione);
				
				// Invio mail all'Operatore economico
				azienda = rappresentanteLegaleService.findAziendaByPartitaIva(praticaWeb.getImpresa());
				if (azienda != null) {
					sendMailCheckValidazione(
							azienda.geteMail(), 
							azienda.getDenominazione(), 
							praticaWeb.getNumeroPratica(), 
							praticaWeb.getOggettoRichiesta(), 
							nrGiorniValidateDa, 
							dataValidazione);
				}
			}
		}
		
		return searchPraticheWebValidate(0);
	}
	private void sendMailCheckValidazione(String emailTo, String denominazione, String numeroIstanza, String oggettoIstanza, int nrGiorniValidateDa, Date dataValidazione) {
		try {
			if (emailTo!=null) {
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
				Map model = new HashMap();
				String oggetto = String.format("Comunicazione di cambio stato istanza:%s - %s", numeroIstanza, oggettoIstanza); 
				model.put("denominazione", denominazione);
				model.put("numeroPratica", numeroIstanza);
				model.put("oggettoPratica", oggettoIstanza);
				model.put("ggCheckValidazione", nrGiorniValidateDa);
				model.put("dataValidazione", sdf.format(dataValidazione));
				model.put("newline", "</br>");
				
				String bodyContent = mailSenderHelper.mergeTplModelli(this.tplEmailCheckValidazione, model);
				
				try {
					this.mailSenderHelper.sendMail(oggetto, bodyContent, null, mittenteMailIstruttorie, new String[]{emailTo});
				} catch (Exception e) {
					log.error(e.getMessage(), e);
					log.error((String.format("Invio della Mail fallito! - %s", e.getMessage())));
				}
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}

	@Override
	public List<PraticaWeb> searchPraticheWebByStato(String stato) {
		log.debug("searchPraticheWebByStato :: entering method");
		
		
		String queryString = "select DISTINCT pr from PraticaWeb pr "
				+ "LEFT OUTER JOIN pr.campiaggiuntivi ca_web "
				+ "LEFT OUTER JOIN ca_web.campiAggiuntivi ca "
				+ "WHERE pr.stato = ?1";
				
		
		Query query = em.createQuery(queryString, PraticaWeb.class);
		
		query.setParameter(1, stato);
		
		return (List<PraticaWeb>) query.getResultList();
	}

	@Override
	public PraticaWeb setStatoByNumeroPratica(String numeroPratica, String newStato) throws ServiceLayerException {
		PraticaWeb prWeb = praticaWebRepository.findByNumeroPratica(numeroPratica);
		if (prWeb == null) {
			throw new ServiceLayerException(String.format("PraticaWeb con numero=%s non trovata in database!", numeroPratica));
		} else {
			prWeb.setStato(newStato);
			PraticaWeb prWebSaved = praticaWebRepository.save(prWeb);
			return prWebSaved;
		}
	}
}
