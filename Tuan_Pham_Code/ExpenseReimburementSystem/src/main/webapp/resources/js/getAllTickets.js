

function getEmployeeID() {
	var id = document.getElementById("employeeidreq").value;
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
	 if (xhttp.readyState == 4 && xhttp.status == 200) { 
		var ajaxObject = JSON.parse(xhttp.responseText);
		var txt = "<br></br>"+"<h3 align=\"center\"> Employee "+ id +" Reimbursements </h3>" +
		"<table class='table table-striped' border='1' style='padding: 50px'> " +
		"<thead>" +
    		"<tr>" +
        		"<th>Ticket ID</th>" +
        		"<th>Employee ID</th>" +
        		"<th>Status</th>" +
        		"<th>Total</th>" +
        		//"<th>Submit Time</th>" +
        		"<th>Description</th>" +
        		"<th>Category</th>"
    		"</tr>"+
        "</thead>" +
        "<tbody>"    		
    for (x in ajaxObject) {
        txt += ("<tr><td>" + ajaxObject[x].ticketId + "</td>" + 
        "<td>" + ajaxObject[x].employeeId + "</td>" + 
        "<td>" + ajaxObject[x].status + "</td>" +
        "<td>" + "$"+ ajaxObject[x].total + "</td>" + 
        //"<td>" + ajaxObject[x].submitTime + "</td>" +
        "<td>" + ajaxObject[x].description + "</td>" + 
        "<td>" + ajaxObject[x].category + "</td>" +
        "</td></tr>")
        		
    }
	
    txt += "</tbody></table>" 
    
    // Populate the empty div 
    document.getElementById("alltickets").innerHTML = txt;
	 
	 }
	};
  xhttp.open("POST", "http://localhost:8080/ExpenseReimburementSystem/findEmployee.ajax?id="+id, true);
  xhttp.send();
}

// function to get all employee's pending tickets
function getPenTickets(){

	var xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function() {
		 if (xhttp.readyState == 4 && xhttp.status == 200) { 
			var ajaxObject = JSON.parse(xhttp.responseText);
	        
			// Generate the html for table and concatenate values from ajax object
			var txt = "<br></br>"+"<h3 align=\"center\"> All Employee Pending Reimbursements </h3>" +
					"<table class='table table-striped' border='1' style='padding: 50px'> " +
	        		"<thead>" +
		        		"<tr>" +
			        		"<th>Ticket ID</th>" +
			        		"<th>Employee ID</th>" +
			        		"<th>Status</th>" +
			        		"<th>Total</th>" +
			        		//"<th>Submit Time</th>" +
			        		"<th>Description</th>" +
			        		"<th>Category</th>" +
			        		"<th>Resolve Ticket</th>" 
		        		"</tr>"+
			        "</thead>" +
			        "<tbody>"    		
	            for (x in ajaxObject) {
	                txt += ("<tr><td>" + ajaxObject[x].ticketId + "</td>" + 
	                "<td>" + ajaxObject[x].employeeId + "</td>" + 
	                "<td>" + ajaxObject[x].status + "</td>" +
	                "<td>" + "$"+ ajaxObject[x].total + "</td>" + 
	                //"<td>" + ajaxObject[x].submitTime + "</td>" +
	                "<td>" + ajaxObject[x].description + "</td>" + 
	                "<td>" + ajaxObject[x].category + "</td>" +
					"<td><button type=\"button\" onclick=\"approve(" + ajaxObject[x].ticketId + "); window.location.reload();\"> Approve</button>" +
					"<button type=\"button\" onclick=\"deny(" + ajaxObject[x].ticketId + "); window.location.reload();\"> Deny</button></td>" +
	                "</td></tr>")
	                		
	            }
	        	
	            txt += "</tbody></table>" 
	            
	            // Populate the empty div 
	            document.getElementById("alltickets").innerHTML = txt;
		 }
		};
	  //Opening connection for endpoint
	  xhttp.open("POST", "http://localhost:8080/ExpenseReimburementSystem/getAllPending.ajax", true);
	  
	  //Sending request to endpoint
	  xhttp.send();
}

//Ajax function call to grab all resolved tickets from employee
function getResTickets(){

	var xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function() {
		 if (xhttp.readyState == 4 && xhttp.status == 200) { 
			var ajaxObject = JSON.parse(xhttp.responseText);
			
			// Generate the html for table and concatenate values from ajax object
			var txt = "<br></br>"+"<h3 align=\"center\"> All Resolved Reimbursements </h3>" +
					"<table class='table table-striped' border='1' style='padding: 50px'> " +
	        		"<thead>" +
		        		"<tr>" +
			        		"<th>Ticket ID</th>" +
			        		"<th>Employee ID</th>" +
			        		"<th>Status</th>" +
			        		"<th>Total</th>" +
			        		//"<th>Submit Time</th>" +
			        		//"<th>Closed Time</th>" +
			        		"<th>Description</th>" +
			        		"<th>Category</th>" +
			        		"<th>Resolved By</th>"
		        		"</tr>"+
			        "</thead>" +
			        "<tbody>"    		
	            for (x in ajaxObject) {
	                txt += ("<tr><td>" + ajaxObject[x].ticketId + "</td>" + 
	    	        "<td>" + ajaxObject[x].employeeId + "</td>" +
	                "<td>" + ajaxObject[x].status + "</td>" +
	                "<td>" + "$"+ ajaxObject[x].total + "</td>" + 
	                //"<td>" + ajaxObject[x].submitTime + "</td>" +
	                //"<td>" + ajaxObject[x].closedTime + "</td>" + 
	                "<td>" + ajaxObject[x].description + "</td>" + 
	                "<td>" + ajaxObject[x].category + "</td>" + 
	                "<td>" + ajaxObject[x].resolvedBy + "</td>" +
	                "</td></tr>")
	                		
	            }
	        	
	            txt += "</tbody></table>" 
	            
	            // Populate the empty div 
	            document.getElementById("alltickets").innerHTML = txt;
		 }
		};
	  //Opening connection for endpoint
	  xhttp.open("POST", "http://localhost:8080/ExpenseReimburementSystem/getAllResolved.ajax", true);
	  
	  //Sending request to endpoint
	  xhttp.send();

}

// function to approve a ticket when clicking the approve button on pending table
function approve(id) {
	var myId = id;
	
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
	//If ready state is DONE and HTTP Status is OK
	 if (xhttp.readyState == 4 && xhttp.status == 200) { 
		var ajaxObject = JSON.parse(xhttp.responseText);
		setValues(ajaxObject);
		window.location.reload();
	 }
	};
  //Opening connection for endpoint
  xhttp.open("POST", "http://localhost:8080/ExpenseReimburementSystem/approve.ajax?reimbursementID="+myId, true);
  
  //Sending request to endpoint
  xhttp.send();
	
}

//function to deny a ticket when clicking the deny button on pending table
function deny(id) {
	var myId = id;
	
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
	//If ready state is DONE and HTTP Status is OK
	 if (xhttp.readyState == 4 && xhttp.status == 200) { 
		//Grabbing JSON object from response body.
        //THIS EXECUTES LAST WITHIN THIS FUNCTION
		var ajaxObject = JSON.parse(xhttp.responseText);
		setValues(ajaxObject);

	 }
	};
  //Opening connection for endpoint
  xhttp.open("POST", "http://localhost:8080/ExpenseReimburementSystem/deny.ajax?reimbursementID="+myId, true);
  
  //Sending request to endpoint
  xhttp.send();
	
}

