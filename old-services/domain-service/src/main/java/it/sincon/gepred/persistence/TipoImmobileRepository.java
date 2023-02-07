package it.sincon.gepred.persistence;

import it.sincon.gepred.domain.TipoImmobile;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoImmobileRepository extends JpaRepository<TipoImmobile, Long> {
	List<TipoImmobile> findAll();
}
