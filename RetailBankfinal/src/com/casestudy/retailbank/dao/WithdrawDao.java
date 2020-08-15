package com.casestudy.retailbank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.casestudy.retailbank.bean.TransferPOJO;
import com.casestudy.retailbank.bean.WithdrawPOJO;
import com.casestudy.retailbank.util.CurrentDate;
import com.casestudy.retailbank.util.DBConnectionUtil;

public class WithdrawDao {
	static Connection conn=null;
	static PreparedStatement ps=null;
	static ResultSet rs=null;
	static String query = null;
	
	TransferPOJO transfer = null; 
	ArrayList<WithdrawPOJO>  withdraw = null;
	WithdrawPOJO wSts = null;
	public ArrayList<WithdrawPOJO> getWithdrawStatus(int accId,int custId,String accType,double amount){
		
		try {
			conn=DBConnectionUtil.getConnection();
			query = "select * from tb_account where acc_id="+accId;
			ps=conn.prepareStatement(query);
			rs = ps.executeQuery();
			double availableAmount = 0 ;
			transfer = new TransferPOJO(); 
			while(rs.next()) {
				
				availableAmount = rs.getInt(3);
				
			}
			
			if(availableAmount < amount) {
				
				return withdraw;
			}else {
				int check = 0;
				double temp = amount;
				amount = availableAmount - amount;
				
				
				query = "update tb_account set balance = "+amount+" where acc_id = "+accId;
				ps = conn.prepareStatement(query);
				check = ps.executeUpdate();
				
				query = "select * from tb_account where acc_id="+accId;
				ps = conn.prepareStatement(query);
				rs = ps.executeQuery();
				withdraw = new ArrayList<WithdrawPOJO>();
				while(rs.next()) {
					
					wSts = new WithdrawPOJO(); 
					wSts.setAmount(rs.getDouble(3));
					withdraw.add(wSts);
					//System.out.println("src : "+rs.getDouble(3));
				}
				query = "insert into tb_transaction(discrip,dt,amount,acc_id) VALUES('withdraw','"+CurrentDate.convertDateToString()+"',"+temp+","+accId+")";
				ps = conn.prepareStatement(query);
				check = ps.executeUpdate();
				//System.out.println(check);
			}
			
			ps.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return withdraw;
	}

}