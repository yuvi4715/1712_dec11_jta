package com.revature.ajax;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.controller.CheckUsernameController;
import com.revature.controller.EmployeeController;
import com.revature.controller.RequestController;
//import com.revature.controller.EmployeeInfoController;
import com.revature.util.FinalUtil;

/* Request helper specifically for AJAX requests */
public class AjaxRequestHelper {
	
	public static Object process(HttpServletRequest request, HttpServletResponse response) {
		switch(request.getRequestURI()) {
		case "/Revature_Employee_Reimbursment/checkUsername.ajax":
			return CheckUsernameController.checkUsername(request, response);
		case "/Revature_Employee_Reimbursment/requestUserPending.ajax":
			return RequestController.getUserOpenList(request, response);
		case "/Revature_Employee_Reimbursment/requestUserResolved.ajax":
			return RequestController.getUserClosedRequestList(request, response);
		case "/Revature_Employee_Reimbursment/requestAllPending.ajax":
			return RequestController.getAllOpenList(request, response);
		case "/Revature_Employee_Reimbursment/requestAllResolved.ajax":
			return RequestController.getAllClosedList(request, response);
		case "/Revature_Employee_Reimbursment/requestEmployeePending.ajax":
			return RequestController.getEmployeeOpenList(request, response);
		case "/Revature_Employee_Reimbursment/requestEmployeeResolved.ajax":
			return RequestController.getEmployeeClosedList(request, response);
		case "/Revature_Employee_Reimbursment/submitRequest.ajax":
			return RequestController.submitRequest(request, response);
		case "/Revature_Employee_Reimbursment/submitNewEmployee.ajax":
			return EmployeeController.submitNewEmployee(request, response);
		case "/Revature_Employee_Reimbursment/updateEmployee.ajax":
			return EmployeeController.updateEmployee(request, response);
		case "/Revature_Employee_Reimbursment/getEmployee.ajax":
			return EmployeeController.getEmployee(request, response);
		case "/Revature_Employee_Reimbursment/requestAllEmployee.ajax":
			return EmployeeController.getAllEmployees(request, response);
		case "/Revature_Employee_Reimbursment/finalizeRequest.ajax":
			return RequestController.finalizeRequest(request, response);
		default:
			return new AjaxMessage(FinalUtil.NOT_IMPLEMENTED);
		}
	}
}
