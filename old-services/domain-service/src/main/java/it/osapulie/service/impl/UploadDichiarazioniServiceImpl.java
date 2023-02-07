package it.osapulie.service.impl;

import it.osapulie.domain.ProfiloUtente;
//import it.osapulie.persistence.ComuneISARepository;
import it.osapulie.service.UploadDichiarazioniService;
import it.osapulie.shared.service.UserPreferences;
import it.osapulie.web.portlet.util.MailPecSenderHelper;
import it.osapulie.web.portlet.util.UploadItem;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.portlet.PortletException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("uploadDichiarazioniService")
@Transactional
public class UploadDichiarazioniServiceImpl implements UploadDichiarazioniService {

	private static Logger log = LoggerFactory.getLogger(UploadDichiarazioniServiceImpl.class);

	@Inject
	private MailPecSenderHelper mailPecSenderHelper;

//	@Inject
//	private ComuneISARepository comuneISARepository;

	/**
	 * Metodo che prende i file uploadati, li verifica e li invia alla PEC del comune
	 * 
	 * @param tipologia
	 * @param UploadItem
	 * 
	 */
	@Override
	public void processaUploadDichiarazioni(String tipologia, UploadItem uploadItem, ProfiloUtente profiloUtente, UserPreferences userPreferences) throws PortletException, IOException {

		String codiceIstat = userPreferences.getCodiceIstatComune();

//		ComuneISA comuneErogatore = comuneISARepository.findByCodiceIstat(codiceIstat);

//		mailPecSenderHelper.setTO(comuneErogatore.getPec());

		Map<String, String> model = new HashMap<String, String>();
		model.put("dichiarazione", tipologia);
		model.put("nome", profiloUtente.getNome());
		model.put("cognome", profiloUtente.getCognome());

		try {
			//mailPecSenderHelper.sendConfirmationEmail(tipologia, "dichiarazioni.vm", uploadItem, model);
		}
		catch (Exception e) {
			log.error("processaUploadDichiarazioni :: " + e.getMessage(), e);
//			throw new IOException("processaUploadDichiarazioni :: Errore durante l'invio della PEC mail all'indirizzo " + comuneErogatore.getPec(), e);
		}
	}
}
