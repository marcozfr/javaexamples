package com.example.ws.client.handler;

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

import com.example.ws.client.WsUtils;

public class AddHeaderProtocolHandler implements SOAPHandler<SOAPMessageContext>{
	
	Logger logger = LoggerFactory.getLogger(AddHeaderProtocolHandler.class);

	@Override
	public boolean handleMessage(SOAPMessageContext context) {
		boolean isOutRequest =(boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
		if(isOutRequest){
			SOAPMessage soapMessage = context.getMessage();
			try {
				SOAPHeaderElement agentHeader = soapMessage
						.getSOAPHeader().addHeaderElement(new QName("http://client.ws.example.com/","agent"));

				agentHeader.addTextNode("jaxws-local-client");
				
				logger.info("Added header to message : ");
				WsUtils.logSOAPMessage(logger, soapMessage);
				
			} catch (SOAPException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return true;
	}

	@Override
	public boolean handleFault(SOAPMessageContext context) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void close(MessageContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Set<QName> getHeaders() {
		// TODO Auto-generated method stub
		return null;
	}

}
