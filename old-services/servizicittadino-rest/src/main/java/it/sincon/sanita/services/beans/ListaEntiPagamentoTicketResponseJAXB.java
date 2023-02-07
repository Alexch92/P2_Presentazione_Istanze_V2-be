package it.sincon.sanita.services.beans;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ListaEntiPagamentoTicketResponseJAXB {
	public int numFound;
	public int start;
	public List<PagamentoTicketEnteJAXB> data;
	
	public ListaEntiPagamentoTicketResponseJAXB(){};
	
	public ListaEntiPagamentoTicketResponseJAXB(int _numFound, int _start, List<PagamentoTicketEnteJAXB> _data){
		this.numFound = _numFound;
		this.start = _start;
		this.data = _data;
	}
	
}

