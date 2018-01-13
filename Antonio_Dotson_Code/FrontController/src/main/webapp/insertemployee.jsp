<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%-- Directive scriplet to include JSTL core library --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
  <head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
	<link rel="stylesheet" href="resources/css/bootstrip_min.css" />
	<script src="https://use.fontawesome.com/d2f3608800.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>App-o-lis Manager Page</title>

    <!-- Bootstrap core CSS -->

  </head>
	<body class="home page-template-default page page-id-143 front menu-closed">
	<!--The entire page is in the container tag-->
	<div class="container-fluid">
		<div class="main">
			<div class="row">
			<div class="col-sm-4">
			
				<span class="pull-left" ><i class="fa fa-facebook"></i></span>
                <span class="pull-left"><i class="fa fa-google"></i></span>
				<span class="pull-left"><i class="fa fa-instagram"></i></span>
			   </div>
				<div class="col-sm-4">
					<h4 class="text-capitalize text-center">APP-O-LIS</h4>
				</div>
				<div class="col-sm-4">
				<span class="pull-right"><a href="upemployee.do">${ loggedCustomer.firstName } - Manager Page </a></span>
				
                
					</div>
					
                </div>
		</div>
    <div class="container">
      <header class="header clearfix">
        <nav>
          <ul class="nav nav-pills float-right">
            <li class="nav-item">
              <a class="nav-link active" href="manager.jsp">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="pendingrequest.do">Pending Request</a>
              <li>
              <li class="nav-link">
              <a class="nav-link" href="allrequest.do">All Request</a>
              </li>
            <li class="nav-item">
              <a class="nav-link" href="employee.do">View All Employee</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="insertemployee.do">Add Employee</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="logout.do">Logout</a>
            </li>
          </ul>
        </nav>
      </header>
<p> ${getServices } </p>
      <main role="main">
   
   <div class="alert alert-info">
    <strong>Success!</strong> Update was Successful
      </div>

        <div class="jumbotron">
          <h1 class="display-3">Insert New Employee</h1>
        </div>
        <div class="well">
        <form method="post" action="updateEmployee.do">
  <div class="form-group">
    <label for="last">Last Name</label>
    <input type="text" class="form-control" id="name"  name="lastname">
  
     <label for="first">First Name</label>
    <input type="text" class="form-control" name="firstname">
  
  <label for="title">Title</label>
    <input type="text" class="form-control" name="title">
  
  
    <label for="manager">ManagerID</label>
    <input type="text" class="form-control"  name="managerid">
  
  <label for="birthdate">Birth date</label>
    <input type="text" class="form-control" name="birthdate">
  
    <label for="exampleInputPassword1">Address</label>
    <input type="text" class="form-control"  name="address">
  
  <label for="exampleInputEmail1">City</label>
    <input type="text" class="form-control"  name="city">
  
    <label for="state">State</label>
    <input type="text" class="form-control" name="state">
 
  <label for="phone">Phone</label>
    <input type="text" class="form-control" name="phone">

    <label for="email">Email</label>
    <input type="email" class="form-control"  name="email">
   <br />
  <button type="submit" class="btn btn-default">Submit</button>
</form>
</div>
</div>
</main>
</div>
  <script>
  $(document).ready(function(){
	    $(".alert").hide();
	    var mystring = " ${ getServices }";
	       if (mystring == true) {
	    	   $(".alert").show();
	       } else if (mystring == " ") {
	    	   $(".alert").hide();
	       }  else if (mystring == false){
	    	 $(".alert ").show().html("<strong>Sorry!</strong> Update was not Successful!");
	       } else {
	    	   $(".alert").hide();
	       }
	    });
  </script>
 <footer>
            
    <div class="bot2_wrapper">
      <div class="container">
        &copy; 2017 APP-O-LIS All Rights Reserved.
      </div>
    </div>

    </footer>
			
	<script src="resources/js/core.min.js"></script>
	<script src="resources/js/style.js"></script>
			
  </body>
</html>	