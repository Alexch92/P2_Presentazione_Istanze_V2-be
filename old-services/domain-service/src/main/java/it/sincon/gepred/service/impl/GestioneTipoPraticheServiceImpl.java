package it.sincon.gepred.service.impl;
/**
 * Implementazione di {@link GestioneTipoPraticheService} 
 * 
 * @author Eligio Cavallo
 * @author Angelo Pascadopoli
 */
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import it.osapulie.domain.Ruolo;
import it.osapulie.persistence.RuoloRepository;
import it.osapulie.service.ServiceLayerException;
import it.osapulie.web.portlet.util.PortletHelper;
import it.sincon.gepred.domain.Allegati;
import it.sincon.gepred.domain.pratica.CategoriePratiche;
import it.sincon.gepred.domain.pratica.Tab;
import it.sincon.gepred.domain.pratica.TipoPratica;
import it.sincon.gepred.domain.pratica.TipoPraticaTab;
import it.sincon.gepred.persistence.AllegatiRepository;
import it.sincon.gepred.persistence.TipoPraticaRepository;
import it.sincon.gepred.service.GestioneCategoriePraticheService;
import it.sincon.gepred.service.GestioneTabService;
import it.sincon.gepred.service.GestioneTipoPraticheService;
import it.sincon.gepred.web.portlet.utils.ServiceHelper;
import it.sincon.gepred.web.portlet.varie.DatiRicercaTipoPratica;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("gestioneTipoPraticheService")
public class GestioneTipoPraticheServiceImpl implements GestioneTipoPraticheService{
	
	private static Logger log = LoggerFactory.getLogger(GestioneTipoPraticheServiceImpl.class);

	@PersistenceContext(unitName="gepred")
	private EntityManager em;
	
	@Inject
	private TipoPraticaRepository tipoPraticaRepository;
	
	//@Inject
	//private PortletHelper helper;
	
	@Inject
	private RuoloRepository repositoryRuolo;
	
	@Inject
	private GestioneCategoriePraticheService categorieService;
	
	@Inject
	private GestioneTabService tabService;
	
	@Inject
	private AllegatiRepository allegatiRepository;

	/**
	 * Metodo che ricerca il tipo di pratiche
	 */
	public List<TipoPratica> searchTipoPratiche(
			DatiRicercaTipoPratica filtriRicerca) {

			log.debug("searchTipoPratiche :: entering method");
			String queryString = "select tp from TipoPratica tp where 1=1 ";
			
			if (filtriRicerca.getFiltroDescrizione() != null && !filtriRicerca.getFiltroDescrizione().equals("")) {
				queryString += " AND lower(tp.descrizione) LIKE lower(?1)";
			}
			/*if (filtriRicerca.getFiltroAllegati() != null) {
				queryString += " AND lower(tp.allegati.nomeDocumento) LIKE lower(?2)";
			}
			if(filtriRicerca.getFiltroModelli()!= null){
				queryString += " AND lower(tp.modelli.nome) LIKE lower(?3)";
			}*/
			Query query = em.createQuery(queryString, TipoPratica.class);
			
			if (filtriRicerca.getFiltroDescrizione() != null && !filtriRicerca.getFiltroDescrizione().equals("")) {
				query.setParameter(1, "%" + filtriRicerca.getFiltroDescrizione().toLowerCase() + "%");
			}
			/*if (filtriRicerca.getFiltroAllegati() != null  && !filtriRicerca.getFiltroAllegati().equals("")) {
				query.setParameter(2, "%" + filtriRicerca.getFiltroAllegati().toLowerCase() + "%");
			}
			if (filtriRicerca.getFiltroModelli() != null && !filtriRicerca.getFiltroModelli().equals("")) {
				query.setParameter(3, "%" + filtriRicerca.getFiltroModelli().toLowerCase() + "%");
			}*/
			return (List<TipoPratica>)query.getResultList();
	}

