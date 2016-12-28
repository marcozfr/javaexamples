package com.example.designpatterns.observer.builtin;

import java.util.Observable;
import java.util.Observer;

public class LatamSubscriber implements Observer {

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("Latam received: " + arg);
	}

}
