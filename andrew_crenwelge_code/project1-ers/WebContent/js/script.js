// requires jQuery
$(document).ready(function(){
  var util = {
    appendTable: function($jqObj,data,hasViewBtn,Btntext) {
      for (var key in data) {
        var columns = data[key].length;
        var $row = $(document.createElement('tr'));
        for (var i=0;i<columns;i++) {
          var $td = $(document.createElement('td'));
          $td.text(data[key][i]);
          $row.append($td);
        }
        if (hasViewBtn) {
          $row.append("<td><button class='btn btn-info'>"+Btntext+"</button></td>");
        }
        $jqObj.append($row);
      }
    }
  };
  var emplfuncs = {
    getAllPending: function(){
      $.ajax({
        url: "",
        method: "GET",
        success: function(rtnData){
          console.log(rtnData);
          var $tbody = $("#pending-requests").find('tbody');
          util.appendTable($tbody,rtnData);
        },
        error: function(err) {
          console.log(err);
        }
      });
    },
    getAllResolved: function() {
      $.ajax({
        url: "",
        method: "GET",
        success: function(rtnData){
          console.log(rtnData);
          var $tbody = $("#resolved-requests").find('tbody');
          util.appendTable($tbody,rtnData);
        },
        error: function(err) {
          console.log(err);
        }
      });
    },
    updateInfo: function(){
      $inputs = $("#emp-info-form input");
      $.ajax({
        url: '/UpdateEmployeeInfo',
        method: POST,
        data: {
          "email": $inputs.get(3),
          "phoneNumber": $inputs.get(5),
          "address": $inputs.get(6),
          "city": $inputs.get(7),
          "state": $inputs.get(8),
          "country": $inputs.get(9),
          "zip": $inputs.get(10),
        },
        success: function(rtnData) {
          $inputs.get(3).val(rtnData.email);
          $inputs.get(5).val(rtnData.phoneNumber);
          $inputs.get(6).val(rtnData.address);
          $inputs.get(7).val(rtnData.city);
          $inputs.get(8).val(rtnData.state);
          $inputs.get(9).val(rtnData.country);
          $inputs.get(10).val(rtnData.zip);
        },
        error: function(err) {
          $("#errordiv").text(err.errMsg);
        }
      });
    }
  };
  var mgrfuncs = {
    getAllPending: function() {
      $.ajax({
        url: "",
        method: "GET",
        success: function(rtnData){
          console.log(rtnData);
          var $tbody = $("#pending").find('tbody');
          util.appendTable($tbody,rtnData);
        },
        error: function(err){
          console.log(err);
        }
      });
    },
    getAllResolved: function(){
      $.ajax({
        url: "",
        method: "GET",
        success: function(rtnData){
          console.log(rtnData);
          var $tbody = $("#resolved").find('tbody');
          util.appendTable($tbody,rtnData);
        },
        error: function(err){
          console.log(err);
        }
      });
    },
    getAllEmployees: function(){
      $.ajax({
        url: "",
        method: "GET",
        success: function(rtnData){
          console.log(rtnData);
          var $tbody = $("all-employees").find('tbody');
          util.appendTable($tbody,rtnData);
        },
        error: function(err){
          console.log(err);
        }
      });
    },
    getAllRequestsForEmployee: function(){
      var text = $("#empName").val();
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
          var $tbody = $("#reqbyemployee").find('tbody');
          util.appendTable($tbody,rtnData);
        },
        error: function(err){
          console.log(err);
        }
      });
    }
  };
  var initEventListeners = function(){
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
    });
    $("#manager-all-pending").on('click', mgrfuncs.getAllPending);
    $("#manager-all-resolved").on('click', mgrfuncs.getAllResolved);
    $("#manager-all-employees").on('click', mgrfuncs.getAllEmployees);
    $("#searchReqByEmp").on('click', mgrfuncs.getAllRequestsForEmployee);

    $("#employee-all-pending").on('click', emplfuncs.getAllPending);
    $("#employee-all-resolved").on('click', emplfuncs.getAllResolved);

    $("#updateInfo").on('click', emplfuncs.updateEmpInfo);
  };
  initEventListeners();
});
