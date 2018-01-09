package com.revature.request;

import com.revature.controller.*;
import javax.servlet.http.HttpServletRequest;


/* Class that helps the MasterServlet with mappings to specific controllers */
public class RequestHelper {
	
	public static String process(HttpServletRequest request) {
		switch(request.getRequestURI()) {
		case "/oferproject1/login.do":
			return LoginController.login(request);
		case "/oferproject1/logout.do":
			return LogoutController.logout(request);
		case "/oferproject1/update.do":
			return UpdateController.update(request);
		case "/oferproject1/submit.do":
			return SubmitController.submit(request);
		case "/oferproject1/view.do":
			return ViewRequestController.view(request);
		default:
			return "404.jsp";
		}
	}
}
