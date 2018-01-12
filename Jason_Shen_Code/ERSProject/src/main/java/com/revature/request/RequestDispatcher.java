package com.revature.request;

import javax.servlet.http.HttpServletRequest;

import com.revature.controller.RegisterController;
import com.revature.controller.TicketController;
import com.revature.controller.UpdateInfoController;
import com.revature.controller.HomeController;
//import com.revature.controller.LoginController;
import com.revature.controller.LoginController;
import com.revature.controller.LogoutController;
import com.revature.controller.ManagerController;

/* Class that helps the MasterServlet with mappings to specific controllers */
public class RequestDispatcher {
	
	public static String process(HttpServletRequest request) {
		switch(request.getRequestURI()) {
		case "/ERSProject/login.do":
			return LoginController.login(request);
		case "/ERSProject/home.do":
			return HomeController.home(request);
		case "/ERSProject/register.do":
			return RegisterController.register(request);
		case "/ERSProject/newTicket.do":
			return TicketController.newTicket(request);
		case "/ERSProject/logout.do":
			return LogoutController.logout(request);
		case "/ERSProject/updateInfo.do":
			return UpdateInfoController.updateInfo(request);
		case "/ERSProject/managerPortal.do":
			return ManagerController.enterPortal(request);			
		default:
			return "404.jsp";
		}
	}
}
