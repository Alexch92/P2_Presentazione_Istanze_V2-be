package it.sincon.gepred.persistence;
import java.util.List;

import it.sincon.gepred.domain.CampiAggiuntivi;
import it.sincon.gepred.domain.CampiAggiuntiviPratica;
import it.sincon.gepred.domain.pratica.Pratica;

import org.springframework.data.repository.PagingAndSortingRepository;
/**
 * @author Eligio Cavallo
 *
 */

public interface CampiAggiuntiviPraticaRepository extends PagingAndSortingRepository<CampiAggiuntiviPratica, Long>
{
	List<CampiAggiuntiviPratica> findByCampiAggiuntivi(CampiAggiuntivi campiAggiuntivi);
	CampiAggiuntiviPratica findByCampiAggiuntiviAndPratica(CampiAggiuntivi campiAggiuntivi, Pratica pr);
}