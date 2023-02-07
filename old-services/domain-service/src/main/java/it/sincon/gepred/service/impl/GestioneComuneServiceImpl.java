/*******************************************************************************
 * Copyright (c) 2011, 2012 Link Management & Technology S.p.A. via R. Scotellaro, 55 - 73100 -
 * Lecce - http://www.linksmt.it All rights reserved.
 * 
 * Contributors: Links Management & Technology S.p.A. - initial API and implementation
 *******************************************************************************/
package it.sincon.gepred.service.impl;

import it.osapulie.domain.Comune;
import it.osapulie.persistence.ComuneRepository;
import it.osapulie.service.ServiceLayerException;
import it.sincon.gepred.service.GestioneComuneService;
import it.sincon.gepred.web.portlet.varie.DatiRicercaComune;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("gestioneComuneService")
@Transactional
public class GestioneComuneServiceImpl implements GestioneComuneService {
	
	private static Logger log = LoggerFactory.getLogger(GestioneComuneServiceImpl.class);

	@Inject
	private ComuneRepository gestioneComuneRepository;
	
	@PersistenceContext
	private EntityManager entity;

	/**
	 * Metodo che ricerca i comuni
	 * + "LEFT OUTER JOIN az.rappresentanti ar "
	 */
	
	public List<Comune> searchComune(DatiRicercaComune filtriRicerca){
		log.debug("get Comune :: entering method");
		String query_String = "select com from Comune com inner join com.provincia pr where 1=1 ";
		
		if (filtriRicerca.getFiltroDenominazione()!= null && !filtriRicerca.getFiltroDenominazione().equals("")) {
			query_String += " AND lower(com.denominazione) LIKE lower(?1)";
		}
		if (filtriRicerca.getFiltroProvincia()!= null && !filtriRicerca.getFiltroProvincia().equals("")) {
			query_String += " AND lower(pr.denominazioneProvincia) LIKE lower(?2)";
		}
		if (filtriRicerca.getFiltroCodiceCatastale()!= null && !filtriRicerca.getFiltroCodiceCatastale().equals("")) {
			query_String += " AND lower(com.codiceCatastale) LIKE lower(?3)";
		}
		Query query = entity.createQuery(query_String , Comune.class);
		
		if (filtriRicerca.getFiltroDenominazione()!= null && !filtriRicerca.getFiltroDenominazione().equals("")) {
			query.setParameter(1, "%" + filtriRicerca.getFiltroDenominazione().toLowerCase() + "%");
		}
		if (filtriRicerca.getFiltroProvincia()!= null && !filtriRicerca.getFiltroProvincia().equals("")) {
			query.setParameter(2, "%" + filtriRicerca.getFiltroProvincia().toLowerCase() + "%");
		}
		if (filtriRicerca.getFiltroCodiceCatastale()!= null && !filtriRicerca.getFiltroCodiceCatastale().equals("")) {
			query.setParameter(3, "%" + filtriRicerca.getFiltroCodiceCatastale().toLowerCase() + "%");
		}
		return  (List<Comune>)query.getResultList();
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see it.sincon.service.ComuneService#saveComune(it.sincon.gepred.domain.Comune)
	 */
	public void saveComune(Comune comune) throws ServiceLayerException {
		log.debug("save Comune :: entering method ");
		try {
			gestioneComuneRepository.save(comune);
		}
		catch (Exception e) {
			throw new ServiceLayerException("There was an error when saving an object of type Comune :: " + e.getMessage(), e);
		}
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see it.sincon.service.ReferenteService#getReferenteByPk(long)
	 */
	public Comune getComuneByPk(long pk) throws ServiceLayerException {
		log.debug("findOne Comune :: entering method");
		return gestioneComuneRepository.findOne(pk);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see it.sincon.service.ReferenteService#deleteReferente(long)
	 */
	public void deleteComune(long pk) throws ServiceLayerException {
		log.debug("delete Comune :: entering method");
		gestioneComuneRepository.delete(pk);
	}
	
}

