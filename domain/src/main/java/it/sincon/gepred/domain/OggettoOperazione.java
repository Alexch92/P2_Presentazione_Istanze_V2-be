package it.sincon.gepred.domain;

import java.io.Serializable;
import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 * @author Eligio Cavallo
 *
 */

public class OggettoOperazione extends AbstractPersistable<Long> implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public static final String ente="Ente";
	public static final String immobile="Immobile";
	public static final String comune="Comune";
	public static final String pratica="Pratica";
	public static final String praticaWeb="PraticaWeb";
	public static final String referente="Referente";
	public static final String campiaggiuntivi="Campi Aggiuntivi";	
	public static final String tipopratica="Tipologia Pratica";
	public static final String attivita="Attivita";
	public static final String qualifica="Qualifica";
	public static final String ruolo="Ruolo";
	public static final String categoria="Categoria";
	public static final String assegnazione="Assegnazione";
}
