window.onload = getTickets();

function getTickets(option){

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
			var txt = "<table class='table table-striped' border='1' style='padding: 50px'> " +
	        		"<thead>" +
		        		"<tr>" +
			        		"<th>Ticket Id No.</th>" +
			        		"<th>Status</th>" +
			        		"<th>Resolution</th>" +
			        		"<th>Total Amount</th>" +
		        		"</tr>"+
			        "</thead>" +
			        "<tbody>"    		
	            for (x in ajaxObject) {
	                txt += ("<tr><td>" + ajaxObject[x].ticketId + "</td>" + 
	                "<td>" + ajaxObject[x].status + "</td>" +
	                "<td>" + ajaxObject[x].resolution + "</td>" + 
	                "<td>$" + ajaxObject[x].total + "</td></tr>")
	                		
	            }
	        	
	            txt += "</tbody></table>" 
	            
	            // Populate the empty div 
	    		
	            document.getElementById("ticketlist").innerHTML = txt;
		 }
		};
		//Opening connection for endpoint
		if (option == "pending") {
			console.log("Pending");
			xhttp.open("POST", "http://localhost:8080/ERSProject/viewPending.ajax", true);
			document.getElementById("tablelabel").innerHTML = "All Pending Tickets";
		}
		else if (option == "resolved") {
			console.log("Resolved");
			xhttp.open("POST", "http://localhost:8080/ERSProject/viewResolved.ajax", true);
			document.getElementById("tablelabel").innerHTML = "All Resolved Tickets";
		}		
		else {
			console.log("All");
			xhttp.open("POST", "http://localhost:8080/ERSProject/viewTickets.ajax", true);
			document.getElementById("tablelabel").innerHTML = "All Reimbursement Tickets";
		}
		
	  
		//Sending request to endpoint
		xhttp.send();
}

/* Modify the DOM after receiving JSON */
// NOT USING THIS
function setValues(ajaxObject){
	document.getElementById("ticketlist").innerHTML = ajaxObject.message;
}