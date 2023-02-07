package it.sincon.gepred.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import it.sincon.gepred.domain.pratica.Pratica;
import it.sincon.gepred.persistence.PraticaRepository;
import it.sincon.gepred.service.GestionePraticheService;
import it.sincon.gepred.service.ValidazioneIseeService;
import it.sincon.gepred.web.portlet.varie.DatiValidazioneIsee;

@Service("validazioneIseeService")
public class ValidazioneIseeServiceImpl implements ValidazioneIseeService {
	private static Logger log = LoggerFactory.getLogger(ValidazioneIseeServiceImpl.class);
	
	private static final String LABEL_ISEE_DICHIARATO = "I S E E";

	@PersistenceContext(unitName="gepred")
	private EntityManager em;

	@Inject
	private PraticaRepository praticaRepository;
	
	@Inject
	private GestionePraticheService gestionePraticheService;

	@Override
	public void eseguiValidazione(List<DatiValidazioneIsee> datiValidazioneIsee) {
		try {
			log.info("validazioneIseeService :: eseguiValidazione -> START");
			
			if (datiValidazioneIsee != null) {
				for (DatiValidazioneIsee datoDSU : datiValidazioneIsee) {
					eseguiValidazione(datoDSU);
				}
			} else {
				log.warn("validazioneIseeService :: eseguiValidazione -> datiValidazioneIsee IS NULL !");
			}
			
			log.info("validazioneIseeService :: eseguiValidazione -> END");
		} catch (Exception exp) {
			log.error(exp.getMessage(), exp);
		}
	}
	
	private void eseguiValidazione(DatiValidazioneIsee datoDSU) {
		if (datoDSU != null) {
			Pratica pratica = praticaRepository.findByNumeroPratica(datoDSU.getNrPratica());
			if (pratica != null) {
				validaPratica(pratica, datoDSU);
			} else {
				log.warn(String.format("validazioneIseeService :: eseguiValidazione -> Pratica con numero %s non trovata! datoDSU scartato!", datoDSU.getNrPratica()));
			}
		} else {
			log.warn("validazioneIseeService :: eseguiValidazione -> datoDSU IS NULL !");
		}
	}
	
	private void validaPratica(Pratica pratica, DatiValidazioneIsee datoDSU) {
		double iseeDichiarato = Double.parseDouble(gestionePraticheService.getValoreCampoAggiuntivo(pratica, LABEL_ISEE_DICHIARATO));
		log.info(String.format("Verifica ISEE per istanza nr %s - ID:%s - Isee Dichiarato: %s - Isee da DSU: %s", 
				datoDSU.getNrPratica(), pratica.getId(),
				iseeDichiarato, datoDSU.getValoreIseeDSU()));
		
		pratica.setDataVerificaIsee(datoDSU.getDataValidazione());
		pratica.setIseeDaDSU(datoDSU.getValoreIseeDSU());
		pratica.setIseeVerificato(true);

		praticaRepository.save(pratica);
	}
}
