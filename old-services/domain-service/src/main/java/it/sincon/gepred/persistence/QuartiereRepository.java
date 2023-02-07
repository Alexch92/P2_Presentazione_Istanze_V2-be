package it.sincon.gepred.persistence;

import java.util.List;

import it.sincon.gepred.domain.Quartiere;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface QuartiereRepository extends PagingAndSortingRepository<Quartiere, Long> {
	
	List<Quartiere> findAll();

}
