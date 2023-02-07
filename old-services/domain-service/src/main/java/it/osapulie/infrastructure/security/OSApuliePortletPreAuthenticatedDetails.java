package it.osapulie.infrastructure.security;

import it.osapulie.domain.ProfiloUtente;

import java.security.cert.X509Certificate;

import javax.portlet.PortletRequest;

import org.springframework.security.extensions.portlet.PortletPreAuthenticatedAuthenticationDetails;

public class OSApuliePortletPreAuthenticatedDetails extends PortletPreAuthenticatedAuthenticationDetails {

	private static final long serialVersionUID = 7929833053851250431L;

	private ProfiloUtente profiloUtente;
	private X509Certificate certificato;

	private boolean autenticatoForte;

	/**
	 * @param request
	 */
	public OSApuliePortletPreAuthenticatedDetails(PortletRequest request) {
		super(request);
	}

	public ProfiloUtente getProfiloUtente() {
		return profiloUtente;
	}

	public void setProfiloUtente(ProfiloUtente profiloUtente) {
		this.profiloUtente = profiloUtente;
	}

	public X509Certificate getCertificato() {
		return certificato;
	}

	public void setCertificato(X509Certificate certificato) {
		this.certificato = certificato;
	}

	public boolean isAutenticatoForte() {
		if (certificato != null)
			return true;
		if (profiloUtente != null && profiloUtente.isAutenticazioneForte())
			return true;
		return autenticatoForte;
	}

	public void setAutenticatoForte(boolean autenticatoForte) {
		this.autenticatoForte = autenticatoForte;
	}
}
