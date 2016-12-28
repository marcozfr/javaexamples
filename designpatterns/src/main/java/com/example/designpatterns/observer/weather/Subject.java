package com.example.designpatterns.observer.weather;

public interface Subject {
	
	public void registerObserver(Observer o);
	
	public void removeObserver(Observer o);
	
	public void notifyObservers();
	
	public void setChanged();
	
}
