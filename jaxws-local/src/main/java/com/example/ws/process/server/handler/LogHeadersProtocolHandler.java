package com.example.ws.process.server.handler;

import java.util.Iterator;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeaderElement;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogHeadersProtocolHandler implements SOAPHandler<SOAPMessageContext> {
	
	private static Logger logger = LoggerFactory.getLogger(LogHeadersProtocolHandler.class);

	@Override
	public boolean handleMessage(SOAPMessageContext context) {
		
		Boolean out = (Boolean)context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
		if(!out){
			SOAPMessage soapMessage = context.getMessage();
			try {
				Iterator iterator = soapMessage.getSOAPHeader().getChildElements();
				while(iterator.hasNext()){
					SOAPHeaderElement header = (SOAPHeaderElement)iterator.next();
					logger.info("Header " + header.getNodeName());
					logger.info("- Namespace: " + header.getNamespaceURI());
					logger.info("- Prefix: " + header.getPrefix());
					logger.info("- Value: " + header.getValue());
				}
			} catch (SOAPException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return true;
	}

	@Override
	public boolean handleFault(SOAPMessageContext context) {
		logger.info("Fault Generated on " + this.getClass());
		return true;
	}

	@Override
	public void close(MessageContext context) {
		logger.info("Closing " + this.getClass());
	}

	@Override
	public Set<QName> getHeaders() {
		// TODO Auto-generated method stub
		return null;
	}

}
