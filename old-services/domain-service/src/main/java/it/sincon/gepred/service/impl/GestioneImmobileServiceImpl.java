package it.sincon.gepred.service.impl;

/**
 * @author Eligio Cavallo - Sincon srl 
* */

import java.util.List;
import it.sincon.gepred.domain.Immobile;
import it.sincon.gepred.service.GestioneImmobileService;
import it.sincon.gepred.web.portlet.varie.DatiRicercaImmobile;
import it.sincon.gepred.persistence.ImmobileRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import it.osapulie.service.ServiceLayerException;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Service("gestioneImmobileService")
public class GestioneImmobileServiceImpl  implements GestioneImmobileService {

	@PersistenceContext
	private EntityManager entity;
	
	private static Logger log = LoggerFactory.getLogger(GestioneImmobileServiceImpl.class);

	@Inject
	private ImmobileRepository repository;
	
	/**
	 * Ritorna l'immobile a partire dai dati di ricerca.
	 * 
	 * @param filtriRicerca
	 * @return List<Immobile>
	 * @throws ServiceLayerException
	 */
	
	public List<Immobile> getImmobili(DatiRicercaImmobile filtriRicerca)throws ServiceLayerException {
		log.debug("get Immobili :: entering method");
		String query_String = "select tb from Immobile tb where 1=1";

		if (filtriRicerca.getFiltroDenominazione()!= null && !filtriRicerca.getFiltroDenominazione().equals("")) {
			query_String += " AND lower(tb.denominazione) LIKE lower(?1)";
		}
		if (filtriRicerca.getFiltroCap()!= null && !filtriRicerca.getFiltroCap().equals("")) {
			query_String += " AND lower(tb.cap) =?2 ";
		}
		if (filtriRicerca.getFiltroComune()!= null ) {
		query_String += " AND tb.comune.id =?3";
		}				
		if (filtriRicerca.getFiltroIndirizzo()!= null && !filtriRicerca.getFiltroIndirizzo().equals("")) {
			query_String += " AND lower(FUNC('REGEX_REPLACE', tb.indirizzo, '^[a-zA-Z0-9]', '')) LIKE concat('%',lower(FUNC('REGEX_REPLACE', ?4, '^[a-zA-Z0-9]', '')),'%')";
		}	
		if (filtriRicerca.getFiltroTipologia()!= null && !filtriRicerca.getFiltroTipologia().equals("")) {
			query_String += " AND tb.tipologia.id =?5";
		}		
		if (filtriRicerca.getFiltroFoglio()!= null && !filtriRicerca.getFiltroFoglio().equals("")) {
			query_String += " AND tb.foglio =?6 ";
		}
		if (filtriRicerca.getFiltroParticella()!= null && !filtriRicerca.getFiltroParticella().equals("")) {
			query_String += " AND tb.particella= ?7 ";
		}
		if (filtriRicerca.getFiltroSubalterno()!= null && !filtriRicerca.getFiltroSubalterno().equals("")){
			query_String += " AND tb.subalterno = ?8 ";
		}		
		
		
		Query query = entity.createQuery(query_String , Immobile.class);
		
		if (filtriRicerca.getFiltroDenominazione()!= null && !filtriRicerca.getFiltroDenominazione().equals("")) {
			query.setParameter(1, "%" + filtriRicerca.getFiltroDenominazione().toLowerCase() + "%");

		}
		if (filtriRicerca.getFiltroCap()!= null && !filtriRicerca.getFiltroCap().equals("")) {
			query.setParameter(2, "%" + filtriRicerca.getFiltroCap().toLowerCase() + "%");
		}
		if (filtriRicerca.getFiltroComune()!= null ) {
			query.setParameter(3,filtriRicerca.getFiltroComune().getId());
		}
		if (filtriRicerca.getFiltroIndirizzo()!= null && !filtriRicerca.getFiltroIndirizzo().equals("")) {
			query.setParameter(4, filtriRicerca.getFiltroIndirizzo().toLowerCase());
		}		
		if (filtriRicerca.getFiltroTipologia()!= null && !filtriRicerca.getFiltroTipologia().equals("")) {
			query.setParameter(5, filtriRicerca.getFiltroTipologia());
		}
		if (filtriRicerca.getFiltroFoglio()!= null && !filtriRicerca.getFiltroFoglio().equals("")) {
			query.setParameter(6,filtriRicerca.getFiltroFoglio());
		}
		if (filtriRicerca.getFiltroParticella()!= null && !filtriRicerca.getFiltroParticella().equals("")) {
			query.setParameter(7,filtriRicerca.getFiltroParticella());
				}
		if (filtriRicerca.getFiltroSubalterno()!= null && !filtriRicerca.getFiltroSubalterno().equals("")){
			query.setParameter(8,filtriRicerca.getFiltroSubalterno());
			
		}				
		return  (List<Immobile>)query.getResultList();
	}
	
	/**
	 * Aggiunge/modifica  l'immobile dal sistema
	 * 
	 * @param immobile
	 * @throws ServiceLayerException
	 */
	
	public void saveImmobile(Immobile immobile) throws ServiceLayerException {
		log.debug("save Immobile :: entering method ");
		try {
			repository.save(immobile);
		}
		catch (Exception e) {
			throw new ServiceLayerException("There was an error when saving an object of type Immobile :: " + e.getMessage(), e);
		}
	}
	
	/**
     * Elimina  l'immobile dal sistema.
	 * 
	 * @param pk
	 * @throws ServiceLayerException
	 */	
	
	public void deleteImmobile(long pk) throws ServiceLayerException {
	log.debug("delete Immobile :: entering method");
	 repository.delete(pk);
	}

	/**
	 * Ritorna l'immobile a partire dal suo id.
	 * 
	 * @param pk
	 * @return Immobile
	 * @throws ServiceLayerException
	 */
	
	public Immobile getImmobileByPk(long pk)throws ServiceLayerException {
		log.debug("finfOne Immobile ::entering method");
		return repository.findOne(pk);	
	}
}




