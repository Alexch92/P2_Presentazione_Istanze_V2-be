package it.sincon.gepred.protocollo.adoc.test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.MessageContext;

import it.sincon.gepred.protocollo.adoc.bean.Destinatario;
import it.sincon.gepred.protocollo.adoc.bean.Documento;
import it.sincon.gepred.protocollo.adoc.bean.Mittente;
import it.sincon.gepred.protocollo.adoc.bean.PersonaFisica;
import it.sincon.gepred.protocollo.adoc.bean.PersonaGiuridica;
import it.sincon.gepred.protocollo.adoc.impl.CompletamentoProtocolloProvvisorio;
import it.sincon.gepred.protocollo.adoc.impl.CompletamentoProtocolloProvvisorioResponse;
import it.sincon.gepred.protocollo.adoc.impl.GetProtocollo;
import it.sincon.gepred.protocollo.adoc.impl.GetProtocolloResponse;
import it.sincon.gepred.protocollo.adoc.impl.ProtocolloServer;
import it.sincon.gepred.protocollo.adoc.impl.ProtocolloServerImplService;
import it.sincon.gepred.protocollo.adoc.impl.RichiestaProtocollo;
import it.sincon.gepred.protocollo.adoc.impl.RichiestaProtocolloProvvisorio;
import it.sincon.gepred.protocollo.adoc.impl.RichiestaProtocolloProvvisorioResponse;
import it.sincon.gepred.protocollo.adoc.impl.RichiestaProtocolloResponse;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@SuppressWarnings("restriction")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProtocolloWebServiceTest {
	
	private ProtocolloServer port;
	

	@Before
	public void setUp() throws Exception {
		ProtocolloServerImplService service = new ProtocolloServerImplService();
		port = service.getProtocolloServerImplPort();
		
		Map<String, Object> req_ctx = ((BindingProvider) port).getRequestContext();
		req_ctx.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "http://sintar:8081/adoc/protocollo?wsdl");

		Map<String, List<String>> headers = new HashMap<String, List<String>>();
		headers.put("Username", Collections.singletonList("santomauroa"));
		headers.put("Password", Collections.singletonList("test"));
		req_ctx.put(MessageContext.HTTP_REQUEST_HEADERS, headers);
}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test1CreazioneProtocolloInIngressoPersonaFisicaCompleto() throws Exception{
		RichiestaProtocollo.ProtocolloRequest protocolloRequest = new RichiestaProtocollo.ProtocolloRequest();
		protocolloRequest.setAmministrazione("e_lmt");
		protocolloRequest.setAreaOrganizzativaOmogenea("app");
		protocolloRequest.setIdUtente(2841);
		protocolloRequest.setOggetto("Oggetto Protocollo Test persona fisica");

		Mittente mittente = new Mittente();
		PersonaFisica persona = new PersonaFisica();
		persona.setCodiceFiscale("CLLGPP79S29E882L");
		persona.setCognome("Cellamare");
		persona.setNome("Giuseppe");
		mittente.setPersonaFisica(persona);
		mittente.setComune("Lizzano");
		mittente.setIndirizzo("Via XXIV Maggio, 35");
		mittente.setNazione("Italia");
		protocolloRequest.setMittente(mittente);

		Documento documento = new Documento();

		InputStream is = this.getClass().getResourceAsStream("/documenti/1.jpg");
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		copyStream(is, os);
		documento.setContenuto(os.toByteArray());
		documento.setTitolo("Titolo DI PROVA");
		documento.setNomeFile("nome di prova.jpg");
		protocolloRequest.setDocumento(documento);

		RichiestaProtocolloResponse.Return response = port.richiestaProtocollo(protocolloRequest);
		assertNotNull(response.getNumeroProtocollo());
		assertNotNull(response.getDataProtocollo());
	}

	@Test
	public void test2CreazioneProtocolloInIngressoPersonaGiuridicaCompleto() throws Exception{
		RichiestaProtocollo.ProtocolloRequest protocolloRequest = new RichiestaProtocollo.ProtocolloRequest();
		protocolloRequest.setAmministrazione("e_lmt");
		protocolloRequest.setAreaOrganizzativaOmogenea("app");
		protocolloRequest.setIdUtente(2841);
		protocolloRequest.setOggetto("Oggetto Protocollo Test persona giuridica");

		Mittente mittente = new Mittente();
		PersonaGiuridica personaGiuridica=new PersonaGiuridica();
		personaGiuridica.setPartitaIVA("00787980739");
		personaGiuridica.setRagioneSociale("Sincon srl");
		mittente.setPersonaGiuridica(personaGiuridica);
		mittente.setComune("Taranto");
		mittente.setIndirizzo("Via Venezia Giulia, 70");
		protocolloRequest.setMittente(mittente);

		Documento documento = new Documento();

		InputStream is = this.getClass().getResourceAsStream("/documenti/1.jpg");
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		copyStream(is, os);
		documento.setContenuto(os.toByteArray());
		documento.setTitolo("Titolo DI PROVA");
		documento.setNomeFile("nome di prova.jpg");
		protocolloRequest.setDocumento(documento);

		RichiestaProtocolloResponse.Return response = port.richiestaProtocollo(protocolloRequest);
		assertNotNull(response.getNumeroProtocollo());
		assertNotNull(response.getDataProtocollo());
	}

	@Test
	public void test3CreazioneProtocolloProvvisorioInIngressoPersonaFisicaConCompletamento() throws Exception{
		RichiestaProtocolloProvvisorio.ProtocolloProvvisorioRequest protocolloRequest = new RichiestaProtocolloProvvisorio.ProtocolloProvvisorioRequest();
		protocolloRequest.setAmministrazione("e_lmt");
		protocolloRequest.setAreaOrganizzativaOmogenea("app");
		protocolloRequest.setIdUtente(2841);
		protocolloRequest.setOggetto("Oggetto Protocollo Test persona fisica per completamento");
		Destinatario destinatario = new Destinatario();
		destinatario.setAmministrazione("e_lmt");
		destinatario.setAreaOrganizzativaOmogenea("app");

		protocolloRequest.setMittente(new Mittente());
		Mittente mittente = new Mittente();
		PersonaFisica persona = new PersonaFisica();
		persona.setCodiceFiscale("CLLGPP79S29E882L");
		persona.setCognome("Cellamare");
		persona.setNome("Giuseppe");
		mittente.setPersonaFisica(persona);
		mittente.setComune("Lizzano");
		mittente.setIndirizzo("Via XXIV Maggio, 35");
		mittente.setNazione("Italia");
		protocolloRequest.setMittente(mittente);

		RichiestaProtocolloProvvisorioResponse.Return response = port.richiestaProtocolloProvvisorio(protocolloRequest);
		assertNotNull(response.getNumeroProtocollo());
		assertNotNull(response.getDataProtocollo());
		
		GetProtocollo.ProtocolloInformazioniRequest request = new GetProtocollo.ProtocolloInformazioniRequest();
		request.setAnno(Integer.toString(response.getDataProtocollo().getYear()));
		request.setNumeroProtocollo(response.getNumeroProtocollo());
		GetProtocolloResponse.Return responseVerifica = port.getProtocollo(request);
		assertNull(responseVerifica.getErrore());
		
		
		CompletamentoProtocolloProvvisorio.ProtocolloDaCompletareRequest protocolloDaCompletareRequest = new CompletamentoProtocolloProvvisorio.ProtocolloDaCompletareRequest();
		protocolloDaCompletareRequest.setAmministrazione("e_lmt");
		protocolloDaCompletareRequest.setAreaOrganizzativaOmogenea("app");
		protocolloDaCompletareRequest.setIdUtente(2841);
		protocolloDaCompletareRequest.setNumeroProtocollo(response.getNumeroProtocollo());
		protocolloDaCompletareRequest.setAnno(Integer.toString(response.getDataProtocollo().getYear()));

		Documento documento = new Documento();
		InputStream is = this.getClass().getResourceAsStream("/documenti/2.jpg");
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		copyStream(is, os);
		documento.setContenuto(os.toByteArray());
		documento.setTitolo("Titolo per documento per protocollo persona fisica da completare");
		documento.setNomeFile("Nome file da completare.jpg");
		protocolloDaCompletareRequest.setDocumento(documento);
		
		CompletamentoProtocolloProvvisorioResponse.Return protocolloDaCompletareResponse = port.completamentoProtocolloProvvisorio(protocolloDaCompletareRequest);
		assertNotNull(protocolloDaCompletareResponse.getDataProtocollo());
		
	}
	
	@Test
	public void test4CreazioneProtocolloProvvisorioInIngressoPersonaGiuridicaConCompletamento() throws Exception{
		RichiestaProtocolloProvvisorio.ProtocolloProvvisorioRequest protocolloRequest = new RichiestaProtocolloProvvisorio.ProtocolloProvvisorioRequest();
		protocolloRequest.setAmministrazione("e_lmt");
		protocolloRequest.setAreaOrganizzativaOmogenea("app");
		protocolloRequest.setIdUtente(2841);
		protocolloRequest.setOggetto("Oggetto Protocollo Test persona giuridica per completamento");
		Destinatario destinatario = new Destinatario();
		destinatario.setAmministrazione("e_lmt");
		destinatario.setAreaOrganizzativaOmogenea("app");

		protocolloRequest.setMittente(new Mittente());
		Mittente mittente = new Mittente();
		PersonaGiuridica personaGiuridica=new PersonaGiuridica();
		personaGiuridica.setPartitaIVA("00787980739");
		personaGiuridica.setRagioneSociale("Sincon srl");
		mittente.setPersonaGiuridica(personaGiuridica);
		mittente.setComune("Taranto");
		mittente.setIndirizzo("Via Venezia Giulia, 70");
		protocolloRequest.setMittente(mittente);

		RichiestaProtocolloProvvisorioResponse.Return response = port.richiestaProtocolloProvvisorio(protocolloRequest);
		assertNotNull(response.getNumeroProtocollo());
		assertNotNull(response.getDataProtocollo());
		
		GetProtocollo.ProtocolloInformazioniRequest request = new GetProtocollo.ProtocolloInformazioniRequest();
		request.setAnno(Integer.toString(response.getDataProtocollo().getYear()));
		request.setNumeroProtocollo(response.getNumeroProtocollo());
		GetProtocolloResponse.Return responseVerifica = port.getProtocollo(request);
		assertNull(responseVerifica.getErrore());
		
		
		CompletamentoProtocolloProvvisorio.ProtocolloDaCompletareRequest protocolloDaCompletareRequest = new CompletamentoProtocolloProvvisorio.ProtocolloDaCompletareRequest();
		protocolloDaCompletareRequest.setAmministrazione("e_lmt");
		protocolloDaCompletareRequest.setAreaOrganizzativaOmogenea("app");
		protocolloDaCompletareRequest.setIdUtente(2841);
		protocolloDaCompletareRequest.setNumeroProtocollo(response.getNumeroProtocollo());
		protocolloDaCompletareRequest.setAnno(Integer.toString(response.getDataProtocollo().getYear()));

		Documento documento = new Documento();
		InputStream is = this.getClass().getResourceAsStream("/documenti/2.jpg");
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		copyStream(is, os);
		documento.setContenuto(os.toByteArray());
		documento.setTitolo("Titolo per documento per protocollo persona giuridica da completare");
		documento.setNomeFile("Nome file da completare.jpg");
		protocolloDaCompletareRequest.setDocumento(documento);
		
		CompletamentoProtocolloProvvisorioResponse.Return protocolloDaCompletareResponse = port.completamentoProtocolloProvvisorio(protocolloDaCompletareRequest);
		assertNotNull(protocolloDaCompletareResponse.getDataProtocollo());
		
	}

	@Test
	public void test5ConsultazioneProtocolloCreatoDaAdoc()
	{
		GetProtocollo.ProtocolloInformazioniRequest request = new GetProtocollo.ProtocolloInformazioniRequest();
		request.setAnno("2014");
		request.setNumeroProtocollo(27L);
		GetProtocolloResponse.Return response = port.getProtocollo(request);
		assertNotNull(response.getDestinatari());
		assertNull(response.getErrore());
	}
	
	@Test
	public void test6ConsultazioneProtocolloCreatoDaWs()
	{
		GetProtocollo.ProtocolloInformazioniRequest request = new GetProtocollo.ProtocolloInformazioniRequest();
		request.setAnno("2014");
		request.setNumeroProtocollo(10L);
		GetProtocolloResponse.Return response = port.getProtocollo(request);
		assertNotNull(response.getDestinatari());
		assertNull(response.getErrore());
	}
	
	@Test
	public void test7ConsultazioneProtocolloInesistente()
	{
		GetProtocollo.ProtocolloInformazioniRequest request = new GetProtocollo.ProtocolloInformazioniRequest();
		request.setAnno("2014");
		request.setNumeroProtocollo(200L);
		GetProtocolloResponse.Return response = port.getProtocollo(request);
		assertNull(response.getOggetto());
		assertNotNull(response.getErrore());
	}
	
	

	private void copyStream(InputStream is,OutputStream os)throws IOException
	{
		while (is.read() != -1) {
	        os.write(is.read());
	    }
		is.close();
	}

}
