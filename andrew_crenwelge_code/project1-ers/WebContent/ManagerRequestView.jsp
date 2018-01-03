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
    <link rel="stylesheet" href="css/layout.css"></link>
    <title>ERS - Reimbursement Requests</title>
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
	      <a class="navbar-brand" href="ManagerHomepage.jsp">ERS</a>
	    </div>
	
	    <!-- Collect the nav links, forms, and other content for toggling -->
	    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	      <ul class="nav navbar-nav">
	        <li><a href="ManagerHomepage.jsp">Home</a></li>
	        <li class="active"><a href="#">Reimbursement Requests <span class="sr-only">(current)</span></a></li>
	        <li class="dropdown">
	          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Profile <span class="caret"></span></a>
	          <ul class="dropdown-menu">
	            <li><a href="ManagerHomepage.jsp">View Profile</a></li>
	            <li role="separator" class="divider"></li>
	            <li id="logout"><a href="Logout">Logout</a></li>
	          </ul>
	        </li>
	      </ul>
	    </div><!-- /.navbar-collapse -->
	  </div><!-- /.container-fluid -->
	  </nav>
    </header>
  	<section class="container">
	  	<div class="page-header">
	  	  <h1>Expense Reimbursement System</h1>
	  	</div>
	  	<p>
	  	  Use the tabs below to navigate the reimbursement requests.
	  	</p>
	  	<ul class="nav nav-tabs">
	  	  <li id="manager-all" role="tab" class="active"><a data-toggle="tab" href="#allrequests">All Requests</a></li>
		  <li id="manager-all-pending" role="tab"><a data-toggle="tab" href="#pending">All Pending Requests</a></li>
		  <li id="manager-all-resolved" role="tab"><a data-toggle="tab" href="#resolved">All Resolved Requests</a></li>
		  <li id="manager-all-employees" role="tab"><a data-toggle="tab" href="#allemployees">All Employees</a></li>
		  <li role="tab"><a data-toggle="tab" href="#reqbyemployee">Search Requests By Employee</a></li>
		</ul>
		<div class="tab-content">
		  <div role="tabpanel" class="tab-pane active" id="allrequests">
		    <div class="panel panel-default">
			  <table class="table table-bordered table-striped table-hover">
				  <thead><tr>
				    <th>Reimbursement Request No.</th>
				    <th>Title</th>
				    <th>Description</th>
				    <th>Amount</th>
				    <th>Submitted By</th>
				    <th>Date Submitted</th>
				    <th>Receipt</th></tr>
				  </thead>
				  <tbody>
				    <c:forEach items="${param.allRequests}" var="req">
				      <tr>
				        <td><c:out value="${req.reqID}"></c:out></td>
				        <td><c:out value="${req.title}"></c:out></td>
				        <td><c:out value="${req.description}"></c:out></td>
				        <td><c:out value="${req.amount}"></c:out></td>
				        <td><c:out value="${req.empName}"></c:out></td>
				        <td><c:out value="${req.dateSubmitted}"></c:out></td>
				        <td><button class="btn btn-info">View Receipt</button></td>
				      </tr>
				    </c:forEach>
				  </tbody>
			  </table>
		    </div>
		  </div>
		  <div role="tabpanel" class="tab-pane" id="pending">
		    <div class="panel panel-default">
			  <table class="table table-bordered table-striped table-hover">
				  <thead><tr>
				    <th>Reimbursement Request No.</th>
				    <th>Title</th>
				    <th>Description</th>
				    <th>Amount</th>
				    <th>Submitted By</th>
				    <th>Date Submitted</th>
				    <th>Receipt</th></tr>
				  </thead>
				  <tbody>
				    <tr>
				      <td>Test</td>
				      <td>Test</td>
				      <td>Test</td>
				      <td>Test</td>
				      <td>Test</td>
				      <td>Test</td>
				      <td><button class="btn btn-info">View Receipt</button></td>
				    </tr>
				  </tbody>
			  </table>
		    </div>
		  </div>
		  <div role="tabpanel" class="tab-pane" id="resolved">
		    <div class="panel panel-default">
			  <table class="table table-bordered table-striped table-hover">
				  <thead><tr>
				    <th>Reimbursement Request No.</th>
				    <th>Title</th>
				    <th>Description</th>
				    <th>Status</th>
				    <th>Amount</th>
				    <th>Submitted By</th>
				    <th>Resolved By</th>
				    <th>Date Submitted</th>
				    <th>Date Resolved</th>
				    <th>Receipt</th></tr>
				  </thead>
				  <tbody>
				    <tr>
				      <td>Test</td>
				      <td>Test</td>
				      <td>Test</td>
				      <td>Test</td>
				      <td>Test</td>
				      <td>Test</td>
				      <td>Test</td>
				      <td>Test</td>
				      <td>Test</td>
				      <td><button class="btn btn-info">View Receipt</button></td>
				    </tr>
				  </tbody>
			  </table>
			</div>
		  </div>
		  <div role="tabpanel" class="tab-pane" id="allemployees">
		    <div class="panel panel-default">
			  <table class="table table-bordered table-striped table-hover">
				<thead><tr>
				  <th>Employee ID No.</th>
				  <th>First Name</th>
				  <th>Last Name</th>
				</thead>
				<tbody>
				  <tr>
				    <td>Test</td>
				    <td>Test</td>
				    <td>Test</td>
				  </tr>
				</tbody>
			  </table>
			</div>
		  </div>
		  <div role="tabpanel" class="tab-pane" id="reqbyemployee">
			<div class="panel panel-default">
			  <div class="panel-body">
			    <form class="form-inline">
			      <div class="form-group">
			        <!-- Search by employee first and last name -->
			        <label>Search Requests By Employee:</label>
		  	        <input id="empName" type="text" name="empName"/>
			      </div>
			      <button id="searchReqByEmp" type="submit" class="btn btn-default">Search</button>
			    </form>
			  </div>
			  <table class="table table-bordered table-striped table-hover">
				  <thead><tr>
				    <th>Employee</th>
				    <th>Reimbursement Request No.</th>
				    <th>Status</th>
				    <th>Amount</th>
				    <th>Resolved By</th>
				    <th>Date Submitted</th>
				    <th>Date Resolved</th>
				    <th>Receipt</th></tr>
				  </thead>
				  <tbody>
				    <tr>
				      <td>Test</td>
				      <td>Test</td>
				      <td>Test</td>
				      <td>Test</td>
				      <td>Test</td>
				      <td>Test</td>
				      <td>Test</td>
				      <td><button class="btn btn-info">View Receipt</button></td>
				    </tr>
				  </tbody>
				</table>
			</div>
		  </div>
		</div>
    </section>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  </body>
</html>