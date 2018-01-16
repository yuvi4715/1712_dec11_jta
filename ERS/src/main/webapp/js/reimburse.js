


window.onload = getNames();
document.getElementById("reimburseBtn").addEventListener("click", getReimbursement);
var e;
const approve = "APPROVED";
const deny = "DENIED";
var employeeJSON = null;
document.getElementById("employee").addEventListener("click",
		function (){
	e = document.getElementById("employee");
	e = e.options[e.selectedIndex].value;
});
//Gets reimbursements based on the employee and reimbursement type
function getReimbursement(){
	var jhttp = new XMLHttpRequest();
	document.getElementById("listbody").innerHTML = "";
	var getType = new Object;
	var reimburseType = document.getElementById("type").value;
	getType.type = reimburseType;
	getType.eid = e;
	if(e == 0 || e == undefined){
		if(reimburseType == "all" || reimburseType == undefined){
			getAllReimbursements();
		}
		else{
			jhttp.onreadystatechange = function() {
				if(this.readyState == 4 && this.status == 200){
					var reimburseJSON = JSON.parse(this.responseText);
					createTable(reimburseJSON);	
				}
			}
			jhttp.open("POST","http://localhost:8080/ERS/html/reimburseAllType.AJAX",true);
			jhttp.send(JSON.stringify(getType));
		}
	}
	else if(reimburseType == "all" || reimburseType == undefined){
		jhttp.onreadystatechange = function() {
			if(this.readyState == 4 && this.status == 200){
				var reimburseJSON = JSON.parse(this.responseText);
				createTable(reimburseJSON);
				
			}
		}
		jhttp.open("POST","http://localhost:8080/ERS/html/reimburseAllEmployee.AJAX",true);
		jhttp.send(JSON.stringify(getType));
	}
	else{
		jhttp.onreadystatechange = function() {
			if(this.readyState == 4 && this.status == 200){
				var reimburseJSON = JSON.parse(this.responseText);
				createTable(reimburseJSON);
				
			}
		}
		jhttp.open("POST","http://localhost:8080/ERS/html/reimburse.AJAX",true);
		jhttp.send(JSON.stringify(getType));
	}
}


//Starts on window load to get all employee names
function getNames(){
	
	var jhttp = new XMLHttpRequest();
	var employeeName = document.getElementById("employee").value;
	
	document.getElementById("listbody").innerHTML = "";
	
	jhttp.onreadystatechange = function() {
		if(this.readyState == 4 && this.status == 200){
			employeeJSON = JSON.parse(this.responseText);
			createNames(employeeJSON);
			getAllReimbursements()
		}
	}
	jhttp.open("POST","http://localhost:8080/ERS/html/names.AJAX",false);
	jhttp.send();
}

//Creates the list of names
function createNames(names){
	var employee = document.getElementById("employee");
	var generic = document.createElement("option");
	generic.innerHTML = "(Select Employee)";
	generic.value = 0;
	employee.appendChild(generic);
	
	for(var i = 0; i < names.length; i++){
		var options = document.createElement("option");
		options.innerHTML = names[i].firstname + " " + names[i].lastname;
		options.value = names[i].eid;
		employee.appendChild(options);
	}
	
}
//Gets every reimbursement
function getAllReimbursements(){
	var jttp= new XMLHttpRequest();
	jttp.onreadystatechange = function() {
		if(this.readyState == 4 && this.status == 200){
			var reimburseAllJSON = JSON.parse(this.responseText);
			createTable(reimburseAllJSON);
		}
	}
	jttp.open("POST", "http://localhost:8080/ERS/html/reimburseAll.AJAX", true);
	jttp.send();
}
//Creates a table of reimbursements
function createTable1(reimburse){
	for(var i = 0; i < reimburse.length; i++){
		var rows = document.createElement("tr");
		var name = rows.appendChild(document.createElement("td"));
		name.textContent = reimburse[i].firstname + " " + reimburse[i].lastname;
		var time = rows.appendChild(document.createElement("td"));
		time.innerHTML = reimburse[i].time;
		var amount = rows.appendChild(document.createElement("td"));
		amount.innerHTML = reimburse[i].amount;
		var manager = rows.appendChild(document.createElement("td"));
		amount.innerHTML = reimburse[i].manager;
		var reason = rows.appendChild(document.createElement("td"));
		reason.innerHTML = reimburse[i].reason;
		var buttons = rows.appendChild(document.createElement("td"));
		if(reimburse[i].status == null){
			let button1 = buttons.appendChild(document.createElement("button"));
			let button2 = buttons.appendChild(document.createElement("button"));
			button1.innerHTML= "APPOVE";
			button1.value = reimburse[i].id;
			button1.addEventListener("click", setStatus);
			button2.innerHTML = "DENY";
			button2.value = reimburse[i].id;
			button2.addEventListener("click", setStatus);
		}
		//write button logic if this is unresolved
		document.getElementById("listbody").appendChild(rows);
	}
}
function setStatus(buttonStatus) {
	var aStatus = new Object();
	if(buttonStatus.innerHTML == "APPROVE"){
		aStatus.status = approve;
	} else {
		aStatus.status = deny;
	}
	aStatus.id = buttonStatus.value;
	var decision = window.confirm("Are you sure you want to RESOLVE this request?");
	if (decision == true) {
		jttp = new XMLHttpRequest();
		jttp.onreadystatechange = function(){
			
		}
		jttp.open("POST", "http://localhost:8080/ERS/html/setStatus.AJAX");
		jttp.send(JSON.stringify(aStatus));
	}
}

