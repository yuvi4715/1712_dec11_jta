$(document).ready(function() {
	alert("Document ready");
	var save = {
		updateInfo : function() {
			console.log("updateInfo function entered");
			$inputs = $("#updateInfoForm input");
			console.log($inputs.eq(1).val());
			console.log($inputs.eq(2).val());
			console.log($inputs.eq(3).val());
			console.log($inputs.eq(4).val());
			var formData = {
				password : $inputs.eq(1).val(),
				firstName : $inputs.eq(2).val(),
				lastName : $inputs.eq(3).val(),
				email : $inputs.eq(4).val()
			};
			$.ajax({
				url : 'UpdateInfo',
				method : "POST",
				data : $.param(formData), //sends form input values
				success : function(data) { //post is void; returns same data
					alert("Ajax updating profile info");
					console.log(data);
					$inputs.eq(1).val(data.password); //update view with form input values
					$inputs.eq(2).val(data.firstName);
					$inputs.eq(3).val(data.lastName);
					$inputs.eq(4).val(data.email);
					//handleSuccess(data);
				}
			//error: util.handleErr
			});
		}
	};
})