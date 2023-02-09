package it.sincon.gepred.domain.pratica;

/**
 * @author Davide Ciannamea - Sincon srl 
 * 
 * 
 */

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "tb_qualifica")
public class Qualifica extends AbstractPersistable<Long> implements Serializable {

	private static final long serialVersionUID = 69955298317664502L;
	
	@Column(name="codicequalifica")
	private int codicequalifica;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name = "visWeb",length=1, nullable = true)
	private boolean visWeb;
	
	
	public int getCodicequalifica() {
		return codicequalifica;
	}
	public void setCodicequalifica(int codicequalifica) {
		this.codicequalifica = codicequalifica;
	}
	public boolean isVisWeb() {
		return visWeb;
	}
	public void setVisWeb(boolean visWeb) {
		this.visWeb = visWeb;
	}
	
	public String getNome() {
			return nome;
	}
	public void setNome (String Nome) {
			this.nome = Nome;
	}
	
}