package org.java.sample;

import java.sql.*;

public class Testing {
    
    public static void main (String a[]){
        
        try{
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila?useSSL=false","root","myqsl");
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("select * from category order by name limit 5");
            while(rs.next()){
                System.out.printf ("$1%\t$2%\t$3%",rs.getInt(1),rs.getString("name"),rs.getDate(3));
                System.out.println();
            }    
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
    }
    
}