<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List"%>
<%@ page import="com.revature.reimbursement.Employee"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manager's Page</title>
</head>
<body>

<h3>Welcome, <c:out value="${loggedEmployee.firstname}"/> </h3>
<p>Select the option that is most pertinent to your interests</p>

<% Employee employee = (Employee) request.getSession().getAttribute("loggedEmployee"); %>
<!-- Welcome, employee.getFirstname() %> Use this for methods --> 

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
		<th> </th>
	</tr>
</table>

<form method="POST" action="managerview.do">
    <button type="submit">View All Employees</button>
</form>

<form method="POST" action="managepending.do">
    <button type="submit">View Pending Reimbursements</button> <!-- stored proceed to transfer to resolved -->
</form>

<form method="POST" action="manageresolved.do">
    <button type="submit">View Resolved Reimbursements</button>
</form>

<form method="POST" action="logout.do">
    <button type="submit">Logout</button>
</form>

</body>
</html>