package com.example.designpatterns.observer.weather;

public class Measurements {
	
	private float humidity;
	private float pressure;
	private float temperature;
	
	public float getHumidity() {
		return humidity;
	}
	public void setHumidity(float humidity) {
		this.humidity = humidity;
	}
	public float getPressure() {
		return pressure;
	}
	public void setPressure(float pressure) {
		this.pressure = pressure;
	}
	public float getTemperature() {
		return temperature;
	}
	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}
	
	@Override
	public String toString() {
		return "Measurements [humidity=" + humidity + ", pressure=" + pressure + ", temperature=" + temperature + "]";
	}

}
