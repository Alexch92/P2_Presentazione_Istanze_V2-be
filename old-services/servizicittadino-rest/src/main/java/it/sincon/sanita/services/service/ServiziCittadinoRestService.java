package it.sincon.sanita.services.service;

import java.util.Locale;

import it.sincon.sanita.services.ServiziCittadinoRestServiceException;
import it.sincon.sanita.services.beans.DisdettaResponseJAXB;
import it.sincon.sanita.services.beans.ListaEntiPagamentoTicketResponseJAXB;

public interface ServiziCittadinoRestService {
	
	/**
	 * Servizio che esegue la Disdetta di una Prenotazione. 
	 * La disdetta verra' eseguita per tutti gli N appuntamenti associati alla prenotazione in oggetto.
	 *  
	 * @param idEnte
	 * @param codFiscale
	 * @param codPrenotazione
	 * @param tipoPrenotazione
	 * @param locale
	 * @return
	 * @throws ServiziCittadinoRestServiceException
	 */
	public DisdettaResponseJAXB disdiciPrenotazione(
			String idEnte, 
			String codFiscale, 
			String codPrenotazione, 
			int tipoPrenotazione, 
			Locale locale,
			String baseURL);
	
	/**
	 * Servizio che restituisce la lista delle url per la redirect al servizio di pagamento ticket
	 * @param locale
	 * @return
	 */
	public ListaEntiPagamentoTicketResponseJAXB getListaEntiPagamentoTicket(Locale locale);
	
	/**
	 * Servizio che recupra la prescrizione disdettata e ne genera il bytearray necessario
	 * per creare il file pdf Promemoria della disdetta. 
	 * @param idEnte
	 * @param codFiscale
	 * @param codPrenotazione
	 * @param tipoPrenotazione
	 * @param baseURL
	 * @return
	 */
	public byte[] generaPromemoriaDisdetta(
			String idEnte, 
			String codFiscale, 
			String codPrenotazione, 
			int tipoPrenotazione,
			String baseURL);
	
	
}
