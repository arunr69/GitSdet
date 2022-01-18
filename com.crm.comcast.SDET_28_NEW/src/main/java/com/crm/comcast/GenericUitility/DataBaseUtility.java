package com.crm.comcast.GenericUitility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.jdbc.NonRegisteringDriver;

public class DataBaseUtility {
	private static final String DrieverManager = null;
	Connection connection=null;
/**
 * This method will do the connection to database
 * @throws Throwable
 */
	public void connectToDb() throws Throwable {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		DriverManager.getConnection("jdbc:mysql://localhost:3306/studentinfo","root","root");
			
	}
	
	/**
	 * This method will close the database connection
	 * @throws Throwable 
	 * @throws  
	 */
	public void closeDB() throws Throwable   {
	connection.close();
	}
	
	/**
	 * method will fetch all the data from the database
	 * @param querry
	 * @return
	 * @throws Throwable 
	 */
	public ResultSet getAllData(String querry) throws Throwable {
		ResultSet result = connection.createStatement().executeQuery(querry);
		return result;
	}
		
	/**
	 * Method will update the data in database and it will verify 
	 * @param querry
	 * @return
	 * @throws Throwable
	 */
	public boolean UpdateData(String querry) throws Throwable  {
		boolean flag = false;
		int result = connection.createStatement().executeUpdate(querry);
		if (result==1) {
			System.out.println("data is update in database");
			flag=true;
		}else {
			
			System.out.println("data is not present in database");
			
		}
		return flag;
	}
		
	public String getTheData(String querry,int columnNumber,String expectedData) throws Throwable {
		boolean flag=false;
		String actualData =null;
		ResultSet result = connection.createStatement().executeQuery(querry);
		while(result.next()) {
			String data = result.getString(columnNumber);
			if(data.equals(expectedData)) {
				actualData=data;
				flag=true;
				break;
			}
		}
		if (flag==true) {
			System.out.println("data is present in the database");
			return actualData;
		}else {
			System.out.println("data is not present in database");
			return actualData;
		}
	}
			
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}


