package com.example.model;

public class Beer {

	private Style style;
	private String name;
	private Integer id;

	public Beer(Integer id, String name, Style style){
		this.id = id;
		this.name = name;
		this.style = style;
	}

	public Style getStyle(){
		return style;
	}

	public void setStyle(Style style){
		this.style = style;
	}
	
	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

	public Integer getId(){
		return id;
	}

	public void setId(Integer id){
		this.id = id;
	}
}