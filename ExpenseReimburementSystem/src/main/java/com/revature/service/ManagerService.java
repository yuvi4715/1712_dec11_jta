package com.revature.service;

import com.revature.dao.ManagerDaoJdbc;


public class ManagerService {
	
private static ManagerService managerService;
	
	private ManagerService() {
	}
	public static ManagerService getManagerService() {
		if(managerService == null) {
			managerService = new ManagerService();
		}
		return managerService;
	}
	
	public void approve(int id, int managerID) {
		ManagerDaoJdbc.getManagerDaoJdbc().approve(id, managerID);
	}
	
	public void deny(int id, int managerID) {
		ManagerDaoJdbc.getManagerDaoJdbc().deny(id, managerID);
	}
}
