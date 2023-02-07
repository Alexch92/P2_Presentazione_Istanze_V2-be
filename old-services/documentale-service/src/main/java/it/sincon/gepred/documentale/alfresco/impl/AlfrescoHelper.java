package it.sincon.gepred.documentale.alfresco.impl;



import it.sincon.gepred.documentale.alfresco.bean.Document;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;

import jec.httpclient.HttpClient;
import jec.httpclient.HttpException;
import jec.httpclient.methods.GetMethod;
import jec.httpclient.methods.PostMethod;

import org.alfresco.webservice.authentication.AuthenticationFault;
import org.alfresco.webservice.content.Content;
import org.alfresco.webservice.content.ContentFault;
import org.alfresco.webservice.repository.QueryResult;
import org.alfresco.webservice.repository.RepositoryFault;
import org.alfresco.webservice.repository.RepositoryServiceSoapBindingStub;
import org.alfresco.webservice.repository.UpdateResult;
import org.alfresco.webservice.types.CML;
import org.alfresco.webservice.types.CMLCreate;
import org.alfresco.webservice.types.CMLDelete;
import org.alfresco.webservice.types.CMLMove;
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
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AlfrescoHelper {
	protected String alfrescoWorkSpaceUri;
	protected String alfrescoUri;
	protected String alfrescoUser;
	protected String alfrescoPsw;

	protected Logger log = LoggerFactory.getLogger(AlfrescoHelper.class);

	protected static final String HEADER_CONTENT_TYPE = "Content-Type";
	protected static final String CONTENT_TYPE_JSON = "application/json";
	protected static final Store STORE = new Store(Constants.WORKSPACE_STORE, "SpacesStore");

	public String getAlfrescoWorkSpaceUri() {
		return alfrescoWorkSpaceUri;
	}

	public void setAlfrescoWorkSpaceUri(String alfrescoWorkSpaceUri) {
		this.alfrescoWorkSpaceUri = alfrescoWorkSpaceUri;
	}

	public String getAlfrescoUri() {
		return alfrescoUri;
	}

	public void setAlfrescoUri(String alfrescoUri) {
		this.alfrescoUri = alfrescoUri;
	}

	public void setAlfrescoUser(String alfrescoUser) {
		this.alfrescoUser = alfrescoUser;
	}

	public void setAlfrescoPsw(String alfrescoPsw) {
		this.alfrescoPsw = alfrescoPsw;
	}

	/**
	 * Avvia la connessione con il server
	 * @throws Exception se la connessione non &egrave; avvenuta
	 */
	protected void connect() throws Exception {
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
	 * Filtra il nome del nodo per usarlo nelle URL
	 * @param nodeName <code>String</code> - il nome originale del nodo
	 * @return <code>String</code> - il nome convertito
	 */
	private String filterNodeName(String nodeName) {
		
		nodeName = nodeName.replaceAll(" ", "_");
		nodeName = nodeName.replaceAll("'", "_");
		
		return nodeName;
	}

	/**
	 * Separa il nome del file dalla sua estensione
	 * @param fileName <code>String</code> - il nome del file completo di estensione
	 * @return <code>String[2]</code> - array[0]=nome file; array[1]=estensione<br/>
	 * Se fileName &egrave <code>null</code>, i due elementi dell'array restituito saranno
	 * stringhe vuote, se fileName non ha un'enstensione, l'elemento array[1] sar&agrave; una
	 * stringa vuota.
	 */
	private String[] getNameExtension(String fileName) {
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
	 * Elimina un nodo di Alfresco
	 * @param node <code>Reference</code> - La reference al nodo da eliminare
	 * @throws Exception in caso di errori
	 */
	protected void deleteNode(Reference node) throws Exception {
		CMLDelete delete = new CMLDelete(new Predicate(new Reference[]{node}, null, null));
		CML cml = new CML();
		cml.setDelete(new CMLDelete[]{delete});
		try {
			WebServiceFactory.getRepositoryService().update(cml);
		} catch (RepositoryFault e) {
			e.printStackTrace();
			throw new Exception("Errore repository", e);
		} catch (RemoteException e) {
			throw new Exception("Eccezione remota", e);
		}
	}
	
	/**
	 * Sposta un nodo di Alfresco
	 * @param node <code>Reference</code> - La reference al nodo da eliminare
	 * @throws Exception in caso di errori
	 */
	protected void moveNode(Reference node, String uuidDestContenitore) throws Exception {
		
		try {
			
			String nome = WebServiceFactory.getRepositoryService().get(new Predicate(new Reference[]{node}, STORE, null))[0].getProperties(0).getValue();
			System.out.println("file da spostare: "+nome);
			//System.out.println("Sposto il file da: "+where.getUuid()+" a: "+uuidDestContenitore);
//			CMLMove move = new CMLMove(
//					new ParentReference(STORE, uuidDestContenitore, null, Constants.ASSOC_CONTAINS, null)
//					, 
//					uuidDestContenitore, 
//					Constants.ASSOC_CONTAINS, 
//					nome, 
//					new Predicate(new Reference[]{node}, null, null), 
//					node.getUuid());
			
			ParentReference parentDest = new ParentReference(STORE, uuidDestContenitore, null, Constants.ASSOC_CONTAINS, null);
			parentDest.setChildName(Constants.createQNameString(Constants.NAMESPACE_CONTENT_MODEL, nome));
			 
			//System.out.println("Sposto il file da: "+where.getUuid()+" a: "+uuidDestContenitore);
			CMLMove move = new CMLMove();
			move.setTo(parentDest);
			move.setWhere(new Predicate(new Reference[]{node},STORE,null));	
			
			CML cml = new CML();
			cml.setMove(new CMLMove[]{move});

			WebServiceFactory.getRepositoryService().update(cml);
		} catch (RepositoryFault e) {
			e.printStackTrace();
			throw new Exception("Errore repository", e);
		} catch (RemoteException e) {
			throw new Exception("Eccezione remota", e);
		}
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
	private Reference createDocument(ParentReference parent, String docname, byte[] content,
			String mimetype, String encoding) throws RuntimeException, Exception {
		Reference document = null;
		parent.setChildName(Constants.createQNameString(Constants.NAMESPACE_CONTENT_MODEL, filterNodeName(docname)));
		NamedValue[] properties = new NamedValue[]{
				Utils.createNamedValue(Constants.PROP_NAME, docname)};
		CMLCreate create = new CMLCreate("1", parent, null, null, null,
				Constants.TYPE_CONTENT, properties);
		CML cml = new CML();
		cml.setCreate(new CMLCreate[]{create});
		UpdateResult[] results = null;
		try {
			results = WebServiceFactory.getRepositoryService().update(cml);
			document = results[0].getDestination();
		} catch (RepositoryFault e) {
			e.printStackTrace();
			log.debug("msg="+e.getMessage1());
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
			WebServiceFactory.getContentService().write(document, Constants.PROP_CONTENT, content, format);
		} catch (Exception e2) {
			this.deleteNode(document);
			throw new Exception("Caricamento dati non riuscito", e2);
		}
		return document;
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
	private Reference createNumberedDocument(ParentReference parent, String name, byte[] content,
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
	 * @see #setMaxRenamedDocuments(int)
	 */
	private int maxRenamedDocuments = 20;

	protected String addDocument(ParentReference parent, String fileName, byte[] content, String mimetype, String encoding) throws Exception {
		Reference document = null;
		try {
			document = this.createDocument(parent, fileName, content, mimetype,encoding);
		} catch (RuntimeException e) {
			e.printStackTrace();
			log.error("ERRORE :"+e.getMessage());
			// in questo caso esiste un file con lo stesso nome
			if(e.getMessage().equals("Il file gia' esiste")){
				document = this.createNumberedDocument(parent, fileName, content, mimetype, encoding);
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
		log.info(String.format("Caricamento contenuto file eseguito con successo. UUID=%s", document.getUuid()));
		return document.getUuid();
	}

	/**
	 * Metodo che crea un Site
	 * @param url
	 * @param ticket
	 * @param shortName
	 * @param title
	 * @param description
	 * @param isPublic
	 * @return boolean
	 * @throws Exception 
	 */
	protected Boolean createSite(String url, String ticket, String shortName, String title, String description, boolean isPublic) throws Exception
	{
		HttpClient httpClient = new HttpClient();
		boolean siteCreated = false;
		PostMethod createSiteMethod = null;
		try
		{
			//AuthenticationUtils.startSession(userName, password);
			//String ticket = AuthenticationUtils.getTicket();

			//Get a JSON string with the site details.
			String createSiteBody = getSiteBody(shortName, title, description, isPublic);

			//Create post method
			createSiteMethod = createPostMethod(url+"/s/api/sites?alf_ticket=" + ticket, createSiteBody, CONTENT_TYPE_JSON);

			if (log.isDebugEnabled()) log.debug("Trying to create site with name: " + shortName + ". URL: " + createSiteMethod.getURI());

			//Execute the post method
			int createSiteStatus = httpClient.executeMethod(createSiteMethod);

			//createSiteMethod.getResponseBody();
			if (log.isDebugEnabled()) log.debug("Create site method returned status: " + createSiteStatus);
			if(createSiteStatus == 200)
			{
				// create title sites component
				siteCreated = createComponent(url, httpClient, shortName, ticket, "title", "title/collaboration-title");

				// create navigation sites component
				siteCreated = createComponent(url, httpClient, shortName, ticket, "navigation", "navigation/collaboration-navigation");

				// create component-1-1 sites component
				siteCreated = createComponent(url, httpClient, shortName, ticket, "component-1-1", "dashlets/site-welcome");

				// create component-2-1 sites component
				siteCreated = createComponent(url, httpClient, shortName, ticket, "component-2-1", "dashlets/docsummary");

				// create component-2-2 sites component
				siteCreated = createComponent(url, httpClient, shortName, ticket, "component-2-2", "dashlets/activityfeed");

				// create component-3-1 sites component
				siteCreated = createComponent(url, httpClient, shortName, ticket, "component-3-1", "dashlets/site-profile");

				// create component-3-2 sites component
				siteCreated = createComponent(url, httpClient, shortName, ticket, "component-3-2", "dashlets/colleagues");

				// create component-3-3 sites component
				siteCreated = createComponent(url, httpClient, shortName, ticket, "component-3-3", "dashlets/site-links");

				// create documetnLibrary folder
				siteCreated = createDocumentLibrary(url, httpClient, shortName, ticket);

				// create sites dashboard
				siteCreated = createSiteDashboard(url, httpClient, shortName, ticket);

				// create links folder
				siteCreated = createLinks(url, httpClient, shortName, ticket);
			}

		}
		catch (HttpException he)
		{
			if (log.isDebugEnabled()) log.debug("Fail to create site with name: " + shortName + ". Message: " + he.getMessage());
			throw new RuntimeException(he);
		}
		catch (AuthenticationFault ae)
		{
			if (log.isDebugEnabled()) log.debug("Fail to create site with name: " + shortName + ". Message: " + ae.getMessage());
			throw new RuntimeException(ae);
		}
		catch (IOException ioe)
		{
			if (log.isDebugEnabled()) log.debug("Fail to create site with name: " + shortName + ". Message: " + ioe.getMessage());
			throw new RuntimeException(ioe);
		}
		catch (JSONException je)
		{
			if (log.isDebugEnabled()) log.debug("Fail to create site with name: " + shortName + ". Message: " + je.getMessage());
			throw new RuntimeException(je);
		}
		finally
		{
			createSiteMethod.releaseConnection();
		}

		return siteCreated;
	}

	/**
	 * Metodo che restituisce l'oggeto site json come stringa
	 * @param shortName
	 * @param title
	 * @param description
	 * @param isPublic
	 * @return String
	 * @throws JSONException
	 */
	private String getSiteBody(String shortName, String title, String description, boolean isPublic) throws JSONException
	{
		JSONObject site = new JSONObject();
		site.put("sitePreset", "site-dashboard");
		site.put("shortName", shortName);
		site.put("title", title);
		site.put("description", description);
		if(isPublic)
			site.put("visibility", "PUBLIC");
		else
			site.put("visibility", "PRIVATE");
		//site.put("alf_ticket", getTicket());
		return site.toString();
	}

	/**
	 * Metodo che crea un component
	 * @param url
	 * @param httpClient
	 * @param siteName
	 * @param ticket
	 * @param componentName
	 * @param componentURL
	 * @return boolean
	 */
	private boolean createComponent(String url, HttpClient httpClient, String siteName, String ticket, String componentName, String componentURL)
	{
		boolean componentCreated = false;
		String compUrl = url+"/s/remotestore/create/alfresco/site-data/components/page." + componentName + ".site~" + siteName
				+ "~dashboard.xml?s=sitestore&alf_ticket=" + ticket;

		String body = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
				"<component>\n" +
				"<guid>page." + componentName + ".site~" + siteName + "~dashboard</guid>\n" +
				"<scope>page</scope>\n" +
				"<region-id>" + componentName + "</region-id>\n" +
				"<source-id>site/" + siteName + "/dashboard</source-id>\n" +
				"<url>/components/" + componentURL + "</url>\n" +
				"</component>";

		PostMethod postMethod = null;
		try
		{
			postMethod = createPostMethod(compUrl, body, "application/octet-stream");
			if (log.isDebugEnabled()) log.debug("Trying to create site component with name: " + componentName + ". URL: " + postMethod.getURI());

			int status = httpClient.executeMethod(postMethod);
			//postMethod.getResponseBody();
			if(status == 200)
				componentCreated = true;
			if (log.isDebugEnabled()) log.debug("Create component with name: " + componentName + ". Method returned status: " + status);
		}
		catch (Exception e)
		{
			if (log.isDebugEnabled()) log.debug("Fail to create site component with name: " + componentName + ". Message: " + e.getMessage());
			throw new RuntimeException(e);
		}
		finally
		{
			postMethod.releaseConnection();
		}
		return componentCreated;
	}

	/**
	 * Creates POST method
	 *
	 * @param url URL for request
	 * @param body body of request
	 * @param contentType content type of request
	 * @return POST method
	 * @throws UnsupportedEncodingException
	 */
	private PostMethod createPostMethod(String url, String body, String contentType) throws UnsupportedEncodingException
	{
		PostMethod postMethod = new PostMethod(url);
		postMethod.setRequestHeader(HEADER_CONTENT_TYPE, contentType);
		postMethod.setRequestBody(body);
		//postMethod.setRequestEntity(new StringRequestEntity(body, CONTENT_TYPE_TEXT_PLAIN, UTF_8));

		return postMethod;
	}

	/**
	 * Creates documentLibrary folder in site
	 *
	 * @param httpClient HTTP client
	 * @param siteName short name of site
	 * @param user current user
	 */
	private boolean createDocumentLibrary(String url, HttpClient httpClient, String siteName, String ticket)
	{
		boolean docLibCreated = false;
		GetMethod createDocumentLibraryFolderMethod = createGetMethod(url+"/s/slingshot/doclib/doclist/documents/site/" + siteName
				+ "/documentLibrary?filter=recentlyModified&max=10&alf_ticket=" + ticket);
		try
		{
			if (log.isDebugEnabled()) log.debug("Trying to create sites documentLibrary folder. URL: " + createDocumentLibraryFolderMethod.getURI());

			int status = httpClient.executeMethod(createDocumentLibraryFolderMethod);
			createDocumentLibraryFolderMethod.getResponseBody();
			if(status == 200)
				docLibCreated = true;
			if (log.isDebugEnabled()) log.debug("Create sites documentLibrary folder method returned status: " + status);
		}
		catch (Exception e)
		{
			if (log.isDebugEnabled()) log.debug("Fail to create sites documentLibrary folder. Message: " + e.getMessage());
			throw new RuntimeException(e);
		}
		finally
		{
			createDocumentLibraryFolderMethod.releaseConnection();
		}
		return docLibCreated;
	}

	/**
	 * Creates GET method
	 *
	 * @param url URL for request
	 * @return GET method
	 */
	private GetMethod createGetMethod(String url)
	{
		GetMethod getMethod = new GetMethod(url);
		return getMethod;
	}

	/**
	 * Creates site dashboard
	 *
	 * @param httpClient HTTP client
	 * @param siteName name of the site
	 * @param user current user
	 * @throws UnsupportedEncodingException
	 */
	private boolean createSiteDashboard(String url, HttpClient httpClient, String siteName, String ticket) throws UnsupportedEncodingException
	{
		boolean dashboardCreated = false;
		String createSiteDashboardBody = "";
		createSiteDashboardBody = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
				"<page>\n" +
				"<title>Collaboration Site Dashboard</title>\n" +
				"<title-id>page.collaboration_site.title</title-id>\n" +
				"<description>Collaboration Site dashboard page</description>\n" +
				"<description-id>page.collaboration_site.description</description-id>\n" +
				"<template-instance>dashboard-3-columns</template-instance>\n" +
				"<authentication>user</authentication>\n" +
				"<properties>\n" +
				"<sitePages>" +
				"["+
				"{\"pageId\":\"wiki-page\"}," +
				"{\"pageId\":\"blog-postlist\"}," +
				"{\"pageId\":\"documentlibrary\"}," +
				"{\"pageId\":\"calendar\"}," +
				"{\"pageId\":\"links\"}," +
				"{\"pageId\":\"discussions-topiclist\"}," +
				"{\"pageId\":\"data-lists\"}," +
				"]" +
				"</sitePages>\n" +
				"</properties>\n" +
				"</page>";

		PostMethod createSiteDashboardMethod = createPostMethod(url+"/s/remotestore/create/alfresco/site-data/pages/site/" + siteName
				+ "/dashboard.xml?s=sitestore&alf_ticket=" + ticket, createSiteDashboardBody, "application/octet-stream");
		try
		{
			if (log.isDebugEnabled()) log.debug("Trying to create site dashboard. URL: " + createSiteDashboardMethod.getURI());

			int status = httpClient.executeMethod(createSiteDashboardMethod);
			createSiteDashboardMethod.getResponseBody();
			if(status == 200)
				dashboardCreated = true;
			if (log.isDebugEnabled()) log.debug("Create site dashboard method returned status: " + status);
		}
		catch (Exception e)
		{
			if (log.isDebugEnabled()) log.debug("Fail to create site dashboard. Message: " + e.getMessage());
			throw new RuntimeException(e);
		}
		finally
		{
			createSiteDashboardMethod.releaseConnection();
		}
		return dashboardCreated;
	}

	/**
	 * Creates links folder in site
	 *
	 * @param httpClient HTTP client
	 * @param siteName short name of site
	 * @param user current user
	 */
	private boolean createLinks(String url, HttpClient httpClient, String siteName, String ticket)
	{
		boolean linksCreated = false;
		GetMethod createLinksFolderMethod = createGetMethod(url+"/s/api/links/site/" + siteName + "/links?page=1&pageSize=512&alf_ticket="
				+ ticket);
		try
		{
			if (log.isDebugEnabled()) log.debug("Trying to create site links folder. URL: " + createLinksFolderMethod.getURI());

			int status = httpClient.executeMethod(createLinksFolderMethod);
			createLinksFolderMethod.getResponseBody();
			if(status == 200)
				linksCreated = true;
			if (log.isDebugEnabled()) log.debug("Create site links folder method returned status: " + status);
		}
		catch (Exception e)
		{
			if (log.isDebugEnabled()) log.debug("Fail to create site links folder. Message: " + e.getMessage());
			throw new RuntimeException(e);
		}
		finally
		{
			createLinksFolderMethod.releaseConnection();
		}
		return linksCreated;
	}

	/**
	 * Restituisce il nome completo della propriet&agrave; per creare una query di lucene.
	 * @param name String la propriet&agrave;
	 * @return String
	 */
	private String getLuceneProperty(String name) {
		return "@\\{http\\://www.alfresco.org/model/content/1.0\\}" + name + ":";
	}
	/**
	 * Restituisce l'UUID corrispondente ad una tipologia
	 * @param siteName {@code String} - Il nome del site in cui inserire/ricercare un documento
	 * @return String
	 * @throws Exception se nel file di configurazione manca la tipologia di default
	 */
	protected String getUUID(String siteName) throws Exception {
		String uuid = "";
		// creo la query con i vari argomenti
		Query query = new Query(Constants.QUERY_LANG_LUCENE, getLuceneProperty("name")+" "+siteName+" ");
		// eseguo la query
		try {
			this.connect();
		} catch (Exception e) {
			throw new Exception("Errore di connessione al server", e);
		}
		RepositoryServiceSoapBindingStub service =  WebServiceFactory.getRepositoryService();
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
					//log.debug(column.getName()+" = "+column.getValue());
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
				//log.debug("childSize = "+childRows.length);
				for (ResultSetRow childRow : childRows) {
					NamedValue[] childColumns = childRow.getColumns();
					for (NamedValue childColumn : childColumns){
						//log.debug(childColumn.getName()+" = "+childColumn.getValue());
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
		log.debug("uuid="+uuid);

		if (uuid.length()==0)
			throw new Exception(String.format("Sito >>%s<< non trovato!!", siteName));

		return uuid;
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

		String alfrescoPath = String.format("/app:company_home/st:sites/cm:%s/cm:documentLibrary", filterNodeName(elements[0]));

		for (int idx=1; idx<elements.length; idx++){
			alfrescoPath+=String.format("/cm:%s", filterNodeName(elements[idx]));
		}

		log.debug(String.format("alfrescoPath: >>%s<<", alfrescoPath));

		ParentReference result = new ParentReference(STORE, null, alfrescoPath, Constants.ASSOC_CONTAINS, null);
		return result;
	}
	
	protected Reference getParent(Reference space) throws Exception
	{	
			QueryResult result = WebServiceFactory.getRepositoryService().queryParents(space);
			ResultSet resultset = result.getResultSet();
			
			String first_parent_id = resultset.getRows(0).getNode().getId();
			
			System.out.println("The queried parent id is: " + first_parent_id);
			
			Reference parent = new Reference(STORE, first_parent_id, null);
			
			return parent;
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

		log.debug(String.format("Parent :%s, folderId :%s, folderName :%s",
				parent.getPath(), folderId, folderName));
		
		parent.setChildName(Constants.createQNameString(Constants.NAMESPACE_CONTENT_MODEL,folderId));
		NamedValue[] properties = new NamedValue[]{
				Utils.createNamedValue(Constants.PROP_NAME, folderName)};
		CMLCreate create = new CMLCreate(folderId, parent, null, null, null,
				Constants.TYPE_FOLDER, properties);
		CML cml = new CML();
		cml.setCreate(new CMLCreate[]{create});
		UpdateResult[] results = null;
		try {
			results = WebServiceFactory.getRepositoryService().update(cml);
			newFolder = results[0].getDestination();
		} catch (RepositoryFault e) {
			if(e.getMessage1().indexOf("DuplicateChildNodeNameException") <= 0){
				e.printStackTrace();
				log.error("msg="+e.getMessage(), e);
				log.error("msg1="+e.getMessage1(), e);
				throw new RuntimeException("Creazione nodo non riuscita", e);
			}
			else{
				log.debug("DuplicateChildNodeName: Nodo già presente");
				return new ParentReference(STORE, 
						null, 
						String.format("%s/cm:%s", parent.getPath(), folderId), 
						Constants.ASSOC_CONTAINS, null);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			log.error("msg="+e.getMessage(), e);
			throw new RuntimeException("Creazione nodo non riuscita", e);
		}
		return convertReferenceToParent(newFolder);
	}

	protected String createPath(String path, String delimiter) throws Exception {
		Boolean folderCreatedSuccesfully = true;
		log.info(String.format("Tryng to create path: %s", path));

		this.connect();

		String[] elements = path.split(delimiter); 
		if (elements.length == 0)
			throw new Exception("AlfrescoHelper Exception: Invalid format of folder path!");

		ParentReference parentReference = translatePath(new String[]{ filterNodeName(elements[0]) });
		folderCreatedSuccesfully = (parentReference != null);
		try {
			int folderIdx=1;

			while (folderCreatedSuccesfully && (folderIdx<elements.length)){
				parentReference = createFolder(parentReference, filterNodeName(elements[folderIdx]), elements[folderIdx]);
				folderCreatedSuccesfully = (parentReference != null);
				folderIdx++;
			}
			this.disconnect();
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			log.error(e1.getMessage(), e1);
			this.disconnect();
			throw new RemoteException();
		}
		catch (Exception e1){
			log.error(e1.getMessage(), e1);
			this.disconnect();
			throw new Exception(e1.getMessage(), e1);
		}

		if (folderCreatedSuccesfully){
			log.info(String.format("Path: %s created with UUID=%s", path, parentReference.getUuid()));
			return parentReference.getUuid();
		}
		else
			throw new Exception(String.format("DocumentHandler Exception: Unable to create new folder %s in Alfresco!", path));
	}

	/**
	 * Legge il contenuto di un nodo e lo restituisce come array di {@code byte}.
	 * @param node {@code Reference} - La reference al nodo da cui leggere
	 * @return {@code byte[]}
	 * @throws Exception in caso di errori di lettura dal nodo
	 */
	protected byte[] getContent(Reference node) throws Exception {
		Content content = null;

		try {
			Content[] read = WebServiceFactory.getContentService().read(new Predicate(new Reference[]{node},
					STORE, null),Constants.PROP_CONTENT);
			content = read[0];
		} catch (Exception e) {
			e.printStackTrace();
			log.error("errore lettura "+e.getMessage(), e.getCause());
			throw new Exception("Lettura del nodo non riuscita", e);
		}
		log.debug(String.format("content.getUrl()=%s",content.getUrl()));
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
	 * Restituisce la reference al nodo con UUID dato in input.
	 * @param uuid String - L'UUID da cercare
	 * @return Reference - La reference completa del nodo
	 * @throws Exception in caso di errori
	 */
	protected Reference getUUIDReference(String uuid) throws Exception {
		Reference[] refs = new Reference[]{new Reference(STORE, uuid, null)};
		Node[] nodes = null;
		try {
			nodes = WebServiceFactory.getRepositoryService().get(new Predicate(refs, STORE, null));
		} catch (RepositoryFault e) {
			throw new Exception("Repository Fault", e);
		} catch (RemoteException e) {
			throw new Exception("Eccezione Remota", e);
		}
		return nodes[0].getReference();
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
	protected Vector<Document> getDocuments(String name, String creator, Date dateFrom,
			Date dateTo, String text, String uuid) throws Exception {

		String q = "";
		Vector<Document> vector = new Vector<Document>();

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
		log.debug("Query="+q);
		Query query = new Query(Constants.QUERY_LANG_LUCENE, q);
		// eseguo la query
		//try {

		//} catch (Exception e) {
		//throw new Exception("Errore di connessione al server", e);
		//}
		QueryResult res;
		try {
			this.connect();
			res = WebServiceFactory.getRepositoryService().query(STORE, query, true);
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
				if (text == null || content.contains(text)){
					String nodeContent = null;
					if (map.containsKey("content")){
						nodeContent = map.get("content");
					}
					if (nodeContent != null)
						log.debug(String.format("Nodo: %s - NodeContent : %s", map.get("node-uuid"), nodeContent));
					else
						log.debug(String.format("Nodo: %s - NodeContent : IS NULL", map.get("node-uuid")));
					
					vector.add(new Document(map.get("name"), 
							uuid,
							map.get("creator"), 
							map.get("created"),
							map.get("node-uuid"),
							nodeContent));
				}
			}
		this.disconnect();

		return vector;
	}
	
private String readContent(HashMap<String, String> map) throws Exception{
		
		Content[] readResult;
		try {
			readResult = WebServiceFactory.getContentService().read(new Predicate(
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

protected String searchSite(String shortName)throws RemoteException, RepositoryFault{
	log.debug("START-searchSite: ");		
	// Get a reference to the respository web service
    RepositoryServiceSoapBindingStub repositoryService = WebServiceFactory.getRepositoryService();         
    
    // Create a query object, looking for all items with alfresco in the name of text
    Query query = new Query(Constants.QUERY_LANG_LUCENE, getLuceneProperty("name")+" "+shortName+" ");
    
    // Execute the query
    QueryResult queryResult = repositoryService.query(STORE, query, false);
    // Display the results
    ResultSet resultSet = queryResult.getResultSet();
    ResultSetRow[] rows = resultSet.getRows();
    if (rows == null)
    {
        log.debug("No query results found with name: "+shortName);
        return null;
    }
    else
    {
    	for(int i=0; i < rows.length ; i++)
    		for(int j=0; j < rows[i].getColumns().length; j++)
    			log.debug("Results: "+rows[i].getColumns(j).getName()+"="+rows[i].getColumns(j).getValue());
    	
    	String uuid = rows[0].getColumns(7).getValue();
    	return uuid;
    }
    
}
}
