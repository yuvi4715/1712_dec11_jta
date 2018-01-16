


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
	jhttp.open("POST","http://localhost:8080/ERS/html/names.AJAX",true);
	jhttp.send();
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
			button2.innerHTML = "DENY";
		}
		//write button logic if this is unresolved
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

