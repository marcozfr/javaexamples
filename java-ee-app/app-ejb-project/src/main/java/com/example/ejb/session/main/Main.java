package com.example.ejb.session.main;

import javax.ejb.EJB;

import com.example.ejb.session.CustomerBean;
import com.example.model.catalog.Customer;

public class Main {
	
	@EJB
	private static CustomerBean customerBean;
	
	public static void main(String[] args) {
		Customer customer = customerBean.createCustomer();
		System.out.println(customer.getCustomerId());
	}

}
