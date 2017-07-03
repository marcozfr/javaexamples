package com.example.ws.http.client;

import java.util.Collections;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.soap.AttachmentPart;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPElement;
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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.ws.client.handler.LogMessageHandler;
import com.example.ws.client.handler.SecuredMessageHandler;
import com.example.ws.domain.util.WsUtils;

public class DispatchClientAttachment extends PipeDumpDispatch {
	
	private static Logger log = LoggerFactory.getLogger(DispatchClientAttachment.class);
	
	public static void main(String[] args) throws SOAPException {
		QName serviceName = new QName("http://process.ws.example.com","LongProcessService");
		QName portName = new QName("http://process.ws.example.com","LongProcessPort");
		
		Service service = Service.create(serviceName);
		
		service.addPort(portName, SOAPBinding.SOAP12HTTP_BINDING , "http://localhost:8180/jaxws-local/LongProcessService?wsdl");
		service.setHandlerResolver(new HandlerResolver() {
			@Override
			public List getHandlerChain(PortInfo arg0) {
				return Collections.singletonList(new SecuredMessageHandler());
			}
		});
		
		Dispatch<SOAPMessage> dispatch = service
				.createDispatch(portName, SOAPMessage.class, Mode.MESSAGE, new MTOMFeature(true, 5000));
		
//		((BindingProvider)dispatch).getRequestContext().put(BindingProvider.USERNAME_PROPERTY, "admin");
//		((BindingProvider)dispatch).getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, "c90100a");
		
		
		MessageFactory mf = MessageFactory.newInstance(SOAPConstants.SOAP_1_2_PROTOCOL);
		SOAPMessage soapMessage = mf.createMessage();
		
		AttachmentPart attachment = soapMessage.createAttachmentPart();
//		attachment.setContentType("application/pdf");
		attachment.setBase64Content(DispatchClientAttachment.class.getClassLoader().getResourceAsStream("elk.jpg"), "image/jpeg");
		attachment.setContentId("elk-local-1.jpg");
		
		soapMessage.addAttachmentPart(attachment);
		
		SOAPElement soapElement = soapMessage.getSOAPBody().addChildElement(new QName("http://process.ws.example.com", "runUpload", "proc"));
		soapElement.addChildElement("name").setTextContent("elk-local-1.jpg");
		soapElement.addChildElement("content").addTextNode("cid:" + attachment.getContentId());
		
		SOAPMessage soapResponse = dispatch.invoke(soapMessage);
		
	}

}
