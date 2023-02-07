package it.osapulie.service.impl;

import it.osapulie.domain.ProfiloUtente;
import it.osapulie.domain.Ruolo;
import it.osapulie.persistence.ProfiloUtenteRepository;
import it.osapulie.persistence.RuoloRepository;
import it.osapulie.service.ProfiloUtenteService;
import it.osapulie.service.ServiceLayerException;
import it.sincon.gepred.domain.pratica.CategoriePratiche;
import it.sincon.gepred.web.portlet.varie.DatiRicercaProfiloUtente;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.jfree.util.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("profiloUtenteService")
@Transactional
public class ProfiloUtenteServiceImpl implements ProfiloUtenteService {

	private static Logger log = LoggerFactory.getLogger(ProfiloUtenteServiceImpl.class);
	
	@Inject
	private ProfiloUtenteRepository profiloUtenteCittadinoRepository;
	@Inject
	private RuoloRepository ruoloRepository;

	@PersistenceContext(unitName="gepred")
	private EntityManager em;
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see it.osapulie.service.ProfiloUtenteService#getAllProfiloUtente()
	 */
	@Override
	public List<ProfiloUtente> getAllProfiloUtenteCittadino() throws ServiceLayerException {
		return (List<ProfiloUtente>) profiloUtenteCittadinoRepository.findAll();
	}
	
	/*
	 * (non-Javadoc)
	 * @see it.osapulie.service.ProfiloUtenteService#searchProfili(DatiRicercaProfiloUtente)
	 */
	public List<ProfiloUtente> searchProfiliByCategorie(List<CategoriePratiche> categorie) throws ServiceLayerException  {
		log.info("****************ProfiloUtenteServiceImpl****************************");
		String queryString = "select DISTINCT pr from ProfiloUtente pr LEFT OUTER JOIN pr.ruoli ru LEFT OUTER JOIN ru.categorieAbilitate cat where cat.id IN ( ";

		for (int i=0; i < categorie.size(); i++){
			queryString +="'"+categorie.get(i).getId().toString()+"'";
			if(i< (categorie.size() - 1))
				queryString += ",";
		}
				
		queryString +=") ORDER BY pr.cognome,pr.nome DESC ";
		
		
		log.info("QUERY:"+queryString);
		
		
		Query query = em.createQuery(queryString, ProfiloUtente.class);

		
		
		log.info("*********************************************************");
		
		return (List<ProfiloUtente>) query.getResultList();
	}
	
