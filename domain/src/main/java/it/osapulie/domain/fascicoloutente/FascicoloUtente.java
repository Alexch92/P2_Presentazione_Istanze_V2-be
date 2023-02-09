package it.osapulie.domain.fascicoloutente;

import it.osapulie.domain.ProfiloUtente;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "tb_fascicolo_utente")
public class FascicoloUtente extends AbstractPersistable<Long> {

	private static final long serialVersionUID = -8731308377602642010L;

	@JoinColumn(name = "fk_cittadino", nullable = false, updatable = false)
	@OneToOne
	private ProfiloUtente cittadino;

	@OrderBy("dataRichiesta DESC")
	@OneToMany(mappedBy = "fascicolo", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<RichiestaServizio> richieste;

	public ProfiloUtente getCittadino() {
		return cittadino;
	}

	public void setCittadino(ProfiloUtente cittadino) {
		this.cittadino = cittadino;
	}

	public List<RichiestaServizio> getRichieste() {
		return richieste;
	}

	public void setRichieste(List<RichiestaServizio> richieste) {
		this.richieste = richieste;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FascicoloUtente [cittadino=" + cittadino + ", richieste=" + richieste + "]";
	}

	public void aggiungiRichiesta(RichiestaServizio richiesta) {
		getRichieste().add(richiesta);
	}
}
