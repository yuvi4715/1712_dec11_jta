package com.revature.reimbursement;

import com.revature.reimbursement.EmployeeDaoImpl;
import com.revature.reimbursement.User;
import com.revature.reimbursement.UserDao;
import com.revature.reimbursement.UserDaoImpl;

import java.util.List;

import com.revature.reimbursement.Employee;

public class EmployeeService {

	//private instance of EmployeeService variable
	private static EmployeeService employeeService;
	//singleton
	private EmployeeService() {
		
	}
	
	
	//getting instance of EmployeeService
	public static EmployeeService getInstance() {
		if(employeeService == null) {
			employeeService = new EmployeeService();
		
	}
	return employeeService;	
	}
	
	//calls the insert method of DAO
	public boolean registerEmployee(Employee employee) {
		return EmployeeDaoImpl.getInstance().insertEmployee(employee);
	}
	
	public Employee findEmployee(Employee employee) {   //this receives the EID gathered from loggedUser.getEid() from the LoginController, for use in lookup.
		Employee emp = EmployeeDaoImpl.getInstance().getEmployee(employee);   
			
	return emp;
	}
	
	//list all Employees
	public List<Employee> ListAll() {
		return EmployeeDaoImpl.getInstance().getAllEmployee();
	}
	
	//changed employee info
		public boolean changeDetail(Employee employee) {
			System.out.println("the title returned is " + employee.getTitle() + " from changedetail method"); // testing
			return EmployeeDaoImpl.getInstance().updateEmployee(employee);
	}
}
