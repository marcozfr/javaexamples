package com.example.designpatterns.observer.builtin;

import java.util.Observable;

public class Publisher extends Observable {
	
	String info = "";
	
	public void setNewInfo(String s){
		this.info = s;
		setChanged();
		
		notifyObservers(this.info);
	}

}
