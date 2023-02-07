package it.sincon.gepred.protocollo.folium.test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.sincon.gepred.protocollo.folium.bean.Allegato;
import it.sincon.gepred.protocollo.folium.bean.DocumentoProtocollato;
import it.sincon.gepred.protocollo.folium.bean.MittenteDestinatario;
import it.sincon.gepred.protocollo.folium.bean.Ricerca;
import it.sincon.gepred.protocollo.folium.bean.WSAuthentication;
import it.sincon.gepred.protocollo.folium.impl.ProtocolloWebService;
import it.sincon.gepred.protocollo.folium.impl.ProtocolloWebServiceService;
import it.sincon.gepred.protocollo.folium.impl.ProtocolloWebServiceServiceLocator;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProtocolloWebServiceTest {
	
	private ProtocolloWebService port;
	private WSAuthentication autenticazione;
	private List<Map<String, Object>> documentiProtocollati;
	
	@Before
	public void setUp() throws Exception {
		ProtocolloWebServiceService service = new ProtocolloWebServiceServiceLocator();
		port = service.getProtocolloWebService();
		autenticazione = new WSAuthentication("AOO_MANDURIA", "gepred", "C_E882", "password1", "gepred");
		if (documentiProtocollati==null)
			documentiProtocollati = new ArrayList<Map<String,Object>>();
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void test1ProtocollazioneProvvisoriaSeguitoDaCompletamento() {
		try
		{
			DocumentoProtocollato documentoSenzaContenuto = new DocumentoProtocollato();
			documentoSenzaContenuto.setOggetto("oggetto di prova");
			documentoSenzaContenuto.setIsContenuto(false);
			documentoSenzaContenuto.setTipoProtocollo("I");
			documentoSenzaContenuto.setTimbro(false);
			documentoSenzaContenuto.setRegistro("reg_test2");
			MittenteDestinatario unicoMittente = new MittenteDestinatario();
			unicoMittente.setTipo("F");
			unicoMittente.setCognome("Santomauro");
			unicoMittente.setNome("Antonio");
			unicoMittente.setDenominazione("Antonio Santomauro");
			unicoMittente.setCodiceMittenteDestinatario("00001");
			unicoMittente.setEmail("antonio.santomauro@sincon.it");
			unicoMittente.setCodiceMezzoSpedizione("MAILST");
			unicoMittente.setCitta("Taranto");
			unicoMittente.setIndirizzo("Via Bari 18");
			unicoMittente.setInvioPC(false);
			documentoSenzaContenuto.setMittentiDestinatari(new MittenteDestinatario[]{unicoMittente});
			DocumentoProtocollato documentoProtocollato = port.protocolla(autenticazione, documentoSenzaContenuto);
			assertNotNull(documentoProtocollato.getDataProtocollo());
			assertNotNull(documentoProtocollato.getNumeroProtocollo());
			assertNotNull(documentoProtocollato.getId());
			Map<String, Object> datiProtocollazione = new HashMap<String, Object>();
			datiProtocollazione.put("dataProtocollo", documentoProtocollato.getDataProtocollo());
			datiProtocollazione.put("numeroProtocollo", documentoProtocollato.getNumeroProtocollo());
			datiProtocollazione.put("id", documentoProtocollato.getId());
			documentiProtocollati.add(datiProtocollazione);
			InputStream is = this.getClass().getResourceAsStream("/documenti/1.jpg");
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			copyStream(is, os);
			documentoProtocollato.setIsContenuto(true);
			documentoProtocollato.setContenuto(os.toByteArray());
			os.close();
			DocumentoProtocollato documentoDefinitivo = port.protocolla(autenticazione, documentoProtocollato);
			assertEquals(documentoProtocollato.getDataProtocollo(), documentoDefinitivo.getDataProtocollo());
			assertNotEquals(documentoProtocollato.getNumeroProtocollo(), documentoDefinitivo.getNumeroProtocollo());
			assertNotEquals(documentoProtocollato.getId(), documentoDefinitivo.getId());
		}
		catch(RemoteException re)
		{
			fail(re.getMessage());
		} 
		catch (IOException e) 
		{
			fail(e.getMessage());
		}
	}
	
	@Test
	public void test2AllegaDocumentoAProtocolloEsistente()
	{
		try 
		{
			Map<String,Object> datiProtocollazioneSalvati = documentiProtocollati.get(0);
			Long id = (Long)datiProtocollazioneSalvati.get("id");
			Allegato allegato = new Allegato();
			allegato.setIdProfilo(id);
			InputStream is = this.getClass().getResourceAsStream("/documenti/2.jpg");
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			copyStream(is, os);
			allegato.setContenuto(os.toByteArray());
			allegato.setDescrizione("Allegato di test");
			allegato.setCollocazione("test");
			Allegato allegatoProtocollato = port.inserisciAllegato(autenticazione, allegato);
			assertNotNull(allegatoProtocollato.getId());
		}		
		catch(RemoteException re)
		{
			fail(re.getMessage());
		} 
		catch (IOException e) 
		{
			fail(e.getMessage());
		}
	}
	
	@Test
	public void test3VerificaRicerca()
	{
		try 
		{
			Map<String,Object> datiProtocollazioneSalvati = documentiProtocollati.get(0);
			Calendar dataProtocollazione = (Calendar)datiProtocollazioneSalvati.get("dataProtocollo");
			String numeroProtocollo = (String)datiProtocollazioneSalvati.get("numeroProtocollo");
			Ricerca ricerca = new Ricerca();
			ricerca.setModalita("I");
			ricerca.setDataProtocolloDa(dataProtocollazione);
			ricerca.setDataProtocolloA(dataProtocollazione);
			ricerca.setNumeroA(numeroProtocollo);
			ricerca.setNumeroDa(numeroProtocollo);
			ricerca.setRegistro("reg_test2");
			DocumentoProtocollato[] elenco=port.ricercaProtocolli(autenticazione, ricerca);
			assertEquals(2, elenco.length);
			for(DocumentoProtocollato singolo:elenco)
			{
				assertNotNull(singolo.getContenuto());
			}
		} 
		catch (RemoteException re) 
		{
			fail(re.getMessage());
		}
	}
	
	private void copyStream(InputStream is,OutputStream os)throws IOException
	{
		while (is.read() != -1) {
	        os.write(is.read());
	    }
		is.close();
	}
	
}
