package it.osapulie.infrastructure;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;


public interface XMLHelper extends Marshaller, Unmarshaller {
	/**
	 * Restituisce la rappresentazione XML (marshalled) dell'oggetto indicato.
	 * 
	 * @param graph l'oggetto di cui effettuare il marshalling
	 * @return una stringa contenente la rappresentazione XML dell'oggetto.
	 */
	String marshal( Object graph );

	/**
	 * Restituisce l'oggetto rappresentanto dalla sorgente XML.<br/>
	 * <strong>Nota</strong> che l'element type specificato nell'XSD associato a questo XML deve 
	 * essere associato ad una classe annotata con l'annotazione {@link XmlRootElement} o la 
	 * deserializzazione fallirà. Vedere <a href="http://springwstemplatejax2bxmlrootmissing.blogspot.com/">qui</a>
	 * per ulteriori dettagli.
	 * @param source una stringa sorgente contenente l'XML da deserializzare
	 * @return l'oggetto deserializzato 
	 */
	<T> T unmarshal( String source );
	
	/**
	 * Quando {@link XmlRootElement} non è presente sulla classe che si conosce essere rappresentata
	 * nell'XML (vedi {@link #unmarshal(String)}, è possibile forzarlo specificando la classe: questo
	 * metodo semplifica l'utilizzo dell'API JAXB. 
	 * @param content una stringa sorgente contenente l'XML da deserializzare
	 * @param type la classe del tipo serializzata in XML
	 * @return l'oggetto deserializzato 
	 */
	<T> T unmarshal( String content, Class<T> type );
}