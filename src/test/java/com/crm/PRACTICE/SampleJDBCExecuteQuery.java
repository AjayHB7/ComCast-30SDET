package com.crm.PRACTICE;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteQuery 
{
	@Test
	public void sampleJDBCExecuteQuery() throws SQLException 
	{
		Connection con=null;
		
		try{
			
		//step 1 register database
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		
		// step2 get connector from database- provide database name
	    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
	    System.out.println("connection is open");
	     
		// step3 issue create statement
	    Statement st = con.createStatement();
	    
	    //step 4 execute query
	    ResultSet result = st.executeQuery("select * from student;");
	    
	    while(result.next())
	    {
	    System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3));
	    }
	    
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	    finally {
	    	// step 5 close connection
		    con.close();
		    System.out.println("connection is closed");
		}
	    
	    
		
		
	}
		
		
	}


