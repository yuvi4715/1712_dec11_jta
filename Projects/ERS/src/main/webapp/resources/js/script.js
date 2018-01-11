function logout() {
	alert("Logout function entered");
	$.ajax({
		url : 'Logout',
		method : "GET",
		async : false,
		success : function() {
			alert("Ajax success");
		},
		failure : function() {
			alert("Ajax failure");
		}
	});
}

function allRequestsByEmployee() {
	alert("allRequestsByEmployee()");
	$.ajax({
		url : 'ViewAllByEmployee',
		method : "GET",
		success : function() {
			alert("Ajax success");
		},
		failure : function() {
			alert("Ajax failure");
		}

	})
}

function allPendingRequestsByEmployee() {
	alert("allPendingRequestsByEmployee()");
	$.ajax({
		url : 'ViewPendingByEmployee',
		method : "GET",
		async : false,
		success : function() {
			alert("Ajax success");
		},
		failure : function() {
			alert("Ajax failure");
		}

	})
}

function allResolvedRequestsByEmployee() {
	alert("allResolvedRequestsByEmployee()");
	$.ajax({
		url : 'ViewResolvedByEmployee',
		method : "GET",
		success : function() {
			alert("Ajax success");
		},
		failure : function() {
			alert("Ajax failure");
		}

	})
}

