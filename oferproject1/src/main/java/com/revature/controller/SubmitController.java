package com.revature.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
//import org.apache.commons.io.IOUtils;
import javax.servlet.http.*;
import com.revature.model.Request;
import com.revature.service.Service;
import java.util.*;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

//@MultipartConfig
//@WebServlet("/SubmitServlet") 
//public class SubmitController extends HttpServlet {
public class SubmitController{
	//   private boolean isMultipart;
	  // private String filePath ="C:\\Users\\Skynet\\Desktop\\Training\\projects\\Receipts2";
	   //private int maxFileSize = 50 * 1024;
	   //private int maxMemSize = 4 * 1024;
	   //private File file ;
	
	private static final long serialVersionUID = 6643075975954708810L;
	

	public static String submit(HttpServletRequest request) { 
		
		HttpSession session = ((HttpServletRequest)request).getSession(false);
	     
		int mflag = Integer.parseInt((String)session.getAttribute("mflag"));
		int eid = Integer.parseInt((String)session.getAttribute("eid"));
		
		String amount = request.getParameter("amount");
		String type = request.getParameter("type");
		String type2 = request.getParameter("details");
		
		System.out.println(eid+" "+mflag+" "+amount+" "+type);
		
		Service.getInstance().submit(new Request(eid,amount,type,type2,0,"0"));
		
		request.setAttribute("submitted","Your request has been submitted!");

		if(mflag==0)
    		return "Employee Homepage.jsp";
	    else if(mflag==1)
    		return "Manager Homepage.jsp";
    	else
    		return "Login.jsp";   
		
	}
	
}
