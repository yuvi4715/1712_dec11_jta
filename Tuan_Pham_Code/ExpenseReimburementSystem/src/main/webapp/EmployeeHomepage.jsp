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
	<div class="container-fluid">
		<p>Welcome to the Expense Reimbursement System  ${ loggedEmployee.firstName }</p>


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
				<li><a href='submitTicket.jsp' class="navbar-brand">Submit Reimbursement Request</a></li>
			</ul>
		</div>
	</div>
	<div>
		<ol class="breadcrumb">
			<li><a href='/ExpenseReimburementSystem/signout.do'>Sign Out</a></li>
		</ol>
</div>
<div class="card">
<div class="card-body">
<h4 class="card-title">Employee Information</h4>
<p class="card-text">
<b>Employee ID:</b> ${loggedEmployee.id}<br />
<b>First Name:</b> ${loggedEmployee.firstName} <br />
<b>Last Name:</b> ${loggedEmployee.lastName} <br />
<b>Email:</b> ${loggedEmployee.email} <br />
<b>Address:</b> ${loggedEmployee.address} <br />
<b>City:</b> ${loggedEmployee.city} <br />
<b>State:</b> ${loggedEmployee.state} <br />
<b>Zip:</b> ${loggedEmployee.zip} <br />
<b>Phone:</b> ${loggedEmployee.phone} 
</p>
<a href='UpdateEmployee.jsp' class="btn btn-primary">Update Information</a>
</div>
</div>

	
<h5 id="tickets"></h5>

	<script type="text/javascript" src="resources/js/getPendingTickets.js"></script>
	</div>
</body>
</html>