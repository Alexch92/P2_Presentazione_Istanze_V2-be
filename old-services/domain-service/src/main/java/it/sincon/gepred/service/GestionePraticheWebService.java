package it.sincon.gepred.service;

import java.util.ArrayList;
import java.util.List;

import it.osapulie.domain.Comune;
import it.osapulie.domain.ProfiloUtente;
import it.osapulie.service.ServiceLayerException;
import it.sincon.gepred.documentale.bean.DocInfo;
import it.sincon.gepred.documentale.bean.DocumentaleException;
import it.sincon.gepred.domain.Allegati;
import it.sincon.gepred.domain.AllegatiPratica;
import it.sincon.gepred.domain.CampiAggiuntiviPraticaWeb;
import it.sincon.gepred.domain.Referente;
import it.sincon.gepred.domain.TipoImmobile;
import it.sincon.gepred.domain.pratica.CategoriePratiche;
import it.sincon.gepred.domain.pratica.ElencoPraticheWeb;
import it.sincon.gepred.domain.pratica.Pratica;
import it.sincon.gepred.domain.pratica.PraticaWeb;
import it.sincon.gepred.domain.pratica.PraticaWebExtended;
import it.sincon.gepred.domain.pratica.RappresentanteLegale;
import it.sincon.gepred.domain.pratica.StatoPratica;
import it.sincon.gepred.domain.pratica.TipoPratica;
import it.sincon.gepred.web.portlet.varie.DatiRicercaPraticaWeb;

/**
 * 
 * @author Maria Michela Birtolo
 * @author Antonio Santomauro
 */
public interface GestionePraticheWebService {
	
	/**
	 * Cancella la pratica a partire dal suo ID.
	 * 
	 * @param pk
	 * @throws ServiceLayerException
	 */
	public void deletePraticaWeb(Long idPratica) throws ServiceLayerException;
	
	/**
	 * Metodo che recupera l'elenco delle pratiche relative ai parametri di ricerca inseriti
	 * @param filtriRicercaPraticheOnline
	 * @return List<Pratica>
	 */
	List<Pratica> searchPratiche(DatiRicercaPraticaWeb filtriRicercaPraticheOnline);
	
	/**
	 * Ritorna la pratica a partire dal suo ID.
	 * 
	 * @param pk
	 * @return Pratica
	 * @throws ServiceLayerException
	 */
	public Pratica getPraticaByPk(long pk) throws ServiceLayerException;
	
	/**
	 * Ritorna la praticaweb a partire dal suo ID.
	 * 
	 * @param pk
	 * @return PraticaWeb
	 * @throws ServiceLayerException
	 */
	public PraticaWeb getPraticaWebByPk(long pk) throws ServiceLayerException;
	
	/**
	 * Salva una pratica nel sistema.
	 * 
	 * @param pratica
	 * @throws ServiceLayerException
	 */
	public PraticaWeb savePratica(PraticaWeb pratica) throws ServiceLayerException;
	
	/**
	 * Metodo che recupera l'elenco delle pratiche relative ai parametri di ricerca inseriti
	 * @param profiloutente
	 * @return List<PraticaWeb>
	 */
	
	public List<ProfiloUtente> getRemainingProfiliUtente(PraticaWeb pratica);
	
	/**
	 * Metodo che recupera la lista di praticheweb di un dato profiloUtente
	 * @param profiloutente
	 * @return la lista di pratiche web
	 */
	public List<PraticaWeb> searchPraticheWeb(ProfiloUtente profiloutente );
	
	/**
	 * Metodo che recupera la lista di praticheweb di una data azienda
	 * @param partitaIva
	 * @return la lista di pratiche web
	 */
	public List<PraticaWeb> searchPraticheWebByImpresa(String partitaIva );
	
	/**
	 * Ricerca le PraticheWeb che si riferiscono ad un dato titolare
	 * @param caLabel
	 * @param caValore
	 * @return
	 */
	public List<PraticaWeb> searchPraticheWebByTitolare(String titolare );
	
	/**
	 * Metodo che recupera l'elenco delle richieste di pratiche per il backend
	 * @return List<PraticaWeb>
	 */
	
	public List<PraticaWeb> praticheSelezionate(ElencoPraticheWeb elenco);
	/**
	 * Metodo che recupera l'elenco di pratiche selezionate
	 * @return List<PraticaWeb>
	 */
	
	public List<PraticaWeb> searchPraticheWeb();
	
