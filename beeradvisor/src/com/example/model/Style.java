package com.example.model;

import java.util.*;

public class Style {

	private int id;
	private String name;
	private List<Beer> beers;

	public Style(){
	}

	public Style(int id, String name, List<Beer> beers){
		this.id = id;
		this.name = name;
		this.beers = beers;
	}
	
	public List<Beer> getBeers(){
		return beers;
	}

	public void setBeers(List<Beer> beers){
		this.beers = beers;
	}
	
	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

	public int getId(){
		return id;
	}

	public void setId(int id){
		this.id = id;
	}

}