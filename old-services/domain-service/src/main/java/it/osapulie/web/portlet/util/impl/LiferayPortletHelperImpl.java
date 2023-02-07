package it.osapulie.web.portlet.util.impl;

import it.osapulie.domain.Permesso;
import it.osapulie.domain.ProfiloUtente;
import it.osapulie.domain.Ruolo;
import it.osapulie.domain.dto.UserInfo;
import it.osapulie.domain.servizi.Servizio;
import it.osapulie.infrastructure.impl.DateUtils;
import it.osapulie.infrastructure.security.OSApuliePortletPreAuthenticatedDetails;
import it.osapulie.infrastructure.security.OSApulieUserDetails;
import it.osapulie.shared.service.UserPreferences;
import it.osapulie.web.WebLayerException;
import it.osapulie.web.portlet.util.PortletHelper;
import it.sincon.gepred.domain.Allegati;
import it.sincon.gepred.domain.AttivitaPratica;
import it.sincon.gepred.domain.TipoPraticaAttivita;
import it.sincon.gepred.domain.pratica.Pratica;
import it.sincon.gepred.domain.pratica.PraticaWeb;
import it.sincon.gepred.domain.pratica.TipoPratica;
import it.sincon.gepred.domain.pratica.TipoPraticaTab;

import java.beans.PropertyDescriptor;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import javax.portlet.PortletMode;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.PortletSession;
import javax.portlet.ResourceResponse;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletURL;
import javax.portlet.PortletModeException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeansException;
import org.springframework.beans.FatalBeanException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StreamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;


/**
 * Implementazione di {@link PortletHelper}.
 * 
 * @author Maria Michela Birtolo
 */
@Component("portletHelper")
public class LiferayPortletHelperImpl implements PortletHelper {

