package com.example.ws.http.client;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import javax.xml.ws.Service.Mode;
import javax.xml.ws.handler.HandlerResolver;
import javax.xml.ws.handler.PortInfo;
import javax.xml.ws.soap.MTOMFeature;
import javax.xml.ws.soap.SOAPBinding;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.ws.client.handler.LogPayloadLogicalHandler;
import com.example.ws.domain.files.File;
import com.example.ws.domain.util.WsUtils;

public class DispatchClientJAXBContext {
	
	private static Logger log = LoggerFactory.getLogger(DispatchClientJAXBContext.class);
	
	public static void main(String[] args) throws  IOException, JAXBException {
		QName serviceName = new QName("http://process.ws.example.com","LongProcessService");
		QName portName = new QName("http://process.ws.example.com","LongProcessPort");
		
		Service service = Service.create(serviceName);
		
		service.addPort(portName, SOAPBinding.SOAP11HTTP_BINDING , "http://localhost:8180/jaxws-local/LongProcessService?wsdl");
		service.setHandlerResolver(new HandlerResolver() {
			@Override
			public List getHandlerChain(PortInfo arg0) {
				return Collections.singletonList(new LogPayloadLogicalHandler());
			}
		});
		
		JAXBContext jaxbContext = JAXBContext.newInstance(File.class);
		
		Dispatch<Object> dispatch = service
				.createDispatch(portName, jaxbContext, Mode.PAYLOAD, new MTOMFeature(true, 5000));
		
		((BindingProvider)dispatch).getRequestContext().put(BindingProvider.USERNAME_PROPERTY, "admin");
		((BindingProvider)dispatch).getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, "c90100a");
		
		File file = new File();
		file.setName("pdf-file");
		file.setContent(IOUtils.toByteArray(DispatchClientJAXBContext.class.getClassLoader().getResourceAsStream("elk.jpg")));
		
		Object soapResponse = dispatch.invoke(file);
		
		log.info("Response : " + soapResponse);
		
	}

}
