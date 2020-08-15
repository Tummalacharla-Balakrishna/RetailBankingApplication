package com.casestudy.retailbank.service;

import java.util.ArrayList;

import com.casestudy.retailbank.bean.WithdrawPOJO;
import com.casestudy.retailbank.dao.WithdrawDao;

public class AccountServiceWithdraw {
	static  WithdrawDao wDao = new WithdrawDao(); 
	
	public static ArrayList<WithdrawPOJO> withdrawStatus(int accId,int custId,String accType,double balance) {
		return wDao.getWithdrawStatus(accId,custId,accType,balance);
	}
}
