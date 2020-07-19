package com.example.twitterapp;

import com.example.twitterapp.core.TwitterFlowableOnSubscribe;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import twitter4j.Status;

public class TwitterStreamReactiveSample {
	
	public static void main(String[] args) {

		TwitterFlowableOnSubscribe twitterFlowableOnSubscribe = new TwitterFlowableOnSubscribe();
		twitterFlowableOnSubscribe.setTwitterQuery("peru");
		Flowable<Status> flow = Flowable
				.create(twitterFlowableOnSubscribe, BackpressureStrategy.BUFFER);
		
		flow.filter(s -> s.getText().length() < 150)
			.subscribe(s -> {
				System.out.println("Received status : ");
				System.out.println(s.getText());
			});
		
		
	}

}
