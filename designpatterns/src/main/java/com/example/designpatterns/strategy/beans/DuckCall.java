package com.example.designpatterns.strategy.beans;

import com.example.designpatterns.strategy.core.Duck;
import com.example.designpatterns.strategy.core.fly.FlyNotImplemented;
import com.example.designpatterns.strategy.core.quack.MuteQuack;

public class DuckCall {
    
    private Duck duck;
    
    public DuckCall() {
        duck = new Duck() {
            
            @Override
            public void display() {
                  System.out.println("display duck call");
            }
        };
        
        duck.setFlyBehavior(new FlyNotImplemented());
        duck.setQuackBehavior(new MuteQuack());
    }
    
    public void mimicQuack(){
        duck.performQuack();
    }

}
