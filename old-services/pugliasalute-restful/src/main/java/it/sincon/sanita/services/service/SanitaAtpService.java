package it.sincon.sanita.services.service;

import it.sincon.sanita.services.beans.atp.DatiAttoJAXB;
import it.sincon.sanita.services.beans.atp.InputTrasparenzaJAXB;
import it.sincon.sanita.services.beans.atp.OutputTrasparenzaJAXB;

import java.net.URISyntaxException;
import java.util.List;

public interface SanitaAtpService {
	public OutputTrasparenzaJAXB ricercaInAlboPretorio(InputTrasparenzaJAXB filtriRicerca) 
			throws URISyntaxException, Exception;
	
}
