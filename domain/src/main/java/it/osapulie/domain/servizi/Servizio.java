package it.osapulie.domain.servizi;

import java.util.List;
import it.osapulie.domain.Ruolo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "tb_servizio")
public class Servizio extends AbstractPersistable<Long> {

	private static final long serialVersionUID = -4174142364198409072L;

	@Override
	protected void setId(Long id) {
		super.setId(id);
	}

	@Column(name = "nome_servizio", length = 255, unique = true)
	private String nomeServizio;

	@Column(name = "descrizione", length = 255, nullable = false)
	private String descrizione;

	@Column(name = "codice_servizio", length = 5, unique = true)
	private String codiceServizio;

	@Column(name = "uri", nullable = false, length = 256)
	private String uri;
	
	@ManyToMany(mappedBy = "servizi", fetch = FetchType.EAGER)
	private List<Ruolo> ruolo;

	public List<Ruolo> getRuolo() {
		return ruolo;
	}

	public void setRuolo(List<Ruolo> ruolo) {
		this.ruolo = ruolo;
	}

	public String getUri() {
		return uri;
	}

	public String getCodiceServizio() {
		return codiceServizio;
	}

	public void setCodiceServizio(String codiceServizio) {
		this.codiceServizio = codiceServizio;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getNomeServizio() {
		return nomeServizio;
	}

	public void setNomeServizio(String nomeServizio) {
		this.nomeServizio = nomeServizio;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
}
