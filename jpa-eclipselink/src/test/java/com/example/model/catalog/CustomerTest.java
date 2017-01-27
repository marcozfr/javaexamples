package com.example.model.catalog;
import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class CustomerTest extends AbstractTest {
    
    @Test
    public void testCustomerEmbeddableContactInfo(){
        
        Customer customer = new Customer();
        customer.setAge(34);
        customer.setCreationDate(new Date());
        customer.setFirstName("Marco");
        customer.setLastName("Flores");
        
        ContactInfo contactInfo = new ContactInfo();
        contactInfo.setEmail("m@gmail.com");
        contactInfo.setLinkedinAccount("marcozfr");
        contactInfo.setPhoneNumber("333-2223");
        
        customer.setContactInfo(contactInfo);
        
        tx.begin();
        
        em.persist(customer);
        
        tx.commit();
        
        assertNotNull(customer.getId());
        
    }
    
}
