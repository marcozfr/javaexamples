package com.example.web.bean;

import java.util.List;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class Employee extends Person implements HttpSessionBindingListener {
	
	private Integer id;
	private String firstName;
	private String lastName;
	private List<String> badges;
	
	public void valueBound(HttpSessionBindingEvent evt){
		System.out.println(" Value bound as: " + evt.getName() + ": " + evt.getValue());
	}
	
	public void valueUnbound(HttpSessionBindingEvent evt){
		System.out.println(" Value unbound as: " + evt.getName() + ": " + evt.getValue());
	}
	
	public Employee() {
		// def
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

	public List<String> getBadges() {
		return badges;
	}

	public void setBadges(List<String> badges) {
		this.badges = badges;
	}

	

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", badges=" + badges
				+ "]";
	}

	@Override
	public String getCountry() {
		return "Peru";
	}

}
