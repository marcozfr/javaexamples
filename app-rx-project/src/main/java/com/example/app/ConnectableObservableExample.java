package com.example.app;

import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;

import java.util.UUID;

/*
Hot Observable
Allows to replay the same emissions to multiple subscribers
 */
public class ConnectableObservableExample {

    public static class Entity {
        private String id;
        public Entity (String id){
            this.id = id;
        }

        @Override
        public String toString() {
            return "Entity{" +
                    "id='" + id + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        ConnectableObservable<Entity> obs = Observable.<Entity>create(emitter -> {
            emitter.onNext(new Entity(UUID.randomUUID().toString()));
            emitter.onNext(new Entity(UUID.randomUUID().toString()));
            emitter.onComplete();
        }).publish();

        obs.subscribe(c -> {
            System.out.println(c);
        });

        obs.subscribe(c -> {
            System.out.println(c);
        });

        obs.connect();
        
    }
}
