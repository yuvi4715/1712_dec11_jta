<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	
<title>Manager Home</title>
</head>
<body>
	<h1 align="center">Manager HomePage</h1>
	<div class="container">
		<p> Welcome Manager ${ loggedEmployee.firstName }</p>
	</div>

	<div class="navbar" class="navbar navbar-light" style="background-color: #e3f2fd;">
		<div class="navbar-header">
			<!-- <a class="navbar-brand" href="#"></a> -->
			<ul class="nav navbar-nav">
				<li><a class="navbar-brand" href="#"><span
						class="glyphicon glyphicon-home" aria-hidden="true"> 
						</span></a></li>

		<li><a id="pendingClick" class="navbar-brand" onclick="return getPenTickets()">View All Pending Reimbursements</a></li>
				<li><a id="pendingClick" class="navbar-brand" onclick="return getResTickets()">View All Resolved Reimbursements</a></li>

			</ul>
		</div>
	</div>
	<div>
		<ol class="breadcrumb">
			<li><a href='/ExpenseReimburementSystem/signout.do'>Sign Out</a></li>
		</ol>
</div>


	<table class="table table-striped">
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
			<c:forEach items="${requestScope.displayEmp2}" var="emp">
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
	
	<h2>Pending Reimbursements</h2>
		<table class="table table-striped">
		<thead>
			<tr>
				<th> Ticket ID </th>
				<th> Employee ID </th>
				<th>Status </th>
				<th> Total </th>
				<th> Submit Time </th>
				<th> Description </th>
				<th> Category </th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${requestScope.displayReimbursement}" var="r">
				<tr>
					<td> <c:out value="${r.getTicketId()}"></c:out></td>
					<td> <c:out value="${r.getEmployeeId()}"></c:out></td>
					<td> <c:out value="${r.getStatus()}"></c:out></td>
					<td> <c:out value="${r.getTotal()}"></c:out></td>
					<td> <c:out value="${r.getSubmitTime()}"></c:out></td>
					<td> <c:out value="${r.getDescription()}"></c:out></td>
					<td> <c:out value="${r.getCategory()}"></c:out></td>
					<td><button id="${r.getTicketId()}" type="button" onclick="approve(this.id)"> Approve</button>
						<button id="${r.getTicketId()}" type="button">Deny</button></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	
	<h5 id="alltickets"></h5>


	<script type="text/javascript" src="resources/js/getAllTickets.js"></script>
</body>
</html>