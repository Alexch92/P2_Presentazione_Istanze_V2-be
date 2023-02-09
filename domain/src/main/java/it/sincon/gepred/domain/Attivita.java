package it.sincon.gepred.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;




import org.springframework.data.jpa.domain.AbstractPersistable;
/**
 * Entity per la tabella Attivit&agrave;
 * 
 * @author Maria Michela Birtolo
 * @author Angelo Pascadopoli
 *
 */
@Entity
@Table(name = "tb_attivita")
public class Attivita extends AbstractPersistable<Long> implements Serializable{

	private static final long serialVersionUID = 7612629974513650558L;

	@Column(name = "descrizione",length=255 ,nullable = false)
	private String descrizione;
	
	@Column(name = "note",columnDefinition = "TEXT",nullable = true)
	private String note;
	
	@OneToMany(mappedBy = "attivita", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<TipoPraticaAttivita> tipoPraticaAttivita;

	/*@Column(name = "scadenza",length=5 ,nullable = true)
	private Integer scadenza;*/
	
	@Override
	public void setId(Long id) {
		super.setId(id);
	}
	
	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	/*public Integer getScadenza() {
		return scadenza;
	}

	public void setScadenza(Integer scadenza) {
		this.scadenza = scadenza;
	}*/

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public List<TipoPraticaAttivita> getTipoPraticaAttivita() {
		return tipoPraticaAttivita;
	}

	public void setTipoPraticaAttivita(List<TipoPraticaAttivita> tipoPraticaAttivita) {
		this.tipoPraticaAttivita = tipoPraticaAttivita;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((descrizione == null) ? 0 : descrizione.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Attivita other = (Attivita) obj;
		if (descrizione == null) {
			if (other.descrizione != null)
				return false;
		} else if (!descrizione.equals(other.descrizione))
			return false;
		return true;
	}
	
	
}
