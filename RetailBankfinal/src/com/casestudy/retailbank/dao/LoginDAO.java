package com.casestudy.retailbank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.casestudy.retailbank.util.DBConnectionUtil;

public class LoginDAO {
	public static boolean validateLogin(String username, String password) {
	
	Connection con = null;
	boolean isValid = false;
	
	try
	{
		con = DBConnectionUtil.getConnection();
		String query = "select * from tb_userstore where username=? and password=?";
		PreparedStatement pstm = con.prepareStatement(query);
		pstm.setString(1,  username);
		pstm.setString(2,  password);
		ResultSet rs = pstm.executeQuery();
		
		if(rs.next())
			isValid = true;
		
		
	}
	catch (SQLException e) {
		e.printStackTrace();
	}
	finally
	{
		//DBConnectionUtil.closeConnection(con);
	}
	
	return isValid;

}
}
