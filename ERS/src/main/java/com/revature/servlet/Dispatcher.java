package com.revature.servlet;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.controller.*;


public class Dispatcher {
	
	public static Object send(HttpServletRequest request, HttpServletResponse response) {
		if (request.getRequestURI().equals("/ERS/html/login.do")) {
			return CredentialController.login(request, response);
		}
		else if(request.getCookies().length >= 4){
			establishCookies(request, response);
			System.out.println(request.getRequestURI());
			switch(request.getRequestURI()) {
			case "/ERS/reimburse.AJAX":
			case "/ERS/html/reimburse.AJAX":
				return ReimbursementController.getReimubrsements(request, response);
			case "/ERS/names.AJAX":
			case "/ERS/html/names.AJAX":
				return ReimbursementController.getNames(request, response);
			case "/ERS/changePassword.AJAX":
			case "/ERS/html/changePassword.AJAX":
				//TODO implement this after cookies are complete
				//for now, this stub..
				return CredentialController.changePassword(request, response);
				//return "";
			case "/ERS/html/employeeGetReimbursements.AJAX":
				return ReimbursementController.getReimbursementsByEmployeeUsername(request);
			case "/ERS/html/setStatus.AJAX":
				return ReimbursementController.setStatus(request, response);
			case "/ERS/html/reimburseAllEmployee.AJAX":
				return ReimbursementController.getAllEmployeeReimbursements(request, response);
			case "/ERS/html/reimburseAll.AJAX": //Check these params to see if they're needed
				return ReimbursementController.getAllReimbursements();
			case "/ERS/html/reimburseAllType.AJAX": //Check these params to see if they're needed
				return ReimbursementController.getAllReimbursementsInType(request, response);
			case "/ERS/html/userInfo.AJAX":
				return CredentialController.getUserInfo(request, response);
			case "/ERS/html/employeeInfo.AJAX":
				return CredentialController.getEmployeeInfo(request, response);
			case "/ERS/html/logout.do":
			default:
				System.out.println("You have been logged out: Dispatcher");
				CredentialController.logout(request, response);
				return "/html/index.html";
			}
		}
		return "/html/index.html";
	}
	
	private static void establishCookies(HttpServletRequest request, HttpServletResponse response) {
		for(Cookie c : request.getCookies()) {
			c.setMaxAge(20 * 60);
			response.addCookie(c);
		}
	}
}
