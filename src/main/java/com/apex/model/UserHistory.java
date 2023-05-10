package com.apex.model;

public class UserHistory {
	private Integer Count;
	private String userName;
	private String ProductName;
	
	public Integer getCount() {
		return Count;
	}
	public void setCount(Integer count) {
		Count = count;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	@Override
	public String toString() {
		return "UserHistory [Count=" + Count + ", userName=" + userName + ", ProductName=" + ProductName + "]";
	}
	
	
	

}
