package org.java.sample;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Savepoint;

public class Transac {

    public static void main (String ...args) throws Exception {
        Connection conn = DriverManager.
            getConnection("jdbc:mysql://localhost:3306/world?useSSL=false", "root","root");
        Statement stmt = conn.createStatement();
        conn.setAutoCommit(false);
        System.out.println(stmt.execute(insertCountryLanguageString("PER","Spanish","T",79.8)));
        
        Savepoint sp = conn.setSavepoint();
        conn.releaseSavepoint(sp);
        
        sp = conn.setSavepoint();
        System.out.println(stmt.execute(insertCityString(9000,"Lima","PER","San Isidro",100000)));
        
        conn.rollback(sp); // when rollbacking with an endpoint, you must call commit after to get your things saved.
        conn.commit(); 
        //conn.rollback();
    }
    
    public static String insertCountryLanguageString(String countryCode, 
                                              String language, String isOfficial, double percentage){
        StringBuilder sb = new StringBuilder();
        sb.append("insert into countrylanguage (countrycode,language,isofficial,percentage) values ('");
        sb.append(countryCode);sb.append("','");
        sb.append(language);sb.append("','");
        sb.append(isOfficial);sb.append("',");
        sb.append(percentage);sb.append(")");
        return sb.toString();
    }
    
    public static String insertCityString(int id, String name, 
                                   String countryCode, String district, int population){
        StringBuilder sb = new StringBuilder();
        sb.append("insert into city (id,name,countrycode,district, population) values (");
        sb.append(id);sb.append(",'");
        sb.append(name);sb.append("','");
        sb.append(countryCode);sb.append("','");
        sb.append(district);sb.append("',");
        sb.append(population);sb.append(")");
        return sb.toString();
    }

}