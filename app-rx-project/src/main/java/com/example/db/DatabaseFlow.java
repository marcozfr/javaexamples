package com.example.db;

import org.davidmoten.rx.jdbc.Database;

public class DatabaseFlow {

    public static void main(String[] args) {
        Database.test().select("select name from Person")
            .getAs(String.class)
            .blockingForEach(c ->{
                System.out.println(c);
            });
    }
}
