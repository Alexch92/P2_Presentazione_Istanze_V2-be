/**
 * 
 */
package it.sincon.gepred.documentale.alfresco;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import org.alfresco.webservice.authentication.AuthenticationFault;
import org.alfresco.webservice.repository.RepositoryFault;
import org.alfresco.webservice.types.ParentReference;
import org.alfresco.webservice.types.Reference;
import org.alfresco.webservice.util.AuthenticationUtils;
import org.alfresco.webservice.util.Constants;
import org.alfresco.webservice.util.WebServiceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.sincon.gepred.documentale.alfresco.bean.Document;
import it.sincon.gepred.documentale.alfresco.impl.AlfrescoHelper;
import it.sincon.gepred.documentale.bean.DocFile;
import it.sincon.gepred.documentale.bean.DocInfo;
import it.sincon.gepred.documentale.bean.DocumentaleException;
import it.sincon.gepred.documentale.service.DocumentaleService;
/**
 * @author Santomauro
 *
 */
public class DocumentaleServiceAlfrescoImpl 
extends AlfrescoHelper implements DocumentaleService{

	protected Logger log = LoggerFactory.getLogger(DocumentaleServiceAlfrescoImpl.class);

	/* (non-Javadoc)
	 * @see it.sincon.gepred.documentale.service.DocumentaleService#creaContenitore(java.lang.String, java.lang.String)
	 */
	public String creaContenitore(String destPath, String regex, String oggettoPratica)throws DocumentaleException {

		String[] elements = destPath.split(regex); 
		if (elements.length == 0)
			throw new DocumentaleException("DocumentHandler Exception: Invalid format of folder path!");

		String siteName = elements[0];
		String siteId = siteName.replaceAll(" ", "");

		log.debug(String.format("Creazione Sito con siteName=%s,  siteId=%s...", siteName, siteId));
		try{
			this.connect();
			createSite(alfrescoUri,
					AuthenticationUtils.getTicket(),
					siteId,
					siteName,
					siteName,
					true);
			log.info(String.format("Creazione sito eseguita con successo! Site Id: %s, Site Name: %s",siteId, siteName));
			
			String uuidContenitore = null;
			if (elements.length>1)
				uuidContenitore = createPath(destPath.replace(siteName, siteId), regex);
			else
				uuidContenitore = ricercaContenitore(destPath, regex);
			
			if (uuidContenitore == null)
				throw new DocumentaleException("DocumentHandler Exception: Unable to create folder path " + destPath + "!");
			
			return uuidContenitore;
		}catch (Exception exp) {
			log.error(exp.getMessage());
			exp.printStackTrace();
			this.disconnect();
			throw new DocumentaleException(exp);
		}
	}

	/* (non-Javadoc)
	 * @see it.sincon.gepred.documentale.service.DocumentaleService#ricercaContenitore(java.lang.String)
	 */
	public String ricercaContenitore(String destPath, String regex)
			throws DocumentaleException {
		String[] elements = destPath.split(regex); 
		if (elements.length == 0)
			throw new DocumentaleException("DocumentHandler Exception: Invalid format of folder path!");

		String siteName = elements[0];
		String siteId = siteName.replaceAll(" ", "");

		log.debug(String.format("Cerca il Sito con siteName=%s,  siteId=%s...", siteName, siteId));
		
		try{
			this.connect();
			String uuid = searchSite( siteId );
			log.info(String.format("ricerca eseguita con successo! Site uuid: %s",uuid));

			return uuid;
		}catch (Exception exp) {
			log.error(exp.getMessage());
			exp.printStackTrace();
			this.disconnect();
			throw new DocumentaleException(exp);
		}
	}

	/* (non-Javadoc)
	 * @see it.sincon.gepred.documentale.service.DocumentaleService#uploadFile(it.sincon.gepred.documentale.bean.DocInfo, java.lang.String)
	 */
	public DocInfo uploadFile(DocInfo file, String uuidContenitore)
			throws DocumentaleException {
		ParentReference parentReference = null;

		log.info(String.format("Alfresco - chiamata al servizio uploadFile... contenitore uuid=%s;", uuidContenitore));
		String generatedUuid = null;
		try {
			this.connect();
			parentReference = new ParentReference(STORE, uuidContenitore, null, Constants.ASSOC_CONTAINS, null);
			generatedUuid = addDocument(parentReference, 
					file.getFile().getNome(), 
					file.getFile().getContent(), 
					file.getFile().getMimeType(), 
					file.getFile().getEncoding());
			DocInfo retValue = new DocInfo(file);

			log.info(String.format("Alfresco - uploadFile eseguito con successo! file uuid=%s", generatedUuid));
			retValue.setUuid(generatedUuid);
			retValue.getFile().setUuid(generatedUuid);
			this.disconnect();

			return retValue;
		} 
		catch (RepositoryFault e1) {
			// TODO Auto-generated catch block
			try{
					this.eliminaFile(generatedUuid);
			}
			catch (Exception ex){
				//throw new DocumentaleException(ex);
				log.error(ex.getMessage(), ex);
			}
			this.disconnect();
			
			log.error(e1.getMessage());
			e1.printStackTrace();
			throw new DocumentaleException(e1);
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			try{
				this.eliminaFile(generatedUuid);
			}
			catch (Exception ex){
//				throw new DocumentaleException(ex);
				log.error(ex.getMessage(), ex);
			}
			this.disconnect();
			log.error(e1.getMessage());
			e1.printStackTrace();
			throw new DocumentaleException(e1);
		}
		catch (Exception e1){
			try{
				this.eliminaFile(generatedUuid);
			}
			catch (Exception ex){
//				throw new DocumentaleException(ex);
				log.error(ex.getMessage(), ex);
			}
			this.disconnect();
			log.error(e1.getMessage());
			throw new DocumentaleException(e1);
		}
	}

	/* (non-Javadoc)
	 * @see it.sincon.gepred.documentale.service.DocumentaleService#consenteEliminaFile()
	 */
	public Boolean consenteEliminaFile() {
		return true;
	}

	/* (non-Javadoc)
	 * @see it.sincon.gepred.documentale.service.DocumentaleService#eliminaFile(java.lang.String)
	 */
	public void eliminaFile(String uuid) throws DocumentaleException {
		try {
			this.connect();
			Reference reference = new Reference(STORE, uuid, null);
			this.deleteNode(reference);
			this.disconnect();
		} catch (Exception e1) {			
			log.error(e1.getMessage());
			e1.printStackTrace();
			throw new DocumentaleException(e1);
		}
	}

	public void eliminaDirectory(String uuid) throws DocumentaleException {
		try {
			this.connect();
			List<DocInfo> files = documentiContenuti(uuid);
			for(DocInfo file:files){
				//eliminaFile(file.getUuid());
				Reference reference = new Reference(STORE, file.getUuid(), null);
				this.deleteNode(reference);
			}
			Reference referenceDir = new Reference(STORE, uuid, null);
			this.deleteNode(referenceDir);
			this.disconnect();
		} catch (Exception e1) {			
			log.error(e1.getMessage());
			e1.printStackTrace();
			throw new DocumentaleException(e1);
		}
	}

	/* (non-Javadoc)
	 * @see it.sincon.gepred.documentale.service.DocumentaleService#getMetadatiDocumento(java.lang.String)
	 */
	public DocInfo getMetadatiDocumento(String uuid)
			throws DocumentaleException {
		log.error("Metodo non Implementato!!");
		throw new DocumentaleException("Metodo non Implementato!!");
	}

	/* (non-Javadoc)
	 * @see it.sincon.gepred.documentale.service.DocumentaleService#download(java.lang.String)
	 */
	public DocFile download(String uuidContenitore, String uuidFile) throws DocumentaleException {

		try {
			this.connect();
		} catch (Exception e1) {
			log.error(e1.getMessage());
			e1.printStackTrace();
			throw new DocumentaleException(e1);
		}

		DocFile retFile = new DocFile();
		try {
			log.debug(String.format("Alfresco - downloadfile del file con uuidFile=%s, uuidContenitore=%s...",uuidFile, uuidContenitore));
			Reference space = this.getUUIDReference(uuidContenitore);
			Reference documentRef = new Reference(STORE, uuidFile, space.getPath());
			retFile.setContent(this.getContent(documentRef));
			documentRef.getPath();
			log.debug(String.format("Alfresco - downloadfile del file con getPath()=%s ...",documentRef.getPath()));

			this.disconnect();
			return retFile;
		} catch (Exception e1) {
			this.disconnect();
			log.error(e1.getMessage());
			e1.printStackTrace();
			throw new DocumentaleException(e1);
		}
	}

	/* (non-Javadoc)
	 * @see it.sincon.gepred.documentale.service.DocumentaleService#spostaDocumento(java.lang.String, java.lang.String)
	 */
	public void spostaDocumento(String uuidDocumento, String uuidDestContenitore)
			throws DocumentaleException {
		try {
			this.connect();
			Reference reference = new Reference(STORE, uuidDocumento, null);
			this.moveNode(reference, uuidDestContenitore);
			this.disconnect();
		} catch (Exception e1) {
			this.disconnect();
			log.error(e1.getMessage());
			e1.printStackTrace();
			throw new DocumentaleException(e1);
		}
	}

	/* (non-Javadoc)
	 * @see it.sincon.gepred.documentale.service.DocumentaleService#documentiContenuti(java.lang.String)
	 */
	public ArrayList<DocInfo> documentiContenuti(String uuidContenitore)
			throws DocumentaleException {
		ArrayList<DocInfo> result = new ArrayList<DocInfo>();
		try {
			Vector<Document> docs = getDocuments(null, null, null, null, null, uuidContenitore);
			for (Document document : docs) {
				DocFile res_file = new DocFile();
				res_file.setNome(document.getName());
				res_file.setUuid(document.getUuid());
				
				// Analisi del content per estrarre mymeType, size ed encoding...
				if (document.getContent()!= null){
					String[] contentParts = document.getContent().split("\\|");
					for (String part : contentParts){
						if (part.startsWith("size"))
							res_file.setDimensione(part.replace("size=", ""));
						if (part.startsWith("encoding"))
							res_file.setEncoding(part.replace("encoding=", ""));
						if (part.startsWith("mimetype"))
							res_file.setMimeType(part.replace("mimetype=", ""));
					}
				}
				
				DocInfo res_doc = new DocInfo();
				res_doc.setUuid(document.getUuid());
				res_doc.setFile(res_file);

				result.add(res_doc);
			}
			return result;
		} catch (Exception e1) {
			log.error(e1.getMessage());
			e1.printStackTrace();
			throw new DocumentaleException(e1);
		}
	}

	public String ricercaInContenitore(String searchText, boolean searchForFolder, String uuidPadre) throws DocumentaleException {
		// TODO Auto-generated method stub
		return null;
	}




}
