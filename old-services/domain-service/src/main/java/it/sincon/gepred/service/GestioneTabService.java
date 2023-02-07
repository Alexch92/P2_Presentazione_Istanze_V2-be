package it.sincon.gepred.service;

import it.osapulie.service.ServiceLayerException;
import it.sincon.gepred.domain.pratica.Tab;

import java.util.List;

/**
 * Service per {@link Tab}
 * 
 * @author Giuseppe Cellamare
 *
 */
public interface GestioneTabService {
	
	/**
	 * Salva un tab sul Db
	 * 
	 * @param tab
	 * @return
	 * @throws ServiceLayerException
	 */
	public Tab saveTab(Tab tab) throws ServiceLayerException;
	
	/**
	 * Recupera tutti i tab presenti sul DB
	 * 
	 * @return
	 */
	public List<Tab> searchAllTab();
	
	/**
	 * Recupera un singolo tab sul Db
	 * 
	 * @param id
	 * @return
	 */
	public Tab findByPk(Long id);
	
	/**
	 * Cancella un tab dal Db
	 * @param id
	 */
	public void deleteTab(Long id);
	
	/**
	 * Restituisce il Master tab relativo ai dati della pratica
	 * 
	 * @return
	 */
	public List<Tab> getMasterTab();

}
