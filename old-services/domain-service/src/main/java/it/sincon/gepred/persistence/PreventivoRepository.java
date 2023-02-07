package it.sincon.gepred.persistence;

import it.sincon.gepred.domain.pratica.Preventivo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 
 * @author Antonio Santomauro
 *
 */
public interface PreventivoRepository extends JpaRepository<Preventivo, Long> {
	List<Preventivo> findAll();
}
