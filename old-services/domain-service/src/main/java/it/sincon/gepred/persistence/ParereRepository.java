package it.sincon.gepred.persistence;

import it.sincon.gepred.domain.pratica.Parere;


import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 
 * @author Maria Michela Birtolo
 *
 */
public interface ParereRepository extends JpaRepository<Parere, Long> {
	
}
