package com.example.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import rx.Observable;

public class Quickstart {
	
	public static void main(String[] args) throws InterruptedException {
		
		List<String> stringList = Arrays.asList("332","54","56","454");
		
		Observable<String>  observr = Observable.from(stringList);
		
		observr.subscribe( str -> System.out.println(Integer.valueOf(str)), err -> System.err.print(err), () -> System.out.println("Completed!"));
		
		observr.subscribe(str -> System.out.println(" Obs ->  " + str));
		
	}

}
