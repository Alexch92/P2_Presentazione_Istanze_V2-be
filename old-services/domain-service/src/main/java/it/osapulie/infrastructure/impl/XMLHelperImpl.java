package it.osapulie.infrastructure.impl;

import it.osapulie.infrastructure.XMLHelper;
import it.osapulie.infrastructure.XMLUnmarshallingException;

import java.io.IOException;

import javax.inject.Inject;
import javax.xml.bind.JAXBElement;
import javax.xml.transform.Result;
import javax.xml.transform.Source;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;
import org.springframework.oxm.XmlMappingException;
import org.springframework.stereotype.Component;
import org.springframework.xml.transform.StringResult;
import org.springframework.xml.transform.StringSource;

@Component("xmlHelper")
public class XMLHelperImpl implements XMLHelper {

	private static Logger log = LoggerFactory.getLogger(XMLHelperImpl.class);

	@Autowired(required=false)
	private Marshaller marshaller;

	@Autowired(required=false)
	private Unmarshaller unmarshaller;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.oxm.Marshaller#supports(java.lang.Class)
	 */
	@Override
	public boolean supports(Class<?> clazz) {
		return true;//marshaller.supports(clazz); // Indifferente rispetto all'unmarshaller
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.oxm.Marshaller#marshal(java.lang.Object, javax.xml.transform.Result)
	 */
	@Override
	public void marshal(Object graph, Result result) throws IOException, XmlMappingException {
		marshaller.marshal(graph, result);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.oxm.Unmarshaller#unmarshal(javax.xml.transform.Source)
	 */
	@Override
	public Object unmarshal(Source source) throws IOException, XmlMappingException {
		return unmarshaller.unmarshal(source);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.osapulie.infrastructure.XMLHelper#marshal(java.lang.Object)
	 */
	@Override
	public String marshal(Object graph) {
		try {
			Result result = new StringResult();
			marshal(graph, result);
			return result.toString();
		}
		catch (Exception e) {
			String message = String.format("Marshalling dell'oggetto di tipo (\"%s\")", graph.getClass().getName());
			log.error(message, e);
			throw new XMLUnmarshallingException(message, e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.osapulie.infrastructure.XMLHelper#unmarshal(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T> T unmarshal(String content) {
		try {
			return (T) unmarshal(new StringSource(content));
		}
		catch (Exception e) {
			log.error("unmarshal :: " + e.getMessage(), e);
			throw new XMLUnmarshallingException("Unmarshalling del contenuto passato ", e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.osapulie.web.portlet.util.PortletHelper#unmarshal(java.lang.String, java.lang.Class)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public <T> T unmarshal(String content, Class<T> type) {
		try {
			Object o = unmarshal(new StringSource(content));
			if (type.isAssignableFrom(o.getClass())) {
				return (T) o;
			}
			JAXBElement<T> userElement = (JAXBElement<T>) o;
			T user = userElement.getValue();
			return user;
		}
		catch (Exception e) {
			log.error("unmarshal :: " + e.getMessage(), e);
			throw new XMLUnmarshallingException("Unmarshalling del contenuto passato ", e);
		}
	}
}
