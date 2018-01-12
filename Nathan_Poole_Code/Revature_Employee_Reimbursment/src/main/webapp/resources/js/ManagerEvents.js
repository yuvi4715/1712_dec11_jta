/**
 * 
 */
window.onload = function () {
	document.getElementById("lookupEmployeeInfo").addEventListener("click", getEmployeeInfo);
	document.getElementById("updateEmployee").addEventListener("click", sendEmployeeUpdate);
	document.getElementById("pending").addEventListener("click", getPending);
	document.getElementById("resolved").addEventListener("click", getResolved);
	document.getElementById("submitRequest").addEventListener("click", sendRequest);
	document.getElementById("createEmployee").addEventListener("click", sendNewEmployee);
	document.getElementById("allPending").addEventListener("click", getAllPending);
	document.getElementById("allResolved").addEventListener("click", getAllResolved);
	document.getElementById("employeeSearchPending").addEventListener("click", getEmployeePending);
	document.getElementById("employeeSearchResolved").addEventListener("click", getEmployeeResolved);
	document.getElementById("allEmployees").addEventListener("click", getAllEmployees);
	document.getElementById("approve").addEventListener("click", approve);
	document.getElementById("deny").addEventListener("click", deny);
}

function getEmployeeInfo(){
	var empid = document.getElementById("loggedEmployeeId").value
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function () {
		if (xhr.readyState == 4 && xhr.status == 200) {
			var ajaxObject = JSON.parse(xhr.responseText);
			
			var infoTable = document.createElement("table");
			var idRow = document.createElement("tr");
			var nameRow = document.createElement("tr");
			var emailRow = document.createElement("tr");
			var unRow = document.createElement("tr");
			var titleRow = document.createElement("tr");
			var managerRow = document.createElement("tr");
			
			var idLabel = document.createElement("th");
			var nameLabel = document.createElement("th");
			var emailLabel = document.createElement("th");
			var unLabel = document.createElement("th");
			var titleLabel = document.createElement("th");
			var managerLabel = document.createElement("th");
			
			var id = document.createElement("th");
			var name = document.createElement("th");
			var email = document.createElement("th");
			var un = document.createElement("th");
			var title = document.createElement("th");
			var manager = document.createElement("th");
			
			idLabel.textContent = "ID :";
			nameLabel.textContent = "Name :";
			emailLabel.textContent = "Email :";
			unLabel.textContent = "Username :";
			titleLabel.textContent = "Job Title :";
			managerLabel.textContent = "Manager :";
			
			id.textContent = ajaxObject.employeeId;
			name.textContent = ajaxObject.employeeName;
			email.textContent =  ajaxObject.email;
			un.textContent =  ajaxObject.username;
			title.textContent = ajaxObject.titleType;
			manager.textContent = (ajaxObject.managerState==1?true:false);
			
			idRow.appendChild(idLabel);
			idRow.appendChild(id);
			nameRow.appendChild(nameLabel);
			nameRow.appendChild(name);
			emailRow.appendChild(emailLabel);
			emailRow.appendChild(email);
			unRow.appendChild(unLabel);
			unRow.appendChild(un);
			titleRow.appendChild(titleLabel);
			titleRow.appendChild(title);
			managerRow.appendChild(managerLabel);
			managerRow.appendChild(manager);
			
			infoTable.appendChild(idRow);
			infoTable.appendChild(nameRow);
			infoTable.appendChild(emailRow);
			infoTable.appendChild(unRow);
			infoTable.appendChild(titleRow);
			infoTable.appendChild(managerRow);
			
			console.log(infoTable);

			var tableDiv = document.getElementById("employeeInfo");
			tableDiv.replaceChild(infoTable, tableDiv.firstChild);	
			}
	}
	xhr.open("POST", "http://localhost:8080/Revature_Employee_Reimbursment/getEmployee.ajax?"
			+"empid="+empid, true);
	xhr.send();
}

function sendEmployeeUpdate(){
	var empid = document.getElementById("loggedEmployeeId").value
	var fullname = document.getElementById("u_fullname").value;
	var email = document.getElementById("u_email").value;
	var username = document.getElementById("u_username").value;
	var password = document.getElementById("u_password").value;
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function () {
		if (xhr.readyState == 4 && xhr.status == 200) {
			var ajaxObject = JSON.parse(xhr.responseText);
			setValues(ajaxObject);
			getEmployeeInfo();
			}
	}
	xhr.open("POST", "http://localhost:8080/Revature_Employee_Reimbursment/updateEmployee.ajax?"
			+"empid="+empid
			+"&fullname="+fullname
			+"&email="+email
			+"&username="+username
			+"&password="+password, true);
	xhr.send();
}

function getPending(){
	var empid = document.getElementById("loggedEmployeeId").value;
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function () {
		if (xhr.readyState == 4 && xhr.status == 200) {
			var ajaxObject = JSON.parse(xhr.responseText);
			populateRequestTable(ajaxObject);
		}
	}
	xhr.open("POST", "http://localhost:8080/Revature_Employee_Reimbursment/requestUserPending.ajax?employeeId="+empid, true);
	xhr.send();
}

