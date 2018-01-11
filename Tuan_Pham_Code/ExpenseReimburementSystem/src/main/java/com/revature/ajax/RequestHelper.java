package com.revature.ajax;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.controller.CheckUsernameController;
import com.revature.controller.PendingController;
import com.revature.controller.ResolvedController;
import com.revature.util.FinalUtil;

/* Request helper specifically for AJAX requests */
public class RequestHelper {
	
	public static Object process(HttpServletRequest request, HttpServletResponse response) {
		switch(request.getRequestURI()) {
		case "/ExpenseReimburementSystem/checkUsername.ajax":
			return CheckUsernameController.checkUsername(request, response);
		case "/ExpenseReimburementSystem/getPending.ajax":
			return PendingController.getPending(request, response);
		case "/ExpenseReimburementSystem/getResolved.ajax":
			return ResolvedController.getResolved(request, response);
		default:
			return new AjaxMessage(FinalUtil.NOT_IMPLEMENTED);
		}
	}
}
