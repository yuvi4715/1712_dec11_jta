package com.revature.controller;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import com.revature.dao.Reimburse;
import com.revature.service.EmployeeService;


public class ReimbursementController {

	public static String returnAllRem(HttpServletRequest request) {


		List <Reimburse> approvedAll =  EmployeeService.getEmployeeService().appprove();
		request.setAttribute("Allrequest", approvedAll);
		return "view_all_request.jsp";
	}

	public static String returnAllPending(HttpServletRequest request) {


		List <Reimburse> Pending =  EmployeeService.getEmployeeService().pending();
		request.setAttribute("pendingAll", Pending);
		return "veiw_all_pending.jsp";
	}
	public static String reAll(HttpServletRequest request) {

		List <Reimburse> allService =  EmployeeService.getEmployeeService().disapproved();
		request.setAttribute("all", allService);
		return "allquest.jsp";
	}

	public static String insertRequest(HttpServletRequest request) {

		Boolean getReimbursement =  EmployeeService.getEmployeeService().addReimbursement(
				Integer.parseInt(request.getParameter("eid")),
				request.getParameter("description"),
				Double.parseDouble(request.getParameter("amount")),
				request.getParameter("type")

				);

		if (getReimbursement == true) {
			request.setAttribute("getServices", getReimbursement);
			return "insertreimbursement.jsp";
		} else {
			return "insertreimbursement.jsp";
		}

	}

}