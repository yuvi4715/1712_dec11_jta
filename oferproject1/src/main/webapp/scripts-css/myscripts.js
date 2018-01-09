
function show(elem){
	   if(elem.value == "Other")
		{
		      document.getElementById('hiddenDiv').style.visibility = "visible";
		}
	   else
		   {
		      document.getElementById('hiddenDiv').style.visibility = "hidden";
		   }
	}
    
    var myInput = document.getElementById("upass1");
    var myInput2 = document.getElementById("upass2");
    // When the user clicks on the password field, show the message box
    myInput.onfocus = function() {
        document.getElementById("message").style.display = "block";
    }
    
    // When the user clicks outside of the password field, hide the message box
    myInput.onblur = function() {
        document.getElementById("message").style.display = "none";
    }
    
    function checkPass()
    {
          
      var pass1 = document.getElementById("upass1");
      var pass2 = document.getElementById("upass2");
      var message = document.getElementById('confirmMessage');
   
      var goodColor = "#66cc66";
      var badColor = "#ff6666";
       
      if(pass1.value == pass2.value){
        
          pass2.style.backgroundColor = goodColor;
          pass1.style.backgroundColor = goodColor;
          message.style.color = goodColor;
          message.innerHTML = "New Passwords Match!"
      }else{
          pass2.style.backgroundColor = badColor;
          pass1.style.backgroundColor = badColor;
          message.style.color = badColor;
          message.innerHTML = "New Passwords Do Not Match!"
      }
       	  
    }
    
    function checkPass2()
    {
          
      var pass1 = document.getElementById("opass1");
      var pass2 = document.getElementById("password");
      var message = document.getElementById('confirmMessage');
   
      var goodColor = "#66cc66";
      var badColor = "#ff6666";
       
      if(pass1.value == pass2){
        
          pass1.style.backgroundColor = goodColor;
          message.style.color = goodColor;
          message.innerHTML = "Password Matches!"
      }else{
          pass1.style.backgroundColor = badColor;
          message.style.color = badColor;
          message.innerHTML = "Password Does Not Match!"
      }
       	  
    }
    
     