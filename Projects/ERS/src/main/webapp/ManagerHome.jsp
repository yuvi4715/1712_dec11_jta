<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"></link>
    <link rel="stylesheet" href="css/layout.css"></link>
    <title>Employee Homepage</title>
  </head>
  <body>
  <h2>Welcome to the ERS Homepage!</h2>
    <header>
	  <p class="navbar-text navbar-right">You are signed on as <c:out value="${sessionScope.loggedEmployee.username}"></c:out></p>
	  
    </header>
	<section class="container">
	
	<p><a href="EmployeeReimbursement.jsp">Reimbursement Requests</a></p>
	  <p><a href="Logout.jsp">Logout</a></p>
	  
	  
	  <div class="form-group">
			  <div class="form-group">
			    <label class="col-sm-4 control-label"><strong>Username: </strong></label>
			    <div class="col-sm-8">
			      <input type="text" class="form-control hidden" readonly>
			      <p class="form-control-static"><c:out value="${sessionScope.loggedEmployee.username}"></c:out></p>
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="col-sm-4 control-label"><strong>Password: </strong></label>
			    <div class="col-sm-8">
			      <input type="text" class="form-control hidden">
			      <p class="form-control-static"><c:out value="${sessionScope.loggedEmployee.password}"></c:out></p>
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="col-sm-4 control-label"><strong>First Name: </strong></label>
			    <div class="col-sm-8">
			      <input type="text" class="form-control hidden" name="firstName">
			      <p class="form-control-static"><c:out value="${sessionScope.loggedEmployee.firstName}"></c:out></p>
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="col-sm-4 control-label"><strong>Last Name: </strong></label>
			    <div class="col-sm-8">
			      <input type="text" class="form-control hidden" name="lastName">
			      <p class="form-control-static"><c:out value="${sessionScope.loggedEmployee.lastName}"></c:out></p>
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="col-sm-4 control-label"><strong>Email: </strong></label>
			    <div class="col-sm-8">
			      <input type="text" class="form-control hidden" name="email">
			      <p class="form-control-static"><c:out value="${sessionScope.loggedEmployee.email}"></c:out></p>
			    </div>
			  </div>
			  <div class="col-sm-offset-4 col-sm-8">
			    <button id="edit" type="button" class="btn btn-warning">Edit Profile</button>
			    <button id="save" type="submit" class="btn btn-primary hideme">Save</button>
			    <button id="cancel" type="button" class="btn btn-danger hideme">Cancel</button>
			  </div>
			  
			  
	</section>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="resources/js/script.js"></script>
  </body>
</html>