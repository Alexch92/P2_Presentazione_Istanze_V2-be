package it.osapulie.web.portlet.util;

import it.osapulie.domain.ProfiloUtente;
import it.osapulie.domain.dto.UserInfo;
import it.osapulie.infrastructure.security.OSApulieUserDetails;
import it.osapulie.shared.service.UserPreferences;
import it.sincon.gepred.domain.pratica.Pratica;
import it.sincon.gepred.domain.pratica.PraticaWeb;

import java.io.InputStream;
import java.io.OutputStream;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.PortletSession;
import javax.portlet.ResourceResponse;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletURL;

import org.springframework.beans.BeansException;

import java.util.Map;

import com.liferay.portal.model.User;

public interface PortletHelper {

	void sendStream(InputStream sourceStream, ResourceResponse response, String mimeType);

	void sendStream(byte[] bytes, ResourceResponse response, String mimeType);

	/**
	 * Serve a {@link ResourceResponse} by setting the attachment response header so that clients
	 * will know the file name to save the file as.
	 * 
	 * @param bytes the content bytes
	 * @param response the portlet's {@link ResourceResponse}
	 * @param attachmentName the filename for the attachment content (i.e., "sample.pdf")
	 * @param mimeType the mime type
	 */
	void sendStreamAsAttachment(byte[] bytes, ResourceResponse response, String attachmentName, String mimeType);

	/**
	 * Copy a stream from an input source to an output destination.
	 * 
	 * @param sourceStream
	 * @param destination
	 */
	void copyStream(InputStream sourceStream, OutputStream destination);

	/**
	 * Questo metodo incapsula un workaround perchè durante il post alcuni ID sono duplicati e
	 * questo non piace a Spring MVC: quindi dobbiamo leggerli noi dalla request e in qualche modo
	 * aggirare il problema.
	 * 
	 * @param parmName il nome del parametro nella request
	 * @param request la portlet request
	 * @return il valore del parametro
	 */
	Long getLongParam(String parmName, PortletRequest request);

	/**
	 * Recupera le informazioni riguardo l'utente corrente.
	 * 
	 * @param request la {@link PortletRequest} corrente
	 * @return
	 */
	UserInfo getUserInfo(PortletRequest request);

	/**
	 * Ottiene il nome della pagina. Ad esempio, se la URL del portale è <code><pre>
	 * http://localhost
	 * :8080//en/web/guest/opere?p_p_id=audio_WAR_mbifrontendportlet&p_p_lifecycle=2&
	 * p_p_state=normal ... altri parametri ... </pre></code> ritorna <code><pre> opere
	 * </pre></code>
	 * 
	 * @param request
	 * @return il nome della pagina
	 */
	String getCurrentPageName(PortletRequest request);
	
	/**
	 * Costruisce una portlet url per effettuare la redirezione verso una pagina esterna
	 * @param request
	 * @param response
	 * @param portletName
	 * @param portletParams
	 * @return
	 */
	public PortletURL createPortletUrlToExternalPortlet(PortletRequest request,PortletResponse response,String portletName,Map<String,String> portletParams,String portletPhase);

	/**
	 * Recupera l'utente corrente.
	 * 
	 * @return
	 */
	OSApulieUserDetails getOsApulieUserDetails();

	public ProfiloUtente getProfiloUtente(PortletSession session);

	/**
	 * Recupera le user preferences dalla sessione http.
	 * 
	 * @param portletRequest
	 * @return
	 */
	public UserPreferences getUserPreferences(PortletRequest portletRequest);
	
	/**
	 * Recupera gli oggetti in sessione
	 * @param portletRequest
	 * @param nome
	 * @return Object
	 */
	public Object getEntityFromSession(PortletRequest portletRequest,String nome);
	
	/**
	 * Mette gli oggetti in sessione
	 * @param portletRequest
	 * @param nome
	 */
	public void setEntityInSession(PortletRequest portletRequest,String nome,Object entity);

	/**
	 * Controlla che lo user appartenga al ruolo specificato.
	 * 
	 * @param liferayUser
	 * @param roleString
	 * @return
	 */
	public boolean userHasRole(User liferayUser, String roleString);
	public boolean userHasService(OSApulieUserDetails osApulieUserDetails, String serviceString);
	public boolean userHasPermissionInsert(OSApulieUserDetails osApulieUserDetails);
	public boolean userHasPermissionReadAll(OSApulieUserDetails osApulieUserDetails);
	public boolean userHasPermissionEditAll(OSApulieUserDetails osApulieUserDetails);
	public boolean userHasPermissionReadOwn(OSApulieUserDetails osApulieUserDetails);
	public boolean userHasPermissionEditOwn(OSApulieUserDetails osApulieUserDetails);
	//public boolean userHasPermissionEditPratica(OSApulieUserDetails osApulieUserDetails,Pratica pratica);
	public boolean userHasPermissionPratica(OSApulieUserDetails osApulieUserDetails,Pratica pratica);
	
	public Map<Long,Boolean> userHasPermissionTabPratica(OSApulieUserDetails osApulieUserDetails,Pratica pratica);
	
	public Map<Long,Boolean> userHasPermissionReadPratica(Pratica pratica);
	
	public void copyProperties(Object source, Object target, Class<?> editable, String[] ignoreProperties)throws BeansException;

	public Map<Long, Boolean> userHasPermissionTabPraticaWeb(OSApulieUserDetails osApulieUserDetails, PraticaWeb praticaWeb);

	String getPortletId(PortletRequest request);
}
