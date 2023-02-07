package it.sincon.gepred.persistence;

import it.sincon.gepred.domain.pratica.Azienda;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
/**
 * @author Antonio Santomauro
 *
 */

public interface AziendaRepository extends PagingAndSortingRepository<Azienda, Long>
{
	public List<Azienda> findAll();
	public Azienda findByPartitaIva(String partitaIva);
}