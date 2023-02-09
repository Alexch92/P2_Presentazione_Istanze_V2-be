package it.sincon.gepred.domain.pratica;

import java.io.Serializable;

public class PraticaWebExtended extends PraticaWeb implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private boolean checked ;


	public boolean isChecked() {
		return checked;
	}
	
//	public boolean getChecked() {
//		return checked;
//	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

}

