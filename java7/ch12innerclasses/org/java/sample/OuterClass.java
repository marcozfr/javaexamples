<<<<<<< HEAD
package org.java.sample;

public class OuterClass {
    
    public static void main (String args[]){
        OutClass out = new InClass();
        System.out.println(out.myint);
        out.back();
        out.abs();
        
        OutClass.InnerClass in = out.new InnerClass();
        in.ars();
    }

}

abstract class OutClass {
    public int myint = 5;
    
    public class InnerClass {
        
        public int myint = 8;
        
        public void ars(){
            System.out.println("ars " +myint);
        }
    }
    
    static public class InnerStaticClass{
        
    }
    
    public void go(){
        System.out.println("goout");
    }
    
    public void back(){
        System.out.println("backout");
    }
    
    public abstract void abs();
    
}


class InClass extends OutClass {
    
    public int myint = 4;
    
    public void abs(){
        System.out.println("absin");
    }
    
    public void then(){
        System.out.println("thenin");
    }
=======
package org.java.sample;

public class OuterClass {
    
    public static void main (String args[]){
        OutClass out = new InClass();
        System.out.println(out.myint);
        out.back();
        out.abs();
        
        OutClass.InnerClass in = out.new InnerClass();
        in.ars();
    }

}

abstract class OutClass {
    public int myint = 5;
    
    public class InnerClass {
        
        public int myint = 8;
        
        public void ars(){
            System.out.println("ars " +myint);
        }
    }
    
    static public class InnerStaticClass{
        
    }
    
    public void go(){
        System.out.println("goout");
    }
    
    public void back(){
        System.out.println("backout");
    }
    
    public abstract void abs();
    
}


class InClass extends OutClass {
    
    public int myint = 4;
    
    public void abs(){
        System.out.println("absin");
    }
    
    public void then(){
        System.out.println("thenin");
    }
>>>>>>> origin/master
}