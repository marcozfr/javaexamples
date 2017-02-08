package com.example.designpatterns.observer.weather;

public class CurrentConditionsDisplay implements DisplayElement, Observer {

	Measurements measurements;

	public void display() {
		System.out.println(measurements);
	}

	public void update(Measurements measurements) {
		this.measurements = measurements;
		display();
	}

}
