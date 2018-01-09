<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register Employee</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="page-header">
					<h1>Employee Register Form</h1>
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
					<!-- action must be configured in the Servlet -->
					<form action="Employee" method="post">
						<div class="form-group">
							<label for="emp_fName">First Name</label>
							<input type="text" id="emp_fName" name="emp_fName" class="form-control" required>
						</div>
						<div class="form-group">
							<label for="emp_lName">Last Name</label>
							<input type="text" id="emp_lName" name="emp_lName" class="form-control" required>
						</div>
						<div class="form-group">
							<label for="emp_email">Email</label>
							<input type="text" id="emp_email" name="emp_email" class="form-control" required>
						</div>
						<div class="form-group">
							<label for="emp_username">Username</label>
							<input type="text" id="emp_username" name="emp_username" class="form-control" required>
						</div>
						<div class="form-group">
							<label for="emp_password">Password</label>
							<input type="text" id="emp_password" name="emp_password" class="form-control" required>
						</div>
						<div class="form-group">
							<label for="emp_role">Role</label>
							<input type="text" id="emp_role" name="emp_role" class="form-control" required>
						</div>
						<div class="form-group">
							<label for="emp_title">Title</label>
							<select type="text" id="emp_title" name="emp_title" class="form-control" required>
								<option value="Employee">Employee</option>
								<option value="Manager">Manager</option>
							</select>
						</div>
						<div class="form-group">
							<label for="emp_reportsTo">Manager's ID Who You Will Reports To</label>
							<input type="number" id="emp_reportsTo" name="emp_reportsTo" class="form-control">
						</div>
						<div class="form-group">
							<input type="submit" value="Register" class="btn btn-primary"/>
							<input type="reset" value="Clear" class="btn btn-danger"/>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>