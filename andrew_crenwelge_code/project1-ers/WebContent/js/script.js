// requires jQuery
$(document).ready(function(){
  var old = {
    updateInfo: function(){
      console.log("Attempting to update this employee's info...");
      $inputs = $("#emp-info-form input");
      console.log($inputs.eq(3).val());
      console.log($inputs.eq(5).val());
      console.log($inputs.eq(6).val());
      console.log($inputs.eq(7).val());
      console.log($inputs.eq(8).val());
      console.log($inputs.eq(9).val());
      var dataToSend = {
        email: $inputs.eq(3).val(),
        phoneNumber: $inputs.eq(5).val(),
        address: $inputs.eq(6).val(),
        city: $inputs.eq(7).val(),
        state: $inputs.eq(8).val(),
        country: $inputs.eq(9).val(),
        zip: $inputs.eq(10).val()
      };
      $.ajax({
        url: 'UpdateEmployeeInfo',
        method: "POST",
        data: $.param(dataToSend),
        success: function(rtnData) {
          console.log(rtnData);
          $inputs.eq(3).val(rtnData.email);
          $inputs.eq(5).val(rtnData.phoneNumber);
          $inputs.eq(6).val(rtnData.address);
          $inputs.eq(7).val(rtnData.city);
          $inputs.eq(8).val(rtnData.state);
          $inputs.eq(9).val(rtnData.country);
          $inputs.eq(10).val(rtnData.zip);
          handleSuccess(rtnData);
        },
        error: util.handleErr
      });
    }
  };
  var util = {
    appendTable: function($jqObj,data,colsToMatch,hasReceiptBtn,hasApproveBtn) {
      $jqObj.children().remove();
      var jsdata = JSON.parse(data);
      for (var i=0;i<data.length;i++) {
        var obj = jsdata[i];
        console.log(obj);
        var $row = $(document.createElement('tr'));
        for (var j=0;j<colsToMatch.length;j++) {
          var column = colsToMatch[j];
          if (obj.hasOwnProperty(column)) {
            var text;
            if (obj[column] != null) {text = obj[column];}
            else {text = "N/A";}
            var $td = $(document.createElement('td'));
            $td.text(text);
            $row.append($td);
          }
        }
        if (hasReceiptBtn) {
          $row.append("<td><button class='btn btn-info'>View Receipt</button></td>");
        }
        if (hasApproveBtn) {
          $row.append("<td><button class='btn btn-success approve'>Approve</button><button class='btn btn-success deny'>Deny</button></td>");
        }
        $jqObj.append($row);
      }
    },
    handleErr: function(errMsg) {
      console.log(errMsg);
      $("#sucessdiv").addClass("hideme");
      $("#errordiv").text(errMsg).removeClass("hideme");
    },
    handleSuccess: function(successMsg) {
      console.log(successMsg);
      $("#errdiv").addClass("hideme");
      $("#sucessdiv").text(successMsg).removeClass("hideme");
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
          var cols = ['reqID','reqTitle','description','amount','status','dateSubmitted','dateResolved','mgrID'];
          util.appendTable($tbody,rtnData,cols);
        },
        error: util.handleErr
      });
    },
  };
  var mgrfuncs = {
    getAllPending: function() {
      console.log("Getting all pending requests for all employees");
      $.ajax({
        url: "ManagerGetPending",
        method: "GET",
        success: function(rtnData){
          console.log(rtnData);
          var $tbody = $("#pending").find('tbody');
          var columns = ['reqID','reqTitle','description','amount','empID','dateSubmitted'];
          util.appendTable($tbody,rtnData,columns,true,true);
        },
        error: util.handleErr
      });
    },
    getAllResolved: function(){
      console.log("Getting all resolved requests for all employees...");
      $.ajax({
        url: "ManagerGetResolved",
        method: "GET",
        success: function(rtnData){
          console.log(rtnData);
          var $tbody = $("#resolved").find('tbody');
          var columns = ['reqID','reqTitle','description','status','amount','empID','mgrID','dateResolved'];
          util.appendTable($tbody,rtnData,columns,true,false);
        },
        error: util.handleErr
      });
    },
    getAllEmployees: function(){
      console.log("Getting all employees...");
      $.ajax({
        url: "ManagerGetAllEmployees",
        method: "GET",
        success: function(rtnData){
          console.log(rtnData);
          var $tbody = $("all-employees").find('tbody');
          var columns = ['empID','firstname','lastname'];
          util.appendTable($tbody,rtnData,columns);
        },
        error: util.handleErr
      });
    },
    getAllRequestsForEmployee: function(){
      console.log("Getting all requests for the employee selected...");
      var eid = $("#employeeID").val();
      $.ajax({
        url: "ManagerGetRequestForEmployee",
        method: "GET",
        data: {
          employeeID: eid
        },
        success: function(rtnData){
          console.log(rtnData);
          var $tbody = $("#reqbyemployee").find('tbody');
          var columns = ['reqID','reqTitle','status','amount','mgrID','dateSubmitted','dateResolved'];
          $tbody.children().remove();
          var jsdata = JSON.parse(data);
          for (var i=0;i<data.length;i++) {
            var obj = jsdata[i];
            var $row = $(document.createElement('tr'));
            for (var j=0;j<columns.length;j++) {
              var column = columns[j];
              if (obj.hasOwnProperty(column)) {
                var text;
                if (obj[column] != null) {text = obj[column];}
                else {text = "N/A";}
                var $td = $(document.createElement('td'));
                $td.text(text);
                $row.append($td);
              }
            }
            if (hasReceiptBtn) {
              $row.append("<td><button class='btn btn-info'>View Receipt</button></td>");
            }
            if (hasApproveBtn) {
              $row.append("<td><button class='btn btn-success approve'>Approve</button><button class='btn btn-success deny'>Deny</button></td>");
            }
            $tbody.append($row);
          }
        },
        error: util.handleErr
      });
    },
    approveRequest: function(){
      console.log("Attempting to approve request #");
      var requestID = Number($(this).parent().children().first().text());
      $.ajax({
        url: "ApproveRequest",
        method: "POST",
        data: $.param(requestID),
        success: util.handleSuccess,
        error: util.handleErr
      });
    },
    denyRequest: function(){
      console.log("Attempting to deny request #");
      var requestID = Number($(this).parent().children().first().text());
      $.ajax({
        url: "DenyRequest",
        method: "POST",
        data: $.param(requestID),
        success: util.handleSuccess,
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
    //$("#manager-all-pending").on('click', mgrfuncs.getAllPending);
    //$("#manager-all-resolved").on('click', mgrfuncs.getAllResolved);
    //$("#manager-all-employees").on('click', mgrfuncs.getAllEmployees);
    $("#searchReqByEmp").on('click', mgrfuncs.getAllRequestsForEmployee);
    $(".approve").on('click', mgrfuncs.approveRequest);
    $(".deny").on('click', mgrfuncs.denyRequest);

    // EmployeeRequestView ajax requests
    $("#employee-pending").on('click', emplfuncs.getAllPending);
    $("#employee-resolved").on('click', emplfuncs.getAllResolved);
  };
  initEventListeners();
});
