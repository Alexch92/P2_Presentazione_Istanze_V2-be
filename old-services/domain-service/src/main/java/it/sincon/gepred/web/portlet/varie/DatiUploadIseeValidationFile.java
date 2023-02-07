package it.sincon.gepred.web.portlet.varie;

import java.io.Serializable;
import java.util.Date;
import org.springframework.web.multipart.MultipartFile;

public class DatiUploadIseeValidationFile  implements Serializable{
	
	private static final long serialVersionUID = -881234567890L;
	private MultipartFile iseeFile;
	private Date dataValidazione;
	
	
	
	public MultipartFile getIseeFile() {
		return iseeFile;
	}
	public void setIseeFile(MultipartFile iseeFile) {
		this.iseeFile = iseeFile;
	}
	public Date getDataValidazione() {
		return dataValidazione;
	}
	public void setDataValidazione(Date dataValidazione) {
		this.dataValidazione = dataValidazione;
	}
}

