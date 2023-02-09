package it.sincon.gepred.domain.pratica;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "tb_numero_pratica")
public class NumeroPratica extends AbstractPersistable<Long> implements
		Serializable {

	private static final long serialVersionUID = 93475320971287639L;

	@Column(name = "prefisso", length = 20, nullable = true)
	private String prefisso;

	@Column(name = "anno", nullable = false)
	private Integer anno;
	
	@Column(name = "progressivo", nullable = false)
	private Long progressivo;
	
	public void setId(Long id) {
		super.setId(id);
	}
	public String getPrefisso() {
		return prefisso;
	}
	public void setPrefisso(String prefisso) {
		this.prefisso = prefisso;
	}
	public Integer getAnno() {
		return anno;
	}
	public void setAnno(Integer anno) {
		this.anno = anno;
	}
	public Long getProgressivo() {
		return progressivo;
	}
	public void setProgressivo(Long progressivo) {
		this.progressivo = progressivo;
	}
	
	
	@Override
	public String toString() {
		
		if (prefisso!=null && !prefisso.isEmpty())
			return String.format("%s/%05d/%s", prefisso, progressivo, anno);
		else
			return String.format("%05d/%s", progressivo, anno);
	}
}
