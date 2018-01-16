<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List"%>
<%@ page import="com.revature.reimbursement.Employee"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee's Page</title>
</head>
<body>
<% Employee employee = (Employee) request.getSession().getAttribute("loggedEmployee"); %>
<!-- Welcome, employee.getFirstname() %> Use this for methods --> 
<h3>Welcome, <c:out value="${loggedEmployee.firstname}"/> </h3>
<p>Select a task to perform during your session</p>



<table style="width:100%">
	<tr>
		<th>Employee ID</th>
		<th>First Name</th>
		<th>Last Name</th>
		<th>Email</th>
		<th>Role </th>
		<th>Title</th>
	</tr>
	<tr>
		<th><c:out value="${loggedEmployee.eid}"/></th>
		<th><c:out value="${loggedEmployee.firstname}"/></th>
		<th><c:out value="${loggedEmployee.lastname}"/></th>
		<th><c:out value="${loggedEmployee.email}"/></th>  <!-- loggedemployee works -->
		<th><c:out value="${loggedEmployee.roleid}"/></th>
		<th><c:out value="${loggedEmployee.title}"/></th>
	</tr> 
	<tr>
		<th></th>
		<th></th>
		<th></th>
		<th></th>
		<th></th>
		<th> </th>
		<th> <form method="POST" action="empedit.do">
    <button type="submit">Edit Employee info</button>
</form> </th>
	</tr>
</table>

<form method="POST" action="emprems.do">
    <button type="submit">View Your Reimbursements</button><br><br> <!-- two queries will be performed with corresponding tables. 
    														WHERE condition will be pending for one and resolved for the other.  -->
</form>

<form method="POST" action="EmployeeRemSubmit.jsp">
    <button type="submit">Submit Reimbursement Request</button>
</form>

<form method="POST" action="logout.do">
    <button type="submit">Logout</button>
</form>
</body>
</html>