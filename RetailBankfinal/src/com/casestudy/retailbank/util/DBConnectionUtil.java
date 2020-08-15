package com.casestudy.retailbank.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionUtil {
	
	private static final String URL="jdbc:mysql://localhost:3306/retail_bank_db";
	private static final String USERNAME="root";
	private static final String PASSWORD="";
	private static final String DRIVER_NAME="com.mysql.jdbc.Driver";
	
	//com.mysql.jdbc.Driver in my system
	
	public static Connection getConnection() {
		//public static void main(String[] args){
		Connection conn=null;
				
		try {
			Class.forName(DRIVER_NAME);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			conn=DriverManager.getConnection(URL,USERNAME,PASSWORD);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		if(conn!=null)
		{
			//System.out.println(conn);
		}
		/* try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		return conn;
	}
	
	
	public void closeConnection(Connection conn) {
		
		 try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}