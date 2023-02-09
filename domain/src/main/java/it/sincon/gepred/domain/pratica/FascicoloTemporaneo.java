package it.sincon.gepred.domain.pratica;



import it.osapulie.domain.ProfiloUtente;
import it.sincon.gepred.domain.AllegatiFascicoloTemp;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 * @author Maria Michela Birtolo
 * 
 */
@Entity
@Table(name = "tb_fascicolo_temp")
public class FascicoloTemporaneo extends AbstractPersistable<Long> implements Serializable {
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name="oggetto", nullable = false, length = 500)
	private String oggettoRichiesta;
	
	@JoinColumn( name = "fk_tipologia",nullable = false)
	private TipoPratica tipologia;
	
	@OneToMany(mappedBy = "fascicolo", cascade = CascadeType.ALL, orphanRemoval = true)	
	private List<AllegatiFascicoloTemp> allegati;
	
	@JoinColumn(name = "fk_profiloutente", nullable = false)
	private ProfiloUtente referente;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name = "tb_profilo_fascicolo_temp", joinColumns = { @JoinColumn(name="fascicolo_id", referencedColumnName= "ID")},inverseJoinColumns = @JoinColumn(name = "profilo_id", referencedColumnName = "ID"))
	private List<ProfiloUtente> assegnatari;
	
	public List<AllegatiFascicoloTemp> getAllegati() {
		return allegati;
	}

	public void setAllegati(List<AllegatiFascicoloTemp> allegati) {
		this.allegati = allegati;
	}

	public ProfiloUtente getReferente() {
		return referente;
	}

	public void setReferente(ProfiloUtente referente) {
		this.referente = referente;
	}

	public List<ProfiloUtente> getAssegnatari() {
		return assegnatari;
	}

	public void setAssegnatari(List<ProfiloUtente> assegnatari) {
		this.assegnatari = assegnatari;
	}

	public String getUuidContenitore() {
		return uuidContenitore;
	}

	public void setUuidContenitore(String uuidContenitore) {
		this.uuidContenitore = uuidContenitore;
	}

	@Column(name="doc_contenitore_uuid", nullable = true, length = 45)
	private String uuidContenitore;
	
	public String getOggettoRichiesta() {
		return oggettoRichiesta;
	}

	public void setOggettoRichiesta(String oggettoRichiesta) {
		this.oggettoRichiesta = oggettoRichiesta;
	}
	public TipoPratica getTipologia() {
		return tipologia;
	}

	public void setTipologia(TipoPratica tipologia) {
		this.tipologia = tipologia;
	}

	
	
	
	
}
