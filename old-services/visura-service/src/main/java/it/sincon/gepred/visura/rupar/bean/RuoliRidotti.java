package it.sincon.gepred.visura.rupar.bean;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class RuoliRidotti {

	@SerializedName("ruolo-ridotto")
	private List<RuoloRidotto> ruoloRidotto;

	public List<RuoloRidotto> getRuoloRidotto() {
		return ruoloRidotto;
	}

	public void setRuoloRidotto(List<RuoloRidotto> ruoloRidotto) {
		this.ruoloRidotto = ruoloRidotto;
	}
	
	
}
