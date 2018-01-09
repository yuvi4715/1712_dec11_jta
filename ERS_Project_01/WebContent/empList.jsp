<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of Employees</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-11">
				<div class="page-header">
					<h1>Employee List</h1>
				</div>
			</div>
			<div class="col-md-1" id="backDiv">
				<div class="page-header">
					<form action="UpdateInfo" method="get">
						<button href="#" class="btn btn-danger">Previous Page</button>
					</form>
				</div>
			</div>
		</div>
		
		<div class="row">
			<table class="table">
				<thead>
					<tr>
						<td>Employee ID</td>
						<td>First Name</td>
						<td>Last Name</td>
						<td>Email</td>
						<td>Role</td>
						<td>Title</td>
						<td>Reports To</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${empList }">
						<tr>
							<td>${item.emp_id}</td>
							<td>${item.emp_fname}</td>
							<td>${item.emp_lname}</td>
							<td>${item.emp_email}</td>
							<td>${item.emp_role}</td>
							<td>${item.emp_title}</td>
							<td>${item.emp_reportsTo}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>	
</body>
</html>