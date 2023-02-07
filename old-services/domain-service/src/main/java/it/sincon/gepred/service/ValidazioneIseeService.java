package it.sincon.gepred.service;

import java.util.List;

import it.sincon.gepred.web.portlet.varie.DatiValidazioneIsee;

public interface ValidazioneIseeService {
	public void eseguiValidazione(List<DatiValidazioneIsee> datiValidazioneIsee);
}
