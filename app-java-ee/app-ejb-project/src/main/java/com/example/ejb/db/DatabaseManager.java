package com.example.ejb.db;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceProperty;

import com.example.ejb.annotations.CatalogManager;
import com.example.ejb.enums.DatabaseType;

public class DatabaseManager {

    @Produces 
    @CatalogManager(DatabaseType.MYSQL)
    @PersistenceContext(unitName="catalogPU",
        properties={@PersistenceProperty(name="javax.persistence.transactionType",value="JTA")})
    private EntityManager mysqlEntityManager;
    
}
