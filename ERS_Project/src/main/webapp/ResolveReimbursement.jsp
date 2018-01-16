<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Resolve Reimbursement</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">ERS</a>
			</div>
			<ul class="nav navbar-nav">
				<li><a href="home.do">Home</a></li>
				<li><a href="edit_page.do">Edit Profile</a></li>
				<li><a href="new_page.do">Reimbursement Form</a></li>
				<li><a href="history.do">Reimbursement History</a></li>
				<li class="active"><a href="resolve_page.do">Resolve Reimbursements</a></li>
				<li><a href="logout.do">Logout</a></li>
			</ul>
		</div>
	</nav>

	<div class="container">
	<h2>Resolve Reimbursement</h2>
	<form action= "resolve.do" method= "post">
		<table class="table table-bordered">
			<tr>
				<th>Id</th>
				<th>Amount</th>
				<th>Description</th>
				<th>Status</th>
				<th>Date Submitted</th>
				<th>Date Resolved</th>
				<th>Resolved By</th>
				<th>Action</th>
			</tr>
			
			<c:forEach var="reimbursement" items="${reimbursements}">
			
				<tr>
					<td><c:out value="${reimbursement.getReimbursementId()}" /></td>
					<td><c:out value="${reimbursement.getAmount()}" /></td>
					<td><c:out value="${reimbursement.getDescription()}" /></td>
					<td><c:out value="${reimbursement.getStatus()}" /></td>
					<td><c:out value="${reimbursement.getOpenDate()}" /></td>
					<td><c:out value="${reimbursement.getCloseDate()}" /></td>
					<td><c:out value="${reimbursement.getManagerId()}" /></td>
					<td><button type="submit" name="approve" value="${reimbursement.getReimbursementId()}"> Approve </button>&nbsp;&nbsp;&nbsp;&nbsp; 
						<button type="submit" name="decline" value="${reimbursement.getReimbursementId()}"> Decline</button> </td>
				</tr>
			</c:forEach>
		</table>
		</form>
	</div>
</body>
</html>