function getResolved(){
	var empid = document.getElementById("loggedEmployeeId").value;
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function () {
		if (xhr.readyState == 4 && xhr.status == 200) {
			var ajaxObject = JSON.parse(xhr.responseText);
			populateRequestTable(ajaxObject);
		}
	}
	xhr.open("POST", "http://localhost:8080/Revature_Employee_Reimbursment/requestUserResolved.ajax?employeeId="+empid, true);
	xhr.send();
}

function sendRequest(){
	
	var empid = document.getElementById("loggedEmployeeId").value;
	var ammount = document.getElementById("ammount").value;
	var desc = document.getElementById("description").value;
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function () {
		if (xhr.readyState == 4 && xhr.status == 200) {
			var ajaxObject = JSON.parse(xhr.responseText);
			setValues(ajaxObject);		

		}
	}
	xhr.open("POST", "http://localhost:8080/Revature_Employee_Reimbursment/submitRequest.ajax?employeeId="+empid
			+"&ammount="+ammount
			+"&desc="+desc, true);
	xhr.send();
}

function setValues(ajaxObject) {
	document.getElementById("msg_board").innerHTML = ajaxObject.message;
}

function sendNewEmployee(){
	
	var fullname = document.getElementById("new_fullname").value;
	var email = document.getElementById("new_email").value;
	var username = document.getElementById("new_username").value;
	var password = document.getElementById("new_password").value;
	var title = document.getElementById("new_title").value;
	var manager = (document.getElementById("new_manager").checked? 1: 0);
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function () {
		if (xhr.readyState == 4 && xhr.status == 200) {
			var ajaxObject = JSON.parse(xhr.responseText);
			setValues(ajaxObject);	
			}
	}
	xhr.open("POST", "http://localhost:8080/Revature_Employee_Reimbursment/submitNewEmployee.ajax?"
			+"fullname="+fullname
			+"&email="+email
			+"&username="+username
			+"&password="+password
			+"&title="+title
			+"&manager="+manager, true);
	xhr.send();
}

function getAllPending(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function () {
		if (xhr.readyState == 4 && xhr.status == 200) {
			var ajaxObject = JSON.parse(xhr.responseText);
			populateRequestTable(ajaxObject);
		}
	}
	xhr.open("POST", "http://localhost:8080/Revature_Employee_Reimbursment/requestAllPending.ajax", true);
	xhr.send();
}

function getAllResolved(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function () {
		if (xhr.readyState == 4 && xhr.status == 200) {
			var ajaxObject = JSON.parse(xhr.responseText);
			populateRequestTable(ajaxObject);
		}
	}
	xhr.open("POST", "http://localhost:8080/Revature_Employee_Reimbursment/requestAllResolved.ajax", true);
	xhr.send();
}

function getEmployeePending(){
	var username = document.getElementById("lookup_username").value;
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function () {
		if (xhr.readyState == 4 && xhr.status == 200) {
			var ajaxObject = JSON.parse(xhr.responseText);
			populateRequestTable(ajaxObject);
		}
	}
	xhr.open("POST", "http://localhost:8080/Revature_Employee_Reimbursment/requestEmployeePending.ajax?username="+username, true);
	xhr.send();
}

function getEmployeeResolved(){
	var username = document.getElementById("lookup_username").value;
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function () {
		if (xhr.readyState == 4 && xhr.status == 200) {
			var ajaxObject = JSON.parse(xhr.responseText);
			populateRequestTable(ajaxObject);
		}
	}
	xhr.open("POST", "http://localhost:8080/Revature_Employee_Reimbursment/requestEmployeeResolved.ajax?username="+username, true);
	xhr.send();
}

