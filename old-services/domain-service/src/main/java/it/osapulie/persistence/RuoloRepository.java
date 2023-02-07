package it.osapulie.persistence;

import it.osapulie.domain.Ruolo;

import org.springframework.data.repository.CrudRepository;


public interface RuoloRepository extends CrudRepository<Ruolo, Long> {
	
	public Ruolo findByNome(String nome);
	
}
