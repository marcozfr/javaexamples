package com.example.designpatterns.decorator.beverage;

import com.example.designpatterns.decorator.beverage.add.Additional;
import com.example.designpatterns.decorator.beverage.add.Cereal;
import com.example.designpatterns.decorator.beverage.add.Cream;

public class Expender {
	
	public static void main(String[] args) {
		Beverage beverage = new Expresso();
		beverage = new Cereal(beverage);
		beverage = new Cream(beverage);
		beverage = new Additional(beverage) {
			
			@Override
			public String getDescription() {
				return beverage.getDescription() + "Extra Add. ";
			}
			
			@Override
			public double cost() {
				return this.beverage.cost() + 5.99;
			}
		};
		
		System.out.println(beverage.getDescription());
		System.out.println(beverage.cost());
	}

}
