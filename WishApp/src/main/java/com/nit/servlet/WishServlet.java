package com.nit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

public class WishServlet extends HttpServlet {
	public void service(ServletRequest req , ServletResponse res )throws IOException,ServletException{
		PrintWriter pw=null;
		int hours=0;
		String name=null;
		String tage=null;
		int age=0;
		//read data from req and save into local veriable
		name=req.getParameter("name");
		tage=req.getParameter("age");  //direct cant convert to int
		//convert string to its own type
		age=Integer.parseInt(tage);
		
		//get writer
		pw=res.getWriter();
		//set Content type;
		res.setContentType("text/html");
		//create date class obj having current time and date
        //Date dt=new Date();//deprecated since java 1.8 thats why we use Calnder class
        Calendar cal=Calendar.getInstance();
		//b.logic
        //getHours of the day
        hours=cal.get(Calendar.HOUR_OF_DAY);
        pw.println("<h2> hour of the day is ::- "+hours+" <h2>");
        if(hours<=12)
        	pw.println("<h3> Good morning ::- "+name+" your age is ::- "+age+"<h3>");
        else if(hours<=15)
        	pw.println("<h3> Good afternoon ::- "+name+" your age is ::- "+age+"<h3>");
        else if(hours<=18)
        	pw.println("<h3> Good evening ::- "+name+" your age is ::- "+age+"<h3>");
        else
             	pw.println("<h3> Good night ::- "+name+" your age is ::- "+age+"<h3>");
        
        //close stream 
        pw.close();
	
	}

}
