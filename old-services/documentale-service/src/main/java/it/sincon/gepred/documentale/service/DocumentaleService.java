package it.sincon.gepred.documentale.service;

import it.sincon.gepred.documentale.bean.DocFile;
import it.sincon.gepred.documentale.bean.DocInfo;
import it.sincon.gepred.documentale.bean.DocumentaleException;

import java.util.ArrayList;
import java.util.Date;

/**
 * Interfaccia per la gestione del Documentale.
 * Raccoglie le operazioni di interesse per il sistema GePred al fine di consentire 
 * la storicizzazione ed il ritrovamento dei files in un sistema Documentale esterno.
 * @author Santomauro
 *
 */
public interface DocumentaleService {
	/**
	 * Servizio che crea un contenitore in cui verranno caricati tutti i documenti
	 * @param destPath - Path che rispecchia l'alberatura della Categoria della pratica 
	 * 					 cui il documento si riferisce.
	 * @param regex - Delimitatore da utilizzare per lo split degli elementi in path
	 * @return L'dentificativo univoco del contenitore creato
	 * @throws DocumentaleException
	 */
	public String creaContenitore(String destPath, String regex, String oggettoPratica)throws DocumentaleException;
	
	/**
	 *
	 * @param destPath - Path che rispecchia l'alberatura della Categoria della pratica 
	 * 					 cui il documento si riferisce. 
	 * @param regex - Delimitatore da utilizzare per lo split degli elementi in path
	 * @return L'dentificativo univoco del contenitore ricercato
	 * @throws Exception
	 */
	public String ricercaContenitore(String destPath, String regex)throws DocumentaleException;
	
	/**
	 * Servizio che consente di ricercare un file o una sottocartella all'interno di un contenitore
	 * @param searchText - Testo da ricercare nel nome file/nome cartella
	 * @param searchForFolder - Se = true la ricerca avrà come target le sottocartelle della cartella padre,
	 *                          Se = false la ricerca avrà come target i files contenuti nella cartella padre,
	 * @param uuidPadre - contenitore all'interno del quale eseguire la ricerca.
	 * @return
	 * @throws DocumentaleException
	 */
	public String ricercaInContenitore(String searchText,boolean searchForFolder, String uuidPadre)throws DocumentaleException;
	
	/**
	 * Servizio che consente di eseguire l'upload di un file nel documentale.
	 * @param file - file da storicizzare, inclusi i suoi eventuali metadati.
	 * @param uuidContenitore - uuid del contenitore in cui caricare il file, ovvero il path 
	 * 			di destinazione. I vari documentali lo implementano in maniera differente 
	 * @return DocFile passato in input con l'attributo uuid valorizzato.
	 * @throws Exception
	 */
	public DocInfo uploadFile(DocInfo file, String uuidContenitore) throws DocumentaleException;

	/**
	 * Servizio che informa se il Documentale in uso consente di 
	 * eliminare un documento caricato.  
	 * @return
	 */
	public Boolean consenteEliminaFile();
	
	/**
	 * Servizio che consente di eliminare un file dal documentale
	 * @param uuid - Identificativo univoco del file
	 * @throws Exception
	 */
	public void eliminaFile(String uuid)throws DocumentaleException;
	
	/**
	 * Servizio che consente di eliminare una directory dal documentale
	 * @param uuid - Identificativo univoco della directory
	 * @throws DocumentaleException
	 */
	public void eliminaDirectory(String uuid)throws DocumentaleException;
	
	/**
	 * Servizio che consente di recuperare i metadati di un documento.
	 * @param uuid
	 * @return Metadati associati al documento, fra cui i dati di protocollazione, se presenti.
	 * @throws Exception
	 */
	public DocInfo getMetadatiDocumento(String uuid)throws DocumentaleException;
	
	/**
	 * Servizio che consente di recuperare un file dal documentale.
	 * @param uuidContenitore - Id del contenitore in cui il file è stato caricato.
	 * @param uuidFile - Id del file da recuperare
	 * @return I dati del file richiesto, incluso il byte array.
	 * @throws Exception
	 */
	public DocFile download(String uuidContenitore, String uuidFile)throws DocumentaleException;

	
	/**
	 * Servizio che consente di spostare un documento da un contenitore ad un altro.
	 * @param uuidDocumento - Identificativo univoco del documento da spostare
	 * @param uuidDestContenitore - Identificatovo univoco del nuovo conenitore
	 * 								di destinazione.
	 * @throws Exception
	 */
	public void spostaDocumento(String uuidDocumento, String uuidDestContenitore)throws DocumentaleException;
	
	/**
	 * Servizio che restituisce la lista di documenti contenuti nel contenitore selezionato.
	 * @param uuidContenitore - Identificativo univoco del Contenitore.
	 * @return Lista di DocInfo dei documenti trovati
	 * @throws Exception
	 */
	public ArrayList<DocInfo> documentiContenuti(String uuidContenitore) throws DocumentaleException;
	
}
