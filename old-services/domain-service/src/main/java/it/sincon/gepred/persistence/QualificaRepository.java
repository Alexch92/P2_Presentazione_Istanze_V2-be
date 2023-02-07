package it.sincon.gepred.persistence;

import it.sincon.gepred.domain.pratica.Qualifica;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 
 * @author Maria Michela Birtolo
 *
 */
public interface QualificaRepository extends JpaRepository<Qualifica, Long> {
	List<Qualifica> findAll();
	List<Qualifica> findByCodicequalifica(int _codice);
}
