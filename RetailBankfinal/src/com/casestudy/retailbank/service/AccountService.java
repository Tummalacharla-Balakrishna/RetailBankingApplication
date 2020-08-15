package com.casestudy.retailbank.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.casestudy.retailbank.bean.AccountPOJO;
import com.casestudy.retailbank.bean.StatusPOJO;
import com.casestudy.retailbank.dao.AccountDao;

public class AccountService {

	AccountDao aDao = new AccountDao();
	
	
	//Search Account by Customer ID
	public List<AccountPOJO> searchAccountByCID(int cust_id) {

		List<AccountPOJO> account = aDao.searchAccountByCID(cust_id);
		return account;
	}
	
	//Search Account by Account ID
	public AccountPOJO searchAccountByAID(int acc_id) {
		AccountPOJO account = aDao.searchAccountByAID(acc_id);
		return account;
	}
	
	//Create Account Method
	public boolean createAccount(AccountPOJO account) throws SQLException, ClassNotFoundException {
		System.out.println("inside service");
		return aDao.createAccount(account);
	}
	
	//Get Account IDs Method
	public ArrayList<Integer> getAllAccountId() throws SQLException, ClassNotFoundException {
		return aDao.getAllAccountId();
	}

	//Delete Account Method
	public boolean deleteAccount(int accountId, String accountType) throws SQLException, ClassNotFoundException {
		return aDao.deleteAccount(accountId, accountType);
	}

	//Search ACCOUNT TYPE by Account ID
	public String searchAccountTypeByAID(int acc_id) throws SQLException, ClassNotFoundException {

		return aDao.searchAccountTypeByAID(acc_id);
	}

	//View Status of all Accounts
	public List<StatusPOJO> ViewAllAccountStatus() {
		List<StatusPOJO> acc_status_arr = aDao.ViewAllAccountStatus();
		return acc_status_arr;
	}
}
