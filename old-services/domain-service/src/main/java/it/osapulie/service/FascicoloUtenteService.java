package it.osapulie.service;

import it.osapulie.domain.ProfiloUtente;
import it.osapulie.shared.service.UserPreferences;

public interface FascicoloUtenteService {

	/**
	 * Salva una nuova richiesta di operazione nel fascicolo del cittadino.
	 * 
	 * @param idProfiloUtente
	 * @param servizio
	 * @param codFiscDelegante
	 * @param userPreferences
	 * @param codiceServizio
	 * @param ricercabileDaComune
	 * @param checksum
	 */
	public void saveNuovaRichiesta(ProfiloUtente idProfiloUtente, String servizio, String codFiscDelegante, UserPreferences userPreferences, String codiceServizio, boolean ricercabileDaComune, String checksum);

}
