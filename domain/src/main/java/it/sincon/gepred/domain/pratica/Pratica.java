package it.sincon.gepred.domain.pratica;

import it.osapulie.infrastructure.impl.DateUtils;
import it.osapulie.domain.ProfiloUtente;
import it.osapulie.domain.Ruolo;
import it.sincon.gepred.domain.AllegatiPratica;


import it.sincon.gepred.domain.AttivitaPratica;
import it.sincon.gepred.domain.CampiAggiuntiviPratica;
import it.sincon.gepred.domain.CampiAggiuntiviTipoPratica;
import it.sincon.gepred.domain.Immobile;
import it.sincon.gepred.domain.Referente;

import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.ManyToMany;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.FetchType;

import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 * @author Maria Michela Birtolo
 * 
 */
@Entity
@Table(name = "tb_pratica")
public class Pratica extends AbstractPersistable<Long> {
	
	private static final long serialVersionUID = 1078352403473320051L;

	@Column(name="oggetto", nullable = false, length = 2000)
	private String oggettoRichiesta;
	
	@Transient
	private String oggettoRichiestaSunto;
	
	@Column(name="letta", nullable = false, length=1)
	private boolean letta;
	
	@Transient
	private String prefisso;
	
	@Transient
	private String numero;
	
	@Column(name="numero", nullable = false, length = 50)
	private String numeroPratica;
	
	@JoinColumn(name = "stato", nullable = true)
	private StatoPratica stato;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_richiesta", nullable = false)
	private Date dataRichiesta;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_scadenza", nullable = true)
	private Date dataScadenza;
	
	@Column(name = "giorni_complessivi", length=5,nullable=true)
	private Integer ggComplessivi;
	
	@JoinColumn( name = "fk_tipologia",nullable = false)
	private TipoPratica tipologia;
	
	@JoinColumn( name = "fk_tipointervento",nullable = true)
	private TipoIntervento tipoIntervento;
	
	@Column(name="numero_protocollo", nullable = true, length = 50)
	private String numeroProtocollo;
	
	@Column(name="completato", nullable = false, length=1)
	private boolean completato;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_protocollo", nullable = true)
	private Date dataProtocollo;
	
	/*@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_chiusura", nullable = true)
	private Date dataChiusura;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_annullamento", nullable = true)
	private Date dataAnnullamento;
	
	@Column(name="motivo_annullamento", nullable = false, length = 500)
	private String motivoAnnullamento;*/
	
	@Column(name="numero_protocollo_richiedente", nullable = true, length = 50)
	private String numeroProtocolloRichiedente;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_protocollo_richiedente", nullable = true)
	private Date dataProtocolloRichiedente;
	
	//campi relativi all'archiviazione fisica
	@Column(name="arch_sito", nullable = true, length = 255)
	private String archSito;
	@Column(name="arch_piano", nullable = true, length = 3)
	private String archPiano;
	@Column(name="arch_stanza", nullable = true, length = 50)
	private String archStanza;
	@Column(name="arch_scaffale", nullable = true, length = 5)
	private String archScaffale;
	@Column(name="arch_ripiano", nullable = true, length = 9)
	private String archRipiano;
	@Column(name="arch_faldone", nullable = true, length = 9)
	private String archFaldone;
				  
	@Column(name="doc_contenitore_uuid", nullable = true, length = 45)
	private String uuidContenitore;
	
	@Column(name="note", nullable = true, length = 500)
	private String note;
	
	@ManyToOne
	@JoinColumn( name = "fk_immobile",nullable = true)
	private Immobile immobile;
	
	@ManyToOne
	@JoinColumn(name = "fk_richiedente", nullable = true)
	private Referente richiedente;
	
	@OneToMany(mappedBy = "pratica", cascade = CascadeType.ALL, orphanRemoval = true, fetch=FetchType.LAZY)
	private List<Figura> figure;
	
	@OneToMany(mappedBy = "pratica", cascade = CascadeType.ALL, orphanRemoval = true, fetch=FetchType.LAZY)	
	private List<CampiAggiuntiviPratica> campiaggiuntivi;

