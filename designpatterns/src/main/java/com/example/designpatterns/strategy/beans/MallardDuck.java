package com.example.designpatterns.strategy.beans;

import com.example.designpatterns.strategy.core.Duck;
import com.example.designpatterns.strategy.core.fly.FlyWithWings;
import com.example.designpatterns.strategy.core.quack.Quack;

public class MallardDuck extends Duck {

    public MallardDuck() {
        setFlyBehavior(new FlyWithWings());
        setQuackBehavior(new Quack());
    }
    
    @Override
    public void display() {
        System.out.println("display mallard duck");
    }
    
}
