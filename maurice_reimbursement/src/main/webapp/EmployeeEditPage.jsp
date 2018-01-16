<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List"%>
<%@ page import="com.revature.reimbursement.Employee"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Employee Info</title>
</head>
<body>
<% Employee employee = (Employee) request.getSession().getAttribute("loggedEmployee"); %>
<!-- Welcome, employee.getFirstname() %> Use this for methods --> 

<h3>Enter changes and click submit!</h3>


<form method="POST" action="empupdate.do">
  Employee EID:<c:out value="${loggedEmployee.eid}"/><br><br>
  First name:<input type="text" name="firstname" value="${loggedEmployee.firstname}"><br><br>
  Last name:<input type="text" name="lastname" value="${loggedEmployee.lastname}"><br><br>
  Email:<input type="text" name="email" value="${loggedEmployee.email}"><br><br>
  Role:<c:out value="${loggedEmployee.roleid}"/><br><br>
  Title:<input type="text" name="title" value="${loggedEmployee.title}"><br><br>
  <button type="submit">Submit changes</button>
</form>
<br><br>
<form method="POST" action="logout.do">
    <button type="submit">Logout</button>
</form>

</body>
</html>