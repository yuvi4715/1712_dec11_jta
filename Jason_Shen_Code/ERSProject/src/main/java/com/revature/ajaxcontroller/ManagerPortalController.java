package com.revature.ajaxcontroller;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dao.EmployeeDaoJDBC;
import com.revature.model.Employee;
import com.revature.service.EmployeeService;
import com.revature.service.ManagerService;
import com.revature.service.TicketService;

public class ManagerPortalController {

	public static Object viewAllEmployees(HttpServletRequest request, HttpServletResponse response) {
		Employee loggedEmployee = (Employee) request.getSession().getAttribute("loggedEmployee");
		
		// Non-Managers will get nothing out of making this request
		if(!EmployeeService.getEmployeeService().isManager(loggedEmployee)) {
			return null;
		}
		else {
			return ManagerService.getManagerService().getAllEmployees();
		}
	}

	public static Object viewAllResolved(HttpServletRequest request, HttpServletResponse response) {
		Employee loggedEmployee = (Employee) request.getSession().getAttribute("loggedEmployee");
		
		// Non-Managers will get nothing out of making this request
		if(!EmployeeService.getEmployeeService().isManager(loggedEmployee)) {
			return null;
		}
		else {
			return ManagerService.getManagerService().getAllResolved();
		}
	}

	public static Object viewAllPending(HttpServletRequest request, HttpServletResponse response) {
		Employee loggedEmployee = (Employee) request.getSession().getAttribute("loggedEmployee");
		
		// Non-Managers will get nothing out of making this request
		if(!EmployeeService.getEmployeeService().isManager(loggedEmployee)) {
			return null;
		}
		else {
			return ManagerService.getManagerService().getAllPending();
		}
	}

	public static Object approve(HttpServletRequest request, HttpServletResponse response) {
		Employee loggedEmployee = (Employee) request.getSession().getAttribute("loggedEmployee");
		
		// Non-Managers will get nothing out of making this request
		if(!EmployeeService.getEmployeeService().isManager(loggedEmployee)) {
			return null;
		}
		else {
			
			try {
				StringBuilder sb = new StringBuilder();
				BufferedReader reader = request.getReader();
				
				String line;
				while ((line = reader.readLine())!=null) {
					sb.append(line);
				}
				System.out.println(sb.toString());
				return ManagerService.getManagerService().approve(Integer.parseInt(sb.toString()), loggedEmployee); 
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "";
		}
	}

	public static Object deny(HttpServletRequest request, HttpServletResponse response) {
		Employee loggedEmployee = (Employee) request.getSession().getAttribute("loggedEmployee");
		
		// Non-Managers will get nothing out of making this request
		if(!EmployeeService.getEmployeeService().isManager(loggedEmployee)) {
			return null;
		}
		else {
			
			try {
				StringBuilder sb = new StringBuilder();
				BufferedReader reader = request.getReader();
				
				String line;
				while ((line = reader.readLine())!=null) {
					sb.append(line);
				}
				System.out.println(sb.toString());
				return ManagerService.getManagerService().deny(Integer.parseInt(sb.toString()), loggedEmployee); 
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "";
		}
	}

	public static Object viewPending(HttpServletRequest request, HttpServletResponse response) {
		Employee loggedEmployee = (Employee) request.getSession().getAttribute("loggedEmployee");

		if(!EmployeeService.getEmployeeService().isManager(loggedEmployee)) {
			return null;
		}
		else {
			
			try {
				StringBuilder sb = new StringBuilder();
				BufferedReader reader = request.getReader();
				
				String line;
				while ((line = reader.readLine())!=null) {
					sb.append(line);
				}
				Employee target_employee = EmployeeDaoJDBC.getEmployeeDaoJDBC().selectById(Integer.parseInt(sb.toString()));
				return TicketService.getTicketService().getAllPending(target_employee);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "";
		}

	}

}
