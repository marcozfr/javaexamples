package com.example.designpatterns.decorator.beverage.add;

import com.example.designpatterns.decorator.beverage.Beverage;

public class Cream extends Additional {

	public Cream(Beverage beverage) {
		super(beverage);
	}

	@Override
	public String getDescription() {
		return beverage.getDescription() + " Cream Added. ";
	}
	
	@Override
	public double cost() {
		return beverage.cost() + 0.99;
	}

}
