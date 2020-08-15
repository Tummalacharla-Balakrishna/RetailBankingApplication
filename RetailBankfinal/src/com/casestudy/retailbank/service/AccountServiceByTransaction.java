package com.casestudy.retailbank.service;

import com.casestudy.retailbank.dao.TransactionDao;

import java.util.ArrayList;

import com.casestudy.retailbank.bean.CustomerTransactions;


public class AccountServiceByTransaction {
	static TransactionDao tDao = new TransactionDao();
	
	public static ArrayList<CustomerTransactions> getTransactionDetails(int accId,int count) {
		return tDao.getTransactionList(accId,count);
	}
	public static ArrayList<CustomerTransactions> getTransactionDetails(int accId) {
		return tDao.getTransactionList(accId);
	}
	public static ArrayList<CustomerTransactions> getTransactionDetailsByDate(int accId,String startDate,String endDate){
		return tDao.getTransactionListByDate(accId, startDate, endDate);
	}
}
