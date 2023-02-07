package it.sincon.gepred.persistence;

import java.util.List;

import it.sincon.gepred.domain.TipoPraticaAttivita;
import it.sincon.gepred.domain.pratica.TipoPratica;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository per l'entity {@link TipoPraticaAttivita}
 * 
 * @author Angelo Pascadopoli
 *
 */
public interface TipoPraticaAttivitaRepository extends JpaRepository<TipoPraticaAttivita, Long> {
	
	List<TipoPraticaAttivita> findAll();
	List<TipoPraticaAttivita> findByTipoPraticaAndAutomatica(TipoPratica tipologia, int automatica);

}
