/**
 * This is JavaScript!!!
 */


function checkValidLogin(){
	document.getElementById("checked").innerText = "the button works.";
	var userjson = new Object;
	userjson.id = 0;
	userjson.username = document.getElementById("username").value;
	userjson.password = document.getElementById("password").value;
	userjson.title = null;
	var xhttp = new XMLHttpRequest();
	
	xhttp.onreadystatechange = function (){
		if(this.readyState == 4 && this.status == 200){
			//document.getElementById("checked").innerText = this.readyState + this.status;
			document.getElementById("checked").innerText = xhttp.responseText;
		}
	}
	xhttp.open("POST","http://localhost:8080/Reimbursement_Services/Controller", true);
	xhttp.setRequestHeader("Content-Type", "application/json");
	xhttp.setRequestHeader("Content-Length", 1);
	xhttp.setRequestHeader("Connection", "close");
	xhttp.send(JSON.stringify(userjson));
}

function setTag() {
	document.getElementById("checked").innerText = xhttp.responseText;
	
}