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
	      <a class="navbar-brand" href="ManagerHomepage.jsp">ERS</a>
	    </div>
	
	    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	      <ul class="nav navbar-nav">
	        <li><a href="ManagerHomepage.jsp"><span class="glyphicon glyphicon-home"></span>&emsp;Home</a></li>
	        <li class="active"><a href="#"><span class="glyphicon glyphicon-usd"></span>&emsp;Reimbursement Requests <span class="sr-only">(current)</span></a></li>
	        <li class="dropdown">
	          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><span class="glyphicon glyphicon-user"></span>&emsp;Profile <span class="caret"></span></a>
	          <ul class="dropdown-menu">
	            <li><a href="ManagerHomepage.jsp">View Profile</a></li>
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
	  	<p>
	  	  Use the tabs below to navigate the reimbursement requests.
	  	</p>
	  </div>
	  <div class="row">
  	    <ul class="nav nav-tabs">
	  	  <li id="manager-all" role="tab" class="active"><a data-toggle="tab" href="#all-requests">All Requests</a></li>
		  <li id="manager-all-pending" role="tab"><a data-toggle="tab" href="#pending">All Pending Requests</a></li>
		  <li id="manager-all-resolved" role="tab"><a data-toggle="tab" href="#resolved">All Resolved Requests</a></li>
		  <li id="manager-all-employees" role="tab"><a data-toggle="tab" href="#allemployees">All Employees</a></li>
		  <li role="tab"><a data-toggle="tab" href="#reqbyemployee">Search Requests By Employee</a></li>
		</ul>
		<div class="tab-content">
		  <div role="tabpanel" class="tab-pane active" id="all-requests">
		    <div class="panel panel-default">
			  <table class="table table-bordered table-striped table-hover">
				  <thead><tr>
				    <th class="col-md-1">Reimbursement Request No.</th>
				    <th class="col-md-1">Name</th>
				    <th class="col-md-2">Description</th>
				    <th class="col-md-1">Status</th>
				    <th class="col-md-1">Amount</th>
				    <th class="col-md-1">Submitted By</th>
				    <th class="col-md-1">Date Submitted</th>
				    <th class="col-md-1">Date Resolved</th>
				    <th class="col-md-1">Receipt</th>
				    <th class="col-md-2">Approve/Deny</th></tr>
				  </thead>
				  <tbody>
				    <c:forEach items="${requestScope.allRequests}" var="req">
				      <tr>
				        <td><c:out value="${req.reqID}"></c:out></td>
				        <td><c:out value="${req.reqTitle}"></c:out></td>
				        <td><c:out value="${req.description}"></c:out></td>
				        <td><c:out value="${req.status}"></c:out></td>
				        <td><c:out value="$ ${req.amount}"></c:out></td>
				        <td><c:out value="${requestScope.mgrMap.get(req.empID)}"></c:out></td>
				        <td><c:out value="${req.getDateSubmitted().toString().substring(0,19)}"></c:out></td>
				        <td><c:out value="${req.getDateResolved().toString().substring(0,19)}"></c:out></td>
				        <td><button class="btn btn-info">View Receipt</button></td>
				        <td><c:if test="${req.getStatus()=='Pending'}">
				          <button class="btn btn-success approve">Approve</button>&ensp;<button class="btn btn-danger deny">Deny</button>
				        </c:if></td>
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
				    <th class="col-md-1">Reimbursement Request No.</th>
				    <th class="col-md-1">Name</th>
				    <th class="col-md-3">Description</th>
				    <th class="col-md-1">Amount</th>
				    <th class="col-md-2">Submitted By</th>
				    <th class="col-md-1">Date Submitted</th>
				    <th class="col-md-1">Receipt</th>
				    <th class="col-md-2">Action</th></tr>
				  </thead>
				  <tbody>
				    <c:forEach items="${requestScope.pendingRequests}" var="req">
				      <tr>
				        <td><c:out value="${req.reqID}"></c:out></td>
				        <td><c:out value="${req.reqTitle}"></c:out></td>
				        <td><c:out value="${req.description}"></c:out></td>
				        <td><c:out value="$ ${req.amount}"></c:out></td>
				        <td><c:out value="${requestScope.mgrMap.get(req.empID)}"></c:out></td>
				        <td><c:out value="${req.getDateSubmitted().toString().substring(0,19)}"></c:out></td>
				        <td><button class="btn btn-info">View Receipt</button></td>
				        <td><button class="btn btn-success approve">Approve</button>&ensp;<button class="btn btn-danger deny">Deny</button></td>
				      </tr>
				    </c:forEach>
				  </tbody>
			  </table>
		    </div>
		  </div>
		  <div role="tabpanel" class="tab-pane" id="resolved">
		    <div class="panel panel-default">
			  <table class="table table-bordered table-striped table-hover">
				  <thead><tr>
				    <th class="col-md-1">Reimbursement Request No.</th>
				    <th class="col-md-1">Name</th>
				    <th class="col-md-2">Description</th>
				    <th class="col-md-1">Status</th>
				    <th class="col-md-1">Amount</th>
				    <th class="col-md-2">Submitted By</th>
				    <th class="col-md-1">Resolved By</th>
				    <th class="col-md-1">Date Submitted</th>
				    <th class="col-md-1">Date Resolved</th>
				    <th class="col-md-1">Receipt</th></tr>
				  </thead>
				  <tbody>
				    <c:forEach items="${requestScope.resolvedRequests}" var="req">
				      <tr>
				        <td><c:out value="${req.reqID}"></c:out></td>
				        <td><c:out value="${req.reqTitle}"></c:out></td>
				        <td><c:out value="${req.description}"></c:out></td>
				        <td><c:out value="${req.status}"></c:out></td>
				        <td><c:out value="$ ${req.amount}"></c:out></td>
				        <td><c:out value="${requestScope.mgrMap.get(req.empID)}"></c:out></td>
				        <td><c:out value="${requestScope.mgrMap.get(req.mgrID)}"></c:out></td>
				        <td><c:out value="${req.getDateSubmitted().toString().substring(0,19)}"></c:out></td>
				        <td><c:out value="${req.getDateResolved().toString().substring(0,19)}"></c:out></td>
				        <td><button class="btn btn-info">View Receipt</button></td>
				      </tr>
				    </c:forEach>
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
				  <c:forEach items="${requestScope.allEmployees}" var="employee">
				      <tr>
				        <td><c:out value="${employee.getId()}"></c:out></td>
				        <td><c:out value="${employee.getFirstname()}"></c:out></td>
				        <td><c:out value="${employee.getLastname()}"></c:out></td>
				      </tr>
				    </c:forEach>
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
		  	        <select name="empName" id="employeeID">
		  	          <c:forEach items="${requestScope.allEmployees}" var="employee">
		  	          	<c:if test="${employee.getIsManager()==false}">
		  	          	  <option value="${employee.getId()}">${employee.getFirstname()} ${employee.getLastname()}</option>
		  	          	</c:if>
		  	          </c:forEach>
		  	        </select>
			      </div>
			      <button id="searchReqByEmp" type="button" class="btn btn-default">Search</button>
			    </form>
			  </div>
			  <table class="table table-bordered table-striped table-hover">
				  <thead><tr>
				    <th class="col-md-1">Reimbursement Request No.</th>
				    <th class="col-md-1">Name</th>
				    <th class="col-md-2">Description</th>
				    <th class="col-md-1">Status</th>
				    <th class="col-md-1">Amount</th>
				    <th class="col-md-1">Resolved By</th>
				    <th class="col-md-2">Date Submitted</th>
				    <th class="col-md-1">Date Resolved</th>
				    <th class="col-md-1">Receipt</th>
				    <th class="col-md-1">Approve/Deny</th></tr>
				  </thead>
				  <tbody></tbody>
				</table>
			  </div>
		    </div> <!-- end panel -->
		</div><!-- end panel container -->
	  </div><!-- end row -->
    </section><!-- end container -->
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="js/script.js"></script>
  </body>
</html>