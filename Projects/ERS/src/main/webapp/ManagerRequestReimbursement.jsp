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
<title>Request Reimbursement</title>
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
							<li><a href="ManagerRequestReimbursement.jsp">Create Request</a></li>
							<li><a href="ManagerReimbursement.jsp">View Requests</a></li>
						</ul></li>
					<li><a href="#" onclick="loadEmployeeList()">View Employees</a></li>
					<li><a href="#" onclick="logout()">Logout</a></li>
				</ul>
			</div>
		</nav>
	<p>
		You are signed on as
		<c:out value="${sessionScope.loggedEmployee.username}"></c:out>
	</p>
	</header>
	<section class="container"> <script>
		function emptyReimbursementForm() {
			$("#a").val("");
			$("#t").val("");
			$("#d").val("");
		}
	</script>

	<form class="form-horizontal no-bottom-margin"
		id="requestReimbursement" action="RequestReimbursement" method="POST">
		<div class="form-group">
			<div class="form-group">
				<strong>Amount: </strong>
				<div>
					<p class="form-control-static"></p>
					<input type="number" class="form-control" name="amount" id="a"
						required>
				</div>
			</div>
			<div class="form-group">
				<strong>Title: </strong>
				<div>
					<p class="form-control-static"></p>
					<input type="text" class="form-control" name="title" id="t"
						required>
				</div>
			</div>
			<div class="form-group">
				<strong>Description: </strong>
				<div>
					<p class="form-control-static"></p>
					<input type="text" class="form-control" name="description" id="d">
				</div>
			</div>

			<div>
				<button id="request" type="submit" class="btn btn-success">Request</button>
				<button id="cancel" type="button" class="btn btn-warning"
					onclick="emptyReimbursementForm()">Clear</button>
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