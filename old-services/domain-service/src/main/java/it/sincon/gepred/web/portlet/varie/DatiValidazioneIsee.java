package it.sincon.gepred.web.portlet.varie;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.web.multipart.MultipartFile;

public class DatiValidazioneIsee  implements Serializable{
	
	private static final long serialVersionUID = -881234567890L;
	private String nrPratica;
	private String cfRichiedenteDSU;
	private Date dataPresentazioneDSU;
	private Date dataValidazione;
	private double valoreIsee;
	private double valoreIseeDSU;
	private boolean validazioneOK;
	
	private String valoreIseeAsString;
	public String getValoreIseeAsString() {
		return DecimalFormat.getCurrencyInstance(Locale.ITALY).format(valoreIsee);
	}
	private String valoreIseeDSUAsString;
	public String getValoreIseeDSUAsString() {
		return DecimalFormat.getCurrencyInstance(Locale.ITALY).format(valoreIseeDSU);
	}
	
	public String getNrPratica() {
		return nrPratica;
	}
	public void setNrPratica(String nrPratica) {
		this.nrPratica = nrPratica;
	}
	public String getCfRichiedenteDSU() {
		return cfRichiedenteDSU;
	}
	public void setCfRichiedenteDSU(String cfRichiedenteDSU) {
		this.cfRichiedenteDSU = cfRichiedenteDSU;
	}
	public Date getDataPresentazioneDSU() {
		return dataPresentazioneDSU;
	}
	public void setDataPresentazioneDSU(Date dataPresentazioneDSU) {
		this.dataPresentazioneDSU = dataPresentazioneDSU;
	}
	public Date getDataValidazione() {
		return dataValidazione;
	}
	public void setDataValidazione(Date dataValidazione) {
		this.dataValidazione = dataValidazione;
	}
	public double getValoreIsee() {
		return valoreIsee;
	}
	public void setValoreIsee(double valoreIsee) {
		this.valoreIsee = valoreIsee;
	}
	public double getValoreIseeDSU() {
		return valoreIseeDSU;
	}
	public void setValoreIseeDSU(double valoreIseeDSU) {
		this.valoreIseeDSU = valoreIseeDSU;
	}
	public boolean isValidazioneOK() {
		return validazioneOK = valoreIsee == valoreIseeDSU;
	}
	
}

