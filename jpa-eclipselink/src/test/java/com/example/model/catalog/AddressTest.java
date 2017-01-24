package com.example.model.catalog;
import static org.junit.Assert.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class AddressTest extends AbstractTest {
    
    @Test
    public void testAddressSecondaryTables(){
        
        Address address = new Address();
        address.setCity("Lima");
        address.setCountry("Peru");
        address.setCountryCode("PE");
        address.setState("Lima");
        address.setZipCode("15074");
        address.setStreet1("Av Rep de Panama");
        address.setStreet2("Of 102");
        
        tx.begin();
        
        em.persist(address);
        
        tx.commit();
        
        assertNotNull(address.getId());
        
    }
    
}
