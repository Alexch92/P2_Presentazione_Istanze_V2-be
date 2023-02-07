package it.sincon.gepred.persistence;

import java.util.List;

import javax.persistence.OrderBy;

import it.osapulie.domain.ProfiloUtente;
import it.sincon.gepred.domain.Referente;
import it.sincon.gepred.domain.pratica.Pratica;
import it.sincon.gepred.domain.pratica.PraticaWeb;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Repository per l'entity pratica.
 * <strong>Nota</strong> questo repository e' implementato tramite Spring Data JPA.
 * 
 * @author Maria Michela Birtolo
 */
public interface PraticaWebRepository extends JpaRepository<PraticaWeb, Long> {
	public final static String FIND_BY_RICHCF_AND_STATO_NON_ACCETTATA_QUERY = 
			"SELECT pr " + 
            "FROM  PraticaWeb pr " +
            "WHERE pr.richCf = :_richCf AND pr.stato != 'A'";
	
	List<PraticaWeb> findByProfiloutenteOrderByDataRichiestaDesc(ProfiloUtente profiloutente);
	
	@Query(FIND_BY_RICHCF_AND_STATO_NON_ACCETTATA_QUERY)
	List<PraticaWeb> findByRichCf(@Param("_richCf")String _richCf);
	
	List<PraticaWeb> findByReferente(Referente referente);
	
	@OrderBy("dataValidazione DESC")
	List<PraticaWeb> findByStato(String stato);
	
	PraticaWeb findByNumeroPratica(String numeroPratica);
	
}
