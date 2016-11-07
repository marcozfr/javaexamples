package com.example.ws.model;

public class Item {
	
	private Integer id;
	private String note;
	private String url;
	
	public Item() {
		super();
	}
	
	public Item(Integer id, String note, String url) {
		super();
		this.id = id;
		this.note = note;
		this.url = url;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	

}
