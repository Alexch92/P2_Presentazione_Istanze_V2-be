package it.sincon.gepred.persistence;
/**
 * @author Eligio Cavallo
 *
 */

import it.sincon.gepred.domain.pratica.Modelli;

import java.util.List;
import it.sincon.gepred.domain.pratica.TipoPratica;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ModelliRepository  extends PagingAndSortingRepository<Modelli,Long> {

List<Modelli> findByTipoPratica(TipoPratica	tipoPratica);

}
