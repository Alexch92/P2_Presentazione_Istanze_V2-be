package it.sincon.gepred.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.osapulie.domain.ProfiloUtente;
import it.sincon.gepred.domain.AttivitaPratica;
import it.sincon.gepred.domain.Referente;
import it.sincon.gepred.persistence.AttivitaPraticaRepository;
import it.sincon.gepred.service.GestioneAttivitaPraticaService;
import it.sincon.gepred.web.portlet.varie.DatiRicercaAttivitaPratica;

/**
 * Implementazione del service per la portlet di Visualizzazione attività
 * 
 * @author Angelo Pascadopoli
 *
 */
@Service("gestioneAttivitaPraticaService")
@Transactional
public class GestioneAttivitaPraticaServiceImpl implements GestioneAttivitaPraticaService {

	private static Logger log = LoggerFactory.getLogger(GestioneAttivitaPraticaServiceImpl.class);

	@Inject
	private AttivitaPraticaRepository attivitaPraticaRepository;
	
	@PersistenceContext
	private EntityManager em;
	
	public List<AttivitaPratica> searchAttivitaCompletate(DatiRicercaAttivitaPratica filtriAttivitaPratica) {
		log.debug("searchAttivitaCompletate :: Entering method");
		
		if (filtriAttivitaPratica!=null){
		log.debug(String.format("filtroAttivita=[utente=%s|descr=%s|completam=%s]",
				filtriAttivitaPratica.getFiltroUtente(),
				filtriAttivitaPratica.getFiltroDescrizione(),
				filtriAttivitaPratica.getFiltroCompletamento()));
		}else
			log.debug("filtroAttivita is NULL!!");
		
		String queryString = "select ap from AttivitaPratica ap where 1=1 ";
		
		if (filtriAttivitaPratica.getFiltroDescrizione() != null && !filtriAttivitaPratica.getFiltroDescrizione().equals(""))
			queryString += "and lower(ap.descrizione) like lower(?1) ";
						
		if (filtriAttivitaPratica.getFiltroCompletamento() != null && !filtriAttivitaPratica.getFiltroCompletamento().equals("Tutte")) {
			if (filtriAttivitaPratica.getFiltroCompletamento().equals("Completata"))
				queryString += "and ap.dataCompletamento is not null ";
			else
				queryString += "and ap.dataCompletamento is null ";
		}
		
		if (filtriAttivitaPratica.getFiltroUtente() != null)
			queryString += "and ap.profiloutente.id=?2 ";
		
		queryString += "ORDER BY ap.dataAssegnazione DESC";
		Query query = em.createQuery(queryString, AttivitaPratica.class);
		
		
		if (filtriAttivitaPratica.getFiltroDescrizione() != null && !filtriAttivitaPratica.getFiltroDescrizione().equals(""))
			query.setParameter(1, "%" + filtriAttivitaPratica.getFiltroDescrizione().toLowerCase() + "%");
		
		if (filtriAttivitaPratica.getFiltroUtente() != null)
			query.setParameter(2, filtriAttivitaPratica.getFiltroUtente());
		
		return (List<AttivitaPratica>) query.getResultList();
	}

	@Override
	public List<AttivitaPratica> searchByProfiloUtenteAndDataCompletamentoIsNull(
			ProfiloUtente profiloUtente) {
		log.debug("searchByProfiloUtenteAndDataCompletamentoIsNull :: Entering method");
		
//		String queryString = "SELECT ap FROM AttivitaPratica ap "
//				+ "WHERE ap.profiloutente = ?1 "
//				+ "ORDER BY ap.dataScadenza IS NULL, "
//				+ "ap.dataScadenza ASC, "
//				+ "ap.dataAssegnazione DESC ";
//		
//		Query query = em.createQuery(queryString, AttivitaPratica.class);
		
//		String queryString = "SELECT * FROM gepred.public.tb_attivitapratica "
//				+ "WHERE (fk_profiloutente = ?1) and (data_completamento is null)"
//				+ "ORDER BY isnull(data_scadenza), data_scadenza ASC, data_assegnazione desc";
//      Verificare 
		String queryString = "SELECT * FROM tb_attivitapratica "
				+ "WHERE (data_completamento is null)";
		if (profiloUtente!=null)
			queryString+="and (fk_profiloutente = ?1)";
		queryString+= " ORDER BY data_scadenza ASC, data_assegnazione desc";
		Query query = em.createNativeQuery(queryString, AttivitaPratica.class);
		if (profiloUtente!=null)
			query.setParameter(1, profiloUtente.getId());
		
		return (List<AttivitaPratica>) query.getResultList();
	}

	@Override
	public List<AttivitaPratica> searchByEnte(Referente ente) {
		String queryString = "SELECT ap FROM AttivitaPratica ap "
				+ "WHERE ap.ente = ?1 "
				+ "ORDER BY ap.dataAssegnazione DESC ";
		
		Query query = em.createQuery(queryString, AttivitaPratica.class);
				
		query.setParameter(1, ente);
		
		return (List<AttivitaPratica>) query.getResultList();
	}

}
