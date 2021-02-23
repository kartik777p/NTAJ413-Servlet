package com.nit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HtmlServlet  extends HttpServlet {

	@Override
	public void service(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException{
		PrintWriter pw=null;
		//set responseContent type
		res.setContentType("text/html");
		//get printWriter
		pw=res.getWriter();
		//write logic
		pw.println("<table border='1'>");
		pw.println("<tr><th>Player</th> <th>Role</th></tr>");
		pw.println("<tr><td>Dhoni</td> <td>Captain</td></tr>");
		pw.println("<tr><td>Gambhir</td> <td>Vice-Captain</td></tr>");
		pw.println("</table>");
		//close stream
		pw.close();
	}
	
	}

