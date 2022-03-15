package com.crm.PRACTICE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteUpdate
{
	@Test
	public void sampleJDBCExecuteUpdate() throws SQLException
	{
		Connection con= null;
		try{
		// register to database
		Driver driverref = new Driver();
		DriverManager.registerDriver(driverref);
		
		//establish connection to database
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
		System.out.println("connection is open");
		
		// issue create statement
		Statement state = con.createStatement();
		
		// execute the query
		int result = state.executeUpdate("insert into student values('2','chai','bangalore');");
		
		if(result==1){
			System.out.println("data added successfully");
		}
		else{
			System.out.println("data not added");
		}
		
		}
		catch (Exception e) {
		
		}
		
		finally 
		{
		// close the connection
			con.close();
			System.out.println("connection is closed");
		}
		
	}

}
