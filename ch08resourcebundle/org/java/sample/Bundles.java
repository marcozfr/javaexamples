package org.java.sample;

import java.util.Locale;
import java.util.ResourceBundle;

public class Bundles {
    
    
    public static void main (String args[]){
        Locale locale = new Locale(args[0],args[1]);
        Locale.setDefault(new Locale("ja","JA"));
        System.out.println(Locale.getDefault());
        ResourceBundle rb = ResourceBundle.getBundle("Resources", locale);
        System.out.println(rb.getObject("man"));
    }
}