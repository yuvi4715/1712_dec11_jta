function getAllEmployees(){

	var xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function() {
		//If ready state is DONE and HTTP Status is OK
		 if (xhttp.readyState == 4 && xhttp.status == 200) { 
			//Grabbing JSON object from response body.
            //THIS EXECUTES LAST WITHIN THIS FUNCTION
			var ajaxObject = JSON.parse(xhttp.responseText);
	        
			// Generate the html for table and concatenate values from ajax object
			var txt = "<table class='table table-striped table-hover' border='1' style='padding: 50px'> " +
	        		"<thead>" +
		        		"<tr>" +
		        			"<th>Employee ID No.</th>" +
			        		"<th>Last Name</th>" +
			        		"<th>First Name</th>" +
			        		"<th>Email</th>" +	
			        		"<th>Role</th>" +	
		        		"</tr>"+
			        "</thead>" +
			        "<tbody>"    		
	            for (x in ajaxObject) {
	                txt += ("<tr class='tablerow' onclick='return getPending(" + ajaxObject[x].id +")' ><td>" + ajaxObject[x].id + "</td>" + 
	                "<td>" + ajaxObject[x].lastName + "</td>" +
	                "<td>" + ajaxObject[x].firstName + "</td>" + 
	                "<td>" + ajaxObject[x].email + "</td>" +
	                "<td>" + ajaxObject[x].role + "</td></tr>")
	                		
	            }
	        	
	            txt += "</tbody></table>" 
	            
	            // Populate the empty div 
	            document.getElementById("ticketlist").innerHTML = txt;
		 }
		};
		//Opening connection for endpoint
		xhttp.open("POST", "http://localhost:8080/ERSProject/viewAllEmployees.ajax", true);
		document.getElementById("tablelabel").innerHTML = "All Employees";

		
	  
		//Sending request to endpoint
		xhttp.send();
}

function getPending(employeeid){

	var xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function() {
		//If ready state is DONE and HTTP Status is OK
		 if (xhttp.readyState == 4 && xhttp.status == 200) { 
			var ajaxObject = JSON.parse(xhttp.responseText);
	        
			// Generate the html for table and concatenate values from ajax object
			var txt = "<table class='table table-striped table-hover' border='1' style='padding: 50px'> " +
	        		"<thead>" +
		        		"<tr>" +
		        			"<th>Ticket ID No.</th>" +
			        		"<th>Status</th>" +
			        		"<th>Resolution</th>" +
			        		"<th>Total Amount</th>" +	
			        		"<th>Action</th>" +	
		        		"</tr>"+
			        "</thead>" +
			        "<tbody>"    		
	            for (x in ajaxObject) {	      
	                txt += ("<tr class='tablerow' onclick='return getTicketInfo(" + ajaxObject[x].ticketId + ")'><td>" + ajaxObject[x].ticketId + "</td>" + 
	                "<td>" + ajaxObject[x].status + "</td>" +
	                "<td>" + ajaxObject[x].resolution + "</td>" + 
	                "<td>" + ajaxObject[x].total + "</td>" +
	                "<td id='action'>" + "<div class='text-center'>" +
	                			"<input type='button' class='btn btn-success' onclick='return approve(" + ajaxObject[x].ticketId +")' value='Approve'/>" +
	                			"<input type='button' class='btn btn-danger' onclick='return deny(" + ajaxObject[x].ticketId +")' value='Deny'/>" + 
	                		"</div>" +
	                "</td></tr>")
	                		
	            }
	        	
	            txt += "</tbody></table>" 
	            
	            // Populate the empty div 
	            document.getElementById("tablelabel").innerHTML = "Pending Tickets for Employee ID No. " + employeeid;
	            document.getElementById("ticketlist").innerHTML = txt;
		 }
		};
		//Opening connection for endpoint
		xhttp.open("POST", "http://localhost:8080/ERSProject/managerViewPending.ajax", true);
		

		//Sending request to endpoint
		xhttp.send(String(employeeid));
}

