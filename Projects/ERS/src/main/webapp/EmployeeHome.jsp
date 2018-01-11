<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"></link>
<link rel="stylesheet" href="css/layout.css"></link>
<title>Employee Homepage</title>
</head>
<body>
	<header>
		<nav class="navbar navbar-default">
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
		<h2>Welcome to the Employee Homepage!</h2>
		<p>
			You are signed on as
			<c:out value="${sessionScope.loggedEmployee.username}"></c:out>
		</p>

		<script>
			function emptyInfoForm() {
				$(".form-control").val("Enter new info");
			}
		</script>

	</header>
	<section class="container">
				
			
		<form class="form-horizontal no-bottom-margin" id="updateInfoForm"
			action="UpdateInfo" method="POST">
			<div class="form-group">
				<label class="col-sm-4 control-label"><strong>Username:
				</strong></label>
				<div class="col-sm-8">
					<p class="form-control-static">
						<c:out value="${sessionScope.loggedEmployee.username}"></c:out>
					</p>
					<input type="text" class="form-control hidden" name="username"
						readonly>

				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label"><strong>Password:
				</strong></label>
				<div class="col-sm-8">
					<p class="form-control-static">
						<c:out value="${sessionScope.loggedEmployee.password}"></c:out>
					</p>
					<input type="text" class="form-control" name="password"
						value="Enter new info">

				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label"><strong>First
						Name: </strong></label>
				<div class="col-sm-8">
					<p class="form-control-static">
						<c:out value="${sessionScope.loggedEmployee.firstName}"></c:out>
					</p>
					<input type="text" class="form-control" name="firstName"
						value="Enter new info">

				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label"><strong>Last
						Name: </strong></label>
				<div class="col-sm-8">
					<p class="form-control-static">
						<c:out value="${sessionScope.loggedEmployee.lastName}"></c:out>
					</p>
					<input type="text" class="form-control" name="lastName"
						value="Enter new info">

				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label"><strong>Email:
				</strong></label>
				<div class="col-sm-8">
					<p class="form-control-static">
						<c:out value="${sessionScope.loggedEmployee.email}"></c:out>
					</p>
					<input type="text" class="form-control" name="email"
						value="Enter new info">

				</div>
			</div>
			<div>
				<button id="save" type="submit" class="btn btn-success">Save</button>
				<button id="clear" type="button" class="btn btn-warning"
					onclick="emptyInfoForm()">Clear</button>
			</div>
			</div>
		</form>


	</section>
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="resources/js/script.js"></script>
</body>
</html>