	@Transactional
	public TipoPratica saveTipoPratica(TipoPratica tipoPratica) throws ServiceLayerException {
		TipoPratica result = null;
		try {
			if (tipoPratica.getDaCancellare()!=null) {
				for(Allegati daCancellare:tipoPratica.getDaCancellare()) {
					if (daCancellare.getTipoPratica()!=null) {
						daCancellare.setTipoPratica(null);
						allegatiRepository.save(daCancellare);
					}
				}
			}
			for (int i = 0; (tipoPratica.getCampiAggiuntiviTipoPratica() != null && i < tipoPratica.getCampiAggiuntiviTipoPratica().size()); i++) {
				tipoPratica.getCampiAggiuntiviTipoPratica().get(i).setTipoPratica(tipoPratica);
				byte conf_cagg = (byte) (tipoPratica.getCampiAggiuntiviTipoPratica().get(i).getBackFrontEnd());
				tipoPratica.getCampiAggiuntiviTipoPratica().get(i).setConfig_cagg(ServiceHelper.setBitMask(new byte[] {conf_cagg}));
				log.debug("Tab selezionato per il campo aggiuntivo "+i+" = "+tipoPratica.getCampiAggiuntiviTipoPratica().get(i).getTab().getDescrizione());
			}	
			for (int i = 0; (tipoPratica.getTipoPraticaAttivita() != null && i < tipoPratica.getTipoPraticaAttivita().size()); i++) {
				tipoPratica.getTipoPraticaAttivita().get(i).setTipoPratica(tipoPratica);
			}
			for(int i=0; (tipoPratica.getAllegati() != null && i < tipoPratica.getAllegati().size()); i++ ){
				tipoPratica.getAllegati().get(i).setTipoPratica(tipoPratica);				
			}
			for(int i=0; (tipoPratica.getModelli() != null && i < tipoPratica.getModelli().size()); i++ ){
				tipoPratica.getModelli().get(i).setTipoPratica(tipoPratica);				
			}
			// Salvo la configurazione della tipologia
			byte config = ServiceHelper.setBitMask(new byte[] {tipoPratica.getShowMittDest(), 
															   tipoPratica.getShowStato(), 
															   tipoPratica.getShowTipoInt(), 
															   tipoPratica.getShowLocalita(),
															   tipoPratica.getAutomaticAssign(),
															   tipoPratica.getShowInviaMailDaAllegato(),
															   tipoPratica.getShowVisibileOnLine(),
															   tipoPratica.getAutomaticProtocol()});
			tipoPratica.setConfigurazione(config);
			for(int i=0;(tipoPratica.getSchede() != null && i<tipoPratica.getSchede().size());i++){
				if (tipoPratica.getSchede().get(i).getTab().isNew())
				{
					Tab tab = tabService.saveTab(tipoPratica.getSchede().get(i).getTab());
					tipoPratica.getSchede().get(i).setTab(tab);
				}
				tipoPratica.getSchede().get(i).setTipoPratica(tipoPratica);
				log.debug("Verifica ruoli abilitati al tab: "+tipoPratica.getSchede().get(i).getTab().getDescrizione());
				if (tipoPratica.getSchede().get(i).getRuoliScrittura()!=null && tipoPratica.getSchede().get(i).getRuoliScrittura().size()>0)
				{
					for(int j=0;j<tipoPratica.getSchede().get(i).getRuoliScrittura().size();j++)
						log.debug(tipoPratica.getSchede().get(i).getRuoliScrittura().get(j).getNome());
				}
				else
					log.debug("Ruoli vuota");
			}
			result = tipoPraticaRepository.save(tipoPratica);
		} catch (Exception e) {
			throw new ServiceLayerException("There was an error when saving an object of type TipoPratica :: " + e.getMessage(), e);
		}
		return result;
	}

