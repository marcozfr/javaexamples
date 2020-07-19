package com.example.app;

import java.util.Arrays;

import io.reactivex.Observable;

public class GettingStartedLight {
	
	public static void main(String[] args) {
		Observable.just("Hi","Test","LP", "G").subscribe(a -> System.out.println(a));

		Observable
			.just("Hi", "this" , "introduces", "transformations")
			.map(a -> a + "(" + a.length()+ ")")
			.subscribe(System.out::println);
		
		Observable.fromArray(Arrays.asList(args)).subscribe(System.out::println);
	}

}
