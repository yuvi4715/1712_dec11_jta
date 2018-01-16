<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List"%>
<%@ page import="com.revature.reimbursement.Closed"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reimbursements</title>
</head>
<body>

<!-- Welcome, employee.getFirstname() %> Use this for methods --> 
<h3>Welcome, <c:out value="${loggedEmployee.firstname}"/> </h3>
<p>Here are your reimbursements</p>



<table style="width:100%">
	<tr>
		<th>Reimbursement ID</th>
		<th>Amount</th>
		<th>EID</th>
		<th>Status</th>
		<th>Entry date</th>
		<th>End date</th>
		<th>Description</th>
		<th>Resolved by</th>
	</tr>
	<c:forEach items="${reimbursementsEid}" var="rem">
	<tr>
		<th><c:out value="${rem.rid}"/></th>
		<th><c:out value="${rem.amt}"/></th>
		<th><c:out value="${rem.eid}"/></th>
		<th><c:out value="${rem.status}"/></th>  
		<th><c:out value="${rem.starttime}"/></th>
		<th><c:out value="${rem.endtime}"/></th>
		<th><c:out value="${rem.description}"/></th>
		<th><c:out value="${rem.resolvedby}"/></th>
	</tr> 
	</c:forEach>
	<tr>
		<th></th>
		<th></th>
		<th></th>
		<th></th>
		<th></th>
		<th> </th>
		<th> <form method="POST" action="employee.do">
    <button type="submit">return</button>
</form> </th>
	</tr>
</table>

<form method="POST" action="employee.do">
    <button type="submit">Submit Reimbursement Request</button>
</form>

<form method="POST" action="logout.do">
    <button type="submit">Logout</button>
</form>

</body>
</html>