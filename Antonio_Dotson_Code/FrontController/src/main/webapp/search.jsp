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
					<h4 class="text-capitalize text-center">APP-O-LIS <a href="search.jsp"><i class="fa fa-search"></i></a></h4>
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
          <h1 class="display-3">Search</h1>
          <p class="lead">Search by employee id to view employee information</p>
          
        </div>
        <div id="results">
        <form method="post" action="getSearch.do">
        <div class="row">
        <div class="col-md-8">
          <div class="form-group">
    <label for="formGroupSearchInput">Search</label>
    <input type="number" name="eid" class="form-control" id="formGroupSearch" pattern="[0-9]{4}">
  </div>
  </div>
  <div class="col-md-4">
  <label for="mySearch"></label>
  <input type="submit" class="btn btn-success" value="search" />
  </div>
  </div>
  </form>
          <table class="table table-striped">
       <thead>
       <tr>
	       <th>First</th><th>Last</th><th>Title</th><th>ManagerID</th><th>Birthday</th>
	       <th>Address</th><th>City</th><th>State</th><th>Phone</th><th>Email</th>
       </thead>
       <tbody>
       <c:forEach items="${requestScope.EmployeeValue}" var="name">
       <tr>
       <td> <c:out value="${name.getLastName()}"></c:out></td>
       <td> <c:out value="${name.getFirstName()}"></c:out></td>
       <td> <c:out value="${name.getTitle()}"></c:out></td>
       <td> <c:out value="${name.getManagerid()}"></c:out></td>
       <td> <c:out value="${name.getBirthdate()}"></c:out></td>
       <td> <c:out value="${name.getAddress()}"></c:out></td>
       <td> <c:out value="${name.getCity()}"></c:out></td>
       <td> <c:out value="${name.getState()}"></c:out></td>
       <td> <c:out value="${name.getPhone()}"></c:out></td>
       <td> <c:out value="${name.getEmail()}"></c:out></td>
       </tr>
       </c:forEach>
       </tbody>
        </table>
     </div>
          <div class="p300">
          <p> &nbsp;</p>
          </div>
           
            </div>
      </div>
</main>
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
	
	