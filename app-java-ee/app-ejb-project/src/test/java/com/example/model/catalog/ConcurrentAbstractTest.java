package com.example.model.catalog;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public abstract class ConcurrentAbstractTest {
    
    protected static EntityManagerFactory emf1;
    protected static EntityManager session1;
    protected static EntityManager session2;
    protected static EntityTransaction tx1;
    protected static EntityTransaction tx2;
    
    @BeforeClass
    public static void before(){
        
    }
    
    @AfterClass
    public static void after(){
        if(session1!=null) session1.close();
        if(session2!=null) session2.close();
        
        if(emf1!=null) emf1.close();
    }
    
//    @Before
//    public void initTx1(){
//        tx1 = session1.getTransaction();
//    }
//    
//    @Before
//    public void initTx2(){
//        tx2 = session2.getTransaction();
//    }

}
