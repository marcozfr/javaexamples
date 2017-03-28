package com.example.ejb.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import javax.naming.NamingException;

import org.junit.Test;

import com.example.ejb.session.CustomerBean;
import com.example.model.catalog.ContactInfo;
import com.example.model.catalog.Customer;

public class CustomerBeanTest extends EjbContainerTest {

	@Test
	public void createCustomerBeanTest() throws NamingException{
		CustomerBean customerBean = (CustomerBean) context.lookup("java:global/classes/CustomerBean!com.example.ejb.session.CustomerBean");
		
		ContactInfo contactInfo = new ContactInfo();
        contactInfo.setEmail("m@gmail.com");
        contactInfo.setPhoneNumber("999-122122");
        
        Customer customer = new Customer();
        customer.setFirstName("Marco");
        customer.setLastName("Flores");
        customer.setDateOfBirth(new Date());
        customer.setContactInfo(contactInfo);
        
		Customer c = customerBean.createCustomer(customer);
		
		assertNotNull(c.getCustomerId());
		
		assertTrue(c.getFirstName().equals("Sr. Marco"));
	}
}