	/*
	 * (non-Javadoc)
	 * @see it.osapulie.service.ProfiloUtenteService#searchProfili(DatiRicercaProfiloUtente)
	 */
	public List<ProfiloUtente> searchProfili(DatiRicercaProfiloUtente filtriRicerca) throws ServiceLayerException  {
		log.info("****************ProfiloUtenteServiceImpl****************************");
		String queryString = "select DISTINCT pr from ProfiloUtente pr where 1=1 ";

		if(filtriRicerca.getFiltroCodiceFiscale() != null && !filtriRicerca.getFiltroCodiceFiscale().equals("")){
			queryString += " AND pr.codiceFiscale LIKE ?1";
		}
		
		if(filtriRicerca.getFiltroCognome() != null && !filtriRicerca.getFiltroCognome().equals("")){
			queryString += " AND pr.cognome LIKE ?2";
		}
		
		if(filtriRicerca.getFiltroNome() != null && !filtriRicerca.getFiltroNome().equals("")){
			queryString += " AND pr.nome LIKE ?3";
		}
		
		if(filtriRicerca.getFiltroMail() != null && !filtriRicerca.getFiltroMail().equals("")){
			queryString += " AND pr.mail LIKE ?4";
		}
		
		if(filtriRicerca.getFiltroMailPec() != null && !filtriRicerca.getFiltroMailPec().equals("")){
			queryString += " AND pr.mailPec LIKE ?5";
		}
		
		if(filtriRicerca.getFiltroUsername() != null && !filtriRicerca.getFiltroUsername().equals("")){
			queryString += " AND pr.usernameProtocollo LIKE ?6";
		}
		
		queryString +=" ORDER BY pr.id DESC ";
		
		
		log.info("QUERY:"+queryString);
		
		
		Query query = em.createQuery(queryString, ProfiloUtente.class);

		if (filtriRicerca.getFiltroCodiceFiscale() != null && !filtriRicerca.getFiltroCodiceFiscale().equals("")) {
			query.setParameter(1, "%" + filtriRicerca.getFiltroCodiceFiscale() + "%");
		}
		
		if(filtriRicerca.getFiltroCognome() != null && !filtriRicerca.getFiltroCognome().equals("")){
			query.setParameter(2, "%" + filtriRicerca.getFiltroCognome() + "%");
		}
		
		if(filtriRicerca.getFiltroNome() != null && !filtriRicerca.getFiltroNome().equals("")){
			query.setParameter(3, "%" + filtriRicerca.getFiltroNome() + "%");
		}
		
		if(filtriRicerca.getFiltroMail() != null && !filtriRicerca.getFiltroMail().equals("")){
			query.setParameter(4, "%" + filtriRicerca.getFiltroMail() + "%");
		}
		
		if(filtriRicerca.getFiltroMailPec() != null && !filtriRicerca.getFiltroMailPec().equals("")){
			query.setParameter(5, "%" + filtriRicerca.getFiltroMailPec() + "%");
		}
		
		if(filtriRicerca.getFiltroUsername() != null && !filtriRicerca.getFiltroUsername().equals("")){
			query.setParameter(6, "%" + filtriRicerca.getFiltroUsername() + "%");
		}
		
		log.info("*********************************************************");
		
		return (List<ProfiloUtente>) query.getResultList();
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see it.osapulie.service.ProfiloUtenteService#getProfiloUtenteCittadinoById(long)
	 */
	@Override
	public ProfiloUtente getProfiloUtenteCittadinoById(long pk) throws ServiceLayerException {
		return profiloUtenteCittadinoRepository.findOne(pk);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see it.osapulie.service.ProfiloUtenteService#getProfiloUtenteCittadinoById(long)
	 */
	@Override
	public ProfiloUtente getProfiloUtenteCittadinoByEmail(String mail) throws ServiceLayerException {
		return profiloUtenteCittadinoRepository.findByMail(mail);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * it.osapulie.service.ProfiloUtenteService#getProfiloUtenteProfessionistaByCf(java.lang.String)
	 */
	@Override
	public ProfiloUtente getProfiloUtenteCittadinoByCf(String cf) throws ServiceLayerException {
		return profiloUtenteCittadinoRepository.findByCodiceFiscale(cf);
	}

	public List<ProfiloUtente> getProfiloUtenteNomeRuolo(String[] nomiRuoli) {
		
		List<ProfiloUtente> result = new ArrayList<ProfiloUtente>();
		for (int i = 0; i < nomiRuoli.length; i++) {
			result.addAll(ruoloRepository.findByNome(nomiRuoli[i].toLowerCase()).getUtenti());
		}
		
		return result;
	}
	@Override
	public List<ProfiloUtente> getAllProfiloUtenteByRuolo(List<Ruolo> ruoli) throws ServiceLayerException {
		List<ProfiloUtente> result = new ArrayList<ProfiloUtente>();
		for(Ruolo ruolo:ruoli)
		{
			if (ruolo.isVisibile()) {
//				List<ProfiloUtente> profili = profiloUtenteCittadinoRepository.findByRuolo(ruolo);
				List<ProfiloUtente> profili = ruolo.getUtenti();
				for(int i=0;i<profili.size();i++)
				{
					boolean found=false;
					for(int j=0;j<result.size()&& !found;j++)
						found = profili.get(i).getId().equals(result.get(j).getId());
					if (!found){
						if (!result.contains(profili.get(i)))
							result.add(profili.get(i));
					}
				}
			}
		}
		return result;
	}

	
	public List<ProfiloUtente> getProfiloUtenteRuolo(Ruolo ruolo) {
		
//		List<ProfiloUtente> result = new ArrayList<ProfiloUtente>();
//		result = profiloUtenteCittadinoRepository.findByRuolo(ruolo);
//		return result;
		return ruolo.getUtenti();
	}

	@Override
	public ProfiloUtente getProfiloUtenteProtocolloByRuolo(List<Ruolo> ruoli) throws ServiceLayerException {
		ProfiloUtente result = null;
		// TODO Auto-generated method stub
		String queryString = "select distinct pu from ProfiloUtente pu LEFT OUTER JOIN pu.ruoli ru where ru.id in (";
		for(int i=0;i<ruoli.size();i++){
			if (i>0)
				queryString+=",";
			queryString+="'"+ruoli.get(i).getId()+"'";
		}
		queryString += ") and not pu.usernameProtocollo is null and not pu.passwordProtocollo is null";
		log.debug(String.format("queryString:= %s", queryString));
		
		Query query = em.createQuery(queryString, ProfiloUtente.class);
		query.setMaxResults(1);
		List<ProfiloUtente> elenco = query.getResultList();
		if (elenco.size()>0)
			result = elenco.get(0);
		return result;
	}

	@Override
	public boolean isAdmin(ProfiloUtente profiloUtente) {
		boolean retValue = false;
		
		if (profiloUtente != null) {
			if (profiloUtente.getRuoli() != null) {
				for (Ruolo ruolo: profiloUtente.getRuoli()) {
					if (ruolo.getNome().toUpperCase().equals("ADMINISTRATOR")) {
						retValue = true;
						break;
					}
				}
			}
		}
		
		return retValue;
	}
}
