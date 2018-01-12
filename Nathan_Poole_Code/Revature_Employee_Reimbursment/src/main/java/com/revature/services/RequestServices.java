package com.revature.services;

import java.util.List;

import com.revature.dao.EmployeeDaoImp;
import com.revature.dao.RequestDaoImp;
import com.revature.model.Employee;
import com.revature.model.Request;

public class RequestServices {

private static RequestServices requestSerivices;
	
	private RequestServices() {};
	
	public static RequestServices getInstance() {
		if(requestSerivices ==null) {
			requestSerivices = new RequestServices();
		}
		return requestSerivices;
	}
	
	public boolean submitRequest(Request request) {
		return RequestDaoImp.getInstance().insertRequest(request);
	}
	
	public boolean submitRequestSecure(Request request) {
		return RequestDaoImp.getInstance().insertRequestProcedure(request);
	}
	
	public List<Request> listAllOpenRequest(){
		return RequestDaoImp.getInstance().selectAllOpen();
	}
	
	public List<Request> listAllClosedRequests(){
		return RequestDaoImp.getInstance().selectAllClosed();
	}
	
	public List<Request> listEmployeeOpenRequests(Employee employee){
		return RequestDaoImp.getInstance().selectOpen(employee);
	}
	
	public List<Request> listEmployeeClosedRequests(Employee employee){
		return RequestDaoImp.getInstance().selectClosed(employee);
	}
	
	public List<Request> listUsernameOpenRequests(Employee employee){
		Employee temp = EmployeeDaoImp.getInstance().select(employee);
		return RequestDaoImp.getInstance().selectOpen(temp);
	}
	
	public List<Request> listUsernameClosedRequest(Employee employee){
		Employee temp = EmployeeDaoImp.getInstance().select(employee);
		return RequestDaoImp.getInstance().selectClosed(temp);
	}
	
	public boolean finalizeOpenRequest(Request request) {
		return RequestDaoImp.getInstance().finalizeProcedure(request);
	}
}
