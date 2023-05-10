package com.apex.servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.apex.connection.ConnectionUtility;
import com.apex.dao.OrdersDao;
import com.apex.model.Customer;
import com.apex.model.Order;


@WebServlet("/ShoppingServlet")
public class ShoppingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ShoppingServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		HttpSession requestSession = request.getSession(true);
		String sessionId = requestSession.getId();
		
		Integer customerId = (Integer) requestSession.getAttribute("sessionUserId");
		System.out.println("customer id"+customerId);

		SimpleDateFormat dateFormate = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		//String customerId = (String)request.getSession().getAttribute(SESSION_ATTRIBUTE_ID);
		//String customerName = (String)request.getSession().getAttribute("sessionUserName");
		//System.out.println(customerName);
		if(customerId != null) {
			String productId = request.getParameter("productId");
			
			Order orders = new Order();
			orders.setProductId(Integer.parseInt(productId));
			orders.setUserId(customerId);
			orders.setOrderQuantity(1);
			orders.setOrderDate(dateFormate.format(date));
			OrdersDao oDao = new OrdersDao(ConnectionUtility.getDBConnection());
			boolean result = oDao.insertOrder(orders);
			if(result) {
				request.getRequestDispatcher("OrderSuccess.jsp").forward(request, response);
			}else {
				response.getWriter().append("Order not Successful");
			}
			
			
		}else {
			request.getRequestDispatcher("LoginPage.html").forward(request, response);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
