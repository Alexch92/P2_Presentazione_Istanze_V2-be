package it.sincon.gepred.persistence;
/**
 * @author Eligio Cavallo
 *
 */
import java.util.List;

import javax.persistence.OrderBy;

import it.sincon.gepred.domain.Allegati;
import it.sincon.gepred.domain.pratica.TipoPratica;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface AllegatiRepository  extends PagingAndSortingRepository<Allegati,Long> {
	
	@OrderBy("posizione")
	public List<Allegati> findByTipoPratica(TipoPratica tipoPratica);
}
