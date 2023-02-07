package it.sincon.gepred.service;

import java.io.File;
import java.io.Serializable;
import java.util.List;
import java.util.Locale;
import java.util.SortedMap;

import org.springframework.context.support.AbstractMessageSource;

import it.osapulie.domain.ProfiloUtente;
import it.osapulie.service.ServiceLayerException;
import it.sincon.gepred.calendario.beans.Appuntamento;
import it.sincon.gepred.domain.AllegatiPratica;
import it.sincon.gepred.domain.Attivita;
import it.sincon.gepred.domain.AttivitaPratica;
import it.sincon.gepred.domain.CampiAggiuntivi;
import it.sincon.gepred.domain.DatiInvioMail;
import it.sincon.gepred.domain.DatiMailInviate;
import it.sincon.gepred.domain.pratica.EsitoIstruttoria;
import it.sincon.gepred.domain.pratica.Pratica;
import it.sincon.gepred.domain.pratica.TipoPratica;
import it.sincon.gepred.web.portlet.varie.DatiConsuntivoPratica;
import it.sincon.gepred.web.portlet.varie.DatiRicercaPratica;
import it.sincon.gepred.domain.Referente;
import it.sincon.gepred.protocollo.bean.AllegatoProtocollo;
import it.sincon.gepred.protocollo.bean.DatiOutputProtocollo;
import it.sincon.gepred.protocollo.bean.DatiRichiestaProtocollo;
import it.sincon.gepred.protocollo.bean.MezzoSpedizioneEnum;

/**
 * 
 * @author Maria Michela Birtolo
 * 
 */
public interface GestionePraticheService {
	
	/**
	 * Metodo che recupera l'elenco delle pratiche relative ai parametri di ricerca inseriti
	 * @param oggetto
	 * @param richiedente
	 * @param numero
	 * @return List<Pratica>
	 */
	List<Pratica> searchPratiche(DatiRicercaPratica filtriRicerca);
	
	/**
	 * Salva una pratica nel sistema.
	 * 
	 * @param pratica
	 * @throws ServiceLayerException
	 */
	public Pratica savePratica(Pratica pratica) throws ServiceLayerException;
	
	/**
	 * Ritorna la pratica a partire dal suo ID.
	 * 
	 * @param pk
	 * @return Pratica
	 * @throws ServiceLayerException
	 */
	public Pratica getPraticaByPk(long pk) throws ServiceLayerException;
	
	/**
	 * Recupera la pratica in cui l'utente fornito è uno degli assegnatari 
	 * @param utente
	 * @return Pratica
	 * @throws ServiceLayerException
	 */
	public Pratica getPraticaByAssegnatari(ProfiloUtente utente) throws ServiceLayerException;
	
	/**
	 * Recupera la pratica relativa al numero passato in input 
	 * @param numero
	 * @return Pratica
	 * @throws ServiceLayerException
	 */
	public Pratica getPraticaByNumero(String numero) throws ServiceLayerException;
	
	/**
	 * Cancella la pratica a partire dal suo ID.
	 * 
	 * @param pk
	 * @throws ServiceLayerException
	 */
	public void deletePratica(Pratica pratica) throws ServiceLayerException;
	
	/**
	 * Calcola il successivo numero di pratica relativa ad una certa tipologia
	 * @param prefisso
	 * @param anno
	 * @throws ServiceLayerException
	 */
	public int generaNumeroPratica(String prefisso, String anno) throws ServiceLayerException;
	
	/**
	 * Calcola il numero successivo in base annuale di un campo contatore il cui id
	 * e' fornito in input 
	 * @param idField
	 * @param anno
	 * @return int 
	 * @throws ServiceLayerException
	 */
	public int generaContatore(long idField,String anno) throws ServiceLayerException;
	/**
	 * Metodo che recupera l'elenco dei CampiAggiuntivi secondo la tipologia di pratica associata
	 * @param filtriRicerca
	 * @return List<CampiAggiuntivi>
	 */
	List<CampiAggiuntivi> getCampiAggiuntiviByTipoPratica(TipoPratica tipoPratica);
	
//	/**
//	 * Metodo che verifica l'esistenza di un site legato alla pratica e sette le preferenze, 
//	 * altrimenti prima lo crea. 
//	 * @param praticaId
//	 * @param prefs
//	 * @throws Exception
//	 */
//	public void verifySitePratica(String praticaId,PortletPreferences prefs)throws Exception;
	
