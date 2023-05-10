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
			<title>Home Page</title>
		<link rel="stylesheet" href="./FormCSS.css">
	</head>
	<header>
		<%@ include file="Header.jsp" %>
	</header>
	<body>
		
		<h2>Welcome <%= session.getAttribute("sessionUserName") %></h2>
		<h3><a href ="Shopping.jsp">Shop now</a></h3>
		<br>
		<h3><a href ="History.jsp">User History</a></h3>
	</body>
	<footer>
		<%@ include file="FooterPage.jsp" %>
	</footer>
</html>