package com.revature.controller;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import com.revature.model.Employee;
import com.revature.service.EmployeeService;


public class SearchController {
	
public static String returnSearch(HttpServletRequest request) {
		
		
	List <Employee> searchEmployee =  EmployeeService.getEmployeeService().Search(
			Integer.parseInt(request.getParameter("eid")));
	        request.setAttribute("EmployeeValue", searchEmployee);
		    return "search.jsp";
			
	}
}     
	
