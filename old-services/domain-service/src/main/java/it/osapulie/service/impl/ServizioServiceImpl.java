package it.osapulie.service.impl;

import it.osapulie.domain.servizi.Servizio;
import it.osapulie.persistence.ServizioRepository;
import it.osapulie.service.ServiceLayerException;
import it.osapulie.service.ServizioService;

import java.util.List;

import javax.inject.Inject;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("servizioService")
@Transactional
public class ServizioServiceImpl implements ServizioService {

	@Inject
	private ServizioRepository servizioRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.osapulie.service.ServizioService#getServizioById(long)
	 */
	@Override
	public Servizio getServizioById(long id) throws ServiceLayerException {
		return servizioRepository.findOne(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.osapulie.service.ServizioService#getAllServizio()
	 */
	@Override
	public List<Servizio> getAllServizio() throws ServiceLayerException {

		Sort sort = new Sort(new Sort.Order(Sort.Direction.ASC, "nomeServizio"));

		List<Servizio> servizioList = servizioRepository.findAll(sort);

		return servizioList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.osapulie.service.ServizioService#getServizioByCodiceServizio(java.lang.String)
	 */
	@Override
	public Servizio getServizioByCodiceServizio(String codiceServizio) throws ServiceLayerException {
		return servizioRepository.findByCodiceServizio(codiceServizio);
	}

}
