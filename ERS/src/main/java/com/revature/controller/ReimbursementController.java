package com.revature.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.DAOFactory;
import com.revature.model.Employee;
import com.revature.model.Reimbursement;
public class ReimbursementController {
	
	private static Logger logger = Logger.getLogger(ReimbursementController.class);
	
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static ArrayList<Reimbursement> getReimubrsements(HttpServletRequest request, HttpServletResponse response) {
		try {
			ObjectMapper om = new ObjectMapper();
			Reimbursement reqReimburse;
			reqReimburse = om.readValue(request.getReader().readLine(),Reimbursement.class);
			return DAOFactory.getInstance().getEmployeeReimbursementsById(reqReimburse.getEid(), reqReimburse.getType());
		} catch (IOException e) {
			e.printStackTrace();
			logger.error(e);
		}
		return null;
	}
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static ArrayList<Reimbursement> getAllEmployeeReimbursements(HttpServletRequest request, HttpServletResponse response){
		ObjectMapper om = new ObjectMapper();
		Reimbursement reqReimburse;
		try {
			reqReimburse = om.readValue(request.getReader().readLine(),Reimbursement.class);
			DAOFactory.getInstance().getAllEmployeeReimbursementsById(reqReimburse.getEid());
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return DAOFactory.getInstance().getAllReimbursements();
	}
	public static ArrayList<Reimbursement> getAllReimbursements(){
		return DAOFactory.getInstance().getAllReimbursements();
	}
	
	public static boolean setStatus(HttpServletRequest request, HttpServletResponse response) {
		ObjectMapper om = new ObjectMapper();
		Reimbursement reqReimburse = null;
		String username = null;
		for(Cookie c : request.getCookies()) {
			if(c.getName().equals("username")) {	
				username = c.getValue();
				break;
			}
		}
		try {
			reqReimburse = om.readValue(request.getReader().readLine(),Reimbursement.class);
			return DAOFactory.getInstance().movePendingToResolved(reqReimburse, username);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		return false;
	}
	public static ArrayList<Reimbursement> getAllReimbursementsInType(HttpServletRequest request, HttpServletResponse response){
		ObjectMapper om = new ObjectMapper();
		Reimbursement reqReimburse;
		try {
			reqReimburse = om.readValue(request.getReader().readLine(),Reimbursement.class);
			return DAOFactory.getInstance().getAllReimbursementsInType(reqReimburse);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static ArrayList<Reimbursement> getReimbursementsByEmployeeUsername(HttpServletRequest request){
		String type = null;
		String username = null;
		for(Cookie c : request.getCookies())
			if(c.getName() == "username")
				username = c.getValue();
		
		try {
			type = request.getReader().readLine();
		} catch (IOException e) {
			e.printStackTrace();
			logger.error(e);
		}
		return DAOFactory.getInstance().getEmployeeReimbursements(username, type);
	}
	
	public static boolean resolve(HttpServletRequest request, HttpServletResponse response) {
		try {
			//TODO check this after completing cookies
			String manager= null;
			for(Cookie c : request.getCookies())
				if(c.getName() == "username")
					manager = c.getValue();
			ObjectMapper om = new ObjectMapper();
			Reimbursement reqReimburse;
			reqReimburse = om.readValue(request.getReader().readLine(),Reimbursement.class);
			return DAOFactory.getInstance().movePendingToResolved(reqReimburse, manager);
		} catch (IOException e) {
			e.printStackTrace();
			logger.error(e);
		}
		return false;
		
	}
	
	public static ArrayList<Employee> getNames(HttpServletRequest request, HttpServletResponse response) {
		return DAOFactory.getInstance().getNames();
	}
}
