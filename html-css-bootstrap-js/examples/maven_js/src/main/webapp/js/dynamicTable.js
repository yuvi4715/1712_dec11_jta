/**
 * To find elements
================
document.getElementById(id)
document.getElementsByTagName(name)
document.getElementsByClassName(name)
document.querySelectorAll - css selectors

To change elements
=====================
element.innerHTML =  new html content
element.attribute = new value
element.setAttribute(attribute, value)
element.style.property = new style

To add and delete elements
============================
document.createElement(element)
document.removeChild(element)
document.appendChild(element)
document.replaceChild(element)
document.write(text)

Properties to navigate between nodes with JavaScript;
==========================================================
parentNode
childNodes[nodenumber]
firstChild
lastChild
nextSibling
previousSibling
 */
//print all properties and methods of an object
/*window.onload = function(){
	var ele = document.getElementById("formDiv");
	for (e in ele){
		console.log(e);
	}
}*/


window.onload = function(){
	document.getElementById("submitBtn").addEventListener("click", addRows);
	document.getElementById("submitBtn").addEventListener("click", clearValues);
	document.getElementById("clearBtn").addEventListener("click", clearValues);
}

function addRows(){
	var id = document.getElementById("eid").value;
	var name = document.getElementById("name").value;
	var age = document.getElementById("age").value;
	
	if (id && name && age){
		if(id.trim !="" && name.trim !="" && age.trim !="" ){
	
			//console.log("they have some values");
			var row = document.createElement("tr");
			var idcol = document.createElement("td");
			var namecol = document.createElement("td");
			var agecol = document.createElement("td");
			
			idcol.textContent = id;
			namecol.textContent = name;
			agecol.textContent = age;
			
			row.appendChild(idcol);
			row.appendChild(namecol);
			row.appendChild(agecol);
			
			document.getElementById("mytable").appendChild(row);		
			
		}			
	} else {
		console.log("no values typed")
	}
		

}

function clearValues(){
	document.getElementById("eid").value = "";
	document.getElementById("name").value = "";
	document.getElementById("age").value = "";
}

