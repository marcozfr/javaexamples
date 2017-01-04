package com.example.designpatterns.strategy.beans;

/**
 * @author MarcoAntonio
 *
 */
public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        MallardDuck mallard = new MallardDuck();
        mallard.display();
        mallard.performQuack();
        mallard.performFly(); 
    }
}
