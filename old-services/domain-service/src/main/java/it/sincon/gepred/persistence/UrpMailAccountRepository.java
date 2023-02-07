package it.sincon.gepred.persistence;

import it.sincon.gepred.domain.pratica.UrpMailAccount;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 
 * @author Antonio Santomauro
 *
 */
public interface UrpMailAccountRepository extends JpaRepository<UrpMailAccount, Long> {
	List<UrpMailAccount> findAll();
	
	UrpMailAccount findByUrp(String urp);
}
