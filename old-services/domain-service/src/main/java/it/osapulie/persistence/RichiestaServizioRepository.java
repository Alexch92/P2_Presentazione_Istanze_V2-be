package it.osapulie.persistence;

import it.osapulie.domain.fascicoloutente.FascicoloUtente;
import it.osapulie.domain.fascicoloutente.RichiestaServizio;
import it.osapulie.domain.servizi.Servizio;

import org.springframework.data.repository.CrudRepository;

import com.sun.istack.Nullable;

public interface RichiestaServizioRepository extends CrudRepository<RichiestaServizio, Long> {
	
	@Nullable
	RichiestaServizio findByFascicoloAndChecksumAndServizio( FascicoloUtente fascicolo , String checksum, Servizio servizio);

}
