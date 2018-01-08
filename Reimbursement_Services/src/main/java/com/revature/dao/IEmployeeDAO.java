package com.revature.dao;

import java.sql.SQLException;

import com.revature.model.Employee;

public interface IEmployeeDAO extends IMainDAO{
	
	Employee getEmployeeInfo(String username) throws SQLException;


}
