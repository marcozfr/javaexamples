package com.example.model.catalog;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.eclipse.persistence.config.EntityManagerProperties;
import org.eclipse.persistence.config.PersistenceUnitProperties;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public abstract class AbstractTest {
    
    protected static EntityManagerFactory emf;
    protected static EntityManager em;
    protected static EntityTransaction tx;
    
    @BeforeClass
    public static void before(){
        
        Map<String,Object> props = new HashMap<>();
        props.put(PersistenceUnitProperties.TRANSACTION_TYPE,"RESOURCE_LOCAL");
        props.put(PersistenceUnitProperties.JDBC_URL,"jdbc:mysql://localhost:3306/catalogtest?useSSL=false");
        emf = Persistence.createEntityManagerFactory("catalogPU",props);
        em = emf.createEntityManager();
    }
    
    @AfterClass
    public static void after(){
        if(em!=null) em.close();
        
        if(emf!=null) emf.close();
    }
    
    @Before
    public void initTransaction(){
        tx = em.getTransaction();
    }
    
}
