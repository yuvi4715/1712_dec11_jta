package com.revature.servlets;

import javax.servlet.http.HttpServletRequest;

import com.revature.controller.EmployeeController;
import com.revature.controller.LoginController;
import com.revature.controller.ManagerController;

/* Class that helps the MasterServlet with mappings to specific controllers */
public class RequestHelper {
	
	public static String process(HttpServletRequest request) {
		switch(request.getRequestURI()) {
		case "/maurice_reimbursement/logout.do":
			return LoginController.logout(request);
		case "/maurice_reimbursement/login.do":
			return LoginController.login(request);
		case "/maurice_reimbursement/empupdate.do": //related to empedit
			return EmployeeController.empupdate(request);
		case "/maurice_reimbursement/employee.do":  //see employee info
			return EmployeeController.employee(request);
		case "/maurice_reimbursement/empedit.do":  //edit employee info
			return EmployeeController.empedit(request);
		case "/maurice_reimbursement/emprems.do":   //see employee reimbursements
			return EmployeeController.emprems(request);
		case "/maurice_reimbursement/remsubmit.do":   //submit new reimbursements
			return EmployeeController.remsubmit(request);
		case "/maurice_reimbursement/manager.do":  //manager home page
			return ManagerController.manager(request);
		case "/maurice_reimbursement/managerview.do": //manager views all employees
			return ManagerController.getallemps(request);
		case "/maurice_reimbursement/managepending.do":  //view all pending reimbursements
			return ManagerController.getpending(request);
		case "/maurice_reimbursement/managerpendingemp.do": //view pending with specifi eid
			return ManagerController.getpendingemp(request);
		case "/maurice_reimbursement/managerapprove.do": //after clicking approve
			return ManagerController.approve(request);
		case "/maurice_reimbursement/managerdeny.do": //after clicking deny
			return ManagerController.deny(request);
		case "/maurice_reimbursement/manageresolved.do": //view all resolved
			return ManagerController.getresolved(request); 
		default:
			return "404.jsp";
		}
	}
}

