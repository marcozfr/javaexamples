package com.example.ws.process.server.handler;

import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.ws.domain.util.WsUtils;

public class LogMessageHandler implements SOAPHandler<SOAPMessageContext> {

	Logger logger = LoggerFactory.getLogger(LogMessageHandler.class);
	
	@Override
	public boolean handleMessage(SOAPMessageContext context) {
		Boolean isOutRequest = (Boolean)context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
		if(isOutRequest){
			logger.info("Return Message : \n");
		}else{
			logger.info("Incoming Message : \n");
		}
		WsUtils.logSOAPMessage(logger, context.getMessage());
		return true;
	}

	@Override
	public boolean handleFault(SOAPMessageContext context) {
		logger.info("Fault generated s");
		return true;
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
