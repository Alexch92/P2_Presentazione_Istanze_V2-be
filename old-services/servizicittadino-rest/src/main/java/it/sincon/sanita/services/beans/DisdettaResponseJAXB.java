package it.sincon.sanita.services.beans;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

@XmlRootElement
public class DisdettaResponseJAXB {
	@XmlElement(name="Stato")
	public String Stato;
	
	@XmlElement(name="Errore")
	public String Errore;
	
	@XmlElement(name="PdfURL")
	public String PdfURL;
	
	public DisdettaResponseJAXB(){};
	
	public DisdettaResponseJAXB(String _stato, String _errore, String _pdfURL){
		this.Stato = _stato;
		this.Errore = _errore;
		this.PdfURL = _pdfURL;
	}
	
	public String toString() {
		try {
			return new JSONObject()
							.put("stato", Stato)
							.put("errore", Errore)
							.put("pdf_url", PdfURL)
							.toString();
		} catch (JSONException e) {
			return null;
		}
	}

}

