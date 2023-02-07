package it.sincon.gepred.persistence;

import it.sincon.gepred.domain.pratica.EsitoParere;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 
 * @author Maria Michela Birtolo
 *
 */
public interface EsitoParereRepository extends JpaRepository<EsitoParere, Long> {
	List<EsitoParere> findAll();
}
