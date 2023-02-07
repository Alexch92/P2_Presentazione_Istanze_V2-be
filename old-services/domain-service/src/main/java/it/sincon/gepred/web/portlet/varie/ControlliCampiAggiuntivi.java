package it.sincon.gepred.web.portlet.varie;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.osapulie.domain.ProfiloUtente;
import it.osapulie.infrastructure.impl.DateUtils;
import it.sincon.gepred.domain.Allegati;
import it.sincon.gepred.domain.AllegatiPratica;
import it.sincon.gepred.domain.AllegatiPraticaExtended;
import it.sincon.gepred.domain.AttivitaPratica;
import it.sincon.gepred.domain.CampiAggiuntivi;
import it.sincon.gepred.domain.CampiAggiuntiviPratica;
import it.sincon.gepred.domain.CampiAggiuntiviPraticaWeb;
import it.sincon.gepred.domain.DatiInvioMail;
import it.sincon.gepred.domain.TipoPraticaAttivita;
import it.sincon.gepred.domain.pratica.Pratica;
import it.sincon.gepred.persistence.AllegatiPraticaRepository;
import it.sincon.gepred.persistence.CampiAggiuntiviPraticaRepository;
import it.sincon.gepred.persistence.PraticaRepository;
import it.sincon.gepred.service.GestionePraticheService;


/**
 * @author Maria Michela Birtolo
 * 
 */
/**
 * @author Santomauro
 *
 */
public class ControlliCampiAggiuntivi{

	private static Logger log = LoggerFactory.getLogger( ControlliCampiAggiuntivi.class );
	
	public static String REGEX_CODICE_FISCALE = "^([A-Z]{6}[0-9LMNPQRSTUV]{2}[ABCDEHLMPRST]{1}[0-9LMNPQRSTUV]{2}[A-Z]{1}[0-9LMNPQRSTUV]{3}[A-Z]{1})$|([0-9]{11})$";
	private static String REGEX_PARTITA_IVA ="^[0-9]{11}$";
	
