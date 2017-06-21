package com.example.designpatterns.decorator.beverage.add;

import com.example.designpatterns.decorator.beverage.Beverage;

public class Cereal extends Additional {

	public Cereal(Beverage beverage) {
		super(beverage);
	}

	@Override
	public String getDescription() {
		return beverage.getDescription() + " Cereal Added. ";
	}
	
	@Override
	public double cost() {
		return beverage.cost() + 1.99;
	}

}
