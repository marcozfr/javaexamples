package org.java.sample;

import java.util.Locale;
import java.util.ResourceBundle;
    
public class Bundles {
    
    public static void main (String ...args){
        System.out.println("default locale : " + Locale.getDefault());
        Locale.setDefault(new Locale("es","PE"));
        System.out.println("new default locale : " + Locale.getDefault());
        Locale locale = new Locale(args[0],args[1]);
        //Locale locale = new Locale(args[0]);
        ResourceBundle rb = ResourceBundle.getBundle("Labels",locale);
        System.out.println(rb.getObject(12)); // can use getString as well
    }
    
}