package it.sincon.gepred.service.impl;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import it.sincon.gepred.domain.pratica.NumeroPratica;
import it.sincon.gepred.persistence.NumeroPraticaRepository;
import it.sincon.gepred.service.NumeroPraticaService;

@Service("numeroPraticaService")
public class NumeroPraticaServiceImpl implements NumeroPraticaService {
	
	private static Logger log = LoggerFactory.getLogger(NumeroPraticaServiceImpl.class);

	@Inject
	private NumeroPraticaRepository numeroPraticaRepository;


	@Override
	public NumeroPratica getNext(String prefisso, Integer anno) {
		Long progressivo = numeroPraticaRepository.findByMaxProgressivoByPrefissoAndAnno(prefisso, anno);
		if (progressivo!=null)
			progressivo+=1;
		else
			progressivo=1L;
		
		NumeroPratica result = new NumeroPratica();
		result.setPrefisso(prefisso);
		result.setAnno(anno);
		result.setProgressivo(progressivo);
		
		return result;
	}

	@Override
	public NumeroPratica save(NumeroPratica entity) {
		
		return numeroPraticaRepository.save(entity);
	}

}
