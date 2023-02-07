package it.osapulie.service.impl;

import java.util.ArrayList;
import java.util.List;

import it.osapulie.domain.Ruolo;
import it.osapulie.persistence.RuoloRepository;
import it.osapulie.service.RuoloService;
import it.osapulie.service.ServiceLayerException;
import it.sincon.gepred.domain.pratica.CategoriePratiche;
import it.sincon.gepred.service.impl.GestioneCategoriePraticheServiceImpl;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.mvel2.optimizers.impl.refl.nodes.ArrayLength;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("ruoloService")
@Transactional
public class RuoloServiceImpl implements RuoloService {

	private static Logger log = LoggerFactory.getLogger(GestioneCategoriePraticheServiceImpl.class);
	
	@PersistenceContext(unitName="gepred")
	private EntityManager entityManager;

	@Inject
	private RuoloRepository repositoryRuolo;

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.osapulie.service.RuoloService#savRuolo(it.osapulie.domain.Ruolo)
	 */
	@Override
	public void saveRuolo(Ruolo ruolo) {
		repositoryRuolo.save(ruolo);

	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see it.osapulie.service.RuoloService#getRuoloById(long)
	 */
	@Override
	public Ruolo getRuoloById(long pk) throws ServiceLayerException {
		return repositoryRuolo.findOne(pk);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see it.osapulie.service.RuoloService#getAllRuolo()
	 */
	@Override
	public List<Ruolo> getAllRuolo() throws ServiceLayerException {
		return (List<Ruolo>) repositoryRuolo.findAll();
	}

	public List<Ruolo> getRuoloNome(String[] ruoli) {
		List<Ruolo> result = new ArrayList<Ruolo>();
		
		for (int i = 0; i < ruoli.length; i++) {
			result.add(repositoryRuolo.findByNome(ruoli[i]));
		}
		
		return result;
	}
}
