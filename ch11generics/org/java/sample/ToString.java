package org.java.sample;

public class ToString {
    public static void main (String args[]){
        Clear c = new Clear();
        Object s = "bring it on";
        System.out.println (c.equals(null));
        
        try{
            Class cl = Class.forName("org.java.sample.Clear");
            System.out.println (cl);
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        
        
    }
}

class Clear {
    
    @Override
    public String toString(){
        return "Clear"+hashCode();
    }
    
    @Override
    public boolean equals(Object o ){
        if(o instanceof Clear && this.toString().equals(o.toString())){
            return true;
        }
        return false;
    }
},