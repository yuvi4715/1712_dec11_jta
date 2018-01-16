<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List"%>
<%@ page import="com.revature.reimbursement.Employee"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Reimbursement submission</title>
</head>
<h3>Employee Reimbursement Submission</h3>
<body>
<% Employee employee = (Employee) request.getSession().getAttribute("loggedEmployee"); %>

<form method="POST" action="remsubmit.do">
  <!-- RID: <input type="text" name="RID" value="is auto generated"><br> -->
  EID: <c:out value="${loggedEmployee.eid}"/><br>
  
  Amount: $ <input type="text" name="AMT" value=""><br>
  
 <!--  Start time:<br>
  <input type="text" name="STARTTIME" value="system-generated"><br>
  End time:<br> 
  <input type="text" name="ENDTIME" value=" "><br> These values will be automatically entered upon insertion into DB -->
  Description: <input type="text" name="description" value=" "><br><br>
  <input type="submit" value="Submit">
</form>

</body>
</html>