package it.sincon.gepred.web.portlet.utils;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import it.sincon.gepred.domain.CampiAggiuntivi;
import it.sincon.gepred.domain.pratica.Preventivo;

public class CalcolaPunteggioUtils {
	private static Logger log = LoggerFactory.getLogger( CalcolaPunteggioUtils.class );
	
	@Value("#{applicationProperties.preventivo_sogliaSconto1}")
	private static String configSogliaSconto1;
	@Value("#{applicationProperties.preventivo_punteggioSconto1}")
	private static String configPunteggioSconto1;
	@Value("#{applicationProperties.preventivo_sogliaSconto2}")
	private static String configSogliaSconto2;
	@Value("#{applicationProperties.preventivo_punteggioSconto2}")
	private static String configPunteggioSconto2;
	
	public static int getPunteggioPreventivo(Preventivo preventivo) {
		int retValue = 0;
		
		double cfgSogliaSconto1 = 10;
		double cfgSogliaSconto2 = 20;
		int cfgPunteggioSconto1 = 5;
		int cfgPunteggioSconto2 = 10;
		try {
			cfgSogliaSconto1 = Double.parseDouble(configSogliaSconto1);
			cfgSogliaSconto2 = Double.parseDouble(configSogliaSconto2);
			cfgPunteggioSconto1 = Integer.parseInt(configPunteggioSconto1);
			cfgPunteggioSconto2 = Integer.parseInt(configPunteggioSconto2);
		} catch (Exception ex) {
			log.warn(ex.getMessage(), ex);
		}
		
		if (preventivo != null) {
			if (preventivo.getScontoUnitario() >= cfgSogliaSconto1 && preventivo.getScontoUnitario() < cfgSogliaSconto2)
				retValue = cfgPunteggioSconto1;
			else if (preventivo.getScontoUnitario() >= cfgSogliaSconto2)
				retValue = cfgPunteggioSconto2;
		}
		
		return retValue;
	}
	/**
	 * Calcola il punteggio per questo CampoAggiuntivo sulla base del suo valore e delle condizioni configurate
	 * tipologia di condizione_punteggio
	 *  valore#0                    - base - se il campo assume quel valore allora prenderà punteggio = campoaggiuntivo.punteggio
	 * 	valori#0:5@1:5@2:5@3:10@4:5 - associo ad ogni possibile valore il punteggio
	 *  range#0-7500:25@7501-15000:20@15001-17500:15@17501-20000:10
	 *  valoreGreaterThan#70        
	 * @param campo
	 * @param valoreCampo
	 * @return
	 */
	public static int getPunteggioCampoAggiuntivo(CampiAggiuntivi campo, String valoreCampo) {
		
		int retValue = 0;
		if (campo.getCondizionePunteggio() != null) {
			log.debug(String.format("getPunteggioCampoAggiuntivo :: ID=%S - condizionePunteggio=%s", campo.getId(), campo.getCondizionePunteggio()));
			
			if (campo.getCondizionePunteggio().isEmpty()) {
				log.warn(String.format("Condizione punteggio non configurata per il CampoAggiuntivo %s.%s!", campo.getId(), campo.getLabel()));
			} else {
				String[] condizioni = campo.getCondizionePunteggio().split(";");
				for (String condizione : condizioni) {
					String[] spltCond = condizione.split("#");
					
					if (spltCond == null) {
						log.warn(String.format("Condizione punteggio non configurata per il CampoAggiuntivo %s.%s!", campo.getId(), campo.getLabel()));
					} else {
						String tipoCondizione = spltCond[0];
						
						if (tipoCondizione.toLowerCase().equals("valore")) {
							retValue += getPunteggioValore(campo, spltCond[1], valoreCampo);
						} else if (tipoCondizione.toLowerCase().equals("valori")) {
							retValue += getPunteggioValori(campo, getValoriPunteggi(spltCond[1]), valoreCampo);
						} else if (tipoCondizione.toLowerCase().equals("range")) {
							retValue += getPunteggioRange(campo, getRangePunteggi(spltCond[1]), valoreCampo);
						} else if (tipoCondizione.toLowerCase().equals("valoregreaterthan")) {
							retValue += getPunteggioValoreGreaterThan(campo, spltCond[1], valoreCampo);
						} else {
							log.warn(String.format("Tipo Condizione %s non valida per calcolo punteggio per il CampoAggiuntivo %s.%s!", 
									condizione, campo.getId(), campo.getLabel()));
						}
					}
				}
			}
		} 
		
		return retValue;
	}
	
