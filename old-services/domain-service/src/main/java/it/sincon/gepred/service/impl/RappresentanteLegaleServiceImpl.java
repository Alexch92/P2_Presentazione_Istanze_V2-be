package it.sincon.gepred.service.impl;

import org.springframework.stereotype.Service;

import it.osapulie.infrastructure.impl.DateUtils;
import it.sincon.gepred.domain.pratica.Azienda;
import it.sincon.gepred.domain.pratica.AziendaRappresentanti;
import it.sincon.gepred.domain.pratica.Preventivo;
import it.sincon.gepred.domain.pratica.RappresentanteLegale;
import it.sincon.gepred.persistence.AziendaRappresentantiRepository;
import it.sincon.gepred.persistence.AziendaRepository;
import it.sincon.gepred.persistence.CategoriePraticheRepository;
import it.sincon.gepred.persistence.RappresentanteLegaleRepository;
import it.sincon.gepred.service.RappresentanteLegaleService;
import it.sincon.gepred.web.portlet.varie.DatiConsuntivoPratica;
import it.sincon.gepred.web.portlet.varie.DatiSelezioneAzienda;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Implementazione del Service per {@link Preventivo}
 * 
 * @author Antonio Santomauro
 *
 */
@Service("rappresentanteLegaleService")
public class RappresentanteLegaleServiceImpl implements RappresentanteLegaleService {
	
	private static Logger log = LoggerFactory.getLogger(RappresentanteLegaleServiceImpl.class);
	
	@PersistenceContext(unitName="gepred")
	private EntityManager em;
	
	@Inject
	private AziendaRepository repositoryAziende;
	@Inject
	private RappresentanteLegaleRepository repositoryRappresentanteLegale;
	@Inject
	private AziendaRappresentantiRepository repositoryAziendaRappresentanti;

	@SuppressWarnings("unchecked")
	@Override
	public List<Azienda> findAziende(String codFiscale) {
		String queryString = "select DISTINCT az from Azienda az "
				+ "LEFT OUTER JOIN az.rappresentanti ar "
				+ "LEFT OUTER JOIN ar.rappresentante rappr "
				+ "where lower(rappr.codiceFiscale) = lower(?1) ";
		
		Query query = em.createQuery(queryString, Azienda.class);
		query.setParameter(1, codFiscale);
		
		return query.getResultList();
	}

	@Override
	public String[] findCfsConPotereFirma(String partitaIva, String nominativo) {
		List<String> listaCF = new ArrayList<String>();
		
		String queryString = "select DISTINCT rappr from RappresentanteLegale rappr "
				+ "LEFT OUTER JOIN rappr.aziende ar "
				+ "LEFT OUTER JOIN ar.azienda az "
				+ "where lower(az.partitaIva) = lower(?1) and lower(rappr.nominativo) = lower(?2)";
		
		Query query = em.createQuery(queryString, RappresentanteLegale.class);
		query.setParameter(1, partitaIva);
		query.setParameter(2, nominativo);
		
		List<RappresentanteLegale> queryResult = query.getResultList();
		if (queryResult != null) {
			for (RappresentanteLegale rl : queryResult) {
				listaCF.add(rl.getCodiceFiscale());
			}
		}
		
		return (String[])listaCF.toArray(new String[0]);
	}
	
	@Override
	public List<AziendaRappresentanti> findRappresentantiByPIvaAzienda(String partitaIva) {
		String queryString = "select DISTINCT ar from AziendaRappresentanti ar "
				+ "INNER JOIN ar.azienda az "
				+ "where lower(az.partitaIva) = lower(?1) ";
		
		Query query = em.createQuery(queryString, AziendaRappresentanti.class);
		query.setParameter(1, partitaIva);
		
		List<AziendaRappresentanti> queryResult = query.getResultList();
		
		return queryResult;
	}

