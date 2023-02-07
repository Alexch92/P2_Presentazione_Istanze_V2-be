package it.sincon.gepred.service;
/**
 * 
 * @author Eligio Cavallo
 * @author Antonio Santomauro
 * 
 */
import java.util.List;

import it.osapulie.service.ServiceLayerException;
import it.sincon.gepred.domain.pratica.CategoriePratiche;
import it.sincon.gepred.domain.pratica.Tab;
import it.sincon.gepred.domain.pratica.TipoPratica;
import it.sincon.gepred.web.portlet.varie.DatiRicercaTipoPratica;

public interface GestioneTipoPraticheService {
	
	/**
	 * Metodo che recupera l'elenco delle pratiche relative ai parametri di ricerca inseriti
	 * @param descrizione
	 * @param allegati
	 * @param modelli
	 * @return List<TipoPratica>
	 */
	List<TipoPratica> searchTipoPratiche(DatiRicercaTipoPratica filtriRicerca);
	
	/**
	 * Salva un tipo di pratica nel sistema.
	 * 
	 * @param tipoPratica
	 * @throws ServiceLayerException
	 */
	public TipoPratica saveTipoPratica(TipoPratica tipoPratica) throws ServiceLayerException;
	
	/**
	 * Ritorna il tipo di pratica a partire dal suo ID.
	 * 
	 * @param pk
	 * @return TipoPratica
	 * @throws ServiceLayerException
	 */
	public TipoPratica getTipoPraticaByPk(long pk) throws ServiceLayerException;
	
	/**
	 * Cancella il tipo di pratica a partire dal suo ID.
	 * 
	 * @param pk
	 * @throws ServiceLayerException
	 */
	public void deleteTipoPratica(long pk) throws ServiceLayerException;
	
	//public List<TipoPratica> getTipoPraticaByRole(List<TipoPratica> lista) throws SystemException;
	
	/**
	 * Utility method che carica i prefissi delle tipologie di pratica dal DB
	 * 
	 * @return la lista dei prefissi
	 */
	public List<String> listaPrefissi();

	
	/**
	 * Restituisce i tab non ancora selezionati all'interno della tipologia
	 * 
	 * @param tipoPratica
	 * @return List<Tab>
	 */
	public List<Tab> getRemainingTab(TipoPratica tipoPratica);
	
	/**
	 * Restituisce le tipologia di pratica relative al frontend
	 * @return tipoPratica
	 */
	public List<TipoPratica> getTipoPraticaByFrontend();
	
	/**
	 * Restituisce le tipologia di pratica relative al frontend
	 * @return tipoPratica
	 */
	public List<TipoPratica> getTipoPraticaByCategoriaAndFrontend(CategoriePratiche categoria);
}
