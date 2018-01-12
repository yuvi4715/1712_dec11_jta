package com.revature.dao;

import java.util.List;

import com.revature.model.Employee;

public interface EmployeeDao {
	
//Employee requirements	
//	\1-An Employee can login\
//	2-An Employee can view the Employee Home page (servlets/js)
//	3-An Employee can logout (servlets/js)
//	\8-An Employee can view their information\
//	9-An Employee can update their information
	
//	\10-A Manager can login\
//	11-A Manager can view the Manager Homepage (servlets/js)
//	12-A Manager can logout	(servlets/js)
//	\13-A Manager can view all Employees\

//	\14-A Manager can register an Employee, which sends the Employee an email with their username and temp password (optional)\
//	\15-An Employee can reset their password (Optional - tied with above functional requirement)\
//	16-An Employee receives an email when one of their reimbursement requests is resolved (optional)

	public boolean insert(Employee employee);			//14
	public boolean insertProcedure(Employee employee);	//14
	public Employee select(Employee employee);			//8
	public List<Employee> selectAll();					//13
	public String getCustomerHash(Employee employee);	//1,10
	public boolean update(Employee employee);			//15
	public Employee selectId(Employee employee);
	
}
