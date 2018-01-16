



//document.getElementById("insertReimbursement").addEventListener("click",insertPending);
document.getElementById("reimburseBtn").addEventListener("click",getReimbursements);
var e;
const approve = "APPROVED";
const deny = "DENIED";
var employeeJSON = null;

function getReimbursement(){
	if(e !== 0){
	var jhttp = new XMLHttpRequest();
	
	var getType = new Object;
	var reimburseType = document.getElementById("type").value;
	getType.type = reimburseType;
	getType.eid = e;
	document.getElementById("listbody").innerHTML = "";
	
	jhttp.onreadystatechange = function() {
		if(this.readyState == 4 && this.status == 200){
			var reimburseJSON = JSON.parse(this.responseText);
			createTable(reimburseJSON);
			
		}
	}
	jhttp.open("POST","http://localhost:8080/ERS/html/reimburse.AJAX",true);
	jhttp.send(JSON.stringify(getType));
	}
	else{
		
	}
}
function getReimbursements(){
	var jttp = new XMLHttpRequest();
	//var getType = document.getElementById("");
	if(reimburseType == "all" || reimburseType == undefined){
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
		jhttp.open("POST","http://localhost:8080/ERS/html/employeeGetReimbursements.AJAX",true);
		jhttp.send(JSON.stringify(getType));
	}
}

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

function getAllReimbursements(){
	var jttp= new XMLHttpRequest();
	jttp.onreadystatechange = function() {
		if(this.readyState == 4 && this.status == 200){
			var reimburseAllJSON = JSON.parse(this.responseText);
			createTable(reimburseAllJSON);
		}
	}
	jttp.open("POST", "http://localhost:8080/ERS/html/reimburseAll.AJAX");
	jttp.send();
}

function createTable(reimburse){
	for(var i = 0; i < reimburse.length; i++){
		var rows = document.createElement("tr");
		var id = rows.appendChild(document.createElement("td"));
		id.innerHTML = reimburse[i].id;
		var name = rows.appendChild(document.createElement("td"));
		name.textContent = reimburse[i].firstname + " " + reimburse[i].lastname;
		var amount = rows.appendChild(document.createElement("td"));
		amount.innerHTML = reimburse[i].amount;
		var manager = rows.appendChild(document.createElement("td"));
		amount.innerHTML = reimburse[i].manager;
		var reason = rows.appendChild(document.createElement("td"));
		reason.innerHTML = reimburse[i].reason;
		document.getElementById("listbody").appendChild(rows);
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

