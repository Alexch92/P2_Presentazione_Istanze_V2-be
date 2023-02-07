package it.sincon.gepred.persistence;

import it.sincon.gepred.domain.pratica.FascicoloTemporaneo;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository per l'entity pratica.
 * <strong>Nota</strong> questo repository è implementato tramite Spring Data JPA.
 * 
 * @author Maria Michela Birtolo
 * @author Eligio Cavallo
 */
public interface FascicoloTemporaneoRepository extends JpaRepository<FascicoloTemporaneo, Long> {
		
}
