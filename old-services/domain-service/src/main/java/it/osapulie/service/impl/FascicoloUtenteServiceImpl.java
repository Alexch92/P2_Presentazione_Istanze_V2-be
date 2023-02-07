package it.osapulie.service.impl;

import it.osapulie.domain.ProfiloUtente;
import it.osapulie.domain.fascicoloutente.FascicoloUtente;
import it.osapulie.domain.fascicoloutente.RichiestaServizio;
import it.osapulie.domain.servizi.Servizio;
import it.osapulie.infrastructure.impl.DateUtils;
import it.osapulie.persistence.FascicoloUtenteRepository;
import it.osapulie.persistence.ProfiloUtenteRepository;
import it.osapulie.persistence.ServizioRepository;
import it.osapulie.service.FascicoloUtenteService;
import it.osapulie.shared.service.UserPreferences;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;


@Service("fascicoloUtenteService")
@Transactional
public class FascicoloUtenteServiceImpl implements FascicoloUtenteService {

	@Inject
	private FascicoloUtenteRepository repositoryFascicolo;

	@Inject
	private ProfiloUtenteRepository repositoryCittadino;

	@Inject
	private ServizioRepository servizioRepository;

//	@Inject
//	private ComuneISARepository comuneISARepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.osapulie.service.FascicoloUtenteService#saveNuovaRichiesta(it.osapulie.domain.
	 * ProfiloUtenteCittadino, java.lang.String, java.lang.String,
	 * it.osapulie.shared.service.UserPreferences)
	 */
	@Override
	public void saveNuovaRichiesta(ProfiloUtente cittadino, String servizio, String codFiscDelegante, UserPreferences userPreferences, String codiceServizio, boolean ricercabileDaComune, String checksum) {

		Assert.notNull(userPreferences, "userPreferences must be not NULL");
		Assert.notNull(codiceServizio, "codiceServizio must be not NULL");

		FascicoloUtente fascicolo = repositoryFascicolo.findByCittadino(cittadino);
		List<RichiestaServizio> richieste = null;
		if (fascicolo == null) {
			fascicolo = new FascicoloUtente();
			fascicolo.setCittadino(cittadino);
			richieste = new ArrayList<RichiestaServizio>();
		}
		else
			richieste = fascicolo.getRichieste();

		RichiestaServizio richiestaServizio = new RichiestaServizio();
		richiestaServizio.setDataRichiesta(DateUtils.getOggi());
		richiestaServizio.setNomeServizio(servizio);
		richiestaServizio.setFascicolo(fascicolo);

		String codiceIstat = userPreferences.getCodiceIstatComune();

		//ComuneISA comuneErogatore = comuneISARepository.findByCodiceIstat(codiceIstat);

		//richiestaServizio.setComuneErogatore(comuneErogatore);

		if (codFiscDelegante != null && !codFiscDelegante.toLowerCase().equals(cittadino.getCodiceFiscale().toLowerCase())) {
			ProfiloUtente delegante = repositoryCittadino.findByCodiceFiscale(codFiscDelegante);
			if (delegante != null)
				richiestaServizio.setDelegante(delegante);
		}

		// Salvataggio servizio
		Servizio servizio2 = servizioRepository.findByCodiceServizio(codiceServizio);
		richiestaServizio.setServizio(servizio2);

		richiestaServizio.setChecksum(checksum);
		richiestaServizio.setRicercabileDaComune(ricercabileDaComune);

		richieste.add(richiestaServizio);
		fascicolo.setRichieste(richieste);

		repositoryFascicolo.save(fascicolo);

	}
}
