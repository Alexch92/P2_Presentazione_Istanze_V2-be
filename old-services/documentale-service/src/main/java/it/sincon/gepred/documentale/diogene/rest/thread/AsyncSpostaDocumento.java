package it.sincon.gepred.documentale.diogene.rest.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.sincon.gepred.documentale.diogene.rest.DiogeneFacade;

public class AsyncSpostaDocumento extends Thread {
	private static Logger log = LoggerFactory.getLogger(AsyncSpostaDocumento.class);
	
	private DiogeneFacade diogene;
	
	private String idDocumento;
	private String tipoContenitore;
	private String idAggregatoDestinazione;
	
	public AsyncSpostaDocumento(
			DiogeneFacade _diogene,
			String _idDocumento, 
			String _idAggregatoDestinazione,
			String _tipoContenitore){
		this.diogene = _diogene;
		
		this.idDocumento = _idDocumento;
		this.tipoContenitore = _tipoContenitore;
		this.idAggregatoDestinazione = _idAggregatoDestinazione;
		
		this.setName("Async Diogene REST SpostaDocumento Thread");
	}
	
	@Override
	public void run() {

		try{
			diogene.spostaDocumento(idDocumento, idAggregatoDestinazione, tipoContenitore, true);
		}catch (Exception exp){
			log.error(exp.getMessage(), exp);
		}
	}
}
