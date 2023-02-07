package it.sincon.gepred.service;

import it.osapulie.service.ServiceLayerException;
import it.sincon.gepred.domain.pratica.Preventivo;
import it.sincon.gepred.domain.pratica.TipoIntervento;

import java.util.List;

/**
 * Service per {@link Tab}
 * 
 * @author Giuseppe Cellamare
 *
 */
public interface PreventivoService {
	
	/**
	 * Recupera tutti i tipi intervento
	 * 
	 * @param classe
	 * @return
	 * @throws ServiceLayerException
	 */
	public List<TipoIntervento> findAll();
	
	public List<TipoIntervento> findTipiInterventoByClasse(int classe);	
	
	public Preventivo getNuovo(boolean isCondominio) throws ServiceLayerException;
	public Preventivo getNuovo(boolean isCondominio, TipoIntervento intPrimario, TipoIntervento intSecondario) throws ServiceLayerException;
		
	public Preventivo ricalcola(Preventivo preventivo, boolean isConsuntivo)throws ServiceLayerException;

	public Preventivo setInterventoPrincipale(Preventivo preventivo, long idIntervento, List<TipoIntervento> interventi);
	public Preventivo setInterventoSecondario(Preventivo preventivo, long idIntervento, List<TipoIntervento> interventi);
}
