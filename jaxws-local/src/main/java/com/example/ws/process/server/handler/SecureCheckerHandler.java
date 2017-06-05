package com.example.ws.process.server.handler;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.ws.process.server.validator.UsersPasswordValidator;
import com.sun.xml.wss.ProcessingContext;
import com.sun.xml.wss.XWSSProcessor;
import com.sun.xml.wss.XWSSProcessorFactory;
import com.sun.xml.wss.XWSSecurityException;
import com.sun.xml.wss.impl.callback.PasswordValidationCallback;
import com.sun.xml.wss.impl.callback.TimestampValidationCallback;
import com.sun.xml.wss.impl.callback.TimestampValidationCallback.TimestampValidationException;
import com.sun.xml.wss.impl.callback.TimestampValidationCallback.TimestampValidator;

public class SecureCheckerHandler implements SOAPHandler<SOAPMessageContext> {
	
	private Logger logger = LoggerFactory.getLogger(SecureCheckerHandler.class);
			
	private XWSSProcessor processor;
	
	public SecureCheckerHandler() {
		try {
			XWSSProcessorFactory processorFactory = XWSSProcessorFactory.newInstance();
			InputStream config = this.getClass().getClassLoader().getResourceAsStream("secure-server.xml");
			processor = processorFactory.createProcessorForSecurityConfiguration(config, new CallbackHandler() {
				@Override
				public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
					logger.info("Verify tokens with callbacks " + callbacks);
					for (int i = 0; i < callbacks.length; i++) {
						if(callbacks[i] instanceof PasswordValidationCallback){
							PasswordValidationCallback pwdCback = (PasswordValidationCallback)callbacks[i];
							pwdCback.setValidator(new UsersPasswordValidator());
						}
						if(callbacks[i] instanceof TimestampValidationCallback){
							TimestampValidationCallback tmpBack = (TimestampValidationCallback)callbacks[i];
							tmpBack.setValidator(new TimestampValidator() {
								@Override
								public void validate(com.sun.xml.wss.impl.callback.TimestampValidationCallback.Request request)
										throws TimestampValidationException {
									logger.info("Validating timestamp");
								}
							});
						}
					}
					
				}
			});
			config.close();
		} catch (XWSSecurityException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	@Override
	public boolean handleMessage(SOAPMessageContext context) {
		Boolean out = (Boolean)context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
		if(!out){
			SOAPMessage soapMessage = context.getMessage();
			
			try {
				ProcessingContext processingContext = processor.createProcessingContext(soapMessage);
				SOAPMessage verifiedSoapMessage = processor.verifyInboundMessage(processingContext);
				
				context.setMessage(verifiedSoapMessage);
				
			} catch (XWSSecurityException e) {
				throw new WebServiceException(e);
			}
		}
		return true;
	}

	@Override
	public boolean handleFault(SOAPMessageContext context) {
		logger.info("Fault on " +this.getClass());
		return false;
	}

	@Override
	public void close(MessageContext context) {
		logger.info("Closing " + this.getClass());
	}

	@Override
	public Set<QName> getHeaders() {
		QName securityHdr = new QName("http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd", "Security", "wsse");
		HashSet<QName> headers = new HashSet<QName>();
		headers.add(securityHdr);
		return headers;
	}

}
