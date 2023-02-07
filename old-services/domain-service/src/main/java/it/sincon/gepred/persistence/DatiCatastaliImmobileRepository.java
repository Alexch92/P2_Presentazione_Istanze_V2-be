package it.sincon.gepred.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.sincon.gepred.domain.pratica.DatiCatastaliImmobile;

/**
 * 
 * @author Antonio Santomauro
 *
 */
public interface DatiCatastaliImmobileRepository extends JpaRepository<DatiCatastaliImmobile, Long> {
	List<DatiCatastaliImmobile> findAll();
}
