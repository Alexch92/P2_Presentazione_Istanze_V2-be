package it.sincon.gepred.persistence;

import it.sincon.gepred.domain.pratica.Figura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FiguraRepository extends JpaRepository<Figura,Long> {

}
