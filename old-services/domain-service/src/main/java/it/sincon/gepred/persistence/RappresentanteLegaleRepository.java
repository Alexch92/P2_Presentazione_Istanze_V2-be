package it.sincon.gepred.persistence;

import it.sincon.gepred.domain.pratica.RappresentanteLegale;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 
 * @author Antonio Santomauro
 *
 */
public interface RappresentanteLegaleRepository extends JpaRepository<RappresentanteLegale, Long> {
	List<RappresentanteLegale> findAll();
}
