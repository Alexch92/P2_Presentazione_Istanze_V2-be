package it.sincon.gepred.persistence;

import it.sincon.gepred.domain.pratica.EsitoIstruttoria;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 
 * @author Antonio Santomauro
 *
 */
public interface EsitoIstruttoriaRepository extends JpaRepository<EsitoIstruttoria, Long> {
	List<EsitoIstruttoria> findAll();
}