	@OneToMany(mappedBy = "pratica", cascade = CascadeType.ALL, orphanRemoval = true, fetch=FetchType.LAZY)
	@OrderBy("dataInserimento DESC")
	private List<AllegatiPratica> allegati;
	
	@OneToMany(mappedBy = "pratica", cascade = CascadeType.ALL, orphanRemoval = true, fetch=FetchType.LAZY)	
	
	//@OrderBy("dataCompletamento ASC")
	@OrderBy("id ASC")
	private List<AttivitaPratica> attivitaPratica;
	
	@OneToMany(mappedBy = "pratica", cascade = CascadeType.ALL, orphanRemoval = true, fetch=FetchType.LAZY)	
	@OrderBy("dataProtoUscita ASC")
	private List<Parere> pareriPratica;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name = "tb_profilo_pratica", joinColumns = { @JoinColumn(name="pratica_id", referencedColumnName= "ID")},inverseJoinColumns = @JoinColumn(name = "profilo_id", referencedColumnName = "ID"))
	private List<ProfiloUtente> assegnatari;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "tb_fascicolicorrelati", joinColumns = { @JoinColumn(name = "id_fascicolo", referencedColumnName = "ID") }, inverseJoinColumns =  @JoinColumn(name = "id_fascicolo_correlato", referencedColumnName = "ID"))
	private List<Pratica> fascicoliCorrelati;
	
//	@ManyToMany(mappedBy = "fascicoliCorrelati", fetch = FetchType.EAGER)
//	private List<Pratica> pratica;
	
	@ManyToOne
	@JoinColumn( name = "fk_profilo",nullable=false)
	private ProfiloUtente referente;
	
	@JoinColumn(name = "fk_esito", insertable = false, nullable = true)
	private EsitoIstruttoria esitoIstruttoria;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_validazione", nullable = true)
	private Date dataValidazione;
	
	@Column(name="punteggio_istanza", nullable = true)
	private int punteggioIstanza;
	
	@Column(name="note_istruttore", nullable = true, length = 2000)
	private String noteIstruttore;
	
	@Column(name="commenti_istruttore", nullable = true, length = 2000)
	private String commentiIstruttore;
	
	@OneToMany(mappedBy = "pratica", cascade = CascadeType.ALL, orphanRemoval = true)	
	List<DatiCatastaliImmobile> datiCatastali;
	
	@JoinColumn( name = "fk_preventivo",nullable = true)
	private Preventivo preventivo;
	
	@Column(name="iseeVerificato", nullable = true, length=1)
	private boolean iseeVerificato = false;
	
	@Column(name="isee_da_dsu", nullable = true)
	private double iseeDaDSU;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_verifica_isee", nullable = true)
	private Date dataVerificaIsee;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_chiusura_istruttoria", nullable = true)
	private Date dataChiusuraIstruttoria;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_chiusura_istanza", nullable = true)
	private Date dataChiusuraPratica;
	
	@Transient
	private int ggDurataRiscontroIstruttoria;
	
	@Column(name="impresa", nullable = true, length = 255)
	private String impresa;
	
	@Column(name="titolare", nullable = true, length = 255)
	private String titolare;
	
	@Column(name="tecnico", nullable = true, length = 255)
	private String tecnico;
	
	@Transient
	private Date dataAssAtt;
	
	@Transient
	private Figura parte;
	
	@Transient
	private String statoCA;
	
	@Transient
	private String listDocsSizeZero;
	
	@Transient
	private String logMsgSizeZero;
	
	@Transient
	private List<String> codiciAteco;
	
	@Transient
	private long intPrincipaleSelected;
	@Transient
	private long intSecondarioSelected;
	
	@Transient
	private double iseeDichiarato;
	@Transient
	private double iseeDichiaratoString;
	
	@Transient
	private boolean iseeValido = false;
	
	public String getStatoCA(){
		String retValue = "";
		
		for (CampiAggiuntiviPratica ca : this.campiaggiuntivi){
			if (ca.getCampiAggiuntivi().getLabel().equalsIgnoreCase("stato"))
				retValue = ca.getValore();
		}
		
		return retValue;
	}
	
	@Override
	public void setId(Long id) {
		super.setId(id);
	}
	
	/*public Date getDataChiusura() {
		return dataChiusura;
	}

	public void setDataChiusura(Date dataChiusura) {
		this.dataChiusura = dataChiusura;
	}

	public Date getDataAnnullamento() {
		return dataAnnullamento;
	}

	public void setDataAnnullamento(Date dataAnnullamento) {
		this.dataAnnullamento = dataAnnullamento;
	}

	public String getMotivoAnnullamento() {
		return motivoAnnullamento;
	}

	public void setMotivoAnnullamento(String motivoAnnullamento) {
		this.motivoAnnullamento = motivoAnnullamento;
	}*/

	public Figura getParte() {
		return parte;
	}

	public void setParte(Figura parte) {
		this.parte = parte;
	}

	public List<Pratica> getFascicoliCorrelati() {
		return fascicoliCorrelati;
	}

	public void setFascicoliCorrelati(List<Pratica> fascicoliCorrelati) {
		this.fascicoliCorrelati = fascicoliCorrelati;
	}

