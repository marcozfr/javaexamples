package org.java.sample;

public class Testing {
    public static void main (String ...args) throws AA{
        try {
            throw new AA();
        }catch(A e){
            e  = new A();
            throw e;
        }
    }
    
}

class A extends Exception {
    
}

class AA extends A {
    
}


class B extends Exception {
    
}