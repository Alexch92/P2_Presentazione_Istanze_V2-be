package it.sincon.gepred.web.portlet.utils;

public class DtoPunteggioRange {
	private int sogliaDa;
	private int sogliaA;
	private int idxValoreCampo;
	private int punteggio;
	
	public int getSogliaDa() {
		return sogliaDa;
	}
	public void setSogliaDa(int sogliaDa) {
		this.sogliaDa = sogliaDa;
	}
	public int getSogliaA() {
		return sogliaA;
	}
	public void setSogliaA(int sogliaA) {
		this.sogliaA = sogliaA;
	}
	public int getPunteggio() {
		return punteggio;
	}
	public void setPunteggio(int punteggio) {
		this.punteggio = punteggio;
	}
	public int getIdxValoreCampo() {
		return idxValoreCampo;
	}
	public void setIdxValoreCampo(int idxValoreCampo) {
		this.idxValoreCampo = idxValoreCampo;
	}
	public DtoPunteggioRange(int _sogliaDa, int _sogliaA, int _punt) {
		this.sogliaDa = _sogliaDa;
		this.sogliaA = _sogliaA;
		this.punteggio = _punt;
	}
	public DtoPunteggioRange(int _idxValoreCampo, int _punt) {
		this.idxValoreCampo = _idxValoreCampo;
		this.punteggio = _punt;
	}
}
