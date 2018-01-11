<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Login</title>
		<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	</head>
	<body>
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="page-header">
						<h1 align="center">Expense Reimbursement System</h1>
						<h2 align="center">Login Page</h2>
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
						<form action="Login" method="post">
							<div class="form-group">
								<label for="emp_User">Username</label>
								<input type="text" id="emp_User" name="emp_User" class="form-control" required>
							</div>
							<div class="form-group">
								<label for="emp_Pass">Password</label>
								<input type="password" id="emp_Pass" name="emp_Pass" class="form-control" required>
							</div>
							<div class="form-group">
								<input type="submit" value="Login" class="btn btn-primary"/>
								<input type="reset" value="Clear" class="btn btn-danger"/>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>