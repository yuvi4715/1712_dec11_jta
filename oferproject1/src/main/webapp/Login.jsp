<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
   import="com.revature.service.*,com.revature.model.*" 
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<title>Login Page</title>
 <!--  <link rel="stylesheet" href="Standard.css" type="text/css"> -->
    <script src="myscript.js"></script>
    
    <style>
    
         
    .jumbotron {
     background-color: rgb(225, 255, 255);
     padding:1px 0 1px 0;
      float: none;
       border: 2px solid #265a88;
    }
   
    
     h5{
     font-size:50px;
     }
     
     h6{
     font-size:25px;
     }

#btn1{
margin: 5px;
}

#loginresult{
	color:red; 
	
}

.nav.navbar-nav {
    display: flex;
    justify-content: center;
    flex-wrap: wrap;
}
    .navbar-nav {
        float: none;
    }
    
    .page-scroll{
    font-size:20px;
    }
    
.panel{ 
			width: 40%;
             display: inline-block;
             margin: 20px;
             background-color:rgb(225, 255, 255);
             }
    
    
    </style>

</head>
<body>

	 
	<br>
	<div class="container text-center">
	<div class="jumbotron">
        <h5>Employee Reimbursement System</h5>
       <h6> This system can be used to submit, display, and approve reimbursement requests</h6>
      </div>
      </div>
      
	<div class="row">
    <div class="col" align="center">
    
				<div class="container">
				
				 <div class="panel panel-primary">
            <div class="panel-heading">
              <h2 class="panel-title" style="font-size:25px">Login</h2>
            </div>
            <div class="panel-body">
				
				
					<form name="login" method="post" action="login.do">
				 		<div class="form-group text-center" style="margin:0">
							<p><label for="username"> <input id="username" name="username" type="text"
								placeholder="Enter your username" class="form-control"/>
							</label> </p>
							<label for="password"> <input id="password" name="password" type="password"
								placeholder="Enter your password" class="form-control"/>
							</label><br>
						<!--  	<p style="font-size:15px; font-weight:bold; line-height:25px; margin:0">Are you a manager?</p>
  								<input type="radio" name="mtest" id="m1" value="1"/> Yes
 								 <input type="radio" name="mtest" id="m0" value="0"/> No
 								  <input type="radio" name="mtest" id="m" value=" " style="display:none" checked/><br>-->

							<input id="btn1" name="lsubmit" class="btn btn-lg btn-primary" type="submit" value="Login"/>
							<!-- onclick="javascript:validate()"  -->	
							
						</div>

					</form>
					<div id="loginresult" style="color:red;">
      							  ${requestScope.utilOutput}
					</div>
					
					
				</div>
          </div>
				
				
			</div>
			
		</div>
	</div>


</body>
</html>