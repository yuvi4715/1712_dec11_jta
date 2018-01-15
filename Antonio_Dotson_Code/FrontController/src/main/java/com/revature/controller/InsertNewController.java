package com.revature.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.revature.model.Employee;
import com.revature.service.EmployeeService;

public class InsertNewController {

	public static String insertEmpl (HttpServletRequest request) {
			
	Boolean getServices =  EmployeeService.getEmployeeService().registerEmployee(
			new Employee(
					request.getParameter("lastname"),
					request.getParameter("firstname"),
					request.getParameter("title"),
			        Integer.parseInt(request.getParameter("managerid")),
					request.getParameter("birthdate"),
					request.getParameter("address"),
					request.getParameter("city"),
					request.getParameter("state"),
					request.getParameter("phone"),
					request.getParameter("email")
					
					));
	   
	   
	                 if (getServices = true) {
		                request.setAttribute("getServices", getServices);
		                      return "insertemployee.jsp";
	                  } else {
	                	
	                	     return "insertemployee.jsp";
	                  }
	       
	    }
	public static String updateManager (HttpServletRequest request) {
		 Employee loggedCustomer  =  EmployeeService.getEmployeeService().modifyEmployee(
    			new Employee(
    					request.getParameter("lastname"),
    					request.getParameter("firstname"),
    					request.getParameter("title"),
    					request.getParameter("address"),
    					request.getParameter("city"),
    					request.getParameter("state"),
    					request.getParameter("phone"),
    					request.getParameter("email"),
    					Integer.parseInt(request.getParameter("eid"))
    					));
    	  
		
			request.getSession().setAttribute("loggedCustomer", loggedCustomer);
		
			return "updatemanager.do";
      
	}
	   
	   
	
	        public static String getEmpl (HttpServletRequest request) {
	        	
		                       return "insertemployee.jsp";
		                  }
	        public static String updateEmpl (HttpServletRequest request) {
				
	        	Employee loggedCustomer  =  EmployeeService.getEmployeeService().modifyEmployee(
	        			new Employee(
	        					request.getParameter("lastname"),
	        					request.getParameter("firstname"),
	        					request.getParameter("title"),
	        					request.getParameter("address"),
	        					request.getParameter("city"),
	        					request.getParameter("state"),
	        					request.getParameter("phone"),
	        					request.getParameter("email"),
	        					Integer.parseInt(request.getParameter("eid"))
	        					));
	        	
	        	 
				request.getSession().setAttribute("loggedCustomer", loggedCustomer);
                 return "updateemployee.do";
	            }	 
	        }     	 
	        	 
	        	 
	        	 
	        