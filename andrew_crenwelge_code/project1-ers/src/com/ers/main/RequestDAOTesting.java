package com.ers.main;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.ers.dao.RequestDao;
import com.ers.dao.RequestDaoImpl;
import com.ers.model.Request;
import com.ers.util.ConnectionUtil;

public class RequestDAOTesting {

	public static void main(String[] args) {
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

	static void getAllRequests() {
		try(Connection conn = ConnectionUtil.getConnection()) {
			System.out.println("connection should be established");
			RequestDao rdao = RequestDaoImpl.getInstance();
			List<Request> list = rdao.getAllRequests();
			for (Request r : list) {
				System.out.println(r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	static void getAllPendingRequests() {
		try(Connection conn = ConnectionUtil.getConnection()) {
			System.out.println("connection should be established");
			RequestDao rdao = RequestDaoImpl.getInstance();
			List<Request> list = rdao.getAllPendingRequests();
			for (Request r : list) {
				System.out.println(r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	static void getAllResolvedRequests() {
		try(Connection conn = ConnectionUtil.getConnection()) {
			System.out.println("connection should be established");
			RequestDao rdao = RequestDaoImpl.getInstance();
			List<Request> list = rdao.getAllResolvedRequests();
			for (Request r : list) {
				System.out.println(r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	static void getSingleRequest() {
		try(Connection conn = ConnectionUtil.getConnection()) {
			System.out.println("connection should be established");
			RequestDao rdao = RequestDaoImpl.getInstance();
			System.out.println(rdao.getRequestById(1));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	static void getEmpResolvedRequest() {
		try(Connection conn = ConnectionUtil.getConnection()) {
			System.out.println("connection should be established");
			RequestDao rdao = RequestDaoImpl.getInstance();
			List<Request> list = rdao.getResolvedRequestsByEmployee(1);
			for (Request r : list) {
				System.out.println(r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	static void getEmpPendingRequest() {
		try(Connection conn = ConnectionUtil.getConnection()) {
			System.out.println("connection should be established");
			RequestDao rdao = RequestDaoImpl.getInstance();
			List<Request> list = rdao.getPendingRequestsByEmployee(1);
			for (Request r : list) {
				System.out.println(r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	static void approveRequest() {
		try(Connection conn = ConnectionUtil.getConnection()) {
			System.out.println("connection should be established");
			RequestDao rdao = RequestDaoImpl.getInstance();
			Request r = new Request();
			rdao.approveRequest(r);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	static void denyRequest() {
		try(Connection conn = ConnectionUtil.getConnection()) {
			System.out.println("connection should be established");
			RequestDao rdao = RequestDaoImpl.getInstance();
			Request r = new Request();
			rdao.denyRequest(r);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	static void getManagerOfRequest() {
		try(Connection conn = ConnectionUtil.getConnection()) {
			System.out.println("connection should be established");
			RequestDao rdao = RequestDaoImpl.getInstance();
			Request r = new Request();
			rdao.getManagerOfRequest(r);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
