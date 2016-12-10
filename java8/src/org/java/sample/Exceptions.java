package org.java.sample;

public class Exceptions{
    
    public static void main (String args[]){
        
        try{
            hang();
        }catch(Exception e){
            System.out.println("Exceptions ");
        }
        
    }
    
    public static void hang() throws MyException{
        try{
            throw new Exception ("exp");
        }catch(Exception e){
            System.out.println("captured exp ");
            throw new MyException();
        }finally{
            System.out.println("do finally");
        }
    }
    
}

class MyException extends Exception {
    
}