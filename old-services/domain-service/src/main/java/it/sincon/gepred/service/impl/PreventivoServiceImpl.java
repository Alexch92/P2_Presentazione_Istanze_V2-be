package it.sincon.gepred.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import it.osapulie.service.ServiceLayerException;

import it.sincon.gepred.domain.pratica.Preventivo;
import it.sincon.gepred.domain.pratica.TipoIntervento;
import it.sincon.gepred.service.PreventivoService;
import it.sincon.gepred.persistence.TipoInterventoRepository;
import java.util.List;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Implementazione del Service per {@link Preventivo}
 * 
 * @author Antonio Santomauro
 *
 */
@Service("preventivoService")
public class PreventivoServiceImpl implements PreventivoService {
	
	private static Logger log = LoggerFactory.getLogger(PreventivoServiceImpl.class);
	
	@Value("#{applicationProperties.preventivo_contributoMax}")
	private String configContributoMax;
	@Value("#{applicationProperties.preventivo_contributoMaxCondomini}")
	private String configContributoMaxCondomini;
	
	@Inject
	private TipoInterventoRepository tipoInterventoRepository;
	
	@Override
	public List<TipoIntervento> findAll() {
		return tipoInterventoRepository.findAll();
	}
	
	@Override
	public List<TipoIntervento> findTipiInterventoByClasse(int classe) {
		return tipoInterventoRepository.findByClasse(classe);
	}

	
	@Override
	public Preventivo ricalcola(Preventivo preventivo, boolean isConsuntivo) throws ServiceLayerException {
		try {
			// INTERVENTO PRINCIPALE
			if (isConsuntivo) {
				preventivo.setIntPrincCostoTotaleCons(calcolaIntPrincCostoTotale(preventivo, isConsuntivo));
				preventivo.setProducibilitaTotaleCons(preventivo.getIntPrincProducibilitaUnitaria()*preventivo.getIntPrincQuantitaCons());
				preventivo.setScontoUnitario(calcolaScontoUnitario(preventivo));
			} else {
				preventivo.setIntPrincCostoTotale(calcolaIntPrincCostoTotale(preventivo, isConsuntivo));
				preventivo.setProducibilitaTotale(preventivo.getIntPrincProducibilitaUnitaria()*preventivo.getIntPrincQuantita());
				preventivo.setScontoUnitario(calcolaScontoUnitario(preventivo));
			}
			
			// INTERVENTO SECONDARIO
			if (preventivo.getInterventoSecondario() != null) {
				// Se il TipoIntervento selezionato è CLASSE = 0 (ovvero NESSUNA SELEZIONE) azzero le quantità..... 
				if (preventivo.getInterventoSecondario().getClasse() == 0) {
					preventivo.setIntSecCostoUnitario(0);
					preventivo.setIntSecQuantita(0);
				}
			}
			if (isConsuntivo) {
				preventivo.setIntSecCostoTotaleCons(calcolaIntSecCostoTotale(preventivo, isConsuntivo));
			} else {
				preventivo.setIntSecCostoTotale(calcolaIntSecCostoTotale(preventivo, isConsuntivo));
			}

			
			if (isConsuntivo) {
				// COSTO TOTALE
				preventivo.setCostoTotaleCons(calcolaCostoTotale(preventivo, isConsuntivo));
				
				// CONTRIBUTO REGIONE  
				preventivo.setContributoRegioneCons(calcolaContributoRegione(preventivo));
				preventivo.setIncidenzaIntSecondarioCons(calcolaIncidenzaIntSecondario(preventivo, isConsuntivo));
				
				// CO-FINANZIAMENTO BENEFICIARIO...
				preventivo.setCofinBeneficiarioCons(preventivo.getCostoTotaleCons()-preventivo.getContributoRegioneCons());
			} else {
				// COSTO TOTALE
				preventivo.setCostoTotale(calcolaCostoTotale(preventivo, isConsuntivo));
				
				// CONTRIBUTO REGIONE  
				preventivo.setContributoRegione(calcolaContributoRegione(preventivo));
				preventivo.setIncidenzaIntSecondario(calcolaIncidenzaIntSecondario(preventivo, isConsuntivo));
				
				// CO-FINANZIAMENTO BENEFICIARIO...
				preventivo.setCofinanziamentoBeneficiario(preventivo.getCostoTotale()-preventivo.getContributoRegione());
			}
		} catch (Exception e) {
			throw new ServiceLayerException("There was an error when saving an object of type Tab :: " + e.getMessage(), e);
		}
		
		return preventivo;
	}

