package it.sincon.gepred.persistence;

import it.osapulie.domain.ProfiloUtente;
import it.sincon.gepred.domain.pratica.CategoriePratiche;
import it.sincon.gepred.domain.pratica.PraticaWeb;
import it.sincon.gepred.domain.pratica.TipoPratica;

import java.util.List;

import javax.persistence.OrderBy;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 
 * @author Maria Michela Birtolo
 * @author Antonio Santomauro
 *
 */
public interface TipoPraticaRepository extends JpaRepository<TipoPratica, Long> {
	
	@OrderBy("descrizione")
	List<TipoPratica> findAll();
	
	@OrderBy("descrizione")
	List<TipoPratica> findByFrontend(Boolean frontend);
	@OrderBy("descrizione")
	List<TipoPratica> findByCategoriaAndFrontend(CategoriePratiche categoria, Boolean frontend);
}