	public void caricaInDocumentale(String uuidContenitore, AllegatiPratica allegato, AllegatiPratica savedAllegato) throws Exception;
	
	/**
	 * Metodod che elimina l'allegato di un parere dipendente dal verso (uscita/risposta)
	 * @param pk
	 * @param verso
	 */
	public void deleteAllegatoParere(long pk,String verso);
	
	/**
	 * Metodo che elimina l'allegato
	 * @param pk
	 */
	public void deleteAllegato(long pk);
	
	/**
	 * Metodo che elimina il campo aggiuntivo di tipo allegato
	 * @param pk
	 */
	public void deleteAllegatoCA(long pk);
	
	/**
	 * Metodo per allegare un file alla pratica
	 * @param path
	 * @param uuidContenitore - id univoco del folder che contiene la pratica nel documentale in uso.
	 * @return String 
	 * @throws ServiceLayerException
	 */
	public String uploadDocumento(File file,String uuidContenitore) throws ServiceLayerException;
	
	/**
	 * Metodo per effettuare il download di un allegato di una pratica
	 * @param uuidContenitore - Folder contenente il documento da scaricare
	 * @param uuidDocumento - documento da scaricare
	 * @return byte[]
	 * @throws ServiceLayerException
	 * 
	 */
	public byte[] downloadDocumento(String uuidContenitore,String uuidDocumento) throws ServiceLayerException;
	
	/**
	 * Metodo per effettuare l'allineamento dei dati del protocollo alla pratica
	 * @param pratica
	 * @param protocollo
	 * @throws ServiceLayerException
	 */
	public DatiRichiestaProtocollo creaProtocolloDaPratica(Pratica pratica) throws ServiceLayerException;
	
	/**
	 * Metodo per effettuare la creazione dei dati del protocollo a partire da un allegato della pratica
	 * @param pratica
	 * @param idAllegato
	 * @throws ServiceLayerException
	 */
	public DatiRichiestaProtocollo creaProtocolloDaAllegato(Pratica pratica,Long idAllegato)throws ServiceLayerException;
	
	/**
	 * Metodo per effettuare la creazione dei dati del protocollo a partire da un parere della pratica e dal verso (uscita/risposta)
	 * @param pratica
	 * @param idParere
	 * @param verso
	 * @return
	 * @throws ServiceLayerException
	 */
	public DatiRichiestaProtocollo creaProtocolloDaParere(Pratica pratica,Long idParere,String verso)throws ServiceLayerException;
	
	/**
	 * Metodo che legge i dati di protocollo dalla pratica per effettuare il completamento
	 * @param pratica
	 * @return
	 * @throws ServiceLayerException
	 */
	public DatiRichiestaProtocollo leggiProtocolloDaPraticaPerCompletamento(Pratica pratica)throws ServiceLayerException;
	
	/**
	 * Metodo per aggiungere un nuovo Mittente/Destinatario al protocollo
	 * @param ref
	 * @param protocollo
	 * @throws ServiceLayerException
	 */
	public void aggiungiReferenteAProtocollo(Referente ref,DatiRichiestaProtocollo protocollo) throws ServiceLayerException;
	
	/**
	 * Metodo che permette di cancellare un Mittente/Destinatario selezionato come cancellabile
	 * dalla lista dei Mittenti/Destinatari del protocollo
	 * @param protocollo
	 * @param mittenteDestinatarioDaCancellare TODO
	 * @throws ServiceLayerException
	 */
	public void rimuoviMittenteDestinatarioDaProtocollo(DatiRichiestaProtocollo protocollo, Integer mittenteDestinatarioDaCancellare) throws ServiceLayerException;
	
	/**
	 * Metodo per effettuare la protocollazione di una pratica
	 * @param datiProtocollazione
	 * @return DatiOutputProtocollo
	 */
	public DatiOutputProtocollo protocollaPratica(DatiRichiestaProtocollo datiProtocollazione);
	
	/**
	 * Metodo per la consultazione del protocollo di una pratica
	 * @param datiIdentificativiProtocollo
	 * @return
	 */
	public DatiRichiestaProtocollo consultaProtocollo(DatiOutputProtocollo datiIdentificativiProtocollo);
	
	/**
	 * Metodo per l'aggiunta di un allegato ad un protocollo esistente
	 * @param allegato
	 * @param datiIdentificativiProtocollo
	 * @return
	 */
	public DatiOutputProtocollo allegaDocumentoAProtocollo(AllegatoProtocollo allegato,DatiOutputProtocollo datiIdentificativiProtocollo);
	
