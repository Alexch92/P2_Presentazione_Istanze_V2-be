package it.sincon.gepred.domain;

import java.io.Serializable;
import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 * @author Eligio Cavallo
 *
 */

public class TipoOperazione extends AbstractPersistable<Long> implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public static final String inserisci="Inserimento";
	public static final String modifica="Modifica";
	public static final String elimina="Eliminazione";
	public static final String stampa="Stampa";	
	public static final String invio="Invio";
	public static final String protocollo="Protocollo";
	public static final String inoltra="Inoltra";
}
