<%@ page import="java.io.*,java.util.*"%>
<% 
	// Checks if there is a user logged in
	// Non-logged in users shouldn't be able to reach this page.
	if (session.getAttribute("loggedEmployee") == null) {
		System.out.println("Invalid session state, redirecting...");
		response.sendRedirect("user/login.jsp");
	}

%>
<head>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css">
  <link rel="stylesheet" type="text/css" href="css/mytables.css">
  
  
</head>
<body class="container" onload="getAllPending()">
<nav class="navbar navbar-toggleable-md navbar-light bg-faded">
  <a class="navbar-brand" href="home.do">Home<span class="sr-only">(current)</span></a>
  <div class=" navbar" id="navbarNavAltMarkup">
    <div class="navbar-nav">
      <a class="nav-item nav-link" href="https://www.google.com">Google</a>
      <a class="nav-item nav-link" href="https://app.revature.com">Revature Pro</a>
      <a class="nav-item nav-link" href="logout.do">Logout</a>
    </div>
  </div>
</nav>



<div class="container text-center">
	<div>
		<label>Manager Portal</label>
	</div>
	<input type="button" class="btn btn-primary" onclick="return getAllEmployees()" value="View All Employees">
	<input type="button" class="btn btn-primary" onclick="return getAllPending()" value="View Pending Requests">
	<input type="button" class="btn btn-primary" onclick="return getAllResolved()" value="View All Resolved">  

 
</div>

<div class="container text-center">
	<label id="tablelabel"></label>
	<div id="ticketlist">
	</div>
</div>



<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"> </script>
<script src="js/viewTickets.js"></script>
<script src="js/manager.js"></script>


</body>
</html>