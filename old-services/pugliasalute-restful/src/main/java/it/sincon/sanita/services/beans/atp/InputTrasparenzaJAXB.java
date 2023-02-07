package it.sincon.sanita.services.beans.atp;

import java.util.List;

public class InputTrasparenzaJAXB {
	public String idAzienda;
	public String azienda;
	public String tipoItem;
	public String trasparenza;
	public Integer limit;
	public Integer offset;
	public List<String> stati;
	
	public String getStatiJson(){
		return "[\"publish\", \"extend\", \"annul\"]";
	}
	
	public String getIdAzienda() {
		return idAzienda;
	}
	
	public String getAzienda() {
		return azienda;
	}

	public String getTipoItem() {
		return tipoItem;
	}

	public String getTrasparenza() {
		return trasparenza;
	}

	public Integer getLimit() {
		return limit;
	}

	public Integer getOffset() {
		return offset;
	}

	public List<String> getStati() {
		return stati;
	}
	
	
}
