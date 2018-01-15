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
          <h1 class="display-3">Reimbursement Application</h1>
          <p class="lead">This application allows you to view all reimbursement request. You will be able to approve and deny request.</p>
          <p>All new request will show as pending</p><p> Please click on the buttons below to get started</p>
          
        </div>
        <div id="results">
        <div class="row">
          <a href="updatestates.do" id="updateME" class="btn btn-primary">Review Pending Request</a>
          </div>
           <table class="table table-striped">
       <thead>
       <tr>
	       <th>First</th><th>Last</th><th>Title</th><th>Record id</th><th>Description</th>
	       <th>Amount</th><th>Time</th><th>Manager-Id</th><th>Time date</th><th>Resolved_date</th>
	       </tr>
       </thead>
       <tbody>
        <c:forEach items="${requestScope.Win}" var="seq"><tr>
       <td> <c:out value="${seq.getLastname()}"></c:out></td>
       <td> <c:out value="${seq.getFirstname()}"></c:out></td>
       <td> <c:out value="${seq.getTitle()}"></c:out></td>
       <td> <c:out value="${seq.getRid()}"></c:out></td>
       <td> <c:out value="${seq.getDescription()}"></c:out></td>
       <td> <c:out value="${seq.getAmount()}"></c:out></td>
       <td> <c:out value="${seq.getTime()}"></c:out></td>
       <td> <c:out value="${seq.getManagerid()}"></c:out></td>
       <td> <c:out value="${seq.getTimedate()}"></c:out></td>
       <td> <c:out value="${seq.getResolved_date()}"></c:out></td>
       <td> <a class='btn btn-success' href='updateassucess.do?success=${seq.getRid()}'>Approved</a></td>
       <td> <a class='btn btn-danger' href= 'updateadeny.do?deny=${seq.getRid()}'>Deny</a></td>
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
    <script>
    <script>
    $( document ).ready(function() {
   $("#results").hide();
   $("#updateME").click(function() {
   $("#results").toggle();
   });
   });
   </script>

   
    </footer>
	<script>
	
	
	</script>
	<script src="resources/js/core.min.js"></script>
	<script src="resources/js/style.js"></script>
		
  </body>
</html>
	
	