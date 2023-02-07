package it.sincon.gepred.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

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
import it.osapulie.service.RuoloService;
import it.osapulie.service.ServiceLayerException;
import it.osapulie.web.portlet.util.CheckSumGenerator;
import it.osapulie.web.portlet.util.MailPecSenderHelper;
import it.osapulie.web.portlet.util.MailSenderHelper;
import it.osapulie.web.portlet.util.PortletHelper;
import it.osapulie.web.portlet.util.SignatureManager;
import it.sincon.gepred.calendario.beans.Appuntamento;
import it.sincon.gepred.calendario.service.CalendarioService;
import it.sincon.gepred.documentale.bean.DocFile;
import it.sincon.gepred.documentale.bean.DocInfo;
import it.sincon.gepred.documentale.bean.DocumentaleException;
import it.sincon.gepred.documentale.service.DocumentaleService;
import it.sincon.gepred.domain.AllegatiPratica;
import it.sincon.gepred.domain.Allegati;
import it.sincon.gepred.domain.AllegatiPraticaExtended;
import it.sincon.gepred.domain.Attivita;
import it.sincon.gepred.domain.AttivitaPratica;
import it.sincon.gepred.domain.CampiAggiuntivi;
import it.sincon.gepred.domain.CampiAggiuntiviListaValori;
import it.sincon.gepred.domain.CampiAggiuntiviPratica;
import it.sincon.gepred.domain.CampiAggiuntiviPraticaWeb;
import it.sincon.gepred.domain.CampiAggiuntiviTipoPratica;
import it.sincon.gepred.domain.DatiInvioMail;
import it.sincon.gepred.domain.DatiMailInviate;
import it.sincon.gepred.domain.Immobile;
import it.sincon.gepred.domain.Referente;
import it.sincon.gepred.domain.pratica.CategoriePratiche;
import it.sincon.gepred.domain.pratica.DatiCatastaliImmobile;
import it.sincon.gepred.domain.pratica.EsitoIstruttoria;
import it.sincon.gepred.domain.TipoPraticaAttivita;
import it.sincon.gepred.domain.pratica.Figura;
import it.sincon.gepred.domain.pratica.Modelli;
import it.sincon.gepred.domain.pratica.NumeroPratica;
import it.sincon.gepred.domain.pratica.Parere;
import it.sincon.gepred.domain.pratica.Pratica;
import it.sincon.gepred.domain.pratica.PraticaWeb;
import it.sincon.gepred.domain.pratica.Preventivo;
import it.sincon.gepred.domain.pratica.StatoPratica;
import it.sincon.gepred.domain.pratica.TipoPratica;
import it.sincon.gepred.domain.pratica.TipoPraticaTab;
import it.sincon.gepred.persistence.AllegatiPraticaRepository;
import it.sincon.gepred.persistence.AllegatiRepository;
import it.sincon.gepred.persistence.AttivitaPraticaRepository;
import it.sincon.gepred.persistence.CampiAggiuntiviPraticaRepository;
import it.sincon.gepred.persistence.DatiCatastaliImmobileRepository;
import it.sincon.gepred.persistence.DatiInvioMailRepository;
import it.sincon.gepred.persistence.EsitoIstruttoriaRepository;
import it.sincon.gepred.persistence.ImmobileRepository;
import it.sincon.gepred.persistence.ParereRepository;
import it.sincon.gepred.persistence.PraticaRepository;
import it.sincon.gepred.persistence.PraticaWebRepository;
import it.sincon.gepred.persistence.PreventivoRepository;
import it.sincon.gepred.persistence.RappresentanteLegaleRepository;
import it.sincon.gepred.persistence.ReferenteRepository;
import it.sincon.gepred.persistence.StatoPraticaRepository;
import it.sincon.gepred.persistence.TipoPraticaAttivitaRepository;
import it.sincon.gepred.persistence.UrpMailAccountRepository;
import it.sincon.gepred.protocollo.bean.DatiAutenticazione;
import it.sincon.gepred.protocollo.bean.AllegatoProtocollo;
import it.sincon.gepred.protocollo.bean.DatiMittenteDestinatario;
import it.sincon.gepred.protocollo.bean.DatiOutputProtocollo;
import it.sincon.gepred.protocollo.bean.DatiRichiestaProtocollo;
import it.sincon.gepred.protocollo.bean.MezzoSpedizioneEnum;
import it.sincon.gepred.protocollo.service.ProtocolloService;
import it.sincon.gepred.service.GestioneCampiAggiuntiviService;
import it.sincon.gepred.service.GestionePraticheService;
import it.sincon.gepred.service.GestionePraticheWebService;
import it.sincon.gepred.service.NumeroPraticaService;
import it.sincon.gepred.service.RappresentanteLegaleService;
import it.sincon.gepred.visura.bean.VisuraImpresa;
import it.sincon.gepred.visura.service.VisuraService;
import it.sincon.gepred.web.portlet.utils.BarChartUtils;
import it.sincon.gepred.web.portlet.utils.CalcolaPunteggioUtils;
import it.sincon.gepred.web.portlet.utils.ConverterToPdf;
import it.sincon.gepred.web.portlet.utils.ServiceHelper;
import it.sincon.gepred.service.GestioneReferenteService;
import it.sincon.gepred.web.portlet.varie.ControlliCampiAggiuntivi;
//import it.sincon.gepred.web.portlet.utils.WorkflowHelper;
import it.sincon.gepred.web.portlet.varie.DatiConsuntivoPratica;
import it.sincon.gepred.web.portlet.varie.DatiRicercaPratica;
import it.sincon.gepred.web.portlet.varie.DatiRicercaReferente;
import it.sincon.gepred.web.portlet.varie.DatiSelezioneAzienda;

import org.alfresco.webservice.util.ContentUtils;
import org.apache.velocity.runtime.directive.Foreach;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.PrefsPropsUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.AbstractMessageSource;


/**
 * Implementazione di {@link GestionePraticheService}
 * 
 * @author Maria Michela Birtolo
 */
@Service("gestionePraticheService")
public class GestionePraticheServiceImpl implements GestionePraticheService {

	private static Logger log = LoggerFactory
			.getLogger(GestionePraticheServiceImpl.class);
	
	private static final String LABEL_UNITA_ABIBATIVE = "Unità abitative occupate";
	private static final String LABEL_UNITA_ABIBATIVE_TOT = "Unita' abitative totali";
	private static final String LABEL_PERC_UNITA_ABIBATIVE = "Unita' abitative (%)";
	
	private static final String LABEL_SUP_LORDA_PAV = "Sup. lorda pavim. destinata ad unita' abitative (mq)";
	private static final String LABEL_SUP_LORDA_PAV_TOT = "Superficie lorda pavimento (mq)";
	private static final String LABEL_PERC_SUP_LORDA_PAV = "S.L.P. (%)";

	@PersistenceContext(unitName="gepred")
	private EntityManager em;

	@Inject
	private PraticaRepository praticaRepository;
	
	@Inject
	private StatoPraticaRepository statoRepository;
	
	@Inject
	private EsitoIstruttoriaRepository esitoIstruttoriaRepository;
	
	@Inject
	private DatiCatastaliImmobileRepository datiCatastaliRepository;
	
	@Inject
	private CampiAggiuntiviPraticaRepository campiAggPraticaRepository;

	@Inject
	private ParereRepository parereRepository;

	@Inject
	private ImmobileRepository immobileRepository;

	@Inject
	private GestioneReferenteService gestioneReferenteService;

	@Inject
	private AllegatiPraticaRepository allegatiRepository;
	
	@Inject
	private DatiInvioMailRepository invioMailRepository;

	@Inject
	private AllegatiRepository tipoAllegatiRepository;
	
	@Inject
	private ProfiloUtenteService profiloUtenteService;
	
	@Inject
	private UrpMailAccountRepository urpMailAccountRepository;
	
	@Inject
	private GestioneCampiAggiuntiviService gestioneCampiAggiuntiviService;
	
	@Inject
	private RuoloService ruoloService;
	
	@Inject
	private NumeroPraticaService numPraticaService;
	
	@Inject
	private PortletHelper helper;

//	@Autowired(required=false)
//	private WorkflowHelper workflowHelper;

	@Autowired(required=false)
	private DocumentaleService documentaleService;
	
	@Inject
	private GestionePraticheWebService gestionePraticheWebService;

	@Inject
	private AttivitaPraticaRepository attivitaPraticaRepository;
	
	@Inject
	private MailPecSenderHelper mailPecSenderHelper;
	
	@Inject
	private MailSenderHelper mailSenderHelper;
	
	/*@Value("#{applicationProperties.ruoli_referenti_assegnatari}")
	private String ruoliReferentiAssegnatari;*/

	@Autowired(required=false)
	private ProtocolloService protocolloService;

	@Autowired(required=false)
	private CalendarioService calendarioService;

	@Value("#{applicationProperties.nomeModello}")
	private String nomeModello;
	
	@Value("#{applicationProperties.host_open_office}")
	private String hostOpenOffice;
	@Value("#{applicationProperties.port_open_office}")
	private String portOpenOffice;
	
	@Inject
	private PraticaWebRepository praticaWebRepository;
	
	@Inject
	private ReferenteRepository referenteRepository;
	
	@Inject
	private ComuneRepository comuneRepository;
	
	@Inject
	private AllegatiPraticaRepository allegatiPraticaRepository;
	
	@Inject
	private PreventivoRepository preventivoRepository;
	
	@Autowired(required = false)
	private VisuraService visuraService;
	
	@Inject
    private RappresentanteLegaleService rappresentanteLegaleService;
	
	@Value("#{applicationProperties.patternNomeAllegatoPraticaWeb}")
	private String patternNomeAllegatoPraticaWeb;
	@Value("#{applicationProperties.patternNomeAllegatoPraticaWebToBeSaved}")
	private String patternNomeAllegatoPraticaWebToBeSaved;
	
	@Value("#{applicationProperties.nomeRichiesta}")
	private String nomeDocRichiesta;
	@Value("#{applicationProperties.nomeRisposta}")
	private String nomeDocRisposta;
	
	@Value("#{applicationProperties.tplEmailComunicazioneConInstallatore}")
	private String tplEmailComunicazioneConInstallatore;
	
	@Value("#{applicationProperties.accettaSignedFilesOnly}")
	private String validaDomandaFirmata;
	
	@Value("#{applicationProperties.ggDurataIstruttoria}")
	private String ggDurataIstruttoria;
		
	/**
	 * Metodo che ricerca le pratiche
	 */
	@SuppressWarnings("unchecked")
	public List<Pratica> searchPratiche(DatiRicercaPratica filtriRicerca) {
		log.debug("searchPratiche :: entering method");
//		String queryString = "select DISTINCT pr from Pratica pr "
//				+ "LEFT OUTER JOIN pr.attivitaPratica ap "
//				+ "LEFT OUTER JOIN pr.tipologia.categoria.ruolo ru "
//				+ "LEFT OUTER JOIN pr.assegnatari ass where 1=1 ";
		//TODO: rivedere la query
		String queryString ="select distinct pr.* from tb_pratica pr "
				+ "LEFT OUTER JOIN tb_tipopratica tp on pr.fk_tipologia = tp.id "
				+ "LEFT OUTER JOIN tb_categorie_pratiche cat on tp.fk_categoria = cat.id "
				+ "LEFT OUTER JOIN tb_ruoli_categorie rolecat on rolecat.categoria_id = cat.id "
				+ "LEFT OUTER JOIN tb_profilo_ruolo profruolo on profruolo.fk_ruolo = rolecat.ruolo_id "
				+ "LEFT OUTER JOIN tb_attivitapratica ap on ap.fk_pratica = pr.id "
				+ "LEFT OUTER JOIN tb_profilo_pratica ass on ass.pratica_id = pr.id "
				+ "where 1=1 ";

		if (filtriRicerca.getOggetto() != null
				&& !filtriRicerca.getOggetto().equals("")) {
			queryString += " AND lower(pr.oggetto) LIKE lower(?1)";
		}
		if (filtriRicerca.getRichiedente() != null) {
			queryString += " AND pr.fk_richiedente = ?2";
		}
		if (filtriRicerca.getImmobile() != null) {
			queryString += " AND pr.fk_immobile = ?6";
		}
		if (filtriRicerca.getNumero() != null
				&& !filtriRicerca.getNumero().equals("")) {
			queryString += " AND lower(pr.numero) LIKE lower(?3)";
		}
		if (filtriRicerca.getStatopratica() != null
				&& !filtriRicerca.getStatopratica().equals("")) {
			queryString += " AND pr.stato  = ?4";
		}
		if (filtriRicerca.getResponsabile() != null
				&& !filtriRicerca.getResponsabile().equals("")) {
			queryString += " AND pr.fk_profilo  = ?14 ";
		}
		if (filtriRicerca.getNumProtocollo() != null
				&& !filtriRicerca.getNumProtocollo().equals("")) {
			queryString += " AND pr.numero = ?15 ";
		}
		
		if (filtriRicerca.getUtenteWorkflow() != null
				&& !filtriRicerca.getUtenteWorkflow().equals("")) {
			List<String> pks = null;
			if(pks != null && !pks.isEmpty()){
				String ids="";
				for(int i=0; i < pks.size(); i++)
					ids = ids + ",'"+pks.get(i)+"'";
				log.debug("ids="+ids);
				queryString += " AND ((ap.fk_profiloutente  = ?5 AND ap.data_completamento is null) OR pr.id IN ("+ids.substring(1)+"))";
			}
			else{
				queryString += " AND ((ap.fk_profiloutente  = ?5 AND ap.data_completamento is null) OR (ass.profilo_id = ?5))";
			}
			//queryString += "AND ?5 IN (SELECT profiloutente.id FROM AttivitaPratica where dataCompletamento is not null and pratica.id = pr.id)";
		}
		
		if (filtriRicerca.getIdCorrelati() != null) {
			log.info("id fascicoli correlati = " + filtriRicerca.getIdCorrelati());
			queryString += " AND pr.id NOT IN (" + filtriRicerca.getIdCorrelati() + ")";
		}

		
		if (filtriRicerca.getTipointervento() != null
				&& !filtriRicerca.getTipointervento().equals("")) {
			queryString += " AND pr.fk_tipointervento  = ?7";
		}
		if (filtriRicerca.getAreaSIN() != null
				&& !filtriRicerca.getAreaSIN().equals("")) {
			queryString += " AND pr.immobile.areaSin  = ?8";
		}
		if (filtriRicerca.getTipologia() != null
				&& !filtriRicerca.getTipologia().equals("")) {
			queryString += " AND pr.fk_tipologia  = ?9";
		}
		if (filtriRicerca.getAnno() != null
				&& !filtriRicerca.getAnno().equals("")) {
			queryString += " AND pr.numero LIKE ?10";
		}
		if (filtriRicerca.getPeriodo_da() != null
				&& !filtriRicerca.getPeriodo_da().equals("")) {
			queryString += " AND pr.data_richiesta  >= ?11";
		}
		if (filtriRicerca.getPeriodo_a() != null
				&& !filtriRicerca.getPeriodo_a().equals("")) {
			queryString += " AND pr.data_richiesta  <= ?12";
		}

//		if (filtriRicerca.getRuoloUtenteLoggato()!= null) {
//			queryString += " AND ru.id = ?13 ";
//		}
		if (filtriRicerca.getUtenteLoggato()!= null) {
			queryString += " AND profruolo.fk_profilo = ?13 ";
		}
		
		if (filtriRicerca.getDataProtocollo_da() != null
				&& !filtriRicerca.getDataProtocollo_da().equals("")) {
			queryString += " AND pr.data_protocollo  >= ?16";
		}
		if (filtriRicerca.getDataProtocollo_a() != null
				&& !filtriRicerca.getDataProtocollo_a().equals("")) {
			queryString += " AND pr.data_protocollo  <= ?17";
		}
		
		if (filtriRicerca.getStatiAmmessi() != null) {
			queryString += " AND pr.stato IN (" + getINValues(filtriRicerca.getStatiAmmessi()) + ") ";
		}
		if(filtriRicerca.getCampiAggiuntivi() != null && !filtriRicerca.getCampiAggiuntivi().isEmpty()){
			int count=18;
			for(int i=0; i < filtriRicerca.getCampiAggiuntivi().size(); i++){
				CampiAggiuntivi campo = filtriRicerca.getCampiAggiuntivi().get(i);
				if(campo.getValoreRicerca() != null && !campo.getValoreRicerca().equals("")){
//					queryString += " AND pr.id IN(SELECT ca"+i+".pratica.id from CampiAggiuntiviPratica ca"+i+" where ca"+i+".valore = ?"+(count+1)+" AND ca"+i+".campiAggiuntivi.id = ?"+(count+2)+" ) ";
					queryString += " AND pr.id IN(SELECT ca"+i+".fk_pratica from tb_ca_pratica ca"+i+" where lower(ca"+i+".valore) like lower(?"+(count+1)+") AND ca"+i+".fk_campiaggiuntivi = ?"+(count+2)+" ) ";
					count=count+2;
				}
			}
		}
		//queryString +="ORDER BY pr.data_richiesta DESC, pr.numero DESC";
		queryString +=" ORDER BY pr.data_protocollo ASC, pr.numero_protocollo ASC";
		
		//Query query = em.createQuery(queryString, Pratica.class);
		Query query = em.createNativeQuery(queryString, Pratica.class);

		if (filtriRicerca.getOggetto() != null
				&& !filtriRicerca.getOggetto().equals("")) {
			query.setParameter(1, "%"
					+ filtriRicerca.getOggetto().toLowerCase() + "%");
		}
		if (filtriRicerca.getRichiedente() != null) {
			query.setParameter(2, filtriRicerca.getRichiedente().getId());
		}
		if (filtriRicerca.getNumero() != null
				&& !filtriRicerca.getNumero().equals("")) {
//			query.setParameter(3, filtriRicerca.getNumero());
			query.setParameter(3, "%" + filtriRicerca.getNumero() + "%");
		}
		if (filtriRicerca.getStatopratica() != null
				&& !filtriRicerca.getStatopratica().equals("")) {
			query.setParameter(4, filtriRicerca.getStatopratica());
		}
		if (filtriRicerca.getUtenteWorkflow() != null
				&& !filtriRicerca.getUtenteWorkflow().equals("")) {
			query.setParameter(5, Long.parseLong(filtriRicerca.getUtenteWorkflow()));
		}
		if (filtriRicerca.getImmobile() != null) {
			query.setParameter(6, filtriRicerca.getImmobile().getId());
		}
		if (filtriRicerca.getTipointervento() != null
				&& !filtriRicerca.getTipointervento().equals("")) {
			query.setParameter(7, filtriRicerca.getTipointervento());
		}
		if (filtriRicerca.getAreaSIN() != null
				&& !filtriRicerca.getAreaSIN().equals("")) {
			query.setParameter(8, filtriRicerca.getAreaSIN());
		}
		if (filtriRicerca.getTipologia() != null
				&& !filtriRicerca.getTipologia().equals("")) {
			query.setParameter(9, Long.parseLong(filtriRicerca.getTipologia()));
		}
		if (filtriRicerca.getAnno() != null
				&& !filtriRicerca.getAnno().equals("")) {
			query.setParameter(10, "%"+filtriRicerca.getAnno());
		}
		if (filtriRicerca.getPeriodo_da() != null
				&& !filtriRicerca.getPeriodo_da().equals("")) {
			query.setParameter(11, DateUtils.getData(filtriRicerca.getPeriodo_da()));			
		}
		if (filtriRicerca.getPeriodo_a() != null
				&& !filtriRicerca.getPeriodo_a().equals("")) {
			query.setParameter(12, DateUtils.getData(filtriRicerca.getPeriodo_a()));			
		}
		if (filtriRicerca.getUtenteLoggato()!= null) {
			query.setParameter(13, filtriRicerca.getUtenteLoggato().getId());
		}
		if (filtriRicerca.getResponsabile() != null) {
			query.setParameter(14, filtriRicerca.getResponsabile());
		}
		if (filtriRicerca.getNumProtocollo() != null && !filtriRicerca.getNumProtocollo().equals("")) {
			query.setParameter(15, filtriRicerca.getNumProtocollo());
		}
		if (filtriRicerca.getDataProtocollo_da() != null
				&& !filtriRicerca.getDataProtocollo_da().equals("")) {
			query.setParameter(16, DateUtils.getData(filtriRicerca.getDataProtocollo_da()));			
		}
		if (filtriRicerca.getDataProtocollo_a() != null
				&& !filtriRicerca.getDataProtocollo_a().equals("")) {
			query.setParameter(17, DateUtils.getData(filtriRicerca.getDataProtocollo_a()));			
		}
		if(filtriRicerca.getCampiAggiuntivi() != null && !filtriRicerca.getCampiAggiuntivi().isEmpty()){
			int count=18;
			for(int i=0; i < filtriRicerca.getCampiAggiuntivi().size(); i++){
				CampiAggiuntivi campo = filtriRicerca.getCampiAggiuntivi().get(i);
				if(campo.getValoreRicerca() != null && !campo.getValoreRicerca().equals("")){
					query.setParameter((count+1), "%" + campo.getValoreRicerca() + "%");
					query.setParameter((count+2), campo.getId());					
					count=count+2;
				}
			}
		}
		

		return (List<Pratica>) query.getResultList();
	}
	
