package com.example.model.catalog;

import java.util.Date;

import javax.persistence.EntityTransaction;
import javax.persistence.LockModeType;
import javax.persistence.RollbackException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class ConcurrentCustomerTest extends ConcurrentAbstractTest {

    private static Logger logger = LogManager.getLogger(ConcurrentCustomerTest.class); 
    
    @Test(expected=RollbackException.class)
    public void customerTest() throws InterruptedException{
        
        EntityTransaction tx0 = session1.getTransaction();
        tx0.begin();
        Customer customer = new Customer();
        customer.setAge(15);
        customer.setCreationDate(new Date());
        customer.setDateOfBirth(new Date());
        customer.setFirstName("Bob");
        customer.setLastName("Sinclair");
        customer.setContactInfo(new ContactInfo());
        customer.getContactInfo().setEmail("bs@gmail.com");
        customer.getContactInfo().setPhoneNumber("111-1111");
        session1.persist(customer);
        logger.info("tx0: {} : {}",customer.toString(),customer.getFirstName());
        tx0.commit();
        
        EntityTransaction tx1 = session1.getTransaction();
        tx1.begin();
        
        customer.setFirstName("Bob1");
        
        session1.persist(customer);
        
        Runnable r = () -> {
            while(true){
                EntityTransaction tx2 = session2.getTransaction();
                tx2.begin();
                Customer f = session2.find(Customer.class, customer.getCustomerId(),LockModeType.PESSIMISTIC_FORCE_INCREMENT);
                f.setFirstName("Bob2");
                session2.persist(f);
                logger.info("tx2: {} : {}",f.toString(),f.getFirstName());
                tx2.commit();
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        };
        
        new Thread(r).start();
        
        Thread.sleep(1000);
        
        tx1.commit(); // throws OptimicticLockException
        logger.info("tx1: {} : {}",customer.toString(),customer.getFirstName());
        Thread.sleep(1000);
        
    }
    
}
