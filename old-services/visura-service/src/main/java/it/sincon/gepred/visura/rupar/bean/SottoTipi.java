package it.sincon.gepred.visura.rupar.bean;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class SottoTipi {

	@SerializedName("sotto-tipo")
	private List<SottoTipo> sottoTipo;

	public List<SottoTipo> getSottoTipo() {
		return sottoTipo;
	}

	public void setSottoTipo(List<SottoTipo> sottoTipo) {
		this.sottoTipo = sottoTipo;
	}
	
	
}
