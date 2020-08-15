package com.casestudy.retailbank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.casestudy.retailbank.bean.AccountPOJO;
import com.casestudy.retailbank.bean.CustomerPOJO;
import com.casestudy.retailbank.bean.StatusPOJO;
import com.casestudy.retailbank.util.DBConnectionUtil;

public class AccountDao {
	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	String query;
	Statement stmt=null;
	public boolean createAccount(AccountPOJO account) throws SQLException,ClassNotFoundException
	{
		System.out.println("inside dao");
		
		String query = null;
		Integer customerId = null;
		conn=DBConnectionUtil.getConnection();
		System.out.println(conn);
		ps=conn.prepareStatement("insert into tb_account(cust_id,acc_type,balance) values(?,?,?)");
		
		ps.setInt(1, account.getCust_id());
		ps.setString(2, account.getAcc_type());
		ps.setDouble(3, account.getBalance());
		
		int rowstatus = ps.executeUpdate();
		
		/*-------------Updated Code for status of the account---------------------*/
		
		System.out.println(conn);
		ps=conn.prepareStatement("select acc_id from tb_account order by acc_id desc LIMIT 1");
		rs=ps.executeQuery();
		int acc_id=0;
		while(rs.next())
		{
			//AccountPOJO account = new AccountPOJO();
			
			//account.setAcct_id(result.getInt("acc_id"));
			acc_id=rs.getInt("acc_id");
		}
		System.out.println("Account type : "+acc_id);
		
		
		
		ps=conn.prepareStatement("insert into tb_account_status(cust_id,acc_id,status,message) values(?,?,?,?)");
		
		ps.setInt(1, account.getCust_id());
		ps.setInt(2, acc_id);
		//ps.setString(3,account.getAcc_type());
		ps.setString(3, "Active");
		ps.setString(4, "account created successfully");
		
		//ps.setDouble(3, account.getAcct_balance());
		
		 ps.executeUpdate();
		 
		 
		 
	  /*-------------Updated Code for status of the account---------------------*/
		
		 
		 //logic to insert the account details to db using JDBC connection
		
		//query = "select acc_id from";
		return true;
	}
	
	public ArrayList<Integer> getAllAccountId() throws SQLException, ClassNotFoundException
	{
		conn=DBConnectionUtil.getConnection();
		System.out.println(conn);
		ps=conn.prepareStatement("select acc_id from tb_account order by acc_id");
		rs=ps.executeQuery();
		ArrayList<Integer> accountIdList=new ArrayList<Integer>();
		while(rs.next())
		{
			//AccountPOJO account = new AccountPOJO();
			
			//account.setAcct_id(result.getInt("acc_id"));
			accountIdList.add(rs.getInt("acc_id"));
		}
		System.out.println("Account Id list size: "+accountIdList.size());
		return accountIdList;
	}
	public boolean deleteAccount(int accountId,String accountType) throws SQLException, ClassNotFoundException
	{
System.out.println("inside dao");
		
		String query = null;
		Integer customerId = null;
		conn=DBConnectionUtil.getConnection();
		System.out.println(conn);
		ps=conn.prepareStatement("delete from tb_account where acc_id="+accountId+" and acc_type='"+accountType+"'");
		
		int rowstatus = ps.executeUpdate();
		System.out.println(rowstatus);
		if(rowstatus>0)
			return true;
		else
			return false;
	}

	public String searchAccountTypeByAID(int acc_id) throws SQLException, ClassNotFoundException
	{
		// TODO Auto-generated method stub
		conn=DBConnectionUtil.getConnection();
		System.out.println(conn);
		ps=conn.prepareStatement("select acc_type from tb_account where acc_id="+acc_id);
		rs=ps.executeQuery();
		String acc_type=new String();
		while(rs.next())
		{
			//AccountPOJO account = new AccountPOJO();
			
			//account.setAcct_id(result.getInt("acc_id"));
			acc_type=rs.getString("acc_type");
		}
		System.out.println("Account type : "+acc_type);
		return acc_type;
	
	}
	
	
	public List<AccountPOJO> searchAccountByCID(int cust_id) {
		
		List<AccountPOJO> list_account=new ArrayList<>();
		AccountPOJO account=null;
		conn=DBConnectionUtil.getConnection();
		query="select * from tb_account where cust_id=?";
		try {
			ps=conn.prepareStatement(query);
			ps.setInt(1, cust_id);
			rs=ps.executeQuery();
			
			while(rs.next())
			{
				account=new AccountPOJO();
				account.setAcc_id(rs.getInt(1));
				account.setCust_id(rs.getInt(2));
				account.setBalance(rs.getDouble(3));
				account.setAcc_type(rs.getString(4));
				
				list_account.add(account);
			}
			conn.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return list_account;
	}


	public AccountPOJO searchAccountByAID(int acc_id) {
		AccountPOJO account=null;
		conn=DBConnectionUtil.getConnection();
		query="select * from tb_account where acc_id=?";
		try {
			ps=conn.prepareStatement(query);
			ps.setInt(1, acc_id);
			rs=ps.executeQuery();
			
			if(rs.next())
			{
				account=new AccountPOJO();
				account.setAcc_id(rs.getInt(1));
				account.setCust_id(rs.getInt(2));
				account.setBalance(rs.getDouble(3));
				account.setAcc_type(rs.getString(4));
			}
			
			conn.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return account;
	}


	public List<StatusPOJO> ViewAllAccountStatus() {
		
		List<StatusPOJO> acc_status_arr=new ArrayList<>();
		StatusPOJO acc_status=null; 
		conn=DBConnectionUtil.getConnection();
		query="SELECT ts.cust_id, tc.acc_id,acc_type, status, message, last_updated " + 
				 "FROM tb_account_status as ts,tb_account tc WHERE ts.acc_id=tc.acc_id ";
		try {
			ps=conn.prepareStatement(query);
			rs=ps.executeQuery();
			while(rs.next())
			{
				acc_status=new StatusPOJO(); 
				acc_status.setCust_id(rs.getInt(1));
				acc_status.setAcc_id(rs.getInt(2));
				acc_status.setAcc_type(rs.getString(3));
				acc_status.setStatus(rs.getString(4));
				acc_status.setMessage(rs.getString(5));
				acc_status.setLast_updated(rs.getString(6));
				acc_status_arr.add(acc_status);
			}
			conn.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return acc_status_arr;
	}
		
	

}

