package com.ers.main;

import java.util.List;

import com.ers.dao.EmployeeDao;
import com.ers.dao.EmployeeDaoImpl;
import com.ers.model.Employee;

public class EmployeeDAOTesting {

	public static void main(String[] args) {
		System.out.println("Getting employee...");
		getEmployee();
		System.out.println("=====================================");
		System.out.println("Authenticating employee...");
		authenticate("acrenwelge","abc");
		//System.out.println("=====================================");
		//System.out.println("Updating employee information...");
		// updateInfo();
		System.out.println("=====================================");
		System.out.println("Retreiving all employees...");
		getAllEmployees();
	}

	static void getEmployee() {
		EmployeeDao edao = EmployeeDaoImpl.getInstance();
		System.out.println(edao.getEmployeeByUsername("acrenwelge"));
		System.out.println(edao.getEmployeeById(1));
	}
	
	static void getAllEmployees() {
		EmployeeDao edao = EmployeeDaoImpl.getInstance();
		List<Employee> list = edao.getAllEmployees();
		for (Employee e : list) {
			System.out.println(e);
		}
	}
	
	static void authenticate(String username, String password) {
		EmployeeDao edao = EmployeeDaoImpl.getInstance();
		if (edao.authenticate(username, password))
			System.out.println("Employee is authenticated & can be logged in");
		else
			System.out.println("Invalid credentials or some other problem");
	}
	
	static void updateInfo() {
		EmployeeDao edao = EmployeeDaoImpl.getInstance();
		Employee e = new Employee();
		e.setId(1);
		e.setEmail("test@gmail.com");
		e.setPhoneNumber("000-000-0000");
		e.setAddress("testaddress");
		e.setCity("testycity");
		e.setState("statetest");
		e.setCountry("USATEST");
		e.setZip("ziptest");
		System.out.println("Old employee info:" + e);
		if (edao.updateInfo(e))
			System.out.println("updated successfully");
		else
			System.out.println("unable to update successfully");
		Employee newEmp = edao.getEmployeeById(e.getId());
		System.out.println("New employee info: " + newEmp);
	}
}
