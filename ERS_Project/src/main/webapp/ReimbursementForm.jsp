<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Reimbursement Form</title>
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
				<li class="active"><a href="new_page.do">Reimbursement Form</a></li>
				<li><a href="history.do">Reimbursement History</a></li>
				<c:if test="${loggedEmployee.getTitle() eq 'Manager' }">
					<li><a href="resolve_page.do">Resolve Reimbursements</a></li>
				</c:if>
				<li><a href="logout.do">Logout</a></li>
			</ul>
		</div>
	</nav>

	<div class="container">
		<h2>Reimbursement Form</h2>
		<form action="new.do" method="post">
			<table class="table table-bordered">
				<tr>
					<td>Amount</td>
					<td><input type="text" name="amount" placeholder="Amount" /></td>
				</tr>
				<tr>
					<td>Description</td>
					<td><input type="text" name="description"
						placeholder="Description" /></td>
				</tr>
			</table>
			<button type="submit">Submit</button>
		</form>
	</div>

</body>
</html>