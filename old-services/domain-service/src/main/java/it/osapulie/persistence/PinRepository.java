package it.osapulie.persistence;

//import it.osapulie.domain.ComuneISA;
import it.osapulie.domain.Pin;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PinRepository extends CrudRepository<Pin, Long> {

	//List<Pin> findByComuneIsa(ComuneISA comuneISA);

}
