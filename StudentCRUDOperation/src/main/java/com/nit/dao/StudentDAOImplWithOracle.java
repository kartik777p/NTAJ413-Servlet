package com.nit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.nit.bo.StudentBO;
import com.nit.commons.DBConnectivity;

public class StudentDAOImplWithOracle  implements StudentDAO{
	private static final String GENRATE_RESULT="INSERT INTO student_result VALUES(sno.nextval,?,?,?,?,?)";
	private Connection con = null;

	// cons
	public StudentDAOImplWithOracle() throws Exception {
		// create connection
		con = DBConnectivity.getConnection();
		System.out.println(con);
	}
	@Override
	public int insertStudent(StudentBO bo) throws Exception {
		PreparedStatement ps = null;
		int count=0;
		// create prepared statement
		if (con != null) {
			ps = con.prepareStatement(GENRATE_RESULT);
			System.out.println("query is pre-compiled");
			}//if
        //set values to queery param
		if(ps!=null) {
			ps.setString(1,bo.getSname());
			ps.setInt(2,bo.getAge());
			ps.setString(3,bo.getAddrs());
			ps.setInt(4, bo.getTotal());
			ps.setString(5,bo.getResult());
			System.out.println("values set sucesfully to query param");
			//execute query
	}//if
		count=ps.executeUpdate();
		// return count to service class.. to print user fdzly massage
		return count;
	}//method


}
