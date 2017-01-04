package com.example.designpatterns.strategy.core.fly;

public class FlyWithWings implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("duck flies freely");
    }

    
}
