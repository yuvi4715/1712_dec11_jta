/**
 * 
 */
window.onload = function(){
	document.getElementById("signout")
		.addEventListener("click", signout);
}
function signout(){
    //document.getElementById('signout').onclick=function(){
    	//session.invalidate();
    	response.sendRedirect("../../Login.html");
    //	};
    	console.log(5 + 6);
}
window.onload=init;