function getAllPending(){

	var xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function() {
		//If ready state is DONE and HTTP Status is OK
		 if (xhttp.readyState == 4 && xhttp.status == 200) { 
			//Grabbing JSON object from response body.
            //THIS EXECUTES LAST WITHIN THIS FUNCTION
			var ajaxObject = JSON.parse(xhttp.responseText);
	        
			// Generate the html for table and concatenate values from ajax object
			var txt = "<table class='table table-striped table-hover' border='1' style='padding: 50px'> " +
	        		"<thead>" +
		        		"<tr>" +
		        			"<th>Ticket ID No.</th>" +
			        		"<th>Status</th>" +
			        		"<th>Resolution</th>" +
			        		"<th>Total Amount</th>" +	
			        		"<th>Action</th>" +	
		        		"</tr>"+
			        "</thead>" +
			        "<tbody>"    		
	            for (x in ajaxObject) {	      
	                txt += ("<tr class='tablerow' onclick='return getTicketInfo(" + ajaxObject[x].ticketId + ")'><td>" + ajaxObject[x].ticketId + "</td>" + 
	                "<td>" + ajaxObject[x].status + "</td>" +
	                "<td>" + ajaxObject[x].resolution + "</td>" + 
	                "<td>" + ajaxObject[x].total + "</td>" +
	                "<td id='action'>" + "<div class='text-center'>" +
	                			"<input type='button' class='btn btn-success' onclick='return approve(" + ajaxObject[x].ticketId +")' value='Approve'/>" +
	                			"<input type='button' class='btn btn-danger' onclick='return deny(" + ajaxObject[x].ticketId +")' value='Deny'/>" + 
	                		"</div>" +
	                "</td></tr>")
	                		
	            }
	        	
	            txt += "</tbody></table>" 
	            
	            // Populate the empty div 
	            document.getElementById("ticketlist").innerHTML = txt;
		 }
		};
		//Opening connection for endpoint
		xhttp.open("POST", "http://localhost:8080/ERSProject/viewAllPending.ajax", true);
		document.getElementById("tablelabel").innerHTML = "All Pending Tickets";
	  
		//Sending request to endpoint
		xhttp.send();
}


function getAllResolved(){

	var xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function() {
		//If ready state is DONE and HTTP Status is OK
		 if (xhttp.readyState == 4 && xhttp.status == 200) { 

			 var ajaxObject = JSON.parse(xhttp.responseText);
			
			// Generate the html for table and concatenate values from ajax object
			var txt = "<table class='table table-striped' border='1' style='padding: 50px'> " +
	        		"<thead>" +
		        		"<tr>" +
		        			"<th>Ticket ID No.</th>" +
			        		"<th>Status</th>" +
			        		"<th>Resolution</th>" +
			        		"<th>Total Amount</th>" +	
			        		"<th>Resolved By</th>" +	
		        		"</tr>"+
			        "</thead>" +
			        "<tbody>"    		
	            for (x in ajaxObject) {
	                txt += ("<tr><td>" + ajaxObject[x].ticketId + "</td>" + 
	                "<td>" + ajaxObject[x].status + "</td>" +
	                "<td>" + ajaxObject[x].resolution + "</td>" + 
	                "<td>" + ajaxObject[x].total + "</td>" +
	                "<td>" + ajaxObject[x].resolvedby + "</td></tr>")
	                		
	            }
	        	
	            txt += "</tbody></table>" 
	            
	            // Populate the empty div 
	            document.getElementById("ticketlist").innerHTML = txt;
		 }
		};
		xhttp.open("POST", "http://localhost:8080/ERSProject/viewAllResolved.ajax", true);
		document.getElementById("tablelabel").innerHTML = "All Resolved Tickets";

		xhttp.send();
}

function approve(ticketid) {
	console.log("function entered");
	console.log(typeof ticketid);
	console.log(typeof String(ticketid));
	var xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function() {
		//If ready state is DONE and HTTP Status is OK
		 if (xhttp.readyState == 4 && xhttp.status == 200) { 
			 
			console.log(xhttp.responseText);
			getAllPending(); 
		 }
		};
		xhttp.open("POST", "http://localhost:8080/ERSProject/approve.ajax", true);
		xhttp.send(String(ticketid));
}

function deny(ticketid) {
	console.log("function entered");
	console.log(typeof ticketid);
	console.log(typeof String(ticketid));
	var xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function() {
		//If ready state is DONE and HTTP Status is OK
		 if (xhttp.readyState == 4 && xhttp.status == 200) { 
			 
			 console.log(xhttp.responseText); 
			 getAllPending(); 
		 }
		};
		//Opening connection for endpoint
		xhttp.open("POST", "http://localhost:8080/ERSProject/deny.ajax", true);

		//Sending request to endpoint
		xhttp.send(String(ticketid));
}

