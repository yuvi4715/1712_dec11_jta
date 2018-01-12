package com.revature.service;

import java.util.List;
import com.revature.dao.EmployeeDaoJdbc;
import com.revature.model.Employee;
import com.revature.model.Reimbursement;

/* Class that executes business logic related to employees */
public class EmployeeService {

	/*Singleton transformation of Employee Service object */
	private static EmployeeService employeeService;
	
	private EmployeeService() {
	}
	
	public static EmployeeService getEmployeeService() {
		if(employeeService == null) {
			employeeService = new EmployeeService();
		}
		return employeeService;
	}
	
	/* Calls the insert method of the DAO */
	public boolean registerEmployee(Employee employee) {
		return EmployeeDaoJdbc.getEmployeeDaoJdbc().insert(employee);
	}
	
	/* Calls the insert method that uses stored procedure in DAO */
	public boolean registerEmployeeSecure(Employee employee) {
		return EmployeeDaoJdbc.getEmployeeDaoJdbc().insertProcedure(employee);
	}
	
	/* Calls selectAll method of the DAO */
	public List<Employee> listAllUsers() {
		return EmployeeDaoJdbc.getEmployeeDaoJdbc().selectAll();
	}
	
	/* Calls select method of the DAO by username and performs login logic */
	public Employee login(Employee employee) {
		//Get user information without validating
		Employee loggedEmployee = EmployeeDaoJdbc.getEmployeeDaoJdbc().select(employee);
		if(loggedEmployee.getPassword().equals(employee.getPassword())) {
			return loggedEmployee;
		}
		return new Employee();
	}
	
	public boolean isManager(Employee employee) {	
		return EmployeeDaoJdbc.getEmployeeDaoJdbc().checkManager(employee);
	}
	
	/* Calls the select method of the DAO, if the user returned is empty, then username is not taken. */
	public boolean isUsernameTaken(Employee employee) {
		return EmployeeDaoJdbc.getEmployeeDaoJdbc().checkUsername(employee);
	}
	
	public List<Employee> getEmployeeInfo(Employee employee) {
		return EmployeeDaoJdbc.getEmployeeDaoJdbc().getInfo(employee);
	}
	
	public List<Reimbursement> getPendingReq(Employee employee) {
		return EmployeeDaoJdbc.getEmployeeDaoJdbc().getPending(employee);
	}
	
	public static List<Reimbursement> gettingPending(Employee employee) {
		return EmployeeDaoJdbc.getEmployeeDaoJdbc().getPending(employee);
	}
	
	public static List<Reimbursement> gettingResolved(Employee employee) {
		return EmployeeDaoJdbc.getEmployeeDaoJdbc().getResolved(employee);
	}
	
	public static List<Reimbursement> gettingAllPending() {
		return EmployeeDaoJdbc.getEmployeeDaoJdbc().getAllPending();
	}
	
	public static List<Reimbursement> gettingAllResolved() {
		return EmployeeDaoJdbc.getEmployeeDaoJdbc().getAllResolved();
	}
	
	public void updateEmployee(Employee employee) {
		EmployeeDaoJdbc.getEmployeeDaoJdbc().update(employee);
	}
	public void submitRequest(Reimbursement ticket) {
		EmployeeDaoJdbc.getEmployeeDaoJdbc().submitTicket(ticket);
	}
}
