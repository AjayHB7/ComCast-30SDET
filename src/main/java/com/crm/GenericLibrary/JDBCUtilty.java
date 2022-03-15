package com.crm.GenericLibrary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;
/**
 * This class contains generic methods to read data from database
 * @author AJAY
 *
 */
public class JDBCUtilty 
{
	Connection con = null;
	/**
	 * This method will open the database connection
	 * @throws Throwable
	 */
	public void connectToDB() throws Throwable
	{
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		con=DriverManager.getConnection(iPathConstants.dbUrl, iPathConstants.dbUserName, iPathConstants.dbPassWord);
		
	}
	
	/**
	 * This method will close the database connection
	 * @throws Throwable
	 */
	public void closeDB() throws Throwable
	{
		con.close();
	}
	
	/**
	 * This method will execute the query and return the matching data to the user
	 * @param query
	 * @param coulumnIndex
	 * @param expData
	 * @return
	 * @throws SQLException
	 */
	public String executeQueryAndGetData(String query, int coulumnIndex, String expData) throws SQLException
	{
		String data = null;
		boolean flag = false;
		ResultSet result = con.createStatement().executeQuery(query);
		while(result.next())
		{
			data =result.getString(coulumnIndex);
			if(data.equalsIgnoreCase(expData))
			{
				flag=true;
				break;
			}
			
		}
		
		if(flag)
		{
			System.out.println(data+"-----> data is verified");
			return data;
		}else
		{
			System.out.println("data is not verified");
			return null;
		}
	}

	/**
	 * This method will execute the update and return the number of row effected
	 * @param Query
	 * @return
	 * @throws Throwable
	 */
	public int executeUpdateQuery(String Query) throws Throwable
	{
		int res = con.createStatement().executeUpdate(Query);
		return res;
	}
}
