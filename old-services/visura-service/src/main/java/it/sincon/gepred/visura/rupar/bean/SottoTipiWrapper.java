package it.sincon.gepred.visura.rupar.bean;

import com.google.gson.annotations.SerializedName;

public class SottoTipiWrapper {
	
	@SerializedName("sotto-tipi")
	private SottoTipi sottoTipi;

	public SottoTipi getSottoTipi() {
		return sottoTipi;
	}

	public void setSottoTipi(SottoTipi sottoTipi) {
		this.sottoTipi = sottoTipi;
	}

}
