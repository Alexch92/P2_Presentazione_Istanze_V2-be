package it.sincon.gepred.scheduler;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.PrefsPropsUtil;

import it.osapulie.domain.ProfiloUtente;
import it.osapulie.service.ProfiloUtenteService;
import it.osapulie.web.portlet.util.MailPecSenderHelper;
import it.osapulie.web.portlet.util.MailSenderHelper;
import it.sincon.gepred.domain.AttivitaPratica;
import it.sincon.gepred.service.GestioneAttivitaPraticaService;

@Component
public class GepredSchedulerTask {

	private static Logger log = LoggerFactory
			.getLogger(GepredSchedulerTask.class);

	@Inject
	private MailSenderHelper mailSenderHelper;
	
	@Inject
	private MailPecSenderHelper mailPecSenderHelper;

	@Value("#{applicationProperties.message_alert}")
	private String messageAlertEmail;

	@Inject
	private GestioneAttivitaPraticaService attivitaPraticaService;
	
	@Inject
	private ProfiloUtenteService profiloUtenteService;
	
	@Scheduled(cron="0 0 1 * * ?")
	public void sendAlertExpired() {
		log.info("start sendAlertExpired");
		List<AttivitaPratica> elencoAttivitaScadute=attivitaPraticaService.searchByProfiloUtenteAndDataCompletamentoIsNull(null);
		Map<Long, List<AttivitaPratica>> mappingAttivitaUtenti=new HashMap<Long, List<AttivitaPratica>>();
		for(AttivitaPratica attivita:elencoAttivitaScadute) {
			if (attivita.getDataScadenza()!=null && attivita.getDataScadenza().before(new Date()) && attivita.isSendAlertMail()) {
				if (!mappingAttivitaUtenti.containsKey(attivita.getProfiloutente().getId()))
					mappingAttivitaUtenti.put(attivita.getProfiloutente().getId(), new ArrayList<AttivitaPratica>());
				mappingAttivitaUtenti.get(attivita.getProfiloutente().getId()).add(attivita);
			}
		}
		log.info("numero utenti: "+mappingAttivitaUtenti.size());
		boolean pecEnableBoolean = false;
		try {
			pecEnableBoolean=Boolean
					.parseBoolean(PrefsPropsUtil.getString("pec.mail.session.mail.smtp.enable"));
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		for(Map.Entry<Long, List<AttivitaPratica>> riga:mappingAttivitaUtenti.entrySet()) {
			ProfiloUtente utente=profiloUtenteService.getProfiloUtenteCittadinoById(riga.getKey());
			StringBuilder body=new StringBuilder("Elenco attivita' scadute:\n");
			for(AttivitaPratica attivita:riga.getValue()) {
				String message=messageAlertEmail.replaceAll("\\$nomeAttivita", attivita.getAttivita().getDescrizione());
				message=message.replaceAll("\\$numeroPratica", attivita.getPratica().getNumeroPratica());
				if (attivita.getDataAssegnazione()!=null)
					message=message.replaceAll("\\$dataAssegnazione",df.format(attivita.getDataAssegnazione()));
				else
					message=message.replaceAll("\\$dataAssegnazione", "-");
				message=message.replaceAll("\\$dataScadenza", df.format(attivita.getDataScadenza()));
				body.append(message);
				body.append("\n");
			}
			log.info("body: "+body);
			try {
				if (pecEnableBoolean)
					mailPecSenderHelper.sendMail("Notifica attivita' scadute", body.toString(), new File[0], null, new String[] {utente.getMail()});
				else
					mailSenderHelper.sendMail("Notifica attivita' scadute", body.toString(), new File[0], null, new String[] {utente.getMail()});
			}catch(Exception e) {
				log.error(e.getMessage(),e);
				e.printStackTrace();
			}
		}
		log.info("end sendAlertExpired");
		
	}
}
