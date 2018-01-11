<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"></link>
<link rel="stylesheet" href="css/layout.css"></link>
<title>Reimbursements</title>
</head>
<body>
	<header> <nav class="navbar navbar-default">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">ERS System</a>
		</div>
		<ul class="nav navbar-nav">
			<li class="active"><a href="EmployeeHome.jsp">Home</a></li>
			<li><a href="RequestReimbursement.jsp">Create Request</a></li>
			<li><a href="EmployeeReimbursement.jsp">View Requests</a></li>
			<li><a href="login.jsp" onclick="logout()">Logout</a></li>
		</ul>
	</div>
	</nav>
	<h2>Reimbursements</h2>
	<p>
		You are signed on as
		<c:out value="${sessionScope.loggedEmployee.username}"></c:out>
	</p>
	</header>
	<section class="container">
	
	<div class="container">
		<div class="row">
			<div class="page-header">
				<ul class="list-inline">
				
					<li><a onclick="allRequestsByEmployee()">All Requests</a></li>
					<li><a onclick="allPendingRequestsByEmployee()">Pending Requests</a></li>
					<li><a onclick="allResolvedRequestsByEmployee()">Resolved Requests</a></li>
				</ul>
			</div>

			<div class="row">
				<table class="table">
					<thead>
						<tr>
							<td>Created By</td>
							<td>Reimbursement ID</td>
							<td>Amount</td>
							<td>Status</td>
							<td>Start Time</td>
							<td>Description</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${employeeReimbursement}" var="reimbursement">
							<tr>
								<td>${reimbursement.reimbursementId}</td>
								<td>${reimbursement.employeeId}</td>
								<td>${reimbursement.managerId}</td>
								<td>${reimbursement.amount}</td>
								<td>${reimbursement.title}</td>
								<td>${reimbursement.description}</td>
								<td>${reimbursement.status}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</section>
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="resources/js/script.js"></script>
</body>
</html>