package it.sincon.gepred.persistence;

import java.util.List;

import it.osapulie.domain.Comune;
import it.sincon.gepred.domain.Referente;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Repository per l'entity referente.
 * <strong>Nota</strong> questo repository è implementato tramite Spring Data JPA.
 * 
 * @author Davide Ciannamea
 * @author Eligio Cavallo
 */

public interface ReferenteRepository extends PagingAndSortingRepository<Referente, Long> {
	List<Referente> findByComune(Comune comune);
	Referente findByCfAndCfIsNotNullAndCfNot(String cf,String cf1);
	Referente findByPivaAndPivaIsNotNullAndPivaNot(String iva,String piva);
	Referente findByNominativoAndNominativoIsNotNullAndNominativoNot(String nominativo,String nominativo1);
}
