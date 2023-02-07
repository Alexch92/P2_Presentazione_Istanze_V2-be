package it.sincon.gepred.persistence;

import it.sincon.gepred.domain.pratica.AziendaRappresentanti;

import org.springframework.data.repository.PagingAndSortingRepository;
/**
 * @author Antonio Santomauro
 *
 */

public interface AziendaRappresentantiRepository extends PagingAndSortingRepository<AziendaRappresentanti, Long>
{
	
}