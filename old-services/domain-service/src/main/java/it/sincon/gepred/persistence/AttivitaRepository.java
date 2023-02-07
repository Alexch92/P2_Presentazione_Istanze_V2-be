package it.sincon.gepred.persistence;

import it.sincon.gepred.domain.Attivita;

import java.util.Collection;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AttivitaRepository extends PagingAndSortingRepository<Attivita, Long> {

	@Override
	Collection<Attivita> findAll();

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.data.repository.PagingAndSortingRepository#findAll(org.springframework
	 * .data.domain.Sort)
	 */
	@Override
	public Iterable<Attivita> findAll(Sort sort);
	
}
