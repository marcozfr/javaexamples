package com.example.model.demo;

import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.MapKeyColumn;

@Entity
public class Attachment {
	
	@Id
	@GeneratedValue
	private Long attachmentId;
	private String name;
	
	@Lob
	private byte[] data; 
	
	@ElementCollection
    @MapKeyColumn(name="header_key")
    @Column(name="header_value")
    @CollectionTable(name="attachment_header")
    Map<String, String> headers; 


	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public Long getAttachmentId() {
		return attachmentId;
	}

	public void setAttachmentId(Long attachmentId) {
		this.attachmentId = attachmentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<String, String> getHeaders() {
		return headers;
	}

	public void setHeaders(Map<String, String> headers) {
		this.headers = headers;
	}
	
}
