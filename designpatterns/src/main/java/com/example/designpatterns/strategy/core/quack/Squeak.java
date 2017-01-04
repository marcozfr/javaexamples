package com.example.designpatterns.strategy.core.quack;

public class Squeak implements QuackBehavior {

    @Override
    public void quack() {
        System.out.println("rubber duck squacks");
    }
}
