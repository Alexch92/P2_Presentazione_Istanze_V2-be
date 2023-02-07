package it.sincon.gepred.service.impl;

import flexjson.JSONSerializer;
import it.osapulie.domain.Ruolo;
import it.osapulie.persistence.RuoloRepository;
import it.osapulie.service.RuoloService;
import it.osapulie.service.ServiceLayerException;
import it.sincon.gepred.domain.pratica.CategoriePratiche;
import it.sincon.gepred.persistence.CategoriePraticheRepository;
import it.sincon.gepred.service.GestioneCategoriePraticheService;
import it.sincon.gepred.web.portlet.varie.DatiRicercaCategoria;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.eclipse.jdt.internal.compiler.IErrorHandlingPolicy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementazione del Service per {@link CategoriePratiche}
 * 
 * @author Angelo Pascadopoli
 *
 */
@Service("gestioneCategoriePraticheService")
public class GestioneCategoriePraticheServiceImpl implements
		GestioneCategoriePraticheService {

	private static Logger log = LoggerFactory
			.getLogger(GestioneCategoriePraticheServiceImpl.class);

	@PersistenceContext(unitName="gepred")
	private EntityManager entityManager;

	@Inject
	private CategoriePraticheRepository repositoryCategorie;

	
	@Inject
	private RuoloService ruoloService;
	
	
	@Transactional
	public void saveCategory(CategoriePratiche categoria)
			throws ServiceLayerException {
		log.debug("saveCategory :: Entering method");
		
		try {
			boolean cascadeRoles =categoria.isNew() && categoria.getParent()!=null; 
			CategoriePratiche saved =repositoryCategorie.save(categoria);
			if (cascadeRoles) {
				List<Ruolo> ruoliAbilitatiPadre = saved.getParent().getRuolo();
				for(Ruolo ruolo:ruoliAbilitatiPadre) {
					Ruolo finded = ruoloService.getRuoloById(ruolo.getId());
					finded.getCategorieAbilitate().add(saved);
					ruoloService.saveRuolo(finded);
				}
			}
		} catch (Exception e) {
			throw new ServiceLayerException(
					"There was an error when saving an object of type CategoriePratiche :: "
							+ e.getMessage(), e);
		}
	}

	public CategoriePratiche findByPk(Long pk) {
		log.debug("findByPk :: Entering method");

		return repositoryCategorie.findOne(pk);
	}

	public List<CategoriePratiche> searchRootCategories() {
		log.debug("searchRootCategories :: Entering method");

		String queryString = "SELECT cp FROM CategoriePratiche cp WHERE cp.parent is null";
		Query query = entityManager.createQuery(queryString,
				CategoriePratiche.class);

		return (List<CategoriePratiche>) query.getResultList();
	}

	public List<CategoriePratiche> searchCategoria(
			DatiRicercaCategoria filtroCategoria) {
		log.debug("searchCategoria :: Entering method");
		log.info("FLAG" +filtroCategoria.isEqual());
		String queryString = "select cp from CategoriePratiche cp where 1=1";

		if (filtroCategoria != null && filtroCategoria.getFiltroDescrizione()!=null
				&& !filtroCategoria.getFiltroDescrizione().equals("") && filtroCategoria.isEqual()==false)
			queryString += " and lower(cp.descr) like lower(?1)";
		else {
			queryString += " and lower(cp.descr) = lower(?1)";
		}
		if (filtroCategoria != null && filtroCategoria.getFiltroID()!=null
				&& !filtroCategoria.getFiltroID().equals(""))
			queryString += " and cp.id like ?2";

		Query query = entityManager.createQuery(queryString,
				CategoriePratiche.class);

		if (filtroCategoria != null && filtroCategoria.getFiltroDescrizione()!=null
				&& !filtroCategoria.getFiltroDescrizione().equals("") && filtroCategoria.isEqual()==false)
			query.setParameter(1, "%" + filtroCategoria.getFiltroDescrizione()
					+ "%");
		else {
			query.setParameter(1, filtroCategoria.getFiltroDescrizione());
		}
		
		if (filtroCategoria != null && filtroCategoria.getFiltroID()!=null
				&& !filtroCategoria.getFiltroID().equals(""))
			query.setParameter(2, filtroCategoria.getFiltroID());

		return (List<CategoriePratiche>) query.getResultList();
	}

	public void deleteCategory(Long id) {
		log.debug("delete Categoria :: entering method");

		repositoryCategorie.delete(id);
	}

	public String listToJson(List<CategoriePratiche> lista, boolean flag)
			throws IOException {
		log.debug("listToJson :: Entering Method");

		JSONSerializer serializer = new JSONSerializer();
		StringBuilder builder = new StringBuilder();
		String result;

		if (flag) { // Chiamata proveniente da gestione pratiche
			serializer.exclude("*.class").exclude("*.parent").exclude("*.new")
					.include("*.tipoPratica.id")
					.include("*.tipoPratica.descrizione")
					.include("*.tipoPratica.frontend")
					.exclude("*.id")
					.exclude("*.tipoPratica.*").exclude("*.ruolo").deepSerialize(lista, builder);
		} else { // Chiamata proveniente da gestione categorie o gestione
					// tipologie
			serializer.exclude("*.class").exclude("*.parent").exclude("*.new")
					.include("*.tipoPratica.descrizione")
					.exclude("*.tipoPratica.*").include("*.ruolo.id")
					.exclude("*.ruolo.*").deepSerialize(lista, builder);
		}

		result = builder.toString();
		result = result.replaceAll("\"children\":\\[\\],", "");
		result = result
				.replaceAll("\"descr\"", "\"isFolder\": true, \"title\"");
		result = result.replaceAll("descrizione", "title");
		result = result.replaceAll(",\"children\":\\[\\]", "");

		log.info(result);
		
		return result;
	}
	
	public List<CategoriePratiche> getCategorieRuolo(long id) {
		log.debug("getCategorieRuolo :: Entering method");
		
		Ruolo role = ruoloService.getRuoloById(id);
		
		List<CategoriePratiche> lista = new ArrayList<CategoriePratiche>();
		lista.addAll(role.getCategorieAbilitate());
		
		List<CategoriePratiche> result = getTreeFromCategory(lista);
		
		return result;
	}
	
	@Override
	public List<CategoriePratiche> getCategorieRuoli(List<Ruolo> ruoli) {
		log.debug("getCategorieRuolo :: Entering method");
		List<CategoriePratiche> lista = new ArrayList<CategoriePratiche>();
		
		for(Ruolo ruolo:ruoli) {
			for(CategoriePratiche cat:ruolo.getCategorieAbilitate()) {
				if (!lista.contains(cat))
					lista.add(cat);
			}
		}
		Collections.sort(lista, new Comparator<CategoriePratiche>() {
			@Override
			public int compare(CategoriePratiche o1, CategoriePratiche o2) {
				return o2.getId().compareTo(o1.getId());
			}
		});
		List<CategoriePratiche> result = getTreeFromCategory(lista);
		
		return result;
	}
	
	public List<CategoriePratiche> getTreeFromCategory(List<CategoriePratiche> categorie) {
		log.debug("getTreeFromCategory :: Entering method");	
		
		Map<Long, CategoriePratiche> mappa = new HashMap<Long, CategoriePratiche>();
		//Map<Long, Long> parent = new HashMap<Long, Long>();
		List<CategoriePratiche> result = new ArrayList<CategoriePratiche>();
		
		for (CategoriePratiche c : categorie) {
			boolean found = false;
			CategoriePratiche cat = new CategoriePratiche();
			BeanUtils.copyProperties(c, cat);
			CategoriePratiche old =	mappa.put(cat.getId(), cat);
			while(!found && cat.getParent() != null) {
				found = mappa.containsKey(cat.getParent().getId());
				if (found) {
					if (old==null)	mappa.get(cat.getParent().getId()).getChildren().add(cat);
					mappa.get(cat.getId()).setParent(mappa.get(cat.getParent().getId()));
				} else {
					CategoriePratiche temp = new CategoriePratiche();
					temp.setId(cat.getParent().getId());
					temp.setDescr(cat.getParent().getDescr());
					temp.setParent(cat.getParent().getParent());
					//parent.put(cat.getId(), cat.getParent().getId());
					temp.setChildren(new ArrayList<CategoriePratiche>());
					temp.getChildren().add(cat);
					mappa.put(temp.getId(), temp);
					cat = temp;
					//cat = cat.getParent();
				}
			}
		}
		
		/*for(Map.Entry<Long, Long> riga : parent.entrySet()) {
			mappa.get(riga.getKey()).setParent(mappa.get(riga.getValue()));
		}*/
		
		for (Iterator<CategoriePratiche> iterator = mappa.values().iterator(); iterator.hasNext();) {
			CategoriePratiche cat = iterator.next();
			//if (!result.contains(cat))
			if (cat.getParent() == null)
				result.add(cat);
		}
		return result;
	}
	
	public CategoriePratiche getRoot(CategoriePratiche categoria) {
		CategoriePratiche root = categoria;
		if (categoria.getParent() != null)
			root = getRoot(categoria.getParent());
		return root;
	}

	@Override
	public List<CategoriePratiche> findAll() {
		return repositoryCategorie.findAll();
	}
		
}
