package it.sincon.gepred.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import it.osapulie.domain.Ruolo;
import it.osapulie.service.ServiceLayerException;
import it.sincon.gepred.domain.pratica.CategoriePratiche;
import it.sincon.gepred.web.portlet.varie.DatiRicercaCategoria;

/**
 * Service per {@link CategoriePratiche}
 * 
 * @author Angelo Pascadopoli
 *
 */
public interface GestioneCategoriePraticheService {

	/**
	 * Salva una categoria nel DB
	 * 
	 * @param categoria
	 * @throws ServiceLayerException
	 */
	public void saveCategory(CategoriePratiche categoria) throws ServiceLayerException;
	
	/**
	 * Restituisce la lista di tutte le categorie nel DB
	 * 
	 * @param pk
	 */
	public List<CategoriePratiche> findAll();
	
	/**
	 * Cerca una singola categoria nel DB
	 * 
	 * @param pk
	 * @return la categoria richiesta
	 */
	public CategoriePratiche findByPk(Long pk);
	
	/**
	 * Metodo che torna le categorie ROOT
	 * 
	 * @return la lista delle categorie root
	 */
	public List<CategoriePratiche> searchRootCategories();
	
	/**
	 * Ricerca una o più categorie sulla base di un filtro
	 * definito dall'utente
	 * 
	 * @param filtroCategoria
	 * @return lista delle categorie selezionate
	 */
	public List<CategoriePratiche> searchCategoria(DatiRicercaCategoria filtroCategoria);
	
	/**
	 * Cancella la categoria data
	 * 
	 * @param id
	 */
	public void deleteCategory(Long id);
	
	/**
	 * Metodo che genera la stringa Json necessaria per
	 * la visualizzazione dell'albero delle categorie
	 * 
	 * @param lista
	 * @param flag
	 * @return una stringa Json
	 * @throws IOException
	 */
	public String listToJson(List<CategoriePratiche> lista, boolean flag) throws IOException;
	
	/**
	 * Torna le categorie di pratiche per le quali il 
	 * ruolo richiesto è abilitato
	 * 
	 * @param id
	 * @return la lista delle categorie abilitate
	 */
	public List<CategoriePratiche> getCategorieRuolo(long id);
	
	/**
	 * Torna le categorie di pratiche per le quali i ruoli richiesti sono abilitati
	 * @param ruoli
	 * @return la lista delle categorie abilitate
	 */
	public List<CategoriePratiche> getCategorieRuoli(List<Ruolo> ruoli);
	
	/**
	 * Ritorna l'elenco di categorie a cui l'utente è abilitato
	 * selezionandole mediante il ruolo di Liferay
	 * 
	 * @param categorie
	 * @return la lista delle categorie abilitate
	 */
	public List<CategoriePratiche> getTreeFromCategory(List<CategoriePratiche> categorie);
	
	/**
	 * Ritorna la root category della categoria data
	 * 
	 * @param categoria
	 * @return la root della categoria data
	 */
	public CategoriePratiche getRoot(CategoriePratiche categoria);
}
