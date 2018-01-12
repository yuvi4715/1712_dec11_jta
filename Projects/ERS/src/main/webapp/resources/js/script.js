function logout() {
	//alert("Logout function entered");
	$.ajax({
		url : "Logout",
		method : "POST",
		async : false,
		success : function() {
			//alert("Ajax success");
			window.location.href = "login.jsp";
		},
		failure : function() {
			//alert("Ajax failure");
		}
	});
}

function allRequestsByEmployee() {
	//alert("allRequestsByEmployee()");
	$.ajax({
		url : "ViewAllByEmployee",
		method : "GET",
		success : function() {
			//alert("Ajax success");
			location.reload();
		},
		failure : function() {
			//alert("Ajax failure");
		}

	});
}

function filterRequestsByEmployee() {
	var id= $("#searchBar").val();
	//alert("filterRequestsByEmployee(): " + id);
	$.post("ViewAllByEmployee", {EID: id})
	.done(function(){
		//alert("Ajax successful!");
	});
}


	
function OLDfilterRequestsByEmployee() {
	//alert("filterRequestsByEmployee()");
	$.ajax({
		url : "ViewAllByEmployee",
		method : "POST",
		data : $("#employeeSearch").serialize(),
		success : function(data) {
			//alert("Ajax success: " + data);
			location.href = location.href;
		},
		failure : function() {
			//alert("Ajax failure");
		}
	});
}

function allPendingRequestsByEmployee() {
	//alert("allPendingRequestsByEmployee()");
	$.ajax({
		url : "ViewPendingByEmployee",
		method : "POST",
		success : function() {
			//alert("Ajax success");
			location.reload();
		},
		failure : function() {
			//alert("Ajax failure");
		}
	});
}

function allResolvedRequestsByEmployee() {
	//alert("allResolvedRequestsByEmployee()");
	$.ajax({
		url : "ViewResolvedByEmployee",
		method : "POST",
		success : function() {
			//alert("Ajax success");
			location.reload();
		},
		failure : function() {
			//alert("Ajax failure");
		}
	});
}

function allPendingRequests() {
	//alert("allPendingRequests()");
	$.ajax({
		url : "ViewAllPending",
		method : "GET",
		success : function() {
			//alert("Ajax success");
			location.href = location.href;
		},
		failure : function() {
			//alert("Ajax failure");
		}
	});
}

function allResolvedRequests() {
	//alert("allResolvedRequests()");
	$.ajax({
		url : "ViewAllResolved",
		method : "GET",
		success : function() {
			//alert("Ajax success");
			location.href = location.href;
		},
		failure : function() {
			//alert("Ajax failure");
		}
	});
}

function approve(clicked_id){
	//alert("approve reimbursement ID: " + clicked_id);
	var rid = clicked_id;
	$.post("ApproveReimbursement", {RID: clicked_id})
	.done(function(){
		//alert("Ajax successful!");
		//document.getElementsById("status"+rid).innerHTML = "approved";
	});
}

function deny(clicked_id){
	//alert("deny reimbursement ID: " + clicked_id);
	$.post("DenyReimbursement", {RID: clicked_id})
	.done(function(){
		//alert("Ajax successful!");
		//document.getElementsById("status"+rid).innerHTML = "denied";
	});
}

	/*
function approve(clicked_id) {
	//alert("reimbursement ID: " + clicked_id);
	$.ajax({
		url : "ApproveReimbursement",
		method : "POST",
		success : function() {
			//alert("Ajax success");
		},
		failure : function() {
			//alert("Ajax failure");
		}
	});
}*/

/*
 function deny(clicked_id) {
 //alert("deny reimbursement ID: " + clicked_id);
 $.ajax({
 //url : "DenyReimbursement",
 //method : "POST",
 success : function() {
 //alert("Ajax success");
 },
 failure : function() {
 //alert("Ajax failure");
 }
 });
 }*/

function loadEmployeeList() {
	//alert("loadEmployeeList()");
	$.ajax({
		url : "ViewAllEmployees",
		method : "POST",
		success : function() {
			//alert("Ajax success");
			window.location.href = "ViewEmployee.jsp";
		},
		failure : function() {
			//alert("Ajax failure");
		}
	});
}

/*
function approve() {
var rid = document.getElementById("username").value;

console.log("Resolving reimbursement: " + rid);
var xhttp = new XMLHttpRequest();
xhttp.onreadystatechange = function() {
	//If ready state is DONE and HTTP Status is OK
	if (xhttp.readyState == 4 && xhttp.status == 200) {
		//Grabbing JSON object from response body.
		//THIS EXECUTES LAST WITHIN THIS FUNCTION
		var ajaxObject = JSON.parse(xhttp.responseText);
		//setValues(ajaxObject);
	}
};
//Opening connection for endpoint
xhttp.open("POST", "http://localhost:8080/ERS/approve.ajax?RID=" + rid,
		true);

//Sending request to endpoint
xhttp.send();
}
 */