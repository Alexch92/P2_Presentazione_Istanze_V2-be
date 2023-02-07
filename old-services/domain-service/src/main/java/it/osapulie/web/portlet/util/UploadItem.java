package it.osapulie.web.portlet.util;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

/**
 * Classe che descrive 
 * @author Maria Michela Birtolo
 * 
 */
public class UploadItem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private MultipartFile file;
	
	private String[] codiciFiscali;
	
	private String motivoRitiro;
	
	private boolean isRitiro;
	
	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public String[] getCodiceFiscale() {
		return codiciFiscali;
	}

	public void setCodiceFiscale(String[] codiciFiscali) {
		this.codiciFiscali = codiciFiscali;
	}

	public String getMotivoRitiro() {
		return motivoRitiro;
	}

	public void setMotivoRitiro(String motivoRitiro) {
		this.motivoRitiro = motivoRitiro;
	}

	public boolean isRitiro() {
		return isRitiro;
	}

	public void setRitiro(boolean isRitiro) {
		this.isRitiro = isRitiro;
	}
	
	
}
