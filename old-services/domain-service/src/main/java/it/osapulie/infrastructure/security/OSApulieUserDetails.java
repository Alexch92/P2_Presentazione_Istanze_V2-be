package it.osapulie.infrastructure.security;

import it.osapulie.domain.ProfiloUtente;

import java.security.cert.X509Certificate;
import java.util.Collection;

import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import com.liferay.portal.model.Contact;

/**
 * Implementazione di {@link UserDetails} che include il profilo utente di un cittadino utente di OS
 * Apulie.
 * 
 * @author Maria Michela Birtolo
 */
public class OSApulieUserDetails implements UserDetails, CredentialsContainer {

	private static final long serialVersionUID = 8577518790550154274L;

	private final User portalUser;
	private final ProfiloUtente profiloUtenteCittadino;
	private final com.liferay.portal.model.User liferayUser;

	/**
	 * Variabile di scambio per permettere la modifica dei dati relativi al contatto di un utente
	 */
	private Contact liferayContact;

	/**
	 * Certificato che identifica l'autenticazione forte di un utente (tramite CNS).
	 */
	private X509Certificate certificato;

	private boolean autenticatoForte;

	/**
	 * @param portalUser
	 * @param profiloUtenteCittadino
	 */
	public OSApulieUserDetails(User portalUser, ProfiloUtente profiloUtente, com.liferay.portal.model.User liferayUser) {
		super();
		this.portalUser = portalUser;
		this.profiloUtenteCittadino = profiloUtente;
		this.liferayUser = liferayUser;
	}

	/**
	 * Verifica che esista un {@link ProfiloUtenteCittadino} associato a questo {@link UserDetails}
	 * (questo indica che l'utente è già stato profilato all'interno del sistema e sono disponibili
	 * tutte le informazioni
	 * 
	 * @return <code>true</code> se l'utente risulta già essere stato profilato all'interno del
	 *         sistema, <code>false</code> altrimenti.
	 */
	public boolean isUtenteProfilato() {
		return profiloUtenteCittadino != null;
	}

	

	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		return portalUser.getAuthorities();
	}

	@Override
	public String getPassword() {
		return portalUser.getPassword();
	}

	@Override
	public String getUsername() {
		return portalUser.getUsername();
	}

	@Override
	public boolean isEnabled() {
		return portalUser.isEnabled();
	}

	@Override
	public boolean isAccountNonExpired() {
		return portalUser.isAccountNonExpired();
	}

	@Override
	public boolean isAccountNonLocked() {
		return portalUser.isAccountNonLocked();
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return portalUser.isCredentialsNonExpired();
	}

	@Override
	public void eraseCredentials() {
		portalUser.eraseCredentials();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object rhs) {
		return portalUser.equals(rhs);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return portalUser.hashCode();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return portalUser.toString();
	}

	public com.liferay.portal.model.User getLiferayUser() {
		return liferayUser;
	}

	public X509Certificate getCertificato() {
		return certificato;
	}

	public void setCertificato(X509Certificate certificato) {
		this.certificato = certificato;
	}

	public Contact getLiferayContact() {
		return liferayContact;
	}

	public void setLiferayContact(Contact liferayContact) {
		this.liferayContact = liferayContact;
	}

	public ProfiloUtente getProfiloUtenteCittadino() {
		return profiloUtenteCittadino;
	}
	
	public boolean isAutenticatoForte() {
		if (certificato != null)
			return true;
		if (profiloUtenteCittadino != null && profiloUtenteCittadino.isAutenticazioneForte())
			return true;
		return autenticatoForte;
	}

	public void setAutenticatoForte(boolean autenticatoForte) {
		this.autenticatoForte = autenticatoForte;
	}
}