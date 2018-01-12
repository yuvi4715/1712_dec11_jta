<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% 
	// Checks if there is a user logged in
	// Non-logged in users shouldn't be able to reach this page.
	if (session.getAttribute("loggedEmployee") == null) {
		System.out.println("Invalid session state, redirecting...");
		response.sendRedirect("login.jsp");
	}

%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<form class="form-group" method="post" action="updateInfo.do" id="updateInfoForm">
			<div class="container"> 
				<label> 
					First Name: <input class="form-control" type="text" value=${loggedEmployee.firstName} name="firstname" required/>
				</label>
				<label>
					Last Name: <input class="form-control" type="text" value=${loggedEmployee.lastName} name="lastname" required/>
				</label>
			</div>
			
			<div class="container">
				<label> 
					Email: <input class="form-control" type="email" value=${loggedEmployee.email} name="email" required/>
				</label>
			</div>
			
			<div class="container">
				<label > 
					New Password: <input class="form-control" type="password" name="newpw1"/>
				</label>
				<label > 
					Confirm New Password: <input class="form-control" type="password" name="newpw2"/>
				</label>
			</div>
			
			<div class="container">
				<label > 
					Enter Current Password To Make Changes: <input class="form-control" type="password" name="currentpw" required/>
				</label>
			</div>
			
			<div class="container">
				<input class="btn btn-primary" type="submit" value="Submit">
			</div>
			
			
		</form>
	</div>
</body>
</html>