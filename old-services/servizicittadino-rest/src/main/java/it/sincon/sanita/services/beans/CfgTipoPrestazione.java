package it.sincon.sanita.services.beans;

/**
 * Classe con le configurazioni di un Ente che espone i servizi al cittadino
 * @author Santomauro
 *
 */
public class CfgTipoPrestazione {
	private String titolo;
	private String tipoErogazione;
	private String tipoPrescrizione;
	public CfgTipoPrestazione(
			String _titolo,
			String _tipoErogazione,
			String _tipoPrescrizione){
		this.titolo = _titolo;
		this.tipoErogazione = _tipoErogazione;
		this.tipoPrescrizione = _tipoPrescrizione;
	}
	
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public String getTipoErogazione() {
		return tipoErogazione;
	}
	public void setTipoErogazione(String tipoErogazione) {
		this.tipoErogazione = tipoErogazione;
	}
	public String getTipoPrescrizione() {
		return tipoPrescrizione;
	}
	public void setTipoPrescrizione(String tipoPrescrizione) {
		this.tipoPrescrizione = tipoPrescrizione;
	}
	
}
