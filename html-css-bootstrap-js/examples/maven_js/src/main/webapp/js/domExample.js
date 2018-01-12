/**
 * 
 */

var u = document.getElementById("user").value;
var p = document.getElementById("pass").value;
console.log(u);

var para = document.getElementById("newParagraph");

function changeParagraph(){
	para.innerHTML = "<p> user " + u + " is logged </p>";
	console.log("value - u & p ", u + " " + p);
}


function mouseHoverDOM(){
	document.getElementById("modifyThis").innerHTML = "Did it work???";
}

function mouseOutDOM(){
	document.getElementById("modifyThis").innerHTML = "Don't know the original value, hence this random text";
}


var user = document.getElementById("user");
var pass = document.getElementById("pass");

user.onfocus = function(){
	user.style.background = "lightblue";
	if(user.value == ''){
		user.placeholder = 'Please enter user name';
	}
};

user.onblur = function(){
	if(user.value == ''){
		user.style.background = "lightgray";
		user.value = '';
	}
}

