package com.apex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.*;

import com.apex.model.Product;
import com.apex.model.UserHistory;

public class HistoryDao {
	private Connection con;
	private String query;
	private PreparedStatement pst;
	private ResultSet rs;
	
	public HistoryDao(Connection con) {
		super();
		this.con = con;
	}
	public List<UserHistory> getAllUserHistory(Integer customerId){
		List<UserHistory> list = new ArrayList<UserHistory>();
		try {
			query = "select count(c.product_id),a.name,c.name from apex.customer_info a "
					+ "inner join apex.orders b "
					+ "on a.customer_id = b.user_id "
					+ "inner join apex.product c "
					+ "on b.product_id = c.product_id where a.customer_id=? group by a.name,c.name";
			pst = con.prepareStatement(query);
			pst.setInt(1, customerId);
			rs = pst.executeQuery();
			while(rs.next()) {
				UserHistory userHistory = new UserHistory();
				userHistory.setCount(rs.getInt(1));
				userHistory.setUserName(rs.getString(2));
				userHistory.setProductName(rs.getString(3));
				
				list.add(userHistory);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
