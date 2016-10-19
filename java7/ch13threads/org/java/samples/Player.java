<<<<<<< HEAD
 package org.java.samples;

public class Player implements Runnable {
    
    private Integer span; 
    private Integer balance = 80;
    
    public Player(Integer span){
        this.span = span;
    }
    
    public Integer getBalance(){
        return balance;
    }
    
    public void withdraw(Integer amount){
        if(balance >= amount){  
            try{
                Thread.sleep(1200);
            }catch (Exception e){e.printStackTrace();}
            balance = balance - amount;
            System.out.println("witdrawn amount: "+ amount + " for "+ Thread.currentThread().getName()); 
        }else{
            System.out.println("not enough money for "+ Thread.currentThread().getName()); 
        }
        
    }
    
    public void run () {
       for(int i = 0 ; i < span ; i ++){
            withdraw(10);
            if(balance < 0){
                System.out.println("account is overdrawn: "+ balance); 
            }
        } 
    }
    
=======
 package org.java.samples;

public class Player implements Runnable {
    
    private Integer span; 
    private Integer balance = 80;
    
    public Player(Integer span){
        this.span = span;
    }
    
    public Integer getBalance(){
        return balance;
    }
    
    public void withdraw(Integer amount){
        if(balance >= amount){  
            try{
                Thread.sleep(1200);
            }catch (Exception e){e.printStackTrace();}
            balance = balance - amount;
            System.out.println("witdrawn amount: "+ amount + " for "+ Thread.currentThread().getName()); 
        }else{
            System.out.println("not enough money for "+ Thread.currentThread().getName()); 
        }
        
    }
    
    public void run () {
       for(int i = 0 ; i < span ; i ++){
            withdraw(10);
            if(balance < 0){
                System.out.println("account is overdrawn: "+ balance); 
            }
        } 
    }
    
>>>>>>> origin/master
}