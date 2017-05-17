package com.example.web.ws.provider;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

import javax.annotation.Resource;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPHeaderElement;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.Provider;
import javax.xml.ws.Service.Mode;
import javax.xml.ws.ServiceMode;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceProvider;
import javax.xml.ws.handler.MessageContext;

import org.apache.commons.io.IOUtils;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

@WebServiceProvider(serviceName = "UsersService", portName = "UsersServicePort", targetNamespace = "http://users.ws.web.example.com")
@ServiceMode(Mode.MESSAGE)
@Stateless
@RolesAllowed("wsaccess-users")
public class UsersSOAPMessageProvider implements Provider<SOAPMessage> {

	@Resource
	WebServiceContext webServiceContext;

	@Override
	public SOAPMessage invoke(SOAPMessage request) {
		
		WsUtils.logSOAPMessage(request);
		
		MessageContext messageContext = webServiceContext.getMessageContext();
		
		//add HTTP Header
		HttpServletResponse servletResponse = (HttpServletResponse) messageContext.get(MessageContext.SERVLET_RESPONSE);
		servletResponse.addHeader("Environment", "test-3");
		
		//Get Servlet Context to load XML
		ServletContext servletContext = (ServletContext) messageContext.get(MessageContext.SERVLET_CONTEXT);
		SOAPMessage messageReturn = null;
		try {
			
			// Load xml
			InputStream is = servletContext.getResourceAsStream("/WEB-INF/mock/customers.xml");
			if(is == null){
				String strPayload = "<data>no data available</data>";
				is = IOUtils.toInputStream(strPayload,Charset.defaultCharset());
			}
			
			MessageFactory messageFactory = MessageFactory.newInstance();
			messageReturn = messageFactory.createMessage();
			
			messageReturn.getSOAPPart().addMimeHeader("Content", "Found");
			messageReturn.getSOAPPart().createComment("Data for testing");
			
			// create header element for testing
			SOAPHeader soapHeaders = messageReturn.getSOAPHeader();
			SOAPHeaderElement headerElement = soapHeaders.addHeaderElement(new QName("http://headers.ns.example.com","version","msv"));
//			headerElement.setValue("v10.0");
			headerElement.addTextNode("v10.3.4");
			
			// create body content From : String-xml -> Document -> Add document as SOAP Body
			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = docBuilderFactory.newDocumentBuilder();
			Document response = documentBuilder.parse(is);
			
			SOAPBody soapBody = messageReturn.getSOAPBody();
			soapBody.addDocument(response);
			
		} catch (SOAPException | DOMException | IOException | SAXException | ParserConfigurationException e) {
			throw new WebServiceException(e);
		}
		
		return messageReturn;
	}

}
