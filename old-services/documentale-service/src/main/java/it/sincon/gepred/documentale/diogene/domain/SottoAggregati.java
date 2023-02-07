package it.sincon.gepred.documentale.diogene.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "tb_sottoAggregatiDiogene")
public class SottoAggregati extends AbstractPersistable<Long> implements Serializable {
	@Column(name="uuid_padre", nullable = false)
	private String uuidContenitorePadre;
	@Column(name="uuid_figlio", nullable = false)
	private String uuidContenitoreFiglio;
	@Column(name="ord_figlio", nullable = false)
	private int ordinaleFiglio;
	@Column(name="counter", nullable = false)
	private int nrFigli;
	
	public SottoAggregati(){
		super();
	}
	
	public SottoAggregati(String _uuidPadre, String _uuidFiglio, int _ordFiglio, int _nrFigli){
		super();
		this.uuidContenitorePadre=_uuidPadre;
		this.uuidContenitoreFiglio=_uuidFiglio;
		this.ordinaleFiglio=_ordFiglio;
		this.nrFigli=_nrFigli;
	}
	
	public String getUuidContenitorePadre() {
		return uuidContenitorePadre;
	}
	public void setUuidContenitorePadre(String uuidContenitorePadre) {
		this.uuidContenitorePadre = uuidContenitorePadre;
	}
	public String getUuidContenitoreFiglio() {
		return uuidContenitoreFiglio;
	}
	public void setUuidContenitoreFiglio(String uuidContenitoreFiglio) {
		this.uuidContenitoreFiglio = uuidContenitoreFiglio;
	}
	public int getOrdinaleFiglio() {
		return ordinaleFiglio;
	}
	public void setOrdinaleFiglio(int ordinaleFiglio) {
		this.ordinaleFiglio = ordinaleFiglio;
	}
	public int getNrFigli() {
		return nrFigli;
	}
	public void setNrFigli(int nrFigli) {
		this.nrFigli = nrFigli;
	}
	
}
