/**
 * 
 */
package it.sincon.gepred.web.portlet.utils;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;

import javax.activation.MimetypesFileTypeMap;
import org.alfresco.webservice.authentication.AuthenticationFault;
import org.alfresco.webservice.content.Content;
import org.alfresco.webservice.content.ContentFault;
import org.alfresco.webservice.content.ContentServiceSoapBindingStub;
import org.alfresco.webservice.repository.QueryResult;
import org.alfresco.webservice.repository.RepositoryFault;
import org.alfresco.webservice.repository.RepositoryServiceSoapBindingStub;
import org.alfresco.webservice.repository.UpdateResult;
import org.alfresco.webservice.types.CML;
import org.alfresco.webservice.types.CMLCreate;
import org.alfresco.webservice.types.CMLDelete;
import org.alfresco.webservice.types.ContentFormat;
import org.alfresco.webservice.types.NamedValue;
import org.alfresco.webservice.types.Node;
import org.alfresco.webservice.types.ParentReference;
import org.alfresco.webservice.types.Predicate;
import org.alfresco.webservice.types.Query;
import org.alfresco.webservice.types.Reference;
import org.alfresco.webservice.types.ResultSet;
import org.alfresco.webservice.types.ResultSetRow;
import org.alfresco.webservice.types.Store;
import org.alfresco.webservice.util.AuthenticationUtils;
import org.alfresco.webservice.util.Constants;
import org.alfresco.webservice.util.ContentUtils;
import org.alfresco.webservice.util.Utils;
import org.alfresco.webservice.util.WebServiceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Classe per gestire i documenti in un server Alfresco.<br>
 * Utilizza la API webservice di Alfresco: org.alfresco.webservice
 * @author Maria Michela Birtolo
 */
@Component("documentHandler")
public class DocumentHandler {
	
	@Value("#{applicationProperties.alfrescoWorkSpaceUri}")
	private String alfrescoWorkSpaceUri;
	
	@Value("#{applicationProperties.alfrescoDownloadUri}")
	private String alfrescoDownloadUri;
	
	@Value("#{applicationProperties.alfrescoUser}")
	private String alfrescoUser;
	@Value("#{applicationProperties.alfrescoPsw}")
	private String alfrescoPsw;
	
	protected Logger logger = LoggerFactory.getLogger(DocumentHandler.class);
	
	/*private String user;
	private String pass;
	private String url;
	private Store store;*/
	protected static final Store STORE = new Store(Constants.WORKSPACE_STORE, "SpacesStore");
	
	/**
	 * @see #setMaxRenamedDocuments(int)
	 */
	private int maxRenamedDocuments = 20;
	
	/**
	 * Crea un'istanza della classe <code>DocumentHandler</code> con i dati di un utente di
	 * Alfresco
	 * @param user <code>String</code> - l'utente che deve accedere al server alfresco
	 * @param role <code>String</code> - il ruolo dell'utente
	 
	public DocumentHandler(String user, String role) {
		this.user = user;
		this.user += (role == null || role == "") ? "" : "_" + (role.trim()).replace(" ", "");
		this.pass = ConfigurationProperties.getInstance().getProperty("pass");
		this.url = ConfigurationProperties.getInstance().getProperty("url");
		System.out.println("Invoco il servizio: "+this.url);
		//this.store = new Store(Constants.WORKSPACE_STORE, "SpacesStore");
	}
	*/
	
	private String addDocument(File file, ParentReference parent) throws Exception {
		if (file == null) throw new Exception("Il file e' null"); //FIXME
		if (file.getName().contains("@"))
			throw new Exception("Il nome del file contiene caratteri non validi");
		InputStream inputStream;
		try {
			inputStream = new FileInputStream(file);
		} catch (FileNotFoundException e1) {
			throw new Exception("Accesso al file non riuscito", e1);
		}
		byte[] content;
		try {
			content = ContentUtils.convertToByteArray(inputStream);
		} catch (Exception e1) {
			throw new Exception("Lettura file non riuscita", e1);
		}
		String mimetype = new MimetypesFileTypeMap().getContentType(file);
		String encoding = getEncoding(file);
		Reference document = null;
		try {
			document = this.createDocument(parent, file.getName(), content, mimetype,
					encoding);
		} catch (RuntimeException e) {
			e.printStackTrace();
			logger.error("ERRORE :"+e.getMessage());
			// in questo caso esiste un file con lo stesso nome
			if(e.getMessage().equals("Il file gia' esiste")){
				document = this.createNumberedDocument(parent, file.getName(), content,
					mimetype, encoding);
				if (document == null) {
					throw new Exception("Raggiunto limite massimo documenti rinominati");
				}
			}else{
				throw new Exception(e);
			}
		} catch (Exception e) {
			// in questo caso non e' stato caricato il contenuto
			throw new Exception("Caricamento contenuto file non riuscito", e);
		}
		inputStream.close();
		return alfrescoDownloadUri+document.getUuid();
	}
	
	
	/**
	 * Carica un file e il suo contenuto sul server Alfresco.<br/>
	 * La posizione di creazione del file viente ricavata dal file di configurazione.
	 * Richiamare questo metodo &egrave; equivalente a richiamare il metodo
	 * {@link #addDocument(File, String) addDocument(file, null)}.
	 * @param file <code>File</code> - il file da aggiungere
	 * @throws Exception in caso di errori di lettura o di caricamento sul server del file
	 * @see #addDocument(File, String)
	 */
	public void addDocument(File file) throws Exception {
		this.addDocument(file, (String)null);
	}
	
