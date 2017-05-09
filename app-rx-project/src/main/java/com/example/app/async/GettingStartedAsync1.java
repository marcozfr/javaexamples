package com.example.app.async;

import rx.Emitter;
import rx.Emitter.BackpressureMode;
import rx.Observable;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class GettingStartedAsync1 {
	
	public static void main(String[] args) throws InterruptedException {
		
		Observable.create(new Action1<Emitter<String>>() {
			@Override
			public void call(Emitter<String> t) {
				t.onNext("to-sub");
			}
		}, BackpressureMode.NONE).subscribeOn(Schedulers.io()).observeOn(Schedulers.newThread()).subscribe(System.out::println);	
		Thread.sleep(2000l);
	}

}
