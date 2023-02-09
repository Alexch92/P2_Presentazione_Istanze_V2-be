package it.sincon.gepred.domain;


public class AllegatiPraticaExtended  {
	
	public AllegatiPraticaExtended(boolean _checked, AllegatiPratica _allegato){
		this.checked = _checked;
		this.allegatoPratica = _allegato;
	}
	
	private boolean checked = false;
	private AllegatiPratica allegatoPratica;
	
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	
	public AllegatiPratica getAllegatoPratica() {
		return allegatoPratica;
	}
	public void setAllegatoPratica(AllegatiPratica allegatoPratica) {
		this.allegatoPratica = allegatoPratica;
	}
}
