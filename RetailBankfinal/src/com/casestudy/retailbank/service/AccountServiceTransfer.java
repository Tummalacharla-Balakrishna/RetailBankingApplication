package com.casestudy.retailbank.service;
import com.casestudy.retailbank.dao.TranserDao;

public class AccountServiceTransfer {
	
	static TranserDao tDao = new TranserDao();
	
	public static boolean transferStatus(int accId,String srcType,String destType,double amount,int custId) {
		 return tDao.getTranserStatus(accId,srcType,destType,amount,custId);
	}

}