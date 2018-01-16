window.onload = employeeInfo();
document.getElementById("change").addEventListener("click", changePassword);
function changePassword(){
	
	var responder = document.getElementById("info");
	var newpassa = document.getElementById("newpassa").value;
	var newpassb = document.getElementById("newpassb").value;
	var password = document.getElementById("oldpass").value;
	var jhttp;
	if(newpassa == newpassb){
		jhttp = new XMLHttpRequest();
		jhttp.onreadystatechange = function (){
			if(this.readyState == 4 && this.status == 200){
				if(this.responseText == true){
					responder.innerHTML = "Your password has been updated.";
				}
				else{
					responder.innerHTML = "Your password has not been updated. Please check your current password and try again.";
				}
			}
		}
	}
	else
		responder.innerHTML = "Your password does not match re-entry.";
	jhttp.open("POST","http://localhost:8080/ERS/html/changePassword.AJAX");
	jhttp.send()
	
}

function populateNames(){
	var jhttp;
	jhttp.onreadystatechange = function (){
		if(this.readyState == 4 && this.status == 200) {
			var names = JSON.parse(responseText.innerHTML);
		}
	}
	jhttp.open("POST","http://localhost:8080/ERS/html/names.do");
	jhttp.send()
}


function employeeInfo(){
	var ehttp = new XMLHttpRequest();
	ehttp.onreadystatechange = function() {
		if(this.readyState == 4 && this.status == 200){
			var value = JSON.parse(this.responseText);
			setupEmployeeInfo(value);
		}
	}
	ehttp.open("post","http://localhost:8080/ERS/html/userInfo.AJAX");
	ehttp.send();
}
function setupEmployeeInfo(getEmployeeInfo) {
	document.getElementById("name").innerHTML = getEmployeeInfo.firstname + " " + getEmployeeInfo.lastname;
	document.getElementById("address").innerHTML = getEmployeeInfo.address;
	document.getElementById("city").innerHTML = getEmployeeInfo.city;
	document.getElementById("state").innerHTML = getEmployeeInfo.state;
	document.getElementById("zip").innerHTML = getEmployeeInfo.zipCode;
	document.getElementById("phone").innerHTML = getEmployeeInfo.phone;
	document.getElementById("email").innerHTML = getEmployeeInfo.email;
}

