console.log("did the page load?");
var d = document;
var c = console;

//simple event listener example
window.onload = function (){
	c.log("page should be loaded now");
	
	//creating an object for add button
	var addNumbers = d.getElementById("addBtn")
	
	//add event listeners for this button when a click occurs 
	addNumbers.addEventListener("click", anotherFunction);
	addNumbers.addEventListener("click", function(){
		var n1 = parseInt(d.getElementById("num1").value);
		var n2 = parseInt(d.getElementById("num2").value);
		
		//c.log("num1 ", typeof(n1));
		//c.log("num2 ", typeof(n2));
		
		var output = n1 + n2; 
		d.getElementById("results").value = output;
		
	});
	
	function anotherFunction(){
		c.log("button was clicked");
	}
}


window.onload = function(){
	//callback function - simplest example
	var c1 = function(msg){
		console.log(msg);
	}

	function run(c2){
		c2('running call back function');
	}

	c1("this is not call back");
	run(c1);
}



