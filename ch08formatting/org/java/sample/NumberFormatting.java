package org.java.sample;

import java.text.*;
import java.util.*;

public class NumberFormatting {
    
    public static void main(String args[]) throws ParseException {
        Double d = Double.valueOf(args[0]);
        Locale l = new Locale(args[1],args[2]);
        System.out.println(l.getDisplayLanguage());
        NumberFormat nf = NumberFormat.getCurrencyInstance(l);
        NumberFormat nfnumber = NumberFormat.getNumberInstance(l);
        nf.setMaximumFractionDigits(6);
        String s = nf.format(d);
        System.out.println(s);
        
        String s1 = nfnumber.format(d);
        System.out.println(s1);
        
        nf.setParseIntegerOnly(true);
        Number dparse = nf.parse(s);
        System.out.println(dparse);
        
    }
    
}