package com.example.model;

import java.util.*;
import java.util.stream.*;

public class BeerRepository {

	private static BeerRepository beerRepository;
	private List<Style> styles = new ArrayList<>();
	private List<Beer> beers = new ArrayList<>();

	public static synchronized BeerRepository getInstance(){
		if(beerRepository==null){
			beerRepository = new BeerRepository();	
		}
		return beerRepository;
	}

	public BeerRepository(){
		Style ale = new Style(1,"ale",new ArrayList<>()); 
		Style lager = new Style(2,"lager",new ArrayList<>());
		Style red = new Style(3,"red",new ArrayList<>());
		Style black = new Style(4,"black",new ArrayList<>());

		Beer ranger = new Beer(1,"ranger",ale);
		Beer budlight = new Beer(2,"budlight",lager);
		Beer budweiser = new Beer(4,"budweiser",lager);

		ale.getBeers().add(ranger);

		lager.getBeers().add(budlight);
		lager.getBeers().add(budweiser);

		styles.add(ale);
		styles.add(lager);
		styles.add(red);
		styles.add(black);
		
		beers.add(ranger);
		beers.add(budlight);
		beers.add(budweiser);
	}

	public void addStyle(int id, String name, List<Beer> beers){
		addStyle(new Style(id,name,beers));
	}

	public void addStyle(Style style){
		styles.add(style);
	}

	public List<Style> getStyles(){
		return styles;
	}

	public List<String> getBeers(String style){
		return styles.stream()
				.filter(x -> x.getName().equals(style))
				.flatMap(x -> x.getBeers().stream())
				.map(Beer::getName)
				.collect(Collectors.toList());
	}

	public List<Beer> getBeers(){
		return beers;
	}

	public Style getStyle(String name){
		return getStyles().stream()
			.filter(x -> x.getName().compareTo(name) == 0)
			.findFirst().orElseThrow(()-> new RuntimeException("Style not found"));
	}

	public Integer getNextBeerId(){
		return getBeers().stream().map(Beer::getId).collect(Collectors.maxBy((a,b) -> a-b)).orElse(1);
	}

	public void addBeer(String styleName, String beerName){
		addBeer(new Beer(getNextBeerId(),beerName,getStyle(styleName)));
	}

	public void addBeer(Integer id, String name, Style style){
		addBeer(new Beer(id,name,style));
	}

	public void addBeer(Beer beer){
		beer.getStyle().getBeers().add(beer);
		beers.add(beer);
	}
	
}