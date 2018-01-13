package com.revature.controller;
import javax.servlet.http.HttpServletRequest;
import com.revature.service.EmployeeService;

public class GetStatusContent {
	

	public static String returnApprov(HttpServletRequest request) {
		
		String reqApprove = request.getQueryString();
		String[] parts = reqApprove.split("=");
		String part2 = parts[1];
        int myNumber = Integer.parseInt(part2);
		boolean approved =  EmployeeService.getEmployeeService().sApproved(myNumber);
          
		if(approved == true) {
		request.setAttribute("approved", true);
         return "manager.jsp";				
		} else {
		 return "manager.jsp";
		}

	        }
    public static String returnDisapprove(HttpServletRequest request) {
		
    	String reqDisapprove = request.getQueryString();
		String[] parts = reqDisapprove.split("=");
		String part2 = parts[1];
        int Number = Integer.parseInt(part2);
		boolean approved =  EmployeeService.getEmployeeService().sDisapproved(Number); 
		if(approved == true) {
		request.setAttribute("denied", true);
         return "manager.jsp";				
		} else {
		 return "manager.jsp";
		}  
       }
	}     