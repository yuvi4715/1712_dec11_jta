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

      <main role="main">

        <div class="jumbotron">
          <h1 class="display-3">Update Your Information</h1>
        </div>
        <div id="#results"></div>
        <div class="well">
        <form method="POST" action="updateemployee.do">
  <div class="form-group">
    <label for="last">Last Name</label>
    <input type="text" class="form-control" id="name"  value="${loggedCustomer.lastName}" name="lastname">
  </div>
     <label for="first">First Name</label>
    <input type="text" class="form-control" value="${loggedCustomer.firstName}" name="firstname">
  <label for="title">Title</label>
    <input type="text" class="form-control" value="${loggedCustomer.title}" name="title">
  
    <label for="exampleInputPassword1">Address</label>
    <input type="text" class="form-control" value="${loggedCustomer.address}" name="address">
  
  
  <label for="exampleInputEmail1">City</label>
    <input type="text" class="form-control" value="${loggedCustomer.city}"name="city">
  
  
    <label for="state">State</label>
    <input type="text" class="form-control" value="${loggedCustomer.state}" name="state">
  
 
  <label for="phone">Phone</label>
    <input type="text" class="form-control" value="${loggedCustomer.phone}" name="phone">
  
    <label for="email">Email</label>
    <input type="email" class="form-control" value="${loggedCustomer.email}" name="email">
    <input type="hidden" value ="${loggedCustomer.eid}" name ="eid" />
  <br/>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>
        
        </div>

      <script>
      $(document).ready(function(){
      var s ='${getServices}';
      if (s == true) {
      $("#results").html("<div class='alert alert-success'>Update was Successful!!</div>");
      $(form).clear();
       } else if (s == false) {
      $("#results").html("<div class='alert alert-danger'>Update was Failed!!</div>"); 
       }
      });
      </script> 
</main>
</div>
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