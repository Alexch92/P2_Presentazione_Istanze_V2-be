package it.sincon.sanita.portlet.apt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import it.sincon.sanita.services.beans.atp.DatiAttoJAXB;
import it.sincon.sanita.services.beans.atp.InputTrasparenzaJAXB;
import it.sincon.sanita.services.beans.atp.OutputTrasparenzaJAXB;
import it.sincon.sanita.services.service.SanitaAtpService;
import it.sincon.sanita.services.service.impl.SanitaAtpServiceImpl;
import it.sincon.sanita.utils.DatiAttoOrderByComparator;
import it.sincon.sanita.utils.PortletUtils;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.PortletSession;
import javax.portlet.PortletURL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringPool;

/**
 * Controller della portlet che visualizza gli atti prelevati dall'Albo Pretorio, ottenuti interrogando il 
 * REST Service di ENG
 * @author Santomauro
 *
 */
@Controller("aptPortletController")
@RequestMapping( "view" )
public class AlboPretorioTrasparenzaPortlet {
	private static final String HOME = "home";
	public static final String PORTLET_NAME = "albopretoriotrasparenza_WAR_pugliasaluterestful";
	private static Logger log = LoggerFactory.getLogger( AlboPretorioTrasparenzaPortlet.class );
	private SanitaAtpService service;
	
//	@Autowired
//	public ResourceBundleMessageSource messageSource;
	
	/**
	 * Default entry quando la portlet viene visualizzata per la prima volta.
	 * 
	 * @param model
	 *            il view model da popolare
	 * @return il view ID da renderizzare.
	 */
	@RenderMapping
	public String homePage( Model model, PortletSession session , PortletRequest request, PortletResponse response) throws Exception {
		log.info("AlboPretorioTrasparenzaPortlet - homePage...");
		int limit = Integer.parseInt(request.getPreferences().getValue("numRisultati", "10"));
		int defaultCur = 1;
		String defaultOrderByCol = "dataPubblicazione";
		String defaultOrderByType = "desc";
		
        // Eseguo la ricerca,...
        performeSearch(model, request, response, limit, defaultCur, defaultOrderByCol, defaultOrderByType);
		return renderHomeForm(model, session);
	}
	
	@RequestMapping(params = "action=searchAtti")
	public void searchAtti(Model model,  PortletSession session,
			ActionRequest request, ActionResponse response,
			@RequestParam("delta") int delta, @RequestParam("cur") int cur, 
			@RequestParam("orderByCol") String orderByCol, 
			@RequestParam("orderByType") String orderByType){
		
		log.info(String.format("AlboPretorioTrasparenzaPortlet - searchAtti... delta:%s, cur:%s, orderByCol:%s, orderByType:%s",
				delta, cur, orderByCol, orderByType));
		
		performeSearch(model, request, response, delta, cur, orderByCol, orderByType);
		response.setRenderParameter("action", "renderHomeForm");
	}
	
	/**
	 * Restituisce la jsp da visualizzare per inserimento/modifica
	 * @param model
	 * @return String
	 */
	@RenderMapping(params = "action=renderHomeForm")
	public String renderHomeForm(Model model, PortletSession session) {
		log.debug( "homePage-elencoAttivitaPortletController" );
		
		return  HOME ;
	}
	
	private void performeSearch(Model model, PortletRequest request, PortletResponse response,
			int _delta, int _cur, String _orderByCol, String _orderByType){

		String trasparenza = request.getPreferences().getValue("trasparenza", StringPool.BLANK);
		String tipoAtto = request.getPreferences().getValue("tipoAtto", StringPool.BLANK);
		String idAzienda = request.getPreferences().getValue("idAzienda", StringPool.BLANK);
		
		
		//Create Portlet URL and set required param for pagination
		PortletURL iteratorURL = PortletUtils.createPortletUrlToExternalPortlet(
				request, 
				response, 
				PORTLET_NAME, 
				null, 
				PortletRequest.ACTION_PHASE);
		iteratorURL.setParameter("action","searchAtti");

		// Inizializzo il SearchContainer...
		SearchContainer<DatiAttoJAXB> searchContainer = new SearchContainer<DatiAttoJAXB>(
				request, 
				null, 
				null, 
				SearchContainer.DEFAULT_CUR_PARAM, 
				_cur,
				_delta, 
				iteratorURL, 
				null, 
				"message.empty-result");
		searchContainer.setOrderByCol(_orderByCol);
		searchContainer.setOrderByType(_orderByType);
		searchContainer.setDeltaConfigurable(true);
		
        OrderByComparator orderByComparator = new DatiAttoOrderByComparator(
        		searchContainer.getOrderByCol(), searchContainer.getOrderByType());
        
        InputTrasparenzaJAXB filtriRicerca = new InputTrasparenzaJAXB();
        filtriRicerca.offset = searchContainer.getStart();
        filtriRicerca.limit = searchContainer.getDelta();
        filtriRicerca.tipoItem = tipoAtto;
        filtriRicerca.trasparenza = trasparenza;
        filtriRicerca.idAzienda = idAzienda;
        filtriRicerca.stati = null;
        
        List<DatiAttoJAXB> listaAttiOrdinata = null;
        OutputTrasparenzaJAXB restSearchResult = null;
        int numTotRisultati = 0;
		try {
			// Eseguo la chiamata al REST Service per la ricerca...
			restSearchResult = getService().ricercaInAlboPretorio(filtriRicerca);
			log.debug(String.format("trasparenzaBeans.size():%s", restSearchResult.trasparenzaBeans.size()));
			log.debug(String.format("elencoRisultatiCount:%s", restSearchResult.totalResult));
			
			// Ordino
	        listaAttiOrdinata = restSearchResult.trasparenzaBeans;
	        numTotRisultati = restSearchResult.totalResult;
	        Collections.sort(listaAttiOrdinata, orderByComparator);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			listaAttiOrdinata = new ArrayList<DatiAttoJAXB>();
			numTotRisultati = 0;
		}
        
		searchContainer.setResults(listaAttiOrdinata);
		searchContainer.setTotal(numTotRisultati);
        model.addAttribute("aptSearchContainer",searchContainer);
	}
	
	private SanitaAtpService getService(){
		if (this.service == null)
			this.service = new SanitaAtpServiceImpl();
		
		return this.service;
	}
}
