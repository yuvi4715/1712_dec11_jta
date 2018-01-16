<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List"%>
<%@ page import="com.revature.reimbursement.Closed"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View All Employees</title>
</head>
<body>
<h3>Welcome, <c:out value="${loggedEmployee.firstname}"/> </h3>
<p>Listed below are all metriculated employees</p>



<table style="width:100%">
	<tr>
		<th>Employee ID</th>
		<th>Firstname</th>
		<th>Lastname</th>
		<th>Email</th>
		<th>Role</th>
		<th>Title</th>
		<th> </th>
		<th> </th>
	</tr>
	<c:forEach items="${listedEmployees}" var="emp">
	<tr>
		<th><c:out value="${emp.eid}"/></th>
		<th><c:out value="${emp.firstname}"/></th>
		<th><c:out value="${emp.lastname}"/></th>
		<th><c:out value="${emp.email}"/></th>  
		<th><c:out value="${emp.roleid}"/></th>
		<th><c:out value="${emp.title}"/></th>
		<th></th>
		<th></th>
	</tr> 
	</c:forEach>
	<tr>
		<th></th>
		<th></th>
		<th></th>
		<th></th>
		<th></th>
		<th> </th>
		<th> </th>
	</tr>
</table>
<br>
<form method="POST" action="manager.do">
    <button type="submit">return</button>
</form>
<br>
<form method="POST" action="logout.do">
    <button type="submit">logout</button><br><br> 
</form>



</body>
</html>