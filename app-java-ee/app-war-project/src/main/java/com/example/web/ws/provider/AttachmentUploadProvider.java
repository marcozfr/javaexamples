package com.example.web.ws.provider;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.activation.DataHandler;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.xml.namespace.QName;
import javax.xml.soap.AttachmentPart;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeader;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.Provider;
import javax.xml.ws.Service.Mode;
import javax.xml.ws.ServiceMode;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceProvider;

import org.apache.commons.io.IOUtils;

import com.example.model.demo.Attachment;

@WebServiceProvider(serviceName="AttachmentUpload",
	portName="AttachmentUploadPort",targetNamespace="http://attachment.ws.web.example.com")
@ServiceMode(Mode.MESSAGE)
@Stateless(name="AttachmentUpload")
public class AttachmentUploadProvider implements Provider<SOAPMessage>{

	@PersistenceContext(unitName="catalogPU")
    private EntityManager entityManager;
	
	@Override
	public SOAPMessage invoke(SOAPMessage request) {
		
		WsUtils.logSOAPMessage(request);
		
		SOAPMessage messageReturn = null;
		try {
			
			int count =request.countAttachments();
			String save = null;
			Iterator invokes = request.getSOAPBody().getChildElements(new QName("http://provider.ws.web.example.com/","action"));
			if(invokes.hasNext()){
				SOAPBodyElement invoke = (SOAPBodyElement)invokes.next();
				save = invoke.getTextContent();
			}
			if("save".equals(save) && count >0){
				Iterator attachmentIterator = request.getAttachments();
				while(attachmentIterator.hasNext()){
					AttachmentPart attachmentPart = (AttachmentPart)attachmentIterator.next();
					DataHandler dataHandler = attachmentPart.getDataHandler();
					byte [] data = IOUtils.toByteArray(dataHandler.getInputStream());
					
					Map<String,String> headerMap = new HashMap<>();
					String filename = null;
					Iterator mimeHeaders = attachmentPart.getAllMimeHeaders();
					while(mimeHeaders.hasNext()){
						MimeHeader mimeHeader = (MimeHeader) mimeHeaders.next();
						headerMap.put(mimeHeader.getName(),mimeHeader.getValue());
						if("Content-ID".equals(mimeHeader.getName())){
							filename = mimeHeader.getValue().replaceAll("<|>", "");
						}
					}
					
					Attachment attachment = new Attachment();
					attachment.setHeaders(headerMap);
					attachment.setData(data);
					attachment.setName(filename);
					entityManager.persist(attachment);
					
				}
			}
		
			
		
			MessageFactory messageFactory = MessageFactory.newInstance();
			messageReturn = messageFactory.createMessage();
			
			messageReturn.getSOAPBody().setTextContent("Ok");
			
		} catch (SOAPException | IOException e) {
			throw new WebServiceException(e);
		}
		
		return messageReturn;
		
	}

}
