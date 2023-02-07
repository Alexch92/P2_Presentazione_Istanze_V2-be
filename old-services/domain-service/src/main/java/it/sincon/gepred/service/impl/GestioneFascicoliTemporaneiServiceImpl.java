package it.sincon.gepred.service.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import it.osapulie.service.ServiceLayerException;
import it.sincon.gepred.domain.pratica.FascicoloTemporaneo;
import it.sincon.gepred.persistence.AllegatiRepository;
import it.sincon.gepred.persistence.FascicoloTemporaneoRepository;
import it.sincon.gepred.service.GestioneFascicoliTemporaneiService;

@Service("gestioneFascicoliTemporaneiService")
public class GestioneFascicoliTemporaneiServiceImpl implements
		GestioneFascicoliTemporaneiService {
	
	@Inject
	private FascicoloTemporaneoRepository fascicoloRepository;
	
	@Inject
	private AllegatiRepository allegatiRepository;

	@Override
	public void deleteFascicolo(FascicoloTemporaneo fascicolo) {
		// TODO Auto-generated method stub
		fascicoloRepository.delete(fascicolo);
	}
	
	/**
	 * Ritorna la pratica a partire dal suo ID.
	 * 
	 * @param pk
	 * @return Pratica
	 * @throws ServiceLayerException
	 */
	public FascicoloTemporaneo getFascicoloByPk(long pk) throws ServiceLayerException{
		return fascicoloRepository.findOne(pk);
	}
	
	/**
	 * Salva una pratica nel sistema.
	 * 
	 * @param pratica
	 * @throws ServiceLayerException
	 */
	public FascicoloTemporaneo saveFascicolo(FascicoloTemporaneo fascicolo) throws ServiceLayerException{
		for(int i=0;i<fascicolo.getAllegati().size();i++)
		{
			fascicolo.getAllegati().get(i).setAllegati(allegatiRepository.save(fascicolo.getAllegati().get(i).getAllegati()));
			fascicolo.getAllegati().get(i).setFascicolo(fascicolo);
		}
		return fascicoloRepository.save(fascicolo);
	}

}
