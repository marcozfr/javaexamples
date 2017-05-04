package com.example.kafka.model;

public class User {
	
	private Long userId;
	private String username;
	
	
	public User() {
		super();
	}
	public User(Long userId, String username) {
		this.userId = userId;
		this.username = username;
	}
	public String getUsername() {
		return username;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	

}
