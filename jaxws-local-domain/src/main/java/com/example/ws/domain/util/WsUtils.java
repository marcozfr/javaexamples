package com.example.ws.domain.util;

import java.io.StringWriter;
import java.util.Iterator;

import javax.xml.soap.AttachmentPart;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;

import org.slf4j.Logger;

public class WsUtils {

	public static void logSOAPMessage(Logger logger, SOAPMessage request) {
		try {
			logger.info("SOAP Message: \n" +fromSource(request.getSOAPPart().getContent()));
			int countAttachments = request.countAttachments();
			if(countAttachments!=0){
				logger.info("SOAP Message Attachments: \n");
				Iterator iterator = request.getAttachments();
				while(iterator.hasNext()){
					AttachmentPart attachment = (AttachmentPart) iterator.next();
					logger.info("Attachment id : "+attachment.getContentId());
					logger.info("Attachment location : "+attachment.getContentLocation());
					logger.info("Attachment cType : "+attachment.getContentType());
					logger.info("Attachment size : "+attachment.getSize());
				}
			}
		} catch (TransformerException | SOAPException e) {
			e.printStackTrace();
		}
	}

	public static String fromSource(Source source) throws TransformerException {
		TransformerFactory tFactory = TransformerFactory.newInstance();

		Transformer transformer = tFactory.newTransformer();
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
		transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount","2");

		StreamResult streamResult = new StreamResult(new StringWriter());
		transformer.transform(source, streamResult);
		
		return streamResult.getWriter().toString();
	}

}
