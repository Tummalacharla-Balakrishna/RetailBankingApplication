package com.casestudy.retailbank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.casestudy.retailbank.bean.DepositPOJO;
import com.casestudy.retailbank.bean.TransferPOJO;
import com.casestudy.retailbank.bean.WithdrawPOJO;
import com.casestudy.retailbank.util.CurrentDate;
import com.casestudy.retailbank.util.DBConnectionUtil;

public class DepositDao {
	
	static Connection conn=null;
	static PreparedStatement ps=null;
	static int rs=0;
	static String query = null;
	
	DepositPOJO deposit = null; 
	ArrayList<DepositPOJO>  depositList = null;
	DepositPOJO dSts = null;
	int check = 0;
	public ArrayList<DepositPOJO> getDepositStatus(int accId,int custId,String accType,double amount){
		
		try {
			conn=DBConnectionUtil.getConnection();
			query = "update  tb_account set balance= balance+"+amount+" where acc_id="+accId;
			ps=conn.prepareStatement(query);
			rs = ps.executeUpdate();
			
			query = "select * from tb_Account where acc_id = "+accId;
			ps = conn.prepareStatement(query);
			ResultSet result = ps.executeQuery();
			depositList = new ArrayList<DepositPOJO>();
			while(result.next()) {
				deposit = new DepositPOJO();
				deposit.setAmount(result.getDouble(3));
				depositList.add(deposit);
			}
			
			query = "insert into tb_transaction(discrip,dt,amount,acc_id) VALUES('deposit','"+CurrentDate.convertDateToString()+"',"+amount+","+accId+")";
			ps = conn.prepareStatement(query);
			check = ps.executeUpdate();
			ps.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return depositList;
	}


}