function populateRequestTable(ajaxObject){
	var requestTable = document.createElement("table");
	
	var headerRow = document.createElement("tbody");
	var rid = document.createElement("th");
	rid.textContent = "Request ID";
	headerRow.appendChild(rid);
	
	var eid = document.createElement("th");
	eid.textContent = "Employee ID";
	headerRow.appendChild(eid);
	
	var s = document.createElement("th");
	s.textContent = "Status";
	headerRow.appendChild(s);
	
	var a = document.createElement("th");
	a.textContent = "Ammount";
	headerRow.appendChild(a);
	
	var d = document.createElement("th");
	d.textContent = "Description";
	headerRow.appendChild(d);
	
	var o = document.createElement("th");
	o.textContent = "Open Date";
	headerRow.appendChild(o);
	
	var c = document.createElement("th");
	c.textContent = "Closed Date";
	headerRow.appendChild(c);
	
	var n = document.createElement("th");
	n.textContent = "Notes";
	headerRow.appendChild(n);
	
	var m = document.createElement("th");
	m.textContent = "Approved By";
	headerRow.appendChild(m);
	requestTable.appendChild(headerRow);

	
	for(let row in ajaxObject){
		var record = document.createElement("tr");
		var requestId = document.createElement("td");
		var employeeId = document.createElement("td");
		var status = document.createElement("td");
		var ammount = document.createElement("td");
		var descritpion = document.createElement("td");
		var openTime = document.createElement("td");
		var clossedTime = document.createElement("td");
		var notes = document.createElement("td");
		var manager = document.createElement("td");
		
		requestId.textContent = ajaxObject[row].requestId;
		employeeId.textContent = ajaxObject[row].employeeId;
		status.textContent = ajaxObject[row].status;
		ammount.textContent = ajaxObject[row].ammount;
		descritpion.textContent = ajaxObject[row].requestDesc;
		openTime.textContent = ajaxObject[row].openTimestamp;
		clossedTime.textContent = ajaxObject[row].closedTimestamp;
		notes.textContent = ajaxObject[row].notes;
		manager.textContent = ajaxObject[row].managerId;
		
		record.appendChild(requestId);
		record.appendChild(employeeId);
		record.appendChild(status);
		record.appendChild(ammount);
		record.appendChild(descritpion);
		record.appendChild(openTime);
		record.appendChild(clossedTime);
		record.appendChild(manager);
		
		requestTable.appendChild(record);
		
	}
	var tableDiv = document.getElementById("request_table");
	tableDiv.replaceChild(requestTable, tableDiv.firstChild);
}

function setValues(ajaxObject) {
	document.getElementById("msg_board").innerHTML = ajaxObject.message;
}

function getAllEmployees(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function () {
		if (xhr.readyState == 4 && xhr.status == 200) {
			var ajaxObject = JSON.parse(xhr.responseText);
			populateEmployeeTable(ajaxObject);			
		}
	}
	xhr.open("POST", "http://localhost:8080/Revature_Employee_Reimbursment/requestAllEmployee.ajax", true);
	xhr.send();
}

function populateEmployeeTable(ajaxObject){
	
	var employeeTable = document.createElement("table");
	
	var headerRow = document.createElement("tbody");
	
	var eid = document.createElement("th");
	eid.textContent = "Employee ID";
	headerRow.appendChild(eid);
	
	var s = document.createElement("th");
	s.textContent = "Name";
	headerRow.appendChild(s);
	
	var a = document.createElement("th");
	a.textContent = "Email";
	headerRow.appendChild(a);
	
	var d = document.createElement("th");
	d.textContent = "Username";
	headerRow.appendChild(d);
	
	var o = document.createElement("th");
	o.textContent = "Title";
	headerRow.appendChild(o);
	
	var c = document.createElement("th");
	c.textContent = "Is Manager";
	headerRow.appendChild(c);
	employeeTable.appendChild(headerRow);
	
	for(let row in ajaxObject){
		var record = document.createElement("tr");
		var id = document.createElement("td");
		var name = document.createElement("td");
		var email = document.createElement("td");
		var un = document.createElement("td");
		var title = document.createElement("td");
		var manager = document.createElement("td");
	

		id.textContent = ajaxObject[row].employeeId;
		name.textContent = ajaxObject[row].employeeName;
		email.textContent = ajaxObject[row].email;
		un.textContent = ajaxObject[row].username;
		title.textContent = ajaxObject[row].titleType;
		manager.textContent = (ajaxObject[row].managerState == 1 ? true : false);
	
		record.appendChild(id);
		record.appendChild(name);
		record.appendChild(email);
		record.appendChild(un);
		record.appendChild(title);
		record.appendChild(manager);
	
		employeeTable.appendChild(record);
	}
	var tableDiv = document.getElementById("request_table");
	tableDiv.replaceChild(employeeTable, tableDiv.firstChild);
}

function approve(){
	var empid = document.getElementById("loggedEmployeeId").value;
	var requestId = document.getElementById("requestId").value;
	var notes = document.getElementById("requestNotes").value;
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function () {
		if (xhr.readyState == 4 && xhr.status == 200) {
			var ajaxObject = JSON.parse(xhr.responseText);
			setValues(ajaxObject);
			getAllPending();
			}
	}
	xhr.open("POST", "http://localhost:8080/Revature_Employee_Reimbursment/finalizeRequest.ajax?"
			+"empid="+empid
			+"&requestId="+requestId
			+"&status=APPROVED"
			+"&notes="+notes, true);
	xhr.send();
}

function deny(){
	var empid = document.getElementById("loggedEmployeeId").value;
	var requestId = document.getElementById("requestId").value;
	var notes = document.getElementById("requestNotes").value;
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function () {
		if (xhr.readyState == 4 && xhr.status == 200) {
			var ajaxObject = JSON.parse(xhr.responseText);
			setValues(ajaxObject);
			getAllPending();
			}
	}
	xhr.open("POST", "http://localhost:8080/Revature_Employee_Reimbursment/finalizeRequest.ajax?"
			+"empid="+empid
			+"&requestId="+requestId
			+"&status=DENIED"
			+"&notes="+notes, true);
	xhr.send();
}

