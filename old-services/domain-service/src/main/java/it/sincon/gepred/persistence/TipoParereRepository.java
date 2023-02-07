package it.sincon.gepred.persistence;

import it.sincon.gepred.domain.pratica.TipoParere;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 
 * @author Maria Michela Birtolo
 *
 */
public interface TipoParereRepository extends JpaRepository<TipoParere, Long> {
	List<TipoParere> findAll();
}
