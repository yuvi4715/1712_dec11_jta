<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>New Reimbursement Page</title>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
</head>
<body>
	<jsp:scriptlet>
	</jsp:scriptlet>

	<div class="container">
		<div class="row">
			<div class="col-md-11">
				<div class="page-header">
					<h1>New Register Form</h1>
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
		
		<!-- Dialog Box To Display 'Success' or 'Fail' -->
		<div class="row">
			<div class="col-md-12">
				<div id="typeMessageID" class="${typeMessage }">
					<p id="messageID">${message }</p>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="col-md-12">
				<div class="page-header">
					<!-- action must be configured in the Servlet -->
					<form action="NewReimbursements" method="post">
						<div class="form-group">
							<label for="empAmount">Amount</label>
							<input type="number" step="0.01" id="empAmount" name="empAmount" class="form-control" required>
						</div>
						<div class="form-group">
							<label for="rDesc">Reimbursement Description</label>
							<input type="text" id="rDesc" name="rDesc" class="form-control">
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