	/**
	 * Carica un file e il suo contenuto sul server Alfresco.<br/>
	 * La posizione di creazione del file viente ricavata dal file di configurazione
	 * in base alla tipologia fornita in input al metodo.
	 * Se gi&agrave; esiste un documento di questa tipologia con lo stesso nome del file
	 * fornito in input, il metodo cerca di creare un documento con un nome numerato. Il
	 * massimo numero di tentativi di creazione, quindi di documenti numerati creabili in
	 * questo modo, viene impostato con il metodo {@link #setMaxRenamedDocuments(int)}.
	 * @param file <code>File</code> - il file da aggiungere
	 * @param siteName <code>String</code> - Il site name e' in nome del site in cui si vuole aggiungere 
	 * @return <code>boolean</code> - <code>true</code> se il documento &egrave; stato creato
	 * @throws Exception in caso di errori di lettura o di caricamento sul server del file
	 * oppure se la tipologia in input non esiste nel file di configurazione
	 * @see #setMaxRenamedDocuments(int)
	 */
	public String addDocument(File file, String siteName) throws Exception {
		String uuid="";
		try {
			 uuid = getUUID(siteName);
			this.connect();
		}catch (Exception e1) {
			throw new Exception(e1.getMessage(), e1);
		}
		Reference parentReference = new Reference(STORE, uuid, null);
		ParentReference parent = convertReferenceToParent(parentReference);
		
		String retValue = "";
		try{
			retValue = addDocument(file, parent);
			this.disconnect();
		}
		catch (Exception exp){
			this.disconnect();
			throw new Exception(exp.getMessage(), exp);
		}
		
		return retValue;
	}
	
	/**
	 * Imposta il massimo numero di documenti con lo stesso nome che possono essere
	 * creati.<br/>
	 * Se viene impostato il valore 0, non verrano creati documenti se ne esiste uno con lo
	 * stesso nome.
	 * @param max <code>int</code> - il numero massimo di documenti rinominati da creare
	 * @throws IllegalArgumentException se l'argomento e' minore di 0
	 * @see #addDocument(File, String)
	 */
	private void setMaxRenamedDocuments(int max) throws IllegalArgumentException {
		if (max < 0)
			throw new IllegalArgumentException(
					"Il limite massimo documenti rinominati non puo' essere negativo");
		this.maxRenamedDocuments = max;
	}
	
	/**
	 * Scarica un documento dal server Alfresco in una cartella locale. Se in essa esiste un
	 * file con lo stesso nome del documento richiesto, il contenuto del file viene
	 * sovrascritto.
	 * <p>
	 * L'argomento {@code cartella} non pu&ograve; essere {@code null} o una stringa
	 * vuota e deve rappresentare una cartella. Il path della cartella non deve finire con
	 * "/" o "\". L'argomento {@code documento} deve avere una tipologia presente
	 * nel file di configurazione.
	 * @param cartella {@code File} - La cartella dove scaricare il documento.
	 * @param documento {@code org.alfresco.webserviceclient.entities.Document} - il 
	 * documento da scaricare
	 * @return {@code boolean} - {@code true} se il file &egrave; stato scaricato.
	 * @throws Exception in caso di argomenti non validi, di errori di connessione con il
	 * server o di errori di lettura o scrittura
	 * @see org.alfresco.webserviceclient.entities#Document Document
	 */
	public boolean downloadDocument(File cartella, Document documento)
			throws Exception {
		if (cartella == null || cartella.getPath().equals("") ||
				cartella.getPath().endsWith("\\") || cartella.getPath().endsWith("/"))
			throw new Exception("Cartella non valida");
		String uuid;
		try {
			uuid = getUUID(documento.getType());
		} catch (Exception e1) {
			throw new Exception("Tipologia documento non valida", e1);
		}
		try {
			this.connect();
		} catch (Exception e1) {
			throw new Exception("Errore di connessione", e1);
		}
		String nome = documento.getName();
		byte[] content;
		try {
			Reference space = this.getUUIDReference(uuid);
			Reference documentRef = new Reference(STORE, null, space.getPath() + "/cm:" +
					filterNodeName(nome));
			content = this.getContent(documentRef);
		} catch (Exception e1) {
			this.disconnect();
			throw new Exception("Errore nella lettura del documento", e1);
		}
		this.disconnect();
		if (!cartella.exists()) {
			boolean mkdir = cartella.mkdir();
			if (!mkdir)
				throw new Exception("Creazione della cartella non riuscita");
		}
		File file = new File(cartella.getPath() + "/" + nome);
		FileOutputStream out;
		try {
			out = new FileOutputStream(file);
			out.write(content);
			out.close();
		} catch (FileNotFoundException e) {
			throw new Exception("Creazione del file in locale non riuscita", e);
		}		
		return true;
	}
	
