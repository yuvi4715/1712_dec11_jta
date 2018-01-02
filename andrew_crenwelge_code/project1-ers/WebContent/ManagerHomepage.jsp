<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <!-- Bootstrap -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"></link>
    <title>ERS Homepage</title>
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>
    <header>
	  <nav class="navbar navbar-default">
	  <div class="container">
	    <!-- Brand and toggle get grouped for better mobile display -->
	    <div class="navbar-header">
	      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
	        <span class="sr-only">Toggle navigation</span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	      </button>
	      <a class="navbar-brand" href="#">ERS</a>
	    </div>
	
	    <!-- Collect the nav links, forms, and other content for toggling -->
	    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	      <ul class="nav navbar-nav">
	        <li class="active"><a href="#">Home</a></li>
	        <li><a href="ManagerRequestView.jsp">Reimbursement Requests <span class="sr-only">(current)</span></a></li>
	        <li class="dropdown">
	          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Profile <span class="caret"></span></a>
	          <ul class="dropdown-menu">
	            <li><a href="#">View Profile</a></li>
	            <li role="separator" class="divider"></li>
	            <li id="logout"><a href="/Logout">Logout</a></li>
	          </ul>
	        </li>
	      </ul>
	    </div><!-- /.navbar-collapse -->
	  </div><!-- /.container-fluid -->
	</nav>
    </header>
	<section class="container">
		<!-- EMPLOYEE SHOULD BE ABLE TO LOGOUT FROM HERE AS WELL AS VIEW/UPDATE THEIR INFO -->
		<div class="page-header">
		  <h1>Expense Reimbursement System</h1>
		</div>
		<h2>Welcome, <c:out value="${sessionScope.employee.firstname} ${sessionScope.employee.lastname}"></c:out></h2>
		<div class="row">
		  <!-- EMPLOYEE INFO HERE -->
		  <div class="col-sm-4 well">
			<ul class="list-unstyled">
			  <li>First name: <c:out value="${sessionScope.employee.firstname}"></c:out></li>
			  <li>Last name: <c:out value="${sessionScope.employee.lastname}"></c:out></li>
			  <li>Username: <c:out value="${sessionScope.employee.username}"></c:out></li>
			  <li>Email: <c:out value="${sessionScope.employee.email}"></c:out></li>
			  <li>Birth date: <c:out value="${sessionScope.employee.birthdate}"></c:out></li>
			  <li>Phone number: <c:out value="${sessionScope.employee.phoneNumber}"></c:out></li>
			  <li>Address: <c:out value="${sessionScope.employee.address}"></c:out></li>
			  <li>City: <c:out value="${sessionScope.employee.city}"></c:out></li>
			  <li>State: <c:out value="${sessionScope.employee.state}"></c:out></li>
			  <li>Country: <c:out value="${sessionScope.employee.country}"></c:out></li>
			  <li>Zip code: <c:out value="${sessionScope.employee.zip}"></c:out></li>
			</ul>
			<button type="button" class="btn btn-warning">Edit Profile</button>
			<button type="submit" class="btn btn-primary">Save</button>
		  </div>
		</div>
		<div>Show info for manager here if user is a manager?</div>
		<div>
		  <!-- LOGOUT HERE -->
		  <button type="submit" class="btn btn-danger">Logout</button>
		</div>
	</section>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  </body>
</html>