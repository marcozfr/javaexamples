package com.example.designpatterns.decorator.beverage;

public class Expresso extends Beverage {
	
	@Override
	public String getDescription() {
		return "Expresso. ";
	}

	@Override
	public double cost() {
		return 12.99d;
	}

}
