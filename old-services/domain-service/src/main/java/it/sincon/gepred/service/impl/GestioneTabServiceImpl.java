package it.sincon.gepred.service.impl;

import org.springframework.stereotype.Service;

import it.osapulie.service.ServiceLayerException;

import it.sincon.gepred.domain.pratica.Tab;
import it.sincon.gepred.service.GestioneTabService;
import it.sincon.gepred.persistence.TabRepository;
import java.util.List;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Implementazione del Service per {@link Tab}
 * 
 * @author Giuseppe Cellamare
 *
 */
@Service("gestioneTabService")
public class GestioneTabServiceImpl implements GestioneTabService {
	
	private static Logger log = LoggerFactory
			.getLogger(GestioneTabServiceImpl.class);
	
	@Inject
	private TabRepository tabRepository;

	@Override
	public Tab saveTab(Tab tab) throws ServiceLayerException {
		log.debug("saveTab :: Entering method");
		Tab result = null;
		
		try {
			result=tabRepository.save(tab);
		} catch (Exception e) {
			throw new ServiceLayerException(
					"There was an error when saving an object of type Tab :: "
							+ e.getMessage(), e);
		}
		return result;

	}

	@Override
	public List<Tab> searchAllTab() {
		log.debug("searchAllTab :: Entering method");
		return tabRepository.findAll();
	}

	@Override
	public Tab findByPk(Long id) {
		log.debug("findByPk :: Entering method");
		
		return tabRepository.findOne(id);
	}

	@Override
	public void deleteTab(Long id) {
		log.debug("delete Tab :: entering method");

		tabRepository.delete(id);
	}
	
	@Override
	public List<Tab> getMasterTab() {
		log.debug("getMasterTab :: entering method");
		
		return tabRepository.findByMaster(true);
	}

}
