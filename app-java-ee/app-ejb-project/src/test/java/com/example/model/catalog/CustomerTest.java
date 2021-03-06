package com.example.model.catalog;
import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Test;
import com.example.model.catalog.AbstractTest;
import com.example.model.catalog.Address;
import com.example.model.catalog.ContactInfo;
import com.example.model.catalog.Customer;

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
        
        Address address = new Address();
        address.setCity("Lima");
        address.setCountry("Peru");
        address.setCountryCode("PE");
        address.setState("Lima");
        address.setZipCode("15074");
        address.setStreet1("Av Rep de Panama");
        address.setStreet2("Of 102");
        
        customer.setContactInfo(contactInfo);
        
        customer.setBillingAddress(address);
        
        tx.begin();
        
        em.persist(customer);
        
        tx.commit();
        
        assertNotNull(customer.getCustomerId());
        
    }
    
}