//	public List<Pratica> getPratica() {
//		return pratica;
//	}
//
//
//	public void setPratica(List<Pratica> pratica) {
//		this.pratica = pratica;
//	}

	public Date getDataAssAtt() {
		return dataAssAtt;
	}

	public void setDataAssAtt(Date dataAssAtt) {
		this.dataAssAtt = dataAssAtt;
	}

	public Integer getGgComplessivi() {
		return ggComplessivi;
	}

	public void setGgComplessivi(Integer ggComplessivi) {
		this.ggComplessivi = ggComplessivi;
	}
	
	public Date getDataScadenza() {
		return dataScadenza;
	}

	public void setDataScadenza(Date dataScadenza) {
		this.dataScadenza = dataScadenza;
	}
	
	public Date getDataProtocollo() {
		return dataProtocollo;
	}

	public void setDataProtocollo(Date dataProtocollo) {
		this.dataProtocollo = dataProtocollo;
	}
	
	public Date getDataProtocolloRichiedente() {
		return dataProtocolloRichiedente;
	}

	public void setDataProtocolloRichiedente(Date _dataProtocollo) {
		this.dataProtocolloRichiedente = _dataProtocollo;
	}

	public String getArchSito() {
		return archSito;
	}

	public void setArchSito(String archSito) {
		this.archSito = archSito;
	}

	public String getArchPiano() {
		return archPiano;
	}

	public void setArchPiano(String archPiano) {
		this.archPiano = archPiano;
	}

	public String getArchStanza() {
		return archStanza;
	}

	public void setArchStanza(String archStanza) {
		this.archStanza = archStanza;
	}

	public String getArchScaffale() {
		return archScaffale;
	}

	public void setArchScaffale(String archScaffale) {
		this.archScaffale = archScaffale;
	}

	public String getArchRipiano() {
		return archRipiano;
	}

	public void setArchRipiano(String archRipiano) {
		this.archRipiano = archRipiano;
	}

	public String getArchFaldone() {
		return archFaldone;
	}

	public void setArchFaldone(String archFaldone) {
		this.archFaldone = archFaldone;
	}

	public List<Parere> getPareriPratica() {
		return pareriPratica;
	}

	public void setPareriPratica(List<Parere> pareriPratica) {
		this.pareriPratica = pareriPratica;
	}
	
	public List<ProfiloUtente> getAssegnatari() {
		return assegnatari;
	}

	public void setAssegnatari(List<ProfiloUtente> assegnatari) {
		this.assegnatari = assegnatari;
	}

	public ProfiloUtente getReferente() {
		return referente;
	}

	public void setReferente(ProfiloUtente referente) {
		this.referente = referente;
	}
	
	public String getUuidContenitore() {
		return uuidContenitore;
	}

	public void setUuidContenitore(String uuidContenitore) {
		this.uuidContenitore = uuidContenitore;
	}


	public List<AttivitaPratica> getAttivitaPratica() {
		return attivitaPratica;
	}

	public void setAttivitaPratica(List<AttivitaPratica> attivitaPratica) {
		this.attivitaPratica = attivitaPratica;
	}

	public String getOggettoRichiesta() {
		return oggettoRichiesta;
	}
	public String getOggettoRichiestaSunto() {
		if (oggettoRichiesta.length() > 400)
			this.oggettoRichiestaSunto = oggettoRichiesta.substring(0, 400) + "...";
		else
			this.oggettoRichiestaSunto = oggettoRichiesta;
		
		return this.oggettoRichiestaSunto;
	}

	public String getNumeroPratica() {
		return numeroPratica;
	}

	public String getNumeroProtocolloRichiedente() {
		return numeroProtocolloRichiedente;
	}
	
	public String getNumeroProtocollo() {
		return numeroProtocollo;
	}
	
	public boolean isCompletato() {
		return completato;
	}
	
	public void setCompletato(boolean completato){
		this.completato = completato;
	}

	public Date getDataRichiesta() {
		return dataRichiesta;
	}

	public TipoPratica getTipologia() {
		return tipologia;
	}

	public TipoIntervento getTipoIntervento() {
		return tipoIntervento;
	}

	public Immobile getImmobile() {
		return immobile;
	}

	public StatoPratica getStato() {
		return stato;
	}

	public Referente getRichiedente() {
		return richiedente;
	}

	public List<Figura> getFigure() {
		return figure;
	}

	public void setOggettoRichiesta(String oggettoRichiesta) {
		this.oggettoRichiesta = oggettoRichiesta;
	}

	public void setNumeroPratica(String numeroPratica) {
		this.numeroPratica = numeroPratica;
	}

	public void setNumeroProtocollo(String _numeroProtocollo) {
		this.numeroProtocollo = _numeroProtocollo;
	}
	
	public void setNumeroProtocolloRichiedente(String _numeroProtocollo) {
		this.numeroProtocolloRichiedente = _numeroProtocollo;
	}

	public void setDataRichiesta(Date dataRichiesta) {
		this.dataRichiesta = dataRichiesta;
	}

	public void setTipologia(TipoPratica tipologia) {
		this.tipologia = tipologia;
	}

	public void setTipoIntervento(TipoIntervento tipoIntervento) {
		this.tipoIntervento = tipoIntervento;
	}

	public void setImmobile(Immobile immobile) {
		this.immobile = immobile;
	}

	public void setStato(StatoPratica stato) {
		this.stato = stato;
	}

	public void setRichiedente(Referente richiedente) {
		this.richiedente = richiedente;
	}

	public void setFigure(List<Figura> figure) {
		this.figure = figure;
	}

	public List<CampiAggiuntiviPratica> getCampiaggiuntivi() {
		return campiaggiuntivi;
	}

	public void setCampiaggiuntivi(List<CampiAggiuntiviPratica> campiaggiuntivi) {
		this.campiaggiuntivi = campiaggiuntivi;
	}

	public List<AllegatiPratica> getAllegati() {
		return allegati;
	}

	public void setAllegati(List<AllegatiPratica> allegati) {
		this.allegati = allegati;
	}
	
	//@ManyToOne
	//@JoinColumn(name = "fk_delegato", insertable = false, updatable = false, nullable = true)
	//private ProfiloUtenteCittadino delegato;

	//@ManyToOne
	//@JoinColumn(name = "fk_delegante", insertable = false, updatable = false, nullable = true)
	//private ProfiloUtenteCittadino delegante;

	//@ManyToMany(fetch = FetchType.EAGER)
	//@JoinTable(name = "tb_delega_servizio", joinColumns = { @JoinColumn(name = "fk_delega", referencedColumnName = "ID") }, inverseJoinColumns = @JoinColumn(name = "fk_servizio", referencedColumnName = "ID"))
	//private List<Servizio> servizi;

	public boolean isLetta() {
		return letta;
	}

	public void setLetta(boolean letta) {
		this.letta = letta;
	}
	
	public String getPrefisso() {
		return prefisso;
	}

	public void setPrefisso(String prefisso) {
		this.prefisso = prefisso;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCategoriaPadre() {
		return this.getNomeCompletoCategoria()
				.split(CategoriePratiche.SEPARATORE)[0];
	}
	
	public String getNomeCompletoCategoria() {
		return this.getTipologia().getCategoria()
				.getNomeCompletoCategoria();
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	

	//@JoinColumn(name = "fk_comune_isa", nullable = false)
	//private ComuneISA comuneIsa;
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
						map.put("tipopratica", ((TipoPratica)campi[i].get(this)).getDescrizione());
						map.put("tipopratica_descr1", ((TipoPratica)campi[i].get(this)).getDescr_link());
						map.put("tipopratica_descr2", ((TipoPratica)campi[i].get(this)).getDescr_link2());
						map.put("tipopratica_descr3", ((TipoPratica)campi[i].get(this)).getDescr_link3());
						map.put("tipopratica_categoria", ((TipoPratica)campi[i].get(this)).getCategoria().getDescr());
					}
					if(campi[i].get(this) instanceof StatoPratica)
						map.put(campi[i].getName(), ((StatoPratica)campi[i].get(this)).getDescrizione());
					if(campi[i].get(this) instanceof Referente)
						map.put(campi[i].getName(), ((Referente)campi[i].get(this)).getNominativo());
					if(campi[i].get(this) instanceof TipoIntervento)
						map.put(campi[i].getName(), ((TipoIntervento)campi[i].get(this)).getDescrizione());
					if(campi[i].get(this) instanceof Immobile)
						map.put(campi[i].getName(), ((Immobile)campi[i].get(this)).getDenominazione()+" "+((Immobile)campi[i].get(this)).getIndirizzo());
				}
			}
		}
		// Aggiungo i seguenti campi per il Richiedente
		if (richiedente!=null){
			if (richiedente.getIndirizzo()!=null)
				map.put("richiedenteIndirizzo", richiedente.getIndirizzo());
			else
				map.put("richiedenteIndirizzo", "");
			if (richiedente.getComune()!=null)
				map.put("richiedenteComune", richiedente.getComune().getDenominazione());
			else
				map.put("richiedenteComune", "");
			if (richiedente.getCap()!=null)
				map.put("richiedenteCap", richiedente.getCap());
			else
				map.put("richiedenteCap", "");
			// Verifico che la chiave referente sia valorizzata, altrimenti la valorizzo come
			// referente.nome + referente.cognome
			if ( (map.get("richiedente") == null) || ((String)map.get("richiedente")).length() < 1){
				map.put("richiedente",String.format("%s %s",richiedente.getNome(), richiedente.getCognome()));
			}
		}

		// CampiAggiuntivi
		if (this.getCampiaggiuntivi()!=null){
			for (CampiAggiuntiviPratica campo : this.getCampiaggiuntivi()){
				map.put(campo.getCampiAggiuntivi().getLabel().replaceAll(" ", ""),campo.getValore());
			}
		}
		
		// Referente della Pratica
		if (referente!=null){
			map.put("referenteNome", referente.getNome());
			map.put("referenteCognome", referente.getCognome());
			map.put("referenteResidenza", referente.getResidenza().toString());
		}
		
		// Lista Assegnatari
		List<HashMap<String, String>> listaAssegnatari = new ArrayList<HashMap<String,String>>();
		if (this.getAssegnatari()!=null){
			for (ProfiloUtente utente : this.getAssegnatari())
				if (utente.getId() != referente.getId()){
					HashMap<String, String> mapAssegnatario = new HashMap<String, String>();
					mapAssegnatario.put("nome", utente.getNome());
					mapAssegnatario.put("cognome", utente.getCognome());
//					mapAssegnatario.put("qualifica", utente.getRuolo().getNome());

					listaAssegnatari.add(mapAssegnatario);
				}
		}
		map.put("listaAssegnatari", listaAssegnatari);
		
		// Pratiche correlate
		List<HashMap<String, String>> listaFascicoloCorrelati = new ArrayList<HashMap<String,String>>();
		if (this.getFascicoliCorrelati()!=null){
			for (Pratica pr : this.getFascicoliCorrelati()){
				HashMap<String, String> mapCorrelati = new HashMap<String, String>();
				mapCorrelati.put("numero", pr.getNumeroPratica());

				listaFascicoloCorrelati.add(mapCorrelati);
			}
		}
		map.put("listaFascicoliCorrelati", listaFascicoloCorrelati);

		// Attori
		List<HashMap<String, String>> listaAttori = new ArrayList<HashMap<String,String>>();
		if (this.getFigure()!=null){
			for (Figura attore : this.getFigure()){
				HashMap<String, String> mapAttore = new HashMap<String, String>();
				mapAttore.put("qualifica", attore.getQualifica().getNome());
				mapAttore.put("nominativo", attore.getReferente().getNominativo());
				mapAttore.put("nome", attore.getReferente().getNome());
				mapAttore.put("numAlbo", attore.getReferente().getNumalbo());
				mapAttore.put("cognome", attore.getReferente().getCognome());
				mapAttore.put("indirizzo", attore.getReferente().getIndirizzo());
				mapAttore.put("cap", attore.getReferente().getCap());
				if(attore.getReferente().getComune() != null)
					mapAttore.put("comune", attore.getReferente().getComune().getDenominazione());
				mapAttore.put("riferimentiTelefonici", attore.getReferente().getRiferimentitelefonici());
				mapAttore.put("partitaIva", attore.getReferente().getPiva());
				mapAttore.put("codiceFiscale", attore.getReferente().getCf());
				mapAttore.put("pec", attore.getReferente().getPec());
				mapAttore.put("coordinateBancarie", attore.getReferente().getCoordinateBancarie());
				mapAttore.put("compagniaAssicurativa", attore.getReferente().getCompagniaAssicurativa());
				mapAttore.put("nrPolizza", attore.getReferente().getNrPolizza());
				if(attore.getReferente().getDataStipulaAssicurazione() != null ) mapAttore.put("dataStipulaAssicurazione", attore.getReferente().getDataStipulaAssicurazione().toString());
				mapAttore.put("importoPolizza", attore.getReferente().getImportoPolizza());
				
				listaAttori.add(mapAttore);
			}
		}
		map.put("listaAttori", listaAttori);
		
		List<HashMap<String,Object>> listaAllegati = new ArrayList<HashMap<String,Object>>();
		if (this.getAllegati()!=null && !this.getAllegati().isEmpty()){
			for(AllegatiPratica allegato : this.getAllegati()) {
				HashMap<String,Object> mapAllegato = new HashMap<String, Object>();
				System.out.println("Pratica: nome Allegato "+allegato.getAllegati().getNomeDocumento());
				mapAllegato.put("descrizione",URLEncoder.encode(allegato.getAllegati().getNomeDocumento(), "ISO-8859-1").replaceAll("%3F", "'").replaceAll("%3f", "'").replaceAll("%", "\\\\'").replaceAll("\\+", " "));
				mapAllegato.put("uuidFile", allegato.getUuidFile());
				mapAllegato.put("presente", allegato.isCaricato() && !allegato.isSpostato() && !allegato.isCancellato());
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

	public List<String> getCodiciAteco() {
		return codiciAteco;
	}

	public void setCodiciAteco(List<String> codiciAteco) {
		this.codiciAteco = codiciAteco;
	}

	public EsitoIstruttoria getEsitoIstruttoria() {
		return esitoIstruttoria;
	}

	public void setEsitoIstruttoria(EsitoIstruttoria esitoIstruttoria) {
		this.esitoIstruttoria = esitoIstruttoria;
	}

	public Date getDataValidazione() {
		return dataValidazione;
	}

	public void setDataValidazione(Date dataValidazione) {
		this.dataValidazione = dataValidazione;
	}

	public int getPunteggioIstanza() {
		return punteggioIstanza;
	}

	public void setPunteggioIstanza(int punteggioIstanza) {
		this.punteggioIstanza = punteggioIstanza;
	}

	public String getNoteIstruttore() {
		return noteIstruttore;
	}

	public void setNoteIstruttore(String noteIstruttore) {
		this.noteIstruttore = noteIstruttore;
	}

	public String getCommentiIstruttore() {
		return commentiIstruttore;
	}

	public void setCommentiIstruttore(String commentiIstruttore) {
		this.commentiIstruttore = commentiIstruttore;
	}
	public List<DatiCatastaliImmobile> getDatiCatastali() {
		return datiCatastali;
	}

	public void setDatiCatastali(List<DatiCatastaliImmobile> datiCatastali) {
		this.datiCatastali = datiCatastali;
	}

	public Preventivo getPreventivo() {
		return preventivo;
	}

	public void setPreventivo(Preventivo preventivo) {
		this.preventivo = preventivo;
	}

	public boolean isIseeVerificato() {
		return iseeVerificato;
	}

	public void setIseeVerificato(boolean iseeVerificato) {
		this.iseeVerificato = iseeVerificato;
	}

	public String getImpresa() {
		return impresa;
	}

	public void setImpresa(String impresa) {
		this.impresa = impresa;
	}

	public String getTitolare() {
		return titolare;
	}

	public void setTitolare(String titolare) {
		this.titolare = titolare;
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

	public double getIseeDaDSU() {
		return iseeDaDSU;
	}

	public void setIseeDaDSU(double iseeDaDSU) {
		this.iseeDaDSU = iseeDaDSU;
	}
	
	public String getIseeDaDSUString() {
		return DecimalFormat.getCurrencyInstance(Locale.ITALY).format(iseeDaDSU);
	}

	public Date getDataVerificaIsee() {
		return dataVerificaIsee;
	}
	public String getDataVerificaIseeString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		if (dataVerificaIsee !=null)
			return sdf.format(dataVerificaIsee);
		else
			return "";
	}

	public void setDataVerificaIsee(Date dataVerificaIsee) {
		this.dataVerificaIsee = dataVerificaIsee;
	}

	public double getIseeDichiarato() {
		return iseeDichiarato;
	}

	public void setIseeDichiarato(double iseeDichiarato) {
		this.iseeDichiarato = iseeDichiarato;
	}
	
	public String getIseeDichiaratoString() {
		return DecimalFormat.getCurrencyInstance(Locale.ITALY).format(iseeDichiarato);
	}

	public boolean isIseeValido() {
		return iseeValido;
	}

	public void setIseeValido(boolean iseeValido) {
		this.iseeValido = iseeValido;
	}

	public String getTecnico() {
		return tecnico;
	}

	public void setTecnico(String tecnico) {
		this.tecnico = tecnico;
	}

	public Date getDataChiusuraIstruttoria() {
		return dataChiusuraIstruttoria;
	}

	public void setDataChiusuraIstruttoria(Date dataChiusuraIstruttoria) {
		this.dataChiusuraIstruttoria = dataChiusuraIstruttoria;
	}

	public Date getDataChiusuraPratica() {
		return dataChiusuraPratica;
	}

	public void setDataChiusuraPratica(Date dataChiusuraPratica) {
		this.dataChiusuraPratica = dataChiusuraPratica;
	}

	public int getGgDurataRiscontroIstruttoria() {
		return ggDurataRiscontroIstruttoria;
	}

	public void setGgDurataRiscontroIstruttoria(int ggDurataRiscontroIstruttoria) {
		this.ggDurataRiscontroIstruttoria = ggDurataRiscontroIstruttoria;
	}
	
}
