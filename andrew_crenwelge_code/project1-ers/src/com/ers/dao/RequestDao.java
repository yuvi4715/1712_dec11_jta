package com.ers.dao;

import java.util.List;
import java.util.Map;

import com.ers.model.Employee;
import com.ers.model.Request;

public interface RequestDao {
	public Request getRequestById(int reqId);
	public boolean initializeNewRequest(Request r);
	public boolean approveRequest(Request r, int mgrID);
	public boolean denyRequest(Request r, int mgrID);
	public List<Request> getAllRequests();
	public List<Request> getAllResolvedRequests();
	public List<Request> getAllPendingRequests();
	public List<Request> getResolvedRequestsByEmployee(int empID);
	public List<Request> getPendingRequestsByEmployee(int empID);
	public List<Request> getRequestsByEmployee(int empID);
	public List<Request> getRequestsByEmployeeName(String firstname, String lastname);
	public Employee getManagerOfRequest(Request r);
	public Map<Integer,String> getRequestMgrMap();
}