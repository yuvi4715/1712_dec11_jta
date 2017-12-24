package com.ers.dao;

import java.util.List;

import com.ers.model.Employee;
import com.ers.model.Request;

public interface RequestDao {
	public Request getRequestById(int reqId);
	public boolean initializeNewRequest(Request r);
	public boolean approveRequest(Request r);
	public boolean denyRequest(Request r);
	public List<Request> getAllRequests();
	public List<Request> getAllResolvedRequests();
	public List<Request> getAllPendingRequests();
	public List<Request> getResolvedRequestsByEmployee(int empID);
	public List<Request> getPendingRequestsByEmployee(int empID);
	public List<Request> getRequestsByEmployee(int empID);
	public Employee getManagerOfRequest(); // depends if we want Managers to be Employees
}