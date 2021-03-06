package com.example.ws.http.client;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.xml.namespace.QName;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Response;
import javax.xml.ws.Service;
import javax.xml.ws.Service.Mode;
import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.HandlerResolver;
import javax.xml.ws.handler.PortInfo;
import javax.xml.ws.soap.SOAPBinding;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.ws.client.handler.SecuredMessageHandler;
import com.example.ws.domain.util.WsUtils;

public class DispatchAsyncResponse extends AbstractPipeDumpDispatch {
	
	private static Logger logger = LoggerFactory.getLogger(DispatchAsyncResponse.class);

	
	public static void main(String[] args) throws SOAPException, InterruptedException, ExecutionException {
		QName serviceName = new QName("http://process.ws.example.com","LongProcessService");
		QName portName = new QName("http://process.ws.example.com","LongProcessPort");
		
		Service service = Service.create(serviceName);
		
		service.setHandlerResolver(new HandlerResolver() {
			
			@Override
			public List getHandlerChain(PortInfo portInfo) {
				return Arrays.asList(new SecuredMessageHandler());
			}
		});
		
		service.addPort(portName, SOAPBinding.SOAP12HTTP_MTOM_BINDING , "http://localhost:8180/jaxws-local/LongProcessService");
		
		Dispatch<SOAPMessage> dispatch = service.createDispatch(portName, SOAPMessage.class, Mode.MESSAGE);
		
		MessageFactory mf = MessageFactory.newInstance(SOAPConstants.SOAP_1_2_PROTOCOL);
		SOAPMessage soapMessage = mf.createMessage();
		
		SOAPElement element = soapMessage.getSOAPBody().addChildElement("run","proc","http://process.ws.example.com");
		element.addChildElement("arg0").addTextNode("Hello");
		
		Response<SOAPMessage> response = dispatch.invokeAsync(soapMessage);
		
		while(!response.isDone()){
			logger.info("Waiting for response...");
			Thread.sleep(500l);
		}
		
		SOAPMessage soapResponse = response.get();
		
		logger.info("Received Response.");
		
	}

}
