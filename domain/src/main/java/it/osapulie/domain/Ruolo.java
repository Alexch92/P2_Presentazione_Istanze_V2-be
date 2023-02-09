package it.osapulie.domain;

import it.osapulie.domain.servizi.Servizio;
import it.sincon.gepred.domain.pratica.CategoriePratiche;
import it.sincon.gepred.domain.pratica.TipoPraticaTab;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "tb_ruolo")
public class Ruolo extends AbstractPersistable<Long> {

	private static final long serialVersionUID = -1021919152275272114L;

	@Column(name = "nome", nullable = false, length = 128)
	private String nome;
	
	@Column(name = "visibile_gestione_pratiche", length = 1, nullable = false)
	private boolean visibile;
	
	@Column(name = "assegnazione_automatica", length = 1, nullable = false)
	private boolean assegnazioneAutomatica;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "tb_ruolo_permesso", joinColumns = { @JoinColumn(name = "ruolo_id", referencedColumnName = "ID") }, inverseJoinColumns = @JoinColumn(name = "permesso_id", referencedColumnName = "ID"))
	private List<Permesso> permessi;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "tb_ruolo_servizio", joinColumns = { @JoinColumn(name = "fk_ruolo", referencedColumnName = "ID") }, inverseJoinColumns = @JoinColumn(name = "fk_servizio", referencedColumnName = "ID"))
	@OrderBy("codiceServizio")
	private List<Servizio> servizi;
	
	@JoinTable(name = "tb_ruoli_categorie", joinColumns = { @JoinColumn(name = "ruolo_id", referencedColumnName = "ID") }, inverseJoinColumns =  @JoinColumn(name = "categoria_id", referencedColumnName = "ID"))
	@OrderBy("id DESC")
	private List<CategoriePratiche> categorieAbilitate;
	
	@ManyToMany(mappedBy = "ruoli", fetch = FetchType.LAZY)
	private List<ProfiloUtente> utenti;
	
	
	public boolean isVisibile() {
		return visibile;
	}

	public boolean isAssegnazioneAutomatica() {
		return assegnazioneAutomatica;
	}

	public void setAssegnazioneAutomatica(boolean assegnazioneAutomatica) {
		this.assegnazioneAutomatica = assegnazioneAutomatica;
	}

	public void setVisibile(boolean visibile) {
		this.visibile = visibile;
	}

	public List<CategoriePratiche> getCategorieAbilitate() {
		return categorieAbilitate;
	}

	public void setCategorieAbilitate(List<CategoriePratiche> categorieAbilitate) {
		this.categorieAbilitate = categorieAbilitate;
	}

	public List<Servizio> getServizi() {
		return servizi;
	}

	public void setServizi(List<Servizio> servizi) {
		this.servizi = servizi;
	}

	public List<Permesso> getPermessi() {
		return permessi;
	}

	public void setPermessi(List<Permesso> permessi) {
		this.permessi = permessi;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public List<ProfiloUtente> getUtenti() {
		return utenti;
	}

	public void setUtenti(List<ProfiloUtente> utenti) {
		this.utenti = utenti;
	}
	
	@Override
	public void setId(Long id) {
		super.setId(id);
	}

}