	/**
	 * Restituisce il contenuto di un documento
	 * @param nome
	 * @param siteName
	 * @return byte[]
	 * @throws Exception
	 */
	public byte[] getDocument(String nome,String siteName,String uid)throws Exception {
		String uuid = getUUID(siteName);
		try {
			this.connect();
		} catch (Exception e1) {
			throw new Exception("Errore di connessione", e1);
		}
		byte[] content;
		try {
			Reference space = this.getUUIDReference(uuid);
			Reference documentRef = new Reference(STORE, uid, space.getPath());
			content = this.getContent(documentRef);
		} catch (Exception e1) {
			this.disconnect();
			throw new Exception("Errore nella lettura del documento", e1);
		}
		this.disconnect();
		
		return content;
	}
	
	/**
	 * Restituisce il contenuto di un documento
	 * @param siteName
	 * @return byte[]
	 * @throws Exception
	 */
	public byte[] getDocument(String siteName,String url)throws Exception {
		String uuid = getUUID(siteName);
		try {
			this.connect();
		} catch (Exception e1) {
			throw new Exception("Errore di connessione", e1);
		}
		byte[] content;
		try {
			String uid = url.substring(url.indexOf("SpacesStore")+12,url.lastIndexOf("/"));
			Reference space = this.getUUIDReference(uuid);
			Reference documentRef = new Reference(STORE, uid, space.getPath());
			content = this.getContent(documentRef);
		} catch (Exception e1) {
			this.disconnect();
			throw new Exception("Errore nella lettura del documento", e1);
		}
		this.disconnect();
		
		return content;
	}
	
	/**
	 * Effettua una ricerca dei documenti in archivio in base ad alcuni criteri. La ricerca
	 * viene effettuata tra le tipologie presenti nel file di configurazione.
	 * <p>
	 * L'argomento {@code tipologia} deve essere presente nel file di configurazione. Se non
	 * &egrave; presente, viene utilizzata la tipologia di default definita nel file di
	 * configurazione.
	 * <p>
	 * Se uno dei criteri &egrave; {@code null}, esso viene ignorato nella ricerca.
	 * @param name {@code String} - Il nome di un documento o parte di esso. Il contenuto
	 * della stringa viene trattato come una frase, compresi eventuali spazi.
	 * @param creator {@code String} - Nome o parte del nome di un utente. Il contenuto
	 * della stringa viene trattato come una frase, compresi evenutali spazi.
	 * @param dateFrom {@code Date} - La data di creazione minima dell'intervallo in cui
	 * cercare. L'ora eventualmente contenuta nell'oggetto viene ignorata.
	 * @param dateTo {@code Date} - La data di creazione massima dell'intervallo in cui
	 * cercare. L'ora eventualmente contenuta nell'oggetto viene ignorata.
	 * @param text {@code String} - Il testo da cercare all'interno dei documenti. Il
	 * contenuto della stringa viene trattato come una frase, compresi gli spazi.
	 * @param tipologia {@code String} - La tipologia del documento cercato.
	 * @return {@code Vector<Document>}
	 * @throws Exception in caso di errore di connessione o di lettura o se la tipologia in
	 * input non esiste nel file di configurazione.
	 */
	public Vector<Document> getDocuments(String name, String creator, Date dateFrom,
			Date dateTo, String text, String tipologia) throws Exception {
		HashMap<String, String> types = new HashMap<String, String>();
		if (tipologia != null) {
			// prendo l'uuid della tipologia in input
			String uuid = getUUID(tipologia);
			types.put(uuid, tipologia);
		} else {
			// prendo l'elenco degli uuid delle tipologie
			/*Enumeration<String> keys = ConfigurationProperties.getInstance().getKeys();
			for (String key = keys.nextElement() ;keys.hasMoreElements();){
				if (key.startsWith("t_")) {
					String typeName = key.substring(2);
					String uuid = getUUID(typeName);
					types.put(uuid, typeName);					
				}
				key = keys.nextElement();
			}
			if (types.isEmpty())
				throw new Exception("Non ci sono tipologie nel file di configurazione");
				*/
		}
		String q = "";
		Vector<Document> vector = new Vector<Document>();
		for (String uuid : types.keySet()) {
			// creo la query con i vari argomenti
			q = "+PARENT:\"workspace://SpacesStore/"+ uuid + "\" ";
			q += name != null ? "+" + this.getLuceneProperty("name") + "\\*" + name + "\\* ": "";
			q += creator != null ? "+" + this.getLuceneProperty("creator") + creator + " "
					: "";
			if (dateFrom != null || dateTo != null) {
				q += "+" + this.getLuceneProperty("created") + "[";
				q += dateFrom == null ? "MIN" :
					new SimpleDateFormat("yyyy-MM-dd").format(dateFrom);
				q += " TO ";
				q += dateTo == null ? "MAX" :
					new SimpleDateFormat("yyyy-MM-dd").format(dateTo);
				q += "] ";
			}
			//q += "+TYPE:content";
			logger.debug("Query="+q);
			Query query = new Query(Constants.QUERY_LANG_LUCENE, q);
			// eseguo la query
			//try {
				
			//} catch (Exception e) {
				//throw new Exception("Errore di connessione al server", e);
			//}
			QueryResult res;
			try {
				this.connect();
				res = this.getRepositoryService().query(STORE, query, true);
			} catch (RepositoryFault e) {
				this.disconnect();
				e.printStackTrace();
				throw new Exception("Errore repository", e);
			} catch (RemoteException e) {
				this.disconnect();
				throw new Exception("Eccezione remota", e);
			}
			// creo un result set
			ResultSet result = res.getResultSet();
			// ottengo le varie righe
			ResultSetRow[] rows = result.getRows();
			if (rows != null)
				// ottengo le colonne di ogni riga;
				for (ResultSetRow row : rows) {
					NamedValue[] columns = row.getColumns();
					HashMap<String, String> map = new HashMap<String, String>();
					for (NamedValue column : columns)
						map.put(column.getName().substring(column.getName().indexOf("}") + 1),
								column.getValue());
					// prendo il contenuto del nodo e lo salvo in una stringa
					String content = null;
					if (text != null) {
						content = readContent(map);
					}
					if (text == null || content.contains(text))
						vector.add(new Document(map.get("name"), types.get(uuid),
								map.get("creator"), map.get("created"),map.get("node-uuid")));
				}
			this.disconnect();
		}
		return vector;
	}
	