function statusApprove(row) {
	var rowInTable = row.target.parentNode.parentNode;
	var decision = window.confirm("Are you sure you want to APPROVE this request?");
	if (decision == true) {
		var resolvedRequest = new Object();
		resolvedRequest.id = rowInTable.firstChild.textContent;
		resolvedRequest.status = approve;
		var jttp = new XMLHttpRequest();
		jttp.onreadystatechange = function() {
			if (this.readyState == 4 && this.status) {
					getReimbursement();
			}
		}
		jttp.open("POST", "http://localhost:8080/ERS/html/setStatus.AJAX");
		jttp.send(JSON.stringify(resolvedRequest));
	}
}

function statusDeny(row) {
	var rowInTable = row.target.parentNode.parentNode;
	var decision = window.confirm("Are you sure you want to DENY this request?");
	if (decision == true) {
		var resolvedRequest = new Object();
		resolvedRequest.id = rowInTable.firstChild.textContent;
		resolvedRequest.status = deny;
		var jttp = new XMLHttpRequest();
		jttp.onreadystatechange = function() {
			if (this.readyState == 4 && this.status) {	
			}
		}
		jttp.open("POST", "http://localhost:8080/ERS/html/setStatus.AJAX");
		jttp.send(JSON.stringify(resolvedRequest));
	}

}

function createTable(ajaxObject) {

	for (var i = 0; i < ajaxObject.length; i++) {
		var tr = document.createElement("tr");
		var tdRequestId = document.createElement("td");
		var tdName = document.createElement("td");
		var tdRequestAmount = document.createElement("td");
		var tdRequestReason = document.createElement("td");
		var tdTimeCreated = document.createElement("td");
		var tdManagerName = document.createElement("td");
		var tdApprove = document.createElement("td");
		var tdDeny = document.createElement("td");
		if(ajaxObject[i].status == null){
			var approveButton = document.createElement("input");
			approveButton.setAttribute("type", "button");
			approveButton.setAttribute("class", "btn btn-success");
			approveButton.setAttribute("value", "APPROVE");
			approveButton.addEventListener("click", statusApprove);
			tdApprove.appendChild(approveButton);
			var denyButton = document.createElement("input");
			denyButton.setAttribute("type", "button");
			denyButton.setAttribute("class", "btn btn-danger");
			denyButton.setAttribute("value", "DENY");
			denyButton.addEventListener("click", statusDeny);
			tdDeny.appendChild(denyButton);
		}
		tdRequestId.textContent = ajaxObject[i].id;
		tdName.textContent = ajaxObject[i].firstname + " " + ajaxObject[i].lastname;
		tdRequestAmount.textContent = ajaxObject[i].amount;
		tdRequestReason.textContent = ajaxObject[i].reason;
		tdTimeCreated.textContent = ajaxObject[i].time;
		tdManagerName.textContent = ajaxObject[i].managerfirstname + " " + ajaxObject[i].managerlastname;
		tr.appendChild(tdRequestId);
		tr.appendChild(tdName);
		tr.appendChild(tdRequestAmount);
		tr.appendChild(tdManagerName);
		tr.appendChild(tdRequestReason);
		if(ajaxObject[i].status == null){
			tr.appendChild(tdApprove);
			tr.appendChild(tdDeny);
		}
		document.getElementById("listbody").appendChild(tr);

	}

}


function createTable2(reimburse) {
	
	for (var i = 0; i < reimburse.length; i++) {
		var row = document.createElement("tr");
		
		var tdName = document.createElement("td");
		var tdTime = document.createElement("td");
		var tdAmount = document.createElement("td");
		var tdManager = document.createElement("td");
		var tdReason = document.createElement("td");
		
		
		tdName.textContent = reimburse[i].firstname + " " + reimburse[i].lastname;
		tdTime.textContent = reimburse[i].time;
		tdAmount.textContent = reimburse[i].amount;
		tdManager.textContent = reimburse[i].manager;
		tdReason.textContent = reimburse[i].reason;
		
		tr.appendChild(tdName);
		tr.appendChild(tdTime);
		tr.appendChild(tdAmound);
		tr.appendChild(tdManager);
		tr.appendChild(tdReason);
		
		document.getElementById("listbody").appendChild(tr);
	}
}

