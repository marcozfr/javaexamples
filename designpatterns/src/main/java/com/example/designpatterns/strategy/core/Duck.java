package com.example.designpatterns.strategy.core;

import com.example.designpatterns.strategy.core.fly.FlyBehavior;
import com.example.designpatterns.strategy.core.quack.QuackBehavior;

public abstract class Duck {

    private FlyBehavior flyBehavior;
    private QuackBehavior quackBehavior;
    
    public void swim(){
        System.out.println("duck swims, they all do it.");
    };
    
    public abstract void display();
    
    public void performQuack(){
       quackBehavior.quack(); 
    };
    
    public void performFly(){
        flyBehavior.fly();
    };

    public FlyBehavior getFlyBehavior() {
        return flyBehavior;
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public QuackBehavior getQuackBehavior() {
        return quackBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }
    
    
    
    
}
