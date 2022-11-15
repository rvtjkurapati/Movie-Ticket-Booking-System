package com.virtusa.mtms.util;

import java.sql.*;

public class DbConnection {
	
	public static Connection getConnection()
	{ 
	
	try
	{
	Class.forName("com.mysql.cj.jdbc.Driver");
	
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample","root","root");
	return con;
	}
	
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return null;
	
	}

}
