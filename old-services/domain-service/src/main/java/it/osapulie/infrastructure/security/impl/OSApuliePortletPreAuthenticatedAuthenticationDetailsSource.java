package it.osapulie.infrastructure.security.impl;

import it.osapulie.domain.ProfiloUtente;
import it.osapulie.infrastructure.security.OSApuliePortletPreAuthenticatedDetails;
import it.osapulie.persistence.ProfiloUtenteRepository;
import it.osapulie.shared.service.UserPreferences;

import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import java.util.Date;

import javax.inject.Inject;
import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.extensions.portlet.PortletPreAuthenticatedAuthenticationDetailsSource;

import com.liferay.portal.util.PortalUtil;

/**
 * Classe di gestione autenticazione portlet.
 * 
 * @author Maria Michela Birtolo 
 */
public class OSApuliePortletPreAuthenticatedAuthenticationDetailsSource extends PortletPreAuthenticatedAuthenticationDetailsSource {

	private Logger log = LoggerFactory.getLogger(OSApuliePortletPreAuthenticatedAuthenticationDetailsSource.class.getName());

	@Inject
	private ProfiloUtenteRepository repositoryCittadini;

	public OSApuliePortletPreAuthenticatedAuthenticationDetailsSource() {
		setClazz(OSApuliePortletPreAuthenticatedDetails.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.web.authentication.preauth.j2ee.
	 * AbstractPreAuthenticatedAuthenticationDetailsSource#buildDetails(java.lang.Object)
	 */
	@Override
	public Object buildDetails(Object context) {

		PortletRequest request = (PortletRequest) context;

		OSApuliePortletPreAuthenticatedDetails details = (OSApuliePortletPreAuthenticatedDetails) super.buildDetails(context);
		
		if(request.getUserPrincipal() != null){
			String userName = request.getUserPrincipal().getName();
			ProfiloUtente profiloUtente = findProfiloUtente(userName);
			details.setProfiloUtente(profiloUtente);
	
			// Setto in sessione, se non esiste già, le userPreferences
			HttpServletRequest httpServletRequest = PortalUtil.getHttpServletRequest(request);
			if (httpServletRequest.getSession().getAttribute("userPreferences") == null) {
				UserPreferences userPreferences = new UserPreferences();
				/*if (profiloUtente.getComuneIsa() != null) {
					userPreferences.setIdComuneIsa(profiloUtente.getComuneIsa().getId());
					userPreferences.setCodiceIstatComune(profiloUtente.getComuneIsa().getCodiceIstat());
					userPreferences.setNomeComune(profiloUtente.getComuneIsa().getNome());
					userPreferences.setUriServizioGateway(profiloUtente.getComuneIsa().getUriServizioGateway());
					userPreferences.setCodiceFiscaleServizio(profiloUtente.getCodiceFiscale());
				}*/
	
				httpServletRequest.getSession().setAttribute("userPreferences", userPreferences);
			}
	
			// Autenticazione forte
			// CNS
			String cipherSuite = (String) request.getAttribute("javax.servlet.request.cipher_suite");
			try {
				if (cipherSuite != null) {
					X509Certificate certChain[] = (X509Certificate[]) request.getAttribute("javax.servlet.request.X509Certificate");
					if (certChain != null) {
						// Salvataggio certificato nell'oggetto ProfiloUtente
						for (int i = 0; i < certChain.length; i++) {
							log.info("buildDetails :: Client Certificate [" + i + "] = " + certChain[i].getSubjectDN().getName());
							try {
								certChain[i].checkValidity(new Date());
								details.setCertificato(certChain[i]);
							}
							catch (CertificateExpiredException e) {
								log.error("buildDetails :: " + e.getMessage(), e);
							}
							catch (CertificateNotYetValidException e) {
								log.error("buildDetails :: " + e.getMessage(), e);
							}
						}
					}
				}
			}
			catch (Exception e) {
				log.error("buildDetails :: " + e.getMessage(), e);
			}
		}
		return details;
	}

	/**
	 * Recupera il profilo utente associato all'utente corrente.
	 * 
	 * @param userName
	 * @return
	 */
	private ProfiloUtente findProfiloUtente(String userName) {
		// Cerchiamo il profilo associato allo user name indicato: può essere un professionista o
		// (come fallback)
		// un cittadino: in caso non sia nemmeno un profilo cittadino allora viene ritornato null.
		ProfiloUtente profiloUtente = repositoryCittadini.findOne(Long.parseLong(userName));
		return profiloUtente;
	}
}
