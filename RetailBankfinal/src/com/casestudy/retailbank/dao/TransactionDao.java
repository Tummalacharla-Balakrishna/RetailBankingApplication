package com.casestudy.retailbank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.casestudy.retailbank.bean.CustomerTransactions;
import com.casestudy.retailbank.util.DBConnectionUtil;

public class TransactionDao {
	static Connection conn=null;
	static PreparedStatement ps=null;
	static ResultSet rs=null;
	static String query = null;
	ArrayList<CustomerTransactions> list = null;
	boolean flag = true;
	public ArrayList<CustomerTransactions> getTransactionList(int accId,int count){
		
		try {
			conn=DBConnectionUtil.getConnection();
			query = "select * from tb_transaction where acc_id="+accId+" order by trans_id desc limit "+count;
			ps=conn.prepareStatement(query);
			rs = ps.executeQuery();
			if(rs !=null) {
				list = new ArrayList<CustomerTransactions>();;
				while( rs.next()) {
					CustomerTransactions ct = new CustomerTransactions();
					ct.setId(rs.getInt(1));
					ct.setType(rs.getString(2));
					ct.setDate(""+rs.getDate(3));
					ct.setAmount(rs.getDouble(4));
					ct.setAccId(rs.getInt(5));
					list.add(ct);
					flag = false;
				}
			}
			
			ps.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		if(flag) {
			return null;
		}else {
			return list;
		}
	}
	
	public ArrayList<CustomerTransactions> getTransactionList(int accId){
		try {
			conn=DBConnectionUtil.getConnection();
			query = "select * from tb_transaction where acc_id="+accId;
			ps=conn.prepareStatement(query);
			rs = ps.executeQuery();
			if(rs !=null) {
				list = new ArrayList<CustomerTransactions>();;
				while( rs.next()) {
					CustomerTransactions ct = new CustomerTransactions();
					ct.setId(rs.getInt(1));
					ct.setType(rs.getString(2));
					ct.setDate(""+rs.getDate(3));
					ct.setAmount(rs.getDouble(4));
					ct.setAccId(rs.getInt(5));
					list.add(ct);
					flag = false;
				}
			}
			
			ps.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		if(flag) {
			return null;
		}else {
			return list;
		}
	}
	
	public ArrayList<CustomerTransactions> getTransactionListByDate(int accId,String startDate,String endDate){
		try {
			conn=DBConnectionUtil.getConnection();
			query = "select * from tb_transaction where acc_id="+accId+" and dt between '"+startDate+"' and '"+endDate+"'";
			ps=conn.prepareStatement(query);
			rs = ps.executeQuery();
			if(rs !=null) {
				list = new ArrayList<CustomerTransactions>();;
				while( rs.next()) {
					CustomerTransactions ct = new CustomerTransactions();
					ct.setId(rs.getInt(1));
					ct.setType(rs.getString(2));
					ct.setDate(""+rs.getDate(3));
					ct.setAmount(rs.getDouble(4));
					ct.setAccId(rs.getInt(5));
					list.add(ct);
					//System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getDate(3)+" "+rs.getDouble(4)+" "+rs.getInt(5));
					flag = false;
				}
			}
			
			ps.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		if(flag) {
			return null;
		}else {
			return list;
		}
	}

}
