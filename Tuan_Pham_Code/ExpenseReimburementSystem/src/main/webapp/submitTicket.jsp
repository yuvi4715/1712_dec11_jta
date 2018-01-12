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
<form id="update" name="update" method="POST" action="/ExpenseReimburementSystem/submit.do"> 
	<div>
		<p class="text-center">Submit a Reimbursement Request</p>
	</div>
	<div class="well">
	<div>
			<div class="form-group" >
				<label for="category"> Category <input type="text" name="category" class="form-control" />
				</label> 
				<label for="total"> Total <input type="text" name="total" class="form-control" />
				</label>
				<label for="desc"> Description <input type="text" name="description" class="form-control" />
				</label>
			</div>
	
	</div>
	<br>
		<input name="update" id="update" class="btn btn-primary" type="submit" value="Submit"></input>
	</div>
</form>
	
</body>
</html>