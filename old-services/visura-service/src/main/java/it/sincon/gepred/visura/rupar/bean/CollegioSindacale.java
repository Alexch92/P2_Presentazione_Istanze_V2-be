package it.sincon.gepred.visura.rupar.bean;

import com.google.gson.annotations.SerializedName;

public class CollegioSindacale {

	private String value;
	
	@SerializedName("n-effettivi")
	private int numeroEffettivi;
	
	@SerializedName("n-supplenti")
	private Integer numeroSupplenti;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int getNumeroEffettivi() {
		return numeroEffettivi;
	}

	public void setNumeroEffettivi(int numeroEffettivi) {
		this.numeroEffettivi = numeroEffettivi;
	}

	public Integer getNumeroSupplenti() {
		return numeroSupplenti;
	}

	public void setNumeroSupplenti(Integer numeroSupplenti) {
		this.numeroSupplenti = numeroSupplenti;
	}
	
	
}
