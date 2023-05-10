package com.apex.servlets;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.apex.connection.ConnectionUtility;
import com.apex.dao.CustomerDao;
import com.apex.model.Customer;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String SESSION_ATTRIBUTE_ID ="sessionUserId";
    public static final String SESSION_ATTRIBUTE_NAME ="sessionUserName";
    
    public LoginServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String emailId = request.getParameter("emailId");
		String password  = request.getParameter("password");

		CustomerDao custDao =null;
		Customer customer =null;
		try {
			custDao = new CustomerDao(ConnectionUtility.getDBConnection());
			customer = custDao.CustomerLogin(emailId, password);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		if(customer!=null) {
			HttpSession sessionRequest = request.getSession(true);
				
			sessionRequest.setAttribute(SESSION_ATTRIBUTE_ID, customer.getCustomerId());
			sessionRequest.setAttribute(SESSION_ATTRIBUTE_NAME, customer.getName());
				
			request.getRequestDispatcher("HomePage.jsp").forward(request, response);
				
		}else {
				request.getRequestDispatcher("Error.html").forward(request, response);
		}
	}
}
