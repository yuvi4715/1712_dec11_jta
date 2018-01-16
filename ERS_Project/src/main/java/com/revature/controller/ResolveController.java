package com.revature.controller;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

public class ResolveController {
	
	public static String resolve(HttpServletRequest request) {
		
		System.out.println("In Resolve Controller");
		
		Enumeration paramNames = request.getParameterNames();
		String param, resolve;
		
		while(paramNames.hasMoreElements()) {
			
			param = (String) paramNames.nextElement();
			resolve = request.getParameter(param);
			
			System.out.println(param);
			
			//If approved
			if(param.equals("approve") && resolve != null) {
				System.out.println("Should go to approve.do");
				return "/approve.do";
				
			}else if(param.equals("decline") && resolve != null) {
				System.out.println("Should go to decline.do");
				return "/decline.do";
			}
		}
		
		return "/resolve_page.do";
		
	}

}