	private String getINValues(List<Long> inputList) {
		String retValue = "";
		
		if (inputList != null) {
			if (inputList.size() > 0) {
				for (Long lVal : inputList) {
					retValue += String.format("%s, ", lVal);
				}
				
				retValue = retValue.substring(0, retValue.length() - 2);
			}
		}
		
		return retValue;
	}

	
	private Pratica updateReferenteAttivita(Pratica pr,int i,ProfiloUtente oldProfilo) {
		log.info("call updateReferenteAttivita");
		if (pr.getAttivitaPratica().get(i).getProfiloutente()!=null){
			log.info("old profilo = "+pr.getAttivitaPratica().get(i).getProfiloutente().getNomeCompletoUtente());
			if (oldProfilo!=null && pr.getAttivitaPratica().get(i).getProfiloutente().getId().equals(oldProfilo.getId()) && pr.getAttivitaPratica().get(i).getDataCompletamento()==null && pr.getReferente()!=null) {
				pr.getAttivitaPratica().get(i).setProfiloutente(pr.getReferente());
			}
			log.info("new profilo = "+pr.getAttivitaPratica().get(i).getProfiloutente().getNomeCompletoUtente());
		}
		return pr;
	}
	
	private File getAllegatoPerMail(AllegatiPratica _allegato) throws Exception{
		File result = new File(_allegato.getNomeFile());
		
		DocFile doc = documentaleService.download(_allegato.getPratica().getUuidContenitore(), _allegato.getUuidFile());
		FileOutputStream output = new FileOutputStream(result);
		output.write(doc.getContent());
		output.close();	
		
		return result;
	}
	
	public boolean invioMailWithAllegato(DatiInvioMail mail ) throws Exception{
		
		log.debug("invioMailWithAllegato :: entering method");
		
		boolean pecEnableBoolean = false;
		boolean res = false;
		try{
//			pecEnableBoolean = Boolean.parseBoolean(PrefsPropsUtil.getString("pec.mail.session.mail.smtp.enable"));
		
			String[] to = null;
			if(mail.getDestinatario().contains(","))
				to = mail.getDestinatario().split(",");
			else{
				to = new String[1];
				to[0] = mail.getDestinatario();
			}
				
			
			// Recupero i files da inviare come allegati alla mail...
			List<File> lstAllegatiMail = new ArrayList<File>();
			for (AllegatiPraticaExtended selAllegato : mail.getAllegatiSelezionati()){
				if (selAllegato.isChecked())
					lstAllegatiMail.add(getAllegatoPerMail(selAllegato.getAllegatoPratica()));
			}
			
			if(pecEnableBoolean){	
				mailPecSenderHelper.sendMail(mail.getOggetto(), mail.getCorpo(), lstAllegatiMail.toArray(new File[0]),mail.getMittente(),  to);
			}
			else{
				mailSenderHelper.sendMail(mail.getOggetto(), mail.getCorpo(), lstAllegatiMail.toArray(new File[0]), mail.getMittente(), to );
			}
			mail.setInviato(true);
			
			// Salvo la mail tante volte per quanti sono gli allegati...
			if (mail.getAllegatiSelezionati().size()>0){
				for (AllegatiPraticaExtended selAllegato : mail.getAllegatiSelezionati()){
					if (selAllegato.isChecked()){
						log.debug(String.format("Salvataggio dell allegatoPratica con ID=%s", selAllegato.getAllegatoPratica().getId()));
						try{
							mail.resetId();
							mail.setAllegato(selAllegato.getAllegatoPratica());
							mail = invioMailRepository.save(mail);
						}catch (Exception exp){
							log.error(exp.getMessage(), exp);
						}
					}
				}
			}else{
				// Salvo la mail una volta sola, in corrispondenza della pratica...
				log.debug(String.format("Salvataggio della mail per la pratica con ID=%s", mail.getIdPratica()));
				try{
					mail.resetId();
					mail = invioMailRepository.save(mail);
				}catch (Exception exp){
					log.error(exp.getMessage(), exp);
				}
			}
			
			res = true;
		}catch(Exception e ){
			log.error("invioMailWithAllegato :: " + e.getMessage(),e);
			res = false;
		}
		return res;
	}
	
	public void logAllegati(List<AllegatiPratica> listaAllegati) 
	{
		if (listaAllegati != null) {
			log.debug(String.format("AllegatiPratica.size()=%s", listaAllegati.size()));
			for (AllegatiPratica alPra : listaAllegati) {
				log.debug(String.format(" AllegatoPratica :: %s", alPra.getId(), alPra.getNomeFile()));
				if (alPra.getAllegato() != null)
				{
					log.debug(String.format(" AllegatoPratica(%s) - rilevato il file con size %s", alPra.getId(), alPra.getAllegato().length()));	
				} else {
					log.debug(String.format(" AllegatoPratica(%s) - il file è NULL", alPra.getId()));
				}
			}
		}
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * it.osapulie.service.PraticaService#savePratica(it.sincon.gepred.domain
	 * .Pratica)
	 */
	@Transactional(rollbackFor={ServiceLayerException.class})
	public Pratica savePratica(Pratica pratica) throws ServiceLayerException {
		boolean nuovo = false;
		Pratica savedPr = null;
		NumeroPratica numPratica = null;
		try {
			ProfiloUtente utente=null;
			if (pratica.isNew()){
				nuovo = true;
				/*if (pratica.getNumero().equals("")) {
					int num = generaNumeroPratica(pratica.getPrefisso(), DateUtils.getDataSenzaSlash(pratica.getDataRichiesta()).substring(4));
					if (pratica.getPrefisso() != null && !pratica.getPrefisso().equals(""))
						pratica.setNumeroPratica(pratica.getPrefisso() + "/" + String.format("%05d", num)  + "/" + DateUtils.getDataSenzaSlash(pratica.getDataRichiesta()).substring(4));
					else
						pratica.setNumeroPratica(String.format("%05d", num) + "/" + DateUtils.getDataSenzaSlash(pratica.getDataRichiesta()).substring(4));
				}else{
					if (pratica.getPrefisso() != null && !pratica.getPrefisso().equals("")){
						pratica.setNumeroPratica(pratica.getPrefisso() + "/" + pratica.getNumero());
					}else{
						pratica.setNumeroPratica(pratica.getNumero());
					}
					
				}*/
				
				if(pratica.getNumero().equals("")){
					numPratica = numPraticaService.getNext(pratica.getPrefisso(), Integer.parseInt(DateUtils.getDataSenzaSlash(pratica.getDataRichiesta()).substring(4)));
					pratica.setNumeroPratica(numPratica.toString());
				}else{
					if (pratica.getPrefisso() != null && !pratica.getPrefisso().equals("")){
						pratica.setNumeroPratica(pratica.getPrefisso() + "/" + pratica.getNumero());
					}else{
						pratica.setNumeroPratica(pratica.getNumero());
					}
				}
			}
			if (!nuovo) {
				log.debug("verifica pratica :: "+(pratica!=null));
				log.debug("verifica pratica2 :: "+(pratica.getId()));
				log.debug("verifica caricamento vecchia pratica :: "+(getPraticaByPk(pratica.getId())));
				utente=getPraticaByPk(pratica.getId()).getReferente();
			}
//			if (nuovo && pratica.getTipologia().getAutomaticAssign()==16) {
//				ProfiloUtente referente=scegliProfilo(pratica);
//				pratica.getAssegnatari().add(referente);
//				pratica.setReferente(referente);
//			}
			for (int i = 0; i < pratica.getCampiaggiuntivi().size(); i++) {
				if (pratica.getCampiaggiuntivi().get(i).getCampiAggiuntivi() !=null) {
					if (pratica.getCampiaggiuntivi().get(i).getCampiAggiuntivi().getTipologia().equals("l") && pratica.getCampiaggiuntivi().get(i).getValore()!=null && !pratica.getCampiaggiuntivi().get(i).getValore().equals("")) {
						boolean found = false;
						for(int j=0;j<pratica.getCampiaggiuntivi().get(i).getCampiAggiuntivi().getValori().size() && !found;j++){
							found = pratica.getCampiaggiuntivi().get(i).getCampiAggiuntivi().getValori().get(j).getValore().equals(pratica.getCampiaggiuntivi().get(i).getValore());
						}
						if (!found) {
							log.debug(String.format("Aggiorno lista valori per il ca pratica con ID=%s", pratica.getCampiaggiuntivi().get(i).getId()));
							CampiAggiuntiviListaValori newValue = new CampiAggiuntiviListaValori();
							newValue.setCampiAggiuntivi(pratica.getCampiaggiuntivi().get(i).getCampiAggiuntivi());
							newValue.setValore(pratica.getCampiaggiuntivi().get(i).getValore());
							pratica.getCampiaggiuntivi().get(i).getCampiAggiuntivi().getValori().add(newValue);
							gestioneCampiAggiuntiviService.saveCampiAggiuntivi(pratica.getCampiaggiuntivi().get(i).getCampiAggiuntivi());
							pratica.getCampiaggiuntivi().get(i).setCampiAggiuntivi(gestioneCampiAggiuntiviService.getCampiAggiuntiviByPk(pratica.getCampiaggiuntivi().get(i).getCampiAggiuntivi().getId()));
						}
					}
				}
				pratica.getCampiaggiuntivi().get(i).setPratica(pratica);
			}
			for (int i = 0; i < pratica.getAllegati().size(); i++) {
				if (pratica.getAllegati().get(i).getAllegati().isNew())
				{
					log.debug(String.format("Allegato nuovo rilevato :: %s-%s", pratica.getAllegati().get(i).getId(), pratica.getAllegati().get(i).getAllegati().getNomeDocumento()));
					Allegati tipo = tipoAllegatiRepository.save(pratica.getAllegati().get(i).getAllegati());
					pratica.getAllegati().get(i).setAllegati(tipo);
				}
				pratica.getAllegati().get(i).setPratica(pratica);
			}
			for (int i = 0; i < pratica.getFigure().size(); i++) {
				pratica.getFigure().get(i).setPratica(pratica);
			}
			for (int i = 0; i < pratica.getAttivitaPratica().size(); i++) {
				pratica.getAttivitaPratica().get(i).setPratica(pratica);
				if (pratica.getAttivitaPratica().get(i).isNew()) {
					TipoPraticaAttivita tipoPraticaAttivita=findByAttivitaAndTipologia(pratica.getTipologia(), pratica.getAttivitaPratica().get(i).getAttivita());
					if (tipoPraticaAttivita!=null)
						pratica.getAttivitaPratica().get(i).setSendAlertMail(tipoPraticaAttivita.isSendAlertMail());
					
					// Se ho aggiunto una attivita di tipo Richiesta riapertura forzo lo stato a ISTRUTTORIA IN CORSO...
					if (pratica.getAttivitaPratica().get(i).getAttivita().getDescrizione().toLowerCase().equals("richiesta riapertura istruttoria") &&
							pratica.getStato().getId() == 5L) {
						StatoPratica stato1L = statoRepository.findOne(1L);
						pratica.setStato(stato1L);
						log.debug(String.format("Stato pratica impostato a %s per nuova attività %s !",stato1L.getDescrizione(), 
								pratica.getAttivitaPratica().get(i).getAttivita().getDescrizione()));
					}
				}
				if (!nuovo)
					pratica = updateReferenteAttivita(pratica, i, utente);
			}
			for (int i = 0; i < pratica.getPareriPratica().size(); i++) {
				pratica.getPareriPratica().get(i).setPratica(pratica);
			}
			if(pratica.isNew() && pratica.getImmobile() != null && pratica.getImmobile().getId() == null){
				Immobile immobile = immobileRepository.save(pratica.getImmobile());
				pratica.setImmobile(immobile);
			}
			if(pratica.isNew() && pratica.getRichiedente() != null && pratica.getRichiedente().getId() == null){
				Referente richiedente = gestioneReferenteService.saveReferente(pratica.getRichiedente());
				pratica.setRichiedente(richiedente);
			}
			if(pratica.isNew() && pratica.getDatiCatastali() != null){
				for (DatiCatastaliImmobile cat : pratica.getDatiCatastali()) {
					datiCatastaliRepository.save(cat);
				}
				pratica.setDatiCatastali(null);
			}
			if (pratica.getPreventivo() != null) {
				Preventivo preventivoSaved = preventivoRepository.save(pratica.getPreventivo());
				pratica.setPreventivo(preventivoSaved);
			}
			
			Pratica mergedPr = em.merge(pratica);
			log.info(String.format("Sto per salvare la pratica con NUMERO=%s - UUID contenitore: %s", pratica.getNumero(), pratica.getUuidContenitore()));
			savedPr = praticaRepository.save(mergedPr);
			log.info(String.format("Salvataggio eseguito... pratica con ID=%s salvata! - UUID contenitore: %s", savedPr.getId(), savedPr.getUuidContenitore()));
			
			if(numPratica != null) 
				numPraticaService.save(numPratica);

			if (nuovo) {
				String pathToBeCreated = String.format("%s%s %s" , 
						pratica.getTipologia().getCategoria().getNomeCompletoCategoria(),
						CategoriePratiche.SEPARATORE,
						pratica.getNumeroPratica().replace("/"," "));
				
				log.debug(String.format("Chiamo creaContenitore %s", pathToBeCreated));
				String uuidContenitore = documentaleService.creaContenitore(pathToBeCreated, CategoriePratiche.SEPARATORE, pratica.getOggettoRichiesta());
				savedPr.setUuidContenitore(uuidContenitore);
				
				log.debug(String.format("Sto per salvare la pratica con NUMERO=%s - UUID contenitore: %s", savedPr.getNumero(), savedPr.getUuidContenitore()));
				savedPr = praticaRepository.save(savedPr);
				log.info(String.format("Salvataggio eseguito... pratica con ID=%s salvata! - UUID contenitore: %s", savedPr.getId(), savedPr.getUuidContenitore()));
			}
			
			if (savedPr.getPareriPratica() != null) 
			{
				for (int i = 0; i < savedPr.getPareriPratica().size(); i++) {
					Parere parere = savedPr.getPareriPratica().get(i);				
					if(parere.getAllegatoParereRisposta() != null){
						log.debug("doc ="+parere.getAllegatoParereRisposta().getName());
						log.debug("allegato != null");
						File file = parere.getAllegatoParereRisposta();
	
						DocInfo docFileInfo = new DocInfo();
						//#SA# : Per alfresco Titolo, Note e Creator non servono.
						//       Per Diogene da verificare se sono necessari e se bastano.
						docFileInfo.setTitolo(parere.getTipoParere().getDescrizione());
						docFileInfo.setNote(parere.getDescrizione());
						//docFileInfo.setCreator(_creator);
						docFileInfo.setFile(ServiceHelper.convertFiletoDocFile(file));
	
						String uuidFileRisposta = documentaleService.uploadFile(docFileInfo, savedPr.getUuidContenitore()).getUuid();
	
						boolean canc = ServiceHelper.deleteFile(file);
						log.debug("file cancellato="+canc);
	
						savedPr.getPareriPratica().get(i).setUuidFileRisposta(uuidFileRisposta);
						savedPr.getPareriPratica().get(i).setNomeFileRisposta(parere.getAllegatoParereRisposta().getName());
						parereRepository.save(savedPr.getPareriPratica().get(i));
					}
					if(parere.getAllegatoParereUscita() != null){
						log.debug("doc ="+parere.getAllegatoParereUscita().getName());
						log.debug("allegato != null");
						File file = parere.getAllegatoParereUscita();
						//parere.getAllegatoParereUscita().transferTo(file);
	
						DocInfo docFileInfo = new DocInfo();
						//#SA# : Per alfresco Titolo, Note e Creator non servono.
						//       Per Diogene da verificare se sono necessari e se bastano.
						docFileInfo.setTitolo(parere.getTipoParere().getDescrizione());
						docFileInfo.setNote(parere.getDescrizione());
						//docFileInfo.setCreator(_creator);
						docFileInfo.setFile(ServiceHelper.convertFiletoDocFile(file));
	
						String uuidFileUscita = documentaleService.uploadFile(docFileInfo, savedPr.getUuidContenitore()).getUuid();
	
						boolean canc = ServiceHelper.deleteFile(file);
						log.debug("file cancellato="+canc);
						savedPr.getPareriPratica().get(i).setUuidFileUscita(uuidFileUscita);
						savedPr.getPareriPratica().get(i).setNomeFileUscita(parere.getAllegatoParereUscita().getName());
						parereRepository.save(savedPr.getPareriPratica().get(i));
					}
				}
			}
			logAllegati(pratica.getAllegati());
			for(int j=0; j < pratica.getAllegati().size(); j++){
				AllegatiPratica allegato = pratica.getAllegati().get(j);
				if(allegato.getAllegato() != null){
					log.debug(String.format("allegato=%s - isFirmaDaValidare=%s", allegato.getAllegati().getNomeDocumento(), allegato.isFirmaDaValidare()));
					boolean doCaricamento = true;
					if (Boolean.parseBoolean(validaDomandaFirmata) && allegato.isFirmaDaValidare()) {
						byte[] fileContent = ServiceHelper.getBytesFromFile(allegato.getAllegato());
						String verifica = SignatureManager.checkPadesSignature(fileContent, new String[] { helper.getOsApulieUserDetails().getLiferayUser().getScreenName() });
						log.debug(String.format("SignatureManager.checkPadesSignature verifica=%s", verifica));
						
						if (verifica != "OK") {
							doCaricamento = false;
							throw new ServiceLayerException("Il documento non contiene una firma digitale valida");
						}
					}
					
					if (doCaricamento)
						caricaInDocumentale(pratica.getUuidContenitore(), allegato, savedPr.getAllegati().get(j));
				} else {
					log.debug(String.format("allegato=%s-%s :: file associato null!!", allegato.getId(), allegato.getAllegati().getNomeDocumento()));
				}
			}
			for(int j=0; j < pratica.getCampiaggiuntivi().size(); j++){
				CampiAggiuntiviPratica ca = pratica.getCampiaggiuntivi().get(j);
				if(ca.getCampiAggiuntivi() != null){
					if(ca.getCampiAggiuntivi().getTipologia().equals("i") && ca.getAllegato() != null){
						log.debug("doc ="+ca.getAllegato().getName());
						log.debug("CA allegato != null");
						File file = ca.getAllegato();
	
						DocInfo docFileInfo = new DocInfo();
						//#SA# : Per alfresco Titolo, Note e Creator non servono.
						//       Per Diogene da verificare se sono necessari e se bastano.
						docFileInfo.setTitolo(ca.getCampiAggiuntivi().getLabel());
						docFileInfo.setFile(ServiceHelper.convertFiletoDocFile(file));
	
						String uuidFileCA = documentaleService.uploadFile(docFileInfo, pratica.getUuidContenitore()).getUuid();
	
						boolean canc = ServiceHelper.deleteFile(file);
						log.debug("file cancellato="+file.getName());
	
						pratica.getCampiaggiuntivi().get(j).setUuidFile(uuidFileCA);
						pratica.getCampiaggiuntivi().get(j).setNomeFile(ca.getAllegato().getName());
						campiAggPraticaRepository.save(pratica.getCampiaggiuntivi().get(j));
					}
				}
			}
			
			// AGGIUNGO LE ATTIVITA' AL CALENDARIO
			if (calendarioService != null && pratica != null) {
				List<Appuntamento> listaAppuntamenti = new ArrayList<Appuntamento>();
				listaAppuntamenti.addAll(generaListaAppuntamentiDaAttivita(pratica));
				HashMap<Long, Long> resultMap = calendarioService.generaAppuntamentiDaLista(listaAppuntamenti);
				for (Long id : resultMap.keySet()) {
					AttivitaPratica ap = attivitaPraticaRepository.findOne(id);
					if (ap != null) {
						ap.setIdEventoCalendario(resultMap.get(id));
						attivitaPraticaRepository.save(ap);
					}
				}
			}
			
			return savedPr;
		} catch (Exception e) {
			if (nuovo) {
				if (documentaleService.consenteEliminaFile()) {
					if (pratica!=null && savedPr.getUuidContenitore()!=null)
						try {
							documentaleService.eliminaDirectory(savedPr.getUuidContenitore());
						}
						catch(DocumentaleException e1) {
							throw new ServiceLayerException("There was an error when removeing folder of type Pratica :: " + e.getMessage(), e);
						}
				}
			}
			throw new ServiceLayerException("There was an error when saving an object of type Pratica :: " + e.getMessage(), e);
		}
	}
	