	private double calcolaContributoRegione(Preventivo preventivo) {
		double retValue = 0;
		double contrUnitarioIntPrinc = 0;
		double cotrPrincipaleTot = 0;
		double contrUnitarioIntSec = 0;
		double cotrSecondarioTot = 0;
		
		if (preventivo != null) {
			contrUnitarioIntPrinc = preventivo.getIntPrincCostoUnitario();
			if (preventivo.getInterventoPrincipale() != null) {
				if (contrUnitarioIntPrinc > preventivo.getInterventoPrincipale().getContributoMax()) {
					contrUnitarioIntPrinc = preventivo.getInterventoPrincipale().getContributoMax();
				}
			}
			cotrPrincipaleTot = contrUnitarioIntPrinc * preventivo.getIntPrincQuantita();
			
			if (preventivo.getInterventoSecondario() != null) {
				if (preventivo.getInterventoSecondario().getClasse() > 0) {
					contrUnitarioIntSec = preventivo.getIntSecCostoUnitario();
					if (contrUnitarioIntSec > preventivo.getInterventoSecondario().getContributoMax()) {
						contrUnitarioIntSec = preventivo.getInterventoSecondario().getContributoMax();
					}
				}
			}
			cotrSecondarioTot = contrUnitarioIntSec * preventivo.getIntSecQuantita();
			
			retValue = cotrPrincipaleTot + cotrSecondarioTot;
			if (preventivo.getCostoFisso() != null)
				retValue += preventivo.getCostoFisso().getContributoMax();
				
			if (retValue >= getCfgContributoMax(preventivo))
				retValue = getCfgContributoMax(preventivo);
		}
		
		return retValue;
	}

	@Override
	public Preventivo getNuovo(boolean iscondominio, TipoIntervento intPrimario, TipoIntervento intSecondario) throws ServiceLayerException {
		Preventivo preventivo = new Preventivo();
		
		preventivo.setInterventoPrincipale(intPrimario);
		preventivo.setIntPrincCostoUnitario(0);
		preventivo.setIntPrincQuantita(0);
		preventivo.setCondominio(iscondominio);
		
		if (intSecondario == null) {
			try {
				intSecondario = findTipiInterventoByClasse(0).get(0);
			} catch (Exception ex) {
				log.error(ex.getMessage(), ex);
			}
		}
		preventivo.setInterventoSecondario(intSecondario);
		preventivo.setIntSecCostoUnitario(0);
		preventivo.setIntSecQuantita(0);
		
		preventivo.setCostoFisso(findTipiInterventoByClasse(4).get(0));
		
		return ricalcola(preventivo, false);
	}
	
	@Override
	public Preventivo getNuovo(boolean isCondominio) throws ServiceLayerException {
		TipoIntervento interventoZero = null;
		try {
			interventoZero = findTipiInterventoByClasse(0).get(0);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
		}
		
		return getNuovo(isCondominio, interventoZero, interventoZero);
	}
	
	private TipoIntervento findTipoIntervento(long idIntervento, List<TipoIntervento> interventi) {
		TipoIntervento retValue = null;

		if (interventi != null) {
			if (interventi.size() > 0) {
				for (TipoIntervento intervento : interventi) {
					if (intervento.getId() == idIntervento) {
						retValue = intervento;
					}
				}
			}
		}
		
		return retValue;
	}

	@Override
	public Preventivo setInterventoPrincipale(Preventivo preventivo, long idIntervento, List<TipoIntervento> interventi) {
		log.debug(String.format("setInterventoPrincipale(%s)", idIntervento));
		
		TipoIntervento intSelezionato = findTipoIntervento(idIntervento, interventi);
		if (intSelezionato != null)
			preventivo.setInterventoPrincipale(intSelezionato);
		
		return preventivo;
	}
	
