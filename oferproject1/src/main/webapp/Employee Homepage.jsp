<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.*,java.util.List.*,java.util.ArrayList.*"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<title>Employee Homepage</title>
<link href="scripts-css/standard.css" rel="stylesheet" type="text/css"/>
    
  
 
    
</head>
<body>
<br>
	<div class="container text-center">
	<div class="jumbotron">
        <h5>Employee Homepage</h5>
      </div>
      </div>
      
      
      <form name="login" method="post" action="logout.do">
			
				<input id="log1" class="btn btn-success" type="submit" value="Logout" onclick=""/>
			</form>
    <br>
                  
          <div class="panel panel-primary">
            <div class="panel-heading">
              <h2 class="panel-title" style="font-size:25px">View and update your profile</h2>
            </div>
            <div class="panel-body">
              
               <form name="profile" method="post" action=update.do>
               
          <table class="table-responsive">
            <thead>
              <tr>
              <th> </th>
               <th>Employee ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Username</th>
                <th>Email</th>
                <th>Password</th>
              </tr>
            </thead>
            <tbody>
       <tr>
       			<th>Current</th>
                <td> ${sessionScope.eid}</td>
                <td>${sessionScope.firstname}</td>
                <td>${sessionScope.lastname}</td>
                  <td>${sessionScope.username}</td>
                    <td>${sessionScope.email}</td>
                      <td>********</td>
              </tr>
              <tr>
              <th>New</th>
                <td></td>
                
              
                
                <td><label for="firstname"> <input id="firstname" type="text"
				placeholder="Enter your new name" class="form-control" name="ufname" value="${sessionScope.firstname}"/>
							</label></td>
                <td><label for="lastname"> <input id="lastname" type="text"
				placeholder="Enter your new name" class="form-control" name="ulname" value="${sessionScope.lastname}"/>
							</label></td>
                <td><label for="username"> <input id="username" type="text"
				placeholder="Enter your new username" class="form-control" name="uuname" value="${sessionScope.username}" 
				pattern=".{4,}" title="Must be from 4 to 20 characters long"/>
							</label></td>
                <td><label for="email"> <input id="email" type="email"
				placeholder="Enter your new email" class="form-control" maxLength="100" name="uemail" value="${sessionScope.email}"/>
							</label></td>
                <td><label for="oldpass"> <input id="oldpass" type="password" name="opass1" placeholder="Enter your current password" class="form-control" onkeyup="checkPass2(); return false;" required/>
							</label><br><label for="upass1"> <input id="upass1" type="password"
				placeholder="Enter your new password" class="form-control" name="upass1" pattern="(?=.*\d)(?=.*[a-z]).{6,}" title="Must contain at least one number and one letter, and be from 6 to 32 characters long" 
				onkeyup="checkPass(); return false;"/>
							</label><br>
							<div class="fieldWrapper">
							<label for="upass2"> <input id="upass2" type="password"
				placeholder="Enter your new password again" class="form-control" name="upass2" 
				pattern="(?=.*\d)(?=.*[a-z]).{6,}" title="Must contain at least one number and one letter, and be from 6 to 32 characters long" 
				onkeyup="checkPass(); return false;" >
							</label>
							<div style="width: 180px; overflow: hidden;" >
							<span id="confirmMessage" class="confirmMessage"><br></span>
														</div>
      				</td>
              </tr>
              </tbody>
          </table>
       <span style="font-size:15px;margin:10px; position:static; display: inline-block;">You must enter your current password to update. All other fields are optional. </span><br>
              <input id="btn1" class="btn btn-lg btn-primary" type="submit" value="Update" style="right: 49%"/>
              <input id="rbtn1" class="btn btn-lg btn-primary" type="reset" value="Reset" style="right: 40%"/>
              
                
              </form>
              <br><br><br>
            </div>
          </div>
          
          <div class="panel panel-primary">
            <div class="panel-heading">
              <h2 class="panel-title" style="font-size:25px">Submit a reimbursement request</h2>
            </div>
            <div class="panel-body">
           
             <form name="reimbursement" method="post" action=submit.do>
           
      
          <table class="table-responsive">
            <thead>
              <tr>
               <th style="text-align: center">Amount ($)</th>
                <th style="text-align: center">Type</th>
                <th style="text-align: center">Details (optional, max 200 chars)</th>
           <!--     <th style="text-align: center">Attach Receipt (optional)</th> -->
              </tr>
            </thead>
            <tbody>
                   <tr>
              
                <td><label for="Pass"> <input type="number" min="0.01" max="1000000000" step="0.01"
								placeholder="Enter amount" class="form-control" name="amount" required
								title="Must be a sum beween $0.01 and $1,000,000,000"/>
							</label></td>
                <td> 
      <select class="form-control" id="sel1" name="type" required>
        <option value="Travel">Travel</option>
        <option value="Lodging">Lodging</option>
        <option value="Training">Training</option>
        <option value="Other">Other</option>
      </select></td>
                <td><textarea rows="4" name="details" maxlength="200"  style="resize:none; width:100%;" name="type2"></textarea>
							</td>
            <!--    <td><input type="file" name="pic" accept="image/*"/></td> -->
                
              </tr>
              </tbody>
          </table>
            <input id="btn2" class="btn btn-lg btn-primary" type="submit" value="Submit" style="right: 49%"/>
            <input id="rbtn2" class="btn btn-lg btn-primary" type="reset" value="Reset" style="right: 40%"/>
            </form>
              <br><br><br>
            </div>
          </div>
        
        <div class="panel panel-primary">
            <div class="panel-heading">
              <h2 class="panel-title" style="font-size:25px">View Your Requests</h2>
            </div>
            <div class="panel-body">
           
            <form name="reimbursement" method="post" action=view.do>
             <input id="btn2" class="btn btn-lg btn-primary" type="submit" value="Load" style="left: 20%; margin:1px"/>       
      <select class="form-control" id="sel1" name="viewtype" style="width:17%" required >
        <option value="Pending">Your Pending Requests</option>
        <option value="Resolved">Your Resolved Requests</option>
      </select>
            <br>
  
					<c:if test="${not empty requestList1}">
					<h5 style="font-size:30px; margin:0 0 10px 0; text-align:center;">${sessionScope.person} ${sessionScope.viewtype} Requests</h5>
					    <table>
					    <thead>
              <tr>
                <th>Request ID</th>
                <th>Employee ID</th>
                <th>Amount</th>
                <th>Start Date</th>
                <th>End Date</th>
                <th>Status</th>
                <th>Type</th>
                <th>Details</th>
                <th>Resolved by ID</th>
             <!--      <th>Receipt Attached</th>
                  <th>Receipt URL</th> -->
              </tr>
            </thead>
            <tbody>
					      <c:forEach items="${requestList1}" var="record"> 
					            <tr>
					                <td>${record.rid}</td>
					                <td>${record.eid}</td>
					                <td>${record.amount}</td>
					                <td>${record.sdate}</td>
					                <td>${record.edate}</td>
					                <td>${record.status}</td>
					                <td>${record.type}</td>
					                <td>${record.type2}</td>
					                <td>${record.resid}</td>
					         <!--         <td>${record.rflag}</td>
					                 <td>${record.rurl}</td> -->
					            </tr>
					         </c:forEach> 
					         </tbody>
					    </table>	    
					</c:if>
              
            </form>
           
            </div>
          </div>
      
  
  <form name="login" method="post" action="logout.do">
	
				<input id="log1" class="btn btn-success" type="submit" value="Logout" onclick=""/>
			</form>
			
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts-css/myscripts.js"></script>    
</body>
</html>