	private TipoPraticaAttivita findByAttivitaAndTipologia(TipoPratica tipoPratica,Attivita attivita) {
		TipoPraticaAttivita result = null;
		for(TipoPraticaAttivita tipoPraticaAttivita:tipoPratica.getTipoPraticaAttivita()) {
			if (tipoPraticaAttivita.getAttivita().getId().equals(attivita.getId())) {
				result = tipoPraticaAttivita;
				break;
			}
		}
		return result;
	}
	public void caricaInDocumentale(String uuidContenitore, AllegatiPratica allegato, AllegatiPratica savedAllegato) throws Exception{
		log.info(String.format("caricaInDocumentale :: uuidContenitore=%s - titolo=%s", uuidContenitore, allegato.getAllegati().getNomeDocumento()));
		File file = allegato.getAllegato();

		DocInfo docFileInfo = new DocInfo();
		//#SA# : Per alfresco Titolo, Note e Creator non servono.
		//       Per Diogene da verificare se sono necessari e se bastano.
		docFileInfo.setTitolo(allegato.getAllegati().getNomeDocumento());
		docFileInfo.setFile(ServiceHelper.convertFiletoDocFile(file));

		String uuidAllegato = documentaleService.uploadFile(docFileInfo, uuidContenitore).getUuid();
		
		//mi calcolo l'impronta e la memorizzo nell'allegato
		byte[] content = null;
		try {
			InputStream inputStream= new FileInputStream(file);					
			content = ContentUtils.convertToByteArray(inputStream);
			inputStream.close();						
			} catch (Exception e1) {
				throw new Exception("Lettura file non riuscita", e1);
			}
		
		if(content != null){
			String impronta = CheckSumGenerator.generateCheckSum(content);
			savedAllegato.setImpronta(impronta);
		}
		
		boolean canc = ServiceHelper.deleteFile(file);
		log.debug("file cancellato="+canc);

		savedAllegato.setUuidFile(uuidAllegato);
		savedAllegato.setNomeFile(allegato.getAllegato().getName());
		savedAllegato.setCaricato(true);
		savedAllegato = allegatiRepository.save(savedAllegato);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * it.sincon.gepred..service.GestionePraticaService#deleteAllegatoParere(long)
	 */
	public void deleteAllegatoParere(long pk,String verso){
		Parere parere = parereRepository.findOne(pk);
		String uuid = null;
		if (verso.equals("risposta"))
			uuid = 	parere.getUuidFileRisposta();
		else if	(verso.equals("uscita"))
			uuid = 	parere.getUuidFileUscita();
		log.debug("elimino il nodo con uuid="+uuid);
		try{
			documentaleService.eliminaFile(uuid);
			if (verso.equals("risposta")){
				parere.setUrlAllegatoRisposta("");
				parere.setUuidFileRisposta(null);
				parere.setNomeFileRisposta(null);
			}
			else if (verso.equals("uscita")){
				parere.setUrlAllegatoUscita("");
				parere.setUuidFileUscita(null);
				parere.setNomeFileUscita(null);
			}
			parereRepository.save(parere);
		}catch (Exception e) {
			throw new ServiceLayerException(
					"There was an error when delete an object of type Allegato Parere :: "
							+ e.getMessage(), e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * it.sincon.gepred..service.GestionePraticaService#deleteAllegato(long)
	 */
	public void deleteAllegato(long pk){
		AllegatiPratica allegato = allegatiRepository.findOne(pk);
		String uuid = allegato.getUuidFile();
		log.debug("elimino il nodo con uuid="+uuid);
		try{
			documentaleService.eliminaFile(uuid);
			allegato.setUrlAllegato("");
			allegato.setUuidFile(null);
			allegatiRepository.save(allegato);
		}catch (Exception e) {
			throw new ServiceLayerException(
					"There was an error when delete an object of type Allegato :: "
							+ e.getMessage(), e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * it.sincon.gepred..service.GestionePraticaService#deleteAllegato(long)
	 */
	public void deleteAllegatoCA(long pk){
		CampiAggiuntiviPratica ca = campiAggPraticaRepository.findOne(pk);
		log.debug("elimino il nodo con uuid="+ca.getUuidFile());
		try{
			documentaleService.eliminaFile(ca.getUuidFile());
			ca.setValore("");
			ca.setUuidFile(null);
			ca.setNomeFile(null);
			campiAggPraticaRepository.save(ca);
		}catch (Exception e) {
			throw new ServiceLayerException(
					"There was an error when delete an object of type CampiAggiuntiviPratica :: "
							+ e.getMessage(), e);
		}
	}

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
	public Pratica getPraticaByAssegnatari(ProfiloUtente utente) throws ServiceLayerException {
		return praticaRepository.findByAssegnatariAndDataScadenzaIsNull(utente);
	}
	
	public Pratica getPraticaByNumero(String numero) throws ServiceLayerException{
		return praticaRepository.findByNumeroPratica(numero);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.osapulie.service.PraticaService#uploadDocumento(String path,String numPratica)
	 */
	// Dovrebbe restituire un AllegatiPratica
	public String uploadDocumento(File file,String uuidContenitore) throws ServiceLayerException {
		String doc = null;
		try{							
			//			doc = documentHandler.addDocument(file,numPratica.replace("/", ""));

			DocInfo docFileInfo = new DocInfo();
			//#SA# : Per alfresco Titolo, Note e Creator non servono.
			//       Per Diogene da verificare se sono necessari e se bastano.
			docFileInfo.setTitolo("Scansione di "+file.getName());
			//docFileInfo.setNote(allegato.);
			//docFileInfo.setCreator(_creator);
			docFileInfo.setFile(ServiceHelper.convertFiletoDocFile(file));

			documentaleService.uploadFile(docFileInfo, uuidContenitore).getUuid();

			/* Da Verificare
			DocInfo docCaricato = documentaleService.uploadFile(docFileInfo, uuidContenitore);
			AllegatiPratica allegatoPratica = new AllegatiPratica();
			Allegati allegato = new Allegati();
			allegato.setNomeDocumento(docCaricato.getTitolo());
			allegatoPratica.setAllegati(allegato);
			allegatoPratica.setCaricato(true);
			allegatoPratica.setUuidFile(docCaricato.getUuid());
			allegatoPratica.setNomeFile(docCaricato.getFile().getNome());
			return allegatoPratica;
			 */ // Da Verificare

			log.debug("doc="+doc);
			ServiceHelper.deleteFile(file);
		}catch (Exception e) {
			throw new ServiceLayerException(
					"There was an error when upload an object of type File :: "
							+ e.getMessage(), e);
		}
		return doc;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.osapulie.service.PraticaService#deletePratica(long)
	 */
	public void deletePratica(Pratica pratica) throws ServiceLayerException {
//		if (workflowHelper != null)
//			workflowHelper.deleteWorkflow(pratica);
		praticaRepository.delete(pratica.getId());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.osapulie.service.PraticaService#deletePratica(long)
	 */
	public int generaNumeroPratica(String prefisso, String anno) throws ServiceLayerException {
		// select max(convert(substring_index(substring_index(numero,'/',-2),'/',1),unsigned)+1) as num from tb_pratica as pr where substring_index(numero,'/',-1)='2014' and substring_index(numero,'/',1)='AABB'
		String queryString;
		if (prefisso != null && !prefisso.equals("")) // con prefisso
			queryString = "select (MAX(CONVERT(SUBSTRING_INDEX(SUBSTRING_INDEX(pr.numero, '/', -2), '/', 1), UNSIGNED) + 1)) num from tb_pratica pr where SUBSTRING_INDEX(pr.numero, '/', -1) = ?1 and SUBSTRING_INDEX(pr.numero, '/', 1) = ?2 ";
		else // senza prefisso
			queryString = "select (MAX(CONVERT(SUBSTRING_INDEX(pr.numero, '/', 1), UNSIGNED) + 1)) num from tb_pratica pr where SUBSTRING_INDEX(pr.numero, '/', -1) = ?1";
		
		Query query = em.createNativeQuery(queryString);
		if (prefisso != null && !prefisso.equals("")) { // con prefisso
			if (anno != null && !anno.equals("") && prefisso != null && !prefisso.equals("")) {
				query.setParameter(1, anno);
				query.setParameter(2, prefisso);
			} else {
				query.setParameter(1, DateUtils.getAnnoCorrente());
				query.setParameter(2, prefisso);
			}
		} else { // senza prefisso
			if (anno != null && !anno.equals("")) {
				query.setParameter(1, anno);
			} else {
				query.setParameter(1, DateUtils.getAnnoCorrente());
			}
		}
		BigInteger num = (BigInteger) query.getSingleResult();
		if (num != null)
			return (int) num.intValue();
		else
			return 1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.osapulie.service.PraticaService#deletePratica(long)
	 */
	public int generaContatore(long idField,String anno) throws ServiceLayerException {
		String queryString = "select (MAX( CONVERT( SUBSTRING_INDEX( cap.valore, '/', 1 ) , UNSIGNED ) ) +1) num from tb_ca_pratica cap where cap.fk_campiaggiuntivi= ?1 and SUBSTRING_INDEX(cap.valore,'/',-1) = ?2 ";
		Query query = em.createNativeQuery(queryString);
		query.setParameter(1, idField);
		if (anno != null && !anno.equals("")) {
			query.setParameter(2, anno);
		} else
			query.setParameter(2, DateUtils.getAnnoCorrente());
		BigInteger num = (BigInteger) query.getSingleResult();
		if (num != null)
			return (int) num.intValue();
		else
			return 1;
	}

	/**
	 * Metodo che dato il parametro tipologia di pratica in input, restituisce
	 * tutti i campi aggiuntivi con quella tipologia di pratica e anche i campi
	 * aggiuntivi con tipologia nulla.
	 */
	@SuppressWarnings("unchecked")
	public List<CampiAggiuntivi> getCampiAggiuntiviByTipoPratica(
			TipoPratica tipoPratica) {

		log.debug("selectCampiAggiuntivi CampiAggiuntivi:: entering method");
		String queryString = "select ca.ID, ca.controllo, ca.dimensione, ca.label, ca.listaValori, ca.note, "
				+ "ca.ricercabile, ca.tipologia, ca.fk_parent, ca.disabled, ca.classe_css, ca.labelBackOffice "
				+ "from tb_tipopratica_cagg cagg "
				+ "inner join tb_campiaggiuntivi ca on cagg.campiaggiuntivi_id = ca.ID "
				+ "where  ca.disabled = 0 and (cagg.tipopratica_id =?1) ORDER BY cagg.posizione";

		Query query = em.createNativeQuery(queryString, CampiAggiuntivi.class);
		query.setParameter(1, tipoPratica.getId());
		return (List<CampiAggiuntivi>) query.getResultList();
	}

	//	/**
	//	 * Verifico se esiste il site per la pratica fornita in input e setto le preferenze, altrimenti prima lo creo.
	//	 * @param praticaId
	//	 * @param prefs
	//	 * @throws Exception
	//	 */
	//	public void verifySitePratica(String praticaId,PortletPreferences prefs)throws Exception{
	//		String siteId = praticaId.replace("/", "");
	//
	//		if(siteAlfrescoManagerHelper.searchSite(siteId)){		
	//			prefs.setValue("siteId",siteId );			
	//			prefs.store();
	//			log.debug( "prefs="+prefs.getValue("siteId", "[DEFAULT]") );
	//		}
	//		else{
	//			siteAlfrescoManagerHelper.createSite(siteId,"Pratica "+praticaId);
	//			prefs.setValue("siteId",siteId );			
	//			prefs.store();
	//			log.debug( "prefs="+prefs.getValue("siteId", "[DEFAULT]") );
	//		}
	//	}

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

	public DatiRichiestaProtocollo creaProtocolloDaPratica(Pratica pratica) throws ServiceLayerException{
		DatiRichiestaProtocollo protocollo = new DatiRichiestaProtocollo();
		try
		{
			log.debug("call creaProtocolloDaPratica");
			protocollo.setOggetto(pratica.getOggettoRichiesta());
			for(AllegatiPratica allegato:pratica.getAllegati())
			{
				boolean found = false;
				if (protocollo.getAllegati()!=null)
				{
					for(int i=0;i<protocollo.getAllegati().size()&&!found;i++)
						found = allegato.getId().equals(protocollo.getAllegati().get(i).getIdAllegato());
				}
				log.debug("verifica situazione dati allegato: numProtocollo = "+allegato.getNumProtocollo()+" chiusura ");
				if (allegato.getUuidFile()!=null && !allegato.getUuidFile().equals("")&&(allegato.getNumProtocollo()==null||allegato.getNumProtocollo().trim().equals("")) &&!found)
				{
					AllegatoProtocollo daAllegare = new AllegatoProtocollo();
					daAllegare.setIdAllegato(allegato.getId());
					daAllegare.setNomeDocumento(allegato.getAllegati().getNomeDocumento());
					daAllegare.setDaAllegareProtocollazione(true);

					//daAllegare.setContenutoAllegato(this.downloadDocumento(pratica.getUuidContenitore(),allegato.getUuidFile()));
					if (allegato.getNomeFile().contains(nomeModello.replaceAll(" ", "_")))
						daAllegare.setUrlAllegato(nomeModello.replaceAll(" ", "_")+".pdf.p7m");
					else
						daAllegare.setUrlAllegato(allegato.getNomeFile());
					daAllegare.setCollocazione(pratica.getUuidContenitore()+" "+allegato.getUuidFile());
					if (protocollo.getAllegati()==null)
					{
						List<AllegatoProtocollo> elenco=new ArrayList<AllegatoProtocollo>();
						protocollo.setAllegati(elenco);
					}
					protocollo.getAllegati().add(daAllegare);
				}
			}

			if (pratica.getRichiedente()!=null)
				aggiungiReferenteAProtocollo(pratica.getRichiedente(), protocollo);
		}
		catch(Exception e)
		{
			throw new ServiceLayerException("Errore nell'allineamento dei dati del protocollo ::"+e.getMessage(),e);
		}
		return protocollo;
	}

	public DatiRichiestaProtocollo creaProtocolloDaAllegato(Pratica pratica,Long idAllegato) throws ServiceLayerException
	{
		DatiRichiestaProtocollo result = new DatiRichiestaProtocollo();
		try
		{
			log.debug("call creaProtocolloDaAllegato");
			boolean found=false;
			for(int i=0;i<pratica.getAllegati().size() && !found;i++)
			{
				found = pratica.getAllegati().get(i).getId().equals(idAllegato);
				if (found)
				{
					log.debug("sono entrato nel ramo found");
					AllegatoProtocollo daAllegare = new AllegatoProtocollo();
					daAllegare.setIdAllegato(pratica.getAllegati().get(i).getId());
					daAllegare.setNomeDocumento(pratica.getAllegati().get(i).getAllegati().getNomeDocumento());
					if (pratica.getAllegati().get(i).getUuidFile()!=null && !pratica.getAllegati().get(i).getUuidFile().trim().equals(""))
					{
						//daAllegare.setContenutoAllegato(this.downloadDocumento(pratica.getUuidContenitore(),pratica.getAllegati().get(i).getUuidFile()));
						daAllegare.setUrlAllegato(pratica.getAllegati().get(i).getNomeFile());
						daAllegare.setCollocazione(pratica.getUuidContenitore()+" "+pratica.getAllegati().get(i).getUuidFile());
					}
					result.setAllegati(new ArrayList<AllegatoProtocollo>());
					result.getAllegati().add(daAllegare);
					result.setDocumentoPrincipale(daAllegare);
					log.debug("dimensione elenco allegati in uscita dal ramo found = "+result.getAllegati().size());
				}
			}
		}
		catch(Exception e)
		{
			throw new ServiceLayerException("Errore nell'allineamento dei dati del protocollo all'allegato ::"+e.getMessage(),e);
		}
		return result;
	}

	public DatiRichiestaProtocollo creaProtocolloDaParere(Pratica pratica,Long idParere,String verso)throws ServiceLayerException
	{
		DatiRichiestaProtocollo result = new DatiRichiestaProtocollo();
		try
		{
			if (verso.equals("uscita"))
				result.setTipoProtocollo("U");
			else if (verso.equals("risposta"))
				result.setTipoProtocollo("I");
			boolean found=false;
			for(int i=0;i<pratica.getPareriPratica().size()&& !found;i++)
			{
				found=pratica.getPareriPratica().get(i).getId().equals(idParere);
				if (found)
				{
					if (verso.equals("uscita"))
					{
						if (pratica.getPareriPratica().get(i).getUuidFileUscita()!=null && !pratica.getPareriPratica().get(i).getUuidFileUscita().trim().equals(""))
						{
							AllegatoProtocollo documentoPrincipale=new AllegatoProtocollo();
							log.debug("start Index = "+pratica.getPareriPratica().get(i).getNomeFileUscita());
							documentoPrincipale.setNomeDocumento(pratica.getPareriPratica().get(i).getNomeFileUscita());
							//documentoPrincipale.setContenutoAllegato(this.downloadDocumento(pratica.getUuidContenitore(),pratica.getPareriPratica().get(i).getUuidFileUscita())); 
							documentoPrincipale.setUrlAllegato(pratica.getPareriPratica().get(i).getNomeFileUscita());
							documentoPrincipale.setCollocazione(pratica.getUuidContenitore()+" "+pratica.getPareriPratica().get(i).getUuidFileUscita());
							result.setAllegati(new ArrayList<AllegatoProtocollo>());
							result.getAllegati().add(documentoPrincipale);
							result.setDocumentoPrincipale(documentoPrincipale);
						}
					}
					else if(verso.equals("risposta"))
					{
						if (pratica.getPareriPratica().get(i).getUuidFileRisposta()!=null && !pratica.getPareriPratica().get(i).getUuidFileRisposta().trim().equals(""))
						{
							AllegatoProtocollo documentoPrincipale=new AllegatoProtocollo();
							log.debug("start Index = "+pratica.getPareriPratica().get(i).getNomeFileRisposta());
							documentoPrincipale.setNomeDocumento(pratica.getPareriPratica().get(i).getNomeFileRisposta());
							//documentoPrincipale.setContenutoAllegato(this.downloadDocumento(pratica.getUuidContenitore(),pratica.getPareriPratica().get(i).getUuidFileRisposta())); 
							documentoPrincipale.setUrlAllegato(pratica.getPareriPratica().get(i).getNomeFileRisposta());
							documentoPrincipale.setCollocazione(pratica.getUuidContenitore()+" "+pratica.getPareriPratica().get(i).getUuidFileRisposta());
							result.setAllegati(new ArrayList<AllegatoProtocollo>());
							result.getAllegati().add(documentoPrincipale);
							result.setDocumentoPrincipale(documentoPrincipale);
						}
					}
				}
			}
		}
		catch(Exception e)
		{
			throw new ServiceLayerException("Errore nell'allineamento dei dati del protocollo dal parere ::"+e.getMessage(),e);
		}
		return result;
	}

	public DatiRichiestaProtocollo leggiProtocolloDaPraticaPerCompletamento(Pratica pratica)throws ServiceLayerException
	{
		DatiRichiestaProtocollo result = null;
		try
		{
			DatiOutputProtocollo dop = generaDatiConsultazioneProtocolloDaPratica(pratica);
			result = consultaProtocollo(dop);
			result.setAllegati(new ArrayList<AllegatoProtocollo>());
			for(AllegatiPratica allegato:pratica.getAllegati())
			{
				if (allegato.getUrlAllegato()!=null && !allegato.getUrlAllegato().equals("")&&(allegato.getNumProtocollo()==null||allegato.getNumProtocollo().trim().equals("")))
				{
					AllegatoProtocollo daAllegare = new AllegatoProtocollo();
					daAllegare.setIdAllegato(allegato.getId());
					daAllegare.setNomeDocumento(allegato.getAllegati().getNomeDocumento());
					//daAllegare.setContenutoAllegato(this.downloadDocumento(pratica.getUuidContenitore(),allegato.getUuidFile()));
					daAllegare.setCollocazione(pratica.getUuidContenitore()+" "+allegato.getUuidFile());
					daAllegare.setUrlAllegato(allegato.getNomeFile());
					result.getAllegati().add(daAllegare);
				}
			}

		}
		catch(Exception e)
		{
			throw new ServiceLayerException("Errore nella creazione del protocollo dalla pratica per operazione di completamento ::"+e.getMessage(),e);
		}
		return result;
	}

	public DatiOutputProtocollo protocollaPratica(
			DatiRichiestaProtocollo datiProtocollazione) {
		DatiAutenticazione autenticazione = new DatiAutenticazione();
		autenticazione.setUsername(helper.getOsApulieUserDetails().getProfiloUtenteCittadino().getUsernameProtocollo());
		autenticazione.setPassword(helper.getOsApulieUserDetails().getProfiloUtenteCittadino().getPasswordProtocollo());
		autenticazione.setIdUtente(helper.getOsApulieUserDetails().getProfiloUtenteCittadino().getIdUtenteProtocollo());
		autenticazione.setCodiceUfficio(helper.getOsApulieUserDetails().getProfiloUtenteCittadino().getCodiceUfficio());
		if (datiProtocollazione.getDocumentoPrincipale()!=null && datiProtocollazione.getDocumentoPrincipale().getCollocazione()!=null) {
			String[] uuid=datiProtocollazione.getDocumentoPrincipale().getCollocazione().split(" ");
			byte[] content = this.downloadDocumento(uuid[0], uuid[1]);
			datiProtocollazione.getDocumentoPrincipale().setContenutoAllegato(content);
		}
		return protocolloService.protocollaPratica(datiProtocollazione,autenticazione);
	}

	public DatiRichiestaProtocollo consultaProtocollo(
			DatiOutputProtocollo datiIdentificativiProtocollo) {
		DatiAutenticazione autenticazione = new DatiAutenticazione();
		autenticazione.setUsername(helper.getOsApulieUserDetails().getProfiloUtenteCittadino().getUsernameProtocollo());
		autenticazione.setPassword(helper.getOsApulieUserDetails().getProfiloUtenteCittadino().getPasswordProtocollo());
		autenticazione.setIdUtente(helper.getOsApulieUserDetails().getProfiloUtenteCittadino().getIdUtenteProtocollo());
		autenticazione.setCodiceUfficio(helper.getOsApulieUserDetails().getProfiloUtenteCittadino().getCodiceUfficio());
		return protocolloService.consultaProtocollo(datiIdentificativiProtocollo,autenticazione);
	}

	public DatiOutputProtocollo allegaDocumentoAProtocollo(
			AllegatoProtocollo allegato,
			DatiOutputProtocollo datiIdentificativiProtocollo) {
		DatiAutenticazione autenticazione = new DatiAutenticazione();
		autenticazione.setUsername(helper.getOsApulieUserDetails().getProfiloUtenteCittadino().getUsernameProtocollo());
		autenticazione.setPassword(helper.getOsApulieUserDetails().getProfiloUtenteCittadino().getPasswordProtocollo());
		autenticazione.setIdUtente(helper.getOsApulieUserDetails().getProfiloUtenteCittadino().getIdUtenteProtocollo());
		autenticazione.setCodiceUfficio(helper.getOsApulieUserDetails().getProfiloUtenteCittadino().getCodiceUfficio());
		if (allegato!=null && allegato.getCollocazione()!=null) {
			String[] uuid=allegato.getCollocazione().split(" ");
			byte[] content = this.downloadDocumento(uuid[0], uuid[1]);
			allegato.setContenutoAllegato(content);
		}
		return protocolloService.allegaDocumentoAProtocollo(allegato, datiIdentificativiProtocollo,autenticazione);
	}

	private DatiOutputProtocollo executeProtocolla(String tipoProtocollo,
			String nomeFileOriginal, String nomeModello, 
			ProfiloUtente profiloUtenteProtocollatore, Pratica pr, 
			byte[] contentPrincipale) 
					throws IOException {
		log.info("executeProtocolla...START");
		DatiOutputProtocollo datiOutputProtocollo = null;
		
		if (profiloUtenteProtocollatore!=null) {
			DatiAutenticazione datiAutenticazione = new DatiAutenticazione();
			datiAutenticazione.setUsername(profiloUtenteProtocollatore.getUsernameProtocollo());
			datiAutenticazione.setPassword(profiloUtenteProtocollatore.getPasswordProtocollo());
			datiAutenticazione.setCodiceUfficio(profiloUtenteProtocollatore.getCodiceUfficio());
			datiAutenticazione.setIdUtente(profiloUtenteProtocollatore.getIdUtenteProtocollo());
			DatiRichiestaProtocollo datiRichiestaProtocollo = new DatiRichiestaProtocollo();
			datiRichiestaProtocollo.setTipoProtocollo(tipoProtocollo);
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
			if (pr.getRichiedente()!=null) {
				email=pr.getRichiedente().getEmail();
				nome=pr.getRichiedente().getNome();
				cognome=pr.getRichiedente().getCognome();
				codiceFiscale=pr.getRichiedente().getCf();
				if (pr.getRichiedente().getComune() != null)
					comune=pr.getRichiedente().getComune().getDenominazione();
				indirizzo=pr.getRichiedente().getIndirizzo();
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
			log.info(String.format("esito protocollo: %s - numero protocollo: %s", datiOutputProtocollo.getEsito().getCodice(), datiOutputProtocollo.getNumeroProtocollo()));
		}
		
		log.info("executeProtocolla...END");
		return datiOutputProtocollo;
	}


	public void aggiungiReferenteAProtocollo(Referente ref,DatiRichiestaProtocollo protocollo) throws ServiceLayerException{
		try
		{
			boolean found = false;
			if (protocollo.getMittenteDestinatario()!=null)
			{
				for(int i=0;i<protocollo.getMittenteDestinatario().size() && !found;i++)
					found = ref.getId().equals(protocollo.getMittenteDestinatario().get(i).getIdMittenteDestinatario());
			}
			if (!found)
			{
				if (protocollo.getMittenteDestinatario()==null)
					protocollo.setMittenteDestinatario(new ArrayList<DatiMittenteDestinatario>());
				DatiMittenteDestinatario mittente = new DatiMittenteDestinatario();
				mittente.setIdMittenteDestinatario(ref.getId());
				mittente.setAzienda(ref.getTipologia().equals("e")||ref.getChkref());
				if (ref.getTipologia().equals("e")||ref.getChkref())
				{
					mittente.setNominativo(ref.getNominativo());
					mittente.setPartitaIva(ref.getPiva());
				}
				else
				{
					mittente.setNome(ref.getNome());
					mittente.setCognome(ref.getCognome());
					mittente.setCodiceFiscale(ref.getCf());
				}
				if (ref.getIndirizzo()!=null && !ref.getIndirizzo().equals(""))
					mittente.setIndirizzo(ref.getIndirizzo());
				else
					mittente.setIndirizzo("NON DEFINITO");
				mittente.setEmail(ref.getEmail());
				if (ref.getComune()!=null && ref.getComune().getDenominazione()!=null && !ref.getComune().getDenominazione().equals(""))
					mittente.setCitta(ref.getComune().getDenominazione());
				else
					mittente.setCitta("NON DEFINITO");
				protocollo.getMittenteDestinatario().add(mittente);
			}
		}
		catch(Exception e)
		{
			throw new ServiceLayerException("Errore nell'aggiunta del referente al protocollo ::"+e.getMessage(),e);
		}
	}

	public void rimuoviMittenteDestinatarioDaProtocollo(DatiRichiestaProtocollo protocollo,Integer daCancellare) throws ServiceLayerException{
		try
		{
			DatiMittenteDestinatario elementoCancellato = protocollo.getMittenteDestinatario().remove(daCancellare.intValue());
			log.debug(elementoCancellato.toString());
		}
		catch(Exception e)
		{
			throw new ServiceLayerException("Errore nella cancellazione di un Mittente/Destinatario dal protocollo ::"+e.getMessage(),e);
		}
	}

	public SortedMap<MezzoSpedizioneEnum, Serializable> traduciMezziSpedizione() {
		return protocolloService.traduciMezziSpedizione();
	}


	public boolean isPresentProtocollo()
	{
		return protocolloService!=null&&helper.getOsApulieUserDetails().getProfiloUtenteCittadino().getUsernameProtocollo()!=null&&!helper.getOsApulieUserDetails().getProfiloUtenteCittadino().getUsernameProtocollo().equals("")&&helper.getOsApulieUserDetails().getProfiloUtenteCittadino().getPasswordProtocollo()!=null&&!helper.getOsApulieUserDetails().getProfiloUtenteCittadino().getPasswordProtocollo().equals("");
	}

	public boolean isImplementedCompletamento()
	{
		return protocolloService!=null&&protocolloService.isImplementedCompletamento();
	}

	public boolean isImplementedProtocolloUscita()
	{
		return protocolloService!=null &&protocolloService.isImplementedProtocolloUscita();
	}


	public boolean isSettatoInviaPc()
	{
		return protocolloService!=null && protocolloService.isSettatoInviaPc();
	}

	public void riversaDatiProtocolloInPratica(DatiRichiestaProtocollo datiProtocollo,Pratica pratica) throws ServiceLayerException
	{
		try
		{
			pratica.setNumeroProtocollo(datiProtocollo.getDatiProtocollazione().getNumeroProtocollo());
			pratica.setDataProtocollo(datiProtocollo.getDatiProtocollazione().getDataProtocollo());
			pratica.setCompletato(datiProtocollo.getDocumentoPrincipale()!=null);
			if (datiProtocollo.getAllegati()!=null)
			{
				for(int i = 0;i<datiProtocollo.getAllegati().size();i++)
				{
					AllegatoProtocollo allegato = datiProtocollo.getAllegati().get(i);
					if (allegato.isDaAllegareProtocollazione() || (datiProtocollo.getDocumentoPrincipale()!=null && datiProtocollo.getDocumentoPrincipale()==allegato))
					{
						boolean found = false;
						for(int j=0;j<pratica.getAllegati().size() && !found;j++)
						{
							found = pratica.getAllegati().get(j).getId().equals(allegato.getIdAllegato());
							if (found)
							{
								pratica.getAllegati().get(j).setTipoProtocollo(datiProtocollo.getTipoProtocollo());
								pratica.getAllegati().get(j).setDataProtocollo(datiProtocollo.getDatiProtocollazione().getDataProtocollo());
								pratica.getAllegati().get(j).setNumProtocollo(datiProtocollo.getDatiProtocollazione().getNumeroProtocollo());
								pratica.getAllegati().get(j).setCompletato(true);
							}

						}
					}
				}
			}
		}
		catch(Exception e)
		{
			throw new ServiceLayerException("Errore nel riversamento dei dati dal protocollo alla pratica::"+e.getMessage(),e);
		}
	}

	public void riversaDatiProtocolloInAllegato(DatiRichiestaProtocollo datiProtocollo,Pratica pratica) throws ServiceLayerException
	{
		try
		{
			log.debug("call riversaDatiProtocolloInAllegato");
			for(int i = 0;i<datiProtocollo.getAllegati().size();i++)
			{
				AllegatoProtocollo allegato = datiProtocollo.getAllegati().get(i);
				if (allegato.isDaAllegareProtocollazione() || (datiProtocollo.getDocumentoPrincipale()!=null && datiProtocollo.getDocumentoPrincipale()==allegato))
				{
					boolean found = false;
					for(int j=0;j<pratica.getAllegati().size() && !found;j++)
					{
						found = pratica.getAllegati().get(j).getId().equals(allegato.getIdAllegato());
						if (found)
						{
							pratica.getAllegati().get(j).setTipoProtocollo(datiProtocollo.getTipoProtocollo());
							pratica.getAllegati().get(j).setDataProtocollo(datiProtocollo.getDatiProtocollazione().getDataProtocollo());
							pratica.getAllegati().get(j).setNumProtocollo(datiProtocollo.getDatiProtocollazione().getNumeroProtocollo());
							log.debug("verifica completamento = "+(pratica.getAllegati().get(j).getUrlAllegato()!=null && !pratica.getAllegati().get(j).getUrlAllegato().trim().equals("")));
							pratica.getAllegati().get(j).setCompletato(pratica.getAllegati().get(j).getUrlAllegato()!=null && !pratica.getAllegati().get(j).getUrlAllegato().trim().equals(""));
						}

					}
				}
			}
		}
		catch(Exception e)
		{
			throw new ServiceLayerException("Errore nel riversamento dei dati dal protocollo agli allegati::"+e.getMessage(),e);
		}
	}

	public void riversaDatiProtocolloInParere(DatiRichiestaProtocollo datiProtocollo,Pratica pratica,Long idParere,String verso)throws ServiceLayerException
	{
		try
		{
			boolean found = false;
			for(int i=0;i<pratica.getPareriPratica().size() && !found ;i++)
			{
				found = pratica.getPareriPratica().get(i).getId().equals(idParere);
				if (found)
				{
					if (verso.equals("uscita"))
					{
						pratica.getPareriPratica().get(i).setDataProtoUscita(datiProtocollo.getDatiProtocollazione().getDataProtocollo());
						pratica.getPareriPratica().get(i).setNumeroProtoUscita(datiProtocollo.getDatiProtocollazione().getNumeroProtocollo());
						pratica.getPareriPratica().get(i).setCompletatoUscita(datiProtocollo.getDocumentoPrincipale()!=null);
					}
					else if ( verso.equals("risposta"))
					{
						pratica.getPareriPratica().get(i).setDataProtoRisposta(datiProtocollo.getDatiProtocollazione().getDataProtocollo());
						pratica.getPareriPratica().get(i).setNumeroProtoRisposta(datiProtocollo.getDatiProtocollazione().getNumeroProtocollo());
						pratica.getPareriPratica().get(i).setCompletatoRisposta(datiProtocollo.getDocumentoPrincipale()!=null);
					}
				}
			}
		}
		catch(Exception e)
		{
			throw new ServiceLayerException("Errore nel riversamento dei dati dal protocollo al parere::"+e.getMessage(),e);
		}
	}

	public DatiOutputProtocollo completaProtocollazioneProvvisoria(AllegatoProtocollo documentoPrincipale,DatiOutputProtocollo datiIdentificativiProtocollo)
	{
		DatiAutenticazione autenticazione = new DatiAutenticazione();
		autenticazione.setUsername(helper.getOsApulieUserDetails().getProfiloUtenteCittadino().getUsernameProtocollo());
		autenticazione.setPassword(helper.getOsApulieUserDetails().getProfiloUtenteCittadino().getPasswordProtocollo());
		autenticazione.setIdUtente(helper.getOsApulieUserDetails().getProfiloUtenteCittadino().getIdUtenteProtocollo());
		autenticazione.setCodiceUfficio(helper.getOsApulieUserDetails().getProfiloUtenteCittadino().getCodiceUfficio());
		return protocolloService.completaProtocollazioneProvvisoria(documentoPrincipale, datiIdentificativiProtocollo,autenticazione);
	}


	public DatiOutputProtocollo generaDatiConsultazioneProtocolloDaPratica(Pratica pr) throws ServiceLayerException
	{
		DatiOutputProtocollo result = new DatiOutputProtocollo();
		try
		{
			result.setNumeroProtocollo(pr.getNumeroProtocollo());
			result.setDataProtocollo(pr.getDataProtocollo());
		}
		catch(Exception e)
		{
			throw new ServiceLayerException("Errore nella generazione dei dati di consultazione del protocollo dalla pratica::"+e.getMessage(),e);
		}
		return result;
	}

	public DatiOutputProtocollo generaDatiConsultazioneProtocolloDaAllegato(Pratica pr,Long idAllegato) throws ServiceLayerException
	{
		log.info("call generaDatiConsultazioneProtocolloDaAllegato");
		DatiOutputProtocollo result = new DatiOutputProtocollo();
		try
		{
			boolean found=false;
			for(int i=0;i<pr.getAllegati().size() && !found;i++)
			{
				found = pr.getAllegati().get(i).getId().equals(idAllegato);
				if (found)
				{

					log.info("Numero protocollo: "+pr.getAllegati().get(i).getNumProtocollo());
					result.setDataProtocollo(pr.getAllegati().get(i).getDataProtocollo());
					result.setNumeroProtocollo(pr.getAllegati().get(i).getNumProtocollo());
				}
			}
		}
		catch(Exception e)
		{
			throw new ServiceLayerException("Errore nella generazione dei dati di consultazione del protocollo dall'allegato::"+e.getMessage(),e);
		}
		return result;
	}

	public DatiOutputProtocollo generaDatiConsultazioneProtocolloDaParere(Pratica pr,Long idParere,String verso) throws ServiceLayerException
	{
		DatiOutputProtocollo result = new DatiOutputProtocollo();
		try
		{
			boolean found = false;
			for(int i=0;i<pr.getPareriPratica().size() && !found;i++)
			{
				found = pr.getPareriPratica().get(i).getId().equals(idParere);
				if (found)
				{
					if (verso.equals("uscita"))
					{
						result.setDataProtocollo(pr.getPareriPratica().get(i).getDataProtoUscita());
						result.setNumeroProtocollo(pr.getPareriPratica().get(i).getNumeroProtoUscita());
					}
					else if (verso.equals("risposta"))
					{
						result.setDataProtocollo(pr.getPareriPratica().get(i).getDataProtoRisposta());
						result.setNumeroProtocollo(pr.getPareriPratica().get(i).getNumeroProtoRisposta());
					}
				}
			}
		}
		catch(Exception e)
		{
			throw new ServiceLayerException("Errore nella generazione dei dati di consultazione del protocollo dal parere::"+e.getMessage(),e);
		}
		return result;
	}

	public DatiOutputProtocollo generaRichiestaCompletamentoProtocolloDaParere(Pratica pratica,Long idParere,String verso) throws ServiceLayerException
	{
		DatiOutputProtocollo result = null;
		try
		{
			boolean found = false;
			DatiOutputProtocollo datiIdentificativiProtocollo = new DatiOutputProtocollo();
			AllegatoProtocollo documentoPrincipale = new AllegatoProtocollo();
			for(int i=0;i<pratica.getPareriPratica().size() && !found;i++)
			{
				found=pratica.getPareriPratica().get(i).getId().equals(idParere);
				if (found)
				{
					if (verso.equals("uscita"))
					{
						datiIdentificativiProtocollo.setDataProtocollo(pratica.getPareriPratica().get(i).getDataProtoUscita());
						datiIdentificativiProtocollo.setNumeroProtocollo(pratica.getPareriPratica().get(i).getNumeroProtoUscita());
						documentoPrincipale.setNomeDocumento(pratica.getPareriPratica().get(i).getUrlAllegatoUscita().substring(pratica.getPareriPratica().get(i).getUrlAllegatoUscita().lastIndexOf("/")+1,pratica.getPareriPratica().get(i).getUrlAllegatoUscita().lastIndexOf(".")));
						//documentoPrincipale.setContenutoAllegato(this.downloadDocumento(pratica.getUuidContenitore(),pratica.getPareriPratica().get(i).getUuidFileUscita())); 
						documentoPrincipale.setUrlAllegato(pratica.getPareriPratica().get(i).getNomeFileUscita());
						documentoPrincipale.setCollocazione(pratica.getUuidContenitore()+" "+pratica.getPareriPratica().get(i).getUuidFileUscita());
					}
					else if (verso.equals("risposta"))
					{
						datiIdentificativiProtocollo.setDataProtocollo(pratica.getPareriPratica().get(i).getDataProtoRisposta());
						datiIdentificativiProtocollo.setNumeroProtocollo(pratica.getPareriPratica().get(i).getNumeroProtoRisposta());
						documentoPrincipale.setNomeDocumento(pratica.getPareriPratica().get(i).getUrlAllegatoRisposta().substring(pratica.getPareriPratica().get(i).getUrlAllegatoRisposta().lastIndexOf("/")+1,pratica.getPareriPratica().get(i).getUrlAllegatoRisposta().lastIndexOf(".")));
						//documentoPrincipale.setContenutoAllegato(this.downloadDocumento(pratica.getUuidContenitore(),pratica.getPareriPratica().get(i).getUuidFileRisposta())); 
						documentoPrincipale.setUrlAllegato(pratica.getPareriPratica().get(i).getNomeFileRisposta());
						documentoPrincipale.setCollocazione(pratica.getUuidContenitore()+" "+pratica.getPareriPratica().get(i).getUuidFileRisposta());
					}
					DatiAutenticazione autenticazione = new DatiAutenticazione();
					autenticazione.setUsername(helper.getOsApulieUserDetails().getProfiloUtenteCittadino().getUsernameProtocollo());
					autenticazione.setPassword(helper.getOsApulieUserDetails().getProfiloUtenteCittadino().getPasswordProtocollo());
					autenticazione.setIdUtente(helper.getOsApulieUserDetails().getProfiloUtenteCittadino().getIdUtenteProtocollo());
					result = protocolloService.completaProtocollazioneProvvisoria(documentoPrincipale, datiIdentificativiProtocollo,autenticazione);
					if (result.getEsito().getCodice().equals("000"))
					{
						if (verso.equals("uscita"))
							pratica.getPareriPratica().get(i).setCompletatoUscita(true);
						else if (verso.equals("risposta"))
							pratica.getPareriPratica().get(i).setCompletatoRisposta(true);
					}
				}
			}
		}
		catch(Exception e)
		{
			throw new ServiceLayerException("Errore nella richiesta di completamento del protocollo dal parere in "+verso+"::"+e.getMessage(),e);
		}
		return result;
	}

	public DatiOutputProtocollo generaRichiestaCompletamentoProtocolloDaAllegato(Pratica pratica,Long idAllegato)throws ServiceLayerException
	{
		DatiOutputProtocollo result = null;
		try
		{
			boolean found = false;
			DatiOutputProtocollo datiIdentificativiProtocollo = new DatiOutputProtocollo();
			AllegatoProtocollo documentoPrincipale = new AllegatoProtocollo();
			for(int i=0;i<pratica.getAllegati().size() && !found;i++)
			{
				found=pratica.getAllegati().get(i).getId().equals(idAllegato);
				if (found)
				{
					AllegatiPratica allegato = pratica.getAllegati().get(i);
					datiIdentificativiProtocollo.setDataProtocollo(allegato.getDataProtocollo());
					datiIdentificativiProtocollo.setNumeroProtocollo(allegato.getNumProtocollo());
					documentoPrincipale.setIdAllegato(allegato.getId());
					documentoPrincipale.setNomeDocumento(allegato.getAllegati().getNomeDocumento());
					//documentoPrincipale.setContenutoAllegato(this.downloadDocumento(pratica.getUuidContenitore(),allegato.getUuidFile()));
					documentoPrincipale.setCollocazione(pratica.getUuidContenitore()+" "+allegato.getUuidFile());
					documentoPrincipale.setUrlAllegato(allegato.getNomeFile());
					DatiAutenticazione autenticazione = new DatiAutenticazione();
					autenticazione.setUsername(helper.getOsApulieUserDetails().getProfiloUtenteCittadino().getUsernameProtocollo());
					autenticazione.setPassword(helper.getOsApulieUserDetails().getProfiloUtenteCittadino().getPasswordProtocollo());
					autenticazione.setIdUtente(helper.getOsApulieUserDetails().getProfiloUtenteCittadino().getIdUtenteProtocollo());
					result = protocolloService.completaProtocollazioneProvvisoria(documentoPrincipale, datiIdentificativiProtocollo,autenticazione);
					if (result.getEsito().getCodice().equals("000"))
						pratica.getAllegati().get(i).setCompletato(true);
				}
			}
		}
		catch(Exception e)
		{
			throw new ServiceLayerException("Errore nella richiesta di completamento del protocollo dall'allegato::"+e.getMessage(),e);
		}
		return result;
	}

	public List<AttivitaPratica> generaListaAttivita(TipoPratica tp) {
		List<AttivitaPratica> result = new ArrayList<AttivitaPratica>();
		for (TipoPraticaAttivita tpa : tp.getTipoPraticaAttivita()) {
			if(tpa.getAutomatica() == 0){
				AttivitaPratica ap = new AttivitaPratica();
				ap.setAttivita(tpa.getAttivita());
				result.add(ap);
			}				
		}
		return result;
	}
	
	private boolean isAttivitaDaCalendario(AttivitaPratica ap, TipoPratica tp){
		boolean result = false;
		
		for (TipoPraticaAttivita tpa :tp.getTipoPraticaAttivita()){
			if (tpa.getAttivita().getId().equals(ap.getAttivita().getId())){
				result = tpa.isDaCalendario();
				break;
			}
		}
		
		return result;
	}

	public List<Appuntamento> generaListaAppuntamentiDaAttivita(Pratica pratica) {
		List<Appuntamento> listaApp = new ArrayList<Appuntamento>();
		for (int i = 0; i < pratica.getAttivitaPratica().size(); i++) {
			if (isAttivitaDaCalendario(pratica.getAttivitaPratica().get(i), pratica.getTipologia())){
				Appuntamento app = new Appuntamento();
				app.setIdAttivita(pratica.getAttivitaPratica().get(i).getId());
				app.setIdUtente(pratica.getAttivitaPratica().get(i).getProfiloutente().getId());
				app.setTitolo(pratica.getAttivitaPratica().get(i).getAttivita().getDescrizione());
				if (!pratica.getAttivitaPratica().get(i).getDescrizione().equals(""))
					app.setDescrizione(pratica.getOggettoRichiesta() + " - " + pratica.getAttivitaPratica().get(i).getDescrizione());
				else
					app.setDescrizione(pratica.getOggettoRichiesta());
				app.setDataInizio(pratica.getAttivitaPratica().get(i).getDataAssegnazione());
				app.setDataScadenza(pratica.getAttivitaPratica().get(i).getDataScadenza());
				app.setIdEventoCalendario(pratica.getAttivitaPratica().get(i).getIdEventoCalendario());
				listaApp.add(app);
			}
		}
		return listaApp;
	}
	
	public Pratica dividiNumeroPratica(Pratica pratica) {
		if (pratica.getTipologia().getPrefisso() != null && !pratica.getTipologia().getPrefisso().equals("")) {
			String[] divided = pratica.getNumeroPratica().split("/");
			String prefix = divided[0];
			String numero = divided[1] + "/" + divided[2];
			pratica.setPrefisso(prefix);
			pratica.setNumero(numero);
		} else {
			pratica.setPrefisso("");
			pratica.setNumero(pratica.getNumeroPratica());
		}
		return pratica;
	}
	
	public List<ProfiloUtente> getRemainingProfiliUtente(Pratica pratica) {
		List<ProfiloUtente> result = null;
		if (pratica!=null && pratica.getTipologia()!=null)
		{
			result = profiloUtenteService.getAllProfiloUtenteByRuolo(pratica.getTipologia().getCategoria().getRuolo());
			/*String[] ruoliRicerca = ruoliReferentiAssegnatari.toLowerCase().split(",");
			result = profiloUtenteService.getProfiloUtenteNomeRuolo(ruoliRicerca);*/
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
	
	public List<ProfiloUtente> getUtentiRuoliVisibili() {
		List<ProfiloUtente> result = new ArrayList<ProfiloUtente>();
		List<Ruolo> ruoli = ruoloService.getAllRuolo();
		for (Ruolo ruolo : ruoli) {
			if (ruolo.isVisibile())
				result.addAll(profiloUtenteService.getProfiloUtenteRuolo(ruolo));
		}
		return result;
	}
	
	public List<Referente> getRemainingRefs(Pratica pratica) {
		DatiRicercaReferente ricercaReferente = new DatiRicercaReferente();
		ricercaReferente.setFiltroTipologia("r");
		List<Referente> result = gestioneReferenteService.searchReferente(ricercaReferente);
		List<Long> idUsers = new ArrayList<Long>();
		List<Referente> daCancellare = new ArrayList<Referente>();
		if (pratica.getFigure()!=null){
			for (Figura figura : pratica.getFigure()) {
				idUsers.add(figura.getReferente().getId());
			}
		}
		for (Long idCancellare: idUsers) {
			boolean found=false;
			for (int i = 0; i < result.size() && !found;i ++) {
				found = result.get(i).getId().equals(idCancellare);
				if (found)
					daCancellare.add(result.get(i));
			}
		}
		result.removeAll(daCancellare);
		return result;
	}

	@Override
	public List<DatiMailInviate> getMailsInviate(long idPratica){
		List<DatiMailInviate> mailsInviate = new ArrayList<DatiMailInviate>();
		
		String queryString = "SELECT data_invio as datainvio, "
				                  + "mittente as mittente,"
				                  + " destinatario as destinatario, "
				                  + "oggetto as oggetto, "
				                  + "corpo as corpo, "
				                  + "sum(case when fk_allegatipratica is null then 0 else 1 END) as nrallegati "
				           + "FROM tb_inviomail "
				           + "WHERE fk_pratica = ?1 "
				           + "GROUP BY fk_pratica, data_invio, mittente, destinatario, oggetto, corpo "
				           + "ORDER BY data_invio DESC";
		
		Query query = em.createNativeQuery(queryString);
		query.setParameter(1, idPratica);
		
		List<Object[]> sqlResults = query.getResultList();
		
		for (Object[] row : sqlResults){
			BigDecimal nrAllegati = (BigDecimal)row[5];
			DatiMailInviate mail = new DatiMailInviate(
					(Date)row[0], 
					(String)row[1], 
					(String)row[2], 
					(String)row[3], 
					(String)row[4], 
					nrAllegati.longValue());
			
			mailsInviate.add(mail);
		}
		
		return mailsInviate;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<DatiConsuntivoPratica> searchConsuntivoPratiche(
			DatiRicercaPratica filtriRicerca) {

		String queryString = "select DISTINCT new it.sincon.gepred.web.portlet.varie.DatiConsuntivoPratica(pr.referente.nome,pr.referente.cognome,count(pr.id)) from Pratica pr "
				+ "LEFT OUTER JOIN pr.tipologia.categoria.ruolo ru "
				+ "where 1=1";
		
		if (filtriRicerca.getPeriodo_da() != null
				&& !filtriRicerca.getPeriodo_da().equals("")) {
			queryString += " AND pr.dataRichiesta  >= ?1";
		}
		if (filtriRicerca.getPeriodo_a() != null
				&& !filtriRicerca.getPeriodo_a().equals("")) {
			queryString += " AND pr.dataRichiesta  <= ?2";
		}
		if (filtriRicerca.getTipologia() != null
				&& !filtriRicerca.getTipologia().equals("")) {
			queryString += " AND pr.tipologia.id  = ?3";
		}
		if (filtriRicerca.getRichiedente() != null) {
			queryString += " AND pr.richiedente.id = ?4";
		}
		if (filtriRicerca.getUtenteLoggato()!=null){
			queryString += " AND ru.id in :idsRuoliUtente";
		}
		queryString+=" group by pr.referente.nome,pr.referente.cognome";
		Query query = em.createQuery(queryString, DatiConsuntivoPratica.class);
		if (filtriRicerca.getPeriodo_da() != null
				&& !filtriRicerca.getPeriodo_da().equals("")) {
			query.setParameter(1, DateUtils.getData(filtriRicerca.getPeriodo_da()));
		}
		if (filtriRicerca.getPeriodo_a() != null
				&& !filtriRicerca.getPeriodo_a().equals("")) {
			query.setParameter(2, DateUtils.getData(filtriRicerca.getPeriodo_a()));
		}
		if (filtriRicerca.getTipologia() != null
				&& !filtriRicerca.getTipologia().equals("")) {
			query.setParameter(3, filtriRicerca.getTipologia());
		}
		if (filtriRicerca.getRichiedente() != null) {
			query.setParameter(4, filtriRicerca.getRichiedente().getId());
		}
		if (filtriRicerca.getUtenteLoggato() != null) {
			query.setParameter("idsRuoliUtente", filtriRicerca.getUtenteLoggato().getListaIdsRuoli());
		}
		return query.getResultList();
	}
	
	/**
	 * Metodo che genera ed aggiunge alla pratica eventuali AttivitaPratica automatiche ed una 
	 * AttivitaPatica per ciascuna Attivita riportata nella lista passata in input
	 *
	 * 
	 * @param pratica : l'entity pratica di cui aggiornare la lista attività
	 * @param utente : l'utente che sta eseguendo l'operaizone
	 * @param attivitaDaCA : lista di attività a fronte delle quali generare una attività pratica: 
	 * 	  	Tale lista viene popolata con le attività da generare a fronte dei controlli previsti
	 * 		nei campi aggiuntivi. 
	 * 				
	 * @return l'entity pratica cone le attività aggiornale
	 */
	public Pratica verificaAttivitaAutomatiche(Pratica pratica,ProfiloUtente utente, List<Attivita> attivitaDaCA) {
		// Verifica delle attività automatiche
		List<TipoPraticaAttivita> result = pratica.getTipologia().getTipoPraticaAttivita();
		if(!result.isEmpty()){
			log.debug(String.format("ID_Pratica:%s - ID_TipoPratica:%s - nr tpa:%s", 
					pratica.getId(), pratica.getTipologia().getId(), 
					pratica.getTipologia().getTipoPraticaAttivita().size()));
			
			int ggIstruttoria = 30; 
			try {
				ggIstruttoria = Integer.parseInt(ggDurataIstruttoria);
			} catch (Exception exp) {
				log.error(exp.getMessage(), exp);
			}
			
			for (TipoPraticaAttivita tpa : result) {
				log.info(String.format("ID_tpa:%s - tpa.isAutomatica:%s", tpa.getId(), tpa.getAutomatica()));
				
				if(tpa.getAutomatica() == 1	&& pratica.isNew() /*&& !pratica.getReferente().equals(utente)*/ ){
					//genero un'attivita' automatica e l'assegno al referente
					AttivitaPratica ap = new AttivitaPratica();
					ap.setAttivita(tpa.getAttivita());
					ap.setDataAssegnazione(DateUtils.getOggi());
					ap.setDescrizione(tpa.getAttivita().getDescrizione());
					ap.setProfiloutente(pratica.getReferente());
					pratica.getAttivitaPratica().add(ap);
				}	
				
				//verifico se esiste un'attività automatica in fase di caricamento di un documento da parte di un utente
				//che non è il referente della pratica
				if(tpa.getAutomatica() == 2 && !pratica.isNew() /*&& !pratica.getReferente().equals(utente)*/){
					//verifico se esiste un documento nuovo caricato dall'utente
					//boolean trovato = false;
					for (int i = 0; i < pratica.getAllegati().size(); i++) {
						if (pratica.getAllegati().get(i).getAllegato() != null || (pratica.getAllegati().get(i).isNew() && pratica.getAllegati().get(i).getUuidFile()!= null && !pratica.getAllegati().get(i).getUuidFile().equals("")))//&& !trovato)
						{//se allegato è valorizzato allora si sta caricando il file
							//genero un'attivita' automatica e l'assegno al referente
							AttivitaPratica ap = new AttivitaPratica();
							ap.setAttivita(tpa.getAttivita());
							ap.setDataAssegnazione(DateUtils.getOggi());
							ap.setDescrizione(tpa.getAttivita().getDescrizione()+" - "+pratica.getAllegati().get(i).getAllegati().getNomeDocumento());
							ap.setProfiloutente(pratica.getReferente());
							pratica.getAttivitaPratica().add(ap);
							//trovato = true;
						}						
					}
					
				}
				
				// genero l'attività automatica legata all'istruttoria e l'assegno al referente...
				if (tpa.getAutomatica() == 3&& pratica.isNew()) {
					AttivitaPratica ap = new AttivitaPratica();
					ap.setAttivita(tpa.getAttivita());
					ap.setDataAssegnazione(DateUtils.getOggi());
					ap.setDataScadenza(DateUtils.AddDays(DateUtils.getOggi(), ggIstruttoria));
					ap.setProfiloutente(pratica.getReferente());
					ap.setDescrizione(tpa.getAttivita().getNote());
					ap.setTipologia(tpa.getAutomatica());
					ap.setSendAlertMail(false);
					pratica.getAttivitaPratica().add(ap);
				}
			}
		}
		
		// Creo le AttivitaPratica da generare automaticamente a fronte 
		// dei controlli previsti nei CampiAggiuntivi
		if(attivitaDaCA != null){
			for (Attivita attivita : attivitaDaCA){
				AttivitaPratica ap = new AttivitaPratica();
				ap.setAttivita(attivita);
				ap.setDataAssegnazione(DateUtils.getOggi());
				ap.setDataCompletamento(DateUtils.getOggi());
				ap.setDescrizione(attivita.getDescrizione());
				
				// In base al tipo di Richiedente assegno l'attivita ad un ete oppure ad un referente.
				// (Per SINTAR il Richiedente è un Referente di tipo 'e', per FASCICULUS è un Referente di tipo 'r'
				if (pratica.getRichiedente().getTipologia().equals("r"))
					ap.setProfiloutente(pratica.getReferente());
				else
					ap.setEnte(pratica.getRichiedente());
				
				pratica.getAttivitaPratica().add(ap);
			}
		}
		return pratica;
	}
	
	/**
	 * Metodo che genera ed aggiunge alla pratica eventuali AttivitaPratica automatiche da
	 * generare alla chiusura della richiesta di Integrazione
	 *
	 * 
	 * @param pratica : l'entity pratica di cui aggiornare la lista attività
	 * @param utente : l'utente che sta eseguendo l'operaizone
	 * 				
	 * @return l'entity pratica cone le attività aggiornale
	 */
	public Pratica verificaAttivitaAutomaticheChiusuraIntegrazione(Pratica pratica,ProfiloUtente utente) {
		// Verifica delle attività automatiche
		List<TipoPraticaAttivita> result = pratica.getTipologia().getTipoPraticaAttivita();
		if(!result.isEmpty()){
			log.debug(String.format("ID_Pratica:%s - ID_TipoPratica:%s - nr tpa:%s", 
					pratica.getId(), pratica.getTipologia().getId(), 
					pratica.getTipologia().getTipoPraticaAttivita().size()));
			
			int ggIstruttoria = 90; 
			try {
				ggIstruttoria = Integer.parseInt(ggDurataIstruttoria);
			} catch (Exception exp) {
				log.error(exp.getMessage(), exp);
			}
			
			for (TipoPraticaAttivita tpa : result) {
				log.info(String.format("ID_tpa:%s - tpa.isAutomatica:%s", tpa.getId(), tpa.getAutomatica()));
				
				// genero l'attività automatica legata alla chiusura della richiesta di integrazione e l'assegno al referente...
				if (tpa.getAutomatica() == 4) {
					AttivitaPratica ap = new AttivitaPratica();
					ap.setAttivita(tpa.getAttivita());
					ap.setDataAssegnazione(DateUtils.getOggi());
					ap.setDataScadenza(DateUtils.AddDays(pratica.getDataProtocollo(), ggIstruttoria));
					ap.setProfiloutente(pratica.getReferente());
					ap.setDescrizione(tpa.getAttivita().getNote());
					ap.setTipologia(tpa.getAutomatica());
					ap.setSendAlertMail(false);
					pratica.getAttivitaPratica().add(ap);
				}
			}
		}
		
		return pratica;
	}
	
	/**
	 * Metodo che imposta la data di chiusura alle attivitàPratica con ID presente nella lista
	 * passata in input.
	 * @param pratica
	 * @param lstAttivitaToBeClosed
	 */
	public void chiudiAttivitaPratica(List<AttivitaPratica> lstAttivitaToBeClosed){
		log.debug(String.format("Chiudi Attivita Pratica... ci sono %s attivita da chiudere...", lstAttivitaToBeClosed.size()));

		for (AttivitaPratica apToBeClosed : lstAttivitaToBeClosed){
			// Imposto la Data di Completamento solo se questa non era già stata impostata...
			if (apToBeClosed!=null && apToBeClosed.getDataCompletamento()==null){
				log.debug(String.format("Chiusura dell'AttivitaPratica con ID = %s ...", apToBeClosed));
				apToBeClosed.setDataCompletamento(DateUtils.getOggi());
			}else
				log.debug(String.format("L'AttivitaPratica con ID = %s ... era già chiusa alla data %s", 
						apToBeClosed, new SimpleDateFormat("dd/MM/yyyy HH:mm").format(apToBeClosed.getDataCompletamento())));
		}
	}
	
	/**
	 * Recupera il valore di uno specifico campo aggiuntivo per la pratica pr. 
	 * 
	 * @param pr
	 * @param labelCampoAggiuntivo
	 * @return Restituisce il valore contenuto nel campo aggiuntivo della pratica pr la cui label 
	 * 		   è pari a labelCampoAggiuntivo, null se il campo aggiuntivo non esiste. 
	 */
	@Override
	public String getValoreCampoAggiuntivo(Pratica pr, String labelCampoAggiuntivo){
		String retValue = null;
		
		try {
			for (CampiAggiuntiviPratica ca_pr : pr.getCampiaggiuntivi()){
				if (ca_pr.getCampiAggiuntivi().getLabel().equalsIgnoreCase(labelCampoAggiuntivo.toLowerCase()))
					retValue = ca_pr.getValore();
			}
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
		}
		
		return retValue;
	}
	
	/**
	 * Recupera il valore di uno specifico campo aggiuntivo per la pratica pr. 
	 * 
	 * @param pr
	 * @param posCampoAggiuntivo
	 * @return Restituisce il valore contenuto nel campo aggiuntivo della pratica pr che si trova 
	 * 		   in posizione posCampoAggiuntivo, null se il campo aggiuntivo non esiste. 
	 */
	@Override
	public String getValoreCampoAggiuntivo(Pratica pr, int posCampoAggiuntivo){
		String retValue = null;
		
		try {
			CampiAggiuntiviPratica ca_pr = pr.getCampiaggiuntivi().get(posCampoAggiuntivo);
			retValue = ca_pr.getValore();
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
		}
		
		log.debug(String.format("getValoreCampoAggiuntivo :: pos=%s - valore=%s", posCampoAggiuntivo, retValue));
		
		return retValue;
	}

	/**
	 * Ritorna il {@link ProfiloUtente} candidato come referente della pratica passata come parametro sulla base
	 * del carico di lavoro
	 * @param pratica
	 * @param campo Campo Aggiuntivo su cui basarsi per il carico di lavoro
	 * @param valueCampo valore del campo aggiuntivo da assumere per il carico di lavoro
	 * @return
	 * @throws ServiceLayerException
	 */
	@SuppressWarnings("unchecked")
	public ProfiloUtente scegliProfilo(Pratica pratica)
			throws ServiceLayerException {
		ProfiloUtente result = null;
		try {
			String queryString = "select distinct a.id from tb_profilo_utente a "
					+ "left OUTER JOIN tb_profilo_ruolo profrole on a.fk_ruolo = profrole.fk_profilo "
					+ "left OUTER JOIN tb_ruolo b on profrole.fk_ruolo = b.ID "
					+ "left OUTER JOIN tb_ruoli_categorie c on b.ID = c.ruolo_id "
					+ "LEFT OUTER JOIN tb_categorie_pratiche d on c.categoria_id=d.ID "
					+ "LEFT OUTER JOIN (select a.fk_profilo,count(a.id) as conteggio "
					+ "						from tb_pratica a where a.fk_tipologia=?3 group by a.fk_profilo) e on a.ID=e.fk_profilo "
					+ "where b.assegnazione_automatica = ?1 and c.categoria_id=?2 "
					+ "group by a.id order by ifnull(e.conteggio,0),rand()";
			Query query = em.createNativeQuery(queryString);
			query.setParameter(1, true);
			query.setParameter(2, pratica.getTipologia().getCategoria().getId());
			query.setParameter(3, pratica.getTipologia().getId());
			
			List<Object> lista = query.getResultList();
			result = profiloUtenteService.getProfiloUtenteCittadinoById((Long)lista.get(0));
		} catch (Exception e) {
			log.error("Error in scegliProfilo::"+e.getMessage(),e);
			throw new ServiceLayerException(e.getMessage(), e);
		}
		return result;
	}
	
	/*private CampiAggiuntivi selectCampoConteggio(Pratica pratica) {
		for(CampiAggiuntiviTipoPratica campi:pratica.getTipologia().getCampiAggiuntiviTipoPratica()) {
			if (campi.getCampiAggiuntivi().getControllo()!=null && !campi.getCampiAggiuntivi().getControllo().equals("")) {
				String[] controlli = campi.getCampiAggiuntivi().getControllo().split("\\|");
				for(String controllo:controlli){
					if (controllo.startsWith("caricoLavoro"))
						return campi.getCampiAggiuntivi();
				}
			}
		}
		return null;
	}*/


	@Override
	public AllegatiPratica getAllegatoByUuidContenitoreAndUuidFile(
			String uuidContenitore, String uuidFile) {
		return allegatiRepository.findByPratica_UuidContenitoreAndUuidFile(uuidContenitore, uuidFile);
	}


	@Override
	/**
	 * Metodo che restituisce il json per il render del Grafico a Barre per il Riepilogo Pratiche
	 * Viene generato un Bar Chart con un solo dataset corrispondente al Numero di Fascicoli
	 * @param inputList
	 * @return
	 */
	public String riepilogoPraticheToBarChartJson(List<DatiConsuntivoPratica> inputList, AbstractMessageSource messageSource, Locale locale) {
		log.debug("Riepilogo Pratiche To Bar Chart Json START...");

		int labelsArraySize = 1;
		
		// Inizializzo l'array delle labels con i quadrimestri della ricerca...
		String[] labels = new String[labelsArraySize];
		labels[0] = messageSource.getMessage("label.numeroPratiche", null, locale);			
		
		// Recupero i valori del rumore, organizzandoli per postazione
		Map<String, Map<Integer, Double>> mapDataSets = new HashMap<String, Map<Integer,Double>>();
		for (DatiConsuntivoPratica lvaRecord : inputList){
			// Salvataggio dati della Postazione...
			Map<Integer, Double> mapValori = null;
			
			// Init di una nuova mappa valori
			mapValori = new TreeMap<Integer, Double>();
			mapValori.put(0, (double)lvaRecord.getNumeroPratiche());

			// Aggiungo la nuova postazione fra quelle da visualizzare nel grafico
			mapDataSets.put(String.format("%s %s", lvaRecord.getCognomeReferente(), lvaRecord.getNomeReferente()), mapValori);
		}

		return BarChartUtils.createBarChartDataJson(mapDataSets, labels);
	}
	
	public boolean esisteMailInviata(String _dest, AllegatiPratica _allegato){
		List<DatiInvioMail> mails = invioMailRepository.findByDestinatarioAndInviatoAndAllegato(_dest, true, _allegato);
		
		if (mails!=null && mails.size()>0)
			return true;
		else
			return false;
	}
	
	public File generaModelloPdf(Pratica pratica, String nomeModello, String mainModelloPath) throws Exception{
		File modelloPdf = null;
		log.info( "download Modello= ..."+nomeModello);
		Modelli modello=null;
		for (Modelli mod : pratica.getTipologia().getModelli()){
			if (mod.getNome().equals(nomeModello)){
				modello=mod;
				break;
			}
		}
		
		if (modello!=null){
			String fileName = StringUtils.cleanString(modello.getNome());
			fileName = fileName + DateUtils.getOggi().getTime();
			mainModelloPath+= fileName+".vm";
			StreamUtils.dumpToFile(modello.getContenuto(), mainModelloPath);
			HashMap<String, Object> map = pratica.getPraticaAsMap();
			log.debug("PraticaMap="+map.toString());

			String body = mailSenderHelper.mergeTplModelli(fileName+".vm", map);
			
			String rtfFileName=fileName+"."+modello.getEstensione();
			
			String pdfFileName = ServiceHelper.createDir();
			modelloPdf = ConverterToPdf.converterToPdf(body.getBytes(), pdfFileName, rtfFileName, hostOpenOffice, Integer.parseInt(portOpenOffice));
		} else{
			String errMessage = String.format("La Tipologia di pratica %s con id: %s no ha nessun modello con nome %s",
					pratica.getTipologia().getDescrizione(), pratica.getTipologia().getId(), nomeModello);
			throw new ServiceLayerException(errMessage);
		}
		
		return modelloPdf;
	}
	
	/**
	 * Metodo per il recupero della configurazione del tab principale della
	 * schermata della pratica
	 * 
	 * @param pratica
	 */
	public void setConfigurazioneTabPrincipale(Pratica pratica) {
		
		// configurazione tab principale
		if (pratica != null) {
			byte config = pratica.getTipologia().getConfigurazione();
			if (ServiceHelper.checkBitMask(config, ServiceHelper.SHOW_MITT_DEST))
				pratica.getTipologia().setShowMittDest(ServiceHelper.SHOW_MITT_DEST);
			if (ServiceHelper.checkBitMask(config, ServiceHelper.SHOW_STATO))
				pratica.getTipologia().setShowStato(ServiceHelper.SHOW_STATO);
			if (ServiceHelper.checkBitMask(config, ServiceHelper.SHOW_TIP_INT))
				pratica.getTipologia().setShowTipoInt(ServiceHelper.SHOW_TIP_INT);
			if (ServiceHelper.checkBitMask(config, ServiceHelper.SHOW_LOCALITA))
				pratica.getTipologia().setShowLocalita(ServiceHelper.SHOW_LOCALITA);
			if (ServiceHelper.checkBitMask(config, ServiceHelper.AUTOMATIC_ASSIGN))
				pratica.getTipologia().setAutomaticAssign(ServiceHelper.AUTOMATIC_ASSIGN);
			if (ServiceHelper.checkBitMask(config, ServiceHelper.SHOW_INVIA_MAIL_DA_ALLEGATO))
				pratica.getTipologia().setShowInviaMailDaAllegato(ServiceHelper.SHOW_INVIA_MAIL_DA_ALLEGATO);
			if (ServiceHelper.checkBitMask(config, ServiceHelper.SHOW_VISIBILE_ON_LINE))
				pratica.getTipologia().setShowVisibileOnLine(ServiceHelper.SHOW_VISIBILE_ON_LINE);
		}
	}

	
	public Pratica getPraticaByPraticaWeb(long idPraticaWeb) throws Exception{
		
		PraticaWeb praticaWeb = praticaWebRepository.findOne(idPraticaWeb);
		if (praticaWeb == null) {
			log.warn(String.format("onSelect( %d ): Entity not found", idPraticaWeb));
			throw new ServiceLayerException(String.format("La certificazione con id: %s non è presente nella base dati", idPraticaWeb));
		}
		
		Pratica newPratica = new Pratica();
		// IMPOSTO LO STATO A PRESENTATA
		newPratica.setStato(statoRepository.findOne(1L));
		newPratica.setEsitoIstruttoria(esitoIstruttoriaRepository.findOne(1L));
		newPratica.setTipologia(praticaWeb.getTipologia());
		newPratica.setNumeroPratica(praticaWeb.getNumeroPratica());
		newPratica = dividiNumeroPratica(newPratica);
		log.info(String.format("numero = %s", newPratica.getNumero()));
		
		
		newPratica.setDataRichiesta(praticaWeb.getDataRichiesta());
		newPratica.setNote(praticaWeb.getMotivo_rifiuto());
		newPratica.setNumeroProtocollo(praticaWeb.getNumeroProtocollo());
		newPratica.setDataProtocollo(praticaWeb.getDataProtocollo());
		
		/*
		if (praticaWeb.getTitolare()!= null && !praticaWeb.getTitolare().isEmpty())
			newPratica.setOggettoRichiesta(praticaWeb.getOggettoRichiesta()+""
					+ "\r\n"
					+ "TITOLARE: "+praticaWeb.getTitolare());
		else*/
		newPratica.setImpresa(praticaWeb.getImpresa());	
		newPratica.setTecnico(praticaWeb.getTecnico());
		newPratica.setTitolare(praticaWeb.getTitolare());
		newPratica.setOggettoRichiesta(praticaWeb.getOggettoRichiesta());
		//newPratica.setUuidContenitore("");
		
		// configurazione tab principale
		setConfigurazioneTabPrincipale(newPratica);
		
		newPratica.setFigure(new ArrayList<Figura>());
		
		// SANITA
		// il ProfiloUtente (se esiste) o salvo come richiedente della pratica della
		if (praticaWeb.getProfiloutente()!=null){
			Referente refe = referenteRepository.findByCfAndCfIsNotNullAndCfNot(praticaWeb.getProfiloutente().getCodiceFiscale(),"");
			if(refe != null){
				newPratica.setRichiedente(refe);
			}else{
				Referente ref = new Referente();
				ref.setNome(praticaWeb.getProfiloutente().getNome());
				ref.setCognome(praticaWeb.getProfiloutente().getCognome());
				if (praticaWeb.getProfiloutente().getResidenza()!=null)
					ref.setIndirizzo(praticaWeb.getProfiloutente().getResidenza().toString());
				if (praticaWeb.getProfiloutente().getComune()!=null){
					Comune comuneProf = comuneRepository.findByCodiceIstat1(praticaWeb.getProfiloutente().getComune().getCodiceIstat1());
					ref.setComune(comuneProf);
				}
				ref.setCf(praticaWeb.getProfiloutente().getCodiceFiscale());
				ref.setEmail(praticaWeb.getProfiloutente().getMail());
				ref.setTipologia("r");
				ref.setChkref(false);
				Referente richiedente = referenteRepository.save(ref);
				newPratica.setRichiedente(richiedente);
			}
		}
		
		if (newPratica.getTipologia().getShowLocalita() == 8){
			log.debug( "onSelectPraticaWeb-gestionePratichePortlet-getShowLocalita");
			//verificare se esiste l'immobile
			Immobile imm = null;
			if(praticaWeb.getDatiCatastali() != null){
				for(int i=0; i < praticaWeb.getDatiCatastali().size(); i++){
					if(!praticaWeb.getDatiCatastali().get(i).getImmobile_foglioNCEU().equals("") && !praticaWeb.getDatiCatastali().get(i).getImmobile_subNCEU().equals(""))
						imm = immobileRepository.findByFoglioAndParticellaAndSubalternoAndComune(Integer.parseInt(praticaWeb.getDatiCatastali().get(i).getImmobile_foglioNCEU()), praticaWeb.getDatiCatastali().get(i).getImmobile_partNCEU(), praticaWeb.getDatiCatastali().get(i).getImmobile_subNCEU(), praticaWeb.getImmobile_comune());
					else if(!praticaWeb.getDatiCatastali().get(i).getImmobile_foglioNCT().equals("") && !praticaWeb.getDatiCatastali().get(i).getImmobile_subNCT().equals(""))
						imm = immobileRepository.findByFoglioAndParticellaAndSubalternoAndComune(Integer.parseInt(praticaWeb.getDatiCatastali().get(i).getImmobile_foglioNCT()), praticaWeb.getDatiCatastali().get(i).getImmobile_partNCT(), praticaWeb.getDatiCatastali().get(i).getImmobile_subNCT(), praticaWeb.getImmobile_comune());
				}
			}
			if(imm != null)
				newPratica.setImmobile(imm);
			else{
				Immobile immo = new Immobile();
				immo.setDenominazione(praticaWeb.getImmobile_den());
				immo.setIndirizzo(praticaWeb.getImmobile_ind());
				immo.setCap(praticaWeb.getImmobile_cap());
				immo.setComune(praticaWeb.getImmobile_comune());
				if(praticaWeb.getDatiCatastali() != null && !praticaWeb.getDatiCatastali().isEmpty()){
					if (!praticaWeb.getDatiCatastali().get(0).getImmobile_foglioNCEU().equals("")) {
						immo.setFoglio(Integer.parseInt(praticaWeb.getDatiCatastali().get(0).getImmobile_foglioNCEU()));
						immo.setParticella(praticaWeb.getDatiCatastali().get(0).getImmobile_partNCEU());
						if(!praticaWeb.getDatiCatastali().get(0).getImmobile_subNCEU().equals(""))
							immo.setSubalterno(praticaWeb.getDatiCatastali().get(0).getImmobile_subNCEU());
					} else {
						immo.setFoglio(Integer.parseInt(praticaWeb.getDatiCatastali().get(0).getImmobile_foglioNCT()));
						immo.setParticella(praticaWeb.getDatiCatastali().get(0).getImmobile_partNCT());
						if(!praticaWeb.getDatiCatastali().get(0).getImmobile_subNCT().equals(""))
							immo.setSubalterno(praticaWeb.getDatiCatastali().get(0).getImmobile_subNCT());
					}
				}
				//immo.set(pratica.getImmobile_cat());
				immo.setTipologia(praticaWeb.getImmobileTipo());
				immo.setAreaSin(praticaWeb.getImmobile_areaSin());
				newPratica.setImmobile(immo);
			}
		}
		
		
		List<Allegati> allegati = (List<Allegati> )praticaWeb.getTipologia().getAllegati();
		List<AllegatiPratica> allegatiPratica = new ArrayList<AllegatiPratica>();

		String logMsgSizeZero = "";
		String listDocsSizeZero = "";
		ArrayList<DocInfo> docs = documentaleService.documentiContenuti(praticaWeb.getUuidContenitore());
		for(int i=0;i<allegati.size();i++)
		{
			AllegatiPratica allegatoPratica=new AllegatiPratica();
			allegatoPratica.setAllegati(allegati.get(i));

			// Lo carico come allegato solo se da configurazione era obbligatorio, altrimenti lo ignoro...
			if (gestionePraticheWebService.isAllegatoPraticaWebObbligatorio(praticaWeb, allegatoPratica)) {
				String nome = ServiceHelper.getNomeAllegatoPraticaWeb(praticaWeb.getId(), 
						allegatoPratica.getAllegati().getId(), 
						null, 
						allegatoPratica.getAllegati().getNomeDocumento(), 
						patternNomeAllegatoPraticaWeb);
				String nomeToBeSaved = ServiceHelper.getNomeAllegatoPraticaWeb(praticaWeb.getId(), 
						allegatoPratica.getAllegati().getId(), 
						null, 
						allegatoPratica.getAllegati().getNomeDocumento(), 
						patternNomeAllegatoPraticaWebToBeSaved);
				
				if(docs!= null && !docs.isEmpty()){
					log.debug( "showDetail- DocSize="+ docs.size());
					for(int j=0; j < docs.size(); j++){
						log.debug(String.format("showDetail- DocName=%s | nome=%s",docs.get(j).getFile().getNome(),nome));
						log.info("UUID: " + docs.get(j).getFile().getUuid());
						if(docs.get(j).getFile().getNome().startsWith(nome) && docs.get(j).getFile().getUuid()!=null ){
							allegatoPratica.setUuidFile(docs.get(j).getFile().getUuid());
							allegatoPratica.setNomeFile(docs.get(j).getFile().getNome().replaceAll(nomeToBeSaved, ""));
							allegatoPratica.setNumProtocollo(newPratica.getNumeroProtocollo());
							allegatoPratica.setDataProtocollo(newPratica.getDataProtocollo());
							allegatoPratica.setTipoProtocollo("I");
							
							//mi calcolo l'impronta e la memorizzo nell'allegato
							//byte[] content = documentaleService.download(praticaWeb.getUuidContenitore(), allegatoPratica.getUuidFile()).getContent();
							byte[] content = docs.get(j).getFile().getContent();
							if(content != null){
								String impronta = CheckSumGenerator.generateCheckSum(content);
								allegatoPratica.setImpronta(impronta);
							} else {
								//log.warn(String.format("Impossibile scaricare il documento con UUID=%s dalla folder=%s", allegatoPratica.getUuidFile(), praticaWeb.getUuidContenitore()));
								log.warn(String.format("Impossibile calcolare l'impornta per il file=%s...effettuo il download...", docs.get(j).getFile().getUuid()));
								try {
									content = documentaleService.download(praticaWeb.getUuidContenitore(), allegatoPratica.getUuidFile()).getContent();
								} catch (Exception exp) {
									log.error(exp.getMessage(), exp);
								}
								
								if(content != null){
									String impronta = CheckSumGenerator.generateCheckSum(content);
									allegatoPratica.setImpronta(impronta);
								} else {
									log.warn(String.format("Impossibile scaricare il documento con UUID=%s dalla folder=%s", allegatoPratica.getUuidFile(), praticaWeb.getUuidContenitore()));
								}
							}
							
							allegatoPratica.setUrlAllegato("");
							allegatoPratica.setCaricato(true);
							
							if (docs.get(j).getFile().getDimensione()==null || docs.get(j).getFile().getDimensione().equals("0")){
								listDocsSizeZero += String.format("%s ", allegatoPratica.getUuidFile());
								logMsgSizeZero += String.format("# uuid:%s fileName:%s #", allegatoPratica.getUuidFile(), allegatoPratica.getNomeFile());
							}
						}
					}
				}
				newPratica.setListDocsSizeZero(listDocsSizeZero);
				newPratica.setLogMsgSizeZero(logMsgSizeZero);
				
				// Se mi arriva un allegato che da Tipologia era previsto obbligatorio, ma non ho il file,
				// necessariamente è un non caricato....
				if (allegatoPratica.getUuidFile() == null && allegatoPratica.getAllegati().isObbligatorio()) {
					allegatoPratica.setNonCaricato(true);
				}
	
				if (ServiceHelper.checkBitMask(newPratica.getTipologia().getConfigurazione(), ServiceHelper.SHOW_VISIBILE_ON_LINE)){
					if (allegatoPratica.getAllegati().getNomeDocumento().equalsIgnoreCase(nomeDocRichiesta) || 
							allegatoPratica.getAllegati().getNomeDocumento().equalsIgnoreCase(nomeDocRisposta))
						allegatoPratica.setVisibileOnline(true);
				}
				
				// Lo carico solo se era previsto come obbligatorio
				if (allegatoPratica.getAllegati().isObbligatorio())
					allegatiPratica.add(allegatoPratica);
			}
		} 
		
		// Prendo anche il modello come allegato
		/*String nome = String.format("%s_%s", id, nomeModello);
		if(docs != null && !docs.isEmpty()){
			for(int j=0; j < docs.size(); j++){
				if(docs.get(j).getFile().getNome().startsWith(nome)){
					Allegati allegato = new Allegati();
					allegato.setNomeDocumento(nomeModello);
					AllegatiPratica allegatoPratica=new AllegatiPratica();
					allegatoPratica.setAllegati(allegato);
					allegatoPratica.setUuidFile(docs.get(j).getFile().getUuid());
					allegatiPratica.add(allegatoPratica);
				}
			}
		}*/

		newPratica.setAllegati(allegatiPratica);
		
		/*
		// GESTIONE DEI RAPPRESENTANTI LEGALI...
		if (praticaWeb.getRappresentanti() != null && !praticaWeb.getRappresentanti().isEmpty()) {
			log.debug(String.format("nr di rappresentanti legali inviati:%d", praticaWeb.getRappresentanti().size()));

			for(int j=0; j < praticaWeb.getRappresentanti().size(); j++){
				RappresentanteLegale rappresentante = praticaWeb.getRappresentanti().get(j);
				// Aggancio il rappresentante alla Pratica...
				rappresentante.setPratica(newPratica);

				if (rappresentante.getUuidAllegatoB() != null && !rappresentante.getUuidAllegatoB().equals("")) {
					// Aggiunta dell'AllegatoPratica non agganciato alla tipologia... 
					Allegati allegato = new Allegati();
					allegato.setNomeDocumento(ServiceHelper.getNomeDocumentoAllegatoBRapprLegale(rappresentante.getNominativo(), rappresentante.getCodiceFiscale()));
					AllegatiPratica allegatoPratica=new AllegatiPratica();
					allegatoPratica.setAllegati(allegato);
					
					allegatoPratica.setUuidFile(rappresentante.getUuidAllegatoB());
					allegatoPratica.setNomeFile(rappresentante.getNomeFileAllegatoB());
					allegatoPratica.setNumProtocollo(newPratica.getNumeroProtocollo());
					allegatoPratica.setDataProtocollo(newPratica.getDataProtocollo());
					allegatoPratica.setTipoProtocollo("I");
					
					allegatiPratica.add(allegatoPratica);
				}
			}
			
			newPratica.setRappresentanti(praticaWeb.getRappresentanti());
		}
		*/
		// GESTIONE DEI DATI CATASTALI...
		if (praticaWeb.getDatiCatastali() != null && !praticaWeb.getDatiCatastali().isEmpty()) {
			log.debug(String.format("nr di dati catastali legali inviati:%d", praticaWeb.getDatiCatastali().size()));

			for(int j=0; j < praticaWeb.getDatiCatastali().size(); j++){
				DatiCatastaliImmobile rigoCatastale = praticaWeb.getDatiCatastali().get(j);
				// Aggancio il rappresentante alla Pratica...
				rigoCatastale.setPratica(newPratica);
			}
		
			newPratica.setDatiCatastali(praticaWeb.getDatiCatastali());
		}
		
		newPratica.setPreventivo(praticaWeb.getPreventivo());

		//#SA#: ADDED - Begin ###################################################################
		List<CampiAggiuntiviTipoPratica> campiAggiuntivi = praticaWeb.getTipologia().getCampiAggiuntiviTipoPratica();
		//log.debug( "showDetail- Nr. Campi Aggiuntivi Web="+ praticaWeb.getCampiaggiuntivi().size());
		List<CampiAggiuntiviPratica> datiCampiAggiuntivi = new ArrayList<CampiAggiuntiviPratica>();

		for (CampiAggiuntiviTipoPratica caTipoPratica : campiAggiuntivi) {
			log.debug(String.format("C.Agg. [ID=%s| label=%s | IdCampoAgg=%s | config_cagg=%s]",
					caTipoPratica.getId(),
					caTipoPratica.getCampiAggiuntivi().getLabel(),
					caTipoPratica.getCampiAggiuntivi().getId(),
					caTipoPratica.getConfig_cagg()));
			
			//prendo solo i campi aggiuntivi da visualizzare nel B/E
			if (ServiceHelper.checkBitMask(caTipoPratica.getConfig_cagg(), ServiceHelper.BACK_END_MAIN_PAG_MASK)) {
				boolean caWebAggiunto=false;
				if(praticaWeb.getCampiaggiuntivi() != null){
					for (CampiAggiuntiviPraticaWeb caWeb : praticaWeb.getCampiaggiuntivi()) {
						log.debug(String.format("C.Agg.Web [ID=%s| label=%s | IdCampoAgg=%s | tab=%s | valore=%s]", 
								caWeb.getId(),
								caWeb.getCampiAggiuntivi().getLabel(),
								caWeb.getCampiAggiuntivi().getId(),
								caTipoPratica.getTab().getDescrizione(),caWeb.getValore()));
						
						if (caTipoPratica.getCampiAggiuntivi().getId().equals(caWeb.getCampiAggiuntivi().getId())) {
							
							if(caTipoPratica.getCampiAggiuntivi().getTipologia().equals("i")){
								Allegati all = new Allegati();
								all.setNomeDocumento(caTipoPratica.getCampiAggiuntivi().getLabel());
								
								AllegatiPratica allegatoPratica=new AllegatiPratica();
								allegatoPratica.setAllegati(all);
								
								allegatoPratica.setUuidFile(caWeb.getUuidFile());
								allegatoPratica.setNomeFile(caWeb.getNomeFile());
								
								newPratica.getAllegati().add(allegatoPratica);
							}else{
							
								CampiAggiuntiviPratica ca = new CampiAggiuntiviPratica(newPratica, caWeb, caTipoPratica.getTab());
								datiCampiAggiuntivi.add(ca);
								log.debug(String.format("Aggiunto CampoAggiuntivo da Pratica web. ID=%s con valore=%s ", ca.getId(),ca.getValore()));
							
							}
							caWebAggiunto=true;
						}
					}
				}
				if(!caWebAggiunto){
					CampiAggiuntiviPratica campoAggiuntivoPratica = new CampiAggiuntiviPratica();
					campoAggiuntivoPratica.setCampiAggiuntivi(caTipoPratica.getCampiAggiuntivi());
					campoAggiuntivoPratica.setTab(caTipoPratica.getTab());
					//datiCampiAggiuntivi.add(campoAggiuntivoPratica);
					datiCampiAggiuntivi.add(ControlliCampiAggiuntivi.defaultValue(campoAggiuntivoPratica));
					log.debug(String.format("Aggiunto CampoAggiuntivo da Tipologia di Pratica ID=%s", caTipoPratica.getId()));
				}
			}
			
			
		} 
		//#SA#: ADDED - E n d  ###################################################################

		newPratica.setCampiaggiuntivi(datiCampiAggiuntivi); 
		
		//newPratica.setAttivitaPratica(getAttivitaAutomaticheAssegnazione(newPratica));
		newPratica.setAttivitaPratica(new ArrayList<AttivitaPratica>());
		newPratica.setAssegnatari(new ArrayList<ProfiloUtente>());
		newPratica.setPareriPratica(new ArrayList<Parere>());
		
		newPratica.setPunteggioIstanza(praticaWeb.getPunteggioIstanza());
		newPratica.setDataValidazione(praticaWeb.getDataValidazione());
		
		return newPratica;
	}
	
	private List<AttivitaPratica> getAttivitaAutomaticheAssegnazione(Pratica pratica){
		log.info("getAttivitaAutomaticheAssegnazione : START...");
		List<AttivitaPratica> retValue = new ArrayList<AttivitaPratica>();
		
		int ggIstruttoria = 30; 
		try {
			ggIstruttoria = Integer.parseInt(ggDurataIstruttoria);
		} catch (Exception exp) {
			log.error(exp.getMessage(), exp);
		}
		
		if (pratica.getTipologia().getTipoPraticaAttivita() != null) {
			log.info(String.format("ID_Pratica:%s - ID_TipoPratica:%s - nr tpa:%s", 
					pratica.getId(), pratica.getTipologia().getId(), 
					pratica.getTipologia().getTipoPraticaAttivita().size()));
		}
		for(TipoPraticaAttivita tpa:pratica.getTipologia().getTipoPraticaAttivita()) {
			log.info(String.format("ID_tpa:%s - tpa.isAutomatica:%s", tpa.getId(), tpa.getAutomatica()));
			
			if (tpa.getAutomatica() == 3) {
				AttivitaPratica ap = new AttivitaPratica();
				ap.setAttivita(tpa.getAttivita());
				ap.setDataAssegnazione(DateUtils.getOggi());
				ap.setDataCompletamento(DateUtils.AddDays(DateUtils.getOggi(), ggIstruttoria));
				ap.setProfiloutente(pratica.getReferente());
				ap.setDescrizione(tpa.getAttivita().getNote());
				ap.setTipologia(tpa.getAutomatica());
				ap.setSendAlertMail(false);
			}
		}
		
		return retValue;
	}
	
	public Pratica spostaAllegatiDaPraticaweb(Pratica entity) throws Exception{
		//entity = em.merge(entity);
		
		List<AllegatiPratica> allegatiP = entity.getAllegati();
		for(int i=0; allegatiP != null && !allegatiP.isEmpty() && i < allegatiP.size(); i++){
			// Sposto l'allegato dal contenitore delle richieste di Pratiche 
			// al contenitore della pratica vera e propria...
			if (allegatiP.get(i).getUuidFile() != null && !allegatiP.get(i).getUuidFile().isEmpty()){
				try{
					log.info(String.format("Tentativo di spostamento file: uuid=%s, filename=%s uuidContenitoreOrigine=%s, uuidContenitoreDest=%s, idPratica=%s",  
							allegatiP.get(i).getUuidFile(),
							allegatiP.get(i).getAllegati().getNomeDocumento(),
							entity.getUuidContenitore(),
							entity.getUuidContenitore(),
							entity.getId()));
					documentaleService.spostaDocumento(allegatiP.get(i).getUuidFile(), entity.getUuidContenitore());
					
					/* #SA# : 2022.07.13 sostato in getPraticaByPraticaWeb...
					//mi calcolo l'impronta e la memorizzo nell'allegato
					byte[] content = documentaleService.download(entity.getUuidContenitore(), allegatiP.get(i).getUuidFile()).getContent();
					if(content != null){
						String impronta = CheckSumGenerator.generateCheckSum(content);
						allegatiP.get(i).setImpronta(impronta);
					}
					
					allegatiP.get(i).setUrlAllegato("");
					allegatiP.get(i).setCaricato(true);
					allegatiPraticaRepository.save(allegatiP.get(i));
					*/
				} catch (Exception e) {
					log.error(e.getMessage());
					e.printStackTrace();
					throw new IOException("Non e' possibile recuperare il documento con uuid "+allegatiP.get(i).getUuidFile()+" :: "+ e.getMessage(), e);
				}
			}
		}
		//prendo i campi aggiuntivi di tipo file
		List<CampiAggiuntiviPratica> caP = entity.getCampiaggiuntivi();
		for(int i=0; caP != null && !caP.isEmpty() && i < caP.size(); i++){
			if(caP.get(i).getCampiAggiuntivi().getTipologia().equals("i")){
				try{
					log.debug(String.format("Tentativo di spostamento campo aggiuntivo di tipo file: uuid=%s, filename=%s uuidContenitoreOrigine=%s, uuidContenitoreDest=%s",  
							caP.get(i).getUuidFile(),
							caP.get(i).getNomeFile(),
							entity.getUuidContenitore(),
							entity.getUuidContenitore()));
					documentaleService.spostaDocumento(caP.get(i).getUuidFile(), entity.getUuidContenitore());

				} catch (Exception e) {
					log.error(e.getMessage());
					e.printStackTrace();
					throw new IOException("Non e' possibile recuperare il documento con uuid "+allegatiP.get(i).getUuidFile()+" :: "+ e.getMessage(), e);
				}
			}
		}
		
		return entity;
	}
	
	public String getUrpMailAccount(String urp){
		return urpMailAccountRepository.findByUrp(urp).getMailAccount();
	}
	
	/**
	 * Recupera uno specifico campo aggiuntivo per la pratica pr. 
	 * 
	 * @param pr
	 * @param labelCampoAggiuntivo
	 * @return Restituisce il valore contenuto nel campo aggiuntivo della pratica pr la cui label 
	 * 		   è pari a labelCampoAggiuntivo, null se il campo aggiuntivo non esiste. 
	 */
	public CampiAggiuntiviPratica getCampoAggiuntivo(Pratica pr, String labelCampoAggiuntivo){
		CampiAggiuntiviPratica retValue = null;
		
		for (CampiAggiuntiviPratica ca_pr : pr.getCampiaggiuntivi()){
			if (ca_pr.getCampiAggiuntivi().getLabel().equalsIgnoreCase(labelCampoAggiuntivo.toLowerCase()))
				retValue = ca_pr;
		}
		
		return retValue;
	}
	
	/**
	 * Recupera il valore di uno specifico campo aggiuntivo per la pratica pr. 
	 * 
	 * @param pr
	 * @param labelCampoAggiuntivo
	 * @return Restituisce il valore contenuto nel campo aggiuntivo della pratica pr la cui label 
	 * 		   è pari a labelCampoAggiuntivo, null se il campo aggiuntivo non esiste. 
	 */
	@Override
	public void setValoreCampoAggiuntivo(Pratica pr, String labelCampoAggiuntivo, String newValue){
		
		CampiAggiuntiviPratica ca_pr = getCampoAggiuntivo(pr, labelCampoAggiuntivo);
		if (ca_pr != null)
			ca_pr.setValore(newValue);
	}
	
	private Pratica getNewPraticaFromTipoPratica(TipoPratica tipoPratica) {
		Pratica pratica = new Pratica();
		pratica.setCampiaggiuntivi(new ArrayList<CampiAggiuntiviPratica>());
		
		List<CampiAggiuntivi> campiAggiuntivi = getCampiAggiuntiviByTipoPratica(tipoPratica);
		if (campiAggiuntivi != null) {
			for (CampiAggiuntivi campo : campiAggiuntivi) {
				CampiAggiuntiviPratica ca = new CampiAggiuntiviPratica();
				ca.setPratica(pratica);
				ca.setCampiAggiuntivi(campo);
				
				pratica.getCampiaggiuntivi().add(ca);
			}
		}
		
		return pratica;
	}
	
	@Override
	public Pratica valorizzaDatiImpresaDaVisura(TipoPratica tipoPratica, String pIvaVisura) throws ServiceLayerException {
		Pratica datiPratica = getNewPraticaFromTipoPratica(tipoPratica);
		VisuraImpresa datiVisura = visuraService.getVisura(pIvaVisura);
		
		if (datiVisura.getCodice().equals("OK")) {
			log.debug(String.format("Dati visura per la P.Iva %s recuperati !", pIvaVisura));
			setValoreCampoAggiuntivo(datiPratica, "della Ditta/Impresa", datiVisura.getDenominazione());
			setValoreCampoAggiuntivo(datiPratica, "Forma giuridica Impresa", datiVisura.getFormaGiuridica());
			setValoreCampoAggiuntivo(datiPratica, "Sede (comune italiano o estero)", datiVisura.getSede().getComune());
			setValoreCampoAggiuntivo(datiPratica, "Provincia", datiVisura.getSede().getProvincia());
			setValoreCampoAggiuntivo(datiPratica, "Indirizzo", datiVisura.getSede().getIndirizzo());
			setValoreCampoAggiuntivo(datiPratica, "CAP / ZIP", datiVisura.getSede().getCap());
			setValoreCampoAggiuntivo(datiPratica, "Domicilio fiscale", datiVisura.getSede().getIndirizzo());
			setValoreCampoAggiuntivo(datiPratica, "Codice Fiscale", datiVisura.getCodiceFiscale());
			setValoreCampoAggiuntivo(datiPratica, "Partita IVA", datiVisura.getPartitaIva());
			
			// Gestione Codici ATECO...
			if (datiVisura.getCodiciAteco() != null) {
				log.debug(String.format("Codici Ateco rilevati=%s", datiVisura.getCodiciAteco().size()));
				datiPratica.setCodiciAteco(new ArrayList<String>(datiVisura.getCodiciAteco()));
				
				int pos = 0;
				int idxCAgg = 0;
				for (String atecoVisura : datiVisura.getCodiciAteco()) {
					log.debug(String.format("atecoVisura=%s", atecoVisura));
					idxCAgg = 8;
					log.debug(String.format("ateco1=%s", datiPratica.getCampiaggiuntivi().get(idxCAgg).getValore()));
					pos = confrontaAteco(datiPratica, idxCAgg, atecoVisura);
					if (pos > 0) {
						log.debug(String.format("campoagiuntivo in pos=%s valorizzato con ateco=%s", idxCAgg, atecoVisura));
						datiPratica.getCampiaggiuntivi().get(idxCAgg).setValore(atecoVisura);
						continue;
					} else if (pos < 0){
						// Ho trovato questo codice Ateco già presente nella pratiaWeb...passo al successivo
						continue;
					} else {
						// NON ho trovato questo codice Ateco nella pratiaWeb...
						idxCAgg = 31;
						log.debug(String.format("ateco1=%s", datiPratica.getCampiaggiuntivi().get(idxCAgg).getValore()));
						pos = confrontaAteco(datiPratica, idxCAgg, atecoVisura);
						if (pos > 0) {
							log.debug(String.format("campoagiuntivo in pos=%s valorizzato con ateco=%s", idxCAgg, atecoVisura));
							datiPratica.getCampiaggiuntivi().get(idxCAgg).setValore(atecoVisura);
							continue;
						} else if (pos < 0){
							// Ho trovato questo codice Ateco già presente nella pratiaWeb...passo al successivo
							continue;
						} else {
							// NON ho trovato questo codice Ateco nella pratiaWeb...
							idxCAgg = 32;
							log.debug(String.format("ateco1=%s", datiPratica.getCampiaggiuntivi().get(idxCAgg).getValore()));
							pos = confrontaAteco(datiPratica, idxCAgg, atecoVisura);
							if (pos > 0) {
								log.debug(String.format("campoagiuntivo in pos=%s valorizzato con ateco=%s", idxCAgg, atecoVisura));
								datiPratica.getCampiaggiuntivi().get(idxCAgg).setValore(atecoVisura);
								continue;
							} else if (pos < 0){
								// Ho trovato questo codice Ateco già presente nella pratiaWeb...passo al successivo
								continue;
							} else {
								// NON ho trovato questo codice Ateco nella pratiaWeb...
								idxCAgg = 33;
								log.debug(String.format("ateco1=%s", datiPratica.getCampiaggiuntivi().get(idxCAgg).getValore()));
								pos = confrontaAteco(datiPratica, idxCAgg, atecoVisura);
								if (pos > 0) {
									log.debug(String.format("campoagiuntivo in pos=%s valorizzato con ateco=%s", idxCAgg, atecoVisura));
									datiPratica.getCampiaggiuntivi().get(idxCAgg).setValore(atecoVisura);
									break;
								}
								continue;
							}
						}
					}
				}
			} else {
				log.debug("datiVisura.getCodiciAteco()= IS NULL");
			}
			/*
			// Gestione Rappresentanti Legali...
			if (datiPratica.getRappresentanti() == null)
				datiPratica.setRappresentanti(new ArrayList<RappresentanteLegale>());
			if (datiVisura.getRappresentanti() != null) {
				log.debug(String.format("datiVisura.getRappresentanti()=%s", datiVisura.getRappresentanti().size()));
				for (it.sincon.gepred.visura.bean.RappresentanteLegale rapprVisura : datiVisura.getRappresentanti()) {
					log.debug(String.format("rappresentanteVisura=%s", rapprVisura.getNominativo()));
					if (!IsRappresentantePresente(datiPratica, rapprVisura)) {
						RappresentanteLegale nuovoRL = new RappresentanteLegale();
						nuovoRL.setVerificaAllegatoB(true);
						nuovoRL.setNominativo(rapprVisura.getNominativo());
						nuovoRL.setCodiceFiscale(rapprVisura.getCodiceFiscale());
						nuovoRL.setCaricaRicoperta(DecodeCaricaRicoperta(rapprVisura.getCaricaRicoperta()));
						datiPratica.getRappresentanti().add(nuovoRL);
					}
				}
			}
			*/
			
		} else {
			throw new ServiceLayerException(String.format("Errore in recupero dati visura per la P.Iva %s - %s", pIvaVisura, datiVisura.getMessaggio()));
		}
		
		return datiPratica;
	}
	private String DecodeCaricaRicoperta(String caricaFromVisura) {
		String retValue = caricaFromVisura;
		
		if (caricaFromVisura != null)
		{
			if (!retValue.equals("Titolare") && 
					!retValue.equals("Direttore Tecnico") && 
					!retValue.equals("Legale Rappresentante") && 
					!retValue.equals("Procuratore"))
				retValue = "Altro";
		}
		else
			retValue = "Altro";
		
		return retValue;
	}
	
	private int confrontaAteco(Pratica datiPraticaWeb, int posCAgg, String atecoVisura){
		int posLibera = 0;
		String atecoVisuraCod = atecoVisura.split("-")[0];
		log.debug(String.format("posCAgg=%s", posCAgg));
		log.debug(String.format("datiPraticaWeb.getCampiaggiuntivi().get(posCAgg).getValore()=%s", datiPraticaWeb.getCampiaggiuntivi().get(posCAgg).getValore()));
		if (datiPraticaWeb.getCampiaggiuntivi().get(posCAgg).getValore() == null || 
				datiPraticaWeb.getCampiaggiuntivi().get(posCAgg).getValore().isEmpty())
			posLibera = posCAgg;
		else {
			posLibera = 0;
			if (atecoVisuraCod.equals(datiPraticaWeb.getCampiaggiuntivi().get(posCAgg).getValore()))
				posLibera = -1; 
		}
		
		log.debug(String.format("posLibera=%s", posLibera));
		return posLibera ;
	}
	
	private boolean IsRappresentantePresente(Pratica datiPraticaWeb, it.sincon.gepred.visura.bean.RappresentanteLegale rapprVisura) {
		boolean trovato = false;
		
		/*
		try {
			if (datiPraticaWeb.getRappresentanti() != null) {
				for (RappresentanteLegale rappresentante : datiPraticaWeb.getRappresentanti()) {
					if (rappresentante.getCodiceFiscale().toUpperCase().equals(rapprVisura.getCodiceFiscale().toUpperCase())) {
						if (rappresentante.getCaricaRicoperta().toUpperCase().equals(rapprVisura.getCaricaRicoperta().toUpperCase())) {
							trovato = true;
							break;
						}
					}
				}
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			trovato = false;
		}	
		*/
		
		log.debug(String.format("IsRappresentantePresente:: C.F.=%s - Carica=%s - IsPresente=%s", 
				rapprVisura.getCodiceFiscale(), rapprVisura.getCaricaRicoperta(), trovato));
			
		return trovato;
	}
	
	private String confrontaCAggConVisura(Pratica entity, Pratica prFromVisura, String labelCampoAggiuntivo) {
		String riscontro = "";
		
		String entityValue = getValoreCampoAggiuntivo(entity, labelCampoAggiuntivo);
		String visuraValue = getValoreCampoAggiuntivo(prFromVisura, labelCampoAggiuntivo);
		
		if (!entityValue.toUpperCase().equals(visuraValue.toUpperCase())) {
			riscontro = String.format("il dato '%s' non corrisponde:\n - dato presentato=%s\n - dato da visura=%s\n", 
					labelCampoAggiuntivo, entityValue, visuraValue);
		}
		
		return riscontro;
	}
	
	private String cercaCodiceAtecoInVisura(String valore, Pratica prFromVisura, String labelCampoAggiuntivo) {
		log.debug(String.format("cercaCodiceAtecoInVisura :: valore=%s...", valore));
		
		String riscontro = "";
		try {
			if (valore != null) {
				if (!valore.isEmpty()) {
					boolean trovato = false;
					log.debug(String.format("cercaCodiceAtecoInVisura :: prFromVisura.getCodiciAteco().size()=%s...", prFromVisura.getCodiciAteco().size()));
					for (String ateco : prFromVisura.getCodiciAteco()) {
						log.debug(String.format("cercaCodiceAtecoInVisura :: ateco=%s...", ateco));
						if (ateco.equalsIgnoreCase(valore)) {
							trovato = true;
							break;
						}
					}
					
					if (!trovato) {
						riscontro = String.format("il valore presentato '%s' per il dato '%s' non trova alcuna corrispondenza nella visura\n", valore, labelCampoAggiuntivo);
					}
				}
			}
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
		}
		
		return riscontro;
	}
	
	public String eseguiConfrontoVisura(Pratica entity, Pratica prFromVisura) {
		String riscontro = "Il Riscontro dei dati presentati con la Visura ha evidenziato le seguenti differenze:\n\n";
		String riscontroParziale = "";
		
		boolean coincidono = true;
		
		riscontroParziale = confrontaCAggConVisura(entity, prFromVisura, "della Ditta/Impresa");
		if (!riscontroParziale.isEmpty())
			coincidono = false;
		riscontro += riscontroParziale;
		riscontroParziale = confrontaCAggConVisura(entity, prFromVisura, "Forma giuridica Impresa");
		if (!riscontroParziale.isEmpty())
			coincidono = false;
		riscontro += riscontroParziale;
		riscontroParziale = confrontaCAggConVisura(entity, prFromVisura, "Sede (comune italiano o estero)");
		if (!riscontroParziale.isEmpty())
			coincidono = false;
		riscontro += riscontroParziale;
		riscontroParziale = confrontaCAggConVisura(entity, prFromVisura, "Provincia");
		if (!riscontroParziale.isEmpty())
			coincidono = false;
		riscontro += riscontroParziale;
		riscontroParziale = confrontaCAggConVisura(entity, prFromVisura, "Indirizzo");
		if (!riscontroParziale.isEmpty())
			coincidono = false;
		riscontro += riscontroParziale;
		riscontroParziale = confrontaCAggConVisura(entity, prFromVisura, "CAP / ZIP");
		if (!riscontroParziale.isEmpty())
			coincidono = false;
		riscontro += riscontroParziale;
		riscontroParziale = confrontaCAggConVisura(entity, prFromVisura, "Domicilio fiscale");
		if (!riscontroParziale.isEmpty())
			coincidono = false;
		riscontro += riscontroParziale;
		riscontroParziale = confrontaCAggConVisura(entity, prFromVisura, "Codice Fiscale");
		if (!riscontroParziale.isEmpty())
			coincidono = false;
		riscontro += riscontroParziale;
		riscontroParziale = confrontaCAggConVisura(entity, prFromVisura, "Partita IVA");
		if (!riscontroParziale.isEmpty())
			coincidono = false;
		riscontro += riscontroParziale;
		
		/*
		riscontroParziale = confrontaCAggConVisura(entity, prFromVisura, "Codice ATECO");
		if (!riscontroParziale.isEmpty())
			coincidono = false;
		riscontro += riscontroParziale;
		*/
		riscontroParziale = cercaCodiceAtecoInVisura(getValoreCampoAggiuntivo(entity, 8), prFromVisura, "Codice ATECO");
		if (!riscontroParziale.isEmpty())
			coincidono = false;
		riscontro += riscontroParziale;
		riscontroParziale = cercaCodiceAtecoInVisura(getValoreCampoAggiuntivo(entity, 31), prFromVisura, "Codice ATECO");
		if (!riscontroParziale.isEmpty())
			coincidono = false;
		riscontro += riscontroParziale;
		riscontroParziale = cercaCodiceAtecoInVisura(getValoreCampoAggiuntivo(entity, 32), prFromVisura, "Codice ATECO");
		if (!riscontroParziale.isEmpty())
			coincidono = false;
		riscontro += riscontroParziale;
		riscontroParziale = cercaCodiceAtecoInVisura(getValoreCampoAggiuntivo(entity, 33), prFromVisura, "Codice ATECO");
		if (!riscontroParziale.isEmpty())
			coincidono = false;
		riscontro += riscontroParziale;
		
		/*
		// Verifica dei Rappresentanti Legali...
		boolean coincidonoRappresentanti = true;
		boolean trovato = false;
		if (entity.getRappresentanti() != null && prFromVisura.getRappresentanti() != null) {
			for (RappresentanteLegale r_v : prFromVisura.getRappresentanti()) {
				trovato = false;
				for (RappresentanteLegale r : entity.getRappresentanti()) {
					log.debug(String.format("Cod. fisc. rappr. visura=%S - cod.fisc. rappr candidatura=%S", r_v.getCodiceFiscale(), r.getCodiceFiscale()));
					if (r_v.getCodiceFiscale().toUpperCase().equals(r.getCodiceFiscale().toUpperCase())) {
						trovato = true;
						break;
					}
				}
				
				if (!trovato) {
					coincidonoRappresentanti = false;
					break;
				}
					
			}
		}
		else {
			coincidonoRappresentanti = false;
			
			if (entity.getRappresentanti() == null)
				log.debug("entity.getRappresentanti() IS NULL !!");
			if (prFromVisura.getRappresentanti() == null)
				log.debug("prFromVisura.getRappresentanti() IS NULL !!");
		}
		
		if (!coincidonoRappresentanti) {
			coincidono = false;
			riscontro += String.format("La lista dei Rappresentanti Legali non coincide con quella rilevata da visura!!\n");
			if (prFromVisura.getRappresentanti()!= null) {
				riscontro += String.format("La visura riporta le seguenti figure con potere di firma:\n");
				riscontro += String.format("   COGNOME E NOME        COD.FISCALE            CARICA RICOPERTA          \n");
				for (RappresentanteLegale r : prFromVisura.getRappresentanti()) {
					riscontro += String.format("%S   %S   %S\n", r.getNominativo(), r.getCodiceFiscale(), r.getCaricaRicoperta());
				}
			}
			else
			{
				riscontro += String.format("La visura NON riporta figure con poteri di firma per questa azienda!\n");	
			}
		}
		*/
		
		
		if (coincidono)
			riscontro = "Il Riscontro dei dati presentati con la Visura non ha evidenziato differenze.";
		else
			riscontro += "\n\nSi richiede di aggiornare i dati presentati con i valori come da visura camerale.";
		
		log.debug(String.format("eseguiConfrontoVisura :: riscontro=%s", riscontro));
		
		return riscontro;
	}

	private void inviaComunicazionePecAlRichiedente(
			String[] emailTo, String emailMittente, 
			byte[] allegatoContent, String nomeFileAllegato, 
			String denominazione, String numeroPratica, 
			String oggettoPratica, String numeroProtocollo,
			String nomeModelloMail) {
		log.info("inviaComunicazionePecAlRichiedente...START");
		
		File[] attachments = null;
		File daAllegare = null;
		if (allegatoContent != null) {
			String directory = ServiceHelper.createDir();
			daAllegare = new File(directory, nomeFileAllegato);
			try {
				StreamUtils.dumpToFile(allegatoContent, daAllegare.getPath());
				
				// #SA#: 22/11/2022 - Su richiesta di Zizzari non invio alcun allegato.
				//attachments = new File[]{daAllegare};
				
				if (emailTo!=null) {
					Map model = new HashMap();
					model.put("denominazione", denominazione);
					model.put("numeroPratica", numeroPratica);
					model.put("oggettoPratica", oggettoPratica);
					model.put("numeroProtocollo", numeroProtocollo);
					model.put("newline", "</br>");
					String oggetto = String.format("Piattaforma reddito energetico - invio comunicazione :%s relativa alla istanza nr.%s - %s", 
							numeroProtocollo, numeroPratica, oggettoPratica);  
					
					boolean pecEnableBoolean = true;
					try {
						pecEnableBoolean = Boolean.parseBoolean(PrefsPropsUtil.getString("pec.mail.session.mail.smtp.enable"));
					} catch (SystemException e1) {
						log.error(e1.getMessage(), e1);
					}
					String bodyContent = mailSenderHelper.mergeTplModelli(nomeModelloMail, model);
					
					if (pecEnableBoolean) {
						try {
							this.mailPecSenderHelper.sendMail(oggetto, bodyContent, attachments, emailMittente, emailTo);
						} catch (Exception e) {
							log.error(String.format("Invio della PEC fallito! - %s", e.getMessage()), e);
						}
					} else {
						try {
							this.mailSenderHelper.sendMail(oggetto, bodyContent, attachments, emailMittente, emailTo);
						} catch (Exception e) {
							log.error(String.format("Invio della Mail fallito! - %s", e.getMessage()), e);
						}
					}
				}
			} catch (Exception e) {
				log.error(e.getMessage(), e);
			}
		} 
		
		log.info("inviaComunicazionePecAlRichiedente...END");
	}

	@Override
	public Pratica protocollaAllegatoEdInviaViaMail(Pratica datiPratica, String pdfAllegatoName, File pdfAllegatoFile, long idStatoNew, String tipoProtocollo, String nomeModelloMail)
			throws ServiceLayerException {
		log.debug(String.format("protocollaAllegatoEdInviaViaMail :: pratica id=%s - pdfAllegatoName=%s", datiPratica.getId(), pdfAllegatoName));

		boolean found = false;
		AllegatiPratica modelloAllegato = null;
		for (AllegatiPratica ma : datiPratica.getAllegati()) {
			if (ma.getAllegati().getNomeDocumento().equals(pdfAllegatoName)) {
				log.info("PDF NOME: " + ma.getAllegati().getNomeDocumento().toString());
				found = true;
				modelloAllegato = ma;
			} 
		}
		if (found) {
			List<Ruolo> ruoliAccessoProtocollo = new ArrayList<Ruolo>();
			for(TipoPraticaTab tab:datiPratica.getTipologia().getSchede()){
				if (tab.getTab().getId().equals(9L)){
					ruoliAccessoProtocollo.addAll(tab.getRuoliScrittura());
					log.debug(String.format("aggiunti %s ruoli: ", tab.getRuoliScrittura().size()));
				}
			}
			ProfiloUtente profiloUtenteProtocollatore = profiloUtenteService.getProfiloUtenteProtocolloByRuolo(ruoliAccessoProtocollo);
			if (profiloUtenteProtocollatore != null) {
				byte[] contentPrincipale=StreamUtils.getFileContent(pdfAllegatoFile);
				try {
					DatiOutputProtocollo datiOutputProtocollo = executeProtocolla(
							tipoProtocollo, pdfAllegatoName, nomeModello, 
							profiloUtenteProtocollatore, datiPratica, 
							contentPrincipale);
					log.debug(String.format("DatiOutputProtocollo :: %s - %s", 
							datiOutputProtocollo.getEsito().getCodice(), datiOutputProtocollo.getEsito().getDescrizione()));
					
					if (datiOutputProtocollo.getEsito().getCodice().equals("000")){
						log.info("datiOutputProtocollo esito=000 - OK!!");
						modelloAllegato.setNumProtocollo(datiOutputProtocollo.getNumeroProtocollo());
						modelloAllegato.setDataProtocollo(datiOutputProtocollo.getDataProtocollo());
						modelloAllegato.setTipoProtocollo(tipoProtocollo);
						modelloAllegato = allegatiPraticaRepository.save(modelloAllegato);
						
						List<String> destNotificationMail = new ArrayList<String>();
						String mailRichiedente = getValoreCampoAggiuntivo(datiPratica, "E-mail");
						if (!mailRichiedente.isEmpty())
							destNotificationMail.add(mailRichiedente);
						
						
						String mailOperatore = "";
						// Recupero la pec dell'azienda dell'Operatore economico
						try {
							DatiSelezioneAzienda dsa = new DatiSelezioneAzienda();
							dsa.setFiltroPartitaIva(datiPratica.getImpresa());
							mailOperatore = rappresentanteLegaleService.searchAziende(dsa).get(0).getPec();
							destNotificationMail.add(mailOperatore);
						} catch (Exception exp) {
							log.error(exp.getMessage(), exp);
						}
						
						
						//String[] destNotificationMail = new String[] { mailOperatore, mailRichiedente };
						
						inviaComunicazionePecAlRichiedente(
								destNotificationMail.toArray(new String[0]),
								datiPratica.getTipologia().getMittenteMail(),
								contentPrincipale, pdfAllegatoName, 
								String.format("%s %s", datiPratica.getRichiedente().getCognome(), datiPratica.getRichiedente().getNome()),
								datiPratica.getNumeroPratica(), 
								datiPratica.getOggettoRichiesta(),
								datiOutputProtocollo.getNumeroProtocollo(),
								nomeModelloMail);
						
						log.info(String.format("Invio PEC con allegato %s effettuato ai destinatari %s - %s!", pdfAllegatoName, mailOperatore, mailRichiedente));
						
						datiPratica.setStato(statoRepository.findOne(idStatoNew));
						datiPratica = savePratica(datiPratica);
					} else {
						throw new ServiceLayerException(String.format("Errore in fase di protocollazione del documento %s - %s", pdfAllegatoName, datiOutputProtocollo.getEsito().getDescrizione()));
					}
				} catch (IOException e) {
					log.error(e.getMessage(), e);
				}
			}
			else
			{
				log.warn("Nessun utente Protocollatore individuato. IMPOSSIBILE PROTOCOLLARE !!!");
			}
		}
		
		return datiPratica;

	}
	
	@Override
	public int calcolaPunteggio(Pratica pratica) throws ServiceLayerException {
		int punteggioIstanza = 0;
		if(pratica.getCampiaggiuntivi()!= null && pratica.getCampiaggiuntivi().size()>0)
		{
			for (CampiAggiuntiviPratica ca : pratica.getCampiaggiuntivi()) {
				punteggioIstanza += CalcolaPunteggioUtils.getPunteggioCampoAggiuntivo(ca.getCampiAggiuntivi(), ca.getValore());
			}
		}
		
		if (pratica.getPreventivo() != null) {
			punteggioIstanza += CalcolaPunteggioUtils.getPunteggioPreventivo(pratica.getPreventivo());
		}
		
		return punteggioIstanza;
	}
	
	private void calcolaPerc(Pratica entity, String labelVal, String labelValTot, String labelValPerc) {
		log.debug(String.format("calcolaPerc: %s - %s - %s", labelVal, labelValTot, labelValPerc));
		
		try {
			CampiAggiuntiviPratica ca_val = getCampoAggiuntivo(entity, labelVal);
			CampiAggiuntiviPratica ca_ValTot = getCampoAggiuntivo(entity, labelValTot);
			double val = Double.parseDouble(ca_val.getValore());
			double valTot = Double.parseDouble(ca_ValTot.getValore());
			double valPerc = ( val / valTot ) * 100;
			setValoreCampoAggiuntivo(entity, labelValPerc, String.format("%.2f%%",valPerc));
			
		} catch (Exception ex) {
			log.error("calcolaPerc :: " + ex.getMessage(), ex);
			setValoreCampoAggiuntivo(entity, labelValPerc, "");
		}
	}
	
	private boolean isIstanzaCondominio(Pratica pratica) {
		return pratica.getTipologia().getCategoria().getNomeCompletoCategoria().toLowerCase().contains("categoria c");
	}
	
	@Override
	public Pratica valorizzaCampiCalcolati(Pratica pratica) throws ServiceLayerException {
		try {
			
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
	public Pratica protocollaAllegatiNonProtocollati(Pratica datiPratica, String pdfAllegatoName, File pdfAllegatoFile, long idStatoNew, String tipoProtocollo)
			throws ServiceLayerException {
		log.debug(String.format("protocollaAllegatiNonProtocollati :: pratica id=%s - pdfAllegatoName=%s", datiPratica.getId(), pdfAllegatoName));

		/*
		AllegatiPratica modelloAllegato = null;
		for (AllegatiPratica ma : datiPratica.getAllegati()) {
			if (ma.getAllegati().getNomeDocumento().equals(pdfAllegatoName)) {
				log.info("PDF NOME: " + ma.getAllegati().getNomeDocumento().toString());
				found = true;
				modelloAllegato = ma;
			} 
		}*/
		List<AllegatiPratica> allegatiNonProtocollati = new ArrayList<AllegatiPratica>();
		for (AllegatiPratica ma : datiPratica.getAllegati()) {
			if (ma.getNumProtocollo() == null) {
				log.info("ALLEGATO NON PROTOCOLLATO: " + ma.getAllegati().getNomeDocumento().toString());
				allegatiNonProtocollati.add(ma);
			} 
		}
		
		if (allegatiNonProtocollati.size() > 0) {
			List<Ruolo> ruoliAccessoProtocollo = new ArrayList<Ruolo>();
			for(TipoPraticaTab tab:datiPratica.getTipologia().getSchede()){
				if (tab.getTab().getId().equals(9L)){
					ruoliAccessoProtocollo.addAll(tab.getRuoliScrittura());
					log.debug(String.format("aggiunti %s ruoli: ", tab.getRuoliScrittura().size()));
				}
			}
			ProfiloUtente profiloUtenteProtocollatore = profiloUtenteService.getProfiloUtenteProtocolloByRuolo(ruoliAccessoProtocollo);
			if (profiloUtenteProtocollatore != null) {
				byte[] contentPrincipale=StreamUtils.getFileContent(pdfAllegatoFile);
				try {
					DatiOutputProtocollo datiOutputProtocollo = executeProtocolla(
							tipoProtocollo, pdfAllegatoName, nomeModello, 
							profiloUtenteProtocollatore, datiPratica, 
							contentPrincipale);
					log.debug(String.format("DatiOutputProtocollo :: %s - %s", 
							datiOutputProtocollo.getEsito().getCodice(), datiOutputProtocollo.getEsito().getDescrizione()));
					
					if (datiOutputProtocollo.getEsito().getCodice().equals("000")){
						log.info("datiOutputProtocollo esito=000 - OK!!");
						for (AllegatiPratica modelloAllegato : allegatiNonProtocollati) {
							modelloAllegato.setNumProtocollo(datiOutputProtocollo.getNumeroProtocollo());
							modelloAllegato.setDataProtocollo(datiOutputProtocollo.getDataProtocollo());
							modelloAllegato.setTipoProtocollo(tipoProtocollo);
							modelloAllegato = allegatiPraticaRepository.save(modelloAllegato);
						}
						
						datiPratica.setStato(statoRepository.findOne(idStatoNew));
						log.info(String.format("Stato pratica nr.%s impostato a %s", datiPratica.getNumero(), datiPratica.getStato().getDescrizione()));
						datiPratica = savePratica(datiPratica);
					} else {
						throw new ServiceLayerException(String.format("Errore in fase di protocollazione del documento %s - %s", pdfAllegatoName, datiOutputProtocollo.getEsito().getDescrizione()));
					}
				} catch (IOException e) {
					log.error(e.getMessage(), e);
				}
			}
			else
			{
				log.warn("Nessun utente Protocollatore individuato. IMPOSSIBILE PROTOCOLLARE !!!");
			}
		}
		
		return datiPratica;

	}
	
	@Override
	public Pratica protocollaAllegatiNonProtocollati(Pratica datiPratica, long idStatoNew, String tipoProtocollo)
			throws ServiceLayerException {
		log.debug(String.format("protocollaAllegatiNonProtocollati :: pratica id=%s", datiPratica.getId()));

		List<AllegatiPratica> allegatiNonProtocollati = new ArrayList<AllegatiPratica>();
		for (AllegatiPratica ma : datiPratica.getAllegati()) {
			if (ma.getNumProtocollo() == null) {
				log.info("ALLEGATO NON PROTOCOLLATO: " + ma.getAllegati().getNomeDocumento().toString());
				allegatiNonProtocollati.add(ma);
			} 
		}
		
		if (allegatiNonProtocollati.size() > 0) {
			List<Ruolo> ruoliAccessoProtocollo = new ArrayList<Ruolo>();
			for(TipoPraticaTab tab:datiPratica.getTipologia().getSchede()){
				if (tab.getTab().getId().equals(9L)){
					ruoliAccessoProtocollo.addAll(tab.getRuoliScrittura());
					log.debug(String.format("aggiunti %s ruoli: ", tab.getRuoliScrittura().size()));
				}
			}
			ProfiloUtente profiloUtenteProtocollatore = profiloUtenteService.getProfiloUtenteProtocolloByRuolo(ruoliAccessoProtocollo);
			if (profiloUtenteProtocollatore != null) {
				byte[] contentPrincipale=null;
				String pdfAllegatoName = allegatiNonProtocollati.get(0).getNomeFile();
				try {
					DatiOutputProtocollo datiOutputProtocollo = executeProtocolla(
							tipoProtocollo, pdfAllegatoName, nomeModello, 
							profiloUtenteProtocollatore, datiPratica, 
							contentPrincipale);
					log.debug(String.format("DatiOutputProtocollo :: %s - %s", 
							datiOutputProtocollo.getEsito().getCodice(), datiOutputProtocollo.getEsito().getDescrizione()));
					
					if (datiOutputProtocollo.getEsito().getCodice().equals("000")){
						log.info("datiOutputProtocollo esito=000 - OK!!");
						for (AllegatiPratica modelloAllegato : allegatiNonProtocollati) {
							modelloAllegato.setNumProtocollo(datiOutputProtocollo.getNumeroProtocollo());
							modelloAllegato.setDataProtocollo(datiOutputProtocollo.getDataProtocollo());
							modelloAllegato.setTipoProtocollo(tipoProtocollo);
							modelloAllegato = allegatiPraticaRepository.save(modelloAllegato);
						}
						
						datiPratica.setStato(statoRepository.findOne(idStatoNew));
						log.info(String.format("Stato pratica nr.%s impostato a %s", datiPratica.getNumero(), datiPratica.getStato().getDescrizione()));
						datiPratica = savePratica(datiPratica);
					} else {
						throw new ServiceLayerException(String.format("Errore in fase di protocollazione del documento %s - %s", pdfAllegatoName, datiOutputProtocollo.getEsito().getDescrizione()));
					}
				} catch (IOException e) {
					log.error(e.getMessage(), e);
				}
			}
			else
			{
				log.warn("Nessun utente Protocollatore individuato. IMPOSSIBILE PROTOCOLLARE !!!");
			}
		}
		
		return datiPratica;

	}


	@Override
	public List<EsitoIstruttoria> getEsitiIstruttoria() {
		return esitoIstruttoriaRepository.findAll();
	}
	
}
