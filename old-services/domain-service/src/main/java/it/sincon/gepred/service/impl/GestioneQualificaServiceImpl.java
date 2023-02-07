/*******************************************************************************
 * Copyright (c) 2011, 2012 Link Management & Technology S.p.A. via R. Scotellaro, 55 - 73100 -
 * Lecce - http://www.linksmt.it All rights reserved.
 * 
 * Contributors: Links Management & Technology S.p.A. - initial API and implementation
 *******************************************************************************/
package it.sincon.gepred.service.impl;

import it.sincon.gepred.domain.pratica.Qualifica;
import it.osapulie.service.ServiceLayerException;
import it.sincon.gepred.persistence.QualificaRepository;
import it.sincon.gepred.service.GestioneQualificaService;
import it.sincon.gepred.web.portlet.varie.DatiRicercaQualifica;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("gestioneQualificaService")
@Transactional
public class GestioneQualificaServiceImpl implements GestioneQualificaService {
	
	private static Logger log = LoggerFactory.getLogger(GestioneQualificaServiceImpl.class);

	@Inject
	private QualificaRepository gestioneQualificaRepository;
	
	@PersistenceContext
	private EntityManager entity;

	/**
	 * Metodo che ricerca le attività
	 */
	
	public List<Qualifica> searchQualifica(DatiRicercaQualifica filtriRicerca){
		log.debug("get Qualifica :: entering method");
		String query_String = "select pr from Qualifica pr where 1=1 ";
		
		if (filtriRicerca.getFiltroDescrizione()!= null && !filtriRicerca.getFiltroDescrizione().equals("")) {
			query_String += " AND lower(pr.nome) LIKE lower(?1)";
		}
		Query query = entity.createQuery(query_String , Qualifica.class);
		
		if (filtriRicerca.getFiltroDescrizione()!= null && !filtriRicerca.getFiltroDescrizione().equals("")) {
			query.setParameter(1, "%" + filtriRicerca.getFiltroDescrizione().toLowerCase() + "%");
		}
		return  (List<Qualifica>)query.getResultList();
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see it.sincon.service.QualificaService#saveQualifica(it.sincon.gepred.domain.Qualifica)
	 */
	public void saveQualifica(Qualifica qualifica) throws ServiceLayerException {
		log.debug("save qualifica :: entering method ");
		try {
			gestioneQualificaRepository.save(qualifica);
		}
		catch (Exception e) {
			throw new ServiceLayerException("There was an error when saving an object of type qualifica :: " + e.getMessage(), e);
		}
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see it.sincon.service.ReferenteService#getReferenteByPk(long)
	 */
	public Qualifica getQualificaByPk(long pk) throws ServiceLayerException {
		log.debug("findOne Qualifica :: entering method");
		return gestioneQualificaRepository.findOne(pk);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see it.sincon.service.ReferenteService#deleteReferente(long)
	 */
	public void deleteQualifica(long pk) throws ServiceLayerException {
		log.debug("delete Qualifica :: entering method");
		gestioneQualificaRepository.delete(pk);
	}
	
}

