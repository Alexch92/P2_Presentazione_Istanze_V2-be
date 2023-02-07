package it.osapulie.persistence;

import it.osapulie.domain.ProfiloUtente;
import it.osapulie.domain.fascicoloutente.FascicoloUtente;

import org.springframework.data.repository.CrudRepository;

import com.sun.istack.Nullable;

public interface FascicoloUtenteRepository extends CrudRepository<FascicoloUtente, Long> {
	
	/**
	 * Recupera il {@link FascicoloUtente} dato l'id del profilo cittadino.
	 * @param id
	 * @return FascicoloUtente
	 */
	@Nullable
	FascicoloUtente findByCittadino( ProfiloUtente cittadino );

}
