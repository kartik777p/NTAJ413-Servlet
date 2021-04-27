package com.nit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

public class DateServlet extends HttpServlet {
	
	
	//service method
	public void service(ServletRequest req, ServletResponse res)throws IOException,ServletException{
		
		PrintWriter pw=null;
		//get writer  having res obj as dest
		pw=res.getWriter();
		//set contentType
		res.setContentType("text/html");
		//get current date using Date class
		Date dt=new Date();
		//write to res obj using pw.println
		pw.println("<h1> <center> Current Date is ::- "+ dt+"</center><h1>");
		//close stream
		pw.close();
		
	}

}
