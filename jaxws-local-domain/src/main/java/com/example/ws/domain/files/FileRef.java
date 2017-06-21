package com.example.ws.domain.files;

import javax.activation.DataHandler;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttachmentRef;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class FileRef {
	
	private String name;
	
	@XmlAttachmentRef
	private DataHandler content;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public DataHandler getContent() {
		return content;
	}

	public void setContent(DataHandler content) {
		this.content = content;
	}

	
	

}
