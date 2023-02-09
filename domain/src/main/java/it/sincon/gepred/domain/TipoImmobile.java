package it.sincon.gepred.domain;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 * Classe che definisce la tipologia di immobile
 * @author Eligio Cavallo
 */
@Entity
@Table(name = "tb_tipoimmobile")
public class TipoImmobile extends AbstractPersistable<Long> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name="descrizione", length=255)
	private String descrizione;
	
	public void setId(Long id) {
		super.setId(id);
	}
	
	public String getDescrizione() {		
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	
}


