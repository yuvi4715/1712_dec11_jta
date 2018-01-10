// requires jQuery
$(document).ready(function(){
  var util = {
    formatTime: function(time) {
      var formatted = String(new Date(time));
      if (formatted != 'Invalid Date') {
        return formatted;
      }
      else {
        return "N/A";
      }
    },
    appendTable: function($jqObj,data,colsToMatch,hasReceiptBtn,hasApproveBtn) {
      function formatTime() {}
      console.log("inside appendTable");
      console.log(data);
      $jqObj.children().remove();
      var empMap = data.map;
      var reqList = data.requestList;
      for (var i=0;i<reqList.length;i++) {
        var req = reqList[i];
        console.log(req);
        var $row = $(document.createElement('tr'));
        for (var j=0;j<colsToMatch.length;j++) {
          var column = colsToMatch[j];
          if (req.hasOwnProperty(column)) {
            var text;
            var value = req[column];
            if (value != null) {text = value;}
            else {text = "N/A";}
            if (column=='amount') {text = "$"+text;}
            else if (column=='dateSubmitted' || column=='dateResolved') {text = this.formatTime(text);}
            else if (column=='mgrID') {text = empMap[value];}
            var $td = $(document.createElement('td'));
            $td.text(text);
            $row.append($td);
          }
        }
        if (hasReceiptBtn) {
          $row.append("<td><button class='btn btn-info'>View Receipt</button></td>");
        }
        if (req.status == 'Pending' && hasApproveBtn==true) {
          $row.append("<td><button class='btn btn-success approve'>Approve</button>&ensp;<button class='btn btn-danger deny'>Deny</button></td>");
        }
        $jqObj.append($row);
      }
    },
    handleErr: function(errMsg) {
      console.log(errMsg);
      $("#successdiv").addClass("hideme");
      $("#errordiv").text(err).removeClass("hideme");
    },
    handleSuccess: function(successMsg) {
      console.log(successMsg);
      $("#errordiv").addClass("hideme");
      $("#successdiv").text(successMsg).removeClass("hideme");
    }
  };
  var emplfuncs = {
    getAllPending: function(){
      console.log("Getting all pending requests for this employee...");
      $.ajax({
        url: "EmployeeGetPending",
        method: "GET",
        success: function(rtnData){
          console.log(rtnData);
          var $tbody = $("#pending-requests").find('tbody');
          var cols = ['reqID','reqTitle','description','amount','dateSubmitted'];
          util.appendTable($tbody,rtnData,cols);
        },
        error: util.handleErr
      });
    },
    getAllResolved: function() {
      console.log("Getting all resolved requests for this employee...");
      $.ajax({
        url: "EmployeeGetResolved",
        method: "GET",
        success: function(rtnData){
          console.log(rtnData);
          var $tbody = $("#resolved-requests").find('tbody');
          var cols = ['reqID','reqTitle','description','status','amount','mgrID','dateSubmitted','dateResolved'];
          util.appendTable($tbody,rtnData,cols);
        },
        error: util.handleErr
      });
    },
  };
  var mgrfuncs = {
    getAllRequestsForEmployee: function(){
      var eid = $("#employeeID").val();
      console.log("Getting all requests for the employee #",eid);
      var dataToSend = {id: eid};
      $.ajax({
        url: "ManagerGetRequestsForEmployee",
        method: "POST",
        data: JSON.stringify(dataToSend),
        success: function(rtnData){
          console.log(rtnData);
          var $tbody = $("#reqbyemployee").find('tbody');
          var columns = ['reqID','reqTitle','description','status','amount','mgrID','dateSubmitted','dateResolved'];
          util.appendTable($tbody,rtnData,columns,true,true);
          $("#reqbyemployee .approve").on('click', mgrfuncs.approveRequest);
          $("#reqbyemployee .deny").on('click', mgrfuncs.denyRequest);
        },
        error: util.handleErr
      });
    },
    approveRequest: function(){
      var requestID = Number($(this).closest('tr').children().first().text());
      $(this).siblings().remove();
      $(this).remove();
      console.log("Attempting to approve request #",requestID);
      var objToSend = {
        id: requestID
      };
      $.ajax({
        url: "ApproveRequest",
        method: "POST",
        data: JSON.stringify(objToSend),
        success: function(rtnData) {
          if (rtnData.success) {
            util.handleSuccess(rtnData.successMsg);
          }
          else {
            util.handleErr(rtnData.errMsg);
          }
        },
        error: util.handleErr
      });
    },
    denyRequest: function(){
      var requestID = Number($(this).closest('tr').children().first().text());
      $(this).siblings().remove();
      $(this).remove();
      console.log("Attempting to deny request #",requestID);
      var objToSend = {
        id: requestID
      };
      $.ajax({
        url: "DenyRequest",
        method: "POST",
        data: JSON.stringify(objToSend),
        success: function(rtnData) {
          if (rtnData.success) {
            util.handleSuccess(rtnData.successMsg);
          }
          else {
            util.handleErr(rtnData.errMsg);
          }
        },
        error: util.handleErr
      });
    }
  };
  var initEventListeners = function(){
    // View manipulation on homepage
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
  		  console.log("Employee info form - input field "+(index+1)+": "+$(this).next().text());
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

    // ManagerRequestView ajax requests
    $("#searchReqByEmp").on('click', mgrfuncs.getAllRequestsForEmployee);
    $(".approve").on('click', mgrfuncs.approveRequest);
    $(".deny").on('click', mgrfuncs.denyRequest);

    // EmployeeRequestView ajax requests
    $("#employee-pending").on('click', emplfuncs.getAllPending);
    $("#employee-resolved").on('click', emplfuncs.getAllResolved);
  };
  initEventListeners();
});
