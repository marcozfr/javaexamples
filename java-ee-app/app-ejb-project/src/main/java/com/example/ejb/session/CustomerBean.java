package com.example.ejb.session;

import java.util.Date;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.model.catalog.ContactInfo;
import com.example.model.catalog.Customer;

@Stateless
public class CustomerBean {

	@PersistenceContext(unitName="catalogJTAPU")
	private EntityManager entityManager;
	
	public Customer createCustomer(){
		ContactInfo contactInfo = new ContactInfo();
		contactInfo.setEmail("m@gmail.com");
		contactInfo.setPhoneNumber("999-122122");
		
		Customer customer = new Customer();
		customer.setFirstName("Marco");
		customer.setLastName("Flores");
		customer.setDateOfBirth(new Date());
		customer.setContactInfo(contactInfo);
		
		entityManager.persist(customer);
		
		return customer;
	}
	
}