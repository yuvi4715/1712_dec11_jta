package com.revature.request;

import javax.servlet.http.HttpServletRequest;

import com.revature.controller.EmployeeHomepageController;
//import com.revature.controller.HomeController;
import com.revature.controller.LoginController;
import com.revature.controller.ManagerHomepageController;
import com.revature.controller.PendingController;
import com.revature.controller.RegistrationController;
import com.revature.controller.SignoutController;

/* Class that helps the MasterServlet with mappings to specific controllers */
public class RequestHelper {
	
	public static String process(HttpServletRequest request) {
		switch(request.getRequestURI()) {
		case "/ExpenseReimburementSystem/login.do":
			//System.out.println("Directing to login controller...");
			return LoginController.login(request);
		case "/ExpenseReimburementSystem/employeehomepage.do":
			return EmployeeHomepageController.emp(request);
		case "/ExpenseReimburementSystem/managerhomepage.do":
			return ManagerHomepageController.man(request);
		case "/ExpenseReimburementSystem/registration.do":
			return RegistrationController.registration(request);
//		case "/ExpenseReimburementSystem/pending.do":
//			return PendingController.emp(request);	
		case "/ExpenseReimburementSystem/signout.do":
			return SignoutController.signout(request);
		
		default:
			return "404.jsp";
		}
	}
}
