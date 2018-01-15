package com.revature.request;
import javax.servlet.http.HttpServletRequest;
import com.revature.controller.EmployeeReimbursement;
import com.revature.controller.GetAllEmployees;
import com.revature.controller.GetStatusContent;
import com.revature.controller.HomeController;
import com.revature.controller.InsertNewController;
import com.revature.controller.LogOutController;
import com.revature.controller.LoginController;
import com.revature.controller.ManagerController;
import com.revature.controller.ReimbursementController;
import com.revature.controller.SearchController;
import com.revature.controller.getPendingController;

/* Class that helps the MasterServlet with mappings to specific controllers */
public class RequestHelper {
	
	public static String process(HttpServletRequest request) {
		switch(request.getRequestURI()) {
		case "/FrontController/login.do":
			return LoginController.login(request);
		case "/FrontController/home.do":
			return HomeController.home(request);
		case "/FrontController/manager.do":
			return ManagerController.manager(request);
		case "/FrontController/employee.do":
			return GetAllEmployees.returnAll(request);
		case "/FrontController/updateEmployee.do":
		    return InsertNewController.insertEmpl(request);
		case "/FrontController/insertemployee.do":
		    return InsertNewController.getEmpl(request);
		case "/FrontController/view_all.do":
			return ReimbursementController.returnAllRem(request);
		case "/FrontController/view_pending.do":
			return ReimbursementController.returnAllPending(request);
		case "/FrontController/logout.do":
			return LogOutController.logOut(request);
		case "/FrontController/updateemployee.do":
			return InsertNewController.updateEmpl(request);
		case "/FrontController/updatemanager.do":
			return InsertNewController.updateManager(request);
		case "/FrontController/insertreimbursement.do":
			return ReimbursementController.insertRequest(request);
		case "/FrontController/view_approve.do":
			return EmployeeReimbursement.returnApproved(request);
		case "/FrontController/allrequest.do":
			return ReimbursementController.reAll(request);
		case "/FrontController/denied.do":
			return EmployeeReimbursement.returnDisapprove(request);
		case "/FrontController/updatestates.do":
			return getPendingController.eAllPending(request);
		case"/FrontController/updateassucess.do":
			return GetStatusContent.returnApprov(request);
		case"/FrontController/updateadeny.do":
			return GetStatusContent.returnDisapprove(request);
		case"/FrontController/getSearch.do":
			return SearchController.returnSearch(request);
		default:  
			return "404.jsp";
		}
	}
}
