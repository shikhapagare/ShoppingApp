package com.apex.model;

public class Order extends Product{

	private int orderId;
	private int userId;
	private int orderQuantity;
	private String orderDate;
	public Order(int orderId, int userId, int orderQuantity, String orderDate) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.orderQuantity = orderQuantity;
		this.orderDate = orderDate;
	}
	public Order(int userId, int orderQuantity, String orderDate) {
		super();
		this.userId = userId;
		this.orderQuantity = orderQuantity;
		this.orderDate = orderDate;
	}
	
	public Order() {
		super();
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getOrderQuantity() {
		return orderQuantity;
	}
	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", userId=" + userId + ", orderQuantity=" + orderQuantity + ", orderDate="
				+ orderDate + "]";
	}
	
	
}
