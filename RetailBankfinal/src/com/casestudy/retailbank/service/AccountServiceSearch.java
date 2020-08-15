package com.casestudy.retailbank.service;

import java.util.ArrayList;

import com.casestudy.retailbank.bean.AccountSearchPOJO;
import com.casestudy.retailbank.dao.AccountSearchDao;

public class AccountServiceSearch {
	
	static AccountSearchDao sdao = new AccountSearchDao();
	
	public static ArrayList<AccountSearchPOJO> searchAccount(int id,String type) {
		return sdao.searchAccount(id,type);
	}
}
