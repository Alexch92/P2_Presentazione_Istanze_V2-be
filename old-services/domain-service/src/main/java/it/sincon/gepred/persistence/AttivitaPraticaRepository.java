package it.sincon.gepred.persistence;

import it.osapulie.domain.ProfiloUtente;
import it.sincon.gepred.domain.AttivitaPratica;
import it.sincon.gepred.domain.pratica.Pratica;

import java.util.List;

import javax.persistence.OrderBy;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface AttivitaPraticaRepository extends PagingAndSortingRepository<AttivitaPratica, Long> {
	
	@OrderBy("dataScadenza ASC")
	public List<AttivitaPratica> findByProfiloutenteAndDataCompletamentoIsNullAndPratica(ProfiloUtente profiloUtente,Pratica pratica);
	
	@OrderBy("dataScadenza ASC")
	public List<AttivitaPratica> findAll();
	
	@OrderBy("dataScadenza ASC")
	public AttivitaPratica findByDescrizione(String descrizione);
	
}
