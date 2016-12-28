package com.example.designpatterns.observer.weather;

public class CurrentConditionsDisplay implements DisplayElement, Observer {

	Measurements measurements;

	@Override
	public void display() {
		System.out.println(measurements);
	}

	@Override
	public void update(Measurements measurements) {
		this.measurements = measurements;
		display();
	}

}
