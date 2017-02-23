package com.example.web.faces.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.example.ejb.session.CustomerBean;
import com.example.model.catalog.Customer;

@ManagedBean(name="customer",eager=false)
@RequestScoped
public class CustomerController {
	
	private List<Customer> customerList;
	
	@EJB
	private CustomerBean customerBean;
	
	@PostConstruct
	public void init(){
		customerList = customerBean.findCustomers();
	}

	public List<Customer> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(List<Customer> customerList) {
		this.customerList = customerList;
	}
	
}