	private static int getPunteggioValore(CampiAggiuntivi campo, String strPos, String valoreCampo) {
		int retValue = 0;
		
		try {
			if (contieneValore(campo, Integer.parseInt(strPos), valoreCampo)) {
				retValue = campo.getPunteggio();
			}
		} catch (Exception ex) {
			log.warn(ex.getMessage(), ex);
		}
		
		return retValue;
	}
	/**
	 * valoreGreaterThan#70
	 * @param campo
	 * @param condizione
	 * @param valoreCampo
	 * @return
	 */
	private static int getPunteggioValoreGreaterThan(CampiAggiuntivi campo, String condizione, String valoreCampo) {
		int retValue = 0;
		
		try {
			double valCampoNumerico = Double.parseDouble(valoreCampo.replace("%", ""));
			double valSoglia = Double.parseDouble(condizione);
			
			if (valCampoNumerico > valSoglia) {
				retValue = campo.getPunteggio();
			}
		} catch (Exception ex) {
			log.warn(ex.getMessage(), ex);
		}
		
		return retValue;
	}
	
	private static int getPunteggioRange(CampiAggiuntivi campo, List<DtoPunteggioRange> rangePunteggi, String valoreCampo) {
		int retValue = 0;
		
		try {
			double valCampoNumerico = Double.parseDouble(valoreCampo.replace(",", "."));
			log.debug(String.format("valCampoNumerico: %s", valCampoNumerico));
			for (DtoPunteggioRange dtoRange : rangePunteggi) {
				log.debug(String.format("dtoRange.getSogliaDa(): %s - dtoRange.getSogliaA(): %s", dtoRange.getSogliaDa(), dtoRange.getSogliaA()));
				if (valCampoNumerico >= dtoRange.getSogliaDa() && valCampoNumerico <= dtoRange.getSogliaA()) {
					retValue = dtoRange.getPunteggio();
					break;
				}
			}
		} catch (Exception ex) {
			log.warn(ex.getMessage(), ex);
		}
		
		log.debug(String.format("getPunteggioRange: %s", retValue));
		return retValue;
	}
	
	/**
	 * Estrae la lista di range con i relativi punteggi.
	 * @param condizioneRange deve rispettare questo formato: 
	 * valDa-ValA:punt@valDa-ValA:punt@valDa-ValA:punt
	 * @return
	 */
	private static List<DtoPunteggioRange> getRangePunteggi(String condizioneRange){
		log.debug(String.format("getRangePunteggi :: condizioneRange=%s", condizioneRange));
		
		int valDa = 0; int valA = 0; int punt = 0;
		List<DtoPunteggioRange> retValue = new ArrayList<DtoPunteggioRange>();
		boolean formatoValido = false;
		
		String[] listaIntervalli = condizioneRange.split("@");
		log.debug(String.format("getRangePunteggi :: listaIntervalli.length=%s", listaIntervalli.length));
		if (listaIntervalli != null) {
			formatoValido = true;
			for (String intervallo : listaIntervalli) {
				log.debug(String.format("getRangePunteggi :: intervallo=%s", intervallo));
				valDa = valA = punt = 0;
				String[] spltInt = intervallo.split(":");
				
				if (spltInt == null) {
					formatoValido = false;
				} else {
					try {
						log.debug(String.format("getRangePunteggi :: spltInt.length=%s", spltInt.length));
						punt = Integer.parseInt(spltInt[1]);
						valDa = Integer.parseInt(spltInt[0].split("-")[0]);
						valA = Integer.parseInt(spltInt[0].split("-")[1]);
						
						retValue.add(new DtoPunteggioRange(valDa, valA, punt));
					} catch (Exception ex) {
						log.warn(ex.getMessage());
						formatoValido = false;
					}
				}
			}
		} 
		
		if (!formatoValido) {
			log.warn("Formato stringa di range per punteggio non valido!");
		}
		
		return retValue;
	}
	
	
	private static boolean contieneValore(CampiAggiuntivi campo, int valoreIdx, String valoreCampo){
		boolean ret = false;
		String listaValori[] = campo.getListaValori().split(",");

		if (listaValori !=null && listaValori.length >= valoreIdx){
		
			if (valoreCampo!=null){
				if(valoreCampo.contains(listaValori[valoreIdx]))
					ret = true;
			}
		}

		return ret;
	}
	
