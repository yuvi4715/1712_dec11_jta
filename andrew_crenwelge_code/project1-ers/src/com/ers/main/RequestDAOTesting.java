package com.ers.main;

import java.util.List;
import java.util.Map;

import com.ers.dao.RequestDao;
import com.ers.dao.RequestDaoImpl;
import com.ers.model.Request;

public class RequestDAOTesting {

	public static void main(String[] args) {
		getEmplMap();
		System.out.println("Getting all requests...");
		getAllRequests();
		System.out.println("=====================================");
		System.out.println("Getting all RESOLVED requests...");
		getAllPendingRequests();
		System.out.println("=====================================");
		System.out.println("Getting all PENDING requests...");
		getAllResolvedRequests();
		System.out.println("=====================================");
		System.out.println("Getting single request...");
		getSingleRequest();
		System.out.println("=====================================");
		System.out.println("Getting all requests by employee...");
		getEmpResolvedRequest();
		System.out.println("=====================================");
		System.out.println("Getting all RESOVLED requests by employee...");
		getEmpResolvedRequest();
		System.out.println("=====================================");
		System.out.println("Getting all PENDING requests by employee...");
		getEmpPendingRequest();
		System.out.println("=====================================");
		System.out.println("Approving request...");
		/*
		approveRequest();
		System.out.println("=====================================");
		System.out.println("Denying request...");
		denyRequest();
		System.out.println("=====================================");
		System.out.println("Getting manager of request...");
		getManagerOfRequest();
		*/
	}
	
	static void getEmplMap() {
		RequestDao rdao = RequestDaoImpl.getInstance();
		Map<Integer,String> list = rdao.getRequestMgrMap();
		for (Map.Entry<Integer, String> e : list.entrySet()) {
			System.out.println(e.getKey());
			System.out.println(e.getValue());
		}
	}

	static void getAllRequests() {
		RequestDao rdao = RequestDaoImpl.getInstance();
		List<Request> list = rdao.getAllRequests();
		for (Request r : list) {
			System.out.println(r);
		}
	}
	
	static void getAllPendingRequests() {
		RequestDao rdao = RequestDaoImpl.getInstance();
		List<Request> list = rdao.getAllPendingRequests();
		for (Request r : list) {
			System.out.println(r);
		}
	}
	
	static void getAllResolvedRequests() {
		RequestDao rdao = RequestDaoImpl.getInstance();
		List<Request> list = rdao.getAllResolvedRequests();
		for (Request r : list) {
			System.out.println(r);
		}
	}
	
	static void getSingleRequest() {
		RequestDao rdao = RequestDaoImpl.getInstance();
		System.out.println(rdao.getRequestById(1));
	}
	
	static void getEmpResolvedRequest() {
		RequestDao rdao = RequestDaoImpl.getInstance();
		List<Request> list = rdao.getResolvedRequestsByEmployee(1);
		for (Request r : list) {
			System.out.println(r);
		}
	}
	
	static void getEmpPendingRequest() {
		RequestDao rdao = RequestDaoImpl.getInstance();
		List<Request> list = rdao.getPendingRequestsByEmployee(1);
		for (Request r : list) {
			System.out.println(r);
		}
	}
	
	static void approveRequest() {
		RequestDao rdao = RequestDaoImpl.getInstance();
		Request r = new Request();
		rdao.approveRequest(r,2);
	}
	
	static void denyRequest() {
		RequestDao rdao = RequestDaoImpl.getInstance();
		Request r = new Request();
		rdao.denyRequest(r,2);
	}
	
	static void getManagerOfRequest() {
		RequestDao rdao = RequestDaoImpl.getInstance();
		Request r = new Request();
		rdao.getManagerOfRequest(r);
	}
}
