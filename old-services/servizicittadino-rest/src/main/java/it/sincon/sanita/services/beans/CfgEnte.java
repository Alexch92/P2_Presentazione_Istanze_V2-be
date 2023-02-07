package it.sincon.sanita.services.beans;

/**
 * Classe con le configurazioni di un Ente che espone i servizi al cittadino
 * @author Santomauro
 *
 */
public class CfgEnte {
	private String idEnte;
	private String nome;
	private String operatoreUsername;
	private String operatorePassword;
	private String codice;
	private String wsEndpointURL;
	private String pagamentoTicketURL;
	private String formatoDataAppuntamento;
	private String formatoDataDisdetta;
	public String getIdEnte() {
		return idEnte;
	}
	public void setIdEnte(String idEnte) {
		this.idEnte = idEnte;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getOperatoreUsername() {
		return operatoreUsername;
	}
	public void setOperatoreUsername(String operatoreUsername) {
		this.operatoreUsername = operatoreUsername;
	}
	public String getOperatorePassword() {
		return operatorePassword;
	}
	public void setOperatorePassword(String operatorePassword) {
		this.operatorePassword = operatorePassword;
	}
	public String getCodice() {
		return codice;
	}
	public void setCodice(String codice) {
		this.codice = codice;
	}
	public String getWsEndpointURL() {
		return wsEndpointURL;
	}
	public void setWsEndpointURL(String wsEndpointURL) {
		this.wsEndpointURL = wsEndpointURL;
	}
	public String getPagamentoTicketURL() {
		return pagamentoTicketURL;
	}
	public void setPagamentoTicketURL(String pagamentoTicketURL) {
		this.pagamentoTicketURL = pagamentoTicketURL;
	}
	public String getFormatoDataAppuntamento() {
		return formatoDataAppuntamento;
	}
	public void setFormatoDataAppuntamento(String formatoDataAppuntamento) {
		this.formatoDataAppuntamento = formatoDataAppuntamento;
	}
	public String getFormatoDataDisdetta() {
		return formatoDataDisdetta;
	}
	public void setFormatoDataDisdetta(String formatoDataDisdetta) {
		this.formatoDataDisdetta = formatoDataDisdetta;
	}
	// Per tutti gli  enti si calcola come segue...
	public String getCodiceUnicoPrenotazione(String anno, String numPrenotazione){
		return anno + codice + numPrenotazione;
	}
}
