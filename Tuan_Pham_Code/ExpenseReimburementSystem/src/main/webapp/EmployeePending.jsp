<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	
<title>Pending Reimbursements</title>
</head>
<body>
	<h1 align="center">Pending Reimbursements Requests</h1>
	
	<table class="table table-striped">
		<thead>
			<tr>
				<th> Ticket ID </th>
				<th> Employee ID </th>
				<th> Total </th>
				<th> Submit Time </th>
				<th> Description </th>
				<th> Category </th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${requestScope.displayPen}" var="pen">
				<tr>
					<td> <c:out value="${pen.getTicketId()}"></c:out></td>
					<td> <c:out value="${pen.getEmployeeId()}"></c:out></td>
					<td> <c:out value="${pen.getTotal()}"></c:out></td>
					<td> <c:out value="${pen.getSubmitTime()}"></c:out></td>
					<td> <c:out value="${pen.getDescription()}"></c:out></td>
					<td> <c:out value="${pen.getCategory()}"></c:out></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>