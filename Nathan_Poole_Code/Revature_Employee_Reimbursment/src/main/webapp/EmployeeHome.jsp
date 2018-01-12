<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%-- Directive scriplet to include JSTL core library --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%@ page import="com.revature.model.Employee"%>
	<%
		Employee user = (Employee) request.getSession().getAttribute("LoggedEmployee");
	%>
	<%
		int employeeId = user.getEmployeeId();
	%>
	<%
		String fullName = user.getEmployeeName();
	%>
	<%
		String email = user.getEmail();
	%>
	<%
		String username = user.getUsername();
	%>
	<%
		String title = user.getTitleType();
	%>
	<%
		boolean manager = (user.getUsername() == "1" ? true : false);
	%>
<input id="loggedEmployeeId" type="hidden" value="<%= employeeId %>" >
	
	<div>
		<form method="POST" action="login.do">
			<input type="submit" value="Logout" />
		</form>
	</div>
	
	<h3 id="msg_board"></h3>
	
	<div>
		<h3>Employee Information:</h3>
		<button id="lookupEmployeeInfo">Show Employee Info</button>
		<div id="employeeInfo">
			<table>
				
			</table>
		</div>
	</div>

	<div>
		<h3>Update Employee Info:</h3>
		<input type="text" placeholder="Employee Name" id="u_fullname" required /> 
		<input type="text" placeholder="Email" id="u_email" />
		<input type="text" placeholder="Username" id="u_username" required />
		<input type="text" placeholder="Password" id="u_password" required />
		<button id="updateEmployee">Update</button>
	</div>
	
	<div>
		<h3>Submit New Request:</h3>
		<input type="number" placeholder="Ammount" id="ammount" /> 
		<input type="text" placeholder="Descreption" id="description" /> 
		<button id="submitRequest">Submit Request</button>
	</div>

	<div>
		<h3>Request History:</h3>
		<button id="pending">Your Pending Requests</button>
		<button id="resolved">Your Resolved Requests</button>
	</div>

	<section>
		<div id="request_table">
			<table>
				
			</table>
		</div>
	</section>
	<script type="text/javascript" src="resources/js/EmployeeEvents.js"></script>
</body>
</html>