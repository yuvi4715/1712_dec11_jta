package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import com.revature.util.ConnectionUtil;
import com.revature.util.LogUtil;


public class ManagerDaoJdbc implements ManagerDao {

	/*Singleton transformation of JDBC implementation object */
	private static ManagerDaoJdbc managerDaoJdbc;

	private ManagerDaoJdbc() {

	}

	public static ManagerDaoJdbc getManagerDaoJdbc() {
		if(managerDaoJdbc == null) {
			managerDaoJdbc = new ManagerDaoJdbc();
		}

		return managerDaoJdbc;
	}

	public void approve(int id, int managerID) {
		try(Connection connection = ConnectionUtil.getConnection()) {
			int statementIndex = 0;
			//Pay attention to this syntax
			String command = "{CALL APPROVE_REIMBURSEMENT(?,?)}";

			//Notice the CallableStatement
			CallableStatement statement = connection.prepareCall(command);

			statement.setInt(++statementIndex, id);
			statement.setInt(++statementIndex, managerID);
			statement.executeQuery();

		} catch (SQLException e) {
			LogUtil.logger.warn("Exception approving ticket", e);
		}

	}
}
