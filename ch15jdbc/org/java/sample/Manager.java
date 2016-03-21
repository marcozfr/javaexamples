package org.java.sample;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

public class Manager {
    
    public static void main (String args[]){
        try{
            Class.forName("com.mysql.jdbc.Driver"); // for jdbc 3 drivers and older
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/world?useSSL=false","root","root");
            //Statement stmt = c.createStatement();
            // to use specific result set types and concurrency 
            // note that mysql uses scrollable by default
            Statement stmt = c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            // mysql specific metadata
            DatabaseMetaData dmd = c.getMetaData();
            System.out.println("forward only: " + dmd.supportsResultSetType(ResultSet.TYPE_FORWARD_ONLY));
            System.out.println("scroll insensitive: " + dmd.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE)); // true
            System.out.println("scroll sensitive: " + dmd.supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE));
            
            System.out.println("scroll sensitive - read only: " +dmd.supportsResultSetConcurrency(
                ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY)); // true
            System.out.println("scroll sensitive - updatable: " +dmd.supportsResultSetConcurrency(
                ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)); // true
            
            System.out.println("statement result set type:"+stmt.getResultSetType());
            System.out.println("statement result set concurrency:"+stmt.getResultSetConcurrency());
            
            System.out.println("updates are detected: " + dmd.updatesAreDetected(ResultSet.TYPE_SCROLL_SENSITIVE));
            System.out.println("deletes are detected: " + dmd.deletesAreDetected(ResultSet.TYPE_SCROLL_SENSITIVE));
            
            //String query = "select * from city limit 0";
            //ResultSet rs = stmt.executeQuery(query);
            boolean resbol = stmt.execute(args[0]);
            System.out.println("execute result:"+resbol);
            //int resint = stmt.executeUpdate(args[0]);
            //System.out.println(resint);
            ResultSet rs = stmt.getResultSet();
            System.out.println("result set:"+rs);
            int updt = stmt.getUpdateCount();
            System.out.println("update count:"+updt);
            if(rs!=null){
                
                 // getting the number of rows returned, moving forward to the last and back again 
               if(rs.last()){
                   int rowCount = rs.getRow();
                   System.out.println("row count:" + rowCount); //considering row count 5.
                   rs.afterLast(); // void, row is 0
                   System.out.println("if row count 5, is pos 0? :"+rs.getRow());
                   rs.beforeFirst(); //void, row is 0
                   System.out.println("if row count 5, is pos 0? :"+rs.getRow());
                   // substract from beyond the last
                   System.out.println("if row count 5, is pos 1? :"+rs.absolute(-5)+" "+rs.getRow());
                   System.out.println("is after last? false:"+rs.isAfterLast());
                   // row is  1 + 2
                   System.out.println("if row count 5, is pos 3? :"+rs.relative(2)+" "+rs.getRow());
                   System.out.println("if row count 5, is pos 2? :"+rs.previous()+" "+rs.getRow());
                   // any (value > total rowcount), position after last row, it means 0
                   System.out.println("if row count 5, is pos 0? :"+rs.absolute(7)+" "+rs.getRow());
                   System.out.println("is after last? true :"+rs.isAfterLast());
                   System.out.println("if row count 5, is pos 0? :"+rs.relative(-20)+" "+rs.getRow());
                   System.out.println("is before last? true:"+rs.isBeforeFirst());
                   System.out.println("if row count 5, is pos 1? :"+rs.next()+" "+rs.getRow());
                   System.out.println("is first true? :"+rs.isFirst());
               }
              
               ResultSetMetaData  rsmt = rs.getMetaData();
               System.out.println("column count:" +rsmt.getColumnCount());
                 // accessing ResoulSet data before moving the pointer throws an Exception
               while(rs.next()){
                 System.out.println(rsmt.getTableName(1)+"/"+rsmt.getColumnName(1)+":"+rs.getObject("ID")+", size:" + rsmt.getColumnDisplaySize(1));
                    System.out.println(rsmt.getTableName(2)+"/" +rsmt.getColumnName(2) + ":"+rs.getString(2)+", size:" + rsmt.getColumnDisplaySize(2));
                    if(rs.getInt("ID") == 22){
                        rs.updateString("Name","Maastricht-up");
                        rs.updateRow();
                        System.out.println("updating Name" );
                    }
                } 
            }
            
            
        }catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        
        
    }
    
}