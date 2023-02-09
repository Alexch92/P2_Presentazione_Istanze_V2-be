package it.sincon.gepred.domain.pratica;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 * 
 * @author Giuseppe Cellamare
 *
 */
@Entity
@Table(name="tb_tab")
public class Tab  extends AbstractPersistable<Long> implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Column(name="descrizione",nullable=false,length=255)
	private String descrizione;

	@Column(name="cancellabile",nullable=false,length=1)
	private boolean cancellabile;
	
	@Column(name="master_tab",nullable=false,length=1)
	private boolean master;
	
	@Override
	public void setId(Long id) {
		super.setId(id);
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public boolean isCancellabile() {
		return cancellabile;
	}

	public void setCancellabile(boolean cancellabile) {
		this.cancellabile = cancellabile;
	}

	public boolean isMaster() {
		return master;
	}

	public void setMaster(boolean master) {
		this.master = master;
	}
	
	
}
