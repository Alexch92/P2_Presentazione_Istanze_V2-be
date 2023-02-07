package it.sincon.gepred.persistence;

import it.sincon.gepred.domain.pratica.CategoriePratiche;

import java.util.List;

import javax.persistence.OrderBy;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository per CategoriePratiche
 * 
 * @author Angelo Pascadopoli
 *
 */
public interface CategoriePraticheRepository extends JpaRepository<CategoriePratiche, Long> {
	
	public List<CategoriePratiche> findAll();
	
	public CategoriePratiche findByDescr(String descrizione);
	
}
