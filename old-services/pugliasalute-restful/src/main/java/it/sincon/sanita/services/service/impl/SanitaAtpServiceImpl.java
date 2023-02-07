package it.sincon.sanita.services.service.impl;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import flexjson.JSONDeserializer;
import it.sincon.sanita.services.beans.atp.AlboPretorioRestResponse;
import it.sincon.sanita.services.beans.atp.DatiAttoJAXB;
import it.sincon.sanita.services.beans.atp.InputTrasparenzaJAXB;
import it.sincon.sanita.services.beans.atp.OutputTrasparenzaJAXB;
import it.sincon.sanita.services.service.SanitaAtpService;
import it.sincon.sanita.utils.PortletUtils;

public class SanitaAtpServiceImpl implements SanitaAtpService {
	private static Logger log = LoggerFactory.getLogger( SanitaAtpServiceImpl.class );
	private final ResourceBundle resourceBundle = ResourceBundle.getBundle("portlet");
	
	private String aptRestURL = resourceBundle.getString("alboPretorioTrasparenza.service.url");

	@Override
	public OutputTrasparenzaJAXB ricercaInAlboPretorio(InputTrasparenzaJAXB filtriRicerca) throws URISyntaxException, Exception {

		Map<String,String> reqParams = new LinkedHashMap<String, String>();
		if (filtriRicerca.idAzienda!=null)
			reqParams.put("idAzienda", filtriRicerca.idAzienda);
		if (filtriRicerca.tipoItem!=null)
			reqParams.put("tipoItem", filtriRicerca.tipoItem);
		if (filtriRicerca.trasparenza!=null)
			reqParams.put("trasparenza", filtriRicerca.trasparenza);
		if (filtriRicerca.limit!=null)
			reqParams.put("limit", String.valueOf(filtriRicerca.limit));
		if (filtriRicerca.offset!=null)
			reqParams.put("offset", String.valueOf(filtriRicerca.offset));
		if (filtriRicerca.stati!=null)
			reqParams.put("stati", filtriRicerca.getStatiJson());
		
		String url = String.format("%s?%s", aptRestURL, PortletUtils.createQueryString(reqParams));
		
		log.info(String.format("Chiamata al servizio AlboPretorioWeb %s...", url));
		String jsonResponseString = PortletUtils.sendRequestHTTPGet(null, url);
		log.debug(String.format("Risposta del servizio AlboPretorioWeb: result=%s", jsonResponseString));
		
		//devo convertire il json in object
//		DateObjectFactory.addDefaultFormat(getFtvResponseDateFormat());
		JSONDeserializer<AlboPretorioRestResponse> deserializer = new JSONDeserializer<AlboPretorioRestResponse>();
		AlboPretorioRestResponse resultObject = deserializer.deserialize(jsonResponseString,AlboPretorioRestResponse.class);	
		
		return resultObject.outputTrasparenza;
	}

}
