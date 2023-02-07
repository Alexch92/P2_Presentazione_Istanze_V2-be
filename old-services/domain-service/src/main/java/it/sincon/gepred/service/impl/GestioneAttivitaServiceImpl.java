/*******************************************************************************
 * Copyright (c) 2011, 2012 Link Management & Technology S.p.A. via R. Scotellaro, 55 - 73100 -
 * Lecce - http://www.linksmt.it All rights reserved.
 * 
 * Contributors: Links Management & Technology S.p.A. - initial API and implementation
 *******************************************************************************/
package it.sincon.gepred.service.impl;

import it.sincon.gepred.domain.Attivita;
import it.osapulie.service.ServiceLayerException;
import it.sincon.gepred.persistence.AttivitaRepository;
import it.sincon.gepred.service.GestioneAttivitaService;
import it.sincon.gepred.web.portlet.varie.DatiRicercaAttivita;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("gestioneAttivitaService")
@Transactional
public class GestioneAttivitaServiceImpl implements GestioneAttivitaService {
	
	private static Logger log = LoggerFactory.getLogger(GestioneAttivitaServiceImpl.class);

	@Inject
	private AttivitaRepository gestioneAttivitaRepository;
	
	@PersistenceContext
	private EntityManager entity;

	/**
	 * Metodo che ricerca le attività
	 */
	
	public List<Attivita> searchAttivita(DatiRicercaAttivita filtriRicerca){
		log.debug("get Attivita :: entering method");
		String query_String = "select pr from Attivita pr where 1=1 ";
		
		if (filtriRicerca.getFiltroDescrizione()!= null && !filtriRicerca.getFiltroDescrizione().equals("")) {
			query_String += " AND lower(pr.descrizione) LIKE lower(?1)";
		}
		Query query = entity.createQuery(query_String , Attivita.class);
		
		if (filtriRicerca.getFiltroDescrizione()!= null && !filtriRicerca.getFiltroDescrizione().equals("")) {
			query.setParameter(1, "%" + filtriRicerca.getFiltroDescrizione().toLowerCase() + "%");
		}
		return  (List<Attivita>)query.getResultList();
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see it.sincon.service.AttivitaService#saveAttivita(it.sincon.gepred.domain.Attivita)
	 */
	public void saveAttivita(Attivita attivita) throws ServiceLayerException {
		log.debug("save attivita :: entering method ");
		try {
			gestioneAttivitaRepository.save(attivita);
		}
		catch (Exception e) {
			throw new ServiceLayerException("There was an error when saving an object of type attivita :: " + e.getMessage(), e);
		}
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see it.sincon.service.ReferenteService#getReferenteByPk(long)
	 */
	public Attivita getAttivitaByPk(long pk) throws ServiceLayerException {
		log.debug("findOne Attivita :: entering method");
		return gestioneAttivitaRepository.findOne(pk);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see it.sincon.service.ReferenteService#deleteReferente(long)
	 */
	public void deleteAttivita(long pk) throws ServiceLayerException {
		log.debug("delete Attivita :: entering method");
		gestioneAttivitaRepository.delete(pk);
	}
	
}

