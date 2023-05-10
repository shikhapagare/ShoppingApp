package com.apex.dao;

import java.sql.*;

import com.apex.connection.ConnectionUtility;
import com.apex.model.Customer;

public class CustomerDao {

	private Connection con;
	private String query;
	private PreparedStatement pst;
	private ResultSet rs;
	
	public CustomerDao(Connection con) {
		this.con=con;
	}
	
	public Boolean RegisterCustomer(String name,String emailId,String password) {
		Boolean flag = false;
		try {
			pst= con.prepareStatement("insert into customer_info (name,email_id,password) values(?,?,?)");
			pst.setString(1, name);
			pst.setString(2, emailId);
			pst.setString(3, password);
			int i = pst.executeUpdate();
			if(i!=0) {
				flag = true;
			}
			System.out.println(i+" Record updated");
			pst.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	public Customer CustomerLogin(String emailId,String password) {
		Customer customer= null;
		try {
			pst = this.con.prepareStatement("select customer_id,name,email_id from customer_info where email_id = ? and password = ?");
			pst.setString(1, emailId);
			pst.setString(2, password);
			rs = pst.executeQuery();
		
			while(rs.next()) {
				customer = new Customer();
				customer.setCustomerId(rs.getInt(1));
				customer.setName(rs.getString(2));
				customer.setEmailId(rs.getString(3));
			}
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customer;
	}
}