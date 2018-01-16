package com.revature.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import com.revature.reimbursement.UserService;
import com.revature.reimbursement.Closed;
import com.revature.reimbursement.ClosedService;
import com.revature.reimbursement.Employee;
import com.revature.reimbursement.EmployeeService;
import com.revature.reimbursement.User;
import com.revature.reimbursement.UserDao;
import com.revature.reimbursement.UserDaoImpl;
import com.revature.util.ConnectionUtil;
import com.revature.util.FinalUtil;

public class EmployeeController {
	
	public static String employee(HttpServletRequest request) {
		return "EmployeePage.jsp";
	}
	
	public static String empedit(HttpServletRequest request) { 
		return "EmployeeEditPage.jsp";
	}
	
	
	
	public static String remsubmit(HttpServletRequest request) { 
		
		//take params set in EmployeeRemSubmit, set them to a reimbursement object and insert/persist it to database
		Employee loggedEmp = (Employee) request.getSession().getAttribute("loggedEmployee"); //used to get EID under whom the new reimbursement request will be submitted
		
		//instantiate a reimbursment object using the information attributes available from request params and the Employee object from session
		String pnd = "PENDING"; //this is the default state, set to every reimbursement submitted from the employee controller; to be altered later by manager controller methods
		
		ClosedService.getInstance().placeClosed(    //instantiate an employee using params gathered from form, then parse to service to perform update through DAO layers
				new Closed(
						Integer.parseInt(request.getParameter("AMT")),
						loggedEmp.getEid(),
						pnd, //reimbursement request set to PENDING as default
						request.getParameter("description")
						));
		
		return "emprems.do";
	}
	
	
	
	
	public static String empupdate(HttpServletRequest request) {
		
		//code for updating the employee information
		
		//if a GET, return the view
	    if(request.getMethod().equals(FinalUtil.HTTP_GET)) {
	    	return "index.jsp";
	    }
	     
	    Employee loggedEmp = (Employee) request.getSession().getAttribute("loggedEmployee"); //we need the EID to parse into the EmployeeService; obtained from session attribute attached in Login Controller
	    
	    EmployeeService.getInstance().changeDetail(    //instantiate an employee using params gathered from form, then parse to service to perform update through DAO layers
				new Employee(
						loggedEmp.getEid(),
						request.getParameter("firstname"),
						request.getParameter("lastname"),
						request.getParameter("email"),
						loggedEmp.getRoleid(),
						request.getParameter("title")
						));
		
	    System.out.println(loggedEmp.getEid()); //test successful
	    System.out.println(loggedEmp.getRoleid());  //test successful
	    System.out.println("frome employee controller");
	    
	    
	    Employee updatedLoggedEmp = EmployeeService.getInstance().findEmployee(loggedEmp); //replace the outdated loggedEmployee with a new one for presentation at the page you are going to
	    request.getSession().setAttribute("loggedEmployee", updatedLoggedEmp);
		return "/employee.do";
	}
	
	
	
	
	public static String emprems(HttpServletRequest request) { 
		//this method returns all of the specific Employee's reimbursements
		
		//if a GET, return the view
	    if(request.getMethod().equals(FinalUtil.HTTP_GET)) {
	    	return "index.jsp";
	    }
		
		//code to search for and display reimbursements using EID
		User loggedUsr = (User) request.getSession().getAttribute("loggedUser");
		
		System.out.println(loggedUsr.getEid()); //test
		
		List<Closed> reimbursements = ClosedService.getInstance().showAllEid(    //parse EID taken from session attribute loggedUsr, to ClosedService method to retreive all related reimbursements.
				
						loggedUsr.getEid()
						);
		
		request.getSession().setAttribute("reimbursementsEid", reimbursements);
		return "EmployeeReimbursments.jsp";
	}
	
	
}

