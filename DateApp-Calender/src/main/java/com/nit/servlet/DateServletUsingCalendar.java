package com.nit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

public class DateServletUsingCalendar extends HttpServlet {
	
	public void service(ServletRequest req, ServletResponse res)throws IOException,ServletException{
		PrintWriter pw=null;
		Calendar calendar=null;
		
		//get printwriter obj
		pw=res.getWriter();
		//setContenttype
		res.setContentType("text/html");
		//create calender class obj
		calendar=Calendar.getInstance();
		//get current time and date
		//print it
		pw.println("<h1> current time and Date is ::- "+calendar.getTime()+"<h1>");
		pw.println("<h2> Day of the week :- "+Calendar.DAY_OF_WEEK+"<h2>");
		pw.println("<h2> Day of the month :- "+Calendar.DAY_OF_MONTH+"<h2>");
		pw.println("<h2> Day of the year :- "+Calendar.DAY_OF_YEAR+"<h2>");
		//close stream
		pw.close();
	}

}
