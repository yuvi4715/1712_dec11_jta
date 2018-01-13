<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<title>User Registration</title>
</head>
<body>
<form id="update" name="update" method="POST" action="/ExpenseReimburementSystem/update.do"> 
	<div>
		<p class="text-center">Update User Information</p>
	</div>
	<div class="well">

	<div>

			<div class="form-group" >

				</label> 
				<label for="fname"> First Name <input type="text" name="fName" value="${loggedEmployee.firstName}" class="form-control" />
				</label> 
				<label for="lname"> Last Name <input type="text" name="lName" value="${loggedEmployee.lastName}" class="form-control" />
				</label>
			</div>
	
	</div>
	
	<div>
		

			<div class="form-group" >
				<label for="id"><input type="hidden" name="id" value="${loggedEmployee.id}" class="form-control" />
				</label> 
				<label for="username"><input type="hidden" name="username" value="${loggedEmployee.username}" class="form-control" />
				</label> 
				<label for="password"><input type="hidden" name="password" value="${loggedEmployee.password}" class="form-control" />
				<label for="email"> Email Address <input type="text" name="email" value="${loggedEmployee.email}" class="form-control" />
				</label> 
			</div>
	</div>	
	
	<div>
	
			<div class="form-group" >
				<label for="address"> Address <input type="text" name="address" value="${loggedEmployee.address}" class="form-control" />
				</label> 
				<label for="city"> City <input type="text" name="city" value="${loggedEmployee.city}" class="form-control" />
				</label>
				<label for="state"> State <input type="text" name="state" value="${loggedEmployee.state}" class="form-control" />
				</label> 
				<label for="zip"> Zip <input type="text" name="zip" value="${loggedEmployee.zip}" class="form-control" />
				</label> 
			</div>

	</div>	
	
	<div>
			<div class="form-group" >
				<label for="phone"> Phone Number <input type="text" name="phone" value="${loggedEmployee.phone}" class="form-control" />
				</label> 
			</div>
	</div>

	<br>
		<input name="update" id="update" class="btn btn-primary" type="submit" value="Update"></input>
	</div>
</form>
	
</body>
</html>