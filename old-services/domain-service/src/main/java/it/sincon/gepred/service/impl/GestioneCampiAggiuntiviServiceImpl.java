package it.sincon.gepred.service.impl;

import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import it.osapulie.service.ServiceLayerException;
import it.sincon.gepred.domain.CampiAggiuntivi;
import it.sincon.gepred.domain.CampiAggiuntiviListaValori;
import it.sincon.gepred.persistence.CampiAggiuntiviRepository;
import it.sincon.gepred.service.GestioneCampiAggiuntiviService;
import it.sincon.gepred.web.portlet.varie.DatiRicercaCampiAggiuntivi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Implementazione di {@link GestioneCampiAggiuntiviService} 
 * 
 * @author Eligio Cavallo
 */
@Service("gestioneCampiAggiuntiviService")
public class GestioneCampiAggiuntiviServiceImpl implements GestioneCampiAggiuntiviService{

	private static Logger log = LoggerFactory.getLogger(GestioneCampiAggiuntiviServiceImpl.class);

	@PersistenceContext(unitName="gepred")
	private EntityManager em;
	
	@Inject
	private CampiAggiuntiviRepository campiaggiuntiviRepository;
	
	/**
	 * Metodo che ricerca i CampiAggiuntivi
	 */
	public List<CampiAggiuntivi> searchCampiAggiuntivi(
			DatiRicercaCampiAggiuntivi filtriRicerca) {
		log.debug("searchCampiAggiuntivi CampiAggiuntivi:: entering method");
		String queryString = "select ca from CampiAggiuntivi ca where 1=1 ";
		
		if (filtriRicerca.getFiltroLabel() != null && !filtriRicerca.getFiltroLabel().equals("")) {
			queryString += " AND lower(ca.label) LIKE lower(?1)";
		}
			
		if (filtriRicerca.getFiltroTipoPratica()!= null && !filtriRicerca.getFiltroTipoPratica().equals("")) {
			queryString +=" AND ca.tipoPratica.id =?2";
		}		
		Query query = em.createQuery(queryString, CampiAggiuntivi.class);
		
		if (filtriRicerca.getFiltroLabel() != null && !filtriRicerca.getFiltroLabel().equals("")) {
			query.setParameter(1, "%" + filtriRicerca.getFiltroLabel().toLowerCase() + "%");
		}
		if (filtriRicerca.getFiltroTipoPratica()!= null && !filtriRicerca.getFiltroTipoPratica().equals("")) {
			query.setParameter(2, filtriRicerca.getFiltroTipoPratica());
		}
	

		return (List<CampiAggiuntivi>)query.getResultList();
	}

	
	/**
	 * Metodo che rileva la lista dei CampiAggiuntivi
	 */
	public List<CampiAggiuntivi> getAll() {
		log.debug("getAll CampiAggiuntivi:: entering method");
		return (List<CampiAggiuntivi>) campiaggiuntiviRepository.findAll();
	}


	
	public void saveCampiAggiuntivi(CampiAggiuntivi campiaggiuntivi) throws ServiceLayerException {
		log.debug("save CampiAggiuntivi CampiAggiuntivi:: entering method ");
		try {
			if (campiaggiuntivi.getValori()!=null) {
				for(CampiAggiuntiviListaValori valore:campiaggiuntivi.getValori())
					valore.setCampiAggiuntivi(campiaggiuntivi);
			}
			campiaggiuntiviRepository.save(campiaggiuntivi);
		}
		catch (Exception e) {
			throw new ServiceLayerException("There was an error when saving an object of type CampiAggiuntivi :: " + e.getMessage(), e);
		}
	}

	public CampiAggiuntivi getCampiAggiuntiviByPk(long pk)
			throws ServiceLayerException {
		log.debug("getCampiAggiuntiviByPk CampiAggiuntivi :: entering method ");
		return campiaggiuntiviRepository.findOne(pk);
	}

	public void deleteCampiAggiuntivi(long pk) throws ServiceLayerException {
		log.debug("deleteCampiAggiuntivi CampiAggiuntivi :: entering method ");
		campiaggiuntiviRepository.delete(pk);
	}
}