	public static boolean campoObbligatorio(CampiAggiuntiviPratica campo){
		boolean ret = true;
		
		String strAllegato = "null";
		
		if (campo.getCampiAggiuntivi().getTipologia().equals("i")){
			if (campo.getAllegato() == null)
				ret = false;
		}
		else{
			if(campo.getValore() == null || campo.getValore().equals("") || campo.getValore().replaceAll(",", "").equals(""))
				ret = false;
		}
		log.debug(String.format("Validazione del campo : Tipologia = %s; Label = %s; Valore = %s; Allegato = %s",
				campo.getCampiAggiuntivi().getTipologia(),
				campo.getCampiAggiuntivi().getLabel(),
				campo.getValore(),
				strAllegato));
		
		return ret;
	}
	public static boolean campoObbligatorioAssumeValore(CampiAggiuntiviPratica campo, String[] listaValoriIdx){
		boolean ret = false;
		
		if (campo.getCampiAggiuntivi().getTipologia().equals("l") || 
				campo.getCampiAggiuntivi().getTipologia().equals("g") || 
				campo.getCampiAggiuntivi().getTipologia().equals("b")){
			if(campo.getValore() != null && !campo.getValore().equals("") && !campo.getValore().replaceAll(",", "").equals("")){
				for (String idx : listaValoriIdx){
					ret = contieneValore(campo, idx);
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
	public static boolean campoObbligatorioAlmenoUno(List<CampiAggiuntiviPratica> campi){
		boolean ret = false;
		for (CampiAggiuntiviPratica campiAggiuntiviPratica : campi) {
			if(campiAggiuntiviPratica.getValore() != null && !campiAggiuntiviPratica.getValore().equals("") && !campiAggiuntiviPratica.getValore().replaceAll(",", "").equals(""))
				ret = true;
		} 
		return ret;
	}
	public static boolean campoObbligatorioDipendente(List<CampiAggiuntiviPratica> campi){
		boolean ret = false;
		if(campi.get(0).getValore() != null && !campi.get(0).getValore().equals("") && !campi.get(0).getValore().replaceAll(",", "").equals("")){
			//verifico che anche l' altro campo e' valorizzato
			if(campi.get(1).getValore() != null && !campi.get(1).getValore().equals("") && !campi.get(1).getValore().replaceAll(",", "").equals(""))
				ret = true;

		}else{
			//verifico che anche l' altro campo e' valorizzato
			if(campi.get(1).getValore() == null || campi.get(1).getValore().equals("") || campi.get(1).getValore().replaceAll(",", "").equals(""))
				ret = true;
		}		

		return ret;
	}
	public static String verificaControllo(List<CampiAggiuntiviPratica> campi,int indice){
		String retValue = "";
		String controllo = campi.get(indice).getCampiAggiuntivi().getControllo();
		String ctrl[] = controllo.split("#");
		if(ctrl[0].equals("campoObbligatorio")){
			if (!campoObbligatorio(campi.get(indice)))
				retValue = "NotEmpty.field.required";
		}
		if(ctrl[0].equals("campoObbligatorioAlmenoUno")){
			String campiSpl[] = ctrl[1].split(",");
			List<CampiAggiuntiviPratica> campiCheck = new ArrayList<CampiAggiuntiviPratica>();
			for (int i = 0; i < campiSpl.length; i++) {
				campiCheck.add(campi.get(Integer.parseInt(campiSpl[i])));
			}
			if (!campoObbligatorioAlmenoUno(campiCheck))
				retValue = "NotEmpty.field.required";
		}
		if(ctrl[0].equals("campoObbligatorioAssumeValore")){
			String listaValoriIdx[] = ctrl[1].split("OR");
			if (!campoObbligatorioAssumeValore(campi.get(indice), listaValoriIdx))
				retValue = String.format("%s.field.customErrorMessage",campi.get(indice).getCampiAggiuntivi().getId());
		}
		if(ctrl[0].equals("campoObbligatorioAssumeValori")){
			String listaValoriIdx[] = ctrl[1].split("AND");
			if (!campoObbligatorioAssumeValori(campi.get(indice), listaValoriIdx))
				retValue = String.format("%s.field.customErrorMessage",campi.get(indice).getCampiAggiuntivi().getId());
		}
		if(ctrl[0].equals("campoObbligatorioDipendente")){
			String campiSpl[] = ctrl[1].split(",");
			List<CampiAggiuntiviPratica> campiCheck = new ArrayList<CampiAggiuntiviPratica>();
			for (int i = 0; i < campiSpl.length; i++) {
				campiCheck.add(campi.get(Integer.parseInt(campiSpl[i])));
			}
			if (!campoObbligatorioDipendente(campiCheck))
				retValue = "NotEmpty.field.required";
		}
		if(ctrl[0].equals("campoObbligatorioDipendenteDaValore")){
			String campiSpl[] = ctrl[1].split("v");
			CampiAggiuntiviPratica campoCheck = findCampoAggiuntivoByID(campi, Long.parseLong(campiSpl[0]));

			if (campoCheck!= null){
				if (contieneValore(campoCheck, campiSpl[1]))
					if (!campoObbligatorio(campi.get(indice)))
						retValue = "NotEmpty.field.required";
			}
			else{
				log .debug(String.format("Campo con id:%s non presente nella lista dei campi aggiuntivi", Long.parseLong(campiSpl[0])));
			}
		}
		if(ctrl[0].equals("campoObbligatorioDipendenteDaValoreByLabel")){
			String campiSpl[] = ctrl[1].split("v");
			CampiAggiuntiviPratica campoCheck = getCampoAggiuntivoByLabel(campi, campiSpl[0]);

			if (campoCheck != null) {
				if (contieneValore(campoCheck, Integer.parseInt(campiSpl[1])))
					if (!campoObbligatorio(campi.get(indice)))
						retValue = "NotEmpty.field.required";
			} else {
				log.debug(String.format("campoObbligatorioDipendenteDaValoreByLabel :: campoCheck IS NULL : label:%s", campiSpl[0]));
			}
		}
		if(ctrl[0].equals("campoObbligatorioUgualeA")){
			if (!campoObbligatorio(campi.get(indice)))
				retValue = "NotEmpty.field.required";
			else {
				String labelCampoRif = ctrl[1];
				CampiAggiuntiviPratica campoCheck = getCampoAggiuntivoByLabel(campi, labelCampoRif);
			
				if (campoCheck.getValore() == null)
					retValue = String.format("%s.field.customErrorMessage",campi.get(indice).getCampiAggiuntivi().getId());
				else {
					String valCampo = campi.get(indice).getValore().trim().toLowerCase();
					String valCheck = campoCheck.getValore().trim().toLowerCase();
					if (!valCampo.equals(valCheck))
						retValue = String.format("%s.field.customErrorMessage",campi.get(indice).getCampiAggiuntivi().getId());
				}
			}
		}
		if(ctrl[0].equals("validaMailAddressObbligatoria")){
			if (!validaMailAddressObbligatoria(campi.get(indice)))
				retValue = "NotValid.string.email";
		}
		if(ctrl[0].equals("campoObbligatorioCodiceFiscale")){
			if (!campoObbligatorioRegEx(campi.get(indice), REGEX_CODICE_FISCALE))
				retValue = "NotValid.string.codFiscale";
		}
		if(ctrl[0].equals("campoObbligatorioPartitaIva")){
			if (!campoObbligatorioRegEx(campi.get(indice), REGEX_PARTITA_IVA))
				retValue = "NotValid.string.partitaIva";
		}
		if(ctrl[0].equals("campoObbligatorioCodFiscaleImpresa")){
			CampiAggiuntiviPratica campoTipoImpresa = campi.get(Integer.parseInt(ctrl[1]));
			retValue = campoObbligatorioCodFiscaleImpresa(campi.get(indice), campoTipoImpresa);
		}
		if(ctrl[0].equals("campoObbligatorioMaxValue")){
			if (!campoObbligatorio(campi.get(indice)))
				retValue = "NotEmpty.field.required";
			else {
				double maxValue = 0;
				double inValue = 0;
				try {
					maxValue = Double.parseDouble(ctrl[1]);
					inValue = Double.parseDouble(campi.get(indice).getValore().replace(",", "."));
					
					if (inValue > maxValue)
						retValue = "error.MaxValueExceeded";
				} catch (Exception e) {
					log.error(e.getMessage(), e);
					retValue = "NotValid.string.isee";
				}
			}
		}
		
		return retValue;
	}
	
	public static boolean validaMailAddress(CampiAggiuntiviPratica campo){
		boolean ret = true;
		
		EmailValidation emailValidation = new EmailValidation();
		
		if(!emailValidation.validate(campo.getValore()) && !campo.getValore().equals("")){
			ret = false;
		}
		
		return ret;
	}
	
	public static boolean verificaControlloAllegati(Pratica pratica,int indice) {
		boolean result = true;
		String controllo = pratica.getCampiaggiuntivi().get(indice).getCampiAggiuntivi().getControllo();
		String[] controlli = controllo.split("\\|");
		for(int i=0;i<controlli.length;i++) {
			if (controlli[i].startsWith("verificaAssenzaAllegati")) {
				String posizione = controlli[i].split("#")[1];
				if (contieneValore(pratica.getCampiaggiuntivi().get(indice), posizione)) {
					for(int k=0;k<pratica.getAllegati().size() && result;k++) {
						result = pratica.getAllegati().get(k).getUuidFile() == null || pratica.getAllegati().get(k).getUuidFile().equals("") ||pratica.getAllegati().get(k).isSpostato() || pratica.getAllegati().get(k).isCancellato(); 
					}
				}
			}
		}
		return result;
	}
	
	public static boolean verificaCanEdit(CampiAggiuntiviPratica campo,String controllo){
		String ctrl1[] = controllo.split("\\|");
		log.debug("ctrl1.size="+ctrl1.length);
		for(int j=0; j < ctrl1.length; j++){
			if(ctrl1[j].startsWith("verificaCanEdit")){
				log.debug("ctrl1=verificaCanEdit");
				String ctrl[] = ctrl1[j].split("#");
				String campiSpl[] = ctrl[1].split(",");
				for(int i =0; i < campiSpl.length; i++){
					if (contieneValore(campo, campiSpl[i])){
						log.debug("campiSpl"+i+"=true");
						return true;
					}
				}
			}
		}
		return false;		
	}
	
	public static boolean verificaAttivaRiapertura(CampiAggiuntiviPratica campo,String controllo){
		try {
			String ctrl1[] = controllo.split("\\|");
			log.debug("ctrl1.size="+ctrl1.length);
			for(int j=0; j < ctrl1.length; j++){
				if(ctrl1[j].startsWith("attivaRiapertura")){
					log.debug("ctrl1=attivaRiapertura");
					String ctrl[] = ctrl1[j].split("#");
					String campiSpl[] = ctrl[1].split(",");
					
					return contieneValore(campo, campiSpl[1]);
				}
			}
			return false;
		}
		catch (Exception e) {
			return false;
		}
		catch (Throwable t) {
			return false;
		}
	}
	
	public static boolean verificaAttivaPresaInCarico(CampiAggiuntiviPratica campo,String controllo){
		try {
			String ctrl1[] = controllo.split("\\|");
			log.debug("ctrl1.size="+ctrl1.length);
			for(int j=0; j < ctrl1.length; j++){
				if(ctrl1[j].toLowerCase().startsWith("attivapresaincarico")){
					log.debug("ctrl1=attivapresaincarico");
					String ctrl[] = ctrl1[j].split("#");
					String campiSpl[] = ctrl[1].split(",");
					
					return contieneValore(campo, campiSpl[1]);
				}
			}
		return false;
		}
		catch (Exception e) {
			return false;
		}
		catch (Throwable t) {
			return false;
		}
	}
	
	public static boolean campoObbligatorioAssumeValori(CampiAggiuntiviPratica campo, String[] listaValoriIdx){
		boolean ret = true;
		
		if (campo.getCampiAggiuntivi().getTipologia().equals("l") || 
				campo.getCampiAggiuntivi().getTipologia().equals("g") || 
				campo.getCampiAggiuntivi().getTipologia().equals("b") ||
				campo.getCampiAggiuntivi().getTipologia().equals("a")){
			if(campo.getValore() != null && !campo.getValore().equals("") && !campo.getValore().replaceAll(",", "").equals("")){
				for (String idx : listaValoriIdx){
					ret = contieneValore(campo, Integer.parseInt(idx));
					if (!ret)
						break;
				}
			} else {
				ret = false;
			}
		}

		log.info(String.format("Validazione del campo : Tipologia = %s; Label = %s; Valore = %s",
				campo.getCampiAggiuntivi().getTipologia(),
				campo.getCampiAggiuntivi().getLabel(),
				campo.getValore()));
		
		return ret;
	}
	
	/** Metodo che verifica se, a fronte del valore assunto dal campo aggiuntivo, se bisogna generare ua nuova 
	 * attivita da aggiungere alla pratica
	 * @param campo
	 * @return l'id dell'entity Attivita a fronte della quale generare l'AttivitaPratica da aggiungere alla pratica
	 */
	public static long verificaAttivita(CampiAggiuntiviPratica campo){
		long retValue= -1; 
		
		try {
			String strControllo = campo.getCampiAggiuntivi().getControllo();
			if(strControllo != null && !strControllo.equals("") && 	strControllo.toLowerCase().contains("addattivita")){
				
				log.debug(String.format("Verifica Attivita. CampoAggPratica [ID:%s|Valore:%s|Controlli: %s]", 
						campo.getId(), campo.getValore(), campo.getCampiAggiuntivi().getControllo()));
				
				String listaCtrl[] = strControllo.split("\\|");
				for(int j=0; j < listaCtrl.length; j++){
					if(listaCtrl[j].toLowerCase().startsWith("addattivita")){
						String ctrl[] = listaCtrl[j].split("#");
						String campiSpl[] = ctrl[1].split(",");
						if (contieneValore(campo, campiSpl[1])){
							log.debug(String.format("Richiesta generazione dell'attivita con id:%s", campiSpl[0]));
							retValue = Long.parseLong(campiSpl[0]);
						}
					}
				}
			}
		}
		catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		catch (Throwable t) {
			log.error(t.getMessage(), t);
		}
		
		return retValue;
	}
	
	public static List<AttivitaPratica> verificaAttivitaToBeClosed(CampiAggiuntiviPratica campo){
		List<AttivitaPratica> retValue = new ArrayList<AttivitaPratica>(); 
		
		String strControllo = campo.getCampiAggiuntivi().getControllo();
		if(strControllo != null && !strControllo.equals("") && 	strControllo.toLowerCase().contains("closeattivita")){
			log.debug(String.format("Verifica Attivita da Chiudere. CampoAggPratica [ID:%s|Valore:%s|Controlli: %s]", 
					campo.getId(), campo.getValore(), campo.getCampiAggiuntivi().getControllo()));
			String listaCtrl[] = strControllo.split("\\|");
			for(int j=0; j < listaCtrl.length; j++){
				if(listaCtrl[j].toLowerCase().startsWith("closeattivita")){
					String ctrl[] = listaCtrl[j].split("#");
					String campiSpl[] = ctrl[1].split(",");
					if (contieneValore(campo, campiSpl[1])){
						log.debug(String.format("Richiesta chiusura dell'attivita con id:%s", campiSpl[0]));
						retValue.addAll(chiudiAttivita(listaCtrl, campo.getPratica(), j));
					}
				}
			}
		}
		
		return retValue;
	}
	
	/** metodo che cicla sulla lista di controlli ed esegue tutti i controlli di tipo 
	 * closeAttivita consecutivi, a partire dall'elemento con indice startIdx
	 * Il controllo closeAttivita è pensato per lavorare nel modo seguente...
	 * 	closeAttivita#automatiche,1|   indica che se il campo assume il valore ad indice 1 della sua listaValori,
	 * allora tutte le attivita automatiche sono da chiudere. Se voglio chiudere i maiera puntuale solo alcune attivita,
	 * allora il primo paramentro (dopo il #) al posto di attivita deve riportare l'id dell'AttivitaPratica da chiudere.
	 * In questo secondo caso dovrò inserire in pipe tanti controlli di tipo closeAttivita quante sono 
	 * le attivitaPratica da chiudere.
	 * @param controlli
	 * @param startIdx
	 * @return la lista aggiornata di campi
	 * @throws NumberFormatException
	 */
	private static List<AttivitaPratica> chiudiAttivita(String[] controlli, Pratica pr, int startIdx) throws NumberFormatException {
		List<AttivitaPratica> retValue= new ArrayList<AttivitaPratica>();
		
		for (int idUp=startIdx; idUp<controlli.length; idUp++)
		{	
			log.debug(String.format("controllo : %s", controlli[idUp]));
			if(controlli[idUp].toLowerCase().startsWith("closeattivita")){
				String ctrlUp[] = controlli[idUp].split("#");
				String campiSplUp[] = ctrlUp[1].split(",");
				
				if (campiSplUp[0].equalsIgnoreCase("automatiche")){
					// Tutte le attivita automatiche sono da chiudere....
					List<TipoPraticaAttivita> listaTpa = pr.getTipologia().getTipoPraticaAttivita();
					for (TipoPraticaAttivita tpa : listaTpa) {
						if(tpa.getAutomatica()>0){
							for (AttivitaPratica ap : pr.getAttivitaPratica()){
								if (ap.getAttivita().equals(tpa.getAttivita())){
									log.debug(String.format("Id attivitaToBeClosed=%s", ap.getId()));
									retValue.add(ap);
								}
							}
						}
					}
				}
//				else{
//					// recupero l'id delle attivita da chiudere.....
//					long valoreIdxUp = Long.parseLong(campiSplUp[0]);
//					log.debug(String.format("Id attivitaToBeClosed=%s", campiSplUp[0]));
//					retValue.add(valoreIdxUp);
//				}
			}
			else
				break;
		}
		
		return retValue;
	}
	
//	verificaCanEdit#1,2|attivaRiapertura#0,1|updateValore#3,null
	public static List<CampiAggiuntiviPratica> attivaRiapertura(List<CampiAggiuntiviPratica> campi,int indice,String controllo){
		CampiAggiuntiviPratica campo = campi.get(indice);
		String ctrl1[] = controllo.split("\\|");
		for(int j=0; j < ctrl1.length; j++){
			if(ctrl1[j].startsWith("attivaRiapertura")){
				String ctrl[] = ctrl1[j].split("#");
				String campiSpl[] = ctrl[1].split(",");
				
				int idxValueToBeSet=Integer.parseInt(campiSpl[0]);
				String listaValori[] = campo.getCampiAggiuntivi().getListaValori().split(",");
				log.debug("attivaRiapertura"+j+"="+listaValori[idxValueToBeSet]);
				
				if(contieneValore(campo, campiSpl[1])){
					campi.get(indice).setValore(listaValori[idxValueToBeSet]);
					campi = updateValore(campi, ctrl1, j+1);
					campi = updateValoreIfEmpty(campi, ctrl1, j+1);
				}
				
			}
		}
		return campi;		
	}
	
	public static List<CampiAggiuntiviPratica> attivaPresaInCarico(List<CampiAggiuntiviPratica> campi,int indice,String controllo){
		CampiAggiuntiviPratica campo = campi.get(indice);
		String ctrl1[] = controllo.split("\\|");
		boolean eseguito=false;
		for(int j=0; j < ctrl1.length; j++){
			if(ctrl1[j].startsWith("attivaPresaInCarico") && !eseguito){
				String ctrl[] = ctrl1[j].split("#");
				String campiSpl[] = ctrl[1].split(",");
				
				int idxValueToBeSet=Integer.parseInt(campiSpl[0]);
				String listaValori[] = campo.getCampiAggiuntivi().getListaValori().split(",");
				log.debug("attivaPresaInCarico"+j+"="+listaValori[idxValueToBeSet]);
				
				if(contieneValore(campo, campiSpl[1])){
					campi.get(indice).setValore(listaValori[idxValueToBeSet]);
					campi = updateValore(campi, ctrl1, j+1);
					campi = updateValoreIfEmpty(campi, ctrl1, j+1);
					eseguito=true;
				}
			}
			if (eseguito)
				break;
		}
		return campi;		
	}

	public static List<CampiAggiuntiviPratica> onValore(List<CampiAggiuntiviPratica> campi,int indice,String controllo){
		CampiAggiuntiviPratica campo = campi.get(indice);
		String lstControlli[] = controllo.split("\\|");
		for(int j=0; j < lstControlli.length; j++){
			if(lstControlli[j].startsWith("onValore")){
				String attrib[] = lstControlli[j].split("#");
				String campiSpl[] = attrib[1].split(",");

				if (!campiSpl[0].equalsIgnoreCase("null")){
					int idxValueToBeSet=Integer.parseInt(campiSpl[0]);
					String listaValori[] = campo.getCampiAggiuntivi().getListaValori().split(",");
					log.debug("onValore"+j+"="+listaValori[idxValueToBeSet]);

					if(contieneValore(campo, campiSpl[0])){
						campi = updateValore(campi, lstControlli, j+1);
					}
				}
			}
		}
		return campi;		
	}
	
	/**
	 * Controllo richiamato quando la pratica non è ancora stata visualizzata per la prima volta del referente
	 * o dall'utente assegnatario di un'attività. Il controllo aggiorna il campo ad un dato valore.
	 * Es. updateStatoIsLetta#,0
	 * @param campi
	 * @param indice
	 * @param controllo
	 * @return
	 */
	public static List<CampiAggiuntiviPratica> updateStatoIsLetta(List<CampiAggiuntiviPratica> campi,int indice,String controllo){
		CampiAggiuntiviPratica campo = campi.get(indice);
		String lstControlli[] = controllo.split("\\|");
		for(int j=0; j < lstControlli.length; j++){
			if(lstControlli[j].startsWith("updateStatoIsLetta")){
				String attrib[] = lstControlli[j].split("#");
				String campiSpl[] = attrib[1].split(",");

				//if (!campiSpl[0].equalsIgnoreCase("null")){
					//int idxValueToBeSet=Integer.parseInt(campiSpl[0]);
					//String listaValori[] = campo.getCampiAggiuntivi().getListaValori().split(",");
					//log.debug("onValore"+j+"="+listaValori[idxValueToBeSet]);

					if(contieneValore(campo, campiSpl[0])){
						int idxValueToBeSet=Integer.parseInt(campiSpl[1]);
						String listaValori[] = campo.getCampiAggiuntivi().getListaValori().split(",");
						campo.setValore(listaValori[idxValueToBeSet]);
					}
				//}
			}
		}
		return campi;		
	}
	
	
	/** metodo che cicla sulla lista di controlli ed esegue tutti i controlli di tipo 
	 * updateValore consecutivi, a partire dall'elemento con indice startIdx
	 * @param campi
	 * @param controlli
	 * @param startIdx
	 * @return la lista aggiornata di campi
	 * @throws NumberFormatException
	 */
	private static List<CampiAggiuntiviPratica> updateValore(List<CampiAggiuntiviPratica> campi,
			String[] controlli, int startIdx) throws NumberFormatException {
		for (int idUp=startIdx; idUp<controlli.length; idUp++)
		{	
			if(controlli[idUp].startsWith("updateValore")){
				String ctrlUp[] = controlli[idUp].split("#");
				String campiSplUp[] = ctrlUp[1].split(",");
				long valoreIdxUp = Long.parseLong(campiSplUp[0]);
				log.debug("updateValore"+idUp+"="+campiSplUp[1]);
				
				CampiAggiuntiviPratica campoAgg = findCampoAggiuntivoByID(campi, valoreIdxUp);
				if(campiSplUp[1].equalsIgnoreCase("null"))
					campoAgg.setValore(null);
				else if (campoAgg.getCampiAggiuntivi().getTipologia().equals("e")){
					String strDateTime = campiSplUp[1];
					if(strDateTime.equalsIgnoreCase("now")){
						if (campoAgg.getCampiAggiuntivi().getClasseCSS().equalsIgnoreCase("datetime"))
							strDateTime = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(Calendar.getInstance().getTime());
						else
							strDateTime = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
					}

					if (DateUtils.isData(strDateTime))
						campoAgg.setValore(strDateTime);
					else
						log.error(String.format("Impossibile assegnare il valore %s ad un campo aggiuntivo date.", strDateTime));
				}
				else
					campoAgg.setValore(campiSplUp[1]);
			}
			else
				break;
		}
		
		return campi;
	}
	
	/** metodo che cicla sulla lista di controlli ed esegue tutti i controlli di tipo 
	 * updateValore consecutivi, a partire dall'elemento con indice startIdx
	 * @param campi
	 * @param controlli
	 * @param startIdx
	 * @return la lista aggiornata di campi
	 * @throws NumberFormatException
	 */
	private static List<CampiAggiuntiviPratica> updateValoreIfEmpty(List<CampiAggiuntiviPratica> campi,
			String[] controlli, int startIdx) throws NumberFormatException {
		for (int idUp=startIdx; idUp<controlli.length; idUp++)
		{	
			if(controlli[idUp].startsWith("ifEmptyUpdateValore")){
				String ctrlUp[] = controlli[idUp].split("#");
				String campiSplUp[] = ctrlUp[1].split(",");
				long valoreIdxUp = Long.parseLong(campiSplUp[0]);
				log.debug("ifEmptyUpdateValore"+idUp+"="+campiSplUp[1]);
				
				CampiAggiuntiviPratica campoAgg = findCampoAggiuntivoByID(campi, valoreIdxUp);
				if (campoAgg.getValore()==null || campoAgg.getValore().isEmpty()){
					if(campiSplUp[1].equalsIgnoreCase("null"))
						campoAgg.setValore(null);
					else if (campoAgg.getCampiAggiuntivi().getTipologia().equals("e")){
						String strDateTime = campiSplUp[1];
						if(strDateTime.equalsIgnoreCase("now")){
							if (campoAgg.getCampiAggiuntivi().getClasseCSS().equalsIgnoreCase("datetime"))
								strDateTime = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(Calendar.getInstance().getTime());
							else
								strDateTime = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
						}
	
						if (DateUtils.isData(strDateTime))
							campoAgg.setValore(strDateTime);
						else
							log.error(String.format("Impossibile assegnare il valore %s ad un campo aggiuntivo date.", strDateTime));
					}
					else
						campoAgg.setValore(campiSplUp[1]);
				}
			}
			else
				break;
		}
		
		return campi;
	}
	
	public static CampiAggiuntiviPratica defaultValue(CampiAggiuntiviPratica campo) {
		try {
			String controllo = campo.getCampiAggiuntivi().getControllo();
			if (controllo != null && ! controllo.equals("")) {
				String[] controlli = controllo.split("\\|");
				for(int i=0;i<controlli.length;i++) {
					if (controlli[i].startsWith("default")) {
						String posString = controlli[i].split("#")[1];
						if (posString.equalsIgnoreCase("null"))
							campo.setValore(null);
						else{
							if (campo.getCampiAggiuntivi().getTipologia().equals("g")) { 
								try {
									int pos = Integer.parseInt(posString);
									campo.setValore(campo.getCampiAggiuntivi().getListaValoriArray()[pos]);
								} catch(NumberFormatException e){
									campo.setValore(posString);
								}
							} else if (campo.getCampiAggiuntivi().getTipologia().equals("l")) {
								try {
									int pos = Integer.parseInt(posString);
									campo.setValore(campo.getCampiAggiuntivi().getValori().get(pos).getValore());
								} catch(NumberFormatException e){
									campo.setValore(posString);
								}
							}
						}
					}
				}
			}
		}
		catch (Exception ex) {
			log.error(ex.getMessage(), ex);
		}
		return campo;
	}
	
	/**
	 * Metodo che imposta il valore di default per i filtri di ricerca
	 * Il controllo dovrà avere la seguente struttura "default#XXX" dove XXX può essere il valore di default oppure l'indice 
	 * all'interno alla lista dei possibili valori.
	 */
	public static CampiAggiuntivi defaultValueRicerca(CampiAggiuntivi campo) {
		String controllo = campo.getControllo();
		if (controllo != null && ! controllo.equals("")) {
			String[] controlli = controllo.split("\\|");
			for(int i=0;i<controlli.length;i++) {
				if (controlli[i].startsWith("default")) {
					String posString = controlli[i].split("#")[1];
					if (posString.equalsIgnoreCase("null"))
						campo.setValoreRicerca(null);
					else{
						if (campo.getTipologia().equals("g")) { 
							try {
								int pos = Integer.parseInt(posString);
								campo.setValoreRicerca(campo.getListaValoriArray()[pos]);
							} catch(NumberFormatException e){
								campo.setValoreRicerca(posString);
							}
						} else if (campo.getTipologia().equals("l")) {
							try {
								int pos = Integer.parseInt(posString);
								campo.setValoreRicerca(campo.getValori().get(pos).getValore());
							} catch(NumberFormatException e){
								campo.setValoreRicerca(posString);
							}
						}
					}
				}
			}
		}
		return campo;
	}
	
	public static Map<Integer,Map<String,List<String>>> getCampiFormula(List<CampiAggiuntiviPratica> campi) {
		Map<Integer,Map<String,List<String>>> result = new HashMap<Integer, Map<String,List<String>>>();
		try {
			for(int i=0;i<campi.size();i++) {
				CampiAggiuntiviPratica campo = campi.get(i);
				if (campo.getCampiAggiuntivi() != null) {
					if (campo.getCampiAggiuntivi().getControllo().contains("formula") && campo.getCampiAggiuntivi().getTipologia().equals("d")) {
						String[] controlli = campo.getCampiAggiuntivi().getControllo().split("\\|");
						String valoreFormula = null;
						for(String token:controlli) {
							if (token.startsWith("formula"))
								valoreFormula = token.split("#")[1];
						}
						StringTokenizer st = new StringTokenizer(valoreFormula, "+-*/", true);
						List<String> operatoriDinamici = new ArrayList<String>();
						List<String> newFormula = new ArrayList<String>();
						while(st.hasMoreTokens()) {
							String token = st.nextToken();
							if (!token.startsWith("$") || "+-*/".indexOf(token)!=-1)
								newFormula.add(token);
							else {
								int index = campi.indexOf(findCampoAggiuntivoByID(campi, Long.parseLong(token.substring(1))));
								String expression ="$"+index; 
								newFormula.add(expression);
								operatoriDinamici.add(""+index);
							}
						}
						Map<String,List<String>> valori = new HashMap<String, List<String>>();
						valori.put("formula", newFormula);
						valori.put("campi", operatoriDinamici);
						result.put(i, valori);
					}
				}
			}
		}
		catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		catch (Throwable t) {
			log.error(t.getMessage(), t);
		}
		
		return result;
	}
	
	private static AllegatiPratica allegaModello(
			Pratica pratica, 
			String[] controlli, 
			int startIdx, 
			String mainModelloPath, 
			String _dest, 
			GestionePraticheService praticheService,
			PraticaRepository praticaRepository) throws Exception {
		
		AllegatiPratica modelloPdfAllegato = null;
		
		for (int idUp=startIdx; idUp<controlli.length; idUp++)
		{	
			if(controlli[idUp].startsWith("allegaModello")){
				String ctrlUp[] = controlli[idUp].split("#");
				String nomeModello = ctrlUp[1];
				log.debug("allegaModello"+idUp+"="+ctrlUp[1]);
				
				// Recupero l'allegato Pratica con tale nome se esiste...
				if (nomeModello.length()>0){
					for (AllegatiPratica alPra : pratica.getAllegati()){
						if (alPra.getAllegati().getNomeDocumento().startsWith(nomeModello) && alPra.isModello()){
							modelloPdfAllegato = alPra;
							break;
						}
					}
					
					// Verifico se è stata già inviata una mail allo stesso destinatario per questo allegatoPratica...
					File pdfGenerato = null;
					if (modelloPdfAllegato!=null){
						if (!praticheService.esisteMailInviata(_dest, modelloPdfAllegato)){
							//E' stato trovato un allegatoPratica generato dal modello con id=idModello,
							//ma non è mai stata inviata una mail con tale allegatoPratica...
							pdfGenerato = praticheService.generaModelloPdf(pratica, nomeModello, mainModelloPath);
							modelloPdfAllegato.setAllegato(pdfGenerato);
							praticheService.caricaInDocumentale(pratica.getUuidContenitore(), modelloPdfAllegato, modelloPdfAllegato);
							
							log.info(String.format("Sono già state inviate mail al destinatario %s con allegato %s", 
									_dest, pdfGenerato.getName()));
						}
					}
					else{
						log.info(String.format("Generazione del nuovo pdf %s da inviare al destinatario %s...", nomeModello, _dest));
						
						// Non e' stato trovato un allegatoPratica generato dal modello con id=idModello...
						pdfGenerato = praticheService.generaModelloPdf(pratica, nomeModello, mainModelloPath);
						
						//Genero il nuovo AllegatoPratica
						DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
						String nomeDocumento = String.format("%s alla data del %s", nomeModello,df.format(new Date()));
						
						modelloPdfAllegato = new AllegatiPratica();
						Allegati allegato = new Allegati();
						allegato.setNomeDocumento(nomeDocumento);
						modelloPdfAllegato.setAllegati(allegato);
						modelloPdfAllegato.setAllegato(pdfGenerato);
						modelloPdfAllegato.setModello(true);
						modelloPdfAllegato.setPratica(pratica);
						
						pratica.getAllegati().add(modelloPdfAllegato);
						pratica = praticaRepository.save(pratica);
						
						// recupero l'allegatoPratica salvato in db...
						int modelloIdx = -1;
						for (int j=0; j < pratica.getAllegati().size(); j++){
							AllegatiPratica alPra = pratica.getAllegati().get(j);
							if (alPra.getAllegati().getNomeDocumento().equals(nomeDocumento) && alPra.isModello()){
								modelloIdx=j;
								break;
							}
						}
						
						log.info(String.format("modelloIdx :%s", modelloIdx));
						praticheService.caricaInDocumentale(pratica.getUuidContenitore(), modelloPdfAllegato, pratica.getAllegati().get(modelloIdx));
						
						// imposto a null il file fisico dell'allegato, 
						// per non caricarlo nuovamente nel documentale
						pratica.getAllegati().get(modelloIdx).setAllegato(null);
						return pratica.getAllegati().get(modelloIdx);
					}
				}
			}
			else
				break;
		}
		
		// imposto a null il file fisico dell'allegato, 
		// per non caricarlo nuovamente nel documentale
		if (modelloPdfAllegato != null)
			modelloPdfAllegato.setAllegato(null);
		
		return modelloPdfAllegato;
	}
	
	private static DatiInvioMail preparaInoltroAUrp(
			Pratica pratica, 
			long idModelloPdfAllegato, 
			String destinatario,
			String msgObject,
			String msgBody,
			ProfiloUtente user
			){
//		String.format(messageSource.getMessage("label.oggettoMail", null, request.getLocale()
		log.info(String.format("Preparazione mail con idModelloAllegato:%s per il destinatario :%s", idModelloPdfAllegato, destinatario));
		
		DatiInvioMail datiMail = new DatiInvioMail();
		
		// Recupero gli allegati dalla pratica
		List<AllegatiPraticaExtended> listaAllegati = new ArrayList<AllegatiPraticaExtended>();
		for (AllegatiPratica allegato : pratica.getAllegati()){
			log.info(String.format("Analisi allegatoPratica con id:%s - uuid:%s", allegato.getId(), allegato.getUuidFile()));
			if (allegato.getUuidFile()!=null && !allegato.getUuidFile().isEmpty()){
				if(allegato.getId() == idModelloPdfAllegato){
					listaAllegati.add(new AllegatiPraticaExtended(true, allegato));
					datiMail.setAllegato(allegato);
				}
				else
					listaAllegati.add(new AllegatiPraticaExtended(false, allegato));
			}
		}
		datiMail.setAllegatiSelezionati(listaAllegati);
		
		datiMail.setMittente(pratica.getTipologia().getMittenteMail());
		datiMail.setDestinatario(destinatario);
		datiMail.setDataInvio(DateUtils.getOggi());
		datiMail.setOggetto(msgObject);
		datiMail.setCorpo(msgBody);
		datiMail.setUtente(user);
		datiMail.setIdPratica(pratica.getId());
		
		return datiMail;
	}
	
	public static Pratica inotraAUrp(
			Pratica pratica,
			int indice,
			String strControlli, 
			String mainModelloPath, 
			GestionePraticheService praticheService,
			PraticaRepository praticaRepository,
			CampiAggiuntiviPraticaRepository caPrRepository,
			String msgObject,
			String msgBody,
			ProfiloUtente user
			){
		List<CampiAggiuntiviPratica> campi = pratica.getCampiaggiuntivi();
		CampiAggiuntiviPratica campo = campi.get(indice);
		String listaControlli[] = strControlli.split("\\|");
		
		for(int j=0; j < listaControlli.length; j++){
			
			if(listaControlli[j].startsWith("inoltraAUrp")){
				String ctrlInoltraAUrpElements[] = listaControlli[j].split("#");
				String campiSpl[] = ctrlInoltraAUrpElements[1].split(",");
				
				CampiAggiuntiviPratica actualCaPr = caPrRepository.findByCampiAggiuntiviAndPratica(campo.getCampiAggiuntivi(), pratica);
				if(contieneValore(campo, campiSpl[0]) && !contieneValore(actualCaPr, campiSpl[0])){
					long valoreIdxUp = Long.parseLong(campiSpl[1]);
					CampiAggiuntiviPratica campoAgg = findCampoAggiuntivoByID(campi, valoreIdxUp);
					if (campoAgg!= null){
						log.info("inoltraAUrp automatico start...");
						log.debug(String.format("Trovato CampoAggiuntivo: ID=$s, label=$s, valore=$s",
								valoreIdxUp, campoAgg.getCampiAggiuntivi().getLabel(), campoAgg.getValore()));
						
						String destinatario = praticheService.getUrpMailAccount(campoAgg.getValore());
						log.info((String.format("Mail Account URP Destinataria : %s", destinatario)));
					
						try {
							AllegatiPratica modelloPdfAllegato = allegaModello(pratica, listaControlli, j+1, mainModelloPath, destinatario, praticheService, praticaRepository);
							log.info("allegaModello automatico eseguito!!");
							
							if (modelloPdfAllegato!=null){
								
								// recupero nuovamente la pratica dal db...
								pratica = praticaRepository.findOne(pratica.getId());
								
								// Preparo la mail da inviare...
								DatiInvioMail mailDaInviare = preparaInoltroAUrp(pratica, modelloPdfAllegato.getId(), destinatario, msgObject, msgBody, user);
								log.info("mailDaInviare preparata!!");
								// Invio la mail...
								boolean inviata = praticheService.invioMailWithAllegato(mailDaInviare);
								log.info(String.format("invioMailWithAllegato eseguito!! Esito:%s", inviata));
								
								if (inviata){
									for(int i=0; i < pratica.getAllegati().size();i++){
										if(pratica.getAllegati().get(i).getId()!=null && mailDaInviare.getAllegato()!=null){
											if(pratica.getAllegati().get(i).getId().equals(mailDaInviare.getAllegato().getId())){
												pratica.getAllegati().get(i).getMail().add(mailDaInviare);
											}
										}
									}
									
									log.debug(String.format("ControlloCampoAggiuntivo inoltraAUrp :: Invio mail con AllegatoPratica(id=%s) relativo alla Pratica(id=%s) al destinatario -%s- eseguito con SUCCESSO!!", 
											modelloPdfAllegato.getId(), pratica.getId(), mailDaInviare.getDestinatario()));
								}
								else
								{
									log.error(String.format("ControlloCampoAggiuntivo inoltraAUrp :: Invio mail con AllegatoPratica(id=%s) relativo alla Pratica(id=%s) al destinatario -%s- FALLITO!!", 
											modelloPdfAllegato.getId(), pratica.getId(), mailDaInviare.getDestinatario()));
								}
							}
							else
								log.debug("modelloPdfAllegato is null!!");
						} catch (Exception e) {
							log.error(e.getMessage(), e);
						}
					}
					else
						log.debug(String.format("Nessun Campo Aggiuntivo con ID=%s trovato in DB!!!",campiSpl[1]));	
				}
			}
		}
		return pratica;		
	}
	
	private static boolean contieneValore(CampiAggiuntiviPratica campo, String valoreIdxStr){
		boolean ret = false;
		
		int valoreIdx=0;
		if (valoreIdxStr.equalsIgnoreCase("null"))
			valoreIdx=-1;
//		else
//			valoreIdx=Integer.parseInt(valoreIdxStr);

		if (valoreIdx==-1){
			if (campo.getValore()==null || campo.getValore().equals(""))
				ret = true;
		}
		else
		{	
			String[] arrayValoriIdx = valoreIdxStr.split("or");
			for (int ii=0; ii<arrayValoriIdx.length; ii++){
				valoreIdx=Integer.parseInt(arrayValoriIdx[ii]);
				
				String listaValori[] = campo.getCampiAggiuntivi().getListaValori().split(",");
				if (listaValori !=null && listaValori.length >= valoreIdx){
					String valore = listaValori[valoreIdx];

					if (campo.getValore()!=null){
						if(campo.getValore().contains(valore)){
							ret = true;
							break;
						}
					}
				}
			}
		}

		return ret;
	}

	private static CampiAggiuntiviPratica findCampoAggiuntivoByID(List<CampiAggiuntiviPratica> campi, long idToBeFound){
		CampiAggiuntiviPratica result = null;
		
		for (CampiAggiuntiviPratica campo : campi){
			if (campo.getCampiAggiuntivi().getId().equals(idToBeFound)){
				result = campo;
				break;
			}
		}
		
		return result;	
	}
	
	private static boolean contieneValore(CampiAggiuntiviPratica campo, int valoreIdx){
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
	
	/**
	 * Recupera uno specifico campo aggiuntivo per la pratica pr. 
	 * 
	 * @param pr
	 * @param labelCampoAggiuntivo
	 * @return Restituisce il valore contenuto nel campo aggiuntivo della pratica pr la cui label 
	 * 		   è pari a labelCampoAggiuntivo, null se il campo aggiuntivo non esiste. 
	 */
	private static CampiAggiuntiviPratica getCampoAggiuntivoByLabel(List<CampiAggiuntiviPratica> campi, String labelCampoAggiuntivo){
		log.debug(String.format("getCampoAggiuntivoByLabel :: labelCampoAggiuntivo=%s", labelCampoAggiuntivo));
		CampiAggiuntiviPratica retValue = null;
		
		for (CampiAggiuntiviPratica ca_pr : campi){
			if (ca_pr.getCampiAggiuntivi().getLabel().toLowerCase().startsWith(labelCampoAggiuntivo.toLowerCase()))
				retValue = ca_pr;
		}
		
		return retValue;
	}
	public static boolean validaMailAddressObbligatoria(CampiAggiuntiviPratica campo){
		boolean ret = true;
		
		if(campo.getValore() == null || campo.getValore().equals("") || campo.getValore().replaceAll(",", "").equals(""))
			ret = false;
		else
			ret = validaMailAddress(campo);
		
		return ret;
	}
	public static boolean campoObbligatorioRegEx(CampiAggiuntiviPratica campo, String regEx){
		boolean ret = true;
		
		String strAllegato = "null";
		
		if (campo.getCampiAggiuntivi().getTipologia().equals("i")){
			if (campo.getAllegato() == null)
				ret = false;
			else{
				strAllegato = String.format("Name :>>%s<< | size : %d", 
						campo.getAllegato().getName(),
						campo.getAllegato().length());
				if (campo.getAllegato().length() == 0)
					ret = false;
			}
		}
		else{
			if(campo.getValore() == null || campo.getValore().equals("") || campo.getValore().replaceAll(",", "").equals(""))
				ret = false;
			
			if (ret) {
				final Pattern pattern = Pattern.compile(regEx);
			    if (!pattern.matcher(campo.getValore()).matches()) {
			    	ret = false;
			    }
			}
				
		}
		log.debug(String.format("Validazione del campo : Tipologia = %s; Label = %s; Valore = %s; RegEx = %s; Ret = %s",
				campo.getCampiAggiuntivi().getTipologia(),
				campo.getCampiAggiuntivi().getLabel(),
				campo.getValore(), regEx,
				ret));
		
		return ret;
	}
	
	private static boolean IsDittaIndividuale(CampiAggiuntiviPratica campoTipoImpresa)
	{
		boolean retValue = false;
		
		if (campoTipoImpresa != null) {
			if (campoTipoImpresa.getValore() != null) {
				if (campoTipoImpresa.getValore().equals(campoTipoImpresa.getCampiAggiuntivi().getListaValoriArray()[0]) ||
						campoTipoImpresa.getValore().toUpperCase().contains("(DI)")) {
					retValue = true;
				}
			}
		}
		
		return retValue;
	}
	private static String campoObbligatorioCodFiscaleImpresa(CampiAggiuntiviPratica campo, CampiAggiuntiviPratica campoTipoImpresa){
		String retValue = "";
		
		log.debug(String.format("campoTipoImpresa.getValore():%s", campoTipoImpresa.getValore()));
		log.debug(String.format("campoTipoImpresa.getCampiAggiuntivi().getListaValoriArray()[0]:%s", campoTipoImpresa.getCampiAggiuntivi().getListaValoriArray()[0]));
		
		if (IsDittaIndividuale(campoTipoImpresa))
		{
			if (!campoObbligatorioRegEx(campo, REGEX_CODICE_FISCALE)) {
				retValue = "NotValid.string.codFiscaleImpresa";
			}
		}
		else {
			if (!campoObbligatorioRegEx(campo, REGEX_PARTITA_IVA)) {
				retValue = "NotValid.string.codFiscaleImpresa";
			}
		}
		
		return retValue;
	}
}
