package com.example.designpatterns.strategy.core.quack;

public class MuteQuack implements QuackBehavior{

    @Override
    public void quack() {
        System.out.println("Not Implemented quack");   
    }
}
