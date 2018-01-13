function getEmployeetPending(){

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
			var txt = "<table class='table table-striped'> " +
	        		"<thead>" +
		        		"<tr>" +
		        			"<th>Record No.</th>" +
			        		"<th>Last Name</th>" +
			        		"<th>First Name</th>" +
			        		"<th>Description</th>" +	
			        		"<th>Amount</th>" +	
		        		"</tr>"+
			        "</thead>" +
			        "<tbody>"    		
	            for (x in ajaxObject) {
	                txt += ("<tr><td>" + ajaxObject[x].rid + "</td>" + 
	                "<td>" + ajaxObject[x].lastname + "</td>" +
	                "<td>" + ajaxObject[x].firstname + "</td>" + 
	                "<td>" + ajaxObject[x].description + "</td>" +
	                "<td>" + ajaxObject[x].amount + "</td></tr>")
	                		
	            }
	        	
	            txt += "</tbody></table>" 
	            
	            // Populate the empty div 
	    		
	            document.getElementById("results").innerHTML = txt;
		 }
		};
		//Opening connection for endpoint
		xhttp.open("POST", "http://localhost:8080/FrontController/viewallpending.ajax", true);

		
	  
		//Sending request to endpoint
		xhttp.send();
}
