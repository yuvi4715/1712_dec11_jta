<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of Reimbursements</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-11">
				<div class="page-header">
					<h1>Reimbursement List</h1>
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
			<div class="col-md-11">
				<div class="page-header">
					<div class = "form-group">	
						<label for="emp_title">Employee IDs</label>
						<input type="text" id="emp_title" name="emp_title" class="form-control" required>
					</div>
				</div>
			</div>	
		</div>
		
		<div class="row">
			<table class="table">
				<thead>
					<tr>
						<td>Created By</td>
						<td>Reimbursement ID</td>
						<td>Amount</td>
						<td>Status</td>
						<td>Start Time</td>
						<td>Description</td>
						<td>Approve/Deny</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${openList }">
						<tr>
							<td>${item.createdBy}</td>
							<td>${item.reimbursementID}</td>
							<td>${item.amount}</td>
							<td>${item.status}</td>
							<td>${item.startTime}</td>
							<td>${item.desc}</td>
							<td>
								<input type="submit" value="APPROVE" class="btn btn-primary"/>
								<input type="submit" value="DENY" class="btn btn-danger"/>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>	
</body>
</html>