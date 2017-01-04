package com.example.designpatterns.strategy.core.fly;

public class FlyNotImplemented implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("Not Implemented fly");
    }
    
}
