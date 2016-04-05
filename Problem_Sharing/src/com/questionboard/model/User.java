package com.questionboard.model;

public class User {
	private long userId;
	private String firstName;
	private String lastName;
	private String username;
	private String email;
	private String password;
	
	public User(long userId, String firstName, String lastName, String username, String email) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.email = email;
	}
	
	public User(String firstName, String lastName, String username, String email, String password) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.email = email;
		this.password = password;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	
}
