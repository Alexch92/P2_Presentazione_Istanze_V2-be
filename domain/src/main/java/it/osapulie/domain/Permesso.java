package it.osapulie.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "tb_permesso")
public class Permesso extends AbstractPersistable<Long> {

	private static final long serialVersionUID = -1021919152275272114L;

	@Column(name = "nome", nullable = false, length = 128)
	private String nome;
	
	@ManyToMany(mappedBy = "permessi", fetch = FetchType.EAGER)
	private List<Ruolo> ruolo;

	public List<Ruolo> getRuolo() {
		return ruolo;
	}

	public void setRuolo(List<Ruolo> ruolo) {
		this.ruolo = ruolo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public void setId(Long id) {
		super.setId(id);
	}
}
