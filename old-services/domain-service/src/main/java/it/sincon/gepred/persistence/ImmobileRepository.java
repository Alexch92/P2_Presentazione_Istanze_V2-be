package it.sincon.gepred.persistence;


import java.util.List;

import it.osapulie.domain.Comune;
import it.sincon.gepred.domain.Immobile;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 
 * @author Maria Michela Birtolo
 * @author Eligio Cavallo
 */
public interface ImmobileRepository extends JpaRepository<Immobile, Long> {
	List<Immobile> findByComune(Comune comune);
	Immobile findByFoglioAndParticellaAndSubalternoAndComune(int foglio,String particella, String sub,Comune comune);
}
