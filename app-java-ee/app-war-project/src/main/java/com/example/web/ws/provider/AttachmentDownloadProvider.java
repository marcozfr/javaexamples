package com.example.web.ws.provider;

import java.io.ByteArrayInputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.xml.namespace.QName;
import javax.xml.soap.AttachmentPart;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.Provider;
import javax.xml.ws.Service.Mode;
import javax.xml.ws.ServiceMode;
import javax.xml.ws.WebServiceProvider;

import org.apache.commons.io.IOUtils;

import com.example.model.demo.Attachment;

@WebServiceProvider(serviceName="AttachmentDownload",
	portName="AttachmentDownloadPort",targetNamespace="http://download.ws.web.example.com")
@ServiceMode(Mode.MESSAGE)
@Stateless(name="AttachmentDownload")
public class AttachmentDownloadProvider implements Provider<SOAPMessage>{

	@PersistenceContext(unitName="catalogPU")
    private EntityManager entityManager;
	
	@Override
	public SOAPMessage invoke(SOAPMessage request) {
		SOAPMessage messageReturn =null;
		try {
			String name = null;
			Iterator idElement = request.getSOAPBody().getChildElements(new QName("name"));
			if(idElement.hasNext()){
				 SOAPBodyElement idEl = (SOAPBodyElement)idElement.next();
				 name = idEl.getTextContent();
			}
			
			TypedQuery<Attachment> q = entityManager.createQuery("select a from Attachment a where a.name like :nameParam ", Attachment.class);
			q.setParameter("nameParam", name + "%");
			
			List<Attachment> attachments = q.getResultList();
			
			MessageFactory messageFactory = MessageFactory.newInstance();
			messageReturn = messageFactory.createMessage();
			
			for(Attachment attachment: attachments){
				AttachmentPart part = messageReturn.createAttachmentPart();
				for(Entry<String,String> entry : attachment.getHeaders().entrySet()){
					part.addMimeHeader(entry.getKey(), entry.getValue());
				}
				part.setContentId(attachment.getName());
				ByteArrayInputStream bais = new ByteArrayInputStream(attachment.getData());
				part.setRawContent(bais, "application/octet-stream");
				IOUtils.closeQuietly(bais);
				messageReturn.addAttachmentPart(part);
			}
			
		} catch (SOAPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return messageReturn;
	}
	
}