	private String readContent(HashMap<String, String> map) throws Exception{
		
		Content[] readResult;
		try {
			readResult = this.getContentService().read(new Predicate(
					new Reference[] {new Reference(STORE, map.get(
					"node-uuid"), map.get("path")) }, STORE, null),
					Constants.PROP_CONTENT);
		} catch (ContentFault e) {
			this.disconnect();
			throw new Exception("Content fault", e);
		} catch (RemoteException e) {
			this.disconnect();
			throw new Exception("Eccezione remota", e);
		}
		return ContentUtils.getContentAsString(readResult[0]);
	}
	
	/**
	 * Cerca di creare un documento numerato perch&eacute; gi&agrave; esiste un documento
	 * con lo stesso nome.<br>
	 * Partendo da un documento chiamato "<code>nome.ext</code>" cerca di creare un documento
	 * chiamato "<code>nome x.ext</code>" dove x &egrave; un numero che va da 2 a N+1
	 * (modificabile dal metodo {@link #setMaxRenamedDocuments(int)}, a seconda dei documenti
	 * che sono stati creati in precedenza. Se esistono tutti i documenti numerati da 2 a N+1
	 * non viene creato un nuovo documento e il metodo restituisce <code>null</code>.
	 * @param parent <code>Reference</code> - il reference al nodo parent
	 * @param name <code>String</code> - il nome originale del file, compreso di estensione
	 * @param content <code>byte[]</code> - il contenuto del file
	 * @param mimetype <node>String</code> - il tipo mime del file
	 * @param encoding <code>String</code> - la codifica del file
	 * @return Reference del nodo creato oppure <code>null</code> se non &grave; stato creato
	 * nulla
	 * @see #setMaxRenamedDocuments(int)
	 */
	protected Reference createNumberedDocument(ParentReference parent, String name, byte[] content,
			String mimetype, String encoding) {
		if (this.maxRenamedDocuments == 0)
			return null;
		boolean done = false;
		int i = 1;
		Reference document = null;
		String[] fileName = getNameExtension(name);
		while (!done && i <= this.maxRenamedDocuments) {
			try {
				document = this.createDocument(parent, fileName[0] + " " + (i + 1) + "." +
						fileName[1], content, mimetype, encoding);
				done = true;
			} catch (RuntimeException e) {}
			catch (Exception e) {
				e.printStackTrace();
			}
			i++;
		}
		return document;
	}
	
	/**
	 * Crea un documento su Alfresco.<br/>
	 * Crea un nuovo nodo figlio di parentref con il nome docname, in seguito carica i dati
	 * in content nel nodo impostando mimetype e encoding come formato del contenuto.
	 * @param parentref <code>Reference</code> - la reference del nodo padre del documento da
	 * creare
	 * @param docname <code>String</code> - il nome del documento da creare
	 * @param content <code>byte[]</code> - il contenuto da caricare nel nuovo documento
	 * @param mimetype <code>String</code> - il tipo mime del contenuto
	 * @param encoding <code>String</code> - la codifica del contenuto
	 * @return <code>Reference</code> al nuovo nodo creato
	 * @throws RuntimeException se non &egrave; stato possibile creare il nodo
	 * @throws Exception se non &egrave; stato possibile caricare il contenuto nel nodo. In
	 * questo caso il nodo vuoto appena creato viene eliminato prima di lanciare l'eccezione.
	 */
	protected Reference createDocument(ParentReference parent, String docname, byte[] content,
			String mimetype, String encoding) throws RuntimeException, Exception {
		Reference document = null;
		parent.setChildName(Constants.createQNameString(Constants.NAMESPACE_CONTENT_MODEL,
				filterNodeName(docname)));
		NamedValue[] properties = new NamedValue[]{
				Utils.createNamedValue(Constants.PROP_NAME, docname)};
		CMLCreate create = new CMLCreate("1", parent, null, null, null,
				Constants.TYPE_CONTENT, properties);
		CML cml = new CML();
		cml.setCreate(new CMLCreate[]{create});
		UpdateResult[] results = null;
		try {
			results = getRepositoryService().update(cml);
			document = results[0].getDestination();
		} catch (RepositoryFault e) {
			e.printStackTrace();
			logger.debug("msg="+e.getMessage1());
			if(e.getMessage1().indexOf("DuplicateChildNodeNameException") > 0)
				throw new RuntimeException("Il file gia' esiste", e);
			else
				throw new RuntimeException("Creazione nodo non riuscita", e);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Creazione nodo non riuscita", e);
		}
		ContentFormat format = new ContentFormat(mimetype, encoding);
		try {
			getContentService().write(document, Constants.PROP_CONTENT, content, format);
		} catch (Exception e2) {
			this.deleteNode(document);
			throw new Exception("Caricamento dati non riuscito", e2);
		}
		return document;
	}
	
