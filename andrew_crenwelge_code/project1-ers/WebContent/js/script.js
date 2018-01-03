// requires jQuery
$(document).ready(function(){
  $("#request-dropdown").on('click',function(){
	  $("#dropme").slideDown();
  });
  $("#closenewreq").on('click',function(){
	  $("#dropme").slideUp();
  });
  $("#edit-profile").on('click',function(){
	  $("#edit-profile").hide();
	  $("#save-profile").show();
	  $("#cancel-profile-update").show();
	  $("#emp-info-form input").each(function(index){
		  console.log($(this).next().text());
		  if (index != 0 && index != 1 && index != 4) {
			  $(this).val($(this).next().text());
			  $(this).removeClass('hidden');
			  $(this).next().hide();
		  }
	  });
  });
  $("#cancel-profile-update").on('click',function(){
	  $("#edit-profile").show();
	  $("#save-profile").hide();
	  $("#cancel-profile-update").hide();
	  var $allinput = $("#emp-info-form input");
	  var $allstatic = $("#emp-info-form p.form-control-static");
	  $allinput.addClass('hidden');
	  $allstatic.show();
  })
  $("#manager-all-pending").on('click', getAllPending);
  $("#manager-all-resolved").on('click', getAllResolved);
  $("#manager-all-employees").on('click', getAllEmployees);
  $("#searchReqByEmp").on('click', getAllRequestsForEmployee);

  $("#employee-all-pending").on('click', getAllPendingForEmployee);
  $("#employee-all-resolved").on('click', getAllResolvedForEmployee);

  $("#updateInfo").on('click', updateEmpInfo);

  function getAllPending() {
    $.ajax({
      url: "",
      method: "GET",
      success: function(){

      },
      error: function(){

      }
    });
  }
  function getAllResolved(){
    $.ajax({
      url: "",
      method: "GET",
      success: function(){

      },
      error: function(){

      }
    })
  }
  function getAllEmployees(){
    $.ajax({
      url: "",
      method: "GET",
      success: function(){

      },
      error: function(){

      }
    })
  }
  function getAllRequestsForEmployee(){
    var text = $("empName").val();
    var firstName = text.split(" ")[0];
    var lastName = text.split(" ")[1];
    $.ajax({
      url: "",
      method: "GET",
      data: {
        firstName: firstName,
        lastName: lastName
      },
      success: function(rtnData){
        console.log(rtnData);
      },
      error: function(err){
        console.log(err);
      }
    })
  }

  function getAllPendingForEmployee(){}
  function getAllResolvedForEmployee() {}

  function updateEmpInfo() {
    $.ajax({
      url: '/UpdateEmployeeInfo',
      method: POST,
      data: {

      },
      success: function(rtnData) {

      },
      error: function(err) {

      }
    })
  }
})
