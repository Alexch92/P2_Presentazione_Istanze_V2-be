package it.osapulie.persistence;

import it.osapulie.domain.Permesso;

import org.springframework.data.repository.CrudRepository;


public interface PermessoRepository extends CrudRepository<Permesso, Long> {
	
	
}