	/**
	 * Elimina un documento
	 * @param uuid
	 * @throws Exception
	 */
	public void deleteDocument(String uuid)throws Exception {
		this.connect();
		Reference reference = new Reference(STORE, uuid, null);
		try {
			this.deleteNode(reference);
		} catch (Exception e) {			
			throw new Exception("Eliminazione documento non riuscito", e);
		}
	}
	
	/**
	 * Elimina un nodo di Alfresco
	 * @param node <code>Reference</code> - La reference al nodo da eliminare
	 * @throws Exception in caso di errori
	 */
	protected void deleteNode(Reference node) throws Exception {
		CMLDelete delete = new CMLDelete(new Predicate(new Reference[]{node}, null, null));
		CML cml = new CML();
		cml.setDelete(new CMLDelete[]{delete});
		try {
			this.getRepositoryService().update(cml);
		} catch (RepositoryFault e) {
			e.printStackTrace();
			throw new Exception("Errore repository", e);
		} catch (RemoteException e) {
			throw new Exception("Eccezione remota", e);
		}
	}
	
	/**
	 * Avvia la connessione con il server
	 * @throws Exception se la connessione non &egrave; avvenuta
	 */
	private void connect() throws Exception {
		WebServiceFactory.setEndpointAddress(alfrescoWorkSpaceUri);
		try {
			AuthenticationUtils.startSession(alfrescoUser, alfrescoPsw);
		} catch (AuthenticationFault e) {
			throw new Exception("Autenticazione fallita.", e);
		}
		catch (Exception e1) {
			throw new Exception("Impossibile connettersi al server", e1);
		}
	}
	
	/**
	 * Termina la connessione con il server
	 */
	protected void disconnect() {
		AuthenticationUtils.endSession();
	}
	
	/**
	 * Converte un'istanza di <code>Reference</code> in un'istanza di
	 * <code>ParentReference</code>
	 * @param spaceref <code>Reference</code> - La reference da convertire
	 * @return <code>ParentReference</code> - Un'instanza della classe ParentReference che fa
	 * riferimento allo stesso space di spaceref
	 */
	private ParentReference convertReferenceToParent(Reference spaceref) {
		ParentReference parent = new ParentReference();
		parent.setStore(STORE);
		parent.setPath(spaceref.getPath());
		parent.setUuid(spaceref.getUuid());
		parent.setAssociationType(Constants.ASSOC_CONTAINS);
		return parent;
	}
	
	/**
	 * Filtra il nome del nodo per usarlo nelle URL
	 * @param nodeName <code>String</code> - il nome originale del nodo
	 * @return <code>String</code> - il nome convertito
	 */
	protected String filterNodeName(String nodeName) {
		return nodeName.replaceAll(" ", "_");
	}
	
	/**
	 * Restituisce il repository service
	 * @return <code>RepositoryServiceSoapBindingStub</code>
	 */
	protected RepositoryServiceSoapBindingStub getRepositoryService() {
		return WebServiceFactory.getRepositoryService();	
	}
		
	/**
	 * Restituisce il content service
	 * @return <code>ContentServiceSoapBindingStub</code>
	 */
	protected ContentServiceSoapBindingStub getContentService() {
		return WebServiceFactory.getContentService();
	}
	
