<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Manager Homepage</title>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<style>
		h1{
			background-color:lightgrey;
			padding: 15px;
			font-size:350%;
		}
		#helloDiv{
			padding-top:20px; 
		}
	</style>
</head>

<body>
	<jsp:scriptlet>
		request.getSession().setAttribute("previousPage", "managerPage.jsp");
	
		Integer empID = (Integer)request.getSession().getAttribute("employeeID");
		String fname = (String)request.getSession().getAttribute("employeeFirstName");
		String lname = (String)request.getSession().getAttribute("employeeLastName");
		String email = (String)request.getSession().getAttribute("employeeEmail");
		String role = (String)request.getSession().getAttribute("employeeRole");
		String title = (String)request.getSession().getAttribute("employeeTitle");
		Integer reportsTo = (Integer)request.getSession().getAttribute("employeeReportsTo");
		String user = (String)request.getSession().getAttribute("employeeUsername");
		String pass = (String)request.getSession().getAttribute("employeePassword");
	</jsp:scriptlet>

	<div class="container">
		<div class="row">
			<div class="col-md-11">
				<h1 align="center">Manager Homepage</h1>
			</div>
			<div class="col-md-1" id="helloDiv">
				<a id="logoutLink" class="btn btn-warning" href="login.jsp">Logout</a>
			</div>
		</div>

		<div class="row">
			<div class="col-md-12" id="helloDiv">
				<h3>Hello, <jsp:expression>user</jsp:expression></h3>
			</div>
		</div>

		<div class="navbar">
			<div class="navbar-header">
				<a class="navbar-brand"></a>
					<ul class="nav navbar-nav">
						<li><a class="navbar-brand" href="Employee">View All Employees</a></li>
						<li><a class="navbar-brand" href="register.jsp">Register An Employee</a></li>
						<li><a class="navbar-brand" href="AllReimbursements">View All Reimbursements</a></li>
						<li><a class="navbar-brand" href="NewReimbursements">Create Reimbursement</a></li>
						<li><a class="navbar-brand" href="OpenReimbursements">Pending Reimbursements</a></li>
						<li><a class="navbar-brand" href="ResolvedReimbursements">Resolved Reimbursements</a></li>
					</ul>
			</div>
		</div>
		
		<div class="row">
			<div class="col-md-12">
				<div class="${typeMessage }">
					<p>${message }</p>
				</div>
			</div>
		</div>
		
		<div class="content">
			<div class="col-md-12">
				<table id="empInfoTable" class="table table-bordered table-striped">
					<thead>
						<tr>
							<th>Employee ID</th>
							<th>First Name</th>
							<th>Last Name</th>
							<th>Email</th>
							<th>Username</th>
							<th>Role</th>
							<th>Title</th>
							<th>Reports To</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><jsp:expression>empID</jsp:expression></td>
							<td><jsp:expression>fname</jsp:expression></td>
							<td><jsp:expression>lname</jsp:expression></td>
							<td><jsp:expression>email</jsp:expression></td>
							<td><jsp:expression>user</jsp:expression></td>
							<td><jsp:expression>role</jsp:expression></td>
							<td><jsp:expression>title</jsp:expression></td>
							<td><jsp:expression>reportsTo</jsp:expression></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		
		<div class="row">
			<div class="col-md-12">
				<form action="UpdateInfo" method="post">
					<a type="submit" class="btn btn-primary" href="updateInfo.jsp">Update Information</a>
				</form>
			</div>
		</div>
		
	</div>
</body>
</html>