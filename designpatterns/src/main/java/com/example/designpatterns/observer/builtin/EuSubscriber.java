package com.example.designpatterns.observer.builtin;

import java.util.Observable;
import java.util.Observer;

public class EuSubscriber implements Observer {

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("Eu received: " + arg);
	}

}
