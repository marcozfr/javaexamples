package com.example.designpatterns.decorator.beverage;

public abstract class Beverage {
	
	public String getDescription(){
		return "Beverage: ";
	};
	
	public abstract double cost();

}
