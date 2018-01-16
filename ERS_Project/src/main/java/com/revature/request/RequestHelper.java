package com.revature.request;

import javax.servlet.http.HttpServletRequest;

import com.revature.controller.ApproveController;
import com.revature.controller.DeclineController;
import com.revature.controller.EditController;
import com.revature.controller.EditPageController;
import com.revature.controller.HistoryController;
import com.revature.controller.HomeController;
import com.revature.controller.LoginController;
import com.revature.controller.LogoutController;
import com.revature.controller.NewController;
import com.revature.controller.NewPageController;
import com.revature.controller.ResolveController;
import com.revature.controller.ResolvePageController;

public class RequestHelper {
	
	public static String process(HttpServletRequest request) {
		
		System.out.println(request.getRequestURI());
		
		switch(request.getRequestURI()) {
		
		case "/ERS_Project/login.do":
			System.out.println("REQUESTHELPER LOGIN");
			return LoginController.login(request);
		
		case "/ERS_Project/home.do":
			System.out.println("REQUESTHELPER HOME");
			return HomeController.home(request);
			
		case "/ERS_Project/resolve_page.do":
			System.out.println("REQUESTHELPER RESOLVE PAGE");
			return ResolvePageController.resolve(request);
			
		case "/ERS_Project/resolve.do":
			System.out.println("REQUESTHELPER RESOLVE");
			return ResolveController.resolve(request);
			
		case "/ERS_Project/decline.do":
			System.out.println("APPROVE RESOLVE");
			return DeclineController.decline(request);
			
		case "/ERS_Project/approve.do":
			System.out.println("APPROVE RESOLVE");
			return ApproveController.approve(request);
			
		case "/ERS_Project/edit_page.do":
			System.out.println("REQUESTHELPER EDIT PAGE");
			return EditPageController.edit(request);
			
		case "/ERS_Project/edit.do":
			System.out.println("REQUESTHELPER EDIT");
			return EditController.edit(request);
			
		case "/ERS_Project/new_page.do":
			System.out.println("REQUESTHELPER NEW PAGE");
			return NewPageController.reimbursementForm(request);
		
		case "/ERS_Project/new.do":
			System.out.println("REQUESTHELPER NEW");
			return NewController.reimbursementForm(request);
			
		case "/ERS_Project/history.do":
			System.out.println("REQUESTHELPER HISTORY");
			return HistoryController.history(request);
			
		case "/ERS_Project/logout.do":
			System.out.println("REQUESTHELPER LOGOUT");
			return LogoutController.logout(request);
			
		default:
			System.out.println("REQUESTHELPER ERROR");
			return "Error.jsp";
		}
	}
	
	
	

}
