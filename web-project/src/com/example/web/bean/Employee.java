package com.example.web.bean;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

import com.example.web.listener.SessionActivationListener;

public class Employee implements HttpSessionBindingListener {
	
	private Integer id;
	private String firstName;
	private String lastName;
	
	public void valueBound(HttpSessionBindingEvent evt){
		System.out.println(" Value bound as: " + evt.getName() + ": " + evt.getValue());
	}
	
	public void valueUnbound(HttpSessionBindingEvent evt){
		System.out.println(" Value unbound as: " + evt.getName() + ": " + evt.getValue());
	}

	public Employee(Integer id, String firstName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}

}
