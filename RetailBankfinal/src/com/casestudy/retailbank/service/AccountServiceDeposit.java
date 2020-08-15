package com.casestudy.retailbank.service;

import java.util.ArrayList;

import com.casestudy.retailbank.bean.DepositPOJO;
import com.casestudy.retailbank.dao.DepositDao;

public class AccountServiceDeposit {
	static  DepositDao dDao = new DepositDao();
	public static ArrayList<DepositPOJO> depositStatus(int accId,int custId,String accType,double balance) {
		return dDao.getDepositStatus(accId,custId,accType,balance);
	}
}
