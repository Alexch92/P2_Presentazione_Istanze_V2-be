package it.sincon.gepred.domain.pratica;

import it.osapulie.domain.Comune;


import it.osapulie.domain.ProfiloUtente;
import it.osapulie.infrastructure.impl.DateUtils;
import it.sincon.gepred.domain.AllegatiPratica;
import it.sincon.gepred.domain.CampiAggiuntiviPraticaWeb;
import it.sincon.gepred.domain.Referente;
import it.sincon.gepred.domain.TipoImmobile;
import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 * @author Maria Michela Birtolo
 * 
 */
@Entity
@Table(name = "tb_praticaweb")
public class PraticaWeb extends AbstractPersistable<Long> implements Serializable {
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 5908491879970975334L;

	@Column(name="oggetto", nullable = false, length = 2000)
	private String oggettoRichiesta;
	
	@Transient
	private String oggettoRichiestaSunto;
	
	@Column(name="stato", nullable = false, length = 2) //P=presentata, R=rifiutata, A=accettata, I=RITIRATA
	private String stato;
	
	@Column(name="motivo_rifiuto", nullable = true, length = 500) 
	private String motivo_rifiuto;
	
	@Column(name="titolare", nullable = true, length = 255)
	private String titolare;
		
	@Column(name="tecnico", nullable = true, length = 255)
	private String tecnico;
	
	@Column(name="impresa", nullable = true, length = 255)
	private String impresa;	
	@Transient
	private String impresaDenom;	
	
	@JoinColumn(name = "fk_profiloutente", nullable = true)
	private ProfiloUtente profiloutente;
	
	@JoinColumn(name = "fk_referente", nullable = true)
	private Referente referente;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_richiesta", nullable = false)
	private Date dataRichiesta;
	
	@JoinColumn( name = "fk_tipologia",nullable = false)
	private TipoPratica tipologia;
	
	//immobile
	@JoinColumn(name = "immobile_fk_comune", nullable = true)
	private Comune immobile_comune;
	
	@Column(name = "immobile_den",length=255, nullable=true)
	private String immobile_den;
	
	@Column(name = "immobile_ind",length=255,nullable=true)
	private String immobile_ind;
	
	@Column(name = "immobile_cap",length=5 ,nullable=true)
	private String immobile_cap;	
	
	@Column(name = "immobile_piano",length=3 ,nullable=true)
	private String immobile_piano;
	
	@Column(name = "immobile_interno",length=3 ,nullable=true)
	private String immobile_interno;
	
	@Column(name = "immobile_area_sin",length=1 ,nullable=true)
	private String immobile_areaSin;
	
	@JoinColumn(name = "immobile_fk_tipo", nullable = true)
	private TipoImmobile  immobileTipo;
	
	@OneToMany(mappedBy = "praticaWeb", cascade = CascadeType.ALL, orphanRemoval = true)	
	List<DatiCatastaliImmobile> datiCatastali;
	
	@OneToMany(mappedBy = "praticaWeb", cascade = CascadeType.ALL, orphanRemoval = true)	
	List<Superfici> superfici;
	
	//richiedente
	@JoinColumn(name="rich_fk_comune", nullable = true)
	private Comune richComune;
	
	@JoinColumn(name="rich_fk_comunenascita", nullable = true)
	private Comune richComuneNascita;
	
	@Temporal(TemporalType.TIMESTAMP)
	@JoinColumn(name="rich_data_nascita", nullable = true)
	private Date richDataNascita;
	
	@Column(name="rich_nominativo", length=255, nullable = true)
	private String richNominativo;
	
	@Column(name="rich_nome", length=255, nullable = true)
	private String richNome;
	
	@Column(name="rich_cognome", length=255, nullable = true)
	private String richCognome;
	
	@Column(name="rich_cf", length=16, nullable = true)
	private String richCf;
	
	@Column(name="rich_piva", length=25, nullable = true)
	private String richPiva;
	
