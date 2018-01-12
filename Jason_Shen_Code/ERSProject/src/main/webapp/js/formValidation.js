function matchingPasswords() {
    var x = document.forms["registerform"]["password"].value;
    var y = document.forms["registerform"]["passwordconfirm"].value;

    if (x !== y) {
        document.getElementById("formerror").innerHTML = "Passwords do not match";
        return false;
    }
}

function emailExists() {
	var email = document.getElementsByName("email").value;
	
}