	/**
	 * Metodo per settare il documento principale nel caso di protocollazione senza documento
	 * @param documentoPrincipale
	 * @param datiIdentificativiProtocollo
	 * @return
	 */
	public DatiOutputProtocollo completaProtocollazioneProvvisoria(AllegatoProtocollo documentoPrincipale,DatiOutputProtocollo datiIdentificativiProtocollo);
	
	/**
	 * Metodo per il mapping tra i mezzi di spedizione interni e quelli dei un protocollo reale 
	 * @return
	 */
	public SortedMap<MezzoSpedizioneEnum, Serializable> traduciMezziSpedizione();
	
	/**
	 * Verifica l'esistenza di un protocollo
	 * @return
	 */
	public boolean isPresentProtocollo();
	
	/**
	 * Verifica che sia implementato il metodo per il completamento
	 * @return
	 */
	public boolean isImplementedCompletamento();
	
	/**
	 * Verifica che sia implementato il protocollo in uscita
	 * @return
	 */
	public boolean isImplementedProtocolloUscita();
	
	
	/**
	 * Verifica che sia presente il campo inviaPerConoscenza
	 * @return
	 */
	public boolean isSettatoInviaPc();
	
	/**
	 * Metodo per riversare i dati di protocollazione nei vari oggetti della pratica
	 * @param datiProtocollo
	 * @param pratica
	 * @throws ServiceLayerException
	 */
	public void riversaDatiProtocolloInPratica(DatiRichiestaProtocollo datiProtocollo,Pratica pratica) throws ServiceLayerException;
	
	/**
	 * Metodo per riversare i dati di protocollazione nell'allegato della pratica presente in elenco
	 * @param datiProtocollo
	 * @param pratica
	 * @throws ServiceLayerException
	 */
	public void riversaDatiProtocolloInAllegato(DatiRichiestaProtocollo datiProtocollo,Pratica pratica)throws ServiceLayerException;
	
	/**
	 * Metodo per riversare i dati di protocollazione nel parere con id passato come parametro e nei campi di uscita/risposta dipendentemente dal verso
	 * @param datiProtocollo
	 * @param pratica
	 * @param idParere
	 * @param verso
	 * @throws ServiceLayerException
	 */
	public void riversaDatiProtocolloInParere(DatiRichiestaProtocollo datiProtocollo,Pratica pratica,Long idParere,String verso)throws ServiceLayerException;
	
	/**
	 * Metodo per generare i dati di richiesta di protocollo a partire dai dati della pratica
	 * @param pr
	 * @return
	 * @throws ServiceLayerException
	 */
	public DatiOutputProtocollo generaDatiConsultazioneProtocolloDaPratica(Pratica pr)throws ServiceLayerException;
	
	/**
	 * Metodo per generare i dati di richiesta di protocollo a partire da un allegato della pratica
	 * @param pr
	 * @param idAllegato
	 * @return
	 * @throws ServiceLayerException
	 */
	public DatiOutputProtocollo generaDatiConsultazioneProtocolloDaAllegato(Pratica pr,Long idAllegato) throws ServiceLayerException;
	
	/**
	 * Metodo per generare i dati di richiesta di protocollo a partire da un parere della pratica
	 * @param pr
	 * @param idParere
	 * @param verso
	 * @return
	 * @throws ServiceLayerException
	 */
	public DatiOutputProtocollo generaDatiConsultazioneProtocolloDaParere(Pratica pr,Long idParere,String verso) throws ServiceLayerException;
	
	/**
	 * Metodo per effettuare il completamento della protocollazione provvisoria di un parere il cui id e' quello passato come parametro e verso di protocollazione (uscita/risposta)
	 * @param pr
	 * @param idParere
	 * @param verso
	 * @return
	 * @throws ServiceLayerException
	 */
	public DatiOutputProtocollo generaRichiestaCompletamentoProtocolloDaParere(Pratica pr,Long idParere,String verso) throws ServiceLayerException;
	
	/**
	 * Metodo per effettuare il completamento della protocollazione provvisoria di un allegato il cui id e' quello passato come parametro
	 * @param pr
	 * @param idAllegato
	 * @return
	 * @throws ServiceLayerException
	 */
	public DatiOutputProtocollo generaRichiestaCompletamentoProtocolloDaAllegato(Pratica pr,Long idAllegato)throws ServiceLayerException;
	
