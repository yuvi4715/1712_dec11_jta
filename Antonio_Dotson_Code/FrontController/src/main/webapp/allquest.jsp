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
<style>
.p300 {
padding-bottom= "300px";}
</style>
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
				<span class="pull-right"><a href="updatemanager.jsp">${ loggedCustomer.firstName } - Manager Page </a></span>
				
                
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
      
      <main role="main">
      <div class="p_150">
          &nbsp;
          </div>
        <div class="jumbotron">
          <h3 class="display-3">Viewing All request that are not pending for all employees</h3>
        </div>

        <div class="row">
          <div class="col-md-12">
           <table class="table table-striped">
       <thead>
       <tr>
	       <th>First</th><th>Last</th><th>Title</th><th>Record id</th><th>Description</th>
	       <th>Amount</th><th>Time</th><th>Manager-Id</th><th>Time date</th><th>Resolved_date</th>
       </thead>
       <tbody>
        <c:forEach items="${requestScope.all}" var="name">
       <tr>
       <td> <c:out value="${name.getLastname()}"></c:out></td>
       <td> <c:out value="${name.getFirstname()}"></c:out></td>
       <td> <c:out value="${name.getTitle()}"></c:out></td>
       <td> <c:out value="${name.getRid()}"></c:out></td>
       <td> <c:out value="${name.getDescription()}"></c:out></td>
       <td> <c:out value="${name.getAmount()}"></c:out></td>
       <td> <c:out value="${name.getTime()}"></c:out></td>
       <td> <c:out value="${name.getManagerid()}"></c:out></td>
       <td> <c:out value="${name.getTimedate()}"></c:out></td>
       <td> <c:out value="${name.getResolved_date()}"></c:out></td>
       </tr>
       </c:forEach>
       </tbody>
        </table>
          
      </div>
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
	
	