package com.example.app;

import com.example.app.helper.CreateObservable;

import rx.observables.ConnectableObservable;

public class ReactiveSum {
	
	public static void main(String[] args) {
		
		ConnectableObservable<String> input = CreateObservable.from(System.in);
	}

}
