package com.example.ws.client.handler;

import javax.xml.transform.Source;
import javax.xml.transform.TransformerException;
import javax.xml.ws.LogicalMessage;
import javax.xml.ws.handler.LogicalHandler;
import javax.xml.ws.handler.LogicalMessageContext;
import javax.xml.ws.handler.MessageContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.ws.domain.util.WsUtils;

public class LogPayloadLogicalHandler implements LogicalHandler<LogicalMessageContext>{
	
	Logger logger = LoggerFactory.getLogger(LogPayloadLogicalHandler.class);
	
	@Override
	public boolean handleMessage(LogicalMessageContext context) {
		LogicalMessage logicalMessage = context.getMessage();
		Source source = logicalMessage.getPayload();
		boolean isOutRequest =(boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
		try {
			if(isOutRequest){
				logger.info("Ongoing Message : \n");
			}else{
				logger.info("Return Message : \n");
			}
			logger.info(WsUtils.fromSource(source));
		} catch (TransformerException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	@Override
	public boolean handleFault(LogicalMessageContext context) {
		logger.info("Fault Generated");
		return true;
	}
	
	@Override
	public void close(MessageContext context) {
		logger.info("Closing " + this.getClass());
	}

}
