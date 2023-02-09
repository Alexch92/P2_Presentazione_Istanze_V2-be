package it.sincon.gepred.domain.pratica;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 * Classe che definisce l'esito del parere
 * @author Maria Michela Birtolo
 */
@Entity
@Table(name = "tb_inviomail_urpaccounts")
public class UrpMailAccount extends AbstractPersistable<Long> implements Serializable {

	private static final long serialVersionUID = -247798258529795889L;
	
	@Column(name="urp_interessato", length=255)
	private String urp;

	@Column(name="urp_mail", length=255)
	private String mailAccount;

	public String getUrp() {
		return urp;
	}

	public void setUrp(String urp) {
		this.urp = urp;
	}

	public String getMailAccount() {
		return mailAccount;
	}

	public void setMailAccount(String mailAccount) {
		this.mailAccount = mailAccount;
	}
}
