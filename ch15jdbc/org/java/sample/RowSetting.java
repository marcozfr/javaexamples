package org.java.sample;

import javax.sql.*;
import javax.sql.rowset.*;


public class RowSetting {
    
    
    public static void main(String args[]) throws Exception{
        
        //JdbcRowSet jrs = RowSetProvider.newFactory().createJdbcRowSet();
        CachedRowSet jrs = RowSetProvider.newFactory().createCachedRowSet();
        jrs.setUrl("jdbc:mysql://localhost:3306/world?useSSL=false");
        jrs.setUsername("root");
        jrs.setPassword("root");
        jrs.setCommand("select  * from countrylanguage where countrycode = 'PER' limit 5 ");
        jrs.addRowSetListener(new MyRowSetImpl());
        jrs.execute();
        
        while(jrs.next()){
            System.out.printf("%1$-15s %2$-15s",jrs.getString("countrycode"),jrs.getString("language"));
            System.out.println();
            if(jrs.isLast()){
                jrs.updateString("language", "Spanish1");
                //jrs.updateRow();
            }
        }
        jrs.moveToInsertRow();
        jrs.updateString("countrycode","PER");
        jrs.updateString("language","Spanglish");
        jrs.updateString("isOfficial","T");
        jrs.updateFloat("percentage",12.3f);
        //jrs.insertRow();
        jrs.moveToCurrentRow();
        //jrs.execute();
        jrs.acceptChanges();
        System.out.println("updated");
        while(jrs.next()){
            System.out.printf("%1$-15s %2$-15s",jrs.getString("countrycode"),jrs.getString("language"));
            System.out.println();
        }
        
        
    }
    
}

class MyRowSetImpl implements RowSetListener {
    
    public void rowChanged(RowSetEvent evt){
        System.out.println("event on changing row");
    }
    
    public void cursorMoved(RowSetEvent evt){
        
    }
    
    public void rowSetChanged(RowSetEvent evt){
        
    }
    
}