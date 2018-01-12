package com.revature.frontController;

import javax.servlet.http.HttpServletRequest;

import com.revature.controller.HomeController;
import com.revature.controller.LoginController;

/* Class that helps the MasterServlet with mappings to specific controllers */
public class RequestHelper {
	
	public static String process(HttpServletRequest request) {
		//System.out.println("Request Helper.process");
		switch(request.getRequestURI()) {
		case "/Revature_Employee_Reimbursment/login.do":
			//System.out.println("Going to login controller");
			return LoginController.login(request);
		case "/Revature_Employee_Reimbursment/home.do":
			//System.out.println("Goint to home Controler");
			return HomeController.home(request);
		default:
			//System.out.println("Request helper gave defalut");
			return "404.jsp";
		}
	}
}
