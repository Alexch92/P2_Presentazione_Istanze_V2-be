package it.osapulie.domain;

import it.sincon.gepred.domain.Referente;
import it.sincon.gepred.domain.pratica.Pratica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "tb_profilo_utente")
public class ProfiloUtente extends AbstractPersistable<Long> {

	private static final long serialVersionUID = -1021919152275272114L;

	@Column(name = "cognome", nullable = false, length = 128)
	private String cognome;

	@Column(name = "nome", nullable = false, length = 128)
	private String nome;

	@Column(name = "codice_fiscale", unique = true, nullable = true, length = 16)
	private String codiceFiscale;

	@Column(name = "mail", nullable = false, length = 128)
	private String mail;

	@Column(name = "mail_pec", nullable = true, length = 128)
	private String mailPec;

	@Column(name = "autenticazione_forte")
	private boolean autenticazioneForte;

	@Temporal(TemporalType.DATE)
	@Column(name = "data_autenticazione_forte", nullable = true)
	private Date dataAutenticazioneForte;

	@Transient
	private String password;
	
	@Transient
	private String nomeCompleto;

	@Embedded 
	private Indirizzo residenza;

	@JoinColumn(name = "fk_comune", nullable = true)
	private Comune comune;
	
	@JoinTable(name="tb_profilo_ruolo", joinColumns = { @JoinColumn(name = "fk_profilo", referencedColumnName = "ID") }, inverseJoinColumns =  @JoinColumn(name = "fk_ruolo", referencedColumnName = "ID"))
	private List<Ruolo> ruoli;
	
	@JoinColumn(name = "fk_referente", nullable = true)
	private Referente referente;
	
	@Column(name = "username_protocollo", nullable = true, length = 50)
	private String usernameProtocollo;
	
	@Column(name = "password_protocollo", nullable = true, length = 50)
	private String passwordProtocollo;
	
	@Column(name = "id_utente_protocollo", nullable = true, length = 15)
	private Integer idUtenteProtocollo;
	
	@Column(name= "codice_ufficio", nullable = true, length = 50)
	private String codiceUfficio;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="referente")
	private List<Pratica> pratiche;
	
	public Referente getReferente() {
		return referente;
	}

	public void setReferente(Referente referente) {
		this.referente = referente;
	}

	public List<Ruolo> getRuoli() {
		return ruoli;
	}

	public void setRuoli(List<Ruolo> ruoli) {
		this.ruoli = ruoli;
	}

	@Override
	public void setId(Long id) {
		super.setId(id);
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public Indirizzo getResidenza() {
		return residenza;
	}

	public void setResidenza(Indirizzo residenza) {
		this.residenza = residenza;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Date getDataAutenticazioneForte() {
		return dataAutenticazioneForte;
	}

	public void setDataAutenticazioneForte(Date dataAutenticazioneForte) {
		this.dataAutenticazioneForte = dataAutenticazioneForte;
	}

	public String getMailPec() {
		return mailPec;
	}

	public void setMailPec(String mailPec) {
		this.mailPec = mailPec;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ProfiloUtenteCittadino [id=" + getId() + ", cognome=" + getCognome() + ", nome=" + getNome() + ", codiceFiscale=" + getCodiceFiscale() + ", residenza=" + getResidenza() + "]";
	}

	public boolean isAutenticazioneForte() {
		return autenticazioneForte;
	}

	public void setAutenticazioneForte(boolean autenticazioneForte) {
		this.autenticazioneForte = autenticazioneForte;
	}

	public Comune getComune() {
		return comune;
	}

	public void setComune(Comune comune) {
		this.comune = comune;
	}
	
	public String getNomeCompletoUtente() {
		return getCognome() + " " + getNome();
	}

	public String getUsernameProtocollo() {
		return usernameProtocollo;
	}

	public void setUsernameProtocollo(String usernameProtocollo) {
		this.usernameProtocollo = usernameProtocollo;
	}

	public String getPasswordProtocollo() {
		return passwordProtocollo;
	}

	public void setPasswordProtocollo(String passwordProtocollo) {
		this.passwordProtocollo = passwordProtocollo;
	}

	public Integer getIdUtenteProtocollo() {
		return idUtenteProtocollo;
	}

	public void setIdUtenteProtocollo(Integer idUtenteProtocollo) {
		this.idUtenteProtocollo = idUtenteProtocollo;
	}

	public String getCodiceUfficio() {
		return codiceUfficio;
	}

	public void setCodiceUfficio(String codiceUfficio) {
		this.codiceUfficio = codiceUfficio;
	}

	public List<Pratica> getPratiche() {
		return pratiche;
	}

	public void setPratiche(List<Pratica> pratiche) {
		this.pratiche = pratiche;
	}
	
	public String getIdsRuoli(){
		String ids="";

		for(int i=0; i < getRuoli().size(); i++){
			ids = String.format("%s,%s", ids, getRuoli().get(i).getId());
		}
		
		return ids.substring(1);
	}
	
	public List<Long> getListaIdsRuoli(){
		List<Long> ids = new ArrayList<Long>();

		long id= 0;
		for(int i=0; i < getRuoli().size(); i++){
			id = getRuoli().get(i).getId();
			if (!ids.contains(id)){
				ids.add(id);
			}
		} 
		
		return ids;
	}
	
	public String getNomeCompleto() {
		nomeCompleto = String.format("%S %S", cognome, nome);
		return nomeCompleto;
	}
	
}
