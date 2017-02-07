package com.example.ejb.test;

import static org.junit.Assert.assertNotNull;

import javax.naming.NamingException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.example.ejb.session.CustomerBean;
import com.example.model.catalog.Customer;

public class CustomerBeanTest extends EjbContainerTest {

	@Test
	public void createCustomerBeanTest() throws NamingException{
		CustomerBean customerBean = (CustomerBean) context.lookup("java:global/classes/CustomerBean!com.example.ejb.session.CustomerBean");
		Customer c = customerBean.createCustomer();
		assertNotNull(c.getCustomerId());
	}
}
