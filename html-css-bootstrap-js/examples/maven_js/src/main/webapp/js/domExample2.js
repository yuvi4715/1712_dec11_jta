console.log("did the page load?");
var d = document;
var c = console;

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