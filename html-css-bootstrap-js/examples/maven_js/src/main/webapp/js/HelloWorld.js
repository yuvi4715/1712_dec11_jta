/**
 * 
 */

"use strict";
console.log("result of multiplication: ", multiply(40,50));

var a = 10;
console.log(a);

//document.write('never use document.write');
//alert("hello world"); //not a good practice - because we forget to remove them in prod

console.log("print this") // best practice

var x = 10; var y = 20;		//global scope
function add(){
	var c = 40;		//local scope
	return (x + y);
}

console.log(add);
console.log(add());
//console.log(c);

//function can be used as variable
//functions can be anonymous
var f1 = function(){
	return true;
}

console.log(f1());

//create function using constructor
var f2 = new Function ("x", "y", "return (x * y)");

console.log(f2(20,30));

//used for hoisting example 
function multiply(d, e){
	return d * e;
}

console.log("result of multiplication: ", multiply(40,50));

//self invoking

(function printMessage(){
	console.log("does self invoking really work????");
})();

//anonymous and self invoking function
(function (){
	console.log("anonymous and self invoking, Huh????");
})();

console.log(multiply(10));
console.log(multiply(10,10));
console.log(multiply(10,10,20));		//ignores the extra arguments
console.log(multiply(10,10,20,30));	

function changeValues(g){
	g += ", How are you?";
	console.log(g);
	return g;
}

var h = changeValues("Tom");
console.log(h);

//overloading 
function multiply(d, e, i){
	return d * e * i;
}

console.log(multiply(10,20));

function Person(age, name){
	this.age = age;
	this.name = name;
}

var tom = new Person(25, "Tom")
var mike = new Person(10, "Mike")

console.log(tom.age);
console.log(mike.age);
mike.age = 11;
console.log(mike.age);

var myVar;	// global scope

function assignValue(){
	myVar = 10;
}

assignValue();
console.log("myVar", myVar);

//create object using new 
var player = new Object();
var playerName = "Marshawn Lynch";
var playerScore = "100";

player.name = playerName;
player.score = playerScore;

var player1 = {name: "Joe Montana", score: 600 , rank : 2};
var player2 = {name: "Tom Brady", score: 650 , rank : 1};

console.log(player1.name);

function printPlayerInfo(){
	console.log(this.name + " scored totally - " + this.score);
}

player1.info = printPlayerInfo;
player2.info = printPlayerInfo;

console.log(player1.info());
console.log(player2.info());


//closure

var counter;
function f3(){
	counter = 0;
	counter += 1;
}

f3();
console.log(counter);
f3();
console.log(counter);
f3();
console.log(counter);
f3();
console.log(counter);


var add2 = (function f4(){
	var cc = 0;
	return (function (){
		cc += 1;
		console.log("cc ", cc);
		return cc; 
		}
	);	
})();


var add = (function(){
	var dd = 0;
	return (function (){ return dd+=1; })
})();

console.log(add());
console.log(add());
console.log(add());
console.log(add());

add2();
add2();
add2();
add2();

function f4(){
	var ee = 0;
	(function f5(){
		var ff = 0;
		(function f6(){
			var gg = 0;
			console.log("gg", ++gg);
			console.log("ee", ++ee);
			console.log("ff", ++ff);
		})();
		//console.log("gg", ++gg);
		console.log("ee", ++ee);
		console.log("ff", ++ff);
	})(); 
	console.log("ee", ++ee);
	//console.log("ff", ++ff);
}


f4();

