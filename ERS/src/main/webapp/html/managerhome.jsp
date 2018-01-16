<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Test</title>
</head>
<body>
	<%@ page import="com.revature.model.Credential"	 %>
	<% Credential cred = (Credential) request.getSession().getAttribute("authorizedUser"); %>
	<h2><%= cred.getUsername() %></h2>
	<div>
		<a href="http://localhost:8080/ERS/html/reimbursements.do">Reimbursements</a>
		<br>
		<a href="http://localhost:8080/ERS/html/account.do">Settings</a>		
	</div>
</body>
</html>