package it.sincon.gepred.documentale.diogene.persistence;

import java.util.List;
import it.sincon.gepred.documentale.diogene.domain.SottoAggregati;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SottoAggregatiRepository extends PagingAndSortingRepository<SottoAggregati, Long>  {
	List<SottoAggregati> findByUuidContenitorePadre (String uuidPadre);
}
