package org.java.sample;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class PreparedManager {

    public static void main (String ...args) throws Exception{
        try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila?useSSL=false", "root","root");){
            
            PreparedStatement ps = conn.prepareStatement("select category_id, name from category where category_id > ? limit 5");
            ps.setInt(1,Integer.valueOf(args[0]));
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            for(int i = 0 ; i < rsmd.getColumnCount() ; i ++){
                System.out.printf("%1$-15s",rsmd.getColumnName(i+1));
            }
            System.out.println();
            rs.afterLast();
            while(rs.previous()){
                System.out.printf("%1$-,15d %2$-15s",rs.getInt("category_id"),rs.getString("name"));
                System.out.println();
            }
            
            System.out.println();
            System.out.println("Calling procedure with out parameter");
            CallableStatement cs = conn.prepareCall("{call film_in_stock(?,?,?)}");
            cs.setInt(1,1);
            cs.setInt(2,2);
            cs.registerOutParameter(3,java.sql.Types.INTEGER);
            
            cs.execute(); // when you got a out parameter, execute should be called
            Integer stock = cs.getInt(3);
            System.out.println("Result :" + stock);
            
                
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        
    }
}