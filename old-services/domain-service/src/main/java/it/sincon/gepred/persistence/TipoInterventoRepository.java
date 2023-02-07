package it.sincon.gepred.persistence;

import it.sincon.gepred.domain.pratica.TipoIntervento;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 
 * @author Maria Michela Birtolo
 *
 */
public interface TipoInterventoRepository extends JpaRepository<TipoIntervento, Long> {
	List<TipoIntervento> findAll();
	List<TipoIntervento> findByClasse(int classe);
}
