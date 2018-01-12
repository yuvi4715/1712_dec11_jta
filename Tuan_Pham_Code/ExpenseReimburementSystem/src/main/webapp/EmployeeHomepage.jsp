<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	
<title>Employee Home</title>
</head>
<body>
	<h1 align="center">Employee HomePage</h1>
	<div class="container">
		<p>Welcome to the Expense Reimbursement System  ${ loggedEmployee.firstName }</p>
	</div>

	<div class="navbar" class="navbar navbar-light" style="background-color: #e3f2fd;">
		<div class="navbar-header">
			<!-- <a class="navbar-brand" href="#"></a> -->
			<ul class="nav navbar-nav">
				<li><a class="navbar-brand" href="#"><span
						class="glyphicon glyphicon-home" aria-hidden="true"> 
						</span></a></li>

	<!--  			<li><a class="navbar-brand" href="/ExpenseReimburementSystem/pending.do">View Pending Reimbursements</a></li> -->
				<li><a id="pendingClick" class="navbar-brand" onclick="return getPenTickets()">View Pending Reimbursements</a></li>
				<li><a id="pendingClick" class="navbar-brand" onclick="return getResTickets()">View Resolved Reimbursements</a></li>
			  	<li><a href='UpdateEmployee.jsp' class="navbar-brand">Update Information</a></li>
				<li><a href='submitTicket.jsp' class="navbar-brand">Submit Reimbursement Request</a></li>
			</ul>
		</div>
	</div>
	<div>
		<ol class="breadcrumb">
			<li><a href='/ExpenseReimburementSystem/signout.do'>Sign Out</a></li>
		</ol>
</div>


	<table class="table table-reflow">
		<thead>
			<tr>
				<th> Employee ID </th>
				<th> First Name </th>
				<th> Last Name </th>
				<th> Email </th>
				<th> Address </th>
				<th> City </th>
				<th> State </th>
				<th> Zip </th>
				<th> Phone </th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${requestScope.displayEmp}" var="emp">
				<tr>
					<td> <c:out value="${emp.getId()}"></c:out></td>
					<td> <c:out value="${emp.getFirstName()}"></c:out></td>
					<td> <c:out value="${emp.getLastName()}"></c:out></td>
					<td> <c:out value="${emp.getEmail()}"></c:out></td>
					<td> <c:out value="${emp.getAddress()}"></c:out></td>
					<td> <c:out value="${emp.getCity()}"></c:out></td>
					<td> <c:out value="${emp.getState()}"></c:out></td>
					<td> <c:out value="${emp.getZip()}"></c:out></td>
					<td> <c:out value="${emp.getPhone()}"></c:out></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<h5 id="tickets"></h5>


	<script type="text/javascript" src="resources/js/getPendingTickets.js"></script>

</body>
</html>