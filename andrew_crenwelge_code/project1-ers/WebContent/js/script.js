// requires jQuery
$(document).ready(function(){
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

      }
      error: function(){

      }
    })
  }
  function getAllResolved(){
    $.ajax({
      url: "",
      method: "GET",
      success: function(){

      }
      error: function(){

      }
    })
  }
  function getAllEmployees(){
    $.ajax({
      url: "",
      method: "GET",
      success: function(){

      }
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
      }
      success: function(rtnData){
        console.log(rtnData);
      }
      error: function(err){
        console.log(err);
      }
    })
  }

  function getAllPendingForEmployee(){
  }
  function getAllResolvedForEmployee() {
  }

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
