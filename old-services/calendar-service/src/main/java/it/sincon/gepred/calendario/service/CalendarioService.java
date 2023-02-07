package it.sincon.gepred.calendario.service;

import java.util.HashMap;
import java.util.List;

import it.sincon.gepred.calendario.beans.Appuntamento;

/**
 * Service per la gestione del calendario
 * 
 * @author Angelo Pascadopoli
 *
 */
public interface CalendarioService {

	/**
	 * Metodo per generare gli eventi del calendario a partire dagli appuntamenti
	 * @param lista
	 * @return mappa contenente l'id di ogni evento in corrispondenza dell'id della relativa attivit&agrave;
	 */
	public HashMap<Long, Long> generaAppuntamentiDaLista(List<Appuntamento> lista);
	
	/**
	 * Metodo che salva il singolo appuntamento sul DB
	 * @param app
	 * @return un appuntamento ricavato dall'evento salvato
	 */
	public Appuntamento salvaAppuntamento(Appuntamento app);
	
}
