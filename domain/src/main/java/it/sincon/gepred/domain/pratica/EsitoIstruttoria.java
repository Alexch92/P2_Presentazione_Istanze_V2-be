package it.sincon.gepred.domain.pratica;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 * Classe che definisce l'esito scelto dall'istruttore quando dichiara conclusa l'istruttoria e porta 
 * lo stato pratica in ISTRUTTORIA CONCLUSA
 * @author Antonio Santomauro
 */
@Entity
@Table(name = "tb_esitoistruttoria")
public class EsitoIstruttoria extends AbstractPersistable<Long> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -247798258529795889L;
	
	@Column(name="descrizione", length=255)
	private String descrizione;

	public String getDescrizione() {		
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	@Override
	public void setId(Long id) {
		super.setId(id);
	}
}
