package it.osapulie.service.impl;

//import it.osapulie.domain.ComuneISA;
import it.osapulie.domain.Pin;
import it.osapulie.persistence.PinRepository;
import it.osapulie.service.PinService;
import it.osapulie.service.ServiceLayerException;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("pinService")
@Transactional
public class PinServiceImpl implements PinService {

	@PersistenceContext(unitName="gepred")
	private EntityManager em;

	@Inject
	private PinRepository pinRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.osapulie.service.DelegaService#getDelegaByPk(it.osapulie.domain.DelegaPK)
	 */
	@Override
	public Pin getPinByPk(long id) throws ServiceLayerException {
		return pinRepository.findOne(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.osapulie.service.DelegaService#saveDelega(it.osapulie.domain.Delega)
	 */
	@Override
	public void savePin(Pin pin) throws ServiceLayerException {
		try {
			pinRepository.save(pin);
		}
		catch (Exception e) {
			throw new ServiceLayerException("There was an error when saving an object of type Pin :: " + e.getMessage(), e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.osapulie.service.DelegaService#getAllDelega()
	 */
	@Override
	public List<Pin> getAllPin() throws ServiceLayerException {
		return (List<Pin>) pinRepository.findAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.osapulie.service.DelegaService#deleteDelega(long)
	 */
	@Override
	public void deletePin(long id) throws ServiceLayerException {
		pinRepository.delete(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.osapulie.service.DelegaService#getAllDelegaByComuneIsa(long)
	 */
//	@Override
//	public List<Pin> getAllPinByComuneIsa(ComuneISA comuneISA) throws ServiceLayerException {
//		return pinRepository.findByComuneIsa(comuneISA);
//	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.osapulie.service.DelegaService#updateDelega(it.osapulie.domain.Delega)
	 */
	@Override
	public Pin updatePin(Pin pin) throws ServiceLayerException {
		return pinRepository.save(pin);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.osapulie.service.DelegaService#searchDeleghe(it.osapulie.domain.ComuneISA,
	 * it.osapulie.domain.ProfiloUtenteCittadino, boolean)
	 */
	@Override
	public List<Pin> searchPin(Long idComuneISA, String cognome, String nome, String codiceFiscale, String stato) throws ServiceLayerException {

		String queryString = "SELECT p FROM Pin p WHERE 1=1";

		if (idComuneISA != null) {
			queryString += " AND p.comuneIsa.id = ?1";
		}
		if (cognome != null && !cognome.equals("")) {
			queryString += " AND p.profiloUtenteCittadino.cognome LIKE lower(?2)";
		}
		if (nome != null && !nome.equals("")) {
			queryString += " AND p.profiloUtenteCittadino.nome LIKE lower(?3)";
		}

		if (codiceFiscale != null && !codiceFiscale.equals("")) {
			queryString += " AND p.profiloUtenteCittadino.codiceFiscale LIKE lower(?4)";
		}
		if (stato != null && !stato.equals("")) {
			queryString += " AND p.stato = ?5";
		}

		Query query = em.createQuery(queryString, Pin.class);

		if (idComuneISA != null) {
			query.setParameter(1, idComuneISA);
		}
		if (cognome != null && !cognome.equals("")) {
			query.setParameter(2, "%" + cognome.toLowerCase() + "%");
		}
		if (nome != null && !nome.equals("")) {
			query.setParameter(3, "%" + nome.toLowerCase() + "%");
		}
		if (codiceFiscale != null && !codiceFiscale.equals("")) {
			query.setParameter(4, "%" + codiceFiscale.toLowerCase() + "%");
		}
		if (stato != null && !stato.equals("")) {
			query.setParameter(5, stato);
		}

		return query.getResultList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.osapulie.service.PinService#getLastPin()
	 */
	@Override
	public Pin getLastPin(long idUtente) throws ServiceLayerException {

		String queryString = "SELECT p FROM Pin p WHERE p.profiloUtenteCittadino.id = ?1  ORDER BY p.id desc";

		Query query = em.createQuery(queryString, Pin.class);
		query.setParameter(1, idUtente);
		query.setMaxResults(1);
		Pin result = null;

		List<Pin> resultList = query.getResultList();
		if (resultList != null && !resultList.isEmpty()) {
			result = resultList.get(0);
		}

		return result;
	}
}
