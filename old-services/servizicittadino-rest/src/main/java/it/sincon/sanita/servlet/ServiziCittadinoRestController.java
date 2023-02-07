package it.sincon.sanita.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;

import flexjson.JSONSerializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import it.sincon.sanita.services.beans.DisdettaResponseJAXB;
import it.sincon.sanita.services.beans.ListaEntiPagamentoTicketResponseJAXB;
import it.sincon.sanita.services.beans.PagamentoTicketEnteJAXB;
import it.sincon.sanita.services.service.ServiziCittadinoRestService;
import it.sincon.sanita.services.service.impl.ServiziCittadinoRestServiceImpl;

/**
 * Prestazioni di test fornite da Vito Porfido... ATTENZIONE SONO VERE PRESTAZIONI!!
 * 
 * | Id Ente	|  Cod Fiscale		| Cod Prenotazione	|	Tipo	|	STATO
 * +------------+-------------------+-------------------+-----------+-----------
 * |  LECCE1	|  PRFVSN54R26A662R	|	2016342900		|	SSN		|	DISDETTATA
 * |  LECCE1	|  PRFVSN54R26A662R	|	20151556386		|	SSN		|	DISDETTATA
 * |  LECCE1	|  PRFVSN54R26A662R	|	20151478163		|	SSN		|	DISDETTATA
 * +------------+-------------------+-------------------+-----------+-----------
 * |  LECCE1	|  PRFVSN54R26A662R	|					|	SSN		|	DA DISDIRE
 * |  LECCE1	|  PRFVSN54R26A662R	|					|	SSN		|	DA DISDIRE
 *
 * 
 * @author Santomauro
 *
 */
@Component
@Path("/services")
public class ServiziCittadinoRestController {
	
	@Inject
	private ServiziCittadinoRestService serviziCittadinoRestService;
	
	private final static String DISDETTA_EXCEPTION_ERROR_MSG = "Disdetta Appuntamento - Parametro errato o mancante. "
			+ "I parametri: language(String);idEnte(String);codiceFiscale(String);cup(String);tipologia(Integer) "
			+ "sono obbligatori!";
	private final static String PROMEMORIA_EXCEPTION_ERROR_MSG = "Download Promemoria - Parametro errato o mancante. "
			+ "I parametri: idEnte(String);codiceFiscale(String);cup(String);tipologia(Integer) "
			+ "sono obbligatori!";
	
	private static Logger log = LoggerFactory.getLogger( ServiziCittadinoRestController.class );
	
	private final ResourceBundle resourceBundle = ResourceBundle.getBundle("servlet");
	
	private final static String DISDETTA_URL = "/disdettaPrenotazione";
	private final static String PROMEMORIA_URL = "/promemoria";
	private final static String PAGAMENTOTICKET_URL = "/pagamentoTicket";
	
	/**
	 * Servizio REST per la Disdetta Prenotazione
	 * 
	 * Esempio:
	 * PRODUZIONE SU AS2
	 * http://www.sanita.puglia.it/servizicittadino-rest/services/disdettaPrenotazione?language=it_IT&idEnte=LECCE1&codiceFiscale=PRFVSN54R26A662R&cup=2016342900&tipologia=1
	 * http://www.sanita.puglia.it/servizicittadino-rest/services/disdettaPrenotazione?language=it_IT&idEnte=LECCE1&codiceFiscale=PRFVSN54R26A662R&cup=20151556386&tipologia=1
	 * http://www.sanita.puglia.it/servizicittadino-rest/services/disdettaPrenotazione?language=it_IT&idEnte=LECCE1&codiceFiscale=PRFVSN54R26A662R&cup=20151478163&tipologia=1
	 *
	 * Taranto
	 * http://www.sanita.puglia.it/servizicittadino-rest/services/disdettaPrenotazione?language=it_IT&idEnte=LECCE1&codiceFiscale=PRFVSN54R26A662R&cup=2015747707&tipologia=1
	 * 
	 * @param language
	 * @param idEnte
	 * @param codFiscale
	 * @param codPrenotazione
	 * @param tipoPrenotazione
	 * @return
	 */
	@Path(DISDETTA_URL)
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String disdettaAppuntamento(
			@QueryParam("language") String language,
			@QueryParam("idEnte") String idEnte,
			@QueryParam("codiceFiscale") String codFiscale,
			@QueryParam("cup") String codPrenotazione,
			@QueryParam("tipologia") Integer tipoPrenotazione,
			@Context HttpServletRequest request){
		
		DisdettaResponseJAXB response = null;
		try{
			if (language == null || idEnte == null || codFiscale == null || codPrenotazione == null || tipoPrenotazione == null)
				throw new NullPointerException();
			
			if (codFiscale!=null)
				codFiscale =  codFiscale.toUpperCase();
			
			log.info(String.format("disdettaAppuntamento - language:%s idEnte:%s codiceFiscale:%s cup:%s tipologia:%s", 
					language, idEnte, codFiscale, codPrenotazione, tipoPrenotazione));
			
			String url = request.getRequestURL().toString().replace(DISDETTA_URL, PROMEMORIA_URL);
			log.info(String.format("URL:%s", url));
			
			response = getServiziCittadinoRestService().disdiciPrenotazione(
					idEnte, 
					codFiscale, 
					codPrenotazione, 
					tipoPrenotazione, 
					new Locale(language),
					url);
		}
		catch (NullPointerException ex){
			log.error(ex.getMessage(), ex);
			response = new DisdettaResponseJAXB("Errore", DISDETTA_EXCEPTION_ERROR_MSG, null); 	
		}
		
		log.debug(String.format("Response JSON:%s", response.toString()));
		return response.toString();
	}
	
