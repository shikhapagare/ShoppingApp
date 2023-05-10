<%@page import="com.apex.connection.ConnectionUtility"%>
<%@page import="com.apex.model.Product"%>
<%@page import="com.apex.dao.ProductDao" %>
<%@page import="java.util.*" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shopping Page</title>
<link rel="stylesheet" href="./FormCSS.css">
</head>
	<header>
		<%@ include file="Header.jsp" %>
	</header>
<body>
	<h2>Welcome <%= session.getAttribute("sessionUserName") %></h2>
		<h3>Shop now</h3>
		<%
			Integer customerId =null;
			customerId = (Integer)session.getAttribute("sessionUserId");
			
			ProductDao pDao = new ProductDao(ConnectionUtility.getDBConnection());
			List<Product> pList = pDao.getAllProduct();
		
		%>
		
		
				<table border="1">
					<tbody>
						<%if(!pList.isEmpty()) {
							for(Product p:pList){%>
							
						<tr>
							<td><%=p.getName()%></td>
							<td><%=p.getCategory()%></td>
							<td><%=p.getPrice()%>
							<td>
								<form name="shoppingForm" action ="ShoppingServlet" method="doPost">
									<input type="hidden" name="productId" value=<%=p.getProductId() %>></input>
									<input type="submit"  value="Buy"></input>
								</form>
							</td>
						</tr>
						
						<%}
							}
						%>
						
						
					</tbody>
				</table>
				<br><br>
			<h2><a href ="HomePage.jsp">Back</a></h2>
		</body>
		<footer>
		<%@ include file="FooterPage.jsp" %>
		</footer>
</html>