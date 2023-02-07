package it.sincon.gepred.persistence;
/**
 * 
 * repository implementato tramite Spring Data JPA.
 * 
 *  @author Eligo Cavallo - Sincon srl 
 **/

import java.util.List;

import it.osapulie.domain.Comune;
import it.sincon.gepred.domain.Ente;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EnteRepository extends PagingAndSortingRepository<Ente, Long>{
	List<Ente> findByComune(Comune comune);
}



