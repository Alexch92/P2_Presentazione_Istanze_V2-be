package it.sincon.sanita.services.service;

import it.sincon.sanita.services.beans.atp.InputTrasparenzaJAXB;
import it.sincon.sanita.services.beans.atp.OutputTrasparenzaJAXB;
import it.sincon.sanita.services.service.impl.SanitaAtpServiceImpl;

import java.net.URISyntaxException;

public class SanitaAtpServiceUtil {
	private static SanitaAtpService _service;
	
	public static OutputTrasparenzaJAXB ricercaInAlboPretorio(InputTrasparenzaJAXB filtroRicerca) throws URISyntaxException, Exception{
		return getService().ricercaInAlboPretorio(filtroRicerca);
	}
	
	
	private static SanitaAtpService getService(){
		if (_service==null){
			_service = new SanitaAtpServiceImpl();
		}
		
		return _service;
	}
}
