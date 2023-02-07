package it.sincon.gepred.persistence;

import java.util.List;

import it.osapulie.domain.ProfiloUtente;
import it.sincon.gepred.domain.Immobile;
import it.sincon.gepred.domain.Referente;
import it.sincon.gepred.domain.pratica.Pratica;
import it.sincon.gepred.domain.pratica.TipoPratica;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository per l'entity pratica.
 * <strong>Nota</strong> questo repository è implementato tramite Spring Data JPA.
 * 
 * @author Maria Michela Birtolo
 * @author Eligio Cavallo
 */
public interface PraticaRepository extends JpaRepository<Pratica, Long> {
		List<Pratica> findByImmobile(Immobile immobile);
		List<Pratica> findByRichiedente(Referente richiedente);
		List<Pratica> findByTipologia(TipoPratica tipologia);
		Pratica findByAssegnatariAndDataScadenzaIsNull(ProfiloUtente utente);
		Pratica findByNumeroPratica(String numeroPratica);
}