	/***
	 * Determines the encoding of the specified file.<br/>
	 * If a UTF16 Byte Order Mark (BOM) is found an encoding of "UTF16" is returned. If a UTF8
	 * BOM is found an encoding of "UTF8" is returned. Otherwise the default encoding is
	 * returned.
	 * @param file <code>File</code> - file to be studied
	 * @return <code>String</code> - "UTF8", "UTF16", or default encoding.
	 * @author Eric Bergman - www.ericbt.com
	 */
	protected static String getEncoding(File file) {
		String encoding = System.getProperty("file.encoding");  
		BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(new InputStreamReader(
					new FileInputStream(file)));
			char buffer[] = new char[3];
			int length = bufferedReader.read(buffer);
			if ((length >= 2) && ((buffer[0] == (char) 0xff && buffer[1] == (char) 0xfe) || 
						(buffer[0] == (char) 0xfe && buffer[1] == (char) 0xff)))
					encoding = "UTF16";
			if ((length >= 3) && (buffer[0] == (char) 0xef && buffer[1] == (char) 0xbb &&
						buffer[2] == (char) 0xbf))
					encoding = "UTF8";
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bufferedReader != null)
				try {
					bufferedReader.close();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
		}
		return encoding;
	}
	
	/**
	 * Separa il nome del file dalla sua estensione
	 * @param fileName <code>String</code> - il nome del file completo di estensione
	 * @return <code>String[2]</code> - array[0]=nome file; array[1]=estensione<br/>
	 * Se fileName &egrave <code>null</code>, i due elementi dell'array restituito saranno
	 * stringhe vuote, se fileName non ha un'enstensione, l'elemento array[1] sar&agrave; una
	 * stringa vuota.
	 */
	private static String[] getNameExtension(String fileName) {
		String[] array = new String[]{"", ""};
		String[] split = fileName.split("\\.");
		if (fileName == null || split.length == 0)
			return array;
		if (split.length == 1) {
			array[0] = fileName;
			return array;
		}
		array[0] = split[0];
		for (int i = 1; i < split.length - 1; i++)
			array[0] += "." + split[i];
		array[1] = split[split.length - 1];
		return array;
	}
	
	/**
	 * 
	 * Crea un nuovo space
	 * @param parentref <code>Reference</code> - il reference dello space parent
	 * @param spacename <code>String</code> - il nome del nuovo space
	 * @return <code>Reference</code> - il reference dello space creato
	 * @throws Exception - se non &egrave; stato creato lo space
	 */
	//@SuppressWarnings("unused")
	public Reference createSpace(Reference parentref, String spacename) throws Exception {
		this.connect();
		Reference document = null;
		ParentReference parent = convertReferenceToParent(parentref);
		parent.setChildName(Constants.createQNameString(Constants.NAMESPACE_CONTENT_MODEL,
				filterNodeName(spacename)));
		NamedValue[] properties = new NamedValue[]{
				Utils.createNamedValue(Constants.PROP_NAME, spacename),
				Utils.createNamedValue("{http://www.alfresco.org/model/site/1.0}sitePreset", "site-dashboard"),
				Utils.createNamedValue("{{http://www.alfresco.org/model/site/1.0}siteVisibility", "PUBLIC")};
		CMLCreate create = new CMLCreate("1", parent, null, null, null,
				Constants.TYPE_FOLDER, properties);
		CML cml = new CML();
		cml.setCreate(new CMLCreate[]{create});
		UpdateResult[] results = null;
		try {
			results = getRepositoryService().update(cml);
			logger.debug("ID="+results[0].getSourceId());
			document = results[0].getDestination();
		} catch (Exception e) {
			System.err.println("Creazione space non riuscita");
			throw new RuntimeException("Creazione nodo non riuscita", e);
		}
		
		
		
		/*Reference space = null;
		ParentReference parent = convertReferenceToParent(parentref);
		try {
			space = new Reference(store, null,
					parent.getPath() + "/cm:" + filterNodeName(spacename));
			WebServiceFactory.getRepositoryService().get(new Predicate(
					new Reference[]{space}, store, null));
		} catch (Exception e1) {
			System.out.println("EXC e1: "+e1.getMessage());
			parent.setChildName(Constants.createQNameString(
					Constants.NAMESPACE_CONTENT_MODEL, filterNodeName(spacename)));
			//Set the space's property name
			NamedValue[] properties = new NamedValue[]{Utils.createNamedValue(
					Constants.PROP_NAME, spacename)};
            // Create the space using CML (Content Manipulation Language)
			CMLCreate create = new CMLCreate("1", parent, null, null, null,
					Constants.TYPE_FOLDER, properties);
                        CML cml = new CML();
            cml.setCreate(new CMLCreate[]{create});
            //Execute the CML create statement
            try {
				getRepositoryService().update(cml);
			} catch (Exception e2) {
				System.err.println("Creazione space non riuscita");
				throw e2;
			}
		}*/
		return document;
	}	
	
	/**
	 * Restituisce l'UUID corrispondente ad una tipologia
	 * @param siteName {@code String} - Il nome del site in cui inserire/ricercare un documento
	 * @return String
	 * @throws Exception se nel file di configurazione manca la tipologia di default
	 */
	private String getUUID(String siteName) throws Exception {
		String uuid = "";
		// creo la query con i vari argomenti
		Query query = new Query(Constants.QUERY_LANG_LUCENE, getLuceneProperty("name")+" "+siteName+" ");
        // eseguo la query
		try {
				this.connect();
		} catch (Exception e) {
				throw new Exception("Errore di connessione al server", e);
			}
		RepositoryServiceSoapBindingStub service = this.getRepositoryService();
		QueryResult res;
		try {
				res = service.query(STORE, query, true);
		} catch (RepositoryFault e) {
			this.disconnect();
			e.printStackTrace();
			throw new Exception("Errore repository", e);
		} catch (RemoteException e) {
			this.disconnect();
			throw new Exception("Eccezione remota", e);
		}
			// creo un result set
		ResultSet result = res.getResultSet();
		// ottengo le varie righe
		ResultSetRow[] rows = result.getRows();
		if (rows != null){
			// ottengo le colonne di ogni riga;
			for (ResultSetRow row : rows) {
					NamedValue[] columns = row.getColumns();
					HashMap<String, String> map = new HashMap<String, String>();
					for (NamedValue column : columns)	{
						//logger.debug(column.getName()+" = "+column.getValue());
						map.put(column.getName().substring(column.getName().indexOf("}") + 1),column.getValue());
					}
					// prendo il contenuto del nodo e lo salvo in una stringa
					String uuidSite = map.get("node-uuid");
					String path = map.get("path");
					Reference reference = new Reference(STORE, uuidSite, path);
					QueryResult childrenResult =service.queryChildren(reference);
					ResultSet childResultSet = childrenResult.getResultSet();
		            ResultSetRow[] childRows = childResultSet.getRows();
		            HashMap<String, String> mapChild = new HashMap<String, String>();
		            //logger.debug("childSize = "+childRows.length);
		            for (ResultSetRow childRow : childRows) {
		            	NamedValue[] childColumns = childRow.getColumns();
		            	for (NamedValue childColumn : childColumns){
		            		//logger.debug(childColumn.getName()+" = "+childColumn.getValue());
		            		mapChild.put(childColumn.getName().substring(childColumn.getName().indexOf("}") + 1),childColumn.getValue());
		            	}
		            	if(mapChild.get("name").equals("documentLibrary")){
		            		uuid = mapChild.get("node-uuid");
		            		break;
		            	}
		            }
			}
			this.disconnect();
		}	
		logger.debug("uuid="+uuid);
		return uuid;
	}
	
	/**
	 * Restituisce la tipologia di default
	 * @return String
	 */
	private static String getDefaultType() {
		return "";//ConfigurationProperties.getInstance().getProperty("default_t");
	}
	
	/**
	 * Restituisce la reference al nodo con UUID dato in input.
	 * @param uuid String - L'UUID da cercare
	 * @return Reference - La reference completa del nodo
	 * @throws Exception in caso di errori
	 */
	private Reference getUUIDReference(String uuid) throws Exception {
		Reference[] refs = new Reference[]{new Reference(STORE, uuid, null)};
		Node[] nodes = null;
		try {
			nodes = this.getRepositoryService().get(new Predicate(refs, STORE, null));
		} catch (RepositoryFault e) {
			throw new Exception("Repository Fault", e);
		} catch (RemoteException e) {
			throw new Exception("Eccezione Remota", e);
		}
		return nodes[0].getReference();
	}
	
	/**
	 * Legge il contenuto di un nodo e lo restituisce come array di {@code byte}.
	 * @param node {@code Reference} - La reference al nodo da cui leggere
	 * @return {@code byte[]}
	 * @throws Exception in caso di errori di lettura dal nodo
	 */
	private byte[] getContent(Reference node) throws Exception {
		Content content = null;
		try {
			Content[] read = getContentService().read(new Predicate(new Reference[]{node},
					STORE, null),Constants.PROP_CONTENT);
			content = read[0];
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("errore lettura "+e.getMessage(), e.getCause());
			throw new Exception("Lettura del nodo non riuscita", e);
		}
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		InputStream in = ContentUtils.getContentAsInputStream(content);
		byte[] buffer = new byte[2048];
		int size;
		size = in.read(buffer);
		while (size != -1) {
			out.write(buffer, 0, size);
			size = in.read(buffer);
		}
		return out.toByteArray();
	}
	
	/**
	 * Restituisce il nome completo della propriet&agrave; per creare una query di lucene.
	 * @param name String la propriet&agrave;
	 * @return String
	 */
	private String getLuceneProperty(String name) {
		return "@\\{http\\://www.alfresco.org/model/content/1.0\\}" + name + ":";
	}

	public String getAlfrescoWorkSpaceUri() {
		return alfrescoWorkSpaceUri;
	}

	public void setAlfrescoWorkSpaceUri(String alfrescoWorkSpaceUri) {
		this.alfrescoWorkSpaceUri = alfrescoWorkSpaceUri;
	}

	public String getAlfrescoDownloadUri() {
		return alfrescoDownloadUri;
	}

	public void setAlfrescoDownloadUri(String alfrescoDownloadUri) {
		this.alfrescoDownloadUri = alfrescoDownloadUri;
	}

	public String getAlfrescoUser() {
		return alfrescoUser;
	}

	public void setAlfrescoUser(String alfrescoUser) {
		this.alfrescoUser = alfrescoUser;
	}

	public String getAlfrescoPsw() {
		return alfrescoPsw;
	}

	public void setAlfrescoPsw(String alfrescoPsw) {
		this.alfrescoPsw = alfrescoPsw;
	}
	
	//#SA ADDED####################################
	/**
	 * Crea una folder su Alfresco.<br/>
	 * Crea un nuovo nodo figlio di parentref con il nome docname, in seguito carica i dati
	 * in content nel nodo impostando mimetype e encoding come formato del contenuto.
	 * @param parentref <code>Reference</code> - la reference del nodo padre del documento da
	 * creare
	 * @param docname <code>String</code> - il nome del documento da creare
	 * @param content <code>byte[]</code> - il contenuto da caricare nel nuovo documento
	 * @param mimetype <code>String</code> - il tipo mime del contenuto
	 * @param encoding <code>String</code> - la codifica del contenuto
	 * @return <code>Reference</code> al nuovo nodo creato
	 * @throws RuntimeException se non &egrave; stato possibile creare il nodo
	 * @throws Exception se non &egrave; stato possibile caricare il contenuto nel nodo. In
	 * questo caso il nodo vuoto appena creato viene eliminato prima di lanciare l'eccezione.
	 */
	private ParentReference createFolder(ParentReference parent,String folderId, String folderName) throws RuntimeException, Exception {
		Reference newFolder = null;

		parent.setChildName(Constants.createQNameString(Constants.NAMESPACE_CONTENT_MODEL,
				filterNodeName(folderName)));
		NamedValue[] properties = new NamedValue[]{
				Utils.createNamedValue(Constants.PROP_NAME, folderName)};
		CMLCreate create = new CMLCreate(folderId, parent, null, null, null,
				Constants.TYPE_FOLDER, properties);
		CML cml = new CML();
		cml.setCreate(new CMLCreate[]{create});
		UpdateResult[] results = null;
		try {
			results = getRepositoryService().update(cml);
			newFolder = results[0].getDestination();
		} catch (RepositoryFault e) {
			if(e.getMessage1().indexOf("DuplicateChildNodeNameException") <= 0){
				e.printStackTrace();
				logger.error("msg="+e.getMessage(), e);
				logger.error("msg1="+e.getMessage1(), e);
				throw new RuntimeException("Creazione nodo non riuscita", e);
			}
			else{
				logger.debug("DuplicateChildNodeName: Nodo già presente");
				return new ParentReference(STORE, 
						null, 
						String.format("%s/cm:%s", parent.getPath(), folderName), 
						Constants.ASSOC_CONTAINS, null);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			logger.error("msg="+e.getMessage(), e);
			throw new RuntimeException("Creazione nodo non riuscita", e);
		}
		return convertReferenceToParent(newFolder);
	}
	
	/**
	 * Restituisce un' istanza di ParentReference costruita partendo dall'elenco 
	 * di elementi presenti in elements, di cui il primo coincide con il Site e 
	 * i restanti le folders. L'ordine con cui queste sono presenti nell'array 
	 * coincide con il loro livello di annidamento
	 * 
	 * @param elements
	 * @return
	 */
	private ParentReference translatePath(String[] elements){

		String alfrescoPath = String.format("/app:company_home/st:sites/cm:%s/cm:documentLibrary", elements[0].replace(" ", "_"));

		for (int idx=1; idx<elements.length; idx++){
			alfrescoPath+=String.format("/cm:%s", elements[idx].replace(" ", "_"));
		}
		
		logger.debug(String.format("alfrescoPath: >>%s<<", alfrescoPath));

		return new ParentReference(STORE, null, alfrescoPath, Constants.ASSOC_CONTAINS, null);
	}
	
	/**
	 * Carica un file e il suo contenuto sul server Alfresco.<br/>
	 * La posizione di creazione del file viente ricavata dal file di configurazione
	 * in base alla tipologia fornita in input al metodo.
	 * Se gi&agrave; esiste un documento di questa tipologia con lo stesso nome del file
	 * fornito in input, il metodo cerca di creare un documento con un nome numerato. Il
	 * massimo numero di tentativi di creazione, quindi di documenti numerati creabili in
	 * questo modo, viene impostato con il metodo {@link #setMaxRenamedDocuments(int)}.
	 * @param file <code>File</code> - il file da aggiungere
	 * @param siteName <code>String</code> - Il site name e' in nome del site in cui si vuole aggiungere 
	 * @return <code>boolean</code> - <code>true</code> se il documento &egrave; stato creato
	 * @throws Exception in caso di errori di lettura o di caricamento sul server del file
	 * oppure se la tipologia in input non esiste nel file di configurazione
	 * @see #setMaxRenamedDocuments(int)
	 */
	public String addDocument(File file, String destFolderPath, String parentDelims) throws Exception {
		this.connect();

		String retValue = "";

		String[] elements = destFolderPath.split(parentDelims); 
		if (elements.length == 0)
			throw new Exception("DocumentHandler Exception: Invalid format of destination folder path!");

		ParentReference parentReference = null;
		try {
			parentReference = translatePath(elements);
			retValue = addDocument(file, parentReference);
			this.disconnect();
		} 
		catch (RepositoryFault e1) {
			// TODO Auto-generated catch block
			this.disconnect();
			e1.printStackTrace();
			throw new RepositoryFault();
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			this.disconnect();
			e1.printStackTrace();
			throw new RemoteException();
		}
		catch (Exception e1){
			this.disconnect();
			throw new Exception(e1.getMessage(), e1);
		}

		return retValue;
	}
	
	public void createPath(String path, String delimiter) throws Exception {
		Boolean folderCreatedSuccesfully = true;
		logger.info(String.format("Tryng to create path: %s", path));
		
		this.connect();
		
		String[] elements = path.split(delimiter); 
		if (elements.length == 0)
			throw new Exception("DocumentHandler Exception: Invalid format of folder path!");
		
		ParentReference parentReference = translatePath(new String[]{ elements[0]});
		folderCreatedSuccesfully = (parentReference != null);
		try {
			int folderIdx=1;
			
			while (folderCreatedSuccesfully && (folderIdx<elements.length)){
				parentReference = createFolder(parentReference, elements[folderIdx], elements[folderIdx]);
				folderCreatedSuccesfully = (parentReference != null);
				folderIdx++;
			}
			this.disconnect();
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			logger.error(e1.getMessage(), e1);
			this.disconnect();
			throw new RemoteException();
		}
		catch (Exception e1){
			logger.error(e1.getMessage(), e1);
			this.disconnect();
			throw new Exception(e1.getMessage(), e1);
		}
		
		if (folderCreatedSuccesfully)
			logger.info(String.format("Path: %s created with UUID=%s", path, parentReference.getUuid()));
		else
			throw new Exception(String.format("DocumentHandler Exception: Unable to create new folder %s in Alfresco!", path));
	}
}
