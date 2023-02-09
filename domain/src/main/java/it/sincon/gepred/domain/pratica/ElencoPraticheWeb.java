package it.sincon.gepred.domain.pratica;

import java.io.Serializable;
import java.util.List;

public class ElencoPraticheWeb implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private List<PraticaWebExtended> elencoPraticheWeb;

	public List<PraticaWebExtended> getElencoPraticheWeb() {
		return elencoPraticheWeb;
	}

	public void setElencoPraticheWeb(List<PraticaWebExtended> elencoPraticheWeb) {
		this.elencoPraticheWeb = elencoPraticheWeb;
	}

}
