package org.java.sample;

import java.util.*;
import java.text.*;

public class  DateFormatting{
        
        public static void main (String args[] ) throws ParseException{
            System.out.println(Locale.getDefault());
            Calendar c = Calendar.getInstance(new Locale("es"));
            c.add(Calendar.DAY_OF_MONTH,3);
            Date d = c.getTime();
            System.out.println(d);
            System.out.println(d.getTime());
            
            DateFormat df = DateFormat.getDateInstance(DateFormat.FULL,new Locale("es"));
            String dateF = df.format(d);
            System.out.println(df.parse(dateF));
            
            NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("en"));
            //nf.setMaximumFractionDigits(3);
            
            System.out.println(nf.format(23232.3232));
            
            StringBuilder sb = new StringBuilder(8);
            System.out.println("sb: "+sb);
            
        } 
    
}