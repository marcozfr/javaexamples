package com.example.web.bean;

import com.example.web.bean.util.Indexer;

public class User {
	
	private Integer id;
	private String firstName;
	private String lastName;
	private Integer age;
	private String status;
	
	public User(String firstName, String lastName, Integer age, String status) {
		this.id = Indexer.getNextIndex();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.status = status;
	}
	public User(){
		
	}
	
	public Integer getId() {
		return id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	

}
