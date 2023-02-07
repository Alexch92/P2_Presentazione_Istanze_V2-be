package it.sincon.sanita.services.beans;

public class PagamentoTicketEnteJAXB {
	public String idEnte;
	public String denominazione;
	public String url;
	
	public PagamentoTicketEnteJAXB(){};
	
	public PagamentoTicketEnteJAXB(String _idEnte, String _denominazione, String _pagamentoURL){
		this.idEnte = _idEnte;
		this.denominazione = _denominazione;
		this.url = _pagamentoURL;
	}
	
}

