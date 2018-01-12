package com.revature;

import com.revature.dao.EmployeeDaoJDBC;
import com.revature.model.Employee;
import com.revature.service.EmployeeService;

public class Test {
	public static void main(String[] args) {
		Employee jason = new Employee("shenj529@gmail.com");
//		EmployeeDaoJDBC.getEmployeeDaoJDBC().setRole(jason, "employee");
		System.out.println(EmployeeService.getEmployeeService().isManager(jason));
	}
}
