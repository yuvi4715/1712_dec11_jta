<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
    <title>ERS Homepage</title>
  </head>
  <body>
    <header>
	  <nav class="navbar navbar-inverse">
	  <div class="container">
	    <div class="navbar-header">
	      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
	        <span class="sr-only">Toggle navigation</span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	      </button>
	      <a class="navbar-brand" href="#">ERS</a>
	    </div>
	
	    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	      <ul class="nav navbar-nav">
	        <li class="active"><a href="#"><span class="glyphicon glyphicon-home"></span>&emsp;Home</a></li>
	        <li><a href="EmployeeRequestView"><span class="glyphicon glyphicon-usd"></span>&emsp;Reimbursement Requests <span class="sr-only">(current)</span></a></li>
	        <li class="dropdown">
	          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><span class="glyphicon glyphicon-user"></span>&emsp;Profile <span class="caret"></span></a>
	          <ul class="dropdown-menu">
	            <li><a href="#">View Profile</a></li>
	            <li role="separator" class="divider"></li>
	            <li id="logout"><a href="Logout">Logout</a></li>
	          </ul>
	        </li>
	      </ul>
	      <p class="navbar-text navbar-right">Signed in as <c:out value="${sessionScope.user.username}"></c:out></p>
	    </div><!-- /.navbar-collapse -->
	  </div><!-- /.container-fluid -->
	</nav>
    </header>
	<section class="container">
		<div class="row">
		  <div class="page-header">
		    <h1>Expense Reimbursement System</h1>
		  </div>
		</div>
		<div class="row">
		    <h3>Welcome, <c:out value="${sessionScope.employee.firstname} ${sessionScope.employee.lastname}"></c:out></h3>
			<c:if test="${not empty requestScope.errMsg}">
		      <div class="alert alert-danger" id="jsp-errordiv">
	            <c:out value="${requestScope.errMsg}" />
	          </div>
	        </c:if>
	        <c:if test="${not empty requestScope.successMsg}">
		      <div class="alert alert-success" id="jsp-successdiv">
	            <c:out value="${requestScope.successMsg}" />
	          </div>
	        </c:if>
		</div>
		<div class="row">
		  <div class="col-sm-6 well">
		  	<h4>Profile Information</h4>
		    <form class="form-horizontal no-bottom-margin" id="emp-info-form" action="UpdateEmployeeInfo" method="POST">
		      <div class="form-group">
			    <label class="col-sm-4 control-label"><strong>First name: </strong></label>
			    <div class="col-sm-8">
			      <input type="text" class="form-control hidden" readonly>
			      <p class="form-control-static"><c:out value="${sessionScope.employee.firstname}"></c:out></p>
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="col-sm-4 control-label"><strong>Last name: </strong></label>
			    <div class="col-sm-8">
			      <input type="text" class="form-control hidden" readonly>
			      <p class="form-control-static"><c:out value="${sessionScope.employee.lastname}"></c:out></p>
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="col-sm-4 control-label"><strong>Username: </strong></label>
			    <div class="col-sm-8">
			      <input type="text" class="form-control hidden" readonly>
			      <p class="form-control-static"><c:out value="${sessionScope.user.username}"></c:out></p>
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="col-sm-4 control-label"><strong>Email: </strong></label>
			    <div class="col-sm-8">
			      <input type="text" class="form-control hidden" name="email">
			      <p class="form-control-static"><c:out value="${sessionScope.employee.email}"></c:out></p>
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="col-sm-4 control-label"><strong>Birth date: </strong></label>
			    <div class="col-sm-8">
			      <input type="text" class="form-control hidden" readonly>
			      <p class="form-control-static"><c:out value="${sessionScope.employee.birthdate}"></c:out></p>
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="col-sm-4 control-label"><strong>Phone number: </strong></label>
			    <div class="col-sm-8">
			      <input type="text" class="form-control hidden" name="phoneNumber">
			      <p class="form-control-static"><c:out value="${sessionScope.employee.phoneNumber}"></c:out></p>
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="col-sm-4 control-label"><strong>Address: </strong></label>
			    <div class="col-sm-8">
			      <input type="text" class="form-control hidden" name="address">
			      <p class="form-control-static"><c:out value="${sessionScope.employee.address}"></c:out></p>
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="col-sm-4 control-label"><strong>City: </strong></label>
			    <div class="col-sm-8">
			      <input type="text" class="form-control hidden" name="city">
			      <p class="form-control-static"><c:out value="${sessionScope.employee.city}"></c:out></p>
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="col-sm-4 control-label"><strong>State: </strong></label>
			    <div class="col-sm-8">
			      <input type="text" class="form-control hidden" name="state">
			      <p class="form-control-static"><c:out value="${sessionScope.employee.state}"></c:out></p>
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="col-sm-4 control-label"><strong>Country: </strong></label>
			    <div class="col-sm-8">
			      <input type="text" class="form-control hidden" name="country">
			      <p class="form-control-static"><c:out value="${sessionScope.employee.country}"></c:out></p>
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="col-sm-4 control-label"><strong>Zip code: </strong></label>
			    <div class="col-sm-8">
			      <input type="text" class="form-control hidden" name="zip">
			      <p class="form-control-static"><c:out value="${sessionScope.employee.zip}"></c:out></p>
			    </div>
			  </div>
			  <div class="col-sm-offset-4 col-sm-8">
			    <button id="edit-profile" type="button" class="btn btn-warning">Edit Profile</button>
			    <button id="save-profile" type="submit" class="btn btn-primary hideme">Save</button>
			    <button id="cancel-profile-update" type="button" class="btn btn-danger hideme">Cancel</button>
			  </div>
			</form>
		  </div>
		</div>
	</section>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="js/script.js"></script>
  </body>
</html>