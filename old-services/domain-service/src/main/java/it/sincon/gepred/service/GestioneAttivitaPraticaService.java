package it.sincon.gepred.service;

import it.osapulie.domain.ProfiloUtente;
import it.sincon.gepred.domain.AttivitaPratica;
import it.sincon.gepred.domain.Referente;
import it.sincon.gepred.web.portlet.varie.DatiRicercaAttivitaPratica;

import java.util.List;

/**
 * Service per la portlet Visualizzazione attività
 * 
 * @author Angelo Pascadopoli
 *
 */
public interface GestioneAttivitaPraticaService {
	/**
	 * Cerca le attività di tutti gli utenti filtrandole in
	 * base alla data di completamento
	 * 
	 * @author Angelo Pascadopoli
	 */
	public List<AttivitaPratica> searchAttivitaCompletate(DatiRicercaAttivitaPratica filtriAttivitaPratica);
	
	public List<AttivitaPratica> searchByProfiloUtenteAndDataCompletamentoIsNull(ProfiloUtente profiloUtente);
	public List<AttivitaPratica> searchByEnte(Referente ente);
}
