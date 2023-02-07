package it.sincon.gepred.service.impl;

/**
 * @author Eligio Cavallo - Sincon srl 
* */

import java.util.List;
import it.sincon.gepred.domain.Ente;
import it.sincon.gepred.domain.Immobile;
import it.sincon.gepred.service.GestioneEnteService;
import it.sincon.gepred.web.portlet.varie.DatiRicercaEnte;
import it.sincon.gepred.web.portlet.varie.DatiRicercaImmobile;
import it.sincon.gepred.persistence.EnteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import it.osapulie.service.ServiceLayerException;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Service("gestioneEnteService")
public  class GestioneEnteServiceImpl  implements GestioneEnteService{

	@PersistenceContext
	private EntityManager entity;
	
	private static Logger log = LoggerFactory.getLogger(GestioneEnteServiceImpl.class);

	@Inject
	private EnteRepository repository;
	
	/**
	 * Ritorna l'ente a partire dalla sua denominazione.
	 * 
	 * @param Denominazione
	 * @return Ente
	 * @throws ServiceLayerException
	 */
	
	public List<Ente> getEnteByDenominazione(DatiRicercaEnte filtriRicerca)throws ServiceLayerException {
		log.debug("get Ente :: entering method");
		String query_String = "select tb from Ente tb where 1=1";

		if (filtriRicerca.getFiltroDenominazione()!= null && !filtriRicerca.getFiltroDenominazione().equals("")) {
			query_String += " AND lower(tb.denominazione) LIKE lower(?1)";
		}
		if (filtriRicerca.getFiltroComune()!= null) {
		query_String += " AND tb.comune.id =?2";
		}				

		Query query = entity.createQuery(query_String , Ente.class);
		
		if (filtriRicerca.getFiltroDenominazione()!= null && !filtriRicerca.getFiltroDenominazione().equals("")) {
			query.setParameter(1, "%" + filtriRicerca.getFiltroDenominazione().toLowerCase() + "%");
		}
		if (filtriRicerca.getFiltroComune()!= null ) {
			query.setParameter(2,filtriRicerca.getFiltroComune().getId());
		}		
	
		return  (List<Ente>)query.getResultList();
	}

	/**
	 * Aggiunge/modifica  l'ente dal sistema
	 * 
	 * @param ente
	 * @return Ente
	 * @throws ServiceLayerException
	 */
	
	public void saveEnte(Ente ente) throws ServiceLayerException {
		log.debug("save Ente :: entering method ");
		try {
			repository.save(ente);
		}
		catch (Exception e) {
			throw new ServiceLayerException("There was an error when saving an object of type Ente :: " + e.getMessage(), e);
		}
	}
	
	/**
     * Elimina  l'ente dal sistema.
	 * 
	 * @param ente
	 * @throws ServiceLayerException
	 */	
	
	public void deleteEnte(long pk) throws ServiceLayerException {
	log.debug("delete Ente :: entering method");
	 repository.delete(pk);
	}

	/**
	 * Ritorna l'ente a partire dal suo id.
	 * 
	 * @param id
	 * @return Ente
	 * @throws ServiceLayerException
	 */
	
	public Ente getEnteByPk(long pk)throws ServiceLayerException {
		log.debug("finfOne Ente ::entering method");
		return repository.findOne(pk);	
	}
	
}