	/**
	 * Metodo che recupera l'elenco delle richieste di pratiche per il backend
	 * @param profiloUtente
	 * @return List<PraticaWeb>
	 */
	public ElencoPraticheWeb searchPraticheWebBackend(ProfiloUtente profiloUtente,DatiRicercaPraticaWeb filtri);
	
	/**
	 * Metodo che recupera l'elenco delle richieste di pratiche per il backend che siano state 
	 * finalizzate (presentano il campo invioPec=S
	 * @param profiloUtente
	 * @return
	 */
	public ElencoPraticheWeb searchPraticheWebBackendInviate(ProfiloUtente profiloUtente,DatiRicercaPraticaWeb filtri);
	
	/**
	 * Metodo che si occupa di gestire l'inoltra della pratica alla pec del comune
	 * @param tipologia
	 * @param uploadItem
	 * @param profiloUtente
	 * @throws ServiceLayerException
	 */
	public String processaUploadPratica(String tipologia, String fileName, byte[] content, ProfiloUtente profiloUtente,String idPratica, String uuidContenitorePratica) throws ServiceLayerException,Exception;
	
	/**
	 * Metodo che si occupa di gestire l'inoltra della pratica alla pec del comune
	 * @param tipologia
	 * @param uploadItem
	 * @param profiloUtente
	 * @throws ServiceLayerException
	 */
	public String processaUploadRitiroPratica(String tipologia, String fileName, byte[] content, ProfiloUtente profiloUtente,String idPratica, String uuidContenitorePratica) throws ServiceLayerException,Exception;

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
	 * Metodo che recupera le tipologie di pratica relative al frontend
	 * @return List<TipoPratica>
	 */
	public List<TipoPratica> searchTipoPraticheFrontEnd();
	/**
	 * Metodo che recupera le tipologie di pratica relative al frontend di una data categoria
	 * @return List<TipoPratica>
	 */
	public List<TipoPratica> searchTipoPraticheFrontEnd(CategoriePratiche categoria);
	
	public List<Comune> searchComuni();
	
	/**
	 * Metodo che recupera la lista di TipoImmobile
	 * @return List<TipoImmobile>
	 */
	public List<TipoImmobile> searchTipoImmobile();
	
	/**
	 * Metodo che recupera la lista degli stati possibile per una pratica
	 * @return List<StatoPratica>
	 */
	public List<StatoPratica> searchStatoPratica();
	
	/**
	 * Metodo che recupera un referente in base alla PK
	 * @param pk
	 * @return Referente
	 */
	public Referente getReferenteByPk(long pk);
	
	/**
	 * Metodo che recupera la lista degli allegati relativi ad una tipologia di pratica
	 * @param tipologia List<Allegati>
	 * @return
	 */
	public List<Allegati> searchAllegatiTipoPratica(TipoPratica tipologia);
	
	/**
	 * Metodo che recupera una tipologia di pratica in base all'ID
	 * @param pk
	 * @return TipoPratica
	 */ 
	public TipoPratica getTipoPraticaByPk(long pk);
	
	public Comune getComuneByPk(long pk);
	
	/**
	 * Metodo che recupera un TipoImmobile di pratica in base all'ID
	 * @param pk
	 * @return TipoImmobile
	 */
	public TipoImmobile getTipoImmobileByPk(long pk);
	
	/**
	 * Metodo che recupera la lista dei documenti contenuti in una cartella specifica
	 * @param uuidContenitore
	 * @return ArrayList<DocInfo>
	 */
	public ArrayList<DocInfo> documentiContenuti(String uuidContenitore);
	
	/**
	 * Metodo che elimina il file identificato dall'uuid
	 * @param uuidFile
	 */
	public Boolean eliminaDocumento(String uuidFile);
	
	/**
	 * Recupera il valore di uno specifico campo aggiuntivo per la pratica web pr. 
	 * 
	 * @param pr
	 * @param labelCampoAggiuntivo
	 * @return Restituisce il valore contenuto nel campo aggiuntivo della pratica pr la cui label 
	 * 		   è pari a labelCampoAggiuntivo, null se il campo aggiuntivo non esiste. 
	 */
	public String getValoreCampoAggiuntivo(PraticaWeb pr, String labelCampoAggiuntivo);
	