	/**
	 * 
	 * @param filename
	 * @return
	 * 
	 * Esempio:
	 * http://www.sanita.puglia.it/servizicittadino-rest/services/promemoria?&idEnte=160114&codiceFiscale=PRFVSN54R26A662R&cup=20143168019&tipologia=1
	 * 
	 * http://www.sanita.puglia.it/servizicittadino-rest/services/promemoria?&idEnte=160112&codiceFiscale=MGZMSC34R51F027S&cup=2016368547&tipologia=1
	 * 
	 * 
	 * String idEnte, 
			String codFiscale, 
			String codPrenotazione, 
			int tipoPrenotazione,
			
	 */
	@GET
	@Path(PROMEMORIA_URL)
	public Response downloadPdfFile(
			@QueryParam("idEnte") String idEnte,
			@QueryParam("codiceFiscale") String codFiscale,
			@QueryParam("cup") String codPrenotazione,
			@QueryParam("tipologia") Integer tipoPrenotazione,
			@Context HttpServletRequest request)
	{
		if (codFiscale!=null)
			codFiscale =  codFiscale.toUpperCase();
		
		log.info(String.format("downloadPdfFile - idEnte:%s codiceFiscale:%s cup:%s tipologia:%s", 
				idEnte, codFiscale, codPrenotazione, tipoPrenotazione));

		// Recupero il content del file pdf del promemoria...
		String url = request.getRequestURL().toString();
		log.info(String.format("Download Promemoria URL:%s", url));
		final byte[] content = getServiziCittadinoRestService().generaPromemoriaDisdetta(
				idEnte, 
				codFiscale, 
				codPrenotazione, 
				tipoPrenotazione,
				url);

		StreamingOutput fileStream =  new StreamingOutput() 
		{
			@Override
			public void write(java.io.OutputStream output) throws IOException, WebApplicationException 
			{
				try
				{
					output.write(content);
					output.flush();
				} 
				catch (Exception e) 
				{
					log.error(e.getMessage(), e);
				}
			}
		};

		String filename=String.format("%s_%s.pdf", codFiscale, codPrenotazione);
		return Response
				.ok(fileStream, MediaType.APPLICATION_OCTET_STREAM)
				.header("content-disposition","attachment; filename = " + filename)
				.build();
	}
	
	/**
	 * Servizio REST per avere la lista degli enti e relative URL di redirect per il servizio
	 * di Pagamento Ticket
	 * 
	 * Esempio:
	 * PRODUZIONE SU AS2
	 * http://www.sanita.puglia.it/servizicittadino-rest/services/pagamentoTicket/listaEnti?language=it_IT
	 * 
	 * @param language
	 * @return
	 */
	@Path(PAGAMENTOTICKET_URL + "/listaEnti")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String listaEntiPagamentoTicket(@QueryParam("language") String language){
		
		ListaEntiPagamentoTicketResponseJAXB listaEnti = null;
		try{
			if (language == null )
				throw new NullPointerException();
			
			log.info(String.format("listaEntiPagamentoTicket - language:%s", language));
			listaEnti = getServiziCittadinoRestService().getListaEntiPagamentoTicket(new Locale(language));
		}
		catch (NullPointerException ex){
			log.error(ex.getMessage(), ex);
			List<PagamentoTicketEnteJAXB> data = new ArrayList<PagamentoTicketEnteJAXB>();
			listaEnti = new ListaEntiPagamentoTicketResponseJAXB(0, 0, data); 	
		}
		
		StringBuilder sb = new StringBuilder();
		JSONSerializer serializer = new JSONSerializer();
		serializer.exclude("*.class").deepSerialize( listaEnti, sb );
		String response = sb.toString();
		
		log.debug(String.format("Response JSON:%s", response));
		
		return response;
	}
	
	private ServiziCittadinoRestService getServiziCittadinoRestService(){
		if (serviziCittadinoRestService==null){
			serviziCittadinoRestService = new ServiziCittadinoRestServiceImpl();
		}

		return serviziCittadinoRestService;
	}

}
