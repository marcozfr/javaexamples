package com.example.ws.http.client;

import java.io.StringReader;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.HandlerResolver;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.PortInfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.ws.client.SOAPConnectionClient;
import com.example.ws.client.WsUtils;
import com.example.ws.client.handler.AddHeaderProtocolHandler;

public class DispatchClientJAXWS {
	
	private static Logger logger = LoggerFactory.getLogger(SOAPConnectionClient.class);
	
	public static void main(String[] args) throws TransformerException, MalformedURLException {
		
		QName serviceName = new QName("http://process.ws.example.com","LongProcessService");
		QName portName = new QName("http://process.ws.example.com","LongProcessPort");
		
		/** declaration 1
		 * Port specified at dispatch creation
		 */
		Service service = Service.create(new URL("http://localhost:8180/jaxws-local/LongProcessService?wsdl"),serviceName);
		
		service.setHandlerResolver(new HandlerResolver() {
			@Override
			public List getHandlerChain(PortInfo portInfo) {
				return Collections.singletonList(new AddHeaderProtocolHandler());
			}
		});
		
		Dispatch<Source> dispatch = service.createDispatch(portName, Source.class, Service.Mode.PAYLOAD);
		/** declaration 2
		 * 
		 */
//		Service service = Service.create(serviceName);
//		service.addPort(portName, bindingId, endpointAddress);
//		Dispatch<Source> dispatch = service.createDispatch(portName, Source.class, Service.Mode.PAYLOAD);
		
		dispatch.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, "admin");
		dispatch.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, "c90100a");
		dispatch.getRequestContext().put(MessageContext.HTTP_REQUEST_METHOD, "POST");
		
		Source result = dispatch.invoke(new StreamSource(new StringReader("<proc:run xmlns:proc=\"http://process.ws.example.com\"><arg0>Hello</arg0></proc:run>")));
		
		logger.info("\n Result: " +WsUtils.fromSource(result));
		
	}

}