	@Override
	public AziendaRappresentanti findByCfAndPIva(String codFiscale, String partitaIva) {
		String queryString = "select DISTINCT ar from AziendaRappresentanti ar "
				+ "INNER JOIN ar.azienda az "
				+ "INNER JOIN ar.rappresentante rappr "
				+ "where lower(az.partitaIva) = lower(?1) "
				+ " and  lower(rappr.codiceFiscale) = lower(?2)";
		
		Query query = em.createQuery(queryString, AziendaRappresentanti.class);
		query.setParameter(1, partitaIva);
		query.setParameter(2, codFiscale);
		
		return (AziendaRappresentanti) query.getSingleResult();
	}
	
	public List<Azienda> findAllAziende(){
		return repositoryAziende.findAll();
	}

	@Override
	public Azienda findAziendaById(long idAzienda) {
		return repositoryAziende.findOne(idAzienda);
	}
	
	
	@Override
	public List<Azienda> searchAziende(DatiSelezioneAzienda filtriRicercaAziende) {
		String queryString = "select DISTINCT az from Azienda az where 1=1 ";
		if (filtriRicercaAziende != null)
		{
			if (filtriRicercaAziende.getFiltroDenominazione() != null)
			{
				if (!filtriRicercaAziende.getFiltroDenominazione().isEmpty())
				{
					queryString += "and lower(az.denominazione) = lower(?1) ";
				}
			}
			if (filtriRicercaAziende.getFiltroPartitaIva() != null)
			{
				if (!filtriRicercaAziende.getFiltroPartitaIva().isEmpty())
				{
					queryString += "and lower(az.partitaIva) = lower(?2) ";
				}
			}
		}
		
		Query query = em.createQuery(queryString, Azienda.class);
		
		if (filtriRicercaAziende != null)
		{
			if (filtriRicercaAziende.getFiltroDenominazione() != null)
			{
				if (!filtriRicercaAziende.getFiltroDenominazione().isEmpty())
				{
					query.setParameter(1, filtriRicercaAziende.getFiltroDenominazione());
				}
			}
			if (filtriRicercaAziende.getFiltroPartitaIva() != null)
			{
				if (!filtriRicercaAziende.getFiltroPartitaIva().isEmpty())
				{
					query.setParameter(2, filtriRicercaAziende.getFiltroPartitaIva());
				}
			}
		}
		
		return query.getResultList();
	}

	@Override
	public RappresentanteLegale findRappresentanteByIdAR(long idAziendaRappresentante) {
		String queryString = "select DISTINCT ar from AziendaRappresentanti ar "
				+ "INNER JOIN ar.rappresentante rappr "
				+ "where ar.id = ?1 ";
		
		Query query = em.createQuery(queryString, AziendaRappresentanti.class);
		query.setParameter(1, idAziendaRappresentante);
		
		AziendaRappresentanti ar = (AziendaRappresentanti) query.getSingleResult();
		if (ar != null)
			return ar.getRappresentante();
		else
			return null;
	}

	@Override
	public AziendaRappresentanti findAziendaRappresentantiById(long idAziendaRappresentante) {
		String queryString = "select DISTINCT ar from AziendaRappresentanti ar where ar.id = ?1 ";
		Query query = em.createQuery(queryString, AziendaRappresentanti.class);
		query.setParameter(1, idAziendaRappresentante);
		
		return (AziendaRappresentanti) query.getSingleResult();
	}

	@Override
	public AziendaRappresentanti saveAziendaRappresentanti(AziendaRappresentanti entity) {
		repositoryRappresentanteLegale.save(entity.getRappresentante());
		return repositoryAziendaRappresentanti.save(entity);
	}

	@Override
	public void deleteAziendaRappresentanti(AziendaRappresentanti ar) {
		repositoryAziendaRappresentanti.delete(ar);
	}

	@Override
	public RappresentanteLegale saveRappresentanteLegale(RappresentanteLegale entity) {
		return repositoryRappresentanteLegale.save(entity);
	}

	@Override
	public Azienda findAziendaByPartitaIva(String partitaIva) {
		return repositoryAziende.findByPartitaIva(partitaIva);
	}
}
