package com.example.designpatterns.strategy.core.quack;

public class Quack implements QuackBehavior {

    @Override
    public void quack() {
        System.out.println("duck quaks");        
    }
    
}
