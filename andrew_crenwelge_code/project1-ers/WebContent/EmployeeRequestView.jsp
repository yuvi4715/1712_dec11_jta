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
    <title>ERS - Reimbursement Requests</title>
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
	      <a class="navbar-brand" href="EmployeeHomepage.jsp">ERS</a>
	    </div>
	
	    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	      <ul class="nav navbar-nav">
	        <li><a href="EmployeeHomepage.jsp"><span class="glyphicon glyphicon-home"></span>&emsp;Home</a></li>
	        <li class="active"><a href="#"><span class="glyphicon glyphicon-usd"></span>&emsp;Reimbursement Requests <span class="sr-only">(current)</span></a></li>
	        <li class="dropdown">
	          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><span class="glyphicon glyphicon-user"></span>&emsp;Profile <span class="caret"></span></a>
	          <ul class="dropdown-menu">
	            <li><a href="EmployeeHomepage.jsp">View Profile</a></li>
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
  	<section  class="container">
  	    <div class="row">
  	        <div class="page-header">
		  	  <h1>Expense Reimbursement System</h1>
		  	</div>
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
		    <div class="alert alert-danger hideme" id="errordiv"></div>
		    <div class="alert alert-success hideme" id="successdiv"></div>
  	    </div>
	  	<div class="row" style="margin-bottom: 15px">
	  	  <button id="request-dropdown" type="button" class="btn btn-primary">Add New Reimbursement Request</button>
	  	</div>
		<div class="row hideme" id="dropme">
		  <div class="col-sm-6 well">
		  <div>
		    <button id="closenewreq" type="button" class="close" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		  </div>
		  <form style="padding-top: 20px;margin-top:10px" method="POST" action="SubmitRequest" class="form-horizontal">
		  	<div class="form-group">
		  	  <label for="name" class="control-label col-sm-3">Request Name</label>
		  	  <div class="col-sm-9">
		  	    <input name="title" type="text" class="form-control" required/>
		  	  </div>
		  	</div>
		  	<div class="form-group">
		  	  <label for="amount" class="control-label col-sm-3">Amount</label>
		  	  <div class="col-sm-9">
		  	    <input name="amount" type="number" min="0.01" max="1000000" step="0.01" class="form-control" required/>
		  	  </div>
		  	</div>
		  	<div class="form-group">
		  	  <label for="description" class="control-label col-sm-3">Description</label>
		  	  <div class="col-sm-9">
		  	    <textarea name="description" class="form-control"></textarea>
		  	  </div>
		  	</div>
		  	<div class="form-group">
		  	  <label for="imagefile" class="control-label col-sm-3">Upload Receipt Picture</label>
		  	  <div class="col-sm-9">
		  	    <input name="imagefile" type="file" class="form-control"/>
		  	  </div>
		  	</div>
		    <button type="submit" class="btn btn-default">Submit Request</button>
		  </form>
		  </div>
		</div>
		
		<div class="row">
		  <p>
		    Use the tabs below to navigate your reimbursement requests.
		  </p>
		</div>
		<div class="row">
			<ul class="nav nav-tabs">
			  <li id="employee-all" role="tab" class="active"><a data-toggle="tab" href="#all-requests">All Requests</a></li>
			  <li id="employee-pending" role="tab"><a data-toggle="tab" href="#pending-requests">Pending Requests</a></li>
			  <li id="employee-resolved" role="tab"><a data-toggle="tab" href="#resolved-requests">Resolved Requests</a></li>
			</ul>
			<div class="tab-content">
		     <div role="tabpanel" class="tab-pane active" id="all-requests">
			   <table class="table table-bordered table-striped table-hover">
				  <thead><tr>
				    <th class="col-md-1">Reimbursement Request No.</th>
				    <th class="col-md-1">Name</th>
				    <th class="col-md-3">Description</th>
				    <th class="col-md-1">Status</th>
				    <th class="col-md-1">Amount</th>
				    <th class="col-md-1">Resolved By</th>
				    <th class="col-md-2">Date Submitted</th>
				    <th class="col-md-2">Date Resolved</th>
				  </thead>
				  <tbody>
				      <c:forEach items="${requestScope.allRequests}" var="req">
				        <tr>
				        <td><c:out value="${req.getReqID()}"></c:out></td>
				        <td><c:out value="${req.getReqTitle()}"></c:out></td>
				        <td><c:out value="${req.getDescription()}"></c:out></td>
				        <td><c:out value="${req.getStatus()}"></c:out></td>
				        <td><c:out value="$ ${req.getAmount()}"></c:out></td>
				        <td><c:out value="${requestScope.mgrMap.get(req.getMgrID())}"></c:out></td>
				        <td><c:out value="${req.getDateSubmitted().toString().substring(0,19)}"></c:out></td>
				        <td><c:out value="${req.getDateResolved().toString().substring(0,19)}"></c:out></td>
				        </tr>
				      </c:forEach>
				  </tbody>
			  </table>
		  	</div>
		     <div role="tabpanel" class="tab-pane" id="pending-requests">
			  <table class="table table-bordered table-striped table-hover">
				  <thead><tr>
				    <th>Reimbursement Request No.</th>
				    <th>Name</th>
				    <th>Description</th>
				    <th>Amount</th>
				    <th>Date Submitted</th></tr>
				  </thead>
				  <tbody>
				    <tr></tr>
				  </tbody>
			  </table>
		  </div>
		     <div role="tabpanel" class="tab-pane" id="resolved-requests">
			  <table class="table table-bordered table-striped table-hover">
				  <thead><tr>
				    <th>Reimbursement Request No.</th>
				    <th>Name</th>
				    <th>Description</th>
				    <th>Status</th>
				    <th>Amount</th>
				    <th>Resolved By</th>
				    <th>Date Submitted</th>
				    <th>Date Resolved</th></tr>
				  </thead>
				  <tbody>
				    <tr></tr>
				  </tbody>
			  </table>
		  </div>
	        </div><!-- end tab content -->
		</div><!-- end row -->
	</section>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="js/script.js"></script>
  </body>
</html>