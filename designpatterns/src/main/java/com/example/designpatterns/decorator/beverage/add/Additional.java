package com.example.designpatterns.decorator.beverage.add;

import com.example.designpatterns.decorator.beverage.Beverage;

public abstract class Additional extends Beverage {

	public Additional(Beverage beverage){
		this.beverage = beverage;
	};
	
	protected Beverage beverage;
	
}
