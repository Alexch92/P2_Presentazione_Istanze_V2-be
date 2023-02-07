package it.sincon.gepred.persistence;
/**
 * @author Antonio Santomauro
 *
 */
import it.sincon.gepred.domain.pratica.NumeroPratica;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface NumeroPraticaRepository  extends PagingAndSortingRepository<NumeroPratica,Long> {
	
	@Query("SELECT MAX(np.progressivo) FROM NumeroPratica np where np.prefisso = :prefisso AND np.anno = :anno")
	public Long findByMaxProgressivoByPrefissoAndAnno(@Param("prefisso") String prefisso,
               										  @Param("anno") Integer anno);

}



