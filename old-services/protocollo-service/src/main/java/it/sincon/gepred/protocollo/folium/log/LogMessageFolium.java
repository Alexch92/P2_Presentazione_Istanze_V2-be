package it.sincon.gepred.protocollo.folium.log;

import java.io.ByteArrayOutputStream;

import javax.xml.namespace.QName;
import javax.xml.rpc.handler.GenericHandler;
import javax.xml.rpc.handler.MessageContext;
import javax.xml.rpc.handler.soap.SOAPMessageContext;
import javax.xml.soap.SOAPMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogMessageFolium extends GenericHandler {

	private static Logger log = LoggerFactory.getLogger(LogMessageFolium.class);
	
	@Override
	public QName[] getHeaders() {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public boolean handleRequest(MessageContext context) {  
		try {  
			SOAPMessageContext smc = (SOAPMessageContext)context;  
			SOAPMessage msg = smc.getMessage();
			
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			msg.writeTo(baos);
			//log.info("request: "+new String(baos.toByteArray()));
		} catch(Exception ex) {  
			ex.printStackTrace();  
		}  
		return super.handleRequest(context);  
	}  
	
	@Override
	public boolean handleResponse(MessageContext context) {  
		try {  
			SOAPMessageContext smc = (SOAPMessageContext)context;  
			SOAPMessage msg = smc.getMessage();  
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			msg.writeTo(baos);
			//log.info("request: "+new String(baos.toByteArray()));
		} catch(Exception ex) {  
			ex.printStackTrace();  
		}  
		return super.handleResponse(context);  
	}  
}