	/**
	 * Recupera uno specifico campo aggiuntivo per la pratica pr. 
	 * 
	 * @param pr
	 * @param labelCampoAggiuntivo
	 * @return Restituisce il valore contenuto nel campo aggiuntivo della pratica pr la cui label 
	 * 		   è pari a labelCampoAggiuntivo, null se il campo aggiuntivo non esiste. 
	 */
	public CampiAggiuntiviPraticaWeb getCampoAggiuntivo(PraticaWeb pr, String labelCampoAggiuntivo);
	
	/**
	 * Imposta il valore di uno specifico campo aggiuntivo per la pratica pr. 
	 * @param pr
	 * @param labelCampoAggiuntivo
	 * @param newValue
	 */
	public void setValoreCampoAggiuntivo(PraticaWeb pr, String labelCampoAggiuntivo, String newValue);

	public RappresentanteLegale rimuoviAllegatoB(RappresentanteLegale rl);
	
	/**
	 * Ricerca le PraticheWeb che hanno un dato valore come campoAggiuntivo
	 * @param caLabel
	 * @param caValore
	 * @return
	 */
	public List<PraticaWeb> searchPraticheWebByValoreCampAgg(String caLabel, String caValore );
	
	/**
	 * 
	 * @param nomeDocumentoModello
	 * @param uuidContenitore
	 * @param idPraticaWeb
	 * @return
	 * @throws ServiceLayerException
	 * @throws DocumentaleException
	 */
	public String CercaAllegatoInDocumentale(String nomeDocumentoModello, String uuidContenitore, long idPraticaWeb) 
			throws ServiceLayerException, DocumentaleException;
	
	/**
	 * Ricerca le PraticheWeb in stato PRESENTATA o VALIDATA che si riferiscono ad un dato titolare
	 * @param caLabel
	 * @param caValore
	 * @return
	 */
	public List<PraticaWeb> searchPraticheWebPresentateByTitolare(String titolare );
	
	public PraticaWeb valorizzaCampiCalcolati(PraticaWeb pratica) throws ServiceLayerException;
	
	/**
	 * elabora il punteggio da assegnare a questa istanza
	 * @param pratica
	 * @return
	 * @throws ServiceLayerException
	 */
	public int calcolaPunteggio(PraticaWeb pratica) throws ServiceLayerException;

	public List<PraticaWeb> searchPraticheWebByImpresaAndTitolare(String partitaIva, String titolare, String stato);
	
	/**
	 * Restituisce true se è possibile effettuare il consolida su questa domanda 
	 * @param pratica
	 * @return
	 */
	public boolean isConsolidaPossibile(PraticaWeb pratica);
	/**
	 * Restituisce true se è possibile effettuare l'invio a Regione di questa domanda
	 * @param pratica
	 * @return
	 */
	public boolean isInviaDomandaPossibile(PraticaWeb pratica);

	/**
	 * Formato di controllo:
	 * campoObbligatorioAssumeValore#<LABEL C.A.>v<IDX_VAL_1>OR<IDX_VAL_2>...
	 * Esempio di controllo:
	 * campoObbligatorioAssumeValore#Sono stati effettuati interventi di miglioramento della prestazione energetica sull’immobile@0
	 * @param alPra
	 * @return
	 */
	boolean isAllegatoPraticaWebObbligatorio(PraticaWeb prWeb, AllegatiPratica alPra);
	
	/**
	 * Metodo che recupera l'elenco di pratiche validate
	 * @return List<PraticaWeb>
	 */
	public List<PraticaWeb> searchPraticheWebValidate(int nrGiorniValidateDa);
	
	/**
	 * Metodo che rimuove la validazione dale pratiche web che sono in stato VALIDE da più di nrGiorniValidateDa giorni.
	 * Rimette lo stato in DA VALIDARE, imposta data Validazione = NILL ed invia la mail per avvisare il beneficiario e
	 * l'operatore economico del cambio stato.
	 * 
	 * @param nrGiorniValidateDa
	 * @return la lista aggiornata di pratiche in stato validate
	 */
	public List<PraticaWeb> rimuoviValidazione(int nrGiorniValidateDa);
	
	/**
	 * Metodo che restituisce le praticheWeb in un dato STATO
	 * @param stato
	 * @return
	 */
	public List<PraticaWeb> searchPraticheWebByStato(String stato);
	
	/**
	 * Aggiorna lo stato della praticaWeb
	 * @param numeroPratica
	 * @param newStato
	 * @return
	 * @throws ServiceLayerException
	 */
	public PraticaWeb setStatoByNumeroPratica(String numeroPratica, String newStato) throws ServiceLayerException;
}
