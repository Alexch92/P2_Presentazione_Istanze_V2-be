package it.sincon.gepred.persistence;

import it.sincon.gepred.domain.pratica.StatoPratica;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 
 * @author Maria Michela Birtolo
 *
 */
public interface StatoPraticaRepository extends JpaRepository<StatoPratica, Long> {
	List<StatoPratica> findAll();
}
