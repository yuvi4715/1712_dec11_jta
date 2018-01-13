package com.revature.controller;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import com.revature.model.Employee;
import com.revature.service.EmployeeService;


public class GetAllEmployees {
	
public static String returnAll(HttpServletRequest request) {
		
		
	List <Employee> aes =  EmployeeService.getEmployeeService().listAllUsers();
	request.setAttribute("EmployeeValue", aes);
		return "employee.jsp";
			
	}


}     
	
	
