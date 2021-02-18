package com.nit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class DateServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		//set response content type
		res.setContentType("text/html");
		//get printWriter obj having res as destination
		pw=res.getWriter();
		//Write response
		Date d=new Date();
		pw.println("<b><center> Date and Time  is ::- "+d+"</center></b>");
		//close stream
		pw.close();
	}

	}