	/**
	 * Metodo per creare una lista di tutte le attivit&agrave; associate al Tipo Pratica
	 * @param tp
	 * @return lista delle attivit&agrave;
	 */
	public List<AttivitaPratica> generaListaAttivita(TipoPratica tp);
	
	/**
	 * Genera una lista di appuntamenti a partire dalle attivit&agrave; associate alla pratica,
	 * gli appuntamenti poi diventeranno eventi del calendario
	 * 
	 * @param pratica
	 * @return lista di appuntamenti
	 */
	public List<Appuntamento> generaListaAppuntamentiDaAttivita(Pratica pratica);
	
	/**
	 * Utility method che splitta il numero di pratica
	 * 
	 * @param pratica
	 * @return la pratica con i campi prefisso e numero popolati
	 */
	public Pratica dividiNumeroPratica(Pratica pratica);
	
	/**
	 * Metodo per recuperare una lista di ProfiliUtente associabili alla pratica
	 * @param pratica
	 * @return
	 */
	public List<ProfiloUtente> getRemainingProfiliUtente(Pratica pratica);
	
	/**
	 * Metodo che aggiorna la lista dei referenti selezionabili nelle input dinamiche
	 * @param pratica
	 * @return la lista degli utenti rimasti
	 */
	public List<Referente> getRemainingRefs(Pratica pratica);
	
	/**
	 * Metodo che recupera la lista di utenti corrispondenti
	 * ai ruoli abilitati alla visualizzazione nelle caselle di input
	 * @return la lista degli utenti abilitati
	 */
	public List<ProfiloUtente> getUtentiRuoliVisibili();
	
	/**
	 * Metodo che recupera il consuntivo delle pratiche relative ai parametri di ricerca inseriti 
	 * @param datiRicercaPratica
	 * @return
	 */
	public List<DatiConsuntivoPratica> searchConsuntivoPratiche(DatiRicercaPratica datiRicercaPratica);
	
	/**
	 * Metodo che genera ed aggiunge alla pratica eventuali AttivitaPratica automatiche ed una 
	 * AttivitaPatica per ciascuna Attivita riportata nella lista passata in input
	 *
	 * 
	 * @param pratica : l'entity pratica di cui aggiornare la lista attività
	 * @param utente : l'utente che sta eseguendo l'operaizone
	 * @param attivitaDaCA : lista di attività a fronte delle quali generare una attività pratica: 
	 * 	  	Tale lista viene popolata con le attività da generare a fronte dei controlli previsti
	 * 		nei campi aggiuntivi. 
	 * 				
	 * @return l'entity pratica cone le attività aggiornale
	 */
	public Pratica verificaAttivitaAutomatiche(Pratica pratica,ProfiloUtente utente, List<Attivita> attivitaDaCA);
	
	/**
	 * Metodo che genera ed aggiunge alla pratica eventuali AttivitaPratica automatiche da
	 * generare alla chiusura della richiesta di Integrazione
	 *
	 * 
	 * @param pratica : l'entity pratica di cui aggiornare la lista attività
	 * @param utente : l'utente che sta eseguendo l'operaizone
	 * 				
	 * @return l'entity pratica cone le attività aggiornale
	 */
	public Pratica verificaAttivitaAutomaticheChiusuraIntegrazione(Pratica pratica,ProfiloUtente utente);
	
	/**
	 * Metodo che imposta la data di chiusura alle attivitàPratica con ID presente nella lista
	 * passata in input.
	 * @param lstAttivitaToBeClosed
	 */
	public void chiudiAttivitaPratica(List<AttivitaPratica> lstAttivitaToBeClosed);
	
	/**
	 * Recupera il valore di uno specifico campo aggiuntivo per la pratica pr. 
	 * 
	 * @param pr
	 * @param labelCampoAggiuntivo
	 * @return Restituisce il valore contenuto nel campo aggiuntivo della pratica pr la cui label 
	 * 		   è pari a labelCampoAggiuntivo, null se il campo aggiuntivo non esiste. 
	 */
	public String getValoreCampoAggiuntivo(Pratica pr, String labelCampoAggiuntivo);
	