	public TipoPratica getTipoPraticaByPk(long pk) throws ServiceLayerException {
		TipoPratica tipoPratica = tipoPraticaRepository.findOne(pk);
		
		// Carico la configurazione dei campi aggiuntivi
		for (int i = 0; (tipoPratica.getCampiAggiuntiviTipoPratica() != null && i < tipoPratica.getCampiAggiuntiviTipoPratica().size()); i++) {
			byte conf = tipoPratica.getCampiAggiuntiviTipoPratica().get(i).getConfig_cagg();
			if (ServiceHelper.checkBitMask(conf, ServiceHelper.FRONT_END_MAIN_PAG_MASK)) 
				tipoPratica.getCampiAggiuntiviTipoPratica().get(i).setBackFrontEnd(ServiceHelper.FRONT_END_MAIN_PAG_MASK);
			if (ServiceHelper.checkBitMask(conf, (byte) (ServiceHelper.BACK_END_MAIN_PAG_MASK))) 
				tipoPratica.getCampiAggiuntiviTipoPratica().get(i).setBackFrontEnd(ServiceHelper.BACK_END_MAIN_PAG_MASK);
			if (ServiceHelper.checkBitMask(conf, (byte) (ServiceHelper.BACK_FRONT_END_MAIN_PAG_MASK))) 
				tipoPratica.getCampiAggiuntiviTipoPratica().get(i).setBackFrontEnd(ServiceHelper.BACK_FRONT_END_MAIN_PAG_MASK);
		}
		// Carico la configurazione della tipologia
		byte config = tipoPratica.getConfigurazione();
		if (ServiceHelper.checkBitMask(config, ServiceHelper.SHOW_MITT_DEST))
			tipoPratica.setShowMittDest(ServiceHelper.SHOW_MITT_DEST);
		if (ServiceHelper.checkBitMask(config, ServiceHelper.SHOW_STATO))
			tipoPratica.setShowStato(ServiceHelper.SHOW_STATO);
		if (ServiceHelper.checkBitMask(config, ServiceHelper.SHOW_TIP_INT))
			tipoPratica.setShowTipoInt(ServiceHelper.SHOW_TIP_INT);
		if (ServiceHelper.checkBitMask(config, ServiceHelper.SHOW_LOCALITA))
			tipoPratica.setShowLocalita(ServiceHelper.SHOW_LOCALITA);
		if (ServiceHelper.checkBitMask(config, ServiceHelper.AUTOMATIC_ASSIGN))
			tipoPratica.setAutomaticAssign(ServiceHelper.AUTOMATIC_ASSIGN);
		if (ServiceHelper.checkBitMask(config, ServiceHelper.SHOW_INVIA_MAIL_DA_ALLEGATO))
			tipoPratica.setShowInviaMailDaAllegato(ServiceHelper.SHOW_INVIA_MAIL_DA_ALLEGATO);
		if (ServiceHelper.checkBitMask(config, ServiceHelper.SHOW_VISIBILE_ON_LINE))
			tipoPratica.setShowVisibileOnLine(ServiceHelper.SHOW_VISIBILE_ON_LINE);
		if (ServiceHelper.checkBitMask(config, ServiceHelper.AUTOMATIC_PROTOCOL))
			tipoPratica.setAutomaticProtocol(ServiceHelper.AUTOMATIC_PROTOCOL);

		return tipoPratica;
	}

	public void deleteTipoPratica(long pk) throws ServiceLayerException {
		tipoPraticaRepository.delete(pk);
	}
	
	// NON ANCORA UTILIZZATO!!
	/*public List<TipoPratica> getTipoPraticaByRole(List<TipoPratica> lista) throws SystemException {
		Ruolo role = repositoryRuolo.findOne(helper.getOsApulieUserDetails().getLiferayUser().getRoleIds()[0]);
		List<TipoPratica> result = new ArrayList<TipoPratica>();
		for (TipoPratica tp : lista) {
			CategoriePratiche root = categorieService.getRoot(tp.getCategoria());
			if (tp.getCategoria().getParent() !=null && role.getCategorieAbilitate().contains(tp.getCategoria()))
				result.add(tp);
		}
		return result;
	}
*/
	
	public List<String> listaPrefissi() {
		
		List<String> prefissi = new ArrayList<String>();
		List<TipoPratica> lista = tipoPraticaRepository.findAll();
		for (TipoPratica t : lista)
			if (!prefissi.contains("\"" + t.getPrefisso() + "\""))
				prefissi.add("\"" + t.getPrefisso() + "\"");
		
		return prefissi;
	}

	public List<Tab> getRemainingTab(TipoPratica tipoPratica) {
		List<Tab> result = tabService.searchAllTab();
		List<Long> idTabs = new ArrayList<Long>();
		List<Tab> daCancellare = new ArrayList<Tab>();
		for(TipoPraticaTab tabSelezionato:tipoPratica.getSchede())
		{
			if (!tabSelezionato.getTab().isNew())
				idTabs.add(tabSelezionato.getTab().getId());
		}
		for(Long idCancellare: idTabs)
		{
			boolean found=false;
			for(int i=0;i<result.size()&&!found;i++)
			{
				found = result.get(i).getId().equals(idCancellare);
				if (found)
					daCancellare.add(result.get(i));
			}
		}
		result.removeAll(daCancellare);
		return result;
	}

	public List<TipoPratica> getTipoPraticaByFrontend() {
		log.debug("getTipoPraticaByFrontend");
		
		return tipoPraticaRepository.findByFrontend(true);
		
	}

	@Override
	public List<TipoPratica> getTipoPraticaByCategoriaAndFrontend(
			CategoriePratiche categoria) {
		return tipoPraticaRepository.findByCategoriaAndFrontend(categoria, true);
	}

}
