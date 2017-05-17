package com.example.ws.client.handler;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.ws.domain.util.WsUtils;
import com.sun.xml.wss.ProcessingContext;
import com.sun.xml.wss.XWSSProcessor;
import com.sun.xml.wss.XWSSProcessorFactory;
import com.sun.xml.wss.XWSSecurityException;
import com.sun.xml.wss.impl.callback.UsernameCallback;

public class SecuredMessageHandler implements SOAPHandler<SOAPMessageContext> {

	private Logger logger = LoggerFactory.getLogger(LogPayloadLogicalHandler.class);
	
	private XWSSProcessor processor = null;
	
	public SecuredMessageHandler() {
		try {
			XWSSProcessorFactory wssProcessorFactory = XWSSProcessorFactory.newInstance();
			InputStream clientConfig = this.getClass().getClassLoader().getResourceAsStream("secure-client.xml");
			processor = wssProcessorFactory.createProcessorForSecurityConfiguration(clientConfig, new CallbackHandler() {
				public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
					logger.info("CallBack Handler");
				}
			});
			clientConfig.close();
			
		} catch (IOException | XWSSecurityException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public boolean handleMessage(SOAPMessageContext context) {
		Boolean out = (Boolean)context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
		if(out) {
			SOAPMessage soapMessage = context.getMessage();
			try {
				ProcessingContext processingContext = processor.createProcessingContext(soapMessage);
				processingContext.setSOAPMessage(soapMessage);
				
				SOAPMessage securedSOAPMessage = processor.secureOutboundMessage(processingContext);
				
//				logger.info("Securing SOAP Message");
//				WsUtils.logSOAPMessage(logger, securedSOAPMessage);
//				logger.info("End Securing SOAP Message");
				
				context.setMessage(securedSOAPMessage);
				
			} catch (XWSSecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return true;
	}
	
	@Override
	public boolean handleFault(SOAPMessageContext context) {
		logger.info("Fault on "+this.getClass());
		return true;
	}
	
	@Override
	public void close(MessageContext context) {
		logger.info("Closing "+this.getClass());
	}
	
	@Override
	public Set<QName> getHeaders() {
		QName securityHeader = new QName("http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd", "Security", "wsse");
		Set<QName> headers = new HashSet<>();
		headers.add(securityHeader);
		return headers;
	}
	
}
