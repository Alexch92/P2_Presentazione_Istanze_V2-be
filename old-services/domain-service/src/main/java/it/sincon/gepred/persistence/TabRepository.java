package it.sincon.gepred.persistence;

import it.sincon.gepred.domain.pratica.Tab;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TabRepository extends JpaRepository<Tab, Long>{
		
	public List<Tab> findByMaster(boolean master);
}
