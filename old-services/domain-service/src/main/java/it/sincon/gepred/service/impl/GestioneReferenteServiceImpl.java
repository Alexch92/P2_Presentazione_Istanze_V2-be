package it.sincon.gepred.service.impl;


import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import it.osapulie.service.ServiceLayerException;
import it.sincon.gepred.domain.Referente;
import it.sincon.gepred.persistence.ReferenteRepository;
import it.sincon.gepred.service.GestioneReferenteService;
import it.sincon.gepred.service.ReferenteDuplicatoException;
import it.sincon.gepred.web.portlet.varie.DatiRicercaReferente;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Implementazione di {@link GestioneReferenteService} 
 * 
 * @author Davide Ciannamea
 */
@Service("gestioneReferenteService")
public class GestioneReferenteServiceImpl implements GestioneReferenteService {
	
	private static Logger log = LoggerFactory.getLogger(GestioneReferenteServiceImpl.class);

	@PersistenceContext(unitName="gepred")
	private EntityManager entity;
	
	@Inject
	private ReferenteRepository referenteRepository;
	
	/**
	 * Metodo che ricerca i referenti
	 */
	
	public List<Referente> searchReferente(DatiRicercaReferente filtriRicerca){
		log.debug("get Referente :: entering method");
		String query_String = "select pr from Referente pr where 1=1 ";
		
		if (filtriRicerca.getFiltroNominativo()!= null && !filtriRicerca.getFiltroNominativo().equals("")) {
			query_String += " AND ((lower(pr.nominativo) LIKE lower(?1))or(lower(concat(concat(pr.nome,' '),pr.cognome)) LIKE lower(?1))or(lower(concat(concat(pr.cognome,' '),pr.nome)) LIKE lower(?1)))";
		}
		/*if (filtriRicerca.getFiltroNome()!= null && !filtriRicerca.getFiltroNome().equals("")) {
			query_String += " AND lower(pr.nome) LIKE lower(?2)";
		}
		if (filtriRicerca.getFiltroCognome()!= null && !filtriRicerca.getFiltroCognome().equals("")) {
			query_String += " AND lower(pr.cognome) LIKE lower(?3)";
		}*/
		if ((filtriRicerca.getFiltroComune() != null)) {
	      query_String = query_String + " AND pr.comune.id = ?2";
	    }
		
		if ((filtriRicerca.getFiltroTipologia() != null && !filtriRicerca.getFiltroTipologia().equals(""))) {
			query_String += "AND pr.tipologia = ?3";
		}
		
		query_String += "ORDER BY pr.nominativo, pr.cognome";
		Query query = entity.createQuery(query_String , Referente.class);
		
		if (filtriRicerca.getFiltroNominativo()!= null && !filtriRicerca.getFiltroNominativo().equals("")) {
			query.setParameter(1, "%" + filtriRicerca.getFiltroNominativo().toLowerCase() + "%");
		}
		/*if (filtriRicerca.getFiltroNome()!= null && !filtriRicerca.getFiltroNome().equals("")) {
			query.setParameter(2, "%" + filtriRicerca.getFiltroNome().toLowerCase() + "%");
		}
		if (filtriRicerca.getFiltroCognome()!= null && !filtriRicerca.getFiltroCognome().equals("")) {
			query.setParameter(3, "%" + filtriRicerca.getFiltroCognome().toLowerCase() + "%");
		}*/
		if (filtriRicerca.getFiltroComune()!= null && !filtriRicerca.getFiltroComune().equals("")) {
			query.setParameter(2, filtriRicerca.getFiltroComune().getId());
		}
		if ((filtriRicerca.getFiltroTipologia() != null && !filtriRicerca.getFiltroTipologia().equals(""))) {
			query.setParameter(3, filtriRicerca.getFiltroTipologia());
		}
		return  (List<Referente>)query.getResultList();
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see it.sincon.service.ReferenteService#saveReferente(it.sincon.gepred.domain.Referente)
	 */
	public Referente saveReferente(Referente referente) throws ServiceLayerException, ReferenteDuplicatoException {
		log.debug("save Referente :: entering method ");
		try {
			String errMessageParam = "";
			Referente refGiaPresente = null;
			if (referente.isNew() && referente.getTipologia()!="e"){
				if (referente.getCf() !=null && !referente.getCf().isEmpty()){
					refGiaPresente = referenteRepository.findByCfAndCfIsNotNullAndCfNot(referente.getCf(),"");
					errMessageParam = "Codice Fiscale : " + referente.getCf();
				}
				else if (referente.getPiva()!=null && !referente.getPiva().isEmpty()){
					refGiaPresente = referenteRepository.findByPivaAndPivaIsNotNullAndPivaNot(referente.getPiva(), "");
					errMessageParam =  "Partita IVA : " + referente.getPiva();
				}
			}

			if((refGiaPresente == null)){
				return referenteRepository.save(referente);
			}
			else
				throw new ReferenteDuplicatoException(
						String.format("Attenzione !! Referente con %s gia presente in Database.", errMessageParam));
	
		}
		catch (ReferenteDuplicatoException refEx) {
			throw new ReferenteDuplicatoException(refEx.getMessage());
		}
		catch (Exception e) {
			throw new ServiceLayerException("There was an error when saving an object of type Referente :: " + e.getMessage(), e);
		}
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see it.sincon.service.ReferenteService#getReferenteByPk(long)
	 */
	public Referente getReferenteByPk(long pk) throws ServiceLayerException {
		log.debug("findOne Referente :: entering method");
		return referenteRepository.findOne(pk);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see it.sincon.service.ReferenteService#deleteReferente(long)
	 */
	public void deleteReferente(long pk) throws ServiceLayerException {
		log.debug("delete Referente :: entering method");
		referenteRepository.delete(pk);
	}

	
	
}

