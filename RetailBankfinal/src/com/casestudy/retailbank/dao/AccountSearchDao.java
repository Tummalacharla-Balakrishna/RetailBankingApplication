package com.casestudy.retailbank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.casestudy.retailbank.bean.AccountSearchPOJO;
import com.casestudy.retailbank.util.DBConnectionUtil;

public class AccountSearchDao {
	static Connection conn=null;
	static PreparedStatement ps=null;
	static ResultSet rs=null;
	static String query = null;
	boolean flag = false;
	AccountSearchPOJO accSearch = null;
	ArrayList<AccountSearchPOJO> list = null;
	
	public ArrayList<AccountSearchPOJO> searchAccount(int id,String type){
		
		try {
			conn=DBConnectionUtil.getConnection();
			if(type == "acc_id") {
				query = "select * from tb_account where acc_id ="+id ;
			}else {
				query = "select * from tb_account where cust_id ="+id ;
			}
			ps=conn.prepareStatement(query);
			rs = ps.executeQuery();
			list = new ArrayList<AccountSearchPOJO>(); 
			while(rs.next()) {
				accSearch = new AccountSearchPOJO();
				accSearch.setAccId(rs.getInt(1));
				accSearch.setCustId(rs.getInt(2));
				accSearch.setAmount(rs.getDouble(3));;
				accSearch.setType(rs.getString(4));
				accSearch.setUpdate("DepositMoney.jsp");
				accSearch.setDelete("WithdrawAmount.jsp");
				accSearch.setTransfer("TransferMoney.jsp");
				list.add(accSearch);
			}
			
			ps.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
}

