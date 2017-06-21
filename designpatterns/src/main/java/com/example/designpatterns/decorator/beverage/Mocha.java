package com.example.designpatterns.decorator.beverage;

public class Mocha extends Beverage {
	
	@Override
	public String getDescription() {
		return  "Mocha. ";
	}

	@Override
	public double cost() {
		return 10.99;
	}

}
