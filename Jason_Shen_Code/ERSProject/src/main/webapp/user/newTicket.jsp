<% 
	// Checks if there is a user logged in
	// Non-logged in users shouldn't be able to reach this page.
	if (session.getAttribute("loggedEmployee") == null) {
		System.out.println("Invalid session state, redirecting...");
		response.sendRedirect("login.jsp");
	}
	


%>
<html>
<head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css">
	<meta charset="ISO-8859-1">
	<title>Revature ERS</title>
</head>
<body class="container">

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


	<p>Create a new ticket here</p>	
	<div class="container">
		<form class="form-group" method="post" action="newTicket.do" id="myform">
			<div class="row" id="formline">
				<div class="col-sm-4">
					 <label>Category:</label>
					<select class="form-control" name="category" required>
						<option selected>Travel</option>
						<option>Relocation</option>
						<option>Materials</option>
						<option>Other</option>						
					</select>
				</div>

				<div class="col-sm-4">
					<label> Amount: </label>
					<div class="input-group mb-3">
						<div class="input-group-addon">
							<span class="input-group-text">$</span>
						</div>
						<input class="form-control currency" type="number" min="0" step="1.00" name="amount" 
							onchange="this.value=parseFloat(this.value).toFixed(2)" placeholder="Amount" required>
					</div>			
				</div>							
				<div class="col-sm-4">
					<label> Category: </label>
					<input class="form-control" type="text" name="description" placeholder="Description" required>
				</div>				
			</div>
		</form>
	</div>		
	<div class="container text-center">
		<button class="btn btn-secondary" id="newrow"> Add Item</button>
	</div>	
	<div class="container">
		<button class="btn btn-default btn-primary" type="button" id="submit"> Submit</button>	
	</div>			
	
	<script src="https://code.jquery.com/jquery-1.10.2.js"></script>	
	<script>
		$(document).ready(function() {
			$("#newrow").click(function() {
				$("#formline:last").clone(false).appendTo("#myform").find("input").val("");
			});
		});		
	</script>
	<script>
		$(document).ready(function() {
			$("#submit").click(function() {
				$("#myform").submit();
			});
		});		
	</script>
</body>
</html>