	private static Logger log = LoggerFactory.getLogger(LiferayPortletHelperImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.linksmt.osapulie.web.portlet.util.PortletHelper#sendStream(java.io.InputStream,
	 * javax.portlet.ResourceResponse, java.lang.String)
	 */
	@Override
	public void sendStream(InputStream sourceStream, ResourceResponse response, String mimeType) {
		try {
			response.setContentType(mimeType);
			copyStream(sourceStream, response.getPortletOutputStream());
		}
		catch (IOException e) {
			log.error(e.getMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.linksmt.osapulie.web.portlet.util.PortletHelper#sendStream(byte[],
	 * javax.portlet.ResourceResponse, java.lang.String)
	 */
	@Override
	public void sendStream(byte[] bytes, ResourceResponse response, String mimeType) {
		sendStreamAsAttachment(bytes, response, null, mimeType);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.linksmt.osapulie.web.portlet.util.PortletHelper#sendStreamAsAttachment(byte[],
	 * javax.portlet.ResourceResponse, java.lang.String, java.lang.String)
	 */
	@Override
	public void sendStreamAsAttachment(byte[] bytes, ResourceResponse response, String attachmentName, String mimeType) {
		if (StringUtils.hasLength(attachmentName)) {
			response.setProperty("Content-disposition", "attachment; filename=" + attachmentName);
		}
		ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
		sendStream(bais, response, mimeType);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.linksmt.osapulie.web.portlet.util.PortletHelper#copyStream(java.io.InputStream,
	 * java.io.OutputStream)
	 */
	@Override
	public void copyStream(InputStream sourceStream, OutputStream os) {
		try {
			StreamUtil.transfer(sourceStream, os, true);
		}
		catch (IOException e) {
			log.error(e.getMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.linksmt.osapulie.web.portlet.util.PortletHelper#getLongParam(java.lang.String,
	 * javax.portlet.PortletRequest)
	 */
	@Override
	public Long getLongParam(String parmName, PortletRequest request) {
		String s = request.getParameter(parmName);
		Long value = 0L;
		if (s != null) {
			try {
				value = Long.parseLong(s);
			}
			catch (NumberFormatException e) {
				String[] ss = s.split(",");
				if (ss.length > 1) {
					value = Long.parseLong(ss[0]);
				}
			}
		}
		return value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * it.linksmt.osapulie.web.portlet.util.PortletHelper#getUserInfo(javax.portlet.PortletRequest)
	 */
	@Override
	public UserInfo getUserInfo(PortletRequest request) {
		User user = null;
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		if (themeDisplay != null) {
			user = themeDisplay.getUser();
		}

		try {
			String userName = user.getLogin();
			String password = user.getPassword();
			List<String> roles = new ArrayList<String>();
			for (Role role : RoleLocalServiceUtil.getUserRoles(user.getUserId())) {
				roles.add(role.getName());
			}
			return new UserInfo(userName, password, roles.toArray(new String[roles.size()]));
		}
		catch (Exception e) {
			throw new WebLayerException(e.getMessage(), e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.linksmt.osapulie.web.portlet.util.PortletHelper#getCurrentPageName(javax.portlet.
	 * PortletRequest)
	 */
	@Override
	public String getCurrentPageName(PortletRequest request) {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

		String friendlyUrl = themeDisplay.getLayout().getFriendlyURL(); // es., "/opere"
		String pageName = friendlyUrl.substring(1); // "opere"

		return pageName;
	}

	@Override
	public PortletURL createPortletUrlToExternalPortlet(PortletRequest request,PortletResponse response,String portletName,Map<String,String> portletParams,String portletPhase)
	{
		//LiferayPortletRequest liferayPortletRequest = (LiferayPortletRequest)actionRequest;
		LiferayPortletResponse liferayPortletResponse = (LiferayPortletResponse)response;

		HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(request);//liferayPortletRequest.getHttpServletRequest();
		ThemeDisplay themeDisplay = (ThemeDisplay)httpRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PortletURL portletURL = null;
		long plid = 0;
		try {
			log.info(String.format("portletname: %s", portletName));
			if (themeDisplay!= null){
				log.info(String.format("themeDisplay.getScopeGroupId(): %s", themeDisplay.getScopeGroupId()));
			}
			else
				log.info("ThemeDisplay is null");
			log.info(String.format("portletname: %s", portletName));
			
			plid = PortalUtil.getPlidFromPortletId(themeDisplay.getScopeGroupId(), portletName);
			portletURL = liferayPortletResponse.createLiferayPortletURL(plid, portletName, portletPhase);
			portletURL.setPortletMode(PortletMode.VIEW);
		} catch (PortalException e) {
			log.error(e.getMessage(), e);
		} catch (SystemException e) {
			log.error(e.getMessage(), e);
		} catch(PortletModeException e) {
			log.error(e.getMessage(), e);
		}
		for(Map.Entry<String,String> row:portletParams.entrySet())
			portletURL.setParameter(row.getKey(),row.getValue());
		return portletURL;

	}


	/**
	 * Prende dalla sessione il profilo utente relativo al cittadino connesso al portale
	 */
	@Override
	public ProfiloUtente getProfiloUtente(PortletSession session) {
		ProfiloUtente retValue = null;
		
		OSApulieUserDetails osapulieUser = getOsApulieUserDetails();
		if (osapulieUser!=null)
			retValue = osapulieUser.getProfiloUtenteCittadino();
		
		return retValue;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * it.osapulie.web.portlet.util.PortletHelper#getOsApulieUserDetails(javax.portlet.PortletRequest
	 * )
	 */
	@Override
	public OSApulieUserDetails getOsApulieUserDetails() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null) {
			return null;
		}

		OSApulieUserDetails user = (OSApulieUserDetails) authentication.getPrincipal();
		// Aggiornamento certificato
		user.setCertificato(((OSApuliePortletPreAuthenticatedDetails) (authentication.getDetails())).getCertificato());
		return user;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * it.osapulie.web.portlet.util.PortletHelper#getUserPreferences(javax.portlet.PortletRequest )
	 */
	@Override
	public UserPreferences getUserPreferences(PortletRequest portletRequest) {
		HttpServletRequest httpServletRequest = PortalUtil.getHttpServletRequest(portletRequest);

		UserPreferences userPreferences = null;
		if (httpServletRequest.getSession().getAttribute("userPreferences") != null)
			userPreferences = (UserPreferences) httpServletRequest.getSession().getAttribute("userPreferences");

		return userPreferences;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * it.osapulie.web.portlet.util.PortletHelper#getEntityFromSession(javax.portlet.PortletRequest ,String nome)
	 */
	@Override
	public Object getEntityFromSession(PortletRequest portletRequest,String nome) {
		HttpServletRequest httpServletRequest = PortalUtil.getHttpServletRequest(portletRequest);

		Object entity = null;
		HttpSession httpSession = httpServletRequest.getSession();
		if (httpSession.getAttribute(nome) != null) {
			entity = httpServletRequest.getSession().getAttribute(nome);
			log.debug(String.format("[SESSION ID:%s] :: %s recuprato dalla sessione con valore=%s!!",httpSession.getId(), nome, entity.toString()));
		}
		else
			log.info(String.format("[SESSION ID:%s] :: %s NON TROVATO IN SESSIONE!!",httpSession.getId(), nome));
		
		return entity;
	}
	private void _dumpSession(HttpSession httpSession) {
    	log.debug(String.format("[SESSION ID:%s] :: Parametri contenuti ...................", httpSession.getId()));
    	
    	for (Object sessionAttributeObj : Collections.list(httpSession.getAttributeNames())) {
    		log.debug(String.format("[SESSION ID:%s] :: %s", httpSession.getId(), sessionAttributeObj.toString()));
    	}
    	log.debug(String.format("[SESSION ID:%s] :: Parametri contenuti ...................", httpSession.getId()));
    }

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * it.osapulie.web.portlet.util.PortletHelper#setEntityInSession(javax.portlet.PortletRequest ,String nome)
	 */
	@Override
	public void setEntityInSession(PortletRequest portletRequest,String nome,Object entity) {
		HttpServletRequest httpServletRequest = PortalUtil.getHttpServletRequest(portletRequest);

		httpServletRequest.getSession().setAttribute(nome, entity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.osapulie.web.portlet.util.PortletHelper#isCurrentUserRole(User liferayUser, String
	 * roleString)
	 */
	@Override
	public boolean userHasRole(User liferayUser, String roleString) {

		if (liferayUser != null) {
			List<Role> roles;
			try {
				roles = liferayUser.getRoles();
				for (Role role : roles) {
					if (role.getName().equals(roleString)) {
						return true;
					}
				}
			}
			catch (SystemException e) {
			}
		}

		return false;
	}
	@Override
	public boolean userHasService(OSApulieUserDetails osApulieUserDetails, String serviceString) {

		if (osApulieUserDetails != null) {
//			Ruolo ruolo = osApulieUserDetails.getProfiloUtenteCittadino().getRuolo();
//			List<Servizio> servizi = ruolo.getServizi();
			
			List<Servizio> servizi = new ArrayList<Servizio>();
			for (Ruolo role : osApulieUserDetails.getProfiloUtenteCittadino().getRuoli() ){
				for (Servizio serv : role.getServizi()){
					if (!servizi.contains(serv))
						servizi.add(serv);
				}
			}
			
			
			for (Servizio servizio : servizi) {
				if (servizio.getCodiceServizio().equals(serviceString)) {
					return true;
				}
			}			
		}

		return false;
	}
	
	private boolean roleHasPermission(Ruolo ruolo, long codPermesso){
		boolean perm = false;
		
		List<Permesso> permessi = ruolo.getPermessi();

		for(int i = 0; i < permessi.size(); i++){
			if(permessi.get(i).getId() == codPermesso)
				perm=true;
		}
		return perm;
	}
	private boolean userHasPermission(OSApulieUserDetails osApulieUserDetails, long codPermesso){
		boolean perm = false;
		
		List<Ruolo> listaRuoli = osApulieUserDetails.getProfiloUtenteCittadino().getRuoli();

		for(Ruolo role : listaRuoli){
			if(roleHasPermission(role, codPermesso)){
				perm=true;
				break;
			}
		}
		return perm;
	}
	@Override
	public boolean userHasPermissionInsert(OSApulieUserDetails osApulieUserDetails){
		
		return userHasPermission(osApulieUserDetails, 3L);
	}
	@Override
	public boolean userHasPermissionReadAll(OSApulieUserDetails osApulieUserDetails){
		
		return userHasPermission(osApulieUserDetails, 1L);
	}
	@Override
	public boolean userHasPermissionEditAll(OSApulieUserDetails osApulieUserDetails){
		return userHasPermission(osApulieUserDetails, 2L);
	}
	
	@Override
	public boolean userHasPermissionReadOwn(OSApulieUserDetails osApulieUserDetails){
		return userHasPermission(osApulieUserDetails, 4L);
	}
	@Override
	public boolean userHasPermissionEditOwn(OSApulieUserDetails osApulieUserDetails){
		return userHasPermission(osApulieUserDetails, 5L);
	}

	public boolean userHasPermissionEditPratica(OSApulieUserDetails osApulieUserDetails,Pratica pratica){
		boolean permPratica = false;

		List<AttivitaPratica> attivita = pratica.getAttivitaPratica();
		if (attivita!=null)
			for(int i =0; i < attivita.size(); i++){
				if(attivita.get(i).getDataCompletamento() == null && osApulieUserDetails.getProfiloUtenteCittadino().equals(attivita.get(i).getProfiloutente()))
					permPratica = true;
			}

		return permPratica;
	}

	public boolean userHasPermissionPratica(OSApulieUserDetails osApulieUserDetails,Pratica pratica){
		boolean permPratica = false;

		List<AttivitaPratica> attivita = pratica.getAttivitaPratica();
		if (attivita!=null)
			for(int i =0; i < attivita.size(); i++){
				if(attivita.get(i).getDataCompletamento() == null && osApulieUserDetails.getProfiloUtenteCittadino().equals(attivita.get(i).getProfiloutente()))
					permPratica = true;
			}

		return permPratica;
	}

	@Override
	public Map<Long,Boolean> userHasPermissionTabPratica(OSApulieUserDetails osApulieUserDetails,Pratica pratica) {
		Map<Long,Boolean> result = new HashMap<Long,Boolean>();
		Long idProfilo = osApulieUserDetails.getProfiloUtenteCittadino().getId();
		boolean isReferente = false;
		boolean isEnabledReferenteAssegnatario = false;
		boolean isAssignedAttivita = false;
		boolean isAssegnatario = false;
		if (pratica!=null && pratica.getTipologia()!=null)
		{
			for(int i=0;i<pratica.getTipologia().getSchede().size() && !isEnabledReferenteAssegnatario;i++) {
				isEnabledReferenteAssegnatario = pratica.getTipologia().getSchede().get(i).getTab().getId().equals(Long.parseLong("8"));
			}
			if (isEnabledReferenteAssegnatario) {
				if (pratica.getReferente()!=null)
					isReferente = pratica.getReferente().getId().equals(idProfilo);
				if (pratica.getAssegnatari()!=null)
				{
					for(int j=0;j<pratica.getAssegnatari().size();j++)
					{
						if (pratica.getAssegnatari().get(j).getId().equals(idProfilo))
							isAssegnatario = true;
					}
				}
			} else {
				isAssignedAttivita = userHasPermissionEditPratica(osApulieUserDetails, pratica);
			}
			for(int i=0;i<pratica.getTipologia().getSchede().size();i++){
//				Long idRuolo = osApulieUserDetails.getProfiloUtenteCittadino().getRuolo().getId();
				List<Ruolo> listaRuoli = osApulieUserDetails.getProfiloUtenteCittadino().getRuoli();
				
				Boolean canEdit = false;
				TipoPraticaTab scheda = pratica.getTipologia().getSchede().get(i);
				if (scheda.getRuoliScrittura()!=null)
				{
					for(int j=0;j<scheda.getRuoliScrittura().size();j++) {
						for (Ruolo role : listaRuoli){
							if (scheda.getRuoliScrittura().get(j).getId().equals(role.getId()))
								canEdit = true;
						}
					}
				}
				if (isEnabledReferenteAssegnatario) {
					if (isReferente)
						canEdit |= scheda.isModificaReferente();
					else if (isAssegnatario)
						canEdit |= scheda.isModificaAssegnatario();
				} else {
					canEdit |= isAssignedAttivita;
				}
				result.put(scheda.getTab().getId(),canEdit);
			}
		}
		return result;
	}
	
	@Override
	public Map<Long,Boolean> userHasPermissionTabPraticaWeb(OSApulieUserDetails osApulieUserDetails,PraticaWeb praticaWeb) {
		Map<Long,Boolean> result = new HashMap<Long,Boolean>();
		Long idProfilo = osApulieUserDetails.getProfiloUtenteCittadino().getId();
		boolean isReferente = false;
		boolean isEnabledReferenteAssegnatario = false;
		boolean isAssignedAttivita = false;
		boolean isAssegnatario = false;
		if (praticaWeb!=null && praticaWeb.getTipologia()!=null)
		{
			for(int i=0;i<praticaWeb.getTipologia().getSchede().size() && !isEnabledReferenteAssegnatario;i++) {
				isEnabledReferenteAssegnatario = praticaWeb.getTipologia().getSchede().get(i).getTab().getId().equals(Long.parseLong("8"));
			}
			
			
			for(int i=0;i<praticaWeb.getTipologia().getSchede().size();i++){
//				Long idRuolo = osApulieUserDetails.getProfiloUtenteCittadino().getRuolo().getId();
				List<Ruolo> listaRuoli = osApulieUserDetails.getProfiloUtenteCittadino().getRuoli();
				
				Boolean canEdit = false;
				TipoPraticaTab scheda = praticaWeb.getTipologia().getSchede().get(i);
				if (scheda.getRuoliScrittura()!=null)
				{
					for(int j=0;j<scheda.getRuoliScrittura().size();j++) {
						for (Ruolo role : listaRuoli){
							if (scheda.getRuoliScrittura().get(j).getId().equals(role.getId()))
								canEdit = true;
						}
					}
				}
				if (isEnabledReferenteAssegnatario) {
					if (isReferente)
						canEdit |= scheda.isModificaReferente();
					else if (isAssegnatario)
						canEdit |= scheda.isModificaAssegnatario();
				} else {
					canEdit |= isAssignedAttivita;
				}
				result.put(scheda.getTab().getId(),canEdit);
			}
		}
		return result;
	}

	@Override
	public Map<Long,Boolean> userHasPermissionReadPratica(Pratica pratica){
		Map<Long,Boolean> result = new HashMap<Long,Boolean>();

		for(int i=0;i<pratica.getTipologia().getSchede().size();i++){
			TipoPraticaTab scheda = pratica.getTipologia().getSchede().get(i);
			Boolean canEdit = false;
			result.put(scheda.getTab().getId(),canEdit);
		}
		return result;

	}
	
	@Override
	public String getPortletId(PortletRequest request) {
		return (String) request.getAttribute(WebKeys.PORTLET_ID);
	}
	
	/**
	 * Copy the property values of the given source bean into the given target bean.
	 * <p>Note: The source and target classes do not have to match or even be derived
	 * from each other, as long as the properties match. Any bean properties that the
	 * source bean exposes but the target bean does not will silently be ignored.
	 * @param source the source bean
	 * @param target the target bean
	 * @param editable the class (or interface) to restrict property setting to
	 * @param ignoreProperties array of property names to ignore
	 * @throws BeansException if the copying failed
	 * @see BeanWrapper
	 */
	public void copyProperties(Object source, Object target, Class<?> editable, String[] ignoreProperties)
			throws BeansException {

		Assert.notNull(source, "Source must not be null");
		Assert.notNull(target, "Target must not be null");
		//log.info("copy object of type "+source.getClass().getName()+" to type "+target.getClass().getName());

		Class<?> actualEditable = target.getClass();
//		System.out.println("Copy properties START - actualEditable="+actualEditable.getName());
		if (editable != null) {
//			System.out.println("editable="+editable.getName());
			if (!editable.isInstance(target)) {
				throw new IllegalArgumentException("Target class [" + target.getClass().getName() +
						"] not assignable to Editable class [" + editable.getName() + "]");
			}
			actualEditable = editable;
		}
		PropertyDescriptor[] targetPds = BeanUtils.getPropertyDescriptors(actualEditable);
//		System.out.println("targetPds.length="+targetPds.length);
		List<String> ignoreList = (ignoreProperties != null) ? Arrays.asList(ignoreProperties) : null;

		for (PropertyDescriptor targetPd : targetPds) {
//			System.out.println("considero la proprietà "+targetPd.getName());
			if ((targetPd.getWriteMethod() != null || List.class.isAssignableFrom(targetPd.getPropertyType())) && 
					(ignoreProperties == null || (!ignoreList.contains(targetPd.getName())))) {
				PropertyDescriptor sourcePd = BeanUtils.getPropertyDescriptor(source.getClass(), targetPd.getName());
				if (sourcePd != null && sourcePd.getReadMethod() != null) {
					if(BeanUtils.isSimpleProperty(targetPd.getPropertyType())){
						try {
//							System.out.println("copy simple property "+targetPd.getName());
							Method readMethod = sourcePd.getReadMethod();
							if (!Modifier.isPublic(readMethod.getDeclaringClass().getModifiers())) {
								readMethod.setAccessible(true);
							}
							Object value = readMethod.invoke(source);
							Method writeMethod = targetPd.getWriteMethod();
							if (!Modifier.isPublic(writeMethod.getDeclaringClass().getModifiers())) {
								writeMethod.setAccessible(true);
							}
							writeMethod.invoke(target, value);
						}
						catch (Throwable ex) {
							throw new FatalBeanException("Could not copy simple properties from source to target: "+targetPd.getName(), ex);
						}
					}
					else{
						try {
//							System.out.println("copy property: "+targetPd.getName()+" tipo: "+targetPd.getPropertyType());
							if(!List.class.isAssignableFrom(targetPd.getPropertyType())){
//								System.out.println("!sono in List"+targetPd.getPropertyType().getName());
								if (targetPd.getPropertyType().equals(Calendar.class)){
//									System.out.println("Gestione ad hoc per target di tipo java.util.Calendar....");
									
									Method readMethod = sourcePd.getReadMethod();
									if (!Modifier.isPublic(readMethod.getDeclaringClass().getModifiers())) {
										readMethod.setAccessible(true);
									}
									Calendar sourceCal = (Calendar) readMethod.invoke(source);  
									
									Calendar targetCal = Calendar.getInstance();
									targetCal.setTime(sourceCal.getTime());
									
									Method writeMethod = targetPd.getWriteMethod();
									if (!Modifier.isPublic(writeMethod.getDeclaringClass().getModifiers())) {
										writeMethod.setAccessible(true);
									}
									writeMethod.invoke(target, targetCal);
								}
								else{
									Object obj = targetPd.getPropertyType().newInstance();
									Method readMethod = sourcePd.getReadMethod();
									if (!Modifier.isPublic(readMethod.getDeclaringClass().getModifiers())) {
										readMethod.setAccessible(true);
									}
									Object value = readMethod.invoke(source);
									if (value!=null) {
										copyProperties(value,obj,null,ignoreProperties);
										Method writeMethod = targetPd.getWriteMethod();
										if (!Modifier.isPublic(writeMethod.getDeclaringClass().getModifiers())) {
											writeMethod.setAccessible(true);
										}
										writeMethod.invoke(target, obj);
									}
								}
							}else{
								Method readMethod = sourcePd.getReadMethod();
								if (!Modifier.isPublic(readMethod.getDeclaringClass().getModifiers())) {
									readMethod.setAccessible(true);
								}
								Field stringListField = actualEditable.getDeclaredField(targetPd.getName());
								ParameterizedType stringListType = (ParameterizedType) stringListField.getGenericType();
						        Class<?> listClass = (Class<?>) stringListType.getActualTypeArguments()[0];
						        List<Object> list = new ArrayList<Object>();
						        
								List value = (List)readMethod.invoke(source);
								if (value!=null) {
									for (Object ob : value) {
										Object o = listClass.newInstance();
										copyProperties(ob,o,null,ignoreProperties);
										list.add(o);
									}
									
									if(targetPd.getWriteMethod() != null){
										Method writeMethod = targetPd.getWriteMethod();
										if (!Modifier.isPublic(writeMethod.getDeclaringClass().getModifiers())) {
											writeMethod.setAccessible(true);
										}
										writeMethod.invoke(target, list);
									}else{
										Method read = targetPd.getReadMethod();
										if (!Modifier.isPublic(read.getDeclaringClass().getModifiers())) {
											read.setAccessible(true);
										}
										List listaTarget = (List)read.invoke(target);
										listaTarget.addAll(list);
									}
								}
							}
						}
						catch (Throwable ex) {
							throw new FatalBeanException("Could not copy properties from source to target: "+targetPd.getName(), ex);
						}
					}
				}
			}
//			else{
//				System.out.println(String.format("Proprietà %s SCARTATA !! targetPd.getWriteMethod()=%s",
//						targetPd.getName(),
//						targetPd.getWriteMethod()==null ? "NULL" : targetPd.getWriteMethod().getName()));
//			}
		}
	}
}