package com.revature.service;
import java.util.List;
import com.revature.dao.EmployeeDaoJdbc;
import com.revature.dao.Reimburse;
import com.revature.model.Employee;

/* Class that executes business logic related to Employees */
public class EmployeeService {

	/*Singleton transformation of Employee Service object */
	private static EmployeeService EmployeeService;
	
	private EmployeeService() {
		
	}
	
	public static EmployeeService getEmployeeService() {
		if(EmployeeService == null) {
			EmployeeService = new EmployeeService();
		}
		
		return EmployeeService;
	}
	
	/* Calls the insert method of the DAO */
	public boolean registerEmployee(Employee Employee) {
		return EmployeeDaoJdbc.getEmployeeDaoJdbc().insert(Employee);
	}
	
	/* Calls the insert method that uses stored procedure in DAO */
	public boolean registerEmployeeSecure(Employee Employee) {
		return EmployeeDaoJdbc.getEmployeeDaoJdbc().insertProcedure(Employee);
	}
	
	/* Calls selectAll method of the DAO */
	public List<Employee> listAllUsers() {
		return EmployeeDaoJdbc.getEmployeeDaoJdbc().selectAll();
	}
	
	/* Calls select method of the DAO by username and performs login logic */
	public Employee login(Employee Employee) {
		//Get user information without validating
		Employee loggedEmployee = EmployeeDaoJdbc.getEmployeeDaoJdbc().select(Employee);
		
		/*
		 * loggedEmployee.getPassword() is the hash we have stored.
		 * We compare that against the hash of the user input.
		 * If credentials are correct we return the full Employee information.
		 * Else, we return a blank object.
		 */
		
        if(loggedEmployee.getPassword().equals(Employee.getPassword())) {
        	
			return loggedEmployee;
		}
		
		return new Employee();
	}
	
	/* Calls the select method of the DAO, if the user returned is empty, then username is not taken. */
	public boolean isUsernameTaken(Employee Employee) {
		if(EmployeeDaoJdbc.getEmployeeDaoJdbc().checkUserName(Employee) == false) {
			return false;
		}
		return true;
	}
    // Calls the select method to update password
     public boolean registerPassword(Employee Employee) {
	    return EmployeeDaoJdbc.getEmployeeDaoJdbc().updatePassword(Employee);
            }
     // Call the update method to update Employee
     public Employee modifyEmployee(Employee Employee) {
 	    return EmployeeDaoJdbc.getEmployeeDaoJdbc().updateEmployee(Employee);
             }
     
     public boolean addReimbursement(int number,String string,double newnumber,String newstring) {
    	 return EmployeeDaoJdbc.getEmployeeDaoJdbc().insertReimbursement(number,string,newnumber,newstring);
     }
     
     public List<Reimburse> disapproved() {
    	 return EmployeeDaoJdbc.getEmployeeDaoJdbc().selectReimburseDisapproved();
     }
     
     public List<Reimburse> appprove() {
    	 return EmployeeDaoJdbc.getEmployeeDaoJdbc().selectReimburseApproved();
     }
     
     public List<Reimburse> pending() {
    	 return EmployeeDaoJdbc.getEmployeeDaoJdbc().selectReimbursePending();
     }
     
     public List<Reimburse> employeeDisapproved(Employee employee) {
    	 return EmployeeDaoJdbc.getEmployeeDaoJdbc().selectEmployeeReimburseDisapproved(employee);
     }
     
     public List<Reimburse> employeeAppproved(Employee employee) {
    	 return EmployeeDaoJdbc.getEmployeeDaoJdbc().selectEmployeeReimburseApproved(employee);
     }
     
     public List<Reimburse> employeePending(Employee employee) {
    	 return EmployeeDaoJdbc.getEmployeeDaoJdbc().selectEmployeeReimbursePending(employee);
     }
     
     public List<Employee> Search(int eid) {
    	 return EmployeeDaoJdbc.getEmployeeDaoJdbc().searchEmployee(eid);
     }
     
     public boolean sApproved(int rid) {
    	 return EmployeeDaoJdbc.getEmployeeDaoJdbc().statusApproved(rid);
     }
     
     public boolean sDisapproved(int rid) {
    	 return EmployeeDaoJdbc.getEmployeeDaoJdbc().statusDisapproved(rid);
     } 
}
