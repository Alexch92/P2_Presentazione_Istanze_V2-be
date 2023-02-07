package it.sincon.gepred.protocollo.scatel.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import it.sincon.gepred.protocollo.scatel.bean.CredenzialiUtente;
import it.sincon.gepred.protocollo.scatel.bean.Descrizione;
import it.sincon.gepred.protocollo.scatel.bean.Destinatario;
import it.sincon.gepred.protocollo.scatel.bean.Destinazione;
import it.sincon.gepred.protocollo.scatel.bean.Documento;
import it.sincon.gepred.protocollo.scatel.bean.Identificatore;
import it.sincon.gepred.protocollo.scatel.bean.ImprontaMIME;
import it.sincon.gepred.protocollo.scatel.bean.IndirizzoTelematico;
import it.sincon.gepred.protocollo.scatel.bean.IndirizzoTelematicoTipo;
import it.sincon.gepred.protocollo.scatel.bean.Intestazione;
import it.sincon.gepred.protocollo.scatel.bean.Mittente;
import it.sincon.gepred.protocollo.scatel.bean.Origine;
import it.sincon.gepred.protocollo.scatel.bean.ParametriEseguiProtocollo;
import it.sincon.gepred.protocollo.scatel.bean.ParametriRicercaProtocollo;
import it.sincon.gepred.protocollo.scatel.bean.ParametriRichiestaProtocollo;
import it.sincon.gepred.protocollo.scatel.bean.Persona;
import it.sincon.gepred.protocollo.scatel.bean.RispostaDettaglioProtocollo;
import it.sincon.gepred.protocollo.scatel.bean.RispostaProtocollo;
import it.sincon.gepred.protocollo.scatel.bean.Segnatura;
import it.sincon.gepred.protocollo.scatel.impl.ProtocolloPortType;
import it.sincon.gepred.protocollo.scatel.impl.ProtocolloWS;
import it.sincon.gepred.protocollo.scatel.impl.ProtocolloWSLocator;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProtocolloWebServiceTest {
	
	private ProtocolloPortType port;

	@Before
	public void setUp() throws Exception {
		ProtocolloWS service = new ProtocolloWSLocator();
		port = service.getProtocolloPort();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test1ProtocollazioneInIngressoPersonaFisica() throws Exception{
		ParametriEseguiProtocollo parametri = new ParametriEseguiProtocollo();
		parametri.setCredenzialiUtente(new CredenzialiUtente("t_test", "AOO_TEST", "test3"));
		parametri.setSegnatura(new Segnatura());
		parametri.getSegnatura().setInOut("I");
		parametri.getSegnatura().setIntestazione(new Intestazione());
		parametri.getSegnatura().getIntestazione().setIdentificatore(new Identificatore("t_test", "AOO_TEST", "0000000", "0000-00-00"));
		parametri.getSegnatura().getIntestazione().setOrigine(new Origine());
		parametri.getSegnatura().getIntestazione().getOrigine().setIndirizzoTelematico(new IndirizzoTelematico());
		parametri.getSegnatura().getIntestazione().getOrigine().getIndirizzoTelematico().setTipo(IndirizzoTelematicoTipo.NMTOKEN);
		parametri.getSegnatura().getIntestazione().getOrigine().setMittente(new Mittente());
		parametri.getSegnatura().getIntestazione().getOrigine().getMittente().setPersona(new Persona(null, "Giuseppe", "Cellamare", null, "CLLGPP79S29E882L", null, null, null));
		parametri.getSegnatura().getIntestazione().setDestinazione(new Destinazione[1]);
		parametri.getSegnatura().getIntestazione().getDestinazione()[0]=new Destinazione();
		parametri.getSegnatura().getIntestazione().getDestinazione()[0].setIndirizzoTelematico(new IndirizzoTelematico());
		parametri.getSegnatura().getIntestazione().getDestinazione()[0].getIndirizzoTelematico().setTipo(IndirizzoTelematicoTipo.NMTOKEN);
		parametri.getSegnatura().getIntestazione().getDestinazione()[0].setDestinatario(new Destinatario[1]);
		parametri.getSegnatura().getIntestazione().getDestinazione()[0].getDestinatario()[0]=new Destinatario();
		parametri.getSegnatura().getIntestazione().getDestinazione()[0].getDestinatario()[0].setDenominazione("t_test");
		parametri.getSegnatura().getIntestazione().setOggetto("Oggetto protocollazione ingresso persona fisica");
		parametri.getSegnatura().setDescrizione(new Descrizione());
		parametri.getSegnatura().getDescrizione().setDocumento(new Documento());
		parametri.getSegnatura().getDescrizione().getDocumento().setNome("Prova.jpg");
		parametri.getSegnatura().getDescrizione().getDocumento().setTitoloDocumento("Prova.jpg");
		parametri.getSegnatura().getDescrizione().getDocumento().setOggetto("Oggetto protocollazione ingresso persona fisica");
		/*InputStream is = this.getClass().getResourceAsStream("/documenti/1.jpg");
		byte[] digest = getDigest(is);
		parametri.getSegnatura().getDescrizione().getDocumento().setImprontaMIME(new ImprontaMIME());
		parametri.getSegnatura().getDescrizione().getDocumento().getImprontaMIME().set_value(new String(digest));*/
		RispostaProtocollo risposta=port.eseguiProtocollazione(parametri);
		assertNotNull(risposta.getSegnaturaProtocollo());
		assertNotNull(risposta.getSegnaturaProtocollo().getNumeroProtocollo());
		System.out.println("test1ProtocollazioneInIngressoPersonaFisica : "+risposta.getSegnaturaProtocollo().getNumeroProtocollo());
		assertNotNull(risposta.getSegnaturaProtocollo().getDataRegistrazione());
		System.out.println("test1ProtocollazioneInIngressoPersonaFisica : "+risposta.getSegnaturaProtocollo().getDataRegistrazione());
	}
	
	@Test
	public void test2ProtocollazioneInIngressoPersonaGiuridica() throws Exception{
		ParametriEseguiProtocollo parametri = new ParametriEseguiProtocollo();
		parametri.setCredenzialiUtente(new CredenzialiUtente("t_test", "AOO_TEST", "test3"));
		parametri.setSegnatura(new Segnatura());
		parametri.getSegnatura().setInOut("I");
		parametri.getSegnatura().setIntestazione(new Intestazione());
		parametri.getSegnatura().getIntestazione().setIdentificatore(new Identificatore("t_test", "AOO_TEST", "0000000", "0000-00-00"));
		parametri.getSegnatura().getIntestazione().setOrigine(new Origine());
		parametri.getSegnatura().getIntestazione().getOrigine().setIndirizzoTelematico(new IndirizzoTelematico());
		parametri.getSegnatura().getIntestazione().getOrigine().getIndirizzoTelematico().setTipo(IndirizzoTelematicoTipo.NMTOKEN);
		parametri.getSegnatura().getIntestazione().getOrigine().setMittente(new Mittente());
		parametri.getSegnatura().getIntestazione().getOrigine().getMittente().setPersona(new Persona("Sincon SRL", null, null, null, "00787980739", null, null, null));
		parametri.getSegnatura().getIntestazione().setDestinazione(new Destinazione[1]);
		parametri.getSegnatura().getIntestazione().getDestinazione()[0]=new Destinazione();
		parametri.getSegnatura().getIntestazione().getDestinazione()[0].setIndirizzoTelematico(new IndirizzoTelematico());
		parametri.getSegnatura().getIntestazione().getDestinazione()[0].getIndirizzoTelematico().setTipo(IndirizzoTelematicoTipo.NMTOKEN);
		parametri.getSegnatura().getIntestazione().getDestinazione()[0].setDestinatario(new Destinatario[1]);
		parametri.getSegnatura().getIntestazione().getDestinazione()[0].getDestinatario()[0]=new Destinatario();
		parametri.getSegnatura().getIntestazione().getDestinazione()[0].getDestinatario()[0].setDenominazione("t_test");
		parametri.getSegnatura().getIntestazione().setOggetto("Oggetto protocollazione ingresso persona giuridica");
		parametri.getSegnatura().setDescrizione(new Descrizione());
		parametri.getSegnatura().getDescrizione().setDocumento(new Documento());
		parametri.getSegnatura().getDescrizione().getDocumento().setNome("Prova2.jpg");
		parametri.getSegnatura().getDescrizione().getDocumento().setTitoloDocumento("Prova2.jpg");
		parametri.getSegnatura().getDescrizione().getDocumento().setOggetto("Oggetto protocollazione ingresso persona giuridica");
		/*InputStream is = this.getClass().getResourceAsStream("/documenti/2.jpg");
		byte[] digest = getDigest(is);
		parametri.getSegnatura().getDescrizione().getDocumento().setImprontaMIME(new ImprontaMIME());
		parametri.getSegnatura().getDescrizione().getDocumento().getImprontaMIME().set_value(new String(digest));*/
		RispostaProtocollo risposta=port.eseguiProtocollazione(parametri);
		assertNotNull(risposta.getSegnaturaProtocollo());
		assertNotNull(risposta.getSegnaturaProtocollo().getNumeroProtocollo());
		System.out.println("test2ProtocollazioneInIngressoPersonaGiuridica : "+risposta.getSegnaturaProtocollo().getNumeroProtocollo());
		assertNotNull(risposta.getSegnaturaProtocollo().getDataRegistrazione());
		System.out.println("test2ProtocollazioneInIngressoPersonaGiuridica : "+risposta.getSegnaturaProtocollo().getDataRegistrazione());
	}
	
	@Test
	public void test3RecuperoProtocolloInIngressoPersonaFisica() throws Exception{
		ParametriRichiestaProtocollo parametri = new ParametriRichiestaProtocollo();
		parametri.setCredenzialiUtente(new CredenzialiUtente("t_test", "AOO_TEST", "test3"));
		parametri.setIdentificatore(new Identificatore());
		parametri.getIdentificatore().setCodiceAmministrazione("t_test");
		parametri.getIdentificatore().setCodiceAOO("AOO_TEST");
		parametri.getIdentificatore().setDataRegistrazione("01/04/2014");
		parametri.getIdentificatore().setNumeroRegistrazione("0000155");
		RispostaDettaglioProtocollo risposta= port.prelevaDettaglioProtocollo(parametri);
		assertTrue(risposta.isTrovato());
		assertNotNull(risposta.getSegnatura());
		assertNotNull(risposta.getSegnatura().getInOut());
	}
	
	@Test
	public void test4RecuperoProtocolloInIngressoPersonaGiuridica() throws Exception {
		ParametriRichiestaProtocollo parametri = new ParametriRichiestaProtocollo();
		parametri.setCredenzialiUtente(new CredenzialiUtente("t_test", "AOO_TEST", "test3"));
		parametri.setIdentificatore(new Identificatore());
		parametri.getIdentificatore().setCodiceAmministrazione("t_test");
		parametri.getIdentificatore().setCodiceAOO("AOO_TEST");
		parametri.getIdentificatore().setDataRegistrazione("01/04/2014");
		parametri.getIdentificatore().setNumeroRegistrazione("0000156");
		RispostaDettaglioProtocollo risposta= port.prelevaDettaglioProtocollo(parametri);
		assertTrue(risposta.isTrovato());
		assertNotNull(risposta.getSegnatura());
		assertNotNull(risposta.getSegnatura().getInOut());
	}
	
	
	/*private static byte[] getDigest(InputStream is) throws NoSuchAlgorithmException, IOException 
	{
		MessageDigest digest = MessageDigest.getInstance("SHA-1");
	    int n = 0;
	    byte[] buffer = new byte[8192];
	    while (n != -1) {
	        n = is.read(buffer);

	        if (n > 0) {
	            digest.update(buffer, 0, n);
	        }
	    }
	    return digest.digest();
	}*/

}

