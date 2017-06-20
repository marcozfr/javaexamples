package com.example.designpatterns.decorator.beverage;

public class Frappe extends Beverage {
	
	@Override
	public String getDescription() {
		return "Frappe. ";
	}

	@Override
	public double cost() {
		return 9.99;
	}

}
