package it.osapulie.persistence;

import it.osapulie.domain.servizi.Servizio;

import java.util.List;

import javax.persistence.OrderBy;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ServizioRepository extends JpaRepository<Servizio, Long> {

	@Override
	@OrderBy("nomeServizio")
	List<Servizio> findAll();

	/**
	 * Recupera il {@link Servizio} dato il codice
	 * 
	 * @param codiceServizio
	 * @return Servizio
	 */
	Servizio findByCodiceServizio(String codiceServizio);
}