	/**
	 * Recupera il valore di uno specifico campo aggiuntivo per la pratica pr. 
	 * 
	 * @param pr
	 * @param posCampoAggiuntivo
	 * @return Restituisce il valore contenuto nel campo aggiuntivo della pratica pr che si trova 
	 * 		   in posizione posCampoAggiuntivo, null se il campo aggiuntivo non esiste. 
	 */
	public String getValoreCampoAggiuntivo(Pratica pr, int posCampoAggiuntivo);
	
	/**
	 * Imposta il valore di uno specifico campo aggiuntivo per la pratica pr. 
	 * 
	 * @param pr
	 * @param labelCampoAggiuntivo
	 * @return Restituisce il valore contenuto nel campo aggiuntivo della pratica pr la cui label 
	 * 		   è pari a labelCampoAggiuntivo, null se il campo aggiuntivo non esiste. 
	 */
	public void setValoreCampoAggiuntivo(Pratica pr, String labelCampoAggiuntivo, String newValue);
	
	/**
	 * Metodo che invia la mail con l'allegato selezionato e memorizza i dati relativi all'invio
	 * @param mail
	 * @throws Exception 
	 */
	public boolean invioMailWithAllegato(DatiInvioMail mail ) throws Exception;
	
	/**
	 * Metodo che sceglie un referente per la pratica se è prevista un'assegnazione automatica
	 * @param pratica
	 * @return ProfiloUtente
	 * @throws ServiceLayerException
	 */
	public ProfiloUtente scegliProfilo(Pratica pratica) throws ServiceLayerException;
	
	/**
	 * Metodo per recuperare un allegato tramite uuid contenitore e uuid file
	 * @param uuidContenitore
	 * @param uuidFile
	 * @return AllegatiPratica
	 */
	public AllegatiPratica getAllegatoByUuidContenitoreAndUuidFile(String uuidContenitore,String uuidFile);
	
	/**
	 * Metodo che restituisce il json per il render del Grafico a Barre per il Riepilogo Pratiche
	 * @param inputList
	 * @return
	 */
	public String riepilogoPraticheToBarChartJson(List<DatiConsuntivoPratica> inputList, AbstractMessageSource messageSource, Locale locale);
	
	/**
	 * Restituisce true se per il dato AllegatoPratica è stata già inviata una mail.
	 * @param _dest
	 * @param _allegato
	 * @return
	 */
	public boolean esisteMailInviata(String _dest, AllegatiPratica _allegato);
	
	/**
	 * Metodo che genera il pdf partendo dal modello con id=idModello e lo allega alla pratica. 
	 * @param pratica
	 * @param idModello
	 * @param mainModelloPath
	 * @return true se la pratica aveva già un allegato generato da questo modello.
	 * @throws Exception
	 */
	public File generaModelloPdf(Pratica pratica, String nomeModello, String mainModelloPath) throws Exception;
	
	/**
	 *
	 * @param urp
	 * @return
	 */
	public String getUrpMailAccount(String urp);

	/**
	 * Recupera i dati per lo Storico mails inviate per una data pratica
	 * @param idPratica
	 * @return
	 */
	public List<DatiMailInviate> getMailsInviate(long idPratica);
	
	public Pratica getPraticaByPraticaWeb(long idPraticaWeb) throws Exception;
	
	public Pratica spostaAllegatiDaPraticaweb(Pratica entity) throws Exception;

	public Pratica valorizzaDatiImpresaDaVisura(TipoPratica tipoPratica, String pIvaVisura) throws ServiceLayerException;
	
	public String eseguiConfrontoVisura(Pratica entity, Pratica prFromVisura);

	public Pratica protocollaAllegatoEdInviaViaMail(Pratica datiPratica, String pdfAllegatoName, File pdfAllegatoFile, long idStatoNew, String tipoProtocollo, String nomeModelloMail) throws ServiceLayerException;
	
	public Pratica protocollaAllegatiNonProtocollati(Pratica datiPratica, String pdfAllegatoName, File pdfAllegatoFile, long idStatoNew, String tipoProtocollo) throws ServiceLayerException;
	public Pratica protocollaAllegatiNonProtocollati(Pratica datiPratica, long idStatoNew, String tipoProtocollo) throws ServiceLayerException;

	public List<EsitoIstruttoria> getEsitiIstruttoria();

	void logAllegati(List<AllegatiPratica> allegati);

	int calcolaPunteggio(Pratica pratica) throws ServiceLayerException;

	Pratica valorizzaCampiCalcolati(Pratica pratica) throws ServiceLayerException;
}
