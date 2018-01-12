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
			<li class="active"><a href="ManagerHome.jsp">Home</a></li>
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#">Reimbursements <span
					class="caret"></span></a>
				<ul class="dropdown-menu">
					<li><a href="ManagerRequestReimbursement.jsp">Create
							Request</a></li>
					<li><a href="ManagerReimbursement.jsp">View Requests</a></li>
				</ul></li>
			<li><a href="#" onclick="loadEmployeeList()">View Employees</a></li>
			<li><a href="#" onclick="logout()">Logout</a></li>
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

					<li><a onclick="allPendingRequests()">All Pending Requests</a></li>
					<li><a onclick="allResolvedRequests()">All Resolved
							Requests</a></li>
					<li><form id="employeeSearch" action="ViewAllByEmployee" method="POST">
						<p><input type="number" name="searchInput" style="width: 250px;" placeholder="Search all requests by Employee ID">
						<button id="searchButton" type="submit" class="btn btn-default">Search</button>
					</form></li>
					<!-- <input id="searchBar" type="number" name="searchInput" style="width: 250px;" placeholder="Search all requests by Employee ID">
						<button id="searchButton" type="button" class="btn btn-default" onclick="filterRequestsByEmployee()">Search</button> -->
				</ul>
			</div>

			<!-- <form id="employeeSearch" action="ViewAllByEmployee" method="POST">
						<input type="int" name="searchInput">
						<button id=searchButton " type="button" class="btn btn-default"
							onclick="filterRequestsByEmployee()">Filter</button>
					</form> 
					-->
			<div class="row">
				<table class="table">
					<thead>
						<tr>
							<td>Reimbursement ID</td>
							<td>Created By</td>
							<td>Resolved By</td>
							<td>Amount</td>
							<td>Title</td>
							<td>Description</td>
							<td>Start Time</td>
							<td>End Time</td>
							<td>Status</td>
							<td>Action</td>
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
								<td>${reimbursement.start}</td>
								<td>${reimbursement.end}</td>
								<td id="status${reimbursement.reimbursementId}">${reimbursement.status}</td>
								<td>
									<button id="${reimbursement.reimbursementId}" type="button" class="btn btn-primary"
										onclick="approve(this.id)">Approve</button>
									<button id="${reimbursement.reimbursementId}" type="button"
										class="btn btn-danger" onclick="deny(this.id)">Deny</button>
								</td>
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