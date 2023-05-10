package com.apex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.apex.model.Order;

public class OrdersDao {
	private Connection con;
	private String query;
	private PreparedStatement pst;
	private ResultSet rs;
	
	public OrdersDao(Connection con) {
		super();
		this.con = con;
	}
	
	public boolean insertOrder(Order order) {
		boolean flag = false;
		try {
			query = "insert into orders (product_id,user_id,oredr_quantity,order_date) values(?,?,?,?)";
			pst = this.con.prepareStatement(query);
			pst.setInt(1, order.getProductId());
			pst.setInt(2, order.getUserId());
			pst.setInt(3, order.getOrderQuantity());
			pst.setString(4, order.getOrderDate());
			int i = pst.executeUpdate();
			if(i != 0) {
				flag = true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

}
