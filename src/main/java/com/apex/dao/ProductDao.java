package com.apex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.apex.model.Product;

public class ProductDao {
	private Connection con;
	private String query;
	private PreparedStatement pst;
	private ResultSet rs;
	
	public ProductDao(Connection con) {
		super();
		this.con = con;
	}

	public List<Product> getAllProduct(){
		List<Product> list = new ArrayList<Product>();
		
		try {
			query="select * from product";
			pst = con.prepareStatement(query);
			rs = pst.executeQuery();
			while(rs.next()) {
				Product products = new Product();
				products.setProductId(rs.getInt(1));
				products.setName(rs.getString(2));
				products.setCategory(rs.getString(3));
				products.setPrice(rs.getDouble(4));
				products.setImage(rs.getString(5));
				list.add(products);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
