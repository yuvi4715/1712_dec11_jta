<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Update Employee Info</title>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<style>
		#backDiv{
			padding-top:20px;
		}
	</style>
	<script src="https://code.jquery.com/jquery-3.2.1.js" type="text/javascript"></script>
</head>
<body>
	<jsp:scriptlet>
		String prevPage = (String)request.getSession().getAttribute("previousPage");
	
		request.setAttribute("email", (String)request.getSession().getAttribute("employeeEmail"));
		request.setAttribute("user", (String)request.getSession().getAttribute("employeeUsername"));
		request.setAttribute("role", (String)request.getSession().getAttribute("employeeRole"));
		request.setAttribute("reportsTo", (Integer)request.getSession().getAttribute("employeeReportsTo"));
	</jsp:scriptlet>

	<div class="container">
		<div class="row">
			<div class="col-md-11">
				<div class="page-header">
					<h1>Update Employee Information Form</h1>
				</div>
			</div>
			<div class="col-md-1" id="backDiv">
				<div class="page-header">
					<form action="UpdateInfo" method="get">
						<button class="btn btn-danger">Previous Page</button>
					</form>
				</div>
			</div>
		</div>
		
		<!-- Dialog Box To Display 'Success' or 'Fail' -->
		<div class="row">
			<div class="col-md-12">
				<div class="${typeMessage }">
					<p>${message }</p>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="col-md-12">
				<div class="page-header">
					<div align="center">
						<h4>To Edit Your Information</h4>
						<h4>Enter Password OR New Passwords Must Match</h4>
					</div>
					<!-- action must be configured in the Servlet -->
					<form action="UpdateInfo" method="post">
						<div class="form-group">
							<label for="emp_email">Email</label>
							<input type="text" id="emp_email" name="emp_email" value=${email } class="form-control" required>
						</div>
						<div class="form-group">
							<label for="emp_username">Username</label>
							<input type="text" id="emp_username" name="emp_username" value=${user } class="form-control" required>
						</div>
						<div class="form-group">
							<label for="emp_password">Password</label>
							<input type="text" id="emp_password" name="emp_password" class="form-control" required>
						</div>
						<div class="form-group">
							<label for="emp_confirmedPassword">Confirm Password (Passwords MUST match)</label>
							<input type="text" id="emp_confirmedPassword" name="emp_confirmedPassword" class="form-control" required>
						</div>
						<div class="form-group">
							<label for="emp_role">Role</label>
							<input type="text" id="emp_role" name="emp_role" value=${role } class="form-control" required>
						</div>
						<div class="form-group">
							<label for="emp_reportsTo">Manager's ID Who You Will Reports To</label>
							<input type="number" id="emp_reportsTo" name="emp_reportsTo" value=${reportsTo } class="form-control">
						</div>
						<div class="form-group">
							<input type="submit" value="Confirm" class="btn btn-primary"/>
							<input type="reset" value="Clear" class="btn btn-danger"/>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>