package com.casestudy.retailbank.service;

import com.casestudy.retailbank.dao.LoginDAO;

public class LoginService {
	
	public boolean validateLogin(String username, String password)
	{
		boolean isValid = LoginDAO.validateLogin(username, password);
		return isValid;
	}
}
