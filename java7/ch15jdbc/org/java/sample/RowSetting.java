<<<<<<< HEAD
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
=======
package org.java.sample;

import java.sql.*;
import javax.sql.*;
import javax.sql.rowset.*;


public class RowSetting {
    
    
    public static void main(String args[]) throws Exception{
        RowSetFactory rsf = RowSetProvider.newFactory();
        JdbcRowSet jdbcRowSet = rsf.createJdbcRowSet() ;
        jdbcRowSet.setCommand("select category_id,name,last_update from category ");
        jdbcRowSet.setUrl("jdbc:mysql://localhost:3306/sakila?useSSL=false");
        jdbcRowSet.setUsername("root");
        jdbcRowSet.setPassword("mysql");
        jdbcRowSet.setType(ResultSet.TYPE_SCROLL_SENSITIVE);
        jdbcRowSet.setConcurrency(ResultSet.CONCUR_UPDATABLE);
        jdbcRowSet.addRowSetListener(new MyListener());
        //jdbcRowSet.setInt(1,10);
        //this is when the DB connection takes place, in the execute method! 
        jdbcRowSet.execute(); // cant use executeUpdate, executeQuery.
        
        while(jdbcRowSet.next()){
            System.out.println(jdbcRowSet.getInt(1)+ " "+jdbcRowSet.getString(2) + " "+jdbcRowSet.getTimestamp(3)); 
        }
        System.out.println("row number after complete iteration: "+jdbcRowSet.getRow());
        
        jdbcRowSet.absolute(89);
        jdbcRowSet.updateString("name","Novelizing");
        jdbcRowSet.updateRow();
        //jdbcRowSet.cancelRowUpdates();
        //System.out.println(jdbcRowSet.rowUpdated());
        
//        jdbcRowSet.absolute(-1);
//        jdbcRowSet.deleteRow();
//        jdbcRowSet.cancelRowUpdates();
        
        //jdbcRowSet.beforeFirst();
        
//        jdbcRowSet.moveToInsertRow();
//        jdbcRowSet.updateInt(1,20);
//        jdbcRowSet.updateString(2,"Comedy Drama");
//        jdbcRowSet.updateObject(3,"2012-02-15 04:12:27.0");
//        jdbcRowSet.insertRow();
//        jdbcRowSet.moveToCurrentRow();
//        
//        while(jdbcRowSet.next()){
//            System.out.println(jdbcRowSet.getInt(1)+ " "+jdbcRowSet.getString(2) + " "+jdbcRowSet.getTimestamp(3)); 
//        }
        
    }
}

class MyListener implements RowSetListener {
    
    public void rowChanged(RowSetEvent ev){
        System.out.println("row changed: "); //+ ((JdbcRowSet)ev).getPassword());
    }
    
    public void cursorMoved(RowSetEvent ev){
        System.out.println("cursor moved: "); // + ((JdbcRowSet)ev).getPassword());
    }
    
    public void rowSetChanged(RowSetEvent ev){
        System.out.println("row set changed: "); //+ ev);
    }
    
}
 
>>>>>>> origin/master
