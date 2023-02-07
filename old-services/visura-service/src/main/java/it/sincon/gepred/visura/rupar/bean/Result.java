package it.sincon.gepred.visura.rupar.bean;

import com.google.gson.annotations.SerializedName;

public class Result {

	@SerializedName("dati-identificativi")
	private DatiIdentificativi datiIdentificativi;
	
	@SerializedName("info-attivita")
	private InfoAttivita infoAttivita;
	
	@SerializedName("albi-ruoli-licenze-ridotti")
	private AlbiRuoliLicenzeRidotti albiRuoliLicenzeRidotti;
	
	@SerializedName("persone-sede")
	private PersoneSede personeSede;
	
	private Localizzazioni localizzazioni;
	
	@SerializedName("elenco-soci")
	private ElencoSoci elencoSoci;
	
	@SerializedName("info-statuto")
	private InfoStatuto infoStatuto;
	
	@SerializedName("amministrazione-controllo")
	private AmministrazioneControllo amministrazioneControllo;
	
	@SerializedName("info-patrimoniali-finanziarie")
	private InfoPatrimonialiFinanziarie infoPatrimonialiFinanziarie;
	
	@SerializedName("scritta-pco-s")
	private ScrittaPcoS scrittaPcoS;

	public DatiIdentificativi getDatiIdentificativi() {
		return datiIdentificativi;
	}

	public void setDatiIdentificativi(DatiIdentificativi datiIdentificativi) {
		this.datiIdentificativi = datiIdentificativi;
	}

	public InfoAttivita getInfoAttivita() {
		return infoAttivita;
	}

	public void setInfoAttivita(InfoAttivita infoAttivita) {
		this.infoAttivita = infoAttivita;
	}

	public AlbiRuoliLicenzeRidotti getAlbiRuoliLicenzeRidotti() {
		return albiRuoliLicenzeRidotti;
	}

	public void setAlbiRuoliLicenzeRidotti(AlbiRuoliLicenzeRidotti albiRuoliLicenzeRidotti) {
		this.albiRuoliLicenzeRidotti = albiRuoliLicenzeRidotti;
	}

	public PersoneSede getPersoneSede() {
		return personeSede;
	}

	public void setPersoneSede(PersoneSede personeSede) {
		this.personeSede = personeSede;
	}

	public Localizzazioni getLocalizzazioni() {
		return localizzazioni;
	}

	public void setLocalizzazioni(Localizzazioni localizzazioni) {
		this.localizzazioni = localizzazioni;
	}

	public ElencoSoci getElencoSoci() {
		return elencoSoci;
	}

	public void setElencoSoci(ElencoSoci elencoSoci) {
		this.elencoSoci = elencoSoci;
	}

	public InfoStatuto getInfoStatuto() {
		return infoStatuto;
	}

	public void setInfoStatuto(InfoStatuto infoStatuto) {
		this.infoStatuto = infoStatuto;
	}

	public AmministrazioneControllo getAmministrazioneControllo() {
		return amministrazioneControllo;
	}

	public void setAmministrazioneControllo(AmministrazioneControllo amministrazioneControllo) {
		this.amministrazioneControllo = amministrazioneControllo;
	}

	public InfoPatrimonialiFinanziarie getInfoPatrimonialiFinanziarie() {
		return infoPatrimonialiFinanziarie;
	}

	public void setInfoPatrimonialiFinanziarie(InfoPatrimonialiFinanziarie infoPatrimonialiFinanziarie) {
		this.infoPatrimonialiFinanziarie = infoPatrimonialiFinanziarie;
	}

	public ScrittaPcoS getScrittaPcoS() {
		return scrittaPcoS;
	}

	public void setScrittaPcoS(ScrittaPcoS scrittaPcoS) {
		this.scrittaPcoS = scrittaPcoS;
	}
	
	
}
