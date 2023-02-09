package it.sincon.gepred.domain.pratica;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Locale;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.Transient;

import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 * Classe che contiene i dati del preventivo per il progetto di riqualificazione energetica da attuare
 * @author Antonio Santomauro
 */
/**
 * @author Santomauro
 *
 */
@Entity
@Table(name = "tb_preventivo")
public class Preventivo extends AbstractPersistable<Long> implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1672642453678627404L;
	@JoinColumn(name = "fk_intervento_principale", insertable = false, nullable = true)
	TipoIntervento interventoPrincipale;
	@Column(name="quantita_int_principale")
	private double intPrincQuantita;
	@Column(name="costo_unitario_int_principale")
	private double intPrincCostoUnitario;
	@Column(name="produc_unitaria_int_principale")
	private double intPrincProducibilitaUnitaria;
	@Column(name="costo_totale_int_principale")
	private double intPrincCostoTotale;
	@Column(name="sconto_unitario_int_principale")
	private double scontoUnitario;
	
	@Transient
	private String intPrincCostoUnitarioString;
	@Transient
	private String scontoUnitarioString;
	@Transient
	private String intPrincCostoTotaleString;
	
	@JoinColumn(name = "fk_intervento_secondario", insertable = false, nullable = true)
	TipoIntervento interventoSecondario;
	@Column(name="quantita_int_secondario")
	private double intSecQuantita;
	@Column(name="costo_unitario_int_secondario")
	private double intSecCostoUnitario;
	@Column(name="incidenza_int_secondario")
	private double incidenzaIntSecondario;
	@Column(name="costo_totale_int_secondario")
	private double intSecCostoTotale;
	@Transient
	private String intSecCostoUnitarioString;
	@Transient
	private String intSecCostoTotaleString;
	
	@JoinColumn(name = "fk_costo_fisso", insertable = false, nullable = true)
	TipoIntervento costoFisso;
	
	@Transient
	private String costoTotaleString;
	@Transient
	private String contributoRegioneString;
	@Transient
	private String cofinanziamentoBeneficiarioString;
	
	@Column(name="producibilita_totale")
	private double producibilitaTotale;
	@Column(name="producibilita_totale_cons")
	private double producibilitaTotaleCons;
	
	@Transient
	private double potenzaImpegnata;
	
	@Column(name="is_condominio")
	private boolean condominio;
	
	@Column(name="costo_totale")
	private double costoTotale;
	@Column(name="contributo_regione")
	private double contributoRegione;
	@Column(name="cofinanziamento_beneficiario")
	private double cofinanziamentoBeneficiario;
	
	
	// DATI A CONSUNTIVO
	@Column(name="quantita_int_principale_cons")
	private double intPrincQuantitaCons;
	@Column(name="costo_totale_int_principale_cons")
	private double intPrincCostoTotaleCons;
	@Transient
	private String intPrincCostoTotaleConsString;
	
	@Column(name="quantita_int_secondario_cons")
	private double intSecQuantitaCons;
	@Column(name="costo_totale_int_secondario_cons")
	private double intSecCostoTotaleCons;
	@Column(name="incidenza_int_secondario_cons")
	private double incidenzaIntSecondarioCons;
	@Transient
	private String intSecCostoTotaleConsString;
	
	@Column(name="costo_totale_cons")
	private double costoTotaleCons;
	@Transient
	private String costoTotaleConsString;
	
	@Column(name="contributo_regione_cons")
	private double contributoRegioneCons;
	@Column(name="cofin_beneficiario_cons")
	private double cofinBeneficiarioCons;
	@Transient
	private String contributoRegioneConsString;
	@Transient
	private String cofinanziamentoBeneficiarioConsString;
	
	@Transient
	private boolean consuntivo = false;
	
	@Override
	public void setId(Long id) {
		super.setId(id);
	}
	
	public TipoIntervento getInterventoPrincipale() {
		return interventoPrincipale;
	}
	public void setInterventoPrincipale(TipoIntervento interventoPrincipale) {
		this.interventoPrincipale = interventoPrincipale;
	}
	public double getIntPrincQuantita() {
		return intPrincQuantita;
	}
	public void setIntPrincQuantita(double intPrincQuantita) {
		this.intPrincQuantita = intPrincQuantita;
	}
	public double getIntPrincCostoUnitario() {
		return intPrincCostoUnitario;
	}
	public void setIntPrincCostoUnitario(double intPrincCostoUnitario) {
		this.intPrincCostoUnitario = intPrincCostoUnitario;
	}
	public double getScontoUnitario() {
		return scontoUnitario;
	}
	public String getScontoUnitarioString() {
		return String.format("%.2f%%",scontoUnitario);
	}
	public double getIntPrincCostoTotale() {
		return intPrincCostoTotale;
	}
	
	public String getIntPrincCostoUnitarioString() {
		return DecimalFormat.getCurrencyInstance(Locale.ITALY).format(intPrincCostoUnitario);
	}
	public String getIntPrincCostoTotaleString() {
		return DecimalFormat.getCurrencyInstance(Locale.ITALY).format(intPrincCostoTotale);
	}

	public TipoIntervento getInterventoSecondario() {
		return interventoSecondario;
	}
	public void setInterventoSecondario(TipoIntervento interventoSecondario) {
		this.interventoSecondario = interventoSecondario;
	}
	public double getIntSecQuantita() {
		return intSecQuantita;
	}
	public void setIntSecQuantita(double intSecQuantita) {
		this.intSecQuantita = intSecQuantita;
	}
	public double getIntSecCostoUnitario() {
		return intSecCostoUnitario;
	}
	public void setIntSecCostoUnitario(double intSecCostoUnitario) {
		this.intSecCostoUnitario = intSecCostoUnitario;
	}
	public double getIntSecCostoTotale() {
		return intSecCostoTotale;
	}

	public String getIntSecCostoUnitarioString() {
		return DecimalFormat.getCurrencyInstance(Locale.ITALY).format(intSecCostoUnitario);
	}
	public String getIntSecCostoTotaleString() {
		return DecimalFormat.getCurrencyInstance(Locale.ITALY).format(intSecCostoTotale);
	}
	public String getCostoTotaleString() {
		return DecimalFormat.getCurrencyInstance(Locale.ITALY).format(costoTotale);
	}
	public String getContributoRegioneString() {
		return DecimalFormat.getCurrencyInstance(Locale.ITALY).format(contributoRegione);
	}
	public String getCofinanziamentoBeneficiarioString() {
		return DecimalFormat.getCurrencyInstance(Locale.ITALY).format(cofinanziamentoBeneficiario);
	}

	public TipoIntervento getCostoFisso() {
		return costoFisso;
	}
	
	public String getCostoFissoString() {
		if (costoFisso != null)
			return DecimalFormat.getCurrencyInstance(Locale.ITALY).format(costoFisso.getContributoMax());
		else
			return DecimalFormat.getCurrencyInstance(Locale.ITALY).format(0);
	}
	
	public void setCostoFisso(TipoIntervento costoFisso) {
		this.costoFisso = costoFisso;
	}
	public void setScontoUnitario(double scontoUnitario) {
		this.scontoUnitario = scontoUnitario;
	}
	public void setIntPrincCostoTotale(double intPrincCostoTotale) {
		this.intPrincCostoTotale = intPrincCostoTotale;
	}
	public void setIntSecCostoTotale(double intSecCostoTotale) {
		this.intSecCostoTotale = intSecCostoTotale;
	}
	public void setCostoTotale(double costoTotale) {
		this.costoTotale = costoTotale;
	}
	public void setScontoUnitarioString(String scontoUnitarioString) {
		this.scontoUnitarioString = scontoUnitarioString;
	}
	public void setIntPrincCostoTotaleString(String intPrincCostoTotaleString) {
		this.intPrincCostoTotaleString = intPrincCostoTotaleString;
	}
	public void setIntSecCostoTotaleString(String intSecCostoTotaleString) {
		this.intSecCostoTotaleString = intSecCostoTotaleString;
	}
	public void setCostoTotaleString(String costoTotaleString) {
		this.costoTotaleString = costoTotaleString;
	}
	public double getIntPrincProducibilitaUnitaria() {
		return intPrincProducibilitaUnitaria;
	}
	public void setIntPrincProducibilitaUnitaria(double intPrincProducibilitaUnitaria) {
		this.intPrincProducibilitaUnitaria = intPrincProducibilitaUnitaria;
	}
	public double getCostoTotale() {
		return costoTotale;
	}
	public double getProducibilitaTotale() {
		return producibilitaTotale;
	}
	
	public void setProducibilitaTotale(double producibilitaTotale) {
		this.producibilitaTotale = producibilitaTotale;
	}

	public double getIncidenzaIntSecondario() {
		return incidenzaIntSecondario;
	}
	public void setIncidenzaIntSecondario(double incidenzaIntSecondario) {
		this.incidenzaIntSecondario = incidenzaIntSecondario;
	}
	public double getPotenzaImpegnata() {
		return potenzaImpegnata;
	}
	public void setPotenzaImpegnata(double potenzaImpegnata) {
		this.potenzaImpegnata = potenzaImpegnata;
	}
	public boolean isCondominio() {
		return condominio;
	}
	public void setCondominio(boolean condominio) {
		this.condominio = condominio;
	}
	public double getContributoRegione() {
		return contributoRegione;
	}
	public void setContributoRegione(double contributoRegione) {
		this.contributoRegione = contributoRegione;
	}
	public double getCofinanziamentoBeneficiario() {
		return cofinanziamentoBeneficiario;
	}
	public void setCofinanziamentoBeneficiario(double cofinanziamentoBeneficiario) {
		this.cofinanziamentoBeneficiario = cofinanziamentoBeneficiario;
	}

	public double getIntPrincQuantitaCons() {
		return intPrincQuantitaCons;
	}

	public void setIntPrincQuantitaCons(double intPrincQuantitaCons) {
		this.intPrincQuantitaCons = intPrincQuantitaCons;
	}

	public double getIntPrincCostoTotaleCons() {
		return intPrincCostoTotaleCons;
	}

	public void setIntPrincCostoTotaleCons(double intPrincCostoTotaleCons) {
		this.intPrincCostoTotaleCons = intPrincCostoTotaleCons;
	}

	public double getIntSecQuantitaCons() {
		return intSecQuantitaCons;
	}

	public void setIntSecQuantitaCons(double intSecQuantitaCons) {
		this.intSecQuantitaCons = intSecQuantitaCons;
	}

	public double getIntSecCostoTotaleCons() {
		return intSecCostoTotaleCons;
	}

	public void setIntSecCostoTotaleCons(double intSecCostoTotaleCons) {
		this.intSecCostoTotaleCons = intSecCostoTotaleCons;
	}

	public double getCostoTotaleCons() {
		return costoTotaleCons;
	}

	public void setCostoTotaleCons(double costoTotaleCons) {
		this.costoTotaleCons = costoTotaleCons;
	}

	public double getContributoRegioneCons() {
		return contributoRegioneCons;
	}

	public void setContributoRegioneCons(double contributoRegioneCons) {
		this.contributoRegioneCons = contributoRegioneCons;
	}

	public double getCofinBeneficiarioCons() {
		return cofinBeneficiarioCons;
	}

	public void setCofinBeneficiarioCons(double cofinBeneficiarioCons) {
		this.cofinBeneficiarioCons = cofinBeneficiarioCons;
	}

	public String getIntPrincCostoTotaleConsString() {
		return DecimalFormat.getCurrencyInstance(Locale.ITALY).format(intPrincCostoTotaleCons);
	}

	public String getIntSecCostoTotaleConsString() {
		return DecimalFormat.getCurrencyInstance(Locale.ITALY).format(intSecCostoTotaleCons);
	}

	public String getCostoTotaleConsString() {
		return DecimalFormat.getCurrencyInstance(Locale.ITALY).format(costoTotaleCons);
	}

	public String getContributoRegioneConsString() {
		return DecimalFormat.getCurrencyInstance(Locale.ITALY).format(contributoRegioneCons);
	}

	public String getCofinanziamentoBeneficiarioConsString() {
		return DecimalFormat.getCurrencyInstance(Locale.ITALY).format(cofinBeneficiarioCons);
	}

	public double getIncidenzaIntSecondarioCons() {
		return incidenzaIntSecondarioCons;
	}

	public void setIncidenzaIntSecondarioCons(double incidenzaIntSecondarioCons) {
		this.incidenzaIntSecondarioCons = incidenzaIntSecondarioCons;
	}

	public boolean isConsuntivo() {
		return consuntivo;
	}

	public void setConsuntivo(boolean consuntivo) {
		this.consuntivo = consuntivo;
	}

	public double getProducibilitaTotaleCons() {
		return producibilitaTotaleCons;
	}

	public void setProducibilitaTotaleCons(double producibilitaTotaleCons) {
		this.producibilitaTotaleCons = producibilitaTotaleCons;
	}
	
}
