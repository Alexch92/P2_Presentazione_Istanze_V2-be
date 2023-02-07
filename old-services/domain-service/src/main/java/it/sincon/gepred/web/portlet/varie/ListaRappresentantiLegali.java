package it.sincon.gepred.web.portlet.varie;

import java.io.Serializable;
import java.util.List;

import it.sincon.gepred.domain.pratica.Azienda;
import it.sincon.gepred.domain.pratica.AziendaRappresentanti;

public class ListaRappresentantiLegali  implements Serializable{
	
	private static final long serialVersionUID = -881234567890L;
	private List<AziendaRappresentanti> elencoRappresentanti;
	
	public List<AziendaRappresentanti> getElencoRappresentanti() {
		return elencoRappresentanti;
	}
	public void setElencoRappresentanti(List<AziendaRappresentanti> elencoRappresentanti) {
		this.elencoRappresentanti = elencoRappresentanti;
	}
	
}

