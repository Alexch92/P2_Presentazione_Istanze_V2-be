package it.sincon.gepred.visura.rupar.bean;

import java.util.Date;

import com.google.gson.annotations.SerializedName;

public class ElencoSoci {

	private Riquadri riquadri;
	
	@SerializedName("dt-soci-titolari-al")
	private Date dataSociTitolariAl;

	public Riquadri getRiquadri() {
		return riquadri;
	}

	public void setRiquadri(Riquadri riquadri) {
		this.riquadri = riquadri;
	}

	public Date getDataSociTitolariAl() {
		return dataSociTitolariAl;
	}

	public void setDataSociTitolariAl(Date dataSociTitolariAl) {
		this.dataSociTitolariAl = dataSociTitolariAl;
	}
	
	
}
