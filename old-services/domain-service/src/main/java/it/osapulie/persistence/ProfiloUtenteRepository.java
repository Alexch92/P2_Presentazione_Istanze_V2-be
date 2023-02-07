package it.osapulie.persistence;

import java.util.List;
import java.util.Collection;

import javax.persistence.OrderBy;


import org.springframework.data.jpa.repository.JpaRepository;

import it.osapulie.domain.ProfiloUtente;
import it.osapulie.domain.Ruolo;


public interface ProfiloUtenteRepository extends JpaRepository<ProfiloUtente, Long> {

	/**
	 * Recupera il {@link ProfiloUtente} dato il codice fiscale del cittadino.
	 * 
	 * @param codiceFiscale
	 * @return ProfiloUtenteCittadino
	 */
	ProfiloUtente findByCodiceFiscale(String codiceFiscale);
	
	/**
	 * Recupera il {@link ProfiloUtente} dato l'email.
	 * 
	 * @param email
	 * @return ProfiloUtente
	 */
	ProfiloUtente findByMail(String mail);
	
//	@OrderBy("cognome ASC")
//	List<ProfiloUtente> findByRuoloNotAndRuoloNot(Ruolo ruolo1,Ruolo ruolo2);
	
	@OrderBy("cognome ASC")
	List<ProfiloUtente> findAll();

//	@OrderBy("cognome ASC")
//	List<ProfiloUtente> findByRuolo_Nome(String nomeRuolo);
	
//	@OrderBy("cognome ASC")
//	List<ProfiloUtente> findByRuolo(Ruolo ruolo);
	
}
