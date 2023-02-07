package it.sincon.gepred.persistence;

import it.sincon.gepred.domain.CampiAggiuntiviTipoPratica;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository per {@link CampiAggiuntiviTipoPratica}
 * 
 * @author Angelo Pascadopoli
 *
 */
public interface CampiAggiuntiviTipoPraticaRepository extends JpaRepository<CampiAggiuntiviTipoPratica, Long> {
	
}
