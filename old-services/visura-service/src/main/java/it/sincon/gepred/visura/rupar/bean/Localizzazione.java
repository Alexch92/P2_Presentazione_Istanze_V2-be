package it.sincon.gepred.visura.rupar.bean;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;

public class Localizzazione {

	private List<Object> sottoTipiOrIndirizzoLocalizzazioneOrAttivitaEsercitata;
	
	private int progressivo;
	
	@SerializedName("c-tipo")
	private String codiceTipo;
	
	private String tipo;
	
	@SerializedName("dt-apertura")
	private Date dataApertura;

	public List<Object> getSottoTipiOrIndirizzoLocalizzazioneOrAttivitaEsercitata() {
		if (sottoTipiOrIndirizzoLocalizzazioneOrAttivitaEsercitata!=null && !sottoTipiOrIndirizzoLocalizzazioneOrAttivitaEsercitata.isEmpty()) {
			if (sottoTipiOrIndirizzoLocalizzazioneOrAttivitaEsercitata.get(0) instanceof Map) {
				int indiceIndirizzoLocalizzazione=0;
				Gson gson = new Gson();
				if (sottoTipiOrIndirizzoLocalizzazioneOrAttivitaEsercitata.size()==5) {
					JsonElement sottoTipi = gson.toJsonTree(sottoTipiOrIndirizzoLocalizzazioneOrAttivitaEsercitata.get(0));
					SottoTipiWrapper sottoTipiWrapper= gson.fromJson(sottoTipi, SottoTipiWrapper.class);
					indiceIndirizzoLocalizzazione=1;
					sottoTipiOrIndirizzoLocalizzazioneOrAttivitaEsercitata.set(0, sottoTipiWrapper);
				}
				JsonElement indirizzoLocalizzazione=gson.toJsonTree(sottoTipiOrIndirizzoLocalizzazioneOrAttivitaEsercitata.get(indiceIndirizzoLocalizzazione));
				IndirizzoLocalizzazioneWrapper indirizzoLocalizzazioneWrapper=gson.fromJson(indirizzoLocalizzazione, IndirizzoLocalizzazioneWrapper.class);
				sottoTipiOrIndirizzoLocalizzazioneOrAttivitaEsercitata.set(indiceIndirizzoLocalizzazione, indirizzoLocalizzazioneWrapper);
				JsonElement sedeFuoriProvincia = gson.toJsonTree(sottoTipiOrIndirizzoLocalizzazioneOrAttivitaEsercitata.get(indiceIndirizzoLocalizzazione+1));
				SedeFuoriProvinciaWrapper sedeFuoriProvinciaWrapper=gson.fromJson(sedeFuoriProvincia, SedeFuoriProvinciaWrapper.class);
				sottoTipiOrIndirizzoLocalizzazioneOrAttivitaEsercitata.set(indiceIndirizzoLocalizzazione+1, sedeFuoriProvinciaWrapper);
				JsonElement classificazioneAteco = gson.toJsonTree(sottoTipiOrIndirizzoLocalizzazioneOrAttivitaEsercitata.get(sottoTipiOrIndirizzoLocalizzazioneOrAttivitaEsercitata.size()-1));
				ClassificazioneAtecoWrapper classificazioneAtecoWrapper = gson.fromJson(classificazioneAteco, ClassificazioneAtecoWrapper.class);
				sottoTipiOrIndirizzoLocalizzazioneOrAttivitaEsercitata.set(sottoTipiOrIndirizzoLocalizzazioneOrAttivitaEsercitata.size()-1, classificazioneAtecoWrapper);
			}
		}
		
		return sottoTipiOrIndirizzoLocalizzazioneOrAttivitaEsercitata;
	}

	public void setSottoTipiOrIndirizzoLocalizzazioneOrAttivitaEsercitata(
			List<Object> sottoTipiOrIndirizzoLocalizzazioneOrAttivitaEsercitata) {
		this.sottoTipiOrIndirizzoLocalizzazioneOrAttivitaEsercitata = sottoTipiOrIndirizzoLocalizzazioneOrAttivitaEsercitata;
	}

	public int getProgressivo() {
		return progressivo;
	}

	public void setProgressivo(int progressivo) {
		this.progressivo = progressivo;
	}

	public String getCodiceTipo() {
		return codiceTipo;
	}

	public void setCodiceTipo(String codiceTipo) {
		this.codiceTipo = codiceTipo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Date getDataApertura() {
		return dataApertura;
	}

	public void setDataApertura(Date dataApertura) {
		this.dataApertura = dataApertura;
	}
	
	
}
