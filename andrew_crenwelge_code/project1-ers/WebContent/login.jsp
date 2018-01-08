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
    <title>ERS Sign In</title>
  </head>
  <body class="container">
  	<div class="page-header">
  	  <h1>Login To ERS - Expense Reimbursement System</h1>
  	</div>
  	<div class="row">
  	  <div class="col-sm-4 col-sm-offset-4">
	     <c:if test="${not empty requestScope.errMsg}">
	      <div class="alert alert-danger">
            <c:out value="${requestScope.errMsg}" />
          </div>
        </c:if>
        <c:if test="${not empty requestScope.successMsg}">
	      <div class="alert alert-success">
            <c:out value="${requestScope.successMsg}" />
          </div>
        </c:if>
  	    <form action="Login" method="post" class="well">
		  <div class="form-group">
			  <label for="userName">Username</label>
			  <input class="form-control" type="text" name="username" placeholder="username" required/>
		  </div>
		  <div class="form-group">
			  <label for="userPass">Password</label>
			  <input class="form-control" type="password" name="userpass" placeholder="password" required/>
		  </div>
		  <input type="submit" class="btn btn-primary" value="Login" />
		</form>
  	  </div>
  	</div>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  </body>
</html>