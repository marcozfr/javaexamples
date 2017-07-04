package com.example.ws.http.client;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.namespace.QName;
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
import com.example.ws.client.handler.SecuredMessageHandler;
import com.example.ws.domain.files.File;

public class DispatchClientJAXBContext {
	
	private static Logger log = LoggerFactory.getLogger(DispatchClientJAXBContext.class);
	
	public static void main(String[] args) throws  IOException, JAXBException {
		QName serviceName = new QName("http://process.ws.example.com","LongProcessService");
		QName portName = new QName("http://process.ws.example.com","LongProcessPort");
		
		Service service = Service.create(serviceName);
		
		service.addPort(portName, SOAPBinding.SOAP12HTTP_MTOM_BINDING , "http://localhost:8180/jaxws-local/LongProcessService?wsdl");
		service.setHandlerResolver(new HandlerResolver() {
			@Override
			public List getHandlerChain(PortInfo arg0) {
				return Arrays.asList(new LogPayloadLogicalHandler(), new SecuredMessageHandler());
			}
		});
		
		JAXBContext jaxbContext = JAXBContext.newInstance(File.class);
		
		Dispatch<Object> dispatch = service
				.createDispatch(portName, jaxbContext, Mode.PAYLOAD, new MTOMFeature(true, 5000));
		
		File file = new File();
		file.setName("pdf-file");
		file.setContent(IOUtils.toByteArray(DispatchClientJAXBContext.class.getClassLoader().getResourceAsStream("elk.jpg")));
		
		Object soapResponse = dispatch.invoke(file);
		
		log.info("Response : " + soapResponse);
		
	}

}
