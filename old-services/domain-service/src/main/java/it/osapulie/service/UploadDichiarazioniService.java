package it.osapulie.service;

import it.osapulie.domain.ProfiloUtente;
import it.osapulie.shared.service.UserPreferences;
import it.osapulie.web.portlet.util.UploadItem;

import java.io.IOException;

import javax.portlet.PortletException;

public interface UploadDichiarazioniService {

	public void processaUploadDichiarazioni( String tipologia, UploadItem uploadItem,ProfiloUtente profiloUtente , UserPreferences userPreferences) throws PortletException, IOException ;
}
