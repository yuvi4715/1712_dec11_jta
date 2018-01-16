package com.revature.controller;

import com.revature.reimbursement.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.revature.reimbursement.Employee;
import com.revature.reimbursement.EmployeeService;
import com.revature.reimbursement.User;
import com.revature.reimbursement.UserDao;
import com.revature.reimbursement.UserDaoImpl;
import com.revature.util.ConnectionUtil;
import com.revature.util.FinalUtil;


public class LoginController {
	public static String login(HttpServletRequest request) {
       
    //if a GET, return the view
    if(request.getMethod().equals(FinalUtil.HTTP_GET)) {
    	return "index.jsp";
    }
    
    
		
	

	
		// POST LOGIQE
		User loggedUser = UserService.getInstance().Login(    //this Login is from UserService vs the lower case login of this class
				new User(
						request.getParameter("username"),
						request.getParameter("password")
						));
				
		//Wrong Credentials
		if(loggedUser.getUsername().equals("")) {
			return "index.jsp";
			//place code to display login error 
		}
		else {
			
			//Persistence via Sessionscoping
			request.getSession().setAttribute("loggedUser", loggedUser);
		
			if (loggedUser.getAdmin().equals("Y")) {    //check if Employee or manager and send to the appropriate page
			
				//perform new lookup in employee table using eid from logged user as the string value to be compared
				//then head to employee page to populate the table with the info; create a 'loggedEmployee' session object.
				
			
				
				Employee loggedEmployee = EmployeeService.getInstance().findEmployee(
						new Employee(
							loggedUser.getEid()
						));
				
				request.getSession().setAttribute("loggedEmployee", loggedEmployee); //attach attributes retreived from Employee to session object
				
				
			return "/manager.do";
			} else {
				
				//perform new lookup in employee table using eid from logged user as the string value to be compared in sql
				//then head to employee page to populate the table with the retreived info; create a 'loggedEmployee' session object.
				
				
				Employee loggedEmployee = EmployeeService.getInstance().findEmployee(
						new Employee(
							loggedUser.getEid()
						));
				
				request.getSession().setAttribute("loggedEmployee", loggedEmployee); //attach attributes retreived from Employee to session object
				return "/employee.do";  
			}
		
			
			
		}
			
		
	}
	
	
	public static String logout(HttpServletRequest request) {
		
		HttpSession session  = request.getSession();
		if(session !=null)
		try
		{      
		    session.invalidate();                               
		    return "index.jsp";           }
		catch (Exception e)
		{
		    System.out.println("error UserValidateServlet message : " + e.getMessage());
		    System.out.println("error UserValidateServlet exception : " + e);
		}
		return "index.jsp";
		
	}
	

	
}
