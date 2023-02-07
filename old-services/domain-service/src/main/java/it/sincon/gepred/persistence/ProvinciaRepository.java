package it.sincon.gepred.persistence;

import java.util.List;

import it.osapulie.domain.Provincia;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProvinciaRepository extends PagingAndSortingRepository<Provincia, Long> {
	
	List<Provincia> findAll();

}
