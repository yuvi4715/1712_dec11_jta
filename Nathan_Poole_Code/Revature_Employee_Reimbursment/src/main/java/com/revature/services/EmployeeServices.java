package com.revature.services;

import java.util.List;

import com.revature.dao.EmployeeDaoImp;
import com.revature.model.Employee;
import com.revature.util.FinalUtil;

public class EmployeeServices {

	//singleton
	private static EmployeeServices employeeServices;
	
	private EmployeeServices() {};
	
	public static EmployeeServices getInstance() {
		if(employeeServices ==null) {
			employeeServices = new EmployeeServices();
		}
		return employeeServices;
	}
	
	
	
	public boolean createEmployee(Employee employee) {
		return EmployeeDaoImp.getInstance().insert(employee);
	}
	
	public boolean createEmployeeSecure(Employee employee) {
		return EmployeeDaoImp.getInstance().insertProcedure(employee);
	}
	
	public List<Employee> listAllUsers(){
		return EmployeeDaoImp.getInstance().selectAll();
	}
	
	public Employee login(Employee employee) {
		Employee c1 = EmployeeDaoImp.getInstance().select(employee);
		
		if (c1.getPw().equals(EmployeeDaoImp.getInstance().getCustomerHash(employee))) {
			return c1;
		}
		return new Employee();
	}
	
	public boolean updateEmployee(Employee employee) {
		return EmployeeDaoImp.getInstance().update(employee);
	}

	public boolean isUsernameTaken(Employee employee) {
		if(EmployeeDaoImp.getInstance().select(employee).getUsername().equals(FinalUtil.EMPTY_STRING)) {
			return false;
		}
		return true;
	}
	
	public Employee selectEmployee(Employee employee) {
		return EmployeeDaoImp.getInstance().selectId(employee);
	}
}
