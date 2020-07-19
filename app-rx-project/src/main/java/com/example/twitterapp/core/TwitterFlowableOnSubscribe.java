package com.example.twitterapp.core;

import io.reactivex.*;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Cancellable;
import twitter4j.*;
import twitter4j.conf.Configuration;

import java.util.Optional;

public class TwitterFlowableOnSubscribe implements FlowableOnSubscribe<Status> {

	private TwitterStream twitterStream;
	private FilterQuery twitterQuery;

	public TwitterFlowableOnSubscribe(){
		twitterStream = new TwitterStreamFactory().getInstance();
	}

	public void setTwitterQuery(String track) {
		FilterQuery filterQuery = new FilterQuery();
		filterQuery.language("es");
		filterQuery.track(track);
		this.twitterQuery = filterQuery;
	}

	@Override
	public void subscribe(@NonNull FlowableEmitter<Status> emitter) throws Exception {

		emitter.setCancellable(() -> {
			if(twitterStream!=null){
				twitterStream.cleanUp();
				twitterStream.shutdown();
			}
		});

		twitterStream.addListener(new StatusAdapter(){
			@Override
			public void onStatus(Status status) {
				emitter.onNext(status);
			}
		});

		twitterStream.filter(twitterQuery);

	}

}
