package com.example.designpatterns.observer.weather;

import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Subject {

	private List<Observer> observers = new ArrayList<Observer>();
	private Measurements measurements = new Measurements();
	private boolean changed;
	
	public void setMeasurements(float humidity, float pressure, float temperature){
		measurements.setHumidity(humidity);
		measurements.setPressure(pressure);
		measurements.setTemperature(temperature);
		
		measurementsChanged();
	}
	
	public void measurementsChanged(){
		setChanged();
		notifyObservers();
	}
	
	public void notifyObservers() {
		if(changed){
			for (Observer observer : observers) {
				observer.update(measurements);
			}
		}
		changed = false;
	}

	public void registerObserver(Observer o) {
		if(!observers.contains(o)){
			observers.add(o);
		}
	}

	public void removeObserver(Observer o) {
		observers.remove(o);
	}

	@Override
	public void setChanged() {
		this.changed = true;
	}

}
