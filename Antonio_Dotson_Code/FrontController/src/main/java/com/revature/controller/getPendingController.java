package com.revature.controller;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import com.revature.dao.Reimburse;
import com.revature.service.EmployeeService;

public class getPendingController {
	
	 public static String eAllPending(HttpServletRequest request) {
		  List <Reimburse> allAll = EmployeeService.getEmployeeService().pending();
		  request.setAttribute("Win", allAll);
		  request.setAttribute("test", "test");
	     return "manager.jsp";
	  }


}
