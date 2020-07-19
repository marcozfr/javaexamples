package com.example.twitterapp;

import twitter4j.FilterQuery;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;

public class TwitterStreamSample {
	
	public static void main(String[] args) {
		
		StatusListener statusListener = new StatusListener() {
			
			@Override
			public void onException(Exception ex) {
				System.out.println("onException");
				ex.printStackTrace();
			}
			
			@Override
			public void onTrackLimitationNotice(int numberOfLimitedStatuses) {
				System.out.println("onTrackLimitationNotice");
			}
			
			@Override
			public void onStatus(Status status) {
				System.out.println("Message: " + status.getText());
			}
			
			@Override
			public void onStallWarning(StallWarning warning) {
				System.out.println("Stall Warning");
				System.out.println(warning.getMessage());
			}
			
			@Override
			public void onScrubGeo(long userId, long upToStatusId) {
				System.out.println("onScrubGeo");
			}
			
			@Override
			public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {
				System.out.println("onDeletionNotice");
				
			}
		};
		
		
		TwitterStream twitterStream = TwitterStreamFactory.getSingleton();
		twitterStream.addListener(statusListener);
		
		FilterQuery query = new FilterQuery("sars2" , "peru");
		twitterStream.filter(query);
	}

}
