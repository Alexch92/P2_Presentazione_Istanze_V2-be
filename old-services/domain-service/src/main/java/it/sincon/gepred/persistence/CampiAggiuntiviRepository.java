
package it.sincon.gepred.persistence;

import java.util.List;

import javax.persistence.OrderBy;

import it.sincon.gepred.domain.CampiAggiuntivi;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author Eligio Cavallo
 *
 */
public interface CampiAggiuntiviRepository extends PagingAndSortingRepository<CampiAggiuntivi, Long>{

	List<CampiAggiuntivi> findAll(Sort sort);
	
	@OrderBy("posizione")
	List<CampiAggiuntivi> findByRicercabile(boolean ricercabile);	
	
	//List<CampiAggiuntivi> findByTipoPratica(TipoPratica  tipoPratica);

}
