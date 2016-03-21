package org.java.sample;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.sql.ResultSet;

public class Datas {

    public static void main (String ...args) throws Exception{
        try{
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/world?useSSL=false", "root","root");
        
            DatabaseMetaData dbmd = conn.getMetaData();
            
            ResultSet rs = dbmd.getColumns(null,null,"ci%",null);
            while(rs.next()){
               System.out.printf("%1$-15s %2$-14s %3$-10s %4$-8s",
                                 rs.getString("TABLE_NAME"),rs.getString("COLUMN_NAME"),
                                 rs.getString("TYPE_NAME"),rs.getString("COLUMN_SIZE")); 
                System.out.println();
            }
            
            ResultSet rs1 = dbmd.getProcedures(null,null,"%");
            while(rs1.next()){
               System.out.printf("%1$-15s",
                                 rs.getString("PROCEDURE_NAME")); 
                System.out.println();
            }
            
            System.out.println(dbmd.getSQLStateType());
            System.out.println(dbmd.getDriverName());
            System.out.println(dbmd.getDriverVersion());
            
            Thread.sleep(5000);
            
        }catch(SQLException sqle){
            System.out.println("Error while executing routine");
            System.out.println(sqle.getMessage());
            System.out.println(sqle.getSQLState());
            System.out.println(sqle.getErrorCode());
            System.out.println("StackTrace");
            sqle.printStackTrace();
        }
        
        
    }
}