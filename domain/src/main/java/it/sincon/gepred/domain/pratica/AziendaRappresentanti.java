package it.sincon.gepred.domain.pratica;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 * 
 * @author Antonio Santomauro
 *
 */
@Entity
@Table(name="tb_azienda_rappresentanti")
public class AziendaRappresentanti  extends AbstractPersistable<Long> implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@JoinColumn(name = "fk_azienda", insertable = false, nullable = false)
	Azienda azienda;

	@JoinColumn(name = "fk_rappresentante", insertable = false, nullable = false)
	RappresentanteLegale rappresentante;
	
	@Column(name="potere_firma", nullable = false, length=1)
	private boolean potereFirma;
		
	@Override
	public void setId(Long id) {
		super.setId(id);
	}

	public Azienda getAzienda() {
		return azienda;
	}

	public void setAzienda(Azienda azienda) {
		this.azienda = azienda;
	}

	public RappresentanteLegale getRappresentante() {
		return rappresentante;
	}

	public void setRappresentante(RappresentanteLegale rappresentante) {
		this.rappresentante = rappresentante;
	}

	public boolean isPotereFirma() {
		return potereFirma;
	}

	public void setPotereFirma(boolean potereFirma) {
		this.potereFirma = potereFirma;
	}

	
}
