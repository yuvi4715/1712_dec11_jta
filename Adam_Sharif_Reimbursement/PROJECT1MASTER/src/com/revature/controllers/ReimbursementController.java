package com.revature.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.revature.beans.Reimbursement;
import com.revature.services.ReimbursementService;

public class ReimbursementController {
	//takes in requests from the dispatcher servlet
	private ReimbursementService rs = new ReimbursementService();

	// server sends a POST request which will call the required method
	public void processPost(HttpServletRequest request, HttpServletResponse response) {
		String actualURL = request.getRequestURI().substring(request.getContextPath().length());
		
		switch(actualURL) {
		case "/reimbursements/add":
			add(request,response);
			break;
		case "/reimbursements/approve":
			approve(request,response);
			break;
		case "/reimbursements/deny":
			deny(request,response);
			break;
		}
	}

	// server sends a GET request which will call the required method
	public void processGet(HttpServletRequest request, HttpServletResponse response) {
		String actualURL = request.getRequestURI().substring(request.getContextPath().length());
	
		switch(actualURL) {
		case "/reimbursements/all":
			displayAll(request,response);
			break;
		case "/reimbursements/user":
			getUserReimbursements(request,response);
			break;
		}
	}
	
	// Method will show reimbursements for a user on the webpage. It converts the 
	// reimbursements to json and to be sent to server
	private void getUserReimbursements(HttpServletRequest request, HttpServletResponse response) {
		String json;
		List<Reimbursement> userReimb = rs.getByUser((Integer)request.getSession().getAttribute("user"));
				
		try {
			ObjectMapper om = new ObjectMapper();
			ObjectWriter ow = om.writer().withDefaultPrettyPrinter();
			json = ow.writeValueAsString(userReimb);
			PrintWriter writer = response.getWriter();
			writer.write(json);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

	// Method will show all reimbursements on the webpage. It converts the
	// reimbursements to json to be sent to server
	private void displayAll(HttpServletRequest request, HttpServletResponse response) {
		String json;
		List<Reimbursement> allReimb = rs.getAllReimb();
		
		try {
			ObjectMapper om = new ObjectMapper();
			ObjectWriter ow = om.writer().withDefaultPrettyPrinter();
			json = ow.writeValueAsString(allReimb);
			PrintWriter writer = response.getWriter();
			writer.write(json);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	private void add(HttpServletRequest request, HttpServletResponse response) {
		String json;
		try {
			json = request.getReader().lines().reduce((acc, curr) -> acc + curr).get();
			ObjectMapper om = new ObjectMapper();
			Reimbursement r = om.readValue(json, Reimbursement.class);
			r.setAmount(r.getAmount());
			r.setAuthorId((Integer)request.getSession().getAttribute("user"));
			int newReimbursement = rs.add(r);
			
			r.setId(newReimbursement);
			
			if(newReimbursement == 0) {
				response.setStatus(401);
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void approve(HttpServletRequest request, HttpServletResponse response) {
		String json;
		try {
			json = request.getReader().lines().reduce((acc, curr) -> acc + curr).get();			
			ObjectMapper om = new ObjectMapper();
			Reimbursement r = om.readValue(json, Reimbursement.class);
			System.out.println("attempting to approve reimbursement");
			boolean success = rs.statusChange(r, "approve", (Integer)request.getSession().getAttribute("user"));
			
			if(success == false) {
				response.setStatus(401);
				response.setHeader("error", "manager");
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	private void deny(HttpServletRequest request, HttpServletResponse response) {
		String json;
		try {
			json = request.getReader().lines().reduce((acc, curr) -> acc + curr).get();
			ObjectMapper om = new ObjectMapper();
			Reimbursement r = om.readValue(json, Reimbursement.class);
			boolean success = rs.statusChange(r, "deny", (Integer)request.getSession().getAttribute("user"));
			
			if(success == false) {
				response.setStatus(401);
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}
