package com.example.web.ws.provider;

import java.io.InputStream;
import java.io.StringWriter;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.BindingType;
import javax.xml.ws.Provider;
import javax.xml.ws.Service.Mode;
import javax.xml.ws.ServiceMode;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.WebServiceProvider;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.http.HTTPBinding;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@WebServiceProvider(serviceName="CompaniesService",
	portName="CompaniesServicePort",targetNamespace="http://companies.ws.web.example.com"
)
@ServiceMode(Mode.PAYLOAD)
@BindingType(HTTPBinding.HTTP_BINDING)
public class CompaniesPayloadProvider implements Provider<Source>{
	
	public static Logger logger = LogManager.getLogger(CompaniesPayloadProvider.class);

	@Resource
	WebServiceContext webServiceContext;
	
	@Override
	public Source invoke(Source request) {
		
		MessageContext messageContext = webServiceContext.getMessageContext();
		
		ServletContext servletContext = (ServletContext) messageContext.get(MessageContext.SERVLET_CONTEXT);
		
		try {
			// transform Source payload to String, then log it
			StringWriter stringWriter = new StringWriter();
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.transform(request, new StreamResult(stringWriter));
			logger.info("Message Payload received: ");
			logger.info(stringWriter);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// return XML file to String and build a StreamSource
		InputStream is = servletContext.getResourceAsStream("mock/companies.xml");
		return new StreamSource(is);
	}

}
