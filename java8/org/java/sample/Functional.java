package org.java.sample;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;
import java.math.*;

public class Functional{
    
    public static void main(String args[]){
        Map<Integer, String> myMap = new HashMap<>();
        myMap.put(3,"asd"); myMap.put(11,null);
        myMap.put(21,"9012"); myMap.put(1,null);
        
        myMap.computeIfPresent(12,(k,v) -> null);
        
        myMap.merge(1,"merged",(v1,v2) -> null);
        
        System.out.println(myMap);
        
        
        Object a = DoubleStream.generate(Math::random).parallel().mapToObj(x -> new BigDecimal(x).setScale(4,BigDecimal.ROUND_DOWN)).limit(5).collect(ArrayList::new,ArrayList::add,ArrayList::addAll);
        
        System.out.println(a);
        
        
    }
    
}

class StringManager {
    
    public static String defaultStringGen(Integer a){
        if(a > 5){
            return "Cinco+";
        }else if(a > 0){
            return "Cero+";
        }
        return "Valor";
    }
    
}