	/**
	 * Estrae la lista di idxValoriCampo con i relativi punteggi.
	 * @param condizioneValori deve rispettare questo formato: 
	 * idxValore1:punt1@idxValore2:punt2
	 * @return
	 */
	private static List<DtoPunteggioRange> getValoriPunteggi(String condizioneValori){
		log.debug(String.format("getValoriPunteggi :: condizioneRange=%s", condizioneValori));
		
		int idxValCa = 0; int punt = 0;
		List<DtoPunteggioRange> retValue = new ArrayList<DtoPunteggioRange>();
		boolean formatoValido = false;
		
		String[] listaIntervalli = condizioneValori.split("@");
		log.debug(String.format("getValoriPunteggi :: listaIntervalli.length=%s", listaIntervalli.length));
		if (listaIntervalli != null) {
			formatoValido = true;
			for (String intervallo : listaIntervalli) {
				log.debug(String.format("getValoriPunteggi :: intervallo=%s", intervallo));
				idxValCa = punt = 0;
				String[] spltInt = intervallo.split(":");
				
				if (spltInt == null) {
					formatoValido = false;
				} else {
					try {
						log.debug(String.format("getValoriPunteggi :: spltInt.length=%s", spltInt.length));
						idxValCa = Integer.parseInt(spltInt[0]);
						punt = Integer.parseInt(spltInt[1]);
						
						retValue.add(new DtoPunteggioRange(idxValCa, punt));
					} catch (Exception ex) {
						log.warn(ex.getMessage());
						formatoValido = false;
					}
				}
			}
		} 
		
		if (!formatoValido) {
			log.warn("Formato stringa di range per punteggio non valido!");
		}
		
		return retValue;
	}
	private static int getPunteggioValori(CampiAggiuntivi campo, List<DtoPunteggioRange> valoriPunteggi, String valoreCampo) {
		int retValue = 0;
		
		try {
			log.debug(String.format("valoreCampo: %s", valoreCampo));
			log.debug(String.format("campo.getListaValori(): %s", campo.getListaValori()));
			for (DtoPunteggioRange dtoRange : valoriPunteggi) {
				log.debug(String.format("dtoRange.getIdxValoreCampo(): %s - dtoRange.getPunteggio(): %s", dtoRange.getIdxValoreCampo(), dtoRange.getPunteggio()));
				if (valoreCampo != null) {
					if (valoreCampo.toLowerCase().contains(campo.getListaValoriArray()[dtoRange.getIdxValoreCampo()].toLowerCase())) {
						retValue += dtoRange.getPunteggio();
					}
				}
			}
		} catch (Exception ex) {
			log.warn(ex.getMessage(), ex);
		}
		
		log.debug(String.format("getPunteggioRange: %s", retValue));
		return retValue;
	}
}
