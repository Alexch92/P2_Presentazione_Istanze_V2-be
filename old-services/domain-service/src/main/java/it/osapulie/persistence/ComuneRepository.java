package it.osapulie.persistence;

import it.osapulie.domain.Comune;

import java.util.Collection;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ComuneRepository extends PagingAndSortingRepository<Comune, Long> {

	@Override
	Collection<Comune> findAll();

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.data.repository.PagingAndSortingRepository#findAll(org.springframework
	 * .data.domain.Sort)
	 */
	@Override
	public Iterable<Comune> findAll(Sort sort);
	
	Comune findByCodiceComune(Integer codiceComune);
	Comune findByCodiceIstat1(String codiceIstat);
}