	@Column(name="rich_indirizzo", length=255, nullable = true)
	private String richIndirizzo;
	
	@Column(name="rich_cap", length=5,nullable = true)
	private String richCap;
	
	@Column(name="rich_cell", length=50, nullable = true)
	private String richCell;
	
	@Column(name="rich_fax", length=50, nullable = true)
	private String richFax;
	
	@Column(name="rich_email", length=155, nullable = true)
	private String richEmail;
	
	@Column(name="rich_pec", length=155, nullable = true)
	private String richPec;
	
	@Column(name = "invio_pec",length=1 ,nullable=true)
	private String invioPec;
	
	@Column(name="doc_contenitore_uuid", nullable = true, length = 45)
	private String uuidContenitore;
	
	@Column(name="numero", nullable = false, length = 50)
	private String numeroPratica;
	
	@Column(name="numero_protocollo", nullable = true, length = 50)
	private String numeroProtocollo;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_protocollo", nullable = true)
	private Date dataProtocollo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_validazione", nullable = true)
	private Date dataValidazione;
	
	@OneToMany(mappedBy = "pratica", cascade = CascadeType.ALL, orphanRemoval = true)
	@OrderBy("id asc")
	private List<CampiAggiuntiviPraticaWeb> campiaggiuntivi;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "tb_fascicolicorrelati_web", joinColumns = { @JoinColumn(name = "id_praticaweb", referencedColumnName = "ID") }, inverseJoinColumns =  @JoinColumn(name = "id_praticaweb_correlata", referencedColumnName = "ID"))
	private List<PraticaWeb> fascicoliCorrelati;
	
	@JoinColumn( name = "fk_preventivo",nullable = true)
	private Preventivo preventivo;
	@Transient
	private long intPrincipaleSelected;
	@Transient
	private long intSecondarioSelected;
	
	@Column(name="nr_determina_idoneita", nullable = true, length = 255)
	private String nrDeterminaIdoneita;
	
	@Transient
	private List<ProfiloUtente> assegnatari;
	
	@Transient
	private PraticaWeb prCorrelata;
	
	@Transient
	private boolean ricevutaPresente;
	
	@Transient
	private String pivaVisura;
	
	@Transient
	private long ggValidazione;
	
	@Transient
	private String listDocsSizeZero;
	
	@Transient
	private String logMsgSizeZero;
	
	@Transient
	private boolean consuntivo;

	public long getGgValidazione() {
		return ggValidazione;
	}

	public void setGgValidazione(long ggValidazione) {
		this.ggValidazione = ggValidazione;
	}

	@Column(name="punteggio_istanza", nullable = true)
	private int punteggioIstanza;
		
	public int getPunteggioIstanza() {
		return punteggioIstanza;
	}

	public void setPunteggioIstanza(int punteggioIstanza) {
		this.punteggioIstanza = punteggioIstanza;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public String getMotivo_rifiuto() {
		return motivo_rifiuto;
	}

	public void setMotivo_rifiuto(String motivo_rifiuto) {
		this.motivo_rifiuto = motivo_rifiuto;
	}

	public void setId(Long id) {
		super.setId(id);
	}
	
		public String getRichNome() {
		return richNome;
	}

		public void setRichNome(String richNome) {
		this.richNome = richNome;
	}

	public String getRichCognome() {
		return richCognome;
	}

	public void setRichCognome(String richCognome) {
		this.richCognome = richCognome;
	}


	public List<CampiAggiuntiviPraticaWeb> getCampiaggiuntivi() {
		return campiaggiuntivi;
	}

	public void setCampiaggiuntivi(List<CampiAggiuntiviPraticaWeb> campiaggiuntivi) {
		this.campiaggiuntivi = campiaggiuntivi;
	}
	
	public List<Superfici> getSuperfici() {
		return superfici;
	}

	public void setSuperfici(List<Superfici> superfici) {
		this.superfici = superfici;
	}

	public String getImmobile_piano() {
		return immobile_piano;
	}

	public void setImmobile_piano(String immobile_piano) {
		this.immobile_piano = immobile_piano;
	}

	public String getImmobile_interno() {
		return immobile_interno;
	}

	public void setImmobile_interno(String immobile_interno) {
		this.immobile_interno = immobile_interno;
	}
	
	public String getTitolare() {
		return titolare;
	}

	public void setTitolare(String titolare) {
		this.titolare = titolare;
	}

	public String getTecnico() {
		return tecnico;
	}

	public void setTecnico(String tecnico) {
		this.tecnico = tecnico;
	}

	public String getImpresa() {
		return impresa;
	}

	public void setImpresa(String impresa) {
		this.impresa = impresa;
	}

	public List<DatiCatastaliImmobile> getDatiCatastali() {
		return datiCatastali;
	}

	public void setDatiCatastali(List<DatiCatastaliImmobile> datiCatastali) {
		this.datiCatastali = datiCatastali;
	}

	public String getRichFax() {
		return richFax;
	}

	public void setRichFax(String richFax) {
		this.richFax = richFax;
	}
	
	public String getRichPec() {
		return richPec;
	}

	public void setRichPec(String richPec) {
		this.richPec = richPec;
	}

	public Comune getRichComuneNascita() {
		return richComuneNascita;
	}

	public void setRichComuneNascita(Comune richComuneNascita) {
		this.richComuneNascita = richComuneNascita;
	}

	public Date getRichDataNascita() {
		return richDataNascita;
	}

	public void setRichDataNascita(Date richDataNascita) {
		this.richDataNascita = richDataNascita;
	}

	@Transient	
	private List<AllegatiPratica> allegati;

	public String getOggettoRichiesta() {
		return oggettoRichiesta;
	}

	public void setOggettoRichiesta(String oggettoRichiesta) {
		this.oggettoRichiesta = oggettoRichiesta;
	}
	
	public Date getDataRichiesta() {
		return dataRichiesta;
	}

	public void setDataRichiesta(Date dataRichiesta) {
		this.dataRichiesta = dataRichiesta;
	}
	
	public String getUuidContenitore() {
		return uuidContenitore;
	}

	public void setUuidContenitore(String uuidContenitore) {
		this.uuidContenitore = uuidContenitore;
	}

	public TipoPratica getTipologia() {
		return tipologia;
	}

	public void setTipologia(TipoPratica tipologia) {
		this.tipologia = tipologia;
	}

	public Comune getImmobile_comune() {
		return immobile_comune;
	}

	public void setImmobile_comune(Comune immobile_comune) {
		this.immobile_comune = immobile_comune;
	}

	public String getImmobile_den() {
		return immobile_den;
	}

	public void setImmobile_den(String immobile_den) {
		this.immobile_den = immobile_den;
	}

	public String getImmobile_ind() {
		return immobile_ind;
	}

	public void setImmobile_ind(String immobile_ind) {
		this.immobile_ind = immobile_ind;
	}

	public String getImmobile_cap() {
		return immobile_cap;
	}

	public void setImmobile_cap(String immobile_cap) {
		this.immobile_cap = immobile_cap;
	}

	public String getImmobile_areaSin() {
		return immobile_areaSin;
	}

	public void setImmobile_areaSin(String immobile_areaSin) {
		this.immobile_areaSin = immobile_areaSin;
	}
		
	public TipoImmobile getImmobileTipo() {
		return immobileTipo;
	}

	public void setImmobileTipo(TipoImmobile immobileTipo) {
		this.immobileTipo = immobileTipo;
	}

	public Comune getRichComune() {
		return richComune;
	}

	public void setRichComune(Comune richComune) {
		this.richComune = richComune;
	}

	public String getRichNominativo() {
		return richNominativo;
	}

	public void setRichNominativo(String richNominativo) {
		this.richNominativo = richNominativo;
	}

	public String getRichCf() {
		return richCf;
	}

	public void setRichCf(String richCf) {
		this.richCf = richCf;
	}

	public String getRichPiva() {
		return richPiva;
	}

	public void setRichPiva(String richPiva) {
		this.richPiva = richPiva;
	}

	public String getRichIndirizzo() {
		return richIndirizzo;
	}

	public void setRichIndirizzo(String richIndirizzo) {
		this.richIndirizzo = richIndirizzo;
	}

	public String getRichCap() {
		return richCap;
	}

	public void setRichCap(String richCap) {
		this.richCap = richCap;
	}

	public String getRichCell() {
		return richCell;
	}

	public void setRichCell(String richCell) {
		this.richCell = richCell;
	}

	public String getRichEmail() {
		return richEmail;
	}

	public void setRichEmail(String richEmail) {
		this.richEmail = richEmail;
	}

	public List<AllegatiPratica> getAllegati() {
		return allegati;
	}

	public void setAllegati(List<AllegatiPratica> allegati) {
		this.allegati = allegati;
	}

	public ProfiloUtente getProfiloutente() {
		return profiloutente;
	}

	public void setProfiloutente(ProfiloUtente profiloutente) {
		this.profiloutente = profiloutente;
	}
	
	public String getInvioPec() {
		return invioPec;
	}

	public void setInvioPec(String invioPec) {
		this.invioPec = invioPec;
	}
	
	public Referente getReferente() {
		return referente;
	}

	public void setReferente(Referente referente) {
		this.referente = referente;
	}
	
	public String getNumeroPratica() {
		return numeroPratica;
	}

	public void setNumeroPratica(String numeroPratica) {
		this.numeroPratica = numeroPratica;
	}
	
	public String getOggettoRichiestaSunto() {
		if (oggettoRichiesta.length() > 400)
			this.oggettoRichiestaSunto = oggettoRichiesta.substring(0, 400) + "...";
		else
			this.oggettoRichiestaSunto = oggettoRichiesta;
		
		return this.oggettoRichiestaSunto;
	}

	public HashMap<String, Object> getPraticaAsMap() throws Exception{
		HashMap<String, Object> map = new HashMap<String, Object>();
		// Aggiungo la data odierna e la data di sistema
		map.put("dataSistema", new SimpleDateFormat("dd/MM/yyy").format(new Date()));
	
		//prendo tutti i campi pubblic e private, invece con getFields prendo solo quelli public 
		Field[] campi = this.getClass().getDeclaredFields();
		//try{
		for(int i = 0 ; i < campi.length; i++){
			if(!campi[i].getName().equals("serialVersionUID")){
				if(campi[i].getType().isPrimitive())
					map.put(campi[i].getName(), ""+campi[i].get(this));
				else{
					if(campi[i].get(this) instanceof Date)
						map.put(campi[i].getName(), DateUtils.getDataGGMMAAAA((Date)campi[i].get(this)));
					if(campi[i].get(this) instanceof String)
						map.put(campi[i].getName(), (String)campi[i].get(this));
					if(campi[i].get(this) instanceof TipoPratica){
						map.put(campi[i].getName(), ((TipoPratica)campi[i].get(this)).getDescrizione());
						map.put(campi[i].getName()+"_descr1", ((TipoPratica)campi[i].get(this)).getDescr_link());
						map.put(campi[i].getName()+"_descr2", ((TipoPratica)campi[i].get(this)).getDescr_link2());
						map.put(campi[i].getName()+"_descr3", ((TipoPratica)campi[i].get(this)).getDescr_link3());
					}
					if(campi[i].get(this) instanceof Referente)
						map.put(campi[i].getName(), ((Referente)campi[i].get(this)).getNominativo());
					if (campi[i].get(this) instanceof Comune)
						map.put(campi[i].getName(), ((Comune)campi[i].get(this)).getDenominazione());
				}
			}
		}
		
		if (this.getCampiaggiuntivi()!=null){
			for (CampiAggiuntiviPraticaWeb campo : this.getCampiaggiuntivi()){
				map.put(campo.getCampiAggiuntivi().getLabel().replaceAll(" ", ""),campo.getValore());
			}
		}

		
		
		// Aggiungo i seguenti campi per il Richiedente
		if (referente!=null){
			map.put("referenteIndirizzo", referente.getIndirizzo());
			map.put("referenteComune", referente.getComune().getDenominazione());
			map.put("referenteCap", referente.getCap());
			// Verifico che la chiave referente sia valorizzata, altrimenti la valorizzo come
			// referente.nome + referente.cognome
			if ( (map.get("referente") == null) || ((String)map.get("referente")).length() < 1){
				map.put("referente",String.format("%s %s",referente.getNome(), referente.getCognome()));
			}
		}
		
		if (datiCatastali!=null && !datiCatastali.isEmpty()){
			List<Map<String,Object>> listDatiCatastali = new ArrayList<Map<String,Object>>();
			BeanInfo beanInfoDatiCatastali = Introspector.getBeanInfo(DatiCatastaliImmobile.class);
			for(DatiCatastaliImmobile immobile:datiCatastali){
				Map<String,Object> datoCatastale = new HashMap<String, Object>();
				for(PropertyDescriptor property:beanInfoDatiCatastali.getPropertyDescriptors()){
					if (property.getWriteMethod()!=null)
						datoCatastale.put(property.getName(), property.getReadMethod().invoke(immobile, new Object[]{}));
				}
				listDatiCatastali.add(datoCatastale);
			}
			map.put("datiCatastali", listDatiCatastali);
		}
		
		if (superfici!=null && !superfici.isEmpty()){
			List<Map<String,Object>> listSuperfici = new ArrayList<Map<String,Object>>();
			BeanInfo beanInfoSuperfici = Introspector.getBeanInfo(Superfici.class);
			for(Superfici superfice:superfici){
				Map<String,Object> datoSuperfice = new HashMap<String, Object>();
				for(PropertyDescriptor property:beanInfoSuperfici.getPropertyDescriptors()){
					if (property.getWriteMethod()!=null)
						datoSuperfice.put(property.getName(), property.getReadMethod().invoke(superfice, new Object[]{}));
				}
				listSuperfici.add(datoSuperfice);
			}
			map.put("superfici", listSuperfici);
		}

		List<HashMap<String,Object>> listaAllegati = new ArrayList<HashMap<String,Object>>();
		if (this.getAllegati()!=null && !this.getAllegati().isEmpty()){
			for(AllegatiPratica allegato : this.getAllegati()) {
				HashMap<String,Object> mapAllegato = new HashMap<String, Object>();
				mapAllegato.put("descrizione",URLEncoder.encode(allegato.getAllegati().getNomeDocumento(), "ISO-8859-1").replaceAll("%3F", "'").replaceAll("%3f", "'").replaceAll("%", "\\\\'").replaceAll("\\+", " "));
				mapAllegato.put("uuidFile", allegato.getUuidFile());
				mapAllegato.put("presente", allegato.getUuidFile()!=null && !allegato.getUuidFile().equals(""));
				mapAllegato.put("numeroProtocollo", allegato.getNumProtocollo());
				mapAllegato.put("dataProtocollo", DateUtils.getDataGGMMAAAA(allegato.getDataProtocollo()));
				String tipoProtocollo = null;
				if (allegato.getTipoProtocollo()!=null && !allegato.getTipoProtocollo().equals("")) {
					if (allegato.getTipoProtocollo().equals("I"))
						tipoProtocollo="INGRESSO";
					else
						tipoProtocollo="USCITA";
				}
				mapAllegato.put("tipoProtocollo", tipoProtocollo);
				mapAllegato.put("nomeFile", allegato.getNomeFile());
				mapAllegato.put("modello", allegato.isModello());
				mapAllegato.put("impronta", allegato.getImpronta());
				listaAllegati.add(mapAllegato);
			}
		}
		map.put("listaAllegati", listaAllegati);
		return map;
	}

	public String getNumeroProtocollo() {
		return numeroProtocollo;
	}

	public void setNumeroProtocollo(String numeroProtocollo) {
		this.numeroProtocollo = numeroProtocollo;
	}

	public Date getDataProtocollo() {
		return dataProtocollo;
	}

	public void setDataProtocollo(Date dataProtocollo) {
		this.dataProtocollo = dataProtocollo;
	}

	public List<ProfiloUtente> getAssegnatari() {
		return assegnatari;
	}

	public void setAssegnatari(List<ProfiloUtente> assegnatari) {
		this.assegnatari = assegnatari;
	}

	public void setOggettoRichiestaSunto(String oggettoRichiestaSunto) {
		this.oggettoRichiestaSunto = oggettoRichiestaSunto;
	}

	public boolean isRicevutaPresente() {
		return ricevutaPresente;
	}

	public void setRicevutaPresente(boolean ricevutaPresente) {
		this.ricevutaPresente = ricevutaPresente;
	}
	
	public String getPivaVisura() {
		return pivaVisura;
	}

	public void setPivaVisura(String pivaVisura) {
		this.pivaVisura = pivaVisura;
	}

	public Preventivo getPreventivo() {
		return preventivo;
	}
	public void setPreventivo(Preventivo preventivo) {
		this.preventivo = preventivo;
	}

	public long getIntPrincipaleSelected() {
		return intPrincipaleSelected;
	}

	public void setIntPrincipaleSelected(long intPrincipaleSelected) {
		this.intPrincipaleSelected = intPrincipaleSelected;
	}

	public long getIntSecondarioSelected() {
		return intSecondarioSelected;
	}

	public void setIntSecondarioSelected(long intSecondarioSelected) {
		this.intSecondarioSelected = intSecondarioSelected;
	}

	public Date getDataValidazione() {
		return dataValidazione;
	}

	public void setDataValidazione(Date dataValidazione) {
		this.dataValidazione = dataValidazione;
	}

	public String getImpresaDenom() {
		return impresaDenom;
	}

	public void setImpresaDenom(String impresaDenom) {
		this.impresaDenom = impresaDenom;
	}

	public String getListDocsSizeZero() {
		return listDocsSizeZero;
	}

	public void setListDocsSizeZero(String listDocsSizeZero) {
		this.listDocsSizeZero = listDocsSizeZero;
	}

	public String getLogMsgSizeZero() {
		return logMsgSizeZero;
	}

	public void setLogMsgSizeZero(String logMsgSizeZero) {
		this.logMsgSizeZero = logMsgSizeZero;
	}

	public List<PraticaWeb> getFascicoliCorrelati() {
		return fascicoliCorrelati;
	}

	public void setFascicoliCorrelati(List<PraticaWeb> fascicoliCorrelati) {
		this.fascicoliCorrelati = fascicoliCorrelati;
	}

	public PraticaWeb getPrCorrelata() {
		return prCorrelata;
	}

	public void setPrCorrelata(PraticaWeb prCorrelata) {
		this.prCorrelata = prCorrelata;
	}

	public String getNrDeterminaIdoneita() {
		return nrDeterminaIdoneita;
	}

	public void setNrDeterminaIdoneita(String nrDeterminaIdoneita) {
		this.nrDeterminaIdoneita = nrDeterminaIdoneita;
	}
	
	public boolean isConsuntivo() {
		boolean retValue = false;
		
		if (tipologia != null) {
			if(tipologia.getDescrizione().toLowerCase().contains("istanza di erogazione")) 
				retValue = true;
		}
		
		return retValue;
	}
	
}
