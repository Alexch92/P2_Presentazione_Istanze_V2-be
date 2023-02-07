package it.sincon.gepred.visura.rupar.bean;

import com.google.gson.annotations.SerializedName;

public class AmministrazioneControllo {

	@SerializedName("sistema-amministrazione")
	private SistemaAmministrazione sistemaAmministrazione;
	
	@SerializedName("sistema-controllo-contabile")
	private SoggettoControlloContabile soggettoControlloContabile;
	
	@SerializedName("forme-amministrative")
	private FormeAmministrative formeAmministrative;
	
	@SerializedName("collegio-sindacale")
	private CollegioSindacale collegioSindacale;

	public SistemaAmministrazione getSistemaAmministrazione() {
		return sistemaAmministrazione;
	}

	public void setSistemaAmministrazione(SistemaAmministrazione sistemaAmministrazione) {
		this.sistemaAmministrazione = sistemaAmministrazione;
	}

	public SoggettoControlloContabile getSoggettoControlloContabile() {
		return soggettoControlloContabile;
	}

	public void setSoggettoControlloContabile(SoggettoControlloContabile soggettoControlloContabile) {
		this.soggettoControlloContabile = soggettoControlloContabile;
	}

	public FormeAmministrative getFormeAmministrative() {
		return formeAmministrative;
	}

	public void setFormeAmministrative(FormeAmministrative formeAmministrative) {
		this.formeAmministrative = formeAmministrative;
	}

	public CollegioSindacale getCollegioSindacale() {
		return collegioSindacale;
	}

	public void setCollegioSindacale(CollegioSindacale collegioSindacale) {
		this.collegioSindacale = collegioSindacale;
	}
	
	
}