	@Override
	public Preventivo setInterventoSecondario(Preventivo preventivo, long idIntervento, List<TipoIntervento> interventi) {
		log.debug(String.format("setInterventoSecondario(%s)", idIntervento));
		
		TipoIntervento intSelezionato = findTipoIntervento(idIntervento, interventi);
		if (intSelezionato != null)
			preventivo.setInterventoSecondario(intSelezionato);
		
		return preventivo;
	}
	
	
	private double calcolaIntPrincCostoTotale(Preventivo prev, boolean isConsuntivo) {
		double intPrincCostoTotale = 0;
		if (isConsuntivo)
		{
			if (prev.getIntPrincCostoUnitario() > 0 && prev.getIntPrincQuantitaCons() > 0)
				intPrincCostoTotale = prev.getIntPrincCostoUnitario() * prev.getIntPrincQuantitaCons();
		} else {
			if (prev.getIntPrincCostoUnitario() > 0 && prev.getIntPrincQuantita() > 0)
				intPrincCostoTotale = prev.getIntPrincCostoUnitario() * prev.getIntPrincQuantita();
		}
		
		return intPrincCostoTotale;
	}
	private double calcolaScontoUnitario(Preventivo prev) {
		double scontoUnitario = 0;
		if (prev.getInterventoPrincipale() != null && prev.getIntPrincCostoUnitario() > 0) {
			scontoUnitario = (100 - (prev.getIntPrincCostoUnitario() / prev.getInterventoPrincipale().getContributoMax()) * 100);
		}
		
		if (scontoUnitario < 0)
			scontoUnitario = 0;
		
		return scontoUnitario;
	}
	private double calcolaIntSecCostoTotale(Preventivo prev, boolean isConsuntivo) {
		double intSecCostoTotale = 0;
		if (isConsuntivo)
		{
			if (prev.getIntSecCostoUnitario() > 0 && prev.getIntSecQuantitaCons() > 0)
				intSecCostoTotale = prev.getIntSecCostoUnitario() * prev.getIntSecQuantitaCons();
		} else {
			if (prev.getIntSecCostoUnitario() > 0 && prev.getIntSecQuantita() > 0)
				intSecCostoTotale = prev.getIntSecCostoUnitario() * prev.getIntSecQuantita();
		}
		
		return intSecCostoTotale;
	}
	private double calcolaIncidenzaIntSecondario(Preventivo prev, boolean isConsuntivo) {
		double incidenzaIntSecondario = 0;
		
		double vCostoTotale = prev.getContributoRegione();
		double vCostoSecondario = prev.getIntSecCostoTotale();
		
		if (isConsuntivo) {
			vCostoTotale = prev.getContributoRegioneCons();
			vCostoSecondario = prev.getIntSecCostoTotaleCons();
		}
		
		if (vCostoSecondario > 0) {
			if (vCostoTotale > 0) {
				incidenzaIntSecondario = ((vCostoSecondario / vCostoTotale) * 100);
			} else
				incidenzaIntSecondario = 100;
		}
		
		return incidenzaIntSecondario;
	}
	private double calcolaCostoTotale(Preventivo prev, boolean isConsuntivo) {
		double costoTotale = prev.getIntPrincCostoTotale() + prev.getIntSecCostoTotale();
		if (isConsuntivo) {
			costoTotale = prev.getIntPrincCostoTotaleCons() + prev.getIntSecCostoTotaleCons();
		}
		
		if (prev.getCostoFisso() != null)
			costoTotale += prev.getCostoFisso().getContributoMax();
		
		return costoTotale;
	}
	private double getCfgContributoMax(Preventivo prev) {
		double cfgContributoMax = 6000;
		double cfgContributoMaxCondominio = 8500;
		double contributoMax = cfgContributoMax;
		
		try {
			cfgContributoMax = Double.parseDouble(configContributoMax);
			cfgContributoMaxCondominio = Double.parseDouble(configContributoMaxCondomini);
			
			contributoMax = cfgContributoMax;
			
			if (prev.isCondominio() && prev.getInterventoSecondario().getClasse() > 0) {
				contributoMax = cfgContributoMaxCondominio;
			}
		} catch (Exception ex) {
			log.warn(ex.getMessage(), ex);
		}
		
		return contributoMax;
	}
	
}
