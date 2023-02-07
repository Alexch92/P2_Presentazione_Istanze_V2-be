package it.sincon.gepred.persistence;
/**
 * @author Eligio Cavallo
 *
 */
import it.sincon.gepred.domain.AllegatiPratica;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AllegatiPraticaRepository  extends PagingAndSortingRepository<AllegatiPratica,Long> {
	
	public AllegatiPratica findByPratica_UuidContenitoreAndUuidFile(String uuidContenitore,String uuidFile);

}



