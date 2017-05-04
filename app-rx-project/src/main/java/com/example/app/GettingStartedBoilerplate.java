package com.example.app;

import rx.Observable;
import rx.Subscriber;

public class GettingStartedBoilerplate {
	
	public static void main(String[] args) {

		@SuppressWarnings("deprecation")
		Observable<String> namesObserver = Observable.create(new Observable.OnSubscribe<String>() {
			@Override
			public void call(Subscriber<? super String> arg0) {
				arg0.onNext("on call, do this");
				arg0.onCompleted();
			}
		});
		
		Subscriber<String> subs1 = new Subscriber<String>(){
			
			@Override
			public void onNext(String t) {
				System.out.println("Hey -> " +t);
			}
			
			@Override
			public void onCompleted() {
				System.out.println("Completed");
			}
			
			@Override
			public void onError(Throwable e) {
				// TODO Auto-generated method stub
				
			}
		};
		
		namesObserver.subscribe(subs1);
		
	}

}
