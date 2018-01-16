<%@ page import = "java.io.*,java.util.*" %>
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
<body class="container" onload="getTickets('pending')">
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



<div class="container">
	<div class='text-center'>
		<label>Employee Home Page</label>
	</div>
	<div class='text-center'>
		<input type="button" class="btn btn-primary"
			onclick="location.href='newTicket.do'" value="Create New Ticket">
		<input type="button" class="btn btn-primary" onclick="location.href='updateInfo.do'" value="Edit Account Info"> 
	</div>
	
</div>

<div class="container text-center">
	<label id="tablelabel"></label>
	<div id="ticketlist">
	</div>
</div>


<div class="container text-center">
	<input type="button" class="btn btn-primary" onclick="return getTickets('pending')" value="View Pending" id="pendingtickets">
	<input type="button" class="btn btn-primary" onclick="return getTickets('resolved')" value="View Resolved" id="resolvedtickets">
	<input type="button" class="btn btn-primary" onclick="return getTickets('')" value="View All Tickets" id="alltickets">
</div>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"> </script>
<script src=js/viewTickets.js></script>

</body>
</html>