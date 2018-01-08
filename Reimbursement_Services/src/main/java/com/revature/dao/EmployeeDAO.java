package com.revature.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.model.Employee;
import com.revature.util.ConnectionUtil;

public class EmployeeDAO implements IEmployeeDAO {

	
	@Override
	public Employee getEmployeeInfo(String username) throws SQLException {
		ResultSet rs = null;
		Employee employeeInfo = null;
		try(Connection conn = ConnectionUtil.getConnection()){
			Statement stmt = null;
			String query = "select employee.firstname, employee.lastname, infoemployee.address, infoemployee.city, infoemployee.state, infoemployee.zipcode, infoemployee.phone, email.email, jobtitle.title "
					+ "from rpadmin.employee "
					+ "inner join rpadmin.logininfo on logininfo.login_id = employee.login_id "
					+ "inner join rpadmin.infoemployee on infoemployee.employee_id = employee.employee_id "
					+ "inner join rpadmin.email  on email.EMPLOYEE_ID = employee.EMPLOYEE_ID "
					+ "inner join rpadmin.jobtitle on jobtitle.TITLE_ID = logininfo.TITLE_ID "
					+ "where rpadmin.logininfo.username = '" + username + "'";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			rs.next();
			employeeInfo = new Employee(rs.getString("firstname"),
					rs.getString("lastname"),
					rs.getString("address"),
					rs.getString("city"),
					rs.getString("state"),
					rs.getInt("zipcode"),
					rs.getLong("phone"),
					rs.getString("email"),
					rs.getString("title"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeInfo;
	}
}
