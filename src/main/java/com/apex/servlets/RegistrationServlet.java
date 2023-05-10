package com.apex.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.apex.connection.ConnectionUtility;
import com.apex.dao.CustomerDao;


@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public RegistrationServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			System.out.println("Inside get method");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String emailId=request.getParameter("emailId");
		String password =request.getParameter("password");	
		Boolean flag= false;
		System.out.println("name in registration "+name);
		try{
			CustomerDao custDao = new CustomerDao(ConnectionUtility.getDBConnection());
			flag =custDao.RegisterCustomer(name, emailId, password);
		}catch(Exception e) {
			e.printStackTrace();
		}
		if(flag) {
			response.getWriter().append("<h1>Thank You "+name+" You Are Register Successfully</h1>");
		}
	}

}
