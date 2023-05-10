package com.apex.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtility {

	public static Connection con =null;
	
	private ConnectionUtility() {
		
	}
	
	public static Connection getDBConnection() {
		try {
			if(con==null) {
				synchronized (ConnectionUtility.class) {
					if(con==null) {
						String dbDriver ="com.mysql.cj.jdbc.Driver";
						String dbUrl="jdbc:mysql://localhost:3306/apex";
						String dbUserName ="root";
						String dbPassword ="Shambhavi$176332";
						Class.forName(dbDriver);
						
						con = DriverManager.getConnection(dbUrl,dbUserName,dbPassword);
					}
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return con; 
	}
}
