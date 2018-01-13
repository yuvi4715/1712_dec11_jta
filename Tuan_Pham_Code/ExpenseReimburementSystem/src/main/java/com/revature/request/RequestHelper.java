package com.revature.request;

import javax.servlet.http.HttpServletRequest;

import com.revature.controller.EmployeeHomepageController;
//import com.revature.controller.HomeController;
import com.revature.controller.LoginController;
import com.revature.controller.ManagerHomepageController;
import com.revature.controller.ReimbursementController;
import com.revature.controller.SignoutController;
import com.revature.controller.UpdateController;

/* Class that helps the MasterServlet with mappings to specific controllers */
public class RequestHelper {
	
	public static String process(HttpServletRequest request) {
		switch(request.getRequestURI()) {
		case "/ExpenseReimburementSystem/login.do":
			return LoginController.login(request);
		case "/ExpenseReimburementSystem/employeehomepage.do":
			return EmployeeHomepageController.emp(request);
		case "/ExpenseReimburementSystem/managerhomepage.do":
			return ManagerHomepageController.man(request);
		case "/ExpenseReimburementSystem/signout.do":
			return SignoutController.signout(request);
		case "/ExpenseReimburementSystem/update.do":
			return UpdateController.updateEmployee(request);
		case "/ExpenseReimburementSystem/submit.do":
			return ReimbursementController.submit(request);	
		default:
			return "404.jsp";
		}
	}
}
