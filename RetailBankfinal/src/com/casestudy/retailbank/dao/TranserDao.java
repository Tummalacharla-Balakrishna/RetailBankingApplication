package com.casestudy.retailbank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.casestudy.retailbank.bean.CustomerTransactions;
import com.casestudy.retailbank.bean.TransferPOJO;
import com.casestudy.retailbank.util.CurrentDate;
import com.casestudy.retailbank.util.DBConnectionUtil;

public class TranserDao {
	
	static Connection conn=null;
	static PreparedStatement ps=null;
	static ResultSet rs=null;
	static String query = null;
	boolean flag = false;
	TransferPOJO transfer = null; 
	ResultSet rs2 = null;
	String query2 = null;
	public boolean getTranserStatus(int accId,String srcType,String destType,double amount,int custId){
		destType = destType.toLowerCase();
		try {
			
			System.out.println(accId+" "+srcType+" "+destType+" "+destType.toLowerCase());
			conn=DBConnectionUtil.getConnection();
			query = "select * from tb_account where cust_id="+accId+" and acc_type = '"+srcType+"'";
			
			
			query2 = "select * from tb_account where cust_id="+accId+" and acc_type = '"+destType+"'";
			
			ps=conn.prepareStatement(query);
			rs = ps.executeQuery();
			double availableAmount = 0 ;
			transfer = new TransferPOJO(); 
			while(rs.next()) {
				
				availableAmount = rs.getInt(3);
				transfer.setSrcType(srcType);
				transfer.setDestType(destType);
				transfer.setBalance(availableAmount);
				//System.out.println("available amount : "+availableAmount);
			}
			query = "select * from tb_account where cust_id = "+accId;
			int count = 0;
			while(rs.next()) {
				count++;
			}
			
			ps = conn.prepareStatement(query2);
			rs2 = ps.executeQuery();
			int test = 0;
			while(rs2.next()) {
				test = 1;
			}
			//System.out.println(" not exists");
			if(count == 1 || srcType.equals(destType) || test ==0) {
				System.out.println(count);
				return false;
			}
			
			if(availableAmount < amount) {
				System.out.println("invalid");
				return false;
			}else {
				
				int check = 0;
				query = "update tb_account set balance = balance-"+amount+" where cust_id = "+accId+" and acc_type = '"+srcType+"'";
				ps = conn.prepareStatement(query);
				check = ps.executeUpdate();

				System.out.println("src : "+check);
				query = "update tb_account set balance = balance+"+amount+" where cust_id = "+accId+" and acc_type = '"+destType+"'";
				ps = conn.prepareStatement(query);
				check = ps.executeUpdate();
				System.out.println("dest : "+check);
				
				query = "insert into tb_transaction(discrip,dt,amount,acc_id) VALUES('transfer','"+CurrentDate.convertDateToString()+"',"+amount+","+custId+")";
				ps = conn.prepareStatement(query);
				check = ps.executeUpdate();
				//System.out.println(check);
				
				flag = true;
			}
			
			ps.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
}