//window.onload = getTickets();

window.onload = function(){
	document.getElementById("pendingClick")
		.addEventListener("click", getPenTickets);
}

function getPenTickets(){

	var xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function() {
		//If ready state is DONE and HTTP Status is OK
		 if (xhttp.readyState == 4 && xhttp.status == 200) { 
			//Grabbing JSON object from response body.
            //THIS EXECUTES LAST WITHIN THIS FUNCTION
			var ajaxObject = JSON.parse(xhttp.responseText);
			
//			NOT USING THIS
//			setValues(ajaxObject)
	        
			// Generate the html for table and concatenate values from ajax object
			var txt = "<br></br>"+"<h3 align=\"center\"> Pending Reimbursements </h3>" +
					"<table class='table table-striped' border='1' style='padding: 50px'> " +
	        		"<thead>" +
		        		"<tr>" +
			        		"<th>Ticket ID</th>" +
			        		"<th>Employee ID</th>" +
			        		"<th>Status</th>" +
			        		"<th>Total</th>" +
			        		"<th>Submit Time</th>" +
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
	                "<td>" + ajaxObject[x].submitTime +
	                "<td>" + ajaxObject[x].description + "</td>" + 
	                "<td>" + ajaxObject[x].category + "</td>" + 
	                "</td></tr>")
	                		
	            }
	        	
	            txt += "</tbody></table>" 
	            
	            // Populate the empty div 
	            document.getElementById("tickets").innerHTML = txt;
		 }
		};
	  //Opening connection for endpoint
	  xhttp.open("POST", "http://localhost:8080/ExpenseReimburementSystem/getPending.ajax", true);
	  
	  //Sending request to endpoint
	  xhttp.send();
}
