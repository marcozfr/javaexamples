package com.example.twitterapp.core;

import javafx.scene.control.ListView;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import twitter4j.Status;
import twitter4j.TwitterStream;

import java.util.function.Consumer;

public class TwitterStreamSubscriber implements Subscriber<Status> {

    private Subscription subscription;
    private ListView<String> listView;
    private Consumer<Status> action;

    public TwitterStreamSubscriber(Consumer<Status> action){
        this.action = action;
    }

    public void cancelSubscription(){
        subscription.cancel();
    }

    @Override
    public void onSubscribe(Subscription s) {
        this.subscription = s;
        this.subscription.request(1);
    }

    @Override
    public void onNext(Status s) {
        action.accept(s);
        this.subscription.request(1);
    }

    @Override
    public void onError(Throwable t) {
        System.err.println(t);
    }

    @Override
    public void onComplete() {
        System.out.println("Subscription has completed");
    }
}
