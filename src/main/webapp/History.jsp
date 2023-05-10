<%@page import="com.apex.connection.ConnectionUtility"%>
<%@page import="com.apex.model.UserHistory"%>
<%@page import="com.apex.dao.HistoryDao" %>
<%@page import="java.util.*" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./FormCSS.css">

</head>
<header>
	<%@ include file="Header.jsp"%>
</header>
<body>
	<h2>
		Welcome
		<%= session.getAttribute("sessionUserName") %></h2>
	<%
			Integer customerId =null;
			customerId = (Integer)session.getAttribute("sessionUserId");
			
			HistoryDao hDao = new HistoryDao(ConnectionUtility.getDBConnection());
			List<UserHistory> pList = hDao.getAllUserHistory(customerId);
	%>
	<table border="1">
		<tbody>
			<tr>
				<td>Count</td>
				<td>User Name</td>
				<td>Product Name</td>

			</tr>
			<%
				if (!pList.isEmpty()) {
				for (UserHistory p : pList) {
			%>

			<tr>
				<td><%=p.getCount()%></td>
				<td><%=p.getUserName()%></td>
				<td><%=p.getProductName()%></td>

			</tr>

			<%
			}
			}
			%>


		</tbody>
	</table>
	<br>
	<br>
	
			<h2><a href ="HomePage.jsp">Back</a></h2>
</body>
<footer>
	<%@ include file="FooterPage.jsp"%>
</footer>
</html>