package com.nit.service;

import com.nit.bo.StudentBO;
import com.nit.dao.StudentDAO;
import com.nit.dao.StudentDAOImplWithMYSQL;
import com.nit.dao.StudentDAOImplWithOracle;
import com.nit.dto.StudentDTO;

public class StudentServiceImpl implements StudentService {
   private StudentDAO dao=null;
   
   //cons
   public StudentServiceImpl()throws Exception {
	   //create dao class obj
	  // dao=new StudentDAOImplWithOracle();   //for oracle
	   dao=new StudentDAOImplWithMYSQL();       //mysql
   }

	@Override
	public int genrateResult(StudentDTO dto)throws Exception {
		//gather data from dto and genrate result
		int total=0;
		String result=null;
		StudentBO  bo=null;
		int count=0;
		
		//calc total
		total=dto.getM1()+dto.getM2()+dto.getM3();
		//check pass or fail based on marks
		if(dto.getM1()>=35 && dto.getM2()>=35 && dto.getM3()>=35) {
			result="pass";
		}
		else {
			result="fail";
		}
		//set this values to bo class obj
		bo=new StudentBO();
		bo.setSname(dto.getSname());
		bo.setAge(dto.getAge());
		bo.setAddrs(dto.getAddrs());
		bo.setTotal(total);
		bo.setResult(result);
		//call dao class method to insert data
		count=dao.insertStudent(bo);
		//return count 
		return count;
	}

}
