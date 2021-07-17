package com.nit.commons;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnectivity {
	private static Connection con;
	
	public static Connection getConnection() throws Exception{
		//register jdbc driver
		//Class.forName("oracle.jdbc.driver.OracleDriver");
		Class.forName("com.mysql.cj.jdbc.Driver");
		//establish the connection with db sw
		//con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","SYSTEM");
	   
		con=DriverManager.getConnection("jdbc:mysql:///student_proj","root","root");//return con obj
		return con;
	}

}
