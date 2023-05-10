package com.apex.model;

public class Customer {

	private int customerId;
	private String name;
	private String emailId;
	private String password;
	
	public Customer() {
	}
	
	public Customer(int customerId, String name, String emailId, String password) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.emailId = emailId;
		this.password = password;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", emailId=" + emailId + ", password="
				+ password + "]";
	}
	
	
	
}
