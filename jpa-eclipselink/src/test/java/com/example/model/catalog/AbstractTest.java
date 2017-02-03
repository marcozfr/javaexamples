package com.example.model.catalog;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

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
        emf = Persistence.createEntityManagerFactory("catalogPU");
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
