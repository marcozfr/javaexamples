package com.example.designpatterns.observer.weather;

public class WeatherStation {
	
	public static void main(String[] args) {
		WeatherData weatherData = new WeatherData();
		
		CurrentConditionsDisplay display1 = new CurrentConditionsDisplay();
		weatherData.registerObserver(display1);
		
		weatherData.setMeasurements(80.0f, 32, 31.f);
		
		weatherData.setMeasurements(81.0f, 23, 31.f);
	}

}
