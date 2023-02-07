package it.osapulie.web.portlet.util;


public class PortletConstants {

	public static final String STATO_DELEGA_ATTIVA = "attiva";
	public static final String STATO_DELEGA_INATTIVA = "inattiva";

	/**
	 * Stato iniziale della richiesta (in attesa di verifica da parte del Comune)
	 */
	public static final String STATO_PIN_RICHIESTO = "RICHIESTO";
	/**
	 * Richiesta respinta dal Comune
	 */
	public static final String STATO_PIN_RESPINTO = "RESPINTO";
	/**
	 * Richiesta annullata dal Cittadino
	 */
	public static final String STATO_PIN_ANNULLATO = "ANNULLATO";
	/**
	 * Richiesta evasa positivamente dal Comune (PIN assegnato)
	 */
	public static final String STATO_PIN_ASSEGNATO = "ASSEGNATO";

}
