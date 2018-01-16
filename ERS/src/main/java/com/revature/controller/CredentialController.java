package com.revature.controller;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.DAOFactory;
import com.revature.model.Credential;
import com.revature.model.Employee;
import com.revature.util.FinalUtil;



public class CredentialController {
class Passwords{
	private String oldPassword;
	private String newPassword;
	public String getOldPassword() {
		return oldPassword;
	}
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	
	
}
	private static Logger logger = Logger.getLogger(CredentialController.class);
	public static String login(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Credential authEmp = new Credential(username, password);
			if((authEmp = DAOFactory.getInstance().validate(authEmp)) != null) {
				setCookie(request, response, authEmp);
				switch(authEmp.getTitle()) {
				case FinalUtil.MANAGER:
					return "/html/managerhome.html";
				case FinalUtil.EMPLOYEE:
					return "/html/employeehome.html";
				}
			}
			else {
				response.setContentType("text/html");
				try {
					response.getWriter().append(FinalUtil.INVALID_LOGIN);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		return "/html/index.html";
	}

	public static boolean changePassword(HttpServletRequest request, HttpServletResponse response) {
		String username = null;
		ObjectMapper om = new ObjectMapper();
		Passwords passwords = null;
		try {
			passwords = om.readValue(request.getReader().readLine(), Passwords.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
			logger.error(e);
		} catch (JsonMappingException e) {
			e.printStackTrace();
			logger.error(e);
		} catch (IOException e) {
			e.printStackTrace();
			logger.error(e);
		}
		
		for(Cookie c : request.getCookies())
			if(c.getName().equals("username")) {
				username = c.getValue();
			}
		return DAOFactory.getInstance().changePassword(new Credential(username, passwords.getOldPassword()), passwords.getNewPassword());
		
	}
	
	public static Employee getUserInfo(HttpServletRequest request, HttpServletResponse response) {
		String username = null;
		for(Cookie c : request.getCookies())
			if(c.getName().equals("username")) {
				username = c.getValue();
			}
		return DAOFactory.getInstance().getUserInfo(username);
	}
	
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static Employee getEmployeeInfo(HttpServletRequest request, HttpServletResponse response) {
		ObjectMapper om = new ObjectMapper();
		Employee empName = null;
		try {
			empName = om.readValue(request.getReader().readLine(), Employee.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return DAOFactory.getInstance().getEmployeeInfo(empName);
	}
	
	public static String logout(HttpServletRequest request, HttpServletResponse response) {
		deleteCookies(request, response);
		return "html/index.html";
	}
	private static void setCookie(HttpServletRequest request, HttpServletResponse response, Credential credential) {
		Cookie cookie;
		try {
			if(request.getCookies() == null || request.getCookies().length < 4) {
				Employee employee = DAOFactory.getInstance().getUserInfo(credential.getUsername());
				cookie = new Cookie("username", credential.getUsername());
				cookie.setMaxAge(20 * 60);
				response.addCookie(cookie);
				cookie = new Cookie("title", credential.getTitle());
				cookie.setMaxAge(20 * 60);
				response.addCookie(cookie);
				cookie = new Cookie("firstname", employee.getFirstname());
				cookie.setMaxAge(20 * 60);
				response.addCookie(cookie);
				cookie = new Cookie("lastname", employee.getLastname());
				cookie.setMaxAge(20 * 60);
				response.addCookie(cookie);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			logger.error(e);
		} catch (NullPointerException e) {
			e.printStackTrace();
			logger.error(e);
		}
	}
	
	private static void deleteCookies(HttpServletRequest request, HttpServletResponse response) {
		Cookie cookie;
		try {
				cookie = new Cookie("username","" );
				cookie.setMaxAge(0);
				response.addCookie(cookie);
				cookie = new Cookie("title", "");
				cookie.setMaxAge(0);
				response.addCookie(cookie);
				cookie = new Cookie("firstname","");
				cookie.setMaxAge(0);
				response.addCookie(cookie);
				cookie = new Cookie("lastname", "");
				cookie.setMaxAge(0);
				response.addCookie(cookie);
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			logger.error(e);
		} catch (NullPointerException e) {
			e.printStackTrace();
			logger.error(e);
		}
	}
}
