package com.example.app;

import java.util.Arrays;
import java.util.List;

import io.reactivex.Observable;

public class Quickstart {
	
	public static void main(String[] args) throws InterruptedException {
		
		List<String> stringList = Arrays.asList("332","54","56","454");
		
		Observable<String>  observr = Observable.fromArray(stringList.toArray(new String[1]));
		
		observr.subscribe( str -> System.out.println(Integer.valueOf(str)), err -> System.err.print(err), () -> System.out.println("Completed!"));
		
		observr.subscribe(str -> System.out.println(" Obs ->  " + str));

		Observable.create(s -> {
			s.onNext("Hello world");
			s.onComplete();
		}).subscribe(a -> System.out.println(a));
		
	}

}
