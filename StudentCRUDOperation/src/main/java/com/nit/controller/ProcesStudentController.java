package com.nit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nit.dto.StudentDTO;
import com.nit.service.StudentService;
import com.nit.service.StudentServiceImpl;
import com.nit.vo.StudentVO;

@WebServlet("/genurl")
public class ProcesStudentController extends HttpServlet {
	private StudentService service;

	// cons
	public ProcesStudentController() {
		try {
			service = new StudentServiceImpl();
		} catch (ClassNotFoundException cnf) {
			cnf.printStackTrace();
		} catch (SQLException se) {
			se.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw = null;
		StudentDTO dto = null;
		int count =0;
		String msg=null;
		// create pw poiting res object as the dest
		pw = res.getWriter();
		// set content type
		res.setContentType("text/html");
		// gather data from req param and set to DTO class..by Convering to its orignal
		// type
		dto = new StudentDTO();
		dto.setSname(req.getParameter("name"));
		dto.setAge(Integer.parseInt(req.getParameter("age")));
		dto.setAddrs(req.getParameter("addrs"));
		dto.setM1(Integer.parseInt(req.getParameter("m1")));
		dto.setM2(Integer.parseInt(req.getParameter("m2")));
		dto.setM3(Integer.parseInt(req.getParameter("m3")));
		//call service method by passing dto class obj 
		try {
		 count=service.genrateResult(dto);
		 if(count!=0) {
			 msg="Student details is Saved Sucessfully !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!";
		 }
		 else {
			 msg="Student details is not  Saved Sucessfully please check once..................... ";
		
		 }
		 //transfer control to jsp 
		 req.setAttribute("msg", msg);
		 RequestDispatcher dispatcher=req.getRequestDispatcher("resultmsg.jsp");
		 dispatcher.forward(req, res);
		 
		// System.out.println(req.getAttribute("msg"));
		 
		}catch (Exception e) {
			e.printStackTrace();
		}
	
		
	}// get

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		doGet(req, res);
	}// post

}
