var a = 10;
var b = true;
var c = "jason";
var d = {};
var e = NaN;
var f = function() {
	var foo = function() {
		return false;
	}
	return true;
};

console.log(typeof(a), typeof(b), typeof(c), typeof(d), typeof(e), typeof(f));

// whenever you use + operator, turns everything into a string
console.log(a + "10");
console.log(b + "10");
console.log(c + "10");
console.log(d + "10");
console.log(e + "10");
console.log(f + "10");

var g = null;
console.log(typeof(g));
console.log(10 - '22');
console.log(NaN === NaN);
console.log("abc" - "def");
console.log(10/"10");


var incrementer = function() {
	var counter = 0;
	return function() {
		counter +=1;
		console.log(counter);
		return counter;
	}();
}

incrementer();
incrementer();
incrementer();

var x = 10;
var ten = '10';


console.log(typeof(ten));