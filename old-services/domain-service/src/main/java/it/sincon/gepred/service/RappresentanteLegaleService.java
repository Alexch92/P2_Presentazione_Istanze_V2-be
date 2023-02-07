package it.sincon.gepred.service;

import it.sincon.gepred.domain.pratica.Azienda;
import it.sincon.gepred.domain.pratica.AziendaRappresentanti;
import it.sincon.gepred.domain.pratica.RappresentanteLegale;
import it.sincon.gepred.web.portlet.varie.DatiSelezioneAzienda;

import java.util.List;

/**
 * Service per {@link RappresentanteLegale}
 * 
 * @author Antonio Santomauro
 *
 */
public interface RappresentanteLegaleService {
	
	/**
	 * recupera la lista di Aziende in cui questo CF risulta come rappresentante legale	
	 * @param codFiscale
	 * @return
	 */
	public List<Azienda> findAziende(String codFiscale);
	
	/**
	 * Recupera il codice Fiscale del rappresentante con potere di firma per questa azienda
	 * @param partitaIva
	 * @param nominativo
	 * @return
	 */
	public String[] findCfsConPotereFirma(String partitaIva, String nominativo);

	public List<AziendaRappresentanti> findRappresentantiByPIvaAzienda(String partitaIva);
	
	public AziendaRappresentanti findByCfAndPIva(String codFiscale, String partitaIva);
	public AziendaRappresentanti findAziendaRappresentantiById(long idAziendaRappresentante);
	public AziendaRappresentanti saveAziendaRappresentanti(AziendaRappresentanti entity);
	public void deleteAziendaRappresentanti(AziendaRappresentanti ar);
	
	public List<Azienda> findAllAziende();
	public Azienda findAziendaById(long idAzienda);
	public Azienda findAziendaByPartitaIva(String partitaIva);
	public List<Azienda> searchAziende(DatiSelezioneAzienda filtriRicercaAziende);
	
	public RappresentanteLegale findRappresentanteByIdAR(long idAziendaRappresentante);
	public RappresentanteLegale saveRappresentanteLegale(RappresentanteLegale entity);
}
